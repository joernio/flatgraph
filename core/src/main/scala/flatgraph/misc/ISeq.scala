package flatgraph.misc

import flatgraph.{AccessHelpers, GNode}

object ISeq {
  val empty = new ISeq(new Array[Nothing](0), 0, 0)

  def from(arr: Object, start: Int, end: Int): ISeq[Any] = {
    arr match {
      case null              => ISeq.empty
      case a: Array[Boolean] => new ISeq(a, start, end)
      case a: Array[Byte]    => new ISeq(a, start, end)
      case a: Array[Short]   => new ISeq(a, start, end)
      case a: Array[Int]     => new ISeq(a, start, end)
      case a: Array[Long]    => new ISeq(a, start, end)
      case a: Array[Float]   => new ISeq(a, start, end)
      case a: Array[Double]  => new ISeq(a, start, end)
      case a: Array[AnyRef]  => new ISeq(a, start, end)
    }
  }
}
class ISeq[@specialized +T](underlying: Array[T], start: Int, end: Int) extends scala.collection.immutable.IndexedSeq[T] {
  override def length: Int = end - start

  override def apply(idx: Int): T = underlying.apply(idx + start)
}

abstract class InitNodeIterator[T <: GNode] extends Iterator[T] {
  def isVirgin: Boolean
}
class InitNodeIteratorArray[T <: GNode](arr: Array[GNode]) extends InitNodeIterator[T] {
  private var pos       = 0
  def isVirgin: Boolean = pos == 0

  override def hasNext: Boolean = pos < arr.length

  override def knownSize: Int = arr.length
  override def next(): T = {
    val res = arr(pos).asInstanceOf[T]
    pos += 1
    res
  }
}

class InitNodeIteratorArrayFiltered[T <: GNode](arr: Array[GNode]) extends InitNodeIterator[T] {
  private var pos       = 0
  private var skipped   = 0
  def isVirgin: Boolean = pos - skipped <= 0

  override def hasNext: Boolean = {
    while (pos < arr.length && AccessHelpers.isDeleted(arr(pos))) {
      skipped += 1
      pos += 1
    }
    pos < arr.length
  }

  override def next(): T = {
    hasNext
    val res = arr(pos).asInstanceOf[T]
    pos += 1
    res
  }
}
