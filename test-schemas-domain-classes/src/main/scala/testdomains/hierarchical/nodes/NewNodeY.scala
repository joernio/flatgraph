package testdomains.hierarchical.nodes

import testdomains.hierarchical.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

object NewNodeY {
  def apply(): NewNodeY                              = new NewNodeY
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map()

  object InsertionHelpers {
    object NewNodeInserter_NodeY_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeY =>
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

class NewNodeY extends NewNode(nodeKind = 1) with NodeYBase with BaseNodeNew {
  override type StoredNodeType = NodeY
  override def label: String = "node_y"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeY.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeY.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "<empty>": String
  def name(value: String): this.type = { this.name = value; this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, 1)
  }

  override def copy: this.type = {
    val newInstance = new NewNodeY
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

  override def productPrefix                = "NewNodeY"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeY]
}
