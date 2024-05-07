package testdomains.hierarchical

import flatgraph.traversal.Language.*
import testdomains.hierarchical.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForBaseNode(node: nodes.BaseNode): AccessNeighborsForBaseNode =
      new AccessNeighborsForBaseNode(node)

    implicit def accessNeighborsForBaseNodeTraversal(traversal: IterableOnce[nodes.BaseNode]): AccessNeighborsForBaseNodeTraversal =
      new AccessNeighborsForBaseNodeTraversal(traversal.iterator)
  }
}
