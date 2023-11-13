package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait KeyValuePairEMT extends AnyRef with HasKeyEMT with HasValueEMT
trait KeyValuePairBase extends AbstractNode with StaticType[KeyValuePairEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("KEY", this.key)
    res.put("VALUE", this.value)
    res
  }
}
class KeyValuePair(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 20.toShort, seq_4762)
    with KeyValuePairBase
    with StaticType[KeyValuePairEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "key"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.key
      case 1 => this.value
      case _ => null
    }

  override def productPrefix = "KeyValuePair"
  override def productArity  = 2

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[KeyValuePair]
}
object NewKeyValuePair { def apply(): NewKeyValuePair = new NewKeyValuePair }
class NewKeyValuePair extends NewNode(20.toShort) with KeyValuePairBase {
  type RelatedStored = KeyValuePair
  override def label: String          = "KEY_VALUE_PAIR"
  var key: String                     = "<empty>": String
  var value: String                   = "": String
  def key(value: String): this.type   = { this.key = value; this }
  def value(value: String): this.type = { this.value = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 32, Iterator(this.key))
    interface.insertProperty(this, 51, Iterator(this.value))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "key"
      case 1 => "value"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.key
      case 1 => this.value
      case _ => null
    }

  override def productPrefix                = "NewKeyValuePair"
  override def productArity                 = 2
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewKeyValuePair]
}
