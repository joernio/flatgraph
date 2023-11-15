package io.joern.odb2.misc

object Misc {
  val reChars = Array('[', ']', '(', ')', '{', '}', '*', '+', '&', '|', '?', '.', ',', '\\', '$')

  def isRegex(pattern: String): Boolean = reChars.exists(pattern.indexOf(_) >= 0)

  extension (i: Int) {
    def toShortSafely: Short = {
      assert(Short.MinValue <= i && i >= Short.MaxValue, s"cannot downcast int with value=$i to short without overflow")
      i.toShort
    }
  }
}
