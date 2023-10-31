package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForDependency(val node: nodes.Dependency) extends AnyVal {

  /** Traverse to IMPORT via IMPORTS IN edge.
    */
  def _importViaImportsIn: Iterator[nodes.Import] = node._importsIn.iterator.collectAll[nodes.Import]

}

final class AccessNeighborsForDependencyTraversal(val traversal: Iterator[nodes.Dependency]) extends AnyVal {

  /** Traverse to IMPORT via IMPORTS IN edge.
    */
  def _importViaImportsIn: Iterator[nodes.Import] = traversal.flatMap(_._importViaImportsIn)

}
