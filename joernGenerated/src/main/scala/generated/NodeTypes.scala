package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

trait AnnotationT extends AnyRef with ExpressionT with HasFullNameT with HasNameT
class Annotation(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with Expression
    with StaticType[AnnotationT] {
//{propAccess}

}

trait AnnotationLiteralT extends AnyRef with ExpressionT with HasNameT
class AnnotationLiteral(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
    with Expression
    with StaticType[AnnotationLiteralT] {
//{propAccess}

}

trait AnnotationParameterT extends AnyRef with AstNodeT
class AnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 2.toShort, seq_4762)
    with AstNode
    with StaticType[AnnotationParameterT] {
//{propAccess}

}

trait AnnotationParameterAssignT extends AnyRef with AstNodeT
class AnnotationParameterAssign(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 3.toShort, seq_4762)
    with AstNode
    with StaticType[AnnotationParameterAssignT] {
//{propAccess}

}

trait ArrayInitializerT extends AnyRef with ExpressionT
class ArrayInitializer(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 4.toShort, seq_4762)
    with Expression
    with StaticType[ArrayInitializerT] {
//{propAccess}

}

trait BindingT                                       extends AnyRef with HasMethodFullNameT with HasNameT with HasSignatureT
class Binding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 5.toShort, seq_4762) with StaticType[BindingT] {
//{propAccess}

}

trait BlockT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Block(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 6.toShort, seq_4762)
    with Expression
    with StaticType[BlockT] {
//{propAccess}

}

trait CallT
    extends AnyRef
    with CallReprT
    with ExpressionT
    with HasDispatchTypeT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasTypeFullNameT
class Call(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 7.toShort, seq_4762)
    with CallRepr
    with Expression
    with StaticType[CallT] {
//{propAccess}

}

trait ClosureBindingT extends AnyRef with HasClosureBindingIdT with HasClosureOriginalNameT with HasEvaluationStrategyT
class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 8.toShort, seq_4762)
    with StaticType[ClosureBindingT] {
//{propAccess}

}

trait CommentT extends AnyRef with AstNodeT with HasFilenameT
class Comment(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 9.toShort, seq_4762)
    with AstNode
    with StaticType[CommentT] {
//{propAccess}

}

trait ConfigFileT                                       extends AnyRef with HasContentT with HasNameT
class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 10.toShort, seq_4762) with StaticType[ConfigFileT] {
//{propAccess}

}

trait ControlStructureT extends AnyRef with ExpressionT with HasControlStructureTypeT with HasParserTypeNameT
class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with Expression
    with StaticType[ControlStructureT] {
//{propAccess}

}

trait DependencyT                                       extends AnyRef with HasDependencyGroupIdT with HasNameT with HasVersionT
class Dependency(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 12.toShort, seq_4762) with StaticType[DependencyT] {
//{propAccess}

}

trait FieldIdentifierT extends AnyRef with ExpressionT with HasCanonicalNameT
class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with Expression
    with StaticType[FieldIdentifierT] {
//{propAccess}

}

trait FileT                                       extends AnyRef with AstNodeT with HasHashT with HasNameT
class File(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 14.toShort, seq_4762) with AstNode with StaticType[FileT] {
//{propAccess}

}

trait FindingT                                       extends AnyRef
class Finding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 15.toShort, seq_4762) with StaticType[FindingT] {
//{propAccess}
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 52, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 53, seq)
}

trait IdentifierT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasNameT with HasTypeFullNameT
class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 16.toShort, seq_4762)
    with Expression
    with StaticType[IdentifierT] {
//{propAccess}

}

trait ImportT
    extends AnyRef
    with AstNodeT
    with HasExplicitAsT
    with HasImportedAsT
    with HasImportedEntityT
    with HasIsExplicitT
    with HasIsWildcardT
class Import(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with AstNode
    with StaticType[ImportT] {
//{propAccess}

}

trait JumpLabelT extends AnyRef with AstNodeT with HasNameT with HasParserTypeNameT
class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 18.toShort, seq_4762)
    with AstNode
    with StaticType[JumpLabelT] {
//{propAccess}

}

trait JumpTargetT extends AnyRef with CfgNodeT with HasArgumentIndexT with HasNameT with HasParserTypeNameT
class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 19.toShort, seq_4762)
    with CfgNode
    with StaticType[JumpTargetT] {
//{propAccess}

}

trait KeyValuePairT extends AnyRef with HasKeyT with HasValueT
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 20.toShort, seq_4762)
    with StaticType[KeyValuePairT] {
//{propAccess}

}

