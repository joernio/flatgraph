package flatgraph

import DiffGraphBuilder.*
import flatgraph.Edge.Direction
import flatgraph.Edge.Direction.{Incoming, Outgoing}
import flatgraph.misc.{Misc, SchemaViolationReporter}

import java.util.concurrent
import scala.collection.{Iterator, mutable}

object DiffGraphApplier {

  /** Apply a diff to a graph. This returns the number of successfully applied changes.
    *
    * Since this applies all changes that are reachable from the DiffGraphBuilder, the number of applied changes can be vastly larger than
    * the size of the diffgraphBuilder, e.g. if there are newNodes that have properties / contained nodes that are themselves newNodes.
    *
    * This function destroys the diff, in order to permit fast freeing of memory (in cases where we run close to exhausting the heap with
    * the diff, the old graph, the new graph, and the temporaries during diff application).
    */
  def applyDiff(
    graph: Graph,
    diff: DiffGraphBuilder,
    schemaViolationReporter: SchemaViolationReporter = new SchemaViolationReporter,
    requestedExecutor: Option[concurrent.ExecutorService] = None
  ): Int = {
    if (graph.isClosed) throw new GraphClosedException(s"graph cannot be modified any longer since it's closed")
    new DiffGraphApplier(graph, diff, schemaViolationReporter, requestedExecutor).applyUpdate()
  }

  /** java friendly api without the defaults */
  def applyDiff(graph: Graph, diff: DiffGraphBuilder): Int =
    applyDiff(graph, diff, new SchemaViolationReporter, None)
}

abstract class NewNodePropertyInsertionHelper {
  def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[DNode], dst: AnyRef, idxs: Array[Int]): Unit = {}
}

/** The class that is responsible for applying diffgraphs. This is not supposed to be public API, users should stick to applyDiff
  */
