package flatgraph

import flatgraph.Edge.Direction
import flatgraph.Graph.*
import flatgraph.misc.{InitNodeIterator, InitNodeIteratorArray, InitNodeIteratorArrayFiltered}
import flatgraph.storage.{Deserialization, Serialization}

import java.nio.file.{Files, Path}
import java.util.concurrent.atomic.AtomicReferenceArray
import org.slf4j.LoggerFactory

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
      println(s"initialising from existing storage ($storagePath)")
      Deserialization.readGraph(storagePath, Option(schema), persistOnClose)
    } else {
      val storagePathMaybe =
        if (persistOnClose) Option(storagePath)
        else None
      Graph(schema, storagePathMaybe)
    }
  }

}

class Graph(val schema: Schema, storagePathMaybe: Option[Path] = None) extends AutoCloseable {
  private val nodeKindCount   = schema.getNumberOfNodeKinds
  private val edgeKindCount   = schema.getNumberOfEdgeKinds
  private val propertiesCount = schema.getNumberOfProperties
  private var closed          = false

  private[flatgraph] val livingNodeCountByKind: Array[Int] = new Array[Int](nodeKindCount)
  private[flatgraph] def nodeCountByKind(kind: Int): Int   = nodesArray(kind).length

  private[flatgraph] val properties     = new Array[AnyRef](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val inverseIndices = new AtomicReferenceArray[Object](nodeKindCount * propertiesCount * PropertySlotSize)
  private[flatgraph] val nodesArray: Array[Array[GNode]] = makeNodesArray()
  private[flatgraph] val neighbors: Array[AnyRef]        = makeNeighbors()

  def _nodes(nodeKind: Int): InitNodeIterator[GNode] = {
    if (nodeCountByKind(nodeKind) == livingNodeCountByKind(nodeKind)) new InitNodeIteratorArray[GNode](nodesArray(nodeKind))
    else new InitNodeIteratorArrayFiltered[GNode](nodesArray(nodeKind))
  }

  def nodes(label: String): InitNodeIterator[GNode] =
    _nodes(schema.getNodeKindByLabel(label))

  def nodes(labels: String*): Iterator[GNode] =
    labels.iterator.flatMap(nodes)

  def allNodes: Iterator[GNode] =
    nodesArray.iterator.flatMap(_.iterator)

  /** Lookup nodes with a given property value (via index). N.b. currently only supported for String properties. Context: MultiDictIndex
    * requires the key to be a String and this is using reverse indices, i.e. the lookup is from String -> GNode.
    */
  def nodesWithProperty(propertyName: String, value: String): Iterator[GNode] = {
    schema.getPropertyKindByName(propertyName) match {
      case Schema.UndefinedKind =>
        Iterator.empty
      case propertyKind =>
        Range(0, schema.getNumberOfNodeKinds).iterator.flatMap { nodeKind =>
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
      nodeKind  <- Range(0, nodeKindCount)
      direction <- Edge.Direction.values
      edgeKind  <- Range(0, edgeKindCount)
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

}
