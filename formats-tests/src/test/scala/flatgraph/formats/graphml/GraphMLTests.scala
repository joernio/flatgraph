package flatgraph.formats.graphml

import better.files.File
import flatgraph.{DiffGraphApplier, TestHelpers}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import flatgraph.util.DiffTool

import java.lang.System.lineSeparator
import java.nio.file.Paths
import scala.jdk.CollectionConverters.{CollectionHasAsScala, IterableHasAsJava}

class GraphMLTests extends AnyWordSpec {

  "import minified gratefuldead graph" in {
    import flatgraph.testdomains.gratefuldead.GratefulDead
    import flatgraph.testdomains.gratefuldead.Language.*
    val gratefulDead = GratefulDead.empty
    val graph        = gratefulDead.graph
    graph.nodeCount() shouldBe 0

    GraphMLImporter.runImport(graph, Paths.get(this.getClass.getResource("/graphml-small.xml").toURI))
    graph.nodeCount() shouldBe 3
    graph.edgeCount() shouldBe 2

    gratefulDead.song.size shouldBe 1
    gratefulDead.song.name.l shouldBe List("HEY BO DIDDLEY")
    gratefulDead.artist.size shouldBe 2
    gratefulDead.artist.name.l shouldBe List("Garcia", "Bo_Diddley")

    val Seq(boDiddley, garcia) = gratefulDead.artist.sortBy(_.name).l
    val Seq(heyBoDiddley)      = gratefulDead.song.l

    heyBoDiddley.sungBy shouldBe garcia
    heyBoDiddley.writtenBy shouldBe boDiddley
    garcia.sang.l shouldBe List(heyBoDiddley)
    boDiddley.wrote.l shouldBe List(heyBoDiddley)

    graph.close()
  }

  "Exporter should export valid xml" when {
    import flatgraph.testdomains.generic.GenericDomain
    import flatgraph.testdomains.generic.Language.*
    import flatgraph.testdomains.generic.nodes.NewNodeA
    import flatgraph.testdomains.generic.edges.ConnectedTo

    "not using (unsupported) list properties" in {
      val genericDomain = GenericDomain.empty
      val graph         = genericDomain.graph

      val Seq(node1, node2, node3) = TestHelpers.addNodes(graph, Seq(NewNodeA(), NewNodeA(), NewNodeA()))

      val diffGraph = GenericDomain.newDiffGraphBuilder
        .addEdge(node1, node2, ConnectedTo.Label)

      DiffGraphApplier.applyDiff(graph, diffGraph)

//      val node2 = graph.addNode(2, TestNode.LABEL, TestNode.STRING_PROPERTY, "stringProp2")
//      val node3 = graph.addNode(3, TestNode.LABEL, TestNode.INT_PROPERTY, 13)
//
//      // only allows values defined in FunkyList.funkyWords
//      val funkyList = new FunkyList()
//      funkyList.add("apoplectic")
//      funkyList.add("bucolic")
//      val node1 = graph.addNode(1, TestNode.LABEL, TestNode.INT_PROPERTY, 11, TestNode.STRING_PROPERTY, "<stringProp1>")
//
//      node1.addEdge(TestEdge.LABEL, node2, TestEdge.LONG_PROPERTY, Long.MaxValue)
//      node2.addEdge(TestEdge.LABEL, node3)
//
//      File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
//        val exportResult = GraphMLExporter.runExport(graph, exportRootDirectory.pathAsString)
//        exportResult.nodeCount shouldBe 3
//        exportResult.edgeCount shouldBe 2
//        val Seq(graphMLFile) = exportResult.files
//
//        // import graphml into new graph, use difftool for round trip of conversion
//        val reimported = SimpleDomain.newGraph()
//        GraphMLImporter.runImport(reimported, graphMLFile)
//        val diff = DiffTool.compare(graph, reimported)
//        withClue(
//          s"original graph and reimport from graphml should be completely equal, but there are differences:\n" +
//            diff.asScala.mkString("\n") +
//            "\n"
//        ) {
//          diff.size shouldBe 0
//        }
//      }
    }

//    "using list properties" in {
//      val graph = SimpleDomain.newGraph()
//
//      // will discard the list properties
//      val node1 = graph.addNode(
//        1,
//        TestNode.LABEL,
//        TestNode.INT_PROPERTY,
//        11,
//        TestNode.STRING_PROPERTY,
//        "<stringProp1>",
//        TestNode.STRING_LIST_PROPERTY,
//        List("stringListProp1a", "stringListProp1b").asJava,
//        TestNode.INT_LIST_PROPERTY,
//        List(21, 31, 41).asJava
//      )
//
//      File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
//        val exportResult = GraphMLExporter.runExport(graph, exportRootDirectory.pathAsString)
//        exportResult.nodeCount shouldBe 1
//        exportResult.edgeCount shouldBe 0
//        exportResult.additionalInfo.get should include("discarded 2 list properties")
//        val Seq(graphMLFile) = exportResult.files
//
//        // import graphml into new graph, use difftool for round trip of conversion
//        val reimported = SimpleDomain.newGraph()
//        GraphMLImporter.runImport(reimported, graphMLFile)
//        val diff = DiffTool.compare(graph, reimported)
//        val diffString = diff.asScala.mkString(lineSeparator)
//        withClue(
//          s"because the original graph contained two list properties, and those are not supported by graphml, " +
//            s"the exporter drops them. therefor they'll not be part of the reimported graph" +
//            diffString +
//            lineSeparator
//        ) {
//          diff.size shouldBe 2
//          diffString should include("IntListProperty")
//          diffString should include("StringListProperty")
//        }
//      }
//    }
  }

}
