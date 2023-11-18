package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForImport(val node: nodes.Import) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

  /** Traverse to CALL via IS_CALL_FOR_IMPORT IN edge.
    */
  def _callViaIsCallForImportIn: Iterator[nodes.Call] = node._isCallForImportIn.iterator.collectAll[nodes.Call]

  /** Traverse to DEPENDENCY via IMPORTS OUT edge.
    */
  def _dependencyViaImportsOut: Iterator[nodes.Dependency] = node._importsOut.iterator.collectAll[nodes.Dependency]

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

}

final class AccessNeighborsForImportTraversal(val traversal: Iterator[nodes.Import]) extends AnyVal {

  /** Traverse to BLOCK via AST IN edge.
    */
  def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

  /** Traverse to CALL via IS_CALL_FOR_IMPORT IN edge.
    */
  def _callViaIsCallForImportIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaIsCallForImportIn)

  /** Traverse to DEPENDENCY via IMPORTS OUT edge.
    */
  def _dependencyViaImportsOut: Iterator[nodes.Dependency] = traversal.flatMap(_._dependencyViaImportsOut)

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaAstIn)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

}
