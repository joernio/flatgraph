package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForType(val node: nodes.Type) extends AnyVal {

  /** Traverse to ARRAY_INITIALIZER via EVAL_TYPE IN edge.
    */
  def _arrayInitializerViaEvalTypeIn: Iterator[nodes.ArrayInitializer] = node._evalTypeIn.iterator.collectAll[nodes.ArrayInitializer]

  /** Traverse to BLOCK via EVAL_TYPE IN edge.
    */
  def _blockViaEvalTypeIn: Iterator[nodes.Block] = node._evalTypeIn.iterator.collectAll[nodes.Block]

  /** Traverse to CALL via EVAL_TYPE IN edge.
    */
  def _callViaEvalTypeIn: Iterator[nodes.Call] = node._evalTypeIn.iterator.collectAll[nodes.Call]

  /** Traverse to CONTROL_STRUCTURE via EVAL_TYPE IN edge.
    */
  def _controlStructureViaEvalTypeIn: Iterator[nodes.ControlStructure] = node._evalTypeIn.iterator.collectAll[nodes.ControlStructure]

  /** Traverse to IDENTIFIER via EVAL_TYPE IN edge.
    */
  def _identifierViaEvalTypeIn: Iterator[nodes.Identifier] = node._evalTypeIn.iterator.collectAll[nodes.Identifier]

  /** Traverse to LITERAL via EVAL_TYPE IN edge.
    */
  def _literalViaEvalTypeIn: Iterator[nodes.Literal] = node._evalTypeIn.iterator.collectAll[nodes.Literal]

  /** Traverse to LOCAL via EVAL_TYPE IN edge.
    */
  def _localViaEvalTypeIn: Iterator[nodes.Local] = node._evalTypeIn.iterator.collectAll[nodes.Local]

  /** Traverse to MEMBER via EVAL_TYPE IN edge.
    */
  def _memberViaEvalTypeIn: Iterator[nodes.Member] = node._evalTypeIn.iterator.collectAll[nodes.Member]

  /** Traverse to METHOD_PARAMETER_IN via EVAL_TYPE IN edge.
    */
  def _methodParameterInViaEvalTypeIn: Iterator[nodes.MethodParameterIn] = node._evalTypeIn.iterator.collectAll[nodes.MethodParameterIn]

  /** Traverse to METHOD_PARAMETER_OUT via EVAL_TYPE IN edge.
    */
  def _methodParameterOutViaEvalTypeIn: Iterator[nodes.MethodParameterOut] = node._evalTypeIn.iterator.collectAll[nodes.MethodParameterOut]

  /** Traverse to METHOD_REF via EVAL_TYPE IN edge.
    */
  def _methodRefViaEvalTypeIn: Iterator[nodes.MethodRef] = node._evalTypeIn.iterator.collectAll[nodes.MethodRef]

  /** Traverse to METHOD_RETURN via EVAL_TYPE IN edge.
    */
  def _methodReturnViaEvalTypeIn: Iterator[nodes.MethodReturn] = node._evalTypeIn.iterator.collectAll[nodes.MethodReturn]

  /** Traverse to TYPE_ARGUMENT via AST OUT edge.
    */
  def _typeArgumentViaAstOut: Iterator[nodes.TypeArgument] = node._astOut.iterator.collectAll[nodes.TypeArgument]

  /** Traverse to TYPE_ARGUMENT via REF IN edge.
    */
  def _typeArgumentViaRefIn: Iterator[nodes.TypeArgument] = node._refIn.iterator.collectAll[nodes.TypeArgument]

  /** Traverse to TYPE_DECL via INHERITS_FROM IN edge.
    */
  def _typeDeclViaInheritsFromIn: Iterator[nodes.TypeDecl] = node._inheritsFromIn.iterator.collectAll[nodes.TypeDecl]

  /** Traverse to TYPE_REF via EVAL_TYPE IN edge.
    */
  def _typeRefViaEvalTypeIn: Iterator[nodes.TypeRef] = node._evalTypeIn.iterator.collectAll[nodes.TypeRef]

  /** Traverse to UNKNOWN via EVAL_TYPE IN edge.
    */
  def _unknownViaEvalTypeIn: Iterator[nodes.Unknown] = node._evalTypeIn.iterator.collectAll[nodes.Unknown]

  /** Direct alias type declarations. Traverse to TYPE_DECL via ALIAS_OF IN edge.
    */
  def aliasTypeDecl: Iterator[nodes.TypeDecl] = node._aliasOfIn.iterator.collectAll[nodes.TypeDecl]

  /** Type declaration which is referenced by this type. Traverse to TYPE_DECL via REF OUT edge.
    */
  def referencedTypeDecl: Iterator[nodes.TypeDecl] = node._refOut.iterator.collectAll[nodes.TypeDecl]

}

