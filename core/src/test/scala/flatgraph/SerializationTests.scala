package flatgraph

import flatgraph.misc.DebugDump.debugDump
import flatgraph.storage.Deserialization.DeserializationException
import flatgraph.storage.{Deserialization, Serialization}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Path}
import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.nio.ByteOrder
import scala.util.Using

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

  /* show that we're no longer vulnerable to the denial of service issue filed here:
   * https://github.com/joernio/flatgraph/security/advisories/GHSA-jqmx-3x2p-69vh
   */
  "is no longer vulnerable to manifest size attack" in {
    val schema = TestSchema.make(1, 0)
    val graph  = Graph(schema)
    val diff   = DiffGraphBuilder(schema).addNode(new GenericDNode(0))
    DiffGraphApplier.applyDiff(graph, diff)

    val storagePath = Files.createTempFile(s"flatgraph-${getClass.getSimpleName}", "fg")
    Serialization.writeGraph(graph, storagePath)
    patchFile(storagePath)

    // when the vulnerability was reported, the following line raised a:
    // `java.lang.OutOfMemoryError: Requested array size exceeds VM limit`
    intercept[DeserializationException] {
      Deserialization.readGraph(storagePath, Option(graph.schema))
    }.getMessage should include("corrupt file: manifest size")
  }

  /** manipulate file as detailed in https: //github.com/joernio/flatgraph/security/advisories/GHSA-jqmx-3x2p-69vh */
  private def patchFile(path: Path): Unit = {
    Using.resource(new RandomAccessFile(path.toFile, "rw")) { file =>
      // Seek to end and get file size
      file.seek(file.length())
      val fileSize = file.getFilePointer

      // Calculate malicious offset
      val maliciousOffset = fileSize - 2147483647L

      // Seek to position 8 and write the offset as little-endian long
      file.seek(8)
      val buffer = ByteBuffer.allocate(8)
      buffer.order(ByteOrder.LITTLE_ENDIAN)
      buffer.putLong(maliciousOffset)
      file.write(buffer.array())
    }
  }

}
