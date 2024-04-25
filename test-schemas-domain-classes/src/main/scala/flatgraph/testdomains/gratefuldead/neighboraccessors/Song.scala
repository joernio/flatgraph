package flatgraph.testdomains.gratefuldead.neighboraccessors

import flatgraph.testdomains.gratefuldead.nodes
import flatgraph.testdomains.gratefuldead.Language.*

final class AccessNeighborsForSong(val node: nodes.Song) extends AnyVal {

  /** Traverse to Song via followedBy IN edge.
    */
  def songViaFollowedbyIn: Iterator[nodes.Song] = followedbyIn.collectAll[nodes.Song]

  /** Traverse to Song via followedBy OUT edge.
    */
  def songViaFollowedbyOut: nodes.Song = {
    try { followedbyOut.collectAll[nodes.Song].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "OUT edge with label followedBy to an adjacent Song is mandatory, but not defined for this Song node with seq=" + node.seq,
          e
        )
    }
  }

  def followedbyIn: Iterator[nodes.Song] = node._followedbyIn.cast[nodes.Song]

  def followedbyOut: Iterator[nodes.Song] = node._followedbyOut.cast[nodes.Song]
}

final class AccessNeighborsForSongTraversal(val traversal: Iterator[nodes.Song]) extends AnyVal {

  /** Traverse to Song via followedBy IN edge.
    */
  def songViaFollowedbyIn: Iterator[nodes.Song] = traversal.flatMap(_.songViaFollowedbyIn)

  /** Traverse to Song via followedBy OUT edge.
    */
  def songViaFollowedbyOut: Iterator[nodes.Song] = traversal.map(_.songViaFollowedbyOut)

  def followedbyIn: Iterator[nodes.Song] = traversal.flatMap(_.followedbyIn)

  def followedbyOut: Iterator[nodes.Song] = traversal.flatMap(_.followedbyOut)
}
