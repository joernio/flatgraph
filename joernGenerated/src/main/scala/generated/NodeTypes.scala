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
}

trait BindingT    extends AnyRef with HasMethodFullNameT with HasNameT with HasSignatureT
trait BindingBase extends AbstractNode with StaticType[BindingT] {}
class Binding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 5.toShort, seq_4762)
    with BindingBase
    with StaticType[BindingT] {}
object NewBinding             { def apply(): NewBinding = new NewBinding }
class NewBinding extends NewNode(5.toShort) with BindingBase {
  type RelatedStored = Binding
  override def label: String                   = "BINDING"
  var methodFullName: String                   = "<empty>": String
  var name: String                             = "<empty>": String
  var signature: String                        = "": String
  def methodFullName(value: String): this.type = { this.methodFullName = value; this }
  def name(value: String): this.type           = { this.name = value; this }
  def signature(value: String): this.type      = { this.signature = value; this }
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
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}

trait CallT
    extends AnyRef
    with CallReprT
    with ExpressionT
    with HasDispatchTypeT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
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
  var dispatchType: String                                            = "<empty>": String
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var lineNumber: Option[Int]                                         = None
  var methodFullName: String                                          = "<empty>": String
  var name: String                                                    = "<empty>": String
  var order: Int                                                      = -1: Int
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
  def signature(value: String): this.type                             = { this.signature = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}

trait ClosureBindingT    extends AnyRef with HasClosureBindingIdT with HasClosureOriginalNameT with HasEvaluationStrategyT
trait ClosureBindingBase extends AbstractNode with StaticType[ClosureBindingT] {}
class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 8.toShort, seq_4762)
    with ClosureBindingBase
    with StaticType[ClosureBindingT] {}
object NewClosureBinding             { def apply(): NewClosureBinding = new NewClosureBinding }
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
}

trait CommentT    extends AnyRef with AstNodeT with HasFilenameT
trait CommentBase extends AbstractNode with AstNodeBase with StaticType[CommentT] {}
class Comment(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 9.toShort, seq_4762)
    with CommentBase
    with AstNode
    with StaticType[CommentT] {}
object NewComment             { def apply(): NewComment = new NewComment }
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
}

trait ConfigFileT    extends AnyRef with HasContentT with HasNameT
trait ConfigFileBase extends AbstractNode with StaticType[ConfigFileT] {}
class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 10.toShort, seq_4762)
    with ConfigFileBase
    with StaticType[ConfigFileT] {}
object NewConfigFile             { def apply(): NewConfigFile = new NewConfigFile }
class NewConfigFile extends NewNode(10.toShort) with ConfigFileBase {
  type RelatedStored = ConfigFile
  override def label: String            = "CONFIG_FILE"
  var content: String                   = "<empty>": String
  var name: String                      = "<empty>": String
  def content(value: String): this.type = { this.content = value; this }
  def name(value: String): this.type    = { this.name = value; this }
}

trait ControlStructureT    extends AnyRef with ExpressionT with HasControlStructureTypeT with HasParserTypeNameT
trait ControlStructureBase extends AbstractNode with ExpressionBase with StaticType[ControlStructureT] {}
class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with ControlStructureBase
    with Expression
    with StaticType[ControlStructureT] {}
object NewControlStructure             { def apply(): NewControlStructure = new NewControlStructure }
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
}

trait DependencyT    extends AnyRef with HasDependencyGroupIdT with HasNameT with HasVersionT
trait DependencyBase extends AbstractNode with StaticType[DependencyT] {}
class Dependency(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 12.toShort, seq_4762)
    with DependencyBase
    with StaticType[DependencyT] {}
object NewDependency             { def apply(): NewDependency = new NewDependency }
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
}

trait FieldIdentifierT    extends AnyRef with ExpressionT with HasCanonicalNameT
trait FieldIdentifierBase extends AbstractNode with ExpressionBase with StaticType[FieldIdentifierT] {}
class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with FieldIdentifierBase
    with Expression
    with StaticType[FieldIdentifierT] {}
object NewFieldIdentifier             { def apply(): NewFieldIdentifier = new NewFieldIdentifier }
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
}

