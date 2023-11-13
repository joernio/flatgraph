package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait MethodParameterInEMT
    extends AnyRef
    with CfgNodeEMT
    with DeclarationEMT
    with HasDynamicTypeHintFullNameEMT
    with HasEvaluationStrategyEMT
    with HasIndexEMT
    with HasIsVariadicEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait MethodParameterInBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodParameterInEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res.put("INDEX", this.index)
    res.put("IS_VARIADIC", this.isVariadic)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with MethodParameterInBase
    with CfgNode
    with Declaration
    with StaticType[MethodParameterInEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "code"
      case 1  => "columnNumber"
      case 2  => "dynamicTypeHintFullName"
      case 3  => "evaluationStrategy"
      case 4  => "index"
      case 5  => "isVariadic"
      case 6  => "lineNumber"
      case 7  => "name"
      case 8  => "order"
      case 9  => "possibleTypes"
      case 10 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.code
      case 1  => this.columnNumber
      case 2  => this.dynamicTypeHintFullName
      case 3  => this.evaluationStrategy
      case 4  => this.index
      case 5  => this.isVariadic
      case 6  => this.lineNumber
      case 7  => this.name
      case 8  => this.order
      case 9  => this.possibleTypes
      case 10 => this.typeFullName
      case _  => null
    }

  override def productPrefix = "MethodParameterIn"
  override def productArity  = 11

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[MethodParameterIn]
}
object NewMethodParameterIn { def apply(): NewMethodParameterIn = new NewMethodParameterIn }
class NewMethodParameterIn extends NewNode(27.toShort) with MethodParameterInBase {
  type RelatedStored = MethodParameterIn
  override def label: String                                          = "METHOD_PARAMETER_IN"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var evaluationStrategy: String                                      = "<empty>": String
  var index: Int                                                      = -1: Int
  var isVariadic: Boolean                                             = false: Boolean
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def evaluationStrategy(value: String): this.type                    = { this.evaluationStrategy = value; this }
  def index(value: Int): this.type                                    = { this.index = value; this }
  def isVariadic(value: Boolean): this.type                           = { this.isVariadic = value; this }
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
    interface.insertProperty(this, 19, Iterator(this.evaluationStrategy))
    interface.insertProperty(this, 26, Iterator(this.index))
    interface.insertProperty(this, 30, Iterator(this.isVariadic))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0  => "code"
      case 1  => "columnNumber"
      case 2  => "dynamicTypeHintFullName"
      case 3  => "evaluationStrategy"
      case 4  => "index"
      case 5  => "isVariadic"
      case 6  => "lineNumber"
      case 7  => "name"
      case 8  => "order"
      case 9  => "possibleTypes"
      case 10 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.code
      case 1  => this.columnNumber
      case 2  => this.dynamicTypeHintFullName
      case 3  => this.evaluationStrategy
      case 4  => this.index
      case 5  => this.isVariadic
      case 6  => this.lineNumber
      case 7  => this.name
      case 8  => this.order
      case 9  => this.possibleTypes
      case 10 => this.typeFullName
      case _  => null
    }

  override def productPrefix                = "NewMethodParameterIn"
  override def productArity                 = 11
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMethodParameterIn]
}
