package flatgraph

import flatgraph.TestHelpers.withTemporaryFile
import flatgraph.misc.DebugDump.debugDump
import flatgraph.storage.{Deserialization, Serialization}
import org.scalatest.matchers.should.Matchers.shouldBe

import java.nio.file.{Files, Path}
import scala.util.Try

object TestHelpers {
  def createTestNode(nodeKind: Int = 0, seqId: Int = 0): GNode =
    GNode(null, 0, 0)

  val DummyTestNode = createTestNode()

  def withTemporaryFile[A](prefix: String, suffix: String)(fun: Path => A): A = {
    val storagePath = Files.createTempFile(prefix, s".$suffix")
    val attempt     = Try(fun(storagePath))
    Files.deleteIfExists(storagePath)
    attempt.get
  }
}

object TestSchema {
  def make(
            nodeKinds: Int,
            edgeKinds: Int,
            properties: Int = 0,
            edgePropertyPrototypes: Array[AnyRef] = null,
            nodePropertyPrototypes: Array[AnyRef] = null
          ): Schema = {
    new FreeSchema(
      nodeLabels = Range(0, nodeKinds).map { id => s"V${id}" }.toArray,
      edgeLabels = Range(0, edgeKinds).map { id => s"${id}" }.toArray,
      propertyLabels = Range(0, properties).map { id => s"${id}" }.toArray,
      edgePropertyPrototypes = if (edgePropertyPrototypes != null) edgePropertyPrototypes else new Array[AnyRef](edgeKinds),
      nodePropertyPrototypes = if (nodePropertyPrototypes != null) nodePropertyPrototypes else new Array[AnyRef](properties)
    )
  }

  def testSerialization(graph: Graph): Unit = {
    val orig = debugDump(graph)
    withTemporaryFile(s"flatgraph-${getClass.getSimpleName}", "fg") { storagePath =>
      Serialization.writeGraph(graph, storagePath)
      val deserialized = Deserialization.readGraph(storagePath, Option(graph.schema))
      val newdump      = debugDump(deserialized)
      //    if (newdump != orig) {
      //      1 + 1 // for easier breakpoints
      //    }
      orig shouldBe newdump
    }
  }

}
