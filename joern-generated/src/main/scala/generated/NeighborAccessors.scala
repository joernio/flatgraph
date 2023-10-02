package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors
import io.joern.odb2
//import io.shiftleft.codepropertygraph.generated.v2.nodes

// object Lang extends ConcreteStoredConversions

object Accessors {
  import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
  import odb2.misc.Misc

  /* accessors for concrete stored nodes start */

  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */

  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyAliasTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]
  ): Access_Property_ALIAS_TYPE_FULL_NAME = new Access_Property_ALIAS_TYPE_FULL_NAME(node)
  implicit def accessPropertyArgumentIndex(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]
  ): Access_Property_ARGUMENT_INDEX = new Access_Property_ARGUMENT_INDEX(node)
  implicit def accessPropertyArgumentName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]
  ): Access_Property_ARGUMENT_NAME = new Access_Property_ARGUMENT_NAME(node)
  implicit def accessPropertyAstParentFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]
  ): Access_Property_AST_PARENT_FULL_NAME = new Access_Property_AST_PARENT_FULL_NAME(node)
  implicit def accessPropertyAstParentType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]
  ): Access_Property_AST_PARENT_TYPE = new Access_Property_AST_PARENT_TYPE(node)
  implicit def accessPropertyCanonicalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]
  ): Access_Property_CANONICAL_NAME = new Access_Property_CANONICAL_NAME(node)
  implicit def accessPropertyClassName(node: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]): Access_Property_CLASS_NAME =
    new Access_Property_CLASS_NAME(node)
  implicit def accessPropertyClassShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]
  ): Access_Property_CLASS_SHORT_NAME = new Access_Property_CLASS_SHORT_NAME(node)
  implicit def accessPropertyClosureBindingId(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]
  ): Access_Property_CLOSURE_BINDING_ID = new Access_Property_CLOSURE_BINDING_ID(node)
  implicit def accessPropertyClosureOriginalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]
  ): Access_Property_CLOSURE_ORIGINAL_NAME = new Access_Property_CLOSURE_ORIGINAL_NAME(node)
  implicit def accessPropertyCode(node: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]): Access_Property_CODE =
    new Access_Property_CODE(node)
  implicit def accessPropertyColumnNumber(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]
  ): Access_Property_COLUMN_NUMBER = new Access_Property_COLUMN_NUMBER(node)
  implicit def accessPropertyColumnNumberEnd(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]
  ): Access_Property_COLUMN_NUMBER_END = new Access_Property_COLUMN_NUMBER_END(node)
  implicit def accessPropertyContainedRef(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]
  ): Access_Property_CONTAINED_REF = new Access_Property_CONTAINED_REF(node)
  implicit def accessPropertyContent(node: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]): Access_Property_CONTENT =
    new Access_Property_CONTENT(node)
  implicit def accessPropertyControlStructureType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]
  ): Access_Property_CONTROL_STRUCTURE_TYPE = new Access_Property_CONTROL_STRUCTURE_TYPE(node)
  implicit def accessPropertyDependencyGroupId(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]
  ): Access_Property_DEPENDENCY_GROUP_ID = new Access_Property_DEPENDENCY_GROUP_ID(node)
  implicit def accessPropertyDispatchType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]
  ): Access_Property_DISPATCH_TYPE = new Access_Property_DISPATCH_TYPE(node)
  implicit def accessPropertyDynamicTypeHintFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]
  ): Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME = new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(node)
  implicit def accessPropertyEvaluationStrategy(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]
  ): Access_Property_EVALUATION_STRATEGY = new Access_Property_EVALUATION_STRATEGY(node)
  implicit def accessPropertyExplicitAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]): Access_Property_EXPLICIT_AS =
    new Access_Property_EXPLICIT_AS(node)
  implicit def accessPropertyFilename(node: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]): Access_Property_FILENAME =
    new Access_Property_FILENAME(node)
  implicit def accessPropertyFullName(node: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]): Access_Property_FULL_NAME =
    new Access_Property_FULL_NAME(node)
  implicit def accessPropertyHash(node: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]): Access_Property_HASH =
    new Access_Property_HASH(node)
  implicit def accessPropertyImportedAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]): Access_Property_IMPORTED_AS =
    new Access_Property_IMPORTED_AS(node)
  implicit def accessPropertyImportedEntity(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]
  ): Access_Property_IMPORTED_ENTITY = new Access_Property_IMPORTED_ENTITY(node)
  implicit def accessPropertyIndex(node: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]): Access_Property_INDEX =
    new Access_Property_INDEX(node)
  implicit def accessPropertyInheritsFromTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]
  ): Access_Property_INHERITS_FROM_TYPE_FULL_NAME = new Access_Property_INHERITS_FROM_TYPE_FULL_NAME(node)
  implicit def accessPropertyIsExplicit(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]): Access_Property_IS_EXPLICIT =
    new Access_Property_IS_EXPLICIT(node)
  implicit def accessPropertyIsExternal(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]): Access_Property_IS_EXTERNAL =
    new Access_Property_IS_EXTERNAL(node)
  implicit def accessPropertyIsVariadic(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]): Access_Property_IS_VARIADIC =
    new Access_Property_IS_VARIADIC(node)
  implicit def accessPropertyIsWildcard(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]): Access_Property_IS_WILDCARD =
    new Access_Property_IS_WILDCARD(node)
  implicit def accessPropertyKey(node: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]): Access_Property_KEY =
    new Access_Property_KEY(node)
  implicit def accessPropertyLanguage(node: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]): Access_Property_LANGUAGE =
    new Access_Property_LANGUAGE(node)
  implicit def accessPropertyLineNumber(node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]): Access_Property_LINE_NUMBER =
    new Access_Property_LINE_NUMBER(node)
  implicit def accessPropertyLineNumberEnd(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]
  ): Access_Property_LINE_NUMBER_END = new Access_Property_LINE_NUMBER_END(node)
  implicit def accessPropertyMethodFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]
  ): Access_Property_METHOD_FULL_NAME = new Access_Property_METHOD_FULL_NAME(node)
  implicit def accessPropertyMethodShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]
  ): Access_Property_METHOD_SHORT_NAME = new Access_Property_METHOD_SHORT_NAME(node)
  implicit def accessPropertyModifierType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]
  ): Access_Property_MODIFIER_TYPE = new Access_Property_MODIFIER_TYPE(node)
  implicit def accessPropertyName(node: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]): Access_Property_NAME =
    new Access_Property_NAME(node)
  implicit def accessPropertyNodeLabel(node: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]): Access_Property_NODE_LABEL =
    new Access_Property_NODE_LABEL(node)
  implicit def accessPropertyOrder(node: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]): Access_Property_ORDER =
    new Access_Property_ORDER(node)
  implicit def accessPropertyOverlays(node: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]): Access_Property_OVERLAYS =
    new Access_Property_OVERLAYS(node)
  implicit def accessPropertyPackageName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]
  ): Access_Property_PACKAGE_NAME = new Access_Property_PACKAGE_NAME(node)
  implicit def accessPropertyParserTypeName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]
  ): Access_Property_PARSER_TYPE_NAME = new Access_Property_PARSER_TYPE_NAME(node)
  implicit def accessPropertyPossibleTypes(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPossibleTypesT]
  ): Access_Property_POSSIBLE_TYPES = new Access_Property_POSSIBLE_TYPES(node)
  implicit def accessPropertyRoot(node: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]): Access_Property_ROOT =
    new Access_Property_ROOT(node)
  implicit def accessPropertySignature(node: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]): Access_Property_SIGNATURE =
    new Access_Property_SIGNATURE(node)
  implicit def accessPropertySymbol(node: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]): Access_Property_SYMBOL =
    new Access_Property_SYMBOL(node)
  implicit def accessPropertyTypeDeclFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]
  ): Access_Property_TYPE_DECL_FULL_NAME = new Access_Property_TYPE_DECL_FULL_NAME(node)
  implicit def accessPropertyTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]
  ): Access_Property_TYPE_FULL_NAME = new Access_Property_TYPE_FULL_NAME(node)
  implicit def accessPropertyValue(node: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]): Access_Property_VALUE =
    new Access_Property_VALUE(node)
  implicit def accessPropertyVersion(node: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]): Access_Property_VERSION =
    new Access_Property_VERSION(node)
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors.*
//XX0 implicit def access_AnnotationBase(node: nodes.AnnotationBase): Access_AnnotationBase = new Access_AnnotationBase(node)
//XX0 implicit def access_AnnotationLiteralBase(node: nodes.AnnotationLiteralBase): Access_AnnotationLiteralBase = new Access_AnnotationLiteralBase(node)
//XX0 implicit def access_AnnotationParameterBase(node: nodes.AnnotationParameterBase): Access_AnnotationParameterBase = new Access_AnnotationParameterBase(node)
//XX0 implicit def access_AnnotationParameterAssignBase(node: nodes.AnnotationParameterAssignBase): Access_AnnotationParameterAssignBase = new Access_AnnotationParameterAssignBase(node)
//XX0 implicit def access_ArrayInitializerBase(node: nodes.ArrayInitializerBase): Access_ArrayInitializerBase = new Access_ArrayInitializerBase(node)
//XX0 implicit def access_BindingBase(node: nodes.BindingBase): Access_BindingBase = new Access_BindingBase(node)
//XX0 implicit def access_BlockBase(node: nodes.BlockBase): Access_BlockBase = new Access_BlockBase(node)
//XX0 implicit def access_CallBase(node: nodes.CallBase): Access_CallBase = new Access_CallBase(node)
//XX0 implicit def access_ClosureBindingBase(node: nodes.ClosureBindingBase): Access_ClosureBindingBase = new Access_ClosureBindingBase(node)
//XX0 implicit def access_CommentBase(node: nodes.CommentBase): Access_CommentBase = new Access_CommentBase(node)
//XX0 implicit def access_ConfigFileBase(node: nodes.ConfigFileBase): Access_ConfigFileBase = new Access_ConfigFileBase(node)
//XX0 implicit def access_ControlStructureBase(node: nodes.ControlStructureBase): Access_ControlStructureBase = new Access_ControlStructureBase(node)
//XX0 implicit def access_DependencyBase(node: nodes.DependencyBase): Access_DependencyBase = new Access_DependencyBase(node)
//XX0 implicit def access_FieldIdentifierBase(node: nodes.FieldIdentifierBase): Access_FieldIdentifierBase = new Access_FieldIdentifierBase(node)
//XX0 implicit def access_FileBase(node: nodes.FileBase): Access_FileBase = new Access_FileBase(node)
//XX0 implicit def access_FindingBase(node: nodes.FindingBase): Access_FindingBase = new Access_FindingBase(node)
//XX0 implicit def access_IdentifierBase(node: nodes.IdentifierBase): Access_IdentifierBase = new Access_IdentifierBase(node)
//XX0 implicit def access_ImportBase(node: nodes.ImportBase): Access_ImportBase = new Access_ImportBase(node)
//XX0 implicit def access_JumpLabelBase(node: nodes.JumpLabelBase): Access_JumpLabelBase = new Access_JumpLabelBase(node)
//XX0 implicit def access_JumpTargetBase(node: nodes.JumpTargetBase): Access_JumpTargetBase = new Access_JumpTargetBase(node)
//XX0 implicit def access_KeyValuePairBase(node: nodes.KeyValuePairBase): Access_KeyValuePairBase = new Access_KeyValuePairBase(node)
//XX0 implicit def access_LiteralBase(node: nodes.LiteralBase): Access_LiteralBase = new Access_LiteralBase(node)
//XX0 implicit def access_LocalBase(node: nodes.LocalBase): Access_LocalBase = new Access_LocalBase(node)
//XX0 implicit def access_LocationBase(node: nodes.LocationBase): Access_LocationBase = new Access_LocationBase(node)
//XX0 implicit def access_MemberBase(node: nodes.MemberBase): Access_MemberBase = new Access_MemberBase(node)
//XX0 implicit def access_MetaDataBase(node: nodes.MetaDataBase): Access_MetaDataBase = new Access_MetaDataBase(node)
//XX0 implicit def access_MethodBase(node: nodes.MethodBase): Access_MethodBase = new Access_MethodBase(node)
//XX0 implicit def access_MethodParameterInBase(node: nodes.MethodParameterInBase): Access_MethodParameterInBase = new Access_MethodParameterInBase(node)
//XX0 implicit def access_MethodParameterOutBase(node: nodes.MethodParameterOutBase): Access_MethodParameterOutBase = new Access_MethodParameterOutBase(node)
//XX0 implicit def access_MethodRefBase(node: nodes.MethodRefBase): Access_MethodRefBase = new Access_MethodRefBase(node)
//XX0 implicit def access_MethodReturnBase(node: nodes.MethodReturnBase): Access_MethodReturnBase = new Access_MethodReturnBase(node)
//XX0 implicit def access_ModifierBase(node: nodes.ModifierBase): Access_ModifierBase = new Access_ModifierBase(node)
//XX0 implicit def access_NamespaceBase(node: nodes.NamespaceBase): Access_NamespaceBase = new Access_NamespaceBase(node)
//XX0 implicit def access_NamespaceBlockBase(node: nodes.NamespaceBlockBase): Access_NamespaceBlockBase = new Access_NamespaceBlockBase(node)
//XX0 implicit def access_ReturnBase(node: nodes.ReturnBase): Access_ReturnBase = new Access_ReturnBase(node)
//XX0 implicit def access_TagBase(node: nodes.TagBase): Access_TagBase = new Access_TagBase(node)
//XX0 implicit def access_TagNodePairBase(node: nodes.TagNodePairBase): Access_TagNodePairBase = new Access_TagNodePairBase(node)
//XX0 implicit def access_TemplateDomBase(node: nodes.TemplateDomBase): Access_TemplateDomBase = new Access_TemplateDomBase(node)
//XX0 implicit def access_TypeBase(node: nodes.TypeBase): Access_TypeBase = new Access_TypeBase(node)
//XX0 implicit def access_TypeArgumentBase(node: nodes.TypeArgumentBase): Access_TypeArgumentBase = new Access_TypeArgumentBase(node)
//XX0 implicit def access_TypeDeclBase(node: nodes.TypeDeclBase): Access_TypeDeclBase = new Access_TypeDeclBase(node)
//XX0 implicit def access_TypeParameterBase(node: nodes.TypeParameterBase): Access_TypeParameterBase = new Access_TypeParameterBase(node)
//XX0 implicit def access_TypeRefBase(node: nodes.TypeRefBase): Access_TypeRefBase = new Access_TypeRefBase(node)
//XX0 implicit def access_UnknownBase(node: nodes.UnknownBase): Access_UnknownBase = new Access_UnknownBase(node)
}

trait AbstractBaseConversions0 {
  import Accessors.*
//XX0 implicit def access_AstNodeBase(node: nodes.AstNodeBase): Access_AstNodeBase = new Access_AstNodeBase(node)
//XX0 implicit def access_CallReprBase(node: nodes.CallReprBase): Access_CallReprBase = new Access_CallReprBase(node)
//XX0 implicit def access_CfgNodeBase(node: nodes.CfgNodeBase): Access_CfgNodeBase = new Access_CfgNodeBase(node)
//XX0 implicit def access_DeclarationBase(node: nodes.DeclarationBase): Access_DeclarationBase = new Access_DeclarationBase(node)
//XX0 implicit def access_ExpressionBase(node: nodes.ExpressionBase): Access_ExpressionBase = new Access_ExpressionBase(node)
}
