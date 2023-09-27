package io.shiftleft.codepropertygraph.generated.v2.accessors
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]) {
    def aliasTypeFullName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 0, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]) {
    def argumentIndex: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), -1: Int)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]) {
    def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 2, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]) {
    def astParentFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 3, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]) {
    def astParentType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]) {
    def canonicalName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 5, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]) {
    def className: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 6, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]) {
    def classShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 7, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]) {
    def closureBindingId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 8, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]) {
    def closureOriginalName: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 9, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]) {
    def code: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 10, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]) {
    def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 11, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]) {
    def columnNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 12, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]) {
    def containedRef: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 13, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]) {
    def content: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 14, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]) {
    def controlStructureType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 15, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]) {
    def dependencyGroupId: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 16, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]) {
    def dispatchType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 17, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]) {
    def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 18, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]) {
    def evaluationStrategy: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 19, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]) {
    def explicitAs: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 20, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]) {
    def filename: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 21, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]) {
    def fullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 22, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]) {
    def hash: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 23, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]) {
    def importedAs: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 24, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]) {
    def importedEntity: Option[String] = odb2.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 25, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]) {
    def index: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 26, node.seq(), -1: Int)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]) {
    def inheritsFromTypeFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 27, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]) {
    def isExplicit: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 28, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]) {
    def isExternal: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 29, node.seq(), false: Boolean)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]) {
    def isVariadic: Boolean = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 30, node.seq(), false: Boolean)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]) {
    def isWildcard: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](node.graph, node.nodeKind, 31, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]) {
    def key: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 32, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]) {
    def language: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 33, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]) {
    def lineNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 34, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]) {
    def lineNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 35, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]) {
    def methodFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 36, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]) {
    def methodShortName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 37, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]) {
    def modifierType: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 38, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]) {
    def name: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 39, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]) {
    def nodeLabel: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 40, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]) {
    def order: Int = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 41, node.seq(), -1: Int)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]) {
    def overlays: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 42, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]) {
    def packageName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 43, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]) {
    def parserTypeName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 44, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasPossibleTypesT]) {
    def possibleTypes: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 45, node.seq)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]) {
    def root: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 46, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]) {
    def signature: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 47, node.seq(), "": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]) {
    def symbol: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 48, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]) {
    def typeDeclFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 49, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]) {
    def typeFullName: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 50, node.seq(), "<empty>": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]) {
    def value: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 51, node.seq(), "": String)
  }
  extension (node: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]) {
    def version: String = odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 52, node.seq(), "<empty>": String)
  }
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  extension (node: nodes.AnnotationBase) {
    def fullName: String = node match {
      case stored: nodes.StoredNode     => stored.fullName
      case newNode: nodes.NewAnnotation => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => stored.name
      case newNode: nodes.NewAnnotation => newNode.name
    }
  }
  extension (node: nodes.AnnotationLiteralBase) {
    def name: String = node match {
      case stored: nodes.StoredNode            => stored.name
      case newNode: nodes.NewAnnotationLiteral => newNode.name
    }
  }
  extension (node: nodes.BindingBase) {
    def methodFullName: String = node match {
      case stored: nodes.StoredNode  => stored.methodFullName
      case newNode: nodes.NewBinding => newNode.methodFullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode  => stored.name
      case newNode: nodes.NewBinding => newNode.name
    }
    def signature: String = node match {
      case stored: nodes.StoredNode  => stored.signature
      case newNode: nodes.NewBinding => newNode.signature
    }
  }
  extension (node: nodes.BlockBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.dynamicTypeHintFullName
      case newNode: nodes.NewBlock  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.possibleTypes
      case newNode: nodes.NewBlock  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => stored.typeFullName
      case newNode: nodes.NewBlock  => newNode.typeFullName
    }
  }
  extension (node: nodes.CallBase) {
    def dispatchType: String = node match {
      case stored: nodes.StoredNode => stored.dispatchType
      case newNode: nodes.NewCall   => newNode.dispatchType
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.dynamicTypeHintFullName
      case newNode: nodes.NewCall   => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode => stored.methodFullName
      case newNode: nodes.NewCall   => newNode.methodFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.possibleTypes
      case newNode: nodes.NewCall   => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => stored.typeFullName
      case newNode: nodes.NewCall   => newNode.typeFullName
    }
  }
  extension (node: nodes.ClosureBindingBase) {
    def closureBindingId: Option[String] = node match {
      case stored: nodes.StoredNode         => stored.closureBindingId
      case newNode: nodes.NewClosureBinding => newNode.closureBindingId
    }
    def closureOriginalName: Option[String] = node match {
      case stored: nodes.StoredNode         => stored.closureOriginalName
      case newNode: nodes.NewClosureBinding => newNode.closureOriginalName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode         => stored.evaluationStrategy
      case newNode: nodes.NewClosureBinding => newNode.evaluationStrategy
    }
  }
  extension (node: nodes.CommentBase) {
    def filename: String = node match {
      case stored: nodes.StoredNode  => stored.filename
      case newNode: nodes.NewComment => newNode.filename
    }
  }
  extension (node: nodes.ConfigFileBase) {
    def content: String = node match {
      case stored: nodes.StoredNode     => stored.content
      case newNode: nodes.NewConfigFile => newNode.content
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => stored.name
      case newNode: nodes.NewConfigFile => newNode.name
    }
  }
  extension (node: nodes.ControlStructureBase) {
    def controlStructureType: String = node match {
      case stored: nodes.StoredNode           => stored.controlStructureType
      case newNode: nodes.NewControlStructure => newNode.controlStructureType
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode           => stored.parserTypeName
      case newNode: nodes.NewControlStructure => newNode.parserTypeName
    }
  }
  extension (node: nodes.DependencyBase) {
    def dependencyGroupId: Option[String] = node match {
      case stored: nodes.StoredNode     => stored.dependencyGroupId
      case newNode: nodes.NewDependency => newNode.dependencyGroupId
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => stored.name
      case newNode: nodes.NewDependency => newNode.name
    }
    def version: String = node match {
      case stored: nodes.StoredNode     => stored.version
      case newNode: nodes.NewDependency => newNode.version
    }
  }
  extension (node: nodes.FieldIdentifierBase) {
    def canonicalName: String = node match {
      case stored: nodes.StoredNode          => stored.canonicalName
      case newNode: nodes.NewFieldIdentifier => newNode.canonicalName
    }
  }
  extension (node: nodes.FileBase) {
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode => stored.hash
      case newNode: nodes.NewFile   => newNode.hash
    }
    def name: String = node match {
      case stored: nodes.StoredNode => stored.name
      case newNode: nodes.NewFile   => newNode.name
    }
  }
  extension (node: nodes.IdentifierBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode     => stored.dynamicTypeHintFullName
      case newNode: nodes.NewIdentifier => newNode.dynamicTypeHintFullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => stored.name
      case newNode: nodes.NewIdentifier => newNode.name
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode     => stored.possibleTypes
      case newNode: nodes.NewIdentifier => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode     => stored.typeFullName
      case newNode: nodes.NewIdentifier => newNode.typeFullName
    }
  }
  extension (node: nodes.ImportBase) {
    def explicitAs: Option[Boolean] = node match {
      case stored: nodes.StoredNode => stored.explicitAs
      case newNode: nodes.NewImport => newNode.explicitAs
    }
    def importedAs: Option[String] = node match {
      case stored: nodes.StoredNode => stored.importedAs
      case newNode: nodes.NewImport => newNode.importedAs
    }
    def importedEntity: Option[String] = node match {
      case stored: nodes.StoredNode => stored.importedEntity
      case newNode: nodes.NewImport => newNode.importedEntity
    }
    def isExplicit: Option[Boolean] = node match {
      case stored: nodes.StoredNode => stored.isExplicit
      case newNode: nodes.NewImport => newNode.isExplicit
    }
    def isWildcard: Option[Boolean] = node match {
      case stored: nodes.StoredNode => stored.isWildcard
      case newNode: nodes.NewImport => newNode.isWildcard
    }
  }
  extension (node: nodes.JumpLabelBase) {
    def name: String = node match {
      case stored: nodes.StoredNode    => stored.name
      case newNode: nodes.NewJumpLabel => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode    => stored.parserTypeName
      case newNode: nodes.NewJumpLabel => newNode.parserTypeName
    }
  }
  extension (node: nodes.JumpTargetBase) {
    def argumentIndex: Int = node match {
      case stored: nodes.StoredNode     => stored.argumentIndex
      case newNode: nodes.NewJumpTarget => newNode.argumentIndex
    }
    def name: String = node match {
      case stored: nodes.StoredNode     => stored.name
      case newNode: nodes.NewJumpTarget => newNode.name
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode     => stored.parserTypeName
      case newNode: nodes.NewJumpTarget => newNode.parserTypeName
    }
  }
  extension (node: nodes.KeyValuePairBase) {
    def key: String = node match {
      case stored: nodes.StoredNode       => stored.key
      case newNode: nodes.NewKeyValuePair => newNode.key
    }
    def value: String = node match {
      case stored: nodes.StoredNode       => stored.value
      case newNode: nodes.NewKeyValuePair => newNode.value
    }
  }
  extension (node: nodes.LiteralBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.dynamicTypeHintFullName
      case newNode: nodes.NewLiteral => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.possibleTypes
      case newNode: nodes.NewLiteral => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => stored.typeFullName
      case newNode: nodes.NewLiteral => newNode.typeFullName
    }
  }
  extension (node: nodes.LocalBase) {
    def closureBindingId: Option[String] = node match {
      case stored: nodes.StoredNode => stored.closureBindingId
      case newNode: nodes.NewLocal  => newNode.closureBindingId
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.dynamicTypeHintFullName
      case newNode: nodes.NewLocal  => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.possibleTypes
      case newNode: nodes.NewLocal  => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => stored.typeFullName
      case newNode: nodes.NewLocal  => newNode.typeFullName
    }
  }
  extension (node: nodes.LocationBase) {
    def className: String = node match {
      case stored: nodes.StoredNode   => stored.className
      case newNode: nodes.NewLocation => newNode.className
    }
    def classShortName: String = node match {
      case stored: nodes.StoredNode   => stored.classShortName
      case newNode: nodes.NewLocation => newNode.classShortName
    }
    def filename: String = node match {
      case stored: nodes.StoredNode   => stored.filename
      case newNode: nodes.NewLocation => newNode.filename
    }
    def lineNumber: Option[Int] = node match {
      case stored: nodes.StoredNode   => stored.lineNumber
      case newNode: nodes.NewLocation => newNode.lineNumber
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode   => stored.methodFullName
      case newNode: nodes.NewLocation => newNode.methodFullName
    }
    def methodShortName: String = node match {
      case stored: nodes.StoredNode   => stored.methodShortName
      case newNode: nodes.NewLocation => newNode.methodShortName
    }
    def nodeLabel: String = node match {
      case stored: nodes.StoredNode   => stored.nodeLabel
      case newNode: nodes.NewLocation => newNode.nodeLabel
    }
    def packageName: String = node match {
      case stored: nodes.StoredNode   => stored.packageName
      case newNode: nodes.NewLocation => newNode.packageName
    }
    def symbol: String = node match {
      case stored: nodes.StoredNode   => stored.symbol
      case newNode: nodes.NewLocation => newNode.symbol
    }
  }
  extension (node: nodes.MemberBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.dynamicTypeHintFullName
      case newNode: nodes.NewMember => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => stored.possibleTypes
      case newNode: nodes.NewMember => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode => stored.typeFullName
      case newNode: nodes.NewMember => newNode.typeFullName
    }
  }
  extension (node: nodes.MetaDataBase) {
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode   => stored.hash
      case newNode: nodes.NewMetaData => newNode.hash
    }
    def language: String = node match {
      case stored: nodes.StoredNode   => stored.language
      case newNode: nodes.NewMetaData => newNode.language
    }
    def overlays: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode   => stored.overlays
      case newNode: nodes.NewMetaData => newNode.overlays
    }
    def root: String = node match {
      case stored: nodes.StoredNode   => stored.root
      case newNode: nodes.NewMetaData => newNode.root
    }
    def version: String = node match {
      case stored: nodes.StoredNode   => stored.version
      case newNode: nodes.NewMetaData => newNode.version
    }
  }
  extension (node: nodes.MethodBase) {
    def astParentFullName: String = node match {
      case stored: nodes.StoredNode => stored.astParentFullName
      case newNode: nodes.NewMethod => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: nodes.StoredNode => stored.astParentType
      case newNode: nodes.NewMethod => newNode.astParentType
    }
    def columnNumberEnd: Option[Int] = node match {
      case stored: nodes.StoredNode => stored.columnNumberEnd
      case newNode: nodes.NewMethod => newNode.columnNumberEnd
    }
    def filename: String = node match {
      case stored: nodes.StoredNode => stored.filename
      case newNode: nodes.NewMethod => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode => stored.fullName
      case newNode: nodes.NewMethod => newNode.fullName
    }
    def hash: Option[String] = node match {
      case stored: nodes.StoredNode => stored.hash
      case newNode: nodes.NewMethod => newNode.hash
    }
    def isExternal: Boolean = node match {
      case stored: nodes.StoredNode => stored.isExternal
      case newNode: nodes.NewMethod => newNode.isExternal
    }
    def lineNumberEnd: Option[Int] = node match {
      case stored: nodes.StoredNode => stored.lineNumberEnd
      case newNode: nodes.NewMethod => newNode.lineNumberEnd
    }
    def signature: String = node match {
      case stored: nodes.StoredNode => stored.signature
      case newNode: nodes.NewMethod => newNode.signature
    }
  }
  extension (node: nodes.MethodParameterInBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode            => stored.dynamicTypeHintFullName
      case newNode: nodes.NewMethodParameterIn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode            => stored.evaluationStrategy
      case newNode: nodes.NewMethodParameterIn => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: nodes.StoredNode            => stored.index
      case newNode: nodes.NewMethodParameterIn => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: nodes.StoredNode            => stored.isVariadic
      case newNode: nodes.NewMethodParameterIn => newNode.isVariadic
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode            => stored.possibleTypes
      case newNode: nodes.NewMethodParameterIn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode            => stored.typeFullName
      case newNode: nodes.NewMethodParameterIn => newNode.typeFullName
    }
  }
  extension (node: nodes.MethodParameterOutBase) {
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode             => stored.evaluationStrategy
      case newNode: nodes.NewMethodParameterOut => newNode.evaluationStrategy
    }
    def index: Int = node match {
      case stored: nodes.StoredNode             => stored.index
      case newNode: nodes.NewMethodParameterOut => newNode.index
    }
    def isVariadic: Boolean = node match {
      case stored: nodes.StoredNode             => stored.isVariadic
      case newNode: nodes.NewMethodParameterOut => newNode.isVariadic
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode             => stored.typeFullName
      case newNode: nodes.NewMethodParameterOut => newNode.typeFullName
    }
  }
  extension (node: nodes.MethodRefBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode    => stored.dynamicTypeHintFullName
      case newNode: nodes.NewMethodRef => newNode.dynamicTypeHintFullName
    }
    def methodFullName: String = node match {
      case stored: nodes.StoredNode    => stored.methodFullName
      case newNode: nodes.NewMethodRef => newNode.methodFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode    => stored.possibleTypes
      case newNode: nodes.NewMethodRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode    => stored.typeFullName
      case newNode: nodes.NewMethodRef => newNode.typeFullName
    }
  }
  extension (node: nodes.MethodReturnBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode       => stored.dynamicTypeHintFullName
      case newNode: nodes.NewMethodReturn => newNode.dynamicTypeHintFullName
    }
    def evaluationStrategy: String = node match {
      case stored: nodes.StoredNode       => stored.evaluationStrategy
      case newNode: nodes.NewMethodReturn => newNode.evaluationStrategy
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode       => stored.possibleTypes
      case newNode: nodes.NewMethodReturn => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode       => stored.typeFullName
      case newNode: nodes.NewMethodReturn => newNode.typeFullName
    }
  }
  extension (node: nodes.ModifierBase) {
    def modifierType: String = node match {
      case stored: nodes.StoredNode   => stored.modifierType
      case newNode: nodes.NewModifier => newNode.modifierType
    }
  }
  extension (node: nodes.NamespaceBase) {
    def name: String = node match {
      case stored: nodes.StoredNode    => stored.name
      case newNode: nodes.NewNamespace => newNode.name
    }
  }
  extension (node: nodes.NamespaceBlockBase) {
    def filename: String = node match {
      case stored: nodes.StoredNode         => stored.filename
      case newNode: nodes.NewNamespaceBlock => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode         => stored.fullName
      case newNode: nodes.NewNamespaceBlock => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode         => stored.name
      case newNode: nodes.NewNamespaceBlock => newNode.name
    }
  }
  extension (node: nodes.TagBase) {
    def name: String = node match {
      case stored: nodes.StoredNode => stored.name
      case newNode: nodes.NewTag    => newNode.name
    }
    def value: String = node match {
      case stored: nodes.StoredNode => stored.value
      case newNode: nodes.NewTag    => newNode.value
    }
  }
  extension (node: nodes.TemplateDomBase) {
    def name: String = node match {
      case stored: nodes.StoredNode      => stored.name
      case newNode: nodes.NewTemplateDom => newNode.name
    }
  }
  extension (node: nodes.TypeBase) {
    def fullName: String = node match {
      case stored: nodes.StoredNode => stored.fullName
      case newNode: nodes.NewType   => newNode.fullName
    }
    def name: String = node match {
      case stored: nodes.StoredNode => stored.name
      case newNode: nodes.NewType   => newNode.name
    }
    def typeDeclFullName: String = node match {
      case stored: nodes.StoredNode => stored.typeDeclFullName
      case newNode: nodes.NewType   => newNode.typeDeclFullName
    }
  }
  extension (node: nodes.TypeDeclBase) {
    def aliasTypeFullName: Option[String] = node match {
      case stored: nodes.StoredNode   => stored.aliasTypeFullName
      case newNode: nodes.NewTypeDecl => newNode.aliasTypeFullName
    }
    def astParentFullName: String = node match {
      case stored: nodes.StoredNode   => stored.astParentFullName
      case newNode: nodes.NewTypeDecl => newNode.astParentFullName
    }
    def astParentType: String = node match {
      case stored: nodes.StoredNode   => stored.astParentType
      case newNode: nodes.NewTypeDecl => newNode.astParentType
    }
    def filename: String = node match {
      case stored: nodes.StoredNode   => stored.filename
      case newNode: nodes.NewTypeDecl => newNode.filename
    }
    def fullName: String = node match {
      case stored: nodes.StoredNode   => stored.fullName
      case newNode: nodes.NewTypeDecl => newNode.fullName
    }
    def inheritsFromTypeFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode   => stored.inheritsFromTypeFullName
      case newNode: nodes.NewTypeDecl => newNode.inheritsFromTypeFullName
    }
    def isExternal: Boolean = node match {
      case stored: nodes.StoredNode   => stored.isExternal
      case newNode: nodes.NewTypeDecl => newNode.isExternal
    }
    def name: String = node match {
      case stored: nodes.StoredNode   => stored.name
      case newNode: nodes.NewTypeDecl => newNode.name
    }
  }
  extension (node: nodes.TypeParameterBase) {
    def name: String = node match {
      case stored: nodes.StoredNode        => stored.name
      case newNode: nodes.NewTypeParameter => newNode.name
    }
  }
  extension (node: nodes.TypeRefBase) {
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.dynamicTypeHintFullName
      case newNode: nodes.NewTypeRef => newNode.dynamicTypeHintFullName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.possibleTypes
      case newNode: nodes.NewTypeRef => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => stored.typeFullName
      case newNode: nodes.NewTypeRef => newNode.typeFullName
    }
  }
  extension (node: nodes.UnknownBase) {
    def containedRef: String = node match {
      case stored: nodes.StoredNode  => stored.containedRef
      case newNode: nodes.NewUnknown => newNode.containedRef
    }
    def dynamicTypeHintFullName: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.dynamicTypeHintFullName
      case newNode: nodes.NewUnknown => newNode.dynamicTypeHintFullName
    }
    def parserTypeName: String = node match {
      case stored: nodes.StoredNode  => stored.parserTypeName
      case newNode: nodes.NewUnknown => newNode.parserTypeName
    }
    def possibleTypes: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode  => stored.possibleTypes
      case newNode: nodes.NewUnknown => newNode.possibleTypes
    }
    def typeFullName: String = node match {
      case stored: nodes.StoredNode  => stored.typeFullName
      case newNode: nodes.NewUnknown => newNode.typeFullName
    }
  }
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  extension (node: nodes.AstNodeBase) {
    def code: String = node match {
      case stored: nodes.StoredNode  => stored.code
      case newNode: nodes.AstNodeNew => newNode.code
    }
    def columnNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => stored.columnNumber
      case newNode: nodes.AstNodeNew => newNode.columnNumber
    }
    def lineNumber: Option[Int] = node match {
      case stored: nodes.StoredNode  => stored.lineNumber
      case newNode: nodes.AstNodeNew => newNode.lineNumber
    }
    def order: Int = node match {
      case stored: nodes.StoredNode  => stored.order
      case newNode: nodes.AstNodeNew => newNode.order
    }
  }
  extension (node: nodes.CallReprBase) {
    def name: String = node match {
      case stored: nodes.StoredNode   => stored.name
      case newNode: nodes.CallReprNew => newNode.name
    }
    def signature: String = node match {
      case stored: nodes.StoredNode   => stored.signature
      case newNode: nodes.CallReprNew => newNode.signature
    }
  }
  extension (node: nodes.ExpressionBase) {
    def argumentIndex: Int = node match {
      case stored: nodes.StoredNode     => stored.argumentIndex
      case newNode: nodes.ExpressionNew => newNode.argumentIndex
    }
    def argumentName: Option[String] = node match {
      case stored: nodes.StoredNode     => stored.argumentName
      case newNode: nodes.ExpressionNew => newNode.argumentName
    }
  }
}

trait AbstractBaseConversions1 {
  extension (node: nodes.DeclarationBase) {
    def name: String = node match {
      case stored: nodes.StoredNode      => stored.name
      case newNode: nodes.DeclarationNew => newNode.name
    }
  }
}
