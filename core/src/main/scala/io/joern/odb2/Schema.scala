package io.joern.odb2

trait Schema {
  def getNNodeKinds: Int
  def getNEdgeKinds: Int

  def indexEdge(kid: Short, inOut: Int, eid: Short): Int =
    indexEdge(kid.toInt, inOut, eid.toInt)

  def indexEdge(kid: Int, inOut: Int, eid: Int): Int = 2 * (kid + getNNodeKinds * (inOut + 2 * eid))

  def makeNode(g: Graph, kid: Short, seqId: Int): GNode

  //fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, eid: Short, subSeq: Int): Edge
}
