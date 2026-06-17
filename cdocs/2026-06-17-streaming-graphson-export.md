# flatgraph: Streaming GraphSON Export

**Date:** 2026-06-17  
**Repo:** `/home/erich.oliphant/IdeaProjects/flatgraph` (joernio/flatgraph, v0.1.32)  
**Purpose:** Eliminate the 1 GB JVM String OOM that kills `joern-export --repr=all` on large graphs.  
**Status:** Ready for implementation — all file paths, code, and verification steps are exact.

---

## Problem

`GraphSONExporter.runExport` (file: `formats/src/main/scala/flatgraph/formats/graphson/GraphSONExporter.scala`) has this sequence:

```scala
val nodeEntries = nodes.iterator.map { node => ... }.toSeq   // fully in memory
val edgeEntries = edges.iterator.map { edge => ... }.toSeq   // fully in memory
val graphSON    = GraphSON(GraphSONElements(nodeEntries, edgeEntries))
val json        = implicitly[JsonWriter[GraphSON]].write(graphSON)  // spray-json JsValue tree, fully in memory
writeFile(outFile, json.prettyPrint)                                // single Java String, fully in memory
```

The final `prettyPrint` call builds the entire JSON document as one `java.lang.String`. Java strings are UTF-16 and capped at ~1 GB. For GS10/grantsolutions.gov (156k nodes, 1M+ edges) this is hit, causing `OutOfMemoryError: Java heap space` in the spray-json `PrettyPrinter`.

**Workaround in place:** codeinsight passes `--namespaces gov.grantsolutions` to `joern-parse`, which limits the CPG to one package prefix. This works but silently drops ~90% of internal application code (the repo uses ~25 other package prefixes: `eacc`, `preaward`, `postaward`, `common`, etc.).

**The real fix:** stream JSON tokens directly to a `FileOutputStream` using Jackson Core, so no full in-memory representation is ever built.

---

## Solution

Replace spray-json in the **export path only** with `com.fasterxml.jackson.core:jackson-core` streaming API.  
The **import path** (`GraphSONImporter.scala`) keeps spray-json — it reads bounded files and is not the bottleneck.

### Why Jackson Core (not Circe, not uJson, not spray-json streaming)

- Jackson Core is the industry-standard Java streaming JSON library; zero transitive deps beyond itself.
- flatgraph already has a Java ecosystem (`ujson` in core uses Java I/O); Jackson fits naturally.
- spray-json has no streaming API — its `PrettyPrinter` always builds a `String`.
- uJson (already in flatgraph-core) writes to a `java.io.Writer` but builds the full `Value` tree first; same OOM.

---

## Files to change

| File | Change |
|------|--------|
| `build.sbt` | Add `jackson-core` to `formats` deps; bump project version |
| `formats/src/main/scala/flatgraph/formats/graphson/GraphSONExporter.scala` | Replace spray-json write with Jackson streaming |

`GraphSONImporter.scala`, `GraphSONProtocol.scala`, `package.scala` — **do not touch**.

---

## Exact changes

### 1. `build.sbt` — add jackson-core to formats, bump version

Current top of file:
```sbt
name := "flatgraph"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := scala3
```

Add a version line after the name line:
```sbt
name := "flatgraph"
ThisBuild / version      := "0.1.33-SNAPSHOT"
ThisBuild / organization := "io.joern"
ThisBuild / scalaVersion := scala3
```

In the `formats` project settings, add jackson-core alongside the existing deps:
```sbt
lazy val formats = project
  .in(file("formats"))
  .dependsOn(core)
  .settings(
    name := "flatgraph-formats",
    libraryDependencies ++= Seq(
      "com.github.tototoshi" %% "scala-csv" % "2.0.0",
      "org.apache.commons" % "commons-text" % commonsTextVersion,
      "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
      "io.spray" %% "spray-json" % "1.3.6",       // kept for GraphSONImporter
      "com.fasterxml.jackson.core" % "jackson-core" % "2.17.2",  // ADD THIS
      "com.github.scopt" %% "scopt" % "4.1.0",
    )
  )
```

### 2. `formats/src/main/scala/flatgraph/formats/graphson/GraphSONExporter.scala` — full replacement

