package io.joern.odb2
import io.joern.odb2.Graph.{NeighborsSlotSize, NumberOfDirections}
import misc.ISeq

object Accessors {

  def getEdgesOut(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, 1, edgeKind)
    val offsets = node.graph._neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph._neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph._neighbors(pos + 2),
      1,
      edgeKind.toShort,
      offsets(node.seq()),
      offsets(node.seq() + 1)
    )
  }

  def getEdgesIn(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, 0, edgeKind)
    val offsets = node.graph._neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph._neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph._neighbors(pos + 2),
      0,
      edgeKind.toShort,
      offsets(node.seq()),
      offsets(node.seq() + 1)
    )
  }

  class EdgeView(neighbors: Array[GNode], base: GNode, properties: Any, inout: Byte, edgeKind: Short, start: Int, end: Int)
      extends IndexedSeq[Edge] {
    override def apply(i: Int): Edge = {
      val property = properties match {
        case null                       => null
        case defaultValue: DefaultValue => defaultValue.default
        case a: Array[_]                => a(start + i)
      }
      if (inout == 0) base.graph.schema.makeEdge(neighbors(start + i), base, edgeKind, -i - 1, property)
      else
        base.graph.schema.makeEdge(base, neighbors(start + i), edgeKind, i + 1, property)
    }

    override def length: Int = end - start
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

  def printNode(n: GNode): String = printNode(n, null)
  def printNode(n: GNode, property: Any): String =
    if (!AccessHelpers.isDeleted(n)) { if (property == null) s"V${n.nodeKind}_${n.seq}" else s"(${property}) V${n.nodeKind}_${n.seq}" }
    else s"(property, deleted) V${n.nodeKind}_${n.seq}"

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
          val edgesOut = Accessors.getEdgesOut(n, edgeKind)
          assert(Accessors.getNeighborsOut(n, edgeKind).sameElements(edgesOut.map { _.dst }))
          if (edgesOut.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeKind}] -> " + edgesOut.map { e => printNode(e.dst, e.property) }.mkString(", ") + "\n")
          }
        }
        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val edgesIn = Accessors.getEdgesIn(n, edgeKind)
          assert(Accessors.getNeighborsIn(n, edgeKind) == (edgesIn.map { _.src }))
          if (edgesIn.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeKind}] <- " + edgesIn.map { e => printNode(e.src, e.property) }.mkString(", ") + "\n")
          }
        }
      }
    }
    sb.toString
  }

}

object Graph {
  // Slot size is 3 because we have one pointer to array of quantity array and one pointer to array of
  // neighbors, and one array containing edge properties
  val NeighborsSlotSize  = 3
  val NumberOfDirections = 2
}

class Graph(val schema: Schema) {
  val _nodes: Array[Array[GNode]] = new Array[Array[GNode]](schema.getNumberOfNodeKinds)

  val _neighbors: Array[AnyRef] =
    new Array[AnyRef](schema.getNumberOfNodeKinds * schema.getNumberOfEdgeKinds * NeighborsSlotSize * NumberOfDirections)

  for (
    nodeKind <- Range(0, schema.getNumberOfNodeKinds);
    inout    <- Range(0, 2);
    edgeKind <- Range(0, schema.getNumberOfEdgeKinds)
  ) {
    val pos = schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
    _neighbors(pos + 2) = schema.edgePropertyDefaultValue(nodeKind, inout, edgeKind)
  }

  val nnodes: Array[Int] = new Array[Int](schema.getNumberOfNodeKinds)
  def nodes(nodeKind: Int): Iterator[GNode] = {
    if (_nodes(nodeKind).length == nnodes(nodeKind)) _nodes(nodeKind).iterator
    else _nodes(nodeKind).iterator.filter { !AccessHelpers.isDeleted(_) }
  }
  for (nodeKind <- Range(0, _nodes.length)) _nodes(nodeKind) = new Array[GNode](0)

}
