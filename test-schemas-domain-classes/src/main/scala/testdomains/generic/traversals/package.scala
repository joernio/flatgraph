package testdomains.generic

import testdomains.generic.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyIntListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_int_list[NodeType] = new Traversal_Property_int_list(traversal.iterator)
    implicit def accessPropertyIntMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_int_mandatory[NodeType] = new Traversal_Property_int_mandatory(traversal.iterator)
    implicit def accessPropertyIntOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_int_optional[NodeType] = new Traversal_Property_int_optional(traversal.iterator)
    implicit def accessPropertyStringListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_string_list[NodeType] = new Traversal_Property_string_list(traversal.iterator)
    implicit def accessPropertyStringMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_string_mandatory[NodeType] = new Traversal_Property_string_mandatory(traversal.iterator)
    implicit def accessPropertyStringOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_string_optional[NodeType] = new Traversal_Property_string_optional(traversal.iterator)
  }

  trait ConcreteBaseConversions {
    implicit def traversal_NodeABase[NodeType <: nodes.NodeABase](traversal: IterableOnce[NodeType]): Traversal_NodeABase[NodeType] =
      new Traversal_NodeABase(traversal.iterator)
    implicit def traversal_NodeBBase[NodeType <: nodes.NodeBBase](traversal: IterableOnce[NodeType]): Traversal_NodeBBase[NodeType] =
      new Traversal_NodeBBase(traversal.iterator)
  }
}
