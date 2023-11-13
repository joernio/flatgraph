package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait MethodParameterOutEMT
    extends AnyRef
    with CfgNodeEMT
    with DeclarationEMT
    with HasEvaluationStrategyEMT
    with HasIndexEMT
    with HasIsVariadicEMT
    with HasTypeFullNameEMT
trait MethodParameterOutBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodParameterOutEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res.put("INDEX", this.index)
    res.put("IS_VARIADIC", this.isVariadic)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodParameterOut(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with MethodParameterOutBase
    with CfgNode
    with Declaration
    with StaticType[MethodParameterOutEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "evaluationStrategy"
      case 3 => "index"
      case 4 => "isVariadic"
      case 5 => "lineNumber"
      case 6 => "name"
      case 7 => "order"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.evaluationStrategy
      case 3 => this.index
      case 4 => this.isVariadic
      case 5 => this.lineNumber
      case 6 => this.name
      case 7 => this.order
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "MethodParameterOut"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[MethodParameterOut]
}
object NewMethodParameterOut { def apply(): NewMethodParameterOut = new NewMethodParameterOut }
class NewMethodParameterOut extends NewNode(28.toShort) with MethodParameterOutBase {
  type RelatedStored = MethodParameterOut
  override def label: String                       = "METHOD_PARAMETER_OUT"
  var code: String                                 = "<empty>": String
  var columnNumber: Option[Int]                    = None
  var evaluationStrategy: String                   = "<empty>": String
  var index: Int                                   = -1: Int
  var isVariadic: Boolean                          = false: Boolean
  var lineNumber: Option[Int]                      = None
  var name: String                                 = "<empty>": String
  var order: Int                                   = -1: Int
  var typeFullName: String                         = "<empty>": String
  def code(value: String): this.type               = { this.code = value; this }
  def columnNumber(value: Int): this.type          = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type  = { this.columnNumber = value; this }
  def evaluationStrategy(value: String): this.type = { this.evaluationStrategy = value; this }
  def index(value: Int): this.type                 = { this.index = value; this }
  def isVariadic(value: Boolean): this.type        = { this.isVariadic = value; this }
  def lineNumber(value: Int): this.type            = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type    = { this.lineNumber = value; this }
  def name(value: String): this.type               = { this.name = value; this }
  def order(value: Int): this.type                 = { this.order = value; this }
  def typeFullName(value: String): this.type       = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 19, Iterator(this.evaluationStrategy))
    interface.insertProperty(this, 26, Iterator(this.index))
    interface.insertProperty(this, 30, Iterator(this.isVariadic))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "evaluationStrategy"
      case 3 => "index"
      case 4 => "isVariadic"
      case 5 => "lineNumber"
      case 6 => "name"
      case 7 => "order"
      case 8 => "typeFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.evaluationStrategy
      case 3 => this.index
      case 4 => this.isVariadic
      case 5 => this.lineNumber
      case 6 => this.name
      case 7 => this.order
      case 8 => this.typeFullName
      case _ => null
    }

  override def productPrefix                = "NewMethodParameterOut"
  override def productArity                 = 9
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMethodParameterOut]
}
