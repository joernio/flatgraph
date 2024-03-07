package flatgraph.formats.graphson

import flatgraph.formats.Importer
import flatgraph.formats.graphson.GraphSONProtocol.*
import flatgraph.misc.ConversionException
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.*
import spray.json.*

import java.nio.file.Path
import scala.collection.mutable
import scala.io.Source.fromFile
import scala.util.Using

/** Imports from GraphSON 3.0 https://tinkerpop.apache.org/docs/3.4.1/dev/io/#graphson-3d0
  */
object GraphSONImporter extends Importer {

  override def runImport(graph: Graph, inputFiles: Seq[Path]): Unit = {
    assert(inputFiles.size == 1, s"input must be exactly one file, but got ${inputFiles.size}")
    Using.resource(fromFile(inputFiles.head.toFile)) { source =>
      val graphSON = source.mkString.parseJson.convertTo[GraphSON]

      val graphsonNodes         = graphSON.`@value`.vertices
      val graphsonNodeIdToGNode = addNodesRaw(graphsonNodes, graph)

      val diffGraph = new DiffGraphBuilder(graph.schema)
      // add vertex properties
      graphSON.`@value`.vertices.foreach { graphsonNode =>
        val graphsonNodeId = graphsonNode.id.`@value`
        lazy val gNode     = lookupGNode(graphsonNodeId, graphsonNodeIdToGNode)
        graphsonNode.properties.foreach { case (name, property) =>
          diffGraph.setNodeProperty(gNode, name, extractPropertyValue(property, graphsonNodeIdToGNode))
        }
      }

      graphSON.`@value`.edges.foreach { edge =>
        val src = lookupGNode(edge.outV.`@value`, graphsonNodeIdToGNode)
        val tgt = lookupGNode(edge.inV.`@value`, graphsonNodeIdToGNode)
        diffGraph.addEdge(src, tgt, edge.label, flattenProperties(edge.properties, graphsonNodeIdToGNode))
      }
      DiffGraphApplier.applyDiff(graph, diffGraph)
    }
  }

  private def addNodesRaw(graphsonNodes: Seq[Vertex], graph: Graph): Map[Long, GNode] = {
    val diffGraphForRawNodes  = new DiffGraphBuilder(graph.schema)
    val graphsonNodeIdToGNode = mutable.Map.empty[Long, GenericDNode]
    graphsonNodes.foreach { graphsonNode =>
      val newNode = new GenericDNode(graph.schema.getNodeKindByLabel(graphsonNode.label).toShortSafely)
      diffGraphForRawNodes.addNode(newNode)
      graphsonNodeIdToGNode.put(graphsonNode.id.`@value`, newNode)
    }
    DiffGraphApplier.applyDiff(graph, diffGraphForRawNodes)
    graphsonNodeIdToGNode.view.mapValues(_.storedRef.get).toMap
  }

  private def lookupGNode(graphsonNodeId: Long, graphsonNodeIdToGNode: Map[Long, GNode]) =
    graphsonNodeIdToGNode.get(graphsonNodeId).getOrElse(throw new ConversionException(s"node with id=$graphsonNodeId not found in graph"))

  private def extractPropertyValue(property: Property, graphsonNodeIdToGNode: Map[Long, GNode]): Any = {
    def handleSingle(value: PropertyValue): Any = {
      value match {
        case NodeIdValue(value, _) => lookupGNode(value, graphsonNodeIdToGNode)
        case value                 => value.`@value`
      }
    }

    // handle list
    property.`@value` match {
      case ListValue(values, _) => values.map(handleSingle)
      case value                => handleSingle(value)
    }
  }

  /** flatgraph can only store a single edge property - that however may be a list... */
  private def flattenProperties(properties: Map[String, Property], graphsonNodeIdToGNode: Map[Long, GNode]): Any = {
    properties.view
      .map(_._2.`@value`)
      .map {
        case ListValue(value, _)   => value.map(_.`@value`)
        case NodeIdValue(value, _) => lookupGNode(value, graphsonNodeIdToGNode)
        case x                     => x.`@value`
      }
      .toList match {
      case Nil               => null
      case List(singleValue) => singleValue
      case multipleValues    => multipleValues
    }
  }

}
