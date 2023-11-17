package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForNamespace(val node: nodes.Namespace) extends AnyVal {

  /** Traverse to NAMESPACE_BLOCK via REF IN edge.
    */
  def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = node._refIn.iterator.collectAll[nodes.NamespaceBlock]

}

final class AccessNeighborsForNamespaceTraversal(val traversal: IterableOnce[nodes.Namespace]) extends AnyVal {

  /** Traverse to NAMESPACE_BLOCK via REF IN edge.
    */
  def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_._namespaceBlockViaRefIn)

}
