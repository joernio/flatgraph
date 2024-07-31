package testdomains.codepropertygraphminified.accessors
import testdomains.codepropertygraphminified.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class AccessPropertyDispatchType(val node: nodes.StoredNode) extends AnyVal {
    def dispatchType: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "<empty>": String)
  }
  final class AccessPropertyName(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 1, node.seq(), "<empty>": String)
  }
  final class AccessPropertyOrder(val node: nodes.StoredNode) extends AnyVal {
    def order: Int = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 2, node.seq(), -1: Int)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class AccessCallBase(val node: nodes.CallBase) extends AnyVal {
    def dispatchType: String = node match {
      case stored: nodes.StoredNode => new AccessPropertyDispatchType(stored).dispatchType
      case newNode: nodes.NewCall   => newNode.dispatchType
    }
  }
  final class AccessMethodBase(val node: nodes.MethodBase) extends AnyVal {}
  final class AccessCallreprBase(val node: nodes.CallReprBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode   => new AccessPropertyName(stored).name
      case newNode: nodes.CallReprNew => newNode.name
    }
    def order: Int = node match {
      case stored: nodes.StoredNode   => new AccessPropertyOrder(stored).order
      case newNode: nodes.CallReprNew => newNode.order
    }
  }
  final class AccessDeclarationBase(val node: nodes.DeclarationBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode      => new AccessPropertyName(stored).name
      case newNode: nodes.DeclarationNew => newNode.name
    }
  }
  /* accessors for base nodes end */
}

import Accessors.*
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  implicit def accessPropertyDispatchType(node: nodes.StoredNode & nodes.StaticType[nodes.HasDispatchTypeEMT]): AccessPropertyDispatchType =
    new AccessPropertyDispatchType(node)
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): AccessPropertyName = new AccessPropertyName(
    node
  )
  implicit def accessPropertyOrder(node: nodes.StoredNode & nodes.StaticType[nodes.HasOrderEMT]): AccessPropertyOrder =
    new AccessPropertyOrder(node)
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  implicit def accessCallbase(node: nodes.CallBase): AccessCallBase       = new AccessCallBase(node)
  implicit def accessMethodbase(node: nodes.MethodBase): AccessMethodBase = new AccessMethodBase(node)
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  implicit def accessCallreprbase(node: nodes.CallReprBase): AccessCallreprBase = new AccessCallreprBase(node)
}

trait AbstractBaseConversions1 {
  implicit def accessDeclarationbase(node: nodes.DeclarationBase): AccessDeclarationBase = new AccessDeclarationBase(node)
}
