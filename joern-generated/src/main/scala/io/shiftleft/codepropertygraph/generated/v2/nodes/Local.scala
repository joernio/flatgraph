package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait LocalEMT
    extends AnyRef
    with AstNodeEMT
    with DeclarationEMT
    with HasClosureBindingIdEMT
    with HasDynamicTypeHintFullNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT

trait LocalBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[LocalEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.closureBindingId.foreach { p => res.put("CLOSURE_BINDING_ID", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}

object Local {
  val Label = "LOCAL"
  object PropertyKinds {
    val ClosureBindingId        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CLOSURE_BINDING_ID
    val Code                    = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber            = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val DynamicTypeHintFullName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.DYNAMIC_TYPE_HINT_FULL_NAME
    val LineNumber              = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Name                    = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Order                   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
    val PossibleTypes           = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.POSSIBLE_TYPES
    val TypeFullName            = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.TYPE_FULL_NAME
  }
}

class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 22.toShort, seq_4762)
    with LocalBase
    with AstNode
    with Declaration
    with StaticType[LocalEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "closureBindingId"
      case 1 => "code"
      case 2 => "columnNumber"
      case 3 => "dynamicTypeHintFullName"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case 7 => "possibleTypes"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.closureBindingId
      case 1 => this.code
      case 2 => this.columnNumber
      case 3 => this.dynamicTypeHintFullName
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case 7 => this.possibleTypes
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "Local"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Local]
}

object NewLocal { def apply(): NewLocal = new NewLocal }
class NewLocal extends NewNode(22.toShort) with LocalBase {
  type RelatedStored = Local
  override def label: String                                          = "LOCAL"
  var closureBindingId: Option[String]                                = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def closureBindingId(value: Option[String]): this.type              = { this.closureBindingId = value; this }
  def closureBindingId(value: String): this.type                      = { this.closureBindingId = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (closureBindingId.nonEmpty) interface.insertProperty(this, 8, this.closureBindingId)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "closureBindingId"
      case 1 => "code"
      case 2 => "columnNumber"
      case 3 => "dynamicTypeHintFullName"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case 7 => "possibleTypes"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.closureBindingId
      case 1 => this.code
      case 2 => this.columnNumber
      case 3 => this.dynamicTypeHintFullName
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case 7 => this.possibleTypes
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix                = "NewLocal"
  override def productArity                 = 9
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewLocal]
}
