package flatgraph.convert

import flatgraph.misc.{ISeq, Misc}
import flatgraph.storage.Manifest.NodeItem
import flatgraph.{AccessHelpers, Accessors, Edge, GNode, storage}
import flatgraph.storage.{Keys, Manifest, Serialization, StorageType}
import org.msgpack.core.{MessageBufferPacker, MessagePack}
import overflowdb.Graph
import overflowdb.storage.{OdbStorage, ValueTypes}

import java.io.{ByteArrayOutputStream, File}
import java.nio.charset.StandardCharsets
import java.nio.file.{Path, Paths}
import java.nio.{ByteBuffer, ByteOrder}
import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable
import scala.util.Using

object Convert {
  val ANON_EDGE_PROPERTY = "EDGE_PROPERTY"

  def main(args: Array[String]): Unit = {
    var dstFile: Path = null
    var srcFile: Path = null
    var reverse       = false
    var verbose       = false
    var tooMany       = false
    for (arg <- args) {
      if (arg == "-r") reverse = true
      else if (arg == "--verbose") verbose = true
      else if (srcFile == null) srcFile = Paths.get(arg)
      else if (dstFile == null) dstFile = Paths.get(arg)
      else tooMany = true
    }
    if (tooMany || dstFile == null || srcFile == null) {
      System.err.println("Usage: convert [--verbose] [inputfileOdb] [outputfileFlatGraph]")
      System.err.println("Usage: convert -r [--verbose] [inputfileFlatGraph] [outputfileOdb]")
      System.err.println("Error: missing input and/or output file - exiting.")
    } else if (reverse) {
      convertFlatgraphToOdb(srcFile, dstFile, verbose = verbose, debug = true)
    } else {
      convertOdbToFlatgraph(srcFile, dstFile, verbose = verbose)
    }
  }

  def convertOdbToFlatgraph(overflowDbFile: Path, outputFile: Path, verbose: Boolean = false): Unit = {
    val storage = overflowdb.storage.OdbStorage.createWithSpecificLocation(overflowDbFile.toFile, new overflowdb.util.StringInterner)
    val nodes   = readOdb(storage)
    writeData(outputFile.toFile, nodes, verbose = verbose)
  }

  def convertFlatgraphToOdb(fgFile: Path, outputFile: Path, debug: Boolean = false, verbose: Boolean = false): Unit = {
    if (verbose) {
      Using(new java.io.RandomAccessFile(fgFile.toAbsolutePath.toFile, "r").getChannel) { channel =>
        val manifest = flatgraph.storage.Deserialization.readManifest(channel)
        println(manifest.render(indent = 2))
      }
    }
    val fg = flatgraph.storage.Deserialization.readGraph(fgFile, None, false)

    val dst = outputFile.toFile
    if (dst.exists()) dst.delete()
    dst.createNewFile()
    val storage = overflowdb.storage.OdbStorage.createWithSpecificLocation(dst, new overflowdb.util.StringInterner)
    for (node <- fg.allNodes if !AccessHelpers.isDeleted(node)) {
      val bytes = packNode(node, storage)
      if (debug) {
        val legacyIdToNewId = mutable.HashMap[Long, NodeRefTmp]()
        val byLabel         = mutable.LinkedHashMap[String, NodeStuff]()
        try {
          readNode(legacyIdToNewId, node.id(), bytes, byLabel, storage)
        } catch {
          case exc: Throwable =>
            println(s"Inconsistency encountered ${node.seq()} / ${node.nodeKind} / ${node.label()} / ${node.id()}")
            println(exc)
            throw exc
        }
      }
      storage.persist(node.id(), packNode(node, storage))
    }
    storage.close()
  }

  class NodeRefTmp(val legacyId: Long) {
    var newNode: flatgraph.GNode = null
  }

  private object NodeStuff {
    val NODEPROPERTY        = "p"
    val NEIGHBOR_IN         = "i"
    val NEIGHBOR_OUT        = "o"
    val EDGEPROPERTY_SUFFIX = "x"
    val legacyId            = "legacyId"
  }

  class NodeStuff(val label: String, val kind: Int) {
    var nextId: Int = 0
    val quantities  = mutable.HashMap[(String, String), mutable.ArrayBuffer[Int]]()
    val values      = mutable.HashMap[(String, String), mutable.ArrayBuffer[Any]]()

