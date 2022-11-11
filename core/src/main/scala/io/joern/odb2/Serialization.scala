package io.joern.odb2
import io.joern.odb2.StorageManifest._

import scala.collection.mutable

object StorageManifest {

  // the Box class exists in lieu of taking the address of contents, i.e. such that we can later update it in place for asynchronous storage
  class Box[T](var contents: T = null) {}

  class StorageWrap(
    val nodes: Array[NodeItem],
    val edges: Array[EdgeItem],
    val properties: Array[PropertyItem],
    val stringpool: Box[StringPool] = new Box
  )

  class NodeItem(val nodeLabel: String, val nnodes: Int, var deletions: Box[IntArray] = new Box)

  class EdgeItem(
    val nodeLabel: String,
    val edgeLabel: String,
    val inout: Int,
    val qty: Box[IntArray] = new Box(),
    val neighbors: Box[RefArray] = new Box(),
    val property: Box[AnyArray] = new Box()
  )

  class PropertyItem(
    val nodeLabel: String,
    val propertyLabel: String,
    val qty: Box[IntArray] = new Box(),
    val values: Box[AnyArray] = new Box()
  )

  sealed trait AnyArray

  // same for: bool, byte, short, long, float, double

  sealed trait BoolArray                                                                          extends AnyArray
  class InlineBoolArray(val bools: Array[Boolean])                                                extends BoolArray
  class ConstBoolArray(val value: Boolean, val size: Int)                                         extends BoolArray
  class ExternalBoolArray(val start: Long, val end: Long, val size: Int, val compression: String) extends BoolArray

  sealed trait ByteArray                                                                         extends AnyArray
  class InlineByteArray(val bytes: Array[Byte])                                                  extends ByteArray
  class ConstByteArray(val value: Byte, val size: Int)                                           extends ByteArray
  class ExternalByterray(val start: Long, val end: Long, val size: Int, val compression: String) extends ByteArray

  sealed trait ShortArray                                                                          extends AnyArray
  class InlineShortArray(val shorts: Array[Short])                                                 extends ShortArray
  class ConstShortArray(val value: Short, val size: Int)                                           extends ShortArray
  class ExternalShortArray(val start: Long, val end: Long, val size: Int, val compression: String) extends ShortArray

  sealed trait IntArray extends AnyArray {
    def get: Array[Int]
  }
  class InlineIntArray(val ints: Array[Int]) extends IntArray {
    override def get: Array[Int] = ints
  }

  sealed trait LongArray extends AnyArray
  // fixme: this may need splitting in top-and-bottomn for json in order to help JS (because int64 support sucks)
  // that's not an issue for noderef or file offsets -- they may overflow int32, but are effectively int48,
  // and definitely won't overflow the available int53
  class InlineLongArray(val longs: Array[Long])                                                   extends LongArray
  class ConstLongArray(val value: Long, val size: Int)                                            extends LongArray
  class ExternalLongArray(val start: Long, val end: Long, val size: Int, val compression: String) extends LongArray

  sealed trait FloatArray                          extends AnyArray
  class InlineFloatArray(val floats: Array[Float]) extends FloatArray

  sealed trait DoubleArray                            extends AnyArray
  class InlineDoubleArray(val doubles: Array[Double]) extends DoubleArray

  sealed trait StringArray                                 extends AnyArray
  class ConstStringArray(val value: String, val size: Int) extends StringArray
  class InlineStringArray(val strings: Array[String])      extends StringArray
  class PoolRefArray(val poolRefs: IntArray)               extends StringArray

  sealed trait RefArray                                                                          extends AnyArray
  class InlineRefArray(val kinds: Array[Short], val seqs: Array[Int])                            extends RefArray
  class ExternalRefArray(val start: Long, val end: Long, val size: Int, val compression: String) extends RefArray

  sealed trait StringPool
  class InlineStringPool(val strings: Array[String]) extends StringPool
}

class StorageConfig

object Foo {

  def encodeRefs(nodes: Array[GNode], config: StorageConfig): RefArray = {
    if (nodes == null) null
    else {
      val len   = nodes.length
      val kinds = new Array[Short](len)
      val seqs  = new Array[Int](len)
      for (idx <- Range(0, len)) {
        kinds(idx) = nodes(idx).nodeKind
        seqs(idx) = nodes(idx).seq()
      }
      new InlineRefArray(kinds, seqs)
    }
  }
  def encodeQty(nnodes: Int, qty: Array[Int], config: StorageConfig): IntArray = {
    val intermediate = new Array[Int](nnodes + 1)
    for (idx <- Range(0, scala.math.min(intermediate.length - 1, qty.length - 1))) {
      intermediate(idx) = qty(idx + 1) - qty(idx)
    }
    new InlineIntArray(intermediate)
  }

