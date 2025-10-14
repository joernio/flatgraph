package flatgraph.misc

import java.util

/** A basic LinkedHashSet-like structure, based on an open hashmap. Somewhat surprisingly, it actually pays to store part of the hash in the
  * upper bits of the index into tha values array
  *
  * This is a fastpath to avoid some unneeded expensive isequal-checks. (expensive because they imply following an object reference)
  *
  * The thing is arranged such that a zero value in pos signifies an empty slot
  */
private[flatgraph] class DedupTable {
  var capacity = 1024
  var size     = 0
  var strs     = new Array[String](capacity)
  var pos      = new Array[Int](capacity)

  def insert(str: String): Int = {
    val cap  = capacity
    val mask = cap - 1
    if (str == null) return -1
    val h      = strengthenHash(str.hashCode)
    var p      = h & mask
    val needle = h & ~mask
    while (true) {
      val idx0 = pos(p)
      val idx  = (idx0 & mask) - 1
      if (idx == -1) {
        val dst = size
        size = size + 1
        strs(dst) = str
        pos(p) = (dst + 1) | needle
        if (size + (size >> 1) > capacity) grow()
        return dst
      } else if ((idx0 & ~mask) == needle && str.equals(strs(idx))) return idx
      p = p + 1
      if (p == cap) {
        // overflow -- rare, so better branch than branchless
        p = 0
      }
    }
    ???
  }

  def insertRehash(str: String): Unit = {
    val cap    = capacity
    val mask   = cap - 1
    val h      = strengthenHash(str.hashCode)
    var p      = h & mask
    val needle = h & ~mask
    while (true) {
      val idx0 = pos(p)
      val idx  = (idx0 & mask) - 1
      if (idx == -1) {
        val dst = size
        size = size + 1
        pos(p) = (dst + 1) | needle
        return
      }
      p = p + 1
      if (p == cap) {
        // overflow -- rare, so better branch than branchless
        p = 0
      }
    }
    ???
  }

  def grow(): Unit = {
    val oldsize = size
    size = 0
    capacity = capacity * 2
    pos = new Array[Int](capacity)
    strs = util.Arrays.copyOf(strs, capacity)
    for (idx <- Range(0, oldsize)) insertRehash(strs(idx))
  }

  def strengthenHash(hash0: Int): Int = {
    // using the simple murmur 32 bit mixing to strengthen the hash
    var hash = hash0 ^ (hash0 >>> 16)
    hash *= 0x85ebca6b
    hash ^= hash >>> 13
    hash
    // murmur does a bit more, but we don't need that.
    // hash *= 0xc2b2ae35
    // hash ^= hash >>> 16
    // hash & (capacity - 1)
  }

}
