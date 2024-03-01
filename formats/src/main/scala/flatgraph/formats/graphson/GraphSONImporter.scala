package flatgraph.formats.graphson

import flatgraph.formats.Importer
import flatgraph.formats.graphson.GraphSONProtocol.*
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.misc.TestUtils.applyDiff
import flatgraph.{GenericDNode, Graph}
import spray.json.*

import java.nio.file.Path
import scala.io.Source.fromFile
import scala.util.Using

/** Imports from GraphSON 3.0
  * https://tinkerpop.apache.org/docs/3.4.1/dev/io/#graphson-3d0
  */
object GraphSONImporter extends Importer {

  override def runImport(graph: Graph, inputFiles: Seq[Path]): Unit = {
    assert(inputFiles.size == 1, s"input must be exactly one file, but got ${inputFiles.size}")
    Using.resource(fromFile(inputFiles.head.toFile)) { source =>
      val graphSON = source.mkString.parseJson.convertTo[GraphSON]
      graphSON.`@value`.vertices.foreach(n => addNode(n, graph))
      graphSON.`@value`.edges.foreach(e => addEdge(e, graph))
    }
  }

  private def addNode(vertex: Vertex, graph: Graph): Unit = {
    val schema = graph.schema

    val dnode = new GenericDNode(schema.getNodeKindByLabel(vertex.label).toShortSafely)
    // todo: store the graphson id as a node property: vertex.id
    graph.applyDiff(_.addNode(dnode))
    val gnode = dnode.storedRef.get

    if (vertex.properties.nonEmpty) {
      graph.applyDiff { builder =>
        vertex.properties.foreach { case (name, property) =>
          builder.setNodeProperty(gnode, name, extractPropertyValue(property))
        }
      }
    }
  }

  private def extractPropertyValue(property: Property): Any = {
    property.`@value` match {
      case ListValue(value, _)   => value.map(_.`@value`)
      case NodeIdValue(value, _) => ??? // graph.node(value) // TODO
      case x                     => x.`@value`
    }
  }

  private def flattenProperties(m: Map[String, Property], graph: Graph): Array[_] = {
    // TODO reimplement or drop
    ???
//    m.view
//      .mapValues { v =>
//        v.`@value` match {
//          case ListValue(value, _)   => value.map(_.`@value`)
//          case NodeIdValue(value, _) => graph.node(value)
//          case x                     => x.`@value`
//        }
//      }
//      .flatMap { case (k, v) => Seq(k, v) }
//      .toArray
  }

  private def addEdge(edge: Edge, graph: Graph): Unit = {
    val src = graph.node(edge.outV.`@value`)
    val tgt = graph.node(edge.inV.`@value`)
    // TODO we need to store the ids from graphml in a graph property and look them up here
//    src.addEdge(e.label, tgt, flattenProperties(e.properties, graph): _*)
    ???
  }
}
