package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait MemberEMT
    extends AnyRef
    with AstNodeEMT
    with DeclarationEMT
    with HasDynamicTypeHintFullNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT

trait MemberBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[MemberEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
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

object Member {
  val Label = "MEMBER"
}

class Member(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with MemberBase
    with AstNode
    with Declaration
    with StaticType[MemberEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "dynamicTypeHintFullName"
      case 3 => "lineNumber"
      case 4 => "name"
      case 5 => "order"
      case 6 => "possibleTypes"
      case 7 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.dynamicTypeHintFullName
      case 3 => this.lineNumber
      case 4 => this.name
      case 5 => this.order
      case 6 => this.possibleTypes
      case 7 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "Member"
  override def productArity  = 8

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Member]
}

object NewMember { def apply(): NewMember = new NewMember }
class NewMember extends NewNode(24.toShort) with MemberBase {
  type RelatedStored = Member
  override def label: String                                          = "MEMBER"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
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
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "dynamicTypeHintFullName"
      case 3 => "lineNumber"
      case 4 => "name"
      case 5 => "order"
      case 6 => "possibleTypes"
      case 7 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.dynamicTypeHintFullName
      case 3 => this.lineNumber
      case 4 => this.name
      case 5 => this.order
      case 6 => this.possibleTypes
      case 7 => this.typeFullName
      case _ => null
    }

  override def productPrefix                = "NewMember"
  override def productArity                 = 8
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMember]
}
