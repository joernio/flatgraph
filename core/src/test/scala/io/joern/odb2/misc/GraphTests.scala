package io.joern.odb2

import io.joern.odb2.TestSchema.testSerialization
import io.joern.odb2.misc.DebugDump
import io.joern.odb2.storage.{Deserialization, Serialization}
import io.joern.odb2.traversal.Language.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class GraphTests extends AnyWordSpec with Matchers {

  // General tip: If a test fails, add println(DebugDump.debugDump(g)) in front, in order to get untruncated "actual" for copy-paste
  "basically work for construction" in {
    val schema = TestSchema.make(1, 1)
    val g      = new Graph(schema)
    // empty graph
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 0), total 0
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]),
        |""".stripMargin
    // with some edges
    val diff0 = new DiffGraphBuilder
    val V0_0  = new GenericDNode(0)
    val V0_1  = new GenericDNode(0)
    val V0_2  = new GenericDNode(0)
    val V0_3  = new GenericDNode(0)
    diff0
      .addEdge(V0_0, V0_1, 0)
      .addEdge(V0_1, V0_2, 0)
      .addEdge(V0_2, V0_3, 0)
      .addEdge(V0_3, V0_0, 0)
      .addEdge(V0_1, V0_0, 0)
    DiffGraphApplier.applyDiff(g, diff0)
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 5 [dense], 5 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- V0_3, V0_1
        |   V0_1   [0] -> V0_2, V0_0
        |   V0_1   [0] <- V0_0
        |   V0_2   [0] -> V0_3
        |   V0_2   [0] <- V0_1
        |   V0_3   [0] -> V0_0
        |   V0_3   [0] <- V0_2
        |""".stripMargin
    g.neighbors(0).asInstanceOf[Array[Int]].length shouldBe 5

    // modify
    val diff2 = new DiffGraphBuilder
    diff2.addEdge(V0_2, V0_3, 0)
    DiffGraphApplier.applyDiff(g, diff2)
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- V0_3, V0_1
        |   V0_1   [0] -> V0_2, V0_0
        |   V0_1   [0] <- V0_0
        |   V0_2   [0] -> V0_3, V0_3
        |   V0_2   [0] <- V0_1
        |   V0_3   [0] -> V0_0
        |   V0_3   [0] <- V0_2, V0_2
        |""".stripMargin

    // add a node. Don't resize edges array
    val V0_4 = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_4))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 5), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- V0_3, V0_1
        |   V0_1   [0] -> V0_2, V0_0
        |   V0_1   [0] <- V0_0
        |   V0_2   [0] -> V0_3, V0_3
        |   V0_2   [0] <- V0_1
        |   V0_3   [0] -> V0_0
        |   V0_3   [0] <- V0_2, V0_2
        |""".stripMargin
    g.neighbors(0).asInstanceOf[Array[Int]].length shouldBe 5

    // add an interior edge. Check that adding edges in the middle and at the end of undersized edge arrays works
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addEdge(V0_1, V0_4, 0))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 5), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 7 [dense], 7 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- V0_3, V0_1
        |   V0_1   [0] -> V0_2, V0_0, V0_4
        |   V0_1   [0] <- V0_0
        |   V0_2   [0] -> V0_3, V0_3
        |   V0_2   [0] <- V0_1
        |   V0_3   [0] -> V0_0
        |   V0_3   [0] <- V0_2, V0_2
        |   V0_4   [0] <- V0_1
        |""".stripMargin
    g.neighbors(0).asInstanceOf[Array[Int]].length shouldBe 6

    testSerialization(g)
  }

  "basically work with multiple edge and node types" in {
    val schema = TestSchema.make(3, 2)
    val g      = new Graph(schema)
    // empty graph
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 0), (1: 0), (2: 0), total 0
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]),
        |Node kind 1. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]),
        |Node kind 2. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]),
        |""".stripMargin

    val V0_0 = new GenericDNode(0)
    val V0_1 = new GenericDNode(0)
    val V1_0 = new GenericDNode(1)
    val V1_1 = new GenericDNode(1)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V1_0)
        .addNode(V1_1)
        .addEdge(V0_0, V0_0, 0)
        .addEdge(V0_1, V1_0, 0)
        .addEdge(V1_1, V0_0, 1)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), (1: 2), (2: 0), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 1 [dense]), (1, 0 [NA], 1 [dense]),
        |   V0_0   [0] -> V0_0
        |   V0_0   [0] <- V0_0
        |   V0_0   [1] <- V1_1
        |   V0_1   [0] -> V1_0
        |Node kind 1. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 1 [dense]), (1, 1 [dense], 0 [NA]),
        |   V1_0   [0] <- V0_1
        |   V1_1   [1] -> V0_0
        |Node kind 2. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]),
        |""".stripMargin

    // test a simple out and in traversal from V0_0
    val V0_0_GNode = g.nodes(0).next()
    Accessors.getNeighborsOut(V0_0_GNode).size shouldBe 1
    Accessors.getNeighborsIn(V0_0_GNode).size shouldBe 2
    Iterator.single(V0_0_GNode).out.size shouldBe 1
    Iterator.single(V0_0_GNode).in.size shouldBe 2
  }

  val schema = TestSchema.make(1, 1)

  def mkGraph(): Graph = {
    val g    = new Graph(schema)
    val V0_0 = new GenericDNode(0)
    val V0_1 = new GenericDNode(0)
    val V0_2 = new GenericDNode(0)
    val V0_3 = new GenericDNode(0)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V0_2)
        .addNode(V0_3)
        .addEdge(V0_0, V0_2, 0)
        .addEdge(V0_0, V0_1, 0)
        .addEdge(V0_3, V0_1, 0)
        .addEdge(V0_0, V0_3, 0)
        .addEdge(V0_0, V0_2, 0)
        .addEdge(V0_3, V0_2, 0)
        .addEdge(V0_0, V0_1, 0)
    )
    g
  }

  "Support unsafe half-edges to violate invariants" in {
    val g    = new Graph(schema)
    val V0_0 = new GenericDNode(0)
    val V0_1 = new GenericDNode(0)
    val V0_2 = new GenericDNode(0)
    val V0_3 = new GenericDNode(0)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V0_2)
        .addNode(V0_3)
        .unsafeAddHalfEdgeForward(V0_0, V0_1, 0)
        .unsafeAddHalfEdgeForward(V0_0, V0_2, 0)
        .unsafeAddHalfEdgeForward(V0_3, V0_2, 0)
        .unsafeAddHalfEdgeForward(V0_3, V0_1, 0)
        .unsafeAddHalfEdgeBackward(V0_3, V0_1, 0)
        .unsafeAddHalfEdgeBackward(V0_0, V0_1, 0)
        .unsafeAddHalfEdgeBackward(V0_0, V0_2, 0)
        .unsafeAddHalfEdgeBackward(V0_3, V0_2, 0)
    )

    def makePermGraph(perm: Iterable[Int]): Graph = {
      val g    = new Graph(schema)
      val V0_0 = new GenericDNode(0)
      val V0_1 = new GenericDNode(0)
      val V0_2 = new GenericDNode(0)
      val V0_3 = new GenericDNode(0)
      val diff = (new DiffGraphBuilder)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V0_2)
        .addNode(V0_3)

      for (i <- perm) i match {
        case 0 => diff.addEdge(V0_0, V0_1, 0)
        case 1 => diff.addEdge(V0_0, V0_2, 0)
        case 2 => diff.addEdge(V0_3, V0_2, 0)
        case 3 => diff.addEdge(V0_3, V0_1, 0)
      }
      DiffGraphApplier.applyDiff(g, diff)
      g
    }

    def signature(g: Graph): String = {
//      def sig(nodes: IndexedSeq[GNode]): String = if (nodes(0).seq < nodes(1).seq) "+" else "-"
      def sig(nodes: Iterator[GNode]): String = if (nodes.next().seq < nodes.next().seq) "+" else "-"

      sig(Accessors.getNeighborsOut(g.nodesArray(0)(0), 0)) + sig(Accessors.getNeighborsIn(g.nodesArray(0)(1), 0)) + sig(
        Accessors.getNeighborsIn(g.nodesArray(0)(2), 0)
      ) + sig(Accessors.getNeighborsOut(g.nodesArray(0)(3), 0))
    }

    val badGraphDump =
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 4 [dense], 4 [dense]),
        |   V0_0   [0] -> V0_1, V0_2
        |   V0_1   [0] <- V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_3
        |   V0_3   [0] -> V0_2, V0_1
        |""".stripMargin
    DebugDump.debugDump(g) shouldBe badGraphDump
    signature(g) shouldBe "+-+-"
    val perms = Array(
      List(0, 1, 2, 3),
      List(0, 1, 3, 2),
      List(0, 2, 1, 3),
      List(0, 2, 3, 1),
      List(0, 3, 1, 2),
      List(0, 3, 2, 1),
      List(1, 0, 2, 3),
      List(1, 0, 3, 2),
      List(1, 2, 0, 3),
      List(1, 2, 3, 0),
      List(1, 3, 0, 2),
      List(1, 3, 2, 0),
      List(2, 0, 1, 3),
      List(2, 0, 3, 1),
      List(2, 1, 0, 3),
      List(2, 1, 3, 0),
      List(2, 3, 0, 1),
      List(2, 3, 1, 0),
      List(3, 0, 1, 2),
      List(3, 0, 2, 1),
      List(3, 1, 0, 2),
      List(3, 1, 2, 0),
      List(3, 2, 0, 1),
      List(3, 2, 1, 0)
    )
    val siglist = perms.map { p => signature(makePermGraph(p)) }.iterator.distinct.toList.sorted
    siglist.length shouldBe 14
    siglist should not contain "+-+-"
    siglist should not contain "-+-+"
    /*We see that only 14 out of the 16 possible edge-orderings can be achieved without unsafe half-edges.
    The constructed one in the beginning is one  of the impossible ones.*/

  }

  "permit an edge deletions" in {
    // empty
    var g = mkGraph()
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 7 [dense], 7 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3, V0_2, V0_1
        |   V0_1   [0] <- V0_0, V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin

    // remove first V0_0->V0_1
    val expectation =
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> V0_2, V0_3, V0_2, V0_1
        |   V0_1   [0] <- V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesOut(g.nodesArray(0)(0), 0).toList(1))
    )
    DebugDump.debugDump(g) shouldBe expectation

    // remove first V0_1<-V0_0, i.e. same edge from the other side
    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesIn(g.nodesArray(0)(1), 0).toList(0))
    )
    DebugDump.debugDump(g) shouldBe expectation

    // remove the edge twice
    // remove first V0_1<-V0_0, i.e. same edge from the other side
    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesIn(g.nodesArray(0)(1), 0).toList(0))
        .removeEdge(Accessors.getEdgesOut(g.nodesArray(0)(0), 0).toList(1))
    )
    DebugDump.debugDump(g) shouldBe expectation
    testSerialization(g)
  }

  "permit a different edge deletion" in {
    var g = mkGraph()
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 7 [dense], 7 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3, V0_2, V0_1
        |   V0_1   [0] <- V0_0, V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin
    // we remove the second edge 0->1
    val expectation =
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3, V0_2
        |   V0_1   [0] <- V0_0, V0_3
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesOut(g.nodesArray(0)(0), 0).toList(4))
    )
    DebugDump.debugDump(g) shouldBe expectation

    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesIn(g.nodesArray(0)(1), 0).toList(2))
    )
    DebugDump.debugDump(g) shouldBe expectation
  }

  "permit multiple edge deletion" in {
    var g = mkGraph()
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 7 [dense], 7 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3, V0_2, V0_1
        |   V0_1   [0] <- V0_0, V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin
    // we remove the second edge 0->1 and the second edge 2<-0
    val expectation =
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 5 [dense], 5 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3
        |   V0_1   [0] <- V0_0, V0_3
        |   V0_2   [0] <- V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesOut(g.nodesArray(0)(0), 0).toList(4))
        .removeEdge(Accessors.getEdgesIn(g.nodesArray(0)(2), 0).toList(1))
    )
    DebugDump.debugDump(g) shouldBe expectation
  }

  "permit node deletion" in {
    var g = mkGraph()
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 7 [dense], 7 [dense]),
        |   V0_0   [0] -> V0_2, V0_1, V0_3, V0_2, V0_1
        |   V0_1   [0] <- V0_0, V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeNode((g.nodesArray(0)(0)))
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_1   [0] <- V0_3
        |   V0_2   [0] <- V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |""".stripMargin

    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeNode((g.nodesArray(0)(1)))
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 4 [dense], 4 [dense]),
        |   V0_0   [0] -> V0_2, V0_3, V0_2
        |   V0_2   [0] <- V0_0, V0_0, V0_3
        |   V0_3   [0] -> V0_2
        |   V0_3   [0] <- V0_0
        |""".stripMargin

    testSerialization(g)

    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeNode((g.nodesArray(0)(2)))
        .removeNode((g.nodesArray(0)(3)))
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> V0_1, V0_1
        |   V0_1   [0] <- V0_0, V0_0
        |""".stripMargin

    testSerialization(g)
  }

  "support edge properties" in {
    val schema = TestSchema.make(1, 1, edgePropertyPrototypes = Array(new Array[String](0)))
    val g      = new Graph(schema)
    val V0_0   = new GenericDNode(0)
    val V0_1   = new GenericDNode(0)
    val V0_2   = new GenericDNode(0)
    val V0_3   = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_0).addNode(V0_1).addNode(V0_2).addNode(V0_3))
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addEdge(V0_0, V0_1, 0))
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .addEdge(V0_0, V0_1, 0, "A")
        .addEdge(V0_1, V0_2, 0, "B")
        .addEdge(V0_2, V0_3, 0, "C")
        .addEdge(V0_3, V0_0, 0, "D")
        .addEdge(V0_1, V0_0, 0, "E")
    )

    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> V0_1, (A) V0_1
        |   V0_0   [0] <- (D) V0_3, (E) V0_1
        |   V0_1   [0] -> (B) V0_2, (E) V0_0
        |   V0_1   [0] <- V0_0, (A) V0_0
        |   V0_2   [0] -> (C) V0_3
        |   V0_2   [0] <- (B) V0_1
        |   V0_3   [0] -> (D) V0_0
        |   V0_3   [0] <- (C) V0_2
        |""".stripMargin

    testSerialization(g)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setEdgeProperty(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(0), "X")
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> (X) V0_1, (A) V0_1
        |   V0_0   [0] <- (D) V0_3, (E) V0_1
        |   V0_1   [0] -> (B) V0_2, (E) V0_0
        |   V0_1   [0] <- (X) V0_0, (A) V0_0
        |   V0_2   [0] -> (C) V0_3
        |   V0_2   [0] <- (B) V0_1
        |   V0_3   [0] -> (D) V0_0
        |   V0_3   [0] <- (C) V0_2
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setEdgeProperty(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(1), DefaultValue)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 6 [dense], 6 [dense]),
        |   V0_0   [0] -> (X) V0_1, V0_1
        |   V0_0   [0] <- (D) V0_3, (E) V0_1
        |   V0_1   [0] -> (B) V0_2, (E) V0_0
        |   V0_1   [0] <- (X) V0_0, V0_0
        |   V0_2   [0] -> (C) V0_3
        |   V0_2   [0] <- (B) V0_1
        |   V0_3   [0] -> (D) V0_0
        |   V0_3   [0] <- (C) V0_2
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeEdge(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(0))
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 5 [dense], 5 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- (D) V0_3, (E) V0_1
        |   V0_1   [0] -> (B) V0_2, (E) V0_0
        |   V0_1   [0] <- V0_0
        |   V0_2   [0] -> (C) V0_3
        |   V0_2   [0] <- (B) V0_1
        |   V0_3   [0] -> (D) V0_0
        |   V0_3   [0] <- (C) V0_2
        |""".stripMargin
    testSerialization(g)

    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeNode(V0_2.storedRef.get)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 3 [dense], 3 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- (D) V0_3, (E) V0_1
        |   V0_1   [0] -> (E) V0_0
        |   V0_1   [0] <- V0_0
        |   V0_3   [0] -> (D) V0_0
        |""".stripMargin
    testSerialization(g)
  }

  "support edge properties with primitives and default values" in {
    val schema = TestSchema.make(1, 1, edgePropertyPrototypes = Array(Array(-1.toShort)))
    val V0_0   = new GenericDNode(0)
    val V0_1   = new GenericDNode(0)
    val g      = new Graph(schema)

    g.neighbors(2).asInstanceOf[DefaultValue].default.getClass.getName shouldBe "java.lang.Short"
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_0).addNode(V0_1).addEdge(V0_0, V0_1, 0).addEdge(V0_0, V0_1, 0))
    g.neighbors(2).asInstanceOf[DefaultValue].default.getClass.getName shouldBe "java.lang.Short"
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> (-1) V0_1, (-1) V0_1
        |   V0_1   [0] <- (-1) V0_0, (-1) V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).setEdgeProperty(Accessors.getEdgesOut(V0_0.storedRef.get, 0)(0), 5.toShort))
    g.neighbors(2).getClass.getName shouldBe "[S"
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> (5) V0_1, (-1) V0_1
        |   V0_1   [0] <- (5) V0_0, (-1) V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addEdge(V0_1.storedRef.get, V0_1, 0, 2.toShort))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 3 [dense], 3 [dense]),
        |   V0_0   [0] -> (5) V0_1, (-1) V0_1
        |   V0_1   [0] -> (2) V0_1
        |   V0_1   [0] <- (5) V0_0, (-1) V0_0, (2) V0_1
        |""".stripMargin

    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).setEdgeProperty(Accessors.getEdgesOut(V0_0.storedRef.get, 0)(0), DefaultValue))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 3 [dense], 3 [dense]),
        |   V0_0   [0] -> (-1) V0_1, (-1) V0_1
        |   V0_1   [0] -> (2) V0_1
        |   V0_1   [0] <- (-1) V0_0, (-1) V0_0, (2) V0_1
        |""".stripMargin
    testSerialization(g)
  }

  "support node properties" in {
    val schema = TestSchema.make(2, 0, 2, nodePropertyPrototypes = Array(new Array[Short](0), new Array[GNode](0)))
    val g      = new Graph(schema)

    val V0_0 = new GenericDNode(0)
    val V0_1 = new GenericDNode(0)
    val V0_2 = new GenericDNode(0)
    val V1_0 = new GenericDNode(1)
    val V1_1 = new GenericDNode(1)
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_0).addNode(V0_1).addNode(V1_0).addNode(V1_1))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), (1: 2), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |""".stripMargin
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setNodeProperty(V0_0.storedRef.get, 1, V0_2 :: V0_0 :: Nil)
        .setNodeProperty(V1_1.storedRef.get, 0, 0.toShort :: 1.toShort :: Nil)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [V0_2, V0_0]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_1       : 0: [0, 1]
        |""".stripMargin
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setNodeProperty(V0_2.storedRef.get, 1, V0_2)
        .setNodeProperty(V1_0.storedRef.get, 0, 0.toShort)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [V0_2, V0_0]
        |   V0_2       : 1: [V0_2]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_0       : 0: [0]
        |   V1_1       : 0: [0, 1]
        |""".stripMargin
    testSerialization(g)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .removeNode(V0_2.storedRef.get)
        .setNodeProperty(V1_0.storedRef.get, 0, null)
        .setNodeProperty(V0_1.storedRef.get, 1, null :: Nil)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [<deleted V0_2>, V0_0]
        |   V0_1       : 1: [null]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_1       : 0: [0, 1]
        |""".stripMargin
    testSerialization(g)
  }

  "Support custom domain classes for detached nodes" in {
    class CustomNode extends DNode {
      private var _storedRef: GNode = null
      var nodes: List[DNodeOrNode]  = Nil
      var strings: List[String]     = Nil
      override def nodeKind: Short  = 0.toShort

      override def storedRef: Option[GNode] = Option(_storedRef)

      override def storedRef_=(ref: Option[GNode]): Unit = ref match {
        case Some(gnode) => _storedRef = gnode
        case None        => _storedRef = null
      }

      override def flattenProperties(interface: BatchedUpdateInterface): Unit = {
        interface.insertProperty(this, 0, nodes)
        interface.insertProperty(this, 1, strings)
      }
    }

    val V0_0 = new CustomNode
    val V0_1 = new CustomNode
    val V0_2 = new CustomNode
    V0_0.nodes = V0_1 :: Nil
    V0_1.nodes = V0_1 :: V0_2 :: Nil
    V0_2.strings = "b" :: Nil
    V0_1.strings = "c" :: Nil
    val schema = TestSchema.make(2, 0, 2, nodePropertyPrototypes = Array(new Array[GNode](0), new Array[String](0)))
    val g      = new Graph(schema)
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_0))
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 0), total 3
      |Node kind 0. (eid, nEdgesOut, nEdgesIn):
      |   V0_0       : 0: [V0_1]
      |   V0_1       : 0: [V0_1, V0_2], 1: [c]
      |   V0_2       : 1: [b]
      |Node kind 1. (eid, nEdgesOut, nEdgesIn):
      |""".stripMargin
    testSerialization(g)
  }

  "support indexed lookups" in {
    val schema = TestSchema.make(1, 0, 1, nodePropertyPrototypes = Array(new Array[String](0)))
    val g      = new Graph(schema)
    val v0     = new GenericDNode(0)
    val v1     = new GenericDNode(0)
    val v2     = new GenericDNode(0)
    val v3     = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(v0).addNode(v1).addNode(v2).addNode(v3))
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setNodeProperty(v0.storedRef.get, 0, "p0")
        .setNodeProperty(v1.storedRef.get, 0, "p1")
        .setNodeProperty(v3.storedRef.get, 0, "p1" :: "p3" :: Nil)
    )
    DebugDump.debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 0: [p0]
        |   V0_1       : 0: [p1]
        |   V0_3       : 0: [p1, p3]
        |""".stripMargin
    g.inverseIndices.get(0) shouldBe null
    Accessors.getWithInverseIndex(g, 0, 0, "p0").toList shouldBe List(v0.storedRef.get)
    Accessors.getWithInverseIndex(g, 0, 0, "p1").toList shouldBe List(v1.storedRef.get, v3.storedRef.get)
    Accessors.getWithInverseIndex(g, 0, 0, "p2").toList shouldBe Nil
    Accessors.getWithInverseIndex(g, 0, 0, "p3").toList shouldBe List(v3.storedRef.get)
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setNodeProperty(v0.storedRef.get, 0, "p0")
        .setNodeProperty(v1.storedRef.get, 0, "p1")
        .setNodeProperty(v3.storedRef.get, 0, "p1" :: "p3" :: Nil)
    )
    g.inverseIndices.get(0) shouldBe null
    DiffGraphApplier.applyDiff(
      g,
      (new DiffGraphBuilder)
        .setNodeProperty(v2.storedRef.get, 0, "p2")
    )
    g.inverseIndices.get(0) shouldBe null

    // println(DebugDump.debugDump(g))

  }
}

