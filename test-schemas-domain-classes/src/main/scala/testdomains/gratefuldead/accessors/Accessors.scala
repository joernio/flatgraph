package testdomains.gratefuldead.accessors
import testdomains.gratefuldead.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class AccessPropertyName(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "": String)
  }
  final class AccessPropertyPerformances(val node: nodes.StoredNode) extends AnyVal {
    def performances: Option[Int] = flatgraph.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 1, node.seq)
  }
  final class AccessPropertySongtype(val node: nodes.StoredNode) extends AnyVal {
    def songtype: Option[String] = flatgraph.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 2, node.seq)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class AccessArtistBase(val node: nodes.ArtistBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new AccessPropertyName(stored).name
      case newNode: nodes.NewArtist => newNode.name
    }
  }
  final class AccessSongBase(val node: nodes.SongBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new AccessPropertyName(stored).name
      case newNode: nodes.NewSong   => newNode.name
    }
    def performances: Option[Int] = node match {
      case stored: nodes.StoredNode => new AccessPropertyPerformances(stored).performances
      case newNode: nodes.NewSong   => newNode.performances
    }
    def songtype: Option[String] = node match {
      case stored: nodes.StoredNode => new AccessPropertySongtype(stored).songtype
      case newNode: nodes.NewSong   => newNode.songtype
    }
  }
  /* accessors for base nodes end */
}

import Accessors.*
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): AccessPropertyName = new AccessPropertyName(
    node
  )
  implicit def accessPropertyPerformances(node: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]): AccessPropertyPerformances =
    new AccessPropertyPerformances(node)
  implicit def accessPropertySongtype(node: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]): AccessPropertySongtype =
    new AccessPropertySongtype(node)
}

trait ConcreteBaseConversions {
  implicit def accessArtistbase(node: nodes.ArtistBase): AccessArtistBase = new AccessArtistBase(node)
  implicit def accessSongbase(node: nodes.SongBase): AccessSongBase       = new AccessSongBase(node)
}
