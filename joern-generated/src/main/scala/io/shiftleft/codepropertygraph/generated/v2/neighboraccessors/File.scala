package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForFile(val node: nodes.File) extends AnyVal {

  /** Traverse to COMMENT via AST OUT edge.
    */
  def comment: Iterator[nodes.Comment] = node._astOut.iterator.collectAll[nodes.Comment]

  /** Traverse to IMPORT via AST OUT edge.
    */
  def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

  /** Traverse to METHOD via CONTAINS OUT edge.
    */
  def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD via SOURCE_FILE IN edge.
    */
  def method: Iterator[nodes.Method] = node._sourceFileIn.iterator.collectAll[nodes.Method]

  /** Traverse to NAMESPACE_BLOCK via AST OUT edge.
    */
  def _namespaceBlockViaAstOut: Iterator[nodes.NamespaceBlock] = node._astOut.iterator.collectAll[nodes.NamespaceBlock]

  /** Traverse to NAMESPACE_BLOCK via SOURCE_FILE IN edge.
    */
  def namespaceBlock: Iterator[nodes.NamespaceBlock] = node._sourceFileIn.iterator.collectAll[nodes.NamespaceBlock]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
    */
  def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

  /** Traverse to TYPE_DECL via CONTAINS OUT edge.
    */
  def _typeDeclViaContainsOut: Iterator[nodes.TypeDecl] = node._containsOut.iterator.collectAll[nodes.TypeDecl]

  /** Traverse to TYPE_DECL via SOURCE_FILE IN edge.
    */
  def typeDecl: Iterator[nodes.TypeDecl] = node._sourceFileIn.iterator.collectAll[nodes.TypeDecl]

}

final class AccessNeighborsForFileTraversal(val traversal: IterableOnce[nodes.File]) extends AnyVal {

  /** Traverse to COMMENT via AST OUT edge.
    */
  def comment: Iterator[nodes.Comment] = traversal.flatMap(_.comment)

  /** Traverse to IMPORT via AST OUT edge.
    */
  def _importViaAstOut: Iterator[nodes.Import] = traversal.flatMap(_._importViaAstOut)

  /** Traverse to METHOD via CONTAINS OUT edge.
    */
  def _methodViaContainsOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsOut)

  /** Traverse to METHOD via SOURCE_FILE IN edge.
    */
  def method: Iterator[nodes.Method] = traversal.flatMap(_.method)

  /** Traverse to NAMESPACE_BLOCK via AST OUT edge.
    */
  def _namespaceBlockViaAstOut: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_._namespaceBlockViaAstOut)

  /** Traverse to NAMESPACE_BLOCK via SOURCE_FILE IN edge.
    */
  def namespaceBlock: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_.namespaceBlock)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
    */
  def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaContainsOut)

  /** Traverse to TYPE_DECL via CONTAINS OUT edge.
    */
  def _typeDeclViaContainsOut: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaContainsOut)

  /** Traverse to TYPE_DECL via SOURCE_FILE IN edge.
    */
  def typeDecl: Iterator[nodes.TypeDecl] = traversal.flatMap(_.typeDecl)

}
