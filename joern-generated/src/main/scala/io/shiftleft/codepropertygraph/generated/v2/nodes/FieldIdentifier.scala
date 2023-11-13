package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait FieldIdentifierEMT extends AnyRef with ExpressionEMT with HasCanonicalNameEMT

trait FieldIdentifierBase extends AbstractNode with ExpressionBase with StaticType[FieldIdentifierEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CANONICAL_NAME", this.canonicalName)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}

object FieldIdentifier {
  val Label = "FIELD_IDENTIFIER"
  object PropertyKinds {
    val ArgumentIndex = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ARGUMENT_INDEX
    val ArgumentName  = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ARGUMENT_NAME
    val CanonicalName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CANONICAL_NAME
    val Code          = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber  = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val LineNumber    = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Order         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
  }
}

class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with FieldIdentifierBase
    with Expression
    with StaticType[FieldIdentifierEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "canonicalName"
      case 3 => "code"
      case 4 => "columnNumber"
      case 5 => "lineNumber"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.canonicalName
      case 3 => this.code
      case 4 => this.columnNumber
      case 5 => this.lineNumber
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "FieldIdentifier"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[FieldIdentifier]
}

object NewFieldIdentifier { def apply(): NewFieldIdentifier = new NewFieldIdentifier }
class NewFieldIdentifier extends NewNode(13.toShort) with FieldIdentifierBase {
  type RelatedStored = FieldIdentifier
  override def label: String                         = "FIELD_IDENTIFIER"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var canonicalName: String                          = "<empty>": String
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def canonicalName(value: String): this.type        = { this.canonicalName = value; this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 5, Iterator(this.canonicalName))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "canonicalName"
      case 3 => "code"
      case 4 => "columnNumber"
      case 5 => "lineNumber"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.canonicalName
      case 3 => this.code
      case 4 => this.columnNumber
      case 5 => this.lineNumber
      case 6 => this.order
      case _ => null
    }

  override def productPrefix                = "NewFieldIdentifier"
  override def productArity                 = 7
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewFieldIdentifier]
}
