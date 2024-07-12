package flatgraph.storage

import com.github.luben.zstd.Zstd
import flatgraph.*
import flatgraph.Edge.Direction
import flatgraph.storage.Manifest.*

import java.io.ByteArrayOutputStream
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.nio.{ByteBuffer, ByteOrder}
import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable

object Serialization {

  def writeGraph(g: Graph, storagePath: Path): Unit = {
    val fileOffset = new AtomicLong(16)
    val stringPool = mutable.LinkedHashMap[String, Int]()

    val fileChannel =
      new java.io.RandomAccessFile(storagePath.toAbsolutePath.toFile, "rw").getChannel

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
    for (nodeKind <- g.schema.nodeKinds) {
      val nodeLabel = g.schema.getNodeLabel(nodeKind)
      val deletions = g
        .nodesArray(nodeKind)
        .collect {
          case deleted: GNode if AccessHelpers.isDeleted(deleted) => deleted.seq()
        }
      val size = g.nodeCountByKind(nodeKind)
      nodes.addOne(new Manifest.NodeItem(nodeLabel, size, deletions))
    }
    for {
      nodeKind  <- g.schema.nodeKinds
      edgeKind  <- g.schema.edgeKinds
      direction <- Direction.values
    } {
      val pos = g.schema.neighborOffsetArrayIndex(nodeKind, direction, edgeKind)
      if (g.neighbors(pos) != null) {
        val nodeLabel = g.schema.getNodeLabel(nodeKind)
        val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
        val edgeItem  = new Manifest.EdgeItem(nodeLabel, edgeLabel, direction.encoding, null, null, null)
        edges.addOne(edgeItem)
        edgeItem.qty =
          encodeAny(deltaEncode(g.nodeCountByKind(nodeKind), g.neighbors(pos).asInstanceOf[Array[Int]]), filePtr, stringPool, fileChannel)
        edgeItem.neighbors = encodeAny(g.neighbors(pos + 1), filePtr, stringPool, fileChannel)
        edgeItem.property = encodeAny(g.neighbors(pos + 2), filePtr, stringPool, fileChannel)
      }
    }
    for {
      nodeKind     <- g.schema.nodeKinds
      propertyKind <- g.schema.propertyKinds
    } {
      val pos = g.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
      if (g.properties(pos) != null) {
        val nodeLabel     = g.schema.getNodeLabel(nodeKind)
        val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
        val propertyItem  = new Manifest.PropertyItem(nodeLabel, propertyLabel, null, null)
        properties.addOne(propertyItem)
        propertyItem.qty =
          encodeAny(deltaEncode(g.nodeCountByKind(nodeKind), g.properties(pos).asInstanceOf[Array[Int]]), filePtr, stringPool, fileChannel)
        propertyItem.property = encodeAny(g.properties(pos + 1), filePtr, stringPool, fileChannel)
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
    val poolLensStored  = new OutlineStorage(StorageType.Int)
    val poolBytesStored = new OutlineStorage(StorageType.Byte)
    write(poolLenBytes, poolLensStored, filePtr, fileChannel)
    write(poolBytes.toByteArray, poolBytesStored, filePtr, fileChannel)
    var pos       = filePtr.get()
    val header    = new Array[Byte](16)
    val headerBuf = ByteBuffer.wrap(header)
    headerBuf.order(ByteOrder.LITTLE_ENDIAN).put(Keys.Header).asLongBuffer().put(pos)
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

  private def deltaEncode(padTo: Int, offsets: Array[Int]): Array[Int] = {
    if (offsets == null) null
    else {
      // the array has one more element than needed, in order to permit deltaDecode to be in-place
      val res = new Array[Int](padTo + 1)
      assert(offsets.length == 0 || offsets(0) == 0)
      var idx   = 0
      val until = math.min(offsets.length - 1, padTo)
      while (idx < until) {
        res(idx) = offsets(idx + 1) - offsets(idx)
        idx += 1
      }
      res
    }
  }

  private[flatgraph] def encodeAny(
    item: Any,
    filePtr: AtomicLong,
    stringPool: mutable.LinkedHashMap[String, Int],
    fileChannel: FileChannel
  ): OutlineStorage = {
    item match {
      case _: DefaultValue => null
      case null            => null
      case bools: Array[Boolean] =>
        write(bools.map { b => if (b) 1.toByte else 0.toByte }, new OutlineStorage(StorageType.Bool), filePtr, fileChannel)
      case bytes: Array[Byte] =>
        write(bytes, new OutlineStorage(StorageType.Byte), filePtr, fileChannel)
      case shorts: Array[Short] =>
        val bytes = new Array[Byte](2 * shorts.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts)
        write(bytes, new OutlineStorage(StorageType.Short), filePtr, fileChannel)
      case ints: Array[Int] =>
        val bytes = new Array[Byte](4 * ints.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(ints)
        write(bytes, new OutlineStorage(StorageType.Int), filePtr, fileChannel)
      case longs: Array[Long] =>
        val bytes = new Array[Byte](8 * longs.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().put(longs)
        write(bytes, new OutlineStorage(StorageType.Long), filePtr, fileChannel)
      case floats: Array[Float] =>
        val bytes = new Array[Byte](4 * floats.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().put(floats)
        write(bytes, new OutlineStorage(StorageType.Float), filePtr, fileChannel)
      case doubles: Array[Double] =>
        val bytes = new Array[Byte](8 * doubles.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer().put(doubles)
        write(bytes, new OutlineStorage(StorageType.Double), filePtr, fileChannel)
      case refs: Array[GNode] =>
        val bytes = new Array[Byte](8 * refs.length)
        val buf   = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
        for (ref <- refs) {
          if (ref == null) buf.putLong(0x0000ffffffffffffL) else buf.putLong(ref.seq().toLong + (ref.nodeKind.toLong << 32))
        }
        write(bytes, new OutlineStorage(StorageType.Ref), filePtr, fileChannel)
      case strings: Array[String] =>
        val indices = strings.map(insertString(stringPool))
        val bytes   = new Array[Byte](4 * strings.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(indices)
        write(bytes, new OutlineStorage(StorageType.String), filePtr, fileChannel)
    }
  }

  private[flatgraph] def write(bytes: Array[Byte], res: OutlineStorage, filePtr: AtomicLong, fileChannel: FileChannel): OutlineStorage = {
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

  private def insertString(stringPool: mutable.LinkedHashMap[String, Int])(s: String): Int = {
    if (s == null) -1
    else stringPool.getOrElseUpdate(s, stringPool.size)
  }
}
