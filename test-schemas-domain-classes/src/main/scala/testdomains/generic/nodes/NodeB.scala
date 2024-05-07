package testdomains.generic.nodes

import testdomains.generic.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeBEMT extends AnyRef with HasStringOptionalEMT

trait NodeBBase extends AbstractNode with StaticType[NodeBEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.generic.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    this.stringOptional.foreach { p => res.put("string_optional", p) }
    res
  }
}

object NodeB {
  val Label = "node_b"
  object PropertyNames {

    val StringOptional = "string_optional"
  }
  object PropertyKeys {
    val StringOptional = flatgraph.OptionalPropertyKey[String](kind = 5, name = "string_optional")
  }
  object PropertyDefaults {}
}

class NodeB(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
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

object NewNodeB {
  def apply(): NewNodeB                              = new NewNodeB
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map()
}
class NewNodeB extends NewNode(1.toShort) with NodeBBase {
  override type StoredNodeType = NodeB
  override def label: String = "node_b"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeB.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeB.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var stringOptional: Option[String]                   = None
  def stringOptional(value: Option[String]): this.type = { this.stringOptional = value; this }
  def stringOptional(value: String): this.type         = { this.stringOptional = Option(value); this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    if (stringOptional.nonEmpty) interface.insertProperty(this, 5, this.stringOptional)
  }

  override def copy(): this.type = {
    val newInstance = new NewNodeB
    newInstance.stringOptional = this.stringOptional
    newInstance.asInstanceOf[this.type]
  }

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

  override def productPrefix                = "NewNodeB"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeB]
}
