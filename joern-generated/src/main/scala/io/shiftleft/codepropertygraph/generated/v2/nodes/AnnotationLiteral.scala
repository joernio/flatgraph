package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait AnnotationLiteralEMT extends AnyRef with ExpressionEMT with HasNameEMT

trait AnnotationLiteralBase extends AbstractNode with ExpressionBase with StaticType[AnnotationLiteralEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}

object AnnotationLiteral {
  val Label = "ANNOTATION_LITERAL"
}

class AnnotationLiteral(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
    with AnnotationLiteralBase
    with Expression
    with StaticType[AnnotationLiteralEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "AnnotationLiteral"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[AnnotationLiteral]
}

object NewAnnotationLiteral { def apply(): NewAnnotationLiteral = new NewAnnotationLiteral }
class NewAnnotationLiteral extends NewNode(1.toShort) with AnnotationLiteralBase {
  type RelatedStored = AnnotationLiteral
  override def label: String                         = "ANNOTATION_LITERAL"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case _ => null
    }

  override def productPrefix                = "NewAnnotationLiteral"
  override def productArity                 = 7
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewAnnotationLiteral]
}
