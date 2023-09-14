package io.shiftleft.codepropertygraph.generated.v2.accessors
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions {}

object Accessors {
  final class Access_Property_ALIAS_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def aliasTypeFullName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 0, node.seq)
  }
  final class Access_Property_ANNOTATION_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def annotationFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), "<empty>": String)
  }
  final class Access_Property_ANNOTATION_NAME(val node: nodes.StoredNode) extends AnyVal {
    def annotationName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 2, node.seq(), "<empty>": String)
  }
  final class Access_Property_ARGUMENT_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def argumentIndex: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 3, node.seq(), -1: Int)
  }
  final class Access_Property_ARGUMENT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 4, node.seq)
  }
  final class Access_Property_AST_PARENT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def astParentFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 5, node.seq(), "<empty>": String)
  }
  final class Access_Property_AST_PARENT_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def astParentType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 6, node.seq(), "<empty>": String)
  }
  final class Access_Property_BINARY_SIGNATURE(val node: nodes.StoredNode) extends AnyVal {
    def binarySignature: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 7, node.seq)
  }
  final class Access_Property_CANONICAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def canonicalName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 8, node.seq(), "<empty>": String)
  }
  final class Access_Property_CATEGORIES(val node: nodes.StoredNode) extends AnyVal {
    def categories: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 9, node.seq)
  }
  final class Access_Property_CATEGORY(val node: nodes.StoredNode) extends AnyVal {
    def category: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 10, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLASS_NAME(val node: nodes.StoredNode) extends AnyVal {
    def className: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 11, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLASS_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def classShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 12, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLOSURE_BINDING_ID(val node: nodes.StoredNode) extends AnyVal {
    def closureBindingId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 13, node.seq)
  }
  final class Access_Property_CLOSURE_ORIGINAL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def closureOriginalName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 14, node.seq)
  }
  final class Access_Property_CODE(val node: nodes.StoredNode) extends AnyVal {
    def code: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 15, node.seq(), "<empty>": String)
  }
  final class Access_Property_COLUMN_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 16, node.seq)
  }
  final class Access_Property_COLUMN_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def columnNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 17, node.seq)
  }
  final class Access_Property_CONTAINED_REF(val node: nodes.StoredNode) extends AnyVal {
    def containedRef: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 18, node.seq(), "<empty>": String)
  }
  final class Access_Property_CONTENT(val node: nodes.StoredNode) extends AnyVal {
    def content: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 19, node.seq(), "<empty>": String)
  }
  final class Access_Property_CONTROL_STRUCTURE_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def controlStructureType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 20, node.seq(), "<empty>": String)
  }
  final class Access_Property_DEPENDENCY_GROUP_ID(val node: nodes.StoredNode) extends AnyVal {
    def dependencyGroupId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 21, node.seq)
  }
  final class Access_Property_DEPENDENCY_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def dependencyType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 22, node.seq(), "<empty>": String)
  }
  final class Access_Property_DEPTH_FIRST_ORDER(val node: nodes.StoredNode) extends AnyVal {
    def depthFirstOrder: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 23, node.seq(), -1: Int)
  }
  final class Access_Property_DESCRIPTION(val node: nodes.StoredNode) extends AnyVal {
    def description: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 24, node.seq(), "<empty>": String)
  }
  final class Access_Property_DISPATCH_NAME(val node: nodes.StoredNode) extends AnyVal {
    def dispatchName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 25, node.seq(), "": String)
  }
  final class Access_Property_DISPATCH_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def dispatchType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 26, node.seq(), "<empty>": String)
  }
  final class Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 27, node.seq)
  }
  final class Access_Property_EVALUATION_STRATEGY(val node: nodes.StoredNode) extends AnyVal {
    def evaluationStrategy: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 28, node.seq(), "<empty>": String)
  }
  final class Access_Property_EVALUATION_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def evaluationType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 29, node.seq(), "<empty>": String)
  }
  final class Access_Property_EVAL_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def evalType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 30, node.seq(), "<empty>": String)
  }
  final class Access_Property_EXPLICIT_AS(val node: nodes.StoredNode) extends AnyVal {
    def explicitAs: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 31, node.seq)
  }
  final class Access_Property_FILENAME(val node: nodes.StoredNode) extends AnyVal {
    def filename: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 32, node.seq(), "<empty>": String)
  }
  final class Access_Property_FINGERPRINT(val node: nodes.StoredNode) extends AnyVal {
    def fingerprint: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 33, node.seq(), "<empty>": String)
  }
  final class Access_Property_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def fullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 34, node.seq(), "<empty>": String)
  }
  final class Access_Property_HASH(val node: nodes.StoredNode) extends AnyVal {
    def hash: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 35, node.seq)
  }
  final class Access_Property_HAS_MAPPING(val node: nodes.StoredNode) extends AnyVal {
    def hasMapping: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 36, node.seq)
  }
  final class Access_Property_IMPORTED_AS(val node: nodes.StoredNode) extends AnyVal {
    def importedAs: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 37, node.seq)
  }
  final class Access_Property_IMPORTED_ENTITY(val node: nodes.StoredNode) extends AnyVal {
    def importedEntity: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 38, node.seq)
  }
  final class Access_Property_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def index: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 39, node.seq(), -1: Int)
  }
  final class Access_Property_INHERITS_FROM_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def inheritsFromTypeFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 40, node.seq)
  }
  final class Access_Property_INTERNAL_FLAGS(val node: nodes.StoredNode) extends AnyVal {
    def internalFlags: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 41, node.seq(), 0: Int)
  }
  final class Access_Property_IS_EXPLICIT(val node: nodes.StoredNode) extends AnyVal {
    def isExplicit: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 42, node.seq)
  }
  final class Access_Property_IS_EXTERNAL(val node: nodes.StoredNode) extends AnyVal {
    def isExternal: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 43, node.seq(), false: Boolean)
  }
  final class Access_Property_IS_METHOD_NEVER_OVERRIDDEN(val node: nodes.StoredNode) extends AnyVal {
    def isMethodNeverOverridden: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 44, node.seq)
  }
  final class Access_Property_IS_STATIC(val node: nodes.StoredNode) extends AnyVal {
    def isStatic: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 45, node.seq(), false: Boolean)
  }
  final class Access_Property_IS_VARIADIC(val node: nodes.StoredNode) extends AnyVal {
    def isVariadic: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 46, node.seq(), false: Boolean)
  }
  final class Access_Property_IS_WILDCARD(val node: nodes.StoredNode) extends AnyVal {
    def isWildcard: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 47, node.seq)
  }
  final class Access_Property_KEY(val node: nodes.StoredNode) extends AnyVal {
    def key: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 48, node.seq(), "<empty>": String)
  }
  final class Access_Property_LANGUAGE(val node: nodes.StoredNode) extends AnyVal {
    def language: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 49, node.seq(), "<empty>": String)
  }
  final class Access_Property_LINE_NUMBER(val node: nodes.StoredNode) extends AnyVal {
    def lineNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 50, node.seq)
  }
  final class Access_Property_LINE_NUMBER_END(val node: nodes.StoredNode) extends AnyVal {
    def lineNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 51, node.seq)
  }
  final class Access_Property_LITERALS_TO_SINK(val node: nodes.StoredNode) extends AnyVal {
    def literalsToSink: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 52, node.seq)
  }
  final class Access_Property_METHOD_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 53, node.seq(), "<empty>": String)
  }
  final class Access_Property_METHOD_INST_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodInstFullName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 54, node.seq)
  }
  final class Access_Property_METHOD_SHORT_NAME(val node: nodes.StoredNode) extends AnyVal {
    def methodShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 55, node.seq(), "<empty>": String)
  }
  final class Access_Property_ML_ASSISTED(val node: nodes.StoredNode) extends AnyVal {
    def mlAssisted: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 56, node.seq(), false: Boolean)
  }
  final class Access_Property_MODIFIER_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def modifierType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 57, node.seq(), "<empty>": String)
  }
  final class Access_Property_NAME(val node: nodes.StoredNode) extends AnyVal {
    def name: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 58, node.seq(), "<empty>": String)
  }
  final class Access_Property_NODE_LABEL(val node: nodes.StoredNode) extends AnyVal {
    def nodeLabel: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 59, node.seq(), "<empty>": String)
  }
  final class Access_Property_ORDER(val node: nodes.StoredNode) extends AnyVal {
    def order: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 60, node.seq(), -1: Int)
  }
  final class Access_Property_OVERLAYS(val node: nodes.StoredNode) extends AnyVal {
    def overlays: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 61, node.seq)
  }
  final class Access_Property_PACKAGE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def packageName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 62, node.seq(), "<empty>": String)
  }
  final class Access_Property_PARAMETER_INDEX(val node: nodes.StoredNode) extends AnyVal {
    def parameterIndex: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 63, node.seq)
  }
  final class Access_Property_PARSER_TYPE_NAME(val node: nodes.StoredNode) extends AnyVal {
    def parserTypeName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 64, node.seq(), "<empty>": String)
  }
  final class Access_Property_PATH(val node: nodes.StoredNode) extends AnyVal {
    def path: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 65, node.seq(), "<empty>": String)
  }
  final class Access_Property_PATTERN(val node: nodes.StoredNode) extends AnyVal {
    def pattern: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 66, node.seq(), "<empty>": String)
  }
  final class Access_Property_POLICY_DIRECTORIES(val node: nodes.StoredNode) extends AnyVal {
    def policyDirectories: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 67, node.seq)
  }
  final class Access_Property_POSSIBLE_TYPES(val node: nodes.StoredNode) extends AnyVal {
    def possibleTypes: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 68, node.seq)
  }
  final class Access_Property_RESOLVED(val node: nodes.StoredNode) extends AnyVal {
    def resolved: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 69, node.seq)
  }
  final class Access_Property_ROOT(val node: nodes.StoredNode) extends AnyVal {
    def root: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 70, node.seq(), "<empty>": String)
  }
  final class Access_Property_SCORE(val node: nodes.StoredNode) extends AnyVal {
    def score: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 71, node.seq(), "<empty>": String)
  }
  final class Access_Property_SIGNATURE(val node: nodes.StoredNode) extends AnyVal {
    def signature: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 72, node.seq(), "": String)
  }
  final class Access_Property_SINK_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def sinkType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 73, node.seq(), "<empty>": String)
  }
  final class Access_Property_SOURCE_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def sourceType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 74, node.seq(), "<empty>": String)
  }
  final class Access_Property_SPID(val node: nodes.StoredNode) extends AnyVal {
    def spid: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 75, node.seq)
  }
  final class Access_Property_STRUCTURED_FINGERPRINT(val node: nodes.StoredNode) extends AnyVal {
    def structuredFingerprint: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 76, node.seq(), "null": String)
  }
  final class Access_Property_SYMBOL(val node: nodes.StoredNode) extends AnyVal {
    def symbol: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 77, node.seq(), "<empty>": String)
  }
  final class Access_Property_TYPE_DECL_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeDeclFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 78, node.seq(), "<empty>": String)
  }
  final class Access_Property_TYPE_FULL_NAME(val node: nodes.StoredNode) extends AnyVal {
    def typeFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 79, node.seq(), "<empty>": String)
  }
  final class Access_Property_URL(val node: nodes.StoredNode) extends AnyVal {
    def url: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 80, node.seq(), "<empty>": String)
  }
  final class Access_Property_VALUE(val node: nodes.StoredNode) extends AnyVal {
    def value: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 81, node.seq(), "": String)
  }
  final class Access_Property_VARARG_PARAMETER(val node: nodes.StoredNode) extends AnyVal {
    def varargParameter: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 82, node.seq(), -1: Int)
  }
  final class Access_Property_VAR_TYPE(val node: nodes.StoredNode) extends AnyVal {
    def varType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 83, node.seq(), "<empty>": String)
  }
  final class Access_Property_VERSION(val node: nodes.StoredNode) extends AnyVal {
    def version: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 84, node.seq(), "<empty>": String)
  }
  //
  final class Access_AnnotationBase(val node: nodes.AnnotationBase) extends AnyVal {
    def fullName: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewAnnotation => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_NAME(stored).name
      case newNode: nodes.NewAnnotation => newNode.name
    }
  }
  final class Access_AnnotationLiteralBase(val node: nodes.AnnotationLiteralBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_NAME(stored).name
      case newNode: nodes.NewAnnotationLiteral => newNode.name
    }
  }
  final class Access_AnnotationParameterBase(val node: nodes.AnnotationParameterBase)             extends AnyVal {}
  final class Access_AnnotationParameterAssignBase(val node: nodes.AnnotationParameterAssignBase) extends AnyVal {}
  final class Access_ArrayInitializerBase(val node: nodes.ArrayInitializerBase)                   extends AnyVal {}
  final class Access_BindingBase(val node: nodes.BindingBase) extends AnyVal {
    def isMethodNeverOverridden: Option[Boolean] = node match {
      case stored: nodes.StoredNode  => new Access_Property_IS_METHOD_NEVER_OVERRIDDEN(stored).isMethodNeverOverridden
      case newNode: nodes.NewBinding => newNode.isMethodNeverOverridden
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: nodes.NewBinding => newNode.methodFullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_NAME(stored).name
      case newNode: nodes.NewBinding => newNode.name
    }
    def signature: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_SIGNATURE(stored).signature
      case newNode: nodes.NewBinding => newNode.signature
    }
  }
  final class Access_BlockBase(val node: nodes.BlockBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewBlock  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewBlock  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewBlock  => newNode.typeFullName
    }
  }
  final class Access_CallBase(val node: nodes.CallBase) extends AnyVal {
    def dispatchName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_DISPATCH_NAME(stored).dispatchName
      case newNode: nodes.NewCall   => newNode.dispatchName
    }
    def dispatchType: String = node match {
      case stored: nodes.StoredNode => new Access_Property_DISPATCH_TYPE(stored).dispatchType
      case newNode: nodes.NewCall   => newNode.dispatchType
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewCall   => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: nodes.NewCall   => newNode.methodFullName
    }
    def methodInstFullName: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_METHOD_INST_FULL_NAME(stored).methodInstFullName
      case newNode: nodes.NewCall   => newNode.methodInstFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewCall   => newNode.possibleTypes
    }
    def resolved: Option[Boolean] = node match {
      case stored: nodes.StoredNode => new Access_Property_RESOLVED(stored).resolved
      case newNode: nodes.NewCall   => newNode.resolved
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewCall   => newNode.typeFullName
    }
  }
  final class Access_CallChainBase(val node: nodes.CallChainBase) extends AnyVal {}
  final class Access_CallSiteBase(val node: nodes.CallSiteBase)   extends AnyVal {}
  final class Access_ClosureBindingBase(val node: nodes.ClosureBindingBase) extends AnyVal {
    def closureBindingId: Option[String] = node match {
      case stored: nodes.StoredNode         => new Access_Property_CLOSURE_BINDING_ID(stored).closureBindingId
      case newNode: nodes.NewClosureBinding => newNode.closureBindingId
    }
    def closureOriginalName: Option[String] = node match {
      case stored: nodes.StoredNode         => new Access_Property_CLOSURE_ORIGINAL_NAME(stored).closureOriginalName
      case newNode: nodes.NewClosureBinding => newNode.closureOriginalName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode         => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: nodes.NewClosureBinding => newNode.evaluationStrategy
    }
  }
  final class Access_CommentBase(val node: nodes.CommentBase) extends AnyVal {
    def filename: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_FILENAME(stored).filename
      case newNode: nodes.NewComment => newNode.filename
    }
  }
  final class Access_ConfigFileBase(val node: nodes.ConfigFileBase) extends AnyVal {
    def content: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_CONTENT(stored).content
      case newNode: nodes.NewConfigFile => newNode.content
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_NAME(stored).name
      case newNode: nodes.NewConfigFile => newNode.name
    }
  }
  final class Access_ControlStructureBase(val node: nodes.ControlStructureBase) extends AnyVal {
    def controlStructureType: String = node match {
      case stored: nodes.StoredNode           => new Access_Property_CONTROL_STRUCTURE_TYPE(stored).controlStructureType
      case newNode: nodes.NewControlStructure => newNode.controlStructureType
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode           => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: nodes.NewControlStructure => newNode.parserTypeName
    }
  }
  final class Access_DependencyBase(val node: nodes.DependencyBase) extends AnyVal {
    def dependencyGroupId: Option[String] = node match {
      case stored: nodes.StoredNode     => new Access_Property_DEPENDENCY_GROUP_ID(stored).dependencyGroupId
      case newNode: nodes.NewDependency => newNode.dependencyGroupId
    }
    def dependencyType: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_DEPENDENCY_TYPE(stored).dependencyType
      case newNode: nodes.NewDependency => newNode.dependencyType
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_NAME(stored).name
      case newNode: nodes.NewDependency => newNode.name
    }
    def version: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_VERSION(stored).version
      case newNode: nodes.NewDependency => newNode.version
    }
  }
  final class Access_DomAttributeBase(val node: nodes.DomAttributeBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_NAME(stored).name
      case newNode: nodes.NewDomAttribute => newNode.name
    }
    def value: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_VALUE(stored).value
      case newNode: nodes.NewDomAttribute => newNode.value
    }
  }
  final class Access_DomNodeBase(val node: nodes.DomNodeBase) extends AnyVal {
    def columnNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => new Access_Property_COLUMN_NUMBER(stored).columnNumber
      case newNode: nodes.NewDomNode => newNode.columnNumber
    }
    def lineNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => new Access_Property_LINE_NUMBER(stored).lineNumber
      case newNode: nodes.NewDomNode => newNode.lineNumber
    }
    def name: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_NAME(stored).name
      case newNode: nodes.NewDomNode => newNode.name
    }
  }
  final class Access_FieldIdentifierBase(val node: nodes.FieldIdentifierBase) extends AnyVal {
    def canonicalName: String = node match {
      case stored: nodes.StoredNode          => new Access_Property_CANONICAL_NAME(stored).canonicalName
      case newNode: nodes.NewFieldIdentifier => newNode.canonicalName
    }
  }
  final class Access_FileBase(val node: nodes.FileBase) extends AnyVal {
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_HASH(stored).hash
      case newNode: nodes.NewFile   => newNode.hash
    }
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_NAME(stored).name
      case newNode: nodes.NewFile   => newNode.name
    }
  }
  final class Access_FindingBase(val node: nodes.FindingBase) extends AnyVal {
    def structuredFingerprint: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_STRUCTURED_FINGERPRINT(stored).structuredFingerprint
      case newNode: nodes.NewFinding => newNode.structuredFingerprint
    }
  }
  final class Access_FlowBase(val node: nodes.FlowBase) extends AnyVal {}
  final class Access_FrameworkBase(val node: nodes.FrameworkBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_NAME(stored).name
      case newNode: nodes.NewFramework => newNode.name
    }
  }
  final class Access_FrameworkDataBase(val node: nodes.FrameworkDataBase) extends AnyVal {
    def content: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_CONTENT(stored).content
      case newNode: nodes.NewFrameworkData => newNode.content
    }
    def name: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_NAME(stored).name
      case newNode: nodes.NewFrameworkData => newNode.name
    }
  }
  final class Access_IdentifierBase(val node: nodes.IdentifierBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode     => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewIdentifier => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode     => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewIdentifier => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewIdentifier => newNode.typeFullName
    }
  }
  final class Access_ImplicitCallBase(val node: nodes.ImplicitCallBase) extends AnyVal {}
  final class Access_ImportBase(val node: nodes.ImportBase) extends AnyVal {
    def explicitAs: Option[Boolean] = node match {
      case stored: nodes.StoredNode => new Access_Property_EXPLICIT_AS(stored).explicitAs
      case newNode: nodes.NewImport => newNode.explicitAs
    }
    def importedAs: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_IMPORTED_AS(stored).importedAs
      case newNode: nodes.NewImport => newNode.importedAs
    }
    def importedEntity: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_IMPORTED_ENTITY(stored).importedEntity
      case newNode: nodes.NewImport => newNode.importedEntity
    }
    def isExplicit: Option[Boolean] = node match {
      case stored: nodes.StoredNode => new Access_Property_IS_EXPLICIT(stored).isExplicit
      case newNode: nodes.NewImport => newNode.isExplicit
    }
    def isWildcard: Option[Boolean] = node match {
      case stored: nodes.StoredNode => new Access_Property_IS_WILDCARD(stored).isWildcard
      case newNode: nodes.NewImport => newNode.isWildcard
    }
  }
  final class Access_IoflowBase(val node: nodes.IoflowBase) extends AnyVal {
    def fingerprint: String = node match {
      case stored: nodes.StoredNode => new Access_Property_FINGERPRINT(stored).fingerprint
      case newNode: nodes.NewIoflow => newNode.fingerprint
    }
    def literalsToSink: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_LITERALS_TO_SINK(stored).literalsToSink
      case newNode: nodes.NewIoflow => newNode.literalsToSink
    }
    def mlAssisted: Boolean = node match {
      case stored: nodes.StoredNode => new Access_Property_ML_ASSISTED(stored).mlAssisted
      case newNode: nodes.NewIoflow => newNode.mlAssisted
    }
  }
  final class Access_JumpLabelBase(val node: nodes.JumpLabelBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_NAME(stored).name
      case newNode: nodes.NewJumpLabel => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: nodes.NewJumpLabel => newNode.parserTypeName
    }
  }
  final class Access_JumpTargetBase(val node: nodes.JumpTargetBase) extends AnyVal {
    def argumentIndex: Int = node match {
      case stored: nodes.StoredNode     => new Access_Property_ARGUMENT_INDEX(stored).argumentIndex
      case newNode: nodes.NewJumpTarget => newNode.argumentIndex
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_NAME(stored).name
      case newNode: nodes.NewJumpTarget => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: nodes.NewJumpTarget => newNode.parserTypeName
    }
  }
  final class Access_KeyValuePairBase(val node: nodes.KeyValuePairBase) extends AnyVal {
    def key: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_KEY(stored).key
      case newNode: nodes.NewKeyValuePair => newNode.key
    }
    def value: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_VALUE(stored).value
      case newNode: nodes.NewKeyValuePair => newNode.value
    }
  }
  final class Access_LiteralBase(val node: nodes.LiteralBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewLiteral => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewLiteral => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewLiteral => newNode.typeFullName
    }
  }
  final class Access_LocalBase(val node: nodes.LocalBase) extends AnyVal {
    def closureBindingId: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_CLOSURE_BINDING_ID(stored).closureBindingId
      case newNode: nodes.NewLocal  => newNode.closureBindingId
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewLocal  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewLocal  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewLocal  => newNode.typeFullName
    }
  }
  final class Access_LocationBase(val node: nodes.LocationBase) extends AnyVal {
    def className: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_CLASS_NAME(stored).className
      case newNode: nodes.NewLocation => newNode.className
    }
    def classShortName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_CLASS_SHORT_NAME(stored).classShortName
      case newNode: nodes.NewLocation => newNode.classShortName
    }
    def filename: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_FILENAME(stored).filename
      case newNode: nodes.NewLocation => newNode.filename
    }
    def lineNumber: Option[Int] = node match {
      case stored: nodes.StoredNode   => new Access_Property_LINE_NUMBER(stored).lineNumber
      case newNode: nodes.NewLocation => newNode.lineNumber
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: nodes.NewLocation => newNode.methodFullName
    }
    def methodShortName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_METHOD_SHORT_NAME(stored).methodShortName
      case newNode: nodes.NewLocation => newNode.methodShortName
    }
    def nodeLabel: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_NODE_LABEL(stored).nodeLabel
      case newNode: nodes.NewLocation => newNode.nodeLabel
    }
    def packageName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_PACKAGE_NAME(stored).packageName
      case newNode: nodes.NewLocation => newNode.packageName
    }
    def symbol: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_SYMBOL(stored).symbol
      case newNode: nodes.NewLocation => newNode.symbol
    }
  }
  final class Access_MatchInfoBase(val node: nodes.MatchInfoBase) extends AnyVal {
    def category: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_CATEGORY(stored).category
      case newNode: nodes.NewMatchInfo => newNode.category
    }
    def pattern: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_PATTERN(stored).pattern
      case newNode: nodes.NewMatchInfo => newNode.pattern
    }
  }
  final class Access_MemberBase(val node: nodes.MemberBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewMember => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewMember => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewMember => newNode.typeFullName
    }
  }
  final class Access_MetaDataBase(val node: nodes.MetaDataBase) extends AnyVal {
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_HASH(stored).hash
      case newNode: nodes.NewMetaData => newNode.hash
    }
    def language: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_LANGUAGE(stored).language
      case newNode: nodes.NewMetaData => newNode.language
    }
    def overlays: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_OVERLAYS(stored).overlays
      case newNode: nodes.NewMetaData => newNode.overlays
    }
    def policyDirectories: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_POLICY_DIRECTORIES(stored).policyDirectories
      case newNode: nodes.NewMetaData => newNode.policyDirectories
    }
    def root: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_ROOT(stored).root
      case newNode: nodes.NewMetaData => newNode.root
    }
    def spid: Option[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_SPID(stored).spid
      case newNode: nodes.NewMetaData => newNode.spid
    }
    def version: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_VERSION(stored).version
      case newNode: nodes.NewMetaData => newNode.version
    }
  }
  final class Access_MethodBase(val node: nodes.MethodBase) extends AnyVal {
    def astParentFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_AST_PARENT_FULL_NAME(stored).astParentFullName
      case newNode: nodes.NewMethod => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: nodes.StoredNode => new Access_Property_AST_PARENT_TYPE(stored).astParentType
      case newNode: nodes.NewMethod => newNode.astParentType
    }
    def binarySignature: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_BINARY_SIGNATURE(stored).binarySignature
      case newNode: nodes.NewMethod => newNode.binarySignature
    }
    def columnNumberEnd: Option[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_COLUMN_NUMBER_END(stored).columnNumberEnd
      case newNode: nodes.NewMethod => newNode.columnNumberEnd
    }
    def filename: String = node match {
      case stored: nodes.StoredNode => new Access_Property_FILENAME(stored).filename
      case newNode: nodes.NewMethod => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewMethod => newNode.fullName
    }
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_HASH(stored).hash
      case newNode: nodes.NewMethod => newNode.hash
    }
    def hasMapping: Option[Boolean] = node match {
      case stored: nodes.StoredNode => new Access_Property_HAS_MAPPING(stored).hasMapping
      case newNode: nodes.NewMethod => newNode.hasMapping
    }
    def isExternal: Boolean = node match {
      case stored: nodes.StoredNode => new Access_Property_IS_EXTERNAL(stored).isExternal
      case newNode: nodes.NewMethod => newNode.isExternal
    }
    def lineNumberEnd: Option[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_LINE_NUMBER_END(stored).lineNumberEnd
      case newNode: nodes.NewMethod => newNode.lineNumberEnd
    }
    def signature: String = node match {
      case stored: nodes.StoredNode => new Access_Property_SIGNATURE(stored).signature
      case newNode: nodes.NewMethod => newNode.signature
    }
    def varargParameter: Int = node match {
      case stored: nodes.StoredNode => new Access_Property_VARARG_PARAMETER(stored).varargParameter
      case newNode: nodes.NewMethod => newNode.varargParameter
    }
  }
  final class Access_MethodInstBase(val node: nodes.MethodInstBase) extends AnyVal {
    def fullName: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewMethodInst => newNode.fullName
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: nodes.NewMethodInst => newNode.methodFullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_NAME(stored).name
      case newNode: nodes.NewMethodInst => newNode.name
    }
    def signature: String = node match {
      case stored: nodes.StoredNode     => new Access_Property_SIGNATURE(stored).signature
      case newNode: nodes.NewMethodInst => newNode.signature
    }
  }
  final class Access_MethodParameterInBase(val node: nodes.MethodParameterInBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode            => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewMethodParameterIn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: nodes.NewMethodParameterIn => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: nodes.StoredNode            => new Access_Property_INDEX(stored).index
      case newNode: nodes.NewMethodParameterIn => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: nodes.StoredNode            => new Access_Property_IS_VARIADIC(stored).isVariadic
      case newNode: nodes.NewMethodParameterIn => newNode.isVariadic
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode            => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewMethodParameterIn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewMethodParameterIn => newNode.typeFullName
    }
  }
  final class Access_MethodParameterOutBase(val node: nodes.MethodParameterOutBase) extends AnyVal {
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode             => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: nodes.NewMethodParameterOut => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: nodes.StoredNode             => new Access_Property_INDEX(stored).index
      case newNode: nodes.NewMethodParameterOut => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: nodes.StoredNode             => new Access_Property_IS_VARIADIC(stored).isVariadic
      case newNode: nodes.NewMethodParameterOut => newNode.isVariadic
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode             => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewMethodParameterOut => newNode.typeFullName
    }
  }
  final class Access_MethodRefBase(val node: nodes.MethodRefBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode    => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewMethodRef => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: nodes.NewMethodRef => newNode.methodFullName
    }
    def methodInstFullName: Option[String] = node match {
      case stored: nodes.StoredNode    => new Access_Property_METHOD_INST_FULL_NAME(stored).methodInstFullName
      case newNode: nodes.NewMethodRef => newNode.methodInstFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode    => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewMethodRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewMethodRef => newNode.typeFullName
    }
  }
  final class Access_MethodReturnBase(val node: nodes.MethodReturnBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode       => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewMethodReturn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: nodes.NewMethodReturn => newNode.evaluationStrategy
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode       => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewMethodReturn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewMethodReturn => newNode.typeFullName
    }
  }
  final class Access_MethodSummaryBase(val node: nodes.MethodSummaryBase) extends AnyVal {
    def binarySignature: Option[String] = node match {
      case stored: nodes.StoredNode        => new Access_Property_BINARY_SIGNATURE(stored).binarySignature
      case newNode: nodes.NewMethodSummary => newNode.binarySignature
    }
    def isExternal: Boolean = node match {
      case stored: nodes.StoredNode        => new Access_Property_IS_EXTERNAL(stored).isExternal
      case newNode: nodes.NewMethodSummary => newNode.isExternal
    }
    def isStatic: Boolean = node match {
      case stored: nodes.StoredNode        => new Access_Property_IS_STATIC(stored).isStatic
      case newNode: nodes.NewMethodSummary => newNode.isStatic
    }
  }
  final class Access_ModifierBase(val node: nodes.ModifierBase) extends AnyVal {
    def modifierType: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_MODIFIER_TYPE(stored).modifierType
      case newNode: nodes.NewModifier => newNode.modifierType
    }
  }
  final class Access_NamespaceBase(val node: nodes.NamespaceBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_NAME(stored).name
      case newNode: nodes.NewNamespace => newNode.name
    }
  }
  final class Access_NamespaceBlockBase(val node: nodes.NamespaceBlockBase) extends AnyVal {
    def filename: String = node match {
      case stored: nodes.StoredNode         => new Access_Property_FILENAME(stored).filename
      case newNode: nodes.NewNamespaceBlock => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode         => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewNamespaceBlock => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode         => new Access_Property_NAME(stored).name
      case newNode: nodes.NewNamespaceBlock => newNode.name
    }
  }
  final class Access_PackagePrefixBase(val node: nodes.PackagePrefixBase) extends AnyVal {
    def value: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_VALUE(stored).value
      case newNode: nodes.NewPackagePrefix => newNode.value
    }
  }
  final class Access_PostExecutionCallBase(val node: nodes.PostExecutionCallBase) extends AnyVal {}
  final class Access_ProgramPointBase(val node: nodes.ProgramPointBase)           extends AnyVal {}
  final class Access_ReadBase(val node: nodes.ReadBase)                           extends AnyVal {}
  final class Access_ReturnBase(val node: nodes.ReturnBase)                       extends AnyVal {}
  final class Access_RouteBase(val node: nodes.RouteBase) extends AnyVal {
    def path: String = node match {
      case stored: nodes.StoredNode => new Access_Property_PATH(stored).path
      case newNode: nodes.NewRoute  => newNode.path
    }
  }
  final class Access_SensitiveDataTypeBase(val node: nodes.SensitiveDataTypeBase) extends AnyVal {
    def fullName: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewSensitiveDataType => newNode.fullName
    }
  }
  final class Access_SensitiveMemberBase(val node: nodes.SensitiveMemberBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode          => new Access_Property_NAME(stored).name
      case newNode: nodes.NewSensitiveMember => newNode.name
    }
  }
  final class Access_SensitiveReferenceBase(val node: nodes.SensitiveReferenceBase) extends AnyVal {}
  final class Access_SensitiveVariableBase(val node: nodes.SensitiveVariableBase) extends AnyVal {
    def categories: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode            => new Access_Property_CATEGORIES(stored).categories
      case newNode: nodes.NewSensitiveVariable => newNode.categories
    }
    def evalType: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_EVAL_TYPE(stored).evalType
      case newNode: nodes.NewSensitiveVariable => newNode.evalType
    }
    def name: String = node match {
      case stored: nodes.StoredNode            => new Access_Property_NAME(stored).name
      case newNode: nodes.NewSensitiveVariable => newNode.name
    }
  }
  final class Access_SinkBase(val node: nodes.SinkBase) extends AnyVal {
    def sinkType: String = node match {
      case stored: nodes.StoredNode => new Access_Property_SINK_TYPE(stored).sinkType
      case newNode: nodes.NewSink   => newNode.sinkType
    }
    def structuredFingerprint: String = node match {
      case stored: nodes.StoredNode => new Access_Property_STRUCTURED_FINGERPRINT(stored).structuredFingerprint
      case newNode: nodes.NewSink   => newNode.structuredFingerprint
    }
  }
  final class Access_SourceBase(val node: nodes.SourceBase) extends AnyVal {
    def sourceType: String = node match {
      case stored: nodes.StoredNode => new Access_Property_SOURCE_TYPE(stored).sourceType
      case newNode: nodes.NewSource => newNode.sourceType
    }
    def structuredFingerprint: String = node match {
      case stored: nodes.StoredNode => new Access_Property_STRUCTURED_FINGERPRINT(stored).structuredFingerprint
      case newNode: nodes.NewSource => newNode.structuredFingerprint
    }
  }
  final class Access_SpAnnotationParameterBase(val node: nodes.SpAnnotationParameterBase) extends AnyVal {
    def annotationFullName: String = node match {
      case stored: nodes.StoredNode                => new Access_Property_ANNOTATION_FULL_NAME(stored).annotationFullName
      case newNode: nodes.NewSpAnnotationParameter => newNode.annotationFullName
    }
    def annotationName: String = node match {
      case stored: nodes.StoredNode                => new Access_Property_ANNOTATION_NAME(stored).annotationName
      case newNode: nodes.NewSpAnnotationParameter => newNode.annotationName
    }
    def name: String = node match {
      case stored: nodes.StoredNode                => new Access_Property_NAME(stored).name
      case newNode: nodes.NewSpAnnotationParameter => newNode.name
    }
    def value: String = node match {
      case stored: nodes.StoredNode                => new Access_Property_VALUE(stored).value
      case newNode: nodes.NewSpAnnotationParameter => newNode.value
    }
  }
  final class Access_SpBlacklistBase(val node: nodes.SpBlacklistBase) extends AnyVal {}
  final class Access_TagBase(val node: nodes.TagBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_NAME(stored).name
      case newNode: nodes.NewTag    => newNode.name
    }
    def value: String = node match {
      case stored: nodes.StoredNode => new Access_Property_VALUE(stored).value
      case newNode: nodes.NewTag    => newNode.value
    }
  }
  final class Access_TagsBase(val node: nodes.TagsBase)               extends AnyVal {}
  final class Access_TagNodePairBase(val node: nodes.TagNodePairBase) extends AnyVal {}
  final class Access_TemplateDomBase(val node: nodes.TemplateDomBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode      => new Access_Property_NAME(stored).name
      case newNode: nodes.NewTemplateDom => newNode.name
    }
  }
  final class Access_TransformBase(val node: nodes.TransformBase)           extends AnyVal {}
  final class Access_TransformationBase(val node: nodes.TransformationBase) extends AnyVal {}
  final class Access_TypeBase(val node: nodes.TypeBase) extends AnyVal {
    def fullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewType   => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_NAME(stored).name
      case newNode: nodes.NewType   => newNode.name
    }
    def typeDeclFullName: String = node match {
      case stored: nodes.StoredNode => new Access_Property_TYPE_DECL_FULL_NAME(stored).typeDeclFullName
      case newNode: nodes.NewType   => newNode.typeDeclFullName
    }
  }
  final class Access_TypeArgumentBase(val node: nodes.TypeArgumentBase) extends AnyVal {}
  final class Access_TypeDeclBase(val node: nodes.TypeDeclBase) extends AnyVal {
    def aliasTypeFullName: Option[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_ALIAS_TYPE_FULL_NAME(stored).aliasTypeFullName
      case newNode: nodes.NewTypeDecl => newNode.aliasTypeFullName
    }
    def astParentFullName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_AST_PARENT_FULL_NAME(stored).astParentFullName
      case newNode: nodes.NewTypeDecl => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_AST_PARENT_TYPE(stored).astParentType
      case newNode: nodes.NewTypeDecl => newNode.astParentType
    }
    def filename: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_FILENAME(stored).filename
      case newNode: nodes.NewTypeDecl => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_FULL_NAME(stored).fullName
      case newNode: nodes.NewTypeDecl => newNode.fullName
    }
    def inheritsFromTypeFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode   => new Access_Property_INHERITS_FROM_TYPE_FULL_NAME(stored).inheritsFromTypeFullName
      case newNode: nodes.NewTypeDecl => newNode.inheritsFromTypeFullName
    }
    def isExternal: Boolean = node match {
      case stored: nodes.StoredNode   => new Access_Property_IS_EXTERNAL(stored).isExternal
      case newNode: nodes.NewTypeDecl => newNode.isExternal
    }
    def name: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_NAME(stored).name
      case newNode: nodes.NewTypeDecl => newNode.name
    }
  }
  final class Access_TypeParameterBase(val node: nodes.TypeParameterBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_NAME(stored).name
      case newNode: nodes.NewTypeParameter => newNode.name
    }
  }
  final class Access_TypeRefBase(val node: nodes.TypeRefBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewTypeRef => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewTypeRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewTypeRef => newNode.typeFullName
    }
  }
  final class Access_UnknownBase(val node: nodes.UnknownBase) extends AnyVal {
    def containedRef: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_CONTAINED_REF(stored).containedRef
      case newNode: nodes.NewUnknown => newNode.containedRef
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: nodes.NewUnknown => newNode.dynamicTypeHintFullName
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: nodes.NewUnknown => newNode.parserTypeName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: nodes.NewUnknown => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: nodes.NewUnknown => newNode.typeFullName
    }
  }
  final class Access_VariableInfoBase(val node: nodes.VariableInfoBase) extends AnyVal {
    def evaluationType: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_EVALUATION_TYPE(stored).evaluationType
      case newNode: nodes.NewVariableInfo => newNode.evaluationType
    }
    def parameterIndex: Option[Int] = node match {
      case stored: nodes.StoredNode       => new Access_Property_PARAMETER_INDEX(stored).parameterIndex
      case newNode: nodes.NewVariableInfo => newNode.parameterIndex
    }
    def varType: String = node match {
      case stored: nodes.StoredNode       => new Access_Property_VAR_TYPE(stored).varType
      case newNode: nodes.NewVariableInfo => newNode.varType
    }
  }
  final class Access_VulnerabilityBase(val node: nodes.VulnerabilityBase) extends AnyVal {
    def description: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_DESCRIPTION(stored).description
      case newNode: nodes.NewVulnerability => newNode.description
    }
    def name: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_NAME(stored).name
      case newNode: nodes.NewVulnerability => newNode.name
    }
    def score: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_SCORE(stored).score
      case newNode: nodes.NewVulnerability => newNode.score
    }
    def url: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_URL(stored).url
      case newNode: nodes.NewVulnerability => newNode.url
    }
  }
  final class Access_WriteBase(val node: nodes.WriteBase) extends AnyVal {}
  final class Access_AstNodeBase(val node: nodes.AstNodeBase) extends AnyVal {
    def code: String = node match {
      case stored: nodes.StoredNode  => new Access_Property_CODE(stored).code
      case newNode: nodes.AstNodeNew => newNode.code
    }
    def columnNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => new Access_Property_COLUMN_NUMBER(stored).columnNumber
      case newNode: nodes.AstNodeNew => newNode.columnNumber
    }
    def lineNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => new Access_Property_LINE_NUMBER(stored).lineNumber
      case newNode: nodes.AstNodeNew => newNode.lineNumber
    }
    def order: Int = node match {
      case stored: nodes.StoredNode  => new Access_Property_ORDER(stored).order
      case newNode: nodes.AstNodeNew => newNode.order
    }
  }
  final class Access_CallReprBase(val node: nodes.CallReprBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_NAME(stored).name
      case newNode: nodes.CallReprNew => newNode.name
    }
    def signature: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_SIGNATURE(stored).signature
      case newNode: nodes.CallReprNew => newNode.signature
    }
  }
  final class Access_CfgNodeBase(val node: nodes.CfgNodeBase) extends AnyVal {
    def depthFirstOrder: Int = node match {
      case stored: nodes.StoredNode  => new Access_Property_DEPTH_FIRST_ORDER(stored).depthFirstOrder
      case newNode: nodes.CfgNodeNew => newNode.depthFirstOrder
    }
    def internalFlags: Int = node match {
      case stored: nodes.StoredNode  => new Access_Property_INTERNAL_FLAGS(stored).internalFlags
      case newNode: nodes.CfgNodeNew => newNode.internalFlags
    }
  }
  final class Access_ExpressionBase(val node: nodes.ExpressionBase) extends AnyVal {
    def argumentIndex: Int = node match {
      case stored: nodes.StoredNode     => new Access_Property_ARGUMENT_INDEX(stored).argumentIndex
      case newNode: nodes.ExpressionNew => newNode.argumentIndex
    }
    def argumentName: Option[String] = node match {
      case stored: nodes.StoredNode     => new Access_Property_ARGUMENT_NAME(stored).argumentName
      case newNode: nodes.ExpressionNew => newNode.argumentName
    }
  }
  final class Access_DeclarationBase(val node: nodes.DeclarationBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode      => new Access_Property_NAME(stored).name
      case newNode: nodes.DeclarationNew => newNode.name
    }
  }
  final class Access_TrackingPointBase(val node: nodes.TrackingPointBase) extends AnyVal {
    def code: String = node match {
      case stored: nodes.StoredNode        => new Access_Property_CODE(stored).code
      case newNode: nodes.TrackingPointNew => newNode.code
    }
  }
  final class Access_LocalLikeBase(val node: nodes.LocalLikeBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode    => new Access_Property_NAME(stored).name
      case newNode: nodes.LocalLikeNew => newNode.name
    }
  }
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors._
  implicit def accessPropertyAliasTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]
  ): Access_Property_ALIAS_TYPE_FULL_NAME = new Access_Property_ALIAS_TYPE_FULL_NAME(node)
  implicit def accessPropertyAnnotationFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationFullNameT]
  ): Access_Property_ANNOTATION_FULL_NAME = new Access_Property_ANNOTATION_FULL_NAME(node)
  implicit def accessPropertyAnnotationName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationNameT]
  ): Access_Property_ANNOTATION_NAME = new Access_Property_ANNOTATION_NAME(node)
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
  implicit def accessPropertyBinarySignature(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasBinarySignatureT]
  ): Access_Property_BINARY_SIGNATURE = new Access_Property_BINARY_SIGNATURE(node)
  implicit def accessPropertyCanonicalName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]
  ): Access_Property_CANONICAL_NAME = new Access_Property_CANONICAL_NAME(node)
  implicit def accessPropertyCategories(node: nodes.StoredNode with nodes.StaticType[nodes.HasCategoriesT]): Access_Property_CATEGORIES =
    new Access_Property_CATEGORIES(node)
  implicit def accessPropertyCategory(node: nodes.StoredNode with nodes.StaticType[nodes.HasCategoryT]): Access_Property_CATEGORY =
    new Access_Property_CATEGORY(node)
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
  implicit def accessPropertyDependencyType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyTypeT]
  ): Access_Property_DEPENDENCY_TYPE = new Access_Property_DEPENDENCY_TYPE(node)
  implicit def accessPropertyDepthFirstOrder(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDepthFirstOrderT]
  ): Access_Property_DEPTH_FIRST_ORDER = new Access_Property_DEPTH_FIRST_ORDER(node)
  implicit def accessPropertyDescription(node: nodes.StoredNode with nodes.StaticType[nodes.HasDescriptionT]): Access_Property_DESCRIPTION =
    new Access_Property_DESCRIPTION(node)
  implicit def accessPropertyDispatchName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchNameT]
  ): Access_Property_DISPATCH_NAME = new Access_Property_DISPATCH_NAME(node)
  implicit def accessPropertyDispatchType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]
  ): Access_Property_DISPATCH_TYPE = new Access_Property_DISPATCH_TYPE(node)
  implicit def accessPropertyDynamicTypeHintFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]
  ): Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME = new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(node)
  implicit def accessPropertyEvaluationStrategy(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]
  ): Access_Property_EVALUATION_STRATEGY = new Access_Property_EVALUATION_STRATEGY(node)
  implicit def accessPropertyEvaluationType(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationTypeT]
  ): Access_Property_EVALUATION_TYPE = new Access_Property_EVALUATION_TYPE(node)
  implicit def accessPropertyEvalType(node: nodes.StoredNode with nodes.StaticType[nodes.HasEvalTypeT]): Access_Property_EVAL_TYPE =
    new Access_Property_EVAL_TYPE(node)
  implicit def accessPropertyExplicitAs(node: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]): Access_Property_EXPLICIT_AS =
    new Access_Property_EXPLICIT_AS(node)
  implicit def accessPropertyFilename(node: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]): Access_Property_FILENAME =
    new Access_Property_FILENAME(node)
  implicit def accessPropertyFingerprint(node: nodes.StoredNode with nodes.StaticType[nodes.HasFingerprintT]): Access_Property_FINGERPRINT =
    new Access_Property_FINGERPRINT(node)
  implicit def accessPropertyFullName(node: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]): Access_Property_FULL_NAME =
    new Access_Property_FULL_NAME(node)
  implicit def accessPropertyHash(node: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]): Access_Property_HASH =
    new Access_Property_HASH(node)
  implicit def accessPropertyHasMapping(node: nodes.StoredNode with nodes.StaticType[nodes.HasHasMappingT]): Access_Property_HAS_MAPPING =
    new Access_Property_HAS_MAPPING(node)
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
  implicit def accessPropertyInternalFlags(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasInternalFlagsT]
  ): Access_Property_INTERNAL_FLAGS = new Access_Property_INTERNAL_FLAGS(node)
  implicit def accessPropertyIsExplicit(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]): Access_Property_IS_EXPLICIT =
    new Access_Property_IS_EXPLICIT(node)
  implicit def accessPropertyIsExternal(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]): Access_Property_IS_EXTERNAL =
    new Access_Property_IS_EXTERNAL(node)
  implicit def accessPropertyIsMethodNeverOverridden(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasIsMethodNeverOverriddenT]
  ): Access_Property_IS_METHOD_NEVER_OVERRIDDEN = new Access_Property_IS_METHOD_NEVER_OVERRIDDEN(node)
  implicit def accessPropertyIsStatic(node: nodes.StoredNode with nodes.StaticType[nodes.HasIsStaticT]): Access_Property_IS_STATIC =
    new Access_Property_IS_STATIC(node)
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
  implicit def accessPropertyLiteralsToSink(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasLiteralsToSinkT]
  ): Access_Property_LITERALS_TO_SINK = new Access_Property_LITERALS_TO_SINK(node)
  implicit def accessPropertyMethodFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]
  ): Access_Property_METHOD_FULL_NAME = new Access_Property_METHOD_FULL_NAME(node)
  implicit def accessPropertyMethodInstFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodInstFullNameT]
  ): Access_Property_METHOD_INST_FULL_NAME = new Access_Property_METHOD_INST_FULL_NAME(node)
  implicit def accessPropertyMethodShortName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]
  ): Access_Property_METHOD_SHORT_NAME = new Access_Property_METHOD_SHORT_NAME(node)
  implicit def accessPropertyMlAssisted(node: nodes.StoredNode with nodes.StaticType[nodes.HasMlAssistedT]): Access_Property_ML_ASSISTED =
    new Access_Property_ML_ASSISTED(node)
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
  implicit def accessPropertyParameterIndex(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParameterIndexT]
  ): Access_Property_PARAMETER_INDEX = new Access_Property_PARAMETER_INDEX(node)
  implicit def accessPropertyParserTypeName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]
  ): Access_Property_PARSER_TYPE_NAME = new Access_Property_PARSER_TYPE_NAME(node)
  implicit def accessPropertyPath(node: nodes.StoredNode with nodes.StaticType[nodes.HasPathT]): Access_Property_PATH =
    new Access_Property_PATH(node)
  implicit def accessPropertyPattern(node: nodes.StoredNode with nodes.StaticType[nodes.HasPatternT]): Access_Property_PATTERN =
    new Access_Property_PATTERN(node)
  implicit def accessPropertyPolicyDirectories(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPolicyDirectoriesT]
  ): Access_Property_POLICY_DIRECTORIES = new Access_Property_POLICY_DIRECTORIES(node)
  implicit def accessPropertyPossibleTypes(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasPossibleTypesT]
  ): Access_Property_POSSIBLE_TYPES = new Access_Property_POSSIBLE_TYPES(node)
  implicit def accessPropertyResolved(node: nodes.StoredNode with nodes.StaticType[nodes.HasResolvedT]): Access_Property_RESOLVED =
    new Access_Property_RESOLVED(node)
  implicit def accessPropertyRoot(node: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]): Access_Property_ROOT =
    new Access_Property_ROOT(node)
  implicit def accessPropertyScore(node: nodes.StoredNode with nodes.StaticType[nodes.HasScoreT]): Access_Property_SCORE =
    new Access_Property_SCORE(node)
  implicit def accessPropertySignature(node: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]): Access_Property_SIGNATURE =
    new Access_Property_SIGNATURE(node)
  implicit def accessPropertySinkType(node: nodes.StoredNode with nodes.StaticType[nodes.HasSinkTypeT]): Access_Property_SINK_TYPE =
    new Access_Property_SINK_TYPE(node)
  implicit def accessPropertySourceType(node: nodes.StoredNode with nodes.StaticType[nodes.HasSourceTypeT]): Access_Property_SOURCE_TYPE =
    new Access_Property_SOURCE_TYPE(node)
  implicit def accessPropertySpid(node: nodes.StoredNode with nodes.StaticType[nodes.HasSpidT]): Access_Property_SPID =
    new Access_Property_SPID(node)
  implicit def accessPropertyStructuredFingerprint(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasStructuredFingerprintT]
  ): Access_Property_STRUCTURED_FINGERPRINT = new Access_Property_STRUCTURED_FINGERPRINT(node)
  implicit def accessPropertySymbol(node: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]): Access_Property_SYMBOL =
    new Access_Property_SYMBOL(node)
  implicit def accessPropertyTypeDeclFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]
  ): Access_Property_TYPE_DECL_FULL_NAME = new Access_Property_TYPE_DECL_FULL_NAME(node)
  implicit def accessPropertyTypeFullName(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]
  ): Access_Property_TYPE_FULL_NAME = new Access_Property_TYPE_FULL_NAME(node)
  implicit def accessPropertyUrl(node: nodes.StoredNode with nodes.StaticType[nodes.HasUrlT]): Access_Property_URL =
    new Access_Property_URL(node)
  implicit def accessPropertyValue(node: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]): Access_Property_VALUE =
    new Access_Property_VALUE(node)
  implicit def accessPropertyVarargParameter(
    node: nodes.StoredNode with nodes.StaticType[nodes.HasVarargParameterT]
  ): Access_Property_VARARG_PARAMETER = new Access_Property_VARARG_PARAMETER(node)
  implicit def accessPropertyVarType(node: nodes.StoredNode with nodes.StaticType[nodes.HasVarTypeT]): Access_Property_VAR_TYPE =
    new Access_Property_VAR_TYPE(node)
  implicit def accessPropertyVersion(node: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]): Access_Property_VERSION =
    new Access_Property_VERSION(node)
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors._
  implicit def access_AnnotationBase(node: nodes.AnnotationBase): Access_AnnotationBase = new Access_AnnotationBase(node)
  implicit def access_AnnotationLiteralBase(node: nodes.AnnotationLiteralBase): Access_AnnotationLiteralBase =
    new Access_AnnotationLiteralBase(node)
  implicit def access_AnnotationParameterBase(node: nodes.AnnotationParameterBase): Access_AnnotationParameterBase =
    new Access_AnnotationParameterBase(node)
  implicit def access_AnnotationParameterAssignBase(node: nodes.AnnotationParameterAssignBase): Access_AnnotationParameterAssignBase =
    new Access_AnnotationParameterAssignBase(node)
  implicit def access_ArrayInitializerBase(node: nodes.ArrayInitializerBase): Access_ArrayInitializerBase = new Access_ArrayInitializerBase(
    node
  )
  implicit def access_BindingBase(node: nodes.BindingBase): Access_BindingBase                      = new Access_BindingBase(node)
  implicit def access_BlockBase(node: nodes.BlockBase): Access_BlockBase                            = new Access_BlockBase(node)
  implicit def access_CallBase(node: nodes.CallBase): Access_CallBase                               = new Access_CallBase(node)
  implicit def access_CallChainBase(node: nodes.CallChainBase): Access_CallChainBase                = new Access_CallChainBase(node)
  implicit def access_CallSiteBase(node: nodes.CallSiteBase): Access_CallSiteBase                   = new Access_CallSiteBase(node)
  implicit def access_ClosureBindingBase(node: nodes.ClosureBindingBase): Access_ClosureBindingBase = new Access_ClosureBindingBase(node)
  implicit def access_CommentBase(node: nodes.CommentBase): Access_CommentBase                      = new Access_CommentBase(node)
  implicit def access_ConfigFileBase(node: nodes.ConfigFileBase): Access_ConfigFileBase             = new Access_ConfigFileBase(node)
  implicit def access_ControlStructureBase(node: nodes.ControlStructureBase): Access_ControlStructureBase = new Access_ControlStructureBase(
    node
  )
  implicit def access_DependencyBase(node: nodes.DependencyBase): Access_DependencyBase       = new Access_DependencyBase(node)
  implicit def access_DomAttributeBase(node: nodes.DomAttributeBase): Access_DomAttributeBase = new Access_DomAttributeBase(node)
  implicit def access_DomNodeBase(node: nodes.DomNodeBase): Access_DomNodeBase                = new Access_DomNodeBase(node)
  implicit def access_FieldIdentifierBase(node: nodes.FieldIdentifierBase): Access_FieldIdentifierBase = new Access_FieldIdentifierBase(
    node
  )
  implicit def access_FileBase(node: nodes.FileBase): Access_FileBase                            = new Access_FileBase(node)
  implicit def access_FindingBase(node: nodes.FindingBase): Access_FindingBase                   = new Access_FindingBase(node)
  implicit def access_FlowBase(node: nodes.FlowBase): Access_FlowBase                            = new Access_FlowBase(node)
  implicit def access_FrameworkBase(node: nodes.FrameworkBase): Access_FrameworkBase             = new Access_FrameworkBase(node)
  implicit def access_FrameworkDataBase(node: nodes.FrameworkDataBase): Access_FrameworkDataBase = new Access_FrameworkDataBase(node)
  implicit def access_IdentifierBase(node: nodes.IdentifierBase): Access_IdentifierBase          = new Access_IdentifierBase(node)
  implicit def access_ImplicitCallBase(node: nodes.ImplicitCallBase): Access_ImplicitCallBase    = new Access_ImplicitCallBase(node)
  implicit def access_ImportBase(node: nodes.ImportBase): Access_ImportBase                      = new Access_ImportBase(node)
  implicit def access_IoflowBase(node: nodes.IoflowBase): Access_IoflowBase                      = new Access_IoflowBase(node)
  implicit def access_JumpLabelBase(node: nodes.JumpLabelBase): Access_JumpLabelBase             = new Access_JumpLabelBase(node)
  implicit def access_JumpTargetBase(node: nodes.JumpTargetBase): Access_JumpTargetBase          = new Access_JumpTargetBase(node)
  implicit def access_KeyValuePairBase(node: nodes.KeyValuePairBase): Access_KeyValuePairBase    = new Access_KeyValuePairBase(node)
  implicit def access_LiteralBase(node: nodes.LiteralBase): Access_LiteralBase                   = new Access_LiteralBase(node)
  implicit def access_LocalBase(node: nodes.LocalBase): Access_LocalBase                         = new Access_LocalBase(node)
  implicit def access_LocationBase(node: nodes.LocationBase): Access_LocationBase                = new Access_LocationBase(node)
  implicit def access_MatchInfoBase(node: nodes.MatchInfoBase): Access_MatchInfoBase             = new Access_MatchInfoBase(node)
  implicit def access_MemberBase(node: nodes.MemberBase): Access_MemberBase                      = new Access_MemberBase(node)
  implicit def access_MetaDataBase(node: nodes.MetaDataBase): Access_MetaDataBase                = new Access_MetaDataBase(node)
  implicit def access_MethodBase(node: nodes.MethodBase): Access_MethodBase                      = new Access_MethodBase(node)
  implicit def access_MethodInstBase(node: nodes.MethodInstBase): Access_MethodInstBase          = new Access_MethodInstBase(node)
  implicit def access_MethodParameterInBase(node: nodes.MethodParameterInBase): Access_MethodParameterInBase =
    new Access_MethodParameterInBase(node)
  implicit def access_MethodParameterOutBase(node: nodes.MethodParameterOutBase): Access_MethodParameterOutBase =
    new Access_MethodParameterOutBase(node)
  implicit def access_MethodRefBase(node: nodes.MethodRefBase): Access_MethodRefBase                = new Access_MethodRefBase(node)
  implicit def access_MethodReturnBase(node: nodes.MethodReturnBase): Access_MethodReturnBase       = new Access_MethodReturnBase(node)
  implicit def access_MethodSummaryBase(node: nodes.MethodSummaryBase): Access_MethodSummaryBase    = new Access_MethodSummaryBase(node)
  implicit def access_ModifierBase(node: nodes.ModifierBase): Access_ModifierBase                   = new Access_ModifierBase(node)
  implicit def access_NamespaceBase(node: nodes.NamespaceBase): Access_NamespaceBase                = new Access_NamespaceBase(node)
  implicit def access_NamespaceBlockBase(node: nodes.NamespaceBlockBase): Access_NamespaceBlockBase = new Access_NamespaceBlockBase(node)
  implicit def access_PackagePrefixBase(node: nodes.PackagePrefixBase): Access_PackagePrefixBase    = new Access_PackagePrefixBase(node)
  implicit def access_PostExecutionCallBase(node: nodes.PostExecutionCallBase): Access_PostExecutionCallBase =
    new Access_PostExecutionCallBase(node)
  implicit def access_ProgramPointBase(node: nodes.ProgramPointBase): Access_ProgramPointBase = new Access_ProgramPointBase(node)
  implicit def access_ReadBase(node: nodes.ReadBase): Access_ReadBase                         = new Access_ReadBase(node)
  implicit def access_ReturnBase(node: nodes.ReturnBase): Access_ReturnBase                   = new Access_ReturnBase(node)
  implicit def access_RouteBase(node: nodes.RouteBase): Access_RouteBase                      = new Access_RouteBase(node)
  implicit def access_SensitiveDataTypeBase(node: nodes.SensitiveDataTypeBase): Access_SensitiveDataTypeBase =
    new Access_SensitiveDataTypeBase(node)
  implicit def access_SensitiveMemberBase(node: nodes.SensitiveMemberBase): Access_SensitiveMemberBase = new Access_SensitiveMemberBase(
    node
  )
  implicit def access_SensitiveReferenceBase(node: nodes.SensitiveReferenceBase): Access_SensitiveReferenceBase =
    new Access_SensitiveReferenceBase(node)
  implicit def access_SensitiveVariableBase(node: nodes.SensitiveVariableBase): Access_SensitiveVariableBase =
    new Access_SensitiveVariableBase(node)
  implicit def access_SinkBase(node: nodes.SinkBase): Access_SinkBase       = new Access_SinkBase(node)
  implicit def access_SourceBase(node: nodes.SourceBase): Access_SourceBase = new Access_SourceBase(node)
  implicit def access_SpAnnotationParameterBase(node: nodes.SpAnnotationParameterBase): Access_SpAnnotationParameterBase =
    new Access_SpAnnotationParameterBase(node)
  implicit def access_SpBlacklistBase(node: nodes.SpBlacklistBase): Access_SpBlacklistBase          = new Access_SpBlacklistBase(node)
  implicit def access_TagBase(node: nodes.TagBase): Access_TagBase                                  = new Access_TagBase(node)
  implicit def access_TagsBase(node: nodes.TagsBase): Access_TagsBase                               = new Access_TagsBase(node)
  implicit def access_TagNodePairBase(node: nodes.TagNodePairBase): Access_TagNodePairBase          = new Access_TagNodePairBase(node)
  implicit def access_TemplateDomBase(node: nodes.TemplateDomBase): Access_TemplateDomBase          = new Access_TemplateDomBase(node)
  implicit def access_TransformBase(node: nodes.TransformBase): Access_TransformBase                = new Access_TransformBase(node)
  implicit def access_TransformationBase(node: nodes.TransformationBase): Access_TransformationBase = new Access_TransformationBase(node)
  implicit def access_TypeBase(node: nodes.TypeBase): Access_TypeBase                               = new Access_TypeBase(node)
  implicit def access_TypeArgumentBase(node: nodes.TypeArgumentBase): Access_TypeArgumentBase       = new Access_TypeArgumentBase(node)
  implicit def access_TypeDeclBase(node: nodes.TypeDeclBase): Access_TypeDeclBase                   = new Access_TypeDeclBase(node)
  implicit def access_TypeParameterBase(node: nodes.TypeParameterBase): Access_TypeParameterBase    = new Access_TypeParameterBase(node)
  implicit def access_TypeRefBase(node: nodes.TypeRefBase): Access_TypeRefBase                      = new Access_TypeRefBase(node)
  implicit def access_UnknownBase(node: nodes.UnknownBase): Access_UnknownBase                      = new Access_UnknownBase(node)
  implicit def access_VariableInfoBase(node: nodes.VariableInfoBase): Access_VariableInfoBase       = new Access_VariableInfoBase(node)
  implicit def access_VulnerabilityBase(node: nodes.VulnerabilityBase): Access_VulnerabilityBase    = new Access_VulnerabilityBase(node)
  implicit def access_WriteBase(node: nodes.WriteBase): Access_WriteBase                            = new Access_WriteBase(node)
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  import Accessors._
  implicit def access_AstNodeBase(node: nodes.AstNodeBase): Access_AstNodeBase          = new Access_AstNodeBase(node)
  implicit def access_CallReprBase(node: nodes.CallReprBase): Access_CallReprBase       = new Access_CallReprBase(node)
  implicit def access_CfgNodeBase(node: nodes.CfgNodeBase): Access_CfgNodeBase          = new Access_CfgNodeBase(node)
  implicit def access_ExpressionBase(node: nodes.ExpressionBase): Access_ExpressionBase = new Access_ExpressionBase(node)
}

trait AbstractBaseConversions1 extends AbstractBaseConversions2 {
  import Accessors._
  implicit def access_DeclarationBase(node: nodes.DeclarationBase): Access_DeclarationBase       = new Access_DeclarationBase(node)
  implicit def access_TrackingPointBase(node: nodes.TrackingPointBase): Access_TrackingPointBase = new Access_TrackingPointBase(node)
}

trait AbstractBaseConversions2 {
  import Accessors._
  implicit def access_LocalLikeBase(node: nodes.LocalLikeBase): Access_LocalLikeBase = new Access_LocalLikeBase(node)
}
