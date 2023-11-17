package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForAnnotationParameterAssign(val node: nodes.AnnotationParameterAssign) extends AnyVal {

  /** Traverse to ANNOTATION via AST IN edge.
    */
  def _annotationViaAstIn: Iterator[nodes.Annotation] = node._astIn.iterator.collectAll[nodes.Annotation]

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

  /** Traverse to ANNOTATION_LITERAL via AST OUT edge.
    */
  def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = node._astOut.iterator.collectAll[nodes.AnnotationLiteral]

  /** Traverse to ANNOTATION_PARAMETER via AST OUT edge.
    */
  def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = node._astOut.iterator.collectAll[nodes.AnnotationParameter]

  /** Traverse to ARRAY_INITIALIZER via AST OUT edge.
    */
  def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = node._astOut.iterator.collectAll[nodes.ArrayInitializer]

}

final class AccessNeighborsForAnnotationParameterAssignTraversal(val traversal: IterableOnce[nodes.AnnotationParameterAssign])
    extends AnyVal {

  /** Traverse to ANNOTATION via AST IN edge.
    */
  def _annotationViaAstIn: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstIn)

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

  /** Traverse to ANNOTATION_LITERAL via AST OUT edge.
    */
  def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = traversal.flatMap(_._annotationLiteralViaAstOut)

  /** Traverse to ANNOTATION_PARAMETER via AST OUT edge.
    */
  def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = traversal.flatMap(_._annotationParameterViaAstOut)

  /** Traverse to ARRAY_INITIALIZER via AST OUT edge.
    */
  def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = traversal.flatMap(_._arrayInitializerViaAstOut)

}
