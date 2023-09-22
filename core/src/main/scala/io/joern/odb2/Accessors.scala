package io.joern.odb2

import io.joern.odb2.Edge.Direction
import io.joern.odb2.Edge.Direction.{Incoming, Outgoing}
import io.joern.odb2.misc.{ISeq, MultiDictIndex}

import scala.reflect.ClassTag

object Accessors {

  def getEdgesOut(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, Edge.Direction.Outgoing, edgeKind)
    val offsets = node.graph.neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph.neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph.neighbors(pos + 2),
      1,
      edgeKind.toShort,
      offsets(node.seq()),
      offsets(node.seq() + 1)
    )
  }

  def getEdgesIn(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, Incoming, edgeKind)
    val offsets = node.graph.neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph.neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph.neighbors(pos + 2),
      0,
      edgeKind.toShort,
      offsets(node.seq()),
      offsets(node.seq() + 1)
    )
  }

  class EdgeView(neighbors: Array[GNode], base: GNode, properties: Any, inout: Byte, edgeKind: Short, start: Int, end: Int)
      extends IndexedSeq[Edge] {
    override def apply(i: Int): Edge = {
      val property = properties match {
        case null                       => null
        case defaultValue: DefaultValue => defaultValue.default
        case a: Array[_]                => a(start + i)
      }

      val (src, dst, subSeq) = Direction.fromOrdinal(inout) match {
        case Incoming => (neighbors(start + i), base, -i - 1)
        case Outgoing => (base, neighbors(start + i), i + 1)
      }
      base.graph.schema.makeEdge(src, dst, edgeKind, subSeq, property)
    }

    override def length: Int = end - start
  }

  def getNeighborsOut(node: GNode, edgeKind: Int): IndexedSeq[GNode] =
    getNeighborsOut(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  def getNeighborsIn(node: GNode, edgeKind: Int): IndexedSeq[GNode] =
    getNeighborsIn(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  def getNeighborsOut(graph: Graph, nodeKind: Int, seq: Int, edgeKind: Int): IndexedSeq[GNode] =
    getNeighbors(graph, graph.schema.neighborOffsetArrayIndex(nodeKind, Outgoing, edgeKind), seq)

  def getNeighborsIn(g: Graph, nodeKind: Short, seq: Int, edgeKind: Short): IndexedSeq[GNode] =
    getNeighbors(g, g.schema.neighborOffsetArrayIndex(nodeKind, Incoming, edgeKind), seq)

  private def getNeighbors(g: Graph, pos: Int, seq: Int): IndexedSeq[GNode] = {
    val qty = g.neighbors(pos).asInstanceOf[Array[Int]]
    if (qty == null) return ISeq.empty
    if (seq + 1 < qty.length) {
      val vals = g.neighbors(pos + 1).asInstanceOf[Array[GNode]]
      new ISeq(vals, qty(seq), qty(seq + 1))
    } else ISeq.empty
  }

  def getNodeProperty(node: GNode, propertyKind: Int): IndexedSeq[Any] =
    getNodeProperty(node.graph, node.nodeKind, propertyKind, node.seq())

  def getNodeProperty(graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int): ISeq[Any] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length) return ISeq.empty
    val vals = graph.properties(pos + 1)
    ISeq.from(vals, qty(seq), qty(seq + 1))
  }

  // this is cheating. It relies on the fact that all reference types are collapsed into one and the array-cast is unchecked.
  def getNodePropertySingle[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int, default: T): T = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length || qty(seq + 1) == qty(seq)) return default
    if (qty(seq + 1) - qty(seq) > 1) ???
    val vals = graph.properties(pos + 1).asInstanceOf[Array[T]] // cast is checked for primitives and unchecked for reftypes
    vals(qty(seq))
  }

  def getNodePropertyOption[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int)(implicit
    evidence: ClassTag[T]
  ): Option[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length || qty(seq) == qty(seq + 1)) return None
    if (qty(seq + 1) - qty(seq) != 1) ???
    val vals = graph.properties(pos + 1).asInstanceOf[Array[T]] // cast is checked for primitives and unchecked for reftypes
    Some(vals(qty(seq)))
  }

  def getNodePropertyMulti[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int)(implicit
    evidence: ClassTag[T]
  ): ISeq[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length) return ISeq.empty
    val vals = graph.properties(pos + 1).asInstanceOf[Array[T]]
    new ISeq(vals, qty(seq), qty(seq + 1))
  }

  def getInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): MultiDictIndex = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    graph.inverseIndices.get(pos) match {
      case exists: MultiDictIndex if exists != null => exists
      case _                                        => createInverseIndex(graph, nodeKind, propertyKind)
    }
  }

  def getWithInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int, value: String): Iterator[GNode] =
    getInverseIndex(graph, nodeKind, propertyKind).get(value)

  private class IndexLock {}

  private def createInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): MultiDictIndex = {
    val pos            = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val inverseIndices = graph.inverseIndices
    /* we have 3 states of the slot:
     * null -> IndexLock -> MultiDictIndex
     * */
    inverseIndices.get(pos) match {
      case null =>
        val lock = new IndexLock
        lock.synchronized {
          if (inverseIndices.compareAndSet(pos, null, lock)) {
            // we now own the slot.
            val inverseIndex = new MultiDictIndex
            try {
              val numItems = graph.properties(pos).asInstanceOf[Array[Int]]
              val items    = graph.properties(pos + 1).asInstanceOf[Array[String]]
              val nodes    = graph.nodesArray(nodeKind)
              inverseIndex.initForSize(items.length)
              for (idx <- Range(0, nodes.length) if idx + 1 < numItems.length) {
                val node  = nodes(idx)
                val start = numItems(idx)
                val end   = numItems(idx + 1)
                for (idx2 <- Range(start, end)) {
                  inverseIndex.insert(items(idx2), node)
                }
              }
              inverseIndex.shrinkfit()
              return inverseIndex
            } finally {
              val lock2 = inverseIndices.getAndSet(pos, inverseIndex)
              assert(lock == lock2, s"something went wrong with the locks: expected them to be equal, but they weren't... lock=$lock, lock2=$lock2")
            }
          }
        }
      case _ =>
    }
    inverseIndices.get(pos) match {
      case null => throw new RuntimeException("sync error")
      case lock: IndexLock if lock != null =>
        lock.synchronized {}
      case _ =>
    }
    inverseIndices.get(pos) match {
      case exists: MultiDictIndex if exists != null =>
        // the slot contains the result
        exists
    }
  }
}
