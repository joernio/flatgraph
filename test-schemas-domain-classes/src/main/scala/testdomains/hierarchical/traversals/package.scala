package testdomains.hierarchical

import testdomains.hierarchical.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_name[NodeType] = new Traversal_Property_name(traversal.iterator)
  }

  trait ConcreteBaseConversions extends AbstractBaseConversions0 {
    implicit def traversal_NodeXBase[NodeType <: nodes.NodeXBase](traversal: IterableOnce[NodeType]): Traversal_NodeXBase[NodeType] =
      new Traversal_NodeXBase(traversal.iterator)
    implicit def traversal_NodeYBase[NodeType <: nodes.NodeYBase](traversal: IterableOnce[NodeType]): Traversal_NodeYBase[NodeType] =
      new Traversal_NodeYBase(traversal.iterator)
  }

  trait AbstractBaseConversions0 {
    implicit def traversal_BaseNodeBase[NodeType <: nodes.BaseNodeBase](
      traversal: IterableOnce[NodeType]
    ): Traversal_BaseNodeBase[NodeType] = new Traversal_BaseNodeBase(traversal.iterator)
  }
}
