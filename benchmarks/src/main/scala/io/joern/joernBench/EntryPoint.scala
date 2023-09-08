package io.joern.joernBench

object EntryPoint {
  def main(args: Array[String]): Unit = {
    args(0) match {
      case "jmh"  => JmhMain.jmhMain()
      case "odb"  => Bench.benchJoern()
      case "odb2" => Bench.benchOdb2()
    }
  }

}
