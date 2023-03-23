package io.shiftleft.codepropertygraph.generated.v2.accessors
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes
import scala.collection.immutable.IndexedSeq

object Accessors {
  class Access_property_ALIAS_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def aliasTypeFullName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 0, node.seq)
  }

  class Access_property_ANNOTATION_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def annotationFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), "<empty>": String)
  }

  class Access_property_ANNOTATION_NAME(val node: nodes.StoredNode) extends AnyVal {
    def annotationName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 2, node.seq(), "<empty>": String)
  }

  class Access_property_ARGUMENT_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def argumentIndex: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 3, node.seq(), -1: Int)
  }

  class Access_property_ARGUMENT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def argumentName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 4, node.seq)
  }

  class Access_property_AST_PARENT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def astParentFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 5, node.seq(), "<empty>": String)
  }

  class Access_property_AST_PARENT_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def astParentType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 6, node.seq(), "<empty>": String)
  }

  class Access_property_BINARY_SIGNATURE(val node: nodes.StoredNode) extends AnyVal {
    def binarySignature: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 7, node.seq)
  }

  class Access_property_CANONICAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def canonicalName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 8, node.seq(), "<empty>": String)
  }

  class Access_property_CATEGORIES(val node: nodes.StoredNode) extends AnyVal {
    def categories: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 9, node.seq)
  }

  class Access_property_CATEGORY(val node: nodes.StoredNode) extends AnyVal {
    def category: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 10, node.seq(), "<empty>": String)
  }

  class Access_property_CLASS_NAME(val node: nodes.StoredNode) extends AnyVal {
    def className: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 11, node.seq(), "<empty>": String)
  }

  class Access_property_CLASS_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def classShortName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 12, node.seq(), "<empty>": String)
  }

  class Access_property_CLOSURE_BINDING_ID(val node: nodes.StoredNode) extends AnyVal {
    def closureBindingId: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 13, node.seq)
  }

  class Access_property_CLOSURE_ORIGINAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def closureOriginalName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 14, node.seq)
  }

  class Access_property_CODE(val node: nodes.StoredNode) extends AnyVal {
    def code: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 15, node.seq(), "<empty>": String)
  }

  class Access_property_COLUMN_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def columnNumber: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 16, node.seq)
  }

  class Access_property_COLUMN_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def columnNumberEnd: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 17, node.seq)
  }

  class Access_property_CONTAINED_REF(val node: nodes.StoredNode) extends AnyVal {
    def containedRef: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 18, node.seq(), "<empty>": String)
  }

  class Access_property_CONTENT(val node: nodes.StoredNode) extends AnyVal {
    def content: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 19, node.seq(), "<empty>": String)
  }

  class Access_property_CONTROL_STRUCTURE_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def controlStructureType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 20, node.seq(), "<empty>": String)
  }

  class Access_property_DEPENDENCY_GROUP_ID(val node: nodes.StoredNode) extends AnyVal {
    def dependencyGroupId: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 21, node.seq)
  }

  class Access_property_DEPENDENCY_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def dependencyType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 22, node.seq(), "<empty>": String)
  }

  class Access_property_DEPTH_FIRST_ORDER(val node: nodes.StoredNode) extends AnyVal {
    def depthFirstOrder: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 23, node.seq(), -1: Int)
  }

  class Access_property_DESCRIPTION(val node: nodes.StoredNode) extends AnyVal {
    def description: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 24, node.seq(), "<empty>": String)
  }

  class Access_property_DISPATCH_NAME(val node: nodes.StoredNode) extends AnyVal {
    def dispatchName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 25, node.seq(), "": String)
  }

  class Access_property_DISPATCH_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def dispatchType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 26, node.seq(), "<empty>": String)
  }

  class Access_property_DYNAMIC_TYPE_HINT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 27, node.seq)
  }

  class Access_property_EVALUATION_STRATEGY(val node: nodes.StoredNode) extends AnyVal {
    def evaluationStrategy: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 28, node.seq(), "<empty>": String)
  }

  class Access_property_EVALUATION_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def evaluationType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 29, node.seq(), "<empty>": String)
  }

  class Access_property_EVAL_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def evalType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 30, node.seq(), "<empty>": String)
  }

  class Access_property_EXPLICIT_AS(val node: nodes.StoredNode) extends AnyVal {
    def explicitAs: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 31, node.seq)
  }

  class Access_property_FILENAME(val node: nodes.StoredNode) extends AnyVal {
    def filename: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 32, node.seq(), "<empty>": String)
  }

  class Access_property_FINGERPRINT(val node: nodes.StoredNode) extends AnyVal {
    def fingerprint: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 33, node.seq(), "<empty>": String)
  }

  class Access_property_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def fullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 34, node.seq(), "<empty>": String)
  }

  class Access_property_HASH(val node: nodes.StoredNode) extends AnyVal {
    def hash: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 35, node.seq)
  }

  class Access_property_HAS_MAPPING(val node: nodes.StoredNode) extends AnyVal {
    def hasMapping: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 36, node.seq)
  }

  class Access_property_IMPORTED_AS(val node: nodes.StoredNode) extends AnyVal {
    def importedAs: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 37, node.seq)
  }

  class Access_property_IMPORTED_ENTITY(val node: nodes.StoredNode) extends AnyVal {
    def importedEntity: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 38, node.seq)
  }

  class Access_property_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def index: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 39, node.seq(), -1: Int)
  }

  class Access_property_INHERITS_FROM_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def inheritsFromTypeFullName: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 40, node.seq)
  }

  class Access_property_INTERNAL_FLAGS(val node: nodes.StoredNode) extends AnyVal {
    def internalFlags: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 41, node.seq(), 0: Int)
  }

  class Access_property_IS_EXPLICIT(val node: nodes.StoredNode) extends AnyVal {
    def isExplicit: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 42, node.seq)
  }

  class Access_property_IS_EXTERNAL(val node: nodes.StoredNode) extends AnyVal {
    def isExternal: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 43, node.seq(), false: Boolean)
  }

  class Access_property_IS_METHOD_NEVER_OVERRIDDEN(val node: nodes.StoredNode) extends AnyVal {
    def isMethodNeverOverridden: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 44, node.seq)
  }

  class Access_property_IS_STATIC(val node: nodes.StoredNode) extends AnyVal {
    def isStatic: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 45, node.seq(), false: Boolean)
  }

  class Access_property_IS_VARIADIC(val node: nodes.StoredNode) extends AnyVal {
    def isVariadic: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 46, node.seq(), false: Boolean)
  }

  class Access_property_IS_WILDCARD(val node: nodes.StoredNode) extends AnyVal {
    def isWildcard: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 47, node.seq)
  }

  class Access_property_KEY(val node: nodes.StoredNode) extends AnyVal {
    def key: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 48, node.seq(), "<empty>": String)
  }

  class Access_property_LANGUAGE(val node: nodes.StoredNode) extends AnyVal {
    def language: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 49, node.seq(), "<empty>": String)
  }

  class Access_property_LINE_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def lineNumber: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 50, node.seq)
  }

  class Access_property_LINE_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def lineNumberEnd: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 51, node.seq)
  }

  class Access_property_LITERALS_TO_SINK(val node: nodes.StoredNode) extends AnyVal {
    def literalsToSink: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 52, node.seq)
  }

  class Access_property_METHOD_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 53, node.seq(), "<empty>": String)
  }

  class Access_property_METHOD_INST_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodInstFullName: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 54, node.seq)
  }

  class Access_property_METHOD_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodShortName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 55, node.seq(), "<empty>": String)
  }

  class Access_property_ML_ASSISTED(val node: nodes.StoredNode) extends AnyVal {
    def mlAssisted: Boolean =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 56, node.seq(), false: Boolean)
  }

  class Access_property_MODIFIER_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def modifierType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 57, node.seq(), "<empty>": String)
  }

  class Access_property_NAME(val node: nodes.StoredNode) extends AnyVal {
    def name: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 58, node.seq(), "<empty>": String)
  }

  class Access_property_NODE_LABEL(val node: nodes.StoredNode) extends AnyVal {
    def nodeLabel: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 59, node.seq(), "<empty>": String)
  }

  class Access_property_ORDER(val node: nodes.StoredNode) extends AnyVal {
    def order: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 60, node.seq(), -1: Int)
  }

  class Access_property_OVERLAYS(val node: nodes.StoredNode) extends AnyVal {
    def overlays: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 61, node.seq)
  }

  class Access_property_PACKAGE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def packageName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 62, node.seq(), "<empty>": String)
  }

  class Access_property_PARAMETER_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def parameterIndex: Option[Int] =
      odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 63, node.seq)
  }

  class Access_property_PARSER_TYPE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def parserTypeName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 64, node.seq(), "<empty>": String)
  }

  class Access_property_PATH(val node: nodes.StoredNode) extends AnyVal {
    def path: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 65, node.seq(), "<empty>": String)
  }

  class Access_property_PATTERN(val node: nodes.StoredNode) extends AnyVal {
    def pattern: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 66, node.seq(), "<empty>": String)
  }

  class Access_property_POLICY_DIRECTORIES(val node: nodes.StoredNode) extends AnyVal {
    def policyDirectories: IndexedSeq[String] =
      odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 67, node.seq)
  }

  class Access_property_RESOLVED(val node: nodes.StoredNode) extends AnyVal {
    def resolved: Option[Boolean] =
      odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 68, node.seq)
  }

  class Access_property_ROOT(val node: nodes.StoredNode) extends AnyVal {
    def root: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 69, node.seq(), "<empty>": String)
  }

  class Access_property_SCORE(val node: nodes.StoredNode) extends AnyVal {
    def score: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 70, node.seq(), "<empty>": String)
  }

  class Access_property_SIGNATURE(val node: nodes.StoredNode) extends AnyVal {
    def signature: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 71, node.seq(), "": String)
  }

  class Access_property_SINK_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def sinkType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 72, node.seq(), "<empty>": String)
  }

  class Access_property_SOURCE_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def sourceType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 73, node.seq(), "<empty>": String)
  }

  class Access_property_SPID(val node: nodes.StoredNode) extends AnyVal {
    def spid: Option[String] =
      odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 74, node.seq)
  }

  class Access_property_STRUCTURED_FINGERPRINT(val node: nodes.StoredNode) extends AnyVal {
    def structuredFingerprint: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 75, node.seq(), "null": String)
  }

  class Access_property_SYMBOL(val node: nodes.StoredNode) extends AnyVal {
    def symbol: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 76, node.seq(), "<empty>": String)
  }

  class Access_property_TYPE_DECL_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeDeclFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 77, node.seq(), "<empty>": String)
  }

  class Access_property_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeFullName: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 78, node.seq(), "<empty>": String)
  }

  class Access_property_URL(val node: nodes.StoredNode) extends AnyVal {
    def url: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 79, node.seq(), "<empty>": String)
  }

  class Access_property_VALUE(val node: nodes.StoredNode) extends AnyVal {
    def value: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 80, node.seq(), "": String)
  }

  class Access_property_VARARG_PARAMETER(val node: nodes.StoredNode) extends AnyVal {
    def varargParameter: Int =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 81, node.seq(), -1: Int)
  }

  class Access_property_VAR_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def varType: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 82, node.seq(), "<empty>": String)
  }

  class Access_property_VERSION(val node: nodes.StoredNode) extends AnyVal {
    def version: String =
      odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 83, node.seq(), "<empty>": String)
  }
}

