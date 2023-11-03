package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForArrayInitializer(val node: nodes.ArrayInitializer) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  /** Traverse to LITERAL via AST OUT edge.
    */
  def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

  /** Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

}

final class AccessNeighborsForArrayInitializerTraversal(val traversal: Iterator[nodes.ArrayInitializer]) extends AnyVal {

  /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
    */
  def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
    traversal.flatMap(_._annotationParameterAssignViaAstIn)

  /** Traverse to LITERAL via AST OUT edge.
    */
  def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

  /** Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

}
