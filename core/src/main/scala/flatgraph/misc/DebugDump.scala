package flatgraph.misc

import flatgraph.Edge.Direction.{Incoming, Outgoing}
import flatgraph.{AccessHelpers, Accessors, GNode, Graph}

import scala.annotation.unchecked.uncheckedVariance
import scala.collection.mutable

object DebugDump {

  private def unpack(s: Any): Option[Object] = {
    s match {
      case iter: IterableOnce[AnyRef @uncheckedVariance] =>
        val res = iter.iterator.toSeq
        if (res.isEmpty) None
        else if (res.size == 1) Some(res.head)
        else Some(res)
      case obj: java.lang.Object => Some(obj)
      case _                     => null
    }
  }
  def debugChildrenScala(n: GNode): Array[Object] = {
    import java.util.Map.Entry
    val res = mutable.ArrayBuffer[(String, Object)]()
    res.addOne(("label", n.label()))
    res.addOne("kind", java.lang.Integer.valueOf(n.nodeKind.toInt))
    res.addOne("seq", java.lang.Integer.valueOf(n.seq()))
    res.addOne("id", java.lang.Long.valueOf(n.id()))

    for (pid <- n.graph.schema.propertyKinds) {
      val propertyname = n.graph.schema.getPropertyLabel(n.nodeKind, pid)
      unpack(Accessors.getNodeProperty(n, pid)).foreach { obj => res.addOne((propertyname, obj)) }
    }

    for (eid <- n.graph.schema.edgeKinds) {
      val edgename = n.graph.schema.getEdgeLabel(n.nodeKind, eid)
      unpack(Accessors.getNeighborsOut(n, eid)).foreach { obj => res.addOne((edgename + "_out", obj)) }
      unpack(Accessors.getNeighborsIn(n, eid)).foreach { obj => res.addOne((edgename + "_in", obj)) }
    }
    res.map { t => new java.util.AbstractMap.SimpleEntry[String, Object](t._1, t._2) }.toArray
  }

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
      g.nodesArray
        .map {
          _.size
        }
        .zipWithIndex
        .map { case (sz, nodeKind) => s"(${nodeKind}: ${sz})" }
        .mkString(", ")
    sb.append(s"#Node numbers (kindId, nnodes) ${numstr}, total ${g.nodesArray.iterator.map {
        _.size
      }.sum}\n")
    for (nodeKind <- g.schema.nodeKinds) {
      sb.append(s"Node kind ${nodeKind}. (eid, nEdgesOut, nEdgesIn):")
      for (edgeKind <- g.schema.edgeKinds) {
        val posOut = g.schema.neighborOffsetArrayIndex(nodeKind, Outgoing, edgeKind)
        val neO = g.neighbors(posOut + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        val posIn = g.schema.neighborOffsetArrayIndex(nodeKind, Incoming, edgeKind)
        val neIn = g.neighbors(posIn + 1) match {
          case null        => "0 [NA]"
          case a: Array[_] => s"${a.length} [dense]"
        }
        sb.append(s" (${edgeKind}, ${neO}, ${neIn}),")
      }
      sb.append("\n")

      for (n <- g._nodes(nodeKind)) {
        val properties = mutable.ArrayBuffer.empty[String]
        for (propertyKind <- g.schema.propertyKinds) {
          val propertyLabel = g.schema.getPropertyLabel(nodeKind, propertyKind)
          val p             = Accessors.getNodeProperty(n, propertyKind)
          if (p.nonEmpty)
            properties.append(
              s"$propertyLabel: [" + p
                .map {
                  case null     => "null"
                  case n: GNode => printNode(n)
                  case other    => other.toString
                }
                .mkString(", ") + "]"
            )
        }
        if (properties.nonEmpty) {
          sb.append(s"   ${printNode(n)}       : " + properties.mkString(", ") + "\n")
        }

        for (edgeKind <- g.schema.edgeKinds) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesOut  = Accessors.getEdgesOut(n, edgeKind)
          assert(
            Accessors
              .getNeighborsOut(n, edgeKind)
              .sameElements(edgesOut.map {
                _.dst
              })
          )
          if (edgesOut.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [${edgeLabel}] -> " + edgesOut.map { e => printNode(e.dst, e.property) }.mkString(", ") + "\n")
          }
        }
        for (edgeKind <- g.schema.edgeKinds) {
          val edgeLabel = g.schema.getEdgeLabel(nodeKind, edgeKind)
          val edgesIn   = Accessors.getEdgesIn(n, edgeKind)
          assert(Accessors.getNeighborsIn(n, edgeKind).to(Seq) == edgesIn.map(_.src).to(Seq))
          if (edgesIn.nonEmpty) {
            sb.append(s"   ${printNode(n)}   [$edgeLabel] <- " + edgesIn.map { e => printNode(e.src, e.property) }.mkString(", ") + "\n")
          }
        }
      }
    }
    sb.toString
  }

}
