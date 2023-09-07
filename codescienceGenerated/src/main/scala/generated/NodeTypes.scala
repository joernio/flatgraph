package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

import scala.collection.immutable.{ArraySeq, IndexedSeq}

trait AnnotationT extends AnyRef with ExpressionT with HasFullNameT with HasNameT
trait AnnotationBase extends AbstractNode with ExpressionBase with StaticType[AnnotationT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("FULL_NAME", this.fullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
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
    with StaticType[AnnotationT] {}
object NewAnnotation             { def apply(): NewAnnotation = new NewAnnotation }
class NewAnnotation extends NewNode(0.toShort) with AnnotationBase {
  type RelatedStored = Annotation
  override def label: String                         = "ANNOTATION"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var fullName: String                               = "<empty>": String
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def fullName(value: String): this.type             = { this.fullName = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait AnnotationLiteralT extends AnyRef with ExpressionT with HasNameT
trait AnnotationLiteralBase extends AbstractNode with ExpressionBase with StaticType[AnnotationLiteralT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
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
    with StaticType[AnnotationLiteralT] {}
object NewAnnotationLiteral             { def apply(): NewAnnotationLiteral = new NewAnnotationLiteral }
class NewAnnotationLiteral extends NewNode(1.toShort) with AnnotationLiteralBase {
  type RelatedStored = AnnotationLiteral
  override def label: String                         = "ANNOTATION_LITERAL"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait AnnotationParameterT extends AnyRef with AstNodeT
trait AnnotationParameterBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterT] {

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
    with StaticType[AnnotationParameterT] {}
object NewAnnotationParameter             { def apply(): NewAnnotationParameter = new NewAnnotationParameter }
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait AnnotationParameterAssignT extends AnyRef with AstNodeT
trait AnnotationParameterAssignBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterAssignT] {

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
    with StaticType[AnnotationParameterAssignT] {}
object NewAnnotationParameterAssign             { def apply(): NewAnnotationParameterAssign = new NewAnnotationParameterAssign }
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait ArrayInitializerT extends AnyRef with ExpressionT
trait ArrayInitializerBase extends AbstractNode with ExpressionBase with StaticType[ArrayInitializerT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class ArrayInitializer(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 4.toShort, seq_4762)
    with ArrayInitializerBase
    with Expression
    with StaticType[ArrayInitializerT] {}
object NewArrayInitializer             { def apply(): NewArrayInitializer = new NewArrayInitializer }
class NewArrayInitializer extends NewNode(4.toShort) with ArrayInitializerBase {
  type RelatedStored = ArrayInitializer
  override def label: String                         = "ARRAY_INITIALIZER"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait BindingT extends AnyRef with HasIsMethodNeverOverriddenT with HasMethodFullNameT with HasNameT with HasSignatureT
trait BindingBase extends AbstractNode with StaticType[BindingT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.isMethodNeverOverridden.foreach { p => res.put("IS_METHOD_NEVER_OVERRIDDEN", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("NAME", this.name)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class Binding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 5.toShort, seq_4762)
    with BindingBase
    with StaticType[BindingT] {}
object NewBinding             { def apply(): NewBinding = new NewBinding }
class NewBinding extends NewNode(5.toShort) with BindingBase {
  type RelatedStored = Binding
  override def label: String                                     = "BINDING"
  var isMethodNeverOverridden: Option[Boolean]                   = None
  var methodFullName: String                                     = "<empty>": String
  var name: String                                               = "<empty>": String
  var signature: String                                          = "": String
  def isMethodNeverOverridden(value: Boolean): this.type         = { this.isMethodNeverOverridden = Option(value); this }
  def isMethodNeverOverridden(value: Option[Boolean]): this.type = { this.isMethodNeverOverridden = value; this }
  def methodFullName(value: String): this.type                   = { this.methodFullName = value; this }
  def name(value: String): this.type                             = { this.name = value; this }
  def signature(value: String): this.type                        = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (isMethodNeverOverridden.nonEmpty) interface.emplaceProperty(this, 44, this.isMethodNeverOverridden)
    interface.emplaceProperty(this, 53, Iterator(this.methodFullName))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 71, Iterator(this.signature))
  }
}

trait BlockT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait BlockBase extends AbstractNode with ExpressionBase with StaticType[BlockT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Block(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 6.toShort, seq_4762)
    with BlockBase
    with Expression
    with StaticType[BlockT] {}
object NewBlock             { def apply(): NewBlock = new NewBlock }
class NewBlock extends NewNode(6.toShort) with BlockBase {
  type RelatedStored = Block
  override def label: String                                          = "BLOCK"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait CallT
    extends AnyRef
    with CallReprT
    with ExpressionT
    with HasDispatchNameT
    with HasDispatchTypeT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasMethodInstFullNameT
    with HasResolvedT
    with HasTypeFullNameT
trait CallBase extends AbstractNode with CallReprBase with ExpressionBase with StaticType[CallT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("DISPATCH_NAME", this.dispatchName)
    res.put("DISPATCH_TYPE", this.dispatchType)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    this.methodInstFullName.foreach { p => res.put("METHOD_INST_FULL_NAME", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    this.resolved.foreach { p => res.put("RESOLVED", p) }
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
    with StaticType[CallT] {}
object NewCall             { def apply(): NewCall = new NewCall }
class NewCall extends NewNode(7.toShort) with CallBase {
  type RelatedStored = Call
  override def label: String                                          = "CALL"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dispatchName: String                                            = "": String
  var dispatchType: String                                            = "<empty>": String
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var methodFullName: String                                          = "<empty>": String
  var methodInstFullName: Option[String]                              = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var resolved: Option[Boolean]                                       = None
  var signature: String                                               = "": String
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dispatchName(value: String): this.type                          = { this.dispatchName = value; this }
  def dispatchType(value: String): this.type                          = { this.dispatchType = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type                        = { this.methodFullName = value; this }
  def methodInstFullName(value: Option[String]): this.type            = { this.methodInstFullName = value; this }
  def methodInstFullName(value: String): this.type                    = { this.methodInstFullName = Option(value); this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def resolved(value: Boolean): this.type                             = { this.resolved = Option(value); this }
  def resolved(value: Option[Boolean]): this.type                     = { this.resolved = value; this }
  def signature(value: String): this.type                             = { this.signature = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 25, Iterator(this.dispatchName))
    interface.emplaceProperty(this, 26, Iterator(this.dispatchType))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 53, Iterator(this.methodFullName))
    if (methodInstFullName.nonEmpty) interface.emplaceProperty(this, 54, this.methodInstFullName)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    if (resolved.nonEmpty) interface.emplaceProperty(this, 68, this.resolved)
    interface.emplaceProperty(this, 71, Iterator(this.signature))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait CallChainT extends AnyRef
trait CallChainBase extends AbstractNode with StaticType[CallChainT] {
  def calls: IndexedSeq[CallBase]
  def methods: IndexedSeq[MethodBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res        = new java.util.HashMap[String, Any]()
    val tmpcalls   = this.calls; if (tmpcalls.nonEmpty) res.put("calls", tmpcalls)
    val tmpmethods = this.methods; if (tmpmethods.nonEmpty) res.put("methods", tmpmethods)
    res
  }
}
class CallChain(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 8.toShort, seq_4762)
    with CallChainBase
    with StaticType[CallChainT] {
  def calls: IndexedSeq[Call]     = odb2.Accessors.getNodePropertyMulti[Call](graph, nodeKind, 84, seq)
  def methods: IndexedSeq[Method] = odb2.Accessors.getNodePropertyMulti[Method](graph, nodeKind, 85, seq)
}
object NewCallChain { def apply(): NewCallChain = new NewCallChain }
class NewCallChain extends NewNode(8.toShort) with CallChainBase {
  type RelatedStored = CallChain
  override def label: String                              = "CALL_CHAIN"
  var calls: IndexedSeq[CallBase]                         = ArraySeq.empty
  var methods: IndexedSeq[MethodBase]                     = ArraySeq.empty
  def calls(value: IterableOnce[CallBase]): this.type     = { this.calls = value.iterator.to(ArraySeq); this }
  def methods(value: IterableOnce[MethodBase]): this.type = { this.methods = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (calls.nonEmpty) interface.emplaceProperty(this, 84, this.calls)
    if (methods.nonEmpty) interface.emplaceProperty(this, 85, this.methods)
  }
}

trait CallSiteT extends AnyRef
trait CallSiteBase extends AbstractNode with StaticType[CallSiteT] {
  def call: CallBase
  def callerMethod: MethodBase
  def method: MethodBase
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("call", this.call)
    res.put("callerMethod", this.callerMethod)
    res.put("method", this.method)
    res
  }
}
class CallSite(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 9.toShort, seq_4762)
    with CallSiteBase
    with StaticType[CallSiteT] {
  def call: Call           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def callerMethod: Method = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Method)
  def method: Method       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
}
object NewCallSite { def apply(): NewCallSite = new NewCallSite }
class NewCallSite extends NewNode(9.toShort) with CallSiteBase {
  type RelatedStored = CallSite
  override def label: String                     = "CALL_SITE"
  var call: CallBase                             = null
  var callerMethod: MethodBase                   = null
  var method: MethodBase                         = null
  def call(value: CallBase): this.type           = { this.call = value; this }
  def callerMethod(value: MethodBase): this.type = { this.callerMethod = value; this }
  def method(value: MethodBase): this.type       = { this.method = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 86, Iterator(this.call))
    interface.emplaceProperty(this, 84, Iterator(this.callerMethod))
    interface.emplaceProperty(this, 85, Iterator(this.method))
  }
}

trait ClosureBindingT extends AnyRef with HasClosureBindingIdT with HasClosureOriginalNameT with HasEvaluationStrategyT
trait ClosureBindingBase extends AbstractNode with StaticType[ClosureBindingT] {

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
    extends StoredNode(graph_4762, 10.toShort, seq_4762)
    with ClosureBindingBase
    with StaticType[ClosureBindingT] {}
object NewClosureBinding             { def apply(): NewClosureBinding = new NewClosureBinding }
class NewClosureBinding extends NewNode(10.toShort) with ClosureBindingBase {
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
    if (closureBindingId.nonEmpty) interface.emplaceProperty(this, 13, this.closureBindingId)
    if (closureOriginalName.nonEmpty) interface.emplaceProperty(this, 14, this.closureOriginalName)
    interface.emplaceProperty(this, 28, Iterator(this.evaluationStrategy))
  }
}

trait CommentT extends AnyRef with AstNodeT with HasFilenameT
trait CommentBase extends AbstractNode with AstNodeBase with StaticType[CommentT] {

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
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with CommentBase
    with AstNode
    with StaticType[CommentT] {}
object NewComment             { def apply(): NewComment = new NewComment }
class NewComment extends NewNode(11.toShort) with CommentBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 32, Iterator(this.filename))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait ConfigFileT extends AnyRef with TrackingPointT with HasContentT with HasNameT
trait ConfigFileBase extends AbstractNode with TrackingPointBase with StaticType[ConfigFileT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    res.put("CONTENT", this.content)
    res.put("NAME", this.name)
    res
  }
}
class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 12.toShort, seq_4762)
    with ConfigFileBase
    with TrackingPoint
    with StaticType[ConfigFileT] {}
object NewConfigFile             { def apply(): NewConfigFile = new NewConfigFile }
class NewConfigFile extends NewNode(12.toShort) with ConfigFileBase {
  type RelatedStored = ConfigFile
  override def label: String            = "CONFIG_FILE"
  var code: String                      = "<empty>": String
  var content: String                   = "<empty>": String
  var name: String                      = "<empty>": String
  def code(value: String): this.type    = { this.code = value; this }
  def content(value: String): this.type = { this.content = value; this }
  def name(value: String): this.type    = { this.name = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    interface.emplaceProperty(this, 19, Iterator(this.content))
    interface.emplaceProperty(this, 58, Iterator(this.name))
  }
}

trait ControlStructureT extends AnyRef with ExpressionT with HasControlStructureTypeT with HasParserTypeNameT
trait ControlStructureBase extends AbstractNode with ExpressionBase with StaticType[ControlStructureT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTROL_STRUCTURE_TYPE", this.controlStructureType)
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}
class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with ControlStructureBase
    with Expression
    with StaticType[ControlStructureT] {}
object NewControlStructure             { def apply(): NewControlStructure = new NewControlStructure }
class NewControlStructure extends NewNode(13.toShort) with ControlStructureBase {
  type RelatedStored = ControlStructure
  override def label: String                         = "CONTROL_STRUCTURE"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var controlStructureType: String                   = "<empty>": String
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
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
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  def parserTypeName(value: String): this.type       = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 20, Iterator(this.controlStructureType))
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 64, Iterator(this.parserTypeName))
  }
}

trait DependencyT extends AnyRef with HasDependencyGroupIdT with HasDependencyTypeT with HasNameT with HasVersionT
trait DependencyBase extends AbstractNode with StaticType[DependencyT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.dependencyGroupId.foreach { p => res.put("DEPENDENCY_GROUP_ID", p) }
    res.put("DEPENDENCY_TYPE", this.dependencyType)
    res.put("NAME", this.name)
    res.put("VERSION", this.version)
    res
  }
}
class Dependency(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 14.toShort, seq_4762)
    with DependencyBase
    with StaticType[DependencyT] {}
object NewDependency             { def apply(): NewDependency = new NewDependency }
class NewDependency extends NewNode(14.toShort) with DependencyBase {
  type RelatedStored = Dependency
  override def label: String                              = "DEPENDENCY"
  var dependencyGroupId: Option[String]                   = None
  var dependencyType: String                              = "<empty>": String
  var name: String                                        = "<empty>": String
  var version: String                                     = "<empty>": String
  def dependencyGroupId(value: Option[String]): this.type = { this.dependencyGroupId = value; this }
  def dependencyGroupId(value: String): this.type         = { this.dependencyGroupId = Option(value); this }
  def dependencyType(value: String): this.type            = { this.dependencyType = value; this }
  def name(value: String): this.type                      = { this.name = value; this }
  def version(value: String): this.type                   = { this.version = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (dependencyGroupId.nonEmpty) interface.emplaceProperty(this, 21, this.dependencyGroupId)
    interface.emplaceProperty(this, 22, Iterator(this.dependencyType))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 83, Iterator(this.version))
  }
}

trait DomAttributeT extends AnyRef with HasNameT with HasValueT
trait DomAttributeBase extends AbstractNode with StaticType[DomAttributeT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    res.put("VALUE", this.value)
    res
  }
}
class DomAttribute(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 15.toShort, seq_4762)
    with DomAttributeBase
    with StaticType[DomAttributeT] {}
object NewDomAttribute             { def apply(): NewDomAttribute = new NewDomAttribute }
class NewDomAttribute extends NewNode(15.toShort) with DomAttributeBase {
  type RelatedStored = DomAttribute
  override def label: String          = "DOM_ATTRIBUTE"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 80, Iterator(this.value))
  }
}

trait DomNodeT extends AnyRef with TrackingPointT with HasColumnNumberT with HasLineNumberT with HasNameT
trait DomNodeBase extends AbstractNode with TrackingPointBase with StaticType[DomNodeT] {
  def attributes: IndexedSeq[DomAttributeBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    val tmpattributes = this.attributes; if (tmpattributes.nonEmpty) res.put("attributes", tmpattributes)
    res
  }
}
class DomNode(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 16.toShort, seq_4762)
    with DomNodeBase
    with TrackingPoint
    with StaticType[DomNodeT] {
  def attributes: IndexedSeq[DomAttribute] = odb2.Accessors.getNodePropertyMulti[DomAttribute](graph, nodeKind, 84, seq)
}
object NewDomNode { def apply(): NewDomNode = new NewDomNode }
class NewDomNode extends NewNode(16.toShort) with DomNodeBase {
  type RelatedStored = DomNode
  override def label: String                                       = "DOM_NODE"
  var attributes: IndexedSeq[DomAttributeBase]                     = ArraySeq.empty
  var code: String                                                 = "<empty>": String
  var columnNumber: Option[Int]                                    = None
  var lineNumber: Option[Int]                                      = None
  var name: String                                                 = "<empty>": String
  def attributes(value: IterableOnce[DomAttributeBase]): this.type = { this.attributes = value.iterator.to(ArraySeq); this }
  def code(value: String): this.type                               = { this.code = value; this }
  def columnNumber(value: Int): this.type                          = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                  = { this.columnNumber = value; this }
  def lineNumber(value: Int): this.type                            = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                    = { this.lineNumber = value; this }
  def name(value: String): this.type                               = { this.name = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    if (attributes.nonEmpty) interface.emplaceProperty(this, 84, this.attributes)
  }
}

trait FieldIdentifierT extends AnyRef with ExpressionT with HasCanonicalNameT
trait FieldIdentifierBase extends AbstractNode with ExpressionBase with StaticType[FieldIdentifierT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CANONICAL_NAME", this.canonicalName)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with FieldIdentifierBase
    with Expression
    with StaticType[FieldIdentifierT] {}
object NewFieldIdentifier             { def apply(): NewFieldIdentifier = new NewFieldIdentifier }
class NewFieldIdentifier extends NewNode(17.toShort) with FieldIdentifierBase {
  type RelatedStored = FieldIdentifier
  override def label: String                         = "FIELD_IDENTIFIER"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var canonicalName: String                          = "<empty>": String
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def canonicalName(value: String): this.type        = { this.canonicalName = value; this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 8, Iterator(this.canonicalName))
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait FileT extends AnyRef with AstNodeT with HasHashT with HasNameT
trait FileBase extends AbstractNode with AstNodeBase with StaticType[FileT] {

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
    extends StoredNode(graph_4762, 18.toShort, seq_4762)
    with FileBase
    with AstNode
    with StaticType[FileT] {}
object NewFile             { def apply(): NewFile = new NewFile }
class NewFile extends NewNode(18.toShort) with FileBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (hash.nonEmpty) interface.emplaceProperty(this, 35, this.hash)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait FindingT extends AnyRef with HasStructuredFingerprintT
trait FindingBase extends AbstractNode with StaticType[FindingT] {
  def evidence: IndexedSeq[AbstractNode]
  def keyValuePairs: IndexedSeq[KeyValuePairBase]
  def rootCauses: IndexedSeq[FindingBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("STRUCTURED_FINGERPRINT", this.structuredFingerprint)
    val tmpevidence      = this.evidence; if (tmpevidence.nonEmpty) res.put("evidence", tmpevidence)
    val tmpkeyValuePairs = this.keyValuePairs; if (tmpkeyValuePairs.nonEmpty) res.put("keyValuePairs", tmpkeyValuePairs)
    val tmprootCauses    = this.rootCauses; if (tmprootCauses.nonEmpty) res.put("rootCauses", tmprootCauses)
    res
  }
}
class Finding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 19.toShort, seq_4762)
    with FindingBase
    with StaticType[FindingT] {
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 84, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 85, seq)
  def rootCauses: IndexedSeq[Finding]         = odb2.Accessors.getNodePropertyMulti[Finding](graph, nodeKind, 86, seq)
}
object NewFinding { def apply(): NewFinding = new NewFinding }
class NewFinding extends NewNode(19.toShort) with FindingBase {
  type RelatedStored = Finding
  override def label: String                                          = "FINDING"
  var evidence: IndexedSeq[AbstractNode]                              = ArraySeq.empty
  var keyValuePairs: IndexedSeq[KeyValuePairBase]                     = ArraySeq.empty
  var rootCauses: IndexedSeq[FindingBase]                             = ArraySeq.empty
  var structuredFingerprint: String                                   = "null": String
  def evidence(value: IterableOnce[AbstractNode]): this.type          = { this.evidence = value.iterator.to(ArraySeq); this }
  def keyValuePairs(value: IterableOnce[KeyValuePairBase]): this.type = { this.keyValuePairs = value.iterator.to(ArraySeq); this }
  def rootCauses(value: IterableOnce[FindingBase]): this.type         = { this.rootCauses = value.iterator.to(ArraySeq); this }
  def structuredFingerprint(value: String): this.type                 = { this.structuredFingerprint = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 75, Iterator(this.structuredFingerprint))
    if (evidence.nonEmpty) interface.emplaceProperty(this, 84, this.evidence)
    if (keyValuePairs.nonEmpty) interface.emplaceProperty(this, 85, this.keyValuePairs)
    if (rootCauses.nonEmpty) interface.emplaceProperty(this, 86, this.rootCauses)
  }
}

trait FlowT extends AnyRef
trait FlowBase extends AbstractNode with StaticType[FlowT] {
  def branchPoints: IndexedSeq[TrackingPointBase]
  def cfgNodes: IndexedSeq[CfgNodeBase]
  def points: IndexedSeq[ProgramPointBase]
  def sink: SinkBase
  def source: SourceBase
  def transformations: IndexedSeq[TransformationBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res             = new java.util.HashMap[String, Any]()
    val tmpbranchPoints = this.branchPoints; if (tmpbranchPoints.nonEmpty) res.put("branchPoints", tmpbranchPoints)
    val tmpcfgNodes     = this.cfgNodes; if (tmpcfgNodes.nonEmpty) res.put("cfgNodes", tmpcfgNodes)
    val tmppoints       = this.points; if (tmppoints.nonEmpty) res.put("points", tmppoints)
    res.put("sink", this.sink)
    res.put("source", this.source)
    val tmptransformations = this.transformations; if (tmptransformations.nonEmpty) res.put("transformations", tmptransformations)
    res
  }
}
class Flow(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 20.toShort, seq_4762)
    with FlowBase
    with StaticType[FlowT] {
  def branchPoints: IndexedSeq[TrackingPoint]     = odb2.Accessors.getNodePropertyMulti[TrackingPoint](graph, nodeKind, 85, seq)
  def cfgNodes: IndexedSeq[CfgNode]               = odb2.Accessors.getNodePropertyMulti[CfgNode](graph, nodeKind, 87, seq)
  def points: IndexedSeq[ProgramPoint]            = odb2.Accessors.getNodePropertyMulti[ProgramPoint](graph, nodeKind, 88, seq)
  def sink: Sink                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def source: Source                              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def transformations: IndexedSeq[Transformation] = odb2.Accessors.getNodePropertyMulti[Transformation](graph, nodeKind, 89, seq)
}
object NewFlow { def apply(): NewFlow = new NewFlow }
class NewFlow extends NewNode(20.toShort) with FlowBase {
  type RelatedStored = Flow
  override def label: String                                              = "FLOW"
  var branchPoints: IndexedSeq[TrackingPointBase]                         = ArraySeq.empty
  var cfgNodes: IndexedSeq[CfgNodeBase]                                   = ArraySeq.empty
  var points: IndexedSeq[ProgramPointBase]                                = ArraySeq.empty
  var sink: SinkBase                                                      = null
  var source: SourceBase                                                  = null
  var transformations: IndexedSeq[TransformationBase]                     = ArraySeq.empty
  def branchPoints(value: IterableOnce[TrackingPointBase]): this.type     = { this.branchPoints = value.iterator.to(ArraySeq); this }
  def cfgNodes(value: IterableOnce[CfgNodeBase]): this.type               = { this.cfgNodes = value.iterator.to(ArraySeq); this }
  def points(value: IterableOnce[ProgramPointBase]): this.type            = { this.points = value.iterator.to(ArraySeq); this }
  def sink(value: SinkBase): this.type                                    = { this.sink = value; this }
  def source(value: SourceBase): this.type                                = { this.source = value; this }
  def transformations(value: IterableOnce[TransformationBase]): this.type = { this.transformations = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (branchPoints.nonEmpty) interface.emplaceProperty(this, 85, this.branchPoints)
    if (cfgNodes.nonEmpty) interface.emplaceProperty(this, 87, this.cfgNodes)
    if (points.nonEmpty) interface.emplaceProperty(this, 88, this.points)
    interface.emplaceProperty(this, 84, Iterator(this.sink))
    interface.emplaceProperty(this, 86, Iterator(this.source))
    if (transformations.nonEmpty) interface.emplaceProperty(this, 89, this.transformations)
  }
}

trait FrameworkT extends AnyRef with HasNameT
trait FrameworkBase extends AbstractNode with StaticType[FrameworkT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    res
  }
}
class Framework(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 21.toShort, seq_4762)
    with FrameworkBase
    with StaticType[FrameworkT] {}
object NewFramework             { def apply(): NewFramework = new NewFramework }
class NewFramework extends NewNode(21.toShort) with FrameworkBase {
  type RelatedStored = Framework
  override def label: String         = "FRAMEWORK"
  var name: String                   = "<empty>": String
  def name(value: String): this.type = { this.name = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 58, Iterator(this.name))
  }
}

