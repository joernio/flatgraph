package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForMethodParameterOut(val node: nodes.MethodParameterOut) extends AnyVal {

  /** Traverse to BLOCK via REACHING_DEF IN edge.
    */
  def blockViaReachingDefIn: Iterator[nodes.Block] = reachingDefIn.collectAll[nodes.Block]

  /** Traverse to CALL via REACHING_DEF IN edge.
    */
  def callViaReachingDefIn: Iterator[nodes.Call] = reachingDefIn.collectAll[nodes.Call]

  /** Traverse to CALL via REACHING_DEF OUT edge.
    */
  def callViaReachingDefOut: Iterator[nodes.Call] = reachingDefOut.collectAll[nodes.Call]

  /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
    */
  def controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = reachingDefIn.collectAll[nodes.ControlStructure]

  /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
    */
  def identifierViaReachingDefIn: Iterator[nodes.Identifier] = reachingDefIn.collectAll[nodes.Identifier]

  /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
    */
  def identifierViaReachingDefOut: Iterator[nodes.Identifier] = reachingDefOut.collectAll[nodes.Identifier]

  /** Traverse to LITERAL via REACHING_DEF IN edge.
    */
  def literalViaReachingDefIn: Iterator[nodes.Literal] = reachingDefIn.collectAll[nodes.Literal]

  /** Traverse to LITERAL via REACHING_DEF OUT edge.
    */
  def literalViaReachingDefOut: Iterator[nodes.Literal] = reachingDefOut.collectAll[nodes.Literal]

  /** Traverse to METHOD via AST IN edge.
    */
  @deprecated("please use method instead")
  def methodViaAstIn: nodes.Method = method

  /** Traverse to METHOD via AST IN edge.
    */
  def method: nodes.Method = {
    try { astIn.collectAll[nodes.Method].next() }
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
  def methodViaReachingDefIn: Iterator[nodes.Method] = reachingDefIn.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
    */
  @deprecated("please use asInput instead")
  def methodParameterInViaParameterLinkIn: Iterator[nodes.MethodParameterIn] = asInput

  /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
    */
  def asInput: Iterator[nodes.MethodParameterIn] = parameterLinkIn.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
    */
  def methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = reachingDefIn.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_REF via REACHING_DEF IN edge.
    */
  def methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = reachingDefIn.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
    */
  def methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = reachingDefOut.collectAll[nodes.MethodRef]

  /** Traverse to RETURN via REACHING_DEF IN edge.
    */
  def returnViaReachingDefIn: Iterator[nodes.Return] = reachingDefIn.collectAll[nodes.Return]

  /** Traverse to RETURN via REACHING_DEF OUT edge.
    */
  def returnViaReachingDefOut: Iterator[nodes.Return] = reachingDefOut.collectAll[nodes.Return]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def tagViaTaggedByOut: Iterator[nodes.Tag] = taggedByOut.collectAll[nodes.Tag]

  /** Traverse to TYPE_REF via REACHING_DEF IN edge.
    */
  def typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = reachingDefIn.collectAll[nodes.TypeRef]

  /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
    */
  def typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = reachingDefOut.collectAll[nodes.TypeRef]

  /** Traverse to UNKNOWN via REACHING_DEF IN edge.
    */
  def unknownViaReachingDefIn: Iterator[nodes.Unknown] = reachingDefIn.collectAll[nodes.Unknown]

  /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  @deprecated("please use typ instead")
  def typeViaEvalTypeOut: Iterator[nodes.Type] = typ

  /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = evalTypeOut.collectAll[nodes.Type]

  def astIn: Iterator[nodes.Method] = node._astIn.cast[nodes.Method]

  def evalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.cast[nodes.Type]

  def parameterLinkIn: Iterator[nodes.MethodParameterIn] = node._parameterLinkIn.cast[nodes.MethodParameterIn]

  def reachingDefIn: Iterator[nodes.CfgNode] = node._reachingDefIn.cast[nodes.CfgNode]

  def reachingDefOut: Iterator[nodes.Expression] = node._reachingDefOut.cast[nodes.Expression]

  def taggedByOut: Iterator[nodes.Tag] = node._taggedByOut.cast[nodes.Tag]
}

final class AccessNeighborsForMethodParameterOutTraversal(val traversal: Iterator[nodes.MethodParameterOut]) extends AnyVal {
  def astIn: Iterator[nodes.Method] = traversal.flatMap(_.astIn)

  def evalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_.evalTypeOut)

  def parameterLinkIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_.parameterLinkIn)

  def reachingDefIn: Iterator[nodes.CfgNode] = traversal.flatMap(_.reachingDefIn)

  def reachingDefOut: Iterator[nodes.Expression] = traversal.flatMap(_.reachingDefOut)

  def taggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_.taggedByOut)
}
