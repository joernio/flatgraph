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
  object PropertyKinds {
    val Name  = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Value = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.VALUE
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
}

object NewTag { def apply(): NewTag = new NewTag }
class NewTag extends NewNode(35.toShort) with TagBase {
  type RelatedStored = Tag
  override def label: String          = "TAG"
  var name: String                    = "<empty>": String
  var value: String                   = "": String
  def name(value: String): this.type  = { this.name = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 51, Iterator(this.value))
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
