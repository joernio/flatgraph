package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait ModifierEMT extends AnyRef with AstNodeEMT with HasModifierTypeEMT

trait ModifierBase extends AbstractNode with AstNodeBase with StaticType[ModifierEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("MODIFIER_TYPE", this.modifierType)
    res.put("ORDER", this.order)
    res
  }
}

object Modifier {
  val Label = "MODIFIER"
  object PropertyKinds {
    val Code         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val LineNumber   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val ModifierType = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.MODIFIER_TYPE
    val Order        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
  }
}

class Modifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with ModifierBase
    with AstNode
    with StaticType[ModifierEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "modifierType"
      case 4 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.modifierType
      case 4 => this.order
      case _ => null
    }

  override def productPrefix = "Modifier"
  override def productArity  = 5

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Modifier]
}

object NewModifier { def apply(): NewModifier = new NewModifier }
class NewModifier extends NewNode(31.toShort) with ModifierBase {
  type RelatedStored = Modifier
  override def label: String                      = "MODIFIER"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var lineNumber: Option[Int]                     = None
  var modifierType: String                        = "<empty>": String
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def modifierType(value: String): this.type      = { this.modifierType = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 38, Iterator(this.modifierType))
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "modifierType"
      case 4 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.modifierType
      case 4 => this.order
      case _ => null
    }

  override def productPrefix                = "NewModifier"
  override def productArity                 = 5
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewModifier]
}
