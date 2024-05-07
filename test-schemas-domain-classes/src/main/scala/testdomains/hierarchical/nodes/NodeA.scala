package testdomains.hierarchical.nodes

import testdomains.hierarchical.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeAEMT extends AnyRef with BaseNodeEMT

trait NodeABase extends AbstractNode with BaseNodeBase with StaticType[NodeAEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.hierarchical.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.name) res.put("name", this.name)
    res
  }
}

object NodeA {
  val Label = "node_a"
  object PropertyNames {

    val Name = "name"
  }
  object PropertyKeys {
    val Name = flatgraph.SinglePropertyKey[String](kind = 0, name = "name", default = "<empty>")
  }
  object PropertyDefaults {
    val Name = "<empty>"
  }
}

class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with NodeABase
    with BaseNode
    with StaticType[NodeAEMT] {

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

  override def productPrefix = "NodeA"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeA]
}

object NewNodeA {
  def apply(): NewNodeA                              = new NewNodeA
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map()
}
class NewNodeA extends NewNode(0.toShort) with NodeABase with BaseNodeNew {
  override type StoredNodeType = NodeA
  override def label: String = "node_a"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "<empty>": String
  def name(value: String): this.type = { this.name = value; this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 0, Iterator(this.name))
  }

  override def copy(): this.type = {
    val newInstance = new NewNodeA
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

  override def productPrefix                = "NewNodeA"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeA]
}
