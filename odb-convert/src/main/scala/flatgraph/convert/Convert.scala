package flatgraph.convert

import flatgraph.{Edge, storage}
import flatgraph.storage.{Keys, Manifest, Serialization, StorageType}
import org.msgpack.core.MessagePack
import overflowdb.storage.{OdbStorage, ValueTypes}

import java.io.{ByteArrayOutputStream, File}
import java.nio.charset.StandardCharsets
import java.nio.file.{Path, Paths}
import java.nio.{ByteBuffer, ByteOrder}
import java.util.concurrent.atomic.AtomicLong
import scala.collection.mutable

object Convert {

  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println("Usage: convert [inputfile] [outputfile]")
      System.err.println("Error: missing input and/or output file - exiting.")
    } else {
      apply(overflowDbFile = Paths.get(args(0)), outputFile = Paths.get(args(1)))
    }
  }

  def apply(overflowDbFile: Path, outputFile: Path): Unit = {
    val storage = overflowdb.storage.OdbStorage.createWithSpecificLocation(overflowDbFile.toFile, new overflowdb.util.StringInterner)
    val (nodes, strings) = readOdb(storage)
    writeData(outputFile.toFile, nodes, strings)
  }

  private class NodeRefTmp(val legacyId: Long) {
    var newId: Long = -1L
  }

  private class StringRef(val idx: Int, val string: String)

  private object NodeStuff {
    val NODEPROPERTY        = "p"
    val NEIGHBOR_IN         = "i"
    val NEIGHBOR_OUT        = "o"
    val EDGEPROPERTY_SUFFIX = "x"
    val legacyId            = "legacyId"
  }

  private class NodeStuff(val label: String, val kind: Int) {
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
      for (qq                 <- quantities.valuesIterator) { while (qq.length < nextId) qq.addOne(0) }
      for (((prefix, key), v) <- values.iterator if prefix.endsWith(NodeStuff.EDGEPROPERTY_SUFFIX)) {
        val stripped =
          if (prefix == NodeStuff.NEIGHBOR_IN + NodeStuff.EDGEPROPERTY_SUFFIX) NodeStuff.NEIGHBOR_IN else NodeStuff.NEIGHBOR_OUT
        val nNeighbors = values((stripped, key)).length
        while (v.length < nNeighbors) v.addOne(null)
      }
    }
  }

  private def writeData(filename: File, nodeStuff: Array[NodeStuff], strings: Array[String]): Unit = {
    val filePtr     = new AtomicLong(16)
    val fileChannel = new java.io.RandomAccessFile(filename, "rw").getChannel
    try {
      val nodes      = nodeStuff.map { ns => new Manifest.NodeItem(ns.label, ns.nextId, null) }
      val edges      = mutable.ArrayBuffer[Manifest.EdgeItem]()
      val properties = mutable.ArrayBuffer[Manifest.PropertyItem]()
      for {
        node                      <- nodeStuff
        ((prefix, key), quantity) <- node.quantities.iterator
      } {
        val deltaEncoded   = quantity.addOne(0).toArray
        val qty            = Serialization.encodeAny(deltaEncoded, filePtr, null, fileChannel)
        val (valtyp, vals) = homogenize(node.values((prefix, key)))
        if (valtyp != null) {
          val values = storage.Serialization.encodeAny(vals, filePtr, null, fileChannel)
          values.typ = valtyp
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
                    val stored = storage.Serialization.encodeAny(pval, filePtr, null, fileChannel)
                    stored.typ = ptype
                    edgeItem.property = stored
                  }
              }
          }
        }
      }
      val poolLenBytes  = new Array[Byte](4 * strings.length)
      val poolLenBuffer = ByteBuffer.wrap(poolLenBytes).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer()
      val poolBytes     = new ByteArrayOutputStream()
      for (s <- strings) {
        val bytes = s.getBytes(StandardCharsets.UTF_8)
        poolBytes.write(bytes)
        poolLenBuffer.put(bytes.length)
      }
      val poolLensStored  = new Manifest.OutlineStorage(StorageType.Int)
      val poolBytesStored = new Manifest.OutlineStorage(storage.StorageType.Byte)
      storage.Serialization.write(poolLenBytes, poolLensStored, filePtr, fileChannel)
      storage.Serialization.write(poolBytes.toByteArray, poolBytesStored, filePtr, fileChannel)

      var pos       = filePtr.get()
      val header    = new Array[Byte](16)
      val headerBuf = ByteBuffer.wrap(header)
      headerBuf.order(ByteOrder.LITTLE_ENDIAN).asLongBuffer().put(Keys.Header).put(pos)
      headerBuf.position(0)
      var headPos = 0L
      while (headerBuf.hasRemaining()) {
        headPos += fileChannel.write(headerBuf, headPos)
      }
      val manifest    = new Manifest.GraphItem(nodes.toArray, edges.toArray, properties.toArray, poolLensStored, poolBytesStored)
      val manifestObj = Manifest.GraphItem.write(manifest)
      val buf         = ByteBuffer.wrap(manifestObj.render().getBytes(StandardCharsets.UTF_8))
      while (buf.hasRemaining()) {
        pos += fileChannel.write(buf, pos)
      }
      fileChannel.truncate(pos)

      // tmp debug
      // println(manifestObj.render(indent = 4))

    } finally { fileChannel.close() }
  }

  private def homogenize(items: mutable.ArrayBuffer[Any]): (String, Array[_]) = {
    items.find { _ != null } match {
      case None             => (null, null)
      case Some(_: Boolean) => (storage.StorageType.Bool, items.asInstanceOf[mutable.ArrayBuffer[Boolean]].toArray)
      case Some(_: Byte)    => (storage.StorageType.Byte, items.asInstanceOf[mutable.ArrayBuffer[Byte]].toArray)
      case Some(_: Short)   => (storage.StorageType.Short, items.asInstanceOf[mutable.ArrayBuffer[Short]].toArray)
      case Some(_: Int)     => (storage.StorageType.Int, items.asInstanceOf[mutable.ArrayBuffer[Int]].toArray)
      case Some(_: Long)    => (storage.StorageType.Long, items.asInstanceOf[mutable.ArrayBuffer[Long]].toArray)
      case Some(_: Float)   => (storage.StorageType.Float, items.asInstanceOf[mutable.ArrayBuffer[Float]].toArray)
      case Some(_: Double)  => (storage.StorageType.Double, items.asInstanceOf[mutable.ArrayBuffer[Double]].toArray)
      case Some(_: StringRef) =>
        (
          storage.StorageType.String,
          items.asInstanceOf[mutable.ArrayBuffer[StringRef]].map { ref => if (ref == null) -1 else ref.idx }.toArray
        )
      case Some(_: NodeRefTmp) =>
        (
          storage.StorageType.Ref,
          items.asInstanceOf[mutable.ArrayBuffer[NodeRefTmp]].map { ref => if (ref == null) 0x0000ffffffffffffL else ref.newId }.toArray
        )
      case Some(other) => throw new AssertionError(s"unexpected item found: $other of type ${other.getClass}")
    }
  }

  private def readOdb(storage: overflowdb.storage.OdbStorage): (Array[NodeStuff], Array[String]) = {
    val legacyIdToNewId = mutable.HashMap[Long, NodeRefTmp]()
    val stringInterner  = mutable.LinkedHashMap[String, StringRef]()
    val byLabel         = mutable.LinkedHashMap[String, NodeStuff]()
    val iter            = storage.allNodes().iterator
    while (iter.hasNext) {
      val e         = iter.next()
      val legacyId  = e.getKey
      val bytes     = e.getValue
      val unpacker  = MessagePack.newDefaultUnpacker(bytes)
      val legacyId2 = unpacker.unpackLong()
      assert(legacyId2 == legacyId)

      val label     = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())
      val sz        = byLabel.size
      val nodeStuff = byLabel.getOrElseUpdate(label, new NodeStuff(label, sz))
      val ref       = legacyIdToNewId.getOrElseUpdate(legacyId, new NodeRefTmp(legacyId))
      ref.newId = nodeStuff.nextId.toLong + (nodeStuff.kind.toLong << 32)
      nodeStuff.nextId += 1
      nodeStuff.addX(NodeStuff.NODEPROPERTY, NodeStuff.legacyId, legacyId)
      for (_ <- Range(0, unpacker.unpackMapHeader())) {
        val key = storage.reverseLookupStringToIntMapping(unpacker.unpackInt())
        for (v <- unpackValue(unpacker.unpackValue().asArrayValue())) {
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
                val pvals = unpackValue(unpacker.unpackValue().asArrayValue())
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

    def unpackValue(
      valueOrPair: org.msgpack.value.Value,
      res: mutable.ArrayBuffer[Any] = mutable.ArrayBuffer[Any](),
      typId: Option[ValueTypes] = None
    ): mutable.ArrayBuffer[Any] = {
      val (typId_, v) = typId match {
        case None =>
          val iter = valueOrPair.asArrayValue().iterator()
          (ValueTypes.lookup(iter.next.asIntegerValue.asByte), iter.next)
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
        case ValueTypes.STRING =>
          val s = v.asStringValue().asString()
          res.addOne(stringInterner.getOrElseUpdate(s, new StringRef(stringInterner.size, s)))
        case ValueTypes.NODE_REF =>
          val legacyId = v.asIntegerValue.asLong
          res.addOne(legacyIdToNewId.get(legacyId) match {
            case null =>
              val tmp = new NodeRefTmp(legacyId)
              legacyIdToNewId.put(legacyId, tmp)
              res
            case exists => exists
          })
        case ValueTypes.LIST | ValueTypes.ARRAY_OBJECT =>
          val iter = v.asArrayValue().iterator()
          while (iter.hasNext) {
            unpackValue(iter.next().asArrayValue(), res)
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
            unpackValue(iter.next().asArrayValue(), res, Some(elementType))
          }

        case _ => ???
      }

      res
    }
    byLabel.valuesIterator.foreach { _.pad() }
    (byLabel.valuesIterator.toArray, stringInterner.keysIterator.toArray)
  }

}
