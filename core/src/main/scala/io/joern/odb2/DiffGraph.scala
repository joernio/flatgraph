package io.joern.odb2

import io.joern.odb2.Edge.Direction
import io.joern.odb2.Edge.Direction.{Incoming, Outgoing}

import scala.collection.{Iterator, mutable}

trait RawUpdate

/*Todo: All the edge representations for updates have the property field. It makes sense to use subclasses with and
   without edge property, in order to save some memory. The resulting dynamic dispatch should be cheap -- at most bimorphic,
   which doesn't prevent inlining, and well-predicted since edge properties are so rarely used.*/
class AddEdgeUnprocessed(val src: DNodeOrNode, val dst: DNodeOrNode, val edgeKind: Short, val property: Any) extends RawUpdate

class AddUnsafeHalfEdge(val src: DNodeOrNode, val dst: DNodeOrNode, val edgeKind: Short, val inout: Byte, val property: Any)
    extends RawUpdate

class RemoveEdge(val edge: Edge)                         extends RawUpdate
class SetEdgeProperty(val edge: Edge, val property: Any) extends RawUpdate

class DelNode(val node: GNode) extends RawUpdate

class SetNodeProperty(val node: GNode, val propertyKind: Int, val property: Any) extends RawUpdate

class DiffGraphBuilder {
  var buffer = mutable.ArrayDeque[RawUpdate]()

  def addNode(newNode: DNode): this.type = {
    this.buffer.append(newNode)
    this
  }

  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, edgeKind.toShort, property))
    this
  }

  def setEdgeProperty(edge: Edge, property: Any): this.type = {
    this.buffer.append(new SetEdgeProperty(edge, property))
    this
  }

  def setNodeProperty(node: GNode, propertyKind: Int, property: Any): this.type = {
    this.buffer.append(new SetNodeProperty(node, propertyKind, property))
    this
  }
  def removeEdge(edge: Edge): this.type = {
    this.buffer.append(new RemoveEdge(edge))
    this
  }

  def removeNode(node: GNode): this.type = {
    this.buffer.append(new DelNode(node))
    this
  }

  def unsafeAddHalfEdgeForward(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShort, 1, property))
    this
  }

  def unsafeAddHalfEdgeBackward(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShort, 0, property))
    this
  }

  def size: Int = buffer.size

  def absorb(right: DiffGraphBuilder): Unit = {
    if (this.buffer.size >= right.buffer.size) {
      this.buffer.appendAll(right.buffer)
      right.buffer = null
    } else {
      val tmp = right.buffer
      tmp.prependAll(this.buffer)
      this.buffer = tmp
      right.buffer = null
    }
  }
}
