package flatgraph.formats.dot

import flatgraph.formats.{ExportResult, Exporter, iterableForList, resolveOutputFileSingle}
import flatgraph.{Accessors, Edge, GNode, Schema}

import java.nio.file.{Files, Path}
import org.apache.commons.text.StringEscapeUtils
import org.apache.commons.text.translate.LookupTranslator

import java.util.Collections
import scala.jdk.CollectionConverters.MapHasAsJava
import scala.util.Using

/** Exports flatgraph to graphviz dot/gv file
  *
  * Note: GraphML doesn't natively support list property types, so we fake it by encoding it as a `;` delimited string. If you import this
  * into a different database, you'll need to parse that separately.
  *
  * Export rules for dot format as per https: //github.com/joernio/joern/issues/5158
  * 1) If the attribute value contains special characters such as spaces,<,>,=, etc., it must be enclosed in double quotation marks.
  * Otherwise, it will cause syntax errors.
  * 2) Graphviz requires that the node ID must be a valid identifier. If the node ID is a pure number (such as 120259084301),
  * it needs to be enclosed in double quotation marks, otherwise it will be mistaken for an integer constant.
  * 3) The attribute value contains special characters such as(such as CODE=""), which need to be enclosed in quotation marks or escaped in some cases.
  * 4) In Graphviz's. dot file, it is best to use semicolons for each node definition, edge definition, and attribute definition; ending. Your file is missing semicolons.
  *
  * https://en.wikipedia.org/wiki/DOT_(graph_description_language) https://www.graphviz.org/doc/info/lang.html
  * http://magjac.com/graphviz-visual-editor/ https://www.slideshare.net/albazo/graphiz-using-the-dot-language
  */
object DotExporter extends Exporter {
  override def defaultFileExtension = "dot"
  val EndOfLine = ';'

  private val lookupMap = Map(
    """\""" -> """\\""", // \ -> \\
    "\"" -> """\"""",    // " -> \"
  )
  val translator = new LookupTranslator(Collections.unmodifiableMap(lookupMap.asJava))

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
          .append(s""""${node.id}" """)
          .append(s"""[label="${node.label}" """)
          .append(
            Accessors
              .getNodeProperties(node)
              .iterator
              .map { case (key, value) =>
                s"""$key="${encodePropertyValue(value)}""""
              }
              .mkString(" ")
          )
          .append("]")
          .append(EndOfLine)
        writeLine(line.toString)
      }

      edges.iterator.foreach { edge =>
        edgeCount += 1
        val propertyMaybe = Option(edge.property).map(property => s"""property="${encodePropertyValue(property)}"""").getOrElse("")
        val line = new StringBuffer()
          .append(s"""  "${edge.src.id()}" -> "${edge.dst.id()}"""")
          .append(s""" [label="${edge.label}" $propertyMaybe]""")
          .append(EndOfLine)
        writeLine(line.toString)
      }

      writeLine("}")
    }

    ExportResult(nodeCount = nodeCount, edgeCount = edgeCount, files = Seq(outFile), additionalInfo = None)
  }

  private def encodePropertyValue(value: Any): String = {
    value match {
      case value: String =>
        StringEscapeUtils.builder(translator).escape(value).toString
      case list if iterableForList.isDefinedAt(list) =>
        iterableForList(list).map(encodePropertyValue).mkString(";")
      case value => value.toString
    }
  }

}
