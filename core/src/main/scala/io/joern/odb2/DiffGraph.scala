package io.joern.odb2

import io.joern.odb2.Edge.Direction
import io.joern.odb2.Edge.Direction.{Incoming, Outgoing}

import scala.collection.{Iterator, mutable}

trait RawUpdate

/*Todo: All the edge representations for updates have the property field. It makes sense to use subclasses with and
   without edge property, in order to save some memory. The resulting dynamic dispatch should be cheap -- at most bimorphic,
   which doesn't prevent inlining, and well-predicted since edge properties are so rarely used.*/
class AddEdgeUnprocessed(val src: DNodeOrNode, val dst: DNodeOrNode, val edgeKind: Short, val property: Any) extends RawUpdate

class AddUnsafeHalfEdge(val src: DNodeOrNode, val dst: DNodeOrNode, val edgeKind: Short, val inout: Byte, val property: Any)
    extends RawUpdate

class RemoveEdge(val edge: Edge)                         extends RawUpdate
class SetEdgeProperty(val edge: Edge, val property: Any) extends RawUpdate

class DelNode(val node: GNode) extends RawUpdate

class SetNodeProperty(val node: GNode, val propertyKind: Int, val property: Any) extends RawUpdate

class DiffGraphBuilder {
  var buffer = mutable.ArrayDeque[RawUpdate]()

  def addNode(newNode: DNode): this.type = {
    this.buffer.append(newNode)
    this
  }

  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, edgeKind.toShort, property))
    this
  }

  def setEdgeProperty(edge: Edge, property: Any): this.type = {
    this.buffer.append(new SetEdgeProperty(edge, property))
    this
  }

  def setNodeProperty(node: GNode, propertyKind: Int, property: Any): this.type = {
    this.buffer.append(new SetNodeProperty(node, propertyKind, property))
    this
  }
  def removeEdge(edge: Edge): this.type = {
    this.buffer.append(new RemoveEdge(edge))
    this
  }

  def removeNode(node: GNode): this.type = {
    this.buffer.append(new DelNode(node))
    this
  }

  def unsafeAddHalfEdgeForward(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShort, 1, property))
    this
  }

  def unsafeAddHalfEdgeBackward(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShort, 0, property))
    this
  }

  def size: Int = buffer.size

  def absorb(right: DiffGraphBuilder): Unit = {
    if (this.buffer.size >= right.buffer.size) {
      this.buffer.appendAll(right.buffer)
      right.buffer = null
    } else {
      val tmp = right.buffer
      tmp.prependAll(this.buffer)
      this.buffer = tmp
      right.buffer = null
    }
  }
}

/*Internal representations of half-edges. These are always normalized to represent either src <- dst or src -> dst. */
class AddEdgeProcessed(val src: GNode, val dst: GNode, val edgeKind: Short, val property: Any)
class EdgeRepr(val src: GNode, val dst: GNode, val edgeKind: Short, val subSeq: Int, val property: Any)

object DiffGraphApplier {
  def applyDiff(g: Graph, diff: DiffGraphBuilder): Unit = {
    new DiffGraphApplier(g, diff).applyUpdate()
    diff.buffer = null
  }
}

private[odb2] class SetPropertyDesc(val node: GNode, val start: Int, val end: Int) {
  def length: Int = end - start
}

/** The class that is responsible for applying diffgraphs. This is not supposed to be public API, users should stick to applyDiff
  */
