package io.joern.odb2

import io.joern.odb2.Edge.Direction
import io.joern.odb2.Graph.{NeighborsSlotSize, NumberOfDirections, PropertySlotSize}

import java.util.concurrent.atomic.AtomicReferenceArray

class Graph(val schema: Schema) {
  private val nodeKindCount   = schema.getNumberOfNodeKinds
  private val edgeKindCount   = schema.getNumberOfEdgeKinds
  private val propertiesCount = schema.getNumberOfProperties

  private[odb2] val nodeCountByKind: Array[Int]     = new Array[Int](nodeKindCount)
  private[odb2] val properties                      = new Array[AnyRef](nodeKindCount * propertiesCount * PropertySlotSize)
  private[odb2] val inverseIndices                  = new AtomicReferenceArray[Object](nodeKindCount * propertiesCount * PropertySlotSize)
  private[odb2] val nodesArray: Array[Array[GNode]] = makeNodesArray()
  private[odb2] val neighbors: Array[AnyRef]        = makeNeighbors()

  private[odb2] def nodeCount(kind: Int): Int = {
    assert(kind >= 0 && kind < nodeCountByKind.length, s"invalid nodeKind=$kind; valid values are 0..${nodeCountByKind.length - 1}")
    nodeCountByKind(kind)
  }

  def nodes(nodeKind: Int): misc.InitNodeIterator[GNode] = {
    if (nodesArray(nodeKind).length == nodeCountByKind(nodeKind)) new misc.InitNodeIteratorArray[GNode](nodesArray(nodeKind))
    else new misc.InitNodeIteratorArrayFiltered[GNode](nodesArray(nodeKind))
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
