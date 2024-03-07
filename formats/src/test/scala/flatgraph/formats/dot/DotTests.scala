package flatgraph.formats.dot

import better.files.*
import flatgraph.*
import flatgraph.TestDomainSimple.*
import flatgraph.TestDomainSimple.PropertyNames.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class DotTests extends AnyWordSpec {

  "Exporter should export valid dot" in {
    val graph = newGraphSimple()

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val exportResult = DotExporter.runExport(graph, exportRootDirectory.pathAsString)
      exportResult.nodeCount shouldBe 3
      exportResult.edgeCount shouldBe 2
      val Seq(exportedFile) = exportResult.files

      val result = better.files.File(exportedFile).contentAsString.trim
      withClue(s"actual result was: `$result`") {
        result.trim shouldBe
          """digraph {
            |  0[label=testNode StringProperty="<stringProp1>" StringListProperty="stringListProp1a;stringList\Prop1b" IntProperty="11" IntListProperty="21;31;41"]
            |  1[label=testNode StringProperty="string"Prop2\"]
            |  2[label=testNode IntProperty="13"]
            |  0 -> 1 [label=testEdge property=9223372036854775807]
            |  1 -> 2 [label=testEdge property=0]
            |}
            |""".stripMargin.trim
      }
    }
  }

}
