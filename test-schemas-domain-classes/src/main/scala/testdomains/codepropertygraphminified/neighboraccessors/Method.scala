package testdomains.codepropertygraphminified.neighboraccessors

import testdomains.codepropertygraphminified.nodes
import testdomains.codepropertygraphminified.language.*

final class AccessNeighborsForMethod(val node: nodes.Method) extends AnyVal {

  /** Traverse to CALL via CALL IN edge.
    */
  def _callViaCallIn: Iterator[nodes.Call] = callIn.collectAll[nodes.Call]

  def callIn: Iterator[nodes.Call] = node._callIn.cast[nodes.Call]
}

final class AccessNeighborsForMethodTraversal(val traversal: Iterator[nodes.Method]) extends AnyVal {

  /** Traverse to CALL via CALL IN edge.
    */
  def _callViaCallIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCallIn)

  def callIn: Iterator[nodes.Call] = traversal.flatMap(_.callIn)
}
