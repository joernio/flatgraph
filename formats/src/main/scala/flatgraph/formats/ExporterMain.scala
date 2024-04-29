package flatgraph.formats

import org.slf4j.LoggerFactory
import flatgraph.formats.dot.DotExporter
import flatgraph.formats.graphml.GraphMLExporter
import flatgraph.formats.graphson.GraphSONExporter
import flatgraph.formats.neo4jcsv.Neo4jCsvExporter
import flatgraph.storage.Deserialization
import scopt.OParser

import java.nio.file.{Files, Path, Paths}
import scala.util.Using

/** Base functionality to export a given flatgraph to various export formats. */
object ExporterMain {
  lazy val logger = LoggerFactory.getLogger(getClass)

  def apply(): Array[String] => Unit = { args =>
    OParser
      .parse(parser, args, Config(Paths.get("/dev/null"), null, Paths.get("/dev/null")))
      .map { case Config(inputFile, format, outputFile) =>
        if (Files.notExists(inputFile))
          throw new AssertionError(s"given input file $inputFile does not exist")
        if (Files.exists(outputFile)) {
          if (Files.isRegularFile(outputFile))
            throw new AssertionError(s"output file $outputFile already exists and is not a directory")
        } else {
          Files.createDirectories(outputFile)
        }

        val exporter: Exporter = format match {
          case Format.Neo4jCsv => Neo4jCsvExporter
          case Format.GraphML  => GraphMLExporter
          case Format.GraphSON => GraphSONExporter
          case Format.Dot      => DotExporter
        }
        logger.info(s"starting export of graph in $inputFile to storagePath=$outputFile in format=$format")

        val ExportResult(nodeCount, edgeCount, files, additionalInfo) =
          Using.resource(Deserialization.readGraph(inputFile, schemaMaybe = None)) { graph =>
            exporter.runExport(graph, outputFile)
          }
        logger.info(s"export completed successfully: $nodeCount nodes, $edgeCount edges in ${files.size} files")
        additionalInfo.foreach(logger.info)
      }
  }

  private lazy val builder = OParser.builder[Config]
  private lazy val parser = {
    import builder._
    OParser.sequence(
      programName("odb-export"),
      help("help").text("prints this usage text"),
      opt[String]('f', "format")
        .required()
        .action((x, c) => c.copy(format = Format.byNameLowercase(x)))
        .text(s"export format, one of [${Format.valuesAsStringLowercase.mkString("|")}]"),
      opt[Path]('o', "out") // will be able to read a `Path` with scopt 4.0.2+ (once released)
        .required()
        .action((x, c) => c.copy(outputFile = x))
        .text("output file or directory - must exist and be writable"),
      arg[Path]("odbBinaryFile")
        .required()
        .action((x, c) => c.copy(inputFile = x))
        .text("input flatgraph graph file - must exist and be readable")
    )
  }

  private case class Config(inputFile: Path, format: Format.Value, outputFile: Path)
}
