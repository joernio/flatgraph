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

trait BindingT extends AnyRef with HasIsMethodNeverOverriddenT with HasMethodFullNameT with HasNameT with HasSignatureT
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
    with HasDispatchNameT
    with HasDispatchTypeT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasMethodInstFullNameT
    with HasResolvedT
    with HasTypeFullNameT
class Call(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 7.toShort, seq_4762)
    with CallRepr
    with Expression
    with StaticType[CallT] {
//{propAccess}

}

trait CallChainT                                       extends AnyRef
class CallChain(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 8.toShort, seq_4762) with StaticType[CallChainT] {
//{propAccess}
  def calls: IndexedSeq[Call]     = odb2.Accessors.getNodePropertyMulti[Call](graph, nodeKind, 84, seq)
  def methods: IndexedSeq[Method] = odb2.Accessors.getNodePropertyMulti[Method](graph, nodeKind, 85, seq)
}

trait CallSiteT                                       extends AnyRef
class CallSite(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 9.toShort, seq_4762) with StaticType[CallSiteT] {
//{propAccess}
  def call: Call           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def callerMethod: Method = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Method)
  def method: Method       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
}

trait ClosureBindingT extends AnyRef with HasClosureBindingIdT with HasClosureOriginalNameT with HasEvaluationStrategyT
class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 10.toShort, seq_4762)
    with StaticType[ClosureBindingT] {
//{propAccess}

}

trait CommentT extends AnyRef with AstNodeT with HasFilenameT
class Comment(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 11.toShort, seq_4762)
    with AstNode
    with StaticType[CommentT] {
//{propAccess}

}

trait ConfigFileT extends AnyRef with TrackingPointT with HasContentT with HasNameT
class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 12.toShort, seq_4762)
    with TrackingPoint
    with StaticType[ConfigFileT] {
//{propAccess}

}

trait ControlStructureT extends AnyRef with ExpressionT with HasControlStructureTypeT with HasParserTypeNameT
class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 13.toShort, seq_4762)
    with Expression
    with StaticType[ControlStructureT] {
//{propAccess}

}

trait DependencyT extends AnyRef with HasDependencyGroupIdT with HasDependencyTypeT with HasNameT with HasVersionT
class Dependency(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 14.toShort, seq_4762) with StaticType[DependencyT] {
//{propAccess}

}

trait DomAttributeT extends AnyRef with HasNameT with HasValueT
class DomAttribute(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 15.toShort, seq_4762)
    with StaticType[DomAttributeT] {
//{propAccess}

}

trait DomNodeT extends AnyRef with TrackingPointT with HasColumnNumberT with HasLineNumberT with HasNameT
class DomNode(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 16.toShort, seq_4762)
    with TrackingPoint
    with StaticType[DomNodeT] {
//{propAccess}
  def attributes: IndexedSeq[DomAttribute] = odb2.Accessors.getNodePropertyMulti[DomAttribute](graph, nodeKind, 84, seq)
}

trait FieldIdentifierT extends AnyRef with ExpressionT with HasCanonicalNameT
class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with Expression
    with StaticType[FieldIdentifierT] {
//{propAccess}

}

trait FileT                                       extends AnyRef with AstNodeT with HasHashT with HasNameT
class File(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 18.toShort, seq_4762) with AstNode with StaticType[FileT] {
//{propAccess}

}

trait FindingT                                       extends AnyRef with HasStructuredFingerprintT
class Finding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 19.toShort, seq_4762) with StaticType[FindingT] {
//{propAccess}
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 84, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 85, seq)
  def rootCauses: IndexedSeq[Finding]         = odb2.Accessors.getNodePropertyMulti[Finding](graph, nodeKind, 86, seq)
}

