package io.joern.joernBench
import better.files.Dsl.cp
import com.jerolba.jmnemohistosyne.{HistogramEntry, Histogramer, MemoryHistogram}
import io.shiftleft.codepropertygraph.cpgloading.{CpgLoader, CpgLoaderConfig}
import io.shiftleft.codepropertygraph.generated.Cpg
import overflowdb.Config

import scala.jdk.CollectionConverters.IteratorHasAsScala

object Bench {

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

  def modHisto(histo: MemoryHistogram, top: Int, nodecount: Int): (Long, String) = {
    val lst = histo
      .iterator()
      .asScala
      .toBuffer
      .sortBy { e: HistogramEntry => -scala.math.abs(e.getSize) }
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

  def main(args: Array[String]): Unit = {
    println(
      s"VM is version ${System.getProperty("java.runtime.version")} with max heap ${java.lang.Runtime.getRuntime.maxMemory >> 20} mb.\n\n"
    )
    val box = new MeasurementBox
    box.histo = new Histogramer().createHistogram()
    val cpgBox    = measure { loadCopyFile(args(0)) }
    val nodecount = cpgBox.result.asInstanceOf[Cpg].graph.nodeCount()
    val callcount = cpgBox.result.asInstanceOf[Cpg].graph.nodeCount("CALL")
    val indexify  = measure { makeIndices(cpgBox.result.asInstanceOf[Cpg]) }
    val touch1    = measure { touchGraph(cpgBox.result.asInstanceOf[Cpg]) }
    val touch2    = measure { touchGraph(cpgBox.result.asInstanceOf[Cpg]) }
    val close     = measure { cpgBox.result.asInstanceOf[Cpg].close() }
    println(s"Graph with ${nodecount} nodes (${callcount} calls) and ${touch1.result} edges at ${args(0)}")
    val histoAfter = new Histogramer().createHistogram()
    box.histo = histoAfter.diff(box.histo)
    val free = measure { cpgBox.result = null }
    box.timeNanos = cpgBox.timeNanos + indexify.timeNanos + touch1.timeNanos + touch2.timeNanos + free.timeNanos
    printHisto("complete benchmark", box, nodecount)
    printHisto("copy and load cpg file", cpgBox, nodecount)
    printHisto("load/create indexes", indexify, nodecount)
    printHisto("count edges (force complete loading)", touch1, nodecount)
    printHisto("count edges again", touch2, nodecount)
    printHisto("close graph", close, nodecount)
    printHisto("free memory", free, nodecount)

  }

}
