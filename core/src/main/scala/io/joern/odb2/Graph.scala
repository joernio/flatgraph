package io.joern.odb2
import misc.ISeq

object Accessors {

  def getEdgesOut(n: GNode, eid: Int): Iterator[Edge] =
    getNeighborsOut(n, eid).iterator.zipWithIndex.map {
      case (nb, i) => n.graph.schema.makeEdge(n, nb, eid.asInstanceOf[Short], i + 1)
    }

  def getEdgesIn(n: GNode, eid: Int): Iterator[Edge] =
    getNeighborsIn(n, eid).iterator.zipWithIndex.map {
      case (nb, i) => n.graph.schema.makeEdge(nb, n, eid.asInstanceOf[Short], -i - 1)
    }

  def getNeighborsOut(n: GNode, eid: Int): IndexedSeq[GNode] =
    getNeighborsOut(n.graph, eid.toShort, n.kindId, n.seqId)
  def getNeighborsIn(n: GNode, eid: Int): IndexedSeq[GNode] =
    getNeighborsIn(n.graph, eid.toShort, n.kindId, n.seqId)

  def getNeighborsOut(g: Graph, eid: Short, kindId: Short, seqid: Int): ISeq[GNode] =
    getNeighbors(g, g.schema.indexEdge(kindId, 1, eid), seqid)
  def getNeighborsIn(g: Graph, eid: Short, kindId: Short, seqid: Int): ISeq[GNode] =
    getNeighbors(g, g.schema.indexEdge(kindId, 0, eid), seqid)

  private def getNeighbors(g: Graph, pos: Int, seqid: Int): ISeq[GNode] = {
    val qty = g._neighbors(pos).asInstanceOf[Array[Int]]
    if (qty == null) return ISeq.empty
    if (seqid + 1 < qty.length) {
      val vals = g._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      new ISeq(vals, qty(seqid), qty(seqid + 1))
    } else ISeq.empty
  }

}

object DebugDump {

  def printNode(n: GNode): String =
    if (!AccessHelpers.isDeleted(n)) s"V${n.kindId}_${n.seqId}" else s"V${n.kindId}_${n.seqId} (deleted)"

  def debugDump(g: Graph): String = {
    val sb = new java.lang.StringBuilder(0)
    val numstr = g._nodes.map { _.size }.zipWithIndex.map { case (kid, sz) => s"${kid}: ${sz}" }.mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${g._nodes.iterator.map { _.size }.sum}\n")
    for (kid <- Range(0, g.schema.getNNodeKinds)) {
      sb.append(s"Node kind ${kid}. (eid, nEdgesOut, nEdgesIn): ")
      for (eid <- Range(0, g.schema.getNEdgeKinds)) {
        val posOut = g.schema.indexEdge(kid, 1, eid)
        val neO = g._neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.indexEdge(kid, 0, eid)
        val neIn = g._neighbors(posIn + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s"(${eid}, ${neO}, ${neIn}), ")
      }
      sb.append("\n")

      for (n <- g._nodes(kid)) {

        for (eid <- Range(0, g.schema.getNEdgeKinds)) {
          val nbo = Accessors.getNeighborsOut(n, eid)
          if (nbo.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${eid}] -> " + nbo.map(printNode).mkString(", ") + "\n")
          }
        }
        for (eid <- Range(0, g.schema.getNEdgeKinds)) {
          val nbo = Accessors.getNeighborsIn(n, eid)
          if (nbo.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${eid}] <- " + nbo.map(printNode).mkString(", ") + "\n")
          }
        }
      }
    }
    sb.toString
  }

}

class Graph(val schema: Schema) {
  val _nodes: Array[Array[GNode]] = new Array[Array[GNode]](schema.getNNodeKinds)
  val _neighbors: Array[AnyRef] = new Array[AnyRef](schema.getNNodeKinds * schema.getNEdgeKinds * 4)

  val nnodes: Array[Int] = new Array[Int](schema.getNNodeKinds)
  def nodes(kid: Short): Iterator[GNode] = {
    if (_nodes(kid).length == nnodes(kid)) _nodes(kid).iterator
    else _nodes(kid).iterator.filter { !AccessHelpers.isDeleted(_) }
  }
  for (idx <- Range(0, _nodes.length)) _nodes(idx) = new Array[GNode](0)

}
