package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait MethodReturnEMT
    extends AnyRef
    with CfgNodeEMT
    with HasDynamicTypeHintFullNameEMT
    with HasEvaluationStrategyEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT

trait MethodReturnBase extends AbstractNode with CfgNodeBase with StaticType[MethodReturnEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}

object MethodReturn {
  val Label = "METHOD_RETURN"
  object PropertyKinds {
    val Code                    = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber            = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val DynamicTypeHintFullName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.DYNAMIC_TYPE_HINT_FULL_NAME
    val EvaluationStrategy      = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.EVALUATION_STRATEGY
    val LineNumber              = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Order                   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
    val PossibleTypes           = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.POSSIBLE_TYPES
    val TypeFullName            = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.TYPE_FULL_NAME
  }
}

class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 30.toShort, seq_4762)
    with MethodReturnBase
    with CfgNode
    with StaticType[MethodReturnEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "dynamicTypeHintFullName"
      case 3 => "evaluationStrategy"
      case 4 => "lineNumber"
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
      case 3 => this.evaluationStrategy
      case 4 => this.lineNumber
      case 5 => this.order
      case 6 => this.possibleTypes
      case 7 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "MethodReturn"
  override def productArity  = 8

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[MethodReturn]
}

object NewMethodReturn { def apply(): NewMethodReturn = new NewMethodReturn }
class NewMethodReturn extends NewNode(30.toShort) with MethodReturnBase {
  type RelatedStored = MethodReturn
  override def label: String                                          = "METHOD_RETURN"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var evaluationStrategy: String                                      = "<empty>": String
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def evaluationStrategy(value: String): this.type                    = { this.evaluationStrategy = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    interface.insertProperty(this, 19, Iterator(this.evaluationStrategy))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "dynamicTypeHintFullName"
      case 3 => "evaluationStrategy"
      case 4 => "lineNumber"
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
      case 3 => this.evaluationStrategy
      case 4 => this.lineNumber
      case 5 => this.order
      case 6 => this.possibleTypes
      case 7 => this.typeFullName
      case _ => null
    }

  override def productPrefix                = "NewMethodReturn"
  override def productArity                 = 8
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMethodReturn]
}
