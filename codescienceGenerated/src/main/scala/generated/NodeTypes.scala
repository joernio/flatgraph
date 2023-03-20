package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

class Annotation(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 0.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def fullName: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class AnnotationLiteral(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 1.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class AnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 2.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class AnnotationParameterAssign(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 3.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class ArrayInitializer(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 4.toShort, seq_4762)
    with AstNode
    with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Binding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 5.toShort, seq_4762) {
  def isMethodNeverOverridden: Option[Boolean] = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 44, seq)
  def methodFullName: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, "<empty>": String)
  def name: String                             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def signature: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)

}

class Block(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 6.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class Call(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 7.toShort, seq_4762) with CallRepr with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dispatchName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 25, seq, "": String)
  def dispatchType: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 26, seq, "<empty>": String)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def methodFullName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, "<empty>": String)
  def methodInstFullName: Option[String]          = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 54, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def resolved: Option[Boolean]                   = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 68, seq)
  def signature: String                           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class CallChain(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 8.toShort, seq_4762) {

  def calls: IndexedSeq[Call]     = odb2.Accessors.getNodePropertyMulti[Call](graph, nodeKind, 84, seq)
  def methods: IndexedSeq[Method] = odb2.Accessors.getNodePropertyMulti[Method](graph, nodeKind, 85, seq)
}

class CallSite(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 9.toShort, seq_4762) {

  def call: Call           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def callerMethod: Method = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Method)
  def method: Method       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
}

class ClosureBinding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 10.toShort, seq_4762) {
  def closureBindingId: Option[String]    = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 13, seq)
  def closureOriginalName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 14, seq)
  def evaluationStrategy: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 28, seq, "<empty>": String)

}

class Comment(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 11.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def filename: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class ConfigFile(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 12.toShort, seq_4762) with TrackingPoint {
  def code: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def content: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)
  def name: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)

}

class ControlStructure(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 13.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def controlStructureType: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 20, seq, "<empty>": String)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def parserTypeName: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 64, seq, "<empty>": String)

}

class Dependency(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 14.toShort, seq_4762) {
  def dependencyGroupId: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 21, seq)
  def dependencyType: String            = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 22, seq, "<empty>": String)
  def name: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def version: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 83, seq, "<empty>": String)

}

class DomAttribute(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 15.toShort, seq_4762) {
  def name: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 80, seq, "": String)

}

class DomNode(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 16.toShort, seq_4762) with TrackingPoint {
  def code: String                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]            = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]              = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def attributes: IndexedSeq[DomAttribute] = odb2.Accessors.getNodePropertyMulti[DomAttribute](graph, nodeKind, 84, seq)
}

class FieldIdentifier(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 17.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def canonicalName: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 8, seq, "<empty>": String)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class File(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 18.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def hash: Option[String]      = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 35, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Finding(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 19.toShort, seq_4762) {
  def structuredFingerprint: String           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 75, seq, "null": String)
  def evidence: IndexedSeq[StoredNode]        = odb2.Accessors.getNodePropertyMulti[StoredNode](graph, nodeKind, 84, seq)
  def keyValuePairs: IndexedSeq[KeyValuePair] = odb2.Accessors.getNodePropertyMulti[KeyValuePair](graph, nodeKind, 85, seq)
  def rootCauses: IndexedSeq[Finding]         = odb2.Accessors.getNodePropertyMulti[Finding](graph, nodeKind, 86, seq)
}

class Flow(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 20.toShort, seq_4762) {

  def branchPoints: IndexedSeq[TrackingPoint]     = odb2.Accessors.getNodePropertyMulti[TrackingPoint](graph, nodeKind, 85, seq)
  def cfgNodes: IndexedSeq[CfgNode]               = odb2.Accessors.getNodePropertyMulti[CfgNode](graph, nodeKind, 87, seq)
  def points: IndexedSeq[ProgramPoint]            = odb2.Accessors.getNodePropertyMulti[ProgramPoint](graph, nodeKind, 88, seq)
  def sink: Sink                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def source: Source                              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def transformations: IndexedSeq[Transformation] = odb2.Accessors.getNodePropertyMulti[Transformation](graph, nodeKind, 89, seq)
}

