package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForTypeDecl(val node: nodes.TypeDecl) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

  /** Traverse to BINDING via BINDS OUT edge.
    */
  def _bindingViaBindsOut: Iterator[nodes.Binding] = node._bindsOut.iterator.collectAll[nodes.Binding]

  /** Traverse to FILE via CONTAINS IN edge.
    */
  def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

  /** Traverse to FILE via SOURCE_FILE OUT edge.
    */
  def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

  /** Traverse to IMPORT via AST OUT edge.
    */
  def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

  /** Traverse to MEMBER via AST OUT edge.
    */
  def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

  /** Traverse to METHOD via AST OUT edge.
    */
  def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD via CONTAINS OUT edge.
    */
  def _methodViaContainsOut: Iterator[nodes.Method] = node._containsOut.iterator.collectAll[nodes.Method]

  /** Traverse to MODIFIER via AST OUT edge.
    */
  def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

  /** Traverse to NAMESPACE_BLOCK via AST IN edge.
    */
  def namespaceBlock: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

  /** Traverse to TYPE via ALIAS_OF OUT edge.
    */
  def aliasedType: Iterator[nodes.Type] = node._aliasOfOut.iterator.collectAll[nodes.Type]

  /** Traverse to TYPE via INHERITS_FROM OUT edge.
    */
  def _typeViaInheritsFromOut: Iterator[nodes.Type] = node._inheritsFromOut.iterator.collectAll[nodes.Type]

  /** Traverse to TYPE via REF IN edge.
    */
  def _typeViaRefIn: Iterator[nodes.Type] = node._refIn.iterator.collectAll[nodes.Type]

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

  /** Traverse to TYPE_DECL via AST OUT edge.
    */
  def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

  /** Traverse to TYPE_PARAMETER via AST OUT edge.
    */
  def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

}

final class AccessNeighborsForTypeDeclTraversal(val traversal: Iterator[nodes.TypeDecl]) extends AnyVal {

  /** Traverse to ANNOTATION via AST OUT edge.
    */
  def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

  /** Traverse to BINDING via BINDS OUT edge.
    */
  def _bindingViaBindsOut: Iterator[nodes.Binding] = traversal.flatMap(_._bindingViaBindsOut)

  /** Traverse to FILE via CONTAINS IN edge.
    */
  def _fileViaContainsIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaContainsIn)

  /** Traverse to FILE via SOURCE_FILE OUT edge.
    */
  def _fileViaSourceFileOut: Iterator[nodes.File] = traversal.flatMap(_._fileViaSourceFileOut)

  /** Traverse to IMPORT via AST OUT edge.
    */
  def _importViaAstOut: Iterator[nodes.Import] = traversal.flatMap(_._importViaAstOut)

  /** Traverse to MEMBER via AST OUT edge.
    */
  def _memberViaAstOut: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstOut)

  /** Traverse to METHOD via AST IN edge.
    */
  def _methodViaAstIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstIn)

  /** Traverse to METHOD via AST OUT edge.
    */
  def _methodViaAstOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstOut)

  /** Traverse to METHOD via CONTAINS OUT edge.
    */
  def _methodViaContainsOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsOut)

  /** Traverse to MODIFIER via AST OUT edge.
    */
  def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

  /** Traverse to NAMESPACE_BLOCK via AST IN edge.
    */
  def namespaceBlock: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_.namespaceBlock)

  /** Traverse to TYPE via ALIAS_OF OUT edge.
    */
  def aliasedType: Iterator[nodes.Type] = traversal.flatMap(_.aliasedType)

  /** Traverse to TYPE via INHERITS_FROM OUT edge.
    */
  def _typeViaInheritsFromOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaInheritsFromOut)

  /** Traverse to TYPE via REF IN edge.
    */
  def _typeViaRefIn: Iterator[nodes.Type] = traversal.flatMap(_._typeViaRefIn)

  /** Traverse to TYPE_DECL via AST IN edge.
    */
  def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

  /** Traverse to TYPE_DECL via AST OUT edge.
    */
  def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstOut)

  /** Traverse to TYPE_PARAMETER via AST OUT edge.
    */
  def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_._typeParameterViaAstOut)

}
