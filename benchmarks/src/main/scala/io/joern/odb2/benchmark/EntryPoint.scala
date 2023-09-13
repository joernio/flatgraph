package io.joern.odb2.benchmark

object EntryPoint {
  def main(args: Array[String]): Unit = {
    args(0) match {
      case "jmh"  => JmhBenchmarks.jmhMain()
      case "odb"  => LoadingAndMemoryBenchmarks.benchJoern()
      case "odb2" => LoadingAndMemoryBenchmarks.benchOdb2()
    }
  }

}