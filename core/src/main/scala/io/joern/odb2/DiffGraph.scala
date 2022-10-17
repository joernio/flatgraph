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
      }
      drainDeferred()
    }
  }

  def applyUpdate(): Unit = {
    splitUpdate()
    //order: 1. remove edges, 2. add nodes, 3. add edges, 4. remove nodes
    for (kid <- Range(0, g.schema.getNNodeKinds)) rewriteNodes(kid.asInstanceOf[Short])

    for (kid <- Range(0, g.schema.getNNodeKinds);
         eid <- Range(0, g.schema.getNEdgeKinds);
         inOut <- Array(true, false)) rewriteEdges(kid.asInstanceOf[Short], eid.asInstanceOf[Short], inOut)

  }

  def rewriteNodes(kid: Short): Unit = {
    if (newNodes(kid) == null || newNodes(kid).isEmpty) { return }
    g._nodes(kid) = g._nodes(kid).appendedAll(newNodes(kid).iterator.map { _.storedRef.get })
  }

  def rewriteEdges(kid: Short, eid: Short, isIn: Boolean): Unit = {
    val pos = kid + g.schema.getNNodeKinds * (2 * eid + (if (isIn) 1 else 0))
    val ne = newEdges(pos)
    if (ne == null || ne.isEmpty) return;
    ne.sortInPlaceBy { _.src.seqId }
    val oldQty = Option(g._neighbors(2 * pos).asInstanceOf[Array[Int]]).getOrElse(new Array[Int](1))
    val oldNeighbors = Option(g._neighbors(2 * pos + 1).asInstanceOf[Array[GNode]]).getOrElse(new Array[GNode](0))
    val (nQty, nNeighbors) = copyEdgeMulti(oldNeighbors, oldQty, g._nodes(kid).size, oldNeighbors.size + ne.size, ne)
    g._neighbors(2 * pos) = nQty
    g._neighbors(2 * pos + 1) = nNeighbors
  }

  def copyEdgeMulti(src: Array[GNode],
                    srcQty: Array[Int],
                    nnodes: Int,
                    expectedSize: Int,
                    newEdges: mutable.ArrayBuffer[AddEdgeProcessed]): (Array[Int], Array[GNode]) = {
    val dst = new Array[GNode](expectedSize)
    val dstQty = new Array[Int](nnodes + 1)
    var nxIdx = 0
    for (e <- newEdges) {
      val seq = e.src.seqId
      acpy(src, srcQty, dst, dstQty, nxIdx, seq + 1)
      val insertpoint = dstQty(seq + 1)
      dst(insertpoint) = e.dst
      dstQty(seq + 1) = insertpoint + 1
      nxIdx = seq + 1
    }
    acpy(src, srcQty, dst, dstQty, nxIdx, nnodes)
    (dstQty, dst)
  }

  private def acpy(src: AnyRef, srci: Array[Int], dst: AnyRef, dsti: Array[Int], from: Int, until: Int): Unit = {
    if (until <= from) return
    if (from + 1 >= srci.length) {
      //there are no values, we just need to write the indices
      val lastpos = dsti(from)
      var idx = from + 1
      while (idx < until + 1) {
        dsti(idx) = lastpos
        idx += 1
      }
      return
    }

    val until0 = scala.math.min(until, srci.length - 1)
    val sn = srci(from)
    val dn = dsti(from)
    val len = srci(until0) - sn
    System.arraycopy(src, sn, dst, dn, len)
    val off = dn - sn
    for (idx <- Range(from + 1, until0 + 1)) {
      dsti(idx) = srci(idx) + off
    }

    //we now need to set the remaining items
    if (until != until0) {
      val terminal = dsti(until0)
      for (idx <- Range(until0 + 1, until + 1)) {
        dsti(idx) = terminal
      }
    }
  }

}
