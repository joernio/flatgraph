package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

object NewNodeB {
  def apply(): NewNodeB                              = new NewNodeB
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map("another_edge" -> Set("node_a"))

  object InsertionHelpers {
    object NewNodeInserter_NodeB_stringOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeB =>
              generated.stringOptional match {
                case Some(item) =>
                  dstCast(offset) = item
                  offset += 1
                case _ =>
              }
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

class NewNodeB extends NewNode(nodeKind = 1) with NodeBBase {
  override type StoredNodeType = NodeB
  override def label: String = "node_b"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeB.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeB.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var stringOptional: Option[String]                   = None
  def stringOptional(value: Option[String]): this.type = { this.stringOptional = value; this }
  def stringOptional(value: String): this.type         = { this.stringOptional = Option(value); this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 5, stringOptional.size)
  }

  override def copy: this.type = {
    val newInstance = new NewNodeB
    newInstance.stringOptional = this.stringOptional
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "stringOptional"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.stringOptional
      case _ => null
    }

  override def productPrefix                = "NewNodeB"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeB]
}
