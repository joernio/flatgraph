package flatgraph.testdomains.gratefuldead.accessors
import flatgraph.testdomains.gratefuldead.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_Name(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "": String)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_ArtistBase(val node: nodes.ArtistBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_Name(stored).name
      case newNode: nodes.NewArtist => newNode.name
    }
  }
  final class Access_SongBase(val node: nodes.SongBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode => new Access_Property_Name(stored).name
      case newNode: nodes.NewSong   => newNode.name
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): Access_Property_Name =
    new Access_Property_Name(node)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def access_ArtistBase(node: nodes.ArtistBase): Access_ArtistBase = new Access_ArtistBase(node)
  implicit def access_SongBase(node: nodes.SongBase): Access_SongBase = new Access_SongBase(node)
}
