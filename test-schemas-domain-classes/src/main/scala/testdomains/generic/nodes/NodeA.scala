package testdomains.generic.nodes

import testdomains.generic.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait NodeAEMT
    extends AnyRef
    with HasIntListEMT
    with HasIntMandatoryEMT
    with HasIntOptionalEMT
    with HasStringListEMT
    with HasStringMandatoryEMT
    with HasStringOptionalEMT

trait NodeABase extends AbstractNode with StaticType[NodeAEMT] {
  def node_b: Option[NodeBBase]
  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.generic.accessors.languagebootstrap.*
    val res        = new java.util.HashMap[String, Any]()
    val tmpIntList = this.intList; if (tmpIntList.nonEmpty) res.put("int_list", tmpIntList)
    if ((42: Int) != this.intMandatory) res.put("int_mandatory", this.intMandatory)
    this.intOptional.foreach { p => res.put("int_optional", p) }
    val tmpStringList = this.stringList; if (tmpStringList.nonEmpty) res.put("string_list", tmpStringList)
    if (("<empty>": String) != this.stringMandatory) res.put("string_mandatory", this.stringMandatory)
    this.stringOptional.foreach { p => res.put("string_optional", p) }
    this.node_b.foreach { p => res.put("node_b", p) }
    res
  }
}

object NodeA {
  val Label = "node_a"
  object PropertyNames {

    val IntList = "int_list"

    val IntMandatory = "int_mandatory"

    val IntOptional = "int_optional"

    val StringList = "string_list"

    val StringMandatory = "string_mandatory"

    val StringOptional = "string_optional"
    val NodeB          = "node_b"
  }
  object Properties {
    val IntList         = flatgraph.MultiPropertyKey[Int](kind = 0, name = "int_list")
    val IntMandatory    = flatgraph.SinglePropertyKey[Int](kind = 1, name = "int_mandatory", default = 42: Int)
    val IntOptional     = flatgraph.OptionalPropertyKey[Int](kind = 2, name = "int_optional")
    val StringList      = flatgraph.MultiPropertyKey[String](kind = 3, name = "string_list")
    val StringMandatory = flatgraph.SinglePropertyKey[String](kind = 4, name = "string_mandatory", default = "<empty>")
    val StringOptional  = flatgraph.OptionalPropertyKey[String](kind = 5, name = "string_optional")
  }
  object PropertyDefaults {
    val IntMandatory    = 42: Int
    val StringMandatory = "<empty>"
  }
}

class NodeA(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 0.toShort, seq_4762)
    with NodeABase
    with StaticType[NodeAEMT] {
  def node_b: Option[NodeB] = flatgraph.Accessors.getNodePropertyOption[NodeB](graph, nodeKind, 6, seq)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intList"
      case 1 => "intMandatory"
      case 2 => "intOptional"
      case 3 => "stringList"
      case 4 => "stringMandatory"
      case 5 => "stringOptional"
      case 6 => "node_b"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intList
      case 1 => this.intMandatory
      case 2 => this.intOptional
      case 3 => this.stringList
      case 4 => this.stringMandatory
      case 5 => this.stringOptional
      case 6 => this.node_b
      case _ => null
    }

  override def productPrefix = "NodeA"
  override def productArity  = 7

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NodeA]
}

object NewNodeA {
  def apply(): NewNodeA                              = new NewNodeA
  private val outNeighbors: Map[String, Set[String]] = Map("connected_to" -> Set("node_a"))
  private val inNeighbors: Map[String, Set[String]]  = Map("connected_to" -> Set("node_a"))

  object InsertionHelpers {
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
    object NewNodeInserter_NodeA_node_b extends flatgraph.NewNodePropertyInsertionHelper {
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
              generated.node_b match {
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

class NewNodeA extends NewNode(0.toShort) with NodeABase {
  override type StoredNodeType = NodeA
  override def label: String = "node_a"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewNodeA.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var intList: IndexedSeq[Int]                           = ArraySeq.empty
  var intMandatory: Int                                  = 42: Int
  var intOptional: Option[Int]                           = None
  var node_b: Option[NodeBBase]                          = None
  var stringList: IndexedSeq[String]                     = ArraySeq.empty
  var stringMandatory: String                            = "<empty>": String
  var stringOptional: Option[String]                     = None
  def intList(value: IterableOnce[Int]): this.type       = { this.intList = value.iterator.to(ArraySeq); this }
  def intMandatory(value: Int): this.type                = { this.intMandatory = value; this }
  def intOptional(value: Int): this.type                 = { this.intOptional = Option(value); this }
  def intOptional(value: Option[Int]): this.type         = { this.intOptional = value; this }
  def node_b(value: NodeBBase): this.type                = { this.node_b = Option(value); this }
  def node_b(value: Option[NodeBBase]): this.type        = { this.node_b = value; this }
  def stringList(value: IterableOnce[String]): this.type = { this.stringList = value.iterator.to(ArraySeq); this }
  def stringMandatory(value: String): this.type          = { this.stringMandatory = value; this }
  def stringOptional(value: Option[String]): this.type   = { this.stringOptional = value; this }
  def stringOptional(value: String): this.type           = { this.stringOptional = Option(value); this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 0, intList.size)
    interface.countProperty(this, 1, 1)
    interface.countProperty(this, 2, intOptional.size)
    interface.countProperty(this, 3, stringList.size)
    interface.countProperty(this, 4, 1)
    interface.countProperty(this, 5, stringOptional.size)
    interface.countProperty(this, 6, node_b.size)
    node_b.foreach(interface.visitContainedNode)
  }

  override def copy: this.type = {
    val newInstance = new NewNodeA
    newInstance.intList = this.intList
    newInstance.intMandatory = this.intMandatory
    newInstance.intOptional = this.intOptional
    newInstance.stringList = this.stringList
    newInstance.stringMandatory = this.stringMandatory
    newInstance.stringOptional = this.stringOptional
    newInstance.node_b = this.node_b
    newInstance.asInstanceOf[this.type]
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "intList"
      case 1 => "intMandatory"
      case 2 => "intOptional"
      case 3 => "stringList"
      case 4 => "stringMandatory"
      case 5 => "stringOptional"
      case 6 => "node_b"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.intList
      case 1 => this.intMandatory
      case 2 => this.intOptional
      case 3 => this.stringList
      case 4 => this.stringMandatory
      case 5 => this.stringOptional
      case 6 => this.node_b
      case _ => null
    }

  override def productPrefix                = "NewNodeA"
  override def productArity                 = 7
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewNodeA]
}
