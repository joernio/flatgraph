package io.joern.odb2.storage

import com.github.luben.zstd.Zstd
import io.joern.odb2.*
import io.joern.odb2.Edge.Direction
import io.joern.odb2.storage.StorageManifest.*

import java.io.ByteArrayOutputStream
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.{ByteBuffer, ByteOrder}
import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable

object StorageTyp {
  val Bool   = "bool"
  val Byte   = "byte"
  val Short  = "short"
  val Int    = "int"
  val Long   = "long"
  val Ref    = "ref"
  val String = "string"
  val Double = "double"
  val Float  = "float"
}
object Keys {
  val typ                = "type"
  val startOffset        = "startOffset"
  val compressedLength   = "compressedLength"
  val decompressedLength = "decompressedLength"
  val nodeLabel          = "nodeLabel"
  val propertyLabel      = "propertyLabel"
  val qty                = "qty"
  val property           = "property"
  val nnodes             = "nnodes"
  val deletions          = "deletions"
  val edgeLabel          = "edgeLabel"
  val inout              = "inout"
  val neighbors          = "neighbors"
  val version            = "version"
  val nodes              = "nodes"
  val edges              = "edges"
  val properties         = "properties"
  val stringpoolLens     = "stringpoolLens"
  val stringpoolBytes    = "stringpoolBytes"
  val HEADER             = 0xdeadbeefdeadbeefL
}

