package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForDependency(val node: nodes.Dependency) extends AnyVal {

  /** Traverse to IMPORT via IMPORTS IN edge.
    */
  def importViaImportsIn: Iterator[nodes.Import] = importsIn.collectAll[nodes.Import]

  def importsIn: Iterator[nodes.Import] = node._importsIn.cast[nodes.Import]
}

final class AccessNeighborsForDependencyTraversal(val traversal: Iterator[nodes.Dependency]) extends AnyVal {

  /** Traverse to IMPORT via IMPORTS IN edge.
    */
  def importViaImportsIn: Iterator[nodes.Import] = traversal.flatMap(_.importViaImportsIn)

  def importsIn: Iterator[nodes.Import] = traversal.flatMap(_.importsIn)
}
