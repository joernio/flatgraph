package testdomains.generic

import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  private val nodeLabels                             = IndexedSeq("node_a", "node_b")
  val nodeKindByLabel                                = nodeLabels.zipWithIndex.toMap
  val edgeLabels: Array[String]                      = Array("connected_to")
  val edgeKindByLabel                                = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]] = Array(size => Array.fill(size)("<empty>") /* label = connected_to, id = 0 */ )
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] =
    Array((g, seq) => new nodes.NodeA(g, seq), (g, seq) => new nodes.NodeB(g, seq))
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] =
    Array((s, d, subseq, p) => new edges.ConnectedTo(s, d, subseq, p))
  val nodePropertyAllocators: Array[Int => Array[?]] = Array(
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[flatgraph.GNode](size)
  )
  val normalNodePropertyNames: Array[String] =
    Array("int_list", "int_mandatory", "int_optional", "string_list", "string_mandatory", "string_optional")
  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap.updated("node_b", 6)
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](28)
    for (idx <- Range(0, 28)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors(0) = FormalQtyType.IntType // node_a.int_list
    nodePropertyDescriptors(1) = FormalQtyType.QtyMulti
    nodePropertyDescriptors(4) = FormalQtyType.IntType // node_a.int_mandatory
    nodePropertyDescriptors(5) = FormalQtyType.QtyOne
    nodePropertyDescriptors(8) = FormalQtyType.IntType // node_a.int_optional
    nodePropertyDescriptors(9) = FormalQtyType.QtyOption
    nodePropertyDescriptors(12) = FormalQtyType.StringType // node_a.string_list
    nodePropertyDescriptors(13) = FormalQtyType.QtyMulti
    nodePropertyDescriptors(16) = FormalQtyType.StringType // node_a.string_mandatory
    nodePropertyDescriptors(17) = FormalQtyType.QtyOne
    nodePropertyDescriptors(20) = FormalQtyType.StringType // node_a.string_optional
    nodePropertyDescriptors(21) = FormalQtyType.QtyOption
    nodePropertyDescriptors(24) = FormalQtyType.RefType // node_a.node_b
    nodePropertyDescriptors(25) = FormalQtyType.QtyOption
    nodePropertyDescriptors(22) = FormalQtyType.StringType // node_b.string_optional
    nodePropertyDescriptors(23) = FormalQtyType.QtyOption
    nodePropertyDescriptors
  }
  private val newNodeInsertionHelpers: Array[flatgraph.NewNodePropertyInsertionHelper] = {
    val _newNodeInserters = new Array[flatgraph.NewNodePropertyInsertionHelper](28)
    _newNodeInserters(0) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_intList
    _newNodeInserters(4) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_intMandatory
    _newNodeInserters(8) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_intOptional
    _newNodeInserters(12) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_stringList
    _newNodeInserters(16) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_stringMandatory
    _newNodeInserters(20) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_stringOptional
    _newNodeInserters(24) = nodes.NewNodeA.InsertionHelpers.NewNodeInserter_NodeA_node_b
    _newNodeInserters(22) = nodes.NewNodeB.InsertionHelpers.NewNodeInserter_NodeB_stringOptional
    _newNodeInserters
  }
  override def getNumberOfNodeKinds: Int                          = 2
  override def getNumberOfEdgeKinds: Int                          = 1
  override def getNodeLabel(nodeKind: Int): String                = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int             = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int             = edgeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNodePropertyNames(nodeLabel: String): Set[String] = {
    nodeLabel match {
      case "node_a" => Set("int_list", "int_mandatory", "int_optional", "string_list", "string_mandatory", "string_optional")
      case "node_b" => Set("string_optional")
      case _        => Set.empty
    }
  }
  override def getEdgePropertyName(label: String): Option[String] = {
    label match {
      case "connected_to" => Some("string_mandatory")
      case _              => None
    }
  }

  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 6) normalNodePropertyNames(propertyKind)
    else if (propertyKind == 6 && nodeKind == 0) "node_b" /*on node node_a*/
    else null
  }

  override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int             = 7
  override def makeNode(graph: flatgraph.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
  override def makeEdge(src: flatgraph.GNode, dst: flatgraph.GNode, edgeKind: Short, subSeq: Int, property: Any): flatgraph.Edge =
    edgeFactories(edgeKind)(src, dst, subSeq, property)
  override def allocateEdgeProperty(nodeKind: Int, direction: flatgraph.Edge.Direction, edgeKind: Int, size: Int): Array[?] =
    edgePropertyAllocators(edgeKind)(size)
  override def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType = nodePropertyDescriptors(
    propertyOffsetArrayIndex(nodeKind, propertyKind)
  ).asInstanceOf[FormalQtyType.FormalType]
  override def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity = nodePropertyDescriptors(
    1 + propertyOffsetArrayIndex(nodeKind, propertyKind)
  ).asInstanceOf[FormalQtyType.FormalQuantity]

  override def getNewNodePropertyInserter(nodeKind: Int, propertyKind: Int): flatgraph.NewNodePropertyInsertionHelper =
    newNodeInsertionHelpers(propertyOffsetArrayIndex(nodeKind, propertyKind))
}
