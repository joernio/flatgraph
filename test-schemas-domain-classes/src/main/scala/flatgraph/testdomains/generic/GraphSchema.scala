package flatgraph.testdomains.generic
import flatgraph.testdomains.generic.nodes
import flatgraph.testdomains.generic.edges
import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  private val nodeLabels = IndexedSeq("node_a")
  val nodeKindByLabel    = nodeLabels.zipWithIndex.toMap
  val edgeLabels         = Array("connected_to")
  val edgeIdByLabel      = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]] =
    Array(size => Array.fill(size)("<empty>") /* label = connected_to, id = 0 */ )
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] = Array((g, seq) => new nodes.NodeA(g, seq))
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] =
    Array((s, d, subseq, p) => new edges.ConnectedTo(s, d, subseq, p))
  val nodePropertyAllocators: Array[Int => Array[?]] = Array(
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size)
  )
  val normalNodePropertyNames =
    Array("intList", "intMandatory", "intOptional", "stringList", "stringMandatory", "stringOptional")
  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](12)
    for (idx <- Range(0, 12)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors(0) = FormalQtyType.IntType // node_a.intList
    nodePropertyDescriptors(1) = FormalQtyType.QtyMulti
    nodePropertyDescriptors(2) = FormalQtyType.IntType // node_a.intMandatory
    nodePropertyDescriptors(3) = FormalQtyType.QtyOne
    nodePropertyDescriptors(4) = FormalQtyType.IntType // node_a.intOptional
    nodePropertyDescriptors(5) = FormalQtyType.QtyOption
    nodePropertyDescriptors(6) = FormalQtyType.StringType // node_a.stringList
    nodePropertyDescriptors(7) = FormalQtyType.QtyMulti
    nodePropertyDescriptors(8) = FormalQtyType.StringType // node_a.stringMandatory
    nodePropertyDescriptors(9) = FormalQtyType.QtyOne
    nodePropertyDescriptors(10) = FormalQtyType.StringType // node_a.stringOptional
    nodePropertyDescriptors(11) = FormalQtyType.QtyOption
    nodePropertyDescriptors
  }
  override def getNumberOfNodeKinds: Int                          = 1
  override def getNumberOfEdgeKinds: Int                          = 1
  override def getNodeLabel(nodeKind: Int): String                = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int             = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int             = edgeIdByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 6) normalNodePropertyNames(propertyKind)
    else null
  }

  override def getPropertyKindByName(label: String): Int =
    nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int = 6
  override def makeNode(graph: flatgraph.Graph, nodeKind: Short, seq: Int): nodes.StoredNode =
    nodeFactories(nodeKind)(graph, seq)
  override def makeEdge(src: flatgraph.GNode, dst: flatgraph.GNode, edgeKind: Short, subSeq: Int, property: Any): flatgraph.Edge =
    edgeFactories(edgeKind)(src, dst, subSeq, property)
  override def allocateEdgeProperty(nodeKind: Int, direction: flatgraph.Edge.Direction, edgeKind: Int, size: Int): Array[?] =
    edgePropertyAllocators(edgeKind)(size)
  override def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType =
    nodePropertyDescriptors(propertyOffsetArrayIndex(nodeKind, propertyKind)).asInstanceOf[FormalQtyType.FormalType]
  override def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity =
    nodePropertyDescriptors(1 + propertyOffsetArrayIndex(nodeKind, propertyKind))
      .asInstanceOf[FormalQtyType.FormalQuantity]
}
