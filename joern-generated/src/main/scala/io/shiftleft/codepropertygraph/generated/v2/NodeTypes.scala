package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait AnnotationEMT extends AnyRef with ExpressionEMT with HasFullNameEMT with HasNameEMT
trait AnnotationBase extends AbstractNode with ExpressionBase with StaticType[AnnotationEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("FULL_NAME", this.fullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class Annotation(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with AnnotationBase
    with Expression
    with StaticType[AnnotationEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "fullName"
      case 5 => "lineNumber"
      case 6 => "name"
      case 7 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.fullName
      case 5 => this.lineNumber
      case 6 => this.name
      case 7 => this.order
      case _ => null
    }

  override def productPrefix = "Annotation"
  override def productArity  = 8

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Annotation]
}
object NewAnnotation { def apply(): NewAnnotation = new NewAnnotation }
class NewAnnotation extends NewNode(0.toShort) with AnnotationBase {
  type RelatedStored = Annotation
  override def label: String                         = "ANNOTATION"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var fullName: String                               = "<empty>": String
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def fullName(value: String): this.type             = { this.fullName = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 22, Iterator(this.fullName))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait AnnotationLiteralEMT extends AnyRef with ExpressionEMT with HasNameEMT
trait AnnotationLiteralBase extends AbstractNode with ExpressionBase with StaticType[AnnotationLiteralEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class AnnotationLiteral(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
    with AnnotationLiteralBase
    with Expression
    with StaticType[AnnotationLiteralEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "AnnotationLiteral"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[AnnotationLiteral]
}
object NewAnnotationLiteral { def apply(): NewAnnotationLiteral = new NewAnnotationLiteral }
class NewAnnotationLiteral extends NewNode(1.toShort) with AnnotationLiteralBase {
  type RelatedStored = AnnotationLiteral
  override def label: String                         = "ANNOTATION_LITERAL"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait AnnotationParameterEMT extends AnyRef with AstNodeEMT
trait AnnotationParameterBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterEMT] {

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
class AnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 2.toShort, seq_4762)
    with AnnotationParameterBase
    with AstNode
    with StaticType[AnnotationParameterEMT] {

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

  override def productPrefix = "AnnotationParameter"
  override def productArity  = 4

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[AnnotationParameter]
}
object NewAnnotationParameter { def apply(): NewAnnotationParameter = new NewAnnotationParameter }
class NewAnnotationParameter extends NewNode(2.toShort) with AnnotationParameterBase {
  type RelatedStored = AnnotationParameter
  override def label: String                      = "ANNOTATION_PARAMETER"
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
}

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
}

trait ArrayInitializerEMT extends AnyRef with ExpressionEMT
trait ArrayInitializerBase extends AbstractNode with ExpressionBase with StaticType[ArrayInitializerEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class ArrayInitializer(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 4.toShort, seq_4762)
    with ArrayInitializerBase
    with Expression
    with StaticType[ArrayInitializerEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.order
      case _ => null
    }

  override def productPrefix = "ArrayInitializer"
  override def productArity  = 6

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[ArrayInitializer]
}
object NewArrayInitializer { def apply(): NewArrayInitializer = new NewArrayInitializer }
class NewArrayInitializer extends NewNode(4.toShort) with ArrayInitializerBase {
  type RelatedStored = ArrayInitializer
  override def label: String                         = "ARRAY_INITIALIZER"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait BindingEMT extends AnyRef with HasMethodFullNameEMT with HasNameEMT with HasSignatureEMT
trait BindingBase extends AbstractNode with StaticType[BindingEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("NAME", this.name)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class Binding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 5.toShort, seq_4762)
    with BindingBase
    with StaticType[BindingEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "methodFullName"
      case 1 => "name"
      case 2 => "signature"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.methodFullName
      case 1 => this.name
      case 2 => this.signature
      case _ => null
    }

  override def productPrefix = "Binding"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Binding]
}
object NewBinding { def apply(): NewBinding = new NewBinding }
class NewBinding extends NewNode(5.toShort) with BindingBase {
  type RelatedStored = Binding
  override def label: String                   = "BINDING"
  var methodFullName: String                   = "<empty>": String
  var name: String                             = "<empty>": String
  var signature: String                        = "": String
  def methodFullName(value: String): this.type = { this.methodFullName = value; this }
  def name(value: String): this.type           = { this.name = value; this }
  def signature(value: String): this.type      = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 47, Iterator(this.signature))
  }
}

trait BlockEMT extends AnyRef with ExpressionEMT with HasDynamicTypeHintFullNameEMT with HasPossibleTypesEMT with HasTypeFullNameEMT
trait BlockBase extends AbstractNode with ExpressionBase with StaticType[BlockEMT] {

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
class Block(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 6.toShort, seq_4762)
    with BlockBase
    with Expression
    with StaticType[BlockEMT] {

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

  override def productPrefix = "Block"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Block]
}
object NewBlock { def apply(): NewBlock = new NewBlock }
class NewBlock extends NewNode(6.toShort) with BlockBase {
  type RelatedStored = Block
  override def label: String                                          = "BLOCK"
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
}

trait CallEMT
    extends AnyRef
    with CallReprEMT
    with ExpressionEMT
    with HasDispatchTypeEMT
    with HasDynamicTypeHintFullNameEMT
    with HasMethodFullNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait CallBase extends AbstractNode with CallReprBase with ExpressionBase with StaticType[CallEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DISPATCH_TYPE", this.dispatchType)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("SIGNATURE", this.signature)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Call(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 7.toShort, seq_4762)
    with CallBase
    with CallRepr
    with Expression
    with StaticType[CallEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "argumentIndex"
      case 1  => "argumentName"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "dispatchType"
      case 5  => "dynamicTypeHintFullName"
      case 6  => "lineNumber"
      case 7  => "methodFullName"
      case 8  => "name"
      case 9  => "order"
      case 10 => "possibleTypes"
      case 11 => "signature"
      case 12 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.argumentIndex
      case 1  => this.argumentName
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.dispatchType
      case 5  => this.dynamicTypeHintFullName
      case 6  => this.lineNumber
      case 7  => this.methodFullName
      case 8  => this.name
      case 9  => this.order
      case 10 => this.possibleTypes
      case 11 => this.signature
      case 12 => this.typeFullName
      case _  => null
    }

  override def productPrefix = "Call"
  override def productArity  = 13

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Call]
}
object NewCall { def apply(): NewCall = new NewCall }
class NewCall extends NewNode(7.toShort) with CallBase {
  type RelatedStored = Call
  override def label: String                                          = "CALL"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dispatchType: String                                            = "<empty>": String
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var methodFullName: String                                          = "<empty>": String
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var signature: String                                               = "": String
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dispatchType(value: String): this.type                          = { this.dispatchType = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type                        = { this.methodFullName = value; this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def signature(value: String): this.type                             = { this.signature = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 17, Iterator(this.dispatchType))
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 47, Iterator(this.signature))
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }
}

