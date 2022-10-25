package io.joern.odb2

import scala.collection.mutable

trait RawUpdate

class AddEdgeUnprocessed(
  val src: DNodeOrNode,
  val dst: DNodeOrNode,
  val edgeKind: Short,
  val unsafeUnidirectional: Boolean = false
) extends RawUpdate

class DiffGraphBuilder {
  var buffer = mutable.ArrayDeque[RawUpdate]()

  def addNode(newNode: DNode): this.type = {
    this.buffer.append(newNode); this
  }

  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Short): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, edgeKind));
    this
  }

  def removeEdge(edge: Edge): this.type = {
    this.buffer.append(edge)
    this
  }

  def removeNode(node: GNode): this.type = {
    this.buffer.append(new DelNode(node))
    this
  }

  def addEdgeUnsafeUnidirectional(src: DNodeOrNode, dst: DNodeOrNode, eid: Short): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, eid, true));
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

class AddEdgeProcessed(val src: GNode, val dst: GNode, val edgeKind: Short)

class DelNode(val node: GNode) extends RawUpdate

object DiffGraphApplier {
  def applyDiff(g: Graph, diff: DiffGraphBuilder): Unit = {
    new DiffGraphApplier(g, diff).applyUpdate()
    diff.buffer = null
  }
}

/** The class that is responsible for applying diffgraphs. This is not supposed to be public API, users should stick to
  * applyDiff
  */
