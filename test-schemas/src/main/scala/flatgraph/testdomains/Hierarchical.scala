package flatgraph.testdomains

import flatgraph.schema.*

object Hierarchical {
  val schema: Schema = {
    val builder = new SchemaBuilder(domainShortName = "Hierarchical", basePackage = "testdomains.hierarchical")

    val name = builder.addProperty("name", Property.ValueType.String).mandatory(default = "<empty>")
    val baseNode = builder.addNodeBaseType("base_node").addProperty(name)
    val nodeA = builder.addNodeType("node_a").extendz(baseNode)
    val nodeB = builder.addNodeType("node_b").extendz(baseNode)

    val connectedTo = builder.addEdgeType("connected_to")
    baseNode.addOutEdge(connectedTo, baseNode, stepNameOut = "connectedTo")

    builder.build
  }
}
