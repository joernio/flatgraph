package io.joern.odb2
import scala.collection.mutable

trait RawUpdate
class AddEdgeUnprocessed(val src: DNodeOrNode,
                         val dst: DNodeOrNode,
                         val eid: Short,
                         val unsafeUnidirectional: Boolean = false)
    extends RawUpdate

class DiffGraphBuilder {
  var buffer = mutable.ArrayDeque[RawUpdate]()

  def addNode(newNode: DNode): this.type = { this.buffer.append(newNode); this }

  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, eid: Short): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, eid)); this
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

class AddEdgeProcessed(val src: GNode, val dst: GNode, val eid: Short)
class DelNode(val node: GNode) extends RawUpdate

object DiffGraphApplier {
  def applyDiff(g: Graph, diff: DiffGraphBuilder): Unit = {
    new DiffGraphApplier(g, diff).applyUpdate()
    diff.buffer = null
  }
}

/**The class that is responsible for applying diffgraphs. This is not supposed to be public API, users should stick to applyDiff*/
class DiffGraphApplier(graph: Graph, diff: DiffGraphBuilder) {
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](graph.schema.getNNodeKinds)
  //newEdges and delEdges are oversized, in order to permit usage of the same indexing function
  val newEdges = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](graph._neighbors.size)
  val delEdges = new Array[mutable.ArrayBuffer[Edge]](graph._neighbors.size)
  val deferred = new mutable.ArrayDeque[DNode]()
  val delNodes = mutable.ArrayBuffer[GNode]()

  private def emplace[T](a: Array[mutable.ArrayBuffer[T]], item: T, pos: Int): Unit = {
    if (a(pos) == null) a(pos) = mutable.ArrayBuffer[T]()
    a(pos).append(item)
  }

  def drainDeferred(): Unit = {
    //todo: Here we will need to add contained nodes
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
            val nodekind = detached.kindId
            val seqId = graph._nodes(nodekind).size + Option(newNodes(nodekind)).map { _.size }.getOrElse(0)
            val res = graph.schema.makeNode(graph, nodekind, seqId)
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
            emplace(newEdges,
                    new AddEdgeProcessed(src, dst, newEdge.eid),
                    graph.schema.indexEdge(src.kindId, 1, newEdge.eid))
            if (!newEdge.unsafeUnidirectional)
              emplace(newEdges,
                      new AddEdgeProcessed(dst, src, newEdge.eid),
                      graph.schema.indexEdge(dst.kindId, 0, newEdge.eid))
          }
        case edgeDeletion: Edge
            if !AccessHelpers.isDeleted(edgeDeletion.src) && !AccessHelpers.isDeleted(edgeDeletion.dst) =>
          /**This is the delEdge case. It is massively annoying.
            *
            * In order to support edge properties, we need to grab the right edge from e.src->e.dst.
            * If we assume that our graph was built normally, i.e. edges were sequentially/batched added without the unsafe
            * unidirectional edges, then our graph has the following invariant:
            *   The kth edge connecting A->B corresponds to the kth edge connecting B<-A
            * This sucks big time, because edge removal is potentially O(N**2).
            * The degenerate behavior occurs when we have ~k edges of the same type starting in src = X or ending in the same
            * dst = X. Each deletion then costs us ~k, and if we delete all ~k edges we pay ~ k*k.
            *
            * But k~N is possible where N is the graph size!
            *  */
          if (edgeDeletion.subSeq > 0) {
            //the edge is forward, i.e. pulled from getEdgesOut
            emplace(delEdges, edgeDeletion, graph.schema.indexEdge(edgeDeletion.src.kindId, 1, edgeDeletion.eid))
            val outNeighbors = Accessors.getNeighborsOut(edgeDeletion.src, edgeDeletion.eid)
            var count = 0
            assert(outNeighbors(edgeDeletion.subSeq - 1) == edgeDeletion.dst)
            for (idx <- Range(0, edgeDeletion.subSeq) if outNeighbors(idx) == edgeDeletion.dst) count += 1
            val inNeighbors = Accessors.getNeighborsIn(edgeDeletion.dst, edgeDeletion.eid)
            var idx = 0
            while (count > 0) {
              if (inNeighbors(idx) == edgeDeletion.src) { count -= 1 }
              idx += 1
            }
            emplace(delEdges,
                    new Edge(edgeDeletion.dst, edgeDeletion.src, edgeDeletion.eid, idx),
                    graph.schema.indexEdge(edgeDeletion.dst.kindId, 0, edgeDeletion.eid))
          } else if (edgeDeletion.subSeq < 0) {
            //the edge is backwards, i.e. pulled from getEdgesIn
            emplace(
              delEdges,
              new Edge(edgeDeletion.dst, edgeDeletion.src, edgeDeletion.eid, -edgeDeletion.subSeq),
              graph.schema.indexEdge(edgeDeletion.dst.kindId, 0, edgeDeletion.eid)
            )
            val inNeighbors = Accessors.getNeighborsIn(edgeDeletion.dst, edgeDeletion.eid)
            var count = 0
            assert(inNeighbors(-edgeDeletion.subSeq - 1) == edgeDeletion.src)
            for (idx <- Range(0, -edgeDeletion.subSeq) if inNeighbors(idx) == edgeDeletion.src) count += 1
            val outNeighbors = Accessors.getNeighborsOut(edgeDeletion.src, edgeDeletion.eid)
            var idx = 0
            while (count > 0) {
              if (outNeighbors(idx) == edgeDeletion.dst) count -= 1
              idx += 1
            }
            emplace(delEdges,
                    new Edge(edgeDeletion.src, edgeDeletion.dst, edgeDeletion.eid, idx),
                    graph.schema.indexEdge(edgeDeletion.src.kindId, 1, edgeDeletion.eid))
          } else assert(false)
        case delNode: DelNode =>
          //already processed
          assert(AccessHelpers.isDeleted(delNode.node))
      }
      drainDeferred()
    }
  }

  def applyUpdate(): Unit = {
    splitUpdate()
    //order: 1. remove edges, 2. add nodes, 3. delete nodes, 4. add edges
    for (nodekind <- Range(0, graph.schema.getNNodeKinds);
         edgekind <- Range(0, graph.schema.getNEdgeKinds);
         inout <- Range(0, 2)) deleteEdges(nodekind, inout, edgekind)

    for (nodekind <- Range(0, graph.schema.getNNodeKinds)) addNodes(nodekind)

    if (delNodes.nonEmpty) {
      deleteNodes()
    }

    for (nodekind <- Range(0, graph.schema.getNNodeKinds);
         edgekind <- Range(0, graph.schema.getNEdgeKinds);
         inout <- Range(0, 2)) addEdges(nodekind, inout, edgekind)

  }

  def deleteNodes(): Unit = {
    val replacements = new Array[AnyRef](graph._neighbors.length)
    def getReplacementQty(nodekind: Int, inout: Int, edgekind: Int): Array[Int] = {
      val pos = graph.schema.indexEdge(nodekind, inout, edgekind)
      if (replacements(pos) != null) replacements(pos).asInstanceOf[Array[Int]]
      else {
        val res = graph._neighbors(pos).asInstanceOf[Array[Int]].clone()
        ranToLen(res)
        replacements(pos) = res
        res
      }
    }

    def getReplacementNeighbors(nodekind: Int, inout: Int, edgekind: Int): Array[GNode] = {
      val pos = graph.schema.indexEdge(nodekind, inout, edgekind)
      if (replacements(pos + 1) != null) replacements(pos + 1).asInstanceOf[Array[GNode]]
      else {
        val res = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]].clone()
        replacements(pos + 1) = res
        res
      }
    }

    for (deletedNode <- delNodes;
         edgekind <- Range(0, graph.schema.getNEdgeKinds);
         inout <- Range(0, 2)) {
      //this loop is not threadsafe. Don't fiddle with locks. It is possible to handle each edgekind separately, though.
      //alternative alg can be fully multithreaded
      val pos = graph.schema.indexEdge(deletedNode.kindId, inout, edgekind)
      val qtyOld = graph._neighbors(pos).asInstanceOf[Array[Int]]
      val oldVal = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      if (qtyOld != null) {
        val start = get(qtyOld, deletedNode.seqId)
        val end = get(qtyOld, deletedNode.seqId + 1)
        if (end - start > 0) {
          //there is something to delete.
          val modQty = getReplacementQty(deletedNode.kindId, inout, edgekind)
          val modVal = getReplacementNeighbors(deletedNode.kindId, inout, edgekind)
          modQty(deletedNode.seqId) = 0
          for (idx <- Range(start, end)) {
            modVal(idx) = deletedNode // we replace the neighbor with a tombstone, conveniently del itself
            val neighbor = oldVal(idx)
            if (!AccessHelpers.isDeleted(neighbor)) {
              //the backwards edge is already a tombstone (it points to del). So we only need to adjust the length.
              //in order to avoid double-adjusting, we only do this if the neighbor itself is not deleted.
              getReplacementQty(neighbor.kindId, 1 - inout, edgekind)(neighbor.seqId) -= 1
            }
          }
        }
      }
    }
    //Now replacements is filled with the modifications.
    for (nodekind <- Range(0, graph.schema.getNNodeKinds);
         edgekind <- Range(0, graph.schema.getNEdgeKinds);
         inout <- Range(0, 2)) {
      val pos = graph.schema.indexEdge(nodekind, inout, edgekind)
      if (replacements(pos) != null) {
        val newQty = replacements(pos).asInstanceOf[Array[Int]]
        lenToRan(newQty)
        val newVal = new Array[GNode](get(newQty, graph._nodes(nodekind).length))
        val oldVal =
          (if (replacements(pos + 1) != null) replacements(pos + 1) else graph._neighbors(pos + 1))
            .asInstanceOf[Array[GNode]]
        var idx = 0
        var idxOut = 0
        while (idx < oldVal.length) {
          if (!AccessHelpers.isDeleted(oldVal(idx))) {
            newVal(idxOut) = oldVal(idx)
            idxOut += 1
          }
          idx += 1
        }
        assert(idxOut == newVal.length)
        graph._neighbors(pos) = newQty
        graph._neighbors(pos + 1) = newVal
      }
    }
  }

  /**in-place turns offset-encoded qty into length-encoded qty*/
  def ranToLen(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr(0) == 0)
      for (idx <- Range(0, arr.length - 1)) {
        arr(idx) = arr(idx + 1) - arr(idx)
      }
    }
    arr(arr.length - 1) = 0
  }

  /**in-place turns length-encoded qty into offset-encoded qty*/
  def lenToRan(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
      assert(arr.last == 0)
      var count = 0
      var idx = 0
      while (idx < arr.length) {
        val tmp = arr(idx)
        arr(idx) = count
        count += tmp
        idx += 1
      }
    }
  }

  def addNodes(nodekind: Int): Unit = {
    if (newNodes(nodekind) == null || newNodes(nodekind).isEmpty) { return }
    graph._nodes(nodekind) = graph._nodes(nodekind).appendedAll(newNodes(nodekind).iterator.map { _.storedRef.get })
    graph.nnodes(nodekind) += newNodes(nodekind).size
  }

  def deleteEdges(nodekind: Int, inout: Int, edgekind: Int): Unit = {
    val pos = graph.schema.indexEdge(nodekind, inout, edgekind)
    val deletions = delEdges(pos)
    if (deletions == null) return
    assert(deletions.forall { edge =>
      edge.eid == edgekind && edge.src.kindId == nodekind && edge.subSeq > 0
    })
    deletions.sortInPlaceBy { edge =>
      ((edge.src.seqId.toLong << 32) + edge.subSeq.toLong)
    }
    dedupBy(deletions, (e: Edge) => ((e.src.seqId.toLong << 32) + e.subSeq.toLong))
    val nnodes = graph._nodes(nodekind).size
    val oldQty = graph._neighbors(pos).asInstanceOf[Array[Int]]
    val oldVal = graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]

    val newQty = new Array[Int](nnodes + 1)
    val newVal = new Array[GNode](oldVal.length - deletions.length)

    var delPtr = 0
    var nxIdx = 0
    while (nxIdx < nnodes) {
      val seq = if (delPtr < deletions.size) deletions(delPtr).src.seqId else nnodes
      //copy from  nxIdx -> seq exclusive
      System.arraycopy(oldVal,
                       get(oldQty, nxIdx),
                       newVal,
                       get(oldQty, nxIdx) - delPtr,
                       get(oldQty, seq) - get(oldQty, nxIdx))
      for (idx <- Range(nxIdx, seq + 1)) newQty(idx) = get(oldQty, idx) - delPtr
      nxIdx = seq + 1
      //we now copy over the non-deleted edges of the critical seq
      if (delPtr < deletions.size) {
        val start = get(oldQty, seq)
        var nxDel = deletions(delPtr)
        var idx = 0
        while (idx < get(oldQty, seq + 1) - start) {
          if (nxDel != null && idx == nxDel.subSeq - 1) {
            delPtr += 1
            assert(nxDel.dst == oldVal(start + idx))
            nxDel = if (delPtr < deletions.size) deletions(delPtr) else null
          } else {
            newVal(start + idx - delPtr) = oldVal(start + idx)
          }
          idx += 1
        }
        newQty(seq + 1) = start + idx - delPtr
      }
    }
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newVal
  }

  def addEdges(nodekind: Int, inout: Int, edgekind: Int): Unit = {
    val pos = graph.schema.indexEdge(nodekind, inout, edgekind)
    val insertions = newEdges(pos)
    if (insertions == null || insertions.isEmpty) return;
    insertions.sortInPlaceBy { _.src.seqId }
    assert(insertions.forall(edge => edge.src.kindId == nodekind && edge.eid == edgekind))
    val nnodes = graph._nodes(nodekind).size
    val oldQty = Option(graph._neighbors(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldVal = Option(graph._neighbors(pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
    val newQty = new Array[Int](nnodes + 1)
    val newVal = new Array[GNode](oldVal.size + insertions.size)
    var nePtr = 0
    var nxIdx = 0
    while (nxIdx < nnodes) {
      val seq = if (nePtr < insertions.size) insertions(nePtr).src.seqId else nnodes - 1
      //copy from  nxIdx -> seq inclusive
      System.arraycopy(oldVal,
                       get(oldQty, nxIdx),
                       newVal,
                       get(oldQty, nxIdx) + nePtr,
                       get(oldQty, seq + 1) - get(oldQty, nxIdx))
      for (idx <- Range(nxIdx, seq + 2)) newQty(idx) = get(oldQty, idx) + nePtr
      //insert
      while (nePtr < insertions.size && insertions(nePtr).src.seqId == seq) {
        newVal(newQty(seq + 1)) = insertions(nePtr).dst
        newQty(seq + 1) += 1
        nePtr += 1
      }
      nxIdx = seq + 1
    }
    graph._neighbors(pos) = newQty
    graph._neighbors(pos + 1) = newVal
  }

  private def get(a: Array[Int], idx: Int): Int = if (idx < a.length) a(idx) else a.last

  /**Removes in place all subsequent duplicate items, with the last overwriting the previous ones.*/
  private def dedupBy[T, S](buff: mutable.ArrayBuffer[T], by: T => S): Unit = {
    var outIdx = 0
    var idx = 0
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