class Framework(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 21.toShort, seq_4762) {
  def name: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)

}

class FrameworkData(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 22.toShort, seq_4762) {
  def content: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 19, seq, "<empty>": String)
  def name: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)

}

class Identifier(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with LocalLike
    with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class ImplicitCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 24.toShort, seq_4762)
    with TrackingPoint
    with CallRepr {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def signature: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)

}

class Import(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 25.toShort, seq_4762) with AstNode {
  def code: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def explicitAs: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 31, seq)
  def importedAs: Option[String]     = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 37, seq)
  def importedEntity: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 38, seq)
  def isExplicit: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 42, seq)
  def isWildcard: Option[Boolean]    = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 47, seq)
  def lineNumber: Option[Int]        = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Ioflow(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 26.toShort, seq_4762) {
  def fingerprint: String                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 33, seq, "<empty>": String)
  def literalsToSink: IndexedSeq[String]      = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 52, seq)
  def mlAssisted: Boolean                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 56, seq, false: Boolean)
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

class JumpLabel(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 27.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def parserTypeName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 64, seq, "<empty>": String)

}

class JumpTarget(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 28.toShort, seq_4762) with CfgNode with AstNode {
  def argumentIndex: Int        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def parserTypeName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 64, seq, "<empty>": String)

}

class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 29.toShort, seq_4762) {
  def key: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 48, seq, "<empty>": String)
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 80, seq, "": String)

}

class Literal(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 30.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class Local(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 31.toShort, seq_4762)
    with AstNode
    with Declaration
    with LocalLike {
  def closureBindingId: Option[String]            = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 13, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class Location(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 32.toShort, seq_4762) {
  def className: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 11, seq, "<empty>": String)
  def classShortName: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 12, seq, "<empty>": String)
  def filename: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def lineNumber: Option[Int]  = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def methodFullName: String   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, "<empty>": String)
  def methodShortName: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 55, seq, "<empty>": String)
  def nodeLabel: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 59, seq, "<empty>": String)
  def packageName: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 62, seq, "<empty>": String)
  def symbol: String           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 76, seq, "<empty>": String)
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 84, seq)
}

class MatchInfo(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 33.toShort, seq_4762) {
  def category: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 10, seq, "<empty>": String)
  def pattern: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 66, seq, "<empty>": String)

}

class Member(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 34.toShort, seq_4762) with AstNode with Declaration {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class MetaData(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) {
  def hash: Option[String]                  = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 35, seq)
  def language: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 49, seq, "<empty>": String)
  def overlays: IndexedSeq[String]          = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 61, seq)
  def policyDirectories: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 67, seq)
  def root: String                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 69, seq, "<empty>": String)
  def spid: Option[String]                  = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 74, seq)
  def version: String                       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 83, seq, "<empty>": String)

}

class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 36.toShort, seq_4762)
    with CfgNode
    with AstNode
    with Declaration {
  def astParentFullName: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 5, seq, "<empty>": String)
  def astParentType: String           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 6, seq, "<empty>": String)
  def binarySignature: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 7, seq)
  def code: String                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]       = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def columnNumberEnd: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 17, seq)
  def depthFirstOrder: Int            = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def filename: String                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def fullName: String                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def hasMapping: Option[Boolean]     = odb2.Accessors.getNodePropertyOption[Boolean](graph, nodeKind, 36, seq)
  def hash: Option[String]            = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 35, seq)
  def internalFlags: Int              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def isExternal: Boolean             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 43, seq, false: Boolean)
  def lineNumber: Option[Int]         = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def lineNumberEnd: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 51, seq)
  def name: String                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def signature: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)
  def varargParameter: Int            = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 81, seq, -1: Int)

}

class MethodInst(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 37.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def fullName: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def methodFullName: String    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, "<empty>": String)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def signature: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)

}

