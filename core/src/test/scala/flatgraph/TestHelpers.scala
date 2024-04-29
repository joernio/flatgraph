package flatgraph

import flatgraph.TestHelpers.withTemporaryFile
import flatgraph.misc.DebugDump.debugDump
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.misc.TestUtils.copy
import flatgraph.storage.{Deserialization, Serialization}
import org.scalatest.matchers.should.Matchers.shouldBe

import java.nio.file.{Files, Path}
import scala.util.Try

object TestHelpers {
  def createTestNode(nodeKind: Int = 0, seqId: Int = 0): GNode =
    GNode(null, nodeKind.toShortSafely, seqId)

  val DummyTestNode = createTestNode()

  def withTemporaryFile[A](prefix: String, suffix: String)(fun: Path => A): A = {
    val storagePath = Files.createTempFile(prefix, s".$suffix")
    val attempt     = Try(fun(storagePath))
    Files.deleteIfExists(storagePath)
    attempt.get
  }

  def addNodes(graph: Graph, nodes: Seq[DNode]): Seq[GNode] = {
    val diffGraph = new DiffGraphBuilder(graph.schema)
    nodes.foreach(diffGraph.addNode)
    DiffGraphApplier.applyDiff(graph, diffGraph)
    nodes.map(_.storedRef.get)
  }
}

object TestSchema {
  def make(
    nodeKinds: Int,
    edgeKinds: Int,
    properties: Int = 0,
    edgePropertyPrototypes: Array[AnyRef] = null,
    nodePropertyPrototypes: Array[AnyRef] = null,
    formalQtys: Array[FormalQtyType.FormalQuantity] = null
  ): Schema = {
    new FreeSchema(
      nodeLabels = Range(0, nodeKinds).map { id => s"V${id}" }.toArray,
      edgeLabels = Range(0, edgeKinds).map { id => s"${id}" }.toArray,
      propertyLabels = Range(0, properties).map { id => s"${id}" }.toArray,
      propertyNamesByNodeLabel = Map.empty,
      edgePropertyPrototypes = if (edgePropertyPrototypes != null) edgePropertyPrototypes else new Array[AnyRef](edgeKinds),
      nodePropertyPrototypes = if (nodePropertyPrototypes != null) nodePropertyPrototypes else new Array[AnyRef](properties),
      formalQtys
    )
  }

  def testSerialization(graph: Graph): Unit = {
    val originalDump = debugDump(graph)
    withTemporaryFile(s"flatgraph-${getClass.getSimpleName}", "fg") { storagePath =>
      Serialization.writeGraph(graph, storagePath)
      val deserialized = Deserialization.readGraph(storagePath, Option(graph.schema))
      val newDump      = debugDump(deserialized)
      originalDump shouldBe newDump

      val cloned    = graph.copy()
      val cloneDump = debugDump(cloned)
      originalDump shouldBe cloneDump
    }
  }

}
