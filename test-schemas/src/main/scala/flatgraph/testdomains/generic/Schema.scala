package flatgraph.testdomains.generic

import flatgraph.schema.Property.ValueType
import flatgraph.schema.SchemaBuilder

/** Simple generic schema */
object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(domainShortName = "GenericDomain", basePackage = "flatgraph.testdomains.generic")

    // properties
    val stringMandatory = builder.addProperty("stringMandatory", ValueType.String).mandatory(default = "<empty>")
    val stringOptional  = builder.addProperty("stringOptional", ValueType.String)
    val stringList      = builder.addProperty("stringList", ValueType.String).asList()
    val intMandatory    = builder.addProperty("intMandatory", ValueType.Int).mandatory(default = 42)
    val intOptional     = builder.addProperty("intOptional", ValueType.Int)
    val intList         = builder.addProperty("intList", ValueType.Int).asList()

    val nodeA = builder
      .addNodeType("node_a")
      .addProperty(stringMandatory)
      .addProperty(stringOptional)
      .addProperty(stringList)
      .addProperty(intMandatory)
      .addProperty(intOptional)
      .addProperty(intList)

    val connectedTo =
      builder.addEdgeType("connectedTo").addProperty(stringMandatory) // TODO implement properties with cardinality ONE and LIST
    nodeA.addOutEdge(connectedTo, nodeA, stepNameOut = "connectedTo")

    builder.build
  }
}
