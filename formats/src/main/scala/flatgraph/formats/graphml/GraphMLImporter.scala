package flatgraph.formats.graphml

import flatgraph.formats.Importer
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.*

import java.nio.file.Path
import scala.collection.mutable
import scala.util.{Failure, Success, Try}
import scala.xml
import scala.xml.XML

/** Imports GraphML into flatgraph
  *
  * https://en.wikipedia.org/wiki/GraphML http://graphml.graphdrawing.org/primer/graphml-primer.html
  */
object GraphMLImporter extends Importer {

  override def runImport(graph: Graph, inputFiles: Seq[Path]): Unit = {
    assert(inputFiles.size == 1, s"input must be exactly one file, but got ${inputFiles.size}")
    val doc      = XML.loadFile(inputFiles.head.toFile)
    val graphXml = doc \ "graph"

    val graphmlNodes         = graphXml \ "node"
    val graphmlNodeIdToGNode = addNodesRaw(graphmlNodes, graph)

    val keyEntries = doc \ "key"
    val diffGraph  = new DiffGraphBuilder(graph.schema)

    // node properties
    val nodePropertyContextById = parsePropertyEntries("node", keyEntries)
    for {
      graphmlNode <- graphmlNodes
      nodeId = graphmlNode \@ "id"
      entry <- graphmlNode \ "data"
    } {
      entry \@ "key" match {
        case KeyForNodeLabel => // ignore, already extracted in `addNodesRaw`
        case key =>
          val propertyContext = nodePropertyContextById
            .get(key)
            .getOrElse(throw new AssertionError(s"key $key not found in propertyContext..."))
          val value          = entry.text
          val convertedValue = convertValue(value, propertyContext.tpe, context = graphmlNode)
          diffGraph.setNodeProperty(graphmlNodeIdToGNode(nodeId), propertyContext.name, convertedValue)
      }
    }

    // edges
    val edgePropertyContextById = parsePropertyEntries("edge", keyEntries)
    for (edge <- graphXml \ "edge") {
      addEdge(diffGraph, graphmlNodeIdToGNode, edge, edgePropertyContextById)
    }

    DiffGraphApplier.applyDiff(graph, diffGraph)
  }

  private def addNodesRaw(graphmlNodes: Seq[xml.Node], graph: Graph): Map[String, GNode] = {
    val diffGraphForRawNodes = new DiffGraphBuilder(graph.schema)
    val graphmlNodeIdToGNode = mutable.Map.empty[String, GenericDNode]
    graphmlNodes.foreach { graphmlNode =>
      val id = graphmlNode \@ "id"
      val label = (graphmlNode \ "data")
        .find(_ \@ "key" == KeyForNodeLabel)
        .map(_.text)
        .getOrElse(throw new AssertionError(s"node label must be defined, but isn't: $graphmlNode"))
      val nodeKind = graph.schema
        .getNodeKindByLabelMaybe(label)
        .getOrElse(
          throw new AssertionError(
            s"node label `$label` is not one of the labels defined in the schema, which are: [${graph.schema.nodeLabels.mkString(",")}]"
          )
        )
      val newNode = new GenericDNode(graph.schema.getNodeKindByLabel(label).toShortSafely)
      diffGraphForRawNodes.addNode(newNode)
      graphmlNodeIdToGNode.put(id, newNode)
    }
    DiffGraphApplier.applyDiff(graph, diffGraphForRawNodes)
    graphmlNodeIdToGNode.view.mapValues(_.storedRef.get).toMap
  }

  private def parsePropertyEntries(forElementType: String, keyEntries: xml.NodeSeq): Map[String, PropertyContext] = {
    keyEntries
      .filter(_ \@ "for" == forElementType)
      .map { node =>
        val id          = node \@ "id"
        val name        = node \@ "attr.name"
        val graphmlType = node \@ "attr.type"
        (id, PropertyContext(name, Type.withName(graphmlType)))
      }
      .toMap
  }

  private def addEdge(
    diffGraph: DiffGraphBuilder,
    graphmlNodeIdToGNode: Map[String, GNode],
    edge: xml.Node,
    propertyContextById: Map[String, PropertyContext]
  ): Unit = {
    val sourceId                                 = edge \@ "source"
    val targetId                                 = edge \@ "target"
    var label: Option[String]                    = None
    var edgePropertyMaybe: Option[(String, Any)] = None

    for (entry <- edge \ "data") {
      val value = entry.text
      entry \@ "key" match {
        case KeyForEdgeLabel => label = Option(value)
        case key =>
          val PropertyContext(name, tpe) = propertyContextById
            .get(key)
            .getOrElse(throw new AssertionError(s"key $key not found in propertyContext..."))
          val convertedValue = convertValue(value, tpe, context = edge)
          if (edgePropertyMaybe.isDefined) {
            logger.warn(
              s"flatgraph only supports 0..1 edge properties. This graphml edge has more than one properties though - taking only the first one... graphml node: $edge"
            )
          }
          edgePropertyMaybe = Some(name -> convertedValue)
      }
    }

    for {
      source <- graphmlNodeIdToGNode.get(sourceId)
      target <- graphmlNodeIdToGNode.get(targetId)
      label  <- label
      edgeProperty = edgePropertyMaybe.map(_._2).getOrElse(flatgraph.DefaultValue)
    } diffGraph.addEdge(source, target, label, edgeProperty)
  }

  private def convertValue(stringValue: String, tpe: Type.Value, context: xml.Node): Any = {
    tryConvertScalarValue(stringValue, tpe) match {
      case Success(value) => value
      case Failure(e)     => throw new AssertionError(s"unable to parse `$stringValue` of tpe=$tpe. context: $context", e)
    }
  }

  private def tryConvertScalarValue(stringValue: String, tpe: Type.Value): Try[Any] = {
    Try {
      tpe match {
        case Type.Boolean => stringValue.toBoolean
        case Type.Int     => stringValue.toInt
        case Type.Long    => stringValue.toLong
        case Type.Float   => stringValue.toLong
        case Type.Double  => stringValue.toDouble
        case Type.String  => stringValue
      }
    }
  }
}