class MethodParameterIn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with CfgNode
    with AstNode
    with Declaration
    with LocalLike
    with TrackingPoint {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def evaluationStrategy: String                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 28, seq, "<empty>": String)
  def index: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, -1: Int)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def isVariadic: Boolean                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 46, seq, false: Boolean)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class MethodParameterOut(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 39.toShort, seq_4762)
    with CfgNode
    with AstNode
    with Declaration
    with TrackingPoint {
  def code: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]  = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def evaluationStrategy: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 28, seq, "<empty>": String)
  def index: Int                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 39, seq, -1: Int)
  def internalFlags: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def isVariadic: Boolean        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 46, seq, false: Boolean)
  def lineNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class MethodRef(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 40.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def methodFullName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 53, seq, "<empty>": String)
  def methodInstFullName: Option[String]          = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 54, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class MethodReturn(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 41.toShort, seq_4762)
    with CfgNode
    with TrackingPoint {
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def evaluationStrategy: String                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 28, seq, "<empty>": String)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class MethodSummary(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 42.toShort, seq_4762) {
  def binarySignature: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 7, seq)
  def isExternal: Boolean             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 43, seq, false: Boolean)
  def isStatic: Boolean               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 45, seq, false: Boolean)
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

class Modifier(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 43.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def modifierType: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 57, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Namespace(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 44.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class NamespaceBlock(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 45.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def filename: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def fullName: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class PackagePrefix(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 46.toShort, seq_4762) {
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 80, seq, "": String)

}

class PostExecutionCall(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 47.toShort, seq_4762)
    with TrackingPoint
    with CallRepr {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def signature: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 71, seq, "": String)

}

class ProgramPoint(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 48.toShort, seq_4762) {

  def elem: TrackingPoint         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: TrackingPoint)
  def method: Option[Method]      = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 85, seq)
  def methodTags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def paramTags: IndexedSeq[Tag]  = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 84, seq)
}

class Read(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 49.toShort, seq_4762) {

  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def source: Source                           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Source)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}

class Return(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 50.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Route(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 51.toShort, seq_4762) {
  def path: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 65, seq, "<empty>": String)

}

class SensitiveDataType(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 52.toShort, seq_4762) {
  def fullName: String                     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def members: IndexedSeq[SensitiveMember] = odb2.Accessors.getNodePropertyMulti[SensitiveMember](graph, nodeKind, 85, seq)
  def names: IndexedSeq[MatchInfo]         = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}

class SensitiveMember(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 53.toShort, seq_4762) {
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def names: IndexedSeq[MatchInfo] = odb2.Accessors.getNodePropertyMulti[MatchInfo](graph, nodeKind, 84, seq)
}

class SensitiveReference(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 54.toShort, seq_4762) {

  def ioflows: IndexedSeq[Ioflow] = odb2.Accessors.getNodePropertyMulti[Ioflow](graph, nodeKind, 84, seq)
}

class SensitiveVariable(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 55.toShort, seq_4762) {
  def categories: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 9, seq)
  def evalType: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 30, seq, "<empty>": String)
  def name: String                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def node: LocalLike                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: LocalLike)
}

class Sink(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 56.toShort, seq_4762) {
  def sinkType: String                       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 72, seq, "<empty>": String)
  def structuredFingerprint: String          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 75, seq, "null": String)
  def callingMethod: Option[Method]          = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]                 = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]            = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def parameterIn: Option[MethodParameterIn] = odb2.Accessors.getNodePropertyOption[MethodParameterIn](graph, nodeKind, 86, seq)
  def parameterInTags: IndexedSeq[Tag]       = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 91, seq)
}

class Source(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 57.toShort, seq_4762) {
  def sourceType: String            = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 73, seq, "<empty>": String)
  def structuredFingerprint: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 75, seq, "null": String)
  def callingMethod: Option[Method] = odb2.Accessors.getNodePropertyOption[Method](graph, nodeKind, 88, seq)
  def callsite: Option[Call]        = odb2.Accessors.getNodePropertyOption[Call](graph, nodeKind, 89, seq)
  def method: Method                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Method)
  def methodTags: IndexedSeq[Tag]   = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 87, seq)
  def node: TrackingPoint           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
  def nodeType: Type                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 90, seq, null: Type)
  def tags: IndexedSeq[Tag]         = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

class SpAnnotationParameter(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 58.toShort, seq_4762) {
  def annotationFullName: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 1, seq, "<empty>": String)
  def annotationName: String     = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 2, seq, "<empty>": String)
  def name: String               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def value: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 80, seq, "": String)

}

