package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForNamespaceBlock(val node: nodes.NamespaceBlock) extends AnyVal {

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Option[nodes.File] = node._astIn.iterator.collectAll[nodes.File].nextOption()

  /** Traverse to FILE via SOURCE_FILE OUT edge.
    */
  def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

  /** Traverse to METHOD via AST OUT edge.
    */
  def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

  /** Traverse to NAMESPACE via REF OUT edge.
    */
  def _namespaceViaRefOut: Iterator[nodes.Namespace] = node._refOut.iterator.collectAll[nodes.Namespace]

  /** Traverse to TYPE_DECL via AST OUT edge.
    */
  def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

}

final class AccessNeighborsForNamespaceBlockTraversal(val traversal: IterableOnce[nodes.NamespaceBlock]) extends AnyVal {

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaAstIn)

  /** Traverse to FILE via SOURCE_FILE OUT edge.
    */
  def _fileViaSourceFileOut: Iterator[nodes.File] = traversal.flatMap(_._fileViaSourceFileOut)

  /** Traverse to METHOD via AST OUT edge.
    */
  def _methodViaAstOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstOut)

  /** Traverse to NAMESPACE via REF OUT edge.
    */
  def _namespaceViaRefOut: Iterator[nodes.Namespace] = traversal.flatMap(_._namespaceViaRefOut)

  /** Traverse to TYPE_DECL via AST OUT edge.
    */
  def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstOut)

}
