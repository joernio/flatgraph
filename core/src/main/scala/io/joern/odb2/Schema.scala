package io.joern.odb2

trait Schema {
  def getNNodeKinds: Int
  def getNEdgeKinds: Int
  def makeNode(g: Graph, kid: Short, seqId: Int): GNode
}
