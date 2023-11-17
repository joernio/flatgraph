package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

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

final class AccessNeighborsForTemplateDomTraversal(val traversal: IterableOnce[nodes.TemplateDom]) extends AnyVal {

  /** Traverse to EXPRESSION via ARGUMENT IN edge.
    */
  def _expressionViaArgumentIn: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaArgumentIn)

  /** Traverse to EXPRESSION via AST OUT edge.
    */
  def _expressionViaAstOut: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaAstOut)

  /** Traverse to EXPRESSION via REACHING_DEF OUT edge.
    */
  def _expressionViaReachingDefOut: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaReachingDefOut)

  /** Traverse to FILE via CONTAINS IN edge.
    */
  def _fileViaContainsIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaContainsIn)

  /** Traverse to METHOD via CONTAINS IN edge.
    */
  def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

}
