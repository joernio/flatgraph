package testdomains.hierarchical

import testdomains.hierarchical.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyName[NodeType] = new TraversalPropertyName(traversal.iterator)
  }

  trait ConcreteBaseConversions extends AbstractBaseConversions0 {
    implicit def traversalNodexBase[NodeType <: nodes.NodeXBase](traversal: IterableOnce[NodeType]): TraversalNodexBase[NodeType] =
      new TraversalNodexBase(traversal.iterator)
    implicit def traversalNodeyBase[NodeType <: nodes.NodeYBase](traversal: IterableOnce[NodeType]): TraversalNodeyBase[NodeType] =
      new TraversalNodeyBase(traversal.iterator)
  }

  trait AbstractBaseConversions0 {
    implicit def traversalBasenodeBase[NodeType <: nodes.BaseNodeBase](traversal: IterableOnce[NodeType]): TraversalBasenodeBase[NodeType] =
      new TraversalBasenodeBase(traversal.iterator)
  }
}
