package flatgraph

sealed trait PropertyKey[ValueType, CompleteType] {
  def kind: Int
  def name: String
}

case class SinglePropertyKey[ValueType](kind: Int, name: String, default: ValueType) extends PropertyKey[ValueType, ValueType]

case class OptionalPropertyKey[ValueType](kind: Int, name: String) extends PropertyKey[ValueType, Option[ValueType]]

case class MultiPropertyKey[ValueType](kind: Int, name: String) extends PropertyKey[ValueType, IndexedSeq[ValueType]]
