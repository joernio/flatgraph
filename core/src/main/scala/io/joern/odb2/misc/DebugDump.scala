package io.joern.odb2.misc

import io.joern.odb2.Edge.Direction.{Incoming, Outgoing}
import io.joern.odb2.{AccessHelpers, Accessors, GNode, Graph}

import scala.collection.mutable

object DebugDump {

  def printNode(n: GNode): String = printNode(n, null)

  def printNode(n: GNode, edgeproperty: Any): String = {
    val nodeLabel = n.graph.schema.getNodeLabel(n.nodeKind)
    if (!AccessHelpers.isDeleted(n)) {
      if (edgeproperty == null) s"${nodeLabel}_${n.seq}" else s"(${edgeproperty}) ${nodeLabel}_${n.seq}"
    } else {
      if (edgeproperty == null) s"<deleted ${nodeLabel}_${n.seq}>" else s"(${edgeproperty}) <deleted ${nodeLabel}_${n.seq} >"
    }
  }

  def debugDump(g: Graph): String = {
    val sb = new java.lang.StringBuilder(0)
    val numstr =
      g.nodesArray.map {
        _.size
      }.zipWithIndex.map { case (sz, nodeKind) => s"(${nodeKind}: ${sz})" }.mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${
      g.nodesArray.iterator.map {
        _.size
      }.sum
    }\n")
    for (nodeKind <- Range(0, g.schema.getNumberOfNodeKinds)) {
      sb.append(s"Node kind ${nodeKind}. (eid, nEdgesOut, nEdgesIn):")
      for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
        val posOut = g.schema.neighborOffsetArrayIndex(nodeKind, Outgoing, edgeKind)
        val neO = g.neighbors(posOut + 1) match {
          case null => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.neighborOffsetArrayIndex(nodeKind, Incoming, edgeKind)
        val neIn = g.neighbors(posIn + 1) match {
          case null => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s" (${edgeKind}, ${neO}, ${neIn}),")
      }
      sb.append("\n")

      for (n <- g.nodes(nodeKind)) {
        val properties = mutable.ArrayBuffer.empty[String]
        for (propertyKind <- Range(0, g.schema.getNumberOfProperties)) {
          val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
          val p = Accessors.getNodeProperty(n, propertyKind)
          if (p.nonEmpty)
            properties.append(
              s"$propertyLabel: [" + p
                .map {
                  case null => "null"
                  case n: GNode => printNode(n)
                  case other => other.toString
                }
                .mkString(", ") + "]"
            )
        }
        if (properties.nonEmpty) {
          sb.append(s"   ${printNode(n)}       : " + properties.mkString(", ") + "\n")
        }

        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesOut = Accessors.getEdgesOut(n, edgeKind)
          assert(Accessors.getNeighborsOut(n, edgeKind).sameElements(edgesOut.map {
            _.dst
          }))
          if (edgesOut.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeLabel}] -> " + edgesOut.map { e => printNode(e.dst, e.property) }.mkString(", ") + "\n")
          }
        }
        for (edgeKind <- Range(0, g.schema.getNumberOfEdgeKinds)) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesIn = Accessors.getEdgesIn(n, edgeKind)
          assert(Accessors.getNeighborsIn(n, edgeKind) == (edgesIn.map {
            _.src
          }))
          if (edgesIn.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeLabel}] <- " + edgesIn.map { e => printNode(e.src, e.property) }.mkString(", ") + "\n")
          }
        }
      }
    }
    sb.toString
  }

}
