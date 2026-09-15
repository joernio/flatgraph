package testdomains.codepropertygraphminified

import flatgraph.traversal.language.*
import testdomains.codepropertygraphminified.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForCall(node: nodes.Call): AccessNeighborsForCall =
      new AccessNeighborsForCall(node)

    implicit def accessNeighborsForCallTraversal(traversal: IterableOnce[nodes.Call]): AccessNeighborsForCallTraversal =
      new AccessNeighborsForCallTraversal(traversal.iterator)

    implicit def accessNeighborsForMethod(node: nodes.Method): AccessNeighborsForMethod =
      new AccessNeighborsForMethod(node)

    implicit def accessNeighborsForMethodTraversal(traversal: IterableOnce[nodes.Method]): AccessNeighborsForMethodTraversal =
      new AccessNeighborsForMethodTraversal(traversal.iterator)
  }
}