trait FileT    extends AnyRef with AstNodeT with HasHashT with HasNameT
trait FileBase extends AbstractNode with AstNodeBase with StaticType[FileT] {}
class File(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 14.toShort, seq_4762)
    with FileBase
    with AstNode
    with StaticType[FileT] {}
object NewFile             { def apply(): NewFile = new NewFile }
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
}

trait FindingT extends AnyRef
trait FindingBase extends AbstractNode with StaticType[FindingT] {
  def evidence: IndexedSeq[AbstractNode]
  def keyValuePairs: IndexedSeq[KeyValuePairBase]
}
class Finding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 15.toShort, seq_4762)
    with FindingBase
    with StaticType[FindingT] {
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 52, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 53, seq)
}
object NewFinding { def apply(): NewFinding = new NewFinding }
class NewFinding extends NewNode(15.toShort) with FindingBase {
  type RelatedStored = Finding
  override def label: String                                          = "FINDING"
  var evidence: IndexedSeq[AbstractNode]                              = ArraySeq.empty
  var keyValuePairs: IndexedSeq[KeyValuePairBase]                     = ArraySeq.empty
  def evidence(value: IterableOnce[AbstractNode]): this.type          = { this.evidence = value.iterator.to(ArraySeq); this }
  def keyValuePairs(value: IterableOnce[KeyValuePairBase]): this.type = { this.keyValuePairs = value.iterator.to(ArraySeq); this }
}

trait IdentifierT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasNameT with HasTypeFullNameT
trait IdentifierBase extends AbstractNode with ExpressionBase with StaticType[IdentifierT] {}
class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 16.toShort, seq_4762)
    with IdentifierBase
    with Expression
    with StaticType[IdentifierT] {}
object NewIdentifier             { def apply(): NewIdentifier = new NewIdentifier }
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
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
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with ImportBase
    with AstNode
    with StaticType[ImportT] {}
object NewImport             { def apply(): NewImport = new NewImport }
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
}

trait JumpLabelT    extends AnyRef with AstNodeT with HasNameT with HasParserTypeNameT
trait JumpLabelBase extends AbstractNode with AstNodeBase with StaticType[JumpLabelT] {}
class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 18.toShort, seq_4762)
    with JumpLabelBase
    with AstNode
    with StaticType[JumpLabelT] {}
object NewJumpLabel             { def apply(): NewJumpLabel = new NewJumpLabel }
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
}

trait JumpTargetT    extends AnyRef with CfgNodeT with HasArgumentIndexT with HasNameT with HasParserTypeNameT
trait JumpTargetBase extends AbstractNode with CfgNodeBase with StaticType[JumpTargetT] {}
class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 19.toShort, seq_4762)
    with JumpTargetBase
    with CfgNode
    with StaticType[JumpTargetT] {}
object NewJumpTarget             { def apply(): NewJumpTarget = new NewJumpTarget }
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
}

trait KeyValuePairT    extends AnyRef with HasKeyT with HasValueT
trait KeyValuePairBase extends AbstractNode with StaticType[KeyValuePairT] {}
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 20.toShort, seq_4762)
    with KeyValuePairBase
    with StaticType[KeyValuePairT] {}
object NewKeyValuePair             { def apply(): NewKeyValuePair = new NewKeyValuePair }
class NewKeyValuePair extends NewNode(20.toShort) with KeyValuePairBase {
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
    extends StoredNode(graph_4762, 21.toShort, seq_4762)
    with LiteralBase
    with Expression
    with StaticType[LiteralT] {}
object NewLiteral             { def apply(): NewLiteral = new NewLiteral }
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}

trait LocalT extends AnyRef with AstNodeT with DeclarationT with HasClosureBindingIdT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait LocalBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[LocalT] {}
class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 22.toShort, seq_4762)
    with LocalBase
    with AstNode
    with Declaration
    with StaticType[LocalT] {}
object NewLocal             { def apply(): NewLocal = new NewLocal }
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
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with LocationBase
    with StaticType[LocationT] {
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 52, seq)
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
}

