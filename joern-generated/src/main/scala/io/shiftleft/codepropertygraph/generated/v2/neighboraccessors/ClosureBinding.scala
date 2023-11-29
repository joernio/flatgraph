package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForClosureBinding(val node: nodes.ClosureBinding) extends AnyVal {

  /** Traverse to LOCAL via CAPTURED_BY IN edge.
    */
  def localViaCapturedByIn: Iterator[nodes.Local] = capturedByIn.collectAll[nodes.Local]

  /** Traverse to LOCAL via REF OUT edge.
    */
  def localViaRefOut: Option[nodes.Local] = refOut.collectAll[nodes.Local].nextOption()

  /** Traverse to METHOD_PARAMETER_IN via CAPTURED_BY IN edge.
    */
  def methodParameterInViaCapturedByIn: Iterator[nodes.MethodParameterIn] = capturedByIn.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
    */
  def methodParameterInViaRefOut: Option[nodes.MethodParameterIn] = refOut.collectAll[nodes.MethodParameterIn].nextOption()

  /** Traverse to METHOD_REF via CAPTURE IN edge.
    */
  def methodRefViaCaptureIn: Iterator[nodes.MethodRef] = captureIn.collectAll[nodes.MethodRef]

  /** Traverse to TYPE_REF via CAPTURE IN edge.
    */
  def typeRefViaCaptureIn: Iterator[nodes.TypeRef] = captureIn.collectAll[nodes.TypeRef]

  def captureIn: Iterator[nodes.Expression] = node._captureIn.cast[nodes.Expression]

  def capturedByIn: Iterator[nodes.AstNode] = node._capturedByIn.cast[nodes.AstNode]

  def refOut: Iterator[nodes.AstNode] = node._refOut.cast[nodes.AstNode]
}

final class AccessNeighborsForClosureBindingTraversal(val traversal: Iterator[nodes.ClosureBinding]) extends AnyVal {
  def captureIn: Iterator[nodes.Expression] = traversal.flatMap(_.captureIn)

  def capturedByIn: Iterator[nodes.AstNode] = traversal.flatMap(_.capturedByIn)

  def refOut: Iterator[nodes.AstNode] = traversal.flatMap(_.refOut)
}
