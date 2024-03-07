package flatgraph.formats.graphson

import flatgraph.formats.*
import flatgraph.formats.graphson.GraphSONProtocol.*
import flatgraph.{Accessors, GNode, Schema}
import spray.json.JsonWriter

import java.nio.file.Path
import java.util.concurrent.atomic.AtomicInteger
import scala.jdk.CollectionConverters.IterableHasAsScala

/** Exports to GraphSON 3.0 https://tinkerpop.apache.org/docs/3.4.1/dev/io/#graphson-3d0
  */
object GraphSONExporter extends Exporter {

  override def defaultFileExtension = "json"

  override def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[flatgraph.Edge], outputFile: Path) = {
    val outFile = resolveOutputFileSingle(outputFile, s"export.$defaultFileExtension")
    // flatgraph doesn't have edge IDs, so for GraphSON we generate them synthetically
    val propertyId = new AtomicInteger(0)
    val edgeId     = new AtomicInteger(0)

    val nodeEntries = nodes.iterator.map { node =>
      val properties = Accessors
        .getNodeProperties(node)
        .iterator
        .map { case (name, value) =>
          name -> Property(LongValue(propertyId.getAndIncrement()), valueEntry(value), "g:VertexProperty")
        }
        .toMap
      Vertex(LongValue(node.id), node.label, properties, "g:Vertex")
    }.toSeq

    val edgeEntries = edges.iterator.map { edge =>
      val inNode  = edge.dst
      val outNode = edge.src
      val propertiesMap: Map[String, Property] = Option(edge.property)
        .map { value =>
          Map("EdgeProperty" -> Property(LongValue(propertyId.getAndIncrement()), valueEntry(edge.property), "g:Property"))
        }
        .getOrElse(Map.empty)

      Edge(
        LongValue(edgeId.getAndIncrement),
        edge.label,
        inNode.label,
        outNode.label,
        LongValue(inNode.id),
        LongValue(outNode.id),
        propertiesMap,
        "g:Edge"
      )
    }.toSeq

    val graphSON = GraphSON(GraphSONElements(nodeEntries, edgeEntries), "tinker:graph")
    val json     = implicitly[JsonWriter[GraphSON]].write(graphSON)
    writeFile(outFile, json.prettyPrint)

    // TODO remove debug
    println(s"spray json: $outFile")
//    println(json.prettyPrint)

//    val json2 = upickle.default.write(graphSON, indent = 2)
//    val outFile2 = outFile.resolveSibling("export.ujson")
//    println(s"ujson: $outFile2")
//    writeFile(outFile2, json2)
//    println(json2)
    object picklers {

      import upickle.default.*

      given ReadWriter[LongValue] = readwriter[ujson.Value].bimap[LongValue](
        value => ujson.Obj("@type" -> value.`@type`, "@value" -> ujson.Num(value.`@value`)),
        json => LongValue(json("@value").num.toInt)
      )

      given ReadWriter[IntValue] = readwriter[ujson.Value].bimap[IntValue](
        value => ujson.Obj("@type" -> value.`@type`, "@value" -> ujson.Num(value.`@value`)),
        json => ???
      )
    }
    import picklers.given

    println(implicitly[JsonWriter[LongValue]].write(LongValue(32)))
    val written = upickle.default.write(LongValue(34))
    println(written)
    println(upickle.default.read[LongValue](written))
//    println(upickle.default.write(IntValue(35)))


    //    println(upickle.default.write(Vertex(), indent = 2))

//    println(upickle.default.write(GraphSON(
//      GraphSONElements(Seq.empty, Seq.empty), "tinker:graph"
//    ), indent = 2))

    ExportResult(nodeCount = nodeEntries.size, edgeCount = edgeEntries.size, files = Seq(outFile), Option.empty)
  }

  def valueEntry(propertyValue: Any): PropertyValue = {
    // Other types require explicit type definitions to be interpreted other than string or bool
    propertyValue match {
      case x: Array[_]              => ListValue(x.map(valueEntry))
      case x: Iterable[_]           => ListValue(x.map(valueEntry).toArray)
      case x: IterableOnce[_]       => ListValue(x.iterator.map(valueEntry).toArray)
      case x: java.lang.Iterable[_] => ListValue(x.asScala.map(valueEntry).toArray)
      case x: Boolean               => BooleanValue(x)
      case x: String                => StringValue(x)
      case x: Double                => DoubleValue(x)
      case x: Float                 => FloatValue(x)
      case x: Int                   => IntValue(x)
      case x: Long                  => LongValue(x)
      case x: GNode                 => NodeIdValue(x.id())
    }
  }

}
