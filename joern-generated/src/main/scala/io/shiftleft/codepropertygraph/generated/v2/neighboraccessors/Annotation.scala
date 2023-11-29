package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForAnnotation(val node: nodes.Annotation) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] = astIn.collectAll[nodes.AnnotationParameterAssign]

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
    */
  def annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] = astOut.collectAll[nodes.AnnotationParameterAssign]

  /** Traverse to IDENTIFIER via AST IN edge.
    */
  def identifierViaAstIn: Iterator[nodes.Identifier] = astIn.collectAll[nodes.Identifier]

  /** Traverse to LITERAL via AST IN edge.
    */
  def literalViaAstIn: Iterator[nodes.Literal] = astIn.collectAll[nodes.Literal]

  /** Traverse to MEMBER via AST IN edge.
    */
  def memberViaAstIn: Iterator[nodes.Member] = astIn.collectAll[nodes.Member]

  /** Traverse to METHOD via AST IN edge.
    */
  def methodViaAstIn: Iterator[nodes.Method] = astIn.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
    */
  def methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = astIn.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_REF via AST IN edge.
    */
  def methodRefViaAstIn: Iterator[nodes.MethodRef] = astIn.collectAll[nodes.MethodRef]

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def typeDeclViaAstIn: Iterator[nodes.TypeDecl] = astIn.collectAll[nodes.TypeDecl]

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def unknownViaAstIn: Iterator[nodes.Unknown] = astIn.collectAll[nodes.Unknown]

  def astIn: Iterator[nodes.AstNode] = node._astIn.cast[nodes.AstNode]

  def astOut: Iterator[nodes.AnnotationParameterAssign] = node._astOut.cast[nodes.AnnotationParameterAssign]
}

final class AccessNeighborsForAnnotationTraversal(val traversal: Iterator[nodes.Annotation]) extends AnyVal {
  def astIn: Iterator[nodes.AstNode] = traversal.flatMap(_.astIn)

  def astOut: Iterator[nodes.AnnotationParameterAssign] = traversal.flatMap(_.astOut)
}