trait FrameworkDataT extends AnyRef with HasContentT with HasNameT
trait FrameworkDataBase extends AbstractNode with StaticType[FrameworkDataT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CONTENT", this.content)
    res.put("NAME", this.name)
    res
  }
}
class FrameworkData(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 22.toShort, seq_4762)
    with FrameworkDataBase
    with StaticType[FrameworkDataT] {}
object NewFrameworkData             { def apply(): NewFrameworkData = new NewFrameworkData }
class NewFrameworkData extends NewNode(22.toShort) with FrameworkDataBase {
  type RelatedStored = FrameworkData
  override def label: String            = "FRAMEWORK_DATA"
  var content: String                   = "<empty>": String
  var name: String                      = "<empty>": String
  def content(value: String): this.type = { this.content = value; this }
  def name(value: String): this.type    = { this.name = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 19, Iterator(this.content))
    interface.emplaceProperty(this, 58, Iterator(this.name))
  }
}

trait IdentifierT extends AnyRef with ExpressionT with LocalLikeT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait IdentifierBase extends AbstractNode with ExpressionBase with LocalLikeBase with StaticType[IdentifierT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with IdentifierBase
    with Expression
    with LocalLike
    with StaticType[IdentifierT] {}
object NewIdentifier             { def apply(): NewIdentifier = new NewIdentifier }
class NewIdentifier extends NewNode(23.toShort) with IdentifierBase {
  type RelatedStored = Identifier
  override def label: String                                          = "IDENTIFIER"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait ImplicitCallT extends AnyRef with CallReprT
trait ImplicitCallBase extends AbstractNode with CallReprBase with StaticType[ImplicitCallT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class ImplicitCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with ImplicitCallBase
    with CallRepr
    with StaticType[ImplicitCallT] {}
object NewImplicitCall             { def apply(): NewImplicitCall = new NewImplicitCall }
class NewImplicitCall extends NewNode(24.toShort) with ImplicitCallBase {
  type RelatedStored = ImplicitCall
  override def label: String                      = "IMPLICIT_CALL"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var depthFirstOrder: Int                        = -1: Int
  var internalFlags: Int                          = 0: Int
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var signature: String                           = "": String
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type      = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type        = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def signature(value: String): this.type         = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 71, Iterator(this.signature))
  }
}

trait ImportT
    extends AnyRef
    with AstNodeT
    with HasExplicitAsT
    with HasImportedAsT
    with HasImportedEntityT
    with HasIsExplicitT
    with HasIsWildcardT
trait ImportBase extends AbstractNode with AstNodeBase with StaticType[ImportT] {

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
    extends StoredNode(graph_4762, 25.toShort, seq_4762)
    with ImportBase
    with AstNode
    with StaticType[ImportT] {}
object NewImport             { def apply(): NewImport = new NewImport }
class NewImport extends NewNode(25.toShort) with ImportBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (explicitAs.nonEmpty) interface.emplaceProperty(this, 31, this.explicitAs)
    if (importedAs.nonEmpty) interface.emplaceProperty(this, 37, this.importedAs)
    if (importedEntity.nonEmpty) interface.emplaceProperty(this, 38, this.importedEntity)
    if (isExplicit.nonEmpty) interface.emplaceProperty(this, 42, this.isExplicit)
    if (isWildcard.nonEmpty) interface.emplaceProperty(this, 47, this.isWildcard)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait IoflowT extends AnyRef with HasFingerprintT with HasLiteralsToSinkT with HasMlAssistedT
trait IoflowBase extends AbstractNode with StaticType[IoflowT] {
  def dataTags: IndexedSeq[TagBase]
  def dstTags: IndexedSeq[TagBase]
  def primaryFlow: FlowBase
  def sink: SinkBase
  def sinkDescriptorFlows: IndexedSeq[FlowBase]
  def sinkDescriptorTags: IndexedSeq[TagBase]
  def source: SourceBase
  def sourceDescriptorFlows: IndexedSeq[FlowBase]
  def sourceDescriptorTags: IndexedSeq[TagBase]
  def sourceTags: IndexedSeq[TagBase]
  def transforms: IndexedSeq[TransformBase]
  def triggerMethods: IndexedSeq[MethodBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("FINGERPRINT", this.fingerprint)
    val tmpLiteralsToSink = this.literalsToSink; if (tmpLiteralsToSink.nonEmpty) res.put("LITERALS_TO_SINK", tmpLiteralsToSink)
    res.put("ML_ASSISTED", this.mlAssisted)
    val tmpdataTags = this.dataTags; if (tmpdataTags.nonEmpty) res.put("dataTags", tmpdataTags)
    val tmpdstTags  = this.dstTags; if (tmpdstTags.nonEmpty) res.put("dstTags", tmpdstTags)
    res.put("primaryFlow", this.primaryFlow)
    res.put("sink", this.sink)
    val tmpsinkDescriptorFlows = this.sinkDescriptorFlows;
    if (tmpsinkDescriptorFlows.nonEmpty) res.put("sinkDescriptorFlows", tmpsinkDescriptorFlows)
    val tmpsinkDescriptorTags = this.sinkDescriptorTags;
    if (tmpsinkDescriptorTags.nonEmpty) res.put("sinkDescriptorTags", tmpsinkDescriptorTags)
    res.put("source", this.source)
    val tmpsourceDescriptorFlows = this.sourceDescriptorFlows;
    if (tmpsourceDescriptorFlows.nonEmpty) res.put("sourceDescriptorFlows", tmpsourceDescriptorFlows)
    val tmpsourceDescriptorTags = this.sourceDescriptorTags;
    if (tmpsourceDescriptorTags.nonEmpty) res.put("sourceDescriptorTags", tmpsourceDescriptorTags)
    val tmpsourceTags     = this.sourceTags; if (tmpsourceTags.nonEmpty) res.put("sourceTags", tmpsourceTags)
    val tmptransforms     = this.transforms; if (tmptransforms.nonEmpty) res.put("transforms", tmptransforms)
    val tmptriggerMethods = this.triggerMethods; if (tmptriggerMethods.nonEmpty) res.put("triggerMethods", tmptriggerMethods)
    res
  }
}
class Ioflow(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with IoflowBase
    with StaticType[IoflowT] {
  def dataTags: IndexedSeq[Tag]               = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 85, seq)
  def dstTags: IndexedSeq[Tag]                = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def primaryFlow: Flow                       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 88, seq, null: Flow)
  def sink: Sink                              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def sinkDescriptorFlows: IndexedSeq[Flow]   = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 89, seq)
  def sinkDescriptorTags: IndexedSeq[Tag]     = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 90, seq)
  def source: Source                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def sourceDescriptorFlows: IndexedSeq[Flow] = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 91, seq)
  def sourceDescriptorTags: IndexedSeq[Tag]   = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 92, seq)
  def sourceTags: IndexedSeq[Tag]             = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 93, seq)
  def transforms: IndexedSeq[Transform]       = odb2.Accessors.getNodePropertyMulti[Transform](graph, nodeKind, 94, seq)
  def triggerMethods: IndexedSeq[Method]      = odb2.Accessors.getNodePropertyMulti[Method](graph, nodeKind, 95, seq)
}
object NewIoflow { def apply(): NewIoflow = new NewIoflow }
class NewIoflow extends NewNode(26.toShort) with IoflowBase {
  type RelatedStored = Ioflow
  override def label: String                                          = "IOFLOW"
  var dataTags: IndexedSeq[TagBase]                                   = ArraySeq.empty
  var dstTags: IndexedSeq[TagBase]                                    = ArraySeq.empty
  var fingerprint: String                                             = "<empty>": String
  var literalsToSink: IndexedSeq[String]                              = ArraySeq.empty
  var mlAssisted: Boolean                                             = false: Boolean
  var primaryFlow: FlowBase                                           = null
  var sink: SinkBase                                                  = null
  var sinkDescriptorFlows: IndexedSeq[FlowBase]                       = ArraySeq.empty
  var sinkDescriptorTags: IndexedSeq[TagBase]                         = ArraySeq.empty
  var source: SourceBase                                              = null
  var sourceDescriptorFlows: IndexedSeq[FlowBase]                     = ArraySeq.empty
  var sourceDescriptorTags: IndexedSeq[TagBase]                       = ArraySeq.empty
  var sourceTags: IndexedSeq[TagBase]                                 = ArraySeq.empty
  var transforms: IndexedSeq[TransformBase]                           = ArraySeq.empty
  var triggerMethods: IndexedSeq[MethodBase]                          = ArraySeq.empty
  def dataTags(value: IterableOnce[TagBase]): this.type               = { this.dataTags = value.iterator.to(ArraySeq); this }
  def dstTags(value: IterableOnce[TagBase]): this.type                = { this.dstTags = value.iterator.to(ArraySeq); this }
  def fingerprint(value: String): this.type                           = { this.fingerprint = value; this }
  def literalsToSink(value: IterableOnce[String]): this.type          = { this.literalsToSink = value.iterator.to(ArraySeq); this }
  def mlAssisted(value: Boolean): this.type                           = { this.mlAssisted = value; this }
  def primaryFlow(value: FlowBase): this.type                         = { this.primaryFlow = value; this }
  def sink(value: SinkBase): this.type                                = { this.sink = value; this }
  def sinkDescriptorFlows(value: IterableOnce[FlowBase]): this.type   = { this.sinkDescriptorFlows = value.iterator.to(ArraySeq); this }
  def sinkDescriptorTags(value: IterableOnce[TagBase]): this.type     = { this.sinkDescriptorTags = value.iterator.to(ArraySeq); this }
  def source(value: SourceBase): this.type                            = { this.source = value; this }
  def sourceDescriptorFlows(value: IterableOnce[FlowBase]): this.type = { this.sourceDescriptorFlows = value.iterator.to(ArraySeq); this }
  def sourceDescriptorTags(value: IterableOnce[TagBase]): this.type   = { this.sourceDescriptorTags = value.iterator.to(ArraySeq); this }
  def sourceTags(value: IterableOnce[TagBase]): this.type             = { this.sourceTags = value.iterator.to(ArraySeq); this }
  def transforms(value: IterableOnce[TransformBase]): this.type       = { this.transforms = value.iterator.to(ArraySeq); this }
  def triggerMethods(value: IterableOnce[MethodBase]): this.type      = { this.triggerMethods = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 33, Iterator(this.fingerprint))
    if (literalsToSink.nonEmpty) interface.emplaceProperty(this, 52, this.literalsToSink)
    interface.emplaceProperty(this, 56, Iterator(this.mlAssisted))
    if (dataTags.nonEmpty) interface.emplaceProperty(this, 85, this.dataTags)
    if (dstTags.nonEmpty) interface.emplaceProperty(this, 87, this.dstTags)
    interface.emplaceProperty(this, 88, Iterator(this.primaryFlow))
    interface.emplaceProperty(this, 84, Iterator(this.sink))
    if (sinkDescriptorFlows.nonEmpty) interface.emplaceProperty(this, 89, this.sinkDescriptorFlows)
    if (sinkDescriptorTags.nonEmpty) interface.emplaceProperty(this, 90, this.sinkDescriptorTags)
    interface.emplaceProperty(this, 86, Iterator(this.source))
    if (sourceDescriptorFlows.nonEmpty) interface.emplaceProperty(this, 91, this.sourceDescriptorFlows)
    if (sourceDescriptorTags.nonEmpty) interface.emplaceProperty(this, 92, this.sourceDescriptorTags)
    if (sourceTags.nonEmpty) interface.emplaceProperty(this, 93, this.sourceTags)
    if (transforms.nonEmpty) interface.emplaceProperty(this, 94, this.transforms)
    if (triggerMethods.nonEmpty) interface.emplaceProperty(this, 95, this.triggerMethods)
  }
}

