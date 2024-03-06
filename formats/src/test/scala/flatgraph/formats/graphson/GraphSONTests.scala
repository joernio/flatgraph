package flatgraph.formats.graphson

import better.files.File
import flatgraph.GenericDNode
import flatgraph.TestDomainSimple.*
import flatgraph.TestDomainSimple.PropertyNames.{ContainedTestNodeProperty, IntProperty}
import flatgraph.misc.TestUtils.applyDiff
import flatgraph.util.DiffTool
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.lang.System.lineSeparator
import scala.jdk.CollectionConverters.CollectionHasAsScala

class GraphSONTests extends AnyWordSpec {

  "export to GraphSON and back" in {
    val graph = newGraphSimple()

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = GraphSONExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 3
      exportResult.edgeCount shouldBe 2
      val Seq(graphMLFile) = exportResult.files

      // import graphml into new graph, use difftool for round trip of conversion
      val reimported = newGraphEmpty()
      GraphSONImporter.runImport(reimported, graphMLFile)
      val diff = DiffTool.compare(graph, reimported)
      withClue(
        s"original graph and reimport from graphml should be completely equal, but there are differences:\n" +
          diff.asScala.mkString("\n") +
          "\n"
      ) {
        diff.size shouldBe 0
      }
    }
  }

  "using 'contained node' property" in {
    val graph = newGraphEmpty()
    val v0New = new GenericDNode(0)
    val v1New = new GenericDNode(0)

    graph.applyDiff(_.addNode(v0New).addNode(v1New))
    val v0 = v0New.storedRef.get
    val v1 = v1New.storedRef.get

    graph.applyDiff(
      _.setNodeProperty(v1, ContainedTestNodeProperty, v0)
        .setNodeProperty(v1, IntProperty, 11)
    )

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = GraphSONExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 2
      val Seq(graphJsonFile) = exportResult.files

      // import graphml into new graph, use difftool for round trip of conversion
      val reimported = newGraphEmpty()
      GraphSONImporter.runImport(reimported, graphJsonFile)
      val diff       = DiffTool.compare(graph, reimported)
      val diffString = diff.asScala.mkString(lineSeparator)
      withClue(s"original graph contained two properties, these should also be present in reimported graph $diffString $lineSeparator") {
        diff.size shouldBe 0
      }
    }
  }

}
