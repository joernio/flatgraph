import flatgraph.codegen.DomainClassesGenerator
import flatgraph.schema.{Schema, SchemaBuilder}
import io.shiftleft.codepropertygraph.schema.CpgSchema

object Main {
  def main(args: Array[String]): Unit = {
    val schema = CpgSchema.instance
    val codegen = new DomainClassesGenerator(schema)
    val outputDir = "joern-generated/src/main/scala"
    codegen.run(java.nio.file.Paths.get(outputDir))

    // this also works...
    // flatgraph.codegen.Main.main(Array(
    //   "--classWithSchema", "io.shiftleft.codepropertygraph.schema.CpgSchema$",
    //   "--field", "instance",
    //   "--out", "joern-generated/src/main/scala"
    // ))
  }
}
