package testdomains.gratefuldead.neighboraccessors

import testdomains.gratefuldead.nodes
import testdomains.gratefuldead.language.*

final class AccessNeighborsForArtist(val node: nodes.Artist) extends AnyVal {

  /** Traverse to song via sungBy IN edge.
    */
  @deprecated("please use sang instead")
  def _songViaSungbyIn: Iterator[nodes.Song] = sang

  /** Traverse to song via sungBy IN edge.
    */
  def sang: Iterator[nodes.Song] = sungbyIn.collectAll[nodes.Song]

  /** Traverse to song via writtenBy IN edge.
    */
  @deprecated("please use wrote instead")
  def _songViaWrittenbyIn: Iterator[nodes.Song] = wrote

  /** Traverse to song via writtenBy IN edge.
    */
  def wrote: Iterator[nodes.Song] = writtenbyIn.collectAll[nodes.Song]

  def sungbyIn: Iterator[nodes.Song] = node._sungbyIn.cast[nodes.Song]

  def writtenbyIn: Iterator[nodes.Song] = node._writtenbyIn.cast[nodes.Song]
}

final class AccessNeighborsForArtistTraversal(val traversal: Iterator[nodes.Artist]) extends AnyVal {

  /** Traverse to song via sungBy IN edge.
    */
  def sang: Iterator[nodes.Song] = traversal.flatMap(_.sang)

  /** Traverse to song via sungBy IN edge.
    */
  @deprecated("please use sang instead")
  def _songViaSungbyIn: Iterator[nodes.Song] = traversal.flatMap(_._songViaSungbyIn)

  /** Traverse to song via writtenBy IN edge.
    */
  def wrote: Iterator[nodes.Song] = traversal.flatMap(_.wrote)

  /** Traverse to song via writtenBy IN edge.
    */
  @deprecated("please use wrote instead")
  def _songViaWrittenbyIn: Iterator[nodes.Song] = traversal.flatMap(_._songViaWrittenbyIn)

  def sungbyIn: Iterator[nodes.Song] = traversal.flatMap(_.sungbyIn)

  def writtenbyIn: Iterator[nodes.Song] = traversal.flatMap(_.writtenbyIn)
}
