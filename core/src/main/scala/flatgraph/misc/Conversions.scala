package flatgraph.misc

object Conversions {
  extension (i: Int) {
    def toShortSafely: Short = {
      assert(Short.MinValue <= i && i <= Short.MaxValue, throw new ConversionException(s"cannot safely downcast int with value=$i to short"))
      i.toShort
    }
  }
}

class ConversionException(msg: String) extends RuntimeException(msg)