trait FlowT                                       extends AnyRef
class Flow(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 20.toShort, seq_4762) with StaticType[FlowT] {
//{propAccess}
  def branchPoints: IndexedSeq[TrackingPoint]     = odb2.Accessors.getNodePropertyMulti[TrackingPoint](graph, nodeKind, 85, seq)
  def cfgNodes: IndexedSeq[CfgNode]               = odb2.Accessors.getNodePropertyMulti[CfgNode](graph, nodeKind, 87, seq)
  def points: IndexedSeq[ProgramPoint]            = odb2.Accessors.getNodePropertyMulti[ProgramPoint](graph, nodeKind, 88, seq)
  def sink: Sink                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def source: Source                              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def transformations: IndexedSeq[Transformation] = odb2.Accessors.getNodePropertyMulti[Transformation](graph, nodeKind, 89, seq)
}

trait FrameworkT                                       extends AnyRef with HasNameT
class Framework(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 21.toShort, seq_4762) with StaticType[FrameworkT] {
//{propAccess}

}

trait FrameworkDataT extends AnyRef with HasContentT with HasNameT
class FrameworkData(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 22.toShort, seq_4762)
    with StaticType[FrameworkDataT] {
//{propAccess}

}

trait IdentifierT extends AnyRef with ExpressionT with LocalLikeT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with Expression
    with LocalLike
    with StaticType[IdentifierT] {
//{propAccess}

}

trait ImplicitCallT extends AnyRef with CallReprT
class ImplicitCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with CallRepr
    with StaticType[ImplicitCallT] {
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
    extends StoredNode(graph_4762, 25.toShort, seq_4762)
    with AstNode
    with StaticType[ImportT] {
//{propAccess}

}

trait IoflowT                                       extends AnyRef with HasFingerprintT with HasLiteralsToSinkT with HasMlAssistedT
class Ioflow(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 26.toShort, seq_4762) with StaticType[IoflowT] {
//{propAccess}
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

trait JumpLabelT extends AnyRef with AstNodeT with HasNameT with HasParserTypeNameT
class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with AstNode
    with StaticType[JumpLabelT] {
//{propAccess}

}

trait JumpTargetT extends AnyRef with CfgNodeT with HasArgumentIndexT with HasNameT with HasParserTypeNameT
class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with CfgNode
    with StaticType[JumpTargetT] {
//{propAccess}

}

trait KeyValuePairT extends AnyRef with HasKeyT with HasValueT
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 29.toShort, seq_4762)
    with StaticType[KeyValuePairT] {
//{propAccess}

}

trait LiteralT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Literal(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 30.toShort, seq_4762)
    with Expression
    with StaticType[LiteralT] {
//{propAccess}

}

trait LocalT
    extends AnyRef
    with AstNodeT
    with DeclarationT
    with LocalLikeT
    with HasClosureBindingIdT
    with HasDynamicTypeHintFullNameT
    with HasTypeFullNameT
class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with AstNode
    with Declaration
    with LocalLike
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
class Location(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 32.toShort, seq_4762) with StaticType[LocationT] {
//{propAccess}
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 84, seq)
}

trait MatchInfoT                                       extends AnyRef with HasCategoryT with HasPatternT
class MatchInfo(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 33.toShort, seq_4762) with StaticType[MatchInfoT] {
//{propAccess}

}

