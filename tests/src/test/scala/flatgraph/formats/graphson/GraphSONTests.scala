package flatgraph.formats.graphson

import better.files.File
import flatgraph.{DiffGraphApplier, GenericDNode, TestGraphs}
import flatgraph.misc.TestUtils.applyDiff
import flatgraph.util.DiffTool
import testdomains.generic.language.*
import testdomains.generic.nodes.NodeA
import testdomains.generic.GenericDomain
import testdomains.generic.nodes.NewNodeB
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.lang.System.lineSeparator
import scala.jdk.CollectionConverters.CollectionHasAsScala

class GraphSONTests extends AnyWordSpec {

  "export to GraphSON and back" in {
    val graph = TestGraphs.createSimpleGraph().graph

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = GraphSONExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 2
      exportResult.edgeCount shouldBe 1
      val Seq(graphMLFile) = exportResult.files

      // import graphml into new graph, use difftool for round trip of conversion
      val reimported = GenericDomain.empty.graph
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
    val genericDomain = TestGraphs.createSimpleGraph()
    val graph         = genericDomain.graph
    val Seq(node2)    = genericDomain.nodeA.intMandatory(1).l
    val newNodeB      = NewNodeB().stringOptional("node b stringOptional")
    DiffGraphApplier.applyDiff(
      graph,
      GenericDomain.newDiffGraphBuilder
        .setNodeProperty(node2, NodeA.PropertyNames.NodeB, newNodeB)
    )

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = GraphSONExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 3
      val Seq(graphJsonFile) = exportResult.files

      // import graphml into new graph, use difftool for round trip of conversion
      val reimported = GenericDomain.empty.graph
      GraphSONImporter.runImport(reimported, graphJsonFile)
      val diff       = DiffTool.compare(graph, reimported)
      val diffString = diff.asScala.mkString(lineSeparator)
      withClue(s"original graph contained two properties, these should also be present in reimported graph $diffString $lineSeparator") {
        diff.size shouldBe 0
      }
    }
  }

}
