package flatgraph.codegen

import java.nio.file.Path
import org.scalafmt.interfaces.Scalafmt

object Formatter {
  val defaultScalafmtConfig = """
      |version=3.7.11
      |runner.dialect=scala3
      |align.preset=some
      |maxColumn=120
      |""".stripMargin

  def run(sourceFiles: Seq[Path], scalafmtConfig: Option[Path]): Unit = {
    // println(s"invoking scalafmt on ${sourceFiles.size} files")
    val configFile: Path =
      scalafmtConfig.getOrElse(os.temp(contents = defaultScalafmtConfig, prefix = "flatgraph-scalafmt", suffix = ".conf").toNIO)

    val scalafmt        = Scalafmt.create(getClass.getClassLoader)
    val scalafmtSession = scalafmt.createSession(configFile)

    sourceFiles.foreach { file =>
      val osPath          = os.Path(file.toFile)
      val originalSource  = os.read(osPath)
      val formattedSource = scalafmtSession.format(file, originalSource)
      os.write.over(osPath, formattedSource)
    }
  }

}