trait JumpLabelT extends AnyRef with AstNodeT with HasNameT with HasParserTypeNameT
trait JumpLabelBase extends AbstractNode with AstNodeBase with StaticType[JumpLabelT] {

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
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with JumpLabelBase
    with AstNode
    with StaticType[JumpLabelT] {}
object NewJumpLabel             { def apply(): NewJumpLabel = new NewJumpLabel }
class NewJumpLabel extends NewNode(27.toShort) with JumpLabelBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 64, Iterator(this.parserTypeName))
  }
}

trait JumpTargetT extends AnyRef with CfgNodeT with HasArgumentIndexT with HasNameT with HasParserTypeNameT
trait JumpTargetBase extends AbstractNode with CfgNodeBase with StaticType[JumpTargetT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res
  }
}
class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with JumpTargetBase
    with CfgNode
    with StaticType[JumpTargetT] {}
object NewJumpTarget             { def apply(): NewJumpTarget = new NewJumpTarget }
class NewJumpTarget extends NewNode(28.toShort) with JumpTargetBase {
  type RelatedStored = JumpTarget
  override def label: String                      = "JUMP_TARGET"
  var argumentIndex: Int                          = -1: Int
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var depthFirstOrder: Int                        = -1: Int
  var internalFlags: Int                          = 0: Int
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var parserTypeName: String                      = "<empty>": String
  def argumentIndex(value: Int): this.type        = { this.argumentIndex = value; this }
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type      = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type        = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def parserTypeName(value: String): this.type    = { this.parserTypeName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 64, Iterator(this.parserTypeName))
  }
}

trait KeyValuePairT extends AnyRef with HasKeyT with HasValueT
trait KeyValuePairBase extends AbstractNode with StaticType[KeyValuePairT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("KEY", this.key)
    res.put("VALUE", this.value)
    res
  }
}
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 29.toShort, seq_4762)
    with KeyValuePairBase
    with StaticType[KeyValuePairT] {}
object NewKeyValuePair             { def apply(): NewKeyValuePair = new NewKeyValuePair }
class NewKeyValuePair extends NewNode(29.toShort) with KeyValuePairBase {
  type RelatedStored = KeyValuePair
  override def label: String          = "KEY_VALUE_PAIR"
  var key: String                     = "<empty>": String
  var value: String                   = "": String
  def key(value: String): this.type   = { this.key = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 48, Iterator(this.key))
    interface.emplaceProperty(this, 80, Iterator(this.value))
  }
}

trait LiteralT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait LiteralBase extends AbstractNode with ExpressionBase with StaticType[LiteralT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Literal(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 30.toShort, seq_4762)
    with LiteralBase
    with Expression
    with StaticType[LiteralT] {}
object NewLiteral             { def apply(): NewLiteral = new NewLiteral }
class NewLiteral extends NewNode(30.toShort) with LiteralBase {
  type RelatedStored = Literal
  override def label: String                                          = "LITERAL"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait LocalT
    extends AnyRef
    with AstNodeT
    with DeclarationT
    with LocalLikeT
    with HasClosureBindingIdT
    with HasDynamicTypeHintFullNameT
    with HasTypeFullNameT
trait LocalBase extends AbstractNode with AstNodeBase with DeclarationBase with LocalLikeBase with StaticType[LocalT] {

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
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with LocalBase
    with AstNode
    with Declaration
    with LocalLike
    with StaticType[LocalT] {}
object NewLocal             { def apply(): NewLocal = new NewLocal }
class NewLocal extends NewNode(31.toShort) with LocalBase {
  type RelatedStored = Local
  override def label: String                                          = "LOCAL"
  var closureBindingId: Option[String]                                = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (closureBindingId.nonEmpty) interface.emplaceProperty(this, 13, this.closureBindingId)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait LocationT
    extends AnyRef
    with HasClassNameT
    with HasClassShortNameT
    with HasFilenameT
    with HasLineNumberT
    with HasMethodFullNameT
    with HasMethodShortNameT
    with HasNodeLabelT
    with HasPackageNameT
    with HasSymbolT
trait LocationBase extends AbstractNode with StaticType[LocationT] {
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
    extends StoredNode(graph_4762, 32.toShort, seq_4762)
    with LocationBase
    with StaticType[LocationT] {
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 84, seq)
}
object NewLocation { def apply(): NewLocation = new NewLocation }
class NewLocation extends NewNode(32.toShort) with LocationBase {
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
    interface.emplaceProperty(this, 11, Iterator(this.className))
    interface.emplaceProperty(this, 12, Iterator(this.classShortName))
    interface.emplaceProperty(this, 32, Iterator(this.filename))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 53, Iterator(this.methodFullName))
    interface.emplaceProperty(this, 55, Iterator(this.methodShortName))
    interface.emplaceProperty(this, 59, Iterator(this.nodeLabel))
    interface.emplaceProperty(this, 62, Iterator(this.packageName))
    interface.emplaceProperty(this, 76, Iterator(this.symbol))
    if (node.nonEmpty) interface.emplaceProperty(this, 84, this.node)
  }
}

trait MatchInfoT extends AnyRef with HasCategoryT with HasPatternT
trait MatchInfoBase extends AbstractNode with StaticType[MatchInfoT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CATEGORY", this.category)
    res.put("PATTERN", this.pattern)
    res
  }
}
class MatchInfo(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 33.toShort, seq_4762)
    with MatchInfoBase
    with StaticType[MatchInfoT] {}
object NewMatchInfo             { def apply(): NewMatchInfo = new NewMatchInfo }
class NewMatchInfo extends NewNode(33.toShort) with MatchInfoBase {
  type RelatedStored = MatchInfo
  override def label: String             = "MATCH_INFO"
  var category: String                   = "<empty>": String
  var pattern: String                    = "<empty>": String
  def category(value: String): this.type = { this.category = value; this }
  def pattern(value: String): this.type  = { this.pattern = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 10, Iterator(this.category))
    interface.emplaceProperty(this, 66, Iterator(this.pattern))
  }
}

