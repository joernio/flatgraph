package io.shiftleft.codepropertygraph.generated.v2.accessors
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes.*
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_ALIAS_TYPE_FULL_NAME(val node: StoredNode) extends AnyVal {
    def aliasTypeFullName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 0, node.seq)
  }
  final class Access_Property_ARGUMENT_INDEX(val node: StoredNode) extends AnyVal {
    def argumentIndex: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), -1: Int)
  }
  final class Access_Property_ARGUMENT_NAME(val node: StoredNode) extends AnyVal {
    def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 2, node.seq)
  }
  final class Access_Property_AST_PARENT_FULL_NAME(val node: StoredNode) extends AnyVal {
    def astParentFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 3, node.seq(), "<empty>": String)
  }
  final class Access_Property_AST_PARENT_TYPE(val node: StoredNode) extends AnyVal {
    def astParentType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }
  final class Access_Property_CANONICAL_NAME(val node: StoredNode) extends AnyVal {
    def canonicalName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 5, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLASS_NAME(val node: StoredNode) extends AnyVal {
    def className: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 6, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLASS_SHORT_NAME(val node: StoredNode) extends AnyVal {
    def classShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 7, node.seq(), "<empty>": String)
  }
  final class Access_Property_CLOSURE_BINDING_ID(val node: StoredNode) extends AnyVal {
    def closureBindingId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 8, node.seq)
  }
  final class Access_Property_CLOSURE_ORIGINAL_NAME(val node: StoredNode) extends AnyVal {
    def closureOriginalName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 9, node.seq)
  }
  final class Access_Property_CODE(val node: StoredNode) extends AnyVal {
    def code: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 10, node.seq(), "<empty>": String)
  }
  final class Access_Property_COLUMN_NUMBER(val node: StoredNode) extends AnyVal {
    def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 11, node.seq)
  }
  final class Access_Property_COLUMN_NUMBER_END(val node: StoredNode) extends AnyVal {
    def columnNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 12, node.seq)
  }
  final class Access_Property_CONTAINED_REF(val node: StoredNode) extends AnyVal {
    def containedRef: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 13, node.seq(), "<empty>": String)
  }
  final class Access_Property_CONTENT(val node: StoredNode) extends AnyVal {
    def content: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 14, node.seq(), "<empty>": String)
  }
  final class Access_Property_CONTROL_STRUCTURE_TYPE(val node: StoredNode) extends AnyVal {
    def controlStructureType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 15, node.seq(), "<empty>": String)
  }
  final class Access_Property_DEPENDENCY_GROUP_ID(val node: StoredNode) extends AnyVal {
    def dependencyGroupId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 16, node.seq)
  }
  final class Access_Property_DISPATCH_TYPE(val node: StoredNode) extends AnyVal {
    def dispatchType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 17, node.seq(), "<empty>": String)
  }
  final class Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(val node: StoredNode) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 18, node.seq)
  }
  final class Access_Property_EVALUATION_STRATEGY(val node: StoredNode) extends AnyVal {
    def evaluationStrategy: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 19, node.seq(), "<empty>": String)
  }
  final class Access_Property_EXPLICIT_AS(val node: StoredNode) extends AnyVal {
    def explicitAs: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 20, node.seq)
  }
  final class Access_Property_FILENAME(val node: StoredNode) extends AnyVal {
    def filename: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 21, node.seq(), "<empty>": String)
  }
  final class Access_Property_FULL_NAME(val node: StoredNode) extends AnyVal {
    def fullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 22, node.seq(), "<empty>": String)
  }
  final class Access_Property_HASH(val node: StoredNode) extends AnyVal {
    def hash: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 23, node.seq)
  }
  final class Access_Property_IMPORTED_AS(val node: StoredNode) extends AnyVal {
    def importedAs: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 24, node.seq)
  }
  final class Access_Property_IMPORTED_ENTITY(val node: StoredNode) extends AnyVal {
    def importedEntity: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 25, node.seq)
  }
  final class Access_Property_INDEX(val node: StoredNode) extends AnyVal {
    def index: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 26, node.seq(), -1: Int)
  }
  final class Access_Property_INHERITS_FROM_TYPE_FULL_NAME(val node: StoredNode) extends AnyVal {
    def inheritsFromTypeFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 27, node.seq)
  }
  final class Access_Property_IS_EXPLICIT(val node: StoredNode) extends AnyVal {
    def isExplicit: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 28, node.seq)
  }
  final class Access_Property_IS_EXTERNAL(val node: StoredNode) extends AnyVal {
    def isExternal: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 29, node.seq(), false: Boolean)
  }
  final class Access_Property_IS_VARIADIC(val node: StoredNode) extends AnyVal {
    def isVariadic: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 30, node.seq(), false: Boolean)
  }
  final class Access_Property_IS_WILDCARD(val node: StoredNode) extends AnyVal {
    def isWildcard: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 31, node.seq)
  }
  final class Access_Property_KEY(val node: StoredNode) extends AnyVal {
    def key: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 32, node.seq(), "<empty>": String)
  }
  final class Access_Property_LANGUAGE(val node: StoredNode) extends AnyVal {
    def language: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 33, node.seq(), "<empty>": String)
  }
  final class Access_Property_LINE_NUMBER(val node: StoredNode) extends AnyVal {
    def lineNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 34, node.seq)
  }
  final class Access_Property_LINE_NUMBER_END(val node: StoredNode) extends AnyVal {
    def lineNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 35, node.seq)
  }
  final class Access_Property_METHOD_FULL_NAME(val node: StoredNode) extends AnyVal {
    def methodFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 36, node.seq(), "<empty>": String)
  }
  final class Access_Property_METHOD_SHORT_NAME(val node: StoredNode) extends AnyVal {
    def methodShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 37, node.seq(), "<empty>": String)
  }
  final class Access_Property_MODIFIER_TYPE(val node: StoredNode) extends AnyVal {
    def modifierType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 38, node.seq(), "<empty>": String)
  }
  final class Access_Property_NAME(val node: StoredNode) extends AnyVal {
    def name: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 39, node.seq(), "<empty>": String)
  }
  final class Access_Property_NODE_LABEL(val node: StoredNode) extends AnyVal {
    def nodeLabel: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 40, node.seq(), "<empty>": String)
  }
  final class Access_Property_ORDER(val node: StoredNode) extends AnyVal {
    def order: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 41, node.seq(), -1: Int)
  }
  final class Access_Property_OVERLAYS(val node: StoredNode) extends AnyVal {
    def overlays: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 42, node.seq)
  }
  final class Access_Property_PACKAGE_NAME(val node: StoredNode) extends AnyVal {
    def packageName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 43, node.seq(), "<empty>": String)
  }
  final class Access_Property_PARSER_TYPE_NAME(val node: StoredNode) extends AnyVal {
    def parserTypeName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 44, node.seq(), "<empty>": String)
  }
  final class Access_Property_POSSIBLE_TYPES(val node: StoredNode) extends AnyVal {
    def possibleTypes: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 45, node.seq)
  }
  final class Access_Property_ROOT(val node: StoredNode) extends AnyVal {
    def root: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 46, node.seq(), "<empty>": String)
  }
  final class Access_Property_SIGNATURE(val node: StoredNode) extends AnyVal {
    def signature: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 47, node.seq(), "": String)
  }
  final class Access_Property_SYMBOL(val node: StoredNode) extends AnyVal {
    def symbol: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 48, node.seq(), "<empty>": String)
  }
  final class Access_Property_TYPE_DECL_FULL_NAME(val node: StoredNode) extends AnyVal {
    def typeDeclFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 49, node.seq(), "<empty>": String)
  }
  final class Access_Property_TYPE_FULL_NAME(val node: StoredNode) extends AnyVal {
    def typeFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 50, node.seq(), "<empty>": String)
  }
  final class Access_Property_VALUE(val node: StoredNode) extends AnyVal {
    def value: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 51, node.seq(), "": String)
  }
  final class Access_Property_VERSION(val node: StoredNode) extends AnyVal {
    def version: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 52, node.seq(), "<empty>": String)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_AnnotationBase(val node: AnnotationBase) extends AnyVal {
    def fullName: String = node match {
      case stored: StoredNode     => new Access_Property_FULL_NAME(stored).fullName
      case newNode: NewAnnotation => newNode.fullName
    }
    def name: String = node match {
      case stored: StoredNode     => new Access_Property_NAME(stored).name
      case newNode: NewAnnotation => newNode.name
    }
  }
  final class Access_AnnotationLiteralBase(val node: AnnotationLiteralBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode            => new Access_Property_NAME(stored).name
      case newNode: NewAnnotationLiteral => newNode.name
    }
  }
  final class Access_AnnotationParameterBase(val node: AnnotationParameterBase)             extends AnyVal {}
  final class Access_AnnotationParameterAssignBase(val node: AnnotationParameterAssignBase) extends AnyVal {}
  final class Access_ArrayInitializerBase(val node: ArrayInitializerBase)                   extends AnyVal {}
  final class Access_BindingBase(val node: BindingBase) extends AnyVal {
    def methodFullName: String = node match {
      case stored: StoredNode  => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: NewBinding => newNode.methodFullName
    }
    def name: String = node match {
      case stored: StoredNode  => new Access_Property_NAME(stored).name
      case newNode: NewBinding => newNode.name
    }
    def signature: String = node match {
      case stored: StoredNode  => new Access_Property_SIGNATURE(stored).signature
      case newNode: NewBinding => newNode.signature
    }
  }
  final class Access_BlockBase(val node: BlockBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewBlock  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewBlock  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewBlock  => newNode.typeFullName
    }
  }
  final class Access_CallBase(val node: CallBase) extends AnyVal {
    def dispatchType: String = node match {
      case stored: StoredNode => new Access_Property_DISPATCH_TYPE(stored).dispatchType
      case newNode: NewCall   => newNode.dispatchType
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewCall   => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: StoredNode => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: NewCall   => newNode.methodFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewCall   => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewCall   => newNode.typeFullName
    }
  }
  final class Access_ClosureBindingBase(val node: ClosureBindingBase) extends AnyVal {
    def closureBindingId: Option[String] = node match {
      case stored: StoredNode         => new Access_Property_CLOSURE_BINDING_ID(stored).closureBindingId
      case newNode: NewClosureBinding => newNode.closureBindingId
    }
    def closureOriginalName: Option[String] = node match {
      case stored: StoredNode         => new Access_Property_CLOSURE_ORIGINAL_NAME(stored).closureOriginalName
      case newNode: NewClosureBinding => newNode.closureOriginalName
    }
    def evaluationStrategy: String = node match {
      case stored: StoredNode         => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: NewClosureBinding => newNode.evaluationStrategy
    }
  }
  final class Access_CommentBase(val node: CommentBase) extends AnyVal {
    def filename: String = node match {
      case stored: StoredNode  => new Access_Property_FILENAME(stored).filename
      case newNode: NewComment => newNode.filename
    }
  }
  final class Access_ConfigFileBase(val node: ConfigFileBase) extends AnyVal {
    def content: String = node match {
      case stored: StoredNode     => new Access_Property_CONTENT(stored).content
      case newNode: NewConfigFile => newNode.content
    }
    def name: String = node match {
      case stored: StoredNode     => new Access_Property_NAME(stored).name
      case newNode: NewConfigFile => newNode.name
    }
  }
  final class Access_ControlStructureBase(val node: ControlStructureBase) extends AnyVal {
    def controlStructureType: String = node match {
      case stored: StoredNode           => new Access_Property_CONTROL_STRUCTURE_TYPE(stored).controlStructureType
      case newNode: NewControlStructure => newNode.controlStructureType
    }
    def parserTypeName: String = node match {
      case stored: StoredNode           => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: NewControlStructure => newNode.parserTypeName
    }
  }
  final class Access_DependencyBase(val node: DependencyBase) extends AnyVal {
    def dependencyGroupId: Option[String] = node match {
      case stored: StoredNode     => new Access_Property_DEPENDENCY_GROUP_ID(stored).dependencyGroupId
      case newNode: NewDependency => newNode.dependencyGroupId
    }
    def name: String = node match {
      case stored: StoredNode     => new Access_Property_NAME(stored).name
      case newNode: NewDependency => newNode.name
    }
    def version: String = node match {
      case stored: StoredNode     => new Access_Property_VERSION(stored).version
      case newNode: NewDependency => newNode.version
    }
  }
  final class Access_FieldIdentifierBase(val node: FieldIdentifierBase) extends AnyVal {
    def canonicalName: String = node match {
      case stored: StoredNode          => new Access_Property_CANONICAL_NAME(stored).canonicalName
      case newNode: NewFieldIdentifier => newNode.canonicalName
    }
  }
  final class Access_FileBase(val node: FileBase) extends AnyVal {
    def hash: Option[String] = node match {
      case stored: StoredNode => new Access_Property_HASH(stored).hash
      case newNode: NewFile   => newNode.hash
    }
    def name: String = node match {
      case stored: StoredNode => new Access_Property_NAME(stored).name
      case newNode: NewFile   => newNode.name
    }
  }
  final class Access_FindingBase(val node: FindingBase) extends AnyVal {}
  final class Access_IdentifierBase(val node: IdentifierBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode     => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewIdentifier => newNode.dynamicTypeHintFullName
    }
    def name: String = node match {
      case stored: StoredNode     => new Access_Property_NAME(stored).name
      case newNode: NewIdentifier => newNode.name
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode     => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewIdentifier => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode     => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewIdentifier => newNode.typeFullName
    }
  }
  final class Access_ImportBase(val node: ImportBase) extends AnyVal {
    def explicitAs: Option[Boolean] = node match {
      case stored: StoredNode => new Access_Property_EXPLICIT_AS(stored).explicitAs
      case newNode: NewImport => newNode.explicitAs
    }
    def importedAs: Option[String] = node match {
      case stored: StoredNode => new Access_Property_IMPORTED_AS(stored).importedAs
      case newNode: NewImport => newNode.importedAs
    }
    def importedEntity: Option[String] = node match {
      case stored: StoredNode => new Access_Property_IMPORTED_ENTITY(stored).importedEntity
      case newNode: NewImport => newNode.importedEntity
    }
    def isExplicit: Option[Boolean] = node match {
      case stored: StoredNode => new Access_Property_IS_EXPLICIT(stored).isExplicit
      case newNode: NewImport => newNode.isExplicit
    }
    def isWildcard: Option[Boolean] = node match {
      case stored: StoredNode => new Access_Property_IS_WILDCARD(stored).isWildcard
      case newNode: NewImport => newNode.isWildcard
    }
  }
  final class Access_JumpLabelBase(val node: JumpLabelBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode    => new Access_Property_NAME(stored).name
      case newNode: NewJumpLabel => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: StoredNode    => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: NewJumpLabel => newNode.parserTypeName
    }
  }
  final class Access_JumpTargetBase(val node: JumpTargetBase) extends AnyVal {
    def argumentIndex: Int = node match {
      case stored: StoredNode     => new Access_Property_ARGUMENT_INDEX(stored).argumentIndex
      case newNode: NewJumpTarget => newNode.argumentIndex
    }
    def name: String = node match {
      case stored: StoredNode     => new Access_Property_NAME(stored).name
      case newNode: NewJumpTarget => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: StoredNode     => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: NewJumpTarget => newNode.parserTypeName
    }
  }
  final class Access_KeyValuePairBase(val node: KeyValuePairBase) extends AnyVal {
    def key: String = node match {
      case stored: StoredNode       => new Access_Property_KEY(stored).key
      case newNode: NewKeyValuePair => newNode.key
    }
    def value: String = node match {
      case stored: StoredNode       => new Access_Property_VALUE(stored).value
      case newNode: NewKeyValuePair => newNode.value
    }
  }
  final class Access_LiteralBase(val node: LiteralBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewLiteral => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewLiteral => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewLiteral => newNode.typeFullName
    }
  }
  final class Access_LocalBase(val node: LocalBase) extends AnyVal {
    def closureBindingId: Option[String] = node match {
      case stored: StoredNode => new Access_Property_CLOSURE_BINDING_ID(stored).closureBindingId
      case newNode: NewLocal  => newNode.closureBindingId
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewLocal  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewLocal  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewLocal  => newNode.typeFullName
    }
  }
  final class Access_LocationBase(val node: LocationBase) extends AnyVal {
    def className: String = node match {
      case stored: StoredNode   => new Access_Property_CLASS_NAME(stored).className
      case newNode: NewLocation => newNode.className
    }
    def classShortName: String = node match {
      case stored: StoredNode   => new Access_Property_CLASS_SHORT_NAME(stored).classShortName
      case newNode: NewLocation => newNode.classShortName
    }
    def filename: String = node match {
      case stored: StoredNode   => new Access_Property_FILENAME(stored).filename
      case newNode: NewLocation => newNode.filename
    }
    def lineNumber: Option[Int] = node match {
      case stored: StoredNode   => new Access_Property_LINE_NUMBER(stored).lineNumber
      case newNode: NewLocation => newNode.lineNumber
    }
    def methodFullName: String = node match {
      case stored: StoredNode   => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: NewLocation => newNode.methodFullName
    }
    def methodShortName: String = node match {
      case stored: StoredNode   => new Access_Property_METHOD_SHORT_NAME(stored).methodShortName
      case newNode: NewLocation => newNode.methodShortName
    }
    def nodeLabel: String = node match {
      case stored: StoredNode   => new Access_Property_NODE_LABEL(stored).nodeLabel
      case newNode: NewLocation => newNode.nodeLabel
    }
    def packageName: String = node match {
      case stored: StoredNode   => new Access_Property_PACKAGE_NAME(stored).packageName
      case newNode: NewLocation => newNode.packageName
    }
    def symbol: String = node match {
      case stored: StoredNode   => new Access_Property_SYMBOL(stored).symbol
      case newNode: NewLocation => newNode.symbol
    }
  }
  final class Access_MemberBase(val node: MemberBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewMember => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewMember => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewMember => newNode.typeFullName
    }
  }
  final class Access_MetaDataBase(val node: MetaDataBase) extends AnyVal {
    def hash: Option[String] = node match {
      case stored: StoredNode   => new Access_Property_HASH(stored).hash
      case newNode: NewMetaData => newNode.hash
    }
    def language: String = node match {
      case stored: StoredNode   => new Access_Property_LANGUAGE(stored).language
      case newNode: NewMetaData => newNode.language
    }
    def overlays: IndexedSeq[String] = node match {
      case stored: StoredNode   => new Access_Property_OVERLAYS(stored).overlays
      case newNode: NewMetaData => newNode.overlays
    }
    def root: String = node match {
      case stored: StoredNode   => new Access_Property_ROOT(stored).root
      case newNode: NewMetaData => newNode.root
    }
    def version: String = node match {
      case stored: StoredNode   => new Access_Property_VERSION(stored).version
      case newNode: NewMetaData => newNode.version
    }
  }
  final class Access_MethodBase(val node: MethodBase) extends AnyVal {
    def astParentFullName: String = node match {
      case stored: StoredNode => new Access_Property_AST_PARENT_FULL_NAME(stored).astParentFullName
      case newNode: NewMethod => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: StoredNode => new Access_Property_AST_PARENT_TYPE(stored).astParentType
      case newNode: NewMethod => newNode.astParentType
    }
    def columnNumberEnd: Option[Int] = node match {
      case stored: StoredNode => new Access_Property_COLUMN_NUMBER_END(stored).columnNumberEnd
      case newNode: NewMethod => newNode.columnNumberEnd
    }
    def filename: String = node match {
      case stored: StoredNode => new Access_Property_FILENAME(stored).filename
      case newNode: NewMethod => newNode.filename
    }
    def fullName: String = node match {
      case stored: StoredNode => new Access_Property_FULL_NAME(stored).fullName
      case newNode: NewMethod => newNode.fullName
    }
    def hash: Option[String] = node match {
      case stored: StoredNode => new Access_Property_HASH(stored).hash
      case newNode: NewMethod => newNode.hash
    }
    def isExternal: Boolean = node match {
      case stored: StoredNode => new Access_Property_IS_EXTERNAL(stored).isExternal
      case newNode: NewMethod => newNode.isExternal
    }
    def lineNumberEnd: Option[Int] = node match {
      case stored: StoredNode => new Access_Property_LINE_NUMBER_END(stored).lineNumberEnd
      case newNode: NewMethod => newNode.lineNumberEnd
    }
    def signature: String = node match {
      case stored: StoredNode => new Access_Property_SIGNATURE(stored).signature
      case newNode: NewMethod => newNode.signature
    }
  }
  final class Access_MethodParameterInBase(val node: MethodParameterInBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode            => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewMethodParameterIn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: StoredNode            => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: NewMethodParameterIn => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: StoredNode            => new Access_Property_INDEX(stored).index
      case newNode: NewMethodParameterIn => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: StoredNode            => new Access_Property_IS_VARIADIC(stored).isVariadic
      case newNode: NewMethodParameterIn => newNode.isVariadic
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode            => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewMethodParameterIn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode            => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewMethodParameterIn => newNode.typeFullName
    }
  }
  final class Access_MethodParameterOutBase(val node: MethodParameterOutBase) extends AnyVal {
    def evaluationStrategy: String = node match {
      case stored: StoredNode             => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: NewMethodParameterOut => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: StoredNode             => new Access_Property_INDEX(stored).index
      case newNode: NewMethodParameterOut => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: StoredNode             => new Access_Property_IS_VARIADIC(stored).isVariadic
      case newNode: NewMethodParameterOut => newNode.isVariadic
    }
    def typeFullName: String = node match {
      case stored: StoredNode             => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewMethodParameterOut => newNode.typeFullName
    }
  }
  final class Access_MethodRefBase(val node: MethodRefBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode    => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewMethodRef => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: StoredNode    => new Access_Property_METHOD_FULL_NAME(stored).methodFullName
      case newNode: NewMethodRef => newNode.methodFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode    => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewMethodRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode    => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewMethodRef => newNode.typeFullName
    }
  }
  final class Access_MethodReturnBase(val node: MethodReturnBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode       => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewMethodReturn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: StoredNode       => new Access_Property_EVALUATION_STRATEGY(stored).evaluationStrategy
      case newNode: NewMethodReturn => newNode.evaluationStrategy
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode       => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewMethodReturn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode       => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewMethodReturn => newNode.typeFullName
    }
  }
  final class Access_ModifierBase(val node: ModifierBase) extends AnyVal {
    def modifierType: String = node match {
      case stored: StoredNode   => new Access_Property_MODIFIER_TYPE(stored).modifierType
      case newNode: NewModifier => newNode.modifierType
    }
  }
  final class Access_NamespaceBase(val node: NamespaceBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode    => new Access_Property_NAME(stored).name
      case newNode: NewNamespace => newNode.name
    }
  }
  final class Access_NamespaceBlockBase(val node: NamespaceBlockBase) extends AnyVal {
    def filename: String = node match {
      case stored: StoredNode         => new Access_Property_FILENAME(stored).filename
      case newNode: NewNamespaceBlock => newNode.filename
    }
    def fullName: String = node match {
      case stored: StoredNode         => new Access_Property_FULL_NAME(stored).fullName
      case newNode: NewNamespaceBlock => newNode.fullName
    }
    def name: String = node match {
      case stored: StoredNode         => new Access_Property_NAME(stored).name
      case newNode: NewNamespaceBlock => newNode.name
    }
  }
  final class Access_ReturnBase(val node: ReturnBase) extends AnyVal {}
  final class Access_TagBase(val node: TagBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode => new Access_Property_NAME(stored).name
      case newNode: NewTag    => newNode.name
    }
    def value: String = node match {
      case stored: StoredNode => new Access_Property_VALUE(stored).value
      case newNode: NewTag    => newNode.value
    }
  }
  final class Access_TagNodePairBase(val node: TagNodePairBase) extends AnyVal {}
  final class Access_TemplateDomBase(val node: TemplateDomBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode      => new Access_Property_NAME(stored).name
      case newNode: NewTemplateDom => newNode.name
    }
  }
  final class Access_TypeBase(val node: TypeBase) extends AnyVal {
    def fullName: String = node match {
      case stored: StoredNode => new Access_Property_FULL_NAME(stored).fullName
      case newNode: NewType   => newNode.fullName
    }
    def name: String = node match {
      case stored: StoredNode => new Access_Property_NAME(stored).name
      case newNode: NewType   => newNode.name
    }
    def typeDeclFullName: String = node match {
      case stored: StoredNode => new Access_Property_TYPE_DECL_FULL_NAME(stored).typeDeclFullName
      case newNode: NewType   => newNode.typeDeclFullName
    }
  }
  final class Access_TypeArgumentBase(val node: TypeArgumentBase) extends AnyVal {}
  final class Access_TypeDeclBase(val node: TypeDeclBase) extends AnyVal {
    def aliasTypeFullName: Option[String] = node match {
      case stored: StoredNode   => new Access_Property_ALIAS_TYPE_FULL_NAME(stored).aliasTypeFullName
      case newNode: NewTypeDecl => newNode.aliasTypeFullName
    }
    def astParentFullName: String = node match {
      case stored: StoredNode   => new Access_Property_AST_PARENT_FULL_NAME(stored).astParentFullName
      case newNode: NewTypeDecl => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: StoredNode   => new Access_Property_AST_PARENT_TYPE(stored).astParentType
      case newNode: NewTypeDecl => newNode.astParentType
    }
    def filename: String = node match {
      case stored: StoredNode   => new Access_Property_FILENAME(stored).filename
      case newNode: NewTypeDecl => newNode.filename
    }
    def fullName: String = node match {
      case stored: StoredNode   => new Access_Property_FULL_NAME(stored).fullName
      case newNode: NewTypeDecl => newNode.fullName
    }
    def inheritsFromTypeFullName: IndexedSeq[String] = node match {
      case stored: StoredNode   => new Access_Property_INHERITS_FROM_TYPE_FULL_NAME(stored).inheritsFromTypeFullName
      case newNode: NewTypeDecl => newNode.inheritsFromTypeFullName
    }
    def isExternal: Boolean = node match {
      case stored: StoredNode   => new Access_Property_IS_EXTERNAL(stored).isExternal
      case newNode: NewTypeDecl => newNode.isExternal
    }
    def name: String = node match {
      case stored: StoredNode   => new Access_Property_NAME(stored).name
      case newNode: NewTypeDecl => newNode.name
    }
  }
  final class Access_TypeParameterBase(val node: TypeParameterBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode        => new Access_Property_NAME(stored).name
      case newNode: NewTypeParameter => newNode.name
    }
  }
  final class Access_TypeRefBase(val node: TypeRefBase) extends AnyVal {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewTypeRef => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewTypeRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewTypeRef => newNode.typeFullName
    }
  }
  final class Access_UnknownBase(val node: UnknownBase) extends AnyVal {
    def containedRef: String = node match {
      case stored: StoredNode  => new Access_Property_CONTAINED_REF(stored).containedRef
      case newNode: NewUnknown => newNode.containedRef
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(stored).dynamicTypeHintFullName
      case newNode: NewUnknown => newNode.dynamicTypeHintFullName
    }
    def parserTypeName: String = node match {
      case stored: StoredNode  => new Access_Property_PARSER_TYPE_NAME(stored).parserTypeName
      case newNode: NewUnknown => newNode.parserTypeName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: StoredNode  => new Access_Property_POSSIBLE_TYPES(stored).possibleTypes
      case newNode: NewUnknown => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: StoredNode  => new Access_Property_TYPE_FULL_NAME(stored).typeFullName
      case newNode: NewUnknown => newNode.typeFullName
    }
  }
  final class Access_AstNodeBase(val node: AstNodeBase) extends AnyVal {
    def code: String = node match {
      case stored: StoredNode  => new Access_Property_CODE(stored).code
      case newNode: AstNodeNew => newNode.code
    }
    def columnNumber: Option[Int] = node match {
      case stored: StoredNode  => new Access_Property_COLUMN_NUMBER(stored).columnNumber
      case newNode: AstNodeNew => newNode.columnNumber
    }
    def lineNumber: Option[Int] = node match {
      case stored: StoredNode  => new Access_Property_LINE_NUMBER(stored).lineNumber
      case newNode: AstNodeNew => newNode.lineNumber
    }
    def order: Int = node match {
      case stored: StoredNode  => new Access_Property_ORDER(stored).order
      case newNode: AstNodeNew => newNode.order
    }
  }
  final class Access_CallReprBase(val node: CallReprBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode   => new Access_Property_NAME(stored).name
      case newNode: CallReprNew => newNode.name
    }
    def signature: String = node match {
      case stored: StoredNode   => new Access_Property_SIGNATURE(stored).signature
      case newNode: CallReprNew => newNode.signature
    }
  }
  final class Access_CfgNodeBase(val node: CfgNodeBase) extends AnyVal {}
  final class Access_ExpressionBase(val node: ExpressionBase) extends AnyVal {
    def argumentIndex: Int = node match {
      case stored: StoredNode     => new Access_Property_ARGUMENT_INDEX(stored).argumentIndex
      case newNode: ExpressionNew => newNode.argumentIndex
    }
    def argumentName: Option[String] = node match {
      case stored: StoredNode     => new Access_Property_ARGUMENT_NAME(stored).argumentName
      case newNode: ExpressionNew => newNode.argumentName
    }
  }
  final class Access_DeclarationBase(val node: DeclarationBase) extends AnyVal {
    def name: String = node match {
      case stored: StoredNode      => new Access_Property_NAME(stored).name
      case newNode: DeclarationNew => newNode.name
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyAliasTypeFullName(
    node: StoredNode with StaticType[HasAliasTypeFullNameT]
  ): Access_Property_ALIAS_TYPE_FULL_NAME = new Access_Property_ALIAS_TYPE_FULL_NAME(node)
  implicit def accessPropertyArgumentIndex(node: StoredNode with StaticType[HasArgumentIndexT]): Access_Property_ARGUMENT_INDEX =
    new Access_Property_ARGUMENT_INDEX(node)
  implicit def accessPropertyArgumentName(node: StoredNode with StaticType[HasArgumentNameT]): Access_Property_ARGUMENT_NAME =
    new Access_Property_ARGUMENT_NAME(node)
  implicit def accessPropertyAstParentFullName(
    node: StoredNode with StaticType[HasAstParentFullNameT]
  ): Access_Property_AST_PARENT_FULL_NAME = new Access_Property_AST_PARENT_FULL_NAME(node)
  implicit def accessPropertyAstParentType(node: StoredNode with StaticType[HasAstParentTypeT]): Access_Property_AST_PARENT_TYPE =
    new Access_Property_AST_PARENT_TYPE(node)
  implicit def accessPropertyCanonicalName(node: StoredNode with StaticType[HasCanonicalNameT]): Access_Property_CANONICAL_NAME =
    new Access_Property_CANONICAL_NAME(node)
  implicit def accessPropertyClassName(node: StoredNode with StaticType[HasClassNameT]): Access_Property_CLASS_NAME =
    new Access_Property_CLASS_NAME(node)
  implicit def accessPropertyClassShortName(node: StoredNode with StaticType[HasClassShortNameT]): Access_Property_CLASS_SHORT_NAME =
    new Access_Property_CLASS_SHORT_NAME(node)
  implicit def accessPropertyClosureBindingId(node: StoredNode with StaticType[HasClosureBindingIdT]): Access_Property_CLOSURE_BINDING_ID =
    new Access_Property_CLOSURE_BINDING_ID(node)
  implicit def accessPropertyClosureOriginalName(
    node: StoredNode with StaticType[HasClosureOriginalNameT]
  ): Access_Property_CLOSURE_ORIGINAL_NAME = new Access_Property_CLOSURE_ORIGINAL_NAME(node)
  implicit def accessPropertyCode(node: StoredNode with StaticType[HasCodeT]): Access_Property_CODE = new Access_Property_CODE(node)
  implicit def accessPropertyColumnNumber(node: StoredNode with StaticType[HasColumnNumberT]): Access_Property_COLUMN_NUMBER =
    new Access_Property_COLUMN_NUMBER(node)
  implicit def accessPropertyColumnNumberEnd(node: StoredNode with StaticType[HasColumnNumberEndT]): Access_Property_COLUMN_NUMBER_END =
    new Access_Property_COLUMN_NUMBER_END(node)
  implicit def accessPropertyContainedRef(node: StoredNode with StaticType[HasContainedRefT]): Access_Property_CONTAINED_REF =
    new Access_Property_CONTAINED_REF(node)
  implicit def accessPropertyContent(node: StoredNode with StaticType[HasContentT]): Access_Property_CONTENT = new Access_Property_CONTENT(
    node
  )
  implicit def accessPropertyControlStructureType(
    node: StoredNode with StaticType[HasControlStructureTypeT]
  ): Access_Property_CONTROL_STRUCTURE_TYPE = new Access_Property_CONTROL_STRUCTURE_TYPE(node)
  implicit def accessPropertyDependencyGroupId(
    node: StoredNode with StaticType[HasDependencyGroupIdT]
  ): Access_Property_DEPENDENCY_GROUP_ID = new Access_Property_DEPENDENCY_GROUP_ID(node)
  implicit def accessPropertyDispatchType(node: StoredNode with StaticType[HasDispatchTypeT]): Access_Property_DISPATCH_TYPE =
    new Access_Property_DISPATCH_TYPE(node)
  implicit def accessPropertyDynamicTypeHintFullName(
    node: StoredNode with StaticType[HasDynamicTypeHintFullNameT]
  ): Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME = new Access_Property_DYNAMIC_TYPE_HINT_FULL_NAME(node)
  implicit def accessPropertyEvaluationStrategy(
    node: StoredNode with StaticType[HasEvaluationStrategyT]
  ): Access_Property_EVALUATION_STRATEGY = new Access_Property_EVALUATION_STRATEGY(node)
  implicit def accessPropertyExplicitAs(node: StoredNode with StaticType[HasExplicitAsT]): Access_Property_EXPLICIT_AS =
    new Access_Property_EXPLICIT_AS(node)
  implicit def accessPropertyFilename(node: StoredNode with StaticType[HasFilenameT]): Access_Property_FILENAME =
    new Access_Property_FILENAME(node)
  implicit def accessPropertyFullName(node: StoredNode with StaticType[HasFullNameT]): Access_Property_FULL_NAME =
    new Access_Property_FULL_NAME(node)
  implicit def accessPropertyHash(node: StoredNode with StaticType[HasHashT]): Access_Property_HASH = new Access_Property_HASH(node)
  implicit def accessPropertyImportedAs(node: StoredNode with StaticType[HasImportedAsT]): Access_Property_IMPORTED_AS =
    new Access_Property_IMPORTED_AS(node)
  implicit def accessPropertyImportedEntity(node: StoredNode with StaticType[HasImportedEntityT]): Access_Property_IMPORTED_ENTITY =
    new Access_Property_IMPORTED_ENTITY(node)
  implicit def accessPropertyIndex(node: StoredNode with StaticType[HasIndexT]): Access_Property_INDEX = new Access_Property_INDEX(node)
  implicit def accessPropertyInheritsFromTypeFullName(
    node: StoredNode with StaticType[HasInheritsFromTypeFullNameT]
  ): Access_Property_INHERITS_FROM_TYPE_FULL_NAME = new Access_Property_INHERITS_FROM_TYPE_FULL_NAME(node)
  implicit def accessPropertyIsExplicit(node: StoredNode with StaticType[HasIsExplicitT]): Access_Property_IS_EXPLICIT =
    new Access_Property_IS_EXPLICIT(node)
  implicit def accessPropertyIsExternal(node: StoredNode with StaticType[HasIsExternalT]): Access_Property_IS_EXTERNAL =
    new Access_Property_IS_EXTERNAL(node)
  implicit def accessPropertyIsVariadic(node: StoredNode with StaticType[HasIsVariadicT]): Access_Property_IS_VARIADIC =
    new Access_Property_IS_VARIADIC(node)
  implicit def accessPropertyIsWildcard(node: StoredNode with StaticType[HasIsWildcardT]): Access_Property_IS_WILDCARD =
    new Access_Property_IS_WILDCARD(node)
  implicit def accessPropertyKey(node: StoredNode with StaticType[HasKeyT]): Access_Property_KEY = new Access_Property_KEY(node)
  implicit def accessPropertyLanguage(node: StoredNode with StaticType[HasLanguageT]): Access_Property_LANGUAGE =
    new Access_Property_LANGUAGE(node)
  implicit def accessPropertyLineNumber(node: StoredNode with StaticType[HasLineNumberT]): Access_Property_LINE_NUMBER =
    new Access_Property_LINE_NUMBER(node)
  implicit def accessPropertyLineNumberEnd(node: StoredNode with StaticType[HasLineNumberEndT]): Access_Property_LINE_NUMBER_END =
    new Access_Property_LINE_NUMBER_END(node)
  implicit def accessPropertyMethodFullName(node: StoredNode with StaticType[HasMethodFullNameT]): Access_Property_METHOD_FULL_NAME =
    new Access_Property_METHOD_FULL_NAME(node)
  implicit def accessPropertyMethodShortName(node: StoredNode with StaticType[HasMethodShortNameT]): Access_Property_METHOD_SHORT_NAME =
    new Access_Property_METHOD_SHORT_NAME(node)
  implicit def accessPropertyModifierType(node: StoredNode with StaticType[HasModifierTypeT]): Access_Property_MODIFIER_TYPE =
    new Access_Property_MODIFIER_TYPE(node)
  implicit def accessPropertyName(node: StoredNode with StaticType[HasNameT]): Access_Property_NAME = new Access_Property_NAME(node)
  implicit def accessPropertyNodeLabel(node: StoredNode with StaticType[HasNodeLabelT]): Access_Property_NODE_LABEL =
    new Access_Property_NODE_LABEL(node)
  implicit def accessPropertyOrder(node: StoredNode with StaticType[HasOrderT]): Access_Property_ORDER = new Access_Property_ORDER(node)
  implicit def accessPropertyOverlays(node: StoredNode with StaticType[HasOverlaysT]): Access_Property_OVERLAYS =
    new Access_Property_OVERLAYS(node)
  implicit def accessPropertyPackageName(node: StoredNode with StaticType[HasPackageNameT]): Access_Property_PACKAGE_NAME =
    new Access_Property_PACKAGE_NAME(node)
  implicit def accessPropertyParserTypeName(node: StoredNode with StaticType[HasParserTypeNameT]): Access_Property_PARSER_TYPE_NAME =
    new Access_Property_PARSER_TYPE_NAME(node)
  implicit def accessPropertyPossibleTypes(node: StoredNode with StaticType[HasPossibleTypesT]): Access_Property_POSSIBLE_TYPES =
    new Access_Property_POSSIBLE_TYPES(node)
  implicit def accessPropertyRoot(node: StoredNode with StaticType[HasRootT]): Access_Property_ROOT = new Access_Property_ROOT(node)
  implicit def accessPropertySignature(node: StoredNode with StaticType[HasSignatureT]): Access_Property_SIGNATURE =
    new Access_Property_SIGNATURE(node)
  implicit def accessPropertySymbol(node: StoredNode with StaticType[HasSymbolT]): Access_Property_SYMBOL = new Access_Property_SYMBOL(node)
  implicit def accessPropertyTypeDeclFullName(node: StoredNode with StaticType[HasTypeDeclFullNameT]): Access_Property_TYPE_DECL_FULL_NAME =
    new Access_Property_TYPE_DECL_FULL_NAME(node)
  implicit def accessPropertyTypeFullName(node: StoredNode with StaticType[HasTypeFullNameT]): Access_Property_TYPE_FULL_NAME =
    new Access_Property_TYPE_FULL_NAME(node)
  implicit def accessPropertyValue(node: StoredNode with StaticType[HasValueT]): Access_Property_VALUE = new Access_Property_VALUE(node)
  implicit def accessPropertyVersion(node: StoredNode with StaticType[HasVersionT]): Access_Property_VERSION = new Access_Property_VERSION(
    node
  )
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors.*
  implicit def access_AnnotationBase(node: AnnotationBase): Access_AnnotationBase = new Access_AnnotationBase(node)
  implicit def access_AnnotationLiteralBase(node: AnnotationLiteralBase): Access_AnnotationLiteralBase = new Access_AnnotationLiteralBase(
    node
  )
  implicit def access_AnnotationParameterBase(node: AnnotationParameterBase): Access_AnnotationParameterBase =
    new Access_AnnotationParameterBase(node)
  implicit def access_AnnotationParameterAssignBase(node: AnnotationParameterAssignBase): Access_AnnotationParameterAssignBase =
    new Access_AnnotationParameterAssignBase(node)
  implicit def access_ArrayInitializerBase(node: ArrayInitializerBase): Access_ArrayInitializerBase = new Access_ArrayInitializerBase(node)
  implicit def access_BindingBase(node: BindingBase): Access_BindingBase                            = new Access_BindingBase(node)
  implicit def access_BlockBase(node: BlockBase): Access_BlockBase                                  = new Access_BlockBase(node)
  implicit def access_CallBase(node: CallBase): Access_CallBase                                     = new Access_CallBase(node)
  implicit def access_ClosureBindingBase(node: ClosureBindingBase): Access_ClosureBindingBase       = new Access_ClosureBindingBase(node)
  implicit def access_CommentBase(node: CommentBase): Access_CommentBase                            = new Access_CommentBase(node)
  implicit def access_ConfigFileBase(node: ConfigFileBase): Access_ConfigFileBase                   = new Access_ConfigFileBase(node)
  implicit def access_ControlStructureBase(node: ControlStructureBase): Access_ControlStructureBase = new Access_ControlStructureBase(node)
  implicit def access_DependencyBase(node: DependencyBase): Access_DependencyBase                   = new Access_DependencyBase(node)
  implicit def access_FieldIdentifierBase(node: FieldIdentifierBase): Access_FieldIdentifierBase    = new Access_FieldIdentifierBase(node)
  implicit def access_FileBase(node: FileBase): Access_FileBase                                     = new Access_FileBase(node)
  implicit def access_FindingBase(node: FindingBase): Access_FindingBase                            = new Access_FindingBase(node)
  implicit def access_IdentifierBase(node: IdentifierBase): Access_IdentifierBase                   = new Access_IdentifierBase(node)
  implicit def access_ImportBase(node: ImportBase): Access_ImportBase                               = new Access_ImportBase(node)
  implicit def access_JumpLabelBase(node: JumpLabelBase): Access_JumpLabelBase                      = new Access_JumpLabelBase(node)
  implicit def access_JumpTargetBase(node: JumpTargetBase): Access_JumpTargetBase                   = new Access_JumpTargetBase(node)
  implicit def access_KeyValuePairBase(node: KeyValuePairBase): Access_KeyValuePairBase             = new Access_KeyValuePairBase(node)
  implicit def access_LiteralBase(node: LiteralBase): Access_LiteralBase                            = new Access_LiteralBase(node)
  implicit def access_LocalBase(node: LocalBase): Access_LocalBase                                  = new Access_LocalBase(node)
  implicit def access_LocationBase(node: LocationBase): Access_LocationBase                         = new Access_LocationBase(node)
  implicit def access_MemberBase(node: MemberBase): Access_MemberBase                               = new Access_MemberBase(node)
  implicit def access_MetaDataBase(node: MetaDataBase): Access_MetaDataBase                         = new Access_MetaDataBase(node)
  implicit def access_MethodBase(node: MethodBase): Access_MethodBase                               = new Access_MethodBase(node)
  implicit def access_MethodParameterInBase(node: MethodParameterInBase): Access_MethodParameterInBase = new Access_MethodParameterInBase(
    node
  )
  implicit def access_MethodParameterOutBase(node: MethodParameterOutBase): Access_MethodParameterOutBase =
    new Access_MethodParameterOutBase(node)
  implicit def access_MethodRefBase(node: MethodRefBase): Access_MethodRefBase                = new Access_MethodRefBase(node)
  implicit def access_MethodReturnBase(node: MethodReturnBase): Access_MethodReturnBase       = new Access_MethodReturnBase(node)
  implicit def access_ModifierBase(node: ModifierBase): Access_ModifierBase                   = new Access_ModifierBase(node)
  implicit def access_NamespaceBase(node: NamespaceBase): Access_NamespaceBase                = new Access_NamespaceBase(node)
  implicit def access_NamespaceBlockBase(node: NamespaceBlockBase): Access_NamespaceBlockBase = new Access_NamespaceBlockBase(node)
  implicit def access_ReturnBase(node: ReturnBase): Access_ReturnBase                         = new Access_ReturnBase(node)
  implicit def access_TagBase(node: TagBase): Access_TagBase                                  = new Access_TagBase(node)
  implicit def access_TagNodePairBase(node: TagNodePairBase): Access_TagNodePairBase          = new Access_TagNodePairBase(node)
  implicit def access_TemplateDomBase(node: TemplateDomBase): Access_TemplateDomBase          = new Access_TemplateDomBase(node)
  implicit def access_TypeBase(node: TypeBase): Access_TypeBase                               = new Access_TypeBase(node)
  implicit def access_TypeArgumentBase(node: TypeArgumentBase): Access_TypeArgumentBase       = new Access_TypeArgumentBase(node)
  implicit def access_TypeDeclBase(node: TypeDeclBase): Access_TypeDeclBase                   = new Access_TypeDeclBase(node)
  implicit def access_TypeParameterBase(node: TypeParameterBase): Access_TypeParameterBase    = new Access_TypeParameterBase(node)
  implicit def access_TypeRefBase(node: TypeRefBase): Access_TypeRefBase                      = new Access_TypeRefBase(node)
  implicit def access_UnknownBase(node: UnknownBase): Access_UnknownBase                      = new Access_UnknownBase(node)
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  import Accessors.*
  implicit def access_AstNodeBase(node: AstNodeBase): Access_AstNodeBase          = new Access_AstNodeBase(node)
  implicit def access_CallReprBase(node: CallReprBase): Access_CallReprBase       = new Access_CallReprBase(node)
  implicit def access_CfgNodeBase(node: CfgNodeBase): Access_CfgNodeBase          = new Access_CfgNodeBase(node)
  implicit def access_ExpressionBase(node: ExpressionBase): Access_ExpressionBase = new Access_ExpressionBase(node)
}

trait AbstractBaseConversions1 {
  import Accessors.*
  implicit def access_DeclarationBase(node: DeclarationBase): Access_DeclarationBase = new Access_DeclarationBase(node)
}
