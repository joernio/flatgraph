package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

trait AstNodeT extends AnyRef with HasCodeT with HasColumnNumberT with HasLineNumberT with HasOrderT

trait AstNodeBase extends AbstractNode with StaticType[AstNodeT]
// new properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited properties:
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ANNOTATION_PARAMETER, ANNOTATION_PARAMETER_ASSIGN, ARRAY_INITIALIZER, BLOCK, CALL, COMMENT, CONTROL_STRUCTURE, FIELD_IDENTIFIER, FILE, IDENTIFIER, IMPORT, JUMP_LABEL, JUMP_TARGET, LITERAL, LOCAL, MEMBER, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, MODIFIER, NAMESPACE, NAMESPACE_BLOCK, RETURN, TEMPLATE_DOM, TYPE_ARGUMENT, TYPE_DECL, TYPE_PARAMETER, TYPE_REF, UNKNOWN
trait AstNode extends StoredNode with AstNodeBase with StaticType[AstNodeT] {
//{accessors}
}

trait AstNodeNew extends NewNode with AstNodeBase with StaticType[AstNodeT]

trait CallReprT extends AnyRef with CfgNodeT with HasNameT with HasSignatureT

trait CallReprBase extends AbstractNode with CfgNodeBase with StaticType[CallReprT]
// new properties: NAME, SIGNATURE
// inherited properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited interfaces: AST_NODE
// implementing nodes: CALL
trait CallRepr extends StoredNode with CallReprBase with CfgNode with StaticType[CallReprT] {
//{accessors}
}

trait CallReprNew extends NewNode with CallReprBase with CfgNodeNew with StaticType[CallReprT]

trait CfgNodeT extends AnyRef with AstNodeT

trait CfgNodeBase extends AbstractNode with AstNodeBase with StaticType[CfgNodeT]
// new properties:
// inherited properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait CfgNode extends StoredNode with CfgNodeBase with AstNode with StaticType[CfgNodeT] {
//{accessors}
}

trait CfgNodeNew extends NewNode with CfgNodeBase with AstNodeNew with StaticType[CfgNodeT]

trait DeclarationT extends AnyRef with HasNameT

trait DeclarationBase extends AbstractNode with StaticType[DeclarationT]
// new properties: NAME
// inherited properties:
// inherited interfaces:
// implementing nodes: LOCAL, MEMBER, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT
trait Declaration extends StoredNode with DeclarationBase with StaticType[DeclarationT] {
//{accessors}
}

trait DeclarationNew extends NewNode with DeclarationBase with StaticType[DeclarationT]

trait ExpressionT extends AnyRef with CfgNodeT with HasArgumentIndexT with HasArgumentNameT

trait ExpressionBase extends AbstractNode with CfgNodeBase with StaticType[ExpressionT]
// new properties: ARGUMENT_INDEX, ARGUMENT_NAME
// inherited properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited interfaces: AST_NODE
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, LITERAL, METHOD_REF, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait Expression extends StoredNode with ExpressionBase with CfgNode with StaticType[ExpressionT] {
//{accessors}
}

trait ExpressionNew extends NewNode with ExpressionBase with CfgNodeNew with AstNodeNew with StaticType[ExpressionT]

trait HasAliasTypeFullNameT
trait HasArgumentIndexT
trait HasArgumentNameT
trait HasAstParentFullNameT
trait HasAstParentTypeT
trait HasCanonicalNameT
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
trait HasDispatchTypeT
trait HasDynamicTypeHintFullNameT
trait HasEvaluationStrategyT
trait HasExplicitAsT
trait HasFilenameT
trait HasFullNameT
trait HasHashT
trait HasImportedAsT
trait HasImportedEntityT
trait HasIndexT
trait HasInheritsFromTypeFullNameT
trait HasIsExplicitT
trait HasIsExternalT
trait HasIsVariadicT
trait HasIsWildcardT
trait HasKeyT
trait HasLanguageT
trait HasLineNumberT
trait HasLineNumberEndT
trait HasMethodFullNameT
trait HasMethodShortNameT
trait HasModifierTypeT
trait HasNameT
trait HasNodeLabelT
trait HasOrderT
trait HasOverlaysT
trait HasPackageNameT
trait HasParserTypeNameT
trait HasRootT
trait HasSignatureT
trait HasSymbolT
trait HasTypeDeclFullNameT
trait HasTypeFullNameT
trait HasValueT
trait HasVersionT
