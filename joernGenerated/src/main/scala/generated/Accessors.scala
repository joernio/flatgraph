package io.shiftleft.codepropertygraph.generated.v2.accessors
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes
import scala.collection.immutable.IndexedSeq

object Accessors {
  class Access_property_ALIAS_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def aliasTypeFullName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 0, node.seq)
  }

  class Access_property_ARGUMENT_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def argumentIndex: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), -1: Int)
  }

  class Access_property_ARGUMENT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def argumentName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 2, node.seq)
  }

  class Access_property_AST_PARENT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def astParentFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 3, node.seq(), "<empty>": String)
  }

  class Access_property_AST_PARENT_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def astParentType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }

  class Access_property_CANONICAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def canonicalName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 5, node.seq(), "<empty>": String)
  }

  class Access_property_CLASS_NAME(val node: nodes.StoredNode) extends AnyVal {
    def className: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 6, node.seq(), "<empty>": String)
  }

  class Access_property_CLASS_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def classShortName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 7, node.seq(), "<empty>": String)
  }

  class Access_property_CLOSURE_BINDING_ID(val node: nodes.StoredNode) extends AnyVal {
    def closureBindingId: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 8, node.seq)
  }

  class Access_property_CLOSURE_ORIGINAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def closureOriginalName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 9, node.seq)
  }

  class Access_property_CODE(val node: nodes.StoredNode) extends AnyVal {
    def code: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 10, node.seq(), "<empty>": String)
  }

  class Access_property_COLUMN_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def columnNumber: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 11, node.seq)
  }

  class Access_property_COLUMN_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def columnNumberEnd: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 12, node.seq)
  }

  class Access_property_CONTAINED_REF(val node: nodes.StoredNode) extends AnyVal {
    def containedRef: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 13, node.seq(), "<empty>": String)
  }

  class Access_property_CONTENT(val node: nodes.StoredNode) extends AnyVal {
    def content: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 14, node.seq(), "<empty>": String)
  }

  class Access_property_CONTROL_STRUCTURE_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def controlStructureType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 15, node.seq(), "<empty>": String)
  }

  class Access_property_DEPENDENCY_GROUP_ID(val node: nodes.StoredNode) extends AnyVal {
    def dependencyGroupId: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 16, node.seq)
  }

  class Access_property_DISPATCH_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def dispatchType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 17, node.seq(), "<empty>": String)
  }

  class Access_property_DYNAMIC_TYPE_HINT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 18, node.seq)
  }

  class Access_property_EVALUATION_STRATEGY(val node: nodes.StoredNode) extends AnyVal {
    def evaluationStrategy: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 19, node.seq(), "<empty>": String)
  }

  class Access_property_EXPLICIT_AS(val node: nodes.StoredNode) extends AnyVal {
    def explicitAs: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 20, node.seq)
  }

  class Access_property_FILENAME(val node: nodes.StoredNode) extends AnyVal {
    def filename: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 21, node.seq(), "<empty>": String)
  }

  class Access_property_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def fullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 22, node.seq(), "<empty>": String)
  }

  class Access_property_HASH(val node: nodes.StoredNode) extends AnyVal {
    def hash: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 23, node.seq)
  }

  class Access_property_IMPORTED_AS(val node: nodes.StoredNode) extends AnyVal {
    def importedAs: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 24, node.seq)
  }

  class Access_property_IMPORTED_ENTITY(val node: nodes.StoredNode) extends AnyVal {
    def importedEntity: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 25, node.seq)
  }

  class Access_property_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def index: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 26, node.seq(), -1: Int)
  }

  class Access_property_INHERITS_FROM_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def inheritsFromTypeFullName: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 27, node.seq)
  }

  class Access_property_IS_EXPLICIT(val node: nodes.StoredNode) extends AnyVal {
    def isExplicit: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 28, node.seq)
  }

  class Access_property_IS_EXTERNAL(val node: nodes.StoredNode) extends AnyVal {
    def isExternal: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 29, node.seq(), false: Boolean)
  }

  class Access_property_IS_VARIADIC(val node: nodes.StoredNode) extends AnyVal {
    def isVariadic: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 30, node.seq(), false: Boolean)
  }

  class Access_property_IS_WILDCARD(val node: nodes.StoredNode) extends AnyVal {
    def isWildcard: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 31, node.seq)
  }

  class Access_property_KEY(val node: nodes.StoredNode) extends AnyVal {
    def key: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 32, node.seq(), "<empty>": String)
  }

  class Access_property_LANGUAGE(val node: nodes.StoredNode) extends AnyVal {
    def language: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 33, node.seq(), "<empty>": String)
  }

  class Access_property_LINE_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def lineNumber: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 34, node.seq)
  }

  class Access_property_LINE_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def lineNumberEnd: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 35, node.seq)
  }

  class Access_property_METHOD_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 36, node.seq(), "<empty>": String)
  }

  class Access_property_METHOD_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodShortName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 37, node.seq(), "<empty>": String)
  }

  class Access_property_MODIFIER_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def modifierType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 38, node.seq(), "<empty>": String)
  }

  class Access_property_NAME(val node: nodes.StoredNode) extends AnyVal {
    def name: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 39, node.seq(), "<empty>": String)
  }

  class Access_property_NODE_LABEL(val node: nodes.StoredNode) extends AnyVal {
    def nodeLabel: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 40, node.seq(), "<empty>": String)
  }

  class Access_property_ORDER(val node: nodes.StoredNode) extends AnyVal {
    def order: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 41, node.seq(), -1: Int)
  }

  class Access_property_OVERLAYS(val node: nodes.StoredNode) extends AnyVal {
    def overlays: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 42, node.seq)
  }

  class Access_property_PACKAGE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def packageName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 43, node.seq(), "<empty>": String)
  }

  class Access_property_PARSER_TYPE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def parserTypeName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 44, node.seq(), "<empty>": String)
  }

  class Access_property_ROOT(val node: nodes.StoredNode) extends AnyVal {
    def root: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 45, node.seq(), "<empty>": String)
  }

  class Access_property_SIGNATURE(val node: nodes.StoredNode) extends AnyVal {
    def signature: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 46, node.seq(), "": String)
  }

  class Access_property_SYMBOL(val node: nodes.StoredNode) extends AnyVal {
    def symbol: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 47, node.seq(), "<empty>": String)
  }

  class Access_property_TYPE_DECL_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeDeclFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 48, node.seq(), "<empty>": String)
  }

  class Access_property_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 49, node.seq(), "<empty>": String)
  }

  class Access_property_VALUE(val node: nodes.StoredNode) extends AnyVal {
    def value: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 50, node.seq(), "": String)
  }

  class Access_property_VERSION(val node: nodes.StoredNode) extends AnyVal {
    def version: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 51, node.seq(), "<empty>": String)
  }
}

