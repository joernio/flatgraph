package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForTypeParameter(val node: nodes.TypeParameter) extends AnyVal {

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: nodes.Method = {
    try { node._astIn.iterator.collectAll[nodes.Method].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this TYPE_PARAMETER node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to TYPE_ARGUMENT via BINDS_TO IN edge.
    */
  def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = node._bindsToIn.iterator.collectAll[nodes.TypeArgument]

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

}

final class AccessNeighborsForTypeParameterTraversal(val traversal: Iterator[nodes.TypeParameter]) extends AnyVal {

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

  /** Traverse to TYPE_ARGUMENT via BINDS_TO IN edge.
    */
  def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = traversal.flatMap(_._typeArgumentViaBindsToIn)

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

}