object StorageManifest {
  object GraphItem {
    def read(item: ujson.Value): GraphItem = {
      val version = item.obj(Keys.version).num.toInt
      if (version != 0) throw new RuntimeException()
      val nodes           = item.obj(Keys.nodes).arr.map(NodeItem.read).toArray
      val edges           = item.obj(Keys.edges).arr.map(EdgeItem.read).toArray
      val properties      = item.obj(Keys.properties).arr.map(PropertyItem.read).toArray
      val stringpoolLens  = OutlineStorage.read(StorageTyp.Int, item.obj(Keys.stringpoolLens))
      val stringpoolBytes = OutlineStorage.read(StorageTyp.Byte, item.obj(Keys.stringpoolBytes))
      val res             = new GraphItem(nodes, edges, properties, stringpoolLens, stringpoolBytes)
      res.version = version
      res
    }
    def write(item: GraphItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.version) = 0
      res(Keys.nodes) = ujson.Arr(item.nodes.map(NodeItem.write): _*)
      res(Keys.edges) = ujson.Arr(item.edges.map(EdgeItem.write): _*)
      res(Keys.properties) = ujson.Arr(item.properties.map(PropertyItem.write): _*)
      res(Keys.stringpoolLens) = OutlineStorage.write(item.stringpoolLens)
      res(Keys.stringpoolBytes) = OutlineStorage.write(item.stringpoolBytes)
      res

    }
  }
  class GraphItem(
    var nodes: Array[NodeItem],
    var edges: Array[EdgeItem],
    var properties: Array[PropertyItem],
    val stringpoolLens: OutlineStorage,
    val stringpoolBytes: OutlineStorage
  ) {
    var version = 0
  }

  class NodeItem(val nodeLabel: String, val nnodes: Int, var deletions: Array[Int])
  object NodeItem {
    def write(item: NodeItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.nodeLabel) = item.nodeLabel
      res(Keys.nnodes) = item.nnodes
      res(Keys.deletions) =
        if (item.deletions == null || item.deletions.isEmpty) ujson.Null else ujson.Arr(item.deletions.map { seq => ujson.Num(seq) }: _*)
      res
    }
    def read(item: ujson.Value): NodeItem = {
      val nodeLabel = item.obj(Keys.nodeLabel).str
      val nnodes    = item.obj(Keys.nnodes).num.toInt
      val deletions = item.obj
        .get(Keys.deletions)
        .flatMap {
          case arr: ujson.Arr =>
            val a = arr.value.map(_.num.toInt)
            if (a.isEmpty) None else Some(a.toArray)
          case _ => None
        }
        .orNull

      new NodeItem(nodeLabel, nnodes, deletions)
    }
  }

  object EdgeItem {
    def read(item: ujson.Value): EdgeItem = {
      val nodeLabel = item.obj(Keys.nodeLabel).str
      val edgeLabel = item.obj(Keys.edgeLabel).str
      val inout     = item.obj(Keys.inout).num.toByte
      val qty       = OutlineStorage.read(StorageTyp.Int, item.obj(Keys.qty))
      val neighbors = OutlineStorage.read(StorageTyp.Ref, item.obj(Keys.neighbors))
      val property  = OutlineStorage.read(item.obj(Keys.property))
      new EdgeItem(nodeLabel, edgeLabel, inout, qty, neighbors, property)
    }
    def write(item: EdgeItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.nodeLabel) = item.nodeLabel
      res(Keys.edgeLabel) = item.edgeLabel
      res(Keys.inout) = item.inout
      res(Keys.qty) = OutlineStorage.write(item.qty)
      res(Keys.neighbors) = OutlineStorage.write(item.neighbors)
      res(Keys.property) = OutlineStorage.write(item.property)
      res
    }
  }
  class EdgeItem(
    val nodeLabel: String,
    val edgeLabel: String,
    val inout: Byte, // 0: Incoming, 1: Outgoing; see Edge.Direction enum
    var qty: OutlineStorage,
    var neighbors: OutlineStorage,
    var property: OutlineStorage
  ) {
    Edge.Direction.verifyEncodingRange(inout)
  }
  object PropertyItem {
    def write(item: PropertyItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.nodeLabel) = item.nodeLabel
      res(Keys.propertyLabel) = item.propertyLabel
      res(Keys.qty) = OutlineStorage.write(item.qty)
      res(Keys.property) = OutlineStorage.write(item.property)
      res
    }

    def read(item: ujson.Value): PropertyItem = {
      val nodeLabel     = item.obj(Keys.nodeLabel).str
      val propertyLabel = item.obj(Keys.propertyLabel).str
      val qty           = OutlineStorage.read(StorageTyp.Int, item.obj(Keys.qty))
      val property      = OutlineStorage.read(item.obj(Keys.property))
      new PropertyItem(nodeLabel, propertyLabel, qty, property)
    }
  }
  class PropertyItem(val nodeLabel: String, val propertyLabel: String, var qty: OutlineStorage, var property: OutlineStorage)

  object OutlineStorage {
    def write(item: OutlineStorage): ujson.Value = {
      if (item == null) return ujson.Null
      val res = ujson.Obj()
      res(Keys.typ) = item.typ
      res(Keys.startOffset) = ujson.Num(item.startOffset.toDouble)
      res(Keys.compressedLength) = ujson.Num(item.compressedLength.toDouble)
      res(Keys.decompressedLength) = ujson.Num(item.decompressedLength)
      res
    }
    def read(typ: String, item: ujson.Value): OutlineStorage = {
      val res = read(item)
      if (res != null && res.typ != typ) throw new RuntimeException()
      res
    }
    def read(item: ujson.Value): OutlineStorage = {
      if (item.isNull) return null
      val res = new OutlineStorage(item.obj(Keys.typ).str)
      res.startOffset = item.obj(Keys.startOffset).num.toLong
      res.compressedLength = item.obj(Keys.compressedLength).num.toInt
      res.decompressedLength = item.obj(Keys.decompressedLength).num.toInt
      res
    }
  }
  class OutlineStorage(var typ: String) {
    var startOffset: Long       = -1L
    var compressedLength: Int   = -1
    var decompressedLength: Int = -1
  }
}

object Serialization {
  def writeGraph(g: Graph, filename: String = "/tmp/foo.fg"): Unit = {
    val fileOffset = new AtomicLong(16)

    // else null
    val stringPool = mutable.LinkedHashMap[String, Int]()
    val fileChannel =
      new java.io.RandomAccessFile(
        filename,
        "rw"
      ).getChannel // if (conf.filename != null) { new java.io.RandomAccessFile("/tmp/foo.fg", "w").getChannel }}
    try {
      innerWriteGraph(g, stringPool, fileOffset, fileChannel)
    } finally {
      stringPool.clear()
      fileChannel.close()
    }
  }

