package io.shiftleft.codepropertygraph.generated.neighboraccessors
import io.joern.odb2
import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.nodes

object Lang extends Conversions

trait Conversions {
  import Accessors.*

  implicit def accessNeighborsForAnnotation(node: nodes.Annotation): AccessNeighborsForAnnotation =
    new AccessNeighborsForAnnotation(node)

  implicit def accessNeighborsForAnnotationTraversal(traversal: Iterator[nodes.Annotation]): AccessNeighborsForAnnotationTraversal =
    new AccessNeighborsForAnnotationTraversal(traversal)

  implicit def accessNeighborsForAnnotationLiteral(node: nodes.AnnotationLiteral): AccessNeighborsForAnnotationLiteral =
    new AccessNeighborsForAnnotationLiteral(node)

  implicit def accessNeighborsForAnnotationLiteralTraversal(
    traversal: Iterator[nodes.AnnotationLiteral]
  ): AccessNeighborsForAnnotationLiteralTraversal =
    new AccessNeighborsForAnnotationLiteralTraversal(traversal)

  implicit def accessNeighborsForAnnotationParameter(node: nodes.AnnotationParameter): AccessNeighborsForAnnotationParameter =
    new AccessNeighborsForAnnotationParameter(node)

  implicit def accessNeighborsForAnnotationParameterTraversal(
    traversal: Iterator[nodes.AnnotationParameter]
  ): AccessNeighborsForAnnotationParameterTraversal =
    new AccessNeighborsForAnnotationParameterTraversal(traversal)

  implicit def accessNeighborsForAnnotationParameterAssign(
    node: nodes.AnnotationParameterAssign
  ): AccessNeighborsForAnnotationParameterAssign =
    new AccessNeighborsForAnnotationParameterAssign(node)

  implicit def accessNeighborsForAnnotationParameterAssignTraversal(
    traversal: Iterator[nodes.AnnotationParameterAssign]
  ): AccessNeighborsForAnnotationParameterAssignTraversal =
    new AccessNeighborsForAnnotationParameterAssignTraversal(traversal)

  implicit def accessNeighborsForArrayInitializer(node: nodes.ArrayInitializer): AccessNeighborsForArrayInitializer =
    new AccessNeighborsForArrayInitializer(node)

  implicit def accessNeighborsForArrayInitializerTraversal(
    traversal: Iterator[nodes.ArrayInitializer]
  ): AccessNeighborsForArrayInitializerTraversal =
    new AccessNeighborsForArrayInitializerTraversal(traversal)

  implicit def accessNeighborsForBinding(node: nodes.Binding): AccessNeighborsForBinding =
    new AccessNeighborsForBinding(node)

  implicit def accessNeighborsForBindingTraversal(traversal: Iterator[nodes.Binding]): AccessNeighborsForBindingTraversal =
    new AccessNeighborsForBindingTraversal(traversal)

  implicit def accessNeighborsForBlock(node: nodes.Block): AccessNeighborsForBlock =
    new AccessNeighborsForBlock(node)

  implicit def accessNeighborsForBlockTraversal(traversal: Iterator[nodes.Block]): AccessNeighborsForBlockTraversal =
    new AccessNeighborsForBlockTraversal(traversal)

  implicit def accessNeighborsForCall(node: nodes.Call): AccessNeighborsForCall =
    new AccessNeighborsForCall(node)

  implicit def accessNeighborsForCallTraversal(traversal: Iterator[nodes.Call]): AccessNeighborsForCallTraversal =
    new AccessNeighborsForCallTraversal(traversal)

  implicit def accessNeighborsForClosureBinding(node: nodes.ClosureBinding): AccessNeighborsForClosureBinding =
    new AccessNeighborsForClosureBinding(node)

  implicit def accessNeighborsForClosureBindingTraversal(
    traversal: Iterator[nodes.ClosureBinding]
  ): AccessNeighborsForClosureBindingTraversal =
    new AccessNeighborsForClosureBindingTraversal(traversal)

  implicit def accessNeighborsForComment(node: nodes.Comment): AccessNeighborsForComment =
    new AccessNeighborsForComment(node)

  implicit def accessNeighborsForCommentTraversal(traversal: Iterator[nodes.Comment]): AccessNeighborsForCommentTraversal =
    new AccessNeighborsForCommentTraversal(traversal)

  implicit def accessNeighborsForControlStructure(node: nodes.ControlStructure): AccessNeighborsForControlStructure =
    new AccessNeighborsForControlStructure(node)

  implicit def accessNeighborsForControlStructureTraversal(
    traversal: Iterator[nodes.ControlStructure]
  ): AccessNeighborsForControlStructureTraversal =
    new AccessNeighborsForControlStructureTraversal(traversal)

  implicit def accessNeighborsForDependency(node: nodes.Dependency): AccessNeighborsForDependency =
    new AccessNeighborsForDependency(node)

  implicit def accessNeighborsForDependencyTraversal(traversal: Iterator[nodes.Dependency]): AccessNeighborsForDependencyTraversal =
    new AccessNeighborsForDependencyTraversal(traversal)

  implicit def accessNeighborsForFieldIdentifier(node: nodes.FieldIdentifier): AccessNeighborsForFieldIdentifier =
    new AccessNeighborsForFieldIdentifier(node)

  implicit def accessNeighborsForFieldIdentifierTraversal(
    traversal: Iterator[nodes.FieldIdentifier]
  ): AccessNeighborsForFieldIdentifierTraversal =
    new AccessNeighborsForFieldIdentifierTraversal(traversal)

  implicit def accessNeighborsForFile(node: nodes.File): AccessNeighborsForFile =
    new AccessNeighborsForFile(node)

  implicit def accessNeighborsForFileTraversal(traversal: Iterator[nodes.File]): AccessNeighborsForFileTraversal =
    new AccessNeighborsForFileTraversal(traversal)

  implicit def accessNeighborsForIdentifier(node: nodes.Identifier): AccessNeighborsForIdentifier =
    new AccessNeighborsForIdentifier(node)

  implicit def accessNeighborsForIdentifierTraversal(traversal: Iterator[nodes.Identifier]): AccessNeighborsForIdentifierTraversal =
    new AccessNeighborsForIdentifierTraversal(traversal)

  implicit def accessNeighborsForImport(node: nodes.Import): AccessNeighborsForImport =
    new AccessNeighborsForImport(node)

  implicit def accessNeighborsForImportTraversal(traversal: Iterator[nodes.Import]): AccessNeighborsForImportTraversal =
    new AccessNeighborsForImportTraversal(traversal)

  implicit def accessNeighborsForJumpLabel(node: nodes.JumpLabel): AccessNeighborsForJumpLabel =
    new AccessNeighborsForJumpLabel(node)

  implicit def accessNeighborsForJumpLabelTraversal(traversal: Iterator[nodes.JumpLabel]): AccessNeighborsForJumpLabelTraversal =
    new AccessNeighborsForJumpLabelTraversal(traversal)

  implicit def accessNeighborsForJumpTarget(node: nodes.JumpTarget): AccessNeighborsForJumpTarget =
    new AccessNeighborsForJumpTarget(node)

  implicit def accessNeighborsForJumpTargetTraversal(traversal: Iterator[nodes.JumpTarget]): AccessNeighborsForJumpTargetTraversal =
    new AccessNeighborsForJumpTargetTraversal(traversal)

  implicit def accessNeighborsForLiteral(node: nodes.Literal): AccessNeighborsForLiteral =
    new AccessNeighborsForLiteral(node)

  implicit def accessNeighborsForLiteralTraversal(traversal: Iterator[nodes.Literal]): AccessNeighborsForLiteralTraversal =
    new AccessNeighborsForLiteralTraversal(traversal)

  implicit def accessNeighborsForLocal(node: nodes.Local): AccessNeighborsForLocal =
    new AccessNeighborsForLocal(node)

  implicit def accessNeighborsForLocalTraversal(traversal: Iterator[nodes.Local]): AccessNeighborsForLocalTraversal =
    new AccessNeighborsForLocalTraversal(traversal)

  implicit def accessNeighborsForMember(node: nodes.Member): AccessNeighborsForMember =
    new AccessNeighborsForMember(node)

  implicit def accessNeighborsForMemberTraversal(traversal: Iterator[nodes.Member]): AccessNeighborsForMemberTraversal =
    new AccessNeighborsForMemberTraversal(traversal)

  implicit def accessNeighborsForMethod(node: nodes.Method): AccessNeighborsForMethod =
    new AccessNeighborsForMethod(node)

  implicit def accessNeighborsForMethodTraversal(traversal: Iterator[nodes.Method]): AccessNeighborsForMethodTraversal =
    new AccessNeighborsForMethodTraversal(traversal)

  implicit def accessNeighborsForMethodParameterIn(node: nodes.MethodParameterIn): AccessNeighborsForMethodParameterIn =
    new AccessNeighborsForMethodParameterIn(node)

  implicit def accessNeighborsForMethodParameterInTraversal(
    traversal: Iterator[nodes.MethodParameterIn]
  ): AccessNeighborsForMethodParameterInTraversal =
    new AccessNeighborsForMethodParameterInTraversal(traversal)

  implicit def accessNeighborsForMethodParameterOut(node: nodes.MethodParameterOut): AccessNeighborsForMethodParameterOut =
    new AccessNeighborsForMethodParameterOut(node)

  implicit def accessNeighborsForMethodParameterOutTraversal(
    traversal: Iterator[nodes.MethodParameterOut]
  ): AccessNeighborsForMethodParameterOutTraversal =
    new AccessNeighborsForMethodParameterOutTraversal(traversal)

  implicit def accessNeighborsForMethodRef(node: nodes.MethodRef): AccessNeighborsForMethodRef =
    new AccessNeighborsForMethodRef(node)

  implicit def accessNeighborsForMethodRefTraversal(traversal: Iterator[nodes.MethodRef]): AccessNeighborsForMethodRefTraversal =
    new AccessNeighborsForMethodRefTraversal(traversal)

