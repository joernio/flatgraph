package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeBEMT extends AnyRef with HasStringOptionalEMT

trait NodeBBase extends AbstractNode with StaticType[NodeBEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.generic.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    this.stringOptional.foreach { p => res.put("string_optional", p) }
    res
  }
}

object NodeB {
  val Label = "node_b"
}

/** * NODE PROPERTIES:
  *
  * ▸ StringOptional (String); Cardinality `ZeroOrOne` (optional)
  */
class NodeB(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1, seq_4762)
    with NodeBBase
    with StaticType[NodeBEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "stringOptional"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.stringOptional
      case _ => null
    }

  override def productPrefix = "NodeB"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeB]
}