  private def innerWriteGraph(
    g: Graph,
    stringPool: mutable.LinkedHashMap[String, Int],
    filePtr: AtomicLong,
    fileChannel: FileChannel
  ): Unit = {
    val nodes      = mutable.ArrayBuffer.empty[NodeItem]
    val edges      = mutable.ArrayBuffer.empty[EdgeItem]
    val properties = mutable.ArrayBuffer.empty[PropertyItem]
    for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) {
      val nodeLabel = g.schema.getNodeLabel(nodeKind)
      val deletions = g
        ._nodes(nodeKind)
        .iterator
        .collect {
          case deleted: GNode if AccessHelpers.isDeleted(deleted) => deleted.seq()
        }
        .toArray
      val size = g._nodes(nodeKind).size
      nodes.addOne(new StorageManifest.NodeItem(nodeLabel, size, deletions))
    }
    for {
      nodeKind  <- Range(0, g.schema.getNumberOfNodeKinds)
      edgeKind  <- Range(0, g.schema.getNumberOfEdgeKinds)
      direction <- Direction.values
    } {
      val pos = g.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (g._neighbors(pos) != null) {
        val nodeLabel = g.schema.getNodeLabel(nodeKind)
        val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
        val edgeItem  = new StorageManifest.EdgeItem(nodeLabel, edgeLabel, direction.encoding, null, null, null)
        edges.addOne(edgeItem)
        edgeItem.qty =
          encodeAny(deltaEncode(g._nodes(nodeKind).length, g._neighbors(pos).asInstanceOf[Array[Int]]), filePtr, stringPool, fileChannel)
        edgeItem.neighbors = encodeAny(g._neighbors(pos + 1), filePtr, stringPool, fileChannel)
        edgeItem.property = encodeAny(g._neighbors(pos + 2), filePtr, stringPool, fileChannel)
      }
    }
    for {
      nodeKind     <- Range(0, g.schema.getNumberOfNodeKinds)
      propertyKind <- Range(0, g.schema.getNumberOfProperties)
    } {
      val pos = g.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
      if (g._properties(pos) != null) {
        val nodeLabel     = g.schema.getNodeLabel(nodeKind)
        val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
        val propertyItem  = new StorageManifest.PropertyItem(nodeLabel, propertyLabel, null, null)
        properties.addOne(propertyItem)
        propertyItem.qty =
          encodeAny(deltaEncode(g._nodes(nodeKind).length, g._properties(pos).asInstanceOf[Array[Int]]), filePtr, stringPool, fileChannel)
        propertyItem.property = encodeAny(g._properties(pos + 1), filePtr, stringPool, fileChannel)
      }
    }

    val poolLenBytes  = new Array[Byte](4 * stringPool.size)
    val poolLenBuffer = ByteBuffer.wrap(poolLenBytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer()
    val poolBytes     = new ByteArrayOutputStream()
    for (s <- stringPool.keysIterator) {
      val bytes = s.getBytes(StandardCharsets.UTF_8)
      poolBytes.write(bytes)
      poolLenBuffer.put(bytes.length)
    }
    val poolLensStored  = new OutlineStorage(StorageTyp.Int)
    val poolBytesStored = new OutlineStorage(StorageTyp.Byte)
    write(poolLenBytes, poolLensStored, filePtr, fileChannel)
    write(poolBytes.toByteArray, poolBytesStored, filePtr, fileChannel)
    var pos       = filePtr.get()
    val header    = new Array[Byte](16)
    val headerBuf = ByteBuffer.wrap(header)
    headerBuf.order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().put(Keys.HEADER).put(pos)
    headerBuf.position(0)
    var headPos = 0L
    while (headerBuf.hasRemaining()) {
      headPos += fileChannel.write(headerBuf, headPos)
    }

    val manifest    = new GraphItem(nodes.toArray, edges.toArray, properties.toArray, poolLensStored, poolBytesStored)
    val manifestObj = GraphItem.write(manifest)
    val buf         = ByteBuffer.wrap(manifestObj.render().getBytes(StandardCharsets.UTF_8))

    while (buf.hasRemaining()) {
      pos += fileChannel.write(buf, pos)
    }
    fileChannel.truncate(pos)
  }
  def deltaEncode(padTo: Int, offsets: Array[Int]): Array[Int] = {
    if (offsets == null) null
    else {
      // the array has one more element than needed, in order to permit deltaDecode to be in-place
      val res = new Array[Int](padTo + 1)
      assert(offsets.length == 0 || offsets(0) == 0)
      var idx   = 0
      val until = math.min(offsets.length, padTo)
      while (idx < until) {
        res(idx) = offsets(idx + 1) - offsets(idx)
        idx += 1
      }
      res
    }
  }

