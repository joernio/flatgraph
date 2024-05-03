package flatgraph.formats.graphml

import flatgraph.formats.{ExportResult, Exporter, isList, resolveOutputFileSingle, writeFile}
import flatgraph.{Accessors, Edge, FormalQtyType, GNode, Schema}

import java.lang.System.lineSeparator
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.mutable
import scala.xml.{PrettyPrinter, XML}

/** Exports to GraphML
  *
  * Warning: list properties are not natively supported by graphml... We initially built some support for those which deviated from the
  * spec, but given that other tools don't support it and the complications re re-importing, we also dropped support for lists. Now, lists
  * are dropped and we print a warning.
  *
  * https://en.wikipedia.org/wiki/GraphML http://graphml.graphdrawing.org/primer/graphml-primer.html
  */
object GraphMLExporter extends Exporter {

  override def defaultFileExtension = "xml"

  override def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[Edge], outputFile: Path) = {
    val outFile                    = resolveOutputFileSingle(outputFile, s"export.$defaultFileExtension")
    val nodePropertyContextById    = mutable.Map.empty[String, PropertyContext]
    val edgePropertyContextById    = mutable.Map.empty[String, PropertyContext]
    val discardedListPropertyCount = new AtomicInteger(0)

    val nodeEntries = nodes.iterator.map { node =>
      val properties = schema.propertyKinds.flatMap { propertyKind =>
        val graph    = node.graph
        val nodeKind = node.nodeKind
        val nodeSeq  = node.seq()
        val valueMaybe = schema.getNodePropertyFormalQuantity(nodeKind, propertyKind) match {
          case FormalQtyType.QtyNone =>
            None
          case FormalQtyType.QtyOne | FormalQtyType.QtyOption =>
            Accessors.getNodePropertyOption[Object](graph, nodeKind, propertyKind, nodeSeq)
          case FormalQtyType.QtyMulti =>
            Option(Accessors.getNodePropertyMulti[Object](graph, nodeKind, propertyKind, nodeSeq)).filter(_.nonEmpty).flatMap { p =>
              // as per class scaladoc: we want to skip list properties, but keep track so we can later inform the user about it...
              discardedListPropertyCount.incrementAndGet()
              None
            }
        }
        valueMaybe.map { value =>
          schema.getPropertyLabel(nodeKind, propertyKind) -> value
        }
      }
      s"""<node id="${node.id}">
         |    <data key="$KeyForNodeLabel">${node.label}</data>
         |    ${dataEntries("node", node.label(), properties, nodePropertyContextById, discardedListPropertyCount)}
         |</node>
         |""".stripMargin
    }.toSeq

    val edgeEntries = edges.iterator.map { edge =>
      val property = // edges can have 0 or 1 properties
        if (edge.property == null) Nil
        else List("property" -> edge.property)
      s"""<edge source="${edge.src.id()}" target="${edge.dst.id()}">
         |    <data key="$KeyForEdgeLabel">${edge.label}</data>
         |    ${dataEntries("edge", edge.label, property, edgePropertyContextById, discardedListPropertyCount)}
         |</edge>
         |""".stripMargin
    }.toSeq

    def propertyKeyXml(forAttr: String, propsMap: mutable.Map[String, PropertyContext]): String = {
      propsMap
        .map { case (key, PropertyContext(name, tpe)) =>
          s"""<key id="$key" for="$forAttr" attr.name="$name" attr.type="$tpe"></key>"""
        }
        .mkString(lineSeparator)
    }
    val nodePropertyKeyEntries = propertyKeyXml("node", nodePropertyContextById)
    val edgePropertyKeyEntries = propertyKeyXml("edge", edgePropertyContextById)

    val xml = s"""
       |<?xml version="1.0" encoding="UTF-8"?>
       |<graphml xmlns="http://graphml.graphdrawing.org/xmlns"
       |  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       |  xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd">
       |    <key id="$KeyForNodeLabel" for="node" attr.name="$KeyForNodeLabel" attr.type="string"></key>
       |    <key id="$KeyForEdgeLabel" for="edge" attr.name="$KeyForEdgeLabel" attr.type="string"></key>
       |    $nodePropertyKeyEntries
       |    $edgePropertyKeyEntries
       |    <graph id="G" edgedefault="directed">
       |      ${nodeEntries.mkString(lineSeparator)}
       |      ${edgeEntries.mkString(lineSeparator)}
       |    </graph>
       |</graphml>
       |""".stripMargin.trim
    writeFile(outFile, xml)
    xmlFormatInPlace(outFile)

    val additionalInfo =
      Some(discardedListPropertyCount.get)
        .filter(_ > 0)
        .map { count =>
          s"warning: discarded $count list properties (because they are not supported by the graphml spec)"
        }

    ExportResult(nodeCount = nodeEntries.size, edgeCount = edgeEntries.size, files = Seq(outFile), additionalInfo)
  }

  /** warning: updates type information based on runtime instances (in mutable.Map `propertyTypeByName`) warning2: updated the
    * `discardedListPropertyCount` counter - if we need to discard any list properties, display a warning to the user
    */
  private def dataEntries(
    prefix: String,
    elementLabel: String,
    properties: IterableOnce[(String, Any)],
    propertyContextById: mutable.Map[String, PropertyContext],
    discardedListPropertyCount: AtomicInteger
  ): String = {
    properties.iterator
      .map { case (propertyName, propertyValue) =>
        if (isList(propertyValue.getClass)) {
          discardedListPropertyCount.incrementAndGet()
          ""     // discard list properties
        } else { // scalar value
          val encodedPropertyName = s"${prefix}__${elementLabel}__$propertyName"
          val graphMLTpe          = Type.fromRuntimeClass(propertyValue.getClass)

          /* update type information based on runtime instances */
          if (!propertyContextById.contains(encodedPropertyName)) {
            propertyContextById.update(encodedPropertyName, PropertyContext(propertyName, graphMLTpe))
          }
          val xmlEncoded = xml.Utility.escape(propertyValue.toString)
          s"""<data key="$encodedPropertyName">$xmlEncoded</data>"""
        }
      }
      .mkString(lineSeparator)
  }

  private def xmlFormatInPlace(xmlFile: Path): Unit = {
    val xml           = XML.loadFile(xmlFile.toFile)
    val prettyPrinter = new PrettyPrinter(120, 2)
    val formatted     = prettyPrinter.format(xml)
    writeFile(xmlFile, formatted)
  }

}
