package flatgraph

class Edge(val src: GNode, val dst: GNode, val edgeKind: Short, val subSeq: Int, val property: Any) {
  def label: String =
    src.graph.schema.getEdgeLabel(src.nodeKind, edgeKind)

  def propertyName: Option[String] = None // override in subclass to provide a property name

  def propertyMaybe: Option[Any] = Option(property)
}

object Edge {

  /** Direction is encoded with a Byte value (0 for Incoming, 1 for Outgoing), because 1) it's used in some classes that are have many
    * instances (byte consumes less memory than an enum reference) 2) it's used for logic-level calculations in some areas of the codebase
    */
  enum Direction(val encoding: Byte) {
    case Incoming extends Direction(0)
    case Outgoing extends Direction(1)
  }

  object Direction {
    def verifyEncodingRange(inoutEncoding: Byte): Unit = {
      if (!(inoutEncoding == 0 || inoutEncoding == 1)) {
        throw new IllegalArgumentException(
          s"illegal encoding for direction: `$inoutEncoding`; possible values are 0 (incoming) and 1 (outgoing)"
        )
      }
    }
  }

}