trait ClosureBindingEMT extends AnyRef with HasClosureBindingIdEMT with HasClosureOriginalNameEMT with HasEvaluationStrategyEMT
trait ClosureBindingBase extends AbstractNode with StaticType[ClosureBindingEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.closureBindingId.foreach { p => res.put("CLOSURE_BINDING_ID", p) }
    this.closureOriginalName.foreach { p => res.put("CLOSURE_ORIGINAL_NAME", p) }
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res
  }
}
class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 8.toShort, seq_4762)
    with ClosureBindingBase
    with StaticType[ClosureBindingEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "closureBindingId"
      case 1 => "closureOriginalName"
      case 2 => "evaluationStrategy"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.closureBindingId
      case 1 => this.closureOriginalName
      case 2 => this.evaluationStrategy
      case _ => null
    }

  override def productPrefix = "ClosureBinding"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[ClosureBinding]
}
object NewClosureBinding { def apply(): NewClosureBinding = new NewClosureBinding }
class NewClosureBinding extends NewNode(8.toShort) with ClosureBindingBase {
  type RelatedStored = ClosureBinding
  override def label: String                                = "CLOSURE_BINDING"
  var closureBindingId: Option[String]                      = None
  var closureOriginalName: Option[String]                   = None
  var evaluationStrategy: String                            = "<empty>": String
  def closureBindingId(value: Option[String]): this.type    = { this.closureBindingId = value; this }
  def closureBindingId(value: String): this.type            = { this.closureBindingId = Option(value); this }
  def closureOriginalName(value: Option[String]): this.type = { this.closureOriginalName = value; this }
  def closureOriginalName(value: String): this.type         = { this.closureOriginalName = Option(value); this }
  def evaluationStrategy(value: String): this.type          = { this.evaluationStrategy = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (closureBindingId.nonEmpty) interface.insertProperty(this, 8, this.closureBindingId)
    if (closureOriginalName.nonEmpty) interface.insertProperty(this, 9, this.closureOriginalName)
    interface.insertProperty(this, 19, Iterator(this.evaluationStrategy))
  }
}

trait CommentEMT extends AnyRef with AstNodeEMT with HasFilenameEMT
trait CommentBase extends AbstractNode with AstNodeBase with StaticType[CommentEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("FILENAME", this.filename)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class Comment(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 9.toShort, seq_4762)
    with CommentBase
    with AstNode
    with StaticType[CommentEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "filename"
      case 3 => "lineNumber"
      case 4 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.filename
      case 3 => this.lineNumber
      case 4 => this.order
      case _ => null
    }

  override def productPrefix = "Comment"
  override def productArity  = 5

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Comment]
}
object NewComment { def apply(): NewComment = new NewComment }
class NewComment extends NewNode(9.toShort) with CommentBase {
  type RelatedStored = Comment
  override def label: String                      = "COMMENT"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var filename: String                            = "<empty>": String
  var lineNumber: Option[Int]                     = None
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def filename(value: String): this.type          = { this.filename = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 21, Iterator(this.filename))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait ConfigFileEMT extends AnyRef with HasContentEMT with HasNameEMT
trait ConfigFileBase extends AbstractNode with StaticType[ConfigFileEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CONTENT", this.content)
    res.put("NAME", this.name)
    res
  }
}
class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 10.toShort, seq_4762)
    with ConfigFileBase
    with StaticType[ConfigFileEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "content"
      case 1 => "name"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.content
      case 1 => this.name
      case _ => null
    }

  override def productPrefix = "ConfigFile"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[ConfigFile]
}
object NewConfigFile { def apply(): NewConfigFile = new NewConfigFile }
class NewConfigFile extends NewNode(10.toShort) with ConfigFileBase {
  type RelatedStored = ConfigFile
  override def label: String            = "CONFIG_FILE"
  var content: String                   = "<empty>": String
  var name: String                      = "<empty>": String
  def content(value: String): this.type = { this.content = value; this }
  def name(value: String): this.type    = { this.name = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 14, Iterator(this.content))
    interface.insertProperty(this, 39, Iterator(this.name))
  }
}

trait ControlStructureEMT extends AnyRef with ExpressionEMT with HasControlStructureTypeEMT with HasParserTypeNameEMT
trait ControlStructureBase extends AbstractNode with ExpressionBase with StaticType[ControlStructureEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTROL_STRUCTURE_TYPE", this.controlStructureType)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}
class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with ControlStructureBase
    with Expression
    with StaticType[ControlStructureEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "controlStructureType"
      case 5 => "lineNumber"
      case 6 => "order"
      case 7 => "parserTypeName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.controlStructureType
      case 5 => this.lineNumber
      case 6 => this.order
      case 7 => this.parserTypeName
      case _ => null
    }

  override def productPrefix = "ControlStructure"
  override def productArity  = 8

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[ControlStructure]
}
object NewControlStructure { def apply(): NewControlStructure = new NewControlStructure }
class NewControlStructure extends NewNode(11.toShort) with ControlStructureBase {
  type RelatedStored = ControlStructure
  override def label: String                         = "CONTROL_STRUCTURE"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var controlStructureType: String                   = "<empty>": String
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  var parserTypeName: String                         = "<empty>": String
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def controlStructureType(value: String): this.type = { this.controlStructureType = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  def parserTypeName(value: String): this.type       = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 15, Iterator(this.controlStructureType))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
  }
}

