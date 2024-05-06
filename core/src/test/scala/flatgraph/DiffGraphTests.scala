package flatgraph

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class DiffGraphTests extends AnyWordSpec with Matchers {

  "node addition and removal" in {
    val schema = TestSchema.make(nodeKinds = 1, edgeKinds = 0)
    val graph  = new Graph(schema)
    graph.allNodes.size shouldBe 0

    // with one node
    val diff0 = new DiffGraphBuilder(schema)
    val V0_0  = new GenericDNode(0)
    diff0.addNode(V0_0)
    DiffGraphApplier.applyDiff(graph, diff0)
    graph.allNodes.size shouldBe 1
    val gNode = graph.allNodes.next()

    // delete node
    val diff1 = new DiffGraphBuilder(schema)
    diff1.removeNode(gNode)
    // it shouldn't matter (and especially not error) if we remove the same node twice
    diff1.removeNode(gNode)
    DiffGraphApplier.applyDiff(graph, diff1)
    graph.allNodes.size shouldBe 0
    graph.livingNodeCountByKind(0) shouldBe 0
    graph.nodes(schema.getNodeLabel(0)).size shouldBe 0
  }

  "edge addition and removal" in {
    val schema = TestSchema.make(nodeKinds = 1, edgeKinds = 1)
    val graph  = new Graph(schema)
    graph.allNodes.size shouldBe 0

    // two nodes, one edge
    val diff0 = new DiffGraphBuilder(schema)
    val V0_0  = new GenericDNode(0)
    val V0_1  = new GenericDNode(0)
    diff0._addEdge(V0_0, V0_1, 0)
    DiffGraphApplier.applyDiff(graph, diff0)
    graph.allNodes.size shouldBe 2
    val allEdges = graph.allNodes.flatMap(Accessors.getEdgesOut).toSeq
    allEdges.size shouldBe 1
    val edge = allEdges.head

    // delete edge
    val diff1 = new DiffGraphBuilder(schema)
    diff1.removeEdge(edge)
    // it shouldn't matter (and especially not error) if we remove the same edge twice
    diff1.removeEdge(edge)
    DiffGraphApplier.applyDiff(graph, diff1)
    graph.allNodes.size shouldBe 2
    graph.allNodes.flatMap(Accessors.getEdgesOut).size shouldBe 0
  }

}