trait MemberT extends AnyRef with AstNodeT with DeclarationT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait MemberBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[MemberT] {

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
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Member(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 34.toShort, seq_4762)
    with MemberBase
    with AstNode
    with Declaration
    with StaticType[MemberT] {}
object NewMember             { def apply(): NewMember = new NewMember }
class NewMember extends NewNode(34.toShort) with MemberBase {
  type RelatedStored = Member
  override def label: String                                          = "MEMBER"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait MetaDataT
    extends AnyRef
    with HasHashT
    with HasLanguageT
    with HasOverlaysT
    with HasPolicyDirectoriesT
    with HasRootT
    with HasSpidT
    with HasVersionT
trait MetaDataBase extends AbstractNode with StaticType[MetaDataT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.hash.foreach { p => res.put("HASH", p) }
    res.put("LANGUAGE", this.language)
    val tmpOverlays          = this.overlays; if (tmpOverlays.nonEmpty) res.put("OVERLAYS", tmpOverlays)
    val tmpPolicyDirectories = this.policyDirectories;
    if (tmpPolicyDirectories.nonEmpty) res.put("POLICY_DIRECTORIES", tmpPolicyDirectories)
    res.put("ROOT", this.root)
    this.spid.foreach { p => res.put("SPID", p) }
    res.put("VERSION", this.version)
    res
  }
}
class MetaData(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 35.toShort, seq_4762)
    with MetaDataBase
    with StaticType[MetaDataT] {}
object NewMetaData             { def apply(): NewMetaData = new NewMetaData }
class NewMetaData extends NewNode(35.toShort) with MetaDataBase {
  type RelatedStored = MetaData
  override def label: String                                    = "META_DATA"
  var hash: Option[String]                                      = None
  var language: String                                          = "<empty>": String
  var overlays: IndexedSeq[String]                              = ArraySeq.empty
  var policyDirectories: IndexedSeq[String]                     = ArraySeq.empty
  var root: String                                              = "<empty>": String
  var spid: Option[String]                                      = None
  var version: String                                           = "<empty>": String
  def hash(value: Option[String]): this.type                    = { this.hash = value; this }
  def hash(value: String): this.type                            = { this.hash = Option(value); this }
  def language(value: String): this.type                        = { this.language = value; this }
  def overlays(value: IterableOnce[String]): this.type          = { this.overlays = value.iterator.to(ArraySeq); this }
  def policyDirectories(value: IterableOnce[String]): this.type = { this.policyDirectories = value.iterator.to(ArraySeq); this }
  def root(value: String): this.type                            = { this.root = value; this }
  def spid(value: Option[String]): this.type                    = { this.spid = value; this }
  def spid(value: String): this.type                            = { this.spid = Option(value); this }
  def version(value: String): this.type                         = { this.version = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (hash.nonEmpty) interface.emplaceProperty(this, 35, this.hash)
    interface.emplaceProperty(this, 49, Iterator(this.language))
    if (overlays.nonEmpty) interface.emplaceProperty(this, 61, this.overlays)
    if (policyDirectories.nonEmpty) interface.emplaceProperty(this, 67, this.policyDirectories)
    interface.emplaceProperty(this, 69, Iterator(this.root))
    if (spid.nonEmpty) interface.emplaceProperty(this, 74, this.spid)
    interface.emplaceProperty(this, 83, Iterator(this.version))
  }
}

trait MethodT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasAstParentFullNameT
    with HasAstParentTypeT
    with HasBinarySignatureT
    with HasColumnNumberEndT
    with HasFilenameT
    with HasFullNameT
    with HasHashT
    with HasHasMappingT
    with HasIsExternalT
    with HasLineNumberEndT
    with HasSignatureT
    with HasVarargParameterT
trait MethodBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("AST_PARENT_FULL_NAME", this.astParentFullName)
    res.put("AST_PARENT_TYPE", this.astParentType)
    this.binarySignature.foreach { p => res.put("BINARY_SIGNATURE", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.columnNumberEnd.foreach { p => res.put("COLUMN_NUMBER_END", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("FILENAME", this.filename)
    res.put("FULL_NAME", this.fullName)
    this.hasMapping.foreach { p => res.put("HAS_MAPPING", p) }
    this.hash.foreach { p => res.put("HASH", p) }
    res.put("INTERNAL_FLAGS", this.internalFlags)
    res.put("IS_EXTERNAL", this.isExternal)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    this.lineNumberEnd.foreach { p => res.put("LINE_NUMBER_END", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res.put("VARARG_PARAMETER", this.varargParameter)
    res
  }
}
class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with MethodBase
    with CfgNode
    with Declaration
    with StaticType[MethodT] {}
object NewMethod             { def apply(): NewMethod = new NewMethod }
class NewMethod extends NewNode(36.toShort) with MethodBase {
  type RelatedStored = Method
  override def label: String                            = "METHOD"
  var astParentFullName: String                         = "<empty>": String
  var astParentType: String                             = "<empty>": String
  var binarySignature: Option[String]                   = None
  var code: String                                      = "<empty>": String
  var columnNumber: Option[Int]                         = None
  var columnNumberEnd: Option[Int]                      = None
  var depthFirstOrder: Int                              = -1: Int
  var filename: String                                  = "<empty>": String
  var fullName: String                                  = "<empty>": String
  var hasMapping: Option[Boolean]                       = None
  var hash: Option[String]                              = None
  var internalFlags: Int                                = 0: Int
  var isExternal: Boolean                               = false: Boolean
  var lineNumber: Option[Int]                           = None
  var lineNumberEnd: Option[Int]                        = None
  var name: String                                      = "<empty>": String
  var order: Int                                        = -1: Int
  var signature: String                                 = "": String
  var varargParameter: Int                              = -1: Int
  def astParentFullName(value: String): this.type       = { this.astParentFullName = value; this }
  def astParentType(value: String): this.type           = { this.astParentType = value; this }
  def binarySignature(value: Option[String]): this.type = { this.binarySignature = value; this }
  def binarySignature(value: String): this.type         = { this.binarySignature = Option(value); this }
  def code(value: String): this.type                    = { this.code = value; this }
  def columnNumber(value: Int): this.type               = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type       = { this.columnNumber = value; this }
  def columnNumberEnd(value: Int): this.type            = { this.columnNumberEnd = Option(value); this }
  def columnNumberEnd(value: Option[Int]): this.type    = { this.columnNumberEnd = value; this }
  def depthFirstOrder(value: Int): this.type            = { this.depthFirstOrder = value; this }
  def filename(value: String): this.type                = { this.filename = value; this }
  def fullName(value: String): this.type                = { this.fullName = value; this }
  def hasMapping(value: Boolean): this.type             = { this.hasMapping = Option(value); this }
  def hasMapping(value: Option[Boolean]): this.type     = { this.hasMapping = value; this }
  def hash(value: Option[String]): this.type            = { this.hash = value; this }
  def hash(value: String): this.type                    = { this.hash = Option(value); this }
  def internalFlags(value: Int): this.type              = { this.internalFlags = value; this }
  def isExternal(value: Boolean): this.type             = { this.isExternal = value; this }
  def lineNumber(value: Int): this.type                 = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type         = { this.lineNumber = value; this }
  def lineNumberEnd(value: Int): this.type              = { this.lineNumberEnd = Option(value); this }
  def lineNumberEnd(value: Option[Int]): this.type      = { this.lineNumberEnd = value; this }
  def name(value: String): this.type                    = { this.name = value; this }
  def order(value: Int): this.type                      = { this.order = value; this }
  def signature(value: String): this.type               = { this.signature = value; this }
  def varargParameter(value: Int): this.type            = { this.varargParameter = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 5, Iterator(this.astParentFullName))
    interface.emplaceProperty(this, 6, Iterator(this.astParentType))
    if (binarySignature.nonEmpty) interface.emplaceProperty(this, 7, this.binarySignature)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (columnNumberEnd.nonEmpty) interface.emplaceProperty(this, 17, this.columnNumberEnd)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 32, Iterator(this.filename))
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    if (hasMapping.nonEmpty) interface.emplaceProperty(this, 36, this.hasMapping)
    if (hash.nonEmpty) interface.emplaceProperty(this, 35, this.hash)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    interface.emplaceProperty(this, 43, Iterator(this.isExternal))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    if (lineNumberEnd.nonEmpty) interface.emplaceProperty(this, 51, this.lineNumberEnd)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 71, Iterator(this.signature))
    interface.emplaceProperty(this, 81, Iterator(this.varargParameter))
  }
}

trait MethodInstT extends AnyRef with AstNodeT with HasFullNameT with HasMethodFullNameT with HasNameT with HasSignatureT
trait MethodInstBase extends AbstractNode with AstNodeBase with StaticType[MethodInstT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("FULL_NAME", this.fullName)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class MethodInst(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 37.toShort, seq_4762)
    with MethodInstBase
    with AstNode
    with StaticType[MethodInstT] {}
object NewMethodInst             { def apply(): NewMethodInst = new NewMethodInst }
class NewMethodInst extends NewNode(37.toShort) with MethodInstBase {
  type RelatedStored = MethodInst
  override def label: String                      = "METHOD_INST"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var fullName: String                            = "<empty>": String
  var lineNumber: Option[Int]                     = None
  var methodFullName: String                      = "<empty>": String
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var signature: String                           = "": String
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def fullName(value: String): this.type          = { this.fullName = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type    = { this.methodFullName = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def signature(value: String): this.type         = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 53, Iterator(this.methodFullName))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 71, Iterator(this.signature))
  }
}

trait MethodParameterInT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with LocalLikeT
    with HasDynamicTypeHintFullNameT
    with HasEvaluationStrategyT
    with HasIndexT
    with HasIsVariadicT
    with HasTypeFullNameT
trait MethodParameterInBase
    extends AbstractNode
    with CfgNodeBase
    with DeclarationBase
    with LocalLikeBase
    with StaticType[MethodParameterInT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res.put("INDEX", this.index)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    res.put("IS_VARIADIC", this.isVariadic)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with MethodParameterInBase
    with CfgNode
    with Declaration
    with LocalLike
    with StaticType[MethodParameterInT] {}
object NewMethodParameterIn             { def apply(): NewMethodParameterIn = new NewMethodParameterIn }
class NewMethodParameterIn extends NewNode(38.toShort) with MethodParameterInBase {
  type RelatedStored = MethodParameterIn
  override def label: String                                          = "METHOD_PARAMETER_IN"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var evaluationStrategy: String                                      = "<empty>": String
  var index: Int                                                      = -1: Int
  var internalFlags: Int                                              = 0: Int
  var isVariadic: Boolean                                             = false: Boolean
  var lineNumber: Option[Int]                                         = None
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def evaluationStrategy(value: String): this.type                    = { this.evaluationStrategy = value; this }
  def index(value: Int): this.type                                    = { this.index = value; this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def isVariadic(value: Boolean): this.type                           = { this.isVariadic = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def name(value: String): this.type                                  = { this.name = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 28, Iterator(this.evaluationStrategy))
    interface.emplaceProperty(this, 39, Iterator(this.index))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    interface.emplaceProperty(this, 46, Iterator(this.isVariadic))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait MethodParameterOutT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasEvaluationStrategyT
    with HasIndexT
    with HasIsVariadicT
    with HasTypeFullNameT
trait MethodParameterOutBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodParameterOutT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res.put("INDEX", this.index)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    res.put("IS_VARIADIC", this.isVariadic)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodParameterOut(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with MethodParameterOutBase
    with CfgNode
    with Declaration
    with StaticType[MethodParameterOutT] {}
object NewMethodParameterOut             { def apply(): NewMethodParameterOut = new NewMethodParameterOut }
class NewMethodParameterOut extends NewNode(39.toShort) with MethodParameterOutBase {
  type RelatedStored = MethodParameterOut
  override def label: String                       = "METHOD_PARAMETER_OUT"
  var code: String                                 = "<empty>": String
  var columnNumber: Option[Int]                    = None
  var depthFirstOrder: Int                         = -1: Int
  var evaluationStrategy: String                   = "<empty>": String
  var index: Int                                   = -1: Int
  var internalFlags: Int                           = 0: Int
  var isVariadic: Boolean                          = false: Boolean
  var lineNumber: Option[Int]                      = None
  var name: String                                 = "<empty>": String
  var order: Int                                   = -1: Int
  var typeFullName: String                         = "<empty>": String
  def code(value: String): this.type               = { this.code = value; this }
  def columnNumber(value: Int): this.type          = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type  = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type       = { this.depthFirstOrder = value; this }
  def evaluationStrategy(value: String): this.type = { this.evaluationStrategy = value; this }
  def index(value: Int): this.type                 = { this.index = value; this }
  def internalFlags(value: Int): this.type         = { this.internalFlags = value; this }
  def isVariadic(value: Boolean): this.type        = { this.isVariadic = value; this }
  def lineNumber(value: Int): this.type            = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type    = { this.lineNumber = value; this }
  def name(value: String): this.type               = { this.name = value; this }
  def order(value: Int): this.type                 = { this.order = value; this }
  def typeFullName(value: String): this.type       = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 28, Iterator(this.evaluationStrategy))
    interface.emplaceProperty(this, 39, Iterator(this.index))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    interface.emplaceProperty(this, 46, Iterator(this.isVariadic))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait MethodRefT
    extends AnyRef
    with ExpressionT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasMethodInstFullNameT
    with HasTypeFullNameT
trait MethodRefBase extends AbstractNode with ExpressionBase with StaticType[MethodRefT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    this.methodInstFullName.foreach { p => res.put("METHOD_INST_FULL_NAME", p) }
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 40.toShort, seq_4762)
    with MethodRefBase
    with Expression
    with StaticType[MethodRefT] {}
object NewMethodRef             { def apply(): NewMethodRef = new NewMethodRef }
class NewMethodRef extends NewNode(40.toShort) with MethodRefBase {
  type RelatedStored = MethodRef
  override def label: String                                          = "METHOD_REF"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var methodFullName: String                                          = "<empty>": String
  var methodInstFullName: Option[String]                              = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type                        = { this.methodFullName = value; this }
  def methodInstFullName(value: Option[String]): this.type            = { this.methodInstFullName = value; this }
  def methodInstFullName(value: String): this.type                    = { this.methodInstFullName = Option(value); this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 53, Iterator(this.methodFullName))
    if (methodInstFullName.nonEmpty) interface.emplaceProperty(this, 54, this.methodInstFullName)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait MethodReturnT extends AnyRef with CfgNodeT with HasDynamicTypeHintFullNameT with HasEvaluationStrategyT with HasTypeFullNameT
trait MethodReturnBase extends AbstractNode with CfgNodeBase with StaticType[MethodReturnT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("EVALUATION_STRATEGY", this.evaluationStrategy)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with MethodReturnBase
    with CfgNode
    with StaticType[MethodReturnT] {}
object NewMethodReturn             { def apply(): NewMethodReturn = new NewMethodReturn }
class NewMethodReturn extends NewNode(41.toShort) with MethodReturnBase {
  type RelatedStored = MethodReturn
  override def label: String                                          = "METHOD_RETURN"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var evaluationStrategy: String                                      = "<empty>": String
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def evaluationStrategy(value: String): this.type                    = { this.evaluationStrategy = value; this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 28, Iterator(this.evaluationStrategy))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait MethodSummaryT extends AnyRef with HasBinarySignatureT with HasIsExternalT with HasIsStaticT
trait MethodSummaryBase extends AbstractNode with StaticType[MethodSummaryT] {
  def annotationParameters: IndexedSeq[SpAnnotationParameterBase]
  def method: MethodBase
  def modifiers: IndexedSeq[ModifierBase]
  def outParameters: IndexedSeq[MethodParameterOutBase]
  def outParamTags: IndexedSeq[TagsBase]
  def parameters: IndexedSeq[MethodParameterInBase]
  def paramTags: IndexedSeq[TagsBase]
  def paramTypes: IndexedSeq[TypeBase]
  def returnParameter: MethodReturnBase
  def returnParameterType: TypeBase
  def returnParamTags: IndexedSeq[TagBase]
  def routes: IndexedSeq[RouteBase]
  def tags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.binarySignature.foreach { p => res.put("BINARY_SIGNATURE", p) }
    res.put("IS_EXTERNAL", this.isExternal)
    res.put("IS_STATIC", this.isStatic)
    val tmpannotationParameters = this.annotationParameters;
    if (tmpannotationParameters.nonEmpty) res.put("annotationParameters", tmpannotationParameters)
    res.put("method", this.method)
    val tmpmodifiers     = this.modifiers; if (tmpmodifiers.nonEmpty) res.put("modifiers", tmpmodifiers)
    val tmpoutParameters = this.outParameters; if (tmpoutParameters.nonEmpty) res.put("outParameters", tmpoutParameters)
    val tmpoutParamTags  = this.outParamTags; if (tmpoutParamTags.nonEmpty) res.put("outParamTags", tmpoutParamTags)
    val tmpparameters    = this.parameters; if (tmpparameters.nonEmpty) res.put("parameters", tmpparameters)
    val tmpparamTags     = this.paramTags; if (tmpparamTags.nonEmpty) res.put("paramTags", tmpparamTags)
    val tmpparamTypes    = this.paramTypes; if (tmpparamTypes.nonEmpty) res.put("paramTypes", tmpparamTypes)
    res.put("returnParameter", this.returnParameter)
    res.put("returnParameterType", this.returnParameterType)
    val tmpreturnParamTags = this.returnParamTags; if (tmpreturnParamTags.nonEmpty) res.put("returnParamTags", tmpreturnParamTags)
    val tmproutes          = this.routes; if (tmproutes.nonEmpty) res.put("routes", tmproutes)
    val tmptags            = this.tags; if (tmptags.nonEmpty) res.put("tags", tmptags)
    res
  }
}
class MethodSummary(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 42.toShort, seq_4762)
    with MethodSummaryBase
    with StaticType[MethodSummaryT] {
  def annotationParameters: IndexedSeq[SpAnnotationParameter] =
    odb2.Accessors.getNodePropertyMulti[SpAnnotationParameter](graph, nodeKind, 87, seq)
  def method: Method                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def modifiers: IndexedSeq[Modifier]               = odb2.Accessors.getNodePropertyMulti[Modifier](graph, nodeKind, 88, seq)
  def outParameters: IndexedSeq[MethodParameterOut] = odb2.Accessors.getNodePropertyMulti[MethodParameterOut](graph, nodeKind, 90, seq)
  def outParamTags: IndexedSeq[Tags]                = odb2.Accessors.getNodePropertyMulti[Tags](graph, nodeKind, 89, seq)
  def parameters: IndexedSeq[MethodParameterIn]     = odb2.Accessors.getNodePropertyMulti[MethodParameterIn](graph, nodeKind, 92, seq)
  def paramTags: IndexedSeq[Tags]                   = odb2.Accessors.getNodePropertyMulti[Tags](graph, nodeKind, 84, seq)
  def paramTypes: IndexedSeq[Type]                  = odb2.Accessors.getNodePropertyMulti[Type](graph, nodeKind, 91, seq)
  def returnParameter: MethodReturn                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 94, seq, null: MethodReturn)
  def returnParameterType: Type                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 95, seq, null: Type)
  def returnParamTags: IndexedSeq[Tag]              = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 93, seq)
  def routes: IndexedSeq[Route]                     = odb2.Accessors.getNodePropertyMulti[Route](graph, nodeKind, 96, seq)
  def tags: IndexedSeq[Tag]                         = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}
object NewMethodSummary { def apply(): NewMethodSummary = new NewMethodSummary }
class NewMethodSummary extends NewNode(42.toShort) with MethodSummaryBase {
  type RelatedStored = MethodSummary
  override def label: String                                      = "METHOD_SUMMARY"
  var annotationParameters: IndexedSeq[SpAnnotationParameterBase] = ArraySeq.empty
  var binarySignature: Option[String]                             = None
  var isExternal: Boolean                                         = false: Boolean
  var isStatic: Boolean                                           = false: Boolean
  var method: MethodBase                                          = null
  var modifiers: IndexedSeq[ModifierBase]                         = ArraySeq.empty
  var outParamTags: IndexedSeq[TagsBase]                          = ArraySeq.empty
  var outParameters: IndexedSeq[MethodParameterOutBase]           = ArraySeq.empty
  var paramTags: IndexedSeq[TagsBase]                             = ArraySeq.empty
  var paramTypes: IndexedSeq[TypeBase]                            = ArraySeq.empty
  var parameters: IndexedSeq[MethodParameterInBase]               = ArraySeq.empty
  var returnParamTags: IndexedSeq[TagBase]                        = ArraySeq.empty
  var returnParameter: MethodReturnBase                           = null
  var returnParameterType: TypeBase                               = null
  var routes: IndexedSeq[RouteBase]                               = ArraySeq.empty
  var tags: IndexedSeq[TagBase]                                   = ArraySeq.empty
  def annotationParameters(value: IterableOnce[SpAnnotationParameterBase]): this.type = {
    this.annotationParameters = value.iterator.to(ArraySeq); this
  }
  def binarySignature(value: Option[String]): this.type                     = { this.binarySignature = value; this }
  def binarySignature(value: String): this.type                             = { this.binarySignature = Option(value); this }
  def isExternal(value: Boolean): this.type                                 = { this.isExternal = value; this }
  def isStatic(value: Boolean): this.type                                   = { this.isStatic = value; this }
  def method(value: MethodBase): this.type                                  = { this.method = value; this }
  def modifiers(value: IterableOnce[ModifierBase]): this.type               = { this.modifiers = value.iterator.to(ArraySeq); this }
  def outParamTags(value: IterableOnce[TagsBase]): this.type                = { this.outParamTags = value.iterator.to(ArraySeq); this }
  def outParameters(value: IterableOnce[MethodParameterOutBase]): this.type = { this.outParameters = value.iterator.to(ArraySeq); this }
  def paramTags(value: IterableOnce[TagsBase]): this.type                   = { this.paramTags = value.iterator.to(ArraySeq); this }
  def paramTypes(value: IterableOnce[TypeBase]): this.type                  = { this.paramTypes = value.iterator.to(ArraySeq); this }
  def parameters(value: IterableOnce[MethodParameterInBase]): this.type     = { this.parameters = value.iterator.to(ArraySeq); this }
  def returnParamTags(value: IterableOnce[TagBase]): this.type              = { this.returnParamTags = value.iterator.to(ArraySeq); this }
  def returnParameter(value: MethodReturnBase): this.type                   = { this.returnParameter = value; this }
  def returnParameterType(value: TypeBase): this.type                       = { this.returnParameterType = value; this }
  def routes(value: IterableOnce[RouteBase]): this.type                     = { this.routes = value.iterator.to(ArraySeq); this }
  def tags(value: IterableOnce[TagBase]): this.type                         = { this.tags = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (binarySignature.nonEmpty) interface.emplaceProperty(this, 7, this.binarySignature)
    interface.emplaceProperty(this, 43, Iterator(this.isExternal))
    interface.emplaceProperty(this, 45, Iterator(this.isStatic))
    if (annotationParameters.nonEmpty) interface.emplaceProperty(this, 87, this.annotationParameters)
    interface.emplaceProperty(this, 85, Iterator(this.method))
    if (modifiers.nonEmpty) interface.emplaceProperty(this, 88, this.modifiers)
    if (outParameters.nonEmpty) interface.emplaceProperty(this, 90, this.outParameters)
    if (outParamTags.nonEmpty) interface.emplaceProperty(this, 89, this.outParamTags)
    if (parameters.nonEmpty) interface.emplaceProperty(this, 92, this.parameters)
    if (paramTags.nonEmpty) interface.emplaceProperty(this, 84, this.paramTags)
    if (paramTypes.nonEmpty) interface.emplaceProperty(this, 91, this.paramTypes)
    interface.emplaceProperty(this, 94, Iterator(this.returnParameter))
    interface.emplaceProperty(this, 95, Iterator(this.returnParameterType))
    if (returnParamTags.nonEmpty) interface.emplaceProperty(this, 93, this.returnParamTags)
    if (routes.nonEmpty) interface.emplaceProperty(this, 96, this.routes)
    if (tags.nonEmpty) interface.emplaceProperty(this, 86, this.tags)
  }
}

trait ModifierT extends AnyRef with AstNodeT with HasModifierTypeT
trait ModifierBase extends AbstractNode with AstNodeBase with StaticType[ModifierT] {

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
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with ModifierBase
    with AstNode
    with StaticType[ModifierT] {}
object NewModifier             { def apply(): NewModifier = new NewModifier }
class NewModifier extends NewNode(43.toShort) with ModifierBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 57, Iterator(this.modifierType))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait NamespaceT extends AnyRef with AstNodeT with HasNameT
trait NamespaceBase extends AbstractNode with AstNodeBase with StaticType[NamespaceT] {

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
    extends StoredNode(graph_4762, 44.toShort, seq_4762)
    with NamespaceBase
    with AstNode
    with StaticType[NamespaceT] {}
object NewNamespace             { def apply(): NewNamespace = new NewNamespace }
class NewNamespace extends NewNode(44.toShort) with NamespaceBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait NamespaceBlockT extends AnyRef with AstNodeT with HasFilenameT with HasFullNameT with HasNameT
trait NamespaceBlockBase extends AbstractNode with AstNodeBase with StaticType[NamespaceBlockT] {

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
    extends StoredNode(graph_4762, 45.toShort, seq_4762)
    with NamespaceBlockBase
    with AstNode
    with StaticType[NamespaceBlockT] {}
object NewNamespaceBlock             { def apply(): NewNamespaceBlock = new NewNamespaceBlock }
class NewNamespaceBlock extends NewNode(45.toShort) with NamespaceBlockBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 32, Iterator(this.filename))
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait PackagePrefixT extends AnyRef with HasValueT
trait PackagePrefixBase extends AbstractNode with StaticType[PackagePrefixT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("VALUE", this.value)
    res
  }
}
class PackagePrefix(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 46.toShort, seq_4762)
    with PackagePrefixBase
    with StaticType[PackagePrefixT] {}
object NewPackagePrefix             { def apply(): NewPackagePrefix = new NewPackagePrefix }
class NewPackagePrefix extends NewNode(46.toShort) with PackagePrefixBase {
  type RelatedStored = PackagePrefix
  override def label: String          = "PACKAGE_PREFIX"
  var value: String                   = "": String
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 80, Iterator(this.value))
  }
}

trait PostExecutionCallT extends AnyRef with CallReprT
trait PostExecutionCallBase extends AbstractNode with CallReprBase with StaticType[PostExecutionCallT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res
  }
}
class PostExecutionCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 47.toShort, seq_4762)
    with PostExecutionCallBase
    with CallRepr
    with StaticType[PostExecutionCallT] {}
object NewPostExecutionCall             { def apply(): NewPostExecutionCall = new NewPostExecutionCall }
class NewPostExecutionCall extends NewNode(47.toShort) with PostExecutionCallBase {
  type RelatedStored = PostExecutionCall
  override def label: String                      = "POST_EXECUTION_CALL"
  var code: String                                = "<empty>": String
  var columnNumber: Option[Int]                   = None
  var depthFirstOrder: Int                        = -1: Int
  var internalFlags: Int                          = 0: Int
  var lineNumber: Option[Int]                     = None
  var name: String                                = "<empty>": String
  var order: Int                                  = -1: Int
  var signature: String                           = "": String
  def code(value: String): this.type              = { this.code = value; this }
  def columnNumber(value: Int): this.type         = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type      = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type        = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type           = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type   = { this.lineNumber = value; this }
  def name(value: String): this.type              = { this.name = value; this }
  def order(value: Int): this.type                = { this.order = value; this }
  def signature(value: String): this.type         = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 71, Iterator(this.signature))
  }
}

