package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

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
  def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

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
  def method: nodes.Method = {
    try { node._astIn.iterator.collectAll[nodes.Method].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
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
  def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

}

final class AccessNeighborsForMethodParameterOutTraversal(val traversal: Iterator[nodes.MethodParameterOut]) extends AnyVal {

  /** Traverse to BLOCK via REACHING_DEF IN edge.
    */
  def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

  /** Traverse to CALL via REACHING_DEF IN edge.
    */
  def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

  /** Traverse to CALL via REACHING_DEF OUT edge.
    */
  def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

  /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
    */
  def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

  /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
    */
  def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

  /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
    */
  def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

  /** Traverse to LITERAL via REACHING_DEF IN edge.
    */
  def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

  /** Traverse to LITERAL via REACHING_DEF OUT edge.
    */
  def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

  /** Traverse to METHOD via AST IN edge.
    */
  def method: Iterator[nodes.Method] = traversal.map(_.method)

  /** Traverse to METHOD via REACHING_DEF IN edge.
    */
  def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

  /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
    */
  def asInput: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_.asInput)

  /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
    */
  def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

  /** Traverse to METHOD_REF via REACHING_DEF IN edge.
    */
  def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

  /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
    */
  def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

  /** Traverse to RETURN via REACHING_DEF IN edge.
    */
  def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

  /** Traverse to RETURN via REACHING_DEF OUT edge.
    */
  def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TYPE_REF via REACHING_DEF IN edge.
    */
  def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

  /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
    */
  def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

  /** Traverse to UNKNOWN via REACHING_DEF IN edge.
    */
  def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

  /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = traversal.flatMap(_.typ)

}
