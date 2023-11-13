package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait UnknownEMT
    extends AnyRef
    with ExpressionEMT
    with HasContainedRefEMT
    with HasDynamicTypeHintFullNameEMT
    with HasParserTypeNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait UnknownBase extends AbstractNode with ExpressionBase with StaticType[UnknownEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTAINED_REF", this.containedRef)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Unknown(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with UnknownBase
    with Expression
    with StaticType[UnknownEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "argumentIndex"
      case 1  => "argumentName"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "containedRef"
      case 5  => "dynamicTypeHintFullName"
      case 6  => "lineNumber"
      case 7  => "order"
      case 8  => "parserTypeName"
      case 9  => "possibleTypes"
      case 10 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.argumentIndex
      case 1  => this.argumentName
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.containedRef
      case 5  => this.dynamicTypeHintFullName
      case 6  => this.lineNumber
      case 7  => this.order
      case 8  => this.parserTypeName
      case 9  => this.possibleTypes
      case 10 => this.typeFullName
      case _  => null
    }

  override def productPrefix = "Unknown"
  override def productArity  = 11

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Unknown]
}
object NewUnknown { def apply(): NewUnknown = new NewUnknown }
class NewUnknown extends NewNode(43.toShort) with UnknownBase {
  type RelatedStored = Unknown
  override def label: String                                          = "UNKNOWN"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var containedRef: String                                            = "<empty>": String
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var parserTypeName: String                                          = "<empty>": String
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def containedRef(value: String): this.type                          = { this.containedRef = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def parserTypeName(value: String): this.type                        = { this.parserTypeName = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 13, Iterator(this.containedRef))
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0  => "argumentIndex"
      case 1  => "argumentName"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "containedRef"
      case 5  => "dynamicTypeHintFullName"
      case 6  => "lineNumber"
      case 7  => "order"
      case 8  => "parserTypeName"
      case 9  => "possibleTypes"
      case 10 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.argumentIndex
      case 1  => this.argumentName
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.containedRef
      case 5  => this.dynamicTypeHintFullName
      case 6  => this.lineNumber
      case 7  => this.order
      case 8  => this.parserTypeName
      case 9  => this.possibleTypes
      case 10 => this.typeFullName
      case _  => null
    }

  override def productPrefix                = "NewUnknown"
  override def productArity                 = 11
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewUnknown]
}
