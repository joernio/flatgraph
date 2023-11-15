package io.joern.odb2

trait DNodeOrNode

/** A DNode represents a detached node. It corresponds to the NewNode classes. This is how one adds nodes to a graph. */
trait DNode extends DiffGraphBuilder.RawUpdate with DNodeOrNode {
  def nodeKind: Short
  def storedRef: Option[GNode]
  def storedRef_=(ref: Option[GNode]): Unit

  def flattenProperties(interface: BatchedUpdateInterface): Unit
}

trait BatchedUpdateInterface {
  def insertProperty(node: DNode, propertyKind: Int, propertyValues: IterableOnce[Any]): Unit
}
class GenericDNode(val nodeKind: Short, var storedRef: Option[GNode] = None) extends DNode {
  override def flattenProperties(interface: BatchedUpdateInterface): Unit = {}
}