  def encodeAny(item: Any, config: StorageConfig): AnyArray = {
    item match {
      case null                   => null
      case bools: Array[Boolean]  => new InlineBoolArray(bools)
      case bytes: Array[Byte]     => new InlineByteArray(bytes)
      case shorts: Array[Short]   => new InlineShortArray(shorts)
      case ints: Array[Int]       => new InlineIntArray(ints)
      case longs: Array[Long]     => new InlineLongArray(longs)
      case floats: Array[Float]   => new InlineFloatArray(floats)
      case doubles: Array[Double] => new InlineDoubleArray(doubles)
      case refs: Array[GNode]     => encodeRefs(refs, config)
      case strings: Array[String] => new InlineStringArray(strings)

    }
  }

  def serialize(g: Graph, config: StorageConfig): StorageManifest.StorageWrap = {
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
      nodes.addOne(new StorageManifest.NodeItem(nodeLabel, size, new StorageManifest.Box(new InlineIntArray(deletions))))

    }
    for (
      nodeKind <- Range(0, g.schema.getNumberOfNodeKinds);
      edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds);
      inout    <- Range(0, 2)
    ) {
      val pos = g.schema.neighborOffsetArrayIndex(nodeKind, inout, edgeKind)
      if (g._neighbors(pos) != null) {
        val nodeLabel = g.schema.getNodeLabel(nodeKind)
        val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
        val edgeItem  = new StorageManifest.EdgeItem(nodeLabel, edgeLabel, inout)
        edges.addOne(edgeItem)
        edgeItem.qty.contents = encodeQty(g._nodes(nodeKind).length, g._neighbors(pos).asInstanceOf[Array[Int]], config)
        edgeItem.neighbors.contents = encodeRefs(g._neighbors(pos + 1).asInstanceOf[Array[GNode]], config)
        edgeItem.property.contents = encodeAny(g._neighbors(pos + 1), config)
      }
    }
    for (
      nodeKind     <- Range(0, g.schema.getNumberOfNodeKinds);
      propertyKind <- Range(9, g.schema.getNumberOfProperties)
    ) {
      val pos = g.schema.propertyOffsetArrayIndex(nodeKind, propertyKind)
      if (g._properties(pos) != null) {
        val nodeLabel     = g.schema.getNodeLabel(nodeKind)
        val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
        val propertyItem  = new StorageManifest.PropertyItem(nodeLabel, propertyLabel)
        properties.addOne(propertyItem)
        propertyItem.qty.contents = encodeQty(g._nodes(nodeKind).length, g._properties(pos).asInstanceOf[Array[Int]], config)
        propertyItem.values.contents = encodeAny(g._properties(pos), config)
      }
    }
    val stringpool = new StorageManifest.InlineStringPool(new Array[String](0))
    new StorageWrap(nodes.toArray, edges.toArray, properties.toArray, new Box(stringpool))
  }

  def deserialize(g: Graph, manifest: StorageWrap): Unit = {
    val nodekinds = mutable.HashMap[String, Short]()
    for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) nodekinds(g.schema.getNodeLabel(nodeKind)) = nodeKind.toShort
    val kindRemapper = Array.fill(manifest.nodes.size)(-1.toShort)
    for ((nodeItem, idx) <- manifest.nodes.zipWithIndex) {
      val nodeKind = nodekinds.get(nodeItem.nodeLabel)
      if (nodeKind.isDefined) {
        kindRemapper(idx) = nodeKind.get
        val nodes = new Array[GNode](nodeItem.nnodes)
        for (seq <- Range(0, nodes.length)) nodes(seq) = g.schema.makeNode(g, nodeKind.get, seq)
        g._nodes(nodeKind.get) = nodes
        for (del <- nodeItem.deletions.contents.get) {
          AccessHelpers.markDeleted(nodes(del))
        }
      }
    }

    val edgeKinds = mutable.HashMap[(String, String), Short]()
    for (
      nodeKind <- Range(0, g.schema.getNumberOfNodeKinds);
      edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)
    ) {
      val nodeLabel = g.schema.getNodeLabel(nodeKind)
      val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
      if (edgeLabel != null) {
        edgeKinds((nodeLabel, edgeLabel)) = edgeKind.toShort
      }
    }

    for (edgeItem <- manifest.edges) {
      val qty = edgeItem.qty.contents.get

    }

    val propertykinds = mutable.HashMap[(String, String), Short]()
    for (
      nodeKind     <- Range(0, g.schema.getNumberOfNodeKinds);
      propertyKind <- Range(0, g.schema.getNumberOfProperties)
    ) {
      val nodeLabel     = g.schema.getNodeLabel(nodeKind)
      val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
      if (propertyLabel != null) {
        propertykinds((nodeLabel, propertyLabel)) = null
      }
    }

  }

}
class GraphSerializer {}
