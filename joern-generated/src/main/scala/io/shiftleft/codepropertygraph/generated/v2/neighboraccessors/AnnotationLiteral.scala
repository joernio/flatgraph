package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForAnnotationLiteral(val node: nodes.AnnotationLiteral) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

}

final class AccessNeighborsForAnnotationLiteralTraversal(val traversal: Iterator[nodes.AnnotationLiteral]) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    traversal.flatMap(_._annotationParameterAssignViaAstIn)

}