trait DependencyEMT extends AnyRef with HasDependencyGroupIdEMT with HasNameEMT with HasVersionEMT
trait DependencyBase extends AbstractNode with StaticType[DependencyEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.dependencyGroupId.foreach { p => res.put("DEPENDENCY_GROUP_ID", p) }
    res.put("NAME", this.name)
    res.put("VERSION", this.version)
    res
  }
}
class Dependency(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 12.toShort, seq_4762)
    with DependencyBase
    with StaticType[DependencyEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "dependencyGroupId"
      case 1 => "name"
      case 2 => "version"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.dependencyGroupId
      case 1 => this.name
      case 2 => this.version
      case _ => null
    }

  override def productPrefix = "Dependency"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Dependency]
}
object NewDependency { def apply(): NewDependency = new NewDependency }
class NewDependency extends NewNode(12.toShort) with DependencyBase {
  type RelatedStored = Dependency
  override def label: String                              = "DEPENDENCY"
  var dependencyGroupId: Option[String]                   = None
  var name: String                                        = "<empty>": String
  var version: String                                     = "<empty>": String
  def dependencyGroupId(value: Option[String]): this.type = { this.dependencyGroupId = value; this }
  def dependencyGroupId(value: String): this.type         = { this.dependencyGroupId = Option(value); this }
  def name(value: String): this.type                      = { this.name = value; this }
  def version(value: String): this.type                   = { this.version = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (dependencyGroupId.nonEmpty) interface.insertProperty(this, 16, this.dependencyGroupId)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 52, Iterator(this.version))
  }
}

trait FieldIdentifierEMT extends AnyRef with ExpressionEMT with HasCanonicalNameEMT
trait FieldIdentifierBase extends AbstractNode with ExpressionBase with StaticType[FieldIdentifierEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CANONICAL_NAME", this.canonicalName)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with FieldIdentifierBase
    with Expression
    with StaticType[FieldIdentifierEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "canonicalName"
      case 3 => "code"
      case 4 => "columnNumber"
      case 5 => "lineNumber"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.canonicalName
      case 3 => this.code
      case 4 => this.columnNumber
      case 5 => this.lineNumber
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "FieldIdentifier"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[FieldIdentifier]
}
object NewFieldIdentifier { def apply(): NewFieldIdentifier = new NewFieldIdentifier }
class NewFieldIdentifier extends NewNode(13.toShort) with FieldIdentifierBase {
  type RelatedStored = FieldIdentifier
  override def label: String                         = "FIELD_IDENTIFIER"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var canonicalName: String                          = "<empty>": String
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def canonicalName(value: String): this.type        = { this.canonicalName = value; this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 5, Iterator(this.canonicalName))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

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
}

trait FindingEMT extends AnyRef
trait FindingBase extends AbstractNode with StaticType[FindingEMT] {
  def evidence: IndexedSeq[AbstractNode]
  def keyValuePairs: IndexedSeq[KeyValuePairBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res              = new java.util.HashMap[String, Any]()
    val tmpevidence      = this.evidence; if (tmpevidence.nonEmpty) res.put("evidence", tmpevidence)
    val tmpkeyValuePairs = this.keyValuePairs; if (tmpkeyValuePairs.nonEmpty) res.put("keyValuePairs", tmpkeyValuePairs)
    res
  }
}
class Finding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 15.toShort, seq_4762)
    with FindingBase
    with StaticType[FindingEMT] {
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 53, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 54, seq)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "evidence"
      case 1 => "keyValuePairs"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.evidence
      case 1 => this.keyValuePairs
      case _ => null
    }

  override def productPrefix = "Finding"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Finding]
}
object NewFinding { def apply(): NewFinding = new NewFinding }
class NewFinding extends NewNode(15.toShort) with FindingBase {
  type RelatedStored = Finding
  override def label: String                                          = "FINDING"
  var evidence: IndexedSeq[AbstractNode]                              = ArraySeq.empty
  var keyValuePairs: IndexedSeq[KeyValuePairBase]                     = ArraySeq.empty
  def evidence(value: IterableOnce[AbstractNode]): this.type          = { this.evidence = value.iterator.to(ArraySeq); this }
  def keyValuePairs(value: IterableOnce[KeyValuePairBase]): this.type = { this.keyValuePairs = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (evidence.nonEmpty) interface.insertProperty(this, 53, this.evidence)
    if (keyValuePairs.nonEmpty) interface.insertProperty(this, 54, this.keyValuePairs)
  }
}

trait IdentifierEMT
    extends AnyRef
    with ExpressionEMT
    with HasDynamicTypeHintFullNameEMT
    with HasNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait IdentifierBase extends AbstractNode with ExpressionBase with StaticType[IdentifierEMT] {

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
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 16.toShort, seq_4762)
    with IdentifierBase
    with Expression
    with StaticType[IdentifierEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "dynamicTypeHintFullName"
      case 5 => "lineNumber"
      case 6 => "name"
      case 7 => "order"
      case 8 => "possibleTypes"
      case 9 => "typeFullName"
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
      case 6 => this.name
      case 7 => this.order
      case 8 => this.possibleTypes
      case 9 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "Identifier"
  override def productArity  = 10

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Identifier]
}
object NewIdentifier { def apply(): NewIdentifier = new NewIdentifier }
class NewIdentifier extends NewNode(16.toShort) with IdentifierBase {
  type RelatedStored = Identifier
  override def label: String                                          = "IDENTIFIER"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
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
  def name(value: String): this.type                                  = { this.name = value; this }
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
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }
}

trait ImportEMT
    extends AnyRef
    with AstNodeEMT
    with HasExplicitAsEMT
    with HasImportedAsEMT
    with HasImportedEntityEMT
    with HasIsExplicitEMT
    with HasIsWildcardEMT
