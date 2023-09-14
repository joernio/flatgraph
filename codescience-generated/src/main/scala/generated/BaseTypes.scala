package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

trait AstNodeT extends AnyRef with HasCodeT with HasColumnNumberT with HasLineNumberT with HasOrderT

trait AstNodeBase extends AbstractNode with StaticType[AstNodeT]
// new properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited properties:
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ANNOTATION_PARAMETER, ANNOTATION_PARAMETER_ASSIGN, ARRAY_INITIALIZER, BLOCK, CALL, COMMENT, CONTROL_STRUCTURE, FIELD_IDENTIFIER, FILE, IDENTIFIER, IMPLICIT_CALL, IMPORT, JUMP_LABEL, JUMP_TARGET, LITERAL, LOCAL, MEMBER, METHOD, METHOD_INST, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, MODIFIER, NAMESPACE, NAMESPACE_BLOCK, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_ARGUMENT, TYPE_DECL, TYPE_PARAMETER, TYPE_REF, UNKNOWN
trait AstNode extends StoredNode with AstNodeBase with StaticType[AstNodeT]

trait AstNodeNew extends NewNode with AstNodeBase with StaticType[AstNodeT] {
  type RelatedStored <: AstNode
  def code: String
  def code_=(value: String): Unit
  def code(value: String): this.type
  def columnNumber: Option[Int]
  def columnNumber_=(value: Option[Int]): Unit
  def columnNumber(value: Option[Int]): this.type
  def columnNumber(value: Int): this.type
  def lineNumber: Option[Int]
  def lineNumber_=(value: Option[Int]): Unit
  def lineNumber(value: Option[Int]): this.type
  def lineNumber(value: Int): this.type
  def order: Int
  def order_=(value: Int): Unit
  def order(value: Int): this.type
}

trait CallReprT extends AnyRef with CfgNodeT with HasNameT with HasSignatureT

trait CallReprBase extends AbstractNode with CfgNodeBase with StaticType[CallReprT]
// new properties: NAME, SIGNATURE
// inherited properties: CODE, COLUMN_NUMBER, DEPTH_FIRST_ORDER, INTERNAL_FLAGS, LINE_NUMBER, ORDER
// inherited interfaces: AST_NODE, TRACKING_POINT
// implementing nodes: CALL, IMPLICIT_CALL, POST_EXECUTION_CALL
trait CallRepr extends StoredNode with CallReprBase with CfgNode with StaticType[CallReprT]

trait CallReprNew extends NewNode with CallReprBase with CfgNodeNew with StaticType[CallReprT] {
  type RelatedStored <: CallRepr
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
  def signature: String
  def signature_=(value: String): Unit
  def signature(value: String): this.type
}

trait CfgNodeT extends AnyRef with AstNodeT with TrackingPointT with HasDepthFirstOrderT with HasInternalFlagsT

trait CfgNodeBase extends AbstractNode with AstNodeBase with TrackingPointBase with StaticType[CfgNodeT]
// new properties: DEPTH_FIRST_ORDER, INTERNAL_FLAGS
// inherited properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, IMPLICIT_CALL, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait CfgNode extends StoredNode with CfgNodeBase with AstNode with TrackingPoint with StaticType[CfgNodeT]

trait CfgNodeNew extends NewNode with CfgNodeBase with AstNodeNew with TrackingPointNew with StaticType[CfgNodeT] {
  type RelatedStored <: CfgNode
  def depthFirstOrder: Int
  def depthFirstOrder_=(value: Int): Unit
  def depthFirstOrder(value: Int): this.type
  def internalFlags: Int
  def internalFlags_=(value: Int): Unit
  def internalFlags(value: Int): this.type
}

trait DeclarationT extends AnyRef with HasNameT

trait DeclarationBase extends AbstractNode with StaticType[DeclarationT]
// new properties: NAME
// inherited properties:
// inherited interfaces:
// implementing nodes: LOCAL, MEMBER, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT
trait Declaration extends StoredNode with DeclarationBase with StaticType[DeclarationT]

trait DeclarationNew extends NewNode with DeclarationBase with StaticType[DeclarationT] {
  type RelatedStored <: Declaration
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
}

trait ExpressionT extends AnyRef with CfgNodeT with HasArgumentIndexT with HasArgumentNameT

trait ExpressionBase extends AbstractNode with CfgNodeBase with StaticType[ExpressionT]
// new properties: ARGUMENT_INDEX, ARGUMENT_NAME
// inherited properties: CODE, COLUMN_NUMBER, DEPTH_FIRST_ORDER, INTERNAL_FLAGS, LINE_NUMBER, ORDER
// inherited interfaces: AST_NODE, TRACKING_POINT
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, LITERAL, METHOD_REF, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait Expression extends StoredNode with ExpressionBase with CfgNode with StaticType[ExpressionT]

