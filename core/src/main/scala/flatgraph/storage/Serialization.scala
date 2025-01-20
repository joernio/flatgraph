package flatgraph.storage

import com.github.luben.zstd.Zstd
import flatgraph.*
import flatgraph.Edge.Direction
import flatgraph.storage.Manifest.*

import java.io.ByteArrayOutputStream
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}
import java.nio.{ByteBuffer, ByteOrder}
import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable
import java.util.concurrent
import java.util.concurrent.TimeUnit

class WriterContext(val fileChannel: FileChannel, val executor: concurrent.ExecutorService) {

  val compressCtx      = new ZstdWrapper.ZstdCtx
  var fileOffset: Long = 16L
  val compressQueue    = mutable.ArrayDeque[concurrent.Future[(OutlineStorage, Array[Byte])]]()
  val writeQueue       = mutable.ArrayDeque[concurrent.Future[Any]]()
  val jobQueue         = mutable.ArrayBuffer[() => (OutlineStorage, Array[Byte])]()
  val stringQueue      = mutable.ArrayDeque[(OutlineStorage, Array[String])]()
  val stringpool       = mutable.LinkedHashMap[String, Int]()

  def submitCompress(block: => (OutlineStorage, Array[Byte])): Unit = {
    compressQueue.addOne(executor.submit((() => block)))
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

  // NOT threadsafe!
  private def insertString(stringPool: mutable.LinkedHashMap[String, Int])(s: String): Int = {
    if (s == null) -1
    else stringPool.getOrElseUpdate(s, stringPool.size)
  }

  private[flatgraph] def encodeAny(item: Any, outlineStorage: OutlineStorage = new OutlineStorage, delta: Int = -1): OutlineStorage = {
    item match {
      case _: DefaultValue => null
      case null            => null
      case bools: Array[Boolean] =>
        outlineStorage.typ = StorageType.Bool
        this.submitCompress {
          val bytes = bools.map { b => if (b) 1.toByte else 0.toByte }
          compressItem(outlineStorage, bytes)
        }
      case bytes: Array[Byte] =>
        outlineStorage.typ = StorageType.Byte
        this.submitCompress {
          compressItem(outlineStorage, bytes)
        }
      case shorts: Array[Short] =>
        outlineStorage.typ = StorageType.Short
        this.submitCompress {
          val bytes = new Array[Byte](2 * shorts.length)
          ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts)
          compressItem(outlineStorage, bytes)
        }
      case ints: Array[Int] =>
        outlineStorage.typ = StorageType.Int
        this.submitCompress {
          val bytes = new Array[Byte](4 * ints.length)
          ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(if (delta == -1) ints else deltaEncode(delta, ints))
          compressItem(outlineStorage, bytes)
        }
      case longs: Array[Long] =>
        outlineStorage.typ = StorageType.Long
        this.submitCompress {
          val bytes = new Array[Byte](8 * longs.length)
          ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().put(longs)
          compressItem(outlineStorage, bytes)
        }
      case floats: Array[Float] =>
        outlineStorage.typ = StorageType.Float
        this.submitCompress {
          val bytes = new Array[Byte](4 * floats.length)
          ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().put(floats)
          compressItem(outlineStorage, bytes)
        }
      case doubles: Array[Double] =>
        outlineStorage.typ = StorageType.Double
        this.submitCompress {
          val bytes = new Array[Byte](8 * doubles.length)
          ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asDoubleBuffer().put(doubles)
          compressItem(outlineStorage, bytes)
        }
      case refs: Array[GNode] =>
        outlineStorage.typ = StorageType.Ref
        this.submitCompress {
          val bytes = new Array[Byte](8 * refs.length)
          val buf   = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
          for (ref <- refs) {
            if (ref == null) buf.putLong(0x0000ffffffffffffL) else buf.putLong(ref.seq().toLong + (ref.nodeKind.toLong << 32))
          }
          compressItem(outlineStorage, bytes)
        }
      case strings: Array[String] =>
        outlineStorage.typ = StorageType.String
        this.stringQueue.addOne((outlineStorage, strings))
      /*
        val indices = strings.map(insertString(stringPool))
        val bytes   = new Array[Byte](4 * strings.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(indices)
        write(bytes, outlineStorage, filePtr, fileChannel)
       */
    }
    outlineStorage
  }

  def compressItem(res: OutlineStorage, bytes: Array[Byte]): (OutlineStorage, Array[Byte]) = {
    res.decompressedLength = bytes.length
    val compressed = this.compressCtx.compress(bytes)
    res.compressedLength = compressed.length
    (res, compressed)
  }

  // NOT threadsafe!
  def writeItem(res: OutlineStorage, bytes: Array[Byte]): Unit = {
    res.compressedLength = bytes.length
    val outPos0 = this.fileOffset
    this.fileOffset += bytes.length
    res.startOffset = outPos0

    this.writeQueue.addOne(this.executor.submit(() => {
      var outPos = outPos0
      val buf    = ByteBuffer.wrap(bytes)
      while (buf.hasRemaining()) {
        outPos += this.fileChannel.write(buf, outPos)
      }
      null
    }))
  }

