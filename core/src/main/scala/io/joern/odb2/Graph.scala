package io.joern.odb2
import misc.ISeq

object Accessors {

  def getNeighborsOut(n: GNode, eid: Int): ISeq[GNode] =
    getNeighborsOut(n.graph, eid.asInstanceOf[Short], n.kindId, n.seqId)
  def getNeighborsIn(n: GNode, eid: Int): ISeq[GNode] =
    getNeighborsIn(n.graph, eid.asInstanceOf[Short], n.kindId, n.seqId)

  def getNeighborsOut(g: Graph, eid: Short, kindId: Short, seqid: Int): ISeq[GNode] =
    getNeighbors(g, 2 * (kindId + g.schema.getNNodeKinds * eid * 2), seqid)
  def getNeighborsIn(g: Graph, eid: Short, kindId: Short, seqid: Int): ISeq[GNode] =
    getNeighbors(g, 2 * (kindId + g.schema.getNNodeKinds * (eid * 2 + 1)), seqid)

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

  def printNode(n: GNode): String = s"V${n.kindId}_${n.seqId}"

  def debugDump(g: Graph): String = {
    val sb = new java.lang.StringBuilder(0)
    val numstr = g._nodes.map { _.size }.zipWithIndex.map { case (kid, sz) => s"${kid}: ${sz}" }.mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${g._nodes.iterator.map { _.size }.sum}\n")
    //sb.append(s"Edge types: ${g.schema.getNEdgeKinds}\\")
    for (kid <- Range(0, g.schema.getNNodeKinds)) {
      sb.append(s"Node kind ${kid}. (eid, nEdgesOut, nEdgesIn): ")
      for (eid <- Range(0, g.schema.getNEdgeKinds)) {
        val posOut = 2 * (kid + g.schema.getNNodeKinds * eid * 2)
        val neO = g._neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = 2 * (kid + g.schema.getNNodeKinds * (eid * 2 + 1))
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

  for (idx <- Range(0, _nodes.length)) _nodes(idx) = new Array[GNode](0)
}