trait ExpressionNew extends NewNode with ExpressionBase with AstNodeNew with CfgNodeNew with TrackingPointNew with StaticType[ExpressionT] {
  type RelatedStored <: Expression
  def argumentIndex: Int
  def argumentIndex_=(value: Int): Unit
  def argumentIndex(value: Int): this.type
  def argumentName: Option[String]
  def argumentName_=(value: Option[String]): Unit
  def argumentName(value: Option[String]): this.type
  def argumentName(value: String): this.type
}

trait LocalLikeT extends AnyRef with HasNameT

trait LocalLikeBase extends AbstractNode with StaticType[LocalLikeT]
// new properties: NAME
// inherited properties:
// inherited interfaces:
// implementing nodes: IDENTIFIER, LOCAL, METHOD_PARAMETER_IN
trait LocalLike extends StoredNode with LocalLikeBase with StaticType[LocalLikeT]

trait LocalLikeNew extends NewNode with LocalLikeBase with StaticType[LocalLikeT] {
  type RelatedStored <: LocalLike
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
}

trait TrackingPointT extends AnyRef with HasCodeT

trait TrackingPointBase extends AbstractNode with TrackingPointMarker with StaticType[TrackingPointT]
// new properties: CODE
// inherited properties:
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONFIG_FILE, CONTROL_STRUCTURE, DOM_NODE, FIELD_IDENTIFIER, IDENTIFIER, IMPLICIT_CALL, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait TrackingPoint extends StoredNode with TrackingPointBase with TrackingPointMarker with StaticType[TrackingPointT]

trait TrackingPointNew extends NewNode with TrackingPointBase with TrackingPointMarker with StaticType[TrackingPointT] {
  type RelatedStored <: TrackingPoint
  def code: String
  def code_=(value: String): Unit
  def code(value: String): this.type
}

trait TrackingBase
trait TrackingPointMarker
trait HasAliasTypeFullNameT
trait HasAnnotationFullNameT
trait HasAnnotationNameT
trait HasArgumentIndexT
trait HasArgumentNameT
trait HasAstParentFullNameT
trait HasAstParentTypeT
trait HasBinarySignatureT
trait HasCanonicalNameT
trait HasCategoriesT
trait HasCategoryT
trait HasClassNameT
trait HasClassShortNameT
trait HasClosureBindingIdT
trait HasClosureOriginalNameT
trait HasCodeT
trait HasColumnNumberT
trait HasColumnNumberEndT
trait HasContainedRefT
trait HasContentT
trait HasControlStructureTypeT
trait HasDependencyGroupIdT
trait HasDependencyTypeT
trait HasDepthFirstOrderT
trait HasDescriptionT
trait HasDispatchNameT
trait HasDispatchTypeT
trait HasDynamicTypeHintFullNameT
trait HasEvaluationStrategyT
trait HasEvaluationTypeT
trait HasEvalTypeT
trait HasExplicitAsT
trait HasFilenameT
trait HasFingerprintT
trait HasFullNameT
trait HasHashT
trait HasHasMappingT
trait HasImportedAsT
trait HasImportedEntityT
trait HasIndexT
trait HasInheritsFromTypeFullNameT
trait HasInternalFlagsT
trait HasIsExplicitT
trait HasIsExternalT
trait HasIsMethodNeverOverriddenT
trait HasIsStaticT
trait HasIsVariadicT
trait HasIsWildcardT
trait HasKeyT
trait HasLanguageT
trait HasLineNumberT
trait HasLineNumberEndT
trait HasLiteralsToSinkT
trait HasMethodFullNameT
trait HasMethodInstFullNameT
trait HasMethodShortNameT
trait HasMlAssistedT
trait HasModifierTypeT
trait HasNameT
trait HasNodeLabelT
trait HasOrderT
trait HasOverlaysT
trait HasPackageNameT
trait HasParameterIndexT
trait HasParserTypeNameT
trait HasPathT
trait HasPatternT
trait HasPolicyDirectoriesT
trait HasPossibleTypesT
trait HasResolvedT
trait HasRootT
trait HasScoreT
trait HasSignatureT
trait HasSinkTypeT
trait HasSourceTypeT
trait HasSpidT
trait HasStructuredFingerprintT
trait HasSymbolT
trait HasTypeDeclFullNameT
trait HasTypeFullNameT
trait HasUrlT
trait HasValueT
trait HasVarargParameterT
trait HasVarTypeT
trait HasVersionT
