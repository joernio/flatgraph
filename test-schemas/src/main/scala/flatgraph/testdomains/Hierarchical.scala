package flatgraph.testdomains

import flatgraph.schema.*

object Hierarchical {
  val schema: Schema = {
    val builder = new SchemaBuilder(domainShortName = "Hierarchical", basePackage = "testdomains.hierarchical")

    val name     = builder.addProperty("name", Property.ValueType.String).mandatory(default = "<empty>")
    val baseNode = builder.addNodeBaseType("base_node").addProperty(name)
    val nodeX    = builder.addNodeType("node_x").extendz(baseNode)
    val nodeY    = builder.addNodeType("node_y").extendz(baseNode)

    val connectedTo = builder.addEdgeType("connected_to")
    baseNode.addOutEdge(connectedTo, baseNode, stepNameOut = "connectedTo")

    builder.build
  }
}