trait MemberT extends AnyRef with AstNodeT with DeclarationT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class Member(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 34.toShort, seq_4762)
    with AstNode
    with Declaration
    with StaticType[MemberT] {
//{propAccess}

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
class MetaData(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) with StaticType[MetaDataT] {
//{propAccess}

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
class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with CfgNode
    with Declaration
    with StaticType[MethodT] {
//{propAccess}

}

trait MethodInstT extends AnyRef with AstNodeT with HasFullNameT with HasMethodFullNameT with HasNameT with HasSignatureT
class MethodInst(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 37.toShort, seq_4762)
    with AstNode
    with StaticType[MethodInstT] {
//{propAccess}

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
class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with CfgNode
    with Declaration
    with LocalLike
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
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with CfgNode
    with Declaration
    with StaticType[MethodParameterOutT] {
//{propAccess}

}

trait MethodRefT
    extends AnyRef
    with ExpressionT
    with HasDynamicTypeHintFullNameT
    with HasMethodFullNameT
    with HasMethodInstFullNameT
    with HasTypeFullNameT
class MethodRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 40.toShort, seq_4762)
    with Expression
    with StaticType[MethodRefT] {
//{propAccess}

}

trait MethodReturnT extends AnyRef with CfgNodeT with HasDynamicTypeHintFullNameT with HasEvaluationStrategyT with HasTypeFullNameT
class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with CfgNode
    with StaticType[MethodReturnT] {
//{propAccess}

}

trait MethodSummaryT extends AnyRef with HasBinarySignatureT with HasIsExternalT with HasIsStaticT
class MethodSummary(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 42.toShort, seq_4762)
    with StaticType[MethodSummaryT] {
//{propAccess}
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

trait ModifierT extends AnyRef with AstNodeT with HasModifierTypeT
class Modifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 43.toShort, seq_4762)
    with AstNode
    with StaticType[ModifierT] {
//{propAccess}

}

trait NamespaceT extends AnyRef with AstNodeT with HasNameT
class Namespace(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 44.toShort, seq_4762)
    with AstNode
    with StaticType[NamespaceT] {
//{propAccess}

}

trait NamespaceBlockT extends AnyRef with AstNodeT with HasFilenameT with HasFullNameT with HasNameT
class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 45.toShort, seq_4762)
    with AstNode
    with StaticType[NamespaceBlockT] {
//{propAccess}

}

trait PackagePrefixT extends AnyRef with HasValueT
class PackagePrefix(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 46.toShort, seq_4762)
    with StaticType[PackagePrefixT] {
//{propAccess}

}

trait PostExecutionCallT extends AnyRef with CallReprT
class PostExecutionCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 47.toShort, seq_4762)
    with CallRepr
    with StaticType[PostExecutionCallT] {
//{propAccess}

}

trait ProgramPointT extends AnyRef
class ProgramPoint(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 48.toShort, seq_4762)
    with StaticType[ProgramPointT] {
//{propAccess}
  def elem: TrackingPoint         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: TrackingPoint)
  def method: Option[Method]      = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 85, seq)
  def methodTags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def paramTags: IndexedSeq[Tag]  = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 84, seq)
}

trait ReadT                                       extends AnyRef
class Read(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 49.toShort, seq_4762) with StaticType[ReadT] {
//{propAccess}
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def source: Source                           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}

trait ReturnT extends AnyRef with ExpressionT
class Return(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 50.toShort, seq_4762)
    with Expression
    with StaticType[ReturnT] {
//{propAccess}

}

trait RouteT                                       extends AnyRef with HasPathT
class Route(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 51.toShort, seq_4762) with StaticType[RouteT] {
//{propAccess}

}

trait SensitiveDataTypeT extends AnyRef with HasFullNameT
class SensitiveDataType(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 52.toShort, seq_4762)
    with StaticType[SensitiveDataTypeT] {
//{propAccess}
  def members: IndexedSeq[SensitiveMember] = odb2.Accessors.getNodePropertyMulti[SensitiveMember](graph, nodeKind, 85, seq)
  def names: IndexedSeq[MatchInfo]         = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}

trait SensitiveMemberT extends AnyRef with HasNameT
class SensitiveMember(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 53.toShort, seq_4762)
    with StaticType[SensitiveMemberT] {
//{propAccess}
  def names: IndexedSeq[MatchInfo] = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}

trait SensitiveReferenceT extends AnyRef
class SensitiveReference(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 54.toShort, seq_4762)
    with StaticType[SensitiveReferenceT] {
//{propAccess}
  def ioflows: IndexedSeq[Ioflow] = odb2.Accessors.getNodePropertyMulti[Ioflow](graph, nodeKind, 84, seq)
}

trait SensitiveVariableT extends AnyRef with HasCategoriesT with HasEvalTypeT with HasNameT
class SensitiveVariable(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 55.toShort, seq_4762)
    with StaticType[SensitiveVariableT] {
//{propAccess}
  def node: LocalLike = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: LocalLike)
}

