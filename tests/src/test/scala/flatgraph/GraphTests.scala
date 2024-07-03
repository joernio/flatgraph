package flatgraph

import flatgraph.misc.SchemaViolationReporter
import flatgraph.testutils.TestHelpers
import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.generic.GenericDomain
import testdomains.generic.language.*
import testdomains.generic.nodes.{NewNodeA, NewNodeB, NodeA}

import scala.jdk.CollectionConverters.MapHasAsScala

class GraphTests extends AnyWordSpec with MockFactory {

  "node property: log warning for schema-unconform property usage" in {
    // unknown node properties often root in deserialising an old storage format,
    // so we don't want to error out but rather log a warning
    val genericDomain     = GenericDomain.empty
    val graph             = genericDomain.graph
    val schema            = graph.schema
    val Seq(nodeA, nodeB) = TestHelpers.addNodes(graph, Seq(NewNodeA(), NewNodeB()))

    val mockSchemaViolationReporter = mock[SchemaViolationReporter]
    mockSchemaViolationReporter.illegalNodeProperty.expects(nodeA.nodeKind: Int, "UNKNOWN", schema)
    mockSchemaViolationReporter.illegalNodeProperty.expects(nodeA.nodeKind: Int, 999, schema)
    mockSchemaViolationReporter.illegalNodeProperty.expects(nodeB.nodeKind: Int, NodeA.Properties.IntOptional.kind, schema)
    mockSchemaViolationReporter.illegalNodeProperty.expects(nodeB.nodeKind: Int, 998, schema)

    val setProperties = new DiffGraphBuilder(schema, mockSchemaViolationReporter)
      // this is fine
      .setNodeProperty(nodeA, NodeA.PropertyNames.IntOptional, 100)
      // these are not schema conform...
      .setNodeProperty(nodeA, "UNKNOWN", "value1")
      ._setNodeProperty(nodeA, 999, "value2")
      .setNodeProperty(nodeB, NodeA.PropertyNames.IntOptional, 101)
      ._setNodeProperty(nodeB, 998, 102)
    new DiffGraphApplier(graph, setProperties, mockSchemaViolationReporter).applyUpdate()

    genericDomain.nodeA.head.propertiesMap.asScala shouldBe Map("int_optional" -> 100)
    genericDomain.nodeB.head.propertiesMap.asScala shouldBe Map()
  }

}