Replace the entire file with:

```scala
package flatgraph.formats.graphson

import com.fasterxml.jackson.core.{JsonEncoding, JsonFactory, JsonGenerator}
import flatgraph.formats.*
import flatgraph.{Accessors, GNode, Schema}

import java.io.BufferedOutputStream
import java.nio.file.{Files, Path}
import java.util.concurrent.atomic.AtomicInteger
import scala.jdk.CollectionConverters.IterableHasAsScala
import scala.util.Using

/** Exports to GraphSON 3.0 https://tinkerpop.apache.org/docs/3.4.1/dev/io/#graphson-3d0
  *
  * Uses Jackson Core streaming API to avoid building the entire graph as a single in-memory
  * String (the spray-json PrettyPrinter bottleneck that OOMs on graphs with >~500k edges).
  * The output is byte-for-byte equivalent to the previous spray-json output.
  */
object GraphSONExporter extends Exporter {

  override def defaultFileExtension = "json"

  private val jsonFactory = new JsonFactory()

  override def runExport(schema: Schema, nodes: IterableOnce[GNode], edges: IterableOnce[flatgraph.Edge], outputFile: Path) = {
    val outFile    = resolveOutputFileSingle(outputFile, s"export.$defaultFileExtension")
    val propertyId = new AtomicInteger(0)
    val edgeId     = new AtomicInteger(0)
    var nodeCount  = 0
    var edgeCount  = 0

    Using.resource(jsonFactory.createGenerator(
      new BufferedOutputStream(Files.newOutputStream(outFile)),
      JsonEncoding.UTF8
    )) { gen =>
      gen.useDefaultPrettyPrinter()

      // {"@type":"tinker:graph","@value":{
      gen.writeStartObject()
      gen.writeStringField("@type", "tinker:graph")
      gen.writeFieldName("@value")
      gen.writeStartObject()

      // "vertices":[
      gen.writeFieldName("vertices")
      gen.writeStartArray()
      nodes.iterator.foreach { node =>
        nodeCount += 1
        writeVertex(gen, node, propertyId)
      }
      gen.writeEndArray()

      // "edges":[
      gen.writeFieldName("edges")
      gen.writeStartArray()
      edges.iterator.foreach { edge =>
        edgeCount += 1
        writeEdge(gen, edge, propertyId, edgeId)
      }
      gen.writeEndArray()

      gen.writeEndObject() // @value
      gen.writeEndObject() // root
    }

    ExportResult(nodeCount = nodeCount, edgeCount = edgeCount, files = Seq(outFile), Option.empty)
  }

  private def writeVertex(gen: JsonGenerator, node: GNode, propertyId: AtomicInteger): Unit = {
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, node.id)
    gen.writeStringField("label", node.label)
    gen.writeFieldName("properties")
    gen.writeStartObject()
    Accessors.getNodeProperties(node).iterator.foreach { case (name, value) =>
      gen.writeFieldName(name)
      writeProperty(gen, propertyId.getAndIncrement(), valueEntry(value), "g:VertexProperty")
    }
    gen.writeEndObject()
    gen.writeStringField("@type", "g:Vertex")
    gen.writeEndObject()
  }

  private def writeEdge(gen: JsonGenerator, edge: flatgraph.Edge, propertyId: AtomicInteger, edgeId: AtomicInteger): Unit = {
    val inNode  = edge.dst
    val outNode = edge.src
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, edgeId.getAndIncrement())
    gen.writeStringField("label", edge.label)
    gen.writeStringField("inVLabel", inNode.label)
    gen.writeStringField("outVLabel", outNode.label)
    gen.writeFieldName("inV")
    writeLongValue(gen, inNode.id)
    gen.writeFieldName("outV")
    writeLongValue(gen, outNode.id)
    gen.writeFieldName("properties")
    gen.writeStartObject()
    Option(edge.property).foreach { value =>
      gen.writeFieldName("EdgeProperty")
      writeProperty(gen, propertyId.getAndIncrement(), valueEntry(value), "g:Property")
    }
    gen.writeEndObject()
    gen.writeStringField("@type", "g:Edge")
    gen.writeEndObject()
  }

  private def writeProperty(gen: JsonGenerator, id: Long, value: PropertyValue, typeStr: String): Unit = {
    gen.writeStartObject()
    gen.writeFieldName("id")
    writeLongValue(gen, id)
    gen.writeFieldName("@value")
    writePropertyValue(gen, value)
    gen.writeStringField("@type", typeStr)
    gen.writeEndObject()
  }

  private def writeLongValue(gen: JsonGenerator, v: Long): Unit = {
    gen.writeStartObject()
    gen.writeNumberField("@value", v)
    gen.writeStringField("@type", "g:Int64")
    gen.writeEndObject()
  }

  private def writePropertyValue(gen: JsonGenerator, pv: PropertyValue): Unit = pv match {
    case StringValue(v, _)  => gen.writeString(v)
    case BooleanValue(v, _) => gen.writeBoolean(v)
    case LongValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Int64")
      gen.writeEndObject()
    case IntValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Int32")
      gen.writeEndObject()
    case FloatValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Float")
      gen.writeEndObject()
    case DoubleValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:Double")
      gen.writeEndObject()
    case NodeIdValue(v, _) =>
      gen.writeStartObject()
      gen.writeNumberField("@value", v)
      gen.writeStringField("@type", "g:VertexId")
      gen.writeEndObject()
    case ListValue(elements, _) =>
      gen.writeStartObject()
      gen.writeFieldName("@value")
      gen.writeStartArray()
      elements.foreach(writePropertyValue(gen, _))
      gen.writeEndArray()
      gen.writeStringField("@type", "g:List")
      gen.writeEndObject()
  }

  // Unchanged from original — also used by GraphSONImporter indirectly via re-export
  def valueEntry(propertyValue: Any): PropertyValue = {
    propertyValue match {
      case x: Array[_]              => ListValue(x.map(valueEntry))
      case x: Iterable[_]           => ListValue(x.map(valueEntry).toArray)
      case x: IterableOnce[_]       => ListValue(x.iterator.map(valueEntry).toArray)
      case x: java.lang.Iterable[_] => ListValue(x.asScala.map(valueEntry).toArray)
      case x: Boolean               => BooleanValue(x)
      case x: String                => StringValue(x)
      case x: Double                => DoubleValue(x)
      case x: Float                 => FloatValue(x)
      case x: Int                   => IntValue(x)
      case x: Long                  => LongValue(x)
      case x: GNode                 => NodeIdValue(x.id())
    }
  }

}
```