final class AccessNeighborsForTypeTraversal(val traversal: IterableOnce[nodes.Type]) extends AnyVal {

  /** Traverse to ARRAY_INITIALIZER via EVAL_TYPE IN edge.
    */
  def _arrayInitializerViaEvalTypeIn: Iterator[nodes.ArrayInitializer] = traversal.flatMap(_._arrayInitializerViaEvalTypeIn)

  /** Traverse to BLOCK via EVAL_TYPE IN edge.
    */
  def _blockViaEvalTypeIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaEvalTypeIn)

  /** Traverse to CALL via EVAL_TYPE IN edge.
    */
  def _callViaEvalTypeIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaEvalTypeIn)

  /** Traverse to CONTROL_STRUCTURE via EVAL_TYPE IN edge.
    */
  def _controlStructureViaEvalTypeIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaEvalTypeIn)

  /** Traverse to IDENTIFIER via EVAL_TYPE IN edge.
    */
  def _identifierViaEvalTypeIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaEvalTypeIn)

  /** Traverse to LITERAL via EVAL_TYPE IN edge.
    */
  def _literalViaEvalTypeIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaEvalTypeIn)

  /** Traverse to LOCAL via EVAL_TYPE IN edge.
    */
  def _localViaEvalTypeIn: Iterator[nodes.Local] = traversal.flatMap(_._localViaEvalTypeIn)

  /** Traverse to MEMBER via EVAL_TYPE IN edge.
    */
  def _memberViaEvalTypeIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaEvalTypeIn)

  /** Traverse to METHOD_PARAMETER_IN via EVAL_TYPE IN edge.
    */
  def _methodParameterInViaEvalTypeIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaEvalTypeIn)

  /** Traverse to METHOD_PARAMETER_OUT via EVAL_TYPE IN edge.
    */
  def _methodParameterOutViaEvalTypeIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaEvalTypeIn)

  /** Traverse to METHOD_REF via EVAL_TYPE IN edge.
    */
  def _methodRefViaEvalTypeIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaEvalTypeIn)

  /** Traverse to METHOD_RETURN via EVAL_TYPE IN edge.
    */
  def _methodReturnViaEvalTypeIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaEvalTypeIn)

  /** Traverse to TYPE_ARGUMENT via AST OUT edge.
    */
  def _typeArgumentViaAstOut: Iterator[nodes.TypeArgument] = traversal.flatMap(_._typeArgumentViaAstOut)

  /** Traverse to TYPE_ARGUMENT via REF IN edge.
    */
  def _typeArgumentViaRefIn: Iterator[nodes.TypeArgument] = traversal.flatMap(_._typeArgumentViaRefIn)

  /** Traverse to TYPE_DECL via INHERITS_FROM IN edge.
    */
  def _typeDeclViaInheritsFromIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaInheritsFromIn)

  /** Traverse to TYPE_REF via EVAL_TYPE IN edge.
    */
  def _typeRefViaEvalTypeIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaEvalTypeIn)

  /** Traverse to UNKNOWN via EVAL_TYPE IN edge.
    */
  def _unknownViaEvalTypeIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaEvalTypeIn)

  /** Direct alias type declarations. Traverse to TYPE_DECL via ALIAS_OF IN edge.
    */
  def aliasTypeDecl: Iterator[nodes.TypeDecl] = traversal.flatMap(_.aliasTypeDecl)

  /** Type declaration which is referenced by this type. Traverse to TYPE_DECL via REF OUT edge.
    */
  def referencedTypeDecl: Iterator[nodes.TypeDecl] = traversal.flatMap(_.referencedTypeDecl)

}
