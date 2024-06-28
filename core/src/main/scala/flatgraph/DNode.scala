package flatgraph

trait DNodeOrNode

/** A DNode represents a detached node. It corresponds to the NewNode classes. This is how one adds nodes to a graph. */
trait DNode extends DiffGraphBuilder.RawUpdate with DNodeOrNode {
  type StoredNodeType <: GNode
  def nodeKind: Short
  def storedRef: Option[StoredNodeType]
  def storedRef_=(ref: Option[GNode]): Unit

  def countAndVisitProperties(interface: BatchedUpdateInterface): Unit
}

trait BatchedUpdateInterface {
  def countProperty(node: DNode, propertyKind: Int, num: Int): Unit
  def visitContainedNode(contained: DNodeOrNode): Unit
}
final class GenericDNode(val nodeKind: Short, var storedRef: Option[GNode] = None) extends DNode {
  override type StoredNodeType = GNode
  override def countAndVisitProperties(interface: BatchedUpdateInterface): Unit = {}
}
