package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait TypeRefEMT extends AnyRef with ExpressionEMT with HasDynamicTypeHintFullNameEMT with HasPossibleTypesEMT with HasTypeFullNameEMT
trait TypeRefBase extends AbstractNode with ExpressionBase with StaticType[TypeRefEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class TypeRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 42.toShort, seq_4762)
    with TypeRefBase
    with Expression
    with StaticType[TypeRefEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "dynamicTypeHintFullName"
      case 5 => "lineNumber"
      case 6 => "order"
      case 7 => "possibleTypes"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.dynamicTypeHintFullName
      case 5 => this.lineNumber
      case 6 => this.order
      case 7 => this.possibleTypes
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "TypeRef"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TypeRef]
}
object NewTypeRef { def apply(): NewTypeRef = new NewTypeRef }
class NewTypeRef extends NewNode(42.toShort) with TypeRefBase {
  type RelatedStored = TypeRef
  override def label: String                                          = "TYPE_REF"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "dynamicTypeHintFullName"
      case 5 => "lineNumber"
      case 6 => "order"
      case 7 => "possibleTypes"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.dynamicTypeHintFullName
      case 5 => this.lineNumber
      case 6 => this.order
      case 7 => this.possibleTypes
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix                = "NewTypeRef"
  override def productArity                 = 9
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewTypeRef]
}
