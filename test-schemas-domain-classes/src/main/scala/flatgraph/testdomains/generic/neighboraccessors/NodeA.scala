package flatgraph.testdomains.generic.neighboraccessors

import flatgraph.testdomains.generic.nodes
import flatgraph.testdomains.generic.Language.*

final class AccessNeighborsForNodeA(val node: nodes.NodeA) extends AnyVal {

  /** Traverse to node_a via connectedTo IN edge.
    */
  def nodeAViaConnectedtoIn: Iterator[nodes.NodeA] = connectedtoIn.collectAll[nodes.NodeA]

  /** Traverse to node_a via connectedTo OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def nodeAViaConnectedtoOut: Iterator[nodes.NodeA] = connectedTo

  /** Traverse to node_a via connectedTo OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = connectedtoOut.collectAll[nodes.NodeA]

  def connectedtoIn: Iterator[nodes.NodeA] = node._connectedtoIn.cast[nodes.NodeA]

  def connectedtoOut: Iterator[nodes.NodeA] = node._connectedtoOut.cast[nodes.NodeA]
}

final class AccessNeighborsForNodeATraversal(val traversal: Iterator[nodes.NodeA]) extends AnyVal {

  /** Traverse to node_a via connectedTo IN edge.
    */
  def nodeAViaConnectedtoIn: Iterator[nodes.NodeA] = traversal.flatMap(_.nodeAViaConnectedtoIn)

  /** Traverse to node_a via connectedTo OUT edge.
    */
  def connectedTo: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedTo)

  /** Traverse to node_a via connectedTo OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def nodeAViaConnectedtoOut: Iterator[nodes.NodeA] = traversal.flatMap(_.nodeAViaConnectedtoOut)

  def connectedtoIn: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedtoIn)

  def connectedtoOut: Iterator[nodes.NodeA] = traversal.flatMap(_.connectedtoOut)
}
