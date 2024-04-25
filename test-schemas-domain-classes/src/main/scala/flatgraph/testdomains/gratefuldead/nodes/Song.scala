package flatgraph.testdomains.gratefuldead.nodes

import flatgraph.testdomains.gratefuldead.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait SongEMT extends AnyRef with HasNameEMT with HasSongtypeEMT

trait SongBase extends AbstractNode with StaticType[SongEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import flatgraph.testdomains.gratefuldead.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    if (("": String) != this.name) res.put("name", this.name)
    this.songtype.foreach { p => res.put("songType", p) }
    res
  }
}

object Song {
  val Label = "song"
  object PropertyNames {
    val Name     = flatgraph.testdomains.gratefuldead.PropertyNames.name
    val Songtype = flatgraph.testdomains.gratefuldead.PropertyNames.songType
  }
  object PropertyDefaults {
    val Name = ""
  }
}

class Song(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
    with SongBase
    with StaticType[SongEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "songtype"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.songtype
      case _ => null
    }

  override def productPrefix = "Song"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Song]
}

object NewSong {
  def apply(): NewSong = new NewSong
  private val outNeighbors: Map[String, Set[String]] =
    Map("followedBy" -> Set("song"), "sungBy" -> Set("artist"), "writtenBy" -> Set("artist"))
  private val inNeighbors: Map[String, Set[String]] = Map("followedBy" -> Set("song"))
}
class NewSong extends NewNode(1.toShort) with SongBase {
  override type StoredNodeType = Song
  override def label: String = "song"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewSong.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewSong.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                               = "": String
  var songtype: Option[String]                   = None
  def name(value: String): this.type             = { this.name = value; this }
  def songtype(value: Option[String]): this.type = { this.songtype = value; this }
  def songtype(value: String): this.type         = { this.songtype = Option(value); this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 0, Iterator(this.name))
    if (songtype.nonEmpty) interface.insertProperty(this, 1, this.songtype)
  }

  override def copy(): this.type = {
    val newInstance = new NewSong
    newInstance.name = this.name
    newInstance.songtype = this.songtype
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "songtype"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.songtype
      case _ => null
    }

  override def productPrefix                = "NewSong"
  override def productArity                 = 2
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewSong]
}