trait ImportBase extends AbstractNode with AstNodeBase with StaticType[ImportEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.explicitAs.foreach { p => res.put("EXPLICIT_AS", p) }
    this.importedAs.foreach { p => res.put("IMPORTED_AS", p) }
    this.importedEntity.foreach { p => res.put("IMPORTED_ENTITY", p) }
    this.isExplicit.foreach { p => res.put("IS_EXPLICIT", p) }
    this.isWildcard.foreach { p => res.put("IS_WILDCARD", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class Import(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with ImportBase
    with AstNode
    with StaticType[ImportEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "explicitAs"
      case 3 => "importedAs"
      case 4 => "importedEntity"
      case 5 => "isExplicit"
      case 6 => "isWildcard"
      case 7 => "lineNumber"
      case 8 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.explicitAs
      case 3 => this.importedAs
      case 4 => this.importedEntity
      case 5 => this.isExplicit
      case 6 => this.isWildcard
      case 7 => this.lineNumber
      case 8 => this.order
      case _ => null
    }

  override def productPrefix = "Import"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Import]
}
object NewImport { def apply(): NewImport = new NewImport }
class NewImport extends NewNode(17.toShort) with ImportBase {
  type RelatedStored = Import
  override def label: String                           = "IMPORT"
  var code: String                                     = "<empty>": String
  var columnNumber: Option[Int]                        = None
  var explicitAs: Option[Boolean]                      = None
  var importedAs: Option[String]                       = None
  var importedEntity: Option[String]                   = None
  var isExplicit: Option[Boolean]                      = None
  var isWildcard: Option[Boolean]                      = None
  var lineNumber: Option[Int]                          = None
  var order: Int                                       = -1: Int
  def code(value: String): this.type                   = { this.code = value; this }
  def columnNumber(value: Int): this.type              = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type      = { this.columnNumber = value; this }
  def explicitAs(value: Boolean): this.type            = { this.explicitAs = Option(value); this }
  def explicitAs(value: Option[Boolean]): this.type    = { this.explicitAs = value; this }
  def importedAs(value: Option[String]): this.type     = { this.importedAs = value; this }
  def importedAs(value: String): this.type             = { this.importedAs = Option(value); this }
  def importedEntity(value: Option[String]): this.type = { this.importedEntity = value; this }
  def importedEntity(value: String): this.type         = { this.importedEntity = Option(value); this }
  def isExplicit(value: Boolean): this.type            = { this.isExplicit = Option(value); this }
  def isExplicit(value: Option[Boolean]): this.type    = { this.isExplicit = value; this }
  def isWildcard(value: Boolean): this.type            = { this.isWildcard = Option(value); this }
  def isWildcard(value: Option[Boolean]): this.type    = { this.isWildcard = value; this }
  def lineNumber(value: Int): this.type                = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type        = { this.lineNumber = value; this }
  def order(value: Int): this.type                     = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (explicitAs.nonEmpty) interface.insertProperty(this, 20, this.explicitAs)
    if (importedAs.nonEmpty) interface.insertProperty(this, 24, this.importedAs)
    if (importedEntity.nonEmpty) interface.insertProperty(this, 25, this.importedEntity)
    if (isExplicit.nonEmpty) interface.insertProperty(this, 28, this.isExplicit)
    if (isWildcard.nonEmpty) interface.insertProperty(this, 31, this.isWildcard)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait JumpLabelEMT extends AnyRef with AstNodeEMT with HasNameEMT with HasParserTypeNameEMT
trait JumpLabelBase extends AbstractNode with AstNodeBase with StaticType[JumpLabelEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}
class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 18.toShort, seq_4762)
    with JumpLabelBase
    with AstNode
    with StaticType[JumpLabelEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "lineNumber"
      case 3 => "name"
      case 4 => "order"
      case 5 => "parserTypeName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.lineNumber
      case 3 => this.name
      case 4 => this.order
      case 5 => this.parserTypeName
      case _ => null
    }

  override def productPrefix = "JumpLabel"
  override def productArity  = 6

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[JumpLabel]
}
object NewJumpLabel { def apply(): NewJumpLabel = new NewJumpLabel }
class NewJumpLabel extends NewNode(18.toShort) with JumpLabelBase {
  type RelatedStored = JumpLabel
  override def label: String                      = "JUMP_LABEL"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var parserTypeName: String                      = "<empty>": String
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def parserTypeName(value: String): this.type    = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
  }
}

trait JumpTargetEMT extends AnyRef with CfgNodeEMT with HasArgumentIndexEMT with HasNameEMT with HasParserTypeNameEMT
trait JumpTargetBase extends AbstractNode with CfgNodeBase with StaticType[JumpTargetEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}
class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 19.toShort, seq_4762)
    with JumpTargetBase
    with CfgNode
    with StaticType[JumpTargetEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "code"
      case 2 => "columnNumber"
      case 3 => "lineNumber"
      case 4 => "name"
      case 5 => "order"
      case 6 => "parserTypeName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.code
      case 2 => this.columnNumber
      case 3 => this.lineNumber
      case 4 => this.name
      case 5 => this.order
      case 6 => this.parserTypeName
      case _ => null
    }

  override def productPrefix = "JumpTarget"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[JumpTarget]
}
object NewJumpTarget { def apply(): NewJumpTarget = new NewJumpTarget }
class NewJumpTarget extends NewNode(19.toShort) with JumpTargetBase {
  type RelatedStored = JumpTarget
  override def label: String                      = "JUMP_TARGET"
  var argumentIndex: Int                          = -1: Int
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var parserTypeName: String                      = "<empty>": String
  def argumentIndex(value: Int): this.type        = { this.argumentIndex = value; this }
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def parserTypeName(value: String): this.type    = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
  }
}

trait KeyValuePairEMT extends AnyRef with HasKeyEMT with HasValueEMT
trait KeyValuePairBase extends AbstractNode with StaticType[KeyValuePairEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("KEY", this.key)
    res.put("VALUE", this.value)
    res
  }
}
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 20.toShort, seq_4762)
    with KeyValuePairBase
    with StaticType[KeyValuePairEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "key"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.key
      case 1 => this.value
      case _ => null
    }

  override def productPrefix = "KeyValuePair"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[KeyValuePair]
}
object NewKeyValuePair { def apply(): NewKeyValuePair = new NewKeyValuePair }
class NewKeyValuePair extends NewNode(20.toShort) with KeyValuePairBase {
  type RelatedStored = KeyValuePair
  override def label: String          = "KEY_VALUE_PAIR"
  var key: String                     = "<empty>": String
  var value: String                   = "": String
  def key(value: String): this.type   = { this.key = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 32, Iterator(this.key))
    interface.insertProperty(this, 51, Iterator(this.value))
  }
}

trait LiteralEMT extends AnyRef with ExpressionEMT with HasDynamicTypeHintFullNameEMT with HasPossibleTypesEMT with HasTypeFullNameEMT
trait LiteralBase extends AbstractNode with ExpressionBase with StaticType[LiteralEMT] {

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
class Literal(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 21.toShort, seq_4762)
    with LiteralBase
    with Expression
    with StaticType[LiteralEMT] {

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

  override def productPrefix = "Literal"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Literal]
}
object NewLiteral { def apply(): NewLiteral = new NewLiteral }
class NewLiteral extends NewNode(21.toShort) with LiteralBase {
  type RelatedStored = Literal
  override def label: String                                          = "LITERAL"
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
}

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
}