private[flatgraph] class DiffGraphApplier(
  graph: Graph,
  diff: DiffGraphBuilder,
  schemaViolationReporter: SchemaViolationReporter,
  requestedExecutor: Option[concurrent.ExecutorService] = None
) {
  val executor = Misc.maybeOverrideExecutor(requestedExecutor)
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](graph.schema.getNumberOfNodeKinds)
  // newEdges and delEdges are oversized, in order to permit usage of the same indexing function
  val newEdges             = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](graph.neighbors.size)
  val delEdges             = new Array[mutable.ArrayBuffer[EdgeRepr]](graph.neighbors.size)
  val setEdgeProperties    = new Array[mutable.ArrayBuffer[EdgeRepr]](graph.neighbors.size)
  val deferred             = new mutable.ArrayDeque[DNode]()
  val delNodes             = new mutable.ArrayBuffer[GNode]()
  val setNodeProperties    = new Array[mutable.ArrayBuffer[Any]](graph.properties.size)
  val newNodeNewProperties = new Array[Int](graph.properties.size)
  val newNodeUsers         = new concurrent.atomic.AtomicIntegerArray(graph.schema.getNumberOfNodeKinds)
  val jobQueue             = mutable.ArrayBuffer[concurrent.Future[Unit]]()

  object NewNodeInterface extends BatchedUpdateInterface {
    override def visitContainedNode(contained: DNodeOrNode): Unit = { if (contained != null) getGNode(contained) }

    override def countProperty(node: DNode, propertyKind: Int, num: Int): Unit = {
      val pos = graph.schema.propertyOffsetArrayIndex(node.nodeKind, propertyKind)
      newNodeNewProperties(pos) += num
    }
  }

  def submitJob[T](block: => Unit): Unit = {
    jobQueue.addOne(executor.submit(() => block))
  }

  private def insertProperty0(node: GNode, propertyKind: Int, propertyValues: Iterator[Any]): Unit = {
    val pos = graph.schema.propertyOffsetArrayIndex(node.nodeKind, propertyKind)
    if (0 > pos || pos >= setNodeProperties.length) {
      schemaViolationReporter.illegalNodeProperty(node.nodeKind, propertyKind, graph.schema)
    } else {
      if (setNodeProperties(pos) == null)
        setNodeProperties(pos) = mutable.ArrayBuffer.empty
      val buf   = setNodeProperties(pos)
      val start = buf.size
      propertyValues.iterator.foreach {
        case dnode: DNode => buf.addOne(getGNode(dnode))
        case other        => buf.addOne(other)
      }
      val bound = new SetPropertyDesc(node, start, buf.size)
      insert(setNodeProperties, bound, pos + 1)
    }
  }

  private def insert[T](a: Array[mutable.ArrayBuffer[T]], item: T, pos: Int): Unit = {
    if (a(pos) == null)
      a(pos) = mutable.ArrayBuffer.empty[T]

    a(pos).append(item)
  }

  private def drainDeferred(): Int = {
    var ndiff = 0
    while (deferred.nonEmpty) {
      ndiff += 1
      deferred.removeHead().countAndVisitProperties(NewNodeInterface)
    }
    ndiff
  }

  private def getGNode(node: DNodeOrNode): GNode = {
    node match {
      case already: GNode =>
        assert(already.graph == graph, "expected a different graph instance")
        already
      case detached: DNode =>
        detached.storedRef match {
          case Some(already: GNode) =>
            assert(already.graph == graph, "expected a different graph instance")
            already
          case None =>
            val nodeKind = detached.nodeKind
            graph.schema.verifyNodeKindIsValid(nodeKind)

            val seqId = graph.nodeCountByKind(nodeKind) + Option(newNodes(nodeKind)).map { _.size }.getOrElse(0)
            val res   = graph.schema.makeNode(graph, nodeKind, seqId)
            detached.storedRef = Some(res)
            insert(newNodes, detached, nodeKind)
            deferred.append(detached)
            res
        }
    }
  }

  private def splitUpdate(): Int = {
    var ndiff = 0
    diff.buffer.foreach {
      case delNode: DelNode if !AccessHelpers.isDeleted(delNode.node) =>
        ndiff += 1
        AccessHelpers.markDeleted(delNode.node)
        delNodes.append(delNode.node)

      case _ =>
    }

    diff.buffer.foreach { item =>
      item match {
        case addNode: DNode =>
          getGNode(addNode)
        case halfEdge: AddUnsafeHalfEdge =>
          val src = getGNode(halfEdge.src)
          val dst = getGNode(halfEdge.dst)
          if (!AccessHelpers.isDeleted(src) && !AccessHelpers.isDeleted(dst)) {
            ndiff += 1
            Direction.fromOrdinal(halfEdge.inout) match {
              case Direction.Incoming =>
                insert(
                  newEdges,
                  new AddEdgeProcessed(dst, src, halfEdge.edgeKind, halfEdge.property),
                  graph.schema.neighborOffsetArrayIndex(dst.nodeKind, Incoming, halfEdge.edgeKind)
                )
              case Direction.Outgoing =>
                insert(
                  newEdges,
                  new AddEdgeProcessed(src, dst, halfEdge.edgeKind, halfEdge.property),
                  graph.schema.neighborOffsetArrayIndex(src.nodeKind, Outgoing, halfEdge.edgeKind)
                )
            }
          }
        case newEdge: AddEdgeUnprocessed =>
          val src = getGNode(newEdge.src)
          val dst = getGNode(newEdge.dst)
          if (!AccessHelpers.isDeleted(src) && !AccessHelpers.isDeleted(dst)) {
            ndiff += 1
            insert(
              newEdges,
              new AddEdgeProcessed(src, dst, newEdge.edgeKind, newEdge.property),
              graph.schema.neighborOffsetArrayIndex(src.nodeKind, Outgoing, newEdge.edgeKind)
            )
            insert(
              newEdges,
              new AddEdgeProcessed(dst, src, newEdge.edgeKind, newEdge.property),
              graph.schema.neighborOffsetArrayIndex(dst.nodeKind, Incoming, newEdge.edgeKind)
            )
          } else {
            // TODO maybe throw exception
          }
        case setEdgeProperty: SetEdgeProperty
            if !AccessHelpers.isDeleted(setEdgeProperty.edge.src) && !AccessHelpers.isDeleted(setEdgeProperty.edge.dst) =>
          ndiff += 1
          val (outR, inR) = normalizeRepresentation(setEdgeProperty.edge)
          insert(
            setEdgeProperties,
            new EdgeRepr(outR.src, outR.dst, outR.edgeKind, outR.subSeq, setEdgeProperty.property),
            graph.schema.neighborOffsetArrayIndex(outR.src.nodeKind, Outgoing, outR.edgeKind)
          )
          insert(
            setEdgeProperties,
            new EdgeRepr(inR.src, inR.dst, inR.edgeKind, inR.subSeq, setEdgeProperty.property),
            graph.schema.neighborOffsetArrayIndex(inR.src.nodeKind, Incoming, inR.edgeKind)
          )
        case edgeDeletion: RemoveEdge
            if !AccessHelpers.isDeleted(edgeDeletion.edge.src) && !AccessHelpers.isDeleted(edgeDeletion.edge.dst) =>
          ndiff += 1

          /** This is the delEdge case. It is massively annoying.
            *
            * In order to support edge properties, we need to grab the right edge from e.src->e.dst. If we assume that our graph was built
            * normally, i.e. edges were sequentially/batched added without the unsafe unidirectional edges, then our graph has the following
            * invariant: The kth edge connecting A->B corresponds to the kth edge connecting B<-A This sucks big time, because edge removal
            * is potentially O(N**2). The degenerate behavior occurs when we have ~k edges of the same type starting in src = X or ending in
            * the same dst = X. Each deletion then costs us ~k, and if we delete all ~k edges we pay ~ k*k.
            *
            * But k~N is possible where N is the graph size!
            */
          val (outR, inR) = normalizeRepresentation(edgeDeletion.edge)
          insert(delEdges, outR, graph.schema.neighborOffsetArrayIndex(outR.src.nodeKind, Outgoing, outR.edgeKind))
          insert(delEdges, inR, graph.schema.neighborOffsetArrayIndex(inR.src.nodeKind, Incoming, inR.edgeKind))

        case setNodeProperty: SetNodeProperty if !AccessHelpers.isDeleted(setNodeProperty.node) =>
          ndiff += 1
          val iter = setNodeProperty.property match {
            case null                  => Iterator.empty
            case iterable: Iterable[_] => iterable.iterator
            case a: Array[_]           => a.iterator
            case item                  => Iterator.single(item)
          }
          insertProperty0(setNodeProperty.node, setNodeProperty.propertyKind, iter)
        case delNode: DelNode =>
          // already processed
          assert(AccessHelpers.isDeleted(delNode.node), s"node should have been deleted already but wasn't: ${delNode.node}")
      }
      // We need to drain the deferred nodes after each single processed update. We cannot wait until we processed all nodes,
      // because that would break the following invariant:
      //     if you have two diffgraphs with no node deletions, and you apply them separately, you get the same result
      //     as if when you merge the updates and then apply them together
      // The breakage of the invariant would be pretty mild -- the only thing that gets messed up is the order of nodes.
      ndiff += drainDeferred()
    }
    ndiff
  }

  private[flatgraph] def applyUpdate(): Int = {
    graph.hasChangedSinceOpen = true
    val ndiff = splitUpdate()
    diff.buffer = null

    try {
      // set edge properties
      for {
        nodeKind  <- graph.schema.nodeKinds
        edgeKind  <- graph.schema.edgeKinds
        direction <- Edge.Direction.values
      } setEdgeProperty(nodeKind, direction, edgeKind)

      jobQueue.foreach(_.get())
      jobQueue.clear()

      // remove edges
      for {
        nodeKind  <- graph.schema.nodeKinds
        edgeKind  <- graph.schema.edgeKinds
        direction <- Edge.Direction.values
      } deleteEdges(nodeKind, direction, edgeKind)

      jobQueue.foreach(_.get())
      jobQueue.clear()

      // add nodes. If necessary, we can start this job earlier in a separate queue; then we must add some extra structures for node sizes at various stages
      for { nodeKind <- graph.schema.nodeKinds } addNodes(nodeKind)

      jobQueue.foreach(_.get())
      jobQueue.clear()

      // delete nodes
      // this is harder to parallelize, only do if needed!
      if (delNodes.nonEmpty) {
        deleteNodes()
      }

      // add edges
      for {
        nodeKind  <- graph.schema.nodeKinds
        edgeKind  <- graph.schema.edgeKinds
        direction <- Direction.values
      } addEdges(nodeKind, direction, edgeKind)

      // set node properties. This doesn't need to wait for add edges to be complete!
      for (nodeKind <- graph.schema.nodeKinds) {
        for { propertyKind <- graph.schema.propertyKinds } setNodeProperties(nodeKind, propertyKind)
        if (newNodeUsers.decrementAndGet(nodeKind) == -1) {
          // whoever reaches newNodeUsers(nodeKind) == -1 first is permitted to free it.
          newNodes(nodeKind) = null
        }
      }

      jobQueue.foreach(_.get())
      jobQueue.clear()
    } catch {
      case ex: java.util.concurrent.ExecutionException =>
        // the whole parallelization / executor stuff wraps exceptions
        // we unwrap them again, in order to not break tests for e.g. SchemaViolationException
        throw ex.getCause()
    }
    ndiff
  }

  private def deleteNodes(): Unit = {
    for (del <- delNodes) {
      graph.livingNodeCountByKind(del.nodeKind) -= 1
    }
    val replacements = new Array[AnyRef](graph.neighbors.length)

    def getReplacementLengths(nodeKind: Int, direction: Direction, edgeKind: Int): Array[Int] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos) != null) replacements(pos).asInstanceOf[Array[Int]]
      else {
        val res = graph.neighbors(pos).asInstanceOf[Array[Int]].clone()
        ranToLen(res)
        replacements(pos) = res
        res
      }
    }

    def getReplacementNeighbors(nodeKind: Int, direction: Direction, edgeKind: Int): Array[GNode] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos + 1) != null) replacements(pos + 1).asInstanceOf[Array[GNode]]
      else {
        val res = graph.neighbors(pos + 1).asInstanceOf[Array[GNode]].clone()
        replacements(pos + 1) = res
        res
      }
    }

    // remove properties
    for {
      propertyKind <- graph.schema.propertyKinds
      deletedNode  <- delNodes
    } {
      val pos = graph.schema.propertyOffsetArrayIndex(deletedNode.nodeKind, propertyKind)
      graph.inverseIndices.set(pos, null)
      graph.properties(pos) match {
        case null =>
        case oldQty: Array[Int] =>
          if (get(oldQty, deletedNode.seq() + 1) - get(oldQty, deletedNode.seq()) > 0)
            insertProperty0(deletedNode, propertyKind, Iterator.empty)
        case _ =>
      }
    }

    // delete incident edges
    for {
      edgeKind    <- graph.schema.edgeKinds // this part can run in parallel
      direction   <- Direction.values
      deletedNode <- delNodes
    } {
      val pos          = graph.schema.neighborOffsetArrayIndex(deletedNode.nodeKind, direction, edgeKind)
      val oldQty       = graph.neighbors(pos).asInstanceOf[Array[Int]]
      val oldNeighbors = graph.neighbors(pos + 1).asInstanceOf[Array[GNode]]
      if (oldQty != null) {
        val delStartIndex = get(oldQty, deletedNode.seq)
        val delEndIndex   = get(oldQty, deletedNode.seq + 1)
        if (delEndIndex - delStartIndex > 0) {
          // there is something to delete.
          val modQty = getReplacementLengths(deletedNode.nodeKind, direction, edgeKind)
          val modVal = getReplacementNeighbors(deletedNode.nodeKind, direction, edgeKind)
          modQty(deletedNode.seq) = 0
          for (idx <- Range(delStartIndex, delEndIndex)) {
            modVal(idx) = deletedNode // we replace the neighbor with a tombstone, conveniently deletedNode itself
            val neighbor = oldNeighbors(idx)
            if (!AccessHelpers.isDeleted(neighbor)) {
              // the backwards edge is already a tombstone (it points to deletedNode). So we only need to adjust the length.
              // in order to avoid double-adjusting, we only do this if the neighbor itself is not deleted.

              // TODO double check and rewrite the logic for this, it's currently a pure refactor from the old logic-entangled-arithmetic in https://github.com/ShiftLeftSecurity/overflowdbv2/blob/0d3abe7/core/src/main/scala/flatgraph/DiffGraph.scala#L353
              val newDirection = Direction.fromOrdinal(1 - direction.encoding)
              getReplacementLengths(neighbor.nodeKind, newDirection, edgeKind)(neighbor.seq) -= 1
            }
          }
        }
      }
    }
    // Now replacements is filled with the modifications.
    for {
      nodeKind  <- graph.schema.nodeKinds
      edgeKind  <- graph.schema.edgeKinds
      direction <- Direction.values
    } {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos) != null) {
        val newQty = replacements(pos).asInstanceOf[Array[Int]]
        lenToRan(newQty)
        val newNeighbors = new Array[GNode](get(newQty, graph.nodeCountByKind(nodeKind)))
        val modNeighbors =
          (if (replacements(pos + 1) != null) replacements(pos + 1) else graph.neighbors(pos + 1))
            .asInstanceOf[Array[GNode]]
        val oldProperty = graph.neighbors(pos + 2) match {
          case _: DefaultValue => null
          case other           => other
        }
        val newProperty =
          if (oldProperty != null) graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, newNeighbors.length) else null
        var idx    = 0
        var idxOut = 0
        while (idx < modNeighbors.length) {
          if (!AccessHelpers.isDeleted(modNeighbors(idx))) {
            newNeighbors(idxOut) = modNeighbors(idx)
            // we really hope that JVM moves these branches out of the loop! Otherwise we're screwed.
            // todo: check that the JIT is clever enough
            if (oldProperty != null) System.arraycopy(oldProperty, idx, newProperty, idxOut, 1)
            idxOut += 1
          }
          idx += 1
        }
        assert(idxOut == newNeighbors.length, s"idxOut was expected to be ${newNeighbors.length}, but instead is $idxOut")
        graph.neighbors(pos) = newQty
        graph.neighbors(pos + 1) = newNeighbors
        graph.neighbors(pos + 2) = newProperty match {
          case null  => graph.neighbors(pos + 2)
          case other => other
        }
      }
    }
  }

  /** returns (out-edge, in-edge) pair */
  private def normalizeRepresentation(edge: Edge): (EdgeRepr, EdgeRepr) = {
    val kind = edge.edgeKind
    assert(edge.subSeq != 0, "edge.subSeq must not be 0")
    if (edge.subSeq > 0) {
      val count    = Accessors.getEdgesOut(edge.src, kind).iterator.take(edge.subSeq).count(_.dst == edge.dst)
      val reversed = Accessors.getEdgesIn(edge.dst, kind).iterator.filter(_.src == edge.src).drop(count - 1).next()
      assert(
        reversed.src == edge.src && reversed.dst == edge.dst && reversed.property == edge.property && reversed.subSeq < 0,
        "something went wrong when calculating reversed edge"
      )
      (
        new EdgeRepr(edge.src, edge.dst, kind, edge.subSeq, edge.property),
        new EdgeRepr(edge.dst, edge.src, kind, -reversed.subSeq, edge.property)
      )
    } else {
      val count    = Accessors.getEdgesIn(edge.dst, kind).iterator.take(-edge.subSeq).count(_.src == edge.src)
      val reversed = Accessors.getEdgesOut(edge.src, kind).iterator.filter(_.dst == edge.dst).drop(count - 1).next()
      assert(
        reversed.src == edge.src && reversed.dst == edge.dst && reversed.property == edge.property && reversed.subSeq > 0,
        "something went wrong when calculating reversed edge"
      )
      (
        new EdgeRepr(edge.src, edge.dst, kind, reversed.subSeq, edge.property),
        new EdgeRepr(edge.dst, edge.src, kind, -edge.subSeq, edge.property)
      )
    }
  }

  /** in-place turns offset-encoded qty into length-encoded qty */
  private def ranToLen(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr(0) == 0, s"first element in array was expected to be `0`, but instead is `${arr(0)}`")
      for (idx <- Range(0, arr.length - 1)) {
        arr(idx) = arr(idx + 1) - arr(idx)
      }
    }
    arr(arr.length - 1) = 0
  }

  /** in-place turns length-encoded qty into offset-encoded qty */
  private def lenToRan(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr.last == 0, s"last element in array was expected to be `0`, but instead is `${arr.last}`")
      var count = 0
      var idx   = 0
      while (idx < arr.length) {
        val tmp = arr(idx)
        arr(idx) = count
        count += tmp
        idx += 1
      }
    }
  }

  private def addNodes(nodeKind: Int): Unit = {
    if (newNodes(nodeKind) == null || newNodes(nodeKind).isEmpty) {
      return
    }
    submitJob {
      graph.nodesArray(nodeKind) = graph.nodesArray(nodeKind).appendedAll(newNodes(nodeKind).iterator.map(_.storedRef.get))
      graph.livingNodeCountByKind(nodeKind) += newNodes(nodeKind).size
    }
  }

  private def setEdgeProperty(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    if (setEdgeProperties(pos) == null) return
    submitJob {
      val size   = graph.neighbors(pos + 1).asInstanceOf[Array[GNode]].size
      val oldQty = graph.neighbors(pos).asInstanceOf[Array[Int]]
      val edgeProp = graph.neighbors(pos + 2) match {
        case _: DefaultValue =>
          graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, size)
        case other =>
          other
        // ^ change this once we switch away from full copy-on-write, see e.g.
        // https://github.com/joernio/flatgraph/pull/163#discussion_r1537246314
      }
      val propview = mutable.ArraySeq.make(edgeProp.asInstanceOf[Array[?]]).asInstanceOf[mutable.ArraySeq[Any]]
      // this will fail if the edge doesn't support properties. todo: better error message
      val default = graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind = edgeKind, size = 1)(0)
      for (edgeRepr <- setEdgeProperties(pos)) {
        val index = oldQty(edgeRepr.src.seq()) + edgeRepr.subSeq - 1
        propview(index) = if (edgeRepr.property == DefaultValue) default else edgeRepr.property
      }
      graph.neighbors(pos + 2) = edgeProp
      setEdgeProperties(pos) == null
    }
  }

  private def deleteEdges(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    if (delEdges(pos) == null) return
    submitJob {
      val deletions = delEdges(pos)
      assert(
        deletions.forall { edge =>
          edge.edgeKind == edgeKind && edge.src.nodeKind == nodeKind && edge.subSeq > 0
        },
        s"something went wrong when deleting edges - values for debugging: edgeKind=$edgeKind; nodeKind=$nodeKind"
      )

      deletions.sortInPlaceBy(numberForEdgeComparison)
      dedupBy(deletions, numberForEdgeComparison)
      val nodeCount    = graph.nodeCountByKind(nodeKind)
      val oldQty       = graph.neighbors(pos).asInstanceOf[Array[Int]]
      val oldNeighbors = graph.neighbors(pos + 1).asInstanceOf[Array[GNode]]

      val newQty       = new Array[Int](nodeCount + 1)
      val newNeighbors = new Array[GNode](get(oldQty, nodeCount) - deletions.length)

      val oldProperty = graph.neighbors(pos + 2) match {
        case _: DefaultValue => null
        case other           => other
      }
      val newProperty =
        if (oldProperty != null) graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, newNeighbors.size)
        else null

      var deletionCounter = 0
      var copyStartSeq    = 0
      while (copyStartSeq < nodeCount) {
        val deletionSeq = if (deletionCounter < deletions.size) deletions(deletionCounter).src.seq else nodeCount
        // we first copy unaffected neighbors
        val copyStartIndex        = get(oldQty, copyStartSeq)
        val deletionSeqIndexStart = get(oldQty, deletionSeq)
        val deletionSeqIndexEnd   = get(oldQty, deletionSeq + 1)
        System.arraycopy(
          oldNeighbors,
          copyStartIndex,
          newNeighbors,
          copyStartIndex - deletionCounter,
          deletionSeqIndexStart - copyStartIndex
        )
        if (oldProperty != null)
          System.arraycopy(
            oldProperty,
            copyStartIndex,
            newProperty,
            copyStartIndex - deletionCounter,
            deletionSeqIndexStart - copyStartIndex
          )

        for (idx <- Range(copyStartSeq, deletionSeq + 1))
          newQty(idx) = get(oldQty, idx) - deletionCounter

        copyStartSeq = deletionSeq + 1
        // we now copy over the non-deleted edges of the critical deletionSeq
        if (deletionCounter < deletions.size) {
          var deletion = deletions(deletionCounter)
          var idx      = 0
          while (idx < deletionSeqIndexEnd - deletionSeqIndexStart) {
            if (deletion != null && idx == deletion.subSeq - 1) {
              assert(
                deletion.dst == oldNeighbors(deletionSeqIndexStart + idx),
                s"deletion.dst was supposed to be `${oldNeighbors(deletionSeqIndexStart + idx)}`, but instead is ${deletion.dst}"
              )
              deletionCounter += 1
              deletion = if (deletionCounter < deletions.size) deletions(deletionCounter) else null
              if (deletion != null && deletion.src.seq() != deletionSeq) deletion = null
            } else {
              newNeighbors(deletionSeqIndexStart + idx - deletionCounter) = oldNeighbors(deletionSeqIndexStart + idx)
              if (oldProperty != null)
                System.arraycopy(oldProperty, deletionSeqIndexStart + idx, newProperty, deletionSeqIndexStart + idx - deletionCounter, 1)
            }
            idx += 1
          }
          newQty(deletionSeq + 1) = deletionSeqIndexStart + idx - deletionCounter
        }
      }
      graph.neighbors(pos) = newQty
      graph.neighbors(pos + 1) = newNeighbors
      graph.neighbors(pos + 2) = newProperty match {
        case null  => graph.neighbors(pos + 2)
        case other => other
      }
      delEdges(pos) = null
    }
  }

  private def addEdges(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    if (newEdges(pos) == null) {
      return
    }
    submitJob {
      val insertions = newEdges(pos)

      insertions.sortInPlaceBy(_.src.seq)

      assert(insertions.nonEmpty, "insertions must be nonEmpty")
      assert(
        insertions.forall(edge => edge.src.nodeKind == nodeKind && edge.edgeKind == edgeKind),
        s"something went wrong while adding edges - values for debugging: nodeKind=$nodeKind; edgeKind=$edgeKind"
      )

      val nodeCount    = graph.nodesArray(nodeKind).length
      val oldQty       = Option(graph.neighbors(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
      val oldNeighbors = Option(graph.neighbors(pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
      val newQty       = new Array[Int](nodeCount + 1)
      val newNeighbors = new Array[GNode](get(oldQty, nodeCount) + insertions.size)

      val hasNewProp = insertions.exists(_.property != DefaultValue)
      val oldProperty = graph.neighbors(pos + 2) match {
        case _: DefaultValue => null
        case other           => other
      }
      val newProperty =
        if (hasNewProp || oldProperty != null) graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, newNeighbors.size) else null
      val newPropertyView = mutable.ArraySeq.make(newProperty).asInstanceOf[mutable.ArraySeq[Any]]

      var insertionCounter = 0
      var copyStartSeq     = 0
      while (copyStartSeq < nodeCount) {
        val insertionSeq = if (insertionCounter < insertions.size) insertions(insertionCounter).src.seq else nodeCount - 1

        val copyStartIdx = get(oldQty, copyStartSeq)
        val insertionIdx = get(oldQty, insertionSeq + 1)

        // copy from  copyStartSeq -> insertionSeq inclusive
        System.arraycopy(oldNeighbors, copyStartIdx, newNeighbors, copyStartIdx + insertionCounter, insertionIdx - copyStartIdx)
        if (oldProperty != null)
          System.arraycopy(oldProperty, copyStartIdx, newProperty, copyStartIdx + insertionCounter, insertionIdx - copyStartIdx)
        for (idx <- Range(copyStartSeq, insertionSeq + 2))
          newQty(idx) = get(oldQty, idx) + insertionCounter

        // insert
        val insertionBaseIndex = newQty(insertionSeq + 1) - insertionCounter
        while (insertionCounter < insertions.size && insertions(insertionCounter).src.seq == insertionSeq) {
          val insertion = insertions(insertionCounter)
          newNeighbors(insertionBaseIndex + insertionCounter) = insertion.dst
          if (newPropertyView != null && insertion.property != DefaultValue) {
            try {
              newPropertyView(insertionBaseIndex + insertionCounter) = insertion.property
            } catch {
              case _: ArrayStoreException | _: ClassCastException =>
                val edgeType = graph.schema.getEdgeLabel(nodeKind, edgeKind)
                throw new UnsupportedOperationException(
                  s"unsupported property type `${insertion.property.getClass}` for edge type `$edgeType`"
                )
            }
          }
          insertionCounter += 1
        }
        newQty(insertionSeq + 1) = insertionBaseIndex + insertionCounter
        copyStartSeq = insertionSeq + 1
      }
      graph.neighbors(pos) = newQty
      graph.neighbors(pos + 1) = newNeighbors
      graph.neighbors(pos + 2) = newProperty match {
        case null  => graph.neighbors(pos + 2)
        case other => other
      }
      newEdges(pos) = null
    }
  }

  private def setNodeProperties(nodeKind: Int, propertyKind: Int): Unit = {
    val schema     = graph.schema
    val pos        = schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val viaNewNode = newNodeNewProperties(pos)
    if (setNodeProperties(pos) == null && viaNewNode == 0) return
    newNodeUsers.incrementAndGet(nodeKind)

    submitJob {
      val propertyBuf = Option(setNodeProperties(pos)).getOrElse(mutable.ArrayBuffer.empty)
      val setPropertyPositions =
        Option(setNodeProperties(pos + 1)).getOrElse(mutable.ArrayBuffer.empty).asInstanceOf[mutable.ArrayBuffer[SetPropertyDesc]]
      graph.inverseIndices.set(pos, null)
      setPropertyPositions.sortInPlaceBy(_.node.seq())
      dedupBy(setPropertyPositions, (setProp: SetPropertyDesc) => setProp.node.seq())
      val oldQty = Option(graph.properties(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
      val lengthDelta = setPropertyPositions.iterator.map { setP =>
        setP.length - (get(oldQty, setP.node.seq()) - get(oldQty, setP.node.seq() + 1))
      }.sum
      val nodeCount = graph.nodesArray(nodeKind).length

      val setPropertyValues = schema.getNodePropertyFormalType(nodeKind, propertyKind).allocate(propertyBuf.size)
      if (setPropertyValues == null) {
        schemaViolationReporter.illegalNodeProperty(nodeKind, propertyKind, schema)
      } else {
        copyToArray(propertyBuf, setPropertyValues)

        val oldProperty = Option(graph.properties(pos + 1))
          .getOrElse(schema.getNodePropertyFormalType(nodeKind, propertyKind).allocate(0))
          .asInstanceOf[Array[?]]
        if (oldProperty == null) schemaViolationReporter.illegalNodeProperty(nodeKind, propertyKind, schema)

        val newQty = new Array[Int](nodeCount + 1)
        val newProperty =
          schema.getNodePropertyFormalType(nodeKind, propertyKind).allocate(get(oldQty, nodeCount) + lengthDelta + viaNewNode)

        val insertionIter = setPropertyPositions.iterator
        var copyStartSeq  = 0
        var outIndex      = 0
        while (copyStartSeq < nodeCount) {
          val insertion      = insertionIter.nextOption()
          val insertionSeq   = insertion.map(_.node.seq()).getOrElse(nodeCount)
          val copyStartIndex = get(oldQty, copyStartSeq)
          val copyEndIndex   = get(oldQty, insertionSeq)
          val offset         = outIndex - copyStartIndex
          System.arraycopy(oldProperty, copyStartIndex, newProperty, outIndex, copyEndIndex - copyStartIndex)
          outIndex += copyEndIndex - copyStartIndex
          assert(
            newQty(copyStartSeq) == get(oldQty, copyStartSeq) + offset,
            s"something went wrong while copying properties: newQty(copyStartSeq) was supposed to be ${get(oldQty, copyStartSeq) + offset} but instead was ${newQty(copyStartSeq)}"
          )
          for (idx <- Range(copyStartSeq + 1, insertionSeq + 1))
            newQty(idx) = get(oldQty, idx) + offset

          insertion.foreach { insertion =>
            System.arraycopy(setPropertyValues, insertion.start, newProperty, outIndex, insertion.length)
            outIndex += insertion.length
            newQty(insertionSeq + 1) = outIndex
          }
          copyStartSeq = insertionSeq + 1
        }
        newQty(nodeCount) = outIndex
        // now need to write the newproperties
        if (viaNewNode > 0) {
          val inserter = schema.getNewNodePropertyInserter(nodeKind, propertyKind)
          inserter.insertNewNodeProperties(newNodes(nodeKind), newProperty, newQty)
        }

        graph.properties(pos) = newQty
        // fixme: need to support graphs with unknown schema. Then we need to homogenize the array here.
        graph.properties(pos + 1) = newProperty
        setNodeProperties(pos) = null
        setNodeProperties(pos + 1) = null
        if (newNodeUsers.decrementAndGet(nodeKind) == -1) {
          // whoever reaches newNodeUsers(nodeKind) == -1 first is permitted to free it.
          newNodes(nodeKind) = null
        }

      }
    }
  }

  private def copyToArray[T](buf: mutable.ArrayBuffer[Any], dst: Array[T]): Unit = {
    try {
      // this is a dirty hack in order to make scala type system shut up
      buf.asInstanceOf[mutable.ArrayBuffer[T]].copyToArray(dst)
    } catch {
      case store: ArrayStoreException =>
        val typeMaybe = buf.headOption.map(property => s": ${property.getClass}").getOrElse("")
        throw new UnsupportedOperationException(
          s"unsupported property type$typeMaybe on ${Option(dst).map { _.getClass.toString }.orNull}",
          store
        )
    }
  }

  private def get(a: Array[Int], idx: Int): Int = if (idx < a.length) a(idx) else a.last

  /** Removes in place all subsequent duplicate items, with the last overwriting the previous ones. */
  private def dedupBy[T, S](buff: mutable.ArrayBuffer[T], by: T => S): Unit = {
    var outIdx = 0
    var idx    = 0
    while (idx < buff.length) {
      if (idx < buff.length - 1 && by(buff(idx)) == by(buff(idx + 1))) {
        buff(outIdx) = buff(idx)
        idx += 1
      } else {
        if (outIdx != idx) buff(outIdx) = buff(idx)
        idx += 1
        outIdx += 1
      }
    }
    buff.dropRightInPlace(idx - outIdx)
  }

  /** Creates a bitstring/integeger for fast comparison where
    *   - the most significicant bits are defined by edge.src.seq
    *   - the least significicant bits are defined by edge.subSeq
    *
    * So that we can quickly sort by edge.src.seq, and where those have multiple results, sort by edge.subSeq
    */
  private def numberForEdgeComparison(edge: EdgeRepr): Long = {
    (edge.src.seq.toLong << 32) + edge.subSeq.toLong
  }
}

/* Internal representations of half-edges. These are always normalized to represent either src <- dst or src -> dst. */
private[flatgraph] class AddEdgeProcessed(val src: GNode, val dst: GNode, val edgeKind: Int, val property: Any)

private[flatgraph] class EdgeRepr(val src: GNode, val dst: GNode, val edgeKind: Int, val subSeq: Int, val property: Any)

private[flatgraph] class SetPropertyDesc(val node: GNode, val start: Int, val end: Int) {
  def length: Int = end - start
}
