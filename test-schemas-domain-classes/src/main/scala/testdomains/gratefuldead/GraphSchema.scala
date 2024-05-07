package testdomains.gratefuldead

import testdomains.gratefuldead.nodes
import testdomains.gratefuldead.edges
import flatgraph.FormalQtyType

object GraphSchema extends flatgraph.Schema {
  private val nodeLabels = IndexedSeq("artist", "song")
  val nodeKindByLabel    = nodeLabels.zipWithIndex.toMap
  val edgeLabels         = Array("followedBy", "sungBy", "writtenBy")
  val edgeKindByLabel    = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[?]] =
    Array(size => Array.fill(size)(0: Long) /* label = followedBy, id = 0 */, size => null, size => null)
  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] =
    Array((g, seq) => new nodes.Artist(g, seq), (g, seq) => new nodes.Song(g, seq))
  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] = Array(
    (s, d, subseq, p) => new edges.Followedby(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Sungby(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Writtenby(s, d, subseq, p)
  )
  val nodePropertyAllocators: Array[Int => Array[?]] = Array(size => new Array[String](size), size => new Array[String](size))
  val normalNodePropertyNames                        = Array("name", "songType")
  val nodePropertyByLabel                            = normalNodePropertyNames.zipWithIndex.toMap
  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = {
    val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType](8)
    for (idx <- Range(0, 8)) {
      nodePropertyDescriptors(idx) =
        if ((idx & 1) == 0) FormalQtyType.NothingType
        else FormalQtyType.QtyNone
    }

    nodePropertyDescriptors(0) = FormalQtyType.StringType // artist.name
    nodePropertyDescriptors(1) = FormalQtyType.QtyOne
    nodePropertyDescriptors(2) = FormalQtyType.StringType // song.name
    nodePropertyDescriptors(3) = FormalQtyType.QtyOne
    nodePropertyDescriptors(6) = FormalQtyType.StringType // song.songType
    nodePropertyDescriptors(7) = FormalQtyType.QtyOption
    nodePropertyDescriptors
  }
  override def getNumberOfNodeKinds: Int                          = 2
  override def getNumberOfEdgeKinds: Int                          = 3
  override def getNodeLabel(nodeKind: Int): String                = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int             = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int             = edgeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNodePropertyNames(nodeLabel: String): Set[String] = {
    nodeLabel match {
      case "artist" => Set("name")
      case "song"   => Set("name", "songType")
      case _        => Set.empty
    }
  }
  override def getEdgePropertyName(label: String): Option[String] = {
    label match {
      case "followedBy" => Some("weight")
      case _            => None
    }
  }

  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
    if (propertyKind < 2) normalNodePropertyNames(propertyKind)
    else null
  }

  override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
  override def getNumberOfPropertyKinds: Int             = 2
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
}
