package flatgraph.testdomains

import flatgraph.codegen.DomainClassesGenerator

object GenerateDomainClasses {
  def main(args: Array[String]): Unit = {
    val outputDir = "test-schemas-domain-classes/src/main/scala"

    Seq(GratefulDead.schema, Generic.schema, Hierarchical.schema, CodePropertyGraphMinified.schema, Empty.schema).foreach { schema =>
      new DomainClassesGenerator(schema).run(java.nio.file.Paths.get(outputDir))

      // this also works...
      // flatgraph.codegen.Main.main(Array(
      //   "--classWithSchema", "flatgraph.testdomains.gratefuldead.Schema$",
      //   "--field", "instance",
      //   "--out", "test-schemas-domain-classes/src/main/scala"
      // ))
    }
  }
}
