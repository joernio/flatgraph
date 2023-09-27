package io.shiftleft.codepropertygraph.generated.v2
import io.joern.odb2

object Cpg {
  def empty: Cpg = new Cpg(new odb2.Graph(GraphSchema))
}
class Cpg(val graph: odb2.Graph) {
  assert(graph.schema == GraphSchema)
}

class CpgNodeStarters(val wrappedCpg: Cpg) extends AnyVal {
  def all: Iterator[nodes.AbstractNode] = wrappedCpg.graph.allNodes.asInstanceOf[Iterator[nodes.AbstractNode]]

  def annotation: Iterator[nodes.Annotation]                   = wrappedCpg.graph.nodes(0).asInstanceOf[Iterator[nodes.Annotation]]
  def annotationLiteral: Iterator[nodes.AnnotationLiteral]     = wrappedCpg.graph.nodes(1).asInstanceOf[Iterator[nodes.AnnotationLiteral]]
  def annotationParameter: Iterator[nodes.AnnotationParameter] = wrappedCpg.graph.nodes(2).asInstanceOf[Iterator[nodes.AnnotationParameter]]
  def annotationParameterAssign: Iterator[nodes.AnnotationParameterAssign] =
    wrappedCpg.graph.nodes(3).asInstanceOf[Iterator[nodes.AnnotationParameterAssign]]
  def arrayInitializer: Iterator[nodes.ArrayInitializer]     = wrappedCpg.graph.nodes(4).asInstanceOf[Iterator[nodes.ArrayInitializer]]
  def binding: Iterator[nodes.Binding]                       = wrappedCpg.graph.nodes(5).asInstanceOf[Iterator[nodes.Binding]]
  def block: Iterator[nodes.Block]                           = wrappedCpg.graph.nodes(6).asInstanceOf[Iterator[nodes.Block]]
  def call: Iterator[nodes.Call]                             = wrappedCpg.graph.nodes(7).asInstanceOf[Iterator[nodes.Call]]
  def callChain: Iterator[nodes.CallChain]                   = wrappedCpg.graph.nodes(8).asInstanceOf[Iterator[nodes.CallChain]]
  def callSite: Iterator[nodes.CallSite]                     = wrappedCpg.graph.nodes(9).asInstanceOf[Iterator[nodes.CallSite]]
  def closureBinding: Iterator[nodes.ClosureBinding]         = wrappedCpg.graph.nodes(10).asInstanceOf[Iterator[nodes.ClosureBinding]]
  def comment: Iterator[nodes.Comment]                       = wrappedCpg.graph.nodes(11).asInstanceOf[Iterator[nodes.Comment]]
  def configFile: Iterator[nodes.ConfigFile]                 = wrappedCpg.graph.nodes(12).asInstanceOf[Iterator[nodes.ConfigFile]]
  def controlStructure: Iterator[nodes.ControlStructure]     = wrappedCpg.graph.nodes(13).asInstanceOf[Iterator[nodes.ControlStructure]]
  def dependency: Iterator[nodes.Dependency]                 = wrappedCpg.graph.nodes(14).asInstanceOf[Iterator[nodes.Dependency]]
  def domAttribute: Iterator[nodes.DomAttribute]             = wrappedCpg.graph.nodes(15).asInstanceOf[Iterator[nodes.DomAttribute]]
  def domNode: Iterator[nodes.DomNode]                       = wrappedCpg.graph.nodes(16).asInstanceOf[Iterator[nodes.DomNode]]
  def fieldIdentifier: Iterator[nodes.FieldIdentifier]       = wrappedCpg.graph.nodes(17).asInstanceOf[Iterator[nodes.FieldIdentifier]]
  def file: Iterator[nodes.File]                             = wrappedCpg.graph.nodes(18).asInstanceOf[Iterator[nodes.File]]
  def finding: Iterator[nodes.Finding]                       = wrappedCpg.graph.nodes(19).asInstanceOf[Iterator[nodes.Finding]]
  def flow: Iterator[nodes.Flow]                             = wrappedCpg.graph.nodes(20).asInstanceOf[Iterator[nodes.Flow]]
  def framework: Iterator[nodes.Framework]                   = wrappedCpg.graph.nodes(21).asInstanceOf[Iterator[nodes.Framework]]
  def frameworkData: Iterator[nodes.FrameworkData]           = wrappedCpg.graph.nodes(22).asInstanceOf[Iterator[nodes.FrameworkData]]
  def identifier: Iterator[nodes.Identifier]                 = wrappedCpg.graph.nodes(23).asInstanceOf[Iterator[nodes.Identifier]]
  def implicitCall: Iterator[nodes.ImplicitCall]             = wrappedCpg.graph.nodes(24).asInstanceOf[Iterator[nodes.ImplicitCall]]
  def imports: Iterator[nodes.Import]                        = wrappedCpg.graph.nodes(25).asInstanceOf[Iterator[nodes.Import]]
  def ioflow: Iterator[nodes.Ioflow]                         = wrappedCpg.graph.nodes(26).asInstanceOf[Iterator[nodes.Ioflow]]
  def jumpLabel: Iterator[nodes.JumpLabel]                   = wrappedCpg.graph.nodes(27).asInstanceOf[Iterator[nodes.JumpLabel]]
  def jumpTarget: Iterator[nodes.JumpTarget]                 = wrappedCpg.graph.nodes(28).asInstanceOf[Iterator[nodes.JumpTarget]]
  def keyValuePair: Iterator[nodes.KeyValuePair]             = wrappedCpg.graph.nodes(29).asInstanceOf[Iterator[nodes.KeyValuePair]]
  def literal: Iterator[nodes.Literal]                       = wrappedCpg.graph.nodes(30).asInstanceOf[Iterator[nodes.Literal]]
  def local: Iterator[nodes.Local]                           = wrappedCpg.graph.nodes(31).asInstanceOf[Iterator[nodes.Local]]
  def location: Iterator[nodes.Location]                     = wrappedCpg.graph.nodes(32).asInstanceOf[Iterator[nodes.Location]]
  def matchInfo: Iterator[nodes.MatchInfo]                   = wrappedCpg.graph.nodes(33).asInstanceOf[Iterator[nodes.MatchInfo]]
  def member: Iterator[nodes.Member]                         = wrappedCpg.graph.nodes(34).asInstanceOf[Iterator[nodes.Member]]
  def metaData: Iterator[nodes.MetaData]                     = wrappedCpg.graph.nodes(35).asInstanceOf[Iterator[nodes.MetaData]]
  def method: Iterator[nodes.Method]                         = wrappedCpg.graph.nodes(36).asInstanceOf[Iterator[nodes.Method]]
  def methodInst: Iterator[nodes.MethodInst]                 = wrappedCpg.graph.nodes(37).asInstanceOf[Iterator[nodes.MethodInst]]
  def methodParameterIn: Iterator[nodes.MethodParameterIn]   = wrappedCpg.graph.nodes(38).asInstanceOf[Iterator[nodes.MethodParameterIn]]
  def methodParameterOut: Iterator[nodes.MethodParameterOut] = wrappedCpg.graph.nodes(39).asInstanceOf[Iterator[nodes.MethodParameterOut]]
  def methodRef: Iterator[nodes.MethodRef]                   = wrappedCpg.graph.nodes(40).asInstanceOf[Iterator[nodes.MethodRef]]
  def methodReturn: Iterator[nodes.MethodReturn]             = wrappedCpg.graph.nodes(41).asInstanceOf[Iterator[nodes.MethodReturn]]
  def methodSummary: Iterator[nodes.MethodSummary]           = wrappedCpg.graph.nodes(42).asInstanceOf[Iterator[nodes.MethodSummary]]
  def modifier: Iterator[nodes.Modifier]                     = wrappedCpg.graph.nodes(43).asInstanceOf[Iterator[nodes.Modifier]]
  def namespace: Iterator[nodes.Namespace]                   = wrappedCpg.graph.nodes(44).asInstanceOf[Iterator[nodes.Namespace]]
  def namespaceBlock: Iterator[nodes.NamespaceBlock]         = wrappedCpg.graph.nodes(45).asInstanceOf[Iterator[nodes.NamespaceBlock]]
  def packagePrefix: Iterator[nodes.PackagePrefix]           = wrappedCpg.graph.nodes(46).asInstanceOf[Iterator[nodes.PackagePrefix]]
  def postExecutionCall: Iterator[nodes.PostExecutionCall]   = wrappedCpg.graph.nodes(47).asInstanceOf[Iterator[nodes.PostExecutionCall]]
  def programPoint: Iterator[nodes.ProgramPoint]             = wrappedCpg.graph.nodes(48).asInstanceOf[Iterator[nodes.ProgramPoint]]
  def read: Iterator[nodes.Read]                             = wrappedCpg.graph.nodes(49).asInstanceOf[Iterator[nodes.Read]]
  def ret: Iterator[nodes.Return]                            = wrappedCpg.graph.nodes(50).asInstanceOf[Iterator[nodes.Return]]
  def route: Iterator[nodes.Route]                           = wrappedCpg.graph.nodes(51).asInstanceOf[Iterator[nodes.Route]]
  def sensitiveDataType: Iterator[nodes.SensitiveDataType]   = wrappedCpg.graph.nodes(52).asInstanceOf[Iterator[nodes.SensitiveDataType]]
  def sensitiveMember: Iterator[nodes.SensitiveMember]       = wrappedCpg.graph.nodes(53).asInstanceOf[Iterator[nodes.SensitiveMember]]
  def sensitiveReference: Iterator[nodes.SensitiveReference] = wrappedCpg.graph.nodes(54).asInstanceOf[Iterator[nodes.SensitiveReference]]
  def sensitiveVariable: Iterator[nodes.SensitiveVariable]   = wrappedCpg.graph.nodes(55).asInstanceOf[Iterator[nodes.SensitiveVariable]]
  def sink: Iterator[nodes.Sink]                             = wrappedCpg.graph.nodes(56).asInstanceOf[Iterator[nodes.Sink]]
  def source: Iterator[nodes.Source]                         = wrappedCpg.graph.nodes(57).asInstanceOf[Iterator[nodes.Source]]
  def spAnnotationParameter: Iterator[nodes.SpAnnotationParameter] =
    wrappedCpg.graph.nodes(58).asInstanceOf[Iterator[nodes.SpAnnotationParameter]]
  def spBlacklist: Iterator[nodes.SpBlacklist]       = wrappedCpg.graph.nodes(59).asInstanceOf[Iterator[nodes.SpBlacklist]]
  def tag: Iterator[nodes.Tag]                       = wrappedCpg.graph.nodes(60).asInstanceOf[Iterator[nodes.Tag]]
  def tags: Iterator[nodes.Tags]                     = wrappedCpg.graph.nodes(61).asInstanceOf[Iterator[nodes.Tags]]
  def tagNodePair: Iterator[nodes.TagNodePair]       = wrappedCpg.graph.nodes(62).asInstanceOf[Iterator[nodes.TagNodePair]]
  def templateDom: Iterator[nodes.TemplateDom]       = wrappedCpg.graph.nodes(63).asInstanceOf[Iterator[nodes.TemplateDom]]
  def transform: Iterator[nodes.Transform]           = wrappedCpg.graph.nodes(64).asInstanceOf[Iterator[nodes.Transform]]
  def transformation: Iterator[nodes.Transformation] = wrappedCpg.graph.nodes(65).asInstanceOf[Iterator[nodes.Transformation]]
  def typ: Iterator[nodes.Type]                      = wrappedCpg.graph.nodes(66).asInstanceOf[Iterator[nodes.Type]]
  def typeArgument: Iterator[nodes.TypeArgument]     = wrappedCpg.graph.nodes(67).asInstanceOf[Iterator[nodes.TypeArgument]]
  def typeDecl: Iterator[nodes.TypeDecl]             = wrappedCpg.graph.nodes(68).asInstanceOf[Iterator[nodes.TypeDecl]]
  def typeParameter: Iterator[nodes.TypeParameter]   = wrappedCpg.graph.nodes(69).asInstanceOf[Iterator[nodes.TypeParameter]]
  def typeRef: Iterator[nodes.TypeRef]               = wrappedCpg.graph.nodes(70).asInstanceOf[Iterator[nodes.TypeRef]]
  def unknown: Iterator[nodes.Unknown]               = wrappedCpg.graph.nodes(71).asInstanceOf[Iterator[nodes.Unknown]]
  def variableInfo: Iterator[nodes.VariableInfo]     = wrappedCpg.graph.nodes(72).asInstanceOf[Iterator[nodes.VariableInfo]]
  def vulnerability: Iterator[nodes.Vulnerability]   = wrappedCpg.graph.nodes(73).asInstanceOf[Iterator[nodes.Vulnerability]]
  def write: Iterator[nodes.Write]                   = wrappedCpg.graph.nodes(74).asInstanceOf[Iterator[nodes.Write]]

