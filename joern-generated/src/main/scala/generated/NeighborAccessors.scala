package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors
import io.joern.odb2
import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes

// object Lang extends ConcreteStoredConversions

object Accessors {
  // import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*

  /* accessors for concrete stored nodes start */
  final class AccessNeighborsForAnnotation(val node: nodes.Annotation) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
      */
    def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
      node._astOut.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to IDENTIFIER via AST IN edge.
      */
    def _identifierViaAstIn: Iterator[nodes.Identifier] = node._astIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via AST IN edge.
      */
    def _literalViaAstIn: Iterator[nodes.Literal] = node._astIn.iterator.collectAll[nodes.Literal]

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via AST IN edge.
      */
    def _methodRefViaAstIn: Iterator[nodes.MethodRef] = node._astIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForAnnotationLiteral(val node: nodes.AnnotationLiteral) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  }

  final class AccessNeighborsForAnnotationParameter(val node: nodes.AnnotationParameter) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  }

  final class AccessNeighborsForAnnotationParameterAssign(val node: nodes.AnnotationParameterAssign) extends AnyVal {

    /** Traverse to ANNOTATION via AST IN edge.
      */
    def _annotationViaAstIn: Iterator[nodes.Annotation] = node._astIn.iterator.collectAll[nodes.Annotation]

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to ANNOTATION_LITERAL via AST OUT edge.
      */
    def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = node._astOut.iterator.collectAll[nodes.AnnotationLiteral]

    /** Traverse to ANNOTATION_PARAMETER via AST OUT edge.
      */
    def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = node._astOut.iterator.collectAll[nodes.AnnotationParameter]

    /** Traverse to ARRAY_INITIALIZER via AST OUT edge.
      */
    def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = node._astOut.iterator.collectAll[nodes.ArrayInitializer]

  }

  final class AccessNeighborsForArrayInitializer(val node: nodes.ArrayInitializer) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForBinding(val node: nodes.Binding) extends AnyVal {

    /** Traverse to METHOD via REF OUT edge.
      */
    def _methodViaRefOut: nodes.Method = {
      try { node._refOut.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this BINDING node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via REF OUT edge.
      */
    def boundMethod: nodes.Method = {
      try { node._refOut.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this BINDING node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_DECL via BINDS IN edge.
      */
    def _typeDeclViaBindsIn: nodes.TypeDecl = {
      try { node._bindsIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label BINDS to an adjacent TYPE_DECL is mandatory, but not defined for this BINDING node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_DECL via BINDS IN edge.
      */
    def bindingTypeDecl: nodes.TypeDecl = {
      try { node._bindsIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label BINDS to an adjacent TYPE_DECL is mandatory, but not defined for this BINDING node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForBlock(val node: nodes.Block) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: nodes.Block = {
      try { node._astIn.iterator.collectAll[nodes.Block].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent BLOCK is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF OUT edge.
      */
    def _blockViaReachingDefOut: Iterator[nodes.Block] = node._reachingDefOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IMPORT via AST OUT edge.
      */
    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
      */
    def local: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

  }

  final class AccessNeighborsForCall(val node: nodes.Call) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Iterator[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via RECEIVER OUT edge.
      */
    def _blockViaReceiverOut: Option[nodes.Block] = node._receiverOut.iterator.collectAll[nodes.Block].nextOption()

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Iterator[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via RECEIVER OUT edge.
      */
    def _callViaReceiverOut: Option[nodes.Call] = node._receiverOut.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this CALL node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via RECEIVER OUT edge.
      */
    def _controlStructureViaReceiverOut: Iterator[nodes.ControlStructure] = node._receiverOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via ARGUMENT OUT edge.
      */
    def _fieldIdentifierViaArgumentOut: Iterator[nodes.FieldIdentifier] = node._argumentOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CFG IN edge.
      */
    def _fieldIdentifierViaCfgIn: Option[nodes.FieldIdentifier] = node._cfgIn.iterator.collectAll[nodes.FieldIdentifier].nextOption()

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Iterator[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via RECEIVER OUT edge.
      */
    def _identifierViaReceiverOut: Option[nodes.Identifier] = node._receiverOut.iterator.collectAll[nodes.Identifier].nextOption()

    /** Traverse to IMPORT via IS_CALL_FOR_IMPORT OUT edge.
      */
    def _importViaIsCallForImportOut: Iterator[nodes.Import] = node._isCallForImportOut.iterator.collectAll[nodes.Import]

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Iterator[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via RECEIVER OUT edge.
      */
    def _literalViaReceiverOut: Option[nodes.Literal] = node._receiverOut.iterator.collectAll[nodes.Literal].nextOption()

    /** Traverse to METHOD via CALL OUT edge.
      */
    def _methodViaCallOut: Iterator[nodes.Method] = node._callOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Iterator[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via RECEIVER OUT edge.
      */
    def _methodRefViaReceiverOut: Option[nodes.MethodRef] = node._receiverOut.iterator.collectAll[nodes.MethodRef].nextOption()

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via RECEIVER OUT edge.
      */
    def _typeRefViaReceiverOut: Iterator[nodes.TypeRef] = node._receiverOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via RECEIVER OUT edge.
      */
    def _unknownViaReceiverOut: Iterator[nodes.Unknown] = node._receiverOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to referenced members Traverse to MEMBER via REF OUT edge.
      */
    def _memberViaRefOut: Iterator[nodes.Member] = node._refOut.iterator.collectAll[nodes.Member]

    /** Traverse to referenced members Traverse to MEMBER via REF OUT edge.
      */
    def referencedMember: Iterator[nodes.Member] = node._refOut.iterator.collectAll[nodes.Member]

  }

  final class AccessNeighborsForClosureBinding(val node: nodes.ClosureBinding) extends AnyVal {

    /** Traverse to LOCAL via CAPTURED_BY IN edge.
      */
    def _localViaCapturedByIn: Iterator[nodes.Local] = node._capturedByIn.iterator.collectAll[nodes.Local]

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: nodes.Local = {
      try { node._refOut.iterator.collectAll[nodes.Local].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent LOCAL is mandatory, but not defined for this CLOSURE_BINDING node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = node._refOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via CAPTURE IN edge.
      */
    def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = node._captureIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_REF via CAPTURE IN edge.
      */
    def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = node._captureIn.iterator.collectAll[nodes.TypeRef]

  }

  final class AccessNeighborsForComment(val node: nodes.Comment) extends AnyVal {

    /** Traverse to COMMENT via SOURCE_FILE IN edge.
      */
    def _commentViaSourceFileIn: Iterator[nodes.Comment] = node._sourceFileIn.iterator.collectAll[nodes.Comment]

    /** Traverse to COMMENT via SOURCE_FILE OUT edge.
      */
    def _commentViaSourceFileOut: Iterator[nodes.Comment] = node._sourceFileOut.iterator.collectAll[nodes.Comment]

    /** Traverse to COMMENT via SOURCE_FILE OUT edge.
      */
    def file: Iterator[nodes.Comment] = node._sourceFileOut.iterator.collectAll[nodes.Comment]

    /** Traverse to FILE via AST IN edge.
      */
    def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

  }

  final class AccessNeighborsForConfigFile(val node: nodes.ConfigFile) extends AnyVal {}

  final class AccessNeighborsForControlStructure(val node: nodes.ControlStructure) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CONDITION OUT edge.
      */
    def _blockViaConditionOut: Iterator[nodes.Block] = node._conditionOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CONDITION OUT edge.
      */
    def _callViaConditionOut: Iterator[nodes.Call] = node._conditionOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION OUT edge.
      */
    def _controlStructureViaConditionOut: Iterator[nodes.ControlStructure] = node._conditionOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CONDITION OUT edge.
      */
    def _identifierViaConditionOut: Iterator[nodes.Identifier] = node._conditionOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_LABEL via AST OUT edge.
      */
    def _jumpLabelViaAstOut: Iterator[nodes.JumpLabel] = node._astOut.iterator.collectAll[nodes.JumpLabel]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CONDITION OUT edge.
      */
    def _jumpTargetViaConditionOut: Iterator[nodes.JumpTarget] = node._conditionOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CONDITION OUT edge.
      */
    def _literalViaConditionOut: Iterator[nodes.Literal] = node._conditionOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CONDITION OUT edge.
      */
    def _methodRefViaConditionOut: Iterator[nodes.MethodRef] = node._conditionOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CONDITION OUT edge.
      */
    def _returnViaConditionOut: Iterator[nodes.Return] = node._conditionOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CONDITION OUT edge.
      */
    def _typeRefViaConditionOut: Iterator[nodes.TypeRef] = node._conditionOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CONDITION OUT edge.
      */
    def _unknownViaConditionOut: Iterator[nodes.Unknown] = node._conditionOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForDependency(val node: nodes.Dependency) extends AnyVal {

    /** Traverse to IMPORT via IMPORTS IN edge.
      */
    def _importViaImportsIn: Iterator[nodes.Import] = node._importsIn.iterator.collectAll[nodes.Import]

  }

  final class AccessNeighborsForFieldIdentifier(val node: nodes.FieldIdentifier) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: nodes.Call = {
      try { node._argumentIn.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label ARGUMENT to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: nodes.Call = {
      try { node._astIn.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CFG OUT edge.
      */
    def _callViaCfgOut: nodes.Call = {
      try { node._cfgOut.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label CFG to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForFile(val node: nodes.File) extends AnyVal {

    /** Traverse to COMMENT via AST OUT edge.
      */
    def _commentViaAstOut: Iterator[nodes.Comment] = node._astOut.iterator.collectAll[nodes.Comment]

    /** Traverse to COMMENT via AST OUT edge.
      */
    def comment: Iterator[nodes.Comment] = node._astOut.iterator.collectAll[nodes.Comment]

    /** Traverse to IMPORT via AST OUT edge.
      */
    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    /** Traverse to METHOD via CONTAINS OUT edge.
      */
    def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via SOURCE_FILE IN edge.
      */
    def _methodViaSourceFileIn: Iterator[nodes.Method] = node._sourceFileIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via SOURCE_FILE IN edge.
      */
    def method: Iterator[nodes.Method] = node._sourceFileIn.iterator.collectAll[nodes.Method]

    /** Traverse to NAMESPACE_BLOCK via AST OUT edge.
      */
    def _namespaceBlockViaAstOut: Iterator[nodes.NamespaceBlock] = node._astOut.iterator.collectAll[nodes.NamespaceBlock]

    /** Traverse to NAMESPACE_BLOCK via SOURCE_FILE IN edge.
      */
    def _namespaceBlockViaSourceFileIn: Iterator[nodes.NamespaceBlock] = node._sourceFileIn.iterator.collectAll[nodes.NamespaceBlock]

    /** Traverse to NAMESPACE_BLOCK via SOURCE_FILE IN edge.
      */
    def namespaceBlock: Iterator[nodes.NamespaceBlock] = node._sourceFileIn.iterator.collectAll[nodes.NamespaceBlock]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
      */
    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TYPE_DECL via CONTAINS OUT edge.
      */
    def _typeDeclViaContainsOut: Iterator[nodes.TypeDecl] = node._containsOut.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_DECL via SOURCE_FILE IN edge.
      */
    def _typeDeclViaSourceFileIn: Iterator[nodes.TypeDecl] = node._sourceFileIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_DECL via SOURCE_FILE IN edge.
      */
    def typeDecl: Iterator[nodes.TypeDecl] = node._sourceFileIn.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForFinding(val node: nodes.Finding) extends AnyVal {}

  final class AccessNeighborsForIdentifier(val node: nodes.Identifier) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: Option[nodes.Local] = node._refOut.iterator.collectAll[nodes.Local].nextOption()

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Option[nodes.MethodParameterIn] =
      node._refOut.iterator.collectAll[nodes.MethodParameterIn].nextOption()

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForImport(val node: nodes.Import) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via IS_CALL_FOR_IMPORT IN edge.
      */
    def _callViaIsCallForImportIn: Iterator[nodes.Call] = node._isCallForImportIn.iterator.collectAll[nodes.Call]

    /** Traverse to DEPENDENCY via IMPORTS OUT edge.
      */
    def _dependencyViaImportsOut: Iterator[nodes.Dependency] = node._importsOut.iterator.collectAll[nodes.Dependency]

    /** Traverse to FILE via AST IN edge.
      */
    def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForJumpLabel(val node: nodes.JumpLabel) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

  }

  final class AccessNeighborsForJumpTarget(val node: nodes.JumpTarget) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForKeyValuePair(val node: nodes.KeyValuePair) extends AnyVal {}

  final class AccessNeighborsForLiteral(val node: nodes.Literal) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to ARRAY_INITIALIZER via AST IN edge.
      */
    def _arrayInitializerViaAstIn: Iterator[nodes.ArrayInitializer] = node._astIn.iterator.collectAll[nodes.ArrayInitializer]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this LITERAL node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForLocal(val node: nodes.Local) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to CLOSURE_BINDING via CAPTURED_BY OUT edge.
      */
    def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = node._capturedByOut.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CLOSURE_BINDING via REF IN edge.
      */
    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Places (identifier) where this local is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def _identifierViaRefIn: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    /** Places (identifier) where this local is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def referencingIdentifiers: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    /** The block in which local is declared. Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** The block in which local is declared. Traverse to BLOCK via AST IN edge.
      */
    def definingBlock: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** The type of the local. Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** The type of the local. Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForLocation(val node: nodes.Location) extends AnyVal {}

  final class AccessNeighborsForMember(val node: nodes.Member) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to CALL via REF IN edge.
      */
    def _callViaRefIn: Iterator[nodes.Call] = node._refIn.iterator.collectAll[nodes.Call]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: nodes.TypeDecl = {
      try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MEMBER node with seq=" + node.seq,
            e
          )
      }
    }

    /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
      */
    def typeDecl: nodes.TypeDecl = {
      try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MEMBER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForMetaData(val node: nodes.MetaData) extends AnyVal {}

  final class AccessNeighborsForMethod(val node: nodes.Method) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BINDING via REF IN edge.
      */
    def _bindingViaRefIn: Iterator[nodes.Binding] = node._refIn.iterator.collectAll[nodes.Binding]

    /** Traverse to BLOCK via CONTAINS OUT edge.
      */
    def _blockViaContainsOut: Iterator[nodes.Block] = node._containsOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CALL IN edge.
      */
    def _callViaCallIn: Iterator[nodes.Call] = node._callIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CONTAINS OUT edge.
      */
    def _callViaContainsOut: Iterator[nodes.Call] = node._containsOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CONTAINS OUT edge.
      */
    def _controlStructureViaContainsOut: Iterator[nodes.ControlStructure] = node._containsOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CONTAINS OUT edge.
      */
    def _fieldIdentifierViaContainsOut: Iterator[nodes.FieldIdentifier] = node._containsOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    /** Traverse to FILE via SOURCE_FILE OUT edge.
      */
    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    /** Traverse to IDENTIFIER via CONTAINS OUT edge.
      */
    def _identifierViaContainsOut: Iterator[nodes.Identifier] = node._containsOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CONTAINS OUT edge.
      */
    def _jumpTargetViaContainsOut: Iterator[nodes.JumpTarget] = node._containsOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

    /** Traverse to METHOD via AST OUT edge.
      */
    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF OUT edge.
      */
    def _methodParameterInViaReachingDefOut: Iterator[nodes.MethodParameterIn] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via AST OUT edge.
      */
    def _methodParameterOutViaAstOut: Iterator[nodes.MethodParameterOut] = node._astOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CONTAINS OUT edge.
      */
    def _methodRefViaContainsOut: Iterator[nodes.MethodRef] = node._containsOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REF IN edge.
      */
    def _methodRefViaRefIn: Iterator[nodes.MethodRef] = node._refIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Option[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn].nextOption()

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to NAMESPACE_BLOCK via AST IN edge.
      */
    def _namespaceBlockViaAstIn: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    /** Traverse to RETURN via CONTAINS OUT edge.
      */
    def _returnViaContainsOut: Iterator[nodes.Return] = node._containsOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
      */
    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

    /** Traverse to TYPE_DECL via AST OUT edge.
      */
    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_DECL via CONTAINS IN edge.
      */
    def _typeDeclViaContainsIn: Iterator[nodes.TypeDecl] = node._containsIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_PARAMETER via AST OUT edge.
      */
    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

    /** Traverse to TYPE_REF via CONTAINS OUT edge.
      */
    def _typeRefViaContainsOut: Iterator[nodes.TypeRef] = node._containsOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CONTAINS OUT edge.
      */
    def _unknownViaContainsOut: Iterator[nodes.Unknown] = node._containsOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** First control flow graph node Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** First control flow graph node Traverse to CFG_NODE via CFG OUT edge.
      */
    def cfgFirst: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Formal return parameters Traverse to METHOD_RETURN via AST OUT edge.
      */
    def _methodReturnViaAstOut: nodes.MethodReturn = {
      try { node._astOut.iterator.collectAll[nodes.MethodReturn].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent METHOD_RETURN is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

    /** Formal return parameters Traverse to METHOD_RETURN via AST OUT edge.
      */
    def methodReturn: nodes.MethodReturn = {
      try { node._astOut.iterator.collectAll[nodes.MethodReturn].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent METHOD_RETURN is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

    /** Literals used in the method Traverse to LITERAL via CONTAINS OUT edge.
      */
    def _literalViaContainsOut: Iterator[nodes.Literal] = node._containsOut.iterator.collectAll[nodes.Literal]

    /** Literals used in the method Traverse to LITERAL via CONTAINS OUT edge.
      */
    def literal: Iterator[nodes.Literal] = node._containsOut.iterator.collectAll[nodes.Literal]

    /** Parameters of the method Traverse to METHOD_PARAMETER_IN via AST OUT edge.
      */
    def _methodParameterInViaAstOut: Iterator[nodes.MethodParameterIn] = node._astOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Parameters of the method Traverse to METHOD_PARAMETER_IN via AST OUT edge.
      */
    def parameter: Iterator[nodes.MethodParameterIn] = node._astOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Root of the abstract syntax tree Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: nodes.Block = {
      try { node._astOut.iterator.collectAll[nodes.Block].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent BLOCK is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

    /** Root of the abstract syntax tree Traverse to BLOCK via AST OUT edge.
      */
    def block: nodes.Block = {
      try { node._astOut.iterator.collectAll[nodes.Block].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent BLOCK is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodParameterIn(val node: nodes.MethodParameterIn) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CLOSURE_BINDING via REF IN edge.
      */
    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Places (identifier) where this parameter is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def _identifierViaRefIn: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    /** Places (identifier) where this parameter is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def referencingIdentifiers: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
      */
    def _methodParameterOutViaParameterLinkOut: Iterator[nodes.MethodParameterOut] =
      node._parameterLinkOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
      */
    def asOutput: Iterator[nodes.MethodParameterOut] = node._parameterLinkOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to method associated with this formal parameter Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to method associated with this formal parameter Traverse to METHOD via AST IN edge.
      */
    def method: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: nodes.Type = {
      try { node._evalTypeOut.iterator.collectAll[nodes.Type].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label EVAL_TYPE to an adjacent TYPE is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: nodes.Type = {
      try { node._evalTypeOut.iterator.collectAll[nodes.Type].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label EVAL_TYPE to an adjacent TYPE is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodParameterOut(val node: nodes.MethodParameterOut) extends AnyVal {

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_OUT node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via AST IN edge.
      */
    def method: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_OUT node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
      */
    def _methodParameterInViaParameterLinkIn: Iterator[nodes.MethodParameterIn] =
      node._parameterLinkIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
      */
    def asInput: Iterator[nodes.MethodParameterIn] = node._parameterLinkIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForMethodRef(val node: nodes.MethodRef) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this METHOD_REF node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to referenced method. Traverse to METHOD via REF OUT edge.
      */
    def _methodViaRefOut: nodes.Method = {
      try { node._refOut.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this METHOD_REF node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to referenced method. Traverse to METHOD via REF OUT edge.
      */
    def referencedMethod: nodes.Method = {
      try { node._refOut.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this METHOD_REF node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodReturn(val node: nodes.MethodReturn) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_RETURN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via CFG IN edge.
      */
    def _methodViaCfgIn: Option[nodes.Method] = node._cfgIn.iterator.collectAll[nodes.Method].nextOption()

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CFG IN edge.
      */
    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = node._cfgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via CFG IN edge.
      */
    def _returnViaCfgIn: Iterator[nodes.Return] = node._cfgIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CFG IN edge.
      */
    def toReturn: Iterator[nodes.Return] = node._cfgIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CFG IN edge.
      */
    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = node._cfgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForModifier(val node: nodes.Modifier) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: nodes.TypeDecl = {
      try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForNamespace(val node: nodes.Namespace) extends AnyVal {

    /** Traverse to NAMESPACE_BLOCK via REF IN edge.
      */
    def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = node._refIn.iterator.collectAll[nodes.NamespaceBlock]

  }

  final class AccessNeighborsForNamespaceBlock(val node: nodes.NamespaceBlock) extends AnyVal {

    /** Traverse to FILE via AST IN edge.
      */
    def _fileViaAstIn: Option[nodes.File] = node._astIn.iterator.collectAll[nodes.File].nextOption()

    /** Traverse to FILE via SOURCE_FILE OUT edge.
      */
    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    /** Traverse to METHOD via AST OUT edge.
      */
    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    /** Traverse to NAMESPACE via REF OUT edge.
      */
    def _namespaceViaRefOut: Iterator[nodes.Namespace] = node._refOut.iterator.collectAll[nodes.Namespace]

    /** Traverse to TYPE_DECL via AST OUT edge.
      */
    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForReturn(val node: nodes.Return) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Option[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block].nextOption()

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Option[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Option[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier].nextOption()

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Option[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal].nextOption()

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Option[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef].nextOption()

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: nodes.MethodReturn = {
      try { node._cfgOut.iterator.collectAll[nodes.MethodReturn].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label CFG to an adjacent METHOD_RETURN is mandatory, but not defined for this RETURN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via REACHING_DEF OUT edge.
      */
    def _methodReturnViaReachingDefOut: Iterator[nodes.MethodReturn] = node._reachingDefOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via ARGUMENT OUT edge.
      */
    def _returnViaArgumentOut: Option[nodes.Return] = node._argumentOut.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForTag(val node: nodes.Tag) extends AnyVal {

    /** Traverse to BLOCK via TAGGED_BY IN edge.
      */
    def _blockViaTaggedByIn: Iterator[nodes.Block] = node._taggedByIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via TAGGED_BY IN edge.
      */
    def _callViaTaggedByIn: Iterator[nodes.Call] = node._taggedByIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via TAGGED_BY IN edge.
      */
    def _controlStructureViaTaggedByIn: Iterator[nodes.ControlStructure] = node._taggedByIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via TAGGED_BY IN edge.
      */
    def _fieldIdentifierViaTaggedByIn: Iterator[nodes.FieldIdentifier] = node._taggedByIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FILE via TAGGED_BY IN edge.
      */
    def _fileViaTaggedByIn: Iterator[nodes.File] = node._taggedByIn.iterator.collectAll[nodes.File]

    /** Traverse to IDENTIFIER via TAGGED_BY IN edge.
      */
    def _identifierViaTaggedByIn: Iterator[nodes.Identifier] = node._taggedByIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IMPORT via TAGGED_BY IN edge.
      */
    def _importViaTaggedByIn: Iterator[nodes.Import] = node._taggedByIn.iterator.collectAll[nodes.Import]

    /** Traverse to JUMP_TARGET via TAGGED_BY IN edge.
      */
    def _jumpTargetViaTaggedByIn: Iterator[nodes.JumpTarget] = node._taggedByIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via TAGGED_BY IN edge.
      */
    def _literalViaTaggedByIn: Iterator[nodes.Literal] = node._taggedByIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via TAGGED_BY IN edge.
      */
    def _localViaTaggedByIn: Iterator[nodes.Local] = node._taggedByIn.iterator.collectAll[nodes.Local]

    /** Traverse to MEMBER via TAGGED_BY IN edge.
      */
    def _memberViaTaggedByIn: Iterator[nodes.Member] = node._taggedByIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via TAGGED_BY IN edge.
      */
    def _methodViaTaggedByIn: Iterator[nodes.Method] = node._taggedByIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via TAGGED_BY IN edge.
      */
    def _methodParameterInViaTaggedByIn: Iterator[nodes.MethodParameterIn] = node._taggedByIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via TAGGED_BY IN edge.
      */
    def _methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] =
      node._taggedByIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via TAGGED_BY IN edge.
      */
    def _methodRefViaTaggedByIn: Iterator[nodes.MethodRef] = node._taggedByIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via TAGGED_BY IN edge.
      */
    def _methodReturnViaTaggedByIn: Iterator[nodes.MethodReturn] = node._taggedByIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via TAGGED_BY IN edge.
      */
    def _returnViaTaggedByIn: Iterator[nodes.Return] = node._taggedByIn.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY IN edge.
      */
    def _tagViaTaggedByIn: Iterator[nodes.Tag] = node._taggedByIn.iterator.collectAll[nodes.Tag]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TEMPLATE_DOM via TAGGED_BY IN edge.
      */
    def _templateDomViaTaggedByIn: Iterator[nodes.TemplateDom] = node._taggedByIn.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TYPE_REF via TAGGED_BY IN edge.
      */
    def _typeRefViaTaggedByIn: Iterator[nodes.TypeRef] = node._taggedByIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via TAGGED_BY IN edge.
      */
    def _unknownViaTaggedByIn: Iterator[nodes.Unknown] = node._taggedByIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForTagNodePair(val node: nodes.TagNodePair) extends AnyVal {}

  final class AccessNeighborsForTemplateDom(val node: nodes.TemplateDom) extends AnyVal {

    /** Traverse to EXPRESSION via ARGUMENT IN edge.
      */
    def _expressionViaArgumentIn: Iterator[nodes.Expression] = node._argumentIn.iterator.collectAll[nodes.Expression]

    /** Traverse to EXPRESSION via AST OUT edge.
      */
    def _expressionViaAstOut: Iterator[nodes.Expression] = node._astOut.iterator.collectAll[nodes.Expression]

    /** Traverse to EXPRESSION via REACHING_DEF OUT edge.
      */
    def _expressionViaReachingDefOut: Iterator[nodes.Expression] = node._reachingDefOut.iterator.collectAll[nodes.Expression]

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  }

  final class AccessNeighborsForType(val node: nodes.Type) extends AnyVal {

    /** Traverse to ARRAY_INITIALIZER via EVAL_TYPE IN edge.
      */
    def _arrayInitializerViaEvalTypeIn: Iterator[nodes.ArrayInitializer] = node._evalTypeIn.iterator.collectAll[nodes.ArrayInitializer]

    /** Traverse to BLOCK via EVAL_TYPE IN edge.
      */
    def _blockViaEvalTypeIn: Iterator[nodes.Block] = node._evalTypeIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via EVAL_TYPE IN edge.
      */
    def _callViaEvalTypeIn: Iterator[nodes.Call] = node._evalTypeIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via EVAL_TYPE IN edge.
      */
    def _controlStructureViaEvalTypeIn: Iterator[nodes.ControlStructure] = node._evalTypeIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to IDENTIFIER via EVAL_TYPE IN edge.
      */
    def _identifierViaEvalTypeIn: Iterator[nodes.Identifier] = node._evalTypeIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via EVAL_TYPE IN edge.
      */
    def _literalViaEvalTypeIn: Iterator[nodes.Literal] = node._evalTypeIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via EVAL_TYPE IN edge.
      */
    def _localViaEvalTypeIn: Iterator[nodes.Local] = node._evalTypeIn.iterator.collectAll[nodes.Local]

    /** Traverse to MEMBER via EVAL_TYPE IN edge.
      */
    def _memberViaEvalTypeIn: Iterator[nodes.Member] = node._evalTypeIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD_PARAMETER_IN via EVAL_TYPE IN edge.
      */
    def _methodParameterInViaEvalTypeIn: Iterator[nodes.MethodParameterIn] = node._evalTypeIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via EVAL_TYPE IN edge.
      */
    def _methodParameterOutViaEvalTypeIn: Iterator[nodes.MethodParameterOut] =
      node._evalTypeIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via EVAL_TYPE IN edge.
      */
    def _methodRefViaEvalTypeIn: Iterator[nodes.MethodRef] = node._evalTypeIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via EVAL_TYPE IN edge.
      */
    def _methodReturnViaEvalTypeIn: Iterator[nodes.MethodReturn] = node._evalTypeIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to TYPE_ARGUMENT via AST OUT edge.
      */
    def _typeArgumentViaAstOut: Iterator[nodes.TypeArgument] = node._astOut.iterator.collectAll[nodes.TypeArgument]

    /** Traverse to TYPE_ARGUMENT via REF IN edge.
      */
    def _typeArgumentViaRefIn: Iterator[nodes.TypeArgument] = node._refIn.iterator.collectAll[nodes.TypeArgument]

    /** Traverse to TYPE_DECL via INHERITS_FROM IN edge.
      */
    def _typeDeclViaInheritsFromIn: Iterator[nodes.TypeDecl] = node._inheritsFromIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_REF via EVAL_TYPE IN edge.
      */
    def _typeRefViaEvalTypeIn: Iterator[nodes.TypeRef] = node._evalTypeIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via EVAL_TYPE IN edge.
      */
    def _unknownViaEvalTypeIn: Iterator[nodes.Unknown] = node._evalTypeIn.iterator.collectAll[nodes.Unknown]

    /** Direct alias type declarations. Traverse to TYPE_DECL via ALIAS_OF IN edge.
      */
    def _typeDeclViaAliasOfIn: Iterator[nodes.TypeDecl] = node._aliasOfIn.iterator.collectAll[nodes.TypeDecl]

    /** Direct alias type declarations. Traverse to TYPE_DECL via ALIAS_OF IN edge.
      */
    def aliasTypeDecl: Iterator[nodes.TypeDecl] = node._aliasOfIn.iterator.collectAll[nodes.TypeDecl]

    /** Type declaration which is referenced by this type. Traverse to TYPE_DECL via REF OUT edge.
      */
    def _typeDeclViaRefOut: Iterator[nodes.TypeDecl] = node._refOut.iterator.collectAll[nodes.TypeDecl]

    /** Type declaration which is referenced by this type. Traverse to TYPE_DECL via REF OUT edge.
      */
    def referencedTypeDecl: Iterator[nodes.TypeDecl] = node._refOut.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForTypeArgument(val node: nodes.TypeArgument) extends AnyVal {

    /** Traverse to TYPE via AST IN edge.
      */
    def _typeViaAstIn: Iterator[nodes.Type] = node._astIn.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE via REF OUT edge.
      */
    def _typeViaRefOut: Iterator[nodes.Type] = node._refOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
      */
    def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = node._bindsToOut.iterator.collectAll[nodes.TypeParameter]

  }

  final class AccessNeighborsForTypeDecl(val node: nodes.TypeDecl) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BINDING via BINDS OUT edge.
      */
    def _bindingViaBindsOut: Iterator[nodes.Binding] = node._bindsOut.iterator.collectAll[nodes.Binding]

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    /** Traverse to FILE via SOURCE_FILE OUT edge.
      */
    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    /** Traverse to IMPORT via AST OUT edge.
      */
    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    /** Traverse to MEMBER via AST OUT edge.
      */
    def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

    /** Traverse to METHOD via AST OUT edge.
      */
    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via CONTAINS OUT edge.
      */
    def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to NAMESPACE_BLOCK via AST IN edge.
      */
    def _namespaceBlockViaAstIn: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    /** Traverse to NAMESPACE_BLOCK via AST IN edge.
      */
    def namespaceBlock: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    /** Traverse to TYPE via ALIAS_OF OUT edge.
      */
    def _typeViaAliasOfOut: Iterator[nodes.Type] = node._aliasOfOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE via ALIAS_OF OUT edge.
      */
    def aliasedType: Iterator[nodes.Type] = node._aliasOfOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE via INHERITS_FROM OUT edge.
      */
    def _typeViaInheritsFromOut: Iterator[nodes.Type] = node._inheritsFromOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE via REF IN edge.
      */
    def _typeViaRefIn: Iterator[nodes.Type] = node._refIn.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

    /** Traverse to TYPE_DECL via AST OUT edge.
      */
    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_PARAMETER via AST OUT edge.
      */
    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

  }

  final class AccessNeighborsForTypeParameter(val node: nodes.TypeParameter) extends AnyVal {

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this TYPE_PARAMETER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_ARGUMENT via BINDS_TO IN edge.
      */
    def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = node._bindsToIn.iterator.collectAll[nodes.TypeArgument]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForTypeRef(val node: nodes.TypeRef) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForUnknown(val node: nodes.Unknown) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to MEMBER via AST OUT edge.
      */
    def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForAstNode(val node: nodes.AstNode) extends AnyVal {}

  final class AccessNeighborsForCallRepr(val node: nodes.CallRepr) extends AnyVal {}

  final class AccessNeighborsForCfgNode(val node: nodes.CfgNode) extends AnyVal {

    /** Traverse to BLOCK via CFG IN edge.
      */
    def _blockViaCfgIn: Iterator[nodes.Block] = node._cfgIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CFG IN edge.
      */
    def _callViaCfgIn: Iterator[nodes.Call] = node._cfgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CFG IN edge.
      */
    def _controlStructureViaCfgIn: Iterator[nodes.ControlStructure] = node._cfgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CFG IN edge.
      */
    def _fieldIdentifierViaCfgIn: Iterator[nodes.FieldIdentifier] = node._cfgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CFG IN edge.
      */
    def _identifierViaCfgIn: Iterator[nodes.Identifier] = node._cfgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CFG IN edge.
      */
    def _jumpTargetViaCfgIn: Iterator[nodes.JumpTarget] = node._cfgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CFG IN edge.
      */
    def _literalViaCfgIn: Iterator[nodes.Literal] = node._cfgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CFG IN edge.
      */
    def _methodViaCfgIn: Iterator[nodes.Method] = node._cfgIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CFG IN edge.
      */
    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = node._cfgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_REF via CFG IN edge.
      */
    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = node._cfgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CFG IN edge.
      */
    def _unknownViaCfgIn: Iterator[nodes.Unknown] = node._cfgIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForDeclaration(val node: nodes.Declaration) extends AnyVal {}

  final class AccessNeighborsForExpression(val node: nodes.Expression) extends AnyVal {

    /** Traverse to TEMPLATE_DOM via ARGUMENT OUT edge.
      */
    def _templateDomViaArgumentOut: Iterator[nodes.TemplateDom] = node._argumentOut.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TEMPLATE_DOM via AST IN edge.
      */
    def _templateDomViaAstIn: Iterator[nodes.TemplateDom] = node._astIn.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TEMPLATE_DOM via REACHING_DEF IN edge.
      */
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
