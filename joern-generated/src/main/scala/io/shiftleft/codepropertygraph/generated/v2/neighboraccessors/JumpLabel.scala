package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForJumpLabel(val node: nodes.JumpLabel) extends AnyVal {

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def controlStructureViaAstIn: Iterator[nodes.ControlStructure] = astIn.collectAll[nodes.ControlStructure]

  def astIn: Iterator[nodes.ControlStructure] = node._astIn.cast[nodes.ControlStructure]
}

final class AccessNeighborsForJumpLabelTraversal(val traversal: Iterator[nodes.JumpLabel]) extends AnyVal {

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_.controlStructureViaAstIn)

  def astIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_.astIn)
}
