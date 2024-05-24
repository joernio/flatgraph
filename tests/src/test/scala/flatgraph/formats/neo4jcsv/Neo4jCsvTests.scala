package flatgraph.formats.neo4jcsv

import better.files.*
import flatgraph.TestGraphs
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import flatgraph.formats.{ExportResult, ExporterMain, ImporterMain}
import flatgraph.util.DiffTool
import testdomains.generic.GenericDomain
import testdomains.generic.language.*
import testdomains.generic.edges.ConnectedTo
import testdomains.generic.nodes.NodeA

import java.io.FileNotFoundException
import java.nio.file.Paths
import scala.jdk.CollectionConverters.CollectionHasAsScala

class Neo4jCsvTests extends AnyWordSpec {
  val subprojectRoot = testutils.ProjectRoot.relativise("tests")
  val neo4jcsvRoot   = Paths.get(subprojectRoot, "src/test/resources/neo4jcsv")

  "Exporter should export valid csv" in {
    val graph = TestGraphs.createSimpleGraph().graph

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
        ":ID,:LABEL,int_list:int[],int_mandatory:int,int_optional:int,string_list:string[],string_mandatory:string,string_optional:string"

      val nodeDataFileLines = fuzzyFindFile(exportedFiles, NodeA.Label, DataFileSuffix).lines.toSeq
      nodeDataFileLines.size shouldBe 2
      nodeDataFileLines should contain("0,node_a,,42,,node 1 c1;node 1 c2,node 1 a,node 1 b")
      nodeDataFileLines should contain("1,node_a,10;11;12,1,2,,<empty>,")

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
          |int_optional: toInteger(line[4]),
          |string_list: toStringList(split(line[5], ";")),
          |string_mandatory: line[6],
          |string_optional: line[7]
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
    "import valid csv" in {
      val csvInputFiles =
        Seq("edges_connected_to_header.csv", "edges_connected_to_data.csv", "nodes_node_a_header.csv", "nodes_node_a_data.csv").map(
          neo4jcsvRoot.resolve
        )

      val genericDomain = GenericDomain.empty
      val graph         = genericDomain.graph
      Neo4jCsvImporter.runImport(graph, csvInputFiles)

      graph.nodeCount shouldBe 2

      val Seq(node1) = genericDomain.nodeA.stringMandatory("node 1 a").l
      val Seq(node2) = genericDomain.nodeA.intMandatory(1).l

      node1.intMandatory shouldBe 42
      node2.intMandatory shouldBe 1
      node1.intOptional shouldBe None
      node2.intOptional shouldBe Some(2)
      node1.intList shouldBe Seq.empty
      node2.intList shouldBe Seq(10, 11, 12)
      node1.stringMandatory shouldBe "node 1 a"
      node2.stringMandatory shouldBe "<empty>"
      node1.stringOptional shouldBe Some("node 1 b")
      node2.stringOptional shouldBe None
      node1.stringList shouldBe Seq("node 1 c1", "node 1 c2")
      node2.stringList shouldBe Seq.empty

      graph.edgeCount shouldBe 1
      node1.connectedTo.l shouldBe Seq(node2)
      val Seq(edge) = node1.outE(ConnectedTo.Label).l
      edge.property shouldBe "edge property"
    }

    "fail if multiple labels are used (unsupported by flatgraph)" in {
      val csvInputFiles = Seq("unsupported_multiple_labels_header.csv", "unsupported_multiple_labels_data.csv").map(neo4jcsvRoot.resolve)

      val graph = GenericDomain.empty.graph
      intercept[NotImplementedError] {
        Neo4jCsvImporter.runImport(graph, csvInputFiles)
      }.getMessage should include("multiple :LABEL columns found")
    }

    "fail if input file doesn't exist" in {
      val csvInputFiles = Seq("does_not_exist_header.csv", "does_not_exist_data.csv").map(neo4jcsvRoot.resolve)

      val graph = GenericDomain.empty.graph
      intercept[FileNotFoundException] {
        Neo4jCsvImporter.runImport(graph, csvInputFiles)
      }
    }

    "fail with context information (line number etc.) for invalid input" in {
      val csvInputFiles = Seq("invalid_column_content_header.csv", "invalid_column_content_data.csv").map(neo4jcsvRoot.resolve)

      val graph = GenericDomain.empty.graph
      intercept[RuntimeException] {
        Neo4jCsvImporter.runImport(graph, csvInputFiles)
      }.getMessage should include("invalid_column_content_data.csv line 3")
    }
  }

  "main apps for cli export/import" in {
    File.usingTemporaryDirectory(getClass.getName) { tmpDir =>
      val graphPath  = tmpDir / "original.fg"
      val exportPath = tmpDir / "export"

      val genericDomain = TestGraphs.createSimpleGraph(Some(graphPath.path))
      genericDomain.close()

      val exporterMain = ExporterMain()
      exporterMain(Array("--format=neo4jcsv", s"--out=${exportPath.pathAsString}", graphPath.pathAsString))
      val exportedFiles = exportPath.list.toArray
      exportedFiles.length shouldBe 6

      // use importer for round trip
      val importerMain       = ImporterMain(testdomains.generic.GraphSchema)
      val reimportPath       = tmpDir / "reimported.fg"
      val relevantInputFiles = exportedFiles.filterNot(_.name.contains(CypherFileSuffix)).map(_.pathAsString)
      importerMain(Array("--format=neo4jcsv", s"--out=${reimportPath.pathAsString}") ++ relevantInputFiles)

      val genericDomainReimported = GenericDomain.withStorage(reimportPath.path)
      genericDomainReimported.graph.nodeCount shouldBe 2
      genericDomainReimported.graph.edgeCount shouldBe 1

      genericDomainReimported.nodeA.intMandatory.l.sorted shouldBe List(1, 42)
      genericDomainReimported.nodeA.stringMandatory("node 1 a").connectedTo.intOptional.head shouldBe 2
    }
  }

  private def fuzzyFindFile(files: Seq[File], label: String, fileSuffix: String): File = {
    files.find { file =>
      val relevantPart = file.nameWithoutExtension.toLowerCase
      relevantPart.contains(label.toLowerCase) && relevantPart.endsWith(fileSuffix)
    }.get
  }

}
