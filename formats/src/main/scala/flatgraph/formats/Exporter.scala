package flatgraph.formats

import java.nio.file.{Path, Paths}
import flatgraph.{Edge, Graph, GNode}

trait Exporter {

  def defaultFileExtension: String

  def runExport(graph: Graph, outputFile: Path): ExportResult

  def runExport(graph: Graph, outputFile: String): ExportResult =
    runExport(graph, Paths.get(outputFile))
}

case class ExportResult(nodeCount: Int, edgeCount: Int, files: Seq[Path], additionalInfo: Option[String])
