package testdomains.codepropertygraphminified.nodes

import testdomains.codepropertygraphminified.language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}
import scala.collection.mutable

/** Node base type for compiletime-only checks to improve type safety. EMT stands for: "erased marker trait", i.e. it is erased at runtime
  */
trait MethodEMT extends AnyRef with DeclarationEMT

trait MethodBase extends AbstractNode with DeclarationBase with StaticType[MethodEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import testdomains.codepropertygraphminified.accessors.languagebootstrap.*
    val res = new java.util.HashMap[String, Any]()
    if (("<empty>": String) != this.name) res.put("NAME", this.name)
    res
  }
}

object Method {
  val Label = "METHOD"
  object PropertyNames {

    val Name = "NAME"
  }
  object Properties {
    val Name = flatgraph.SinglePropertyKey[String](kind = 1, name = "NAME", default = "<empty>")
  }
  object PropertyDefaults {
    val Name = "<empty>"
  }
}

class Method(graph_4762: flatgraph.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 1.toShort, seq_4762)
    with MethodBase
    with Declaration
    with StaticType[MethodEMT] {

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

  override def productPrefix = "Method"
  override def productArity  = 1

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Method]
}

object NewMethod {
  def apply(): NewMethod                             = new NewMethod
  private val outNeighbors: Map[String, Set[String]] = Map()
  private val inNeighbors: Map[String, Set[String]]  = Map("CALL" -> Set("CALL"))

  object InsertionHelpers {
    object NewNodeInserter_Method_name extends flatgraph.NewNodePropertyInsertionHelper {
      override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
        if (newNodes.isEmpty) return
        val dstCast = dst.asInstanceOf[Array[String]]
        val seq     = newNodes.head.storedRef.get.seq()
        var offset  = offsets(seq)
        var idx     = 0
        while (idx < newNodes.length) {
          val nn = newNodes(idx)
          nn match {
            case generated: NewMethod =>
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

class NewMethod extends NewNode(1.toShort) with MethodBase with DeclarationNew {
  override type StoredNodeType = Method
  override def label: String = "METHOD"

  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewMethod.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }
  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
    NewMethod.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
  }

  var name: String                   = "<empty>": String
  def name(value: String): this.type = { this.name = value; this }
  override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {
    interface.countProperty(this, 1, 1)
  }

  override def copy: this.type = {
    val newInstance = new NewMethod
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

  override def productPrefix                = "NewMethod"
  override def productArity                 = 1
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMethod]
}
