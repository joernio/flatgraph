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

class AddEdgeProcessed(val src: GNode, val dst: GNode)

object DiffGraphApplier {
  def applyDiff(g: Graph, diff: DiffGraphBuilder): Unit = {
    new DiffGraphApplier(g, diff).applyUpdate()
    diff.buffer = null
  }
}

class DiffGraphApplier(g: Graph, diff: DiffGraphBuilder) {
  val newNodes = new Array[mutable.ArrayBuffer[DNode]](g.schema.getNNodeKinds)
  val newEdges = new Array[mutable.ArrayBuffer[AddEdgeProcessed]](g.schema.getNEdgeKinds * g.schema.getNNodeKinds * 2)
  val delEdges = new Array[mutable.ArrayBuffer[Edge]](g.schema.getNEdgeKinds * g.schema.getNNodeKinds * 2)
  val deferred = new mutable.ArrayDeque[DNode]()

  def emplace[T](a: Array[mutable.ArrayBuffer[T]], item: T, pos: Int): Unit = {
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
    for (item <- diff.buffer) {
      item match {
        case a: DNode =>
          getGNode(a)
        case a: AddEdgeUnprocessed =>
          val src = getGNode(a.src)
          val dst = getGNode(a.dst)
          emplace(newEdges, new AddEdgeProcessed(src, dst), (src.kindId + g.schema.getNNodeKinds * a.eid * 2))
          if (!a.unsafeUnidirectional)
            emplace(newEdges, new AddEdgeProcessed(dst, src), (dst.kindId + g.schema.getNNodeKinds * (a.eid * 2 + 1)))
        case e: Edge =>
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
            emplace(delEdges, e, (e.src.kindId + g.schema.getNNodeKinds * e.eid * 2))
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
            emplace(delEdges,
                    new Edge(e.dst, e.src, e.eid, idx),
                    (e.dst.kindId + g.schema.getNNodeKinds * (e.eid * 2 + 1)))
          } else if (e.subSeq < 0) {
            //the edge is backwards, i.e. pulled from getEdgesIn
            emplace(delEdges,
                    new Edge(e.dst, e.src, e.eid, -e.subSeq),
                    (e.dst.kindId + g.schema.getNNodeKinds * (e.eid * 2 + 1)))
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
            emplace(delEdges, new Edge(e.src, e.dst, e.eid, idx), (e.src.kindId + g.schema.getNNodeKinds * e.eid * 2))
          } else assert(false)

      }
      drainDeferred()
    }
  }

  def applyUpdate(): Unit = {
    splitUpdate()
    //order: 1. remove edges, 2. add nodes, 3. add edges
    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inOut <- Array(true, false)) deleteEdges(kid.asInstanceOf[Short], eid.asInstanceOf[Short], inOut)

    for (kid <- Range(0, g.schema.getNNodeKinds)) addNodes(kid.asInstanceOf[Short])

    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inOut <- Array(true, false)) addEdges(kid.asInstanceOf[Short], eid.asInstanceOf[Short], inOut)

  }

  def addNodes(kid: Short): Unit = {
    if (newNodes(kid) == null || newNodes(kid).isEmpty) { return }
    g._nodes(kid) = g._nodes(kid).appendedAll(newNodes(kid).iterator.map { _.storedRef.get })
  }

  def deleteEdges(kid: Short, eid: Short, isIn: Boolean): Unit = {
    val pos = kid + g.schema.getNNodeKinds * (2 * eid + (if (isIn) 1 else 0))
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
    val oldQty = g._neighbors(2 * pos).asInstanceOf[Array[Int]]
    val oldVal = g._neighbors(2 * pos + 1).asInstanceOf[Array[GNode]]

    val newQty = new Array[Int](oldQty.length)
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
    g._neighbors(2 * pos) = newQty
    g._neighbors(2 * pos + 1) = newVal
  }

  def addEdges(kid: Short, eid: Short, isIn: Boolean): Unit = {
    val pos = kid + g.schema.getNNodeKinds * (2 * eid + (if (isIn) 1 else 0))
    val ne = newEdges(pos)
    if (ne == null || ne.isEmpty) return;
    ne.sortInPlaceBy { _.src.seqId }
    val nnodes = g._nodes(kid).size
    val oldQty = Option(g._neighbors(2 * pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldVal = Option(g._neighbors(2 * pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
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
    g._neighbors(2 * pos) = newQty
    g._neighbors(2 * pos + 1) = newVal
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
