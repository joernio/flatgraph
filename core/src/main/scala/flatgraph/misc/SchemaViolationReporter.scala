package flatgraph.misc

import flatgraph.Schema
import org.slf4j.LoggerFactory

import scala.collection.mutable

/** Illegal usage of node properties often roots in deserialising an old storage format, so we don't want to error out but rather log a
  * warning, and only do so once for each node/property combination.
  */
class SchemaViolationReporter {
  private val logger                 = LoggerFactory.getLogger(getClass)
  private val loggedSchemaViolations = mutable.Set.empty[(Int, String | Int)] // (NodeKind, PropertyLabel|PropertyKind)

  def illegalNodeProperty(nodeKind: Int, propertyIdentifier: String | Int, schema: Schema): Unit = {
    if (loggedSchemaViolations.contains((nodeKind, propertyIdentifier))) {
      val contextBuilder = Seq.newBuilder[String]

      contextBuilder += s"nodeKind=$nodeKind"
      schema.getNodeLabelMaybe(nodeKind).foreach { nodeLabel =>
        contextBuilder += s",nodeLabel=$nodeLabel"
      }
      propertyIdentifier match {
        case name: String =>
          contextBuilder += s",propertyName=$name"
        case kind: Int =>
          contextBuilder += s",propertyKind=$kind"
          schema.getPropertyLabelMaybe(nodeKind, kind).foreach { name =>
            contextBuilder += s",propertyName=$name"
          }
      }
      val context = contextBuilder.result().mkString(",")
      logger.warn(s"""Unsupported (deprecated?) property on node: $context""")
      loggedSchemaViolations.addOne((nodeKind, propertyIdentifier))
    }
  }

}
