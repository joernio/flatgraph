package flatgraph.util

import flatgraph.TestSchema.testSerialization
import flatgraph.misc.DebugDump.debugDump
import flatgraph.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.jdk.CollectionConverters.*

class DiffToolTests extends AnyWordSpec {
  import DiffToolTests.makeSampleGraph

  "detects zero changes for the same (identity) graph" in {
    val graph = makeSampleGraph()
    val diff  = DiffTool.compare(graph, graph)
    withClue(s"$diff size") {
      diff.size() shouldBe 0
    }
  }

  "detects zero changes for the same (equality) graph" in {
    val graph0 = makeSampleGraph()
    val graph1 = makeSampleGraph()
    val diff   = DiffTool.compare(graph0, graph1)
    withClue(s"$diff size") {
      diff.size() shouldBe 0
    }
  }

  "detects differences in properties" in {
    val graph0 = makeSampleGraph()
    val graph1 = {
      val graph = makeSampleGraph()
      val v0    = graph.node(0, 0)
      val v1    = graph.node(0, 1)
      val e     = Accessors.getEdgesOut(v0).head
      DiffGraphApplier.applyDiff(
        graph,
        new DiffGraphBuilder(graph0.schema)
          ._setNodeProperty(v0, 0, "A9")
          ._setNodeProperty(v1, 0, Seq("X9", "Y9"))
          ._setNodeProperty(v0, 1, 49.toShort)
          ._setNodeProperty(v1, 1, Seq(58.toShort, 59.toShort))
          .setEdgeProperty(e, "edgePropertyValueUpdated")
      )
      graph
    }

    val diff = DiffTool.compare(graph0, graph1).asScala
    diff.size shouldBe 5
    diff.mkString("\n") shouldBe
      """nodeId=0; property '0' has different values: graph1='IndexedSeq(A)', graph2='IndexedSeq(A9)'
        |nodeId=0; property '1' has different values: graph1='IndexedSeq(40)', graph2='IndexedSeq(49)'
        |nodeId=0.outE; edge label = 0; property 'EDGE_PROPERTY' has different values: graph1='edgePropertyValue', graph2='edgePropertyValueUpdated'
        |nodeId=1; property '0' has different values: graph1='IndexedSeq(X, Y)', graph2='IndexedSeq(X9, Y9)'
        |nodeId=1; property '1' has different values: graph1='IndexedSeq(50, 51)', graph2='IndexedSeq(58, 59)'
        |""".stripMargin.trim
  }

  "detects missing edge" in {
    val graph0 = makeSampleGraph()
    val graph1 = {
      val graph = makeSampleGraph()
      val v0    = graph.node(0, 0)
      val e     = Accessors.getEdgesOut(v0).head
      DiffGraphApplier.applyDiff(graph, new DiffGraphBuilder(graph0.schema).removeEdge(e))
      graph
    }

    val diff = DiffTool.compare(graph0, graph1).asScala
    diff.size shouldBe 1
    diff.mkString("\n") shouldBe
      """nodeId=0.outE; different number of edges: graph1=1, graph2=0
        |""".stripMargin.trim
  }

  "detects missing node" in {
    val graph0 = makeSampleGraph()
    val graph1 = {
      val graph = makeSampleGraph()
      val v0    = graph.node(0, 0)
      DiffGraphApplier.applyDiff(graph, new DiffGraphBuilder(graph0.schema).removeNode(v0))
      graph
    }

    val diff = DiffTool.compare(graph0, graph1).asScala
    diff should contain("node count differs: graph1=2, graph2=1")
    diff should contain("node flatgraph.GNode[label=V0; seq=0; id=0] only exists in graph1")
  }

}

object DiffToolTests {
  val sampleSchema = TestSchema.make(
    nodeKinds = 1,
    edgeKinds = 1,
    properties = 2,
    nodePropertyPrototypes = Array(Array.empty[String], Array.emptyShortArray),
    edgePropertyPrototypes = Array(Array.empty[String])
  )

  def makeSampleGraph(): Graph = {
    val graph = new Graph(sampleSchema)

    val v0 = new GenericDNode(0)
    val v1 = new GenericDNode(0)

    DiffGraphApplier.applyDiff(graph, new DiffGraphBuilder(sampleSchema)._addEdge(v0, v1, 0, "edgePropertyValue"))
    DiffGraphApplier.applyDiff(
      graph,
      new DiffGraphBuilder(sampleSchema)
        ._setNodeProperty(v0.storedRef.get, 0, "A")
        ._setNodeProperty(v1.storedRef.get, 0, Seq("X", "Y"))
        ._setNodeProperty(v0.storedRef.get, 1, 40.toShort)
        ._setNodeProperty(v1.storedRef.get, 1, Seq(50.toShort, 51.toShort))
    )
    //    println(debugDump(graph))
    debugDump(graph) shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 1 [dense], 1 [dense]),
        |   V0_0       : 0: [A], 1: [40]
        |   V0_0   [0] -> (edgePropertyValue) V0_1
        |   V0_1       : 0: [X, Y], 1: [50, 51]
        |   V0_1   [0] <- (edgePropertyValue) V0_0
        |""".stripMargin
    testSerialization(graph)
    graph
  }
}
