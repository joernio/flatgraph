package io.joern.odb2

trait DNodeOrNode

/** A DNode represents a detached node. It corresponds to the NewNode classes. This is how one adds nodes to a graph. */
trait DNode extends RawUpdate with DNodeOrNode {
  def nodeKind: Short
  def storedRef: Option[GNode]
  def storedRef_=(ref: Option[GNode]): Unit
}
class GenericDNode(val nodeKind: Short, var storedRef: Option[GNode] = None) extends DNode