object TestSchema {
  def make(
    nKinds: Int,
    nEdgeKinds: Int,
    nProperties: Int = 0,
    edgePropertyPrototypes: Array[AnyRef] = null,
    nodePropertyPrototypes: Array[AnyRef] = null
  ): Schema = {
    new FreeSchema(
      nodeLabels = Range(0, nKinds).map { id => s"V${id}" }.toArray,
      edgeLabels = Range(0, nEdgeKinds).map { id => s"${id}" }.toArray,
      propertyLabels = Range(0, nProperties).map { id => s"${id}" }.toArray,
      edgePropertyPrototypes = if (edgePropertyPrototypes != null) edgePropertyPrototypes else new Array[AnyRef](nEdgeKinds),
      nodePropertyPrototypes = if (nodePropertyPrototypes != null) nodePropertyPrototypes else new Array[AnyRef](nProperties)
    )
  }

  def testSerialization(g: Graph): Unit = {
    val orig = DebugDump.debugDump(g)
    val fn   = "/tmp/foo.fg"
    Serialization.writeGraph(g, fn)
    val deserialized = Deserialization.readGraph(fn, g.schema)
    val newdump      = DebugDump.debugDump(deserialized)
    //    if (newdump != orig) {
    //      1 + 1 // for easier breakpoints
    //    }
    orig shouldBe newdump
  }

}
