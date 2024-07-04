package testdomains.gratefuldead

import testdomains.gratefuldead.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_name[NodeType] = new Traversal_Property_name(traversal.iterator)
    implicit def accessPropertyPerformancesTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_performances[NodeType] = new Traversal_Property_performances(traversal.iterator)
    implicit def accessPropertySongtypeTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]](
      traversal: IterableOnce[NodeType]
    ): Traversal_Property_songType[NodeType] = new Traversal_Property_songType(traversal.iterator)
  }

  trait ConcreteBaseConversions {
    implicit def traversal_ArtistBase[NodeType <: nodes.ArtistBase](traversal: IterableOnce[NodeType]): Traversal_ArtistBase[NodeType] =
      new Traversal_ArtistBase(traversal.iterator)
    implicit def traversal_SongBase[NodeType <: nodes.SongBase](traversal: IterableOnce[NodeType]): Traversal_SongBase[NodeType] =
      new Traversal_SongBase(traversal.iterator)
  }
}
