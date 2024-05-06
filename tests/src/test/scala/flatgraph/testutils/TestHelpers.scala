package flatgraph.testutils

import flatgraph.*

import java.nio.file.{Files, Path}
import scala.util.Try

object TestHelpers {
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
