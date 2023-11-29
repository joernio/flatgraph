package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForTag(val node: nodes.Tag) extends AnyVal {

  /** Traverse to BLOCK via TAGGED_BY IN edge.
    */
  def blockViaTaggedByIn: Iterator[nodes.Block] = taggedByIn.collectAll[nodes.Block]

  /** Traverse to CALL via TAGGED_BY IN edge.
    */
  def callViaTaggedByIn: Iterator[nodes.Call] = taggedByIn.collectAll[nodes.Call]

  /** Traverse to CONTROL_STRUCTURE via TAGGED_BY IN edge.
    */
  def controlStructureViaTaggedByIn: Iterator[nodes.ControlStructure] = taggedByIn.collectAll[nodes.ControlStructure]

  /** Traverse to FIELD_IDENTIFIER via TAGGED_BY IN edge.
    */
  def fieldIdentifierViaTaggedByIn: Iterator[nodes.FieldIdentifier] = taggedByIn.collectAll[nodes.FieldIdentifier]

  /** Traverse to FILE via TAGGED_BY IN edge.
    */
  def fileViaTaggedByIn: Iterator[nodes.File] = taggedByIn.collectAll[nodes.File]

  /** Traverse to IDENTIFIER via TAGGED_BY IN edge.
    */
  def identifierViaTaggedByIn: Iterator[nodes.Identifier] = taggedByIn.collectAll[nodes.Identifier]

  /** Traverse to IMPORT via TAGGED_BY IN edge.
    */
  def importViaTaggedByIn: Iterator[nodes.Import] = taggedByIn.collectAll[nodes.Import]

  /** Traverse to JUMP_TARGET via TAGGED_BY IN edge.
    */
  def jumpTargetViaTaggedByIn: Iterator[nodes.JumpTarget] = taggedByIn.collectAll[nodes.JumpTarget]

  /** Traverse to LITERAL via TAGGED_BY IN edge.
    */
  def literalViaTaggedByIn: Iterator[nodes.Literal] = taggedByIn.collectAll[nodes.Literal]

  /** Traverse to LOCAL via TAGGED_BY IN edge.
    */
  def localViaTaggedByIn: Iterator[nodes.Local] = taggedByIn.collectAll[nodes.Local]

  /** Traverse to MEMBER via TAGGED_BY IN edge.
    */
  def memberViaTaggedByIn: Iterator[nodes.Member] = taggedByIn.collectAll[nodes.Member]

  /** Traverse to METHOD via TAGGED_BY IN edge.
    */
  def methodViaTaggedByIn: Iterator[nodes.Method] = taggedByIn.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_IN via TAGGED_BY IN edge.
    */
  def methodParameterInViaTaggedByIn: Iterator[nodes.MethodParameterIn] = taggedByIn.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_OUT via TAGGED_BY IN edge.
    */
  def methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] = taggedByIn.collectAll[nodes.MethodParameterOut]

  /** Traverse to METHOD_REF via TAGGED_BY IN edge.
    */
  def methodRefViaTaggedByIn: Iterator[nodes.MethodRef] = taggedByIn.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_RETURN via TAGGED_BY IN edge.
    */
  def methodReturnViaTaggedByIn: Iterator[nodes.MethodReturn] = taggedByIn.collectAll[nodes.MethodReturn]

  /** Traverse to RETURN via TAGGED_BY IN edge.
    */
  def returnViaTaggedByIn: Iterator[nodes.Return] = taggedByIn.collectAll[nodes.Return]

  /** Traverse to TAG via TAGGED_BY IN edge.
    */
  def tagViaTaggedByIn: Iterator[nodes.Tag] = taggedByIn.collectAll[nodes.Tag]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def tagViaTaggedByOut: Iterator[nodes.Tag] = taggedByOut.collectAll[nodes.Tag]

  /** Traverse to TEMPLATE_DOM via TAGGED_BY IN edge.
    */
  def templateDomViaTaggedByIn: Iterator[nodes.TemplateDom] = taggedByIn.collectAll[nodes.TemplateDom]

  /** Traverse to TYPE_DECL via TAGGED_BY IN edge.
    */
  def typeDeclViaTaggedByIn: Iterator[nodes.TypeDecl] = taggedByIn.collectAll[nodes.TypeDecl]

  /** Traverse to TYPE_REF via TAGGED_BY IN edge.
    */
  def typeRefViaTaggedByIn: Iterator[nodes.TypeRef] = taggedByIn.collectAll[nodes.TypeRef]

  /** Traverse to UNKNOWN via TAGGED_BY IN edge.
    */
  def unknownViaTaggedByIn: Iterator[nodes.Unknown] = taggedByIn.collectAll[nodes.Unknown]

  def taggedByIn: Iterator[nodes.StoredNode] = node._taggedByIn.cast[nodes.StoredNode]

  def taggedByOut: Iterator[nodes.Tag] = node._taggedByOut.cast[nodes.Tag]
}

final class AccessNeighborsForTagTraversal(val traversal: Iterator[nodes.Tag]) extends AnyVal {
  def taggedByIn: Iterator[nodes.StoredNode] = traversal.flatMap(_.taggedByIn)

  def taggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_.taggedByOut)
}