trait SinkT                                       extends AnyRef with HasSinkTypeT with HasStructuredFingerprintT
class Sink(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 56.toShort, seq_4762) with StaticType[SinkT] {
//{propAccess}
  def callingMethod: Option[Method]          = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]                 = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]            = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def parameterIn: Option[MethodParameterIn] = odb2.Accessors.getNodePropertyOption[MethodParameterIn](graph, nodeKind, 86, seq)
  def parameterInTags: IndexedSeq[Tag]       = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 91, seq)
}

trait SourceT                                       extends AnyRef with HasSourceTypeT with HasStructuredFingerprintT
class Source(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 57.toShort, seq_4762) with StaticType[SourceT] {
//{propAccess}
  def callingMethod: Option[Method] = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]        = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]   = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def tags: IndexedSeq[Tag]         = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

trait SpAnnotationParameterT extends AnyRef with HasAnnotationFullNameT with HasAnnotationNameT with HasNameT with HasValueT
class SpAnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 58.toShort, seq_4762)
    with StaticType[SpAnnotationParameterT] {
//{propAccess}

}

trait SpBlacklistT extends AnyRef
class SpBlacklist(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 59.toShort, seq_4762)
    with StaticType[SpBlacklistT] {
//{propAccess}
  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

trait TagT                                       extends AnyRef with HasNameT with HasValueT
class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 60.toShort, seq_4762) with StaticType[TagT] {
//{propAccess}

}

trait TagsT                                       extends AnyRef
class Tags(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 61.toShort, seq_4762) with StaticType[TagsT] {
//{propAccess}
  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

trait TagNodePairT extends AnyRef
class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 62.toShort, seq_4762)
    with StaticType[TagNodePairT] {
//{propAccess}
  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Tag)
}

trait TemplateDomT extends AnyRef with ExpressionT with HasNameT
class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 63.toShort, seq_4762)
    with Expression
    with StaticType[TemplateDomT] {
//{propAccess}

}

trait TransformT                                       extends AnyRef
class Transform(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 64.toShort, seq_4762) with StaticType[TransformT] {
//{propAccess}
  def call: Call                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}

trait TransformationT extends AnyRef
class Transformation(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 65.toShort, seq_4762)
    with StaticType[TransformationT] {
//{propAccess}
  def node: TrackingPoint = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
}

trait TypeT                                       extends AnyRef with HasFullNameT with HasNameT with HasTypeDeclFullNameT
class Type(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 66.toShort, seq_4762) with StaticType[TypeT] {
//{propAccess}

}

trait TypeArgumentT extends AnyRef with AstNodeT
class TypeArgument(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 67.toShort, seq_4762)
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
    extends StoredNode(graph_4762, 68.toShort, seq_4762)
    with AstNode
    with StaticType[TypeDeclT] {
//{propAccess}

}

trait TypeParameterT extends AnyRef with AstNodeT with HasNameT
class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 69.toShort, seq_4762)
    with AstNode
    with StaticType[TypeParameterT] {
//{propAccess}

}

trait TypeRefT extends AnyRef with ExpressionT with HasDynamicTypeHintFullNameT with HasTypeFullNameT
class TypeRef(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 70.toShort, seq_4762)
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
    extends StoredNode(graph_4762, 71.toShort, seq_4762)
    with Expression
    with StaticType[UnknownT] {
//{propAccess}

}

trait VariableInfoT extends AnyRef with HasEvaluationTypeT with HasParameterIndexT with HasVarTypeT
class VariableInfo(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 72.toShort, seq_4762)
    with StaticType[VariableInfoT] {
//{propAccess}

}

trait VulnerabilityT extends AnyRef with HasDescriptionT with HasNameT with HasScoreT with HasUrlT
class Vulnerability(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 73.toShort, seq_4762)
    with StaticType[VulnerabilityT] {
//{propAccess}

}

trait WriteT                                       extends AnyRef
class Write(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 74.toShort, seq_4762) with StaticType[WriteT] {
//{propAccess}
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def flows: IndexedSeq[Flow]                  = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 86, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}
