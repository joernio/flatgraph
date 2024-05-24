package flatgraph.algorithm

import flatgraph.Edge.Direction
import flatgraph.GNode
import flatgraph.traversal.language.*

object PathFinder {
  def apply(nodeA: GNode, nodeB: GNode, maxDepth: Int = -1): Seq[Path] = {
    if (nodeA == nodeB) Seq(Path(Seq(nodeA)))
    else {
      Iterator
        .single(nodeA)
        .enablePathTracking
        .repeat(_.both) { initialBehaviour =>
          val behaviour = initialBehaviour.dedup // no cycles
            .until(_.is(nodeB)) // don't continue on a given path if we've reached our destination
          if (maxDepth > -1) behaviour.maxDepth(maxDepth)
          else behaviour
        }
        .is(nodeB) // we only care about the paths that lead to our destination
        .path
        .cast[Seq[GNode]]
        .map(Path.apply)
        .toSeq
    }
  }

  case class Path(nodes: Seq[GNode]) {
    def withEdges: PathWithEdges = {
      val elements = Seq.newBuilder[PathEntry]
      nodes.headOption.foreach { firstElement =>
        elements.addOne(NodeEntry(firstElement))
      }

      for {
        case Seq(nodeA, nodeB) <- nodes.sliding(2)
        edgesBetweenAsPathEntry: PathEntry =
          edgesBetween(nodeA, nodeB) match {
            case Nil =>
              throw new AssertionError(s"no edges between nodes $nodeA and $nodeB - this looks like a bug in PathFinder")
            case Seq(edgeEntry) => edgeEntry
            case multipleEdges  => EdgeEntries(multipleEdges)
          }
      } {
        elements.addOne(edgesBetweenAsPathEntry)
        elements.addOne(NodeEntry(nodeB))
      }

      PathWithEdges(elements.result())
    }
  }

  private def edgesBetween(nodeA: GNode, nodeB: GNode): Seq[EdgeEntry] = {
    val outEdges = nodeA.outE.filter(_.dst == nodeB).map(edge => EdgeEntry(Direction.Outgoing, edge.label))
    val inEdges  = nodeA.inE.filter(_.src == nodeB).map(edge => EdgeEntry(Direction.Incoming, edge.label))
    outEdges.to(Seq) ++ inEdges.to(Seq)
  }

  case class PathWithEdges(elements: Seq[PathEntry])
  sealed trait PathEntry
  case class NodeEntry(node: GNode) extends PathEntry {
    def label: String = node.label()
    def id: Long      = node.id()
  }
  case class EdgeEntries(edgeEntries: Seq[EdgeEntry])       extends PathEntry
  case class EdgeEntry(direction: Direction, label: String) extends PathEntry

}
