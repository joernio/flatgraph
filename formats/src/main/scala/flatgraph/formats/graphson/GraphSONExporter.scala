package flatgraph.formats.graphson

import com.fasterxml.jackson.core.{JsonEncoding, JsonFactory, JsonGenerator}
import flatgraph.formats.*
import flatgraph.{Accessors, GNode, Schema}

import java.io.BufferedOutputStream
import java.nio.file.{Files, Path}
import java.util.concurrent.atomic.AtomicLong
import scala.jdk.CollectionConverters.IterableHasAsScala
import scala.util.Using

/** Exports to GraphSON 3.0 https://tinkerpop.apache.org/docs/3.4.1/dev/io/#graphson-3d0
  *
  * Uses Jackson Core streaming API to avoid the spray-json PrettyPrinter bottleneck that builds the entire graph as a single
  * java.lang.String, causing OOM on large graphs.
  */
object GraphSONExporter extends Exporter {

  override def defaultFileExtension = "json"

  private val jsonFactory = new JsonFactory()

  override def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[flatgraph.Edge], outputFile: Path) = {
    val outFile    = resolveOutputFileSingle(outputFile, s"export.$defaultFileExtension")
    val propertyId = new AtomicLong(0)
    val edgeId     = new AtomicLong(0)
    var nodeCount  = 0
    var edgeCount  = 0

    Using.resource(new BufferedOutputStream(Files.newOutputStream(outFile))) { os =>
      Using.resource(jsonFactory.createGenerator(os, JsonEncoding.UTF8)) { gen =>
        gen.useDefaultPrettyPrinter()

        gen.writeStartObject()
        gen.writeFieldName("@value")
        gen.writeStartObject()

        gen.writeFieldName("vertices")
        gen.writeStartArray()
        nodes.iterator.foreach { node =>
          nodeCount += 1
          writeVertex(gen, node, propertyId)
        }
        gen.writeEndArray()

        gen.writeFieldName("edges")
        gen.writeStartArray()
        edges.iterator.foreach { edge =>
          edgeCount += 1
          writeEdge(gen, edge, propertyId, edgeId)
        }
        gen.writeEndArray()

        gen.writeEndObject() // @value
        gen.writeStringField("@type", "tinker:graph")
        gen.writeEndObject() // root
      }
    }

    ExportResult(nodeCount = nodeCount, edgeCount = edgeCount, files = Seq(outFile), Option.empty)
  }

  private def writeVertex(gen: JsonGenerator, node: GNode, propertyId: AtomicLong): Unit = {
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, node.id)
    gen.writeStringField("label", node.label)
    gen.writeFieldName("properties")
    gen.writeStartObject()
    Accessors.getNodeProperties(node).iterator.foreach { case (name, value) =>
      gen.writeFieldName(name)
      writeProperty(gen, propertyId.getAndIncrement(), valueEntry(value), "g:VertexProperty")
    }
    gen.writeEndObject()
    gen.writeStringField("@type", "g:Vertex")
    gen.writeEndObject()
  }

  private def writeEdge(gen: JsonGenerator, edge: flatgraph.Edge, propertyId: AtomicLong, edgeId: AtomicLong): Unit = {
    val inNode  = edge.dst
    val outNode = edge.src
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, edgeId.getAndIncrement())
    gen.writeStringField("label", edge.label)
    gen.writeStringField("inVLabel", inNode.label)
    gen.writeStringField("outVLabel", outNode.label)
    gen.writeFieldName("inV")
    writeLongValue(gen, inNode.id)
    gen.writeFieldName("outV")
    writeLongValue(gen, outNode.id)
    gen.writeFieldName("properties")
    gen.writeStartObject()
    Option(edge.property).foreach { value =>
      gen.writeFieldName("EdgeProperty")
      writeProperty(gen, propertyId.getAndIncrement(), valueEntry(value), "g:Property")
    }
    gen.writeEndObject()
    gen.writeStringField("@type", "g:Edge")
    gen.writeEndObject()
  }

  private def writeProperty(gen: JsonGenerator, id: Long, value: PropertyValue, typeStr: String): Unit = {
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, id)
    gen.writeFieldName("@value")
    writePropertyValue(gen, value)
    gen.writeStringField("@type", typeStr)
    gen.writeEndObject()
  }

  private def writeLongValue(gen: JsonGenerator, v: Long): Unit = {
    gen.writeStartObject()
    gen.writeNumberField("@value", v)
    gen.writeStringField("@type", "g:Int64")
    gen.writeEndObject()
  }

  private def writePropertyValue(gen: JsonGenerator, pv: PropertyValue): Unit = pv match {
    case StringValue(v, _)  => gen.writeString(v)
    case BooleanValue(v, _) => gen.writeBoolean(v)
    case LongValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Int64")
      gen.writeEndObject()
    case IntValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Int32")
      gen.writeEndObject()
    case FloatValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Float")
      gen.writeEndObject()
    case DoubleValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Double")
      gen.writeEndObject()
    case NodeIdValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:VertexId")
      gen.writeEndObject()
    case ListValue(elements, _) =>
      gen.writeStartObject()
      gen.writeFieldName("@value")
      gen.writeStartArray()
      elements.foreach(writePropertyValue(gen, _))
      gen.writeEndArray()
      gen.writeStringField("@type", "g:List")
      gen.writeEndObject()
    case unsupported =>
      throw new IllegalArgumentException(s"unsupported propertyValue: $unsupported")
  }

  def valueEntry(propertyValue: Any): PropertyValue = {
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
