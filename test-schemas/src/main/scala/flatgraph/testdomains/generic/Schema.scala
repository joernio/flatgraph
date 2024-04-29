package flatgraph.testdomains.generic

import flatgraph.schema.Property.ValueType
import flatgraph.schema.SchemaBuilder

/** Simple generic schema */
object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(domainShortName = "GenericDomain", basePackage = "flatgraph.testdomains.generic")

    // properties
    val stringMandatory = builder.addProperty("string_mandatory", ValueType.String).mandatory(default = "<empty>")
    val stringOptional  = builder.addProperty("string_optional", ValueType.String)
    val stringList      = builder.addProperty("string_list", ValueType.String).asList()
    val intMandatory    = builder.addProperty("int_mandatory", ValueType.Int).mandatory(default = 42)
    val intOptional     = builder.addProperty("int_optional", ValueType.Int)
    val intList         = builder.addProperty("int_list", ValueType.Int).asList()

    val nodeA = builder
      .addNodeType("node_a")
      .addProperty(stringMandatory)
      .addProperty(stringOptional)
      .addProperty(stringList)
      .addProperty(intMandatory)
      .addProperty(intOptional)
      .addProperty(intList)

    // TODO add support for edge properties with cardinality ONE and LIST
    val connectedTo = builder.addEdgeType("connected_to").addProperty(stringMandatory)
    nodeA.addOutEdge(connectedTo, nodeA, stepNameOut = "connectedTo")

    builder.build
  }
}