class SpBlacklist(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 59.toShort, seq_4762) {

  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 60.toShort, seq_4762) {
  def name: String  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def value: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 80, seq, "": String)

}

class Tags(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 61.toShort, seq_4762) {

  def tags: IndexedSeq[Tag] = odb2.Accessors.getNodePropertyMulti[Tag](graph, nodeKind, 86, seq)
}

class TagNodePair(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 62.toShort, seq_4762) {

  def node: StoredNode = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: StoredNode)
  def tag: Tag         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 85, seq, null: Tag)
}

class TemplateDom(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 63.toShort, seq_4762) with Expression {
  def argumentIndex: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String] = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def internalFlags: Int           = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class Transform(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 64.toShort, seq_4762) {

  def call: Call                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 86, seq, null: Call)
  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}

class Transformation(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 65.toShort, seq_4762) {

  def node: TrackingPoint = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: TrackingPoint)
}

class Type(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 66.toShort, seq_4762) {
  def fullName: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def name: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def typeDeclFullName: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 77, seq, "<empty>": String)

}

class TypeArgument(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 67.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class TypeDecl(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 68.toShort, seq_4762) with AstNode {
  def aliasTypeFullName: Option[String]            = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 0, seq)
  def astParentFullName: String                    = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 5, seq, "<empty>": String)
  def astParentType: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 6, seq, "<empty>": String)
  def code: String                                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                    = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def filename: String                             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 32, seq, "<empty>": String)
  def fullName: String                             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 34, seq, "<empty>": String)
  def inheritsFromTypeFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 40, seq)
  def isExternal: Boolean                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 43, seq, false: Boolean)
  def lineNumber: Option[Int]                      = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String                                 = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                                   = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class TypeParameter(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 69.toShort, seq_4762) with AstNode {
  def code: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def lineNumber: Option[Int]   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def name: String              = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def order: Int                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)

}

class TypeRef(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 70.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class Unknown(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 71.toShort, seq_4762) with Expression {
  def argumentIndex: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 3, seq, -1: Int)
  def argumentName: Option[String]                = odb2.Accessors.getNodePropertyOption[String](graph, nodeKind, 4, seq)
  def code: String                                = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 15, seq, "<empty>": String)
  def columnNumber: Option[Int]                   = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 16, seq)
  def containedRef: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 18, seq, "<empty>": String)
  def depthFirstOrder: Int                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 23, seq, -1: Int)
  def dynamicTypeHintFullName: IndexedSeq[String] = odb2.Accessors.getNodePropertyMulti[String](graph, nodeKind, 27, seq)
  def internalFlags: Int                          = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 41, seq, 0: Int)
  def lineNumber: Option[Int]                     = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 50, seq)
  def order: Int                                  = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 60, seq, -1: Int)
  def parserTypeName: String                      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 64, seq, "<empty>": String)
  def typeFullName: String                        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 78, seq, "<empty>": String)

}

class VariableInfo(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 72.toShort, seq_4762) {
  def evaluationType: String      = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 29, seq, "<empty>": String)
  def parameterIndex: Option[Int] = odb2.Accessors.getNodePropertyOption[Int](graph, nodeKind, 63, seq)
  def varType: String             = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 82, seq, "<empty>": String)

}

class Vulnerability(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 73.toShort, seq_4762) {
  def description: String = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 24, seq, "<empty>": String)
  def name: String        = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 58, seq, "<empty>": String)
  def score: String       = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 70, seq, "<empty>": String)
  def url: String         = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 79, seq, "<empty>": String)

}

class Write(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 74.toShort, seq_4762) {

  def descriptorFlows: IndexedSeq[Flow]        = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 85, seq)
  def flows: IndexedSeq[Flow]                  = odb2.Accessors.getNodePropertyMulti[Flow](graph, nodeKind, 86, seq)
  def sink: Sink                               = odb2.Accessors.getNodePropertySingle(graph, nodeKind, 84, seq, null: Sink)
  def triggerCallChains: IndexedSeq[CallChain] = odb2.Accessors.getNodePropertyMulti[CallChain](graph, nodeKind, 87, seq)
}