trait MemberT    extends AnyRef with AstNodeT with DeclarationT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait MemberBase extends AbstractNode with AstNodeBase with DeclarationBase with StaticType[MemberT] {}
class Member(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with MemberBase
    with AstNode
    with Declaration
    with StaticType[MemberT] {}
object NewMember             { def apply(): NewMember = new NewMember }
class NewMember extends NewNode(24.toShort) with MemberBase {
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

trait MetaDataT    extends AnyRef with HasHashT with HasLanguageT with HasOverlaysT with HasRootT with HasVersionT
trait MetaDataBase extends AbstractNode with StaticType[MetaDataT] {}
class MetaData(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 25.toShort, seq_4762)
    with MetaDataBase
    with StaticType[MetaDataT] {}
object NewMetaData             { def apply(): NewMetaData = new NewMetaData }
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
}

trait MethodT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasAstParentFullNameT
    with HasAstParentTypeT
    with HasColumnNumberEndT
    with HasFilenameT
    with HasFullNameT
    with HasHashT
    with HasIsExternalT
    with HasLineNumberEndT
    with HasSignatureT
trait MethodBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodT] {}
class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with MethodBase
    with CfgNode
    with Declaration
    with StaticType[MethodT] {}
object NewMethod             { def apply(): NewMethod = new NewMethod }
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
}

trait MethodParameterInT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasDynamicTypeHintFullNameT
    with HasEvaluationStrategyT
    with HasIndexT
    with HasIsVariadicT
    with HasTypeFullNameT
trait MethodParameterInBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodParameterInT] {}
class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with MethodParameterInBase
    with CfgNode
    with Declaration
    with StaticType[MethodParameterInT] {}
object NewMethodParameterIn             { def apply(): NewMethodParameterIn = new NewMethodParameterIn }
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
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with MethodParameterOutBase
    with CfgNode
    with Declaration
    with StaticType[MethodParameterOutT] {}
object NewMethodParameterOut             { def apply(): NewMethodParameterOut = new NewMethodParameterOut }
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
}

trait MethodRefT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasMethodFullNameT with HasTypeFullNameT
trait MethodRefBase extends AbstractNode with ExpressionBase with StaticType[MethodRefT] {}
class MethodRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 29.toShort, seq_4762)
    with MethodRefBase
    with Expression
    with StaticType[MethodRefT] {}
object NewMethodRef             { def apply(): NewMethodRef = new NewMethodRef }
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}

trait MethodReturnT    extends AnyRef with CfgNodeT with HasDynamicTypeHintFullNameT with HasEvaluationStrategyT with HasTypeFullNameT
trait MethodReturnBase extends AbstractNode with CfgNodeBase with StaticType[MethodReturnT] {}
class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 30.toShort, seq_4762)
    with MethodReturnBase
    with CfgNode
    with StaticType[MethodReturnT] {}
object NewMethodReturn             { def apply(): NewMethodReturn = new NewMethodReturn }
class NewMethodReturn extends NewNode(30.toShort) with MethodReturnBase {
  type RelatedStored = MethodReturn
  override def label: String                                          = "METHOD_RETURN"
  var code: String                                                    = "<empty>": String
  var columnNumber: Option[Int]                                       = None
  var dynamicTypeHintFullName: IndexedSeq[String]                     = ArraySeq.empty
  var evaluationStrategy: String                                      = "<empty>": String
  var lineNumber: Option[Int]                                         = None
  var order: Int                                                      = -1: Int
  var typeFullName: String                                            = "<empty>": String
  def code(value: String): this.type                                  = { this.code = value; this }
  def columnNumber(value: Int): this.type                             = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type                     = { this.columnNumber = value; this }
  def dynamicTypeHintFullName(value: IterableOnce[String]): this.type = { this.dynamicTypeHintFullName = value.iterator.to(ArraySeq); this }
  def evaluationStrategy(value: String): this.type                    = { this.evaluationStrategy = value; this }
  def lineNumber(value: Int): this.type                               = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type                       = { this.lineNumber = value; this }
  def order(value: Int): this.type                                    = { this.order = value; this }
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}

trait ModifierT    extends AnyRef with AstNodeT with HasModifierTypeT
trait ModifierBase extends AbstractNode with AstNodeBase with StaticType[ModifierT] {}
class Modifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with ModifierBase
    with AstNode
    with StaticType[ModifierT] {}
