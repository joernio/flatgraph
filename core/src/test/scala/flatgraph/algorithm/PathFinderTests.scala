package flatgraph.algorithm

import flatgraph.traversal.testdomains.simple.ExampleGraphSetup
import PathFinder.*
import flatgraph.Edge.Direction
import flatgraph.traversal.testdomains.simple.SimpleDomain.Connection
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers.*

class PathFinderTests extends AnyWordSpec with ExampleGraphSetup {
  /* sample graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  "identity" in {
    val path = PathFinder(center, center)
    path shouldBe Seq(Path(Seq(center)))

    path.head.withEdges shouldBe PathWithEdges(Seq(NodeEntry(center)))
  }

  "direct neighbors" in {
    val path = PathFinder(center, r1)
    path shouldBe Seq(Path(Seq(center, r1)))

    path.head.withEdges shouldBe PathWithEdges(Seq(NodeEntry(center), EdgeEntry(Direction.Outgoing, Connection.Label), NodeEntry(r1)))
  }

  "longer path" in {
    val path = PathFinder(l1, r1)
    path shouldBe Seq(Path(Seq(l1, center, r1)))

    path.head.withEdges shouldBe PathWithEdges(
      Seq(
        NodeEntry(l1),
        EdgeEntry(Direction.Incoming, Connection.Label),
        NodeEntry(center),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r1)
      )
    )
  }

  "longest path" in {
    val path = PathFinder(l3, r5)
    path shouldBe Seq(Path(Seq(l3, l2, l1, center, r1, r2, r3, r4, r5)))

    path.head.withEdges shouldBe PathWithEdges(
      Seq(
        NodeEntry(l3),
        EdgeEntry(Direction.Incoming, Connection.Label),
        NodeEntry(l2),
        EdgeEntry(Direction.Incoming, Connection.Label),
        NodeEntry(l1),
        EdgeEntry(Direction.Incoming, Connection.Label),
        NodeEntry(center),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r1),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r2),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r3),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r4),
        EdgeEntry(Direction.Outgoing, Connection.Label),
        NodeEntry(r5)
      )
    )
  }

  "max depth" in {
    PathFinder(center, r3, maxDepth = 3) shouldBe Seq(Path(Vector(center, r1, r2, r3)))

    PathFinder(center, r3, maxDepth = 2) shouldBe Nil
  }

}