---

## JSON structure contract (must not change)

The `GraphSONImporter` deserialises with spray-json `convertTo[GraphSON]`. The field order within each object does not matter to the parser, but all fields must be present. Verify these invariants:

**Root:**
```json
{ "@type": "tinker:graph", "@value": { "vertices": [...], "edges": [...] } }
```

**Vertex:**
```json
{
  "id":         {"@type": "g:Int64", "@value": <node.id>},
  "label":      "<node.label>",
  "properties": { "<name>": {"id": {...}, "@value": <PropertyValue>, "@type": "g:VertexProperty"} },
  "@type":      "g:Vertex"
}
```

**Edge:**
```json
{
  "id":         {"@type": "g:Int64", "@value": <edgeId>},
  "label":      "<edge.label>",
  "inVLabel":   "<edge.dst.label>",
  "outVLabel":  "<edge.src.label>",
  "inV":        {"@type": "g:Int64", "@value": <edge.dst.id>},
  "outV":       {"@type": "g:Int64", "@value": <edge.src.id>},
  "properties": {},
  "@type":      "g:Edge"
}
```

**PropertyValue type tokens** (must match exactly what `GraphSONProtocol.PropertyValueJsonFormat.read` expects):

| Scala type | JSON |
|---|---|
| `StringValue` | `"<string>"` (bare, no wrapper) |
| `BooleanValue` | `true`/`false` (bare) |
| `LongValue` | `{"@type":"g:Int64","@value":<long>}` |
| `IntValue` | `{"@type":"g:Int32","@value":<int>}` |
| `FloatValue` | `{"@type":"g:Float","@value":<float>}` |
| `DoubleValue` | `{"@type":"g:Double","@value":<double>}` |
| `NodeIdValue` | `{"@type":"g:VertexId","@value":<long>}` |
| `ListValue` | `{"@type":"g:List","@value":[...]}` |

