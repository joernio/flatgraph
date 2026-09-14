package testdomains.hierarchical.neighboraccessors

import testdomains.hierarchical.nodes
import testdomains.hierarchical.language.*

final class AccessNeighborsForBaseNode(val node: nodes.BaseNode) extends AnyVal {

  /** Traverse to base_node via connected_to IN edge.
    */
  def _baseNodeViaConnectedToIn: Iterator[nodes.BaseNode] = connectedToIn.collectAll[nodes.BaseNode]

  /** Traverse to base_node via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def _baseNodeViaConnectedToOut: Iterator[nodes.BaseNode] = connectedTo

  /** Traverse to base_node via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.BaseNode] = connectedToOut.collectAll[nodes.BaseNode]

  def connectedToIn: Iterator[nodes.BaseNode] = node._connectedToIn.cast[nodes.BaseNode]

  def connectedToOut: Iterator[nodes.BaseNode] = node._connectedToOut.cast[nodes.BaseNode]
}

final class AccessNeighborsForBaseNodeTraversal(val traversal: Iterator[nodes.BaseNode]) extends AnyVal {

  /** Traverse to base_node via connected_to IN edge.
    */
  def _baseNodeViaConnectedToIn: Iterator[nodes.BaseNode] = traversal.flatMap(_._baseNodeViaConnectedToIn)

  /** Traverse to base_node via connected_to OUT edge.
    */
  def connectedTo: Iterator[nodes.BaseNode] = traversal.flatMap(_.connectedTo)

  /** Traverse to base_node via connected_to OUT edge.
    */
  @deprecated("please use connectedTo instead")
  def _baseNodeViaConnectedToOut: Iterator[nodes.BaseNode] = traversal.flatMap(_._baseNodeViaConnectedToOut)

  def connectedToIn: Iterator[nodes.BaseNode] = traversal.flatMap(_.connectedToIn)

  def connectedToOut: Iterator[nodes.BaseNode] = traversal.flatMap(_.connectedToOut)
}
