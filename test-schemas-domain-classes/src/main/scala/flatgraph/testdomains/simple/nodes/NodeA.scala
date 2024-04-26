package flatgraph.testdomains.simple.nodes

import flatgraph.testdomains.simple.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait NodeAEMT
    extends AnyRef
    with HasIntlistEMT
    with HasIntmandatoryEMT
    with HasIntoptionalEMT
    with HasStringlistEMT
    with HasStringmandatoryEMT
    with HasStringoptionalEMT

trait NodeABase extends AbstractNode with StaticType[NodeAEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import flatgraph.testdomains.simple.accessors.Lang.*
    val res        = new java.util.HashMap[String, Any]()
    val tmpIntlist = this.intlist; if (tmpIntlist.nonEmpty) res.put("intList", tmpIntlist)
    if ((42: Int) != this.intmandatory) res.put("intMandatory", this.intmandatory)
    this.intoptional.foreach { p => res.put("intOptional", p) }
    val tmpStringlist = this.stringlist; if (tmpStringlist.nonEmpty) res.put("stringList", tmpStringlist)
    if (("<empty>": String) != this.stringmandatory) res.put("stringMandatory", this.stringmandatory)
    this.stringoptional.foreach { p => res.put("stringOptional", p) }
    res
  }
}

object NodeA {
  val Label = "node_a"
  object PropertyNames {
    val Intlist         = flatgraph.testdomains.simple.PropertyNames.intList
    val Intmandatory    = flatgraph.testdomains.simple.PropertyNames.intMandatory
    val Intoptional     = flatgraph.testdomains.simple.PropertyNames.intOptional
    val Stringlist      = flatgraph.testdomains.simple.PropertyNames.stringList
    val Stringmandatory = flatgraph.testdomains.simple.PropertyNames.stringMandatory
    val Stringoptional  = flatgraph.testdomains.simple.PropertyNames.stringOptional
  }
  object PropertyDefaults {
    val Intmandatory    = 42: Int
    val Stringmandatory = "<empty>"
  }
}

class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with NodeABase
    with StaticType[NodeAEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intlist"
      case 1 => "intmandatory"
      case 2 => "intoptional"
      case 3 => "stringlist"
      case 4 => "stringmandatory"
      case 5 => "stringoptional"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intlist
      case 1 => this.intmandatory
      case 2 => this.intoptional
      case 3 => this.stringlist
      case 4 => this.stringmandatory
      case 5 => this.stringoptional
      case _ => null
    }

  override def productPrefix = "NodeA"
  override def productArity  = 6

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeA]
}

object NewNodeA {
  def apply(): NewNodeA                              = new NewNodeA
  private val outNeighbors: Map[String, Set[String]] = Map("connectedTo" -> Set("node_a"))
  private val inNeighbors: Map[String, Set[String]]  = Map("connectedTo" -> Set("node_a"))
}
class NewNodeA extends NewNode(0.toShort) with NodeABase {
  override type StoredNodeType = NodeA
  override def label: String = "node_a"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var intlist: IndexedSeq[Int]                           = ArraySeq.empty
  var intmandatory: Int                                  = 42: Int
  var intoptional: Option[Int]                           = None
  var stringlist: IndexedSeq[String]                     = ArraySeq.empty
  var stringmandatory: String                            = "<empty>": String
  var stringoptional: Option[String]                     = None
  def intlist(value: IterableOnce[Int]): this.type       = { this.intlist = value.iterator.to(ArraySeq); this }
  def intmandatory(value: Int): this.type                = { this.intmandatory = value; this }
  def intoptional(value: Int): this.type                 = { this.intoptional = Option(value); this }
  def intoptional(value: Option[Int]): this.type         = { this.intoptional = value; this }
  def stringlist(value: IterableOnce[String]): this.type = { this.stringlist = value.iterator.to(ArraySeq); this }
  def stringmandatory(value: String): this.type          = { this.stringmandatory = value; this }
  def stringoptional(value: Option[String]): this.type   = { this.stringoptional = value; this }
  def stringoptional(value: String): this.type           = { this.stringoptional = Option(value); this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    if (intlist.nonEmpty) interface.insertProperty(this, 0, this.intlist)
    interface.insertProperty(this, 1, Iterator(this.intmandatory))
    if (intoptional.nonEmpty) interface.insertProperty(this, 2, this.intoptional)
    if (stringlist.nonEmpty) interface.insertProperty(this, 3, this.stringlist)
    interface.insertProperty(this, 4, Iterator(this.stringmandatory))
    if (stringoptional.nonEmpty) interface.insertProperty(this, 5, this.stringoptional)
  }

  override def copy(): this.type = {
    val newInstance = new NewNodeA
    newInstance.intlist = this.intlist
    newInstance.intmandatory = this.intmandatory
    newInstance.intoptional = this.intoptional
    newInstance.stringlist = this.stringlist
    newInstance.stringmandatory = this.stringmandatory
    newInstance.stringoptional = this.stringoptional
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intlist"
      case 1 => "intmandatory"
      case 2 => "intoptional"
      case 3 => "stringlist"
      case 4 => "stringmandatory"
      case 5 => "stringoptional"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intlist
      case 1 => this.intmandatory
      case 2 => this.intoptional
      case 3 => this.stringlist
      case 4 => this.stringmandatory
      case 5 => this.stringoptional
      case _ => null
    }

  override def productPrefix                = "NewNodeA"
  override def productArity                 = 6
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeA]
}