trait LocationEMT
    extends AnyRef
    with HasClassNameEMT
    with HasClassShortNameEMT
    with HasFilenameEMT
    with HasLineNumberEMT
    with HasMethodFullNameEMT
    with HasMethodShortNameEMT
    with HasNodeLabelEMT
    with HasPackageNameEMT
    with HasSymbolEMT
trait LocationBase extends AbstractNode with StaticType[LocationEMT] {
  def node: Option[AbstractNode]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CLASS_NAME", this.className)
    res.put("CLASS_SHORT_NAME", this.classShortName)
    res.put("FILENAME", this.filename)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("METHOD_SHORT_NAME", this.methodShortName)
    res.put("NODE_LABEL", this.nodeLabel)
    res.put("PACKAGE_NAME", this.packageName)
    res.put("SYMBOL", this.symbol)
    this.node.foreach { p => res.put("node", p) }
    res
  }
}
class Location(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with LocationBase
    with StaticType[LocationEMT] {
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 53, seq)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "className"
      case 1 => "classShortName"
      case 2 => "filename"
      case 3 => "lineNumber"
      case 4 => "methodFullName"
      case 5 => "methodShortName"
      case 6 => "nodeLabel"
      case 7 => "packageName"
      case 8 => "symbol"
      case 9 => "node"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.className
      case 1 => this.classShortName
      case 2 => this.filename
      case 3 => this.lineNumber
      case 4 => this.methodFullName
      case 5 => this.methodShortName
      case 6 => this.nodeLabel
      case 7 => this.packageName
      case 8 => this.symbol
      case 9 => this.node
      case _ => null
    }

  override def productPrefix = "Location"
  override def productArity  = 10

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Location]
}
object NewLocation { def apply(): NewLocation = new NewLocation }
class NewLocation extends NewNode(23.toShort) with LocationBase {
  type RelatedStored = Location
  override def label: String                       = "LOCATION"
  var className: String                            = "<empty>": String
  var classShortName: String                       = "<empty>": String
  var filename: String                             = "<empty>": String
  var lineNumber: Option[Int]                      = None
  var methodFullName: String                       = "<empty>": String
  var methodShortName: String                      = "<empty>": String
  var node: Option[AbstractNode]                   = None
  var nodeLabel: String                            = "<empty>": String
  var packageName: String                          = "<empty>": String
  var symbol: String                               = "<empty>": String
  def className(value: String): this.type          = { this.className = value; this }
  def classShortName(value: String): this.type     = { this.classShortName = value; this }
  def filename(value: String): this.type           = { this.filename = value; this }
  def lineNumber(value: Int): this.type            = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type    = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type     = { this.methodFullName = value; this }
  def methodShortName(value: String): this.type    = { this.methodShortName = value; this }
  def node(value: AbstractNode): this.type         = { this.node = Option(value); this }
  def node(value: Option[AbstractNode]): this.type = { this.node = value; this }
  def nodeLabel(value: String): this.type          = { this.nodeLabel = value; this }
  def packageName(value: String): this.type        = { this.packageName = value; this }
  def symbol(value: String): this.type             = { this.symbol = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 6, Iterator(this.className))
    interface.insertProperty(this, 7, Iterator(this.classShortName))
    interface.insertProperty(this, 21, Iterator(this.filename))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 37, Iterator(this.methodShortName))
    interface.insertProperty(this, 40, Iterator(this.nodeLabel))
    interface.insertProperty(this, 43, Iterator(this.packageName))
    interface.insertProperty(this, 48, Iterator(this.symbol))
    if (node.nonEmpty) interface.insertProperty(this, 53, this.node)
  }
}

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
}

trait MetaDataEMT extends AnyRef with HasHashEMT with HasLanguageEMT with HasOverlaysEMT with HasRootEMT with HasVersionEMT
trait MetaDataBase extends AbstractNode with StaticType[MetaDataEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.hash.foreach { p => res.put("HASH", p) }
    res.put("LANGUAGE", this.language)
    val tmpOverlays = this.overlays; if (tmpOverlays.nonEmpty) res.put("OVERLAYS", tmpOverlays)
    res.put("ROOT", this.root)
    res.put("VERSION", this.version)
    res
  }
}
class MetaData(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 25.toShort, seq_4762)
    with MetaDataBase
    with StaticType[MetaDataEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "hash"
      case 1 => "language"
      case 2 => "overlays"
      case 3 => "root"
      case 4 => "version"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.hash
      case 1 => this.language
      case 2 => this.overlays
      case 3 => this.root
      case 4 => this.version
      case _ => null
    }

  override def productPrefix = "MetaData"
  override def productArity  = 5

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[MetaData]
}
object NewMetaData { def apply(): NewMetaData = new NewMetaData }
class NewMetaData extends NewNode(25.toShort) with MetaDataBase {
  type RelatedStored = MetaData
  override def label: String                           = "META_DATA"
  var hash: Option[String]                             = None
  var language: String                                 = "<empty>": String
  var overlays: IndexedSeq[String]                     = ArraySeq.empty
  var root: String                                     = "<empty>": String
  var version: String                                  = "<empty>": String
  def hash(value: Option[String]): this.type           = { this.hash = value; this }
  def hash(value: String): this.type                   = { this.hash = Option(value); this }
  def language(value: String): this.type               = { this.language = value; this }
  def overlays(value: IterableOnce[String]): this.type = { this.overlays = value.iterator.to(ArraySeq); this }
  def root(value: String): this.type                   = { this.root = value; this }
  def version(value: String): this.type                = { this.version = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (hash.nonEmpty) interface.insertProperty(this, 23, this.hash)
    interface.insertProperty(this, 33, Iterator(this.language))
    if (overlays.nonEmpty) interface.insertProperty(this, 42, this.overlays)
    interface.insertProperty(this, 46, Iterator(this.root))
    interface.insertProperty(this, 52, Iterator(this.version))
  }
}

trait MethodEMT
    extends AnyRef
    with CfgNodeEMT
    with DeclarationEMT
    with HasAstParentFullNameEMT
    with HasAstParentTypeEMT
    with HasColumnNumberEndEMT
    with HasFilenameEMT
    with HasFullNameEMT
    with HasHashEMT
    with HasIsExternalEMT
    with HasLineNumberEndEMT
    with HasSignatureEMT
