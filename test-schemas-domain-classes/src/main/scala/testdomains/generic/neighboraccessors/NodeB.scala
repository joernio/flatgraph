package testdomains.generic.neighboraccessors

import testdomains.generic.nodes
import testdomains.generic.language.*

final class AccessNeighborsForNodeB(val node: nodes.NodeB) extends AnyVal {

  /** Traverse to node_a via another_edge IN edge.
    */
  def _nodeAViaAnotherEdgeIn: Iterator[nodes.NodeA] = defaultStepNameIn.collectAll[nodes.NodeA]

  def defaultStepNameIn: Iterator[nodes.NodeA] = node._anotherEdgeIn.cast[nodes.NodeA]
}

final class AccessNeighborsForNodeBTraversal(val traversal: Iterator[nodes.NodeB]) extends AnyVal {

  /** Traverse to node_a via another_edge IN edge.
    */
  def _nodeAViaAnotherEdgeIn: Iterator[nodes.NodeA] = traversal.flatMap(_._nodeAViaAnotherEdgeIn)

  def defaultStepNameIn: Iterator[nodes.NodeA] = traversal.flatMap(_.defaultStepNameIn)
}