  implicit def accessNeighborsForMethodReturn(node: nodes.MethodReturn): AccessNeighborsForMethodReturn =
    new AccessNeighborsForMethodReturn(node)

  implicit def accessNeighborsForMethodReturnTraversal(traversal: Iterator[nodes.MethodReturn]): AccessNeighborsForMethodReturnTraversal =
    new AccessNeighborsForMethodReturnTraversal(traversal)

  implicit def accessNeighborsForModifier(node: nodes.Modifier): AccessNeighborsForModifier =
    new AccessNeighborsForModifier(node)

  implicit def accessNeighborsForModifierTraversal(traversal: Iterator[nodes.Modifier]): AccessNeighborsForModifierTraversal =
    new AccessNeighborsForModifierTraversal(traversal)

  implicit def accessNeighborsForNamespace(node: nodes.Namespace): AccessNeighborsForNamespace =
    new AccessNeighborsForNamespace(node)

  implicit def accessNeighborsForNamespaceTraversal(traversal: Iterator[nodes.Namespace]): AccessNeighborsForNamespaceTraversal =
    new AccessNeighborsForNamespaceTraversal(traversal)

  implicit def accessNeighborsForNamespaceBlock(node: nodes.NamespaceBlock): AccessNeighborsForNamespaceBlock =
    new AccessNeighborsForNamespaceBlock(node)

  implicit def accessNeighborsForNamespaceBlockTraversal(
    traversal: Iterator[nodes.NamespaceBlock]
  ): AccessNeighborsForNamespaceBlockTraversal =
    new AccessNeighborsForNamespaceBlockTraversal(traversal)

  implicit def accessNeighborsForReturn(node: nodes.Return): AccessNeighborsForReturn =
    new AccessNeighborsForReturn(node)

  implicit def accessNeighborsForReturnTraversal(traversal: Iterator[nodes.Return]): AccessNeighborsForReturnTraversal =
    new AccessNeighborsForReturnTraversal(traversal)

  implicit def accessNeighborsForTag(node: nodes.Tag): AccessNeighborsForTag =
    new AccessNeighborsForTag(node)

  implicit def accessNeighborsForTagTraversal(traversal: Iterator[nodes.Tag]): AccessNeighborsForTagTraversal =
    new AccessNeighborsForTagTraversal(traversal)

  implicit def accessNeighborsForTemplateDom(node: nodes.TemplateDom): AccessNeighborsForTemplateDom =
    new AccessNeighborsForTemplateDom(node)

  implicit def accessNeighborsForTemplateDomTraversal(traversal: Iterator[nodes.TemplateDom]): AccessNeighborsForTemplateDomTraversal =
    new AccessNeighborsForTemplateDomTraversal(traversal)

  implicit def accessNeighborsForType(node: nodes.Type): AccessNeighborsForType =
    new AccessNeighborsForType(node)

  implicit def accessNeighborsForTypeTraversal(traversal: Iterator[nodes.Type]): AccessNeighborsForTypeTraversal =
    new AccessNeighborsForTypeTraversal(traversal)

  implicit def accessNeighborsForTypeArgument(node: nodes.TypeArgument): AccessNeighborsForTypeArgument =
    new AccessNeighborsForTypeArgument(node)

  implicit def accessNeighborsForTypeArgumentTraversal(traversal: Iterator[nodes.TypeArgument]): AccessNeighborsForTypeArgumentTraversal =
    new AccessNeighborsForTypeArgumentTraversal(traversal)

  implicit def accessNeighborsForTypeDecl(node: nodes.TypeDecl): AccessNeighborsForTypeDecl =
    new AccessNeighborsForTypeDecl(node)

  implicit def accessNeighborsForTypeDeclTraversal(traversal: Iterator[nodes.TypeDecl]): AccessNeighborsForTypeDeclTraversal =
    new AccessNeighborsForTypeDeclTraversal(traversal)

  implicit def accessNeighborsForTypeParameter(node: nodes.TypeParameter): AccessNeighborsForTypeParameter =
    new AccessNeighborsForTypeParameter(node)

  implicit def accessNeighborsForTypeParameterTraversal(
    traversal: Iterator[nodes.TypeParameter]
  ): AccessNeighborsForTypeParameterTraversal =
    new AccessNeighborsForTypeParameterTraversal(traversal)

  implicit def accessNeighborsForTypeRef(node: nodes.TypeRef): AccessNeighborsForTypeRef =
    new AccessNeighborsForTypeRef(node)

  implicit def accessNeighborsForTypeRefTraversal(traversal: Iterator[nodes.TypeRef]): AccessNeighborsForTypeRefTraversal =
    new AccessNeighborsForTypeRefTraversal(traversal)

  implicit def accessNeighborsForUnknown(node: nodes.Unknown): AccessNeighborsForUnknown =
    new AccessNeighborsForUnknown(node)

  implicit def accessNeighborsForUnknownTraversal(traversal: Iterator[nodes.Unknown]): AccessNeighborsForUnknownTraversal =
    new AccessNeighborsForUnknownTraversal(traversal)

  implicit def accessNeighborsForCfgNode(node: nodes.CfgNode): AccessNeighborsForCfgNode =
    new AccessNeighborsForCfgNode(node)

  implicit def accessNeighborsForCfgNodeTraversal(traversal: Iterator[nodes.CfgNode]): AccessNeighborsForCfgNodeTraversal =
    new AccessNeighborsForCfgNodeTraversal(traversal)

  implicit def accessNeighborsForExpression(node: nodes.Expression): AccessNeighborsForExpression =
    new AccessNeighborsForExpression(node)

  implicit def accessNeighborsForExpressionTraversal(traversal: Iterator[nodes.Expression]): AccessNeighborsForExpressionTraversal =
    new AccessNeighborsForExpressionTraversal(traversal)
}

object Accessors {
  import Lang.*

  final class AccessNeighborsForAnnotation(val node: nodes.Annotation) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
      */
    def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
      node._astOut.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to IDENTIFIER via AST IN edge.
      */
    def _identifierViaAstIn: Iterator[nodes.Identifier] = node._astIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via AST IN edge.
      */
    def _literalViaAstIn: Iterator[nodes.Literal] = node._astIn.iterator.collectAll[nodes.Literal]

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via AST IN edge.
      */
    def _methodRefViaAstIn: Iterator[nodes.MethodRef] = node._astIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForAnnotationTraversal(val traversal: Iterator[nodes.Annotation]) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      traversal.flatMap(_._annotationParameterAssignViaAstIn)

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST OUT edge.
      */
    def _annotationParameterAssignViaAstOut: Iterator[nodes.AnnotationParameterAssign] =
      traversal.flatMap(_._annotationParameterAssignViaAstOut)

