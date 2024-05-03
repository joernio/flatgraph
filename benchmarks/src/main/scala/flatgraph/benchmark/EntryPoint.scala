package flatgraph.benchmark

object EntryPoint {
  def main(args: Array[String]): Unit = {
    args(0) match {
      case "jmh"       => JmhBenchmarks.jmhMain()
      case "flatgraph" => LoadingAndMemoryBenchmarks.benchFlatgraph()
    }
  }

}
