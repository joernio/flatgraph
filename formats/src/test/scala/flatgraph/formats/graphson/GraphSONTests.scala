package flatgraph.formats.graphson

import better.files.File
import flatgraph.TestDomainSimple.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import flatgraph.util.DiffTool

import java.lang.System.lineSeparator
import java.nio.file.Paths
import scala.jdk.CollectionConverters.{CollectionHasAsScala, IterableHasAsJava}

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
    ???
//      val graph = SimpleDomain.newGraph()
//
//      val node1 = graph.addNode(1, TestNode.LABEL)
//      graph.addNode(2, TestNode.LABEL, TestNode.CONTAINED_TESTNODE_PROPERTY, node1, TestNode.INT_PROPERTY, 11)
//
//      File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
//        val exportResult = GraphSONExporter.runExport(graph, exportRootDirectory.pathAsString)
//        exportResult.nodeCount shouldBe 2
//        val Seq(graphJsonFile) = exportResult.files
//
//        // import graphml into new graph, use difftool for round trip of conversion
//        val reimported = SimpleDomain.newGraph()
//        GraphSONImporter.runImport(reimported, graphJsonFile)
//        val diff = DiffTool.compare(graph, reimported)
//        val diffString = diff.asScala.mkString(lineSeparator)
//        withClue(
//          s"original graph contained two list properties, these should also be present in reimported graph $diffString $lineSeparator"
//        ) {
//          diff.size shouldBe 0
//        }
//      }
  }

}
