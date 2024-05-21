package flatgraph.codegen.sbt

import org.scalafmt.sbt.ScalafmtPlugin
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtConfig
import sbt.plugins.JvmPlugin
import sbt._
import sbt.Keys._

import scala.util.Try

object FlatgraphCodegenSbtPlugin extends AutoPlugin {

  object autoImport {
    val generateDomainClasses = taskKey[File]("regenerates domain classes for the given schema; return value is the output root directory")
    val generateDomainClassesCheck = taskKey[Unit](
      "Fails if domain classes are not generated with the latest versions. Analogous to `scalafmtCheck`, i.e. run this on PRs."
    )
    val outputDir = settingKey[File]("target directory for the generated domain classes, e.g. `Projects.domainClasses/scalaSource`")
    val invalidateOnChangesIn =
      settingKey[Seq[File]]("if any of the configured files/directories changed, we will regenerate the domain classes")
    val classWithSchema = settingKey[String]("class with schema field, e.g. `org.example.MyDomain$`")
    val fieldName = settingKey[String](
      "(static) field name for schema within the specified `classWithSchema` with schema field, e.g. `org.example.MyDomain$`"
    )
    val disableFormatting = settingKey[Boolean]("disable automatic scalafmt invocation")

    lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
      generateDomainClasses                     := generateDomainClassesTask.value,
      generateDomainClassesCheck                := generateDomainClassesCheckTask.value,
      generateDomainClasses / disableFormatting := false
    )
  }
  import autoImport._

  override lazy val globalSettings: Seq[Setting[_]] = Seq(invalidateOnChangesIn := Seq())

  override def requires = JvmPlugin && ScalafmtPlugin

  // This plugin needs to be enabled manually via `enablePlugins`
  override def trigger = noTrigger

  // a group of settings that are automatically added to projects.
  override val projectSettings = inConfig(Compile)(autoImport.baseSettings)

  lazy val generateDomainClassesTask = {
    Def.taskDyn {
      val classWithSchemaValue       = (generateDomainClasses / classWithSchema).value
      val fieldNameValue             = (generateDomainClasses / fieldName).value
      val outputDirValue             = (generateDomainClasses / outputDir).value
      val invalidateOnChangesInValue = (generateDomainClasses / invalidateOnChangesIn).value

      val disableFormattingParamMaybe =
        if ((generateDomainClasses / disableFormatting).value) "--noformat"
        else ""

      val scalafmtConfigFileMaybe = {
        val file = (generateDomainClasses / scalafmtConfig).value
        if (file.exists) s"--scalafmtConfig=$file"
        else ""
      }

      val schemaAndDependenciesHashFile = target.value / "flatgraph-schema-and-dependencies.md5"
      val dependenciesFile              = target.value / "dependenciesCP.txt" // includes codegen version!
      IO.write(dependenciesFile, dependencyClasspath.value.mkString(System.lineSeparator))
      // directories / files that we want to monitor for changes - if none of these changed, we don't need to regenerate the domain classes
      val inputs =
        invalidateOnChangesInValue ++ // <- configurable in the build, e.g. `generateDomainClasses/invalidateOnChangesIn += file("foo.bar")`
          Seq(sourceDirectory.value, baseDirectory.value / "build.sbt", (ThisBuild / baseDirectory).value / "build.sbt", dependenciesFile)
      // inputs.foreach(println)
      lazy val currentSchemaAndDependenciesHash = FileUtils.md5(inputs)
      lazy val lastSchemaAndDependenciesHash: Option[String] =
        Try(IO.read(schemaAndDependenciesHashFile)).toOption

      val disabled = sys.env.getOrElse("FLATGRAPH_CODEGEN_DISABLE", default = "false").toLowerCase == "true"
      if (disabled) {
        Def.task {
          streams.value.log.info("flatgraph codegen is disabled")
          outputDirValue
        }
      } else if (outputDirValue.exists && lastSchemaAndDependenciesHash == Some(currentSchemaAndDependenciesHash)) {
        streams.value.log.info("inputs did not change -> no need to run codegen")
        Def.task { outputDirValue }
      } else {
        Def.task {
          (Compile / runMain)
            .toTask(
              s" flatgraph.codegen.Main --classWithSchema=$classWithSchemaValue --field=$fieldNameValue --out=$outputDirValue $disableFormattingParamMaybe $scalafmtConfigFileMaybe"
            )
            .value
          IO.write(schemaAndDependenciesHashFile, currentSchemaAndDependenciesHash)
          outputDirValue
        }
      }
    }
  }

  lazy val generateDomainClassesCheckTask = {
    Def.taskDyn {
      streams.value.log.info("generateDomainClassesCheck: running codegen for comparison")
      val classWithSchemaValue = (generateDomainClasses / classWithSchema).value
      val fieldNameValue       = (generateDomainClasses / fieldName).value
      val outputDirValue       = (generateDomainClasses / outputDir).value
      val tempOutputDir        = target.value / "generate-domain-classes-check"

      val disableFormattingParamMaybe =
        if ((generateDomainClasses / disableFormatting).value) "--noformat"
        else ""

      val scalafmtConfigFileMaybe = {
        val file = (generateDomainClasses / scalafmtConfig).value
        if (file.exists) s"--scalafmtConfig=$file"
        else ""
      }

      Def.task {
        (Compile / runMain)
          .toTask(
            s" flatgraph.codegen.Main --classWithSchema=$classWithSchemaValue --field=$fieldNameValue --out=$tempOutputDir $disableFormattingParamMaybe $scalafmtConfigFileMaybe"
          )
          .value

        val generatedSourcesIdentical = FileUtils.md5(outputDirValue) == FileUtils.md5(tempOutputDir)
        if (!generatedSourcesIdentical) {
          throw new MessageOnlyException(
            "there are differences in the generated and the existing sources, please run `generateDomainClasses` to fix this"
          )
        }
      }
    }
  }

}