    def addX(iop: String, key: String, value: Any, edgePropertyKey: String = null, edgePropertyValue: Any = null): Unit = {
      val q = quantities.getOrElseUpdate((iop, key), mutable.ArrayBuffer[Int]())
      while (q.length < nextId) q.addOne(0)
      q(q.length - 1) += 1
      val v = values.getOrElseUpdate((iop, key), mutable.ArrayBuffer[Any]())
      v.addOne(value)
      if (edgePropertyKey != null) {
        assert(iop == NodeStuff.NEIGHBOR_IN || iop == NodeStuff.NEIGHBOR_OUT)
        val vv = values.getOrElseUpdate((iop + NodeStuff.EDGEPROPERTY_SUFFIX, key), mutable.ArrayBuffer[Any]())
        while (vv.length < v.length) vv.addOne(null)
        vv(vv.length - 1) = edgePropertyValue
      }
    }
    def pad(): Unit = {
      for (qq <- quantities.valuesIterator) { while (qq.length < nextId) qq.addOne(0) }
      for (((prefix, key), v) <- values.iterator if prefix.endsWith(NodeStuff.EDGEPROPERTY_SUFFIX)) {
        val stripped =
          if (prefix == NodeStuff.NEIGHBOR_IN + NodeStuff.EDGEPROPERTY_SUFFIX) NodeStuff.NEIGHBOR_IN else NodeStuff.NEIGHBOR_OUT
        val nNeighbors = values((stripped, key)).length
        while (v.length < nNeighbors) v.addOne(null)
      }
    }
  }

  private def writeData(filename: File, nodeStuff: Array[NodeStuff], verbose: Boolean = false): Unit = {
    val fileAbsolute = filename.getAbsoluteFile
    val filePtr      = new AtomicLong(16)
    if (!fileAbsolute.exists()) {
      fileAbsolute.getParentFile.mkdirs()
      fileAbsolute.createNewFile()
    }
    val fileChannel = new java.io.RandomAccessFile(fileAbsolute, "rw").getChannel
    val writer      = storage.WriterContext(fileChannel, Misc.maybeOverrideExecutor(None))
    try {
      val nodes      = nodeStuff.map { ns => new Manifest.NodeItem(ns.label, ns.nextId, null) }
      val edges      = mutable.ArrayBuffer[Manifest.EdgeItem]()
      val properties = mutable.ArrayBuffer[Manifest.PropertyItem]()
      for {
        node                      <- nodeStuff
        ((prefix, key), quantity) <- node.quantities.iterator
      } {
        val (valtyp, vals) = homogenize(node.values((prefix, key)))
        if (valtyp != null) {
          val deltaEncoded = quantity.addOne(0).toArray
          val qty          = writer.encodeAny(deltaEncoded)
          val values       = writer.encodeAny(vals)
          assert(values.typ == valtyp)
          prefix match {
            case NodeStuff.NODEPROPERTY =>
              properties.addOne(new Manifest.PropertyItem(node.label, key, qty, values))
            case NodeStuff.NEIGHBOR_IN | NodeStuff.NEIGHBOR_OUT =>
              val inout =
                if (prefix == NodeStuff.NEIGHBOR_IN) Edge.Direction.Incoming.encoding
                else Edge.Direction.Outgoing.encoding
              val edgeItem = new Manifest.EdgeItem(node.label, key, inout, qty, values, null)
              edges.addOne(edgeItem)
              node.values.get((prefix + NodeStuff.EDGEPROPERTY_SUFFIX, key)) match {
                case None =>
                case Some(propvalues) =>
                  val (ptype, pval) = homogenize(propvalues)
                  if (ptype != null) {
                    val stored = writer.encodeAny(pval)
                    edgeItem.property = stored
                  }
              }
          }
        }
      }
      val manifest = new Manifest.GraphItem(nodes, edges.toArray, properties.toArray)
      writer.finish(manifest)
    } finally { fileChannel.close(); writer.compressCtx.close(); }
  }

