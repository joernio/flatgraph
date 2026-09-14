package testdomains.codepropertygraphminified.neighboraccessors

import testdomains.codepropertygraphminified.nodes
import testdomains.codepropertygraphminified.language.*

final class AccessNeighborsForCall(val node: nodes.Call) extends AnyVal {

  /** Traverse to METHOD via CALL OUT edge.
    */
  @deprecated("please use method instead")
  def _methodViaCallOut: Iterator[nodes.Method] = method

  /** Traverse to METHOD via CALL OUT edge.
    */
  def method: Iterator[nodes.Method] = callOut.collectAll[nodes.Method]

  def callOut: Iterator[nodes.Method] = node._callOut.cast[nodes.Method]
}

final class AccessNeighborsForCallTraversal(val traversal: Iterator[nodes.Call]) extends AnyVal {

  /** Traverse to METHOD via CALL OUT edge.
    */
  def method: Iterator[nodes.Method] = traversal.flatMap(_.method)

  /** Traverse to METHOD via CALL OUT edge.
    */
  @deprecated("please use method instead")
  def _methodViaCallOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaCallOut)

  def callOut: Iterator[nodes.Method] = traversal.flatMap(_.callOut)
}
