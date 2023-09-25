package io.joern.odb2

object TestHelpers {
  def createTestNode(nodeKind: Int = 0, seqId: Int = 0): GNode =
    GNode(null, 0, 0)
  
  val DummyTestNode = createTestNode()
}
