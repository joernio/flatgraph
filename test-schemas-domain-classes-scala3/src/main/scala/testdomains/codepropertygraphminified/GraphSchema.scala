package testdomains.codepropertygraphminified

import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  private val nodeLabels                             = IndexedSeq("CALL", "METHOD")
  val nodeKindByLabel                                = nodeLabels.zipWithIndex.toMap
  val edgeLabels: Array[String]                      = Array("CALL")
  val edgeKindByLabel                                = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]] = Array(size => null)
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] =
    Array((g, seq) => new nodes.Call(g, seq), (g, seq) => new nodes.Method(g, seq))
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] =
    Array((s, d, subseq, p) => new edges.Call(s, d, subseq, p))
  val nodePropertyAllocators: Array[Int => Array[?]] =
    Array(size => new Array[String](size), size => new Array[String](size), size => new Array[Int](size))
  val normalNodePropertyNames: Array[String] = Array("DISPATCH_TYPE", "NAME", "ORDER")
  val nodePropertyByLabel                    = normalNodePropertyNames.zipWithIndex.toMap
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](12)
    for (idx <- Range(0, 12)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors(0) = FormalQtyType.StringType // CALL.DISPATCH_TYPE
    nodePropertyDescriptors(1) = FormalQtyType.QtyOne
    nodePropertyDescriptors(4) = FormalQtyType.StringType // CALL.NAME
    nodePropertyDescriptors(5) = FormalQtyType.QtyOne
    nodePropertyDescriptors(8) = FormalQtyType.IntType // CALL.ORDER
    nodePropertyDescriptors(9) = FormalQtyType.QtyOne
    nodePropertyDescriptors(6) = FormalQtyType.StringType // METHOD.NAME
    nodePropertyDescriptors(7) = FormalQtyType.QtyOne
    nodePropertyDescriptors
  }
  private val newNodeInsertionHelpers: Array[flatgraph.NewNodePropertyInsertionHelper] = {
    val _newNodeInserters = new Array[flatgraph.NewNodePropertyInsertionHelper](12)
    _newNodeInserters(0) = nodes.NewCall.InsertionHelpers.NewNodeInserter_Call_dispatchType
    _newNodeInserters(4) = nodes.NewCall.InsertionHelpers.NewNodeInserter_Call_name
    _newNodeInserters(8) = nodes.NewCall.InsertionHelpers.NewNodeInserter_Call_order
    _newNodeInserters(6) = nodes.NewMethod.InsertionHelpers.NewNodeInserter_Method_name
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
      case "CALL"   => Set("DISPATCH_TYPE", "NAME", "ORDER")
      case "METHOD" => Set("NAME")
      case _        => Set.empty
    }
  }
  override def getEdgePropertyName(label: String): Option[String] = {
    label match {

      case _ => None
    }
  }

  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 3) normalNodePropertyNames(propertyKind)
    else null
  }

  override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int             = 3
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
