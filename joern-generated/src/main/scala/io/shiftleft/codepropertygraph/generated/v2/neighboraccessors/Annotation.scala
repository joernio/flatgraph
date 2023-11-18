package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForAnnotation(val node: nodes.Annotation) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
    */
  def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
    node._astOut.iterator.collectAll[nodes.AnnotationParameterAssign]

  /** Traverse to IDENTIFIER via AST IN edge.
    */
  def _identifierViaAstIn: Iterator[nodes.Identifier] = node._astIn.iterator.collectAll[nodes.Identifier]

  /** Traverse to LITERAL via AST IN edge.
    */
  def _literalViaAstIn: Iterator[nodes.Literal] = node._astIn.iterator.collectAll[nodes.Literal]

  /** Traverse to MEMBER via AST IN edge.
    */
  def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
    */
  def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_REF via AST IN edge.
    */
  def _methodRefViaAstIn: Iterator[nodes.MethodRef] = node._astIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

}

final class AccessNeighborsForAnnotationTraversal(val traversal: Iterator[nodes.Annotation]) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    traversal.flatMap(_._annotationParameterAssignViaAstIn)

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
    */
  def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
    traversal.flatMap(_._annotationParameterAssignViaAstOut)

  /** Traverse to IDENTIFIER via AST IN edge.
    */
  def _identifierViaAstIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstIn)

  /** Traverse to LITERAL via AST IN edge.
    */
  def _literalViaAstIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstIn)

  /** Traverse to MEMBER via AST IN edge.
    */
  def _memberViaAstIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstIn)

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstIn)

  /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
    */
  def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaAstIn)

  /** Traverse to METHOD_REF via AST IN edge.
    */
  def _methodRefViaAstIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstIn)

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

}
