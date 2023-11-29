package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForBlock(val node: nodes.Block) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def blockViaAstIn: nodes.Block = {
    try { astIn.collectAll[nodes.Block].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "IN edge with label AST to an adjacent BLOCK is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to BLOCK via AST OUT edge.
    */
  def blockViaAstOut: Iterator[nodes.Block] = astOut.collectAll[nodes.Block]

  /** Traverse to BLOCK via CDG IN edge.
    */
  def blockViaCdgIn: Iterator[nodes.Block] = cdgIn.collectAll[nodes.Block]

  /** Traverse to BLOCK via CDG OUT edge.
    */
  def blockViaCdgOut: Iterator[nodes.Block] = cdgOut.collectAll[nodes.Block]

  /** Traverse to BLOCK via DOMINATE IN edge.
    */
  def blockViaDominateIn: Iterator[nodes.Block] = dominateIn.collectAll[nodes.Block]

  /** Traverse to BLOCK via DOMINATE OUT edge.
    */
  def blockViaDominateOut: Iterator[nodes.Block] = dominateOut.collectAll[nodes.Block]

  /** Traverse to BLOCK via POST_DOMINATE IN edge.
    */
  def blockViaPostDominateIn: Iterator[nodes.Block] = postDominateIn.collectAll[nodes.Block]

  /** Traverse to BLOCK via POST_DOMINATE OUT edge.
    */
  def blockViaPostDominateOut: Iterator[nodes.Block] = postDominateOut.collectAll[nodes.Block]

  /** Traverse to BLOCK via REACHING_DEF IN edge.
    */
  def blockViaReachingDefIn: Iterator[nodes.Block] = reachingDefIn.collectAll[nodes.Block]

  /** Traverse to BLOCK via REACHING_DEF OUT edge.
    */
  def blockViaReachingDefOut: Iterator[nodes.Block] = reachingDefOut.collectAll[nodes.Block]

  /** Traverse to CALL via ARGUMENT IN edge.
    */
  def callViaArgumentIn: Option[nodes.Call] = argumentIn.collectAll[nodes.Call].nextOption()

  /** Traverse to CALL via AST IN edge.
    */
  def callViaAstIn: Iterator[nodes.Call] = astIn.collectAll[nodes.Call]

  /** Traverse to CALL via AST OUT edge.
    */
  def callViaAstOut: Iterator[nodes.Call] = astOut.collectAll[nodes.Call]

  /** Traverse to CALL via CDG IN edge.
    */
  def callViaCdgIn: Iterator[nodes.Call] = cdgIn.collectAll[nodes.Call]

  /** Traverse to CALL via CDG OUT edge.
    */
  def callViaCdgOut: Iterator[nodes.Call] = cdgOut.collectAll[nodes.Call]

  /** Traverse to CALL via DOMINATE IN edge.
    */
  def callViaDominateIn: Iterator[nodes.Call] = dominateIn.collectAll[nodes.Call]

  /** Traverse to CALL via DOMINATE OUT edge.
    */
  def callViaDominateOut: Iterator[nodes.Call] = dominateOut.collectAll[nodes.Call]

  /** Traverse to CALL via POST_DOMINATE IN edge.
    */
  def callViaPostDominateIn: Iterator[nodes.Call] = postDominateIn.collectAll[nodes.Call]

  /** Traverse to CALL via POST_DOMINATE OUT edge.
    */
  def callViaPostDominateOut: Iterator[nodes.Call] = postDominateOut.collectAll[nodes.Call]

  /** Traverse to CALL via REACHING_DEF OUT edge.
    */
  def callViaReachingDefOut: Iterator[nodes.Call] = reachingDefOut.collectAll[nodes.Call]

  /** Traverse to CALL via RECEIVER IN edge.
    */
  def callViaReceiverIn: Option[nodes.Call] = receiverIn.collectAll[nodes.Call].nextOption()

  /** Traverse to CFG_NODE via CFG OUT edge.
    */
  def cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = cfgOut.collectAll[nodes.CfgNode]

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def controlStructureViaAstIn: Option[nodes.ControlStructure] = astIn.collectAll[nodes.ControlStructure].nextOption()

  /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
    */
  def controlStructureViaAstOut: Iterator[nodes.ControlStructure] = astOut.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
    */
  def controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = cdgIn.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
    */
  def controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = cdgOut.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
    */
  def controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = conditionIn.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
    */
  def controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = dominateIn.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
    */
  def controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = dominateOut.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
    */
  def controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = postDominateIn.collectAll[nodes.ControlStructure]

  /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
    */
  def controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = postDominateOut.collectAll[nodes.ControlStructure]

  /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
    */
  def fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = cdgIn.collectAll[nodes.FieldIdentifier]

  /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
    */
  def fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = cdgOut.collectAll[nodes.FieldIdentifier]

  /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
    */
  def fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = dominateIn.collectAll[nodes.FieldIdentifier]

  /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
    */
  def fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = dominateOut.collectAll[nodes.FieldIdentifier]

  /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
    */
  def fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = postDominateIn.collectAll[nodes.FieldIdentifier]

  /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = postDominateOut.collectAll[nodes.FieldIdentifier]

  /** Traverse to IDENTIFIER via AST OUT edge.
    */
  def identifierViaAstOut: Iterator[nodes.Identifier] = astOut.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via CDG IN edge.
    */
  def identifierViaCdgIn: Iterator[nodes.Identifier] = cdgIn.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via CDG OUT edge.
    */
  def identifierViaCdgOut: Iterator[nodes.Identifier] = cdgOut.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via DOMINATE IN edge.
    */
  def identifierViaDominateIn: Iterator[nodes.Identifier] = dominateIn.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via DOMINATE OUT edge.
    */
  def identifierViaDominateOut: Iterator[nodes.Identifier] = dominateOut.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
    */
  def identifierViaPostDominateIn: Iterator[nodes.Identifier] = postDominateIn.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def identifierViaPostDominateOut: Iterator[nodes.Identifier] = postDominateOut.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
    */
  def identifierViaReachingDefOut: Iterator[nodes.Identifier] = reachingDefOut.collectAll[nodes.Identifier]

  /** Traverse to IMPORT via AST OUT edge.
    */
  def importViaAstOut: Iterator[nodes.Import] = astOut.collectAll[nodes.Import]

  /** Traverse to JUMP_TARGET via AST OUT edge.
    */
  def jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = astOut.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via CDG IN edge.
    */
  def jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = cdgIn.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via CDG OUT edge.
    */
  def jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = cdgOut.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via DOMINATE IN edge.
    */
  def jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = dominateIn.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
    */
  def jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = dominateOut.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
    */
  def jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = postDominateIn.collectAll[nodes.JumpTarget]

  /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
    */
  def jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = postDominateOut.collectAll[nodes.JumpTarget]

  /** Traverse to LITERAL via AST OUT edge.
    */
  def literalViaAstOut: Iterator[nodes.Literal] = astOut.collectAll[nodes.Literal]

  /** Traverse to LITERAL via CDG IN edge.
    */
  def literalViaCdgIn: Iterator[nodes.Literal] = cdgIn.collectAll[nodes.Literal]

  /** Traverse to LITERAL via CDG OUT edge.
    */
  def literalViaCdgOut: Iterator[nodes.Literal] = cdgOut.collectAll[nodes.Literal]

  /** Traverse to LITERAL via DOMINATE IN edge.
    */
  def literalViaDominateIn: Iterator[nodes.Literal] = dominateIn.collectAll[nodes.Literal]

  /** Traverse to LITERAL via DOMINATE OUT edge.
    */
  def literalViaDominateOut: Iterator[nodes.Literal] = dominateOut.collectAll[nodes.Literal]

  /** Traverse to LITERAL via POST_DOMINATE IN edge.
    */
  def literalViaPostDominateIn: Iterator[nodes.Literal] = postDominateIn.collectAll[nodes.Literal]

  /** Traverse to LITERAL via POST_DOMINATE OUT edge.
    */
  def literalViaPostDominateOut: Iterator[nodes.Literal] = postDominateOut.collectAll[nodes.Literal]

  /** Traverse to LITERAL via REACHING_DEF OUT edge.
    */
  def literalViaReachingDefOut: Iterator[nodes.Literal] = reachingDefOut.collectAll[nodes.Literal]

  /** Traverse to LOCAL via AST OUT edge.
    */
  def localViaAstOut: Iterator[nodes.Local] = astOut.collectAll[nodes.Local]

  /** Traverse to METHOD via AST IN edge.
    */
  def methodViaAstIn: nodes.Method = {
    try { astIn.collectAll[nodes.Method].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to METHOD via CONTAINS IN edge.
    */
  def methodViaContainsIn: Iterator[nodes.Method] = containsIn.collectAll[nodes.Method]

  /** Traverse to METHOD via DOMINATE IN edge.
    */
  def methodViaDominateIn: Iterator[nodes.Method] = dominateIn.collectAll[nodes.Method]

  /** Traverse to METHOD via POST_DOMINATE OUT edge.
    */
  def methodViaPostDominateOut: Iterator[nodes.Method] = postDominateOut.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
    */
  def methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = reachingDefOut.collectAll[nodes.MethodParameterOut]

  /** Traverse to METHOD_REF via AST OUT edge.
    */
  def methodRefViaAstOut: Iterator[nodes.MethodRef] = astOut.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via CDG IN edge.
    */
  def methodRefViaCdgIn: Iterator[nodes.MethodRef] = cdgIn.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via CDG OUT edge.
    */
  def methodRefViaCdgOut: Iterator[nodes.MethodRef] = cdgOut.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via DOMINATE IN edge.
    */
  def methodRefViaDominateIn: Iterator[nodes.MethodRef] = dominateIn.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via DOMINATE OUT edge.
    */
  def methodRefViaDominateOut: Iterator[nodes.MethodRef] = dominateOut.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
    */
  def methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = postDominateIn.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
    */
  def methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = postDominateOut.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
    */
  def methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = reachingDefOut.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_RETURN via CDG OUT edge.
    */
  def methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = cdgOut.collectAll[nodes.MethodReturn]

  /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
    */
  def methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = dominateOut.collectAll[nodes.MethodReturn]

  /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
    */
  def methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = postDominateIn.collectAll[nodes.MethodReturn]

  /** Traverse to RETURN via ARGUMENT IN edge.
    */
  def returnViaArgumentIn: Option[nodes.Return] = argumentIn.collectAll[nodes.Return].nextOption()

  /** Traverse to RETURN via AST IN edge.
    */
  def returnViaAstIn: Iterator[nodes.Return] = astIn.collectAll[nodes.Return]

  /** Traverse to RETURN via AST OUT edge.
    */
  def returnViaAstOut: Iterator[nodes.Return] = astOut.collectAll[nodes.Return]

  /** Traverse to RETURN via CDG OUT edge.
    */
  def returnViaCdgOut: Iterator[nodes.Return] = cdgOut.collectAll[nodes.Return]

  /** Traverse to RETURN via DOMINATE IN edge.
    */
  def returnViaDominateIn: Iterator[nodes.Return] = dominateIn.collectAll[nodes.Return]

  /** Traverse to RETURN via DOMINATE OUT edge.
    */
  def returnViaDominateOut: Iterator[nodes.Return] = dominateOut.collectAll[nodes.Return]

  /** Traverse to RETURN via POST_DOMINATE IN edge.
    */
  def returnViaPostDominateIn: Iterator[nodes.Return] = postDominateIn.collectAll[nodes.Return]

  /** Traverse to RETURN via POST_DOMINATE OUT edge.
    */
  def returnViaPostDominateOut: Iterator[nodes.Return] = postDominateOut.collectAll[nodes.Return]

  /** Traverse to RETURN via REACHING_DEF OUT edge.
    */
  def returnViaReachingDefOut: Iterator[nodes.Return] = reachingDefOut.collectAll[nodes.Return]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def tagViaTaggedByOut: Iterator[nodes.Tag] = taggedByOut.collectAll[nodes.Tag]

  /** Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typeViaEvalTypeOut: Iterator[nodes.Type] = evalTypeOut.collectAll[nodes.Type]

  /** Traverse to TYPE_REF via AST OUT edge.
    */
  def typeRefViaAstOut: Iterator[nodes.TypeRef] = astOut.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via CDG IN edge.
    */
  def typeRefViaCdgIn: Iterator[nodes.TypeRef] = cdgIn.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via CDG OUT edge.
    */
  def typeRefViaCdgOut: Iterator[nodes.TypeRef] = cdgOut.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via DOMINATE IN edge.
    */
  def typeRefViaDominateIn: Iterator[nodes.TypeRef] = dominateIn.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via DOMINATE OUT edge.
    */
  def typeRefViaDominateOut: Iterator[nodes.TypeRef] = dominateOut.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
    */
  def typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = postDominateIn.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
    */
  def typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = postDominateOut.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
    */
  def typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = reachingDefOut.collectAll[nodes.TypeRef]

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def unknownViaAstIn: Iterator[nodes.Unknown] = astIn.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via AST OUT edge.
    */
  def unknownViaAstOut: Iterator[nodes.Unknown] = astOut.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via CDG IN edge.
    */
  def unknownViaCdgIn: Iterator[nodes.Unknown] = cdgIn.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via CDG OUT edge.
    */
  def unknownViaCdgOut: Iterator[nodes.Unknown] = cdgOut.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via DOMINATE IN edge.
    */
  def unknownViaDominateIn: Iterator[nodes.Unknown] = dominateIn.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via DOMINATE OUT edge.
    */
  def unknownViaDominateOut: Iterator[nodes.Unknown] = dominateOut.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
    */
  def unknownViaPostDominateIn: Iterator[nodes.Unknown] = postDominateIn.collectAll[nodes.Unknown]

  /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
    */
  def unknownViaPostDominateOut: Iterator[nodes.Unknown] = postDominateOut.collectAll[nodes.Unknown]

  /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
    */
  @deprecated("please use local instead")
  def localViaAstOut: Iterator[nodes.Local] = local

  /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
    */
  def local: Iterator[nodes.Local] = astOut.collectAll[nodes.Local]

  def argumentIn: Iterator[nodes.Expression] = node._argumentIn.cast[nodes.Expression]

  def astIn: Iterator[nodes.CfgNode] = node._astIn.cast[nodes.CfgNode]

  def astOut: Iterator[nodes.AstNode] = node._astOut.cast[nodes.AstNode]

  def cdgIn: Iterator[nodes.CfgNode] = node._cdgIn.cast[nodes.CfgNode]

  def cdgOut: Iterator[nodes.CfgNode] = node._cdgOut.cast[nodes.CfgNode]

  def cfgOut: Iterator[nodes.CfgNode] = node._cfgOut.cast[nodes.CfgNode]

  def conditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.cast[nodes.ControlStructure]

  def containsIn: Iterator[nodes.Method] = node._containsIn.cast[nodes.Method]

  def dominateIn: Iterator[nodes.CfgNode] = node._dominateIn.cast[nodes.CfgNode]

  def dominateOut: Iterator[nodes.CfgNode] = node._dominateOut.cast[nodes.CfgNode]

  def evalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.cast[nodes.Type]

  def postDominateIn: Iterator[nodes.CfgNode] = node._postDominateIn.cast[nodes.CfgNode]

  def postDominateOut: Iterator[nodes.CfgNode] = node._postDominateOut.cast[nodes.CfgNode]

  def reachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.cast[nodes.Block]

  def reachingDefOut: Iterator[nodes.CfgNode] = node._reachingDefOut.cast[nodes.CfgNode]

  def receiverIn: Iterator[nodes.Call] = node._receiverIn.cast[nodes.Call]

  def taggedByOut: Iterator[nodes.Tag] = node._taggedByOut.cast[nodes.Tag]
}

final class AccessNeighborsForBlockTraversal(val traversal: Iterator[nodes.Block]) extends AnyVal {
  def argumentIn: Iterator[nodes.Expression] = traversal.flatMap(_.argumentIn)

  def astIn: Iterator[nodes.CfgNode] = traversal.flatMap(_.astIn)

  def astOut: Iterator[nodes.AstNode] = traversal.flatMap(_.astOut)

  def cdgIn: Iterator[nodes.CfgNode] = traversal.flatMap(_.cdgIn)

  def cdgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_.cdgOut)

  def cfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_.cfgOut)

  def conditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_.conditionIn)

  def containsIn: Iterator[nodes.Method] = traversal.flatMap(_.containsIn)

  def dominateIn: Iterator[nodes.CfgNode] = traversal.flatMap(_.dominateIn)

  def dominateOut: Iterator[nodes.CfgNode] = traversal.flatMap(_.dominateOut)

  def evalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_.evalTypeOut)

  def postDominateIn: Iterator[nodes.CfgNode] = traversal.flatMap(_.postDominateIn)

  def postDominateOut: Iterator[nodes.CfgNode] = traversal.flatMap(_.postDominateOut)

  def reachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_.reachingDefIn)

  def reachingDefOut: Iterator[nodes.CfgNode] = traversal.flatMap(_.reachingDefOut)

  def receiverIn: Iterator[nodes.Call] = traversal.flatMap(_.receiverIn)

  def taggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_.taggedByOut)
}