trait ProgramPointT extends AnyRef
trait ProgramPointBase extends AbstractNode with StaticType[ProgramPointT] {
  def elem: TrackingPointBase
  def method: Option[MethodBase]
  def methodTags: IndexedSeq[TagBase]
  def paramTags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("elem", this.elem)
    this.method.foreach { p => res.put("method", p) }
    val tmpmethodTags = this.methodTags; if (tmpmethodTags.nonEmpty) res.put("methodTags", tmpmethodTags)
    val tmpparamTags  = this.paramTags; if (tmpparamTags.nonEmpty) res.put("paramTags", tmpparamTags)
    res
  }
}
class ProgramPoint(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 48.toShort, seq_4762)
    with ProgramPointBase
    with StaticType[ProgramPointT] {
  def elem: TrackingPoint         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: TrackingPoint)
  def method: Option[Method]      = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 85, seq)
  def methodTags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def paramTags: IndexedSeq[Tag]  = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 84, seq)
}
object NewProgramPoint { def apply(): NewProgramPoint = new NewProgramPoint }
class NewProgramPoint extends NewNode(48.toShort) with ProgramPointBase {
  type RelatedStored = ProgramPoint
  override def label: String                              = "PROGRAM_POINT"
  var elem: TrackingPointBase                             = null
  var method: Option[MethodBase]                          = None
  var methodTags: IndexedSeq[TagBase]                     = ArraySeq.empty
  var paramTags: IndexedSeq[TagBase]                      = ArraySeq.empty
  def elem(value: TrackingPointBase): this.type           = { this.elem = value; this }
  def method(value: MethodBase): this.type                = { this.method = Option(value); this }
  def method(value: Option[MethodBase]): this.type        = { this.method = value; this }
  def methodTags(value: IterableOnce[TagBase]): this.type = { this.methodTags = value.iterator.to(ArraySeq); this }
  def paramTags(value: IterableOnce[TagBase]): this.type  = { this.paramTags = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 86, Iterator(this.elem))
    if (method.nonEmpty) interface.emplaceProperty(this, 85, this.method)
    if (methodTags.nonEmpty) interface.emplaceProperty(this, 87, this.methodTags)
    if (paramTags.nonEmpty) interface.emplaceProperty(this, 84, this.paramTags)
  }
}

