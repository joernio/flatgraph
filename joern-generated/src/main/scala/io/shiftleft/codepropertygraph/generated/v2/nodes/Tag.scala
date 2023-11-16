package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait TagEMT extends AnyRef with HasNameEMT with HasValueEMT

trait TagBase extends AbstractNode with StaticType[TagEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("NAME", this.name)
    res.put("VALUE", this.value)
    res
  }
}

object Tag {
  val Label = "TAG"
  object PropertyNames {
    val Name  = io.shiftleft.codepropertygraph.generated.v2.PropertyNames.NAME
    val Value = io.shiftleft.codepropertygraph.generated.v2.PropertyNames.VALUE
  }
  object PropertyDefaults {
    val Name  = "<empty>"
    val Value = ""
  }
}

class Tag(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, 35.toShort, seq_4762) with TagBase with StaticType[TagEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.value
      case _ => null
    }

  override def productPrefix = "Tag"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Tag]

  override def propertyDefaultValue(propertyKey: String) =
    propertyKey match {
      case "NAME"  => Tag.PropertyDefaults.Name
      case "VALUE" => Tag.PropertyDefaults.Value
      case _       => super.propertyDefaultValue(propertyKey)
    }

}

object NewTag {
  def apply(): NewTag                                = new NewTag
  private val outNeighbors: Map[String, Set[String]] = Map("TAGGED_BY" -> Set("TAG"))
  private val inNeighbors: Map[String, Set[String]] = Map(
    "TAGGED_BY" -> Set(
      "BLOCK",
      "CALL",
      "CONTROL_STRUCTURE",
      "FIELD_IDENTIFIER",
      "FILE",
      "IDENTIFIER",
      "IMPORT",
      "JUMP_TARGET",
      "LITERAL",
      "LOCAL",
      "MEMBER",
      "METHOD",
      "METHOD_PARAMETER_IN",
      "METHOD_PARAMETER_OUT",
      "METHOD_REF",
      "METHOD_RETURN",
      "RETURN",
      "TAG",
      "TEMPLATE_DOM",
      "TYPE_REF",
      "UNKNOWN"
    )
  )
}
class NewTag extends NewNode(35.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String = "TAG"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewTag.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewTag.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 51, Iterator(this.value))
  }

  override def copy(): this.type = {
    val newInstance = new NewTag
    newInstance.name = this.name
    newInstance.value = this.value
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.value
      case _ => null
    }

  override def productPrefix                = "NewTag"
  override def productArity                 = 2
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewTag]
}