trait MethodBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("AST_PARENT_FULL_NAME", this.astParentFullName)
    res.put("AST_PARENT_TYPE", this.astParentType)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.columnNumberEnd.foreach { p => res.put("COLUMN_NUMBER_END", p) }
    res.put("FILENAME", this.filename)
    res.put("FULL_NAME", this.fullName)
    this.hash.foreach { p => res.put("HASH", p) }
    res.put("IS_EXTERNAL", this.isExternal)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    this.lineNumberEnd.foreach { p => res.put("LINE_NUMBER_END", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with MethodBase
    with CfgNode
    with Declaration
    with StaticType[MethodEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "astParentFullName"
      case 1  => "astParentType"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "columnNumberEnd"
      case 5  => "filename"
      case 6  => "fullName"
      case 7  => "hash"
      case 8  => "isExternal"
      case 9  => "lineNumber"
      case 10 => "lineNumberEnd"
      case 11 => "name"
      case 12 => "order"
      case 13 => "signature"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.astParentFullName
      case 1  => this.astParentType
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.columnNumberEnd
      case 5  => this.filename
      case 6  => this.fullName
      case 7  => this.hash
      case 8  => this.isExternal
      case 9  => this.lineNumber
      case 10 => this.lineNumberEnd
      case 11 => this.name
      case 12 => this.order
      case 13 => this.signature
      case _  => null
    }

  override def productPrefix = "Method"
  override def productArity  = 14

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Method]
}
object NewMethod { def apply(): NewMethod = new NewMethod }
class NewMethod extends NewNode(26.toShort) with MethodBase {
  type RelatedStored = Method
  override def label: String                         = "METHOD"
  var astParentFullName: String                      = "<empty>": String
  var astParentType: String                          = "<empty>": String
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var columnNumberEnd: Option[Int]                   = None
  var filename: String                               = "<empty>": String
  var fullName: String                               = "<empty>": String
  var hash: Option[String]                           = None
  var isExternal: Boolean                            = false: Boolean
  var lineNumber: Option[Int]                        = None
  var lineNumberEnd: Option[Int]                     = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  var signature: String                              = "": String
  def astParentFullName(value: String): this.type    = { this.astParentFullName = value; this }
  def astParentType(value: String): this.type        = { this.astParentType = value; this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def columnNumberEnd(value: Int): this.type         = { this.columnNumberEnd = Option(value); this }
  def columnNumberEnd(value: Option[Int]): this.type = { this.columnNumberEnd = value; this }
  def filename(value: String): this.type             = { this.filename = value; this }
  def fullName(value: String): this.type             = { this.fullName = value; this }
  def hash(value: Option[String]): this.type         = { this.hash = value; this }
  def hash(value: String): this.type                 = { this.hash = Option(value); this }
  def isExternal(value: Boolean): this.type          = { this.isExternal = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def lineNumberEnd(value: Int): this.type           = { this.lineNumberEnd = Option(value); this }
  def lineNumberEnd(value: Option[Int]): this.type   = { this.lineNumberEnd = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  def signature(value: String): this.type            = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 3, Iterator(this.astParentFullName))
    interface.insertProperty(this, 4, Iterator(this.astParentType))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (columnNumberEnd.nonEmpty) interface.insertProperty(this, 12, this.columnNumberEnd)
    interface.insertProperty(this, 21, Iterator(this.filename))
    interface.insertProperty(this, 22, Iterator(this.fullName))
    if (hash.nonEmpty) interface.insertProperty(this, 23, this.hash)
    interface.insertProperty(this, 29, Iterator(this.isExternal))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    if (lineNumberEnd.nonEmpty) interface.insertProperty(this, 35, this.lineNumberEnd)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 47, Iterator(this.signature))
  }
}

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
}

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
}

trait MethodRefEMT
    extends AnyRef
    with ExpressionEMT
    with HasDynamicTypeHintFullNameEMT
    with HasMethodFullNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait MethodRefBase extends AbstractNode with ExpressionBase with StaticType[MethodRefEMT] {

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
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("ORDER", this.order)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 29.toShort, seq_4762)
    with MethodRefBase
    with Expression
    with StaticType[MethodRefEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "dynamicTypeHintFullName"
      case 5 => "lineNumber"
      case 6 => "methodFullName"
      case 7 => "order"
      case 8 => "possibleTypes"
      case 9 => "typeFullName"
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
      case 6 => this.methodFullName
      case 7 => this.order
      case 8 => this.possibleTypes
      case 9 => this.typeFullName
      case _ => null
    }

  override def productPrefix = "MethodRef"
  override def productArity  = 10

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[MethodRef]
}
object NewMethodRef { def apply(): NewMethodRef = new NewMethodRef }
class NewMethodRef extends NewNode(29.toShort) with MethodRefBase {
  type RelatedStored = MethodRef
  override def label: String                                          = "METHOD_REF"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var methodFullName: String                                          = "<empty>": String
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
  def methodFullName(value: String): this.type                        = { this.methodFullName = value; this }
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
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 41, Iterator(this.order))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }
}

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
}

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
}

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
}

trait NamespaceBlockEMT extends AnyRef with AstNodeEMT with HasFilenameEMT with HasFullNameEMT with HasNameEMT
trait NamespaceBlockBase extends AbstractNode with AstNodeBase with StaticType[NamespaceBlockEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("FILENAME", this.filename)
    res.put("FULL_NAME", this.fullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 33.toShort, seq_4762)
    with NamespaceBlockBase
    with AstNode
    with StaticType[NamespaceBlockEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "filename"
      case 3 => "fullName"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.filename
      case 3 => this.fullName
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "NamespaceBlock"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NamespaceBlock]
}
object NewNamespaceBlock { def apply(): NewNamespaceBlock = new NewNamespaceBlock }
class NewNamespaceBlock extends NewNode(33.toShort) with NamespaceBlockBase {
  type RelatedStored = NamespaceBlock
  override def label: String                      = "NAMESPACE_BLOCK"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var filename: String                            = "<empty>": String
  var fullName: String                            = "<empty>": String
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def filename(value: String): this.type          = { this.filename = value; this }
  def fullName(value: String): this.type          = { this.fullName = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 21, Iterator(this.filename))
    interface.insertProperty(this, 22, Iterator(this.fullName))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait ReturnEMT extends AnyRef with ExpressionEMT
trait ReturnBase extends AbstractNode with ExpressionBase with StaticType[ReturnEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class Return(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 34.toShort, seq_4762)
    with ReturnBase
    with Expression
    with StaticType[ReturnEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.order
      case _ => null
    }

  override def productPrefix = "Return"
  override def productArity  = 6

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Return]
}
object NewReturn { def apply(): NewReturn = new NewReturn }
class NewReturn extends NewNode(34.toShort) with ReturnBase {
  type RelatedStored = Return
  override def label: String                         = "RETURN"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait TagEMT extends AnyRef with HasNameEMT with HasValueEMT
trait TagBase extends AbstractNode with StaticType[TagEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    res.put("VALUE", this.value)
    res
  }
}
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) with TagBase with StaticType[TagEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.value
      case _ => null
    }

  override def productPrefix = "Tag"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Tag]
}
object NewTag { def apply(): NewTag = new NewTag }
class NewTag extends NewNode(35.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String          = "TAG"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 51, Iterator(this.value))
  }
}