trait LiteralT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Literal(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 21.toShort, seq_4762)
    with Expression
    with StaticType[LiteralT] {
//{propAccess}

}

trait LocalT extends AnyRef with AstNodeT with DeclarationT with HasClosureBindingIdT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 22.toShort, seq_4762)
    with AstNode
    with Declaration
    with StaticType[LocalT] {
//{propAccess}

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
class Location(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 23.toShort, seq_4762) with StaticType[LocationT] {
//{propAccess}
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 52, seq)
}

trait MemberT extends AnyRef with AstNodeT with DeclarationT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Member(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with AstNode
    with Declaration
    with StaticType[MemberT] {
//{propAccess}

}

trait MetaDataT extends AnyRef with HasHashT with HasLanguageT with HasOverlaysT with HasRootT with HasVersionT
class MetaData(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 25.toShort, seq_4762) with StaticType[MetaDataT] {
//{propAccess}

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
class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with CfgNode
    with Declaration
    with StaticType[MethodT] {
//{propAccess}

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
class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with CfgNode
    with Declaration
    with StaticType[MethodParameterInT] {
//{propAccess}

}

trait MethodParameterOutT
    extends AnyRef
    with CfgNodeT
    with DeclarationT
    with HasEvaluationStrategyT
    with HasIndexT
    with HasIsVariadicT
    with HasTypeFullNameT
class MethodParameterOut(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with CfgNode
    with Declaration
    with StaticType[MethodParameterOutT] {
//{propAccess}

}

trait MethodRefT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasMethodFullNameT with HasTypeFullNameT
class MethodRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 29.toShort, seq_4762)
    with Expression
    with StaticType[MethodRefT] {
//{propAccess}

}

trait MethodReturnT extends AnyRef with CfgNodeT with HasDynamicTypeHintFullNameT with HasEvaluationStrategyT with HasTypeFullNameT
class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 30.toShort, seq_4762)
    with CfgNode
    with StaticType[MethodReturnT] {
//{propAccess}

}

trait ModifierT extends AnyRef with AstNodeT with HasModifierTypeT
class Modifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with AstNode
    with StaticType[ModifierT] {
//{propAccess}

}

trait NamespaceT extends AnyRef with AstNodeT with HasNameT
class Namespace(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 32.toShort, seq_4762)
    with AstNode
    with StaticType[NamespaceT] {
//{propAccess}

}

trait NamespaceBlockT extends AnyRef with AstNodeT with HasFilenameT with HasFullNameT with HasNameT
class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 33.toShort, seq_4762)
    with AstNode
    with StaticType[NamespaceBlockT] {
//{propAccess}

}

trait ReturnT extends AnyRef with ExpressionT
class Return(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 34.toShort, seq_4762)
    with Expression
    with StaticType[ReturnT] {
//{propAccess}

}

trait TagT                                       extends AnyRef with HasNameT with HasValueT
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) with StaticType[TagT] {
//{propAccess}

}

trait TagNodePairT extends AnyRef
class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with StaticType[TagNodePairT] {
//{propAccess}
  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 52, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, null: Tag)
}

trait TemplateDomT extends AnyRef with ExpressionT with HasNameT
class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 37.toShort, seq_4762)
    with Expression
    with StaticType[TemplateDomT] {
//{propAccess}

}

trait TypeT                                       extends AnyRef with HasFullNameT with HasNameT with HasTypeDeclFullNameT
class Type(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 38.toShort, seq_4762) with StaticType[TypeT] {
//{propAccess}

}

trait TypeArgumentT extends AnyRef with AstNodeT
class TypeArgument(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with AstNode
    with StaticType[TypeArgumentT] {
//{propAccess}

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
class TypeDecl(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 40.toShort, seq_4762)
    with AstNode
    with StaticType[TypeDeclT] {
//{propAccess}

}

trait TypeParameterT extends AnyRef with AstNodeT with HasNameT
class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with AstNode
    with StaticType[TypeParameterT] {
//{propAccess}

}

trait TypeRefT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class TypeRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 42.toShort, seq_4762)
    with Expression
    with StaticType[TypeRefT] {
//{propAccess}

}

trait UnknownT
    extends AnyRef
    with ExpressionT
    with HasContainedRefT
    with HasDynamicTypeHintFullNameT
    with HasParserTypeNameT
    with HasTypeFullNameT
class Unknown(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with Expression
    with StaticType[UnknownT] {
//{propAccess}

}
