package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

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
  def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

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

  /** Traverse to METHOD via DOMINATE IN edge.
    */
  def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD via POST_DOMINATE OUT edge.
    */
  def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD_REF via CDG IN edge.
    */
  def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via DOMINATE IN edge.
    */
  def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
    */
  def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

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

final class AccessNeighborsForMethodReturnTraversal(val traversal: Iterator[nodes.MethodReturn]) extends AnyVal {

  /** Traverse to BLOCK via CDG IN edge.
    */
  def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

  /** Traverse to BLOCK via DOMINATE IN edge.
    */
  def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

  /** Traverse to BLOCK via POST_DOMINATE OUT edge.
    */
  def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

  /** Traverse to CALL via CDG IN edge.
    */
  def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

  /** Traverse to CALL via DOMINATE IN edge.
    */
  def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

  /** Traverse to CALL via POST_DOMINATE OUT edge.
    */
  def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

  /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
    */
  def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

  /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
    */
  def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

  /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
    */
  def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

  /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
    */
  def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

  /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
    */
  def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

  /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

  /** Traverse to IDENTIFIER via CDG IN edge.
    */
  def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

  /** Traverse to IDENTIFIER via DOMINATE IN edge.
    */
  def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

  /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
    */
  def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

  /** Traverse to JUMP_TARGET via CDG IN edge.
    */
  def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

  /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
    */
  def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

  /** Traverse to LITERAL via CDG IN edge.
    */
  def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

  /** Traverse to LITERAL via DOMINATE IN edge.
    */
  def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

  /** Traverse to LITERAL via POST_DOMINATE OUT edge.
    */
  def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

  /** Traverse to METHOD via DOMINATE IN edge.
    */
  def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

  /** Traverse to METHOD via POST_DOMINATE OUT edge.
    */
  def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

  /** Traverse to METHOD_REF via CDG IN edge.
    */
  def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

  /** Traverse to METHOD_REF via DOMINATE IN edge.
    */
  def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

  /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
    */
  def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

  /** Traverse to RETURN via CFG IN edge.
    */
  def toReturn: Iterator[nodes.Return] = traversal.flatMap(_.toReturn)

  /** Traverse to RETURN via DOMINATE IN edge.
    */
  def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

  /** Traverse to RETURN via POST_DOMINATE OUT edge.
    */
  def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

  /** Traverse to RETURN via REACHING_DEF IN edge.
    */
  def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

  /** Traverse to TYPE_REF via CDG IN edge.
    */
  def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

  /** Traverse to TYPE_REF via DOMINATE IN edge.
    */
  def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

  /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
    */
  def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

  /** Traverse to UNKNOWN via CDG IN edge.
    */
  def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

  /** Traverse to UNKNOWN via DOMINATE IN edge.
    */
  def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

  /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
    */
  def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

}
