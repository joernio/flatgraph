package flatgraph.codegen

object DomainClassesGeneratorCodescience {

  def main(args: Array[String]): Unit = {
    new DomainClassesGenerator(io.shiftleft.codepropertygraph.schema.CpgExtSchema.instance).main(args)
  }
}
