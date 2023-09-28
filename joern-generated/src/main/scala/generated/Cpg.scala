package io.shiftleft.codepropertygraph.generated.v2
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes.*

object Cpg {
  def empty: Cpg = new Cpg(new odb2.Graph(GraphSchema))
}
class Cpg(val graph: odb2.Graph) {
  assert(graph.schema == GraphSchema)
}

class CpgNodeStarters(val wrappedCpg: Cpg) extends AnyVal {
  def all: Iterator[AbstractNode] = wrappedCpg.graph.allNodes.asInstanceOf[Iterator[AbstractNode]]

  def annotation: Iterator[Annotation]                   = wrappedCpg.graph.nodes(0).asInstanceOf[Iterator[Annotation]]
  def annotationLiteral: Iterator[AnnotationLiteral]     = wrappedCpg.graph.nodes(1).asInstanceOf[Iterator[AnnotationLiteral]]
  def annotationParameter: Iterator[AnnotationParameter] = wrappedCpg.graph.nodes(2).asInstanceOf[Iterator[AnnotationParameter]]
  def annotationParameterAssign: Iterator[AnnotationParameterAssign] =
    wrappedCpg.graph.nodes(3).asInstanceOf[Iterator[AnnotationParameterAssign]]
  def arrayInitializer: Iterator[ArrayInitializer]     = wrappedCpg.graph.nodes(4).asInstanceOf[Iterator[ArrayInitializer]]
  def binding: Iterator[Binding]                       = wrappedCpg.graph.nodes(5).asInstanceOf[Iterator[Binding]]
  def block: Iterator[Block]                           = wrappedCpg.graph.nodes(6).asInstanceOf[Iterator[Block]]
  def call: Iterator[Call]                             = wrappedCpg.graph.nodes(7).asInstanceOf[Iterator[Call]]
  def closureBinding: Iterator[ClosureBinding]         = wrappedCpg.graph.nodes(8).asInstanceOf[Iterator[ClosureBinding]]
  def comment: Iterator[Comment]                       = wrappedCpg.graph.nodes(9).asInstanceOf[Iterator[Comment]]
  def configFile: Iterator[ConfigFile]                 = wrappedCpg.graph.nodes(10).asInstanceOf[Iterator[ConfigFile]]
  def controlStructure: Iterator[ControlStructure]     = wrappedCpg.graph.nodes(11).asInstanceOf[Iterator[ControlStructure]]
  def dependency: Iterator[Dependency]                 = wrappedCpg.graph.nodes(12).asInstanceOf[Iterator[Dependency]]
  def fieldIdentifier: Iterator[FieldIdentifier]       = wrappedCpg.graph.nodes(13).asInstanceOf[Iterator[FieldIdentifier]]
  def file: Iterator[File]                             = wrappedCpg.graph.nodes(14).asInstanceOf[Iterator[File]]
  def finding: Iterator[Finding]                       = wrappedCpg.graph.nodes(15).asInstanceOf[Iterator[Finding]]
  def identifier: Iterator[Identifier]                 = wrappedCpg.graph.nodes(16).asInstanceOf[Iterator[Identifier]]
  def imports: Iterator[Import]                        = wrappedCpg.graph.nodes(17).asInstanceOf[Iterator[Import]]
  def jumpLabel: Iterator[JumpLabel]                   = wrappedCpg.graph.nodes(18).asInstanceOf[Iterator[JumpLabel]]
  def jumpTarget: Iterator[JumpTarget]                 = wrappedCpg.graph.nodes(19).asInstanceOf[Iterator[JumpTarget]]
  def keyValuePair: Iterator[KeyValuePair]             = wrappedCpg.graph.nodes(20).asInstanceOf[Iterator[KeyValuePair]]
  def literal: Iterator[Literal]                       = wrappedCpg.graph.nodes(21).asInstanceOf[Iterator[Literal]]
  def local: Iterator[Local]                           = wrappedCpg.graph.nodes(22).asInstanceOf[Iterator[Local]]
  def location: Iterator[Location]                     = wrappedCpg.graph.nodes(23).asInstanceOf[Iterator[Location]]
  def member: Iterator[Member]                         = wrappedCpg.graph.nodes(24).asInstanceOf[Iterator[Member]]
  def metaData: Iterator[MetaData]                     = wrappedCpg.graph.nodes(25).asInstanceOf[Iterator[MetaData]]
  def method: Iterator[Method]                         = wrappedCpg.graph.nodes(26).asInstanceOf[Iterator[Method]]
  def methodParameterIn: Iterator[MethodParameterIn]   = wrappedCpg.graph.nodes(27).asInstanceOf[Iterator[MethodParameterIn]]
  def methodParameterOut: Iterator[MethodParameterOut] = wrappedCpg.graph.nodes(28).asInstanceOf[Iterator[MethodParameterOut]]
  def methodRef: Iterator[MethodRef]                   = wrappedCpg.graph.nodes(29).asInstanceOf[Iterator[MethodRef]]
  def methodReturn: Iterator[MethodReturn]             = wrappedCpg.graph.nodes(30).asInstanceOf[Iterator[MethodReturn]]
  def modifier: Iterator[Modifier]                     = wrappedCpg.graph.nodes(31).asInstanceOf[Iterator[Modifier]]
  def namespace: Iterator[Namespace]                   = wrappedCpg.graph.nodes(32).asInstanceOf[Iterator[Namespace]]
  def namespaceBlock: Iterator[NamespaceBlock]         = wrappedCpg.graph.nodes(33).asInstanceOf[Iterator[NamespaceBlock]]
  def ret: Iterator[Return]                            = wrappedCpg.graph.nodes(34).asInstanceOf[Iterator[Return]]
  def tag: Iterator[Tag]                               = wrappedCpg.graph.nodes(35).asInstanceOf[Iterator[Tag]]
  def tagNodePair: Iterator[TagNodePair]               = wrappedCpg.graph.nodes(36).asInstanceOf[Iterator[TagNodePair]]
  def templateDom: Iterator[TemplateDom]               = wrappedCpg.graph.nodes(37).asInstanceOf[Iterator[TemplateDom]]
  def typ: Iterator[Type]                              = wrappedCpg.graph.nodes(38).asInstanceOf[Iterator[Type]]
  def typeArgument: Iterator[TypeArgument]             = wrappedCpg.graph.nodes(39).asInstanceOf[Iterator[TypeArgument]]
  def typeDecl: Iterator[TypeDecl]                     = wrappedCpg.graph.nodes(40).asInstanceOf[Iterator[TypeDecl]]
  def typeParameter: Iterator[TypeParameter]           = wrappedCpg.graph.nodes(41).asInstanceOf[Iterator[TypeParameter]]
  def typeRef: Iterator[TypeRef]                       = wrappedCpg.graph.nodes(42).asInstanceOf[Iterator[TypeRef]]
  def unknown: Iterator[Unknown]                       = wrappedCpg.graph.nodes(43).asInstanceOf[Iterator[Unknown]]

