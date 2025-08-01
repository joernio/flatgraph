package testdomains.generic.neighboraccessors

import testdomains.generic.nodes
import testdomains.generic.language.*

final class AccessNeighborsForNodeA(val node: nodes.NodeA) extends AnyVal {

  /** Traverse to node_a via connected_to IN edge.
    */
  def _nodeAViaConnectedToIn: Iterator[nodes.NodeA] = connectedToIn.collectAll[nodes.NodeA]

  /** Traverse to node_b via another_edge OUT edge.
    */
  def _nodeBViaAnotherEdgeOut: Iterator[nodes.NodeB] = defaultStepNameOut.collectAll[nodes.NodeB]

  /** Connected neighbor node Traverse to node_a via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def _nodeAViaConnectedToOut: Iterator[nodes.NodeA] = connectedTo

  /** Connected neighbor node Traverse to node_a via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = connectedToOut.collectAll[nodes.NodeA]

  def connectedToIn: Iterator[nodes.NodeA] = node._connectedToIn.cast[nodes.NodeA]

  def connectedToOut: Iterator[nodes.NodeA] = node._connectedToOut.cast[nodes.NodeA]

  def defaultStepNameOut: Iterator[nodes.NodeB] = node._anotherEdgeOut.cast[nodes.NodeB]
}

final class AccessNeighborsForNodeATraversal(val traversal: Iterator[nodes.NodeA]) extends AnyVal {

  /** Traverse to node_a via connected_to IN edge.
    */
  def _nodeAViaConnectedToIn: Iterator[nodes.NodeA] = traversal.flatMap(_._nodeAViaConnectedToIn)

  /** Traverse to node_b via another_edge OUT edge.
    */
  def _nodeBViaAnotherEdgeOut: Iterator[nodes.NodeB] = traversal.flatMap(_._nodeBViaAnotherEdgeOut)

  /** Connected neighbor node Traverse to node_a via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedTo)

  /** Connected neighbor node Traverse to node_a via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def _nodeAViaConnectedToOut: Iterator[nodes.NodeA] = traversal.flatMap(_._nodeAViaConnectedToOut)

  def connectedToIn: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedToIn)

  def connectedToOut: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedToOut)

  def defaultStepNameOut: Iterator[nodes.NodeB] = traversal.flatMap(_.defaultStepNameOut)
}
