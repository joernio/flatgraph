package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForNamespace(val node: nodes.Namespace) extends AnyVal {

  /** Traverse to NAMESPACE_BLOCK via REF IN edge.
    */
  def namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = refIn.collectAll[nodes.NamespaceBlock]

  def refIn: Iterator[nodes.NamespaceBlock] = node._refIn.cast[nodes.NamespaceBlock]
}

final class AccessNeighborsForNamespaceTraversal(val traversal: Iterator[nodes.Namespace]) extends AnyVal {
  def refIn: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_.refIn)
}
