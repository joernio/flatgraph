package testdomains.hierarchical.nodes

import testdomains.hierarchical.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeYEMT extends AnyRef with BaseNodeEMT

trait NodeYBase extends AbstractNode with BaseNodeBase with StaticType[NodeYEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.hierarchical.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.name) res.put("name", this.name)
    res
  }
}

object NodeY {
  val Label = "node_y"
}

/** * NODE PROPERTIES:
  *
  * ▸ Name (String); Cardinality `one` (mandatory with default value `<empty>`)
  */
class NodeY(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1, seq_4762)
    with NodeYBase
    with BaseNode
    with StaticType[NodeYEMT] {

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

  override def productPrefix = "NodeY"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeY]
}
