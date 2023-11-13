package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait ControlStructureEMT extends AnyRef with ExpressionEMT with HasControlStructureTypeEMT with HasParserTypeNameEMT

trait ControlStructureBase extends AbstractNode with ExpressionBase with StaticType[ControlStructureEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTROL_STRUCTURE_TYPE", this.controlStructureType)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}

object ControlStructure {
  val Label = "CONTROL_STRUCTURE"
}

class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with ControlStructureBase
    with Expression
    with StaticType[ControlStructureEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "controlStructureType"
      case 5 => "lineNumber"
      case 6 => "order"
      case 7 => "parserTypeName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.controlStructureType
      case 5 => this.lineNumber
      case 6 => this.order
      case 7 => this.parserTypeName
      case _ => null
    }

  override def productPrefix = "ControlStructure"
  override def productArity  = 8

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[ControlStructure]
}

object NewControlStructure { def apply(): NewControlStructure = new NewControlStructure }
class NewControlStructure extends NewNode(11.toShort) with ControlStructureBase {
  type RelatedStored = ControlStructure
  override def label: String                         = "CONTROL_STRUCTURE"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var controlStructureType: String                   = "<empty>": String
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  var parserTypeName: String                         = "<empty>": String
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def controlStructureType(value: String): this.type = { this.controlStructureType = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  def parserTypeName(value: String): this.type       = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 15, Iterator(this.controlStructureType))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "controlStructureType"
      case 5 => "lineNumber"
      case 6 => "order"
      case 7 => "parserTypeName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.controlStructureType
      case 5 => this.lineNumber
      case 6 => this.order
      case 7 => this.parserTypeName
      case _ => null
    }

  override def productPrefix                = "NewControlStructure"
  override def productArity                 = 8
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewControlStructure]
}
