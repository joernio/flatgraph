package io.joern.joernBench
import better.files.Dsl.cp
import com.jerolba.jmnemohistosyne.{Histogramer, MemoryHistogram}
import io.joern.odb2
import io.shiftleft.codepropertygraph.cpgloading.{CpgLoader, CpgLoaderConfig}
import io.shiftleft.codepropertygraph.generated.Cpg
import overflowdb.Config

import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.util.{Success, Try}

object Bench {

  // generic stuff for measuring memory consumption
  class MeasurementBox {
    var timeNanos = -1L
    // the @volatile is really just to disincentivize the jvm from clearing up writes to the result
    @volatile var result: Any            = null
    @volatile var histo: MemoryHistogram = null

    def clear(): Unit = {
      result = null
    }
  }

  def measure(code: => Any): MeasurementBox = {
    val box = new MeasurementBox
    box.histo = Histogramer.getDiff(() => {
      val tic = System.nanoTime()
      box.result = code
      val toc = System.nanoTime()
      box.timeNanos = toc - tic
    })
    box
  }

  def modHisto(histo: MemoryHistogram, top: Int, nodecount: Int): (Long, String) = {
    val lst = histo
      .iterator()
      .asScala
      .toBuffer
      .sortBy(e => -scala.math.abs(e.getSize))
      .take(if (top > 0) top else java.lang.Integer.MAX_VALUE)
      .filter { _.getInstances != 0 }
    val total = lst.iterator.map { e => e.getSize }.sum
    val str = lst.iterator
      .map { e =>
        s"${e.getClassName}, ${e.getInstances}, ${e.getSize}, ${e.getInstances * 1.0 / nodecount},  ${e.getSize * 1.0 / e.getInstances}, ${e.getSize * 1.0 / nodecount}"
      }
      .mkString("Class, #instances, total size, instances/node, bytes/instance, bytes/node\n", "\n", "")
    (total, str)
  }

  def printHisto(sect: String, box: MeasurementBox, nodecount: Int): Unit = {
    println(
      s"\n<=========\nRunning ${sect} in ${box.timeNanos} ns  == ${box.timeNanos * 1e-6} ms == ${box.timeNanos * 1e-3 / nodecount} us/node and costing ${box.histo.getTotalMemory} bytes == ${box.histo.getTotalMemory * 1.0 / (1 << 20)} MB == ${box.histo.getTotalMemory * 1.0 / nodecount} bytes/node."
    )
    val top20 = modHisto(box.histo, 20, nodecount)
    println(s"Top 20 account for ${top20._1 * 100.0 / box.histo.getTotalMemory}%:")
    println(top20._2)
    println("=========>\n\n")
  }

  def printMemConsumerLayout(histogram: MemoryHistogram): Unit = {
    println(s"VM details according to JOL: ${org.openjdk.jol.vm.VM.current().details()}. Layout of top consumers: \n\n")
    println(
      histogram
        .iterator()
        .asScala
        .toBuffer
        .sortBy(e => -scala.math.abs(e.getSize))
        .take(20)
        .flatMap { e =>
          Try(Class.forName(e.getClassName)) match {
            case Success(v) => Some(v)
            case _          => None
          }
        }
        .iterator
        .map { c =>
          org.openjdk.jol.info.ClassLayout.parseClass(c).toPrintable
        }
        .mkString("\n\n")
    )
  }

  // cpg loading
  def loadCopyFile(filename: String): Cpg = {
    val newLoc = better.files.File(filename + ".tmp")
    cp(better.files.File(filename), newLoc)
    val odbConfig = Config.withDefaults.withStorageLocation(newLoc.toString())
    val config    = CpgLoaderConfig.withDefaults.doNotCreateIndexesOnLoad.withOverflowConfig(odbConfig)
    CpgLoader.loadFromOverflowDb(config)
  }

  def makeIndices(cpg: Cpg): Unit = {
    CpgLoader.createIndexes(cpg)
  }

  def touchGraph(cpg: Cpg): Int = {
    cpg.graph.edgeCount()
  }

  def touchGraph(graph: odb2.Graph): Int = {
    var count = 0
    for {
      nodesArray <- graph._nodes
      edgeKind   <- Range(0, graph.schema.getNumberOfEdgeKinds).iterator
      node       <- nodesArray
    } count += odb2.Accessors.getNeighborsOut(node, edgeKind).length

    count
  }

  def loadOdb2(filename: String, schema: odb2.Schema): odb2.Graph = {
    odb2.storage.Deserialization.readGraph(filename, schema)
  }

