package flatgraph.formats.dot

import flatgraph.formats.{ExportResult, Exporter, iterableForList, resolveOutputFileSingle}
import flatgraph.{Accessors, Edge, GNode, Graph, Schema}

import java.nio.file.{Files, Path}
import scala.jdk.CollectionConverters.MapHasAsScala
import scala.util.Using

/** Exports flatgraph to graphviz dot/gv file
  *
  * Note: GraphML doesn't natively support list property types, so we fake it by encoding it as a `;` delimited string. If you import this
  * into a different database, you'll need to parse that separately.
  *
  * https://en.wikipedia.org/wiki/DOT_(graph_description_language) https://www.graphviz.org/doc/info/lang.html
  * http://magjac.com/graphviz-visual-editor/ https://www.slideshare.net/albazo/graphiz-using-the-dot-language
  */
object DotExporter extends Exporter {
  override def defaultFileExtension = "dot"

  override def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[Edge], outputFile: Path) = {
    val outFile              = resolveOutputFileSingle(outputFile, s"export.$defaultFileExtension")
    var nodeCount, edgeCount = 0

    Using.resource(Files.newBufferedWriter(outFile)) { writer =>
      def writeLine(line: String): Unit = {
        writer.write(line)
        writer.newLine()
      }

      writeLine("digraph {")

      nodes.iterator.foreach { node =>
        nodeCount += 1
        val line = new StringBuffer()
          .append("  ")
          .append(node.id)
          .append(s"[label=${node.label} ")
          .append(
            Accessors
              .getNodeProperties(node)
              .iterator
              .map { case (key, value) =>
                s"$key=${encodePropertyValue(value)}"
              }
              .mkString(" ")
          )
          .append("]")
        writeLine(line.toString)
      }

      edges.iterator.foreach { edge =>
        edgeCount += 1
        val line = new StringBuffer()
          .append(s"  ${edge.src.id()} -> ${edge.dst.id()} ")
          .append(s"[label=${edge.label} ")

        if (edge.property != null)
          line.append(s"property=${encodePropertyValue(edge.property)}")

        line.append("]")
        writeLine(line.toString)
      }

      writeLine("}")
    }

    ExportResult(nodeCount = nodeCount, edgeCount = edgeCount, files = Seq(outFile), additionalInfo = None)
  }

  private def encodePropertyValue(value: Any): String = {
    value match {
      case value: String =>
        val escaped = value
          .replace("""\""", """\\""") // escape escape chars - this should come first
          .replace("\"", "\\\"")      // escape double quotes, because we use them to enclose strings
        s"\"$escaped\""
      case list if iterableForList.isDefinedAt(list) =>
        val values = iterableForList(list).mkString(";")
        s"\"$values\""
      case value => value.toString
    }
  }

}
