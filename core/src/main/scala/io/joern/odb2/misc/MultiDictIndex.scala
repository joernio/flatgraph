package io.joern.odb2.misc

import scala.collection.mutable

private[odb2] class MultiDictIndex[K <: AnyRef, V <: AnyRef] {
  private var keys: Array[AnyRef]   = _
  private var values: Array[AnyRef] = _
  private var size                  = 0
  private var finished = false
  def initForSize(sizehint: Int): Unit = {
    size = sizehint + sizehint >> 2
    keys = new Array[AnyRef](size)
    values = new Array[AnyRef](size)
  }

  private def hashToPos(hash0: Int): Int = {
    // using the simple murmur 32 bit mixing to strengthen the hash
    var hash = hash0 ^ hash0 >>> 16
    hash *= 0x85ebca6b
    hash ^= hash >>> 13
    hash *= 0xc2b2ae35
    hash ^= hash >>> 16

    (((hash.toLong & 0x00000000ffffffffL) * size.toLong) >> 32).toInt
  }

  def insert(key: K, value: V): Unit = {
    if (key == null) return
    if(finished) throw new RuntimeException("Cannot insert into finished index")
    var pos = hashToPos(key.hashCode())
    while (true) {
      if (pos >= size) pos = 0
      val k = keys(pos)
      if (k eq null) {
        keys(pos) = key
        values(pos) = value
        return
      } else if (k.equals(key)) {
        values(pos) match {
          case buf: mutable.ArrayBuffer[V] => buf.addOne(value)
          case old: V @unchecked =>
            values(pos) = mutable.ArrayBuffer(old, value)
        }
        return
      }
      pos += 1
    }
  }

  def shrinkfit(): Unit = {
    var idx = 0
    while (idx < size) {
      keys(idx) match {
        case buf: mutable.ArrayBuffer[V] => keys(idx) = buf.toArray[AnyRef]
        case _                           =>
      }
      idx += 1
    }
    finished = true
  }
  def get(key: K): Iterator[V] = {
    if (key == null) return null
    if(!finished) throw new RuntimeException("Cannot lookup in unfinished index")
    var pos = hashToPos(key.hashCode())
    while (true) {
      if (pos >= size) pos = 0
      val k = keys(pos)
      if (k eq null) {
        return Iterator.empty
      } else if (k.equals(key)) {
        values(pos) match {
          case buf: Array[AnyRef]   => return buf.iterator.asInstanceOf[Iterator[V]]
          case single: V @unchecked => return Iterator(single)
        }
      }
      pos += 1
    }
    throw new RuntimeException("unreachable")
  }

}
