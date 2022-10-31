package io.joern.odb2

object DefaultValue
final class DefaultValue(val default: Any)
trait Schema {
  def getNumberOfNodeKinds: Int

  def getNumberOfEdgeKinds: Int

  def getNumberOfProperties: Int
  def neighborOffsetArrayIndex(nodeKind: Int, inout: Int, edgeKind: Int): Int = {
    3 * (nodeKind + getNumberOfNodeKinds * (inout + 2 * edgeKind))
  }

  def propertyOffsetArrayIndex(nodeKind: Int, propertyKind: Int): Int = {
    2 * (nodeKind + getNumberOfNodeKinds * propertyKind)
  }

  def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode

  // fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge

  def allocateEdgeProperty(nodeKind: Int, inout: Int, edgeKind: Int, size: Int): Array[_]

  def edgePropertyDefaultValue(nodeKind: Int, inout: Int, edgeKind: Int): DefaultValue

  def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_]
}