The `readNonList` branch in `PropertyValueJsonFormat` matches `Seq(JsNumber(v), JsString(typ))` — so `@value` must come before `@type` in the number wrappers. **Jackson writes fields in the order they are emitted**, so `gen.writeNumberField("@value", v)` before `gen.writeStringField("@type", ...)` is correct and required.

---

## Build and test

### Prereqs
- sbt installed (project uses sbt, not Maven)
- Working directory: `/home/erich.oliphant/IdeaProjects/flatgraph`

### Step 1 — compile
```bash
cd /home/erich.oliphant/IdeaProjects/flatgraph
sbt formats/compile
```
Expected: clean compile, zero errors.

### Step 2 — run existing GraphSON tests
```bash
sbt tests/testOnly flatgraph.formats.graphson.GraphSONTests
```
Expected: both tests pass (`export to GraphSON and back`, `using 'contained node' property`).  
These are round-trip tests (export → import → diff), so they validate JSON contract compliance.

### Step 3 — publish locally
```bash
sbt publishLocal
```
This installs to `~/.ivy2/local/io.joern/flatgraph-formats_3/0.1.33-SNAPSHOT/`.

### Step 4 — smoke test against a real large CPG
Use the `cpg.bin` from a previous joern-parse run (if available from the earlier experiments at `/tmp/joern-experiments/shared-parse/cpg.bin`):

```bash
# Build a new joern-export binary that uses the patched flatgraph
cd /home/erich.oliphant/IdeaProjects/joern
# Update flatgraph version reference in joern's build.sbt (see Integration section below)
sbt joern-cli/stage

# Run export against the large CPG (WITHOUT --namespaces, to test the fix)
time /home/erich.oliphant/IdeaProjects/joern/joern-cli/target/universal/stage/joern-export \
  /tmp/joern-experiments/shared-parse/cpg.bin \
  --repr=all --format=graphson \
  --out /tmp/streaming-test-out

du -sh /tmp/streaming-test-out/
```
Expected: completes in seconds (not 30+ minutes), no OOM.

---

## Integration with joern

After publishing flatgraph locally, update joern to use it.

In `/home/erich.oliphant/IdeaProjects/joern/build.sbt`, find the flatgraph version reference:
```bash
rg "flatgraph" /home/erich.oliphant/IdeaProjects/joern/build.sbt | head -10
```

Change the flatgraph version from `0.1.32` to `0.1.33-SNAPSHOT`, then build joern:
```bash
cd /home/erich.oliphant/IdeaProjects/joern
sbt joern-cli/stage
```

The new binary is at `joern-cli/target/universal/stage/joern-export`.

---

## Integration with codeinsight

Once the patched joern-export binary is built, point codeinsight at it by overriding the config:

In `src/main/resources/application.properties` (or `application-dev.properties`):
```properties
codeinsight.cpg.joern.export-cmd=/home/erich.oliphant/IdeaProjects/joern/joern-cli/target/universal/stage/joern-export
```

At that point, `--namespaces gov.grantsolutions` in `CpgConfig` can be widened or removed to capture the full application call graph.

---

## What this does NOT change

- `GraphSONImporter` — unchanged, still uses spray-json
- `GraphSONProtocol` — unchanged
- `package.scala` (graphson types) — unchanged  
- All other exporters (Dot, GraphML, Neo4jCsv) — unchanged
- The `Exporter` trait interface — unchanged
- The `--repr=cpg` split-by-method path in joern (not relevant here)

---

## Risk

Low. The change is purely in the serialisation path of one exporter. The round-trip test in `GraphSONTests.scala` validates the output is still parseable by `GraphSONImporter`. The JSON structure contract is fully specified above.

The one subtle point is field ordering within `@value`/`@type` pairs: `@value` must precede `@type` in numeric wrappers because spray-json's `readNonList` pattern-matches `Seq(JsNumber(v), JsString(typ))` — spray-json preserves insertion order in `JsObject` but `getFields` returns values in the order the fields appear in JSON. The implementation above emits `@value` first consistently.