class DiffGraphApplier(graph: Graph, diff: DiffGraphBuilder) {
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](graph.schema.getNumberOfNodeKinds)
  // newEdges and delEdges are oversized, in order to permit usage of the same indexing function
  val newEdges = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](graph._neighbors.size)
  val delEdges = new Array[mutable.ArrayBuffer[Edge]](graph._neighbors.size)
  val deferred = new mutable.ArrayDeque[DNode]()
  val delNodes = mutable.ArrayBuffer[GNode]()

  private def emplace[T](a: Array[mutable.ArrayBuffer[T]], item: T, pos: Int): Unit = {
    if (a(pos) == null) a(pos) = mutable.ArrayBuffer.empty[T]
    a(pos).append(item)
  }

  def drainDeferred(): Unit = {
    // todo: Here we will need to add contained nodes
    deferred.clear()
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
        case newEdge: AddEdgeUnprocessed =>
          val src = getGNode(newEdge.src)
          val dst = getGNode(newEdge.dst)
          if (!AccessHelpers.isDeleted(src) && !AccessHelpers.isDeleted(dst)) {
            emplace(
              newEdges,
              new AddEdgeProcessed(src, dst, newEdge.edgeKind),
              graph.schema.neighborOffsetArrayIndex(src.nodeKind, 1, newEdge.edgeKind)
            )
            if (!newEdge.unsafeUnidirectional)
              emplace(
                newEdges,
                new AddEdgeProcessed(dst, src, newEdge.edgeKind),
                graph.schema.neighborOffsetArrayIndex(dst.nodeKind, 0, newEdge.edgeKind)
              )
          } else {
            // TODO throw exception
          }
        case edgeDeletion: Edge
            if !AccessHelpers.isDeleted(edgeDeletion.src) && !AccessHelpers.isDeleted(edgeDeletion.dst) =>
          /** This is the delEdge case. It is massively annoying.
            *
            * In order to support edge properties, we need to grab the right edge from e.src->e.dst. If we assume that
            * our graph was built normally, i.e. edges were sequentially/batched added without the unsafe unidirectional
            * edges, then our graph has the following invariant: The kth edge connecting A->B corresponds to the kth
            * edge connecting B<-A This sucks big time, because edge removal is potentially O(N**2). The degenerate
            * behavior occurs when we have ~k edges of the same type starting in src = X or ending in the same dst = X.
            * Each deletion then costs us ~k, and if we delete all ~k edges we pay ~ k*k.
            *
            * But k~N is possible where N is the graph size!
            */
          if (edgeDeletion.subSeq > 0) {
            // the edge is forward, i.e. pulled from getEdgesOut
            emplace(
              delEdges,
              edgeDeletion,
              graph.schema.neighborOffsetArrayIndex(edgeDeletion.src.nodeKind, 1, edgeDeletion.edgeKind)
            )
            val outNeighbors = Accessors.getNeighborsOut(edgeDeletion.src, edgeDeletion.edgeKind)
            var count        = 0
            assert(outNeighbors(edgeDeletion.subSeq - 1) == edgeDeletion.dst)
            for (idx <- Range(0, edgeDeletion.subSeq) if outNeighbors(idx) == edgeDeletion.dst) count += 1
            val inNeighbors = Accessors.getNeighborsIn(edgeDeletion.dst, edgeDeletion.edgeKind)
            var idx         = 0
            while (count > 0) {
              if (inNeighbors(idx) == edgeDeletion.src) {
                count -= 1
              }
              idx += 1
            }
            emplace(
              delEdges,
              new Edge(edgeDeletion.dst, edgeDeletion.src, edgeDeletion.edgeKind, idx),
              graph.schema.neighborOffsetArrayIndex(edgeDeletion.dst.nodeKind, 0, edgeDeletion.edgeKind)
            )
          } else if (edgeDeletion.subSeq < 0) {
            // the edge is backwards, i.e. pulled from getEdgesIn
            emplace(
              delEdges,
              new Edge(edgeDeletion.dst, edgeDeletion.src, edgeDeletion.edgeKind, -edgeDeletion.subSeq),
              graph.schema.neighborOffsetArrayIndex(edgeDeletion.dst.nodeKind, 0, edgeDeletion.edgeKind)
            )
            val inNeighbors = Accessors.getNeighborsIn(edgeDeletion.dst, edgeDeletion.edgeKind)
            var count       = 0
            assert(inNeighbors(-edgeDeletion.subSeq - 1) == edgeDeletion.src)
            for (idx <- Range(0, -edgeDeletion.subSeq) if inNeighbors(idx) == edgeDeletion.src) count += 1
            val outNeighbors = Accessors.getNeighborsOut(edgeDeletion.src, edgeDeletion.edgeKind)
            var idx          = 0
            while (count > 0) {
              if (outNeighbors(idx) == edgeDeletion.dst) count -= 1
              idx += 1
            }
            emplace(
              delEdges,
              new Edge(edgeDeletion.src, edgeDeletion.dst, edgeDeletion.edgeKind, idx),
              graph.schema.neighborOffsetArrayIndex(edgeDeletion.src.nodeKind, 1, edgeDeletion.edgeKind)
            )
          } else assert(false)
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
    for (
      nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds);
      edgeKind <- Range(0, graph.schema.getNumberOfEdgeKinds);
      inout    <- Range(0, 2)
    ) deleteEdges(nodeKind, inout, edgeKind)

    for (nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds)) addNodes(nodeKind)

    if (delNodes.nonEmpty) {
      deleteNodes()
    }

    for (
      nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds);
      edgeKind <- Range(0, graph.schema.getNumberOfEdgeKinds);
      inout    <- Range(0, 2)
    ) addEdges(nodeKind, inout, edgeKind)

  }

  def deleteNodes(): Unit = {
    val replacements = new Array[AnyRef](graph._neighbors.length)

    def getReplacementLengths(nodeKind: Int, inout: Int, edgeKind: Int): Array[Int] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
      if (replacements(pos) != null) replacements(pos).asInstanceOf[Array[Int]]
      else {
        val res = graph._neighbors(pos).asInstanceOf[Array[Int]].clone()
        ranToLen(res)
        replacements(pos) = res
        res
      }
    }

    def getReplacementNeighbors(nodeKind: Int, inout: Int, edgeKind: Int): Array[GNode] = {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
      if (replacements(pos + 1) != null) replacements(pos + 1).asInstanceOf[Array[GNode]]
      else {
        val res = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]].clone()
        replacements(pos + 1) = res
        res
      }
    }

    for (
      edgeKind    <- Range(0, graph.schema.getNumberOfEdgeKinds); // this part can run in parallel
      inout       <- Range(0, 2);
      deletedNode <- delNodes
    ) {
      val pos          = graph.schema.neighborOffsetArrayIndex(deletedNode.nodeKind, inout, edgeKind)
      val oldQty       = graph._neighbors(pos).asInstanceOf[Array[Int]]
      val oldNeighbors = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      if (oldQty != null) {
        val delStartIndex = get(oldQty, deletedNode.seq)
        val delEndIndex   = get(oldQty, deletedNode.seq + 1)
        if (delEndIndex - delStartIndex > 0) {
          // there is something to delete.
          val modQty = getReplacementLengths(deletedNode.nodeKind, inout, edgeKind)
          val modVal = getReplacementNeighbors(deletedNode.nodeKind, inout, edgeKind)
          modQty(deletedNode.seq) = 0
          for (idx <- Range(delStartIndex, delEndIndex)) {
            modVal(idx) = deletedNode // we replace the neighbor with a tombstone, conveniently deletedNode itself
            val neighbor = oldNeighbors(idx)
            if (!AccessHelpers.isDeleted(neighbor)) {
              // the backwards edge is already a tombstone (it points to deletedNode). So we only need to adjust the length.
              // in order to avoid double-adjusting, we only do this if the neighbor itself is not deleted.
              getReplacementLengths(neighbor.nodeKind, 1 - inout, edgeKind)(neighbor.seq) -= 1
            }
          }
        }
      }
    }
    // Now replacements is filled with the modifications.
    for (
      nodeKind <- Range(0, graph.schema.getNumberOfNodeKinds);
      edgeKind <- Range(0, graph.schema.getNumberOfEdgeKinds);
      inout    <- Range(0, 2)
    ) {
      val pos = graph.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
      if (replacements(pos) != null) {
        val newQty = replacements(pos).asInstanceOf[Array[Int]]
        lenToRan(newQty)
        val newNeighbors = new Array[GNode](get(newQty, graph._nodes(nodeKind).length))
        val modNeighbors =
          (if (replacements(pos + 1) != null) replacements(pos + 1) else graph._neighbors(pos + 1))
            .asInstanceOf[Array[GNode]]
        var idx    = 0
        var idxOut = 0
        while (idx < modNeighbors.length) {
          if (!AccessHelpers.isDeleted(modNeighbors(idx))) {
            newNeighbors(idxOut) = modNeighbors(idx)
            idxOut += 1
          }
          idx += 1
        }
        assert(idxOut == newNeighbors.length)
        graph._neighbors(pos) = newQty
        graph._neighbors(pos + 1) = newNeighbors
      }
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

  def deleteEdges(nodeKind: Int, inout: Int, edgeKind: Int): Unit = {
    val pos       = graph.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
    val deletions = delEdges(pos)
    if (deletions == null) return
    assert(deletions.forall { edge =>
      edge.edgeKind == edgeKind && edge.src.nodeKind == nodeKind && edge.subSeq > 0
    })
    deletions.sortInPlaceBy { edge =>
      ((edge.src.seq.toLong << 32) + edge.subSeq.toLong)
    }
    dedupBy(deletions, (e: Edge) => ((e.src.seq.toLong << 32) + e.subSeq.toLong))
    val nnodes       = graph._nodes(nodeKind).size
    val oldQty       = graph._neighbors(pos).asInstanceOf[Array[Int]]
    val oldNeighbors = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]

    val newQty       = new Array[Int](nnodes + 1)
    val newNeighbors = new Array[GNode](oldNeighbors.length - deletions.length)

    var deletionCounter = 0
    var copyStartSeq    = 0
    while (copyStartSeq < nnodes) {
      val deletionSeq = if (deletionCounter < deletions.size) deletions(deletionCounter).src.seq else nnodes
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
          }
          idx += 1
        }
        newQty(deletionSeq + 1) = deletionSeqIndexStart + idx - deletionCounter
      }
    }
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newNeighbors
  }

  def addEdges(nodeKind: Int, inout: Int, edgeKind: Int): Unit = {
    val pos        = graph.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
    val insertions = newEdges(pos)
    if (insertions == null) {
      return
    }

    insertions.sortInPlaceBy {
      _.src.seq
    }

    assert(insertions.nonEmpty)
    assert(insertions.forall(edge => edge.src.nodeKind == nodeKind && edge.edgeKind == edgeKind))

    val nnodes           = graph._nodes(nodeKind).size
    val oldQty           = Option(graph._neighbors(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldNeighbors     = Option(graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
    val newQty           = new Array[Int](nnodes + 1)
    val newNeighbors     = new Array[GNode](oldNeighbors.size + insertions.size)
    var insertionCounter = 0
    var copyStartSeq     = 0
    while (copyStartSeq < nnodes) {
      val insertionSeq = if (insertionCounter < insertions.size) insertions(insertionCounter).src.seq else nnodes - 1

      val copyStartIdx = get(oldQty, copyStartSeq)
      val insertionIdx = get(oldQty, insertionSeq + 1)

      // copy from  copyStartSeq -> insertionSeq inclusive
      System.arraycopy(
        oldNeighbors,
        copyStartIdx,
        newNeighbors,
        copyStartIdx + insertionCounter,
        insertionIdx - copyStartIdx
      )
      for (idx <- Range(copyStartSeq, insertionSeq + 2)) newQty(idx) = get(oldQty, idx) + insertionCounter
      // insert
      while (insertionCounter < insertions.size && insertions(insertionCounter).src.seq == insertionSeq) {
        newNeighbors(newQty(insertionSeq + 1)) = insertions(insertionCounter).dst
        newQty(insertionSeq + 1) += 1
        insertionCounter += 1
      }
      copyStartSeq = insertionSeq + 1
    }
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newNeighbors
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
