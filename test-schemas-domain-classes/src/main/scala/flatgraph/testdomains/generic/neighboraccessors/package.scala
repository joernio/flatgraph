package flatgraph.testdomains.generic

import flatgraph.traversal.Language.*
import flatgraph.testdomains.generic.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForNodeA(node: nodes.NodeA): AccessNeighborsForNodeA =
      new AccessNeighborsForNodeA(node)

    implicit def accessNeighborsForNodeATraversal(traversal: IterableOnce[nodes.NodeA]): AccessNeighborsForNodeATraversal =
      new AccessNeighborsForNodeATraversal(traversal.iterator)
  }
}
