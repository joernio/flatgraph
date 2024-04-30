package flatgraph.formats.dot

import better.files.*
import flatgraph.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class DotTests extends AnyWordSpec {

  "Exporter should export valid dot" in {
    val graph = TestGraphs.createSimpleGraph().graph

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = DotExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 2
      exportResult.edgeCount shouldBe 1
      val Seq(exportedFile) = exportResult.files

      val result = better.files.File(exportedFile).contentAsString.trim
      withClue(s"actual result was: `$result`") {
        result.trim shouldBe
          """digraph {
            |  0[label=node_a int_mandatory="42" string_list="node 1 c1;node 1 c2" string_mandatory="node 1 a" string_optional="node 1 b"]
            |  1[label=node_a int_list="10;11;12" int_mandatory="1" int_optional="2" string_mandatory="<empty>"]
            |  0 -> 1 [label=connected_to property="edge property"]
            |}
            |""".stripMargin.trim
      }
    }
  }

}
