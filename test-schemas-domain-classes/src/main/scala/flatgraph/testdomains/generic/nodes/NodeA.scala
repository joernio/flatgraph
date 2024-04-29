package flatgraph.testdomains.generic.nodes

import flatgraph.testdomains.generic.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait NodeAEMT
    extends AnyRef
    with HasIntListEMT
    with HasIntMandatoryEMT
    with HasIntOptionalEMT
    with HasStringListEMT
    with HasStringMandatoryEMT
    with HasStringOptionalEMT

trait NodeABase extends AbstractNode with StaticType[NodeAEMT] {
  def node_b: Option[NodeBBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import flatgraph.testdomains.generic.accessors.Lang.*
    val res        = new java.util.HashMap[String, Any]()
    val tmpIntList = this.intList; if (tmpIntList.nonEmpty) res.put("int_list", tmpIntList)
    if ((42: Int) != this.intMandatory) res.put("int_mandatory", this.intMandatory)
    this.intOptional.foreach { p => res.put("int_optional", p) }
    val tmpStringList = this.stringList; if (tmpStringList.nonEmpty) res.put("string_list", tmpStringList)
    if (("<empty>": String) != this.stringMandatory) res.put("string_mandatory", this.stringMandatory)
    this.stringOptional.foreach { p => res.put("string_optional", p) }
    this.node_b.foreach { p => res.put("node_b", p) }
    res
  }
}

object NodeA {
  val Label = "node_a"
  object PropertyNames {

    val IntList         = "int_list"
    val IntMandatory    = "int_mandatory"
    val IntOptional     = "int_optional"
    val StringList      = "string_list"
    val StringMandatory = "string_mandatory"
    val StringOptional  = "string_optional"
    val NodeB           = "node_b"
  }
  object PropertyDefaults {
    val IntMandatory    = 42: Int
    val StringMandatory = "<empty>"
  }
}

class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with NodeABase
    with StaticType[NodeAEMT] {
  def node_b: Option[NodeB] = flatgraph.Accessors.getNodePropertyOption[NodeB](graph, nodeKind, 6, seq)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intList"
      case 1 => "intMandatory"
      case 2 => "intOptional"
      case 3 => "stringList"
      case 4 => "stringMandatory"
      case 5 => "stringOptional"
      case 6 => "node_b"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intList
      case 1 => this.intMandatory
      case 2 => this.intOptional
      case 3 => this.stringList
      case 4 => this.stringMandatory
      case 5 => this.stringOptional
      case 6 => this.node_b
      case _ => null
    }

  override def productPrefix = "NodeA"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeA]
}

object NewNodeA {
  def apply(): NewNodeA                              = new NewNodeA
  private val outNeighbors: Map[String, Set[String]] = Map("connected_to" -> Set("node_a"))
  private val inNeighbors: Map[String, Set[String]]  = Map("connected_to" -> Set("node_a"))
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

  var intList: IndexedSeq[Int]                           = ArraySeq.empty
  var intMandatory: Int                                  = 42: Int
  var intOptional: Option[Int]                           = None
  var node_b: Option[NodeBBase]                          = None
  var stringList: IndexedSeq[String]                     = ArraySeq.empty
  var stringMandatory: String                            = "<empty>": String
  var stringOptional: Option[String]                     = None
  def intList(value: IterableOnce[Int]): this.type       = { this.intList = value.iterator.to(ArraySeq); this }
  def intMandatory(value: Int): this.type                = { this.intMandatory = value; this }
  def intOptional(value: Int): this.type                 = { this.intOptional = Option(value); this }
  def intOptional(value: Option[Int]): this.type         = { this.intOptional = value; this }
  def node_b(value: NodeBBase): this.type                = { this.node_b = Option(value); this }
  def node_b(value: Option[NodeBBase]): this.type        = { this.node_b = value; this }
  def stringList(value: IterableOnce[String]): this.type = { this.stringList = value.iterator.to(ArraySeq); this }
  def stringMandatory(value: String): this.type          = { this.stringMandatory = value; this }
  def stringOptional(value: Option[String]): this.type   = { this.stringOptional = value; this }
  def stringOptional(value: String): this.type           = { this.stringOptional = Option(value); this }
  override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    if (intList.nonEmpty) interface.insertProperty(this, 0, this.intList)
    interface.insertProperty(this, 1, Iterator(this.intMandatory))
    if (intOptional.nonEmpty) interface.insertProperty(this, 2, this.intOptional)
    if (stringList.nonEmpty) interface.insertProperty(this, 3, this.stringList)
    interface.insertProperty(this, 4, Iterator(this.stringMandatory))
    if (stringOptional.nonEmpty) interface.insertProperty(this, 5, this.stringOptional)
    if (node_b.nonEmpty) interface.insertProperty(this, 6, this.node_b)
  }

  override def copy(): this.type = {
    val newInstance = new NewNodeA
    newInstance.intList = this.intList
    newInstance.intMandatory = this.intMandatory
    newInstance.intOptional = this.intOptional
    newInstance.stringList = this.stringList
    newInstance.stringMandatory = this.stringMandatory
    newInstance.stringOptional = this.stringOptional
    newInstance.node_b = this.node_b
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intList"
      case 1 => "intMandatory"
      case 2 => "intOptional"
      case 3 => "stringList"
      case 4 => "stringMandatory"
      case 5 => "stringOptional"
      case 6 => "node_b"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intList
      case 1 => this.intMandatory
      case 2 => this.intOptional
      case 3 => this.stringList
      case 4 => this.stringMandatory
      case 5 => this.stringOptional
      case 6 => this.node_b
      case _ => null
    }

  override def productPrefix                = "NewNodeA"
  override def productArity                 = 7
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeA]
}
