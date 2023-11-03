package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForTag(val node: nodes.Tag) extends AnyVal {

  /** Traverse to BLOCK via TAGGED_BY IN edge.
    */
  def _blockViaTaggedByIn: Iterator[nodes.Block] = node._taggedByIn.iterator.collectAll[nodes.Block]

  /** Traverse to CALL via TAGGED_BY IN edge.
    */
  def _callViaTaggedByIn: Iterator[nodes.Call] = node._taggedByIn.iterator.collectAll[nodes.Call]

  /** Traverse to CONTROL_STRUCTURE via TAGGED_BY IN edge.
    */
  def _controlStructureViaTaggedByIn: Iterator[nodes.ControlStructure] = node._taggedByIn.iterator.collectAll[nodes.ControlStructure]

  /** Traverse to FIELD_IDENTIFIER via TAGGED_BY IN edge.
    */
  def _fieldIdentifierViaTaggedByIn: Iterator[nodes.FieldIdentifier] = node._taggedByIn.iterator.collectAll[nodes.FieldIdentifier]

  /** Traverse to FILE via TAGGED_BY IN edge.
    */
  def _fileViaTaggedByIn: Iterator[nodes.File] = node._taggedByIn.iterator.collectAll[nodes.File]

  /** Traverse to IDENTIFIER via TAGGED_BY IN edge.
    */
  def _identifierViaTaggedByIn: Iterator[nodes.Identifier] = node._taggedByIn.iterator.collectAll[nodes.Identifier]

  /** Traverse to IMPORT via TAGGED_BY IN edge.
    */
  def _importViaTaggedByIn: Iterator[nodes.Import] = node._taggedByIn.iterator.collectAll[nodes.Import]

  /** Traverse to JUMP_TARGET via TAGGED_BY IN edge.
    */
  def _jumpTargetViaTaggedByIn: Iterator[nodes.JumpTarget] = node._taggedByIn.iterator.collectAll[nodes.JumpTarget]

  /** Traverse to LITERAL via TAGGED_BY IN edge.
    */
  def _literalViaTaggedByIn: Iterator[nodes.Literal] = node._taggedByIn.iterator.collectAll[nodes.Literal]

  /** Traverse to LOCAL via TAGGED_BY IN edge.
    */
  def _localViaTaggedByIn: Iterator[nodes.Local] = node._taggedByIn.iterator.collectAll[nodes.Local]

  /** Traverse to MEMBER via TAGGED_BY IN edge.
    */
  def _memberViaTaggedByIn: Iterator[nodes.Member] = node._taggedByIn.iterator.collectAll[nodes.Member]

  /** Traverse to METHOD via TAGGED_BY IN edge.
    */
  def _methodViaTaggedByIn: Iterator[nodes.Method] = node._taggedByIn.iterator.collectAll[nodes.Method]

  /** Traverse to METHOD_PARAMETER_IN via TAGGED_BY IN edge.
    */
  def _methodParameterInViaTaggedByIn: Iterator[nodes.MethodParameterIn] = node._taggedByIn.iterator.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_OUT via TAGGED_BY IN edge.
    */
  def _methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] = node._taggedByIn.iterator.collectAll[nodes.MethodParameterOut]

  /** Traverse to METHOD_REF via TAGGED_BY IN edge.
    */
  def _methodRefViaTaggedByIn: Iterator[nodes.MethodRef] = node._taggedByIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_RETURN via TAGGED_BY IN edge.
    */
  def _methodReturnViaTaggedByIn: Iterator[nodes.MethodReturn] = node._taggedByIn.iterator.collectAll[nodes.MethodReturn]

  /** Traverse to RETURN via TAGGED_BY IN edge.
    */
  def _returnViaTaggedByIn: Iterator[nodes.Return] = node._taggedByIn.iterator.collectAll[nodes.Return]

  /** Traverse to TAG via TAGGED_BY IN edge.
    */
  def _tagViaTaggedByIn: Iterator[nodes.Tag] = node._taggedByIn.iterator.collectAll[nodes.Tag]

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  /** Traverse to TEMPLATE_DOM via TAGGED_BY IN edge.
    */
  def _templateDomViaTaggedByIn: Iterator[nodes.TemplateDom] = node._taggedByIn.iterator.collectAll[nodes.TemplateDom]

  /** Traverse to TYPE_REF via TAGGED_BY IN edge.
    */
  def _typeRefViaTaggedByIn: Iterator[nodes.TypeRef] = node._taggedByIn.iterator.collectAll[nodes.TypeRef]

  /** Traverse to UNKNOWN via TAGGED_BY IN edge.
    */
  def _unknownViaTaggedByIn: Iterator[nodes.Unknown] = node._taggedByIn.iterator.collectAll[nodes.Unknown]

}

