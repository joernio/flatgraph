package flatgraph.codegen

import java.nio.file.Path
import flatgraph.schema.Schema
import scopt.OParser

object Main {
  case class Config(
    classWithSchema: String,
    fieldName: String,
    outputDir: Path,
    disableScalafmt: Boolean = false,
    scalafmtConfig: Option[Path] = None
  )

  def main(args: Array[String]) = {
    val builder = OParser.builder[Config]
    val parser = {
      import builder._
      OParser.sequence(
        programName("codegen"),
        opt[String]('c', "classWithSchema")
          .required()
          .action((x, c) => c.copy(classWithSchema = x))
          .text("class with schema field, e.g. `org.example.MyDomain$`"),
        opt[String]('f', "field")
          .required()
          .action((x, c) => c.copy(fieldName = x))
          .text("(static) field name for schema within the specified `classWithSchema` with schema field, e.g. `org.example.MyDomain$`"),
        opt[Path]('o', "out")
          .required()
          .action((x, c) => c.copy(outputDir = x))
          .text("output directory"),
        opt[Unit]("noformat")
          .action((x, c) => c.copy(disableScalafmt = true))
          .text("disable scalafmt formatting"),
        opt[Path]("scalafmtConfig")
          .valueName(".scalafmt")
          .action((x, c) => c.copy(scalafmtConfig = Option(x)))
          .text("path to scalafmt config file (e.g. .scalafmt)")
      )
    }

    OParser.parse(parser, args, Config("", "", null)).foreach(execute)

    def execute(config: Config): Seq[Path] = config match {
      case Config(classWithSchema, fieldName, outputDir, disableScalafmt, scalafmtConfig) =>
        val classLoader = getClass.getClassLoader
        val clazz       = classLoader.loadClass(classWithSchema)
        val field       = clazz.getDeclaredField(fieldName)
        assert(
          field.getType == classOf[Schema],
          s"field $fieldName in class `$classWithSchema` must be of type `flatgraph.schema.Schema`, but actually is of type `${field.getType}`"
        )
        field.setAccessible(true)
        val companionObject = clazz.getField("MODULE$").get(null)
        val schema          = field.get(companionObject).asInstanceOf[Schema]

        val codegen = new DomainClassesGenerator(schema)
        if (disableScalafmt) codegen.disableScalafmt
        scalafmtConfig.foreach(codegen.withScalafmtConfig)
        codegen.run(outputDir)
    }
  }
}
