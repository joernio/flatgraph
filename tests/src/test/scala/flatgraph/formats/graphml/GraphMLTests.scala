package flatgraph.formats.graphml

import better.files.File
import flatgraph.DiffGraphApplier
import flatgraph.util.DiffTool
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.lang.System.lineSeparator
import java.nio.file.Paths
import scala.jdk.CollectionConverters.CollectionHasAsScala

class GraphMLTests extends AnyWordSpec {

  "import minified gratefuldead graph" in {
    import testdomains.gratefuldead.GratefulDead
    import testdomains.gratefuldead.language.*
    val gratefulDead = GratefulDead.empty
    val graph        = gratefulDead.graph
    graph.nodeCount shouldBe 0

    GraphMLImporter.runImport(graph, Paths.get(this.getClass.getResource("/graphml-small.xml").toURI))
    graph.nodeCount shouldBe 3
    graph.edgeCount shouldBe 2

    gratefulDead.song.size shouldBe 1
    gratefulDead.song.name.l shouldBe List("HEY BO DIDDLEY")
    gratefulDead.artist.size shouldBe 2
    gratefulDead.artist.name.l shouldBe List("Garcia", "Bo_Diddley")

    val Seq(boDiddley, garcia) = gratefulDead.artist.sortBy(_.name).l
    val Seq(heyBoDiddley)      = gratefulDead.song.l

    heyBoDiddley.sungBy.l shouldBe List(garcia)
    heyBoDiddley.writtenBy.l shouldBe List(boDiddley)
    garcia.sang.l shouldBe List(heyBoDiddley)
    boDiddley.wrote.l shouldBe List(heyBoDiddley)

    graph.close()
  }

  "Exporter should export valid xml" when {
    import testdomains.generic.GenericDomain
    import testdomains.generic.language.*
    import testdomains.generic.edges.ConnectedTo
    import testdomains.generic.nodes.NewNodeA

    "not using (unsupported) list properties" in {
      val node1 = NewNodeA().stringOptional("node 1 opt")
      val node2 = NewNodeA().stringMandatory("node 2 mandatory").stringOptional("node 2 opt")
      val node3 = NewNodeA().intMandatory(1).intOptional(2)

      val graph = GenericDomain
        .from(
          _.addEdge(node1, node2, ConnectedTo.Label)
            .addEdge(node2, node3, ConnectedTo.Label)
        )
        .graph

      File.usingTemporaryDirectory(this.getClass.getName) { exportRootDirectory =>
        val exportResult = GraphMLExporter.runExport(graph, exportRootDirectory.pathAsString)
        exportResult.nodeCount shouldBe 3
        exportResult.edgeCount shouldBe 2
        val Seq(graphMLFile) = exportResult.files

        // import graphml into new graph, use difftool for round trip of conversion
        val reimported = GenericDomain.empty.graph
        GraphMLImporter.runImport(reimported, graphMLFile)
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

    "using list properties" in {
      // exporter  will discard the list properties, but inform the user about it
      val node1 = NewNodeA().stringMandatory("node 2 a").stringOptional("node 2 b").stringList(Seq("node 3 c1", "node 3 c2"))
      val node2 = NewNodeA().intMandatory(1).intOptional(2).intList(Seq(10, 11, 12))

      val graph = GenericDomain.from(_.addEdge(node1, node2, ConnectedTo.Label)).graph

      File.usingTemporaryDirectory(this.getClass.getName) { exportRootDirectory =>
        val exportResult = GraphMLExporter.runExport(graph, exportRootDirectory.pathAsString)
        exportResult.nodeCount shouldBe 2
        exportResult.edgeCount shouldBe 1
        exportResult.additionalInfo.get should include("discarded 2 list properties")

        val Seq(graphMLFile) = exportResult.files

        // import graphml into new graph, use difftool for round trip of conversion
        val reimported = GenericDomain.empty.graph
        GraphMLImporter.runImport(reimported, graphMLFile)
        val diff       = DiffTool.compare(graph, reimported)
        val diffString = diff.asScala.mkString(lineSeparator)
        withClue(
          s"because the original graph contained two list properties, and those are not supported by graphml, " +
            s"the exporter drops them. therefor they'll not be part of the reimported graph" +
            diffString +
            lineSeparator
        ) {
          diff.size shouldBe 2
          diffString should include("Seq(10, 11, 12)")
          diffString should include("Seq(node 3 c1, node 3 c2)")
        }
      }
    }
  }

}