  def astNode: Iterator[AstNode] = Iterator(
    this.annotation,
    this.annotationLiteral,
    this.annotationParameter,
    this.annotationParameterAssign,
    this.arrayInitializer,
    this.block,
    this.call,
    this.comment,
    this.controlStructure,
    this.fieldIdentifier,
    this.file,
    this.identifier,
    this.imports,
    this.jumpLabel,
    this.jumpTarget,
    this.literal,
    this.local,
    this.member,
    this.method,
    this.methodParameterIn,
    this.methodParameterOut,
    this.methodRef,
    this.methodReturn,
    this.modifier,
    this.namespace,
    this.namespaceBlock,
    this.ret,
    this.templateDom,
    this.typeArgument,
    this.typeDecl,
    this.typeParameter,
    this.typeRef,
    this.unknown
  ).flatten
  def callRepr: Iterator[CallRepr] = Iterator(this.call).flatten
  def cfgNode: Iterator[CfgNode] = Iterator(
    this.annotation,
    this.annotationLiteral,
    this.arrayInitializer,
    this.block,
    this.call,
    this.controlStructure,
    this.fieldIdentifier,
    this.identifier,
    this.jumpTarget,
    this.literal,
    this.method,
    this.methodParameterIn,
    this.methodParameterOut,
    this.methodRef,
    this.methodReturn,
    this.ret,
    this.templateDom,
    this.typeRef,
    this.unknown
  ).flatten
  def declaration: Iterator[Declaration] =
    Iterator(this.local, this.member, this.method, this.methodParameterIn, this.methodParameterOut).flatten
  def expression: Iterator[Expression] = Iterator(
    this.annotation,
    this.annotationLiteral,
    this.arrayInitializer,
    this.block,
    this.call,
    this.controlStructure,
    this.fieldIdentifier,
    this.identifier,
    this.literal,
    this.methodRef,
    this.ret,
    this.templateDom,
    this.typeRef,
    this.unknown
  ).flatten
}
