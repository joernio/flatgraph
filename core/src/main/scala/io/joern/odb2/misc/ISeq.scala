package io.joern.odb2.misc

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
class ISeq[@specialized +T](underlying: Array[T], start: Int, end: Int)
    extends scala.collection.immutable.IndexedSeq[T] {
  override def length: Int = end - start

  override def apply(idx: Int): T = underlying.apply(idx + start)
}