class DiffGraphApplier(graph: Graph, diff: DiffGraphBuilder) {
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](graph.schema.getNumberOfNodeKinds)
  // newEdges and delEdges are oversized, in order to permit usage of the same indexing function
  val newEdges          = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](graph._neighbors.size)
  val delEdges          = new Array[mutable.ArrayBuffer[EdgeRepr]](graph._neighbors.size)
  val setEdgeProperties = new Array[mutable.ArrayBuffer[EdgeRepr]](graph._neighbors.size)
  val deferred          = new mutable.ArrayDeque[DNode]()
  val delNodes          = mutable.ArrayBuffer[GNode]()
  val setNodeProperties = new Array[mutable.ArrayBuffer[Any]](graph._properties.size)

  object NewNodeInterface extends BatchedUpdateInterface {
    override def emplaceProperty(node: DNode, propertyKind: Int, propertyValues: IterableOnce[Any]): Unit = {
      val iter = propertyValues.iterator
      if (iter.hasNext) {
        emplaceSetProperty(node.storedRef.get, propertyKind, iter)
      }
    }
  }

  def emplaceSetProperty(node: GNode, propertyKind: Int, propertyValues: Iterator[Any]): Unit = {
    val iter = propertyValues.iterator
    val pos  = graph.schema.propertyOffsetArrayIndex(node.nodeKind, propertyKind)
    if (setNodeProperties(pos) == null) setNodeProperties(pos) = mutable.ArrayBuffer.empty
    val buf   = setNodeProperties(pos)
    val start = buf.size
    for (item <- iter) {
      item match {
        case dnode: DNode => buf.addOne(getGNode(dnode))
        case other        => buf.addOne(other)
      }
    }
    val bound = new SetPropertyDesc(node, start, buf.size)
    emplace(setNodeProperties, bound, pos + 1)
  }

  private def emplace[T](a: Array[mutable.ArrayBuffer[T]], item: T, pos: Int): Unit = {
    if (a(pos) == null) a(pos) = mutable.ArrayBuffer.empty[T]
    a(pos).append(item)
  }

  def drainDeferred(): Unit = {
    while (deferred.nonEmpty) {
      deferred.removeHead().flattenProperties(NewNodeInterface)
    }
  }

  def getGNode(node: DNodeOrNode): GNode = {
    node match {
      case already: GNode =>
        assert(already.graph eq graph)
        already
      case detached: DNode =>
        detached.storedRef match {
          case Some(already: GNode) =>
            assert(already.graph eq graph)
            already
          case None =>
            val nodekind = detached.nodeKind
            val seqId    = graph._nodes(nodekind).size + Option(newNodes(nodekind)).map { _.size }.getOrElse(0)
            val res      = graph.schema.makeNode(graph, nodekind, seqId)
            detached.storedRef = Some(res)
            emplace(newNodes, detached, nodekind)
            deferred.append(detached)
            res
        }
    }
  }

  def splitUpdate(): Unit = {

    for (item <- diff.buffer) item match {
      case delNode: DelNode if !AccessHelpers.isDeleted(delNode.node) =>
        AccessHelpers.markDeleted(delNode.node)
        delNodes.append(delNode.node)
      case _ =>
    }

    for (item <- diff.buffer) {
      item match {
        case addNode: DNode =>
          getGNode(addNode)
        case halfEdge: AddUnsafeHalfEdge =>
          val src = getGNode(halfEdge.src)
          val dst = getGNode(halfEdge.dst)
          if (!AccessHelpers.isDeleted(src) && !AccessHelpers.isDeleted(dst)) {
            Direction.fromOrdinal(halfEdge.inout) match {
              case Direction.Incoming =>
                emplace(
                  newEdges,
                  new AddEdgeProcessed(dst, src, halfEdge.edgeKind, halfEdge.property),
                  graph.schema.neighborOffsetArrayIndex(dst.nodeKind, Incoming, halfEdge.edgeKind)
                )
              case Direction.Outgoing =>
                emplace(
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
            emplace(
              newEdges,
              new AddEdgeProcessed(src, dst, newEdge.edgeKind, newEdge.property),
              graph.schema.neighborOffsetArrayIndex(src.nodeKind, Outgoing, newEdge.edgeKind)
            )
            emplace(
              newEdges,
              new AddEdgeProcessed(dst, src, newEdge.edgeKind, newEdge.property),
              graph.schema.neighborOffsetArrayIndex(dst.nodeKind, Incoming, newEdge.edgeKind)
            )
          } else {
            // TODO maybe throw exception
          }
        case setEdgeProperty: SetEdgeProperty
            if !AccessHelpers.isDeleted(setEdgeProperty.edge.src) && !AccessHelpers.isDeleted(setEdgeProperty.edge.dst) =>
          val (outR, inR) = normalizeRepresentation(setEdgeProperty.edge)
          emplace(
            setEdgeProperties,
            new EdgeRepr(outR.src, outR.dst, outR.edgeKind, outR.subSeq, setEdgeProperty.property),
            graph.schema.neighborOffsetArrayIndex(outR.src.nodeKind, Outgoing, outR.edgeKind)
          )
          emplace(
            setEdgeProperties,
            new EdgeRepr(inR.src, inR.dst, inR.edgeKind, inR.subSeq, setEdgeProperty.property),
            graph.schema.neighborOffsetArrayIndex(inR.src.nodeKind, Incoming, inR.edgeKind)
          )
        case edgeDeletion: RemoveEdge
            if !AccessHelpers.isDeleted(edgeDeletion.edge.src) && !AccessHelpers.isDeleted(edgeDeletion.edge.dst) =>
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
          emplace(delEdges, outR, graph.schema.neighborOffsetArrayIndex(outR.src.nodeKind, Outgoing, outR.edgeKind))
          emplace(delEdges, inR, graph.schema.neighborOffsetArrayIndex(inR.src.nodeKind, Incoming, inR.edgeKind))

        case setNodeProperty: SetNodeProperty if !AccessHelpers.isDeleted(setNodeProperty.node) =>
          val iter = setNodeProperty.property match {
            case null                  => Iterator.empty
            case iterable: Iterable[_] => iterable.iterator
            case a: Array[_]           => a.iterator
            case item                  => Iterator.single(item)
          }
          emplaceSetProperty(setNodeProperty.node, setNodeProperty.propertyKind, iter)
        case delNode: DelNode =>
          // already processed
          assert(AccessHelpers.isDeleted(delNode.node))
      }
      drainDeferred()
    }
  }

  def applyUpdate(): Unit = {
    splitUpdate()
    // order: 1. remove edges, 2. add nodes, 3. delete nodes, 4. add edges
    for {
      nodeKind  <- Range(0, graph.schema.getNumberOfNodeKinds)
      edgeKind  <- Range(0, graph.schema.getNumberOfEdgeKinds)
      direction <- Edge.Direction.values
    } setEdgeProperty(nodeKind, direction, edgeKind)

    for {
      nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds)
      edgeKind <- Range(0, graph.schema.getNumberOfEdgeKinds)
      direction <- Edge.Direction.values
    } deleteEdges(nodeKind, direction, edgeKind)

    for (nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds)) addNodes(nodeKind)

    if (delNodes.nonEmpty) {
      deleteNodes()
    }

    for {
      nodeKind  <- Range(0, graph.schema.getNumberOfNodeKinds)
      edgeKind  <- Range(0, graph.schema.getNumberOfEdgeKinds)
      direction <- Direction.values
    } addEdges(nodeKind, direction, edgeKind)

    for {
      nodeKind     <- Range(0, graph.schema.getNumberOfNodeKinds)
      propertyKind <- Range(0, graph.schema.getNumberOfProperties)
    } setNodeProperties(nodeKind, propertyKind)

  }

  def deleteNodes(): Unit = {
    val replacements = new Array[AnyRef](graph._neighbors.length)

    def getReplacementLengths(nodeKind: Int, direction: Direction, edgeKind: Int): Array[Int] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos) != null) replacements(pos).asInstanceOf[Array[Int]]
      else {
        val res = graph._neighbors(pos).asInstanceOf[Array[Int]].clone()
        ranToLen(res)
        replacements(pos) = res
        res
      }
    }

    def getReplacementNeighbors(nodeKind: Int, direction: Direction, edgeKind: Int): Array[GNode] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos + 1) != null) replacements(pos + 1).asInstanceOf[Array[GNode]]
      else {
        val res = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]].clone()
        replacements(pos + 1) = res
        res
      }
    }

    // remove properties
    for {
      propertyKind <- Range(0, graph.schema.getNumberOfProperties)
      deletedNode  <- delNodes
    } {
      val pos = graph.schema.propertyOffsetArrayIndex(deletedNode.nodeKind, propertyKind)
      graph._inverseIndices.set(pos, null)
      graph._properties(pos) match {
        case null =>
        case oldQty: Array[Int] =>
          if (get(oldQty, deletedNode.seq() + 1) - get(oldQty, deletedNode.seq()) > 0)
            emplaceSetProperty(deletedNode, propertyKind, Iterator.empty)
        case _ =>
      }
    }

    // delete incident edges
    for {
      edgeKind    <- Range(0, graph.schema.getNumberOfEdgeKinds) // this part can run in parallel
      direction   <- Direction.values
      deletedNode <- delNodes
    } {
      val pos          = graph.schema.neighborOffsetArrayIndex(deletedNode.nodeKind, direction, edgeKind)
      val oldQty       = graph._neighbors(pos).asInstanceOf[Array[Int]]
      val oldNeighbors = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]
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

              // TODO double check and rewrite the logic for this, it's currently a pure refactor from the old logic-entangled-arithmetic in https://github.com/ShiftLeftSecurity/overflowdbv2/blob/0d3abe7/core/src/main/scala/io/joern/odb2/DiffGraph.scala#L353
              val newDirection = Direction.fromOrdinal(1 - direction.encoding)
              getReplacementLengths(neighbor.nodeKind, newDirection, edgeKind)(neighbor.seq) -= 1
            }
          }
        }
      }
    }
    // Now replacements is filled with the modifications.
    for {
      nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds)
      edgeKind <- Range(0, graph.schema.getNumberOfEdgeKinds)
      direction    <- Direction.values
    } {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (replacements(pos) != null) {
        val newQty = replacements(pos).asInstanceOf[Array[Int]]
        lenToRan(newQty)
        val newNeighbors = new Array[GNode](get(newQty, graph._nodes(nodeKind).length))
        val modNeighbors =
          (if (replacements(pos + 1) != null) replacements(pos + 1) else graph._neighbors(pos + 1))
            .asInstanceOf[Array[GNode]]
        val oldProperty = graph._neighbors(pos + 2) match {
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
        assert(idxOut == newNeighbors.length)
        graph._neighbors(pos) = newQty
        graph._neighbors(pos + 1) = newNeighbors
        graph._neighbors(pos + 2) = newProperty match {
          case null  => graph._neighbors(pos + 2)
          case other => other
        }
      }
    }
  }

  /** returns (out-edge, in-edge) pair */
  def normalizeRepresentation(edge: Edge): (EdgeRepr, EdgeRepr) = {
    val kind = edge.edgeKind
    assert(edge.subSeq != 0, "edge.subSeq must not be 0")
    if (edge.subSeq > 0) {
      val count    = Accessors.getEdgesOut(edge.src, kind).iterator.take(edge.subSeq).count(_.dst == edge.dst)
      val reversed = Accessors.getEdgesIn(edge.dst, kind).iterator.filter(_.src == edge.src).drop(count - 1).next()
      assert(reversed.src == edge.src && reversed.dst == edge.dst && reversed.property == edge.property && reversed.subSeq < 0, "something went wrong when calculating reversed edge")
      (
        new EdgeRepr(edge.src, edge.dst, kind, edge.subSeq, edge.property),
        new EdgeRepr(edge.dst, edge.src, kind, -reversed.subSeq, edge.property)
      )
    } else {
      val count    = Accessors.getEdgesIn(edge.dst, kind).iterator.take(-edge.subSeq).count(_.src == edge.src)
      val reversed = Accessors.getEdgesOut(edge.src, kind).iterator.filter(_.dst == edge.dst).drop(count - 1).next()
      assert(reversed.src == edge.src && reversed.dst == edge.dst && reversed.property == edge.property && reversed.subSeq > 0, "something went wrong when calculating reversed edge")
      (
        new EdgeRepr(edge.src, edge.dst, kind, reversed.subSeq, edge.property),
        new EdgeRepr(edge.dst, edge.src, kind, -edge.subSeq, edge.property)
      )
    }
  }

  /** in-place turns offset-encoded qty into length-encoded qty */
  def ranToLen(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr(0) == 0)
      for (idx <- Range(0, arr.length - 1)) {
        arr(idx) = arr(idx + 1) - arr(idx)
      }
    }
    arr(arr.length - 1) = 0
  }

  /** in-place turns length-encoded qty into offset-encoded qty */
  def lenToRan(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr.last == 0)
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

  def addNodes(nodeKind: Int): Unit = {
    if (newNodes(nodeKind) == null || newNodes(nodeKind).isEmpty) {
      return
    }
    graph._nodes(nodeKind) = graph
      ._nodes(nodeKind)
      .appendedAll(newNodes(nodeKind).iterator.map {
        _.storedRef.get
      })
    graph.nnodes(nodeKind) += newNodes(nodeKind).size
  }

  def setEdgeProperty(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    if (setEdgeProperties(pos) == null) return
    val size   = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]].size
    val oldQty = graph._neighbors(pos).asInstanceOf[Array[Int]]
    val edgeProp = graph._neighbors(pos + 2) match {
      case _: DefaultValue => graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, size)
      case other           => other
    }
    val propview = mutable.ArraySeq.make(edgeProp.asInstanceOf[Array[_]]).asInstanceOf[mutable.ArraySeq[Any]]
    // this will fail if the edge doesn't support properties. todo: better error message
    val default = graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, 1)(0)
    for (edgeRepr <- setEdgeProperties(pos)) {
      val index = oldQty(edgeRepr.src.seq()) + edgeRepr.subSeq - 1
      propview(index) = if (edgeRepr.property == DefaultValue) default else edgeRepr.property
    }
    graph._neighbors(pos + 2) = edgeProp

  }

  def deleteEdges(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos       = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    val deletions = delEdges(pos)
    if (deletions == null) return
    assert(deletions.forall { edge =>
      edge.edgeKind == edgeKind && edge.src.nodeKind == nodeKind && edge.subSeq > 0
    })
    deletions.sortInPlaceBy { edge =>
      ((edge.src.seq.toLong << 32) + edge.subSeq.toLong)
    }
    dedupBy(deletions, (e: EdgeRepr) => ((e.src.seq.toLong << 32) + e.subSeq.toLong))
    val nnodes       = graph._nodes(nodeKind).size
    val oldQty       = graph._neighbors(pos).asInstanceOf[Array[Int]]
    val oldNeighbors = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]

    val newQty       = new Array[Int](nnodes + 1)
    val newNeighbors = new Array[GNode](get(oldQty, nnodes) - deletions.length)

    val oldProperty = graph._neighbors(pos + 2) match {
      case _: DefaultValue => null
      case other           => other
    }
    val newProperty =
      if (oldProperty != null) graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, newNeighbors.size)
      else null

    var deletionCounter = 0
    var copyStartSeq    = 0
    while (copyStartSeq < nnodes) {
      val deletionSeq = if (deletionCounter < deletions.size) deletions(deletionCounter).src.seq else nnodes
      // we first copy unaffected neighbors
      val copyStartIndex        = get(oldQty, copyStartSeq)
      val deletionSeqIndexStart = get(oldQty, deletionSeq)
      val deletionSeqIndexEnd   = get(oldQty, deletionSeq + 1)
      System.arraycopy(oldNeighbors, copyStartIndex, newNeighbors, copyStartIndex - deletionCounter, deletionSeqIndexStart - copyStartIndex)
      if (oldProperty != null)
        System.arraycopy(oldProperty, copyStartIndex, newProperty, copyStartIndex - deletionCounter, deletionSeqIndexStart - copyStartIndex)

      for (idx <- Range(copyStartSeq, deletionSeq + 1)) newQty(idx) = get(oldQty, idx) - deletionCounter
      copyStartSeq = deletionSeq + 1
      // we now copy over the non-deleted edges of the critical deletionSeq
      if (deletionCounter < deletions.size) {
        var deletion = deletions(deletionCounter)
        var idx      = 0
        while (idx < deletionSeqIndexEnd - deletionSeqIndexStart) {
          if (deletion != null && idx == deletion.subSeq - 1) {
            deletionCounter += 1
            assert(deletion.dst == oldNeighbors(deletionSeqIndexStart + idx))
            deletion = if (deletionCounter < deletions.size) deletions(deletionCounter) else null
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
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newNeighbors
    graph._neighbors(pos + 2) = newProperty match {
      case null  => graph._neighbors(pos + 2)
      case other => other
    }
  }

  def addEdges(nodeKind: Int, direction: Direction, edgeKind: Int): Unit = {
    val pos        = graph.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    val insertions = newEdges(pos)
    if (insertions == null) {
      return
    }

    insertions.sortInPlaceBy {
      _.src.seq
    }

    assert(insertions.nonEmpty)
    assert(insertions.forall(edge => edge.src.nodeKind == nodeKind && edge.edgeKind == edgeKind))

    val nnodes       = graph._nodes(nodeKind).size
    val oldQty       = Option(graph._neighbors(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldNeighbors = Option(graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
    val newQty       = new Array[Int](nnodes + 1)
    val newNeighbors = new Array[GNode](get(oldQty, nnodes) + insertions.size)

    val hasNewProp = insertions.exists(_.property != DefaultValue)
    val oldProperty = graph._neighbors(pos + 2) match {
      case _: DefaultValue => null
      case other           => other
    }
    val newProperty =
      if (hasNewProp || oldProperty != null) graph.schema.allocateEdgeProperty(nodeKind, direction, edgeKind, newNeighbors.size) else null
    val newPropertyView = mutable.ArraySeq.make(newProperty).asInstanceOf[mutable.ArraySeq[Any]]

    var insertionCounter = 0
    var copyStartSeq     = 0
    while (copyStartSeq < nnodes) {
      val insertionSeq = if (insertionCounter < insertions.size) insertions(insertionCounter).src.seq else nnodes - 1

      val copyStartIdx = get(oldQty, copyStartSeq)
      val insertionIdx = get(oldQty, insertionSeq + 1)

      // copy from  copyStartSeq -> insertionSeq inclusive
      System.arraycopy(oldNeighbors, copyStartIdx, newNeighbors, copyStartIdx + insertionCounter, insertionIdx - copyStartIdx)
      if (oldProperty != null)
        System.arraycopy(oldProperty, copyStartIdx, newProperty, copyStartIdx + insertionCounter, insertionIdx - copyStartIdx)
      for (idx <- Range(copyStartSeq, insertionSeq + 2)) newQty(idx) = get(oldQty, idx) + insertionCounter
      // insert
      val insertionBaseIndex = newQty(insertionSeq + 1) - insertionCounter
      while (insertionCounter < insertions.size && insertions(insertionCounter).src.seq == insertionSeq) {
        val insertion = insertions(insertionCounter)
        newNeighbors(insertionBaseIndex + insertionCounter) = insertion.dst
        if (newPropertyView != null && insertion.property != DefaultValue)
          newPropertyView(insertionBaseIndex + insertionCounter) = insertion.property
        insertionCounter += 1
      }
      newQty(insertionSeq + 1) = insertionBaseIndex + insertionCounter
      copyStartSeq = insertionSeq + 1
    }
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newNeighbors
    graph._neighbors(pos + 2) = newProperty match {
      case null  => graph._neighbors(pos + 2)
      case other => other
    }
  }

  def setNodeProperties(nodeKind: Int, propertyKind: Int): Unit = {
    val pos         = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val propertyBuf = setNodeProperties(pos)
    if (propertyBuf != null) {
      val setPropertyPositions = setNodeProperties(pos + 1).asInstanceOf[mutable.ArrayBuffer[SetPropertyDesc]]
      graph._inverseIndices.set(pos, null)
      setPropertyPositions.sortInPlaceBy(_.node.seq())
      dedupBy(setPropertyPositions, (setProp: SetPropertyDesc) => setProp.node.seq())
      val nnodes = graph._nodes(nodeKind).size

      val setPropertyValues = graph.schema.allocateNodeProperty(nodeKind, propertyKind, propertyBuf.size)
      copyToArray(propertyBuf, setPropertyValues)

      val oldQty = Option(graph._properties(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
      val oldProperty =
        Option(graph._properties(pos + 1)).getOrElse(graph.schema.allocateNodeProperty(nodeKind, propertyKind, 0)).asInstanceOf[Array[_]]

      val newQty      = new Array[Int](nnodes + 1)
      val newProperty = graph.schema.allocateNodeProperty(nodeKind, propertyKind, get(oldQty, nnodes) + propertyBuf.size)

      val insertionIter = setPropertyPositions.iterator
      var copyStartSeq  = 0
      var outIndex      = 0
      while (copyStartSeq < nnodes) {
        val insertion      = insertionIter.nextOption()
        val insertionSeq   = insertion.map(_.node.seq()).getOrElse(nnodes)
        val copyStartIndex = get(oldQty, copyStartSeq)
        val copyEndIndex   = get(oldQty, insertionSeq)
        val offset         = outIndex - copyStartIndex
        System.arraycopy(oldProperty, copyStartIndex, newProperty, outIndex, copyEndIndex - copyStartIndex)
        outIndex += copyEndIndex - copyStartIndex
        assert(newQty(copyStartSeq) == get(oldQty, copyStartSeq) + offset)
        for (idx <- Range(copyStartSeq + 1, insertionSeq + 1)) newQty(idx) = get(oldQty, idx) + offset

        if (insertion.isDefined) {
          System.arraycopy(setPropertyValues, insertion.get.start, newProperty, outIndex, insertion.get.length)
          outIndex += insertion.get.length
          newQty(insertionSeq + 1) = outIndex
        }
        copyStartSeq = insertionSeq + 1
      }
      newQty(nnodes) = outIndex

      graph._properties(pos) = newQty
      // fixme: need to support graphs with unknown schema. Then we need to homogenize the array here.
      graph._properties(pos + 1) = newProperty
    }
  }

  private def copyToArray[T](buf: mutable.ArrayBuffer[Any], dst: Array[T]): Unit = {
    // this is a dirty hack in order to make scala type system shut up
    buf.asInstanceOf[mutable.ArrayBuffer[T]].copyToArray(dst)
  }

  private def get(a: Array[Int], idx: Int): Int = if (idx < a.length) a(idx) else a.last

  /** Removes in place all subsequent duplicate items, with the last overwriting the previous ones. */
  private def dedupBy[T, S](buff: mutable.ArrayBuffer[T], by: T => S): Unit = {
    var outIdx = 0
    var idx    = 0
    while (idx < buff.length - 1) {
      if (by(buff(idx)) == by(buff(idx + 1))) {
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
}
