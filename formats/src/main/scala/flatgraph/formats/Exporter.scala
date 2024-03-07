package flatgraph.formats

import java.nio.file.{Path, Paths}
import flatgraph.{Edge, GNode, Graph, Schema}

trait Exporter {

  def defaultFileExtension: String

  def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[Edge], outputFile: Path): ExportResult

  def runExport(graph: Graph, outputFile: Path): ExportResult =
    runExport(graph.schema, graph.allNodes, graph.allEdges, outputFile)

  def runExport(graph: Graph, outputFile: String): ExportResult =
    runExport(graph, Paths.get(outputFile))
}

case class ExportResult(nodeCount: Int, edgeCount: Int, files: Seq[Path], additionalInfo: Option[String])
