package io.shiftleft.codepropertygraph.generated.v2

import io.joern.odb2
import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
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
}
