package flatgraph

import flatgraph.TestHelpers.withTemporaryFile
import flatgraph.TestSchema.testSerialization
import flatgraph.misc.DebugDump.debugDump
import flatgraph.storage.Deserialization
import flatgraph.storage.Deserialization.DeserializationException
import flatgraph.traversal.language.*
import flatgraph.util.DiffToolTests
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.Files

class GraphTests extends AnyWordSpec with Matchers {

  // General tip: If a test fails, add println(debugDump.debugDump(g)) in front, in order to get untruncated "actual" for copy-paste
  "basically work for construction" in {
    val schema = TestSchema.make(1, 1)
    val g      = new Graph(schema)
    // empty graph
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 0), total 0
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]),
        |""".stripMargin
    // with some edges
    val diff0 = new DiffGraphBuilder(schema)
    val V0_0  = new GenericDNode(0)
    val V0_1  = new GenericDNode(0)
    val V0_2  = new GenericDNode(0)
    val V0_3  = new GenericDNode(0)
    diff0
      ._addEdge(V0_0, V0_1, 0)
      ._addEdge(V0_1, V0_2, 0)
      ._addEdge(V0_2, V0_3, 0)
      ._addEdge(V0_3, V0_0, 0)
      ._addEdge(V0_1, V0_0, 0)
    DiffGraphApplier.applyDiff(g, diff0)
    debugDump(g) shouldBe
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
    val diff2 = new DiffGraphBuilder(schema)
    diff2._addEdge(V0_2, V0_3, 0)
    DiffGraphApplier.applyDiff(g, diff2)
    debugDump(g) shouldBe
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
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(V0_4))
    debugDump(g) shouldBe
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
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema)._addEdge(V0_1, V0_4, 0))
    debugDump(g) shouldBe
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

  "some basic lookups" in {
    val schema = TestSchema.make(2, 1)
    val g      = new Graph(schema)
    val V0_0   = new GenericDNode(0)
    val V0_1   = new GenericDNode(0)
    val V1_0   = new GenericDNode(1)
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._addEdge(V0_0, V0_0, 0)
        ._addEdge(V0_1, V1_0, 0)
    )

    g.nodes().label.toSet shouldBe Set("V0", "V1")
    g.allNodes.size shouldBe 3
    g.nodes().size shouldBe 3
    g.nodes("V0").size shouldBe 2
    g.nodes("V1").size shouldBe 1
    g.nodes("V0", "V1").size shouldBe 3
    g.nodes("V0", "V1", "V2").size shouldBe 3
    g.nodes("V2").size shouldBe 0
  }

  "basically work with multiple edge and node types" in {
    val schema = TestSchema.make(3, 2)
    val g      = new Graph(schema)
    // empty graph
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V1_0)
        .addNode(V1_1)
        ._addEdge(V0_0, V0_0, 0)
        ._addEdge(V0_1, V1_0, 0)
        ._addEdge(V1_1, V0_0, 1)
    )
    debugDump(g) shouldBe
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
    val V0_0_GNode = g._nodes(0).next()
    Accessors.getNeighborsOut(V0_0_GNode).size shouldBe 1
    Accessors.getNeighborsIn(V0_0_GNode).size shouldBe 2
    V0_0_GNode.out.size shouldBe 1
    V0_0_GNode.in.size shouldBe 2

    g.toString shouldBe "Graph[4 nodes]"
    g.nodeCountByLabel shouldBe Map("V0" -> 2, "V1" -> 2)
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
      new DiffGraphBuilder(schema)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V0_2)
        .addNode(V0_3)
        ._addEdge(V0_0, V0_2, 0)
        ._addEdge(V0_0, V0_1, 0)
        ._addEdge(V0_3, V0_1, 0)
        ._addEdge(V0_0, V0_3, 0)
        ._addEdge(V0_0, V0_2, 0)
        ._addEdge(V0_3, V0_2, 0)
        ._addEdge(V0_0, V0_1, 0)
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
      new DiffGraphBuilder(schema)
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
      val diff = new DiffGraphBuilder(schema)
        .addNode(V0_0)
        .addNode(V0_1)
        .addNode(V0_2)
        .addNode(V0_3)

      for (i <- perm) i match {
        case 0 => diff._addEdge(V0_0, V0_1, 0)
        case 1 => diff._addEdge(V0_0, V0_2, 0)
        case 2 => diff._addEdge(V0_3, V0_2, 0)
        case 3 => diff._addEdge(V0_3, V0_1, 0)
      }
      DiffGraphApplier.applyDiff(g, diff)
      g
    }

    def signature(g: Graph): String = {
//      def sig(nodes: IndexedSeq[GNode]): String = if (nodes(0).seq < nodes(1).seq) "+" else "-"
      def sig(nodes: Iterator[GNode]): String = if (nodes.next().seq < nodes.next().seq) "+" else "-"

      sig(Accessors.getNeighborsOut(g.node(0, 0), 0)) + sig(Accessors.getNeighborsIn(g.node(0, 1), 0)) + sig(
        Accessors.getNeighborsIn(g.node(0, 2), 0)
      ) + sig(Accessors.getNeighborsOut(g.node(0, 3), 0))
    }

    val badGraphDump =
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 4 [dense], 4 [dense]),
        |   V0_0   [0] -> V0_1, V0_2
        |   V0_1   [0] <- V0_3, V0_0
        |   V0_2   [0] <- V0_0, V0_3
        |   V0_3   [0] -> V0_2, V0_1
        |""".stripMargin
    debugDump(g) shouldBe badGraphDump
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
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesOut(g.node(0, 0), 0).toList(1))
    )
    debugDump(g) shouldBe expectation

    // remove first V0_1<-V0_0, i.e. same edge from the other side
    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesIn(g.node(0, 1), 0).toList(0))
    )
    debugDump(g) shouldBe expectation

    // remove the edge twice
    // remove first V0_1<-V0_0, i.e. same edge from the other side
    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesIn(g.node(0, 1), 0).toList(0))
        .removeEdge(Accessors.getEdgesOut(g.node(0, 0), 0).toList(1))
    )
    debugDump(g) shouldBe expectation
    testSerialization(g)
  }

  "permit a different edge deletion" in {
    var g = mkGraph()
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesOut(g.node(0, 0), 0).toList(4))
    )
    debugDump(g) shouldBe expectation

    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesIn(g.node(0, 1), 0).toList(2))
    )
    debugDump(g) shouldBe expectation
  }

  "permit multiple edge deletion" in {
    val g = mkGraph()
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesOut(g.node(0, 0), 0).toList(4))
        .removeEdge(Accessors.getEdgesIn(g.node(0, 2), 0).toList(1))
    )
    debugDump(g) shouldBe expectation
  }

  "permit node deletion" in {
    var g = mkGraph()
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeNode(g.node(0, 0))
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_1   [0] <- V0_3
        |   V0_2   [0] <- V0_3
        |   V0_3   [0] -> V0_1, V0_2
        |""".stripMargin

    g = mkGraph()
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        .removeNode(g.node(0, 1))
    )
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeNode(g.node(0, 2))
        .removeNode(g.node(0, 3))
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> V0_1, V0_1
        |   V0_1   [0] <- V0_0, V0_0
        |""".stripMargin

    testSerialization(g)
  }

  "dont mess up after node deletion" in {
    val schema = TestSchema.make(1, 0, 1, nodePropertyPrototypes = Array(Array[String]("")), edgePropertyPrototypes = null)
    val g      = new Graph(schema)
    val n1     = new GenericDNode(0)
    val n2     = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(n1).addNode(n2))
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)._setNodeProperty(n1.storedRef.get, 0, "n1")._setNodeProperty(n2.storedRef.get, 0, "n2")
    )
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).removeNode(n1.storedRef.get))
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
      |Node kind 0. (eid, nEdgesOut, nEdgesIn):
      |   V0_1       : 0: [n2]
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
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(V0_0).addNode(V0_1).addNode(V0_2).addNode(V0_3))
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema)._addEdge(V0_0, V0_1, 0))
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._addEdge(V0_0, V0_1, 0, "A")
        ._addEdge(V0_1, V0_2, 0, "B")
        ._addEdge(V0_2, V0_3, 0, "C")
        ._addEdge(V0_3, V0_0, 0, "D")
        ._addEdge(V0_1, V0_0, 0, "E")
    )

    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .setEdgeProperty(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(0), "X")
    )
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .setEdgeProperty(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(1), DefaultValue)
    )
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeEdge(Accessors.getEdgesIn(V0_1.storedRef.get, 0)(0))
    )
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeNode(V0_2.storedRef.get)
    )
    debugDump(g) shouldBe
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
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(V0_0).addNode(V0_1)._addEdge(V0_0, V0_1, 0)._addEdge(V0_0, V0_1, 0))
    g.neighbors(2).asInstanceOf[DefaultValue].default.getClass.getName shouldBe "java.lang.Short"
    g.neighbors(2).asInstanceOf[DefaultValue].default shouldBe (-1).toShort
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> (-1) V0_1, (-1) V0_1
        |   V0_1   [0] <- (-1) V0_0, (-1) V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).setEdgeProperty(Accessors.getEdgesOut(V0_0.storedRef.get, 0)(0), 5.toShort))
    g.neighbors(2).getClass.getName shouldBe "[S"
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> (5) V0_1, (-1) V0_1
        |   V0_1   [0] <- (5) V0_0, (-1) V0_0
        |""".stripMargin

    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema)._addEdge(V0_1.storedRef.get, V0_1, 0, 2.toShort))
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 3 [dense], 3 [dense]),
        |   V0_0   [0] -> (5) V0_1, (-1) V0_1
        |   V0_1   [0] -> (2) V0_1
        |   V0_1   [0] <- (5) V0_0, (-1) V0_0, (2) V0_1
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema).setEdgeProperty(Accessors.getEdgesOut(V0_0.storedRef.get, 0)(0), DefaultValue)
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 3 [dense], 3 [dense]),
        |   V0_0   [0] -> (-1) V0_1, (-1) V0_1
        |   V0_1   [0] -> (2) V0_1
        |   V0_1   [0] <- (-1) V0_0, (-1) V0_0, (2) V0_1
        |""".stripMargin
    testSerialization(g)
  }

  "support node properties" in {
    val schema = TestSchema.make(
      2,
      0,
      2,
      nodePropertyPrototypes = Array(new Array[Short](0), new Array[GNode](0)),
      formalQtys =
        Array(FormalQtyType.QtyOption, null, FormalQtyType.QtyMulti, null, FormalQtyType.QtyMulti, null, FormalQtyType.QtyMulti, null)
    )
    val g = new Graph(schema)

    val V0_0 = new GenericDNode(0)
    val V0_1 = new GenericDNode(0)
    val V0_2 = new GenericDNode(0)
    val V1_0 = new GenericDNode(1)
    val V1_1 = new GenericDNode(1)
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(V0_0).addNode(V0_1).addNode(V1_0).addNode(V1_1))
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), (1: 2), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |""".stripMargin

    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(V0_0.storedRef.get, 1, V0_2 :: V0_0 :: Nil)
        ._setNodeProperty(V1_1.storedRef.get, 0, 0.toShort :: 1.toShort :: Nil)
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [V0_2, V0_0]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_1       : 0: [0, 1]
        |""".stripMargin
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(V0_2.storedRef.get, 1, V0_2)
        ._setNodeProperty(V1_0.storedRef.get, 0, 0.toShort)
    )
    debugDump(g) shouldBe
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
      new DiffGraphBuilder(schema)
        .removeNode(V0_2.storedRef.get)
        ._setNodeProperty(V1_0.storedRef.get, 0, null)
        ._setNodeProperty(V0_1.storedRef.get, 1, null :: Nil)
    )

    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [<deleted V0_2>, V0_0]
        |   V0_1       : 1: [null]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_1       : 0: [0, 1]
        |""".stripMargin
    testSerialization(g)
    // If you overwrite the same property on the same node multiple times within the same diffgraph,
    // then the latest update overwrites all the previous ones
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        .removeNode(V0_2.storedRef.get)
        ._setNodeProperty(V1_1.storedRef.get, 0, 2.toShort :: 3.toShort :: Nil)
        ._setNodeProperty(V1_1.storedRef.get, 0, 4.toShort :: 5.toShort :: Nil)
        ._setNodeProperty(V1_1.storedRef.get, 0, 6.toShort :: Nil)
        ._setNodeProperty(V0_1.storedRef.get, 0, 6.toShort :: Nil)
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 2), total 5
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 1: [<deleted V0_2>, V0_0]
        |   V0_1       : 0: [6], 1: [null]
        |Node kind 1. (eid, nEdgesOut, nEdgesIn):
        |   V1_1       : 0: [6]
        |""".stripMargin
  }

  "node property accessors" in {
    val Node0Label = "V0"

    // Properties - these are normally generated by the DomainClassesGenerator based on the schema
    val propertySingle   = new SinglePropertyKey[String](kind = 0, name = "propertySingle", default = "propertySingleDefault")
    val propertyOptional = new OptionalPropertyKey[String](kind = 1, name = "propertyOptional")
    val propertyMulti    = new MultiPropertyKey[String](kind = 2, name = "propertyMulti")

    val schema = new FreeSchema(
      nodeLabels = Array(Node0Label),
      edgeLabels = Array.empty,
      propertyLabels = Array(propertySingle, propertyOptional, propertyMulti).map(_.name),
      propertyNamesByNodeLabel = Map.empty,
      edgePropertyPrototypes = new Array[AnyRef](0),
      nodePropertyPrototypes = Array(new Array[String](0), new Array[String](0), new Array[String](0)),
      formalQuantities = Array(FormalQtyType.QtyOne, null, FormalQtyType.QtyOption, null, FormalQtyType.QtyMulti)
    )

    // just to verify the free schema setup
    schema.getNodePropertyFormalQuantity(0, 0) shouldBe FormalQtyType.QtyOne
    schema.getNodePropertyFormalQuantity(0, 1) shouldBe FormalQtyType.QtyOption
    schema.getNodePropertyFormalQuantity(0, 2) shouldBe FormalQtyType.QtyMulti

    val g = new Graph(schema)
    val v0 = {
      val diffGraph = new DiffGraphBuilder(schema)
      val dnode     = new GenericDNode(0)
      diffGraph.addNode(dnode)
      DiffGraphApplier.applyDiff(g, diffGraph)
      dnode.storedRef.get
    }

    // test cases where the property is not defined
    v0.property(propertySingle) shouldBe "propertySingleDefault"

    // TODO this should rather return `Some("propertySingleDefault")` for an undefined property, rather than `None`, but
    // we only want to make that change after joern's transition to flatgraph
    // v0.propertyOption(propertySingle) shouldBe Some("propertySingleDefault")
    v0.propertyOption(propertySingle) shouldBe None

    v0.property(propertyOptional) shouldBe None
    v0.propertyOption(propertyOptional) shouldBe None
    v0.property(propertyMulti) shouldBe Seq.empty
    // TODO this should rather return `None` for an undefined property, rather than `Some(Seq.empty)`, but we only want
    //  to make that change after joern's transition to flatgraph - see https://github.com/joernio/joern/pull/4382
//    v0.propertyOption(propertyMulti) shouldBe None
    v0.propertyOption(propertyMulti) shouldBe Some(Seq.empty[String])

    // ensure odb compat accessors work just like before
    // see https://github.com/joernio/joern/pull/4382
    Accessors.getNodePropertyOptionCompat(v0, 0) shouldBe None
    Accessors.getNodePropertyOptionCompat(v0, 1) shouldBe None
    Accessors.getNodePropertyOptionCompat(v0, 2) shouldBe Some(Seq.empty)

    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(v0, 0, "a")           // qty.one
        ._setNodeProperty(v0, 1, "b")           // qty.option
        ._setNodeProperty(v0, 2, Seq("c", "d")) // qty.multi
    )

    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 1), total 1
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : propertySingle: [a], propertyOptional: [b], propertyMulti: [c, d]
        |""".stripMargin

    // test cases where the property is defined
    v0.property(propertySingle) shouldBe "a"
    v0.propertyOption(propertySingle) shouldBe Some("a")
    v0.property(propertyOptional) shouldBe Some("b")
    v0.propertyOption(propertyOptional) shouldBe Some("b")
    v0.property(propertyMulti) shouldBe Seq("c", "d")
    v0.propertyOption(propertyMulti) shouldBe Some(Seq("c", "d"))

    // ensure odb compat accessors work just like before
    // see https://github.com/joernio/joern/pull/4382
    Accessors.getNodePropertyOptionCompat(v0, 0) shouldBe Some("a")
    Accessors.getNodePropertyOptionCompat(v0, 1) shouldBe Some("b")
    Accessors.getNodePropertyOptionCompat(v0, 2) shouldBe Some(Seq("c", "d"))

    // lookup nodes by property values from indices
    g.nodesWithProperty(propertySingle.name, "a").l shouldBe List(v0)
    g.nodesWithProperty(propertySingle.name, "A").l shouldBe Nil
    g.nodesWithProperty(propertyOptional.name, "b").l shouldBe List(v0)
    g.nodesWithProperty(propertyOptional.name, "B").l shouldBe Nil
    g.nodesWithProperty(propertyMulti.name, "c").l shouldBe List(v0)
    g.nodesWithProperty(propertyMulti.name, "C").l shouldBe Nil
    g.nodesWithProperty(propertyMulti.name, "d").l shouldBe List(v0)
    g.nodesWithProperty(propertyMulti.name, "D").l shouldBe Nil
    g.nodesWithProperty("undefined", "foo").l shouldBe Nil

    // lookup nodes by label and property values from indices
    g.nodesWithProperty(Node0Label, propertySingle.name, "a").l shouldBe List(v0)
    g.nodesWithProperty(Node0Label, propertySingle.name, "A").l shouldBe Nil
    g.nodesWithProperty("undefined", propertySingle.name, "A").l shouldBe Nil
    g.nodesWithProperty(Node0Label, propertyOptional.name, "b").l shouldBe List(v0)
    g.nodesWithProperty(Node0Label, propertyOptional.name, "B").l shouldBe Nil
    g.nodesWithProperty("undefined", propertyOptional.name, "B").l shouldBe Nil
    g.nodesWithProperty(Node0Label, propertyMulti.name, "c").l shouldBe List(v0)
    g.nodesWithProperty(Node0Label, propertyMulti.name, "C").l shouldBe Nil
    g.nodesWithProperty("undefined", propertyMulti.name, "C").l shouldBe Nil
    g.nodesWithProperty(Node0Label, "undefined", "foo").l shouldBe Nil
  }

  "report error when trying to use unsupported property types" in {
    class A(wrapped: String) // we don't support arbitrary classes as property types

    // ensure that we throw an exception when trying to define a schema with an arbitrary class as a node property type
    intercept[UnsupportedOperationException] {
      TestSchema.make(1, 1, nodePropertyPrototypes = Array(Array.empty[A]))
    }.getMessage should include("unsupported property prototype")

    // same for edge properties
    intercept[UnsupportedOperationException] {
      TestSchema.make(1, 1, edgePropertyPrototypes = Array(Array.empty[A]))
    }.getMessage should include("unsupported property prototype")

    // now let's define a valid schema and try to update a node/edge property to something illegal via a DiffGraph
    val schema = TestSchema.make(
      nodeKinds = 1,
      edgeKinds = 1,
      properties = 1,
      edgePropertyPrototypes = Array(Array.empty[String]),
      nodePropertyPrototypes = Array(Array.empty[String]),
      formalQtys = Array(FormalQtyType.QtyOption, null, FormalQtyType.QtyMulti, null)
    )

    val g  = new Graph(schema)
    val v0 = new GenericDNode(0)
    val v1 = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(v0).addNode(v1))

    // try to update a node property to something unsupported via a DiffGraph
    intercept[UnsupportedOperationException] {
      DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema)._setNodeProperty(v0.storedRef.get, 0, new A("should not work")))
    }.getMessage should include("unsupported property type")

    // same for edge properties
    intercept[UnsupportedOperationException] {
      DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema)._addEdge(v0, v1, 0, new A("should not work")))
    }.getMessage should include("unsupported property type")
  }

  /*
  "Support custom domain classes for detached nodes" in {
    class CustomNode extends DNode {
      override type StoredNodeType = GNode
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
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(V0_0))
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 3), (1: 0), total 3
      |Node kind 0. (eid, nEdgesOut, nEdgesIn):
      |   V0_0       : 0: [V0_1]
      |   V0_1       : 0: [V0_1, V0_2], 1: [c]
      |   V0_2       : 1: [b]
      |Node kind 1. (eid, nEdgesOut, nEdgesIn):
      |""".stripMargin
    testSerialization(g)
  }
   */
  "support indexed lookups" in {
    val schema = TestSchema.make(1, 0, 1, nodePropertyPrototypes = Array(new Array[String](0)))
    val g      = new Graph(schema)
    val v0     = new GenericDNode(0)
    val v1     = new GenericDNode(0)
    val v2     = new GenericDNode(0)
    val v3     = new GenericDNode(0)
    DiffGraphApplier.applyDiff(g, new DiffGraphBuilder(schema).addNode(v0).addNode(v1).addNode(v2).addNode(v3))

    // if we're asking for a valid property and no node has one defined yet, index lookups should already be possible,
    // i.e. we want empty results rather than throwing an exception
    Accessors.getWithInverseIndex(g, 0, 0, "p0").toList shouldBe Nil

    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(v0.storedRef.get, 0, "p0")
        ._setNodeProperty(v1.storedRef.get, 0, "p1")
        ._setNodeProperty(v3.storedRef.get, 0, "p1" :: "p3" :: Nil)
    )
    debugDump(g) shouldBe
      """#Node numbers (kindId, nnodes) (0: 4), total 4
        |Node kind 0. (eid, nEdgesOut, nEdgesIn):
        |   V0_0       : 0: [p0]
        |   V0_1       : 0: [p1]
        |   V0_3       : 0: [p1, p3]
        |""".stripMargin
    Accessors.getWithInverseIndex(g, 0, 0, "p0").toList shouldBe List(v0.storedRef.get)
    Accessors.getWithInverseIndex(g, 0, 0, "p1").toList shouldBe List(v1.storedRef.get, v3.storedRef.get)
    Accessors.getWithInverseIndex(g, 0, 0, "p2").toList shouldBe Nil
    Accessors.getWithInverseIndex(g, 0, 0, "p3").toList shouldBe List(v3.storedRef.get)
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(v0.storedRef.get, 0, "p0")
        ._setNodeProperty(v1.storedRef.get, 0, "p1")
        ._setNodeProperty(v3.storedRef.get, 0, "p1" :: "p3" :: Nil)
    )
    g.inverseIndices.get(0) shouldBe null
    DiffGraphApplier.applyDiff(
      g,
      new DiffGraphBuilder(schema)
        ._setNodeProperty(v2.storedRef.get, 0, "p2")
    )
    g.inverseIndices.get(0) shouldBe null
  }

  "write to storage on close and read from storage on open" in {
    val schema = TestSchema.make(3, 2)

    withTemporaryFile(s"flatgraph-${getClass.getSimpleName}-", "fg") { storagePath =>
      // TODO pass storagePath to graph - in config object? check what config options odb1 had
      val graph1 = Graph.withStorage(schema, storagePath)

      val V0_0 = new GenericDNode(0)
      val V0_1 = new GenericDNode(0)
      val V1_0 = new GenericDNode(1)
      val V1_1 = new GenericDNode(1)
      DiffGraphApplier.applyDiff(
        graph1,
        new DiffGraphBuilder(schema)
          .addNode(V0_0)
          .addNode(V0_1)
          .addNode(V1_0)
          .addNode(V1_1)
          ._addEdge(V0_0, V0_0, 0)
          ._addEdge(V0_1, V1_0, 0)
          ._addEdge(V1_1, V0_0, 1)
      )
      val g1Dump = debugDump(graph1)
      g1Dump shouldBe
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
      graph1.close()

      Files.size(storagePath) should be > 0L

      // further access to the graph should be prohibited
      intercept[GraphClosedException](DiffGraphApplier.applyDiff(graph1, DiffGraphBuilder(schema)))

      val graph2 = Graph.withStorage(schema, storagePath)
      val g2Dump = debugDump(graph2)
      g2Dump shouldBe g1Dump
    }
  }

  "opening a broken graph file should be handled gracefully" when {
    "file is empty" in {
      withTemporaryFile(s"flatgraph-${getClass.getSimpleName}-", "fg") { storagePath =>
        assertThrows[DeserializationException](Deserialization.readGraph(storagePath, None))
      }
    }

    "file is too small (smaller than even the header)" in {
      withTemporaryFile(s"flatgraph-${getClass.getSimpleName}-", "fg") { storagePath =>
        val brokenHeader = new Array[Byte](storage.HeaderSize - 1)
        Files.write(storagePath, brokenHeader)
        assertThrows[DeserializationException](Deserialization.readGraph(storagePath, None))
      }
    }

    "header is incorrect" in {
      withTemporaryFile(s"flatgraph-${getClass.getSimpleName}-", "fg") { storagePath =>
        val brokenHeader = new Array[Byte](storage.HeaderSize + 30)
        Files.write(storagePath, brokenHeader)
        assertThrows[DeserializationException](Deserialization.readGraph(storagePath, None))
      }
    }
  }

  "copying a graph" in {
    import flatgraph.misc.TestUtils.copy

    val graph                  = DiffToolTests.makeSampleGraph()
    val debugDumpOriginalGraph = debugDump(graph)
    debugDumpOriginalGraph shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 1 [dense], 1 [dense]),
        |   V0_0       : 0: [A], 1: [40]
        |   V0_0   [0] -> (edgePropertyValue) V0_1
        |   V0_1       : 0: [X, Y], 1: [50, 51]
        |   V0_1   [0] <- (edgePropertyValue) V0_0
        |""".stripMargin

    val graphCopy = graph.copy()
    debugDump(graph) shouldBe debugDump(graphCopy)

    // make some changes only to the graph copy
    val v0   = graphCopy.node(kind = 0, seq = 0)
    val edge = Accessors.getEdgesOut(v0).head
    DiffGraphApplier.applyDiff(
      graphCopy,
      new DiffGraphBuilder(DiffToolTests.sampleSchema)
        .setNodeProperty(v0, "0", "updatedNodeProperty")
        .setEdgeProperty(edge, "updatedEdgeProperty")
    )
    debugDump(graphCopy) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 1 [dense], 1 [dense]),
        |   V0_0       : 0: [updatedNodeProperty], 1: [40]
        |   V0_0   [0] -> (updatedEdgeProperty) V0_1
        |   V0_1       : 0: [X, Y], 1: [50, 51]
        |   V0_1   [0] <- (updatedEdgeProperty) V0_0
        |""".stripMargin

    // original graph should be untouched
    debugDump(graph) shouldBe debugDumpOriginalGraph
  }
}
