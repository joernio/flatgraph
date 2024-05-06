package flatgraph

import DiffGraphBuilder.*
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.misc.SchemaViolationReporter

import scala.collection.mutable

class DiffGraphBuilder(schema: Schema, schemaViolationReporter: SchemaViolationReporter = new SchemaViolationReporter) {
  private[flatgraph] var buffer = mutable.ArrayDeque[RawUpdate]()

  def addNode(newNode: DNode): this.type = {
    this.buffer.append(newNode)
    this
  }

  /** n.b. one would expect a property name/value pair here, but since each edge has exactly one property we don't need the key here... see
    * the readme.md for more context
    */
  def addEdge(src: DNodeOrNode, dst: DNodeOrNode, edgeLabel: String, property: Any = DefaultValue): this.type = {
    val edgeKind = schema.getEdgeKindByLabel(edgeLabel)
    if (edgeKind == Schema.UndefinedKind)
      throw new SchemaViolationException(s"unknown edge label: `$edgeLabel`")
    this._addEdge(src, dst, edgeKind.toShortSafely, property)
  }

  /** n.b. one would expect a property name/value pair here, but since each edge has exactly one property we don't need the key here... see
    * the readme.md for more context
    */
  def _addEdge(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Short, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddEdgeUnprocessed(src, dst, edgeKind, property))
    this
  }

  def setEdgeProperty(edge: Edge, property: Any): this.type = {
    this.buffer.append(new SetEdgeProperty(edge, property))
    this
  }

  def setNodeProperty(node: GNode, propertyName: String, property: Any): this.type = {
    schema.getPropertyKindByName(propertyName) match {
      case Schema.UndefinedKind =>
        schemaViolationReporter.illegalNodeProperty(node.nodeKind, propertyName, schema)
        this
      case propertyKind =>
        this._setNodeProperty(node, propertyKind, property)
    }
  }

  def _setNodeProperty(node: GNode, propertyKind: Int, property: Any): this.type = {
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
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShortSafely, 1, property))
    this
  }

  def unsafeAddHalfEdgeBackward(src: DNodeOrNode, dst: DNodeOrNode, edgeKind: Int, property: Any = DefaultValue): this.type = {
    this.buffer.append(new AddUnsafeHalfEdge(src, dst, edgeKind.toShortSafely, 0, property))
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

object DiffGraphBuilder {
  private[flatgraph] trait RawUpdate

  /*Todo: All the edge representations for updates have the property field. It makes sense to use subclasses with and
     without edge property, in order to save some memory. The resulting dynamic dispatch should be cheap -- at most bimorphic,
     which doesn't prevent inlining, and well-predicted since edge properties are so rarely used.*/
  private[flatgraph] class AddEdgeUnprocessed(val src: DNodeOrNode, val dst: DNodeOrNode, val edgeKind: Short, val property: Any)
      extends RawUpdate

  private[flatgraph] class AddUnsafeHalfEdge(
    val src: DNodeOrNode,
    val dst: DNodeOrNode,
    val edgeKind: Short,
    val inout: Byte,
    val property: Any
  ) extends RawUpdate

  private[flatgraph] class RemoveEdge(val edge: Edge)                         extends RawUpdate
  private[flatgraph] class SetEdgeProperty(val edge: Edge, val property: Any) extends RawUpdate

  private[flatgraph] class DelNode(val node: GNode) extends RawUpdate

  private[flatgraph] class SetNodeProperty(val node: GNode, val propertyKind: Int, val property: Any) extends RawUpdate
}
