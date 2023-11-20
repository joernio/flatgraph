package flatgraph

import flatgraph.Edge.Direction
import flatgraph.Graph.*
import flatgraph.misc.{InitNodeIterator, InitNodeIteratorArray, InitNodeIteratorArrayFiltered}

import java.util.concurrent.atomic.AtomicReferenceArray

class Graph(val schema: Schema) {
  private val nodeKindCount   = schema.getNumberOfNodeKinds
  private val edgeKindCount   = schema.getNumberOfEdgeKinds
  private val propertiesCount = schema.getNumberOfProperties

  private[flatgraph] val nodeCountByKind: Array[Int]     = new Array[Int](nodeKindCount)
  private[flatgraph] val properties                      = new Array[AnyRef](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val inverseIndices                  = new AtomicReferenceArray[Object](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val nodesArray: Array[Array[GNode]] = makeNodesArray()
  private[flatgraph] val neighbors: Array[AnyRef]        = makeNeighbors()

  private[flatgraph] def nodeCount(kind: Int): Int = {
    assert(kind >= 0 && kind < nodeCountByKind.length, s"invalid nodeKind=$kind; valid values are 0..${nodeCountByKind.length - 1}")
    nodeCountByKind(kind)
  }

  def _nodes(nodeKind: Int): InitNodeIterator[GNode] = {
    if (nodesArray(nodeKind).length == nodeCountByKind(nodeKind)) new InitNodeIteratorArray[GNode](nodesArray(nodeKind))
    else new InitNodeIteratorArrayFiltered[GNode](nodesArray(nodeKind))
  }

  def nodes(label: String): InitNodeIterator[GNode] =
    _nodes(schema.getNodeKindByLabel(label))

  def nodes(labels: String*): Iterator[GNode] =
    labels.iterator.flatMap(nodes)

  def allNodes: Iterator[GNode] =
    nodesArray.iterator.flatMap(_.iterator)

  /** Lookup nodes with a given property value (via index). N.b. currently only supported for String properties. Context: MultiDictIndex
    * requires the key to be a String and this is using reverse indices, i.e. the lookup is from String -> GNode.
    */
  def nodesWithProperty(propertyName: String, value: String): Iterator[GNode] = {
    val propertyKind = schema.getPropertyKindByName(propertyName)
    Range(0, schema.getNumberOfNodeKinds).iterator.flatMap { nodeKind =>
      Accessors.getWithInverseIndex(this, nodeKind, propertyKind, value)
    }
  }

  private def makeNodesArray(): Array[Array[GNode]] = {
    val nodes = new Array[Array[GNode]](nodeKindCount)
    for (nodeKind <- Range(0, nodes.length))
      nodes(nodeKind) = new Array[GNode](0)
    nodes
  }

  private def makeNeighbors() = {
    val neighbors = new Array[AnyRef](nodeKindCount * edgeKindCount * NeighborsSlotSize * NumberOfDirections)
    for {
      nodeKind  <- Range(0, nodeKindCount)
      direction <- Edge.Direction.values
      edgeKind  <- Range(0, edgeKindCount)
      pos             = schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      propertyDefault = schema.allocateEdgeProperty(nodeKind, direction, edgeKind, size = 1)
      value =
        if (propertyDefault == null) null
        else new DefaultValue(propertyDefault(0))
    } neighbors(pos + 2) = value

    neighbors
  }
}

object Graph {
  // Slot size is 3 because we have one pointer to array of quantity array and one pointer to array of
  // neighbors, and one array containing edge properties
  val NeighborsSlotSize  = 3
  val NumberOfDirections = 2
  val PropertySlotSize   = 2
}
