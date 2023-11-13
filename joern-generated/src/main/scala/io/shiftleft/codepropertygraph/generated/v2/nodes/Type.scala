package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait TypeEMT extends AnyRef with HasFullNameEMT with HasNameEMT with HasTypeDeclFullNameEMT

trait TypeBase extends AbstractNode with StaticType[TypeEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("FULL_NAME", this.fullName)
    res.put("NAME", this.name)
    res.put("TYPE_DECL_FULL_NAME", this.typeDeclFullName)
    res
  }
}

object Type {
  val Label = "TYPE"
  object PropertyKinds {
    val FullName         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.FULL_NAME
    val Name             = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val TypeDeclFullName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.TYPE_DECL_FULL_NAME
  }
}

class Type(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 38.toShort, seq_4762)
    with TypeBase
    with StaticType[TypeEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "fullName"
      case 1 => "name"
      case 2 => "typeDeclFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.fullName
      case 1 => this.name
      case 2 => this.typeDeclFullName
      case _ => null
    }

  override def productPrefix = "Type"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Type]
}

object NewType { def apply(): NewType = new NewType }
class NewType extends NewNode(38.toShort) with TypeBase {
  type RelatedStored = Type
  override def label: String                     = "TYPE"
  var fullName: String                           = "<empty>": String
  var name: String                               = "<empty>": String
  var typeDeclFullName: String                   = "<empty>": String
  def fullName(value: String): this.type         = { this.fullName = value; this }
  def name(value: String): this.type             = { this.name = value; this }
  def typeDeclFullName(value: String): this.type = { this.typeDeclFullName = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 22, Iterator(this.fullName))
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 49, Iterator(this.typeDeclFullName))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "fullName"
      case 1 => "name"
      case 2 => "typeDeclFullName"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.fullName
      case 1 => this.name
      case 2 => this.typeDeclFullName
      case _ => null
    }

  override def productPrefix                = "NewType"
  override def productArity                 = 3
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewType]
}