trait TagNodePairEMT extends AnyRef
trait TagNodePairBase extends AbstractNode with StaticType[TagNodePairEMT] {
  def node: AbstractNode
  def tag: TagBase
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("node", this.node)
    res.put("tag", this.tag)
    res
  }
}
class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with TagNodePairBase
    with StaticType[TagNodePairEMT] {
  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 54, seq, null: Tag)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "node"
      case 1 => "tag"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.node
      case 1 => this.tag
      case _ => null
    }

  override def productPrefix = "TagNodePair"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TagNodePair]
}
object NewTagNodePair { def apply(): NewTagNodePair = new NewTagNodePair }
class NewTagNodePair extends NewNode(36.toShort) with TagNodePairBase {
  type RelatedStored = TagNodePair
  override def label: String               = "TAG_NODE_PAIR"
  var node: AbstractNode                   = null
  var tag: TagBase                         = null
  def node(value: AbstractNode): this.type = { this.node = value; this }
  def tag(value: TagBase): this.type       = { this.tag = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 53, Iterator(this.node))
    interface.insertProperty(this, 54, Iterator(this.tag))
  }
}

trait TemplateDomEMT extends AnyRef with ExpressionEMT with HasNameEMT
trait TemplateDomBase extends AbstractNode with ExpressionBase with StaticType[TemplateDomEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 37.toShort, seq_4762)
    with TemplateDomBase
    with Expression
    with StaticType[TemplateDomEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "argumentIndex"
      case 1 => "argumentName"
      case 2 => "code"
      case 3 => "columnNumber"
      case 4 => "lineNumber"
      case 5 => "name"
      case 6 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.argumentIndex
      case 1 => this.argumentName
      case 2 => this.code
      case 3 => this.columnNumber
      case 4 => this.lineNumber
      case 5 => this.name
      case 6 => this.order
      case _ => null
    }

  override def productPrefix = "TemplateDom"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TemplateDom]
}
object NewTemplateDom { def apply(): NewTemplateDom = new NewTemplateDom }
class NewTemplateDom extends NewNode(37.toShort) with TemplateDomBase {
  type RelatedStored = TemplateDom
  override def label: String                         = "TEMPLATE_DOM"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait TypeEMT extends AnyRef with HasFullNameEMT with HasNameEMT with HasTypeDeclFullNameEMT
trait TypeBase extends AbstractNode with StaticType[TypeEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("FULL_NAME", this.fullName)
    res.put("NAME", this.name)
    res.put("TYPE_DECL_FULL_NAME", this.typeDeclFullName)
    res
  }
}
class Type(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with TypeBase
    with StaticType[TypeEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "fullName"
      case 1 => "name"
      case 2 => "typeDeclFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.fullName
      case 1 => this.name
      case 2 => this.typeDeclFullName
      case _ => null
    }

  override def productPrefix = "Type"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Type]
}
object NewType { def apply(): NewType = new NewType }
class NewType extends NewNode(38.toShort) with TypeBase {
  type RelatedStored = Type
  override def label: String                     = "TYPE"
  var fullName: String                           = "<empty>": String
  var name: String                               = "<empty>": String
  var typeDeclFullName: String                   = "<empty>": String
  def fullName(value: String): this.type         = { this.fullName = value; this }
  def name(value: String): this.type             = { this.name = value; this }
  def typeDeclFullName(value: String): this.type = { this.typeDeclFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 22, Iterator(this.fullName))
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 49, Iterator(this.typeDeclFullName))
  }
}

