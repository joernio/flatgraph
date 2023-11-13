package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait AnnotationParameterAssignEMT extends AnyRef with AstNodeEMT

trait AnnotationParameterAssignBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterAssignEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}

object AnnotationParameterAssign {
  val Label = "ANNOTATION_PARAMETER_ASSIGN"
}

class AnnotationParameterAssign(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 3.toShort, seq_4762)
    with AnnotationParameterAssignBase
    with AstNode
    with StaticType[AnnotationParameterAssignEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.order
      case _ => null
    }

  override def productPrefix = "AnnotationParameterAssign"
  override def productArity  = 4

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[AnnotationParameterAssign]
}

object NewAnnotationParameterAssign { def apply(): NewAnnotationParameterAssign = new NewAnnotationParameterAssign }
class NewAnnotationParameterAssign extends NewNode(3.toShort) with AnnotationParameterAssignBase {
  type RelatedStored = AnnotationParameterAssign
  override def label: String                      = "ANNOTATION_PARAMETER_ASSIGN"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var lineNumber: Option[Int]                     = None
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.order
      case _ => null
    }

  override def productPrefix                = "NewAnnotationParameterAssign"
  override def productArity                 = 4
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewAnnotationParameterAssign]
}
