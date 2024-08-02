package flatgraph.testdomains

import flatgraph.schema.*

/** Just to ensure that users can start with a blank page without any compiler errors or warnings in the generated domain classes
  */
object Empty {
  val schema: Schema = {
    val builder = new SchemaBuilder(domainShortName = "Empty", basePackage = "testdomains.empty")

    builder.build
  }
}
