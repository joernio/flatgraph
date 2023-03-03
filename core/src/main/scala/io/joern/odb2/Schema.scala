package io.joern.odb2

object DefaultValue
object NoProperty
final class DefaultValue(val default: Any)
abstract class Schema {
  def getNumberOfNodeKinds: Int
  def getNumberOfEdgeKinds: Int
  def getNodeLabel(nodeKind: Int): String
  def getNodeIdByLabel(label: String): Int

  // So, the issue here is: We have a couple of pseudo-properties that can only exist at a single node kind
  // (theoretically same for edges). We want to allow our data-layout to alias these properties. This means that multiple
  // properties share the same propertyKind / slot. Hence, to go back from id -> label, we also need to know the node-kind.
  def getEdgeLabel(nodeKind: Int, edgeKind: Int): String
  def getEdgeIdByLabel(label: String): Int

  def getPropertyLabel(nodeKind: Int, propertyKind: Int): String
  def getPropertyIdByLabel(label: String): Int

  def getNumberOfProperties: Int
  final def neighborOffsetArrayIndex(nodeKind: Int, inout: Int, edgeKind: Int): Int = {
    3 * (nodeKind + getNumberOfNodeKinds * (inout + 2 * edgeKind))
  }

  final def propertyOffsetArrayIndex(nodeKind: Int, propertyKind: Int): Int = {
    2 * (nodeKind + getNumberOfNodeKinds * propertyKind)
  }

  def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode

  // fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge

  def allocateEdgeProperty(nodeKind: Int, inout: Int, edgeKind: Int, size: Int): Array[_]

  def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_]
}

class FreeSchema(
  val nodeLabels: Array[String],
  val propertyLabels: Array[String],
  val nodePropertyPrototypes: Array[AnyRef],
  val edgeLabels: Array[String],
  val edgePropertyPrototypes: Array[AnyRef]
) extends Schema {
  val nodeMap = nodeLabels.zipWithIndex.toMap
  val propMap = propertyLabels.zipWithIndex.toMap
  val edgeMap = edgeLabels.zipWithIndex.toMap
  private def similar(proto: AnyRef, size: Int): Array[_] = {
    proto match {
      case null              => null
      case a: Array[Boolean] => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Boolean](size)
      case a: Array[Byte]    => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Byte](size)
      case a: Array[Short]   => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Short](size)
      case a: Array[Int]     => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Int](size)
      case a: Array[Long]    => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Long](size)
      case a: Array[Float]   => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Float](size)
      case a: Array[Double]  => if (a.length == 1) Array.fill(size)(a(0)) else new Array[Double](size)
      case a: Array[String]  => if (a.length == 1) Array.fill(size)(a(0)) else new Array[String](size)
      case a: Array[GNode]   => if (a.length == 1) Array.fill(size)(a(0)) else new Array[GNode](size)
      case _                 => ???
    }
  }
  override def getNumberOfNodeKinds: Int                                  = nodeLabels.length
  override def getNumberOfEdgeKinds: Int                                  = edgeLabels.length
  override def getNodeLabel(nodeKind: Int): String                        = nodeLabels(nodeKind)
  override def getNodeIdByLabel(label: String): Int                       = nodeMap.getOrElse(label, -1)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String         = edgeLabels(edgeKind)
  override def getEdgeIdByLabel(label: String): Int                       = edgeMap.getOrElse(label, -1)
  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = propertyLabels(propertyKind)
  override def getPropertyIdByLabel(label: String): Int                   = propMap.getOrElse(label, -1)
  override def getNumberOfProperties: Int                                 = propertyLabels.length
  override def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode   = new GNode(graph, nodeKind, seq)
  override def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge =
    new Edge(src, dst, edgeKind, subSeq, property)
  override def allocateEdgeProperty(nodeKind: Int, inout: Int, edgeKind: Int, size: Int): Array[_] =
    similar(edgePropertyPrototypes(edgeKind), size)
  override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_] =
    similar(nodePropertyPrototypes(propertyKind), size)
}
