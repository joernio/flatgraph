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
      .stringOptional("""<escapeMe1> [escapeMe2] escape=Me3 escape"Me4 escape\Me5 """)
      .stringList(Seq("one", "two"))
    val node2 = NewNodeA().intMandatory(1).intOptional(2).intList(Seq(10, 11))

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

      /* Export rules for dot format as per https: //github.com/joernio/joern/issues/5158 :
       * 1) If the attribute value contains special characters such as spaces,<,>,=, etc., it must be enclosed in double quotation marks.
       * Otherwise, it will cause syntax errors.
       * 2) Graphviz requires that the node ID must be a valid identifier. If the node ID is a pure number (such as 120259084301),
       * it needs to be enclosed in double quotation marks, otherwise it will be mistaken for an integer constant.
       * 3) The attribute value contains special characters such as(such as CODE=""), which need to be enclosed in quotation marks or escaped in some cases.
       * 4) In Graphviz's. dot file, it is best to use semicolons for each node definition, edge definition, and attribute definition; ending. Your file is missing semicolons.
       */

      withClue(s"actual result was: `$result`") {
        result.trim shouldBe
          """digraph {
          |  "0" [label="node_a" int_mandatory="42" string_list="one;two" string_mandatory="regular string" string_optional="<escapeMe1> [escapeMe2] escape=Me3 escape\"Me4 escape\\Me5 "];
          |  "1" [label="node_a" int_list="10;11" int_mandatory="1" int_optional="2" string_mandatory="<empty>"];
          |  "0" -> "1" [label="connected_to" property="edge property"];
          |}
          |""".stripMargin.trim
      }
    }
  }

}
