package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForBinding(val node: nodes.Binding) extends AnyVal {

  /** Traverse to METHOD via REF OUT edge.
    */
  def boundMethod: nodes.Method = {
    try { node._refOut.iterator.collectAll[nodes.Method].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this BINDING node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to TYPE_DECL via BINDS IN edge.
    */
  def bindingTypeDecl: nodes.TypeDecl = {
    try { node._bindsIn.iterator.collectAll[nodes.TypeDecl].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new io.joern.odb2.SchemaViolationException(
          "IN edge with label BINDS to an adjacent TYPE_DECL is mandatory, but not defined for this BINDING node with seq=" + node.seq,
          e
        )
    }
  }

}

final class AccessNeighborsForBindingTraversal(val traversal: Iterator[nodes.Binding]) extends AnyVal {

  /** Traverse to METHOD via REF OUT edge.
    */
  def boundMethod: Iterator[nodes.Method] = traversal.map(_.boundMethod)

  /** Traverse to TYPE_DECL via BINDS IN edge.
    */
  def bindingTypeDecl: Iterator[nodes.TypeDecl] = traversal.map(_.bindingTypeDecl)

}
