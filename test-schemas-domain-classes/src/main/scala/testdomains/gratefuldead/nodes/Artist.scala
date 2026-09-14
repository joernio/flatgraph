package testdomains.gratefuldead.nodes

import testdomains.gratefuldead.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait ArtistEMT extends AnyRef with HasNameEMT

trait ArtistBase extends AbstractNode with StaticType[ArtistEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.gratefuldead.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("": String) != this.name) res.put("name", this.name)
    res
  }
}

object Artist {
  val Label = "artist"
}

/** * NODE PROPERTIES:
  *
  * ▸ Name (String); Cardinality `one` (mandatory with default value ``); This is a property comment
  */
class Artist(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0, seq_4762)
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
