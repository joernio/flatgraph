package testdomains.codepropertygraphminified

import testdomains.codepropertygraphminified.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyDispatchTypeTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasDispatchTypeEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyDispatchType[NodeType] = new TraversalPropertyDispatchType(traversal.iterator)
    implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyName[NodeType] = new TraversalPropertyName(traversal.iterator)
    implicit def accessPropertyOrderTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasOrderEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyOrder[NodeType] = new TraversalPropertyOrder(traversal.iterator)
  }

  trait ConcreteBaseConversions extends AbstractBaseConversions0 {
    implicit def traversalCallBase[NodeType <: nodes.CallBase](traversal: IterableOnce[NodeType]): TraversalCallBase[NodeType] =
      new TraversalCallBase(traversal.iterator)
    implicit def traversalMethodBase[NodeType <: nodes.MethodBase](traversal: IterableOnce[NodeType]): TraversalMethodBase[NodeType] =
      new TraversalMethodBase(traversal.iterator)
  }

  trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
    implicit def traversalCallreprBase[NodeType <: nodes.CallReprBase](traversal: IterableOnce[NodeType]): TraversalCallreprBase[NodeType] =
      new TraversalCallreprBase(traversal.iterator)
  }

  trait AbstractBaseConversions1 {
    implicit def traversalDeclarationBase[NodeType <: nodes.DeclarationBase](
      traversal: IterableOnce[NodeType]
    ): TraversalDeclarationBase[NodeType] = new TraversalDeclarationBase(traversal.iterator)
  }
}