object NewModifier             { def apply(): NewModifier = new NewModifier }
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
}

trait NamespaceT    extends AnyRef with AstNodeT with HasNameT
trait NamespaceBase extends AbstractNode with AstNodeBase with StaticType[NamespaceT] {}
class Namespace(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 32.toShort, seq_4762)
    with NamespaceBase
    with AstNode
    with StaticType[NamespaceT] {}
object NewNamespace             { def apply(): NewNamespace = new NewNamespace }
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
}

trait NamespaceBlockT    extends AnyRef with AstNodeT with HasFilenameT with HasFullNameT with HasNameT
trait NamespaceBlockBase extends AbstractNode with AstNodeBase with StaticType[NamespaceBlockT] {}
class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 33.toShort, seq_4762)
    with NamespaceBlockBase
    with AstNode
    with StaticType[NamespaceBlockT] {}
object NewNamespaceBlock             { def apply(): NewNamespaceBlock = new NewNamespaceBlock }
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
}

trait ReturnT    extends AnyRef with ExpressionT
trait ReturnBase extends AbstractNode with ExpressionBase with StaticType[ReturnT] {}
class Return(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 34.toShort, seq_4762)
    with ReturnBase
    with Expression
    with StaticType[ReturnT] {}
object NewReturn             { def apply(): NewReturn = new NewReturn }
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
}

trait TagT                                       extends AnyRef with HasNameT with HasValueT
trait TagBase                                    extends AbstractNode with StaticType[TagT]                                              {}
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) with TagBase with StaticType[TagT] {}
object NewTag { def apply(): NewTag = new NewTag }
class NewTag extends NewNode(35.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String          = "TAG"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
}

trait TagNodePairT extends AnyRef
trait TagNodePairBase extends AbstractNode with StaticType[TagNodePairT] {
  def node: AbstractNode
  def tag: TagBase
}
class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with TagNodePairBase
    with StaticType[TagNodePairT] {
  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 52, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, null: Tag)
}
object NewTagNodePair { def apply(): NewTagNodePair = new NewTagNodePair }
class NewTagNodePair extends NewNode(36.toShort) with TagNodePairBase {
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
    extends StoredNode(graph_4762, 37.toShort, seq_4762)
    with TemplateDomBase
    with Expression
    with StaticType[TemplateDomT] {}
object NewTemplateDom             { def apply(): NewTemplateDom = new NewTemplateDom }
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
}

trait TypeT    extends AnyRef with HasFullNameT with HasNameT with HasTypeDeclFullNameT
trait TypeBase extends AbstractNode with StaticType[TypeT] {}
class Type(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with TypeBase
    with StaticType[TypeT] {}
object NewType             { def apply(): NewType = new NewType }
class NewType extends NewNode(38.toShort) with TypeBase {
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
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with TypeArgumentBase
    with AstNode
    with StaticType[TypeArgumentT] {}
object NewTypeArgument             { def apply(): NewTypeArgument = new NewTypeArgument }
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
    extends StoredNode(graph_4762, 40.toShort, seq_4762)
    with TypeDeclBase
    with AstNode
    with StaticType[TypeDeclT] {}
object NewTypeDecl             { def apply(): NewTypeDecl = new NewTypeDecl }
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
}

trait TypeParameterT    extends AnyRef with AstNodeT with HasNameT
trait TypeParameterBase extends AbstractNode with AstNodeBase with StaticType[TypeParameterT] {}
class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with TypeParameterBase
    with AstNode
    with StaticType[TypeParameterT] {}
object NewTypeParameter             { def apply(): NewTypeParameter = new NewTypeParameter }
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
}

trait TypeRefT    extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
trait TypeRefBase extends AbstractNode with ExpressionBase with StaticType[TypeRefT] {}
class TypeRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 42.toShort, seq_4762)
    with TypeRefBase
    with Expression
    with StaticType[TypeRefT] {}
object NewTypeRef             { def apply(): NewTypeRef = new NewTypeRef }
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
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with UnknownBase
    with Expression
    with StaticType[UnknownT] {}
object NewUnknown             { def apply(): NewUnknown = new NewUnknown }
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
  def typeFullName(value: String): this.type                          = { this.typeFullName = value; this }
}
