package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForTypeArgument(val node: nodes.TypeArgument) extends AnyVal {

  /** Traverse to TYPE via AST IN edge.
    */
  def _typeViaAstIn: Iterator[nodes.Type] = node._astIn.iterator.collectAll[nodes.Type]

  /** Traverse to TYPE via REF OUT edge.
    */
  def _typeViaRefOut: Iterator[nodes.Type] = node._refOut.iterator.collectAll[nodes.Type]

  /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
    */
  def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = node._bindsToOut.iterator.collectAll[nodes.TypeParameter]

}

final class AccessNeighborsForTypeArgumentTraversal(val traversal: Iterator[nodes.TypeArgument]) extends AnyVal {

  /** Traverse to TYPE via AST IN edge.
    */
  def _typeViaAstIn: Iterator[nodes.Type] = traversal.flatMap(_._typeViaAstIn)

  /** Traverse to TYPE via REF OUT edge.
    */
  def _typeViaRefOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaRefOut)

  /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
    */
  def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_._typeParameterViaBindsToOut)

}
