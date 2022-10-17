package io.joern.odb2

trait DNodeOrNode

trait DNode extends RawUpdate with DNodeOrNode {
  def kindId: Short
  def storedRef: Option[GNode]
  def storedRef_=(ref: Option[GNode]): Unit
}
class GenericDNode(val kindId: Short, var storedRef: Option[GNode] = None) extends DNode
