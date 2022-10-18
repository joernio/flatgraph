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

  def addNode(nn: DNode): this.type = { this.buffer.append(nn); this }

  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, eid: Short): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, eid)); this
  }
  def removeEdge(e: Edge): this.type = {
    this.buffer.append(e)
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
class DiffGraphApplier(g: Graph, diff: DiffGraphBuilder) {
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](g.schema.getNNodeKinds)
  //newEdges and delEdges are oversized, in order to permit usage of the same indexing function
  val newEdges = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](g._neighbors.size)
  val delEdges = new Array[mutable.ArrayBuffer[Edge]](g._neighbors.size)
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

  def getGNode(n: DNodeOrNode): GNode = {
    n match {
      case already: GNode =>
        assert(already.graph eq g)
        already
      case dn: DNode =>
        dn.storedRef match {
          case Some(already: GNode) =>
            assert(already.graph eq g)
            already
          case None =>
            val kid = dn.kindId
            val seqId = g._nodes(kid).size + Option(newNodes(kid)).map { _.size }.getOrElse(0)
            val gn = g.schema.makeNode(g, kid, seqId)
            dn.storedRef = Some(gn)
            emplace(newNodes, dn, kid)
            deferred.append(dn)
            gn
        }
    }
  }

  def splitUpdate(): Unit = {

    for (item <- diff.buffer) item match {
      case delNode: DelNode =>
        if (!AccessHelpers.isDeleted(delNode.node)) {
          AccessHelpers.markDeleted(delNode.node)
          delNodes.append(delNode.node)
        }
      case _ =>
    }

    for (item <- diff.buffer) {
      item match {
        case a: DNode =>
          getGNode(a)
        case a: AddEdgeUnprocessed =>
          val src = getGNode(a.src)
          val dst = getGNode(a.dst)
          if (!AccessHelpers.isDeleted(src) && !AccessHelpers.isDeleted(dst)) {
            emplace(newEdges, new AddEdgeProcessed(src, dst, a.eid), g.schema.indexEdge(src.kindId, 1, a.eid))
            if (!a.unsafeUnidirectional)
              emplace(newEdges, new AddEdgeProcessed(dst, src, a.eid), g.schema.indexEdge(dst.kindId, 0, a.eid))
          }
        case e: Edge if !AccessHelpers.isDeleted(e.src) && !AccessHelpers.isDeleted(e.dst) =>
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
          if (e.subSeq > 0) {
            //the edge is forward, i.e. pulled from getEdgesOut
            emplace(delEdges, e, g.schema.indexEdge(e.src.kindId, 1, e.eid))
            val nbo = Accessors.getNeighborsOut(e.src, e.eid)
            var count = 0
            assert(nbo(e.subSeq - 1) == e.dst)
            for (idx <- Range(0, e.subSeq) if nbo(idx) == e.dst) count += 1
            val nbi = Accessors.getNeighborsIn(e.dst, e.eid)
            var idx = 0
            while (count > 0) {
              if (nbi(idx) == e.src) { count -= 1 }
              idx += 1
            }
            emplace(delEdges, new Edge(e.dst, e.src, e.eid, idx), g.schema.indexEdge(e.dst.kindId, 0, e.eid))
          } else if (e.subSeq < 0) {
            //the edge is backwards, i.e. pulled from getEdgesIn
            emplace(delEdges, new Edge(e.dst, e.src, e.eid, -e.subSeq), g.schema.indexEdge(e.dst.kindId, 0, e.eid))
            val nbi = Accessors.getNeighborsIn(e.dst, e.eid)
            var count = 0
            assert(nbi(-e.subSeq - 1) == e.src)
            for (idx <- Range(0, -e.subSeq) if nbi(idx) == e.src) count += 1
            val nbo = Accessors.getNeighborsOut(e.src, e.eid)
            var idx = 0
            while (count > 0) {
              if (nbo(idx) == e.dst) count -= 1
              idx += 1
            }
            emplace(delEdges, new Edge(e.src, e.dst, e.eid, idx), g.schema.indexEdge(e.src.kindId, 1, e.eid))
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
    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inOut <- Array(true, false)) deleteEdges(kid.asInstanceOf[Short], eid.asInstanceOf[Short], inOut)

    for (kid <- Range(0, g.schema.getNNodeKinds)) addNodes(kid.asInstanceOf[Short])

    if (delNodes.nonEmpty) {
      deleteNodes()
    }

    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inOut <- Array(true, false)) addEdges(kid.asInstanceOf[Short], eid.asInstanceOf[Short], inOut)

  }

  def deleteNodes(): Unit = {
    val replacement = new Array[AnyRef](g._neighbors.length)
    def cowgetQty(kid: Int, inout: Int, eid: Int): Array[Int] = {
      val pos = g.schema.indexEdge(kid, inout, eid)
      if (replacement(pos) != null) replacement(pos).asInstanceOf[Array[Int]]
      else {
        val r = g._neighbors(pos).asInstanceOf[Array[Int]].clone()
        ranToLen(r)
        replacement(pos) = r
        r
      }
    }

    def cowgetVal(kid: Int, inout: Int, eid: Int): Array[GNode] = {
      val pos = g.schema.indexEdge(kid, inout, eid)
      if (replacement(pos + 1) != null) replacement(pos + 1).asInstanceOf[Array[GNode]]
      else {
        val r = g._neighbors(pos + 1).asInstanceOf[Array[GNode]].clone()
        replacement(pos + 1) = r
        r
      }
    }

    for (del <- delNodes;
         eid <- Range(0, g.schema.getNEdgeKinds);
         inout <- Range(0, 2)) {
      //this loop is not threadsafe. Don't fiddle with locks. It is possible to handle each eid separately, though.
      //alternative alg can be fully multithreaded
      val pos = g.schema.indexEdge(del.kindId, inout, eid)
      val qtyOld = g._neighbors(pos).asInstanceOf[Array[Int]]
      val oldVal = g._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      if (qtyOld != null) {
        val start = get(qtyOld, del.seqId)
        val end = get(qtyOld, del.seqId + 1)
        if (end - start > 0) {
          //there is something to delete.
          val modQty = cowgetQty(del.kindId, inout, eid)
          val modVal = cowgetVal(del.kindId, inout, eid)
          //val (modQty, modVal) = cowget(del.kindId, inout, eid)
          modQty(del.seqId) = 0
          for (idx <- Range(start, end)) {
            modVal(idx) = del // we replace the neighbor with a tombstone, conveniently del itself
            val neighbor = oldVal(idx)
            if (!AccessHelpers.isDeleted(neighbor)) {
              //the backwards edge is already a tombstone (it points to del). So we only need to adjust the length.
              //in order to avoid double-adjusting, we only do this if the neighbor itself is not deleted.
              cowgetQty(neighbor.kindId, 1 - inout, eid)(neighbor.seqId) -= 1
            }
          }
        }
      }
    }
    //Now replacements is filled with the modifications.
    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inout <- Range(0, 2)) {
      val pos = g.schema.indexEdge(kid, inout, eid)
      if (replacement(pos) != null) {
        val newQty = replacement(pos).asInstanceOf[Array[Int]]
        lenToRan(newQty)
        val newVal = new Array[GNode](get(newQty, g._nodes(kid).length))
        val oldVal =
          (if (replacement(pos + 1) != null) replacement(pos + 1) else g._neighbors(pos + 1)).asInstanceOf[Array[GNode]]
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
        g._neighbors(pos) = newQty
        g._neighbors(pos + 1) = newVal
      }
    }
  }

  def ranToLen(a: Array[Int]): Unit = {
    if (a.length > 0) {
      assert(a(0) == 0)
      for (idx <- Range(0, a.length - 1)) {
        a(idx) = a(idx + 1) - a(idx)
      }
    }
    a(a.length - 1) = 0
  }

  def lenToRan(a: Array[Int]): Unit = {
    if (a.length > 0) {
      assert(a.last == 0)
      var count = 0
      var idx = 0
      while (idx < a.length) {
        val tmp = a(idx)
        a(idx) = count
        count += tmp
        idx += 1
      }
    }
  }

  def addNodes(kid: Short): Unit = {
    if (newNodes(kid) == null || newNodes(kid).isEmpty) { return }
    g._nodes(kid) = g._nodes(kid).appendedAll(newNodes(kid).iterator.map { _.storedRef.get })
    g.nnodes(kid) += newNodes(kid).size
  }

  def deleteEdges(kid: Short, eid: Short, isIn: Boolean): Unit = {
    val pos = g.schema.indexEdge(kid, if (isIn) 0 else 1, eid)
    val de = delEdges(pos)
    if (de == null) return
    assert(de.forall { e =>
      e.eid == eid && e.src.kindId == kid && e.subSeq > 0
    })
    de.sortInPlaceBy { e =>
      ((e.src.seqId.toLong << 32) + e.subSeq.toLong)
    }
    dedupBy(de, (e: Edge) => ((e.src.seqId.toLong << 32) + e.subSeq.toLong))
    val nnodes = g._nodes(kid).size
    val oldQty = g._neighbors(pos).asInstanceOf[Array[Int]]
    val oldVal = g._neighbors(pos + 1).asInstanceOf[Array[GNode]]

    val newQty = new Array[Int](nnodes + 1)
    val newVal = new Array[GNode](oldVal.length - de.length)

    var delPtr = 0
    var nxIdx = 0
    while (nxIdx < nnodes) {
      val seq = if (delPtr < de.size) de(delPtr).src.seqId else nnodes
      //copy from  nxIdx -> seq exclusive
      System.arraycopy(oldVal,
                       get(oldQty, nxIdx),
                       newVal,
                       get(oldQty, nxIdx) - delPtr,
                       get(oldQty, seq) - get(oldQty, nxIdx))
      for (idx <- Range(nxIdx, seq + 1)) newQty(idx) = get(oldQty, idx) - delPtr
      nxIdx = seq + 1
      //we now copy over the non-deleted edges of the critical seq
      if (delPtr < de.size) {
        val start = get(oldQty, seq)
        var nxDel = de(delPtr)
        var idx = 0
        while (idx < get(oldQty, seq + 1) - start) {
          if (nxDel != null && idx == nxDel.subSeq - 1) {
            delPtr += 1
            assert(nxDel.dst == oldVal(start + idx))
            nxDel = if (delPtr < de.size) de(delPtr) else null
          } else {
            newVal(start + idx - delPtr) = oldVal(start + idx)
          }
          idx += 1
        }
        newQty(seq + 1) = start + idx - delPtr
      }
    }
    g._neighbors(pos) = newQty
    g._neighbors(pos + 1) = newVal
  }

  def addEdges(kid: Short, eid: Short, isIn: Boolean): Unit = {
    val pos = g.schema.indexEdge(kid, if (isIn) 0 else 1, eid)
    val ne = newEdges(pos)
    if (ne == null || ne.isEmpty) return;
    ne.sortInPlaceBy { _.src.seqId }
    assert(ne.forall(e => e.src.kindId == kid && e.eid == eid))
    val nnodes = g._nodes(kid).size
    val oldQty = Option(g._neighbors(pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldVal = Option(g._neighbors(pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
    val newQty = new Array[Int](nnodes + 1)
    val newVal = new Array[GNode](oldVal.size + ne.size)
    var nePtr = 0
    var nxIdx = 0
    while (nxIdx < nnodes) {
      val seq = if (nePtr < ne.size) ne(nePtr).src.seqId else nnodes - 1
      //copy from  nxIdx -> seq inclusive
      System.arraycopy(oldVal,
                       get(oldQty, nxIdx),
                       newVal,
                       get(oldQty, nxIdx) + nePtr,
                       get(oldQty, seq + 1) - get(oldQty, nxIdx))
      for (idx <- Range(nxIdx, seq + 2)) newQty(idx) = get(oldQty, idx) + nePtr
      //insert
      while (nePtr < ne.size && ne(nePtr).src.seqId == seq) {
        newVal(newQty(seq + 1)) = ne(nePtr).dst
        newQty(seq + 1) += 1
        nePtr += 1
      }
      nxIdx = seq + 1
    }
    g._neighbors(pos) = newQty
    g._neighbors(pos + 1) = newVal
  }

  private def get(a: Array[Int], idx: Int): Int = if (idx < a.length) a(idx) else a.last

  /**Removes in place all subsequent duplicate items, with the last overwriting the previous ones.*/
  private def dedupBy[T, S](a: mutable.ArrayBuffer[T], by: T => S): Unit = {
    var outIdx = 0
    var idx = 0
    while (idx < a.length - 1) {
      if (by(a(idx)) == by(a(idx + 1))) {
        a(outIdx) = a(idx)
        idx += 1
      } else {
        if (outIdx != idx) a(outIdx) = a(idx)
        idx += 1
        outIdx += 1
      }
    }
    a.dropRightInPlace(idx - outIdx)
  }
}
