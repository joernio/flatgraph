package flatgraph.testdomains.gratefuldead.accessors
import flatgraph.testdomains.gratefuldead.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_name(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "": String)
  }
  final class Access_Property_songType(val node: nodes.StoredNode) extends AnyVal {
    def songtype: Option[String] =
      flatgraph.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 1, node.seq)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_ArtistBase(val node: nodes.ArtistBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_name(stored).name
      case newNode: nodes.NewArtist => newNode.name
    }
  }
  final class Access_SongBase(val node: nodes.SongBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_name(stored).name
      case newNode: nodes.NewSong   => newNode.name
    }
    def songtype: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_songType(stored).songtype
      case newNode: nodes.NewSong   => newNode.songtype
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): Access_Property_name =
    new Access_Property_name(node)
  implicit def accessPropertySongtype(node: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]): Access_Property_songType =
    new Access_Property_songType(node)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def access_ArtistBase(node: nodes.ArtistBase): Access_ArtistBase = new Access_ArtistBase(node)
  implicit def access_SongBase(node: nodes.SongBase): Access_SongBase       = new Access_SongBase(node)
}