object Lang extends ImplicitAccessors
trait ImplicitAccessors {
  import Accessors._
  implicit def accessPropertyAliasTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]
  ): Access_property_ALIAS_TYPE_FULL_NAME = new Access_property_ALIAS_TYPE_FULL_NAME(node)
  implicit def accessPropertyAnnotationFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationFullNameT]
  ): Access_property_ANNOTATION_FULL_NAME = new Access_property_ANNOTATION_FULL_NAME(node)
  implicit def accessPropertyAnnotationName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationNameT]
  ): Access_property_ANNOTATION_NAME = new Access_property_ANNOTATION_NAME(node)
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
  implicit def accessPropertyBinarySignature(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasBinarySignatureT]
  ): Access_property_BINARY_SIGNATURE = new Access_property_BINARY_SIGNATURE(node)
  implicit def accessPropertyCanonicalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]
  ): Access_property_CANONICAL_NAME = new Access_property_CANONICAL_NAME(node)
  implicit def accessPropertyCategories(node: nodes.StoredNode with nodes.StaticType[nodes.HasCategoriesT]): Access_property_CATEGORIES =
    new Access_property_CATEGORIES(node)
  implicit def accessPropertyCategory(node: nodes.StoredNode with nodes.StaticType[nodes.HasCategoryT]): Access_property_CATEGORY =
    new Access_property_CATEGORY(node)
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
  implicit def accessPropertyDependencyType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyTypeT]
  ): Access_property_DEPENDENCY_TYPE = new Access_property_DEPENDENCY_TYPE(node)
  implicit def accessPropertyDepthFirstOrder(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDepthFirstOrderT]
  ): Access_property_DEPTH_FIRST_ORDER = new Access_property_DEPTH_FIRST_ORDER(node)
  implicit def accessPropertyDescription(node: nodes.StoredNode with nodes.StaticType[nodes.HasDescriptionT]): Access_property_DESCRIPTION =
    new Access_property_DESCRIPTION(node)
  implicit def accessPropertyDispatchName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchNameT]
  ): Access_property_DISPATCH_NAME = new Access_property_DISPATCH_NAME(node)
  implicit def accessPropertyDispatchType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]
  ): Access_property_DISPATCH_TYPE = new Access_property_DISPATCH_TYPE(node)
  implicit def accessPropertyDynamicTypeHintFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]
  ): Access_property_DYNAMIC_TYPE_HINT_FULL_NAME = new Access_property_DYNAMIC_TYPE_HINT_FULL_NAME(node)
  implicit def accessPropertyEvaluationStrategy(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]
  ): Access_property_EVALUATION_STRATEGY = new Access_property_EVALUATION_STRATEGY(node)
  implicit def accessPropertyEvaluationType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationTypeT]
  ): Access_property_EVALUATION_TYPE = new Access_property_EVALUATION_TYPE(node)
  implicit def accessPropertyEvalType(node: nodes.StoredNode with nodes.StaticType[nodes.HasEvalTypeT]): Access_property_EVAL_TYPE =
    new Access_property_EVAL_TYPE(node)
  implicit def accessPropertyExplicitAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]): Access_property_EXPLICIT_AS =
    new Access_property_EXPLICIT_AS(node)
  implicit def accessPropertyFilename(node: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]): Access_property_FILENAME =
    new Access_property_FILENAME(node)
  implicit def accessPropertyFingerprint(node: nodes.StoredNode with nodes.StaticType[nodes.HasFingerprintT]): Access_property_FINGERPRINT =
    new Access_property_FINGERPRINT(node)
  implicit def accessPropertyFullName(node: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]): Access_property_FULL_NAME =
    new Access_property_FULL_NAME(node)
  implicit def accessPropertyHash(node: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]): Access_property_HASH =
    new Access_property_HASH(node)
  implicit def accessPropertyHasMapping(node: nodes.StoredNode with nodes.StaticType[nodes.HasHasMappingT]): Access_property_HAS_MAPPING =
    new Access_property_HAS_MAPPING(node)
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
  implicit def accessPropertyInternalFlags(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasInternalFlagsT]
  ): Access_property_INTERNAL_FLAGS = new Access_property_INTERNAL_FLAGS(node)
  implicit def accessPropertyIsExplicit(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]): Access_property_IS_EXPLICIT =
    new Access_property_IS_EXPLICIT(node)
  implicit def accessPropertyIsExternal(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]): Access_property_IS_EXTERNAL =
    new Access_property_IS_EXTERNAL(node)
  implicit def accessPropertyIsMethodNeverOverridden(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasIsMethodNeverOverriddenT]
  ): Access_property_IS_METHOD_NEVER_OVERRIDDEN = new Access_property_IS_METHOD_NEVER_OVERRIDDEN(node)
  implicit def accessPropertyIsStatic(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsStaticT]): Access_property_IS_STATIC =
    new Access_property_IS_STATIC(node)
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
  implicit def accessPropertyLiteralsToSink(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasLiteralsToSinkT]
  ): Access_property_LITERALS_TO_SINK = new Access_property_LITERALS_TO_SINK(node)
  implicit def accessPropertyMethodFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]
  ): Access_property_METHOD_FULL_NAME = new Access_property_METHOD_FULL_NAME(node)
  implicit def accessPropertyMethodInstFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodInstFullNameT]
  ): Access_property_METHOD_INST_FULL_NAME = new Access_property_METHOD_INST_FULL_NAME(node)
  implicit def accessPropertyMethodShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]
  ): Access_property_METHOD_SHORT_NAME = new Access_property_METHOD_SHORT_NAME(node)
  implicit def accessPropertyMlAssisted(node: nodes.StoredNode with nodes.StaticType[nodes.HasMlAssistedT]): Access_property_ML_ASSISTED =
    new Access_property_ML_ASSISTED(node)
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
  implicit def accessPropertyParameterIndex(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParameterIndexT]
  ): Access_property_PARAMETER_INDEX = new Access_property_PARAMETER_INDEX(node)
  implicit def accessPropertyParserTypeName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]
  ): Access_property_PARSER_TYPE_NAME = new Access_property_PARSER_TYPE_NAME(node)
  implicit def accessPropertyPath(node: nodes.StoredNode with nodes.StaticType[nodes.HasPathT]): Access_property_PATH =
    new Access_property_PATH(node)
  implicit def accessPropertyPattern(node: nodes.StoredNode with nodes.StaticType[nodes.HasPatternT]): Access_property_PATTERN =
    new Access_property_PATTERN(node)
  implicit def accessPropertyPolicyDirectories(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPolicyDirectoriesT]
  ): Access_property_POLICY_DIRECTORIES = new Access_property_POLICY_DIRECTORIES(node)
  implicit def accessPropertyResolved(node: nodes.StoredNode with nodes.StaticType[nodes.HasResolvedT]): Access_property_RESOLVED =
    new Access_property_RESOLVED(node)
  implicit def accessPropertyRoot(node: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]): Access_property_ROOT =
    new Access_property_ROOT(node)
  implicit def accessPropertyScore(node: nodes.StoredNode with nodes.StaticType[nodes.HasScoreT]): Access_property_SCORE =
    new Access_property_SCORE(node)
  implicit def accessPropertySignature(node: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]): Access_property_SIGNATURE =
    new Access_property_SIGNATURE(node)
  implicit def accessPropertySinkType(node: nodes.StoredNode with nodes.StaticType[nodes.HasSinkTypeT]): Access_property_SINK_TYPE =
    new Access_property_SINK_TYPE(node)
  implicit def accessPropertySourceType(node: nodes.StoredNode with nodes.StaticType[nodes.HasSourceTypeT]): Access_property_SOURCE_TYPE =
    new Access_property_SOURCE_TYPE(node)
  implicit def accessPropertySpid(node: nodes.StoredNode with nodes.StaticType[nodes.HasSpidT]): Access_property_SPID =
    new Access_property_SPID(node)
  implicit def accessPropertyStructuredFingerprint(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasStructuredFingerprintT]
  ): Access_property_STRUCTURED_FINGERPRINT = new Access_property_STRUCTURED_FINGERPRINT(node)
  implicit def accessPropertySymbol(node: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]): Access_property_SYMBOL =
    new Access_property_SYMBOL(node)
  implicit def accessPropertyTypeDeclFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]
  ): Access_property_TYPE_DECL_FULL_NAME = new Access_property_TYPE_DECL_FULL_NAME(node)
  implicit def accessPropertyTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]
  ): Access_property_TYPE_FULL_NAME = new Access_property_TYPE_FULL_NAME(node)
  implicit def accessPropertyUrl(node: nodes.StoredNode with nodes.StaticType[nodes.HasUrlT]): Access_property_URL =
    new Access_property_URL(node)
  implicit def accessPropertyValue(node: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]): Access_property_VALUE =
    new Access_property_VALUE(node)
  implicit def accessPropertyVarargParameter(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasVarargParameterT]
  ): Access_property_VARARG_PARAMETER = new Access_property_VARARG_PARAMETER(node)
  implicit def accessPropertyVarType(node: nodes.StoredNode with nodes.StaticType[nodes.HasVarTypeT]): Access_property_VAR_TYPE =
    new Access_property_VAR_TYPE(node)
  implicit def accessPropertyVersion(node: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]): Access_property_VERSION =
    new Access_property_VERSION(node)
}
