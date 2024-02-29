package flatgraph.formats.dot

import better.files.*
import flatgraph.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class DotTests extends AnyWordSpec {

  "Exporter should export valid dot" in {
    val testNodeLabel = "testNode"
    val testEdgeLabel = "testEdge"
    val schema = new FreeSchema(
      nodeLabels = Array(testNodeLabel),
      edgeLabels = Array(testEdgeLabel),
      propertyLabels = Array("StringProperty", "StringListProperty", "IntProperty", "IntListProperty"),
      nodePropertyPrototypes = Array(Array.empty[String], Array.empty[String], Array.emptyIntArray, Array.emptyIntArray),
      edgePropertyPrototypes = Array(Array.emptyLongArray),
    )

    val graph = new Graph(schema)
    val v0 = new GenericDNode(0)
    val v1 = new GenericDNode(0)
    val v2 = new GenericDNode(0)

    DiffGraphApplier.applyDiff(graph, new DiffGraphBuilder(schema)
      ._addEdge(v0, v1, 0, Long.MaxValue)
      ._addEdge(v1, v2, 0))

    DiffGraphApplier.applyDiff(
      graph,
      new DiffGraphBuilder(schema)
        .setNodeProperty(v0.storedRef.get, "IntProperty", 11)
        .setNodeProperty(v0.storedRef.get, "StringProperty", "<stringProp1>")
        .setNodeProperty(v0.storedRef.get, "StringListProperty", List("stringListProp1a", "stringList\\Prop1b"))
        .setNodeProperty(v0.storedRef.get, "IntListProperty", List(21, 31, 41))
        .setNodeProperty(v1.storedRef.get, "StringProperty", """string"Prop2\""")
        .setNodeProperty(v2.storedRef.get, "IntProperty", 13)
    )

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
