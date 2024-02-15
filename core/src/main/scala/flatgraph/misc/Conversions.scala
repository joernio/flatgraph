package flatgraph.misc

object Conversions {
  extension (i: Int) {
    def toShortSafely: Short = {
      assert(0 <= i && i <= Short.MaxValue, throw new ConversionException(s"cannot safely downcast int with value=$i to short"))
      i.toShort
    }
  }
}

class ConversionException(msg: String) extends RuntimeException(msg)
