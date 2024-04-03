package flatgraph.misc

object Conversions {
  extension (i: Int) {
    def toShortSafely: Short = {
      val shortValue = i.toShort
      if (shortValue.toInt == i)
        shortValue
      else
        throw new ConversionException(s"cannot safely downcast int with value=$i to short")
    }
  }
}

class ConversionException(msg: String) extends RuntimeException(msg)
