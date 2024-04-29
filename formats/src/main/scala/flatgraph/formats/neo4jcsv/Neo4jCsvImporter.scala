package flatgraph.formats.neo4jcsv

import com.github.tototoshi.csv.*
import flatgraph.formats.Importer
import flatgraph.misc.Conversions.toShortSafely
import flatgraph.*

import java.nio.file.Path
import scala.collection.mutable
import scala.util.Using

/** Imports from neo4j csv files see https://neo4j.com/docs/operations-manual/current/tools/neo4j-admin/neo4j-admin-import/
  */
object Neo4jCsvImporter extends Importer {
  val Neo4jAdminDoc = "https://neo4j.com/docs/operations-manual/current/tools/neo4j-admin/neo4j-admin-import"

  override def runImport(graph: Graph, inputFiles: Seq[Path]): Unit = {
    var importedNodeCount = 0
    var importedEdgeCount = 0

    // we need to add the nodes in two steps: first as raw nodes, and finally add the properties
    val diffGraphForRawNodes = new DiffGraphBuilder(graph.schema)
    val diffGraph            = new DiffGraphBuilder(graph.schema)
    val nodeContextByNeo4jId = mutable.Map.empty[Int, Neo4jNodeContext]

    groupInputFiles(inputFiles)
      .sortBy(nodeFilesFirst)
      .foreach { case HeaderAndDataFile(ParsedHeaderFile(fileType, columnDefs), dataFile) =>
        Using.resource(CSVReader.open(dataFile.toFile)) { dataReader =>
          dataReader.iterator.zipWithIndex.foreach { case (columnsRaw, idx) =>
            assert(
              columnsRaw.size == columnDefs.size,
              s"datafile ${dataFile.toAbsolutePath} row must have the same column count as the headerfile (${columnDefs.size}) - instead found ${columnsRaw.size} for row=${columnsRaw
                  .mkString(",")}"
            )
            val lineNo = idx + 1
            fileType match {
              case FileType.Nodes =>
                parseNodeRowData(columnsRaw, columnDefs, dataFile, lineNo) match {
                  case ParsedNodeRowData(id, label, properties) =>
                    val newNode = new GenericDNode(graph.schema.getNodeKindByLabel(label).toShortSafely)
                    diffGraphForRawNodes.addNode(newNode)
                    // we'll need to add the properties in a separate pass at the end
                    nodeContextByNeo4jId.addOne(id, Neo4jNodeContext(newNode, properties))
                    importedNodeCount += 1
                }
              case FileType.Relationships =>
                parseEdgeRowData(columnsRaw, columnDefs, dataFile, lineNo) match {
                  case ParsedEdgeRowData(startId, endId, label, properties) =>
                    val Seq(startNode, endNode) = Seq(startId, endId).map(nodeContextByNeo4jId).map(_.newNode)
                    // flatgraph only supports one property per edge type
                    val propertyMaybe = graph.schema.getEdgePropertyName(label).flatMap { edgePropertyName =>
                      properties.find(_.name == edgePropertyName).map(_.value)
                    }
                    diffGraph.addEdge(startNode, endNode, label, propertyMaybe.orNull)
                    importedEdgeCount += 1
                }
            }
          }
        }
      }

    // apply diffGraphForRawNodes, which sets the `storedRef` handles...
    DiffGraphApplier.applyDiff(graph, diffGraphForRawNodes)

    // ... so that we can now set the node properties
    for {
      Neo4jNodeContext(dnode, properties) <- nodeContextByNeo4jId.values
      gnode = dnode.storedRef.get
      ParsedProperty(name, value) <- properties
    } diffGraph.setNodeProperty(gnode, name, value)

    DiffGraphApplier.applyDiff(graph, diffGraph)

