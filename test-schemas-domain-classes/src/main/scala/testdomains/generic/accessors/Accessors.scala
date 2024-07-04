package testdomains.generic.accessors
import testdomains.generic.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class AccessPropertyIntList(val node: nodes.StoredNode) extends AnyVal {
    def intList: IndexedSeq[Int] = flatgraph.Accessors.getNodePropertyMulti[Int](node.graph, node.nodeKind, 0, node.seq)
  }
  final class AccessPropertyIntMandatory(val node: nodes.StoredNode) extends AnyVal {
    def intMandatory: Int = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), 42: Int)
  }
  final class AccessPropertyIntOptional(val node: nodes.StoredNode) extends AnyVal {
    def intOptional: Option[Int] = flatgraph.Accessors.getNodePropertyOption[Int](node.graph, node.nodeKind, 2, node.seq)
  }
  final class AccessPropertyStringList(val node: nodes.StoredNode) extends AnyVal {
    def stringList: IndexedSeq[String] = flatgraph.Accessors.getNodePropertyMulti[String](node.graph, node.nodeKind, 3, node.seq)
  }
  final class AccessPropertyStringMandatory(val node: nodes.StoredNode) extends AnyVal {
    def stringMandatory: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 4, node.seq(), "<empty>": String)
  }
  final class AccessPropertyStringOptional(val node: nodes.StoredNode) extends AnyVal {
    def stringOptional: Option[String] = flatgraph.Accessors.getNodePropertyOption[String](node.graph, node.nodeKind, 5, node.seq)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class AccessNodeaBase(val node: nodes.NodeABase) extends AnyVal {
    def intList: IndexedSeq[Int] = node match {
      case stored: nodes.StoredNode => new AccessPropertyIntList(stored).intList
      case newNode: nodes.NewNodeA  => newNode.intList
    }
    def intMandatory: Int = node match {
      case stored: nodes.StoredNode => new AccessPropertyIntMandatory(stored).intMandatory
      case newNode: nodes.NewNodeA  => newNode.intMandatory
    }
    def intOptional: Option[Int] = node match {
      case stored: nodes.StoredNode => new AccessPropertyIntOptional(stored).intOptional
      case newNode: nodes.NewNodeA  => newNode.intOptional
    }
    def stringList: IndexedSeq[String] = node match {
      case stored: nodes.StoredNode => new AccessPropertyStringList(stored).stringList
      case newNode: nodes.NewNodeA  => newNode.stringList
    }
    def stringMandatory: String = node match {
      case stored: nodes.StoredNode => new AccessPropertyStringMandatory(stored).stringMandatory
      case newNode: nodes.NewNodeA  => newNode.stringMandatory
    }
    def stringOptional: Option[String] = node match {
      case stored: nodes.StoredNode => new AccessPropertyStringOptional(stored).stringOptional
      case newNode: nodes.NewNodeA  => newNode.stringOptional
    }
  }
  final class AccessNodebBase(val node: nodes.NodeBBase) extends AnyVal {
    def stringOptional: Option[String] = node match {
      case stored: nodes.StoredNode => new AccessPropertyStringOptional(stored).stringOptional
      case newNode: nodes.NewNodeB  => newNode.stringOptional
    }
  }
  /* accessors for base nodes end */
}

import Accessors.*
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  implicit def accessPropertyIntList(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]): AccessPropertyIntList =
    new AccessPropertyIntList(node)
  implicit def accessPropertyIntMandatory(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]): AccessPropertyIntMandatory =
    new AccessPropertyIntMandatory(node)
  implicit def accessPropertyIntOptional(node: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]): AccessPropertyIntOptional =
    new AccessPropertyIntOptional(node)
  implicit def accessPropertyStringList(node: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]): AccessPropertyStringList =
    new AccessPropertyStringList(node)
  implicit def accessPropertyStringMandatory(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]
  ): AccessPropertyStringMandatory = new AccessPropertyStringMandatory(node)
  implicit def accessPropertyStringOptional(
    node: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]
  ): AccessPropertyStringOptional = new AccessPropertyStringOptional(node)
}

trait ConcreteBaseConversions {
  implicit def accessNodeabase(node: nodes.NodeABase): AccessNodeaBase = new AccessNodeaBase(node)
  implicit def accessNodebbase(node: nodes.NodeBBase): AccessNodebBase = new AccessNodebBase(node)
}
