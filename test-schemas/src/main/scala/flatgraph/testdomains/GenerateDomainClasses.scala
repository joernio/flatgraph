package flatgraph.testdomains

import flatgraph.codegen.DomainClassesGenerator

object GenerateDomainClasses {
  val allSchemas = Seq(GratefulDead.schema, Generic.schema, Hierarchical.schema, CodePropertyGraphMinified.schema, Empty.schema)

  def main(args: Array[String]): Unit = {
    val outputDir = "test-schemas-domain-classes/src/main/scala"

    allSchemas.foreach { schema =>
      new DomainClassesGenerator(schema).run(java.nio.file.Paths.get(outputDir))
    }
  }
}

object GenerateDomainClassesScala3 {
  def main(args: Array[String]): Unit = {
    val outputDir = "test-schemas-domain-classes-scala3/src/main/scala"

    GenerateDomainClasses.allSchemas.foreach { schema =>
      new DomainClassesGenerator(schema).withScala3Features.run(java.nio.file.Paths.get(outputDir))
    }
  }
}
