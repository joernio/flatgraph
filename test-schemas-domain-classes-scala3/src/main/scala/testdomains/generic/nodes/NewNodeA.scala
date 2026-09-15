package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

object NewNodeA {
  def apply(): NewNodeA                              = new NewNodeA
  private val outNeighbors: Map[String, Set[String]] = Map("another_edge" -> Set("node_b"), "connected_to" -> Set("node_a"))
  private val inNeighbors: Map[String, Set[String]]  = Map("connected_to" -> Set("node_a"))

  object InsertionHelpers {
    object NewNodeInserter_NodeA_booleanOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Boolean]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.booleanOptional match {
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
    object NewNodeInserter_NodeA_doubleOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Double]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.doubleOptional match {
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
    object NewNodeInserter_NodeA_floatOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Float]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.floatOptional match {
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
    object NewNodeInserter_NodeA_intList extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Int]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              for (item <- generated.intList) {
                dstCast(offset) = item
                offset += 1
              }
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_NodeA_intMandatory extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Int]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              dstCast(offset) = generated.intMandatory
              offset += 1
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_NodeA_intOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Int]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.intOptional match {
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
    object NewNodeInserter_NodeA_longOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[Long]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.longOptional match {
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
    object NewNodeInserter_NodeA_stringList extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              for (item <- generated.stringList) {
                dstCast(offset) = item
                offset += 1
              }
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_NodeA_stringMandatory extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              dstCast(offset) = generated.stringMandatory
              offset += 1
            case _ =>
          }
          assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
          idx += 1
          offsets(idx + seq) = offset
        }
      }
    }
    object NewNodeInserter_NodeA_stringOptional extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
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
    object NewNodeInserter_NodeA_contained_node_b extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[flatgraph.GNode]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewNodeA =>
              generated.contained_node_b match {
                case Some(item) =>
                  dstCast(offset) = item match {
                    case newV: flatgraph.DNode => newV.storedRef.get; case oldV: flatgraph.GNode => oldV; case null => null
                  }
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

class NewNodeA extends NewNode(nodeKind = 0) with NodeABase {
  override type StoredNodeType = NodeA
  override def label: String = "node_a"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var booleanOptional: Option[Boolean]                      = None
  var contained_node_b: Option[NodeBBase]                   = None
  var doubleOptional: Option[Double]                        = None
  var floatOptional: Option[Float]                          = None
  var intList: IndexedSeq[Int]                              = ArraySeq.empty
  var intMandatory: Int                                     = 42: Int
  var intOptional: Option[Int]                              = None
  var longOptional: Option[Long]                            = None
  var stringList: IndexedSeq[String]                        = ArraySeq.empty
  var stringMandatory: String                               = "<empty>": String
  var stringOptional: Option[String]                        = None
  def booleanOptional(value: Boolean): this.type            = { this.booleanOptional = Option(value); this }
  def booleanOptional(value: Option[Boolean]): this.type    = { this.booleanOptional = value; this }
  def contained_node_b(value: NodeBBase): this.type         = { this.contained_node_b = Option(value); this }
  def contained_node_b(value: Option[NodeBBase]): this.type = { this.contained_node_b = value; this }
  def doubleOptional(value: Double): this.type              = { this.doubleOptional = Option(value); this }
  def doubleOptional(value: Option[Double]): this.type      = { this.doubleOptional = value; this }
  def floatOptional(value: Float): this.type                = { this.floatOptional = Option(value); this }
  def floatOptional(value: Option[Float]): this.type        = { this.floatOptional = value; this }
  def intList(value: IterableOnce[Int]): this.type          = { this.intList = value.iterator.to(ArraySeq); this }
  def intMandatory(value: Int): this.type                   = { this.intMandatory = value; this }
  def intOptional(value: Int): this.type                    = { this.intOptional = Option(value); this }
  def intOptional(value: Option[Int]): this.type            = { this.intOptional = value; this }
  def longOptional(value: Long): this.type                  = { this.longOptional = Option(value); this }
  def longOptional(value: Option[Long]): this.type          = { this.longOptional = value; this }
  def stringList(value: IterableOnce[String]): this.type    = { this.stringList = value.iterator.to(ArraySeq); this }
  def stringMandatory(value: String): this.type             = { this.stringMandatory = value; this }
  def stringOptional(value: Option[String]): this.type      = { this.stringOptional = value; this }
  def stringOptional(value: String): this.type              = { this.stringOptional = Option(value); this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, booleanOptional.size)
    interface.countProperty(this, 1, doubleOptional.size)
    interface.countProperty(this, 2, floatOptional.size)
    interface.countProperty(this, 3, intList.size)
    interface.countProperty(this, 4, 1)
    interface.countProperty(this, 5, intOptional.size)
    interface.countProperty(this, 6, longOptional.size)
    interface.countProperty(this, 7, stringList.size)
    interface.countProperty(this, 8, 1)
    interface.countProperty(this, 9, stringOptional.size)
    interface.countProperty(this, 10, contained_node_b.size)
    contained_node_b.foreach(interface.visitContainedNode)
  }

  override def copy: this.type = {
    val newInstance = new NewNodeA
    newInstance.booleanOptional = this.booleanOptional
    newInstance.doubleOptional = this.doubleOptional
    newInstance.floatOptional = this.floatOptional
    newInstance.intList = this.intList
    newInstance.intMandatory = this.intMandatory
    newInstance.intOptional = this.intOptional
    newInstance.longOptional = this.longOptional
    newInstance.stringList = this.stringList
    newInstance.stringMandatory = this.stringMandatory
    newInstance.stringOptional = this.stringOptional
    newInstance.contained_node_b = this.contained_node_b
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0  => "booleanOptional"
      case 1  => "doubleOptional"
      case 2  => "floatOptional"
      case 3  => "intList"
      case 4  => "intMandatory"
      case 5  => "intOptional"
      case 6  => "longOptional"
      case 7  => "stringList"
      case 8  => "stringMandatory"
      case 9  => "stringOptional"
      case 10 => "contained_node_b"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.booleanOptional
      case 1  => this.doubleOptional
      case 2  => this.floatOptional
      case 3  => this.intList
      case 4  => this.intMandatory
      case 5  => this.intOptional
      case 6  => this.longOptional
      case 7  => this.stringList
      case 8  => this.stringMandatory
      case 9  => this.stringOptional
      case 10 => this.contained_node_b
      case _  => null
    }

  override def productPrefix                = "NewNodeA"
  override def productArity                 = 11
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeA]
}