    logger.info(s"imported $importedNodeCount nodes and $importedEdgeCount edges")
  }

  private def groupInputFiles(inputFiles: Seq[Path]): Seq[HeaderAndDataFile] = {
    val nonCsvFiles = inputFiles.filterNot(_.getFileName.toString.endsWith(".csv"))
    assert(nonCsvFiles.isEmpty, s"input files must all have `.csv` extension, which is not the case for ${nonCsvFiles.mkString(",")}")

    val (headerFiles, dataFiles) = inputFiles.partition(_.getFileName.toString.endsWith(s"$HeaderFileSuffix.csv"))
    assert(
      headerFiles.size == dataFiles.size,
      s"number of header files (`xyz$HeaderFileSuffix.csv`) must equal the number of data files (`xyz.csv`)"
    )

    headerFiles.map { headerFile =>
      val wantedBodyFilename = headerFile.getFileName.toString.replaceAll(HeaderFileSuffix, DataFileSuffix)
      dataFiles.find(_.getFileName.toString == wantedBodyFilename) match {
        case Some(dataFile) =>
          HeaderAndDataFile(parseHeaderFile(headerFile), dataFile)
        case None =>
          val inputFilenames = inputFiles.map(_.getFileName).mkString(", ")
          throw new AssertionError(s"body filename `$wantedBodyFilename` wanted, but not found in given input files: $inputFilenames")
      }
    }
  }

  private def nodeFilesFirst(headerAndDataFile: HeaderAndDataFile): Int = {
    headerAndDataFile.headerFile.fileType match {
      case FileType.Nodes         => 1 // we must import nodes first, because relationships refer to nodes
      case FileType.Relationships => 2
    }
  }

  private def parseHeaderFile(headerFile: Path): ParsedHeaderFile = {
    val columnDefs = Using.resource(CSVReader.open(headerFile.toFile)) { headerReader =>
      headerReader.all().headOption.getOrElse(throw new AssertionError(s"header file $headerFile is empty"))
    }

    val propertyDefs     = Map.newBuilder[Int, ColumnDef]
    var labelColumnFound = false
    // will figure out if this is a node or relationship file during parsing
    var fileType: Option[FileType.Value] = None
    columnDefs.zipWithIndex.foreach { case (entry, idx) =>
      val propertyDef = entry match {
        case ColumnType.LabelMarker =>
          if (labelColumnFound)
            throw new NotImplementedError(s"multiple ${ColumnType.Label} columns found in $headerFile, which is not supported by flatgraph")
          labelColumnFound = true
          fileType = Option(FileType.Nodes)
          ColumnDef(None, ColumnType.Label)
        case ColumnType.TypeMarker =>
          fileType = Option(FileType.Relationships)
          ColumnDef(None, ColumnType.Type)
        case s if s.endsWith(ColumnType.Id.toString) =>
          ColumnDef(None, ColumnType.Id)
        case s if s.endsWith(ColumnType.StartId.toString) =>
          ColumnDef(None, ColumnType.StartId)
        case s if s.endsWith(ColumnType.EndId.toString) =>
          ColumnDef(None, ColumnType.EndId)
        case propertyDef if propertyDef.contains(":") =>
          val name :: valueTpe0 :: Nil = propertyDef.split(':').toList: @unchecked
          val isArray = propertyDef.endsWith(ColumnType.ArrayMarker) // from the docs: "To define an array type, append [] to the type"
          val valueTpe =
            if (isArray) valueTpe0.dropRight(2)
            else valueTpe0
          ColumnDef(Option(name), valueType = ColumnType.withName(valueTpe), isArray)
        case propertyName =>
          ColumnDef(Option(propertyName), valueType = ColumnType.String) // if property is not annotated with `:someType`, default to String
      }
      propertyDefs.addOne((idx, propertyDef))
    }

    val propertyDefsRes = propertyDefs.result()
    fileType match {
      case Some(FileType.Nodes) =>
        assert(
          propertyDefsRes.values.exists(_.valueType == ColumnType.Id),
          s"no :ID column found in headerFile $headerFile - see format definition in $Neo4jAdminDoc"
        )
        ParsedHeaderFile(FileType.Nodes, propertyDefsRes)
      case Some(FileType.Relationships) =>
        assert(
          propertyDefsRes.values.exists(_.valueType == ColumnType.StartId),
          s"no :START_ID column found in headerFile $headerFile - see format definition in $Neo4jAdminDoc"
        )
        assert(
          propertyDefsRes.values.exists(_.valueType == ColumnType.EndId),
          s"no :END_ID column found in headerFile $headerFile - see format definition in $Neo4jAdminDoc"
        )
        ParsedHeaderFile(FileType.Relationships, propertyDefsRes)
      case _ =>
        throw new AssertionError(
          s"unable to determine file type - neither ${ColumnType.Label} (for nodes) nor ${ColumnType.Type} (for relationships) found"
        )
    }
  }

  private def parseNodeRowData(
    columnsRaw: Seq[String],
    columnDefs: Map[Int, ColumnDef],
    inputFile: Path,
    lineNo: Int
  ): ParsedNodeRowData = {
    var id: Integer   = null
    var label: String = null
    val properties    = Seq.newBuilder[ParsedProperty]
    columnsRaw.zipWithIndex.foreach { case (entry, idx) =>
      val columnDef = columnDefs.getOrElse(
        idx,
        throw new AssertionError(s"column with index=$idx not found in column definitions derived from headerFile")
      )
      parseEntry(entry, columnDef, inputFile, lineNo) {
        case ColumnDef(_, ColumnType.Id, _) =>
          id = parseInt(entry, ColumnType.Id, lineNo)
        case ColumnDef(_, ColumnType.Label, _) =>
          label = entry
        case ColumnDef(Some(name), valueType, false) =>
          parseProperty(entry, name, valueType).foreach(properties.addOne)
        case ColumnDef(Some(name), valueType, true) =>
          parseArrayProperty(entry, name, valueType).foreach(properties.addOne)
      }
    }
    assert(id != null, s"no ID column found in line $lineNo")
    assert(label != null, s"no LABEL column found in line $lineNo")

    val ret = ParsedNodeRowData(id, label, properties.result())
    logger.debug("parsed line {}: {}", lineNo, ret)
    ret
  }

  private def parseEdgeRowData(
    columnsRaw: Seq[String],
    columnDefs: Map[Int, ColumnDef],
    inputFile: Path,
    lineNo: Int
  ): ParsedEdgeRowData = {
    var startId: Integer = null
    var endId: Integer   = null
    var label: String    = null
    val properties       = Seq.newBuilder[ParsedProperty]
    columnsRaw.zipWithIndex.foreach { case (entry, idx) =>
      val columnDef = columnDefs.getOrElse(
        idx,
        throw new AssertionError(s"column with index=$idx not found in column definitions derived from headerFile")
      )
      parseEntry(entry, columnDef, inputFile, lineNo) {
        case ColumnDef(_, ColumnType.StartId, _) =>
          startId = parseInt(entry, ColumnType.StartId, lineNo)
        case ColumnDef(_, ColumnType.EndId, _) =>
          endId = parseInt(entry, ColumnType.EndId, lineNo)
        case ColumnDef(_, ColumnType.Type, _) =>
          label = entry
        case ColumnDef(Some(name), valueType, false) =>
          parseProperty(entry, name, valueType).foreach(properties.addOne)
        case ColumnDef(Some(name), valueType, true) =>
          parseArrayProperty(entry, name, valueType).foreach(properties.addOne)
      }
    }
    assert(startId != null, s"no START_ID column found in line $lineNo")
    assert(endId != null, s"no END_ID column found in line $lineNo")
    assert(label != null, s"no LABEL column found in line $lineNo")

    val ret = ParsedEdgeRowData(startId, endId, label, properties.result())
    logger.debug("parsed line {}: {}", lineNo, ret)
    ret
  }

  private def parseEntry(rawValue: String, columnDef: ColumnDef, inputFile: Path, lineNo: Int)(
    handleColumn: PartialFunction[ColumnDef, ?]
  ): Unit = {
    try {
      handleColumn.applyOrElse(
        columnDef,
        { (_: ColumnDef) =>
          throw new MatchError(s"unhandled case $columnDef for rawValue=$rawValue in ${inputFile.getFileName} line $lineNo")
        }
      )
    } catch {
      case err: Exception =>
        throw new RuntimeException(
          s"error while parsing input value '$rawValue' of valueType=${columnDef.valueType} in ${inputFile.getFileName} line $lineNo",
          err
        )
    }
  }

  private def parseProperty(rawValue: String, name: String, valueType: ColumnType.Value): Option[ParsedProperty] = {
    // an empty string in a csv is equivalent to `value not set`
    Option(rawValue).filter(_.nonEmpty).map { value =>
      ParsedProperty(name, parsePropertyValue(value, valueType))
    }
  }

  private def parseArrayProperty(rawValue: String, name: String, valueType: ColumnType.Value): Option[ParsedProperty] = {
    val values = rawValue.split(';') // from the docs: "By default, array values are separated by ;"
    if (values.nonEmpty && values.head != "") { // csv parser always adds one empty string entry...
      val parsedValues = values.map(parsePropertyValue(_, valueType))
      Some(ParsedProperty(name, parsedValues))
    } else {
      None
    }
  }

  private def parsePropertyValue(rawString: String, valueType: ColumnType.Value): Any = {
    valueType match {
      case ColumnType.Int           => rawString.toInt
      case ColumnType.Long          => rawString.toLong
      case ColumnType.Float         => rawString.toFloat
      case ColumnType.Double        => rawString.toDouble
      case ColumnType.Boolean       => rawString.toBoolean
      case ColumnType.Byte          => rawString.toByte
      case ColumnType.Short         => rawString.toShort
      case ColumnType.Char          => rawString.head
      case ColumnType.String        => rawString
      case ColumnType.Point         => ???
      case ColumnType.Date          => ???
      case ColumnType.LocalTime     => ???
      case ColumnType.Time          => ???
      case ColumnType.LocalDateTime => ???
      case ColumnType.DateTime      => ???
      case ColumnType.Duration      => ???
    }
  }

  private def parseInt(entry: String, columnType: ColumnType.Value, lineNo: Int): Int = {
    try entry.toInt
    catch {
      case err: Exception => throw new AssertionError(s"$columnType is not an Int ($lineNo): $entry: $err", err)
    }
  }

  private case class HeaderAndDataFile(headerFile: ParsedHeaderFile, dataFile: Path)
  private case class ParsedHeaderFile(fileType: FileType.Value, propertyByColumnIndex: Map[Int, ColumnDef])
  private case class ColumnDef(name: Option[String], valueType: ColumnType.Value, isArray: Boolean = false)
  private case class ParsedProperty(name: String, value: Any)
  private case class ParsedNodeRowData(id: Int, label: String, properties: Seq[ParsedProperty])
  private case class ParsedEdgeRowData(startId: Int, endId: Int, label: String, properties: Seq[ParsedProperty])
  private case class Neo4jNodeContext(newNode: DNode, properties: Seq[ParsedProperty])

}