    /** Traverse to IDENTIFIER via AST IN edge.
      */
    def _identifierViaAstIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstIn)

    /** Traverse to LITERAL via AST IN edge.
      */
    def _literalViaAstIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstIn)

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstIn)

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstIn)

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaAstIn)

    /** Traverse to METHOD_REF via AST IN edge.
      */
    def _methodRefViaAstIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstIn)

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

  }

  final class AccessNeighborsForAnnotationLiteral(val node: nodes.AnnotationLiteral) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  }

  final class AccessNeighborsForAnnotationLiteralTraversal(val traversal: Iterator[nodes.AnnotationLiteral]) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      traversal.flatMap(_._annotationParameterAssignViaAstIn)

  }

  final class AccessNeighborsForAnnotationParameter(val node: nodes.AnnotationParameter) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

  }

  final class AccessNeighborsForAnnotationParameterTraversal(val traversal: Iterator[nodes.AnnotationParameter]) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      traversal.flatMap(_._annotationParameterAssignViaAstIn)

  }

  final class AccessNeighborsForAnnotationParameterAssign(val node: nodes.AnnotationParameterAssign) extends AnyVal {

    /** Traverse to ANNOTATION via AST IN edge.
      */
    def _annotationViaAstIn: Iterator[nodes.Annotation] = node._astIn.iterator.collectAll[nodes.Annotation]

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to ANNOTATION_LITERAL via AST OUT edge.
      */
    def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = node._astOut.iterator.collectAll[nodes.AnnotationLiteral]

    /** Traverse to ANNOTATION_PARAMETER via AST OUT edge.
      */
    def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = node._astOut.iterator.collectAll[nodes.AnnotationParameter]

    /** Traverse to ARRAY_INITIALIZER via AST OUT edge.
      */
    def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = node._astOut.iterator.collectAll[nodes.ArrayInitializer]

  }

  final class AccessNeighborsForAnnotationParameterAssignTraversal(val traversal: Iterator[nodes.AnnotationParameterAssign])
      extends AnyVal {

    /** Traverse to ANNOTATION via AST IN edge.
      */
    def _annotationViaAstIn: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstIn)

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to ANNOTATION_LITERAL via AST OUT edge.
      */
    def _annotationLiteralViaAstOut: Iterator[nodes.AnnotationLiteral] = traversal.flatMap(_._annotationLiteralViaAstOut)

    /** Traverse to ANNOTATION_PARAMETER via AST OUT edge.
      */
    def _annotationParameterViaAstOut: Iterator[nodes.AnnotationParameter] = traversal.flatMap(_._annotationParameterViaAstOut)

    /** Traverse to ARRAY_INITIALIZER via AST OUT edge.
      */
    def _arrayInitializerViaAstOut: Iterator[nodes.ArrayInitializer] = traversal.flatMap(_._arrayInitializerViaAstOut)

  }

  final class AccessNeighborsForArrayInitializer(val node: nodes.ArrayInitializer) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      node._astIn.iterator.collectAll[nodes.AnnotationParameterAssign]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForArrayInitializerTraversal(val traversal: Iterator[nodes.ArrayInitializer]) extends AnyVal {

    /** Traverse to ANNOTATION_PARAMETER_ASSIGN via AST IN edge.
      */
    def _annotationParameterAssignViaAstIn: Iterator[nodes.AnnotationParameterAssign] =
      traversal.flatMap(_._annotationParameterAssignViaAstIn)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

  }

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

  final class AccessNeighborsForBlock(val node: nodes.Block) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: nodes.Block = {
      try { node._astIn.iterator.collectAll[nodes.Block].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent BLOCK is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF OUT edge.
      */
    def _blockViaReachingDefOut: Iterator[nodes.Block] = node._reachingDefOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IMPORT via AST OUT edge.
      */
    def _importViaAstOut: Iterator[nodes.Import] = node._astOut.iterator.collectAll[nodes.Import]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this BLOCK node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
      */
    def local: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

  }

  final class AccessNeighborsForBlockTraversal(val traversal: Iterator[nodes.Block]) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.map(_._blockViaAstIn)

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstOut)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to BLOCK via REACHING_DEF OUT edge.
      */
    def _blockViaReachingDefOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to IMPORT via AST OUT edge.
      */
    def _importViaAstOut: Iterator[nodes.Import] = traversal.flatMap(_._importViaAstOut)

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaAstOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = traversal.flatMap(_._localViaAstOut)

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstOut)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaAstOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to locals of this block. Traverse to LOCAL via AST OUT edge.
      */
    def local: Iterator[nodes.Local] = traversal.flatMap(_.local)

  }

  final class AccessNeighborsForCall(val node: nodes.Call) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Iterator[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via RECEIVER OUT edge.
      */
    def _blockViaReceiverOut: Option[nodes.Block] = node._receiverOut.iterator.collectAll[nodes.Block].nextOption()

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Iterator[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via RECEIVER OUT edge.
      */
    def _callViaReceiverOut: Option[nodes.Call] = node._receiverOut.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this CALL node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via RECEIVER OUT edge.
      */
    def _controlStructureViaReceiverOut: Iterator[nodes.ControlStructure] = node._receiverOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via ARGUMENT OUT edge.
      */
    def _fieldIdentifierViaArgumentOut: Iterator[nodes.FieldIdentifier] = node._argumentOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Iterator[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via RECEIVER OUT edge.
      */
    def _identifierViaReceiverOut: Option[nodes.Identifier] = node._receiverOut.iterator.collectAll[nodes.Identifier].nextOption()

    /** Traverse to IMPORT via IS_CALL_FOR_IMPORT OUT edge.
      */
    def _importViaIsCallForImportOut: Iterator[nodes.Import] = node._isCallForImportOut.iterator.collectAll[nodes.Import]

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Iterator[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via RECEIVER OUT edge.
      */
    def _literalViaReceiverOut: Option[nodes.Literal] = node._receiverOut.iterator.collectAll[nodes.Literal].nextOption()

    /** Traverse to METHOD via CALL OUT edge.
      */
    def _methodViaCallOut: Iterator[nodes.Method] = node._callOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Iterator[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via RECEIVER OUT edge.
      */
    def _methodRefViaReceiverOut: Option[nodes.MethodRef] = node._receiverOut.iterator.collectAll[nodes.MethodRef].nextOption()

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via RECEIVER OUT edge.
      */
    def _typeRefViaReceiverOut: Iterator[nodes.TypeRef] = node._receiverOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via RECEIVER OUT edge.
      */
    def _unknownViaReceiverOut: Iterator[nodes.Unknown] = node._receiverOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to referenced members Traverse to MEMBER via REF OUT edge.
      */
    def referencedMember: Iterator[nodes.Member] = node._refOut.iterator.collectAll[nodes.Member]

  }

  final class AccessNeighborsForCallTraversal(val traversal: Iterator[nodes.Call]) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaArgumentOut)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstOut)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to BLOCK via RECEIVER OUT edge.
      */
    def _blockViaReceiverOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReceiverOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentOut)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CALL via RECEIVER OUT edge.
      */
    def _callViaReceiverOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverOut)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaArgumentOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.map(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to CONTROL_STRUCTURE via RECEIVER OUT edge.
      */
    def _controlStructureViaReceiverOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReceiverOut)

    /** Traverse to FIELD_IDENTIFIER via ARGUMENT OUT edge.
      */
    def _fieldIdentifierViaArgumentOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaArgumentOut)

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaAstOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaArgumentOut)

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to IDENTIFIER via RECEIVER OUT edge.
      */
    def _identifierViaReceiverOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReceiverOut)

    /** Traverse to IMPORT via IS_CALL_FOR_IMPORT OUT edge.
      */
    def _importViaIsCallForImportOut: Iterator[nodes.Import] = traversal.flatMap(_._importViaIsCallForImportOut)

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaArgumentOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaArgumentOut)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to LITERAL via RECEIVER OUT edge.
      */
    def _literalViaReceiverOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReceiverOut)

    /** Traverse to METHOD via CALL OUT edge.
      */
    def _methodViaCallOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaCallOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaArgumentOut)

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_REF via RECEIVER OUT edge.
      */
    def _methodRefViaReceiverOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReceiverOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstOut)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaArgumentOut)

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaAstOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to TYPE_REF via RECEIVER OUT edge.
      */
    def _typeRefViaReceiverOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReceiverOut)

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaArgumentOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

    /** Traverse to UNKNOWN via RECEIVER OUT edge.
      */
    def _unknownViaReceiverOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReceiverOut)

    /** Traverse to referenced members Traverse to MEMBER via REF OUT edge.
      */
    def referencedMember: Iterator[nodes.Member] = traversal.flatMap(_.referencedMember)

  }

  final class AccessNeighborsForClosureBinding(val node: nodes.ClosureBinding) extends AnyVal {

    /** Traverse to LOCAL via CAPTURED_BY IN edge.
      */
    def _localViaCapturedByIn: Iterator[nodes.Local] = node._capturedByIn.iterator.collectAll[nodes.Local]

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: nodes.Local = {
      try { node._refOut.iterator.collectAll[nodes.Local].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent LOCAL is mandatory, but not defined for this CLOSURE_BINDING node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = node._refOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via CAPTURE IN edge.
      */
    def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = node._captureIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_REF via CAPTURE IN edge.
      */
    def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = node._captureIn.iterator.collectAll[nodes.TypeRef]

  }

  final class AccessNeighborsForClosureBindingTraversal(val traversal: Iterator[nodes.ClosureBinding]) extends AnyVal {

    /** Traverse to LOCAL via CAPTURED_BY IN edge.
      */
    def _localViaCapturedByIn: Iterator[nodes.Local] = traversal.flatMap(_._localViaCapturedByIn)

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: Iterator[nodes.Local] = traversal.map(_._localViaRefOut)

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaRefOut)

    /** Traverse to METHOD_REF via CAPTURE IN edge.
      */
    def _methodRefViaCaptureIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCaptureIn)

    /** Traverse to TYPE_REF via CAPTURE IN edge.
      */
    def _typeRefViaCaptureIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCaptureIn)

  }

  final class AccessNeighborsForComment(val node: nodes.Comment) extends AnyVal {

    /** Traverse to COMMENT via SOURCE_FILE IN edge.
      */
    def _commentViaSourceFileIn: Iterator[nodes.Comment] = node._sourceFileIn.iterator.collectAll[nodes.Comment]

    /** Traverse to COMMENT via SOURCE_FILE OUT edge.
      */
    def file: Iterator[nodes.Comment] = node._sourceFileOut.iterator.collectAll[nodes.Comment]

    /** Traverse to FILE via AST IN edge.
      */
    def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

  }

  final class AccessNeighborsForCommentTraversal(val traversal: Iterator[nodes.Comment]) extends AnyVal {

    /** Traverse to COMMENT via SOURCE_FILE IN edge.
      */
    def _commentViaSourceFileIn: Iterator[nodes.Comment] = traversal.flatMap(_._commentViaSourceFileIn)

    /** Traverse to COMMENT via SOURCE_FILE OUT edge.
      */
    def file: Iterator[nodes.Comment] = traversal.flatMap(_.file)

    /** Traverse to FILE via AST IN edge.
      */
    def _fileViaAstIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaAstIn)

  }

  final class AccessNeighborsForControlStructure(val node: nodes.ControlStructure) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CONDITION OUT edge.
      */
    def _blockViaConditionOut: Iterator[nodes.Block] = node._conditionOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CONDITION OUT edge.
      */
    def _callViaConditionOut: Iterator[nodes.Call] = node._conditionOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION OUT edge.
      */
    def _controlStructureViaConditionOut: Iterator[nodes.ControlStructure] = node._conditionOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CONDITION OUT edge.
      */
    def _identifierViaConditionOut: Iterator[nodes.Identifier] = node._conditionOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_LABEL via AST OUT edge.
      */
    def _jumpLabelViaAstOut: Iterator[nodes.JumpLabel] = node._astOut.iterator.collectAll[nodes.JumpLabel]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CONDITION OUT edge.
      */
    def _jumpTargetViaConditionOut: Iterator[nodes.JumpTarget] = node._conditionOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CONDITION OUT edge.
      */
    def _literalViaConditionOut: Iterator[nodes.Literal] = node._conditionOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CONDITION OUT edge.
      */
    def _methodRefViaConditionOut: Iterator[nodes.MethodRef] = node._conditionOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CONDITION OUT edge.
      */
    def _returnViaConditionOut: Iterator[nodes.Return] = node._conditionOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CONDITION OUT edge.
      */
    def _typeRefViaConditionOut: Iterator[nodes.TypeRef] = node._conditionOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CONDITION OUT edge.
      */
    def _unknownViaConditionOut: Iterator[nodes.Unknown] = node._conditionOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForControlStructureTraversal(val traversal: Iterator[nodes.ControlStructure]) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstOut)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via CONDITION OUT edge.
      */
    def _blockViaConditionOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaConditionOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via CONDITION OUT edge.
      */
    def _callViaConditionOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaConditionOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via CONDITION OUT edge.
      */
    def _controlStructureViaConditionOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionOut)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via CONDITION OUT edge.
      */
    def _identifierViaConditionOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaConditionOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_LABEL via AST OUT edge.
      */
    def _jumpLabelViaAstOut: Iterator[nodes.JumpLabel] = traversal.flatMap(_._jumpLabelViaAstOut)

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaAstOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via CONDITION OUT edge.
      */
    def _jumpTargetViaConditionOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaConditionOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via CONDITION OUT edge.
      */
    def _literalViaConditionOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaConditionOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = traversal.flatMap(_._localViaAstOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via CONDITION OUT edge.
      */
    def _methodRefViaConditionOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaConditionOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstOut)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via CONDITION OUT edge.
      */
    def _returnViaConditionOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaConditionOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaAstOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via CONDITION OUT edge.
      */
    def _typeRefViaConditionOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaConditionOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via CONDITION OUT edge.
      */
    def _unknownViaConditionOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaConditionOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

  }

  final class AccessNeighborsForDependency(val node: nodes.Dependency) extends AnyVal {

    /** Traverse to IMPORT via IMPORTS IN edge.
      */
    def _importViaImportsIn: Iterator[nodes.Import] = node._importsIn.iterator.collectAll[nodes.Import]

  }

  final class AccessNeighborsForDependencyTraversal(val traversal: Iterator[nodes.Dependency]) extends AnyVal {

    /** Traverse to IMPORT via IMPORTS IN edge.
      */
    def _importViaImportsIn: Iterator[nodes.Import] = traversal.flatMap(_._importViaImportsIn)

  }

  final class AccessNeighborsForFieldIdentifier(val node: nodes.FieldIdentifier) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: nodes.Call = {
      try { node._argumentIn.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label ARGUMENT to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: nodes.Call = {
      try { node._astIn.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CFG OUT edge.
      */
    def _callViaCfgOut: nodes.Call = {
      try { node._cfgOut.iterator.collectAll[nodes.Call].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label CFG to an adjacent CALL is mandatory, but not defined for this FIELD_IDENTIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForFieldIdentifierTraversal(val traversal: Iterator[nodes.FieldIdentifier]) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.map(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.map(_._callViaAstIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via CFG OUT edge.
      */
    def _callViaCfgOut: Iterator[nodes.Call] = traversal.map(_._callViaCfgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

  }

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

  final class AccessNeighborsForFileTraversal(val traversal: Iterator[nodes.File]) extends AnyVal {

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

  final class AccessNeighborsForIdentifier(val node: nodes.Identifier) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: Option[nodes.Local] = node._refOut.iterator.collectAll[nodes.Local].nextOption()

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Option[nodes.MethodParameterIn] =
      node._refOut.iterator.collectAll[nodes.MethodParameterIn].nextOption()

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForIdentifierTraversal(val traversal: Iterator[nodes.Identifier]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to LOCAL via REF OUT edge.
      */
    def _localViaRefOut: Iterator[nodes.Local] = traversal.flatMap(_._localViaRefOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REF OUT edge.
      */
    def _methodParameterInViaRefOut: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaRefOut)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

  }

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

  final class AccessNeighborsForJumpLabel(val node: nodes.JumpLabel) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

  }

  final class AccessNeighborsForJumpLabelTraversal(val traversal: Iterator[nodes.JumpLabel]) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

  }

  final class AccessNeighborsForJumpTarget(val node: nodes.JumpTarget) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForJumpTargetTraversal(val traversal: Iterator[nodes.JumpTarget]) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

  }

  final class AccessNeighborsForLiteral(val node: nodes.Literal) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to ARRAY_INITIALIZER via AST IN edge.
      */
    def _arrayInitializerViaAstIn: Iterator[nodes.ArrayInitializer] = node._astIn.iterator.collectAll[nodes.ArrayInitializer]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this LITERAL node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForLiteralTraversal(val traversal: Iterator[nodes.Literal]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to ARRAY_INITIALIZER via AST IN edge.
      */
    def _arrayInitializerViaAstIn: Iterator[nodes.ArrayInitializer] = traversal.flatMap(_._arrayInitializerViaAstIn)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.map(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

  }

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

  final class AccessNeighborsForMember(val node: nodes.Member) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to CALL via REF IN edge.
      */
    def _callViaRefIn: Iterator[nodes.Call] = node._refIn.iterator.collectAll[nodes.Call]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
      */
    def typeDecl: nodes.TypeDecl = {
      try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MEMBER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForMemberTraversal(val traversal: Iterator[nodes.Member]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to CALL via REF IN edge.
      */
    def _callViaRefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaRefIn)

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** The type declaration this member is defined in Traverse to TYPE_DECL via AST IN edge.
      */
    def typeDecl: Iterator[nodes.TypeDecl] = traversal.map(_.typeDecl)

    /** Traverse to member type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = traversal.flatMap(_.typ)

  }

  final class AccessNeighborsForMethod(val node: nodes.Method) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BINDING via REF IN edge.
      */
    def _bindingViaRefIn: Iterator[nodes.Binding] = node._refIn.iterator.collectAll[nodes.Binding]

    /** Traverse to BLOCK via CONTAINS OUT edge.
      */
    def _blockViaContainsOut: Iterator[nodes.Block] = node._containsOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CALL IN edge.
      */
    def _callViaCallIn: Iterator[nodes.Call] = node._callIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CONTAINS OUT edge.
      */
    def _callViaContainsOut: Iterator[nodes.Call] = node._containsOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CONTAINS OUT edge.
      */
    def _controlStructureViaContainsOut: Iterator[nodes.ControlStructure] = node._containsOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CONTAINS OUT edge.
      */
    def _fieldIdentifierViaContainsOut: Iterator[nodes.FieldIdentifier] = node._containsOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    /** Traverse to FILE via SOURCE_FILE OUT edge.
      */
    def _fileViaSourceFileOut: Iterator[nodes.File] = node._sourceFileOut.iterator.collectAll[nodes.File]

    /** Traverse to IDENTIFIER via CONTAINS OUT edge.
      */
    def _identifierViaContainsOut: Iterator[nodes.Identifier] = node._containsOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CONTAINS OUT edge.
      */
    def _jumpTargetViaContainsOut: Iterator[nodes.JumpTarget] = node._containsOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Option[nodes.Method] = node._astIn.iterator.collectAll[nodes.Method].nextOption()

    /** Traverse to METHOD via AST OUT edge.
      */
    def _methodViaAstOut: Iterator[nodes.Method] = node._astOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF OUT edge.
      */
    def _methodParameterInViaReachingDefOut: Iterator[nodes.MethodParameterIn] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via AST OUT edge.
      */
    def _methodParameterOutViaAstOut: Iterator[nodes.MethodParameterOut] = node._astOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CONTAINS OUT edge.
      */
    def _methodRefViaContainsOut: Iterator[nodes.MethodRef] = node._containsOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REF IN edge.
      */
    def _methodRefViaRefIn: Iterator[nodes.MethodRef] = node._refIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Option[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn].nextOption()

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to NAMESPACE_BLOCK via AST IN edge.
      */
    def _namespaceBlockViaAstIn: Option[nodes.NamespaceBlock] = node._astIn.iterator.collectAll[nodes.NamespaceBlock].nextOption()

    /** Traverse to RETURN via CONTAINS OUT edge.
      */
    def _returnViaContainsOut: Iterator[nodes.Return] = node._containsOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
      */
    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = node._containsOut.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Option[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl].nextOption()

    /** Traverse to TYPE_DECL via AST OUT edge.
      */
    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = node._astOut.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_DECL via CONTAINS IN edge.
      */
    def _typeDeclViaContainsIn: Iterator[nodes.TypeDecl] = node._containsIn.iterator.collectAll[nodes.TypeDecl]

    /** Traverse to TYPE_PARAMETER via AST OUT edge.
      */
    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = node._astOut.iterator.collectAll[nodes.TypeParameter]

    /** Traverse to TYPE_REF via CONTAINS OUT edge.
      */
    def _typeRefViaContainsOut: Iterator[nodes.TypeRef] = node._containsOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CONTAINS OUT edge.
      */
    def _unknownViaContainsOut: Iterator[nodes.Unknown] = node._containsOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** First control flow graph node Traverse to CFG_NODE via CFG OUT edge.
      */
    def cfgFirst: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Formal return parameters Traverse to METHOD_RETURN via AST OUT edge.
      */
    def methodReturn: nodes.MethodReturn = {
      try { node._astOut.iterator.collectAll[nodes.MethodReturn].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent METHOD_RETURN is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

    /** Literals used in the method Traverse to LITERAL via CONTAINS OUT edge.
      */
    def literal: Iterator[nodes.Literal] = node._containsOut.iterator.collectAll[nodes.Literal]

    /** Parameters of the method Traverse to METHOD_PARAMETER_IN via AST OUT edge.
      */
    def parameter: Iterator[nodes.MethodParameterIn] = node._astOut.iterator.collectAll[nodes.MethodParameterIn]

    /** Root of the abstract syntax tree Traverse to BLOCK via AST OUT edge.
      */
    def block: nodes.Block = {
      try { node._astOut.iterator.collectAll[nodes.Block].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label AST to an adjacent BLOCK is mandatory, but not defined for this METHOD node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodTraversal(val traversal: Iterator[nodes.Method]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to BINDING via REF IN edge.
      */
    def _bindingViaRefIn: Iterator[nodes.Binding] = traversal.flatMap(_._bindingViaRefIn)

    /** Traverse to BLOCK via CONTAINS OUT edge.
      */
    def _blockViaContainsOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaContainsOut)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to CALL via CALL IN edge.
      */
    def _callViaCallIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCallIn)

    /** Traverse to CALL via CONTAINS OUT edge.
      */
    def _callViaContainsOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaContainsOut)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CONTROL_STRUCTURE via CONTAINS OUT edge.
      */
    def _controlStructureViaContainsOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaContainsOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via CONTAINS OUT edge.
      */
    def _fieldIdentifierViaContainsOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaContainsOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaContainsIn)

    /** Traverse to FILE via SOURCE_FILE OUT edge.
      */
    def _fileViaSourceFileOut: Iterator[nodes.File] = traversal.flatMap(_._fileViaSourceFileOut)

    /** Traverse to IDENTIFIER via CONTAINS OUT edge.
      */
    def _identifierViaContainsOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaContainsOut)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via CONTAINS OUT edge.
      */
    def _jumpTargetViaContainsOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaContainsOut)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstIn)

    /** Traverse to METHOD via AST OUT edge.
      */
    def _methodViaAstOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaAstOut)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF OUT edge.
      */
    def _methodParameterInViaReachingDefOut: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefOut)

    /** Traverse to METHOD_PARAMETER_OUT via AST OUT edge.
      */
    def _methodParameterOutViaAstOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaAstOut)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CONTAINS OUT edge.
      */
    def _methodRefViaContainsOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaContainsOut)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_REF via REF IN edge.
      */
    def _methodRefViaRefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaRefIn)

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCfgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

    /** Traverse to NAMESPACE_BLOCK via AST IN edge.
      */
    def _namespaceBlockViaAstIn: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_._namespaceBlockViaAstIn)

    /** Traverse to RETURN via CONTAINS OUT edge.
      */
    def _returnViaContainsOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaContainsOut)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TEMPLATE_DOM via CONTAINS OUT edge.
      */
    def _templateDomViaContainsOut: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaContainsOut)

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

    /** Traverse to TYPE_DECL via AST OUT edge.
      */
    def _typeDeclViaAstOut: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstOut)

    /** Traverse to TYPE_DECL via CONTAINS IN edge.
      */
    def _typeDeclViaContainsIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaContainsIn)

    /** Traverse to TYPE_PARAMETER via AST OUT edge.
      */
    def _typeParameterViaAstOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_._typeParameterViaAstOut)

    /** Traverse to TYPE_REF via CONTAINS OUT edge.
      */
    def _typeRefViaContainsOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaContainsOut)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via CONTAINS OUT edge.
      */
    def _unknownViaContainsOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaContainsOut)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** First control flow graph node Traverse to CFG_NODE via CFG OUT edge.
      */
    def cfgFirst: Iterator[nodes.CfgNode] = traversal.flatMap(_.cfgFirst)

    /** Formal return parameters Traverse to METHOD_RETURN via AST OUT edge.
      */
    def methodReturn: Iterator[nodes.MethodReturn] = traversal.map(_.methodReturn)

    /** Literals used in the method Traverse to LITERAL via CONTAINS OUT edge.
      */
    def literal: Iterator[nodes.Literal] = traversal.flatMap(_.literal)

    /** Parameters of the method Traverse to METHOD_PARAMETER_IN via AST OUT edge.
      */
    def parameter: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_.parameter)

    /** Root of the abstract syntax tree Traverse to BLOCK via AST OUT edge.
      */
    def block: Iterator[nodes.Block] = traversal.map(_.block)

  }

  final class AccessNeighborsForMethodParameterIn(val node: nodes.MethodParameterIn) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CLOSURE_BINDING via REF IN edge.
      */
    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = node._refIn.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Places (identifier) where this parameter is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def referencingIdentifiers: Iterator[nodes.Identifier] = node._refIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
      */
    def asOutput: Iterator[nodes.MethodParameterOut] = node._parameterLinkOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to method associated with this formal parameter Traverse to METHOD via AST IN edge.
      */
    def method: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: nodes.Type = {
      try { node._evalTypeOut.iterator.collectAll[nodes.Type].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label EVAL_TYPE to an adjacent TYPE is mandatory, but not defined for this METHOD_PARAMETER_IN node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodParameterInTraversal(val traversal: Iterator[nodes.MethodParameterIn]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CLOSURE_BINDING via REF IN edge.
      */
    def _closureBindingViaRefIn: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaRefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

    /** Places (identifier) where this parameter is being referenced Traverse to IDENTIFIER via REF IN edge.
      */
    def referencingIdentifiers: Iterator[nodes.Identifier] = traversal.flatMap(_.referencingIdentifiers)

    /** Traverse to corresponding formal output parameter Traverse to METHOD_PARAMETER_OUT via PARAMETER_LINK OUT edge.
      */
    def asOutput: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_.asOutput)

    /** Traverse to method associated with this formal parameter Traverse to METHOD via AST IN edge.
      */
    def method: Iterator[nodes.Method] = traversal.map(_.method)

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = traversal.map(_.typ)

  }

  final class AccessNeighborsForMethodParameterOut(val node: nodes.MethodParameterOut) extends AnyVal {

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def method: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_PARAMETER_OUT node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
      */
    def asInput: Iterator[nodes.MethodParameterIn] = node._parameterLinkIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

  }

  final class AccessNeighborsForMethodParameterOutTraversal(val traversal: Iterator[nodes.MethodParameterOut]) extends AnyVal {

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via AST IN edge.
      */
    def method: Iterator[nodes.Method] = traversal.map(_.method)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via PARAMETER_LINK IN edge.
      */
    def asInput: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_.asInput)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

    /** Traverse to parameter type Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def typ: Iterator[nodes.Type] = traversal.flatMap(_.typ)

  }

  final class AccessNeighborsForMethodRef(val node: nodes.MethodRef) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Option[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Option[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: nodes.ControlStructure = {
      try { node._astIn.iterator.collectAll[nodes.ControlStructure].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent CONTROL_STRUCTURE is mandatory, but not defined for this METHOD_REF node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to referenced method. Traverse to METHOD via REF OUT edge.
      */
    def referencedMethod: nodes.Method = {
      try { node._refOut.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label REF to an adjacent METHOD is mandatory, but not defined for this METHOD_REF node with seq=" + node.seq,
            e
          )
      }
    }

  }

  final class AccessNeighborsForMethodRefTraversal(val traversal: Iterator[nodes.MethodRef]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaCaptureOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.map(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCfgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

    /** Traverse to referenced method. Traverse to METHOD via REF OUT edge.
      */
    def referencedMethod: Iterator[nodes.Method] = traversal.map(_.referencedMethod)

  }

  final class AccessNeighborsForMethodReturn(val node: nodes.MethodReturn) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this METHOD_RETURN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to RETURN via CFG IN edge.
      */
    def toReturn: Iterator[nodes.Return] = node._cfgIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForMethodReturnTraversal(val traversal: Iterator[nodes.MethodReturn]) extends AnyVal {

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to RETURN via CFG IN edge.
      */
    def toReturn: Iterator[nodes.Return] = traversal.flatMap(_.toReturn)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

  }

  final class AccessNeighborsForModifier(val node: nodes.Modifier) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = node._astIn.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: nodes.TypeDecl = {
      try { node._astIn.iterator.collectAll[nodes.TypeDecl].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent TYPE_DECL is mandatory, but not defined for this MODIFIER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForModifierTraversal(val traversal: Iterator[nodes.Modifier]) extends AnyVal {

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to MEMBER via AST IN edge.
      */
    def _memberViaAstIn: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstIn)

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.map(_._typeDeclViaAstIn)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

  }

  final class AccessNeighborsForNamespace(val node: nodes.Namespace) extends AnyVal {

    /** Traverse to NAMESPACE_BLOCK via REF IN edge.
      */
    def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = node._refIn.iterator.collectAll[nodes.NamespaceBlock]

  }

  final class AccessNeighborsForNamespaceTraversal(val traversal: Iterator[nodes.Namespace]) extends AnyVal {

    /** Traverse to NAMESPACE_BLOCK via REF IN edge.
      */
    def _namespaceBlockViaRefIn: Iterator[nodes.NamespaceBlock] = traversal.flatMap(_._namespaceBlockViaRefIn)

  }

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

  final class AccessNeighborsForNamespaceBlockTraversal(val traversal: Iterator[nodes.NamespaceBlock]) extends AnyVal {

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

  final class AccessNeighborsForReturn(val node: nodes.Return) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Option[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block].nextOption()

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Option[nodes.Call] = node._argumentOut.iterator.collectAll[nodes.Call].nextOption()

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = node._argumentOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Option[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure].nextOption()

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Option[nodes.Identifier] = node._argumentOut.iterator.collectAll[nodes.Identifier].nextOption()

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = node._argumentOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Option[nodes.Literal] = node._argumentOut.iterator.collectAll[nodes.Literal].nextOption()

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Option[nodes.MethodRef] = node._argumentOut.iterator.collectAll[nodes.MethodRef].nextOption()

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = node._astOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: nodes.MethodReturn = {
      try { node._cfgOut.iterator.collectAll[nodes.MethodReturn].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "OUT edge with label CFG to an adjacent METHOD_RETURN is mandatory, but not defined for this RETURN node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via REACHING_DEF OUT edge.
      */
    def _methodReturnViaReachingDefOut: Iterator[nodes.MethodReturn] = node._reachingDefOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Option[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via ARGUMENT OUT edge.
      */
    def _returnViaArgumentOut: Option[nodes.Return] = node._argumentOut.iterator.collectAll[nodes.Return].nextOption()

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = node._argumentOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = node._astOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = node._argumentOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForReturnTraversal(val traversal: Iterator[nodes.Return]) extends AnyVal {

    /** Traverse to BLOCK via ARGUMENT OUT edge.
      */
    def _blockViaArgumentOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaArgumentOut)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstOut)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via ARGUMENT OUT edge.
      */
    def _callViaArgumentOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentOut)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CONTROL_STRUCTURE via ARGUMENT OUT edge.
      */
    def _controlStructureViaArgumentOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaArgumentOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via ARGUMENT OUT edge.
      */
    def _identifierViaArgumentOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaArgumentOut)

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via ARGUMENT OUT edge.
      */
    def _jumpTargetViaArgumentOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaArgumentOut)

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaAstOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via ARGUMENT OUT edge.
      */
    def _literalViaArgumentOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaArgumentOut)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via ARGUMENT OUT edge.
      */
    def _methodRefViaArgumentOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaArgumentOut)

    /** Traverse to METHOD_REF via AST OUT edge.
      */
    def _methodRefViaAstOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaAstOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = traversal.map(_._methodReturnViaCfgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to METHOD_RETURN via REACHING_DEF OUT edge.
      */
    def _methodReturnViaReachingDefOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaReachingDefOut)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via ARGUMENT OUT edge.
      */
    def _returnViaArgumentOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentOut)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE_REF via ARGUMENT OUT edge.
      */
    def _typeRefViaArgumentOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaArgumentOut)

    /** Traverse to TYPE_REF via AST OUT edge.
      */
    def _typeRefViaAstOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaAstOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via ARGUMENT OUT edge.
      */
    def _unknownViaArgumentOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaArgumentOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

  }

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
    def _methodParameterOutViaTaggedByIn: Iterator[nodes.MethodParameterOut] =
      node._taggedByIn.iterator.collectAll[nodes.MethodParameterOut]

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

  final class AccessNeighborsForTemplateDom(val node: nodes.TemplateDom) extends AnyVal {

    /** Traverse to EXPRESSION via ARGUMENT IN edge.
      */
    def _expressionViaArgumentIn: Iterator[nodes.Expression] = node._argumentIn.iterator.collectAll[nodes.Expression]

    /** Traverse to EXPRESSION via AST OUT edge.
      */
    def _expressionViaAstOut: Iterator[nodes.Expression] = node._astOut.iterator.collectAll[nodes.Expression]

    /** Traverse to EXPRESSION via REACHING_DEF OUT edge.
      */
    def _expressionViaReachingDefOut: Iterator[nodes.Expression] = node._reachingDefOut.iterator.collectAll[nodes.Expression]

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = node._containsIn.iterator.collectAll[nodes.File]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

  }

  final class AccessNeighborsForTemplateDomTraversal(val traversal: Iterator[nodes.TemplateDom]) extends AnyVal {

    /** Traverse to EXPRESSION via ARGUMENT IN edge.
      */
    def _expressionViaArgumentIn: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaArgumentIn)

    /** Traverse to EXPRESSION via AST OUT edge.
      */
    def _expressionViaAstOut: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaAstOut)

    /** Traverse to EXPRESSION via REACHING_DEF OUT edge.
      */
    def _expressionViaReachingDefOut: Iterator[nodes.Expression] = traversal.flatMap(_._expressionViaReachingDefOut)

    /** Traverse to FILE via CONTAINS IN edge.
      */
    def _fileViaContainsIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaContainsIn)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

  }

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
    def _methodParameterOutViaEvalTypeIn: Iterator[nodes.MethodParameterOut] =
      node._evalTypeIn.iterator.collectAll[nodes.MethodParameterOut]

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

  final class AccessNeighborsForTypeTraversal(val traversal: Iterator[nodes.Type]) extends AnyVal {

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

  final class AccessNeighborsForTypeArgument(val node: nodes.TypeArgument) extends AnyVal {

    /** Traverse to TYPE via AST IN edge.
      */
    def _typeViaAstIn: Iterator[nodes.Type] = node._astIn.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE via REF OUT edge.
      */
    def _typeViaRefOut: Iterator[nodes.Type] = node._refOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
      */
    def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = node._bindsToOut.iterator.collectAll[nodes.TypeParameter]

  }

  final class AccessNeighborsForTypeArgumentTraversal(val traversal: Iterator[nodes.TypeArgument]) extends AnyVal {

    /** Traverse to TYPE via AST IN edge.
      */
    def _typeViaAstIn: Iterator[nodes.Type] = traversal.flatMap(_._typeViaAstIn)

    /** Traverse to TYPE via REF OUT edge.
      */
    def _typeViaRefOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaRefOut)

    /** Traverse to TYPE_PARAMETER via BINDS_TO OUT edge.
      */
    def _typeParameterViaBindsToOut: Iterator[nodes.TypeParameter] = traversal.flatMap(_._typeParameterViaBindsToOut)

  }

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

  final class AccessNeighborsForTypeParameter(val node: nodes.TypeParameter) extends AnyVal {

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: nodes.Method = {
      try { node._astIn.iterator.collectAll[nodes.Method].next() }
      catch {
        case e: java.util.NoSuchElementException =>
          throw new io.joern.odb2.SchemaViolationException(
            "IN edge with label AST to an adjacent METHOD is mandatory, but not defined for this TYPE_PARAMETER node with seq=" + node.seq,
            e
          )
      }
    }

    /** Traverse to TYPE_ARGUMENT via BINDS_TO IN edge.
      */
    def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = node._bindsToIn.iterator.collectAll[nodes.TypeArgument]

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = node._astIn.iterator.collectAll[nodes.TypeDecl]

  }

  final class AccessNeighborsForTypeParameterTraversal(val traversal: Iterator[nodes.TypeParameter]) extends AnyVal {

    /** Traverse to METHOD via AST IN edge.
      */
    def _methodViaAstIn: Iterator[nodes.Method] = traversal.map(_._methodViaAstIn)

    /** Traverse to TYPE_ARGUMENT via BINDS_TO IN edge.
      */
    def _typeArgumentViaBindsToIn: Iterator[nodes.TypeArgument] = traversal.flatMap(_._typeArgumentViaBindsToIn)

    /** Traverse to TYPE_DECL via AST IN edge.
      */
    def _typeDeclViaAstIn: Iterator[nodes.TypeDecl] = traversal.flatMap(_._typeDeclViaAstIn)

  }

  final class AccessNeighborsForTypeRef(val node: nodes.TypeRef) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = node._reachingDefIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = node._astIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = node._reachingDefIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = node._captureOut.iterator.collectAll[nodes.ClosureBinding]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] =
      node._reachingDefIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = node._reachingDefIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = node._reachingDefIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = node._reachingDefIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] =
      node._reachingDefIn.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = node._reachingDefIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = node._cfgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = node._reachingDefIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = node._reachingDefIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = node._reachingDefIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForTypeRefTraversal(val traversal: Iterator[nodes.TypeRef]) extends AnyVal {

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to BLOCK via REACHING_DEF IN edge.
      */
    def _blockViaReachingDefIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaReachingDefIn)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST IN edge.
      */
    def _callViaAstIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstIn)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF IN edge.
      */
    def _callViaReachingDefIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefIn)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CLOSURE_BINDING via CAPTURE OUT edge.
      */
    def _closureBindingViaCaptureOut: Iterator[nodes.ClosureBinding] = traversal.flatMap(_._closureBindingViaCaptureOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to CONTROL_STRUCTURE via REACHING_DEF IN edge.
      */
    def _controlStructureViaReachingDefIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaReachingDefIn)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF IN edge.
      */
    def _identifierViaReachingDefIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefIn)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF IN edge.
      */
    def _literalViaReachingDefIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefIn)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD via REACHING_DEF IN edge.
      */
    def _methodViaReachingDefIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_IN via REACHING_DEF IN edge.
      */
    def _methodParameterInViaReachingDefIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF IN edge.
      */
    def _methodParameterOutViaReachingDefIn: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF IN edge.
      */
    def _methodRefViaReachingDefIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefIn)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via CFG OUT edge.
      */
    def _methodReturnViaCfgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCfgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF IN edge.
      */
    def _returnViaReachingDefIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefIn)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF IN edge.
      */
    def _typeRefViaReachingDefIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefIn)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

    /** Traverse to UNKNOWN via REACHING_DEF IN edge.
      */
    def _unknownViaReachingDefIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaReachingDefIn)

  }

  final class AccessNeighborsForUnknown(val node: nodes.Unknown) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = node._astOut.iterator.collectAll[nodes.Annotation]

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = node._astIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = node._astOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = node._cdgIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = node._cdgOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = node._dominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = node._dominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = node._postDominateIn.iterator.collectAll[nodes.Block]

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = node._postDominateOut.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = node._argumentIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = node._astOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = node._cdgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = node._cdgOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = node._dominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = node._dominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = node._postDominateIn.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = node._postDominateOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = node._reachingDefOut.iterator.collectAll[nodes.Call]

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = node._receiverIn.iterator.collectAll[nodes.Call]

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = node._cfgOut.iterator.collectAll[nodes.CfgNode]

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = node._astIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = node._astOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = node._cdgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = node._cdgOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = node._conditionIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = node._dominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = node._dominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] =
      node._postDominateIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] =
      node._postDominateOut.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = node._astOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = node._cdgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = node._cdgOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = node._dominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = node._dominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = node._postDominateIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] =
      node._postDominateOut.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = node._astOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = node._cdgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = node._cdgOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = node._dominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = node._dominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = node._postDominateIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = node._postDominateOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = node._reachingDefOut.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = node._astOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = node._cdgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = node._cdgOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = node._dominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = node._dominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = node._postDominateIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = node._postDominateOut.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = node._astOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = node._cdgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = node._cdgOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = node._dominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = node._dominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = node._postDominateIn.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = node._postDominateOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = node._reachingDefOut.iterator.collectAll[nodes.Literal]

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = node._astOut.iterator.collectAll[nodes.Local]

    /** Traverse to MEMBER via AST OUT edge.
      */
    def _memberViaAstOut: Iterator[nodes.Member] = node._astOut.iterator.collectAll[nodes.Member]

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = node._containsIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = node._dominateIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = node._postDominateOut.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = node._astIn.iterator.collectAll[nodes.MethodParameterIn]

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] =
      node._reachingDefOut.iterator.collectAll[nodes.MethodParameterOut]

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = node._cdgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = node._cdgOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = node._dominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = node._dominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = node._postDominateIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = node._postDominateOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = node._reachingDefOut.iterator.collectAll[nodes.MethodRef]

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = node._cdgOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = node._dominateOut.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = node._postDominateIn.iterator.collectAll[nodes.MethodReturn]

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = node._astOut.iterator.collectAll[nodes.Modifier]

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = node._argumentIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = node._astIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = node._astOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = node._cdgOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = node._dominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = node._dominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = node._postDominateIn.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = node._postDominateOut.iterator.collectAll[nodes.Return]

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = node._reachingDefOut.iterator.collectAll[nodes.Return]

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = node._taggedByOut.iterator.collectAll[nodes.Tag]

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = node._evalTypeOut.iterator.collectAll[nodes.Type]

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = node._cdgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = node._cdgOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = node._dominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = node._dominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = node._postDominateIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = node._postDominateOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = node._reachingDefOut.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = node._astIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = node._astOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = node._cdgIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = node._cdgOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = node._dominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = node._dominateOut.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = node._postDominateIn.iterator.collectAll[nodes.Unknown]

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = node._postDominateOut.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForUnknownTraversal(val traversal: Iterator[nodes.Unknown]) extends AnyVal {

    /** Traverse to ANNOTATION via AST OUT edge.
      */
    def _annotationViaAstOut: Iterator[nodes.Annotation] = traversal.flatMap(_._annotationViaAstOut)

    /** Traverse to BLOCK via AST IN edge.
      */
    def _blockViaAstIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstIn)

    /** Traverse to BLOCK via AST OUT edge.
      */
    def _blockViaAstOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaAstOut)

    /** Traverse to BLOCK via CDG IN edge.
      */
    def _blockViaCdgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgIn)

    /** Traverse to BLOCK via CDG OUT edge.
      */
    def _blockViaCdgOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCdgOut)

    /** Traverse to BLOCK via DOMINATE IN edge.
      */
    def _blockViaDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateIn)

    /** Traverse to BLOCK via DOMINATE OUT edge.
      */
    def _blockViaDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaDominateOut)

    /** Traverse to BLOCK via POST_DOMINATE IN edge.
      */
    def _blockViaPostDominateIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateIn)

    /** Traverse to BLOCK via POST_DOMINATE OUT edge.
      */
    def _blockViaPostDominateOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaPostDominateOut)

    /** Traverse to CALL via ARGUMENT IN edge.
      */
    def _callViaArgumentIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaArgumentIn)

    /** Traverse to CALL via AST OUT edge.
      */
    def _callViaAstOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaAstOut)

    /** Traverse to CALL via CDG IN edge.
      */
    def _callViaCdgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgIn)

    /** Traverse to CALL via CDG OUT edge.
      */
    def _callViaCdgOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaCdgOut)

    /** Traverse to CALL via DOMINATE IN edge.
      */
    def _callViaDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateIn)

    /** Traverse to CALL via DOMINATE OUT edge.
      */
    def _callViaDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaDominateOut)

    /** Traverse to CALL via POST_DOMINATE IN edge.
      */
    def _callViaPostDominateIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateIn)

    /** Traverse to CALL via POST_DOMINATE OUT edge.
      */
    def _callViaPostDominateOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaPostDominateOut)

    /** Traverse to CALL via REACHING_DEF OUT edge.
      */
    def _callViaReachingDefOut: Iterator[nodes.Call] = traversal.flatMap(_._callViaReachingDefOut)

    /** Traverse to CALL via RECEIVER IN edge.
      */
    def _callViaReceiverIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaReceiverIn)

    /** Traverse to CFG_NODE via CFG OUT edge.
      */
    def _cfgNodeViaCfgOut: Iterator[nodes.CfgNode] = traversal.flatMap(_._cfgNodeViaCfgOut)

    /** Traverse to CONTROL_STRUCTURE via AST IN edge.
      */
    def _controlStructureViaAstIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstIn)

    /** Traverse to CONTROL_STRUCTURE via AST OUT edge.
      */
    def _controlStructureViaAstOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaAstOut)

    /** Traverse to CONTROL_STRUCTURE via CDG IN edge.
      */
    def _controlStructureViaCdgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgIn)

    /** Traverse to CONTROL_STRUCTURE via CDG OUT edge.
      */
    def _controlStructureViaCdgOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCdgOut)

    /** Traverse to CONTROL_STRUCTURE via CONDITION IN edge.
      */
    def _controlStructureViaConditionIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaConditionIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE IN edge.
      */
    def _controlStructureViaDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateIn)

    /** Traverse to CONTROL_STRUCTURE via DOMINATE OUT edge.
      */
    def _controlStructureViaDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaDominateOut)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE IN edge.
      */
    def _controlStructureViaPostDominateIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateIn)

    /** Traverse to CONTROL_STRUCTURE via POST_DOMINATE OUT edge.
      */
    def _controlStructureViaPostDominateOut: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaPostDominateOut)

    /** Traverse to FIELD_IDENTIFIER via AST OUT edge.
      */
    def _fieldIdentifierViaAstOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaAstOut)

    /** Traverse to FIELD_IDENTIFIER via CDG IN edge.
      */
    def _fieldIdentifierViaCdgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgIn)

    /** Traverse to FIELD_IDENTIFIER via CDG OUT edge.
      */
    def _fieldIdentifierViaCdgOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCdgOut)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE IN edge.
      */
    def _fieldIdentifierViaDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateIn)

    /** Traverse to FIELD_IDENTIFIER via DOMINATE OUT edge.
      */
    def _fieldIdentifierViaDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaDominateOut)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _fieldIdentifierViaPostDominateIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateIn)

    /** Traverse to FIELD_IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _fieldIdentifierViaPostDominateOut: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via AST OUT edge.
      */
    def _identifierViaAstOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaAstOut)

    /** Traverse to IDENTIFIER via CDG IN edge.
      */
    def _identifierViaCdgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgIn)

    /** Traverse to IDENTIFIER via CDG OUT edge.
      */
    def _identifierViaCdgOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCdgOut)

    /** Traverse to IDENTIFIER via DOMINATE IN edge.
      */
    def _identifierViaDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateIn)

    /** Traverse to IDENTIFIER via DOMINATE OUT edge.
      */
    def _identifierViaDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaDominateOut)

    /** Traverse to IDENTIFIER via POST_DOMINATE IN edge.
      */
    def _identifierViaPostDominateIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateIn)

    /** Traverse to IDENTIFIER via POST_DOMINATE OUT edge.
      */
    def _identifierViaPostDominateOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaPostDominateOut)

    /** Traverse to IDENTIFIER via REACHING_DEF OUT edge.
      */
    def _identifierViaReachingDefOut: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaReachingDefOut)

    /** Traverse to JUMP_TARGET via AST OUT edge.
      */
    def _jumpTargetViaAstOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaAstOut)

    /** Traverse to JUMP_TARGET via CDG IN edge.
      */
    def _jumpTargetViaCdgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgIn)

    /** Traverse to JUMP_TARGET via CDG OUT edge.
      */
    def _jumpTargetViaCdgOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCdgOut)

    /** Traverse to JUMP_TARGET via DOMINATE IN edge.
      */
    def _jumpTargetViaDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateIn)

    /** Traverse to JUMP_TARGET via DOMINATE OUT edge.
      */
    def _jumpTargetViaDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaDominateOut)

    /** Traverse to JUMP_TARGET via POST_DOMINATE IN edge.
      */
    def _jumpTargetViaPostDominateIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateIn)

    /** Traverse to JUMP_TARGET via POST_DOMINATE OUT edge.
      */
    def _jumpTargetViaPostDominateOut: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaPostDominateOut)

    /** Traverse to LITERAL via AST OUT edge.
      */
    def _literalViaAstOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaAstOut)

    /** Traverse to LITERAL via CDG IN edge.
      */
    def _literalViaCdgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgIn)

    /** Traverse to LITERAL via CDG OUT edge.
      */
    def _literalViaCdgOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCdgOut)

    /** Traverse to LITERAL via DOMINATE IN edge.
      */
    def _literalViaDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateIn)

    /** Traverse to LITERAL via DOMINATE OUT edge.
      */
    def _literalViaDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaDominateOut)

    /** Traverse to LITERAL via POST_DOMINATE IN edge.
      */
    def _literalViaPostDominateIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateIn)

    /** Traverse to LITERAL via POST_DOMINATE OUT edge.
      */
    def _literalViaPostDominateOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaPostDominateOut)

    /** Traverse to LITERAL via REACHING_DEF OUT edge.
      */
    def _literalViaReachingDefOut: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaReachingDefOut)

    /** Traverse to LOCAL via AST OUT edge.
      */
    def _localViaAstOut: Iterator[nodes.Local] = traversal.flatMap(_._localViaAstOut)

    /** Traverse to MEMBER via AST OUT edge.
      */
    def _memberViaAstOut: Iterator[nodes.Member] = traversal.flatMap(_._memberViaAstOut)

    /** Traverse to METHOD via CONTAINS IN edge.
      */
    def _methodViaContainsIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaContainsIn)

    /** Traverse to METHOD via DOMINATE IN edge.
      */
    def _methodViaDominateIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaDominateIn)

    /** Traverse to METHOD via POST_DOMINATE OUT edge.
      */
    def _methodViaPostDominateOut: Iterator[nodes.Method] = traversal.flatMap(_._methodViaPostDominateOut)

    /** Traverse to METHOD_PARAMETER_IN via AST IN edge.
      */
    def _methodParameterInViaAstIn: Iterator[nodes.MethodParameterIn] = traversal.flatMap(_._methodParameterInViaAstIn)

    /** Traverse to METHOD_PARAMETER_OUT via REACHING_DEF OUT edge.
      */
    def _methodParameterOutViaReachingDefOut: Iterator[nodes.MethodParameterOut] = traversal.flatMap(_._methodParameterOutViaReachingDefOut)

    /** Traverse to METHOD_REF via CDG IN edge.
      */
    def _methodRefViaCdgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgIn)

    /** Traverse to METHOD_REF via CDG OUT edge.
      */
    def _methodRefViaCdgOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCdgOut)

    /** Traverse to METHOD_REF via DOMINATE IN edge.
      */
    def _methodRefViaDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateIn)

    /** Traverse to METHOD_REF via DOMINATE OUT edge.
      */
    def _methodRefViaDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaDominateOut)

    /** Traverse to METHOD_REF via POST_DOMINATE IN edge.
      */
    def _methodRefViaPostDominateIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateIn)

    /** Traverse to METHOD_REF via POST_DOMINATE OUT edge.
      */
    def _methodRefViaPostDominateOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaPostDominateOut)

    /** Traverse to METHOD_REF via REACHING_DEF OUT edge.
      */
    def _methodRefViaReachingDefOut: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaReachingDefOut)

    /** Traverse to METHOD_RETURN via CDG OUT edge.
      */
    def _methodReturnViaCdgOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaCdgOut)

    /** Traverse to METHOD_RETURN via DOMINATE OUT edge.
      */
    def _methodReturnViaDominateOut: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaDominateOut)

    /** Traverse to METHOD_RETURN via POST_DOMINATE IN edge.
      */
    def _methodReturnViaPostDominateIn: Iterator[nodes.MethodReturn] = traversal.flatMap(_._methodReturnViaPostDominateIn)

    /** Traverse to MODIFIER via AST OUT edge.
      */
    def _modifierViaAstOut: Iterator[nodes.Modifier] = traversal.flatMap(_._modifierViaAstOut)

    /** Traverse to RETURN via ARGUMENT IN edge.
      */
    def _returnViaArgumentIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaArgumentIn)

    /** Traverse to RETURN via AST IN edge.
      */
    def _returnViaAstIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstIn)

    /** Traverse to RETURN via AST OUT edge.
      */
    def _returnViaAstOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaAstOut)

    /** Traverse to RETURN via CDG OUT edge.
      */
    def _returnViaCdgOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaCdgOut)

    /** Traverse to RETURN via DOMINATE IN edge.
      */
    def _returnViaDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateIn)

    /** Traverse to RETURN via DOMINATE OUT edge.
      */
    def _returnViaDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaDominateOut)

    /** Traverse to RETURN via POST_DOMINATE IN edge.
      */
    def _returnViaPostDominateIn: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateIn)

    /** Traverse to RETURN via POST_DOMINATE OUT edge.
      */
    def _returnViaPostDominateOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaPostDominateOut)

    /** Traverse to RETURN via REACHING_DEF OUT edge.
      */
    def _returnViaReachingDefOut: Iterator[nodes.Return] = traversal.flatMap(_._returnViaReachingDefOut)

    /** Traverse to TAG via TAGGED_BY OUT edge.
      */
    def _tagViaTaggedByOut: Iterator[nodes.Tag] = traversal.flatMap(_._tagViaTaggedByOut)

    /** Traverse to TYPE via EVAL_TYPE OUT edge.
      */
    def _typeViaEvalTypeOut: Iterator[nodes.Type] = traversal.flatMap(_._typeViaEvalTypeOut)

    /** Traverse to TYPE_REF via CDG IN edge.
      */
    def _typeRefViaCdgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgIn)

    /** Traverse to TYPE_REF via CDG OUT edge.
      */
    def _typeRefViaCdgOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCdgOut)

    /** Traverse to TYPE_REF via DOMINATE IN edge.
      */
    def _typeRefViaDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateIn)

    /** Traverse to TYPE_REF via DOMINATE OUT edge.
      */
    def _typeRefViaDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaDominateOut)

    /** Traverse to TYPE_REF via POST_DOMINATE IN edge.
      */
    def _typeRefViaPostDominateIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateIn)

    /** Traverse to TYPE_REF via POST_DOMINATE OUT edge.
      */
    def _typeRefViaPostDominateOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaPostDominateOut)

    /** Traverse to TYPE_REF via REACHING_DEF OUT edge.
      */
    def _typeRefViaReachingDefOut: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaReachingDefOut)

    /** Traverse to UNKNOWN via AST IN edge.
      */
    def _unknownViaAstIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstIn)

    /** Traverse to UNKNOWN via AST OUT edge.
      */
    def _unknownViaAstOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaAstOut)

    /** Traverse to UNKNOWN via CDG IN edge.
      */
    def _unknownViaCdgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgIn)

    /** Traverse to UNKNOWN via CDG OUT edge.
      */
    def _unknownViaCdgOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCdgOut)

    /** Traverse to UNKNOWN via DOMINATE IN edge.
      */
    def _unknownViaDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateIn)

    /** Traverse to UNKNOWN via DOMINATE OUT edge.
      */
    def _unknownViaDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaDominateOut)

    /** Traverse to UNKNOWN via POST_DOMINATE IN edge.
      */
    def _unknownViaPostDominateIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateIn)

    /** Traverse to UNKNOWN via POST_DOMINATE OUT edge.
      */
    def _unknownViaPostDominateOut: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaPostDominateOut)

  }

  final class AccessNeighborsForCfgNode(val node: nodes.CfgNode) extends AnyVal {

    /** Traverse to BLOCK via CFG IN edge.
      */
    def _blockViaCfgIn: Iterator[nodes.Block] = node._cfgIn.iterator.collectAll[nodes.Block]

    /** Traverse to CALL via CFG IN edge.
      */
    def _callViaCfgIn: Iterator[nodes.Call] = node._cfgIn.iterator.collectAll[nodes.Call]

    /** Traverse to CONTROL_STRUCTURE via CFG IN edge.
      */
    def _controlStructureViaCfgIn: Iterator[nodes.ControlStructure] = node._cfgIn.iterator.collectAll[nodes.ControlStructure]

    /** Traverse to FIELD_IDENTIFIER via CFG IN edge.
      */
    def _fieldIdentifierViaCfgIn: Iterator[nodes.FieldIdentifier] = node._cfgIn.iterator.collectAll[nodes.FieldIdentifier]

    /** Traverse to IDENTIFIER via CFG IN edge.
      */
    def _identifierViaCfgIn: Iterator[nodes.Identifier] = node._cfgIn.iterator.collectAll[nodes.Identifier]

    /** Traverse to JUMP_TARGET via CFG IN edge.
      */
    def _jumpTargetViaCfgIn: Iterator[nodes.JumpTarget] = node._cfgIn.iterator.collectAll[nodes.JumpTarget]

    /** Traverse to LITERAL via CFG IN edge.
      */
    def _literalViaCfgIn: Iterator[nodes.Literal] = node._cfgIn.iterator.collectAll[nodes.Literal]

    /** Traverse to METHOD via CFG IN edge.
      */
    def _methodViaCfgIn: Iterator[nodes.Method] = node._cfgIn.iterator.collectAll[nodes.Method]

    /** Traverse to METHOD_REF via CFG IN edge.
      */
    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = node._cfgIn.iterator.collectAll[nodes.MethodRef]

    /** Traverse to TYPE_REF via CFG IN edge.
      */
    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = node._cfgIn.iterator.collectAll[nodes.TypeRef]

    /** Traverse to UNKNOWN via CFG IN edge.
      */
    def _unknownViaCfgIn: Iterator[nodes.Unknown] = node._cfgIn.iterator.collectAll[nodes.Unknown]

  }

  final class AccessNeighborsForCfgNodeTraversal(val traversal: Iterator[nodes.CfgNode]) extends AnyVal {

    /** Traverse to BLOCK via CFG IN edge.
      */
    def _blockViaCfgIn: Iterator[nodes.Block] = traversal.flatMap(_._blockViaCfgIn)

    /** Traverse to CALL via CFG IN edge.
      */
    def _callViaCfgIn: Iterator[nodes.Call] = traversal.flatMap(_._callViaCfgIn)

    /** Traverse to CONTROL_STRUCTURE via CFG IN edge.
      */
    def _controlStructureViaCfgIn: Iterator[nodes.ControlStructure] = traversal.flatMap(_._controlStructureViaCfgIn)

    /** Traverse to FIELD_IDENTIFIER via CFG IN edge.
      */
    def _fieldIdentifierViaCfgIn: Iterator[nodes.FieldIdentifier] = traversal.flatMap(_._fieldIdentifierViaCfgIn)

    /** Traverse to IDENTIFIER via CFG IN edge.
      */
    def _identifierViaCfgIn: Iterator[nodes.Identifier] = traversal.flatMap(_._identifierViaCfgIn)

    /** Traverse to JUMP_TARGET via CFG IN edge.
      */
    def _jumpTargetViaCfgIn: Iterator[nodes.JumpTarget] = traversal.flatMap(_._jumpTargetViaCfgIn)

    /** Traverse to LITERAL via CFG IN edge.
      */
    def _literalViaCfgIn: Iterator[nodes.Literal] = traversal.flatMap(_._literalViaCfgIn)

    /** Traverse to METHOD via CFG IN edge.
      */
    def _methodViaCfgIn: Iterator[nodes.Method] = traversal.flatMap(_._methodViaCfgIn)

    /** Traverse to METHOD_REF via CFG IN edge.
      */
    def _methodRefViaCfgIn: Iterator[nodes.MethodRef] = traversal.flatMap(_._methodRefViaCfgIn)

    /** Traverse to TYPE_REF via CFG IN edge.
      */
    def _typeRefViaCfgIn: Iterator[nodes.TypeRef] = traversal.flatMap(_._typeRefViaCfgIn)

    /** Traverse to UNKNOWN via CFG IN edge.
      */
    def _unknownViaCfgIn: Iterator[nodes.Unknown] = traversal.flatMap(_._unknownViaCfgIn)

  }

  final class AccessNeighborsForExpression(val node: nodes.Expression) extends AnyVal {

    /** Traverse to TEMPLATE_DOM via ARGUMENT OUT edge.
      */
    def _templateDomViaArgumentOut: Iterator[nodes.TemplateDom] = node._argumentOut.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TEMPLATE_DOM via AST IN edge.
      */
    def _templateDomViaAstIn: Iterator[nodes.TemplateDom] = node._astIn.iterator.collectAll[nodes.TemplateDom]

    /** Traverse to TEMPLATE_DOM via REACHING_DEF IN edge.
      */
    def _templateDomViaReachingDefIn: Iterator[nodes.TemplateDom] = node._reachingDefIn.iterator.collectAll[nodes.TemplateDom]

  }

  final class AccessNeighborsForExpressionTraversal(val traversal: Iterator[nodes.Expression]) extends AnyVal {

    /** Traverse to TEMPLATE_DOM via ARGUMENT OUT edge.
      */
    def _templateDomViaArgumentOut: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaArgumentOut)

    /** Traverse to TEMPLATE_DOM via AST IN edge.
      */
    def _templateDomViaAstIn: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaAstIn)

    /** Traverse to TEMPLATE_DOM via REACHING_DEF IN edge.
      */
    def _templateDomViaReachingDefIn: Iterator[nodes.TemplateDom] = traversal.flatMap(_._templateDomViaReachingDefIn)

  }

}
