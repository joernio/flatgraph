package testdomains.hierarchical.accessors
import testdomains.hierarchical.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class AccessPropertyName(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "<empty>": String)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class AccessNodexBase(val node: nodes.NodeXBase) extends AnyVal {}
  final class AccessNodeyBase(val node: nodes.NodeYBase) extends AnyVal {}
  final class AccessBasenodeBase(val node: nodes.BaseNodeBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode   => new AccessPropertyName(stored).name
      case newNode: nodes.BaseNodeNew => newNode.name
    }
  }
  /* accessors for base nodes end */
}

import Accessors.*
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): AccessPropertyName = new AccessPropertyName(
    node
  )
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  implicit def accessNodexbase(node: nodes.NodeXBase): AccessNodexBase = new AccessNodexBase(node)
  implicit def accessNodeybase(node: nodes.NodeYBase): AccessNodeyBase = new AccessNodeyBase(node)
}

trait AbstractBaseConversions0 {
  implicit def accessBasenodebase(node: nodes.BaseNodeBase): AccessBasenodeBase = new AccessBasenodeBase(node)
}
