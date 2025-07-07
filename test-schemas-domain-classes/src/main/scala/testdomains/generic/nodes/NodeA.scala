package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
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
    import testdomains.generic.accessors.languagebootstrap.*
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
}

/** * NODE PROPERTIES:
  *
  * ▸ IntList (Int); Cardinality `List` (many)
  *
  * ▸ IntMandatory (Int); Cardinality `one` (mandatory with default value `42`)
  *
  * ▸ IntOptional (Int); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ StringList (String); Cardinality `List` (many)
  *
  * ▸ StringMandatory (String); Cardinality `one` (mandatory with default value `<empty>`)
  *
  * ▸ StringOptional (String); Cardinality `ZeroOrOne` (optional)
  *
  * CONTAINED NODES:
  *
  * ▸ node_b (NodeB); Cardinality `ZeroOrOne` (optional)
  */
class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0, seq_4762)
    with NodeABase
    with StaticType[NodeAEMT] {
  def node_b: Option[NodeB] = flatgraph.Accessors.getNodePropertyOption[NodeB](graph, nodeKind = nodeKind, propertyKind = 6, seq = seq)

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
