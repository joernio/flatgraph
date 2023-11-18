package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForMember(val node: nodes.Member) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

  /** Traverse to CALL via REF IN edge.
    */
  def _callViaRefIn: Iterator[nodes.Call] = node._refIn.iterator.collectAll[nodes.Call]

  /** Traverse to MODIFIER via AST OUT edge.
    */
  def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
    */
  def typeDecl: nodes.TypeDecl = {
    try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MEMBER node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

}

final class AccessNeighborsForMemberTraversal(val traversal: Iterator[nodes.Member]) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

  /** Traverse to CALL via REF IN edge.
    */
  def _callViaRefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaRefIn)

  /** Traverse to MODIFIER via AST OUT edge.
    */
  def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

  /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
    */
  def typeDecl: Iterator[nodes.TypeDecl] = traversal.map(_.typeDecl)

  /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = traversal.flatMap(_.typ)

}
