package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForMethodParameterIn(val node: nodes.MethodParameterIn) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

  /** Traverse to CALL via REACHING_DEF OUT edge.
    */
  def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

  /** Traverse to CLOSURE_BINDING via CAPTURED_BY OUT edge.
    */
  def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = node._capturedByOut.iterator.collectAll[nodes.ClosureBinding]

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
  def referencingIdentifiers: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

  /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
    */
  def asOutput: Iterator[nodes.MethodParameterOut] = node._parameterLinkOut.iterator.collectAll[nodes.MethodParameterOut]

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

final class AccessNeighborsForMethodParameterInTraversal(val traversal: Iterator[nodes.MethodParameterIn]) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

  /** Traverse to CALL via REACHING_DEF OUT edge.
    */
  def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

  /** Traverse to CLOSURE_BINDING via CAPTURED_BY OUT edge.
    */
  def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaCapturedByOut)

  /** Traverse to CLOSURE_BINDING via REF IN edge.
    */
  def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaRefIn)

  /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
    */
  def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

  /** Traverse to LITERAL via REACHING_DEF OUT edge.
    */
  def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

  /** Traverse to METHOD via REACHING_DEF IN edge.
    */
  def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

  /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
    */
  def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

  /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
    */
  def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

  /** Traverse to RETURN via REACHING_DEF OUT edge.
    */
  def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
    */
  def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

  /** Traverse to UNKNOWN via AST OUT edge.
    */
  def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

  /** Places (identifier) where this parameter is being referenced Traverse to IDENTIFIER via REF IN edge.
    */
  def referencingIdentifiers: Iterator[nodes.Identifier] = traversal.flatMap(_.referencingIdentifiers)

  /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
    */
  def asOutput: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_.asOutput)

  /** Traverse to method associated with this formal parameter Traverse to METHOD via AST IN edge.
    */
  def method: Iterator[nodes.Method] = traversal.map(_.method)

  /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = traversal.map(_.typ)

}
