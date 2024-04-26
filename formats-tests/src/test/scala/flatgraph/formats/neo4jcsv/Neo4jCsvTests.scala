package flatgraph.formats.neo4jcsv

import better.files.*
import flatgraph.DiffGraphApplier
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import flatgraph.formats.{ExportResult, ExporterMain, ImporterMain}
import flatgraph.traversal.*
import flatgraph.util.DiffTool
import flatgraph.testdomains.generic.GenericDomain
import flatgraph.testdomains.generic.Language.*
import flatgraph.testdomains.generic.edges.ConnectedTo
import flatgraph.testdomains.generic.nodes.{NewNodeA, NodeA}

import java.io.FileNotFoundException
import java.nio.file.Paths
import scala.jdk.CollectionConverters.{CollectionHasAsScala, IterableHasAsJava, IteratorHasAsScala}

class Neo4jCsvTests extends AnyWordSpec {
  val subprojectRoot = testutils.ProjectRoot.relativise("formats")
  val neo4jcsvRoot   = Paths.get(subprojectRoot, "src/test/resources/neo4jcsv")

  "Exporter should export valid csv" in {
    val graph = GenericDomain.empty.graph
    val node1 = NewNodeA().stringMandatory("node 2 a").stringOptional("node 2 b").stringList(Seq("node 3 c1", "node 3 c2"))
    val node2 = NewNodeA().intMandatory(1).intOptional(2).intList(Seq(10, 11, 12))

    DiffGraphApplier.applyDiff(
      graph,
      GenericDomain.newDiffGraphBuilder
        .addEdge(node1, node2, ConnectedTo.Label, "edge property")
    )

    File.usingTemporaryDirectory(getClass.getName) { exportRootDirectory =>
      val ExportResult(nodeCount, edgeCount, exportedFiles0, additionalInfo) =
        Neo4jCsvExporter.runExport(graph, exportRootDirectory.pathAsString)
      nodeCount shouldBe 2
      edgeCount shouldBe 1
      val exportedFiles = exportedFiles0.map(_.toFile.toScala)
      exportedFiles.size shouldBe 6
      exportedFiles.foreach(_.parent shouldBe exportRootDirectory)

      // assert csv file contents
      val nodeHeaderFile = fuzzyFindFile(exportedFiles, NodeA.Label, HeaderFileSuffix)
      nodeHeaderFile.contentAsString.trim shouldBe
        ":ID,:LABEL,int_list:int[],int_mandatory:int,string_list:string[],string_mandatory:string,string_optional:string"

      val nodeDataFileLines = fuzzyFindFile(exportedFiles, NodeA.Label, DataFileSuffix).lines.toSeq
      nodeDataFileLines.size shouldBe 2
      nodeDataFileLines should contain("0,node_a,,42,node 3 c1;node 3 c2,node 2 a,node 2 b")
      nodeDataFileLines should contain("1,node_a,10;11;12,1,,<empty>,")

      val edgeHeaderFile = fuzzyFindFile(exportedFiles, ConnectedTo.Label, HeaderFileSuffix)
      edgeHeaderFile.contentAsString.trim shouldBe ":START_ID,:END_ID,:TYPE,string_mandatory:string"

      val edgeDataFileLines = fuzzyFindFile(exportedFiles, ConnectedTo.Label, DataFileSuffix).lines.toSeq
      edgeDataFileLines.size shouldBe 1
      edgeDataFileLines should contain("0,1,connected_to,edge property")

      fuzzyFindFile(exportedFiles, NodeA.Label, CypherFileSuffix).contentAsString shouldBe
        """LOAD CSV FROM 'file:/nodes_node_a_data.csv' AS line
          |CREATE (:node_a {
          |id: toInteger(line[0]),
          |int_list: toIntegerList(split(line[2], ";")),
          |int_mandatory: toInteger(line[3]),
          |string_list: toStringList(split(line[4], ";")),
          |string_mandatory: line[5],
          |string_optional: line[6]
          |});
          |""".stripMargin

      fuzzyFindFile(exportedFiles, ConnectedTo.Label, CypherFileSuffix).contentAsString shouldBe
        """LOAD CSV FROM 'file:/edges_connected_to_data.csv' AS line
          |MATCH (a), (b)
          |WHERE a.id = toInteger(line[0]) AND b.id = toInteger(line[1])
          |CREATE (a)-[r:connected_to {string_mandatory: line[3]}]->(b);
          |""".stripMargin

      /** example cypher queries to run manually in your neo4j instance: MATCH (a) return a; MATCH (a)-[r]->(b) RETURN a.id, type(r), b.id;
        */

      // import csv into new graph, use difftool for round trip of conversion
      val graphFromCsv = GenericDomain.empty.graph
      Neo4jCsvImporter.runImport(graphFromCsv, exportedFiles.filterNot(_.name.contains(CypherFileSuffix)).map(_.toJava.toPath))
      val diff = DiffTool.compare(graph, graphFromCsv)
      withClue(
        s"original graph and reimport from csv should be completely equal, but there are differences:\n" +
          diff.asScala.mkString("\n") +
          "\n"
      ) {
        diff.size shouldBe 0
      }
    }
  }

