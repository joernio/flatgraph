package io.joern.odb2.misc

import io.joern.odb2.GNode

import scala.collection.mutable

private[odb2] class MultiDictIndex {
  private var keys: Array[String]   = _
  private var values: Array[AnyRef] = _
  private var size                  = 0
  private var finished              = false

  def initForSize(sizeHint: Int): Unit = {
    size = sizeHint + (sizeHint >> 1)
    keys = new Array[String](size)
    values = new Array[AnyRef](size)
  }

  def insert(key: String, value: GNode): Unit = {
    if (key != null) {
      assert(!finished, "Cannot insert into finished index")
      var position = hashToPos(key.hashCode())
      var inserted = false
      while (!inserted) {
        if (position >= size) position = 0
        keys(position) match {
          case null =>
            keys(position) = key
            values(position) = value
            inserted = true
          case k if k == key =>
            values(position) match {
              case buf: mutable.ArrayBuffer[GNode] => buf.addOne(value)
              case old: GNode =>
                values(position) = mutable.ArrayBuffer(old, value)
            }
            inserted = true
          case _ =>
            position += 1
        }
      }
    }
  }

  def shrinkfit(): Unit = {
    var idx = 0
    while (idx < size) {
      values(idx) match {
        case buf: mutable.ArrayBuffer[GNode] => values(idx) = buf.toArray[GNode]
        case _                               =>
      }
      idx += 1
    }
    finished = true
  }
  def get(key: String): Iterator[GNode] = {
    if (key == null) return null
    if (!finished) throw new RuntimeException("Cannot lookup in unfinished index")
    var pos = hashToPos(key.hashCode())
    while (true) {
      if (pos >= size) pos = 0
      val k = keys(pos)
      if (k == null) {
        return Iterator.empty
      } else if (k == key) {
        values(pos) match {
          case buf: Array[GNode] => return buf.iterator
          case single: GNode     => return Iterator(single)
        }
      }
      pos += 1
    }
    throw new RuntimeException("unreachable")
  }

  private def hashToPos(hash0: Int): Int = {
    // using the simple murmur 32 bit mixing to strengthen the hash
    var hash = hash0 ^ (hash0 >>> 16)
    hash *= 0x85ebca6b
    hash ^= hash >>> 13
    hash *= 0xc2b2ae35
    hash ^= hash >>> 16

    (((hash.toLong & 0x00000000ffffffffL) * size.toLong) >> 32).toInt
  }

}
