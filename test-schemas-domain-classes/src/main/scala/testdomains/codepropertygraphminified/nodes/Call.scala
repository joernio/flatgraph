package testdomains.codepropertygraphminified.nodes

import testdomains.codepropertygraphminified.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait CallEMT extends AnyRef with CallReprEMT with HasDispatchTypeEMT

trait CallBase extends AbstractNode with CallReprBase with StaticType[CallEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.codepropertygraphminified.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.dispatchType) res.put("DISPATCH_TYPE", this.dispatchType)
    if (("<empty>": String) != this.name) res.put("NAME", this.name)
    if ((-1: Int) != this.order) res.put("ORDER", this.order)
    res
  }
}

object Call {
  val Label = "CALL"
}

/** * NODE PROPERTIES:
  *
  * ▸ DispatchType (String); Cardinality `one` (mandatory with default value `<empty>`)
  *
  * ▸ Name (String); Cardinality `one` (mandatory with default value `<empty>`); The name of a thing.
  *
  * ▸ Order (Int); Cardinality `one` (mandatory with default value `-1`)
  */
class Call(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0, seq_4762)
    with CallBase
    with CallRepr
    with StaticType[CallEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "dispatchType"
      case 1 => "name"
      case 2 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.dispatchType
      case 1 => this.name
      case 2 => this.order
      case _ => null
    }

  override def productPrefix = "Call"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Call]
}