final class AccessNeighborsForTagTraversal(val traversal: Iterator[nodes.Tag]) extends AnyVal {

  /** Traverse to BLOCK via TAGGED_BY IN edge.
    */
  def _blockViaTaggedByIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaTaggedByIn)

  /** Traverse to CALL via TAGGED_BY IN edge.
    */
  def _callViaTaggedByIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaTaggedByIn)

  /** Traverse to CONTROL_STRUCTURE via TAGGED_BY IN edge.
    */
  def _controlStructureViaTaggedByIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaTaggedByIn)

  /** Traverse to FIELD_IDENTIFIER via TAGGED_BY IN edge.
    */
  def _fieldIdentifierViaTaggedByIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaTaggedByIn)

  /** Traverse to FILE via TAGGED_BY IN edge.
    */
  def _fileViaTaggedByIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaTaggedByIn)

  /** Traverse to IDENTIFIER via TAGGED_BY IN edge.
    */
  def _identifierViaTaggedByIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaTaggedByIn)

  /** Traverse to IMPORT via TAGGED_BY IN edge.
    */
  def _importViaTaggedByIn: Iterator[nodes.Import] = traversal.flatMap(_._importViaTaggedByIn)

  /** Traverse to JUMP_TARGET via TAGGED_BY IN edge.
    */
  def _jumpTargetViaTaggedByIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaTaggedByIn)

  /** Traverse to LITERAL via TAGGED_BY IN edge.
    */
  def _literalViaTaggedByIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaTaggedByIn)

  /** Traverse to LOCAL via TAGGED_BY IN edge.
    */
  def _localViaTaggedByIn: Iterator[nodes.Local] = traversal.flatMap(_._localViaTaggedByIn)

  /** Traverse to MEMBER via TAGGED_BY IN edge.
    */
  def _memberViaTaggedByIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaTaggedByIn)

  /** Traverse to METHOD via TAGGED_BY IN edge.
    */
  def _methodViaTaggedByIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaTaggedByIn)

  /** Traverse to METHOD_PARAMETER_IN via TAGGED_BY IN edge.
    */
  def _methodParameterInViaTaggedByIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaTaggedByIn)

  /** Traverse to METHOD_PARAMETER_OUT via TAGGED_BY IN edge.
    */
  def _methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaTaggedByIn)

  /** Traverse to METHOD_REF via TAGGED_BY IN edge.
    */
  def _methodRefViaTaggedByIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaTaggedByIn)

  /** Traverse to METHOD_RETURN via TAGGED_BY IN edge.
    */
  def _methodReturnViaTaggedByIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaTaggedByIn)

  /** Traverse to RETURN via TAGGED_BY IN edge.
    */
  def _returnViaTaggedByIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaTaggedByIn)

  /** Traverse to TAG via TAGGED_BY IN edge.
    */
  def _tagViaTaggedByIn: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByIn)

  /** Traverse to TAG via TAGGED_BY OUT edge.
    */
  def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  /** Traverse to TEMPLATE_DOM via TAGGED_BY IN edge.
    */
  def _templateDomViaTaggedByIn: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaTaggedByIn)

  /** Traverse to TYPE_REF via TAGGED_BY IN edge.
    */
  def _typeRefViaTaggedByIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaTaggedByIn)

  /** Traverse to UNKNOWN via TAGGED_BY IN edge.
    */
  def _unknownViaTaggedByIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaTaggedByIn)

}
