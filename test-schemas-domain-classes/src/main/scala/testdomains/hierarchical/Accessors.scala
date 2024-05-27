package testdomains.hierarchical.accessors
import testdomains.hierarchical.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */
  final class Access_Property_name(val node: nodes.StoredNode) extends AnyVal {
    def name: String = flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, 0, node.seq(), "<empty>": String)
  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Access_NodeXBase(val node: nodes.NodeXBase) extends AnyVal {}
  final class Access_NodeYBase(val node: nodes.NodeYBase) extends AnyVal {}
  final class Access_BaseNodeBase(val node: nodes.BaseNodeBase) extends AnyVal {
    def name: String = node match {
      case stored: nodes.StoredNode   => new Access_Property_name(stored).name
      case newNode: nodes.BaseNodeNew => newNode.name
    }
  }
  /* accessors for base nodes end */
}

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyName(node: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]): Access_Property_name =
    new Access_Property_name(node)
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors.*
  implicit def access_NodeXBase(node: nodes.NodeXBase): Access_NodeXBase = new Access_NodeXBase(node)
  implicit def access_NodeYBase(node: nodes.NodeYBase): Access_NodeYBase = new Access_NodeYBase(node)
}

trait AbstractBaseConversions0 {
  import Accessors.*
  implicit def access_BaseNodeBase(node: nodes.BaseNodeBase): Access_BaseNodeBase = new Access_BaseNodeBase(node)
}
