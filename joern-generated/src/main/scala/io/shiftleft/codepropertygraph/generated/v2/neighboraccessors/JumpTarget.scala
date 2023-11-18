package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

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
  def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

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

final class AccessNeighborsForJumpTargetTraversal(val traversal: Iterator[nodes.JumpTarget]) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

  /** Traverse to BLOCK via CDG IN edge.
    */
  def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

  /** Traverse to BLOCK via CDG OUT edge.
    */
  def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

  /** Traverse to BLOCK via DOMINATE IN edge.
    */
  def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

  /** Traverse to BLOCK via DOMINATE OUT edge.
    */
  def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

  /** Traverse to BLOCK via POST_DOMINATE IN edge.
    */
  def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

  /** Traverse to BLOCK via POST_DOMINATE OUT edge.
    */
  def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

  /** Traverse to CALL via ARGUMENT IN edge.
    */
  def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

  /** Traverse to CALL via CDG IN edge.
    */
  def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

  /** Traverse to CALL via CDG OUT edge.
    */
  def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

  /** Traverse to CALL via DOMINATE IN edge.
    */
  def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

  /** Traverse to CALL via DOMINATE OUT edge.
    */
  def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

  /** Traverse to CALL via POST_DOMINATE IN edge.
    */
  def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

  /** Traverse to CALL via POST_DOMINATE OUT edge.
    */
  def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

  /** Traverse to CFG_NODE via CFG OUT edge.
    */
  def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

  /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
    */
  def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

  /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
    */
  def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

  /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
    */
  def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

  /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
    */
  def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

  /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
    */
  def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

  /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
    */
  def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

  /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
    */
  def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

  /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
    */
  def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

  /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
    */
  def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

  /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
    */
  def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

  /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
    */
  def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

  /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
    */
  def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

  /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

  /** Traverse to IDENTIFIER via CDG IN edge.
    */
  def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

  /** Traverse to IDENTIFIER via CDG OUT edge.
    */
  def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

  /** Traverse to IDENTIFIER via DOMINATE IN edge.
    */
  def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

  /** Traverse to IDENTIFIER via DOMINATE OUT edge.
    */
  def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

  /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
    */
  def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

  /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

  /** Traverse to JUMP_TARGET via CDG IN edge.
    */
  def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

  /** Traverse to JUMP_TARGET via CDG OUT edge.
    */
  def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

  /** Traverse to JUMP_TARGET via DOMINATE IN edge.
    */
  def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

  /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
    */
  def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

  /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
    */
  def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

  /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
    */
  def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

  /** Traverse to LITERAL via CDG IN edge.
    */
  def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

  /** Traverse to LITERAL via CDG OUT edge.
    */
  def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

  /** Traverse to LITERAL via DOMINATE IN edge.
    */
  def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

  /** Traverse to LITERAL via DOMINATE OUT edge.
    */
  def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

  /** Traverse to LITERAL via POST_DOMINATE IN edge.
    */
  def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

  /** Traverse to LITERAL via POST_DOMINATE OUT edge.
    */
  def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

  /** Traverse to METHOD via CONTAINS IN edge.
    */
  def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

  /** Traverse to METHOD_REF via CDG IN edge.
    */
  def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

  /** Traverse to METHOD_REF via CDG OUT edge.
    */
  def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

  /** Traverse to METHOD_REF via DOMINATE IN edge.
    */
  def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

  /** Traverse to METHOD_REF via DOMINATE OUT edge.
    */
  def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

  /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
    */
  def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

  /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
    */
  def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

  /** Traverse to METHOD_RETURN via CDG OUT edge.
    */
  def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

  /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
    */
  def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

  /** Traverse to RETURN via ARGUMENT IN edge.
    */
  def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

  /** Traverse to RETURN via AST IN edge.
    */
  def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

  /** Traverse to RETURN via CDG OUT edge.
    */
  def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

  /** Traverse to RETURN via DOMINATE IN edge.
    */
  def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

  /** Traverse to RETURN via DOMINATE OUT edge.
    */
  def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

  /** Traverse to RETURN via POST_DOMINATE IN edge.
    */
  def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

  /** Traverse to RETURN via POST_DOMINATE OUT edge.
    */
  def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TYPE_REF via CDG IN edge.
    */
  def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

  /** Traverse to TYPE_REF via CDG OUT edge.
    */
  def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

  /** Traverse to TYPE_REF via DOMINATE IN edge.
    */
  def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

  /** Traverse to TYPE_REF via DOMINATE OUT edge.
    */
  def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

  /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
    */
  def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

  /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
    */
  def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

  /** Traverse to UNKNOWN via CDG IN edge.
    */
  def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

  /** Traverse to UNKNOWN via CDG OUT edge.
    */
  def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

  /** Traverse to UNKNOWN via DOMINATE IN edge.
    */
  def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

  /** Traverse to UNKNOWN via DOMINATE OUT edge.
    */
  def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

  /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
    */
  def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

  /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
    */
  def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

}
