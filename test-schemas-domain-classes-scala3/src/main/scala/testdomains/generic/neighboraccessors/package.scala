package testdomains.generic

import flatgraph.traversal.language.*
import testdomains.generic.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForNodeA(node: nodes.NodeA): AccessNeighborsForNodeA =
      new AccessNeighborsForNodeA(node)

    implicit def accessNeighborsForNodeATraversal(traversal: IterableOnce[nodes.NodeA]): AccessNeighborsForNodeATraversal =
      new AccessNeighborsForNodeATraversal(traversal.iterator)

    implicit def accessNeighborsForNodeB(node: nodes.NodeB): AccessNeighborsForNodeB =
      new AccessNeighborsForNodeB(node)

    implicit def accessNeighborsForNodeBTraversal(traversal: IterableOnce[nodes.NodeB]): AccessNeighborsForNodeBTraversal =
      new AccessNeighborsForNodeBTraversal(traversal.iterator)
  }
}