  def benchJoern(): Unit = {
    println(
      s"VM is version ${System.getProperty("java.runtime.version")} with max heap ${java.lang.Runtime.getRuntime.maxMemory >> 20} mb.\n\n"
    )
    val box = new MeasurementBox
    box.histo = new Histogramer().createHistogram()
    val cpgBox    = measure { loadCopyFile("./cpg.bin") }
    val nodecount = cpgBox.result.asInstanceOf[Cpg].graph.nodeCount()
    val callcount = cpgBox.result.asInstanceOf[Cpg].graph.nodeCount("CALL")
    val indexify  = measure { makeIndices(cpgBox.result.asInstanceOf[Cpg]) }
    val touch1    = measure { touchGraph(cpgBox.result.asInstanceOf[Cpg]) }
    val touch2    = measure { touchGraph(cpgBox.result.asInstanceOf[Cpg]) }
    val close     = measure { cpgBox.result.asInstanceOf[Cpg].close() }
    val filesize  = new java.io.File("./cpg.bin").length()
    println(s"Graph with ${nodecount} nodes (${callcount} calls) and ${touch1.result} edges.")
    val histoAfter = new Histogramer().createHistogram()
    box.histo = histoAfter.diff(box.histo)
    val free = measure { cpgBox.result = null }
    box.timeNanos = cpgBox.timeNanos + indexify.timeNanos + touch1.timeNanos + touch2.timeNanos
    println(
      s"On disk ${filesize} bytes = ${filesize * 1.0 / nodecount} bytes/node.\n" +
        s"Loading data from disk at ${box.timeNanos * 1.0 / filesize} ns/byte and filling the heap at ${box.timeNanos * 1.0 / box.histo.getTotalMemory} ns/byte."
    )
    printHisto("complete benchmark", box, nodecount)
    printHisto("copy and load cpg file", cpgBox, nodecount)
    printHisto("load/create indexes", indexify, nodecount)
    printHisto("count edges (force complete loading)", touch1, nodecount)
    printHisto("count edges again", touch2, nodecount)
    printHisto("close graph", close, nodecount)
    printHisto("free memory", free, nodecount)
    printMemConsumerLayout(box.histo)
  }

  def benchOdb2(): Unit = {
    println(
      s"VM is version ${System.getProperty("java.runtime.version")} with max heap ${java.lang.Runtime.getRuntime.maxMemory >> 20} mb.\n\n"
    )
    val box = new MeasurementBox
    box.histo = new Histogramer().createHistogram()
    val cpgBox = measure {
      loadOdb2("./cpg.fg", null)
    }
    val touch1 = measure {
      touchGraph(cpgBox.result.asInstanceOf[odb2.Graph])
    }
    val touch2 = measure {
      touchGraph(cpgBox.result.asInstanceOf[odb2.Graph])
    }
    val nodecount = cpgBox.result.asInstanceOf[odb2.Graph].nnodes.sum
    val filesize  = new java.io.File("./cpg.fg").length()
    val (nnodeKinds, npropKinds, nEdgeKinds) = Some(cpgBox.result.asInstanceOf[odb2.Graph].schema).map { s =>
      (s.getNumberOfNodeKinds, s.getNumberOfProperties, s.getNumberOfEdgeKinds)
    }.get
    println(
      s"Graph with ${nodecount} nodes and ${touch1.result} edges. There are ${nnodeKinds} node kinds, ${npropKinds} property kinds and ${nEdgeKinds} edge kinds."
    )
    val histoAfter = new Histogramer().createHistogram()
    box.histo = histoAfter.diff(box.histo)
    val free = measure {
      cpgBox.result = null
    }
    box.timeNanos = cpgBox.timeNanos + touch1.timeNanos + touch2.timeNanos
    println(
      s"On disk ${filesize} bytes = ${filesize * 1.0 / nodecount} bytes/node.\n" +
        s"Loading data from disk at ${box.timeNanos * 1.0 / filesize} ns/byte and filling the heap at ${box.timeNanos * 1.0 / box.histo.getTotalMemory} ns/byte."
    )
    printHisto("complete benchmark", box, nodecount)
    printHisto("load flat cpg file", cpgBox, nodecount)
    printHisto("count edges (force complete loading)", touch1, nodecount)
    printHisto("count edges again", touch2, nodecount)
    printHisto("free memory", free, nodecount)
    printMemConsumerLayout(box.histo)
  }

}