  def astNode: Iterator[nodes.AstNode] = Iterator(
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
    this.implicitCall,
    this.imports,
    this.jumpLabel,
    this.jumpTarget,
    this.literal,
    this.local,
    this.member,
    this.method,
    this.methodInst,
    this.methodParameterIn,
    this.methodParameterOut,
    this.methodRef,
    this.methodReturn,
    this.modifier,
    this.namespace,
    this.namespaceBlock,
    this.postExecutionCall,
    this.ret,
    this.templateDom,
    this.typeArgument,
    this.typeDecl,
    this.typeParameter,
    this.typeRef,
    this.unknown
  ).flatten
  def callRepr: Iterator[nodes.CallRepr] = Iterator(this.call, this.implicitCall, this.postExecutionCall).flatten
  def cfgNode: Iterator[nodes.CfgNode] = Iterator(
    this.annotation,
    this.annotationLiteral,
    this.arrayInitializer,
    this.block,
    this.call,
    this.controlStructure,
    this.fieldIdentifier,
    this.identifier,
    this.implicitCall,
    this.jumpTarget,
    this.literal,
    this.method,
    this.methodParameterIn,
    this.methodParameterOut,
    this.methodRef,
    this.methodReturn,
    this.postExecutionCall,
    this.ret,
    this.templateDom,
    this.typeRef,
    this.unknown
  ).flatten
  def declaration: Iterator[nodes.Declaration] =
    Iterator(this.local, this.member, this.method, this.methodParameterIn, this.methodParameterOut).flatten
  def expression: Iterator[nodes.Expression] = Iterator(
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
  def localLike: Iterator[nodes.LocalLike] = Iterator(this.identifier, this.local, this.methodParameterIn).flatten
  def trackingPoint: Iterator[nodes.TrackingPoint] = Iterator(
    this.annotation,
    this.annotationLiteral,
    this.arrayInitializer,
    this.block,
    this.call,
    this.configFile,
    this.controlStructure,
    this.domNode,
    this.fieldIdentifier,
    this.identifier,
    this.implicitCall,
    this.jumpTarget,
    this.literal,
    this.method,
    this.methodParameterIn,
    this.methodParameterOut,
    this.methodRef,
    this.methodReturn,
    this.postExecutionCall,
    this.ret,
    this.templateDom,
    this.typeRef,
    this.unknown
  ).flatten
}
