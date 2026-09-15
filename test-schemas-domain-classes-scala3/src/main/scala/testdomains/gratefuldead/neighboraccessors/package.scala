package testdomains.gratefuldead

import flatgraph.traversal.language.*
import testdomains.gratefuldead.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForArtist(node: nodes.Artist): AccessNeighborsForArtist =
      new AccessNeighborsForArtist(node)

    implicit def accessNeighborsForArtistTraversal(traversal: IterableOnce[nodes.Artist]): AccessNeighborsForArtistTraversal =
      new AccessNeighborsForArtistTraversal(traversal.iterator)

    implicit def accessNeighborsForSong(node: nodes.Song): AccessNeighborsForSong =
      new AccessNeighborsForSong(node)

    implicit def accessNeighborsForSongTraversal(traversal: IterableOnce[nodes.Song]): AccessNeighborsForSongTraversal =
      new AccessNeighborsForSongTraversal(traversal.iterator)
  }
}