  def finish(manifest: Manifest.GraphItem): Unit = {
    // writes header etc

    // OK, all jobs have been submitted. Let's clear the stringqueue.
    while (stringQueue.nonEmpty) {
      while (writeQueue.nonEmpty && writeQueue.head.isDone) {
        writeQueue.removeHead()
      }
      while (compressQueue.nonEmpty && compressQueue.head.isDone) {
        val (item, bytes) = compressQueue.removeHead().get()
        writeItem(item, bytes)
      }
      val (item, strings) = stringQueue.removeHead()
      val indices         = strings.map(insertString(stringpool))
      submitCompress {
        val bytes = new Array[Byte](4 * strings.length)
        ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(indices)
        compressItem(item, bytes)
      }
    }
    // OK, stringpool is ready.
    val poolLenBytes  = new Array[Byte](4 * stringpool.size)
    val poolLenBuffer = ByteBuffer.wrap(poolLenBytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer()
    val poolBytes     = new ByteArrayOutputStream()
    for (s <- stringpool.keysIterator) {
      val bytes = s.getBytes(StandardCharsets.UTF_8)
      poolBytes.write(bytes)
      poolLenBuffer.put(bytes.length)
    }
    submitCompress {
      compressItem(manifest.stringPoolLength, poolLenBytes)
    }
    submitCompress {
      compressItem(manifest.stringPoolBytes, poolBytes.toByteArray)
    }

    // OK, all jobs submitted. Let's clear the queues.
    while (compressQueue.nonEmpty) {
      while (writeQueue.nonEmpty && writeQueue.head.isDone) {
        writeQueue.removeHead()
      }
      val (item, bytes) = compressQueue.removeHead().get()
      writeItem(item, bytes)
    }
    while (writeQueue.nonEmpty) {
      writeQueue.removeHead().get()
    }

    var pos       = fileOffset
    val header    = new Array[Byte](16)
    val headerBuf = ByteBuffer.wrap(header)
    headerBuf.order(ByteOrder.LITTLE_ENDIAN).put(Keys.Header).asLongBuffer().put(pos)
    headerBuf.position(0)
    var headPos = 0L
    while (headerBuf.hasRemaining()) {
      headPos += fileChannel.write(headerBuf, headPos)
    }
    val manifestObj = GraphItem.write(manifest)
    // we prefix the manifest with 20 newlines. That allows us to conveniently extract the valid json manifest via `tail`
    val prefixForTail = "\n" * 20
    val buf           = ByteBuffer.wrap((prefixForTail + manifestObj.render()).getBytes(StandardCharsets.UTF_8))

    while (buf.hasRemaining()) {
      pos += fileChannel.write(buf, pos)
    }
    fileChannel.truncate(pos)
  }

}

object Serialization {

  def writeGraph(g: Graph, storagePath: Path, requestedExecutor: Option[concurrent.ExecutorService] = None): Unit = {

    // ensure parent directory exists
    val parentDir = storagePath.getParent
    if (Files.notExists(parentDir)) Files.createDirectories(parentDir)

    val fileChannel = new java.io.RandomAccessFile(storagePath.toAbsolutePath.toFile, "rw").getChannel

    val writer = new WriterContext(fileChannel, flatgraph.Misc.maybeOverrideExecutor(requestedExecutor))

    try {
      innerWriteGraph(g, writer)
    } catch {
      case ex: java.util.concurrent.ExecutionException =>
        throw ex.getCause()
    } finally {
      writer.compressCtx.close()
      fileChannel.close()
    }
  }

  private def innerWriteGraph(g: Graph, writer: WriterContext): Unit = {
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
        val edgeItem  = new Manifest.EdgeItem(nodeLabel, edgeLabel, direction.encoding)
        edges.addOne(edgeItem)
        writer.encodeAny(g.neighbors(pos), edgeItem.qty, delta = g.nodeCountByKind(nodeKind))
        writer.encodeAny(g.neighbors(pos + 1), edgeItem.neighbors)
        writer.encodeAny(g.neighbors(pos + 2), edgeItem.property)
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
        val propertyItem  = new Manifest.PropertyItem(nodeLabel, propertyLabel)
        properties.addOne(propertyItem)
        writer.encodeAny(g.properties(pos).asInstanceOf[Array[Int]], propertyItem.qty, delta = g.nodeCountByKind(nodeKind))
        writer.encodeAny(g.properties(pos + 1), propertyItem.property)
      }
    }

    val manifest = new GraphItem(nodes.toArray, edges.toArray, properties.toArray)
    writer.finish(manifest)

  }

  private[flatgraph] def write(bytes: Array[Byte], res: OutlineStorage, filePtr: AtomicLong, fileChannel: FileChannel): OutlineStorage = {
    res.decompressedLength = bytes.length
    val compressed = ZstdWrapper(Zstd.compress(bytes))

    var outPos = filePtr.getAndAdd(compressed.length)
    res.startOffset = outPos
    res.compressedLength = compressed.length
    val buf = ByteBuffer.wrap(compressed)
    while (buf.hasRemaining()) {
      outPos += fileChannel.write(buf, outPos)
    }
    res
  }

}
