package testdomains.generic

import testdomains.generic.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyIntListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyIntList[NodeType] = new TraversalPropertyIntList(traversal.iterator)
    implicit def accessPropertyIntMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyIntMandatory[NodeType] = new TraversalPropertyIntMandatory(traversal.iterator)
    implicit def accessPropertyIntOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyIntOptional[NodeType] = new TraversalPropertyIntOptional(traversal.iterator)
    implicit def accessPropertyStringListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyStringList[NodeType] = new TraversalPropertyStringList(traversal.iterator)
    implicit def accessPropertyStringMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyStringMandatory[NodeType] = new TraversalPropertyStringMandatory(traversal.iterator)
    implicit def accessPropertyStringOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyStringOptional[NodeType] = new TraversalPropertyStringOptional(traversal.iterator)
  }

  trait ConcreteBaseConversions {
    implicit def traversalNodeaBase[NodeType <: nodes.NodeABase](traversal: IterableOnce[NodeType]): TraversalNodeaBase[NodeType] =
      new TraversalNodeaBase(traversal.iterator)
    implicit def traversalNodebBase[NodeType <: nodes.NodeBBase](traversal: IterableOnce[NodeType]): TraversalNodebBase[NodeType] =
      new TraversalNodebBase(traversal.iterator)
  }
}