trait ReadT extends AnyRef
trait ReadBase extends AbstractNode with StaticType[ReadT] {
  def descriptorFlows: IndexedSeq[FlowBase]
  def source: SourceBase
  def triggerCallChains: IndexedSeq[CallChainBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res                = new java.util.HashMap[String, Any]()
    val tmpdescriptorFlows = this.descriptorFlows; if (tmpdescriptorFlows.nonEmpty) res.put("descriptorFlows", tmpdescriptorFlows)
    res.put("source", this.source)
    val tmptriggerCallChains = this.triggerCallChains; if (tmptriggerCallChains.nonEmpty) res.put("triggerCallChains", tmptriggerCallChains)
    res
  }
}
class Read(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 49.toShort, seq_4762)
    with ReadBase
    with StaticType[ReadT] {
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def source: Source                           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}
object NewRead { def apply(): NewRead = new NewRead }
class NewRead extends NewNode(49.toShort) with ReadBase {
  type RelatedStored = Read
  override def label: String                                           = "READ"
  var descriptorFlows: IndexedSeq[FlowBase]                            = ArraySeq.empty
  var source: SourceBase                                               = null
  var triggerCallChains: IndexedSeq[CallChainBase]                     = ArraySeq.empty
  def descriptorFlows(value: IterableOnce[FlowBase]): this.type        = { this.descriptorFlows = value.iterator.to(ArraySeq); this }
  def source(value: SourceBase): this.type                             = { this.source = value; this }
  def triggerCallChains(value: IterableOnce[CallChainBase]): this.type = { this.triggerCallChains = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (descriptorFlows.nonEmpty) interface.emplaceProperty(this, 85, this.descriptorFlows)
    interface.emplaceProperty(this, 86, Iterator(this.source))
    if (triggerCallChains.nonEmpty) interface.emplaceProperty(this, 87, this.triggerCallChains)
  }
}

trait ReturnT extends AnyRef with ExpressionT
trait ReturnBase extends AbstractNode with ExpressionBase with StaticType[ReturnT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}
class Return(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 50.toShort, seq_4762)
    with ReturnBase
    with Expression
    with StaticType[ReturnT] {}
object NewReturn             { def apply(): NewReturn = new NewReturn }
class NewReturn extends NewNode(50.toShort) with ReturnBase {
  type RelatedStored = Return
  override def label: String                         = "RETURN"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait RouteT extends AnyRef with HasPathT
trait RouteBase extends AbstractNode with StaticType[RouteT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("PATH", this.path)
    res
  }
}
class Route(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 51.toShort, seq_4762)
    with RouteBase
    with StaticType[RouteT] {}
object NewRoute             { def apply(): NewRoute = new NewRoute }
class NewRoute extends NewNode(51.toShort) with RouteBase {
  type RelatedStored = Route
  override def label: String         = "ROUTE"
  var path: String                   = "<empty>": String
  def path(value: String): this.type = { this.path = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 65, Iterator(this.path))
  }
}

trait SensitiveDataTypeT extends AnyRef with HasFullNameT
trait SensitiveDataTypeBase extends AbstractNode with StaticType[SensitiveDataTypeT] {
  def members: IndexedSeq[SensitiveMemberBase]
  def names: IndexedSeq[MatchInfoBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("FULL_NAME", this.fullName)
    val tmpmembers = this.members; if (tmpmembers.nonEmpty) res.put("members", tmpmembers)
    val tmpnames   = this.names; if (tmpnames.nonEmpty) res.put("names", tmpnames)
    res
  }
}
class SensitiveDataType(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 52.toShort, seq_4762)
    with SensitiveDataTypeBase
    with StaticType[SensitiveDataTypeT] {
  def members: IndexedSeq[SensitiveMember] = odb2.Accessors.getNodePropertyMulti[SensitiveMember](graph, nodeKind, 85, seq)
  def names: IndexedSeq[MatchInfo]         = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}
object NewSensitiveDataType { def apply(): NewSensitiveDataType = new NewSensitiveDataType }
class NewSensitiveDataType extends NewNode(52.toShort) with SensitiveDataTypeBase {
  type RelatedStored = SensitiveDataType
  override def label: String                                       = "SENSITIVE_DATA_TYPE"
  var fullName: String                                             = "<empty>": String
  var members: IndexedSeq[SensitiveMemberBase]                     = ArraySeq.empty
  var names: IndexedSeq[MatchInfoBase]                             = ArraySeq.empty
  def fullName(value: String): this.type                           = { this.fullName = value; this }
  def members(value: IterableOnce[SensitiveMemberBase]): this.type = { this.members = value.iterator.to(ArraySeq); this }
  def names(value: IterableOnce[MatchInfoBase]): this.type         = { this.names = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    if (members.nonEmpty) interface.emplaceProperty(this, 85, this.members)
    if (names.nonEmpty) interface.emplaceProperty(this, 84, this.names)
  }
}

trait SensitiveMemberT extends AnyRef with HasNameT
trait SensitiveMemberBase extends AbstractNode with StaticType[SensitiveMemberT] {
  def names: IndexedSeq[MatchInfoBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    val tmpnames = this.names; if (tmpnames.nonEmpty) res.put("names", tmpnames)
    res
  }
}
class SensitiveMember(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 53.toShort, seq_4762)
    with SensitiveMemberBase
    with StaticType[SensitiveMemberT] {
  def names: IndexedSeq[MatchInfo] = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}
object NewSensitiveMember { def apply(): NewSensitiveMember = new NewSensitiveMember }
class NewSensitiveMember extends NewNode(53.toShort) with SensitiveMemberBase {
  type RelatedStored = SensitiveMember
  override def label: String                               = "SENSITIVE_MEMBER"
  var name: String                                         = "<empty>": String
  var names: IndexedSeq[MatchInfoBase]                     = ArraySeq.empty
  def name(value: String): this.type                       = { this.name = value; this }
  def names(value: IterableOnce[MatchInfoBase]): this.type = { this.names = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 58, Iterator(this.name))
    if (names.nonEmpty) interface.emplaceProperty(this, 84, this.names)
  }
}

trait SensitiveReferenceT extends AnyRef
trait SensitiveReferenceBase extends AbstractNode with StaticType[SensitiveReferenceT] {
  def ioflows: IndexedSeq[IoflowBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res        = new java.util.HashMap[String, Any]()
    val tmpioflows = this.ioflows; if (tmpioflows.nonEmpty) res.put("ioflows", tmpioflows)
    res
  }
}
class SensitiveReference(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 54.toShort, seq_4762)
    with SensitiveReferenceBase
    with StaticType[SensitiveReferenceT] {
  def ioflows: IndexedSeq[Ioflow] = odb2.Accessors.getNodePropertyMulti[Ioflow](graph, nodeKind, 84, seq)
}
object NewSensitiveReference { def apply(): NewSensitiveReference = new NewSensitiveReference }
class NewSensitiveReference extends NewNode(54.toShort) with SensitiveReferenceBase {
  type RelatedStored = SensitiveReference
  override def label: String                              = "SENSITIVE_REFERENCE"
  var ioflows: IndexedSeq[IoflowBase]                     = ArraySeq.empty
  def ioflows(value: IterableOnce[IoflowBase]): this.type = { this.ioflows = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (ioflows.nonEmpty) interface.emplaceProperty(this, 84, this.ioflows)
  }
}

trait SensitiveVariableT extends AnyRef with HasCategoriesT with HasEvalTypeT with HasNameT
trait SensitiveVariableBase extends AbstractNode with StaticType[SensitiveVariableT] {
  def node: LocalLikeBase
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res           = new java.util.HashMap[String, Any]()
    val tmpCategories = this.categories; if (tmpCategories.nonEmpty) res.put("CATEGORIES", tmpCategories)
    res.put("EVAL_TYPE", this.evalType)
    res.put("NAME", this.name)
    res.put("node", this.node)
    res
  }
}
class SensitiveVariable(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 55.toShort, seq_4762)
    with SensitiveVariableBase
    with StaticType[SensitiveVariableT] {
  def node: LocalLike = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: LocalLike)
}
object NewSensitiveVariable { def apply(): NewSensitiveVariable = new NewSensitiveVariable }
class NewSensitiveVariable extends NewNode(55.toShort) with SensitiveVariableBase {
  type RelatedStored = SensitiveVariable
  override def label: String                             = "SENSITIVE_VARIABLE"
  var categories: IndexedSeq[String]                     = ArraySeq.empty
  var evalType: String                                   = "<empty>": String
  var name: String                                       = "<empty>": String
  var node: LocalLikeBase                                = null
  def categories(value: IterableOnce[String]): this.type = { this.categories = value.iterator.to(ArraySeq); this }
  def evalType(value: String): this.type                 = { this.evalType = value; this }
  def name(value: String): this.type                     = { this.name = value; this }
  def node(value: LocalLikeBase): this.type              = { this.node = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (categories.nonEmpty) interface.emplaceProperty(this, 9, this.categories)
    interface.emplaceProperty(this, 30, Iterator(this.evalType))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 84, Iterator(this.node))
  }
}

