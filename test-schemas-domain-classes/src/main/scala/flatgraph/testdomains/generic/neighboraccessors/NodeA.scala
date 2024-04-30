package flatgraph.testdomains.generic.neighboraccessors

import flatgraph.testdomains.generic.nodes
import flatgraph.testdomains.generic.Language.*

final class AccessNeighborsForNodeA(val node: nodes.NodeA) extends AnyVal {

  /** Traverse to node_a via connected_to IN edge.
    */
  def nodeAViaConnectedToIn: Iterator[nodes.NodeA] = connectedToIn.collectAll[nodes.NodeA]

  /** connected node Traverse to node_a via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def nodeAViaConnectedToOut: Iterator[nodes.NodeA] = connectedTo

  /** connected node Traverse to node_a via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = connectedToOut.collectAll[nodes.NodeA]

  def connectedToIn: Iterator[nodes.NodeA] = node._connectedToIn.cast[nodes.NodeA]

  def connectedToOut: Iterator[nodes.NodeA] = node._connectedToOut.cast[nodes.NodeA]
}

final class AccessNeighborsForNodeATraversal(val traversal: Iterator[nodes.NodeA]) extends AnyVal {

  /** Traverse to node_a via connected_to IN edge.
    */
  def nodeAViaConnectedToIn: Iterator[nodes.NodeA] = traversal.flatMap(_.nodeAViaConnectedToIn)

  /** connected node Traverse to node_a via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedTo)

  /** connected node Traverse to node_a via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def nodeAViaConnectedToOut: Iterator[nodes.NodeA] = traversal.flatMap(_.nodeAViaConnectedToOut)

  def connectedToIn: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedToIn)

  def connectedToOut: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedToOut)
}
