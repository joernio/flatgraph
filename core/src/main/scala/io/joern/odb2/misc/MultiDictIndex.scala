package io.joern.odb2.misc

import scala.annotation.tailrec
import scala.collection.mutable
import scala.reflect.ClassTag

private[odb2] class MultiDictIndex[A <: AnyRef](sizeHint: Int) {
  private val size                  = sizeHint + (sizeHint >> 1)
  private val keys: Array[String]   = new Array[String](size)
  private val values: Array[AnyRef] = new Array[AnyRef](size) // holds single elements of type `A` and lists of type `Array[A]`, hence the use of `AnyRef`
  private var finalized             = false

  def insert(key: String, value: A): Unit = {
    if (key != null) {
      assert(!finalized, "Cannot insert into finalized index")
      val startPosition = hashToPos(key.hashCode())
      insert0(key, value, position = startPosition)
    }
  }

  @tailrec
  private def insert0(key: String, value: A, position: Int, iteration: Int = 0): Unit = {
    assert(iteration < size,
      s"We've tried all possible slots, none of which was available - please allocate a large-enough index! iteration=$iteration, size=$size")

    if (position >= size) {
      // we've reached the end of the slots. overflow: try from index 0
      insert0(key, value, position = 0, iteration = iteration + 1)
    } else {
      keys(position) match {
        case null =>
          // found a free slot: insert here
          keys(position) = key
          values(position) = value
        case k if k == key =>
          // found the right (preexistent) slot for this key: append to existing entries
          values(position) match {
            case buf: mutable.ArrayBuffer[A @unchecked] => buf.addOne(value)
            case old =>
              values(position) = mutable.ArrayBuffer(old, value)
          }
        case _ =>
          // this slot is already taken - try the next one
          insert0(key, value, position + 1, iteration = iteration + 1)
      }
    }
  }

  def shrinkFit(): Unit = {
    var idx = 0
    while (idx < size) {
      values(idx) match {
        case buf: mutable.ArrayBuffer[A @unchecked] =>
          values(idx) = buf.toArray[AnyRef]
        case _  =>
      }
      idx += 1
    }
    finalized = true
  }

  def get(key: String): Iterator[A] = {
    if (key == null) return null
    if (!finalized) throw new RuntimeException("Cannot lookup in an index that's not finalized - please invoke `shrinkFit` first")
    val startPosition = hashToPos(key.hashCode())
    get0(key, position = startPosition)
  }

  @tailrec
  private def get0(key: String, position: Int, iteration: Int = 0): Iterator[A] = {
    if (iteration >= size) {
      // we've tried all possible slots
      Iterator.empty
    } else {
      if (position >= size) {
        // we've reached the end of the slots. overflow: try from index 0
        get0(key, position = 0, iteration = iteration + 1)
      } else {
        keys(position) match {
          case null => Iterator.empty
          case k if k == key =>
            // found the right (preexistent) slot for this key: append to existing entries
            values(position) match {
              case multiple: mutable.ArrayBuffer[A@unchecked] => multiple.iterator
              case single: A @unchecked => Iterator.single(single)
            }
          case _ =>
            // key not found so far - try the next slot
            get0(key, position + 1, iteration = iteration + 1)
        }
      }
    }
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
