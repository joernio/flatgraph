package flatgraph.testdomains.gratefuldead.nodes

import flatgraph.testdomains.gratefuldead.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait ArtistEMT extends AnyRef with HasNameEMT

trait ArtistBase extends AbstractNode with StaticType[ArtistEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import flatgraph.testdomains.gratefuldead.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    if (("": String) != this.name) res.put("name", this.name)
    res
  }
}

object Artist {
  val Label = "artist"
  object PropertyNames {

    val Name = "name"
  }
  object PropertyKeys {
    val Name = flatgraph.SinglePropertyKey[String](kind = 0, name = "name", default = "")
  }
  object PropertyDefaults {
    val Name = ""
  }
}

class Artist(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with ArtistBase
    with StaticType[ArtistEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case _ => null
    }

  override def productPrefix = "Artist"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Artist]
}

object NewArtist {
  def apply(): NewArtist                             = new NewArtist
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map("sungBy" -> Set("song"), "writtenBy" -> Set("song"))
}
class NewArtist extends NewNode(0.toShort) with ArtistBase {
  override type StoredNodeType = Artist
  override def label: String = "artist"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewArtist.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewArtist.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "": String
  def name(value: String): this.type = { this.name = value; this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 0, Iterator(this.name))
  }

  override def copy(): this.type = {
    val newInstance = new NewArtist
    newInstance.name = this.name
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case _ => null
    }

  override def productPrefix                = "NewArtist"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewArtist]
}
