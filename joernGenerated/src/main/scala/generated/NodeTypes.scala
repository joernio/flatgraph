package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

class Annotation(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 0.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def fullName: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class AnnotationLiteral(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 1.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class AnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 2.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class AnnotationParameterAssign(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 3.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class ArrayInitializer(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 4.toShort, seq_4762)
    with Expression
    with AstNode {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Binding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 5.toShort, seq_4762) {
  def methodFullName: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 36, seq, "<empty>": String)
  def name: String           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def signature: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 46, seq, "": String)

}

class Block(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 6.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Call(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 7.toShort, seq_4762) with CallRepr with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dispatchType: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 17, seq, "<empty>": String)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def methodFullName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 36, seq, "<empty>": String)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def signature: String                           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 46, seq, "": String)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 8.toShort, seq_4762) {
  def closureBindingId: Option[String]    = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 8, seq)
  def closureOriginalName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 9, seq)
  def evaluationStrategy: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)

}

class Comment(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 9.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def filename: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 21, seq, "<empty>": String)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 10.toShort, seq_4762) {
  def content: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 14, seq, "<empty>": String)
  def name: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)

}

class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 11.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def controlStructureType: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def parserTypeName: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 44, seq, "<empty>": String)

}

class Dependency(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 12.toShort, seq_4762) {
  def dependencyGroupId: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 16, seq)
  def name: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def version: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 51, seq, "<empty>": String)

}

class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 13.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def canonicalName: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 5, seq, "<empty>": String)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class File(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 14.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def hash: Option[String]      = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 23, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Finding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 15.toShort, seq_4762) {

  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 52, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 53, seq)
}

class Identifier(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 16.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Import(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 17.toShort, seq_4762) with AstNode {
  def code: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def explicitAs: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 20, seq)
  def importedAs: Option[String]     = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 24, seq)
  def importedEntity: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 25, seq)
  def isExplicit: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 28, seq)
  def isWildcard: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 31, seq)
  def lineNumber: Option[Int]        = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 18.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def parserTypeName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 44, seq, "<empty>": String)

}

class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 19.toShort, seq_4762) with CfgNode with AstNode {
  def argumentIndex: Int        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def parserTypeName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 44, seq, "<empty>": String)

}

class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 20.toShort, seq_4762) {
  def key: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 50, seq, "": String)

}

class Literal(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 21.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Local(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 22.toShort, seq_4762) with Declaration with AstNode {
  def closureBindingId: Option[String]            = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 8, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Location(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 23.toShort, seq_4762) {
  def className: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 6, seq, "<empty>": String)
  def classShortName: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 7, seq, "<empty>": String)
  def filename: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 21, seq, "<empty>": String)
  def lineNumber: Option[Int]  = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def methodFullName: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 36, seq, "<empty>": String)
  def methodShortName: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 37, seq, "<empty>": String)
  def nodeLabel: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 40, seq, "<empty>": String)
  def packageName: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 43, seq, "<empty>": String)
  def symbol: String           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 47, seq, "<empty>": String)
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 52, seq)
}

class Member(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 24.toShort, seq_4762) with Declaration with AstNode {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class MetaData(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 25.toShort, seq_4762) {
  def hash: Option[String]         = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 23, seq)
  def language: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 33, seq, "<empty>": String)
  def overlays: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 42, seq)
  def root: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 45, seq, "<empty>": String)
  def version: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 51, seq, "<empty>": String)

}

class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with CfgNode
    with Declaration
    with AstNode {
  def astParentFullName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, "<empty>": String)
  def astParentType: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 4, seq, "<empty>": String)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def columnNumberEnd: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 12, seq)
  def filename: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 21, seq, "<empty>": String)
  def fullName: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def hash: Option[String]         = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 23, seq)
  def isExternal: Boolean          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 29, seq, false: Boolean)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def lineNumberEnd: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 35, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def signature: String            = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 46, seq, "": String)

}

class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 27.toShort, seq_4762)
    with CfgNode
    with Declaration
    with AstNode {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def evaluationStrategy: String                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)
  def index: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 26, seq, -1: Int)
  def isVariadic: Boolean                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 30, seq, false: Boolean)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class MethodParameterOut(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 28.toShort, seq_4762)
    with CfgNode
    with Declaration
    with AstNode {
  def code: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]  = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def evaluationStrategy: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)
  def index: Int                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 26, seq, -1: Int)
  def isVariadic: Boolean        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 30, seq, false: Boolean)
  def lineNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class MethodRef(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 29.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def methodFullName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 36, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 30.toShort, seq_4762) with CfgNode {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def evaluationStrategy: String                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Modifier(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 31.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def modifierType: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 38, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Namespace(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 32.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 33.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def filename: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 21, seq, "<empty>": String)
  def fullName: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Return(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 34.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) {
  def name: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 50, seq, "": String)

}

class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 36.toShort, seq_4762) {

  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 52, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, null: Tag)
}

class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 37.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class Type(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 38.toShort, seq_4762) {
  def fullName: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def name: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def typeDeclFullName: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 48, seq, "<empty>": String)

}

class TypeArgument(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 39.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class TypeDecl(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 40.toShort, seq_4762) with AstNode {
  def aliasTypeFullName: Option[String]            = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 0, seq)
  def astParentFullName: String                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, "<empty>": String)
  def astParentType: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 4, seq, "<empty>": String)
  def code: String                                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def filename: String                             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 21, seq, "<empty>": String)
  def fullName: String                             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def inheritsFromTypeFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def isExternal: Boolean                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 29, seq, false: Boolean)
  def lineNumber: Option[Int]                      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String                                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 41.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)

}

class TypeRef(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 42.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}

class Unknown(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 43.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 2, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 11, seq)
  def containedRef: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 13, seq, "<empty>": String)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 18, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 34, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, -1: Int)
  def parserTypeName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 44, seq, "<empty>": String)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)

}
