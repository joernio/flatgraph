package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait AnnotationT    extends AnyRef with ExpressionT with HasFullNameT with HasNameT
trait AnnotationBase extends AbstractNode with ExpressionBase with StaticType[AnnotationT] {}
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
}

trait AnnotationLiteralT    extends AnyRef with ExpressionT with HasNameT
trait AnnotationLiteralBase extends AbstractNode with ExpressionBase with StaticType[AnnotationLiteralT] {}
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
}

trait AnnotationParameterT    extends AnyRef with AstNodeT
trait AnnotationParameterBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterT] {}
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
}

trait AnnotationParameterAssignT    extends AnyRef with AstNodeT
trait AnnotationParameterAssignBase extends AbstractNode with AstNodeBase with StaticType[AnnotationParameterAssignT] {}
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
}

trait ArrayInitializerT    extends AnyRef with ExpressionT
trait ArrayInitializerBase extends AbstractNode with ExpressionBase with StaticType[ArrayInitializerT] {}
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
}

trait BindingT    extends AnyRef with HasIsMethodNeverOverriddenT with HasMethodFullNameT with HasNameT with HasSignatureT
trait BindingBase extends AbstractNode with StaticType[BindingT] {}
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
}

trait BlockT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait BlockBase extends AbstractNode with ExpressionBase with StaticType[BlockT] {}
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
trait CallBase extends AbstractNode with CallReprBase with ExpressionBase with StaticType[CallT] {}
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
}

trait CallChainT extends AnyRef
trait CallChainBase extends AbstractNode with StaticType[CallChainT] {
  def calls: IndexedSeq[CallBase]
  def methods: IndexedSeq[MethodBase]
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
}

trait CallSiteT extends AnyRef
trait CallSiteBase extends AbstractNode with StaticType[CallSiteT] {
  def call: CallBase
  def callerMethod: MethodBase
  def method: MethodBase
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
}

trait ClosureBindingT    extends AnyRef with HasClosureBindingIdT with HasClosureOriginalNameT with HasEvaluationStrategyT
trait ClosureBindingBase extends AbstractNode with StaticType[ClosureBindingT] {}
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
}

trait CommentT    extends AnyRef with AstNodeT with HasFilenameT
trait CommentBase extends AbstractNode with AstNodeBase with StaticType[CommentT] {}
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
}

trait ConfigFileT    extends AnyRef with TrackingPointT with HasContentT with HasNameT
trait ConfigFileBase extends AbstractNode with TrackingPointBase with StaticType[ConfigFileT] {}
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
}

trait ControlStructureT    extends AnyRef with ExpressionT with HasControlStructureTypeT with HasParserTypeNameT
trait ControlStructureBase extends AbstractNode with ExpressionBase with StaticType[ControlStructureT] {}
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
}

trait DependencyT    extends AnyRef with HasDependencyGroupIdT with HasDependencyTypeT with HasNameT with HasVersionT
trait DependencyBase extends AbstractNode with StaticType[DependencyT] {}
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
}

trait DomAttributeT    extends AnyRef with HasNameT with HasValueT
trait DomAttributeBase extends AbstractNode with StaticType[DomAttributeT] {}
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
}

trait DomNodeT extends AnyRef with TrackingPointT with HasColumnNumberT with HasLineNumberT with HasNameT
trait DomNodeBase extends AbstractNode with TrackingPointBase with StaticType[DomNodeT] {
  def attributes: IndexedSeq[DomAttributeBase]
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
}

trait FieldIdentifierT    extends AnyRef with ExpressionT with HasCanonicalNameT
trait FieldIdentifierBase extends AbstractNode with ExpressionBase with StaticType[FieldIdentifierT] {}
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
}

trait FileT    extends AnyRef with AstNodeT with HasHashT with HasNameT
trait FileBase extends AbstractNode with AstNodeBase with StaticType[FileT] {}
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
}

trait FindingT extends AnyRef with HasStructuredFingerprintT
trait FindingBase extends AbstractNode with StaticType[FindingT] {
  def evidence: IndexedSeq[AbstractNode]
  def keyValuePairs: IndexedSeq[KeyValuePairBase]
  def rootCauses: IndexedSeq[FindingBase]
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
}

trait FlowT extends AnyRef
trait FlowBase extends AbstractNode with StaticType[FlowT] {
  def branchPoints: IndexedSeq[TrackingPointBase]
  def cfgNodes: IndexedSeq[CfgNodeBase]
  def points: IndexedSeq[ProgramPointBase]
  def sink: SinkBase
  def source: SourceBase
  def transformations: IndexedSeq[TransformationBase]
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
}

trait FrameworkT    extends AnyRef with HasNameT
trait FrameworkBase extends AbstractNode with StaticType[FrameworkT] {}
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
}

trait FrameworkDataT    extends AnyRef with HasContentT with HasNameT
trait FrameworkDataBase extends AbstractNode with StaticType[FrameworkDataT] {}
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
}

