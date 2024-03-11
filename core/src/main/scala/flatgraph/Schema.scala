package flatgraph

import flatgraph.Edge.Direction

object DefaultValue
object NoProperty
final class DefaultValue(val default: Any)

object Schema {
  val UndefinedKind: Short = -1
}

object FormalQtyType {
  sealed trait FormalQuantity

  object QtyNone extends FormalQuantity

  object QtyOne extends FormalQuantity

  object QtyOption extends FormalQuantity

  object QtyMulti extends FormalQuantity

  sealed trait FormalType {
    def allocate(n: Int): Array[_]
  }

  object NothingType extends FormalType {
    def allocate(n: Int): Array[_] = null
  }

  object BoolType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Boolean](n)
  }
  case class BoolTypeWithDefault(b: Boolean) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }

  object ByteType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Byte](n)
  }

  case class ByteTypeWithDefault(b: Byte) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }

  object ShortType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Short](n)
  }

  case class ShortTypeWithDefault(b: Short) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }

  object IntType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Int](n)
  }

  case class IntTypeWithDefault(b: Int) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }
  object LongType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Long](n)
  }

  case class LongTypeWithDefault(b: Long) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }

  object FloatType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Float](n)
  }

  case class FloatTypeWithDefault(b: Float) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }
  object DoubleType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[Double](n)
  }

  case class DoubleTypeWithDefault(b: Double) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }

  object StringType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[String](n)
  }

  case class StringTypeWithDefault(b: String) extends FormalType {
    override def allocate(n: Int): Array[_] = Array.fill(n)(b)
  }
  object RefType extends FormalType {
    override def allocate(n: Int): Array[_] = new Array[GNode](n)
  }
}

abstract class Schema {
  def getNumberOfNodeKinds: Int
  def getNumberOfEdgeKinds: Int
  def getNodeLabel(nodeKind: Int): String
  def getNodeKindByLabel(label: String): Int

  // So, the issue here is: We have a couple of pseudo-properties that can only exist at a single node kind
  // (theoretically same for edges). We want to allow our data-layout to alias these properties. This means that multiple
  // properties share the same propertyKind / slot. Hence, to go back from kind -> label, we also need to know the node-kind.
  def getEdgeLabel(nodeKind: Int, edgeKind: Int): String
  def getEdgeKindByLabel(label: String): Int

  def getPropertyLabel(nodeKind: Int, propertyKind: Int): String
  def getPropertyKindByName(label: String): Int

  def getNumberOfProperties: Int

  final def neighborOffsetArrayIndex(nodeKind: Int, direction: Edge.Direction, edgeKind: Int): Int = {
    val directionFactor: Int = direction.encoding
    3 * (nodeKind + getNumberOfNodeKinds * (directionFactor + 2 * edgeKind))
  }

  final def propertyOffsetArrayIndex(nodeKind: Int, propertyKind: Int): Int = {
    2 * (nodeKind + getNumberOfNodeKinds * propertyKind)
  }

  def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode

  // fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge

  def allocateEdgeProperty(nodeKind: Int, direction: Direction, edgeKind: Int, size: Int): Array[_]
  def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType
  def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity
  def getNodePropertyDefault(nodeKind: Int, propertyKind: Int): Any
}

class FreeSchema(
  val nodeLabels: Array[String],
  val propertyLabels: Array[String],
  nodePropertyPrototypes: Array[AnyRef],
  val edgeLabels: Array[String],
  edgePropertyPrototypes: Array[AnyRef],
  formalqtys: Array[FormalQtyType.FormalQuantity] = null
) extends Schema {
  val nodeMap = nodeLabels.zipWithIndex.toMap
  val propMap = propertyLabels.zipWithIndex.toMap
  val edgeMap = edgeLabels.zipWithIndex.toMap

  val edgePropertyTypes: Array[FormalQtyType.FormalType] = edgePropertyPrototypes.map(fromPrototype)
  val nodePropertyTypes: Array[FormalQtyType.FormalType] = nodePropertyPrototypes.map(fromPrototype)

  private def fromPrototype(prototype: AnyRef): FormalQtyType.FormalType = prototype match {
    case null              => FormalQtyType.NothingType
    case a: Array[Boolean] => if (a.length == 0) FormalQtyType.BoolType else FormalQtyType.BoolTypeWithDefault(a(0))
    case a: Array[Byte]    => if (a.length == 0) FormalQtyType.ByteType else FormalQtyType.ByteTypeWithDefault(a(0))
    case a: Array[Short]   => if (a.length == 0) FormalQtyType.ShortType else FormalQtyType.ShortTypeWithDefault(a(0))
    case a: Array[Int]     => if (a.length == 0) FormalQtyType.IntType else FormalQtyType.IntTypeWithDefault(a(0))
    case a: Array[Long]    => if (a.length == 0) FormalQtyType.LongType else FormalQtyType.LongTypeWithDefault(a(0))
    case a: Array[Float]   => if (a.length == 0) FormalQtyType.FloatType else FormalQtyType.FloatTypeWithDefault(a(0))
    case a: Array[Double]  => if (a.length == 0) FormalQtyType.DoubleType else FormalQtyType.DoubleTypeWithDefault(a(0))
    case a: Array[String]  => if (a.length == 0) FormalQtyType.StringType else FormalQtyType.StringTypeWithDefault(a(0))
    case a: Array[GNode]   => FormalQtyType.RefType
    case _                 => ???
  }
  override def getNumberOfNodeKinds: Int                                  = nodeLabels.length
  override def getNumberOfEdgeKinds: Int                                  = edgeLabels.length
  override def getNodeLabel(nodeKind: Int): String                        = nodeLabels(nodeKind)
  override def getNodeKindByLabel(label: String): Int                     = nodeMap.getOrElse(label, Schema.UndefinedKind)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String         = edgeLabels(edgeKind)
  override def getEdgeKindByLabel(label: String): Int                     = edgeMap.getOrElse(label, Schema.UndefinedKind)
  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = propertyLabels(propertyKind)
  override def getPropertyKindByName(label: String): Int                  = propMap.getOrElse(label, Schema.UndefinedKind)
  override def getNumberOfProperties: Int                                 = propertyLabels.length
  override def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode   = new GNode(graph, nodeKind, seq)
  override def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge =
    new Edge(src, dst, edgeKind, subSeq, property)

  override def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType = nodePropertyTypes(propertyKind)
  override def allocateEdgeProperty(nodeKind: Int, direction: Direction, edgeKind: Int, size: Int): Array[_] =
    edgePropertyTypes(edgeKind).allocate(size)

  override def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity =
    if (formalqtys == null) getNodePropertyFormalType(nodeKind, propertyKind) match {
      case FormalQtyType.NothingType => FormalQtyType.QtyNone
      case _                         => FormalQtyType.QtyMulti
    }
    else formalqtys(propertyOffsetArrayIndex(nodeKind, propertyKind))

  override def getNodePropertyDefault(nodeKind: Int, propertyKind: Int): Any =
    null

}