trait SinkT extends AnyRef with HasSinkTypeT with HasStructuredFingerprintT
trait SinkBase extends AbstractNode with StaticType[SinkT] {
  def callingMethod: Option[MethodBase]
  def callsite: Option[CallBase]
  def method: MethodBase
  def methodTags: IndexedSeq[TagBase]
  def node: TrackingPointBase
  def nodeType: TypeBase
  def parameterIn: Option[MethodParameterInBase]
  def parameterInTags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("SINK_TYPE", this.sinkType)
    res.put("STRUCTURED_FINGERPRINT", this.structuredFingerprint)
    this.callingMethod.foreach { p => res.put("callingMethod", p) }
    this.callsite.foreach { p => res.put("callsite", p) }
    res.put("method", this.method)
    val tmpmethodTags = this.methodTags; if (tmpmethodTags.nonEmpty) res.put("methodTags", tmpmethodTags)
    res.put("node", this.node)
    res.put("nodeType", this.nodeType)
    this.parameterIn.foreach { p => res.put("parameterIn", p) }
    val tmpparameterInTags = this.parameterInTags; if (tmpparameterInTags.nonEmpty) res.put("parameterInTags", tmpparameterInTags)
    res
  }
}
class Sink(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 56.toShort, seq_4762)
    with SinkBase
    with StaticType[SinkT] {
  def callingMethod: Option[Method]          = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]                 = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]            = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def parameterIn: Option[MethodParameterIn] = odb2.Accessors.getNodePropertyOption[MethodParameterIn](graph, nodeKind, 86, seq)
  def parameterInTags: IndexedSeq[Tag]       = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 91, seq)
}
object NewSink { def apply(): NewSink = new NewSink }
class NewSink extends NewNode(56.toShort) with SinkBase {
  type RelatedStored = Sink
  override def label: String                                       = "SINK"
  var callingMethod: Option[MethodBase]                            = None
  var callsite: Option[CallBase]                                   = None
  var method: MethodBase                                           = null
  var methodTags: IndexedSeq[TagBase]                              = ArraySeq.empty
  var node: TrackingPointBase                                      = null
  var nodeType: TypeBase                                           = null
  var parameterIn: Option[MethodParameterInBase]                   = None
  var parameterInTags: IndexedSeq[TagBase]                         = ArraySeq.empty
  var sinkType: String                                             = "<empty>": String
  var structuredFingerprint: String                                = "null": String
  def callingMethod(value: MethodBase): this.type                  = { this.callingMethod = Option(value); this }
  def callingMethod(value: Option[MethodBase]): this.type          = { this.callingMethod = value; this }
  def callsite(value: CallBase): this.type                         = { this.callsite = Option(value); this }
  def callsite(value: Option[CallBase]): this.type                 = { this.callsite = value; this }
  def method(value: MethodBase): this.type                         = { this.method = value; this }
  def methodTags(value: IterableOnce[TagBase]): this.type          = { this.methodTags = value.iterator.to(ArraySeq); this }
  def node(value: TrackingPointBase): this.type                    = { this.node = value; this }
  def nodeType(value: TypeBase): this.type                         = { this.nodeType = value; this }
  def parameterIn(value: MethodParameterInBase): this.type         = { this.parameterIn = Option(value); this }
  def parameterIn(value: Option[MethodParameterInBase]): this.type = { this.parameterIn = value; this }
  def parameterInTags(value: IterableOnce[TagBase]): this.type     = { this.parameterInTags = value.iterator.to(ArraySeq); this }
  def sinkType(value: String): this.type                           = { this.sinkType = value; this }
  def structuredFingerprint(value: String): this.type              = { this.structuredFingerprint = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 72, Iterator(this.sinkType))
    interface.emplaceProperty(this, 75, Iterator(this.structuredFingerprint))
    if (callingMethod.nonEmpty) interface.emplaceProperty(this, 88, this.callingMethod)
    if (callsite.nonEmpty) interface.emplaceProperty(this, 89, this.callsite)
    interface.emplaceProperty(this, 85, Iterator(this.method))
    if (methodTags.nonEmpty) interface.emplaceProperty(this, 87, this.methodTags)
    interface.emplaceProperty(this, 84, Iterator(this.node))
    interface.emplaceProperty(this, 90, Iterator(this.nodeType))
    if (parameterIn.nonEmpty) interface.emplaceProperty(this, 86, this.parameterIn)
    if (parameterInTags.nonEmpty) interface.emplaceProperty(this, 91, this.parameterInTags)
  }
}

trait SourceT extends AnyRef with HasSourceTypeT with HasStructuredFingerprintT
trait SourceBase extends AbstractNode with StaticType[SourceT] {
  def callingMethod: Option[MethodBase]
  def callsite: Option[CallBase]
  def method: MethodBase
  def methodTags: IndexedSeq[TagBase]
  def node: TrackingPointBase
  def nodeType: TypeBase
  def tags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("SOURCE_TYPE", this.sourceType)
    res.put("STRUCTURED_FINGERPRINT", this.structuredFingerprint)
    this.callingMethod.foreach { p => res.put("callingMethod", p) }
    this.callsite.foreach { p => res.put("callsite", p) }
    res.put("method", this.method)
    val tmpmethodTags = this.methodTags; if (tmpmethodTags.nonEmpty) res.put("methodTags", tmpmethodTags)
    res.put("node", this.node)
    res.put("nodeType", this.nodeType)
    val tmptags = this.tags; if (tmptags.nonEmpty) res.put("tags", tmptags)
    res
  }
}
class Source(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 57.toShort, seq_4762)
    with SourceBase
    with StaticType[SourceT] {
  def callingMethod: Option[Method] = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]        = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]   = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def tags: IndexedSeq[Tag]         = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}
object NewSource { def apply(): NewSource = new NewSource }
class NewSource extends NewNode(57.toShort) with SourceBase {
  type RelatedStored = Source
  override def label: String                              = "SOURCE"
  var callingMethod: Option[MethodBase]                   = None
  var callsite: Option[CallBase]                          = None
  var method: MethodBase                                  = null
  var methodTags: IndexedSeq[TagBase]                     = ArraySeq.empty
  var node: TrackingPointBase                             = null
  var nodeType: TypeBase                                  = null
  var sourceType: String                                  = "<empty>": String
  var structuredFingerprint: String                       = "null": String
  var tags: IndexedSeq[TagBase]                           = ArraySeq.empty
  def callingMethod(value: MethodBase): this.type         = { this.callingMethod = Option(value); this }
  def callingMethod(value: Option[MethodBase]): this.type = { this.callingMethod = value; this }
  def callsite(value: CallBase): this.type                = { this.callsite = Option(value); this }
  def callsite(value: Option[CallBase]): this.type        = { this.callsite = value; this }
  def method(value: MethodBase): this.type                = { this.method = value; this }
  def methodTags(value: IterableOnce[TagBase]): this.type = { this.methodTags = value.iterator.to(ArraySeq); this }
  def node(value: TrackingPointBase): this.type           = { this.node = value; this }
  def nodeType(value: TypeBase): this.type                = { this.nodeType = value; this }
  def sourceType(value: String): this.type                = { this.sourceType = value; this }
  def structuredFingerprint(value: String): this.type     = { this.structuredFingerprint = value; this }
  def tags(value: IterableOnce[TagBase]): this.type       = { this.tags = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 73, Iterator(this.sourceType))
    interface.emplaceProperty(this, 75, Iterator(this.structuredFingerprint))
    if (callingMethod.nonEmpty) interface.emplaceProperty(this, 88, this.callingMethod)
    if (callsite.nonEmpty) interface.emplaceProperty(this, 89, this.callsite)
    interface.emplaceProperty(this, 85, Iterator(this.method))
    if (methodTags.nonEmpty) interface.emplaceProperty(this, 87, this.methodTags)
    interface.emplaceProperty(this, 84, Iterator(this.node))
    interface.emplaceProperty(this, 90, Iterator(this.nodeType))
    if (tags.nonEmpty) interface.emplaceProperty(this, 86, this.tags)
  }
}

trait SpAnnotationParameterT extends AnyRef with HasAnnotationFullNameT with HasAnnotationNameT with HasNameT with HasValueT
trait SpAnnotationParameterBase extends AbstractNode with StaticType[SpAnnotationParameterT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ANNOTATION_FULL_NAME", this.annotationFullName)
    res.put("ANNOTATION_NAME", this.annotationName)
    res.put("NAME", this.name)
    res.put("VALUE", this.value)
    res
  }
}
class SpAnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 58.toShort, seq_4762)
    with SpAnnotationParameterBase
    with StaticType[SpAnnotationParameterT] {}
object NewSpAnnotationParameter             { def apply(): NewSpAnnotationParameter = new NewSpAnnotationParameter }
class NewSpAnnotationParameter extends NewNode(58.toShort) with SpAnnotationParameterBase {
  type RelatedStored = SpAnnotationParameter
  override def label: String                       = "SP_ANNOTATION_PARAMETER"
  var annotationFullName: String                   = "<empty>": String
  var annotationName: String                       = "<empty>": String
  var name: String                                 = "<empty>": String
  var value: String                                = "": String
  def annotationFullName(value: String): this.type = { this.annotationFullName = value; this }
  def annotationName(value: String): this.type     = { this.annotationName = value; this }
  def name(value: String): this.type               = { this.name = value; this }
  def value(value: String): this.type              = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 1, Iterator(this.annotationFullName))
    interface.emplaceProperty(this, 2, Iterator(this.annotationName))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 80, Iterator(this.value))
  }
}

trait SpBlacklistT extends AnyRef
trait SpBlacklistBase extends AbstractNode with StaticType[SpBlacklistT] {
  def tags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res     = new java.util.HashMap[String, Any]()
    val tmptags = this.tags; if (tmptags.nonEmpty) res.put("tags", tmptags)
    res
  }
}
class SpBlacklist(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 59.toShort, seq_4762)
    with SpBlacklistBase
    with StaticType[SpBlacklistT] {
  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}
object NewSpBlacklist { def apply(): NewSpBlacklist = new NewSpBlacklist }
class NewSpBlacklist extends NewNode(59.toShort) with SpBlacklistBase {
  type RelatedStored = SpBlacklist
  override def label: String                        = "SP_BLACKLIST"
  var tags: IndexedSeq[TagBase]                     = ArraySeq.empty
  def tags(value: IterableOnce[TagBase]): this.type = { this.tags = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (tags.nonEmpty) interface.emplaceProperty(this, 86, this.tags)
  }
}

trait TagT extends AnyRef with HasNameT with HasValueT
trait TagBase extends AbstractNode with StaticType[TagT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    res.put("VALUE", this.value)
    res
  }
}
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 60.toShort, seq_4762) with TagBase with StaticType[TagT] {}
object NewTag { def apply(): NewTag = new NewTag }
class NewTag extends NewNode(60.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String          = "TAG"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 80, Iterator(this.value))
  }
}

trait TagsT extends AnyRef
trait TagsBase extends AbstractNode with StaticType[TagsT] {
  def tags: IndexedSeq[TagBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res     = new java.util.HashMap[String, Any]()
    val tmptags = this.tags; if (tmptags.nonEmpty) res.put("tags", tmptags)
    res
  }
}
class Tags(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 61.toShort, seq_4762)
    with TagsBase
    with StaticType[TagsT] {
  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}
object NewTags { def apply(): NewTags = new NewTags }
class NewTags extends NewNode(61.toShort) with TagsBase {
  type RelatedStored = Tags
  override def label: String                        = "TAGS"
  var tags: IndexedSeq[TagBase]                     = ArraySeq.empty
  def tags(value: IterableOnce[TagBase]): this.type = { this.tags = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (tags.nonEmpty) interface.emplaceProperty(this, 86, this.tags)
  }
}

trait TagNodePairT extends AnyRef
trait TagNodePairBase extends AbstractNode with StaticType[TagNodePairT] {
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
    extends StoredNode(graph_4762, 62.toShort, seq_4762)
    with TagNodePairBase
    with StaticType[TagNodePairT] {
  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Tag)
}
object NewTagNodePair { def apply(): NewTagNodePair = new NewTagNodePair }
class NewTagNodePair extends NewNode(62.toShort) with TagNodePairBase {
  type RelatedStored = TagNodePair
  override def label: String               = "TAG_NODE_PAIR"
  var node: AbstractNode                   = null
  var tag: TagBase                         = null
  def node(value: AbstractNode): this.type = { this.node = value; this }
  def tag(value: TagBase): this.type       = { this.tag = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 84, Iterator(this.node))
    interface.emplaceProperty(this, 85, Iterator(this.tag))
  }
}

trait TemplateDomT extends AnyRef with ExpressionT with HasNameT
trait TemplateDomBase extends AbstractNode with ExpressionBase with StaticType[TemplateDomT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res
  }
}
class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 63.toShort, seq_4762)
    with TemplateDomBase
    with Expression
    with StaticType[TemplateDomT] {}
object NewTemplateDom             { def apply(): NewTemplateDom = new NewTemplateDom }
class NewTemplateDom extends NewNode(63.toShort) with TemplateDomBase {
  type RelatedStored = TemplateDom
  override def label: String                         = "TEMPLATE_DOM"
  var argumentIndex: Int                             = -1: Int
  var argumentName: Option[String]                   = None
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var depthFirstOrder: Int                           = -1: Int
  var internalFlags: Int                             = 0: Int
  var lineNumber: Option[Int]                        = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  def argumentIndex(value: Int): this.type           = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type = { this.argumentName = value; this }
  def argumentName(value: String): this.type         = { this.argumentName = Option(value); this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type         = { this.depthFirstOrder = value; this }
  def internalFlags(value: Int): this.type           = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait TransformT extends AnyRef
trait TransformBase extends AbstractNode with StaticType[TransformT] {
  def call: CallBase
  def descriptorFlows: IndexedSeq[FlowBase]
  def sink: SinkBase
  def triggerCallChains: IndexedSeq[CallChainBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("call", this.call)
    val tmpdescriptorFlows = this.descriptorFlows; if (tmpdescriptorFlows.nonEmpty) res.put("descriptorFlows", tmpdescriptorFlows)
    res.put("sink", this.sink)
    val tmptriggerCallChains = this.triggerCallChains; if (tmptriggerCallChains.nonEmpty) res.put("triggerCallChains", tmptriggerCallChains)
    res
  }
}
class Transform(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 64.toShort, seq_4762)
    with TransformBase
    with StaticType[TransformT] {
  def call: Call                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}
object NewTransform { def apply(): NewTransform = new NewTransform }
class NewTransform extends NewNode(64.toShort) with TransformBase {
  type RelatedStored = Transform
  override def label: String                                           = "TRANSFORM"
  var call: CallBase                                                   = null
  var descriptorFlows: IndexedSeq[FlowBase]                            = ArraySeq.empty
  var sink: SinkBase                                                   = null
  var triggerCallChains: IndexedSeq[CallChainBase]                     = ArraySeq.empty
  def call(value: CallBase): this.type                                 = { this.call = value; this }
  def descriptorFlows(value: IterableOnce[FlowBase]): this.type        = { this.descriptorFlows = value.iterator.to(ArraySeq); this }
  def sink(value: SinkBase): this.type                                 = { this.sink = value; this }
  def triggerCallChains(value: IterableOnce[CallChainBase]): this.type = { this.triggerCallChains = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 86, Iterator(this.call))
    if (descriptorFlows.nonEmpty) interface.emplaceProperty(this, 85, this.descriptorFlows)
    interface.emplaceProperty(this, 84, Iterator(this.sink))
    if (triggerCallChains.nonEmpty) interface.emplaceProperty(this, 87, this.triggerCallChains)
  }
}

trait TransformationT extends AnyRef
trait TransformationBase extends AbstractNode with StaticType[TransformationT] {
  def node: TrackingPointBase
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("node", this.node)
    res
  }
}
class Transformation(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 65.toShort, seq_4762)
    with TransformationBase
    with StaticType[TransformationT] {
  def node: TrackingPoint = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
}
object NewTransformation { def apply(): NewTransformation = new NewTransformation }
class NewTransformation extends NewNode(65.toShort) with TransformationBase {
  type RelatedStored = Transformation
  override def label: String                    = "TRANSFORMATION"
  var node: TrackingPointBase                   = null
  def node(value: TrackingPointBase): this.type = { this.node = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 84, Iterator(this.node))
  }
}

