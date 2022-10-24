package io.joern.odb2
import io.joern.odb2.Graph.{NeighborsSlotSize, NumberOfDirections}
import misc.ISeq

object Accessors {

  def getEdgesOut(node: GNode, edgeId: Int): Iterator[Edge] =
    getNeighborsOut(node, edgeId).iterator.zipWithIndex.map {
      case (nb, i) => node.graph.schema.makeEdge(node, nb, edgeId.asInstanceOf[Short], i + 1)
    }

  def getEdgesIn(node: GNode, edgeId: Int): Iterator[Edge] =
    getNeighborsIn(node, edgeId).iterator.zipWithIndex.map {
      case (nb, i) => node.graph.schema.makeEdge(nb, node, edgeId.asInstanceOf[Short], -i - 1)
    }

  def getNeighborsOut(node: GNode, edgeId: Int): IndexedSeq[GNode] =
    getNeighborsOut(node.graph, node.kindId, node.seqId, edgeId.toShort)

  def getNeighborsIn(node: GNode, edgeId: Int): IndexedSeq[GNode] =
    getNeighborsIn(node.graph, node.kindId, node.seqId, edgeId.toShort)

  def getNeighborsOut(graph: Graph, nodeKind: Short, seqid: Int, edgeId: Short): IndexedSeq[GNode] =
    getNeighbors(graph, graph.schema.neighborOffsetArrayIndex(nodeKind, 1, edgeId), seqid)

  def getNeighborsIn(g: Graph, kindId: Short, seqid: Int, edgeId: Short): IndexedSeq[GNode] =
    getNeighbors(g, g.schema.neighborOffsetArrayIndex(kindId, 0, edgeId), seqid)

  private def getNeighbors(g: Graph, pos: Int, seqid: Int): IndexedSeq[GNode] = {
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
    for (kid <- Range(0, g.schema.getNumberOfNodeKinds)) {
      sb.append(s"Node kind ${kid}. (eid, nEdgesOut, nEdgesIn): ")
      for (eid <- Range(0, g.schema.getNumberOfEdgeKinds)) {
        val posOut = g.schema.neighborOffsetArrayIndex(kid, 1, eid)
        val neO = g._neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.neighborOffsetArrayIndex(kid, 0, eid)
        val neIn = g._neighbors(posIn + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s"(${eid}, ${neO}, ${neIn}), ")
      }
      sb.append("\n")

      for (n <- g._nodes(kid)) {

        for (eid <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val nbo = Accessors.getNeighborsOut(n, eid)
          if (nbo.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${eid}] -> " + nbo.map(printNode).mkString(", ") + "\n")
          }
        }
        for (eid <- Range(0, g.schema.getNumberOfEdgeKinds)) {
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

object Graph {
  // Slot size is 2 because we have one pointer to array of quantity array and one pointer to array of
  // neighbors.
  val NeighborsSlotSize = 2
  val NumberOfDirections = 2
}

class Graph(val schema: Schema) {
  val _nodes: Array[Array[GNode]] = new Array[Array[GNode]](schema.getNumberOfNodeKinds)

  val _neighbors: Array[AnyRef] = new Array[AnyRef](schema.getNumberOfNodeKinds * schema.getNumberOfEdgeKinds * NeighborsSlotSize * NumberOfDirections)

  val nnodes: Array[Int] = new Array[Int](schema.getNumberOfNodeKinds)
  def nodes(kid: Short): Iterator[GNode] = {
    if (_nodes(kid).length == nnodes(kid)) _nodes(kid).iterator
    else _nodes(kid).iterator.filter { !AccessHelpers.isDeleted(_) }
  }
  for (idx <- Range(0, _nodes.length)) _nodes(idx) = new Array[GNode](0)

}