trait TypeArgumentEMT extends AnyRef with AstNodeEMT
trait TypeArgumentBase extends AbstractNode with AstNodeBase with StaticType[TypeArgumentEMT] {

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
class TypeArgument(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with TypeArgumentBase
    with AstNode
    with StaticType[TypeArgumentEMT] {

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

  override def productPrefix = "TypeArgument"
  override def productArity  = 4

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TypeArgument]
}
object NewTypeArgument { def apply(): NewTypeArgument = new NewTypeArgument }
class NewTypeArgument extends NewNode(39.toShort) with TypeArgumentBase {
  type RelatedStored = TypeArgument
  override def label: String                      = "TYPE_ARGUMENT"
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
}

trait TypeDeclEMT
    extends AnyRef
    with AstNodeEMT
    with HasAliasTypeFullNameEMT
    with HasAstParentFullNameEMT
    with HasAstParentTypeEMT
    with HasFilenameEMT
    with HasFullNameEMT
    with HasInheritsFromTypeFullNameEMT
    with HasIsExternalEMT
    with HasNameEMT
trait TypeDeclBase extends AbstractNode with AstNodeBase with StaticType[TypeDeclEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.aliasTypeFullName.foreach { p => res.put("ALIAS_TYPE_FULL_NAME", p) }
    res.put("AST_PARENT_FULL_NAME", this.astParentFullName)
    res.put("AST_PARENT_TYPE", this.astParentType)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("FILENAME", this.filename)
    res.put("FULL_NAME", this.fullName)
    val tmpInheritsFromTypeFullName = this.inheritsFromTypeFullName;
    if (tmpInheritsFromTypeFullName.nonEmpty) res.put("INHERITS_FROM_TYPE_FULL_NAME", tmpInheritsFromTypeFullName)
    res.put("IS_EXTERNAL", this.isExternal)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class TypeDecl(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 40.toShort, seq_4762)
    with TypeDeclBase
    with AstNode
    with StaticType[TypeDeclEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "aliasTypeFullName"
      case 1  => "astParentFullName"
      case 2  => "astParentType"
      case 3  => "code"
      case 4  => "columnNumber"
      case 5  => "filename"
      case 6  => "fullName"
      case 7  => "inheritsFromTypeFullName"
      case 8  => "isExternal"
      case 9  => "lineNumber"
      case 10 => "name"
      case 11 => "order"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.aliasTypeFullName
      case 1  => this.astParentFullName
      case 2  => this.astParentType
      case 3  => this.code
      case 4  => this.columnNumber
      case 5  => this.filename
      case 6  => this.fullName
      case 7  => this.inheritsFromTypeFullName
      case 8  => this.isExternal
      case 9  => this.lineNumber
      case 10 => this.name
      case 11 => this.order
      case _  => null
    }

  override def productPrefix = "TypeDecl"
  override def productArity  = 12

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TypeDecl]
}
object NewTypeDecl { def apply(): NewTypeDecl = new NewTypeDecl }
class NewTypeDecl extends NewNode(40.toShort) with TypeDeclBase {
  type RelatedStored = TypeDecl
  override def label: String                              = "TYPE_DECL"
  var aliasTypeFullName: Option[String]                   = None
  var astParentFullName: String                           = "<empty>": String
  var astParentType: String                               = "<empty>": String
  var code: String                                        = "<empty>": String
  var columnNumber: Option[Int]                           = None
  var filename: String                                    = "<empty>": String
  var fullName: String                                    = "<empty>": String
  var inheritsFromTypeFullName: IndexedSeq[String]        = ArraySeq.empty
  var isExternal: Boolean                                 = false: Boolean
  var lineNumber: Option[Int]                             = None
  var name: String                                        = "<empty>": String
  var order: Int                                          = -1: Int
  def aliasTypeFullName(value: Option[String]): this.type = { this.aliasTypeFullName = value; this }
  def aliasTypeFullName(value: String): this.type         = { this.aliasTypeFullName = Option(value); this }
  def astParentFullName(value: String): this.type         = { this.astParentFullName = value; this }
  def astParentType(value: String): this.type             = { this.astParentType = value; this }
  def code(value: String): this.type                      = { this.code = value; this }
  def columnNumber(value: Int): this.type                 = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type         = { this.columnNumber = value; this }
  def filename(value: String): this.type                  = { this.filename = value; this }
  def fullName(value: String): this.type                  = { this.fullName = value; this }
  def inheritsFromTypeFullName(value: IterableOnce[String]): this.type = {
    this.inheritsFromTypeFullName = value.iterator.to(ArraySeq); this
  }
  def isExternal(value: Boolean): this.type     = { this.isExternal = value; this }
  def lineNumber(value: Int): this.type         = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type = { this.lineNumber = value; this }
  def name(value: String): this.type            = { this.name = value; this }
  def order(value: Int): this.type              = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (aliasTypeFullName.nonEmpty) interface.insertProperty(this, 0, this.aliasTypeFullName)
    interface.insertProperty(this, 3, Iterator(this.astParentFullName))
    interface.insertProperty(this, 4, Iterator(this.astParentType))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 21, Iterator(this.filename))
    interface.insertProperty(this, 22, Iterator(this.fullName))
    if (inheritsFromTypeFullName.nonEmpty) interface.insertProperty(this, 27, this.inheritsFromTypeFullName)
    interface.insertProperty(this, 29, Iterator(this.isExternal))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
  }
}

trait TypeParameterEMT extends AnyRef with AstNodeEMT with HasNameEMT
trait TypeParameterBase extends AbstractNode with AstNodeBase with StaticType[TypeParameterEMT] {

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
class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with TypeParameterBase
    with AstNode
    with StaticType[TypeParameterEMT] {

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

  override def productPrefix = "TypeParameter"
  override def productArity  = 5

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[TypeParameter]
}
object NewTypeParameter { def apply(): NewTypeParameter = new NewTypeParameter }
class NewTypeParameter extends NewNode(41.toShort) with TypeParameterBase {
  type RelatedStored = TypeParameter
  override def label: String                      = "TYPE_PARAMETER"
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
}

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
}

trait UnknownEMT
    extends AnyRef
    with ExpressionEMT
    with HasContainedRefEMT
    with HasDynamicTypeHintFullNameEMT
    with HasParserTypeNameEMT
    with HasPossibleTypesEMT
    with HasTypeFullNameEMT
trait UnknownBase extends AbstractNode with ExpressionBase with StaticType[UnknownEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTAINED_REF", this.containedRef)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    val tmpPossibleTypes = this.possibleTypes; if (tmpPossibleTypes.nonEmpty) res.put("POSSIBLE_TYPES", tmpPossibleTypes)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Unknown(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with UnknownBase
    with Expression
    with StaticType[UnknownEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "argumentIndex"
      case 1  => "argumentName"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "containedRef"
      case 5  => "dynamicTypeHintFullName"
      case 6  => "lineNumber"
      case 7  => "order"
      case 8  => "parserTypeName"
      case 9  => "possibleTypes"
      case 10 => "typeFullName"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.argumentIndex
      case 1  => this.argumentName
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.containedRef
      case 5  => this.dynamicTypeHintFullName
      case 6  => this.lineNumber
      case 7  => this.order
      case 8  => this.parserTypeName
      case 9  => this.possibleTypes
      case 10 => this.typeFullName
      case _  => null
    }

  override def productPrefix = "Unknown"
  override def productArity  = 11

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Unknown]
}
object NewUnknown { def apply(): NewUnknown = new NewUnknown }
class NewUnknown extends NewNode(43.toShort) with UnknownBase {
  type RelatedStored = Unknown
  override def label: String                                          = "UNKNOWN"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var containedRef: String                                            = "<empty>": String
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var parserTypeName: String                                          = "<empty>": String
  var possibleTypes: IndexedSeq[String]                               = ArraySeq.empty
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def containedRef(value: String): this.type                          = { this.containedRef = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def parserTypeName(value: String): this.type                        = { this.parserTypeName = value; this }
  def possibleTypes(value: IterableOnce[String]): this.type           = { this.possibleTypes = value.iterator.to(ArraySeq); this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 1, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.insertProperty(this, 2, this.argumentName)
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    interface.insertProperty(this, 13, Iterator(this.containedRef))
    if (dynamicTypeHintFullName.nonEmpty) interface.insertProperty(this, 18, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 44, Iterator(this.parserTypeName))
    if (possibleTypes.nonEmpty) interface.insertProperty(this, 45, this.possibleTypes)
    interface.insertProperty(this, 50, Iterator(this.typeFullName))
  }
}
