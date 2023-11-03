package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForModifier(val node: nodes.Modifier) extends AnyVal {

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

  /** Traverse to MEMBER via AST IN edge.
    */
  def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: nodes.Method = {
    try { node._astIn.iterator.collectAll[nodes.Method].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: nodes.TypeDecl = {
    try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

}

final class AccessNeighborsForModifierTraversal(val traversal: Iterator[nodes.Modifier]) extends AnyVal {

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

  /** Traverse to MEMBER via AST IN edge.
    */
  def _memberViaAstIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstIn)

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.map(_._typeDeclViaAstIn)

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

}
