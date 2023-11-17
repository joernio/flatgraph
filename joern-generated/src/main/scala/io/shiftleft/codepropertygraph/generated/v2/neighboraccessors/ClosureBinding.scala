package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForClosureBinding(val node: nodes.ClosureBinding) extends AnyVal {

  /** Traverse to LOCAL via CAPTURED_BY IN edge.
    */
  def _localViaCapturedByIn: Iterator[nodes.Local] = node._capturedByIn.iterator.collectAll[nodes.Local]

  /** Traverse to LOCAL via REF OUT edge.
    */
  def _localViaRefOut: Option[nodes.Local] = node._refOut.iterator.collectAll[nodes.Local].nextOption()

  /** Traverse to METHOD_PARAMETER_IN via CAPTURED_BY IN edge.
    */
  def _methodParameterInViaCapturedByIn: Iterator[nodes.MethodParameterIn] = node._capturedByIn.iterator.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
    */
  def _methodParameterInViaRefOut: Option[nodes.MethodParameterIn] = node._refOut.iterator.collectAll[nodes.MethodParameterIn].nextOption()

  /** Traverse to METHOD_REF via CAPTURE IN edge.
    */
  def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = node._captureIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to TYPE_REF via CAPTURE IN edge.
    */
  def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = node._captureIn.iterator.collectAll[nodes.TypeRef]

}

final class AccessNeighborsForClosureBindingTraversal(val traversal: IterableOnce[nodes.ClosureBinding]) extends AnyVal {

  /** Traverse to LOCAL via CAPTURED_BY IN edge.
    */
  def _localViaCapturedByIn: Iterator[nodes.Local] = traversal.flatMap(_._localViaCapturedByIn)

  /** Traverse to LOCAL via REF OUT edge.
    */
  def _localViaRefOut: Iterator[nodes.Local] = traversal.flatMap(_._localViaRefOut)

  /** Traverse to METHOD_PARAMETER_IN via CAPTURED_BY IN edge.
    */
  def _methodParameterInViaCapturedByIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaCapturedByIn)

  /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
    */
  def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaRefOut)

  /** Traverse to METHOD_REF via CAPTURE IN edge.
    */
  def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCaptureIn)

  /** Traverse to TYPE_REF via CAPTURE IN edge.
    */
  def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCaptureIn)

}
