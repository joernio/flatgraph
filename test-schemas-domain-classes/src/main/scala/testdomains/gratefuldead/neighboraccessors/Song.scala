package testdomains.gratefuldead.neighboraccessors

import testdomains.gratefuldead.nodes
import testdomains.gratefuldead.language.*

final class AccessNeighborsForSong(val node: nodes.Song) extends AnyVal {

  /** Traverse to artist via sungBy OUT edge.
    */
  @deprecated("please use sungBy instead")
  def _artistViaSungbyOut: Iterator[nodes.Artist] = sungBy

  /** Traverse to artist via sungBy OUT edge.
    */
  def sungBy: Iterator[nodes.Artist] = sungbyOut.collectAll[nodes.Artist]

  /** Traverse to artist via writtenBy OUT edge.
    */
  @deprecated("please use writtenBy instead")
  def _artistViaWrittenbyOut: Iterator[nodes.Artist] = writtenBy

  /** Traverse to artist via writtenBy OUT edge.
    */
  def writtenBy: Iterator[nodes.Artist] = writtenbyOut.collectAll[nodes.Artist]

  /** Traverse to song via followedBy IN edge.
    */
  def _songViaFollowedbyIn: Iterator[nodes.Song] = followedbyIn.collectAll[nodes.Song]

  /** Traverse to song via followedBy OUT edge.
    */
  @deprecated("please use followedBy instead")
  def _songViaFollowedbyOut: Iterator[nodes.Song] = followedBy

  /** Traverse to song via followedBy OUT edge.
    */
  def followedBy: Iterator[nodes.Song] = followedbyOut.collectAll[nodes.Song]

  def followedbyIn: Iterator[nodes.Song] = node._followedbyIn.cast[nodes.Song]

  def followedbyOut: Iterator[nodes.Song] = node._followedbyOut.cast[nodes.Song]

  def sungbyOut: Iterator[nodes.Artist] = node._sungbyOut.cast[nodes.Artist]

  def writtenbyOut: Iterator[nodes.Artist] = node._writtenbyOut.cast[nodes.Artist]
}

final class AccessNeighborsForSongTraversal(val traversal: Iterator[nodes.Song]) extends AnyVal {

  /** Traverse to artist via sungBy OUT edge.
    */
  def sungBy: Iterator[nodes.Artist] = traversal.flatMap(_.sungBy)

  /** Traverse to artist via sungBy OUT edge.
    */
  @deprecated("please use sungBy instead")
  def _artistViaSungbyOut: Iterator[nodes.Artist] = traversal.flatMap(_._artistViaSungbyOut)

  /** Traverse to artist via writtenBy OUT edge.
    */
  def writtenBy: Iterator[nodes.Artist] = traversal.flatMap(_.writtenBy)

  /** Traverse to artist via writtenBy OUT edge.
    */
  @deprecated("please use writtenBy instead")
  def _artistViaWrittenbyOut: Iterator[nodes.Artist] = traversal.flatMap(_._artistViaWrittenbyOut)

  /** Traverse to song via followedBy IN edge.
    */
  def _songViaFollowedbyIn: Iterator[nodes.Song] = traversal.flatMap(_._songViaFollowedbyIn)

  /** Traverse to song via followedBy OUT edge.
    */
  def followedBy: Iterator[nodes.Song] = traversal.flatMap(_.followedBy)

  /** Traverse to song via followedBy OUT edge.
    */
  @deprecated("please use followedBy instead")
  def _songViaFollowedbyOut: Iterator[nodes.Song] = traversal.flatMap(_._songViaFollowedbyOut)

  def followedbyIn: Iterator[nodes.Song] = traversal.flatMap(_.followedbyIn)

  def followedbyOut: Iterator[nodes.Song] = traversal.flatMap(_.followedbyOut)

  def sungbyOut: Iterator[nodes.Artist] = traversal.flatMap(_.sungbyOut)

  def writtenbyOut: Iterator[nodes.Artist] = traversal.flatMap(_.writtenbyOut)
}