  private def homogenize(items: mutable.ArrayBuffer[Any]): (String, Array[?]) = {
    items.find { _ != null } match {
      case None             => (null, null)
      case Some(_: Boolean) => (storage.StorageType.Bool, items.asInstanceOf[mutable.ArrayBuffer[Boolean]].toArray)
      case Some(_: Byte)    => (storage.StorageType.Byte, items.asInstanceOf[mutable.ArrayBuffer[Byte]].toArray)
      case Some(_: Short)   => (storage.StorageType.Short, items.asInstanceOf[mutable.ArrayBuffer[Short]].toArray)
      case Some(_: Int)     => (storage.StorageType.Int, items.asInstanceOf[mutable.ArrayBuffer[Int]].toArray)
      case Some(_: Long)    => (storage.StorageType.Long, items.asInstanceOf[mutable.ArrayBuffer[Long]].toArray)
      case Some(_: Float)   => (storage.StorageType.Float, items.asInstanceOf[mutable.ArrayBuffer[Float]].toArray)
      case Some(_: Double)  => (storage.StorageType.Double, items.asInstanceOf[mutable.ArrayBuffer[Double]].toArray)
      case Some(_: String) =>
        (storage.StorageType.String, items.asInstanceOf[mutable.ArrayBuffer[String]].toArray)
      case Some(_: NodeRefTmp) =>
        (
          storage.StorageType.Ref,
          items.asInstanceOf[mutable.ArrayBuffer[NodeRefTmp]].iterator.map { ref => if (ref == null) null else ref.newNode }.toArray
        )
      case Some(other) => throw new AssertionError(s"unexpected item found: other of type ${other.getClass}")
    }
  }

  def packNode(node: GNode, storage: OdbStorage): Array[Byte] = {
    val packer = MessagePack.newDefaultBufferPacker()
    val graph  = node.graph
    val schema = graph.schema
    packer.packLong(node.id())
    packer.packInt(storage.lookupOrCreateStringToIntMapping(schema.getNodeLabel(node.nodeKind)))

    var nprops = 0
    for (propertyId <- Range(0, schema.getNumberOfPropertyKinds) if Accessors.getNodeProperty(node, propertyId).nonEmpty) {
      nprops += 1
    }
    packer.packMapHeader(nprops)
    for (propertyId <- Range(0, schema.getNumberOfPropertyKinds)) {
      val values  = Accessors.getNodeProperty(graph, node.nodeKind, propertyId, node.seq())
      val rawVals = graph.properties(schema.propertyOffsetArrayIndex(node.nodeKind, propertyId) + 1)
      packProperty(rawVals, values, packer, storage.lookupOrCreateStringToIntMapping(schema.getPropertyLabel(node.nodeKind, propertyId)))
    }

    for (inOut <- List(1, 0)) {
      var edgeTypeCount = 0
      for (edgeId <- Range(0, schema.getNumberOfEdgeKinds)) {
        val edges = if (inOut == 0) Accessors.getEdgesIn(node, edgeId) else Accessors.getEdgesOut(node, edgeId)
        if (edges.nonEmpty) edgeTypeCount += 1
      }
      packer.packInt(edgeTypeCount)
      for (edgeId <- Range(0, schema.getNumberOfEdgeKinds)) {
        val edges = if (inOut == 0) Accessors.getEdgesIn(node, edgeId) else Accessors.getEdgesOut(node, edgeId)
        if (edges.nonEmpty) {
          packer.packInt(storage.lookupOrCreateStringToIntMapping(schema.getEdgeLabel(node.nodeKind, edgeId)))
          packer.packInt(edges.size)
          for (edge <- edges) {
            packer.packLong(if (inOut == 0) edge.src.id() else edge.dst.id())
            if (edge.property != null) {
              packer.packMapHeader(1)
              packer.packInt(storage.lookupOrCreateStringToIntMapping(ANON_EDGE_PROPERTY))
              packer.packArrayHeader(2)
              edge.property match {
                case v: java.lang.Boolean =>
                  packer.packByte(ValueTypes.BOOLEAN.id)
                  packer.packBoolean(v)
                case v: java.lang.Byte =>
                  packer.packByte(ValueTypes.BYTE.id)
                  packer.packByte(v)
                case v: java.lang.Short =>
                  packer.packByte(ValueTypes.SHORT.id)
                  packer.packShort(v)
                case v: java.lang.Integer =>
                  packer.packByte(ValueTypes.INTEGER.id)
                  packer.packInt(v)
                case v: java.lang.Long =>
                  packer.packByte(ValueTypes.LONG.id)
                  packer.packLong(v)
                case v: java.lang.Float =>
                  packer.packByte(ValueTypes.FLOAT.id)
                  packer.packFloat(v)
                case v: java.lang.Double =>
                  packer.packByte(ValueTypes.DOUBLE.id)
                  packer.packDouble(v)
                case v: java.lang.String =>
                  packer.packByte(ValueTypes.STRING.id)
                  packer.packString(v)
                case v: GNode =>
                  packer.packByte(ValueTypes.NODE_REF.id)
                  packer.packLong(v.id())
              }
            } else packer.packMapHeader(0)
          }
        }
      }
    }
    packer.toByteArray
  }

