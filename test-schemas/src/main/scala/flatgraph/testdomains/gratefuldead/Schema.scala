package flatgraph.testdomains.gratefuldead

import flatgraph.schema.SchemaBuilder

object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(
      domainShortName = "GratefulDead",
      basePackage = "flatgraph.testdomains.gratefuldead"
    )
    // new Schema(builder)
    // TODO
    builder.build
  }
}
