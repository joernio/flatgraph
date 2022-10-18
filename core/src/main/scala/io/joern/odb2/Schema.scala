package io.joern.odb2

trait Schema {
  def getNNodeKinds: Int
  def getNEdgeKinds: Int
  def makeNode(g: Graph, kid: Short, seqId: Int): GNode

  //fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, eid: Short, subSeq: Int): Edge
}
