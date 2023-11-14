package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait NamespaceEMT extends AnyRef with AstNodeEMT with HasNameEMT

trait NamespaceBase extends AbstractNode with AstNodeBase with StaticType[NamespaceEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}

object Namespace {
  val Label = "NAMESPACE"
  object PropertyKinds {
    val Code         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val LineNumber   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Name         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Order        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
  }
  object PropertyDefaults {
    val Code  = "<empty>"
    val Name  = "<empty>"
    val Order = -1: Int
  }
}

class Namespace(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 32.toShort, seq_4762)
    with NamespaceBase
    with AstNode
    with StaticType[NamespaceEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "name"
      case 4 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.name
      case 4 => this.order
      case _ => null
    }

  override def productPrefix = "Namespace"
  override def productArity  = 5

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Namespace]
}

object NewNamespace { def apply(): NewNamespace = new NewNamespace }
class NewNamespace extends NewNode(32.toShort) with NamespaceBase {
  type RelatedStored = Namespace
  override def label: String                      = "NAMESPACE"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "name"
      case 4 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.name
      case 4 => this.order
      case _ => null
    }

  override def productPrefix                = "NewNamespace"
  override def productArity                 = 5
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNamespace]
}
