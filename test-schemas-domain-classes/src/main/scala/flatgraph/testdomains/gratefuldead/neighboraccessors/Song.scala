package flatgraph.testdomains.gratefuldead.neighboraccessors

import flatgraph.testdomains.gratefuldead.nodes
import flatgraph.testdomains.gratefuldead.Language.*

final class AccessNeighborsForSong(val node: nodes.Song) extends AnyVal {

  /** Traverse to artist via sungBy OUT edge.
    */
  @deprecated("please use sungBy instead")
  def artistViaSungbyOut: nodes.Artist = sungBy

  /** Traverse to artist via sungBy OUT edge.
    */
  def sungBy: nodes.Artist = {
    try { sungbyOut.collectAll[nodes.Artist].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "OUT edge with label sungBy to an adjacent artist is mandatory, but not defined for this song node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to artist via writtenBy OUT edge.
    */
  @deprecated("please use writtenBy instead")
  def artistViaWrittenbyOut: nodes.Artist = writtenBy

  /** Traverse to artist via writtenBy OUT edge.
    */
  def writtenBy: nodes.Artist = {
    try { writtenbyOut.collectAll[nodes.Artist].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "OUT edge with label writtenBy to an adjacent artist is mandatory, but not defined for this song node with seq=" + node.seq,
          e
        )
    }
  }

  /** Traverse to song via followedBy IN edge.
    */
  def songViaFollowedbyIn: Iterator[nodes.Song] = followedbyIn.collectAll[nodes.Song]

  /** Traverse to song via followedBy OUT edge.
    */
  @deprecated("please use followedBy instead")
  def songViaFollowedbyOut: nodes.Song = followedBy

  /** Traverse to song via followedBy OUT edge.
    */
  def followedBy: nodes.Song = {
    try { followedbyOut.collectAll[nodes.Song].next() }
    catch {
      case e: java.util.NoSuchElementException =>
        throw new flatgraph.SchemaViolationException(
          "OUT edge with label followedBy to an adjacent song is mandatory, but not defined for this song node with seq=" + node.seq,
          e
        )
    }
  }

  def followedbyIn: Iterator[nodes.Song] = node._followedbyIn.cast[nodes.Song]

  def followedbyOut: Iterator[nodes.Song] = node._followedbyOut.cast[nodes.Song]

  def sungbyOut: Iterator[nodes.Artist] = node._sungbyOut.cast[nodes.Artist]

  def writtenbyOut: Iterator[nodes.Artist] = node._writtenbyOut.cast[nodes.Artist]
}

final class AccessNeighborsForSongTraversal(val traversal: Iterator[nodes.Song]) extends AnyVal {

  /** Traverse to artist via sungBy OUT edge.
    */
  def sungBy: Iterator[nodes.Artist] = traversal.map(_.sungBy)

  /** Traverse to artist via sungBy OUT edge.
    */
  @deprecated("please use sungBy instead")
  def artistViaSungbyOut: Iterator[nodes.Artist] = traversal.map(_.artistViaSungbyOut)

  /** Traverse to artist via writtenBy OUT edge.
    */
  def writtenBy: Iterator[nodes.Artist] = traversal.map(_.writtenBy)

  /** Traverse to artist via writtenBy OUT edge.
    */
  @deprecated("please use writtenBy instead")
  def artistViaWrittenbyOut: Iterator[nodes.Artist] = traversal.map(_.artistViaWrittenbyOut)

  /** Traverse to song via followedBy IN edge.
    */
  def songViaFollowedbyIn: Iterator[nodes.Song] = traversal.flatMap(_.songViaFollowedbyIn)

  /** Traverse to song via followedBy OUT edge.
    */
  def followedBy: Iterator[nodes.Song] = traversal.map(_.followedBy)

  /** Traverse to song via followedBy OUT edge.
    */
  @deprecated("please use followedBy instead")
  def songViaFollowedbyOut: Iterator[nodes.Song] = traversal.map(_.songViaFollowedbyOut)

  def followedbyIn: Iterator[nodes.Song] = traversal.flatMap(_.followedbyIn)

  def followedbyOut: Iterator[nodes.Song] = traversal.flatMap(_.followedbyOut)

  def sungbyOut: Iterator[nodes.Artist] = traversal.flatMap(_.sungbyOut)

  def writtenbyOut: Iterator[nodes.Artist] = traversal.flatMap(_.writtenbyOut)
}
