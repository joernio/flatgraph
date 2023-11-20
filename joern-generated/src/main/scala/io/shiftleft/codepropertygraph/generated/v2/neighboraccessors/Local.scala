package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForLocal(val node: nodes.Local) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

  /** Traverse to CLOSURE_BINDING via CAPTURED_BY OUT edge.
    */
  def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = node._capturedByOut.iterator.collectAll[nodes.ClosureBinding]

  /** Traverse to CLOSURE_BINDING via REF IN edge.
    */
  def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  /** Places (identifier) where this local is being referenced Traverse to IDENTIFIER via REF IN edge.
    */
  def referencingIdentifiers: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

  /** The block in which local is declared. Traverse to BLOCK via AST IN edge.
    */
  def definingBlock: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

  /** The type of the local. Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

}

final class AccessNeighborsForLocalTraversal(val traversal: Iterator[nodes.Local]) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

  /** Traverse to CLOSURE_BINDING via CAPTURED_BY OUT edge.
    */
  def _closureBindingViaCapturedByOut: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaCapturedByOut)

  /** Traverse to CLOSURE_BINDING via REF IN edge.
    */
  def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaRefIn)

  /** Traverse to CONTROL_STRUCTURE via AST IN edge.
    */
  def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to UNKNOWN via AST IN edge.
    */
  def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

  /** Places (identifier) where this local is being referenced Traverse to IDENTIFIER via REF IN edge.
    */
  def referencingIdentifiers: Iterator[nodes.Identifier] = traversal.flatMap(_.referencingIdentifiers)

  /** The block in which local is declared. Traverse to BLOCK via AST IN edge.
    */
  def definingBlock: Iterator[nodes.Block] = traversal.flatMap(_.definingBlock)

  /** The type of the local. Traverse to TYPE via EVAL_TYPE OUT edge.
    */
  def typ: Iterator[nodes.Type] = traversal.flatMap(_.typ)

}
