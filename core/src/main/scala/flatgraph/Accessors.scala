package flatgraph

import flatgraph.Edge.Direction
import flatgraph.Edge.Direction.{Incoming, Outgoing}
import flatgraph.misc.{ISeq, MultiDictIndex}

object Accessors {

  def getEdgesOut(node: GNode, edgeKind: Int): IndexedSeq[Edge] = {
    if (edgeKind == Schema.UndefinedKind) return IndexedSeq.empty[Edge]
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
    if (edgeKind == Schema.UndefinedKind) return IndexedSeq.empty[Edge]
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

  def getEdgesOut(node: GNode): IndexedSeq[Edge] =
    node.graph.schema.edgeKinds.flatMap(getEdgesOut(node, _))

  def getEdgesIn(node: GNode): IndexedSeq[Edge] =
    node.graph.schema.edgeKinds.flatMap(getEdgesIn(node, _))

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

  def getNeighborsOut(node: GNode, edgeKind: Int): Iterator[GNode] =
    getNeighborsOut(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  def getNeighborsIn(node: GNode, edgeKind: Int): Iterator[GNode] =
    getNeighborsIn(node.graph, node.nodeKind, node.seq, edgeKind.toShort)

  /** follow _all_ OUT edges to their adjacent nodes */
  def getNeighborsOut(node: GNode): Iterator[GNode] =
    getNeighborsOut(node.graph, node.nodeKind, node.seq)

  /** follow _all_ IN edges to their adjacent nodes */
  def getNeighborsIn(node: GNode): Iterator[GNode] =
    getNeighborsIn(node.graph, node.nodeKind, node.seq)

  def getNeighborsOut(graph: Graph, nodeKind: Int, seq: Int, edgeKind: Int): Iterator[GNode] =
    getNeighbors(graph, graph.schema.neighborOffsetArrayIndex(nodeKind, Outgoing, edgeKind), seq)

  def getNeighborsIn(g: Graph, nodeKind: Short, seq: Int, edgeKind: Int): Iterator[GNode] =
    getNeighbors(g, g.schema.neighborOffsetArrayIndex(nodeKind, Incoming, edgeKind), seq)

  /** follow _all_ OUT edges to their adjacent nodes */
  def getNeighborsOut(g: Graph, nodeKind: Short, seq: Int): Iterator[GNode] = {
    g.schema.edgeKinds.iterator.flatMap { edgeKind =>
      getNeighborsOut(g, nodeKind, seq, edgeKind.toShort)
    }
  }

  /** follow _all_ IN edges to their adjacent nodes */
  def getNeighborsIn(g: Graph, nodeKind: Short, seq: Int): Iterator[GNode] = {
    g.schema.edgeKinds.iterator.flatMap { edgeKind =>
      getNeighborsIn(g, nodeKind, seq, edgeKind.toShort)
    }
  }

  /* Implementation note / TODO later: this (along with all `getNeighbors*`) could return `IndexedSeq
   * rather than `Iterator`. For the sake of compat and an easier migration we are going with `Iterator` for now.
   * Once odb1 is out, we can re-introduce IndexedSeq as a cool new feature.
   * https://github.com/ShiftLeftSecurity/overflowdbv2/pull/89#discussion_r1377682980
   */
  private def getNeighbors(g: Graph, pos: Int, seq: Int): Iterator[GNode] = {
    if (pos < 0) return Iterator.empty
    val qty = g.neighbors(pos).asInstanceOf[Array[Int]]
    if (qty == null) return Iterator.empty // ISeq.empty
    if (seq + 1 < qty.length) {
      val vals = g.neighbors(pos + 1).asInstanceOf[Array[GNode]]
      new ISeq(vals, qty(seq), qty(seq + 1)).iterator
    } else Iterator.empty // ISeq.empty
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

  def getNodePropertyOption[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int): Option[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length || qty(seq) == qty(seq + 1)) return None
    if (qty(seq + 1) - qty(seq) != 1) ???
    val vals = graph.properties(pos + 1).asInstanceOf[Array[T]] // cast is checked for primitives and unchecked for reftypes
    Option(vals(qty(seq)))
  }

  def getNodePropertyOptionCompat(node: GNode, propertyKind: Int): Option[Object] = {
    val graph    = node.graph
    val schema   = graph.schema
    val seq      = node.seq()
    val nodeKind = node.nodeKind.toInt
    schema.getNodePropertyFormalQuantity(nodeKind, propertyKind) match {
      case FormalQtyType.QtyNone                          => None
      case FormalQtyType.QtyOne | FormalQtyType.QtyOption => getNodePropertyOption[Object](graph, nodeKind, propertyKind, seq)
      case FormalQtyType.QtyMulti                         => Option(getNodePropertyMulti[Object](graph, nodeKind, propertyKind, seq))
    }
  }

  def getNodePropertyMulti[@specialized T](graph: Graph, nodeKind: Int, propertyKind: Int, seq: Int): ISeq[T] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    val qty = graph.properties(pos).asInstanceOf[Array[Int]]
    if (qty == null || seq + 1 >= qty.length) return ISeq.empty
    val vals = graph.properties(pos + 1).asInstanceOf[Array[T]]
    new ISeq(vals, qty(seq), qty(seq + 1))
  }

  def getNodeProperties(node: GNode): IterableOnce[(String, IndexedSeq[Any])] = {
    val schema = node.graph.schema
    for {
      propertyKind <- schema.propertyKinds
      property = Accessors.getNodeProperty(node, propertyKind)
      if property.nonEmpty
      propertyLabel = schema.getPropertyLabel(node.nodeKind, propertyKind)
    } yield propertyLabel -> property
  }

  def getInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): MultiDictIndex[GNode] = {
    val pos = graph.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
    graph.inverseIndices.get(pos) match {
      case exists: MultiDictIndex[GNode @unchecked] if exists != null => exists
      case _                                                          => createInverseIndex(graph, nodeKind, propertyKind)
    }
  }

  def getWithInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int, value: String): Iterator[GNode] =
    getInverseIndex(graph, nodeKind, propertyKind).get(value)

  private class IndexLock {}

  private def createInverseIndex(graph: Graph, nodeKind: Int, propertyKind: Int): MultiDictIndex[GNode] = {
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
            val numItems     = Option(graph.properties(pos)).getOrElse(Array.empty[Int]).asInstanceOf[Array[Int]]
            val items        = Option(graph.properties(pos + 1)).getOrElse(Array.empty[String]).asInstanceOf[Array[String]]
            val nodes        = graph.nodesArray(nodeKind)
            val inverseIndex = new MultiDictIndex[GNode](items.length)
            try {
              for (idx <- Range(0, nodes.length) if idx + 1 < numItems.length) {
                val node  = nodes(idx)
                val start = numItems(idx)
                val end   = numItems(idx + 1)
                for (idx2 <- Range(start, end)) {
                  inverseIndex.insert(items(idx2), node)
                }
              }
              inverseIndex.shrinkFit()
              return inverseIndex
            } finally {
              val lock2 = inverseIndices.getAndSet(pos, inverseIndex)
              assert(
                lock == lock2,
                s"something went wrong with the locks: expected them to be equal, but they weren't... lock=$lock, lock2=$lock2"
              )
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
      case exists: MultiDictIndex[GNode] @unchecked if exists != null =>
        // the slot contains the result
        exists
    }
  }
}
