import flatgraph.codegen.DomainClassesGenerator
import flatgraph.testdomains.gratefuldead

object Main {
  def main(args: Array[String]): Unit = {
    val schema    = gratefuldead.Schema.instance
    val codegen   = new DomainClassesGenerator(schema)
    val outputDir = "test-schemas-domain-classes/src/main/scala"
    codegen.run(java.nio.file.Paths.get(outputDir))

    // this also works...
    // flatgraph.codegen.Main.main(Array(
    //   "--classWithSchema", "flatgraph.testdomains.gratefuldead.Schema$",
    //   "--field", "instance",
    //   "--out", "test-schemas-domain-classes/src/main/scala"
    // ))
  }
}
