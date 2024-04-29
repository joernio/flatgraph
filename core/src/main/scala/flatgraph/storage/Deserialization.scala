package flatgraph.storage

import com.github.luben.zstd.Zstd
import flatgraph.*
import flatgraph.Edge.Direction
import flatgraph.storage.Manifest.{GraphItem, OutlineStorage}

import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.nio.{ByteBuffer, ByteOrder}
import scala.collection.mutable

object Deserialization {

  def readGraph(storagePath: Path, schemaMaybe: Option[Schema], persistOnClose: Boolean = true): Graph = {
    val fileChannel = new java.io.RandomAccessFile(storagePath.toAbsolutePath.toFile, "r").getChannel
    try {
      // fixme: Use convenience methods from schema to translate string->id. Fix after we get strict schema checking.
      val manifest = readManifest(fileChannel)
      val pool     = readPool(manifest, fileChannel)
      val schema   = schemaMaybe.getOrElse(freeSchemaFromManifest(manifest))
      val storagePathMaybe =
        if (persistOnClose) Option(storagePath)
        else None
      val g         = new Graph(schema, storagePathMaybe)
      val nodekinds = mutable.HashMap[String, Short]()
      for (nodeKind <- g.schema.nodeKinds) nodekinds(g.schema.getNodeLabel(nodeKind)) = nodeKind.toShort
      val kindRemapper = Array.fill(manifest.nodes.size)(-1.toShort)
      val nodeRemapper = new Array[Array[GNode]](manifest.nodes.length)
      for {
        (nodeItem, idx) <- manifest.nodes.zipWithIndex
        nodeKind        <- nodekinds.get(nodeItem.nodeLabel)
      } {
        kindRemapper(idx) = nodeKind
        val nodes = new Array[GNode](nodeItem.nnodes)
        for (seq <- Range(0, nodes.length)) nodes(seq) = g.schema.makeNode(g, nodeKind, seq)
        g.nodesArray(nodeKind) = nodes
        nodeRemapper(idx) = nodes
        if (nodeItem.deletions != null) {
          for (del <- nodeItem.deletions) {
            val node = nodes(del)
            if (!AccessHelpers.isDeleted(node)) AccessHelpers.markDeleted(nodes(del))
            else throw new RuntimeException()
          }
          g.livingNodeCountByKind(nodeKind) = nodes.length - nodeItem.deletions.length
        } else g.livingNodeCountByKind(nodeKind) = nodes.length
      }

      val edgeKinds = mutable.HashMap[(String, String), Short]()
      for {
        nodeKind <- g.schema.nodeKinds
        edgeKind <- g.schema.edgeKinds
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
          g.neighbors(pos) = deltaDecode(readArray(fileChannel, edgeItem.qty, nodeRemapper, pool).asInstanceOf[Array[Int]])
          g.neighbors(pos + 1) = readArray(fileChannel, edgeItem.neighbors, nodeRemapper, pool)
          val property = readArray(fileChannel, edgeItem.property, nodeRemapper, pool)
          if (property != null)
            g.neighbors(pos + 2) = property
        }
      }

      val propertykinds = mutable.HashMap[(String, String), Int]()
      for {
        nodeKind     <- g.schema.nodeKinds
        propertyKind <- g.schema.propertyKinds
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
          g.properties(pos) = deltaDecode(readArray(fileChannel, property.qty, nodeRemapper, pool).asInstanceOf[Array[Int]])
          g.properties(pos + 1) = readArray(fileChannel, property.property, nodeRemapper, pool)
        }
      }
      g
    } finally fileChannel.close()
  }

  private def freeSchemaFromManifest(manifest: Manifest.GraphItem): FreeSchema = {
    val nodeLabels    = manifest.nodes.map { n => n.nodeLabel }
    val nodePropNames = mutable.LinkedHashMap.empty[String, AnyRef]
    val propertyNamesByNodeLabel = mutable.LinkedHashMap.empty[String, Set[String]]
    for (prop <- manifest.properties) {
      propertyNamesByNodeLabel.updateWith(prop.nodeLabel) {
        case None => Some(Set(prop.propertyLabel))
        case Some(oldEntries) => Some(oldEntries + prop.propertyLabel)
      }
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

    new FreeSchema(nodeLabels, propertyLabels, nodePropertyPrototypes, propertyNamesByNodeLabel.toMap, edgeLabels, edgePropertyPrototypes)
  }

  private def protoFromOutline(outline: OutlineStorage): AnyRef = {
    if (outline == null) return null
    outline.typ match {
      case StorageType.Bool   => new Array[Boolean](0)
      case StorageType.Byte   => new Array[Byte](0)
      case StorageType.Short  => new Array[Short](0)
      case StorageType.Int    => new Array[Int](0)
      case StorageType.Long   => new Array[Long](0)
      case StorageType.Float  => new Array[Float](0)
      case StorageType.Double => new Array[Double](0)
      case StorageType.Ref    => new Array[GNode](0)
      case StorageType.String => new Array[String](0)
    }
  }

  private def readManifest(channel: FileChannel): GraphItem = {
    if (channel.size() < HeaderSize)
      throw new DeserializationException(s"corrupt file, expected at least $HeaderSize bytes, but only found ${channel.size()}")

    val header    = ByteBuffer.allocate(HeaderSize).order(ByteOrder.LITTLE_ENDIAN)
    var readBytes = 0
    while (readBytes < HeaderSize) {
      readBytes += channel.read(header, readBytes)
    }
    header.flip()

    if (header.getLong() != Keys.Header)
      throw new DeserializationException(s"expected header (`${Keys.Header}`), but found ${header.getLong}")

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

  private def readPool(manifest: GraphItem, fileChannel: FileChannel): Array[String] = {
    val stringPoolLength = Zstd
      .decompress(
        fileChannel.map(FileChannel.MapMode.READ_ONLY, manifest.stringPoolLength.startOffset, manifest.stringPoolLength.compressedLength),
        manifest.stringPoolLength.decompressedLength
      )
      .order(ByteOrder.LITTLE_ENDIAN)
    val stringPoolBytes = Zstd
      .decompress(
        fileChannel
          .map(FileChannel.MapMode.READ_ONLY, manifest.stringPoolBytes.startOffset, manifest.stringPoolBytes.compressedLength),
        manifest.stringPoolBytes.decompressedLength
      )
      .order(ByteOrder.LITTLE_ENDIAN)
    val poolBytes = new Array[Byte](manifest.stringPoolBytes.decompressedLength)
    stringPoolBytes.get(poolBytes)
    val pool    = new Array[String](manifest.stringPoolLength.decompressedLength >> 2)
    var idx     = 0
    var poolPtr = 0
    while (idx < pool.length) {
      val len = stringPoolLength.getInt()
      pool(idx) = new String(poolBytes, poolPtr, len, StandardCharsets.UTF_8)
      idx += 1
      poolPtr += len
    }
    pool
  }

  private def deltaDecode(a: Array[Int]): Array[Int] = {
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

  private def readArray(channel: FileChannel, ptr: OutlineStorage, nodes: Array[Array[GNode]], stringPool: Array[String]): Array[?] = {
    if (ptr == null) return null
    val dec = Zstd
      .decompress(channel.map(FileChannel.MapMode.READ_ONLY, ptr.startOffset, ptr.compressedLength), ptr.decompressedLength)
      .order(ByteOrder.LITTLE_ENDIAN)
    ptr.typ match {
      case StorageType.Bool =>
        val bytes = new Array[Byte](dec.limit())
        dec.get(bytes)
        bytes.map {
          case 0 => false
          case 1 => true
        }
      case StorageType.Byte =>
        val bytes = new Array[Byte](dec.limit())
        dec.get(bytes)
        bytes
      case StorageType.Short =>
        val res = new Array[Short](dec.limit() >> 1)
        dec.asShortBuffer().get(res)
        res
      case StorageType.Int =>
        val res = new Array[Int](dec.limit() >> 2)
        dec.asIntBuffer().get(res)
        res
      case StorageType.Long =>
        val res = new Array[Long](dec.limit() >> 3)
        dec.asLongBuffer().get(res)
        res
      case StorageType.Float =>
        val res = new Array[Float](dec.limit() >> 2)
        dec.asFloatBuffer().get(res)
        res
      case StorageType.Double =>
        val res = new Array[Double](dec.limit() >> 3)
        dec.asDoubleBuffer().get(res)
        res
      case StorageType.String =>
        val res    = new Array[String](dec.limit() >> 2)
        val intbuf = dec.asIntBuffer()
        var idx    = 0
        while (idx < res.length) {
          val offset = intbuf.get(idx)
          if (offset >= 0) res(idx) = stringPool(offset)
          idx += 1
        }
        res
      case StorageType.Ref =>
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

  class DeserializationException(message: String, cause: Option[Throwable] = None) extends RuntimeException(message, cause.orNull)
}
