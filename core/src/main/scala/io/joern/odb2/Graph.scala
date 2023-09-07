package io.joern.odb2
import io.joern.odb2.Edge.Direction.{Incoming, Outgoing}
import io.joern.odb2.Graph.{NeighborsSlotSize, NumberOfDirections, PropertySlotSize}
import io.joern.odb2.misc.{ISeq, MultiDictIndex}

import java.util.concurrent.atomic.AtomicReferenceArray
import scala.collection.mutable
import scala.reflect.ClassTag

object Accessors {

  def getEdgesOut(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, Edge.Direction.Outgoing, edgeKind)
    val offsets = node.graph._neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph._neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph._neighbors(pos + 2),
      1,
      edgeKind.toShort,
      offsets(node.seq()),
      offsets(node.seq() + 1)
    )
  }

  def getEdgesIn(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    val pos     = node.graph.schema.neighborOffsetArrayIndex(node.nodeKind, Incoming, edgeKind)
    val offsets = node.graph._neighbors(pos).asInstanceOf[Array[Int]]
    if (offsets == null || node.seq() + 1 >= offsets.length) return IndexedSeq.empty[Edge]
    new EdgeView(
      node.graph._neighbors(pos + 1).asInstanceOf[Array[GNode]],
      node,
      node.graph._neighbors(pos + 2),
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

      import Edge.Direction
      val (src, dst, subSeq) = Direction.fromOrdinal(inout) match {
        case Direction.Incoming => (neighbors(start + i), base, -i - 1)
        case Direction.Outgoing => (base, neighbors(start + i), i + 1)
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
    val qty = g._neighbors(pos).asInstanceOf[Array[Int]]
    if (qty == null) return ISeq.empty
    if (seq + 1 < qty.length) {
      val vals = g._neighbors(pos + 1).asInstanceOf[Array[GNode]]
      new ISeq(vals, qty(seq), qty(seq + 1))
    } else ISeq.empty
  }

  def getNodeProperty(node: GNode, propertyKind: Int): IndexedSeq[Any] =
    getNodeProperty(node.graph, node.nodeKind, propertyKind, node.seq())

  def getNodeProperty(graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int): ISeq[Any] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph._properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length) return ISeq.empty
    val vals = graph._properties(pos + 1)
    ISeq.from(vals, qty(seq), qty(seq + 1))
  }

  // this is cheating. It relies on the fact that all reference types are collapsed into one and the array-cast is unchecked.
  def getNodePropertySingle[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int, default: T): T = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph._properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length || qty(seq + 1) == qty(seq)) return default
    if (qty(seq + 1) - qty(seq) > 1) ???
    val vals = graph._properties(pos + 1).asInstanceOf[Array[T]] // cast is checked for primitives and unchecked for reftypes
    vals(qty(seq))
  }

  def getNodePropertyOption[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int)(implicit
    evidence: ClassTag[T]
  ): Option[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph._properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length || qty(seq) == qty(seq + 1)) return None
    if (qty(seq + 1) - qty(seq) != 1) ???
    val vals = graph._properties(pos + 1).asInstanceOf[Array[T]] // cast is checked for primitives and unchecked for reftypes
    Some(vals(qty(seq)))
  }

  def getNodePropertyMulti[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int)(implicit
    evidence: ClassTag[T]
  ): ISeq[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph._properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length) return ISeq.empty
    val vals = graph._properties(pos + 1).asInstanceOf[Array[T]]
    new ISeq(vals, qty(seq), qty(seq + 1))
  }

  def getInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): misc.MultiDictIndex = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    graph._inverseIndices.get(pos) match {
      case exists: misc.MultiDictIndex if exists != null => exists
      case _                                             => createInverseIndex(graph, nodeKind, propertyKind)
    }
  }

  def getWithInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int, value: String): Iterator[GNode] =
    getInverseIndex(graph, nodeKind, propertyKind).get(value)

  private class IndexLock {}
  private def createInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): misc.MultiDictIndex = {
    val pos            = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val inverseIndices = graph._inverseIndices
    /* we have 3 states of the slot:
      null -> IndexLock -> MultiDictIndex

     * */
    inverseIndices.get(pos) match {
      case null =>
        val lock = new IndexLock
        lock.synchronized {
          if (inverseIndices.compareAndSet(pos, null, lock)) {
            // we now own the slot.
            val inverseIndex = new MultiDictIndex
            try {

              val numItems = graph._properties(pos).asInstanceOf[Array[Int]]
              val items    = graph._properties(pos + 1).asInstanceOf[Array[String]]
              val nodes    = graph._nodes(nodeKind)
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
              assert(lock eq lock2)
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
      case exists: misc.MultiDictIndex if exists != null =>
        // the slot contains the result
        exists
    }
  }
}

object DebugDump {

  def printNode(n: GNode): String = printNode(n, null)
  def printNode(n: GNode, edgeproperty: Any): String = {
    val nodeLabel = n.graph.schema.getNodeLabel(n.nodeKind)
    if (!AccessHelpers.isDeleted(n)) {
      if (edgeproperty == null) s"${nodeLabel}_${n.seq}" else s"(${edgeproperty}) ${nodeLabel}_${n.seq}"
    } else {
      if (edgeproperty == null) s"<deleted ${nodeLabel}_${n.seq}>" else s"(${edgeproperty}) <deleted ${nodeLabel}_${n.seq} >"
    }
  }

  def debugDump(g: Graph): String = {
    val sb = new java.lang.StringBuilder(0)
    val numstr =
      g._nodes.map { _.size }.zipWithIndex.map { case (sz, nodeKind) => s"(${nodeKind}: ${sz})" }.mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${g._nodes.iterator.map { _.size }.sum}\n")
    for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) {
      sb.append(s"Node kind ${nodeKind}. (eid, nEdgesOut, nEdgesIn):")
      for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
        val posOut = g.schema.neighborOffsetArrayIndex(nodeKind, Outgoing, edgeKind)
        val neO = g._neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.neighborOffsetArrayIndex(nodeKind, Incoming, edgeKind)
        val neIn = g._neighbors(posIn + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s" (${edgeKind}, ${neO}, ${neIn}),")
      }
      sb.append("\n")

      for (n <- g._nodes(nodeKind)) {
        val properties = mutable.ArrayBuffer.empty[String]
        for (propertyKind <- Range(0, g.schema.getNumberOfProperties)) {
          val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
          val p             = Accessors.getNodeProperty(n, propertyKind)
          if (p.nonEmpty)
            properties.append(
              s"$propertyLabel: [" + p
                .map {
                  case null     => "null"
                  case n: GNode => printNode(n)
                  case other    => other.toString
                }
                .mkString(", ") + "]"
            )
        }
        if (properties.nonEmpty) {
          sb.append(s"   ${printNode(n)}       : " + properties.mkString(", ") + "\n")
        }

        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesOut  = Accessors.getEdgesOut(n, edgeKind)
          assert(Accessors.getNeighborsOut(n, edgeKind).sameElements(edgesOut.map { _.dst }))
          if (edgesOut.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeLabel}] -> " + edgesOut.map { e => printNode(e.dst, e.property) }.mkString(", ") + "\n")
          }
        }
        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesIn   = Accessors.getEdgesIn(n, edgeKind)
          assert(Accessors.getNeighborsIn(n, edgeKind) == (edgesIn.map { _.src }))
          if (edgesIn.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeLabel}] <- " + edgesIn.map { e => printNode(e.src, e.property) }.mkString(", ") + "\n")
          }
        }
      }
    }
    sb.toString
  }

}

