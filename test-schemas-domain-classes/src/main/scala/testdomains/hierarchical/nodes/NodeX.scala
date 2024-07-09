package testdomains.hierarchical.nodes

import testdomains.hierarchical.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeXEMT extends AnyRef with BaseNodeEMT

trait NodeXBase extends AbstractNode with BaseNodeBase with StaticType[NodeXEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.hierarchical.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.name) res.put("name", this.name)
    res
  }
}

object NodeX {
  val Label = "node_x"
  object PropertyNames {

    val Name = "name"
  }
  object Properties {
    val Name = flatgraph.SinglePropertyKey[String](kind = 0, name = "name", default = "<empty>")
  }
  object PropertyDefaults {
    val Name = "<empty>"
  }
}

class NodeX(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with NodeXBase
    with BaseNode
    with StaticType[NodeXEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case _ => null
    }

  override def productPrefix = "NodeX"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeX]
}

object NewNodeX {
  def apply(): NewNodeX                              = new NewNodeX
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map()

  object InsertionHelpers {
    object NewNodeInserter_NodeX_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeX =>
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
  }
}

class NewNodeX extends NewNode(0.toShort) with NodeXBase with BaseNodeNew {
  override type StoredNodeType = NodeX
  override def label: String = "node_x"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeX.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeX.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "<empty>": String
  def name(value: String): this.type = { this.name = value; this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, 1)
  }

  override def copy: this.type = {
    val newInstance = new NewNodeX
    newInstance.name = this.name
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case _ => null
    }

  override def productPrefix                = "NewNodeX"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeX]
}