  def packProperty(rawVals: Any, values: ISeq[Any], packer: MessageBufferPacker, storageId: Int): Unit = {
    if (values.nonEmpty) {
      packer.packInt(storageId)
      packer.packArrayHeader(2)

      rawVals match {
        case null => ???
        case _: Array[Boolean] =>
          val vv = values.asInstanceOf[ISeq[Boolean]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.BOOLEAN.id)
            packer.packBoolean(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_BOOL.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packBoolean)
          }
        case _: Array[Byte] =>
          val vv = values.asInstanceOf[ISeq[Byte]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.BYTE.id)
            packer.packByte(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_BYTE.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packByte)
          }
        case _: Array[Short] =>
          val vv = values.asInstanceOf[ISeq[Short]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.SHORT.id)
            packer.packShort(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_SHORT.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packShort)
          }
        case _: Array[Int] =>
          val vv = values.asInstanceOf[ISeq[Int]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.INTEGER.id)
            packer.packInt(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_INT.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packInt)
          }
        case _: Array[Long] =>
          val vv = values.asInstanceOf[ISeq[Long]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.LONG.id)
            packer.packLong(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_LONG.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packLong)
          }
        case _: Array[Float] =>
          val vv = values.asInstanceOf[ISeq[Float]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.FLOAT.id)
            packer.packFloat(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_FLOAT.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packFloat)
          }
        case _: Array[Double] =>
          val vv = values.asInstanceOf[ISeq[Double]]
          if (vv.size == 1) {
            packer.packByte(ValueTypes.DOUBLE.id)
            packer.packDouble(vv.head)
          } else {
            packer.packByte(ValueTypes.ARRAY_DOUBLE.id)
            packer.packArrayHeader(vv.size)
            vv.foreach(packer.packDouble)
          }
        case _: Array[String] | _: Array[GNode] =>
          if (values.size == 1) packTypedRefValue(packer, values.head, true)
          else {
            packer.packByte(ValueTypes.ARRAY_OBJECT.id)
            packer.packArrayHeader(values.size)
            values.foreach(packTypedRefValue(packer, _, false))
          }

      }

    }
  }

  def packTypedRefValue(packer: MessageBufferPacker, v: Any, skipHeader: Boolean): Unit = {
    if (!skipHeader) packer.packArrayHeader(2)
    v match {
      case null =>
        packer.packByte(ValueTypes.UNKNOWN.id)
        packer.packNil()
      case str: String =>
        packer.packByte(ValueTypes.STRING.id)
        packer.packString(str)
      case gn: GNode =>
        packer.packByte(ValueTypes.NODE_REF.id)
        packer.packLong(gn.id())
    }
  }

  def readNode(
    legacyIdToNewId: mutable.HashMap[Long, NodeRefTmp],
    legacyId: Long,
    bytes: Array[Byte],
    byLabel: mutable.LinkedHashMap[String, NodeStuff],
    storage: OdbStorage
  ): Unit = {
    val unpacker  = MessagePack.newDefaultUnpacker(bytes)
    val legacyId2 = unpacker.unpackLong()
    assert(legacyId2 == legacyId)

    val label = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())

    val sz        = byLabel.size
    val nodeStuff = byLabel.getOrElseUpdate(label, new NodeStuff(label, sz))
    val ref       = legacyIdToNewId.getOrElseUpdate(legacyId, new NodeRefTmp(legacyId))
    ref.newNode = new GNode(null, nodeStuff.kind.toShort, nodeStuff.nextId)
    nodeStuff.nextId += 1
    // nodeStuff.addX(NodeStuff.NODEPROPERTY, NodeStuff.legacyId, legacyId)
    val nprops = unpacker.unpackMapHeader()
    for (_ <- Range(0, nprops)) {
      val key = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())
      for (v <- unpackValue(legacyIdToNewId, unpacker.unpackValue().asArrayValue())) {
        nodeStuff.addX(NodeStuff.NODEPROPERTY, key, v)
      }
    }
    for (inout <- List(NodeStuff.NEIGHBOR_OUT, NodeStuff.NEIGHBOR_IN)) {
      val edgeTypeCount = unpacker.unpackInt()
      for (_ <- Range(0, edgeTypeCount)) {
        val key       = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())
        val edgeCount = unpacker.unpackInt()
        for (_ <- Range(0, edgeCount)) {
          val adjacentId   = unpacker.unpackLong
          val adjacentNode = legacyIdToNewId.getOrElseUpdate(adjacentId, new NodeRefTmp(adjacentId))
          val (pkey, pval) = unpacker.unpackMapHeader() match {
            case 0 => (null, null) // no property
            case 1 =>
              val pkey  = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())
              val pvals = unpackValue(legacyIdToNewId, unpacker.unpackValue().asArrayValue())
              if (pvals.length == 0) (null, null)
              else if (pvals.length == 1) (pkey, pvals.head)
              else ???
            case _ => ??? // we only support one property!
          }
          nodeStuff.addX(inout, key, adjacentNode, pkey, pval)
        }
      }
    }

  }

  private def readOdb(storage: overflowdb.storage.OdbStorage): Array[NodeStuff] = {
    val legacyIdToNewId = mutable.HashMap[Long, NodeRefTmp]()
    val byLabel         = mutable.LinkedHashMap[String, NodeStuff]()
    val iter            = storage.allNodes().iterator
    while (iter.hasNext) {
      val e        = iter.next()
      val legacyId = e.getKey
      val bytes    = e.getValue
      readNode(legacyIdToNewId, legacyId, bytes, byLabel, storage)
    }

    byLabel.valuesIterator.foreach { _.pad() }
    byLabel.valuesIterator.toArray
  }

  def unpackValue(
    legacyIdToNewId: mutable.HashMap[Long, NodeRefTmp],
    valueOrPair: org.msgpack.value.Value,
    res: mutable.ArrayBuffer[Any] = mutable.ArrayBuffer[Any](),
    typId: Option[ValueTypes] = None
  ): mutable.ArrayBuffer[Any] = {
    val (typId_, v) = typId match {
      case None =>
        val iter      = valueOrPair.asArrayValue().iterator()
        val first     = iter.next.asIntegerValue().asByte()
        val remainder = iter.next()
        (ValueTypes.lookup(first), remainder)
      case Some(t) => (t, valueOrPair)
    }
    typId_ match {
      case ValueTypes.UNKNOWN => res.addOne(null) // this is the encoding for null strings and noderefs.
      case ValueTypes.BOOLEAN => res.addOne(v.asBooleanValue().getBoolean)
      case ValueTypes.BYTE    => res.addOne(v.asIntegerValue.asByte)
      case ValueTypes.SHORT   => res.addOne(v.asIntegerValue.asShort)
      case ValueTypes.INTEGER => res.addOne(v.asIntegerValue.asInt)
      case ValueTypes.LONG    => res.addOne(v.asIntegerValue.asLong)
      case ValueTypes.FLOAT   => res.addOne(v.asFloatValue.toFloat)
      case ValueTypes.DOUBLE  => res.addOne(v.asFloatValue.toDouble)
      case ValueTypes.STRING  => res.addOne(v.asStringValue().asString())
      case ValueTypes.NODE_REF =>
        val legacyId = v.asIntegerValue.asLong
        res.addOne(legacyIdToNewId.get(legacyId) match {
          case None =>
            val tmp = new NodeRefTmp(legacyId)
            legacyIdToNewId.put(legacyId, tmp)
            tmp
          case Some(exists) => exists
        })
      case ValueTypes.LIST | ValueTypes.ARRAY_OBJECT =>
        val iter = v.asArrayValue().iterator()
        while (iter.hasNext) {
          unpackValue(legacyIdToNewId, iter.next().asArrayValue(), res)
        }
      case ValueTypes.ARRAY_BOOL | ValueTypes.ARRAY_BYTE | ValueTypes.ARRAY_SHORT | ValueTypes.ARRAY_INT | ValueTypes.ARRAY_LONG |
          ValueTypes.ARRAY_FLOAT | ValueTypes.ARRAY_DOUBLE =>
        val elementType = typId_ match {
          case ValueTypes.ARRAY_BOOL   => ValueTypes.BOOLEAN
          case ValueTypes.ARRAY_BYTE   => ValueTypes.BYTE
          case ValueTypes.ARRAY_SHORT  => ValueTypes.SHORT
          case ValueTypes.ARRAY_INT    => ValueTypes.INTEGER
          case ValueTypes.ARRAY_LONG   => ValueTypes.LONG
          case ValueTypes.ARRAY_FLOAT  => ValueTypes.FLOAT
          case ValueTypes.ARRAY_DOUBLE => ValueTypes.DOUBLE
          case _                       => ???
        }
        val iter = v.asArrayValue().iterator()
        while (iter.hasNext) {
          unpackValue(legacyIdToNewId, iter.next().asArrayValue(), res, Some(elementType))
        }

      case _ => ???
    }

    res
  }

}
