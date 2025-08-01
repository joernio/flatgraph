package testdomains.gratefuldead.nodes

import testdomains.gratefuldead.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

object NewArtist {
  def apply(): NewArtist                             = new NewArtist
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map("sungBy" -> Set("song"), "writtenBy" -> Set("song"))

  object InsertionHelpers {
    object NewNodeInserter_Artist_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewArtist =>
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

class NewArtist extends NewNode(nodeKind = 0) with ArtistBase {
  override type StoredNodeType = Artist
  override def label: String = "artist"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewArtist.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewArtist.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "": String
  def name(value: String): this.type = { this.name = value; this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, 1)
  }

  override def copy: this.type = {
    val newInstance = new NewArtist
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

  override def productPrefix                = "NewArtist"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewArtist]
}
