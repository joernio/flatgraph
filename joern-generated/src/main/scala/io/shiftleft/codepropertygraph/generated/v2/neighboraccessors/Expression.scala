package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

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

final class AccessNeighborsForExpressionTraversal(val traversal: Iterator[nodes.Expression]) extends AnyVal {

  /** Traverse to TEMPLATE_DOM via ARGUMENT OUT edge.
    */
  def _templateDomViaArgumentOut: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaArgumentOut)

  /** Traverse to TEMPLATE_DOM via AST IN edge.
    */
  def _templateDomViaAstIn: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaAstIn)

  /** Traverse to TEMPLATE_DOM via REACHING_DEF IN edge.
    */
  def _templateDomViaReachingDefIn: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaReachingDefIn)

}
