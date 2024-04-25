package flatgraph.testdomains.gratefuldead
import flatgraph.testdomains.gratefuldead.nodes
import flatgraph.testdomains.gratefuldead.edges
import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  val nodeLabels = Array("Artist", "Song")
  val nodeKindByLabel = nodeLabels.zipWithIndex.toMap
  val edgeLabels = Array("followedBy")
  val edgeIdByLabel = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]] = Array(size => null)
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] =
    Array((g, seq) => new nodes.Artist(g, seq), (g, seq) => new nodes.Song(g, seq))
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] =
    Array((s, d, subseq, p) => new edges.Followedby(s, d, subseq, p))
  val nodePropertyAllocators: Array[Int => Array[?]] = Array(size => new Array[String](size))
  val normalNodePropertyNames = Array("Name")
  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](4)
    for (idx <- Range(0, 4)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors(0) = FormalQtyType.StringType // Artist.Name
    nodePropertyDescriptors(1) = FormalQtyType.QtyOne
    nodePropertyDescriptors(2) = FormalQtyType.StringType // Song.Name
    nodePropertyDescriptors(3) = FormalQtyType.QtyOne
    nodePropertyDescriptors
  }
  override def getNumberOfNodeKinds: Int = 2
  override def getNumberOfEdgeKinds: Int = 1
  override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int = edgeIdByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 1) normalNodePropertyNames(propertyKind)
    else null
  }

  override def getPropertyKindByName(label: String): Int =
    nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int = 1
  override def makeNode(graph: flatgraph.Graph, nodeKind: Short, seq: Int): nodes.StoredNode =
    nodeFactories(nodeKind)(graph, seq)
  override def makeEdge(
      src: flatgraph.GNode,
      dst: flatgraph.GNode,
      edgeKind: Short,
      subSeq: Int,
      property: Any
  ): flatgraph.Edge = edgeFactories(edgeKind)(src, dst, subSeq, property)
  override def allocateEdgeProperty(
      nodeKind: Int,
      direction: flatgraph.Edge.Direction,
      edgeKind: Int,
      size: Int
  ): Array[?] = edgePropertyAllocators(edgeKind)(size)
  override def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType =
    nodePropertyDescriptors(propertyOffsetArrayIndex(nodeKind, propertyKind)).asInstanceOf[FormalQtyType.FormalType]
  override def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity =
    nodePropertyDescriptors(1 + propertyOffsetArrayIndex(nodeKind, propertyKind))
      .asInstanceOf[FormalQtyType.FormalQuantity]
}
