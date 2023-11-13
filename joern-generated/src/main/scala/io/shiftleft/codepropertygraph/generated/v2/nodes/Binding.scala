package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait BindingEMT extends AnyRef with HasMethodFullNameEMT with HasNameEMT with HasSignatureEMT

trait BindingBase extends AbstractNode with StaticType[BindingEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("NAME", this.name)
    res.put("SIGNATURE", this.signature)
    res
  }
}

object Binding {
  val Label = "BINDING"
  object PropertyKinds {
    val MethodFullName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.METHOD_FULL_NAME
    val Name           = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Signature      = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.SIGNATURE
  }
}

class Binding(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 5.toShort, seq_4762)
    with BindingBase
    with StaticType[BindingEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "methodFullName"
      case 1 => "name"
      case 2 => "signature"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.methodFullName
      case 1 => this.name
      case 2 => this.signature
      case _ => null
    }

  override def productPrefix = "Binding"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Binding]
}

object NewBinding { def apply(): NewBinding = new NewBinding }
class NewBinding extends NewNode(5.toShort) with BindingBase {
  type RelatedStored = Binding
  override def label: String                   = "BINDING"
  var methodFullName: String                   = "<empty>": String
  var name: String                             = "<empty>": String
  var signature: String                        = "": String
  def methodFullName(value: String): this.type = { this.methodFullName = value; this }
  def name(value: String): this.type           = { this.name = value; this }
  def signature(value: String): this.type      = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 47, Iterator(this.signature))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "methodFullName"
      case 1 => "name"
      case 2 => "signature"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.methodFullName
      case 1 => this.name
      case 2 => this.signature
      case _ => null
    }

  override def productPrefix                = "NewBinding"
  override def productArity                 = 3
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewBinding]
}