trait TypeT extends AnyRef with HasFullNameT with HasNameT with HasTypeDeclFullNameT
trait TypeBase extends AbstractNode with StaticType[TypeT] {

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
    extends StoredNode(graph_4762, 66.toShort, seq_4762)
    with TypeBase
    with StaticType[TypeT] {}
object NewType             { def apply(): NewType = new NewType }
class NewType extends NewNode(66.toShort) with TypeBase {
  type RelatedStored = Type
  override def label: String                     = "TYPE"
  var fullName: String                           = "<empty>": String
  var name: String                               = "<empty>": String
  var typeDeclFullName: String                   = "<empty>": String
  def fullName(value: String): this.type         = { this.fullName = value; this }
  def name(value: String): this.type             = { this.name = value; this }
  def typeDeclFullName(value: String): this.type = { this.typeDeclFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 77, Iterator(this.typeDeclFullName))
  }
}

trait TypeArgumentT extends AnyRef with AstNodeT
trait TypeArgumentBase extends AbstractNode with AstNodeBase with StaticType[TypeArgumentT] {

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
    extends StoredNode(graph_4762, 67.toShort, seq_4762)
    with TypeArgumentBase
    with AstNode
    with StaticType[TypeArgumentT] {}
object NewTypeArgument             { def apply(): NewTypeArgument = new NewTypeArgument }
class NewTypeArgument extends NewNode(67.toShort) with TypeArgumentBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait TypeDeclT
    extends AnyRef
    with AstNodeT
    with HasAliasTypeFullNameT
    with HasAstParentFullNameT
    with HasAstParentTypeT
    with HasFilenameT
    with HasFullNameT
    with HasInheritsFromTypeFullNameT
    with HasIsExternalT
    with HasNameT
trait TypeDeclBase extends AbstractNode with AstNodeBase with StaticType[TypeDeclT] {

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
    extends StoredNode(graph_4762, 68.toShort, seq_4762)
    with TypeDeclBase
    with AstNode
    with StaticType[TypeDeclT] {}
object NewTypeDecl             { def apply(): NewTypeDecl = new NewTypeDecl }
class NewTypeDecl extends NewNode(68.toShort) with TypeDeclBase {
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
    if (aliasTypeFullName.nonEmpty) interface.emplaceProperty(this, 0, this.aliasTypeFullName)
    interface.emplaceProperty(this, 5, Iterator(this.astParentFullName))
    interface.emplaceProperty(this, 6, Iterator(this.astParentType))
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 32, Iterator(this.filename))
    interface.emplaceProperty(this, 34, Iterator(this.fullName))
    if (inheritsFromTypeFullName.nonEmpty) interface.emplaceProperty(this, 40, this.inheritsFromTypeFullName)
    interface.emplaceProperty(this, 43, Iterator(this.isExternal))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait TypeParameterT extends AnyRef with AstNodeT with HasNameT
trait TypeParameterBase extends AbstractNode with AstNodeBase with StaticType[TypeParameterT] {

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
    extends StoredNode(graph_4762, 69.toShort, seq_4762)
    with TypeParameterBase
    with AstNode
    with StaticType[TypeParameterT] {}
object NewTypeParameter             { def apply(): NewTypeParameter = new NewTypeParameter }
class NewTypeParameter extends NewNode(69.toShort) with TypeParameterBase {
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
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 60, Iterator(this.order))
  }
}

trait TypeRefT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait TypeRefBase extends AbstractNode with ExpressionBase with StaticType[TypeRefT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class TypeRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 70.toShort, seq_4762)
    with TypeRefBase
    with Expression
    with StaticType[TypeRefT] {}
object NewTypeRef             { def apply(): NewTypeRef = new NewTypeRef }
class NewTypeRef extends NewNode(70.toShort) with TypeRefBase {
  type RelatedStored = TypeRef
  override def label: String                                          = "TYPE_REF"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait UnknownT
    extends AnyRef
    with ExpressionT
    with HasContainedRefT
    with HasDynamicTypeHintFullNameT
    with HasParserTypeNameT
    with HasTypeFullNameT
trait UnknownBase extends AbstractNode with ExpressionBase with StaticType[UnknownT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("ARGUMENT_INDEX", this.argumentIndex)
    this.argumentName.foreach { p => res.put("ARGUMENT_NAME", p) }
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    res.put("CONTAINED_REF", this.containedRef)
    res.put("DEPTH_FIRST_ORDER", this.depthFirstOrder)
    val tmpDynamicTypeHintFullName = this.dynamicTypeHintFullName;
    if (tmpDynamicTypeHintFullName.nonEmpty) res.put("DYNAMIC_TYPE_HINT_FULL_NAME", tmpDynamicTypeHintFullName)
    res.put("INTERNAL_FLAGS", this.internalFlags)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res.put("PARSER_TYPE_NAME", this.parserTypeName)
    res.put("TYPE_FULL_NAME", this.typeFullName)
    res
  }
}
class Unknown(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 71.toShort, seq_4762)
    with UnknownBase
    with Expression
    with StaticType[UnknownT] {}
object NewUnknown             { def apply(): NewUnknown = new NewUnknown }
class NewUnknown extends NewNode(71.toShort) with UnknownBase {
  type RelatedStored = Unknown
  override def label: String                                          = "UNKNOWN"
  var argumentIndex: Int                                              = -1: Int
  var argumentName: Option[String]                                    = None
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var containedRef: String                                            = "<empty>": String
  var depthFirstOrder: Int                                            = -1: Int
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var internalFlags: Int                                              = 0: Int
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var parserTypeName: String                                          = "<empty>": String
  var typeFullName: String                                            = "<empty>": String
  def argumentIndex(value: Int): this.type                            = { this.argumentIndex = value; this }
  def argumentName(value: Option[String]): this.type                  = { this.argumentName = value; this }
  def argumentName(value: String): this.type                          = { this.argumentName = Option(value); this }
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def containedRef(value: String): this.type                          = { this.containedRef = value; this }
  def depthFirstOrder(value: Int): this.type                          = { this.depthFirstOrder = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def internalFlags(value: Int): this.type                            = { this.internalFlags = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def parserTypeName(value: String): this.type                        = { this.parserTypeName = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 3, Iterator(this.argumentIndex))
    if (argumentName.nonEmpty) interface.emplaceProperty(this, 4, this.argumentName)
    interface.emplaceProperty(this, 15, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.emplaceProperty(this, 16, this.columnNumber)
    interface.emplaceProperty(this, 18, Iterator(this.containedRef))
    interface.emplaceProperty(this, 23, Iterator(this.depthFirstOrder))
    if (dynamicTypeHintFullName.nonEmpty) interface.emplaceProperty(this, 27, this.dynamicTypeHintFullName)
    interface.emplaceProperty(this, 41, Iterator(this.internalFlags))
    if (lineNumber.nonEmpty) interface.emplaceProperty(this, 50, this.lineNumber)
    interface.emplaceProperty(this, 60, Iterator(this.order))
    interface.emplaceProperty(this, 64, Iterator(this.parserTypeName))
    interface.emplaceProperty(this, 78, Iterator(this.typeFullName))
  }
}

trait VariableInfoT extends AnyRef with HasEvaluationTypeT with HasParameterIndexT with HasVarTypeT
trait VariableInfoBase extends AbstractNode with StaticType[VariableInfoT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("EVALUATION_TYPE", this.evaluationType)
    this.parameterIndex.foreach { p => res.put("PARAMETER_INDEX", p) }
    res.put("VAR_TYPE", this.varType)
    res
  }
}
class VariableInfo(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 72.toShort, seq_4762)
    with VariableInfoBase
    with StaticType[VariableInfoT] {}
object NewVariableInfo             { def apply(): NewVariableInfo = new NewVariableInfo }
class NewVariableInfo extends NewNode(72.toShort) with VariableInfoBase {
  type RelatedStored = VariableInfo
  override def label: String                        = "VARIABLE_INFO"
  var evaluationType: String                        = "<empty>": String
  var parameterIndex: Option[Int]                   = None
  var varType: String                               = "<empty>": String
  def evaluationType(value: String): this.type      = { this.evaluationType = value; this }
  def parameterIndex(value: Int): this.type         = { this.parameterIndex = Option(value); this }
  def parameterIndex(value: Option[Int]): this.type = { this.parameterIndex = value; this }
  def varType(value: String): this.type             = { this.varType = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 29, Iterator(this.evaluationType))
    if (parameterIndex.nonEmpty) interface.emplaceProperty(this, 63, this.parameterIndex)
    interface.emplaceProperty(this, 82, Iterator(this.varType))
  }
}

trait VulnerabilityT extends AnyRef with HasDescriptionT with HasNameT with HasScoreT with HasUrlT
trait VulnerabilityBase extends AbstractNode with StaticType[VulnerabilityT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("DESCRIPTION", this.description)
    res.put("NAME", this.name)
    res.put("SCORE", this.score)
    res.put("URL", this.url)
    res
  }
}
class Vulnerability(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 73.toShort, seq_4762)
    with VulnerabilityBase
    with StaticType[VulnerabilityT] {}
object NewVulnerability             { def apply(): NewVulnerability = new NewVulnerability }
class NewVulnerability extends NewNode(73.toShort) with VulnerabilityBase {
  type RelatedStored = Vulnerability
  override def label: String                = "VULNERABILITY"
  var description: String                   = "<empty>": String
  var name: String                          = "<empty>": String
  var score: String                         = "<empty>": String
  var url: String                           = "<empty>": String
  def description(value: String): this.type = { this.description = value; this }
  def name(value: String): this.type        = { this.name = value; this }
  def score(value: String): this.type       = { this.score = value; this }
  def url(value: String): this.type         = { this.url = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.emplaceProperty(this, 24, Iterator(this.description))
    interface.emplaceProperty(this, 58, Iterator(this.name))
    interface.emplaceProperty(this, 70, Iterator(this.score))
    interface.emplaceProperty(this, 79, Iterator(this.url))
  }
}

trait WriteT extends AnyRef
trait WriteBase extends AbstractNode with StaticType[WriteT] {
  def descriptorFlows: IndexedSeq[FlowBase]
  def flows: IndexedSeq[FlowBase]
  def sink: SinkBase
  def triggerCallChains: IndexedSeq[CallChainBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res                = new java.util.HashMap[String, Any]()
    val tmpdescriptorFlows = this.descriptorFlows; if (tmpdescriptorFlows.nonEmpty) res.put("descriptorFlows", tmpdescriptorFlows)
    val tmpflows           = this.flows; if (tmpflows.nonEmpty) res.put("flows", tmpflows)
    res.put("sink", this.sink)
    val tmptriggerCallChains = this.triggerCallChains; if (tmptriggerCallChains.nonEmpty) res.put("triggerCallChains", tmptriggerCallChains)
    res
  }
}
class Write(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 74.toShort, seq_4762)
    with WriteBase
    with StaticType[WriteT] {
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def flows: IndexedSeq[Flow]                  = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 86, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}
object NewWrite { def apply(): NewWrite = new NewWrite }
class NewWrite extends NewNode(74.toShort) with WriteBase {
  type RelatedStored = Write
  override def label: String                                           = "WRITE"
  var descriptorFlows: IndexedSeq[FlowBase]                            = ArraySeq.empty
  var flows: IndexedSeq[FlowBase]                                      = ArraySeq.empty
  var sink: SinkBase                                                   = null
  var triggerCallChains: IndexedSeq[CallChainBase]                     = ArraySeq.empty
  def descriptorFlows(value: IterableOnce[FlowBase]): this.type        = { this.descriptorFlows = value.iterator.to(ArraySeq); this }
  def flows(value: IterableOnce[FlowBase]): this.type                  = { this.flows = value.iterator.to(ArraySeq); this }
  def sink(value: SinkBase): this.type                                 = { this.sink = value; this }
  def triggerCallChains(value: IterableOnce[CallChainBase]): this.type = { this.triggerCallChains = value.iterator.to(ArraySeq); this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    if (descriptorFlows.nonEmpty) interface.emplaceProperty(this, 85, this.descriptorFlows)
    if (flows.nonEmpty) interface.emplaceProperty(this, 86, this.flows)
    interface.emplaceProperty(this, 84, Iterator(this.sink))
    if (triggerCallChains.nonEmpty) interface.emplaceProperty(this, 87, this.triggerCallChains)
  }
}
