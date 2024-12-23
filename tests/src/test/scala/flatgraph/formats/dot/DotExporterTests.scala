package flatgraph.formats.dot

import better.files.*
import flatgraph.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.generic.GenericDomain
import testdomains.generic.edges.ConnectedTo
import testdomains.generic.nodes.NewNodeA

class DotExporterTests extends AnyWordSpec {

  "Exporter should export valid dot" in {
    val graph = GenericDomain.empty.graph
    val node1 = NewNodeA()
      .stringMandatory("regular string")
      .stringOptional("<escapeMe>")
      .stringList(Seq("node 1 c1", "<escapeMe2>"))
    val node2 = NewNodeA().intMandatory(1).intOptional(2).intList(Seq(10, 11, 12))

    DiffGraphApplier.applyDiff(
      graph,
      GenericDomain.newDiffGraphBuilder
        .addEdge(node1, node2, ConnectedTo.Label, "edge property")
    )

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = DotExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 2
      exportResult.edgeCount shouldBe 1
      val Seq(exportedFile) = exportResult.files

      val result = better.files.File(exportedFile).contentAsString.trim

      // TODO remove
      better.files.File(exportedFile).copyTo(better.files.File("/home/mp/Projects/shiftleft/flatgraph/target/dot.dot"))
      Thread.sleep(20000)




      withClue(s"actual result was: `$result`") {
        result.trim shouldBe
          """digraph {
            |  0[label=node_a int_mandatory="42" string_list="node 1 c1;node 1 c2" string_mandatory="regular string" string_optional=""]
            |  1[label=node_a int_list="10;11;12" int_mandatory="1" int_optional="2" string_mandatory="<empty>"]
            |  0 -> 1 [label=connected_to property="edge property"]
            |}
            |""".stripMargin.trim
      }
    }
  }

}
