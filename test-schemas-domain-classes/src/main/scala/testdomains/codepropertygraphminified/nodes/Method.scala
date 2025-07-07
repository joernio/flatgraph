package testdomains.codepropertygraphminified.nodes

import testdomains.codepropertygraphminified.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait MethodEMT extends AnyRef with DeclarationEMT

trait MethodBase extends AbstractNode with DeclarationBase with StaticType[MethodEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.codepropertygraphminified.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.name) res.put("NAME", this.name)
    res
  }
}

object Method {
  val Label = "METHOD"
}

/** * NODE PROPERTIES:
  *
  * ▸ Name (String); Cardinality `one` (mandatory with default value `<empty>`); The name of a thing.
  */
class Method(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1, seq_4762)
    with MethodBase
    with Declaration
    with StaticType[MethodEMT] {

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

  override def productPrefix = "Method"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Method]
}
