package testdomains.empty

import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  private val nodeLabels                                                                   = IndexedSeq()
  val nodeKindByLabel                                                                      = nodeLabels.zipWithIndex.toMap
  val edgeLabels: Array[String]                                                            = Array()
  val edgeKindByLabel                                                                      = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]]                                       = Array()
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode]                     = Array()
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] = Array()
  val nodePropertyAllocators: Array[Int => Array[?]]                                       = Array()
  val normalNodePropertyNames: Array[String]                                               = Array()
  val nodePropertyByLabel                                                                  = normalNodePropertyNames.zipWithIndex.toMap
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](0)
    for (idx <- Range(0, 0)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors
  }
  private val newNodeInsertionHelpers: Array[flatgraph.NewNodePropertyInsertionHelper] = {
    val _newNodeInserters = new Array[flatgraph.NewNodePropertyInsertionHelper](0)

    _newNodeInserters
  }
  override def getNumberOfNodeKinds: Int                          = 0
  override def getNumberOfEdgeKinds: Int                          = 0
  override def getNodeLabel(nodeKind: Int): String                = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int             = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int             = edgeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNodePropertyNames(nodeLabel: String): Set[String] = {
    nodeLabel match {

      case _ => Set.empty
    }
  }
  override def getEdgePropertyName(label: String): Option[String] = {
    label match {

      case _ => None
    }
  }

  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 0) normalNodePropertyNames(propertyKind)
    else null
  }

  override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int             = 0
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
