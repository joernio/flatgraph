package testdomains.gratefuldead

import testdomains.gratefuldead.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {
    implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyName[NodeType] = new TraversalPropertyName(traversal.iterator)
    implicit def accessPropertyPerformancesTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertyPerformances[NodeType] = new TraversalPropertyPerformances(traversal.iterator)
    implicit def accessPropertySongtypeTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]](
      traversal: IterableOnce[NodeType]
    ): TraversalPropertySongtype[NodeType] = new TraversalPropertySongtype(traversal.iterator)
  }

  trait ConcreteBaseConversions {
    implicit def traversalArtistBase[NodeType <: nodes.ArtistBase](traversal: IterableOnce[NodeType]): TraversalArtistBase[NodeType] =
      new TraversalArtistBase(traversal.iterator)
    implicit def traversalSongBase[NodeType <: nodes.SongBase](traversal: IterableOnce[NodeType]): TraversalSongBase[NodeType] =
      new TraversalSongBase(traversal.iterator)
  }
}
