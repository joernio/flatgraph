package flatgraph.testdomains.gratefuldead

import flatgraph.traversal.Language.*
import flatgraph.testdomains.gratefuldead.nodes

package object neighboraccessors {
  object Lang extends Conversions

  trait Conversions {
    implicit def accessNeighborsForSong(node: nodes.Song): AccessNeighborsForSong =
      new AccessNeighborsForSong(node)

    implicit def accessNeighborsForSongTraversal(traversal: IterableOnce[nodes.Song]): AccessNeighborsForSongTraversal =
      new AccessNeighborsForSongTraversal(traversal.iterator)
  }
}
