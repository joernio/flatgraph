package io.joern.odb2
import io.joern.odb2.Graph.{NeighborsSlotSize, NumberOfDirections}
import misc.ISeq

object Accessors {

  def getEdgesOut(node: GNode, edgeKind: Int): Iterator[Edge] =
    getNeighborsOut(node, edgeKind).iterator.zipWithIndex.map { case (nb, i) =>
      node.graph.schema.makeEdge(node, nb, edgeKind.asInstanceOf[Short], i + 1)
    }

  def getEdgesIn(node: GNode, edgeKind: Int): Iterator[Edge] =
    getNeighborsIn(node, edgeKind).iterator.zipWithIndex.map { case (nb, i) =>
      node.graph.schema.makeEdge(nb, node, edgeKind.asInstanceOf[Short], -i - 1)
    }

  def getNeighborsOut(node: GNode, edgeKind: Int): IndexedSeq[GNode] =
    getNeighborsOut(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  def getNeighborsIn(node: GNode, edgeKind: Int): IndexedSeq[GNode] =
    getNeighborsIn(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  def getNeighborsOut(graph: Graph, nodeKind: Int, seq: Int, edgeKind: Int): IndexedSeq[GNode] =
    getNeighbors(graph, graph.schema.neighborOffsetArrayIndex(nodeKind, 1, edgeKind), seq)

  def getNeighborsIn(g: Graph, nodeKind: Short, seq: Int, edgeKind: Short): IndexedSeq[GNode] =
    getNeighbors(g, g.schema.neighborOffsetArrayIndex(nodeKind, 0, edgeKind), seq)

  private def getNeighbors(g: Graph, pos: Int, seq: Int): IndexedSeq[GNode] = {
    val qty = g._neighbors(pos).asInstanceOf[Array[Int]]
    if (qty == null) return ISeq.empty
    if (seq + 1 < qty.length) {
      val vals = g._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      new ISeq(vals, qty(seq), qty(seq + 1))
    } else ISeq.empty
  }

}

object DebugDump {

  def printNode(n: GNode): String =
    if (!AccessHelpers.isDeleted(n)) s"V${n.nodeKind}_${n.seq}" else s"V${n.nodeKind}_${n.seq} (deleted)"

  def debugDump(g: Graph): String = {
    val sb = new java.lang.StringBuilder(0)
    val numstr =
      g._nodes.map { _.size }.zipWithIndex.map { case (nodeKind, sz) => s"${nodeKind}: ${sz}" }.mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${g._nodes.iterator.map { _.size }.sum}\n")
    for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) {
      sb.append(s"Node kind ${nodeKind}. (eid, nEdgesOut, nEdgesIn):")
      for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
        val posOut = g.schema.neighborOffsetArrayIndex(nodeKind, 1, edgeKind)
        val neO = g._neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.neighborOffsetArrayIndex(nodeKind, 0, edgeKind)
        val neIn = g._neighbors(posIn + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s" (${edgeKind}, ${neO}, ${neIn}),")
      }
      sb.append("\n")

      for (n <- g._nodes(nodeKind)) {

        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val nbo = Accessors.getNeighborsOut(n, edgeKind)
          if (nbo.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeKind}] -> " + nbo.map(printNode).mkString(", ") + "\n")
          }
        }
        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val nbo = Accessors.getNeighborsIn(n, edgeKind)
          if (nbo.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeKind}] <- " + nbo.map(printNode).mkString(", ") + "\n")
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
  val NeighborsSlotSize  = 2
  val NumberOfDirections = 2
}

class Graph(val schema: Schema) {
  val _nodes: Array[Array[GNode]] = new Array[Array[GNode]](schema.getNumberOfNodeKinds)

  val _neighbors: Array[AnyRef] = new Array[AnyRef](
    schema.getNumberOfNodeKinds * schema.getNumberOfEdgeKinds * NeighborsSlotSize * NumberOfDirections
  )

  val nnodes: Array[Int] = new Array[Int](schema.getNumberOfNodeKinds)
  def nodes(nodeKind: Int): Iterator[GNode] = {
    if (_nodes(nodeKind).length == nnodes(nodeKind)) _nodes(nodeKind).iterator
    else _nodes(nodeKind).iterator.filter { !AccessHelpers.isDeleted(_) }
  }
  for (nodeKind <- Range(0, _nodes.length)) _nodes(nodeKind) = new Array[GNode](0)

}
