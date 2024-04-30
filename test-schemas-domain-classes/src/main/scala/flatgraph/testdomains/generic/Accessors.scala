package flatgraph.testdomains.generic.accessors
import flatgraph.testdomains.generic.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_int_list(val node: nodes.StoredNode) extends AnyVal {
    def intList: IndexedSeq[Int] = flatgraph.Accessors.getNodePropertyMulti[Int](node.graph, node.nodeKind, 0, node.seq)
  }
  final class Access_Property_int_mandatory(val node: nodes.StoredNode) extends AnyVal {
    def intMandatory: Int = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), 42: Int)
  }
  final class Access_Property_int_optional(val node: nodes.StoredNode) extends AnyVal {
    def intOptional: Option[Int] =
      flatgraph.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 2, node.seq)
  }
  final class Access_Property_string_list(val node: nodes.StoredNode) extends AnyVal {
    def stringList: IndexedSeq[String] =
      flatgraph.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 3, node.seq)
  }
  final class Access_Property_string_mandatory(val node: nodes.StoredNode) extends AnyVal {
    def stringMandatory: String =
      flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }
  final class Access_Property_string_optional(val node: nodes.StoredNode) extends AnyVal {
    def stringOptional: Option[String] =
      flatgraph.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 5, node.seq)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_NodeABase(val node: nodes.NodeABase) extends AnyVal {
    def intList: IndexedSeq[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_int_list(stored).intList
      case newNode: nodes.NewNodeA  => newNode.intList
    }
    def intMandatory: Int = node match {
      case stored: nodes.StoredNode => new Access_Property_int_mandatory(stored).intMandatory
      case newNode: nodes.NewNodeA  => newNode.intMandatory
    }
    def intOptional: Option[Int] = node match {
      case stored: nodes.StoredNode => new Access_Property_int_optional(stored).intOptional
      case newNode: nodes.NewNodeA  => newNode.intOptional
    }
    def stringList: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_string_list(stored).stringList
      case newNode: nodes.NewNodeA  => newNode.stringList
    }
    def stringMandatory: String = node match {
      case stored: nodes.StoredNode => new Access_Property_string_mandatory(stored).stringMandatory
      case newNode: nodes.NewNodeA  => newNode.stringMandatory
    }
    def stringOptional: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_string_optional(stored).stringOptional
      case newNode: nodes.NewNodeA  => newNode.stringOptional
    }
  }
  final class Access_NodeBBase(val node: nodes.NodeBBase) extends AnyVal {
    def stringOptional: Option[String] = node match {
      case stored: nodes.StoredNode => new Access_Property_string_optional(stored).stringOptional
      case newNode: nodes.NewNodeB  => newNode.stringOptional
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyIntList(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]): Access_Property_int_list =
    new Access_Property_int_list(node)
  implicit def accessPropertyIntMandatory(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]
  ): Access_Property_int_mandatory = new Access_Property_int_mandatory(node)
  implicit def accessPropertyIntOptional(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]): Access_Property_int_optional =
    new Access_Property_int_optional(node)
  implicit def accessPropertyStringList(node: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]): Access_Property_string_list =
    new Access_Property_string_list(node)
  implicit def accessPropertyStringMandatory(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]
  ): Access_Property_string_mandatory = new Access_Property_string_mandatory(node)
  implicit def accessPropertyStringOptional(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]
  ): Access_Property_string_optional = new Access_Property_string_optional(node)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def access_NodeABase(node: nodes.NodeABase): Access_NodeABase = new Access_NodeABase(node)
  implicit def access_NodeBBase(node: nodes.NodeBBase): Access_NodeBBase = new Access_NodeBBase(node)
}
