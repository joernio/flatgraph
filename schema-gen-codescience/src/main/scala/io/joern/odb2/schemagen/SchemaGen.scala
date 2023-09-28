package io.joern.odb2.schemagen

object SchemaGenCodescienceMain {

  def main(args: Array[String]): Unit = {
    new SchemaGen(io.shiftleft.codepropertygraph.schema.CpgExtSchema.instance).main(args)
  }
}