trait IdentifierT    extends AnyRef with ExpressionT with LocalLikeT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait IdentifierBase extends AbstractNode with ExpressionBase with LocalLikeBase with StaticType[IdentifierT] {}
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
}

trait ImplicitCallT    extends AnyRef with CallReprT
trait ImplicitCallBase extends AbstractNode with CallReprBase with StaticType[ImplicitCallT] {}
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
}

trait ImportT
    extends AnyRef
    with AstNodeT
    with HasExplicitAsT
    with HasImportedAsT
    with HasImportedEntityT
    with HasIsExplicitT
    with HasIsWildcardT
trait ImportBase extends AbstractNode with AstNodeBase with StaticType[ImportT] {}
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
}

trait JumpLabelT    extends AnyRef with AstNodeT with HasNameT with HasParserTypeNameT
trait JumpLabelBase extends AbstractNode with AstNodeBase with StaticType[JumpLabelT] {}
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
}

trait JumpTargetT    extends AnyRef with CfgNodeT with HasArgumentIndexT with HasNameT with HasParserTypeNameT
trait JumpTargetBase extends AbstractNode with CfgNodeBase with StaticType[JumpTargetT] {}
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
}

trait KeyValuePairT    extends AnyRef with HasKeyT with HasValueT
trait KeyValuePairBase extends AbstractNode with StaticType[KeyValuePairT] {}
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
}

trait LiteralT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait LiteralBase extends AbstractNode with ExpressionBase with StaticType[LiteralT] {}
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
}

trait LocalT
    extends AnyRef
    with AstNodeT
    with DeclarationT
    with LocalLikeT
    with HasClosureBindingIdT
    with HasDynamicTypeHintFullNameT
    with HasTypeFullNameT
trait LocalBase extends AbstractNode with AstNodeBase with DeclarationBase with LocalLikeBase with StaticType[LocalT] {}
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
}

trait MatchInfoT    extends AnyRef with HasCategoryT with HasPatternT
trait MatchInfoBase extends AbstractNode with StaticType[MatchInfoT] {}
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
}

trait MemberT    extends AnyRef with AstNodeT with DeclarationT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait MemberBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[MemberT] {}
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
trait MetaDataBase extends AbstractNode with StaticType[MetaDataT] {}
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
trait MethodBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodT] {}
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
}

trait MethodInstT    extends AnyRef with AstNodeT with HasFullNameT with HasMethodFullNameT with HasNameT with HasSignatureT
trait MethodInstBase extends AbstractNode with AstNodeBase with StaticType[MethodInstT] {}
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
    with StaticType[MethodParameterInT] {}
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
}

trait MethodParameterOutT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasEvaluationStrategyT
    with HasIndexT
    with HasIsVariadicT
    with HasTypeFullNameT
trait MethodParameterOutBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodParameterOutT] {}
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
}

trait MethodRefT
    extends AnyRef
    with ExpressionT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasMethodInstFullNameT
    with HasTypeFullNameT
trait MethodRefBase extends AbstractNode with ExpressionBase with StaticType[MethodRefT] {}
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
}

trait MethodReturnT    extends AnyRef with CfgNodeT with HasDynamicTypeHintFullNameT with HasEvaluationStrategyT with HasTypeFullNameT
trait MethodReturnBase extends AbstractNode with CfgNodeBase with StaticType[MethodReturnT] {}
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
}

trait ModifierT    extends AnyRef with AstNodeT with HasModifierTypeT
trait ModifierBase extends AbstractNode with AstNodeBase with StaticType[ModifierT] {}
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
}

trait NamespaceT    extends AnyRef with AstNodeT with HasNameT
trait NamespaceBase extends AbstractNode with AstNodeBase with StaticType[NamespaceT] {}
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
}

trait NamespaceBlockT    extends AnyRef with AstNodeT with HasFilenameT with HasFullNameT with HasNameT
trait NamespaceBlockBase extends AbstractNode with AstNodeBase with StaticType[NamespaceBlockT] {}
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
}

trait PackagePrefixT    extends AnyRef with HasValueT
trait PackagePrefixBase extends AbstractNode with StaticType[PackagePrefixT] {}
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
}

trait PostExecutionCallT    extends AnyRef with CallReprT
trait PostExecutionCallBase extends AbstractNode with CallReprBase with StaticType[PostExecutionCallT] {}
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
}

trait ProgramPointT extends AnyRef
trait ProgramPointBase extends AbstractNode with StaticType[ProgramPointT] {
  def elem: TrackingPointBase
  def method: Option[MethodBase]
  def methodTags: IndexedSeq[TagBase]
  def paramTags: IndexedSeq[TagBase]
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
}

trait ReadT extends AnyRef
trait ReadBase extends AbstractNode with StaticType[ReadT] {
  def descriptorFlows: IndexedSeq[FlowBase]
  def source: SourceBase
  def triggerCallChains: IndexedSeq[CallChainBase]
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
}

