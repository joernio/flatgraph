package flatgraph.codegen

import java.nio.file.{Files, Path, Paths}
import org.scalafmt.interfaces.Scalafmt
import scala.util.Try

object Formatter {
  val defaultScalafmtConfig: String = {
    Try {
      os.read(os.pwd / ".scalafmt.conf")
    }.toOption.getOrElse("""version=3.7.12
        |runner.dialect=scala3
        |preset = IntelliJ
        |maxColumn=140
        |align.preset=true
        |""".stripMargin)
  }

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