  "Importer" should {
    "Foo" in {
      ???
    }

//    "import valid csv" in {
//      val csvInputFiles = Seq(
//        "testedges_header.csv",
//        "testedges_data.csv",
//        "testnodes_header.csv",
//        "testnodes_data.csv"
//      ).map(neo4jcsvRoot.resolve)
//
//      val graph = SimpleDomain.newGraph()
//      Neo4jCsvImporter.runImport(graph, csvInputFiles)
//
//      graph.nodeCount shouldBe 3
//
//      val node1 = graph.node(1).asInstanceOf[TestNode]
//      node1.label shouldBe "testNode"
//      node1.intProperty shouldBe 11
//      node1.stringProperty shouldBe "stringProp1"
//      node1.stringListProperty.asScala.toList shouldBe List("stringListProp1a", "stringListProp1b")
//      node1.intListProperty.asScala.toList shouldBe List(21, 31, 41)
//
//      val node2 = graph.node(2).asInstanceOf[TestNode]
//      node2.stringProperty shouldBe "stringProp2"
//
//      val node3 = graph.node(3).asInstanceOf[TestNode]
//      node3.intProperty shouldBe 13
//
//      graph.edgeCount shouldBe 2
//      val edge1 = node1.outE("testEdge").next().asInstanceOf[TestEdge]
//      edge1.longProperty shouldBe Long.MaxValue
//      edge1.inNode shouldBe node2
//
//      val edge2 = node3.inE("testEdge").next().asInstanceOf[TestEdge]
//      edge2.outNode shouldBe node2
//    }
//
//    "fail if multiple labels are used (unsupported by flatgraph)" in {
//      val csvInputFiles = Seq(
//        "unsupported_multiple_labels_header.csv",
//        "unsupported_multiple_labels_data.csv"
//      ).map(neo4jcsvRoot.resolve)
//
//      val graph = SimpleDomain.newGraph()
//      intercept[NotImplementedError] {
//        Neo4jCsvImporter.runImport(graph, csvInputFiles)
//      }.getMessage should include("multiple :LABEL columns found")
//    }
//
//    "fail if input file doesn't exist" in {
//      val csvInputFiles = Seq(
//        "does_not_exist_header.csv",
//        "does_not_exist_data.csv"
//      ).map(neo4jcsvRoot.resolve)
//
//      val graph = SimpleDomain.newGraph()
//      intercept[FileNotFoundException] {
//        Neo4jCsvImporter.runImport(graph, csvInputFiles)
//      }
//    }
//
//    "fail with context information (line number etc.) for invalid input" in {
//      val csvInputFiles = Seq(
//        "invalid_column_content_header.csv",
//        "invalid_column_content_data.csv"
//      ).map(neo4jcsvRoot.resolve)
//
//      val graph = SimpleDomain.newGraph()
//      intercept[RuntimeException] {
//        Neo4jCsvImporter.runImport(graph, csvInputFiles)
//      }.getMessage should include("invalid_column_content_data.csv line 3")
//    }
  }

  "main apps for cli export/import" in {
    ???
//    File.usingTemporaryDirectory(getClass.getName) { tmpDir =>
//      val graphPath = tmpDir / "original.odb"
//      val exportPath = tmpDir / "export"
//      val graph =
//        SimpleDomain.newGraph(flatgraph.Config.withoutOverflow().withStorageLocation(graphPath.toJava.toPath))
//      val node2 = graph.addNode(2, TestNode.LABEL, TestNode.STRING_PROPERTY, "stringProp2")
//      val node3 = graph.addNode(3, TestNode.LABEL, TestNode.INT_PROPERTY, 13)
//      node2.addEdge(TestEdge.LABEL, node3)
//      graph.close()
//
//      val exporterMain = ExporterMain(Seq(TestNode.factory), Seq(TestEdge.factory))
//      exporterMain(Array("--format=neo4jcsv", s"--out=${exportPath.pathAsString}", graphPath.pathAsString))
//      val exportedFiles = exportPath.list.toArray
//      exportedFiles.size shouldBe 6
//
//      // use importer for round trip
//      val importerMain = ImporterMain(Seq(TestNode.factory), Seq(TestEdge.factory))
//      val reimportPath = tmpDir / "reimported.odb"
//      val relevantInputFiles = exportedFiles.filterNot(_.name.contains(CypherFileSuffix)).map(_.pathAsString)
//      importerMain(Array("--format=neo4jcsv", s"--out=${reimportPath.pathAsString}") ++ relevantInputFiles)
//      val graphReimported =
//        SimpleDomain.newGraph(flatgraph.Config.withoutOverflow().withStorageLocation(reimportPath.toJava.toPath))
//      graphReimported.nodeCount shouldBe 2
//
//      // TODO change back once we're on Scala 3.2.2
//      // graphReimported.node(2).out(TestEdge.LABEL).property(TestNode.INT_PROPERTY).l shouldBe Seq(13)
//      graphReimported.node(2).out(TestEdge.LABEL).asScala.property(TestNode.INT_PROPERTY).l shouldBe Seq(13)
//    }
  }

  private def fuzzyFindFile(files: Seq[File], label: String, fileSuffix: String): File = {
    files.find { file =>
      val relevantPart = file.nameWithoutExtension.toLowerCase
      relevantPart.contains(label.toLowerCase) && relevantPart.endsWith(fileSuffix)
    }.get
  }

}
