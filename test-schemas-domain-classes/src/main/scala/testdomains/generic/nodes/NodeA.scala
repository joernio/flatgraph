package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeAEMT
    extends AnyRef
    with HasBooleanOptionalEMT
    with HasDoubleOptionalEMT
    with HasFloatOptionalEMT
    with HasIntListEMT
    with HasIntMandatoryEMT
    with HasIntOptionalEMT
    with HasLongOptionalEMT
    with HasStringListEMT
    with HasStringMandatoryEMT
    with HasStringOptionalEMT

trait NodeABase extends AbstractNode with StaticType[NodeAEMT] {
  def contained_node_b: Option[NodeBBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.generic.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    this.booleanOptional.foreach { p => res.put("boolean_optional", p) }
    this.doubleOptional.foreach { p => res.put("double_optional", p) }
    this.floatOptional.foreach { p => res.put("float_optional", p) }
    val tmpIntList = this.intList; if (tmpIntList.nonEmpty) res.put("int_list", tmpIntList)
    if ((42: Int) != this.intMandatory) res.put("int_mandatory", this.intMandatory)
    this.intOptional.foreach { p => res.put("int_optional", p) }
    this.longOptional.foreach { p => res.put("long_optional", p) }
    val tmpStringList = this.stringList; if (tmpStringList.nonEmpty) res.put("string_list", tmpStringList)
    if (("<empty>": String) != this.stringMandatory) res.put("string_mandatory", this.stringMandatory)
    this.stringOptional.foreach { p => res.put("string_optional", p) }
    this.contained_node_b.foreach { p => res.put("contained_node_b", p) }
    res
  }
}

object NodeA {
  val Label = "node_a"
}

/** * NODE PROPERTIES:
  *
  * ▸ BooleanOptional (Boolean); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ DoubleOptional (Double); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ FloatOptional (Float); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ IntList (Int); Cardinality `List` (many)
  *
  * ▸ IntMandatory (Int); Cardinality `one` (mandatory with default value `42`)
  *
  * ▸ IntOptional (Int); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ LongOptional (Long); Cardinality `ZeroOrOne` (optional)
  *
  * ▸ StringList (String); Cardinality `List` (many)
  *
  * ▸ StringMandatory (String); Cardinality `one` (mandatory with default value `<empty>`)
  *
  * ▸ StringOptional (String); Cardinality `ZeroOrOne` (optional)
  *
  * CONTAINED NODES:
  *
  * ▸ contained_node_b (NodeB); Cardinality `ZeroOrOne` (optional)
  */
class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0, seq_4762)
    with NodeABase
    with StaticType[NodeAEMT] {
  def contained_node_b: Option[NodeB] =
    flatgraph.Accessors.getNodePropertyOption[NodeB](graph, nodeKind = nodeKind, propertyKind = 10, seq = seq)

  override def productElementName(n: Int): String =
    n match {
      case 0  => "booleanOptional"
      case 1  => "doubleOptional"
      case 2  => "floatOptional"
      case 3  => "intList"
      case 4  => "intMandatory"
      case 5  => "intOptional"
      case 6  => "longOptional"
      case 7  => "stringList"
      case 8  => "stringMandatory"
      case 9  => "stringOptional"
      case 10 => "contained_node_b"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.booleanOptional
      case 1  => this.doubleOptional
      case 2  => this.floatOptional
      case 3  => this.intList
      case 4  => this.intMandatory
      case 5  => this.intOptional
      case 6  => this.longOptional
      case 7  => this.stringList
      case 8  => this.stringMandatory
      case 9  => this.stringOptional
      case 10 => this.contained_node_b
      case _  => null
    }

  override def productPrefix = "NodeA"
  override def productArity  = 11

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeA]
}
