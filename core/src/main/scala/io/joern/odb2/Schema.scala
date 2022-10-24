package io.joern.odb2

trait Schema {
  def getNumberOfNodeKinds: Int

  def getNumberOfEdgeKinds: Int

  def neighborOffsetArrayIndex(nodekind: Int, inout: Int, edgekind: Int): Int = {
    2 * (nodekind + getNumberOfNodeKinds * (inout + 2 * edgekind))
  }

  def makeNode(graph: Graph, kid: Short, seqId: Int): GNode

  //fixme: API will need to change when we add generated edge classes (relevant for edge properties)
  def makeEdge(src: GNode, dst: GNode, eid: Short, subSeq: Int): Edge
}
