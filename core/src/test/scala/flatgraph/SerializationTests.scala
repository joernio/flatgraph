package flatgraph

import flatgraph.TestSchema.testSerialization
import flatgraph.misc.DebugDump.debugDump
import flatgraph.storage.{Deserialization, Serialization}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.Files

class SerializationTests extends AnyWordSpec with Matchers {

  "creates parent directories" in {
    val testRoot    = Files.createTempDirectory(getClass.getSimpleName)
    val storagePath = testRoot.resolve("non-existing-parent/graph.fg")

    val schema = TestSchema.make(1, 1)
    val graph  = new Graph(schema)

    val diff0 = new DiffGraphBuilder(schema)
    val V0_0  = new GenericDNode(0)
    val V0_1  = new GenericDNode(0)
    diff0
      ._addEdge(V0_0, V0_1, 0)
      ._addEdge(V0_1, V0_0, 0)
    DiffGraphApplier.applyDiff(graph, diff0)
    val originalDump = debugDump(graph)
    originalDump shouldBe
      """#Node numbers (kindId, nnodes) (0: 2), total 2
        |Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 2 [dense], 2 [dense]),
        |   V0_0   [0] -> V0_1
        |   V0_0   [0] <- V0_1
        |   V0_1   [0] -> V0_0
        |   V0_1   [0] <- V0_0
        |""".stripMargin

    Serialization.writeGraph(graph, storagePath)

    val deserialized = Deserialization.readGraph(storagePath, Option(graph.schema))
    val newDump      = debugDump(deserialized)
    originalDump shouldBe newDump
  }

}
