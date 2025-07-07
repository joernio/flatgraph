package testdomains.gratefuldead.nodes

import testdomains.gratefuldead.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait SongEMT extends AnyRef with HasNameEMT with HasPerformancesEMT with HasSongtypeEMT

trait SongBase extends AbstractNode with StaticType[SongEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.gratefuldead.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("": String) != this.name) res.put("name", this.name)
    this.performances.foreach { p => res.put("performances", p) }
    this.songtype.foreach { p => res.put("songType", p) }
    res
  }
}

object Song {
  val Label = "song"
}

/** * NODE PROPERTIES:
  *
  * ▸ Name (String); Cardinality `one` (mandatory with default value ``); This is a property comment
  *
  * ▸ Performances (Int); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ Songtype (String); Cardinality `ZeroOrOne` (optional)
  */
class Song(graph_4762: flatgraph.Graph, seq_4762: Int) extends StoredNode(graph_4762, 1, seq_4762) with SongBase with StaticType[SongEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "performances"
      case 2 => "songtype"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.performances
      case 2 => this.songtype
      case _ => null
    }

  override def productPrefix = "Song"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Song]
}
