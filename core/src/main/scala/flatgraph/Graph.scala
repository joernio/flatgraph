package flatgraph

import flatgraph.Edge.Direction
import flatgraph.GNode.KindAndSeq
import flatgraph.Graph.*
import flatgraph.misc.{InitNodeIterator, InitNodeIteratorArray, InitNodeIteratorArrayFiltered}
import flatgraph.storage.{Deserialization, Serialization}

import java.nio.file.{Files, Path}
import java.util.concurrent.atomic.AtomicReferenceArray
import org.slf4j.LoggerFactory

import java.util

object Graph {
  // Slot size is 3 because we have one pointer to array of quantity array and one pointer to array of
  // neighbors, and one array containing edge properties
  val NeighborsSlotSize  = 3
  val NumberOfDirections = 2
  val PropertySlotSize   = 2

  val logger = LoggerFactory.getLogger(classOf[Graph])

  /** Instantiate a new graph with storage. If the file already exists, this will deserialize the given file into memory. `Graph.close` will
    * serialise graph to that given file (and override whatever was there before), unless you specify `persistOnClose = false`.
    */
  def withStorage(schema: Schema, storagePath: Path, persistOnClose: Boolean = true): Graph = {
    if (Files.exists(storagePath) && Files.size(storagePath) > 0) {
      logger.info(s"initialising from existing storage ($storagePath)")
      Deserialization.readGraph(storagePath, Option(schema), persistOnClose)
    } else {
      val storagePathMaybe =
        if (persistOnClose) Option(storagePath)
        else None
      Graph(schema, storagePathMaybe)
    }
  }
}

class Graph(val schema: Schema, val storagePathMaybe: Option[Path] = None) extends AutoCloseable {
  private val nodeKindCount   = schema.getNumberOfNodeKinds
  private val edgeKindCount   = schema.getNumberOfEdgeKinds
  private val propertiesCount = schema.getNumberOfPropertyKinds
  private var closed          = false

  private[flatgraph] val livingNodeCountByKind: Array[Int] = new Array[Int](nodeKindCount)

  private[flatgraph] val properties     = new Array[AnyRef](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val inverseIndices = new AtomicReferenceArray[Object](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val nodesArray: Array[Array[GNode]] = makeNodesArray()
  private[flatgraph] val neighbors: Array[AnyRef]        = makeNeighbors()

  /** Note: this included `deleted` nodes! You might want to use `livingNodeCountByKind` instead. */
  private[flatgraph] def nodeCountByKind(kind: Int): Int = {
    schema.verifyNodeKindIsValid(kind)
    nodesArray(kind).length
  }

  def _nodes(nodeKind: Int): InitNodeIterator[GNode] = {
    if (nodeKind < 0 || schema.getNumberOfNodeKinds <= nodeKind) InitNodeIteratorArray(Array.empty[GNode])
    else if (nodeCountByKind(nodeKind) == livingNodeCountByKind(nodeKind)) new InitNodeIteratorArray[GNode](nodesArray(nodeKind))
    else new InitNodeIteratorArrayFiltered[GNode](nodesArray(nodeKind))
  }

  def nodes(label: String): InitNodeIterator[GNode] =
    _nodes(schema.getNodeKindByLabel(label))

  /** Lookup nodes for the given labels, or all nodes if no label is given (`.nodes()`) */
  def nodes(labels: String*): Iterator[GNode] =
    if (labels.isEmpty) allNodes
    else labels.iterator.flatMap(nodes)

  /** Lookup node by id - note: this may return null or throw an exception if the referenced node doesn't exist */
  def node(id: Long): GNode =
    node(GNode.extractKind(id), GNode.extractSeq(id))

  /** Lookup node by kind and seq - note: this may return null if the referenced node doesn't exist */
  def node(kind: Int, seq: Int): GNode = {
    if (kind < 0 || kind >= nodesArray.length || seq < 0 || seq >= nodesArray(kind).length) return null
    val node = nodesArray(kind)(seq)
    if (node._isDeleted) null
    else node
  }

  /** Lookup node by kindAndSeq - note: this may return null or throw an exception if the referenced node doesn't exist */
  def node(kindAndSeq: KindAndSeq): GNode =
    node(kindAndSeq.kind, kindAndSeq.seq)

  def allNodes: Iterator[GNode] =
    schema.nodeKinds.iterator.flatMap(_nodes)

  def nodeCount(label: String): Int =
    livingNodeCountByKind(schema.getNodeKindByLabel(label))

  def nodeCount: Int =
    livingNodeCountByKind.sum

  def allEdges: Iterator[Edge] =
    allNodes.flatMap(Accessors.getEdgesOut)

  def edgeCount: Int =
    allEdges.size

  /** Lookup nodes with a given label and property value via index. N.b. currently only supported for String properties. Context:
    * MultiDictIndex requires the key to be a String and this is using reverse indices, i.e. the lookup is from String -> GNode.
    */
  def nodesWithProperty(label: String, propertyName: String, value: String): Iterator[GNode] = {
    val nodeKind     = schema.getNodeKindByLabel(label)
    val propertyKind = schema.getPropertyKindByName(propertyName)
    if (nodeKind == Schema.UndefinedKind || propertyKind == Schema.UndefinedKind)
      Iterator.empty
    else
      Accessors.getWithInverseIndex(this, nodeKind, propertyKind, value)
  }

  /** Lookup nodes with a given property value via index. N.b. currently only supported for String properties. Context: MultiDictIndex
    * requires the key to be a String and this is using reverse indices, i.e. the lookup is from String -> GNode.
    */
  def nodesWithProperty(propertyName: String, value: String): Iterator[GNode] = {
    schema.getPropertyKindByName(propertyName) match {
      case Schema.UndefinedKind =>
        Iterator.empty
      case propertyKind =>
        schema.nodeKinds.iterator.flatMap { nodeKind =>
          Accessors.getWithInverseIndex(this, nodeKind, propertyKind, value)
        }
    }
  }

  private def makeNodesArray(): Array[Array[GNode]] = {
    val nodes = new Array[Array[GNode]](nodeKindCount)
    for (nodeKind <- Range(0, nodes.length))
      nodes(nodeKind) = new Array[GNode](0)
    nodes
  }

  private def makeNeighbors() = {
    val neighbors = new Array[AnyRef](nodeKindCount * edgeKindCount * NeighborsSlotSize * NumberOfDirections)
    for {
      nodeKind  <- schema.nodeKinds
      direction <- Edge.Direction.values
      edgeKind  <- schema.edgeKinds
      pos             = schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      propertyDefault = schema.allocateEdgeProperty(nodeKind, direction, edgeKind, size = 1)
      value =
        if (propertyDefault == null) null
        else new DefaultValue(propertyDefault(0))
    } neighbors(pos + 2) = value

    neighbors
  }

  def isClosed: Boolean = closed

  override def close(): Unit = {
    this.closed = true

    storagePathMaybe.foreach { storagePath =>
      logger.info(s"closing graph: writing to storage at `$storagePath`")
      Serialization.writeGraph(this, storagePath)
    }
  }

  override def toString(): String =
    s"Graph[$nodeCount nodes]"

  def nodeCountByLabel: Map[String, Int] = {
    schema.nodeKinds
      .map(schema.getNodeLabel)
      .map(label => label -> nodeCount(label))
      .filter { case (label, count) => count > 0 }
      .toMap
  }

}
