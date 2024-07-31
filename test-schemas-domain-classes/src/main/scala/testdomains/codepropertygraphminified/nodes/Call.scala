package testdomains.codepropertygraphminified.nodes

import testdomains.codepropertygraphminified.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait CallEMT extends AnyRef with CallReprEMT with HasDispatchTypeEMT

trait CallBase extends AbstractNode with CallReprBase with StaticType[CallEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.codepropertygraphminified.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.dispatchType) res.put("DISPATCH_TYPE", this.dispatchType)
    if (("<empty>": String) != this.name) res.put("NAME", this.name)
    if ((-1: Int) != this.order) res.put("ORDER", this.order)
    res
  }
}

object Call {
  val Label = "CALL"
  object PropertyNames {

    val DispatchType = "DISPATCH_TYPE"

    val Name = "NAME"

    val Order = "ORDER"
  }
  object Properties {
    val DispatchType = flatgraph.SinglePropertyKey[String](kind = 0, name = "DISPATCH_TYPE", default = "<empty>")
    val Name         = flatgraph.SinglePropertyKey[String](kind = 1, name = "NAME", default = "<empty>")
    val Order        = flatgraph.SinglePropertyKey[Int](kind = 2, name = "ORDER", default = -1: Int)
  }
  object PropertyDefaults {
    val DispatchType = "<empty>"
    val Name         = "<empty>"
    val Order        = -1: Int
  }
}

class Call(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with CallBase
    with CallRepr
    with StaticType[CallEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "dispatchType"
      case 1 => "name"
      case 2 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.dispatchType
      case 1 => this.name
      case 2 => this.order
      case _ => null
    }

  override def productPrefix = "Call"
  override def productArity  = 3

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Call]
}

object NewCall {
  def apply(): NewCall                               = new NewCall
  private val outNeighbors: Map[String, Set[String]] = Map("CALL" -> Set("METHOD"))
  private val inNeighbors: Map[String, Set[String]]  = Map()

  object InsertionHelpers {
    object NewNodeInserter_Call_dispatchType extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewCall =>
              dstCast(offset) = generated.dispatchType
              offset += 1
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_Call_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewCall =>
              dstCast(offset) = generated.name
              offset += 1
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_Call_order extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Int]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewCall =>
              dstCast(offset) = generated.order
              offset += 1
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
  }
}

class NewCall extends NewNode(0.toShort) with CallBase with CallReprNew {
  override type StoredNodeType = Call
  override def label: String = "CALL"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewCall.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewCall.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var dispatchType: String                   = "<empty>": String
  var name: String                           = "<empty>": String
  var order: Int                             = -1: Int
  def dispatchType(value: String): this.type = { this.dispatchType = value; this }
  def name(value: String): this.type         = { this.name = value; this }
  def order(value: Int): this.type           = { this.order = value; this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, 1)
    interface.countProperty(this, 1, 1)
    interface.countProperty(this, 2, 1)
  }

  override def copy: this.type = {
    val newInstance = new NewCall
    newInstance.dispatchType = this.dispatchType
    newInstance.name = this.name
    newInstance.order = this.order
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "dispatchType"
      case 1 => "name"
      case 2 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.dispatchType
      case 1 => this.name
      case 2 => this.order
      case _ => null
    }

  override def productPrefix                = "NewCall"
  override def productArity                 = 3
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewCall]
}
