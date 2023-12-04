package io.shiftleft.codepropertygraph.generated.neighboraccessors

import io.shiftleft.codepropertygraph.generated.nodes
import io.shiftleft.codepropertygraph.generated.Language.*

final class AccessNeighborsForTypeArgument(val node: nodes.TypeArgument) extends AnyVal {

  /** Traverse to TYPE via AST IN edge.
    */
  def typeViaAstIn: Iterator[nodes.Type] = astIn.collectAll[nodes.Type]

  /** Traverse to TYPE via REF OUT edge.
    */
  def typeViaRefOut: Iterator[nodes.Type] = refOut.collectAll[nodes.Type]

  /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
    */
  def typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = bindsToOut.collectAll[nodes.TypeParameter]

  def astIn: Iterator[nodes.Type] = node._astIn.cast[nodes.Type]

  def bindsToOut: Iterator[nodes.TypeParameter] = node._bindsToOut.cast[nodes.TypeParameter]

  def refOut: Iterator[nodes.Type] = node._refOut.cast[nodes.Type]
}

final class AccessNeighborsForTypeArgumentTraversal(val traversal: Iterator[nodes.TypeArgument]) extends AnyVal {

  /** Traverse to TYPE via AST IN edge.
    */
  def typeViaAstIn: Iterator[nodes.Type] = traversal.flatMap(_.typeViaAstIn)

  /** Traverse to TYPE via REF OUT edge.
    */
  def typeViaRefOut: Iterator[nodes.Type] = traversal.flatMap(_.typeViaRefOut)

  /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
    */
  def typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_.typeParameterViaBindsToOut)

  def astIn: Iterator[nodes.Type] = traversal.flatMap(_.astIn)

  def bindsToOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_.bindsToOut)

  def refOut: Iterator[nodes.Type] = traversal.flatMap(_.refOut)
}