object Graph {
  // Slot size is 3 because we have one pointer to array of quantity array and one pointer to array of
  // neighbors, and one array containing edge properties
  val NeighborsSlotSize  = 3
  val NumberOfDirections = 2
  val PropertySlotSize   = 2
}

class Graph(val schema: Schema) {
  val _nodes: Array[Array[GNode]] = new Array[Array[GNode]](schema.getNumberOfNodeKinds)

  val _neighbors: Array[AnyRef] =
    new Array[AnyRef](schema.getNumberOfNodeKinds * schema.getNumberOfEdgeKinds * NeighborsSlotSize * NumberOfDirections)

  val _properties = new Array[AnyRef](schema.getNumberOfNodeKinds * schema.getNumberOfProperties * PropertySlotSize)

  val _inverseIndices = new AtomicReferenceArray[Object](schema.getNumberOfNodeKinds * schema.getNumberOfProperties * PropertySlotSize)

  for {
    nodeKind  <- Range(0, schema.getNumberOfNodeKinds)
    direction <- Edge.Direction.values
    edgeKind  <- Range(0, schema.getNumberOfEdgeKinds)
  } {
    val pos             = schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
    val propertyDefault = schema.allocateEdgeProperty(nodeKind, direction, edgeKind, 1)
    _neighbors(pos + 2) = if (propertyDefault == null) null else new DefaultValue(propertyDefault(0))
  }

  val nnodes: Array[Int] = new Array[Int](schema.getNumberOfNodeKinds)
  def nodes(nodeKind: Int): misc.InitNodeIterator[GNode] = {
    if (_nodes(nodeKind).length == nnodes(nodeKind)) new misc.InitNodeIteratorArray[GNode](_nodes(nodeKind))
    else new misc.InitNodeIteratorArrayFiltered[GNode](_nodes(nodeKind))
  }
  for (nodeKind <- Range(0, _nodes.length)) _nodes(nodeKind) = new Array[GNode](0)

}
