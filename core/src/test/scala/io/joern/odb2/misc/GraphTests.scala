package io.joern.odb2
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TestSchema(val nKinds: Int, val nEdgeKinds: Int) extends Schema {
  override def getNNodeKinds: Int = nKinds

  override def getNEdgeKinds: Int = nEdgeKinds

  override def makeNode(g: Graph, kid: Short, seqId: Int): GNode = new GNode(g, kid, seqId)

}

class GraphTests extends AnyWordSpec with Matchers {
  //General tip: If a test fails, add println(DebugDump.debugDump(g)) in front, in order to get untruncated "actual" for copy-paste
  "Graphs" should {
    "work with updates and a single edge type" in {
      val schema = new TestSchema(1, 1)
      val g = new Graph(schema)
      //empty graph
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 0: 0, total 0
          |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), 
          |""".stripMargin
      //with some edges
      val diff0 = new DiffGraphBuilder
      val V0_0 = new GenericDNode(0)
      val V0_1 = new GenericDNode(0)
      val V0_2 = new GenericDNode(0)
      val V0_3 = new GenericDNode(0)
      diff0
        .addEdge(V0_0, V0_1, 0)
        .addEdge(V0_1, V0_2, 0)
        .addEdge(V0_2, V0_3, 0)
        .addEdge(V0_3, V0_0, 0)
        .addEdge(V0_1, V0_0, 0)
      DiffGraphApplier.applyDiff(g, diff0)
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 4: 0, total 4
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
      g._neighbors(0).asInstanceOf[Array[Int]].length shouldBe 5

      //modify
      val diff2 = new DiffGraphBuilder
      diff2.addEdge(V0_2, V0_3, 0)
      DiffGraphApplier.applyDiff(g, diff2)
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 4: 0, total 4
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

      //add a node. Don't resize edges array
      val V0_4 = new GenericDNode(0)
      DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addNode(V0_4))
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 5: 0, total 5
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
      g._neighbors(0).asInstanceOf[Array[Int]].length shouldBe 5

      //add an interior edge. Check that adding edges in the middle and at the end of undersized edge arrays works
      DiffGraphApplier.applyDiff(g, (new DiffGraphBuilder).addEdge(V0_1, V0_4, 0))
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 5: 0, total 5
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
      g._neighbors(0).asInstanceOf[Array[Int]].length shouldBe 6
    }

    "work with multiple edge and node types" in {
      val schema = new TestSchema(3, 2)
      val g = new Graph(schema)
      //empty graph
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 0: 0, 0: 1, 0: 2, total 0
          |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]), 
          |Node kind 1. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]), 
          |Node kind 2. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]), (1, 0 [NA], 0 [NA]), 
          |""".stripMargin

      val V0_0 = new GenericDNode(0)
      val V0_1 = new GenericDNode(0)
      val V1_0 = new GenericDNode(1)
      val V1_1 = new GenericDNode(1)
      DiffGraphApplier.applyDiff(g,
                                 (new DiffGraphBuilder)
                                   .addNode(V0_0)
                                   .addNode(V0_1)
                                   .addNode(V1_0)
                                   .addNode(V1_1)
                                   .addEdge(V0_0, V0_0, 0)
                                   .addEdge(V0_1, V1_0, 0)
                                   .addEdge(V1_1, V0_0, 1))
      DebugDump.debugDump(g) shouldBe
        """#Node numbers (kindId, nnodes) 2: 0, 2: 1, 0: 2, total 4
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
    }
  }
}
