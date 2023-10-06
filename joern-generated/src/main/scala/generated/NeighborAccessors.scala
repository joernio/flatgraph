package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors
import io.joern.odb2
import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes

// object Lang extends ConcreteStoredConversions

object Accessors {
  // import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*

  /* accessors for concrete stored nodes start */
  final class AccessNeighborsForAnnotation(val node: nodes.Annotation) extends AnyVal {
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
      node._astOut.iterator.collectAll[nodes.AnnotationParameterAssign]

    def _identifierViaAstIn: Iterator[nodes.Identifier] = node._astIn.iterator.collectAll[nodes.Identifier]

    def _literalViaAstIn: Iterator[nodes.Literal] = node._astIn.iterator.collectAll[nodes.Literal]

    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodRefViaAstIn: Iterator[nodes.MethodRef] = node._astIn.iterator.collectAll[nodes.MethodRef]

    def _methodViaAstIn: Iterator[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method]

    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForAnnotationLiteral(val node: nodes.AnnotationLiteral) extends AnyVal {
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]
  }

  final class AccessNeighborsForAnnotationParameter(val node: nodes.AnnotationParameter) extends AnyVal {
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]
  }

  final class AccessNeighborsForAnnotationParameterAssign(val node: nodes.AnnotationParameterAssign) extends AnyVal {
    def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = node._astOut.iterator.collectAll[nodes.AnnotationLiteral]

    def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = node._astOut.iterator.collectAll[nodes.AnnotationParameter]

    def _annotationViaAstIn: Iterator[nodes.Annotation] = node._astIn.iterator.collectAll[nodes.Annotation]

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = node._astOut.iterator.collectAll[nodes.ArrayInitializer]
  }

  final class AccessNeighborsForArrayInitializer(val node: nodes.ArrayInitializer) extends AnyVal {
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]
  }

  final class AccessNeighborsForBinding(val node: nodes.Binding) extends AnyVal {
    // asd

// asd
  }

  final class AccessNeighborsForBlock(val node: nodes.Block) extends AnyVal {
    // asd

// asd

    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefOut: Iterator[nodes.Block] = node._reachingDefOut.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForCall(val node: nodes.Call) extends AnyVal {
    // asd

    def _blockViaArgumentOut: Iterator[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _blockViaReceiverOut: Option[nodes.Block] = node._receiverOut.iterator.collectAll[nodes.Block].nextOption()

    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaArgumentOut: Iterator[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call]

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaReceiverOut: Option[nodes.Call] = node._receiverOut.iterator.collectAll[nodes.Call].nextOption()

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReceiverOut: Iterator[nodes.ControlStructure] = node._receiverOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaArgumentOut: Iterator[nodes.FieldIdentifier] = node._argumentOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCfgIn: Option[nodes.FieldIdentifier] = node._cfgIn.iterator.collectAll[nodes.FieldIdentifier].nextOption()

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaArgumentOut: Iterator[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReceiverOut: Option[nodes.Identifier] = node._receiverOut.iterator.collectAll[nodes.Identifier].nextOption()

    def _importViaIsCallForImportOut: Iterator[nodes.Import] = node._isCallForImportOut.iterator.collectAll[nodes.Import]

    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaArgumentOut: Iterator[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal]

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _literalViaReceiverOut: Option[nodes.Literal] = node._receiverOut.iterator.collectAll[nodes.Literal].nextOption()

    def _memberViaRefOut: Iterator[nodes.Member] = node._refOut.iterator.collectAll[nodes.Member]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaArgumentOut: Iterator[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReceiverOut: Option[nodes.MethodRef] = node._receiverOut.iterator.collectAll[nodes.MethodRef].nextOption()

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaCallOut: Iterator[nodes.Method] = node._callOut.iterator.collectAll[nodes.Method]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReceiverOut: Iterator[nodes.TypeRef] = node._receiverOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaReceiverOut: Iterator[nodes.Unknown] = node._receiverOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForClosureBinding(val node: nodes.ClosureBinding) extends AnyVal {
    // asd

    def _localViaCapturedByIn: Iterator[nodes.Local] = node._capturedByIn.iterator.collectAll[nodes.Local]

    def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = node._refOut.iterator.collectAll[nodes.MethodParameterIn]

    def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = node._captureIn.iterator.collectAll[nodes.MethodRef]

    def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = node._captureIn.iterator.collectAll[nodes.TypeRef]
  }

  final class AccessNeighborsForComment(val node: nodes.Comment) extends AnyVal {
    def _commentViaSourceFileIn: Iterator[nodes.Comment] = node._sourceFileIn.iterator.collectAll[nodes.Comment]

    def _commentViaSourceFileOut: Iterator[nodes.Comment] = node._sourceFileOut.iterator.collectAll[nodes.Comment]

    def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]
  }

  final class AccessNeighborsForConfigFile(val node: nodes.ConfigFile) extends AnyVal {}

  final class AccessNeighborsForControlStructure(val node: nodes.ControlStructure) extends AnyVal {
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaConditionOut: Iterator[nodes.Block] = node._conditionOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaConditionOut: Iterator[nodes.Call] = node._conditionOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionOut: Iterator[nodes.ControlStructure] = node._conditionOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaConditionOut: Iterator[nodes.Identifier] = node._conditionOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpLabelViaAstOut: Iterator[nodes.JumpLabel] = node._astOut.iterator.collectAll[nodes.JumpLabel]

    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaConditionOut: Iterator[nodes.JumpTarget] = node._conditionOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaConditionOut: Iterator[nodes.Literal] = node._conditionOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaConditionOut: Iterator[nodes.MethodRef] = node._conditionOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaConditionOut: Iterator[nodes.Return] = node._conditionOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaConditionOut: Iterator[nodes.TypeRef] = node._conditionOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaConditionOut: Iterator[nodes.Unknown] = node._conditionOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForDependency(val node: nodes.Dependency) extends AnyVal {
    def _importViaImportsIn: Iterator[nodes.Import] = node._importsIn.iterator.collectAll[nodes.Import]
  }

  final class AccessNeighborsForFieldIdentifier(val node: nodes.FieldIdentifier) extends AnyVal {
    // asd

// asd

// asd

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForFile(val node: nodes.File) extends AnyVal {
    def _commentViaAstOut: Iterator[nodes.Comment] = node._astOut.iterator.collectAll[nodes.Comment]

    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

    def _methodViaSourceFileIn: Iterator[nodes.Method] = node._sourceFileIn.iterator.collectAll[nodes.Method]

    def _namespaceBlockViaAstOut: Iterator[nodes.NamespaceBlock] = node._astOut.iterator.collectAll[nodes.NamespaceBlock]

    def _namespaceBlockViaSourceFileIn: Iterator[nodes.NamespaceBlock] = node._sourceFileIn.iterator.collectAll[nodes.NamespaceBlock]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

    def _typeDeclViaContainsOut: Iterator[nodes.TypeDecl] = node._containsOut.iterator.collectAll[nodes.TypeDecl]

    def _typeDeclViaSourceFileIn: Iterator[nodes.TypeDecl] = node._sourceFileIn.iterator.collectAll[nodes.TypeDecl]
  }

  final class AccessNeighborsForFinding(val node: nodes.Finding) extends AnyVal {}

  final class AccessNeighborsForIdentifier(val node: nodes.Identifier) extends AnyVal {
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _localViaRefOut: Option[nodes.Local] = node._refOut.iterator.collectAll[nodes.Local].nextOption()

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterInViaRefOut: Option[nodes.MethodParameterIn] =
      node._refOut.iterator.collectAll[nodes.MethodParameterIn].nextOption()

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForImport(val node: nodes.Import) extends AnyVal {
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _callViaIsCallForImportIn: Iterator[nodes.Call] = node._isCallForImportIn.iterator.collectAll[nodes.Call]

    def _dependencyViaImportsOut: Iterator[nodes.Dependency] = node._importsOut.iterator.collectAll[nodes.Dependency]

    def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]
  }

  final class AccessNeighborsForJumpLabel(val node: nodes.JumpLabel) extends AnyVal {
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]
  }

  final class AccessNeighborsForJumpTarget(val node: nodes.JumpTarget) extends AnyVal {
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForKeyValuePair(val node: nodes.KeyValuePair) extends AnyVal {}

  final class AccessNeighborsForLiteral(val node: nodes.Literal) extends AnyVal {
    // asd

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _arrayInitializerViaAstIn: Iterator[nodes.ArrayInitializer] = node._astIn.iterator.collectAll[nodes.ArrayInitializer]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForLocal(val node: nodes.Local) extends AnyVal {
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = node._capturedByOut.iterator.collectAll[nodes.ClosureBinding]

    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _identifierViaRefIn: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForLocation(val node: nodes.Location) extends AnyVal {}

  final class AccessNeighborsForMember(val node: nodes.Member) extends AnyVal {
    // asd

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _callViaRefIn: Iterator[nodes.Call] = node._refIn.iterator.collectAll[nodes.Call]

    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForMetaData(val node: nodes.MetaData) extends AnyVal {}

  final class AccessNeighborsForMethod(val node: nodes.Method) extends AnyVal {
    // asd

// asd

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _bindingViaRefIn: Iterator[nodes.Binding] = node._refIn.iterator.collectAll[nodes.Binding]

    def _blockViaContainsOut: Iterator[nodes.Block] = node._containsOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _callViaCallIn: Iterator[nodes.Call] = node._callIn.iterator.collectAll[nodes.Call]

    def _callViaContainsOut: Iterator[nodes.Call] = node._containsOut.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaContainsOut: Iterator[nodes.ControlStructure] = node._containsOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaContainsOut: Iterator[nodes.FieldIdentifier] = node._containsOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    def _identifierViaContainsOut: Iterator[nodes.Identifier] = node._containsOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaContainsOut: Iterator[nodes.JumpTarget] = node._containsOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaContainsOut: Iterator[nodes.Literal] = node._containsOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaAstOut: Iterator[nodes.MethodParameterIn] = node._astOut.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterInViaReachingDefOut: Iterator[nodes.MethodParameterIn] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaAstOut: Iterator[nodes.MethodParameterOut] = node._astOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaContainsOut: Iterator[nodes.MethodRef] = node._containsOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaRefIn: Iterator[nodes.MethodRef] = node._refIn.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCfgOut: Option[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn].nextOption()

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    def _namespaceBlockViaAstIn: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    def _returnViaContainsOut: Iterator[nodes.Return] = node._containsOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

    def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

    def _typeDeclViaContainsIn: Iterator[nodes.TypeDecl] = node._containsIn.iterator.collectAll[nodes.TypeDecl]

    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

    def _typeRefViaContainsOut: Iterator[nodes.TypeRef] = node._containsOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _unknownViaContainsOut: Iterator[nodes.Unknown] = node._containsOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForMethodParameterIn(val node: nodes.MethodParameterIn) extends AnyVal {
    // asd

// asd

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaRefIn: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterOutViaParameterLinkOut: Iterator[nodes.MethodParameterOut] =
      node._parameterLinkOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForMethodParameterOut(val node: nodes.MethodParameterOut) extends AnyVal {
    // asd

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaParameterLinkIn: Iterator[nodes.MethodParameterIn] =
      node._parameterLinkIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForMethodRef(val node: nodes.MethodRef) extends AnyVal {
    // asd

// asd

    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForMethodReturn(val node: nodes.MethodReturn) extends AnyVal {
    // asd

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = node._cfgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodViaCfgIn: Option[nodes.Method] = node._cfgIn.iterator.collectAll[nodes.Method].nextOption()

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _returnViaCfgIn: Iterator[nodes.Return] = node._cfgIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = node._cfgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForModifier(val node: nodes.Modifier) extends AnyVal {
    // asd

// asd

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForNamespace(val node: nodes.Namespace) extends AnyVal {
    def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = node._refIn.iterator.collectAll[nodes.NamespaceBlock]
  }

  final class AccessNeighborsForNamespaceBlock(val node: nodes.NamespaceBlock) extends AnyVal {
    def _fileViaAstIn: Option[nodes.File] = node._astIn.iterator.collectAll[nodes.File].nextOption()

    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    def _namespaceViaRefOut: Iterator[nodes.Namespace] = node._refOut.iterator.collectAll[nodes.Namespace]

    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]
  }

  final class AccessNeighborsForReturn(val node: nodes.Return) extends AnyVal {
    // asd

    def _blockViaArgumentOut: Option[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block].nextOption()

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaArgumentOut: Option[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call].nextOption()

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaArgumentOut: Option[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier].nextOption()

    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaArgumentOut: Option[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal].nextOption()

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaArgumentOut: Option[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef].nextOption()

    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaReachingDefOut: Iterator[nodes.MethodReturn] = node._reachingDefOut.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaArgumentOut: Option[nodes.Return] = node._argumentOut.iterator.collectAll[nodes.Return].nextOption()

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForTag(val node: nodes.Tag) extends AnyVal {
    def _blockViaTaggedByIn: Iterator[nodes.Block] = node._taggedByIn.iterator.collectAll[nodes.Block]

    def _callViaTaggedByIn: Iterator[nodes.Call] = node._taggedByIn.iterator.collectAll[nodes.Call]

    def _controlStructureViaTaggedByIn: Iterator[nodes.ControlStructure] = node._taggedByIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaTaggedByIn: Iterator[nodes.FieldIdentifier] = node._taggedByIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fileViaTaggedByIn: Iterator[nodes.File] = node._taggedByIn.iterator.collectAll[nodes.File]

    def _identifierViaTaggedByIn: Iterator[nodes.Identifier] = node._taggedByIn.iterator.collectAll[nodes.Identifier]

    def _importViaTaggedByIn: Iterator[nodes.Import] = node._taggedByIn.iterator.collectAll[nodes.Import]

    def _jumpTargetViaTaggedByIn: Iterator[nodes.JumpTarget] = node._taggedByIn.iterator.collectAll[nodes.JumpTarget]

    def _literalViaTaggedByIn: Iterator[nodes.Literal] = node._taggedByIn.iterator.collectAll[nodes.Literal]

    def _localViaTaggedByIn: Iterator[nodes.Local] = node._taggedByIn.iterator.collectAll[nodes.Local]

    def _memberViaTaggedByIn: Iterator[nodes.Member] = node._taggedByIn.iterator.collectAll[nodes.Member]

    def _methodParameterInViaTaggedByIn: Iterator[nodes.MethodParameterIn] = node._taggedByIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] =
      node._taggedByIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaTaggedByIn: Iterator[nodes.MethodRef] = node._taggedByIn.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaTaggedByIn: Iterator[nodes.MethodReturn] = node._taggedByIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaTaggedByIn: Iterator[nodes.Method] = node._taggedByIn.iterator.collectAll[nodes.Method]

    def _returnViaTaggedByIn: Iterator[nodes.Return] = node._taggedByIn.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByIn: Iterator[nodes.Tag] = node._taggedByIn.iterator.collectAll[nodes.Tag]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _templateDomViaTaggedByIn: Iterator[nodes.TemplateDom] = node._taggedByIn.iterator.collectAll[nodes.TemplateDom]

    def _typeRefViaTaggedByIn: Iterator[nodes.TypeRef] = node._taggedByIn.iterator.collectAll[nodes.TypeRef]

    def _unknownViaTaggedByIn: Iterator[nodes.Unknown] = node._taggedByIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForTagNodePair(val node: nodes.TagNodePair) extends AnyVal {}

  final class AccessNeighborsForTemplateDom(val node: nodes.TemplateDom) extends AnyVal {
    def _expressionViaArgumentIn: Iterator[nodes.Expression] = node._argumentIn.iterator.collectAll[nodes.Expression]

    def _expressionViaAstOut: Iterator[nodes.Expression] = node._astOut.iterator.collectAll[nodes.Expression]

    def _expressionViaReachingDefOut: Iterator[nodes.Expression] = node._reachingDefOut.iterator.collectAll[nodes.Expression]

    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]
  }

  final class AccessNeighborsForType(val node: nodes.Type) extends AnyVal {
    def _arrayInitializerViaEvalTypeIn: Iterator[nodes.ArrayInitializer] = node._evalTypeIn.iterator.collectAll[nodes.ArrayInitializer]

    def _blockViaEvalTypeIn: Iterator[nodes.Block] = node._evalTypeIn.iterator.collectAll[nodes.Block]

    def _callViaEvalTypeIn: Iterator[nodes.Call] = node._evalTypeIn.iterator.collectAll[nodes.Call]

    def _controlStructureViaEvalTypeIn: Iterator[nodes.ControlStructure] = node._evalTypeIn.iterator.collectAll[nodes.ControlStructure]

    def _identifierViaEvalTypeIn: Iterator[nodes.Identifier] = node._evalTypeIn.iterator.collectAll[nodes.Identifier]

    def _literalViaEvalTypeIn: Iterator[nodes.Literal] = node._evalTypeIn.iterator.collectAll[nodes.Literal]

    def _localViaEvalTypeIn: Iterator[nodes.Local] = node._evalTypeIn.iterator.collectAll[nodes.Local]

    def _memberViaEvalTypeIn: Iterator[nodes.Member] = node._evalTypeIn.iterator.collectAll[nodes.Member]

    def _methodParameterInViaEvalTypeIn: Iterator[nodes.MethodParameterIn] = node._evalTypeIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaEvalTypeIn: Iterator[nodes.MethodParameterOut] =
      node._evalTypeIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaEvalTypeIn: Iterator[nodes.MethodRef] = node._evalTypeIn.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaEvalTypeIn: Iterator[nodes.MethodReturn] = node._evalTypeIn.iterator.collectAll[nodes.MethodReturn]

    def _typeArgumentViaAstOut: Iterator[nodes.TypeArgument] = node._astOut.iterator.collectAll[nodes.TypeArgument]

    def _typeArgumentViaRefIn: Iterator[nodes.TypeArgument] = node._refIn.iterator.collectAll[nodes.TypeArgument]

    def _typeDeclViaAliasOfIn: Iterator[nodes.TypeDecl] = node._aliasOfIn.iterator.collectAll[nodes.TypeDecl]

    def _typeDeclViaInheritsFromIn: Iterator[nodes.TypeDecl] = node._inheritsFromIn.iterator.collectAll[nodes.TypeDecl]

    def _typeDeclViaRefOut: Iterator[nodes.TypeDecl] = node._refOut.iterator.collectAll[nodes.TypeDecl]

    def _typeRefViaEvalTypeIn: Iterator[nodes.TypeRef] = node._evalTypeIn.iterator.collectAll[nodes.TypeRef]

    def _unknownViaEvalTypeIn: Iterator[nodes.Unknown] = node._evalTypeIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForTypeArgument(val node: nodes.TypeArgument) extends AnyVal {
    def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = node._bindsToOut.iterator.collectAll[nodes.TypeParameter]

    def _typeViaAstIn: Iterator[nodes.Type] = node._astIn.iterator.collectAll[nodes.Type]

    def _typeViaRefOut: Iterator[nodes.Type] = node._refOut.iterator.collectAll[nodes.Type]
  }

  final class AccessNeighborsForTypeDecl(val node: nodes.TypeDecl) extends AnyVal {
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _bindingViaBindsOut: Iterator[nodes.Binding] = node._bindsOut.iterator.collectAll[nodes.Binding]

    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

    def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    def _namespaceBlockViaAstIn: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

    def _typeViaAliasOfOut: Iterator[nodes.Type] = node._aliasOfOut.iterator.collectAll[nodes.Type]

    def _typeViaInheritsFromOut: Iterator[nodes.Type] = node._inheritsFromOut.iterator.collectAll[nodes.Type]

    def _typeViaRefIn: Iterator[nodes.Type] = node._refIn.iterator.collectAll[nodes.Type]
  }

  final class AccessNeighborsForTypeParameter(val node: nodes.TypeParameter) extends AnyVal {
    // asd

    def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = node._bindsToIn.iterator.collectAll[nodes.TypeArgument]

    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]
  }

  final class AccessNeighborsForTypeRef(val node: nodes.TypeRef) extends AnyVal {
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForUnknown(val node: nodes.Unknown) extends AnyVal {
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForAstNode(val node: nodes.AstNode) extends AnyVal {}

  final class AccessNeighborsForCallRepr(val node: nodes.CallRepr) extends AnyVal {}

  final class AccessNeighborsForCfgNode(val node: nodes.CfgNode) extends AnyVal {
    def _blockViaCfgIn: Iterator[nodes.Block] = node._cfgIn.iterator.collectAll[nodes.Block]

    def _callViaCfgIn: Iterator[nodes.Call] = node._cfgIn.iterator.collectAll[nodes.Call]

    def _controlStructureViaCfgIn: Iterator[nodes.ControlStructure] = node._cfgIn.iterator.collectAll[nodes.ControlStructure]

    def _fieldIdentifierViaCfgIn: Iterator[nodes.FieldIdentifier] = node._cfgIn.iterator.collectAll[nodes.FieldIdentifier]

    def _identifierViaCfgIn: Iterator[nodes.Identifier] = node._cfgIn.iterator.collectAll[nodes.Identifier]

    def _jumpTargetViaCfgIn: Iterator[nodes.JumpTarget] = node._cfgIn.iterator.collectAll[nodes.JumpTarget]

    def _literalViaCfgIn: Iterator[nodes.Literal] = node._cfgIn.iterator.collectAll[nodes.Literal]

    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = node._cfgIn.iterator.collectAll[nodes.MethodRef]

    def _methodViaCfgIn: Iterator[nodes.Method] = node._cfgIn.iterator.collectAll[nodes.Method]

    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = node._cfgIn.iterator.collectAll[nodes.TypeRef]

    def _unknownViaCfgIn: Iterator[nodes.Unknown] = node._cfgIn.iterator.collectAll[nodes.Unknown]
  }

  final class AccessNeighborsForDeclaration(val node: nodes.Declaration) extends AnyVal {}

  final class AccessNeighborsForExpression(val node: nodes.Expression) extends AnyVal {
    def _templateDomViaArgumentOut: Iterator[nodes.TemplateDom] = node._argumentOut.iterator.collectAll[nodes.TemplateDom]

    def _templateDomViaAstIn: Iterator[nodes.TemplateDom] = node._astIn.iterator.collectAll[nodes.TemplateDom]

    def _templateDomViaReachingDefIn: Iterator[nodes.TemplateDom] = node._reachingDefIn.iterator.collectAll[nodes.TemplateDom]
  }

  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */

  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*

}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors.*
//XX2 implicit def access_AnnotationBase(node: nodes.AnnotationBase): Access_AnnotationBase = new Access_AnnotationBase(node)
//XX2 implicit def access_AnnotationLiteralBase(node: nodes.AnnotationLiteralBase): Access_AnnotationLiteralBase = new Access_AnnotationLiteralBase(node)
//XX2 implicit def access_AnnotationParameterBase(node: nodes.AnnotationParameterBase): Access_AnnotationParameterBase = new Access_AnnotationParameterBase(node)
//XX2 implicit def access_AnnotationParameterAssignBase(node: nodes.AnnotationParameterAssignBase): Access_AnnotationParameterAssignBase = new Access_AnnotationParameterAssignBase(node)
//XX2 implicit def access_ArrayInitializerBase(node: nodes.ArrayInitializerBase): Access_ArrayInitializerBase = new Access_ArrayInitializerBase(node)
//XX2 implicit def access_BindingBase(node: nodes.BindingBase): Access_BindingBase = new Access_BindingBase(node)
//XX2 implicit def access_BlockBase(node: nodes.BlockBase): Access_BlockBase = new Access_BlockBase(node)
//XX2 implicit def access_CallBase(node: nodes.CallBase): Access_CallBase = new Access_CallBase(node)
//XX2 implicit def access_ClosureBindingBase(node: nodes.ClosureBindingBase): Access_ClosureBindingBase = new Access_ClosureBindingBase(node)
//XX2 implicit def access_CommentBase(node: nodes.CommentBase): Access_CommentBase = new Access_CommentBase(node)
//XX2 implicit def access_ConfigFileBase(node: nodes.ConfigFileBase): Access_ConfigFileBase = new Access_ConfigFileBase(node)
//XX2 implicit def access_ControlStructureBase(node: nodes.ControlStructureBase): Access_ControlStructureBase = new Access_ControlStructureBase(node)
//XX2 implicit def access_DependencyBase(node: nodes.DependencyBase): Access_DependencyBase = new Access_DependencyBase(node)
//XX2 implicit def access_FieldIdentifierBase(node: nodes.FieldIdentifierBase): Access_FieldIdentifierBase = new Access_FieldIdentifierBase(node)
//XX2 implicit def access_FileBase(node: nodes.FileBase): Access_FileBase = new Access_FileBase(node)
//XX2 implicit def access_FindingBase(node: nodes.FindingBase): Access_FindingBase = new Access_FindingBase(node)
//XX2 implicit def access_IdentifierBase(node: nodes.IdentifierBase): Access_IdentifierBase = new Access_IdentifierBase(node)
//XX2 implicit def access_ImportBase(node: nodes.ImportBase): Access_ImportBase = new Access_ImportBase(node)
//XX2 implicit def access_JumpLabelBase(node: nodes.JumpLabelBase): Access_JumpLabelBase = new Access_JumpLabelBase(node)
//XX2 implicit def access_JumpTargetBase(node: nodes.JumpTargetBase): Access_JumpTargetBase = new Access_JumpTargetBase(node)
//XX2 implicit def access_KeyValuePairBase(node: nodes.KeyValuePairBase): Access_KeyValuePairBase = new Access_KeyValuePairBase(node)
//XX2 implicit def access_LiteralBase(node: nodes.LiteralBase): Access_LiteralBase = new Access_LiteralBase(node)
//XX2 implicit def access_LocalBase(node: nodes.LocalBase): Access_LocalBase = new Access_LocalBase(node)
//XX2 implicit def access_LocationBase(node: nodes.LocationBase): Access_LocationBase = new Access_LocationBase(node)
//XX2 implicit def access_MemberBase(node: nodes.MemberBase): Access_MemberBase = new Access_MemberBase(node)
//XX2 implicit def access_MetaDataBase(node: nodes.MetaDataBase): Access_MetaDataBase = new Access_MetaDataBase(node)
//XX2 implicit def access_MethodBase(node: nodes.MethodBase): Access_MethodBase = new Access_MethodBase(node)
//XX2 implicit def access_MethodParameterInBase(node: nodes.MethodParameterInBase): Access_MethodParameterInBase = new Access_MethodParameterInBase(node)
//XX2 implicit def access_MethodParameterOutBase(node: nodes.MethodParameterOutBase): Access_MethodParameterOutBase = new Access_MethodParameterOutBase(node)
//XX2 implicit def access_MethodRefBase(node: nodes.MethodRefBase): Access_MethodRefBase = new Access_MethodRefBase(node)
//XX2 implicit def access_MethodReturnBase(node: nodes.MethodReturnBase): Access_MethodReturnBase = new Access_MethodReturnBase(node)
//XX2 implicit def access_ModifierBase(node: nodes.ModifierBase): Access_ModifierBase = new Access_ModifierBase(node)
//XX2 implicit def access_NamespaceBase(node: nodes.NamespaceBase): Access_NamespaceBase = new Access_NamespaceBase(node)
//XX2 implicit def access_NamespaceBlockBase(node: nodes.NamespaceBlockBase): Access_NamespaceBlockBase = new Access_NamespaceBlockBase(node)
//XX2 implicit def access_ReturnBase(node: nodes.ReturnBase): Access_ReturnBase = new Access_ReturnBase(node)
//XX2 implicit def access_TagBase(node: nodes.TagBase): Access_TagBase = new Access_TagBase(node)
//XX2 implicit def access_TagNodePairBase(node: nodes.TagNodePairBase): Access_TagNodePairBase = new Access_TagNodePairBase(node)
//XX2 implicit def access_TemplateDomBase(node: nodes.TemplateDomBase): Access_TemplateDomBase = new Access_TemplateDomBase(node)
//XX2 implicit def access_TypeBase(node: nodes.TypeBase): Access_TypeBase = new Access_TypeBase(node)
//XX2 implicit def access_TypeArgumentBase(node: nodes.TypeArgumentBase): Access_TypeArgumentBase = new Access_TypeArgumentBase(node)
//XX2 implicit def access_TypeDeclBase(node: nodes.TypeDeclBase): Access_TypeDeclBase = new Access_TypeDeclBase(node)
//XX2 implicit def access_TypeParameterBase(node: nodes.TypeParameterBase): Access_TypeParameterBase = new Access_TypeParameterBase(node)
//XX2 implicit def access_TypeRefBase(node: nodes.TypeRefBase): Access_TypeRefBase = new Access_TypeRefBase(node)
//XX2 implicit def access_UnknownBase(node: nodes.UnknownBase): Access_UnknownBase = new Access_UnknownBase(node)
}

trait AbstractBaseConversions0 {
  import Accessors.*
//XX2 implicit def access_AstNodeBase(node: nodes.AstNodeBase): Access_AstNodeBase = new Access_AstNodeBase(node)
//XX2 implicit def access_CallReprBase(node: nodes.CallReprBase): Access_CallReprBase = new Access_CallReprBase(node)
//XX2 implicit def access_CfgNodeBase(node: nodes.CfgNodeBase): Access_CfgNodeBase = new Access_CfgNodeBase(node)
//XX2 implicit def access_DeclarationBase(node: nodes.DeclarationBase): Access_DeclarationBase = new Access_DeclarationBase(node)
//XX2 implicit def access_ExpressionBase(node: nodes.ExpressionBase): Access_ExpressionBase = new Access_ExpressionBase(node)
}
