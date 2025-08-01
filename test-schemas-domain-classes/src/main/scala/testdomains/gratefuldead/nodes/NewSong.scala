package testdomains.gratefuldead.nodes

import testdomains.gratefuldead.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

object NewSong {
  def apply(): NewSong = new NewSong
  private val outNeighbors: Map[String, Set[String]] =
    Map("followedBy" -> Set("song"), "sungBy" -> Set("artist"), "writtenBy" -> Set("artist"))
  private val inNeighbors: Map[String, Set[String]] = Map("followedBy" -> Set("song"))

  object InsertionHelpers {
    object NewNodeInserter_Song_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewSong =>
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
    object NewNodeInserter_Song_performances extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Int]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewSong =>
              generated.performances match {
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
    object NewNodeInserter_Song_songtype extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewSong =>
              generated.songtype match {
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

class NewSong extends NewNode(nodeKind = 1) with SongBase {
  override type StoredNodeType = Song
  override def label: String = "song"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewSong.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewSong.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                                = "": String
  var performances: Option[Int]                   = None
  var songtype: Option[String]                    = None
  def name(value: String): this.type              = { this.name = value; this }
  def performances(value: Int): this.type         = { this.performances = Option(value); this }
  def performances(value: Option[Int]): this.type = { this.performances = value; this }
  def songtype(value: Option[String]): this.type  = { this.songtype = value; this }
  def songtype(value: String): this.type          = { this.songtype = Option(value); this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, 1)
    interface.countProperty(this, 1, performances.size)
    interface.countProperty(this, 2, songtype.size)
  }

  override def copy: this.type = {
    val newInstance = new NewSong
    newInstance.name = this.name
    newInstance.performances = this.performances
    newInstance.songtype = this.songtype
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "name"
      case 1 => "performances"
      case 2 => "songtype"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.name
      case 1 => this.performances
      case 2 => this.songtype
      case _ => null
    }

  override def productPrefix                = "NewSong"
  override def productArity                 = 3
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewSong]
}
