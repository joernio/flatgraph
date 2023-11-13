package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait FileEMT extends AnyRef with AstNodeEMT with HasHashEMT with HasNameEMT

trait FileBase extends AbstractNode with AstNodeBase with StaticType[FileEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.hash.foreach { p => res.put("HASH", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}

object File {
  val Label = "FILE"
  object PropertyKinds {
    val Code         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val Hash         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.HASH
    val LineNumber   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Name         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Order        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
  }
}

class File(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 14.toShort, seq_4762)
    with FileBase
    with AstNode
    with StaticType[FileEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "hash"
      case 3 => "lineNumber"
      case 4 => "name"
      case 5 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.hash
      case 3 => this.lineNumber
      case 4 => this.name
      case 5 => this.order
      case _ => null
    }

  override def productPrefix = "File"
  override def productArity  = 6

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[File]
}

object NewFile { def apply(): NewFile = new NewFile }
class NewFile extends NewNode(14.toShort) with FileBase {
  type RelatedStored = File
  override def label: String                      = "FILE"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var hash: Option[String]                        = None
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def hash(value: Option[String]): this.type      = { this.hash = value; this }
  def hash(value: String): this.type              = { this.hash = Option(value); this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (hash.nonEmpty) interface.insertProperty(this, 23, this.hash)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "hash"
      case 3 => "lineNumber"
      case 4 => "name"
      case 5 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.hash
      case 3 => this.lineNumber
      case 4 => this.name
      case 5 => this.order
      case _ => null
    }

  override def productPrefix                = "NewFile"
  override def productArity                 = 6
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewFile]
}
