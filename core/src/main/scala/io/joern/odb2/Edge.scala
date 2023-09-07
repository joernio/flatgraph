package io.joern.odb2

class Edge(val src: GNode, val dst: GNode, val edgeKind: Short, val subSeq: Int, val property: Any)

object Edge {

  enum Direction(val encoding: Byte) {
    case Incoming extends Direction(0)
    case Outgoing extends Direction(1)
  }

  object Direction {
    def verifyEncodingRange(inoutEncoding: Byte): Unit = {
      if (!(inoutEncoding == 0 || inoutEncoding == 1)) {
        throw new IllegalArgumentException(s"illegal encoding for direction: `$inoutEncoding`; possible values are 0 (incoming) and 1 (outgoing)")
      }
    }
  }

}