trait ReturnT    extends AnyRef with ExpressionT
trait ReturnBase extends AbstractNode with ExpressionBase with StaticType[ReturnT] {}
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
}

trait RouteT    extends AnyRef with HasPathT
trait RouteBase extends AbstractNode with StaticType[RouteT] {}
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
}

trait SensitiveDataTypeT extends AnyRef with HasFullNameT
trait SensitiveDataTypeBase extends AbstractNode with StaticType[SensitiveDataTypeT] {
  def members: IndexedSeq[SensitiveMemberBase]
  def names: IndexedSeq[MatchInfoBase]
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
}

trait SensitiveMemberT extends AnyRef with HasNameT
trait SensitiveMemberBase extends AbstractNode with StaticType[SensitiveMemberT] {
  def names: IndexedSeq[MatchInfoBase]
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
}

trait SensitiveReferenceT extends AnyRef
trait SensitiveReferenceBase extends AbstractNode with StaticType[SensitiveReferenceT] {
  def ioflows: IndexedSeq[IoflowBase]
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
}

trait SensitiveVariableT extends AnyRef with HasCategoriesT with HasEvalTypeT with HasNameT
trait SensitiveVariableBase extends AbstractNode with StaticType[SensitiveVariableT] {
  def node: LocalLikeBase
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
}

trait SpAnnotationParameterT    extends AnyRef with HasAnnotationFullNameT with HasAnnotationNameT with HasNameT with HasValueT
trait SpAnnotationParameterBase extends AbstractNode with StaticType[SpAnnotationParameterT] {}
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
}

trait SpBlacklistT extends AnyRef
trait SpBlacklistBase extends AbstractNode with StaticType[SpBlacklistT] {
  def tags: IndexedSeq[TagBase]
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
}

trait TagT                                       extends AnyRef with HasNameT with HasValueT
trait TagBase                                    extends AbstractNode with StaticType[TagT]                                              {}
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 60.toShort, seq_4762) with TagBase with StaticType[TagT] {}
object NewTag { def apply(): NewTag = new NewTag }
class NewTag extends NewNode(60.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String          = "TAG"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
}

trait TagsT extends AnyRef
trait TagsBase extends AbstractNode with StaticType[TagsT] {
  def tags: IndexedSeq[TagBase]
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
}

trait TagNodePairT extends AnyRef
trait TagNodePairBase extends AbstractNode with StaticType[TagNodePairT] {
  def node: AbstractNode
  def tag: TagBase
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
}

trait TemplateDomT    extends AnyRef with ExpressionT with HasNameT
trait TemplateDomBase extends AbstractNode with ExpressionBase with StaticType[TemplateDomT] {}
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
}

trait TransformT extends AnyRef
trait TransformBase extends AbstractNode with StaticType[TransformT] {
  def call: CallBase
  def descriptorFlows: IndexedSeq[FlowBase]
  def sink: SinkBase
  def triggerCallChains: IndexedSeq[CallChainBase]
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
}

trait TransformationT extends AnyRef
trait TransformationBase extends AbstractNode with StaticType[TransformationT] {
  def node: TrackingPointBase
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
}

trait TypeT    extends AnyRef with HasFullNameT with HasNameT with HasTypeDeclFullNameT
trait TypeBase extends AbstractNode with StaticType[TypeT] {}
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
}

trait TypeArgumentT    extends AnyRef with AstNodeT
trait TypeArgumentBase extends AbstractNode with AstNodeBase with StaticType[TypeArgumentT] {}
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
trait TypeDeclBase extends AbstractNode with AstNodeBase with StaticType[TypeDeclT] {}
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
}

trait TypeParameterT    extends AnyRef with AstNodeT with HasNameT
trait TypeParameterBase extends AbstractNode with AstNodeBase with StaticType[TypeParameterT] {}
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
}

trait TypeRefT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait TypeRefBase extends AbstractNode with ExpressionBase with StaticType[TypeRefT] {}
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
}

trait UnknownT
    extends AnyRef
    with ExpressionT
    with HasContainedRefT
    with HasDynamicTypeHintFullNameT
    with HasParserTypeNameT
    with HasTypeFullNameT
trait UnknownBase extends AbstractNode with ExpressionBase with StaticType[UnknownT] {}
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
}

trait VariableInfoT    extends AnyRef with HasEvaluationTypeT with HasParameterIndexT with HasVarTypeT
trait VariableInfoBase extends AbstractNode with StaticType[VariableInfoT] {}
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
}

trait VulnerabilityT    extends AnyRef with HasDescriptionT with HasNameT with HasScoreT with HasUrlT
trait VulnerabilityBase extends AbstractNode with StaticType[VulnerabilityT] {}
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
}

trait WriteT extends AnyRef
trait WriteBase extends AbstractNode with StaticType[WriteT] {
  def descriptorFlows: IndexedSeq[FlowBase]
  def flows: IndexedSeq[FlowBase]
  def sink: SinkBase
  def triggerCallChains: IndexedSeq[CallChainBase]
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
}