  def encodeAny(
    item: Any,
    filePtr: AtomicLong,
    stringPool: mutable.LinkedHashMap[String, Int],
    fileChannel: FileChannel
  ): OutlineStorage = {
    item match {
      case default: DefaultValue => null
      case null                  => null
      case bools: Array[Boolean] =>
        write(bools.map { b => if (b) 1.toByte else 0.toByte }, new OutlineStorage(StorageTyp.Bool), filePtr, fileChannel)
      case bytes: Array[Byte] =>
        write(bytes, new OutlineStorage(StorageTyp.Byte), filePtr, fileChannel)
      case shorts: Array[Short] =>
        val bytes = new Array[Byte](2 * shorts.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts)
        write(bytes, new OutlineStorage(StorageTyp.Short), filePtr, fileChannel)
      case ints: Array[Int] =>
        val bytes = new Array[Byte](4 * ints.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(ints)
        write(bytes, new OutlineStorage(StorageTyp.Int), filePtr, fileChannel)
      case longs: Array[Long] =>
        val bytes = new Array[Byte](8 * longs.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().put(longs)
        write(bytes, new OutlineStorage(StorageTyp.Long), filePtr, fileChannel)
      case floats: Array[Float] =>
        val bytes = new Array[Byte](4 * floats.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().put(floats)
        write(bytes, new OutlineStorage(StorageTyp.Float), filePtr, fileChannel)
      case doubles: Array[Double] =>
        val bytes = new Array[Byte](8 * doubles.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer().put(doubles)
        write(bytes, new OutlineStorage(StorageTyp.Double), filePtr, fileChannel)
      case refs: Array[GNode] =>
        val bytes = new Array[Byte](8 * refs.length)
        val buf   = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
        for (ref <- refs) {
          if (ref == null) buf.putLong(0x0000ffffffffffffL) else buf.putLong(ref.seq().toLong + (ref.nodeKind.toLong << 32))
        }
        write(bytes, new OutlineStorage(StorageTyp.Ref), filePtr, fileChannel)
      case strings: Array[String] =>
        val indices = strings.map(insertString(stringPool))
        val bytes   = new Array[Byte](4 * strings.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(indices)
        write(bytes, new OutlineStorage(StorageTyp.String), filePtr, fileChannel)
    }
  }

  def write(bytes: Array[Byte], res: OutlineStorage, filePtr: AtomicLong, fileChannel: FileChannel): OutlineStorage = {
    res.decompressedLength = bytes.length
    val compressed = Zstd.compress(bytes)

    var outPos = filePtr.getAndAdd(compressed.length)
    res.startOffset = outPos
    res.compressedLength = compressed.length
    val buf = ByteBuffer.wrap(compressed)
    while (buf.hasRemaining()) {
      outPos += fileChannel.write(buf, outPos)
    }
    res
  }
  def insertString(stringPool: mutable.LinkedHashMap[String, Int])(s: String): Int = {
    if (s == null) -1
    else stringPool.getOrElseUpdate(s, stringPool.size)
  }
}

object Deserialization {

  def freeSchemaFromManifest(manifest: StorageManifest.GraphItem): FreeSchema = {
    val nodeLabels    = manifest.nodes.map { n => n.nodeLabel }
    val nodePropNames = mutable.LinkedHashMap[String, AnyRef]()
    for (prop <- manifest.properties) {
      nodePropNames(prop.propertyLabel) = protoFromOutline(prop.property)
    }
    val propertyLabels         = nodePropNames.keysIterator.toArray
    val nodePropertyPrototypes = nodePropNames.valuesIterator.toArray

    val edgePropNames = mutable.LinkedHashMap[String, AnyRef]()
    for (edge <- manifest.edges) {
      edgePropNames.get(edge.edgeLabel) match {
        case None | Some(null) => edgePropNames(edge.edgeLabel) = protoFromOutline(edge.property)
        case _                 =>
      }
    }
    val edgeLabels             = edgePropNames.keysIterator.toArray
    val edgePropertyPrototypes = edgePropNames.valuesIterator.toArray

    new FreeSchema(nodeLabels, propertyLabels, nodePropertyPrototypes, edgeLabels, edgePropertyPrototypes)
  }

  def protoFromOutline(outline: OutlineStorage): AnyRef = {
    if (outline == null) return null
    outline.typ match {
      case StorageTyp.Bool   => new Array[Boolean](0)
      case StorageTyp.Byte   => new Array[Byte](0)
      case StorageTyp.Short  => new Array[Short](0)
      case StorageTyp.Int    => new Array[Int](0)
      case StorageTyp.Long   => new Array[Long](0)
      case StorageTyp.Float  => new Array[Float](0)
      case StorageTyp.Double => new Array[Double](0)
      case StorageTyp.Ref    => new Array[GNode](0)
      case StorageTyp.String => new Array[String](0)
    }
  }

  def readGraph(filename: String, schema: Schema): Graph = {
    val fileChannel =
      new java.io.RandomAccessFile(filename, "r").getChannel
    try {
      // fixme: Use convenience methods from schema to translate string->id. Fix after we get strict schema checking.
      val manifest  = readManifest(fileChannel)
      val pool      = readPool(manifest, fileChannel)
      val g         = new Graph(if (schema != null) schema else freeSchemaFromManifest(manifest))
      val nodekinds = mutable.HashMap[String, Short]()
      for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) nodekinds(g.schema.getNodeLabel(nodeKind)) = nodeKind.toShort
      val kindRemapper = Array.fill(manifest.nodes.size)(-1.toShort)
      val nodeRemapper = new Array[Array[GNode]](manifest.nodes.length)
      for {
        (nodeItem, idx) <- manifest.nodes.zipWithIndex
        nodeKind        <- nodekinds.get(nodeItem.nodeLabel)
      } {
        kindRemapper(idx) = nodeKind
        val nodes = new Array[GNode](nodeItem.nnodes)
        for (seq <- Range(0, nodes.length)) nodes(seq) = g.schema.makeNode(g, nodeKind, seq)
        g._nodes(nodeKind) = nodes
        nodeRemapper(idx) = nodes
        if (nodeItem.deletions != null) {
          for (del <- nodeItem.deletions) {
            val node = nodes(del)
            if (!AccessHelpers.isDeleted(node)) AccessHelpers.markDeleted(nodes(del))
            else throw new RuntimeException()
          }
          g.nnodes(nodeKind) = nodes.length - nodeItem.deletions.length
        } else g.nnodes(nodeKind) = nodes.length
      }

      val edgeKinds = mutable.HashMap[(String, String), Short]()
      for {
        nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)
        edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)
      } {
        val nodeLabel = g.schema.getNodeLabel(nodeKind)
        val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
        if (edgeLabel != null) {
          edgeKinds((nodeLabel, edgeLabel)) = edgeKind.toShort
        }
      }

      for (edgeItem <- manifest.edges) {
        val nodeKind  = nodekinds.get(edgeItem.nodeLabel)
        val edgeKind  = edgeKinds.get(edgeItem.nodeLabel, edgeItem.edgeLabel)
        val direction = Direction.fromOrdinal(edgeItem.inout)
        if (nodeKind.isDefined && edgeKind.isDefined) {
          val pos = g.schema.neighborOffsetArrayIndex(nodeKind.get, direction, edgeKind.get)
          g._neighbors(pos) = deltaDecode(readArray(fileChannel, edgeItem.qty, nodeRemapper, pool).asInstanceOf[Array[Int]])
          g._neighbors(pos + 1) = readArray(fileChannel, edgeItem.neighbors, nodeRemapper, pool)
          val property = readArray(fileChannel, edgeItem.property, nodeRemapper, pool)
          if (property != null)
            g._neighbors(pos + 2) = property
        }
      }

      val propertykinds = mutable.HashMap[(String, String), Int]()
      for {
        nodeKind     <- Range(0, g.schema.getNumberOfNodeKinds)
        propertyKind <- Range(0, g.schema.getNumberOfProperties)
      } {
        val nodeLabel     = g.schema.getNodeLabel(nodeKind)
        val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
        if (propertyLabel != null) {
          propertykinds((nodeLabel, propertyLabel)) = propertyKind
        }
      }

      for (property <- manifest.properties) {
        val nodeKind     = nodekinds.get(property.nodeLabel)
        val propertyKind = propertykinds.get((property.nodeLabel, property.propertyLabel))
        if (nodeKind.isDefined && propertyKind.isDefined) {
          val pos = g.schema.propertyOffsetArrayIndex(nodeKind.get, propertyKind.get)
          g._properties(pos) = deltaDecode(readArray(fileChannel, property.qty, nodeRemapper, pool).asInstanceOf[Array[Int]])
          g._properties(pos + 1) = readArray(fileChannel, property.property, nodeRemapper, pool)
        }
      }
      g
    } finally fileChannel.close()
  }

  def readManifest(channel: FileChannel): GraphItem = {
    val header    = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN)
    var readBytes = 0
    while (readBytes < 16) {
      readBytes += channel.read(header, readBytes)
    }
    header.flip()

    if (header.getLong() != Keys.HEADER) throw new RuntimeException()
    val manifestOffset = header.getLong()
    val manifestSize   = channel.size() - manifestOffset
    val manifestBytes  = ByteBuffer.allocate(manifestSize.toInt)
    readBytes = 0
    while (readBytes < manifestSize) {
      readBytes += channel.read(manifestBytes, readBytes + manifestOffset)
    }
    manifestBytes.flip()
    val jsonObj = ujson.read(manifestBytes)
    GraphItem.read(jsonObj)
  }

  def readPool(manifest: GraphItem, fileChannel: FileChannel): Array[String] = {
    val stringPoolLens = Zstd
      .decompress(
        fileChannel.map(FileChannel.MapMode.READ_ONLY, manifest.stringpoolLens.startOffset, manifest.stringpoolLens.compressedLength),
        manifest.stringpoolLens.decompressedLength
      )
      .order(ByteOrder.LITTLE_ENDIAN)
    val stringPoolBytes = Zstd
      .decompress(
        fileChannel
          .map(FileChannel.MapMode.READ_ONLY, manifest.stringpoolBytes.startOffset, manifest.stringpoolBytes.compressedLength),
        manifest.stringpoolBytes.decompressedLength
      )
      .order(ByteOrder.LITTLE_ENDIAN)
    val poolBytes = new Array[Byte](manifest.stringpoolBytes.decompressedLength)
    stringPoolBytes.get(poolBytes)
    val pool    = new Array[String](manifest.stringpoolLens.decompressedLength >> 2)
    var idx     = 0
    var poolPtr = 0
    while (idx < pool.length) {
      val len = stringPoolLens.getInt()
      pool(idx) = new String(poolBytes, poolPtr, len, StandardCharsets.UTF_8)
      idx += 1
      poolPtr += len
    }
    pool
  }

  def deltaDecode(a: Array[Int]): Array[Int] = {
    if (a == null) return null
    var idx    = 0
    var cumsum = 0
    while (idx < a.length) {
      val tmp = a(idx)
      a(idx) = cumsum
      cumsum += tmp
      idx += 1
    }
    a
  }
  def readArray(channel: FileChannel, ptr: OutlineStorage, nodes: Array[Array[GNode]], stringpool: Array[String]): Array[_] = {
    if (ptr == null) return null
    val dec = Zstd
      .decompress(channel.map(FileChannel.MapMode.READ_ONLY, ptr.startOffset, ptr.compressedLength), ptr.decompressedLength)
      .order(ByteOrder.LITTLE_ENDIAN)
    ptr.typ match {
      case StorageTyp.Bool =>
        val bytes = new Array[Byte](dec.limit())
        dec.get(bytes)
        bytes.map {
          case 0 => false
          case 1 => true
        }
      case StorageTyp.Byte =>
        val bytes = new Array[Byte](dec.limit())
        dec.get(bytes)
        bytes
      case StorageTyp.Short =>
        val res = new Array[Short](dec.limit() >> 1)
        dec.asShortBuffer().get(res)
        res
      case StorageTyp.Int =>
        val res = new Array[Int](dec.limit() >> 2)
        dec.asIntBuffer().get(res)
        res
      case StorageTyp.Long =>
        val res = new Array[Long](dec.limit() >> 3)
        dec.asLongBuffer().get(res)
        res
      case StorageTyp.Float =>
        val res = new Array[Float](dec.limit() >> 2)
        dec.asFloatBuffer().get(res)
        res
      case StorageTyp.Double =>
        val res = new Array[Double](dec.limit() >> 3)
        dec.asDoubleBuffer().get(res)
        res
      case StorageTyp.String =>
        val res    = new Array[String](dec.limit() >> 2)
        val intbuf = dec.asIntBuffer()
        var idx    = 0
        while (idx < res.length) {
          val offset = intbuf.get(idx)
          if (offset >= 0) res(idx) = stringpool(offset)
          idx += 1
        }
        res
      case StorageTyp.Ref =>
        val res     = new Array[GNode](dec.limit() >> 3)
        val longbuf = dec.asLongBuffer()
        var idx     = 0
        while (idx < res.length) {
          val encodedRef = longbuf.get()
          val kind       = (encodedRef >>> 32).toInt
          val seqid      = encodedRef.toInt
          if (kind >= 0) {
            if (kind < nodes.length) res(idx) = nodes(kind)(seqid)
            else {
              // we cannot decode this node -- it is a type that doesn't exist in our schema.
              // fixme log message.
            }
          } // otherwise this encodes a null-pointer
          idx += 1
        }
        res
    }
  }
}