object Lang extends ImplicitAccessors
trait ImplicitAccessors {
  import Accessors._
  implicit def accessPropertyAliasTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]
  ): Access_property_ALIAS_TYPE_FULL_NAME = new Access_property_ALIAS_TYPE_FULL_NAME(node)
  implicit def accessPropertyArgumentIndex(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]
  ): Access_property_ARGUMENT_INDEX = new Access_property_ARGUMENT_INDEX(node)
  implicit def accessPropertyArgumentName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]
  ): Access_property_ARGUMENT_NAME = new Access_property_ARGUMENT_NAME(node)
  implicit def accessPropertyAstParentFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]
  ): Access_property_AST_PARENT_FULL_NAME = new Access_property_AST_PARENT_FULL_NAME(node)
  implicit def accessPropertyAstParentType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]
  ): Access_property_AST_PARENT_TYPE = new Access_property_AST_PARENT_TYPE(node)
  implicit def accessPropertyCanonicalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]
  ): Access_property_CANONICAL_NAME = new Access_property_CANONICAL_NAME(node)
  implicit def accessPropertyClassName(node: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]): Access_property_CLASS_NAME =
    new Access_property_CLASS_NAME(node)
  implicit def accessPropertyClassShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]
  ): Access_property_CLASS_SHORT_NAME = new Access_property_CLASS_SHORT_NAME(node)
  implicit def accessPropertyClosureBindingId(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]
  ): Access_property_CLOSURE_BINDING_ID = new Access_property_CLOSURE_BINDING_ID(node)
  implicit def accessPropertyClosureOriginalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]
  ): Access_property_CLOSURE_ORIGINAL_NAME = new Access_property_CLOSURE_ORIGINAL_NAME(node)
  implicit def accessPropertyCode(node: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]): Access_property_CODE =
    new Access_property_CODE(node)
  implicit def accessPropertyColumnNumber(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]
  ): Access_property_COLUMN_NUMBER = new Access_property_COLUMN_NUMBER(node)
  implicit def accessPropertyColumnNumberEnd(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]
  ): Access_property_COLUMN_NUMBER_END = new Access_property_COLUMN_NUMBER_END(node)
  implicit def accessPropertyContainedRef(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]
  ): Access_property_CONTAINED_REF = new Access_property_CONTAINED_REF(node)
  implicit def accessPropertyContent(node: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]): Access_property_CONTENT =
    new Access_property_CONTENT(node)
  implicit def accessPropertyControlStructureType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]
  ): Access_property_CONTROL_STRUCTURE_TYPE = new Access_property_CONTROL_STRUCTURE_TYPE(node)
  implicit def accessPropertyDependencyGroupId(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]
  ): Access_property_DEPENDENCY_GROUP_ID = new Access_property_DEPENDENCY_GROUP_ID(node)
  implicit def accessPropertyDispatchType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]
  ): Access_property_DISPATCH_TYPE = new Access_property_DISPATCH_TYPE(node)
  implicit def accessPropertyDynamicTypeHintFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]
  ): Access_property_DYNAMIC_TYPE_HINT_FULL_NAME = new Access_property_DYNAMIC_TYPE_HINT_FULL_NAME(node)
  implicit def accessPropertyEvaluationStrategy(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]
  ): Access_property_EVALUATION_STRATEGY = new Access_property_EVALUATION_STRATEGY(node)
  implicit def accessPropertyExplicitAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]): Access_property_EXPLICIT_AS =
    new Access_property_EXPLICIT_AS(node)
  implicit def accessPropertyFilename(node: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]): Access_property_FILENAME =
    new Access_property_FILENAME(node)
  implicit def accessPropertyFullName(node: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]): Access_property_FULL_NAME =
    new Access_property_FULL_NAME(node)
  implicit def accessPropertyHash(node: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]): Access_property_HASH =
    new Access_property_HASH(node)
  implicit def accessPropertyImportedAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]): Access_property_IMPORTED_AS =
    new Access_property_IMPORTED_AS(node)
  implicit def accessPropertyImportedEntity(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]
  ): Access_property_IMPORTED_ENTITY = new Access_property_IMPORTED_ENTITY(node)
  implicit def accessPropertyIndex(node: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]): Access_property_INDEX =
    new Access_property_INDEX(node)
  implicit def accessPropertyInheritsFromTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]
  ): Access_property_INHERITS_FROM_TYPE_FULL_NAME = new Access_property_INHERITS_FROM_TYPE_FULL_NAME(node)
  implicit def accessPropertyIsExplicit(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]): Access_property_IS_EXPLICIT =
    new Access_property_IS_EXPLICIT(node)
  implicit def accessPropertyIsExternal(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]): Access_property_IS_EXTERNAL =
    new Access_property_IS_EXTERNAL(node)
  implicit def accessPropertyIsVariadic(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]): Access_property_IS_VARIADIC =
    new Access_property_IS_VARIADIC(node)
  implicit def accessPropertyIsWildcard(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]): Access_property_IS_WILDCARD =
    new Access_property_IS_WILDCARD(node)
  implicit def accessPropertyKey(node: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]): Access_property_KEY =
    new Access_property_KEY(node)
  implicit def accessPropertyLanguage(node: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]): Access_property_LANGUAGE =
    new Access_property_LANGUAGE(node)
  implicit def accessPropertyLineNumber(node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]): Access_property_LINE_NUMBER =
    new Access_property_LINE_NUMBER(node)
  implicit def accessPropertyLineNumberEnd(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]
  ): Access_property_LINE_NUMBER_END = new Access_property_LINE_NUMBER_END(node)
  implicit def accessPropertyMethodFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]
  ): Access_property_METHOD_FULL_NAME = new Access_property_METHOD_FULL_NAME(node)
  implicit def accessPropertyMethodShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]
  ): Access_property_METHOD_SHORT_NAME = new Access_property_METHOD_SHORT_NAME(node)
  implicit def accessPropertyModifierType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]
  ): Access_property_MODIFIER_TYPE = new Access_property_MODIFIER_TYPE(node)
  implicit def accessPropertyName(node: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]): Access_property_NAME =
    new Access_property_NAME(node)
  implicit def accessPropertyNodeLabel(node: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]): Access_property_NODE_LABEL =
    new Access_property_NODE_LABEL(node)
  implicit def accessPropertyOrder(node: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]): Access_property_ORDER =
    new Access_property_ORDER(node)
  implicit def accessPropertyOverlays(node: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]): Access_property_OVERLAYS =
    new Access_property_OVERLAYS(node)
  implicit def accessPropertyPackageName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]
  ): Access_property_PACKAGE_NAME = new Access_property_PACKAGE_NAME(node)
  implicit def accessPropertyParserTypeName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]
  ): Access_property_PARSER_TYPE_NAME = new Access_property_PARSER_TYPE_NAME(node)
  implicit def accessPropertyRoot(node: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]): Access_property_ROOT =
    new Access_property_ROOT(node)
  implicit def accessPropertySignature(node: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]): Access_property_SIGNATURE =
    new Access_property_SIGNATURE(node)
  implicit def accessPropertySymbol(node: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]): Access_property_SYMBOL =
    new Access_property_SYMBOL(node)
  implicit def accessPropertyTypeDeclFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]
  ): Access_property_TYPE_DECL_FULL_NAME = new Access_property_TYPE_DECL_FULL_NAME(node)
  implicit def accessPropertyTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]
  ): Access_property_TYPE_FULL_NAME = new Access_property_TYPE_FULL_NAME(node)
  implicit def accessPropertyValue(node: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]): Access_property_VALUE =
    new Access_property_VALUE(node)
  implicit def accessPropertyVersion(node: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]): Access_property_VERSION =
    new Access_property_VERSION(node)
}
