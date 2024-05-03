package flatgraph.benchmark

import better.files.Dsl.cp
import com.jerolba.jmnemohistosyne.{Histogramer, MemoryHistogram}
import io.shiftleft.codepropertygraph.cpgloading.CpgLoader
import io.shiftleft.codepropertygraph.generated.Cpg

import java.nio.file.{Path, Paths}
import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.util.{Success, Try}

object LoadingAndMemoryBenchmarks {

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

  def touchGraph(graph: flatgraph.Graph): Int = {
    var count = 0
    for {
      nodesArray <- graph.nodesArray
      edgeKind   <- graph.schema.edgeKinds.iterator
      node       <- nodesArray
    } count += flatgraph.Accessors.getNeighborsOut(node, edgeKind).length

    count
  }

  def loadFlatgraph(storagePath: Path, schema: flatgraph.Schema): flatgraph.Graph = {
    flatgraph.storage.Deserialization.readGraph(storagePath, Option(schema))
  }

  def benchFlatgraph(): Unit = {
    println(
      s"VM is version ${System.getProperty("java.runtime.version")} with max heap ${java.lang.Runtime.getRuntime.maxMemory >> 20} mb.\n\n"
    )
    val box = new MeasurementBox
    box.histo = new Histogramer().createHistogram()
    val cpgBox = measure {
      loadFlatgraph(Paths.get("./cpg.fg"), null)
    }
    val touch1 = measure {
      touchGraph(cpgBox.result.asInstanceOf[flatgraph.Graph])
    }
    val touch2 = measure {
      touchGraph(cpgBox.result.asInstanceOf[flatgraph.Graph])
    }
    val nodecount = cpgBox.result.asInstanceOf[flatgraph.Graph].livingNodeCountByKind.sum
    val filesize  = new java.io.File("./cpg.fg").length()
    val (nnodeKinds, npropKinds, nEdgeKinds) = Some(cpgBox.result.asInstanceOf[flatgraph.Graph].schema).map { s =>
      (s.getNumberOfNodeKinds, s.getNumberOfPropertyKinds, s.getNumberOfEdgeKinds)
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
