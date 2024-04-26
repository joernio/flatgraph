package flatgraph.testdomains.generic.accessors
import flatgraph.testdomains.generic.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_intList(val node: nodes.StoredNode) extends AnyVal {
    def intlist: IndexedSeq[Int] = flatgraph.Accessors.getNodePropertyMulti[Int](node.graph, node.nodeKind, 0, node.seq)
  }
  final class Access_Property_intMandatory(val node: nodes.StoredNode) extends AnyVal {
    def intmandatory: Int = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), 42: Int)
  }
  final class Access_Property_intOptional(val node: nodes.StoredNode) extends AnyVal {
    def intoptional: Option[Int] =
      flatgraph.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 2, node.seq)
  }
  final class Access_Property_stringList(val node: nodes.StoredNode) extends AnyVal {
    def stringlist: IndexedSeq[String] =
      flatgraph.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 3, node.seq)
  }
  final class Access_Property_stringMandatory(val node: nodes.StoredNode) extends AnyVal {
    def stringmandatory: String =
      flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }
  final class Access_Property_stringOptional(val node: nodes.StoredNode) extends AnyVal {
    def stringoptional: Option[String] =
      flatgraph.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 5, node.seq)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_NodeABase(val node: nodes.NodeABase) extends AnyVal {
    def intlist: IndexedSeq[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_intList(stored).intlist
      case newNode: nodes.NewNodeA  => newNode.intlist
    }
    def intmandatory: Int = node match {
      case stored: nodes.StoredNode => new Access_Property_intMandatory(stored).intmandatory
      case newNode: nodes.NewNodeA  => newNode.intmandatory
    }
    def intoptional: Option[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_intOptional(stored).intoptional
      case newNode: nodes.NewNodeA  => newNode.intoptional
    }
    def stringlist: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_stringList(stored).stringlist
      case newNode: nodes.NewNodeA  => newNode.stringlist
    }
    def stringmandatory: String = node match {
      case stored: nodes.StoredNode => new Access_Property_stringMandatory(stored).stringmandatory
      case newNode: nodes.NewNodeA  => newNode.stringmandatory
    }
    def stringoptional: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_stringOptional(stored).stringoptional
      case newNode: nodes.NewNodeA  => newNode.stringoptional
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyIntlist(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntlistEMT]): Access_Property_intList =
    new Access_Property_intList(node)
  implicit def accessPropertyIntmandatory(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasIntmandatoryEMT]
  ): Access_Property_intMandatory = new Access_Property_intMandatory(node)
  implicit def accessPropertyIntoptional(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntoptionalEMT]): Access_Property_intOptional =
    new Access_Property_intOptional(node)
  implicit def accessPropertyStringlist(node: nodes.StoredNode & nodes.StaticType[nodes.HasStringlistEMT]): Access_Property_stringList =
    new Access_Property_stringList(node)
  implicit def accessPropertyStringmandatory(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringmandatoryEMT]
  ): Access_Property_stringMandatory = new Access_Property_stringMandatory(node)
  implicit def accessPropertyStringoptional(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringoptionalEMT]
  ): Access_Property_stringOptional = new Access_Property_stringOptional(node)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def access_NodeABase(node: nodes.NodeABase): Access_NodeABase = new Access_NodeABase(node)
}
