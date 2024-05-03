package flatgraph.benchmark

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.{BenchmarkParams, Blackhole}
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.{OptionsBuilder, TimeValue}

import java.nio.file.Paths
import scala.compiletime.uninitialized
import java.util.concurrent.TimeUnit
import scala.util.Random

object JmhBenchmarks {
  val JmhOutputFile = "benchmarks/target/output.txt"
  val JmhResultFile = "benchmarks/target/results.csv"

  def jmhMain(): Unit = {
    val opt = new OptionsBuilder()
      // .include(".*indexed.*")
      .include(classOf[FlatgraphGenerated].getSimpleName)
      // .addProfiler(classOf[profile.GCProfiler])
      // .addProfiler(classOf[profile.LinuxPerfNormProfiler])
      // .addProfiler(classOf[profile.LinuxPerfAsmProfiler], "tooBigThreshold=5000")
      .warmupIterations(1)
      .warmupTime(TimeValue.seconds(1))
      .measurementTime(TimeValue.seconds(2))
      .measurementIterations(3)
      .mode(Mode.AverageTime)
      .timeUnit(TimeUnit.NANOSECONDS)
      .forks(2)
      .output(JmhOutputFile)
      .result(JmhResultFile)
      .detectJvmArgs() // inherit stuff like max heap size
      .build()
    new Runner(opt).run()
    println(s"Finished JMH benchmarks. Results: $JmhResultFile; Output: $JmhOutputFile")
  }

  def setOps(params: BenchmarkParams, ops: Int): Unit = {
    var field: java.lang.reflect.Field = null
    var clazz: Class[?]                = params.getClass
    while (field == null) {
      field = clazz.getDeclaredFields
        .find {
          _.getName == "opsPerInvocation"
        }
        .getOrElse(null)
      clazz = clazz.getSuperclass
    }
    field.setAccessible(true)
    field.setInt(params, ops)
  }
}

@State(Scope.Benchmark)
class FlatgraphGenerated {
  import io.shiftleft.codepropertygraph.generated.{Cpg, CpgNodeStarters, GraphSchema}
  import io.shiftleft.codepropertygraph.generated.nodes.{AstNode, AstNodeEMT, Call, StaticType, StoredNode}
  import io.shiftleft.codepropertygraph.generated.accessors.Lang.*
  import io.shiftleft.codepropertygraph.generated.traversals.Lang.*

  @Param(Array("true", "false"))
  var shuffled: Boolean = uninitialized

  private var cpg: Cpg                     = uninitialized
  private var nodeStart: Array[StoredNode] = new Array[StoredNode](0)
  private var fullnames: Array[String]     = uninitialized

  @Setup
  def setupFun(params: BenchmarkParams): Unit = {
    cpg = new Cpg(flatgraph.storage.Deserialization.readGraph(Paths.get("./cpg.fg"), Option(GraphSchema)))
    params.getBenchmark match {
      case name if name.endsWith("astDFS") =>
        nodeStart = cpg.graph.nodesArray.iterator.flatMap { nodesOfKind =>
          nodesOfKind.iterator.collect {
            case astNode: StoredNode if astNode._astIn.isEmpty && astNode._astOut.nonEmpty => astNode
          }
        }.toArray
        JmhBenchmarks.setOps(params, astDFS(null))
      case name if name.endsWith("astUp") =>
        nodeStart = cpg.graph.nodesArray.flatMap {
          _.iterator.asInstanceOf[Iterator[StoredNode]]
        }
        JmhBenchmarks.setOps(params, astUp(null))
      case name if name.contains("orderSum") =>
        nodeStart = cpg.graph.nodesArray.iterator.flatMap { nodesOfKind =>
          nodesOfKind.iterator.collect { case astNode: AstNode =>
            astNode.asInstanceOf[StoredNode]
          }
        }.toArray
        JmhBenchmarks.setOps(params, nodeStart.length)
      case name if name.contains("callOrder") =>
        nodeStart = cpg.graph.nodesArray.iterator.flatMap { nodesOfKind =>
          nodesOfKind.iterator.collect { case node: Call =>
            node.asInstanceOf[StoredNode]
          }
        }.toArray
        JmhBenchmarks.setOps(params, nodeStart.length)
      case name if name.contains("MethodFullName") =>
        if (shuffled)
          fullnames = new Random(1234).shuffle(new CpgNodeStarters(cpg).method.fullName.iterator).toArray
        else
          fullnames =
            new Random(1234).shuffle(new CpgNodeStarters(cpg).method.fullName.iterator.map { name => name + "lolnope" }).toArray
        fullnames = fullnames.slice(0, math.min(1000, fullnames.length))
        JmhBenchmarks.setOps(params, fullnames.length)
    }

    if (shuffled) {
      nodeStart = new Random(1234).shuffle(nodeStart.iterator).toArray
    }
  }

  @Benchmark
  def astDFS(blackhole: Blackhole): Int = {
    val stack = scala.collection.mutable.ArrayDeque.empty[StoredNode]
    stack.addAll(nodeStart)
    var nnodes = nodeStart.size
    while (stack.nonEmpty) {
      val nx = stack.removeLast()
      stack.appendAll(nx._astOut)
      nnodes += 1
    }
    if (blackhole != null) blackhole.consume(nnodes)
    nnodes
  }

  @Benchmark
  def astUp(blackhole: Blackhole): Int = {
    var sumDepth = 0
    for (node <- nodeStart) {
      var p = node
      while (p != null) {
        sumDepth += 1
        p = p._astIn.nextOption.orNull
      }
    }
    if (blackhole != null) blackhole.consume(sumDepth)
    sumDepth
  }

  @Benchmark
  def orderSumChecked(blackhole: Blackhole): Int = {
    var sumOrder = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[AstNode]]) {
      // we use a checked cast to ensure that our node is an AST-node (i.e. implements the AstNode interface)
      sumOrder += node.order
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }

  @Benchmark
  def orderSumUnchecked(blackhole: Blackhole): Int = {
    var sumOrder = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[StoredNode & StaticType[AstNodeEMT]]]) {
      // we use an unchecked cast to claim that our node is an AST-node.
      // the difference is type-erased so that should be a no-op.
      // on the other hand, we won't get classCast exceptions on mistakes, only silent type confusion bugs.
      sumOrder += node.order
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }

  @Benchmark
  def orderSumExplicit(blackhole: Blackhole): Int = {
    var sumOrder = 0
    val prop     = nodeStart.head.graph.schema.getPropertyKindByName("ORDER")
    for (node <- nodeStart) {
      sumOrder += flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, prop, node.seq(), -1)
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }

  @Benchmark
  def callOrderTrav(blackhole: Blackhole): Int = {
    val res = nodeStart.iterator.asInstanceOf[Iterator[Call]].orderGt(2).size
    if (blackhole != null) blackhole.consume(res)
    res
  }

  @Benchmark
  def callOrderExplicit(blackhole: Blackhole): Int = {
    var res = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[Call]]) {
      if (node.order > 2) res += 1
    }
    if (blackhole != null) blackhole.consume(res)
    res
  }

  @Benchmark
  def indexedMethodFullName(bh: Blackhole): Unit = {
    fullnames.foreach { fullName =>
      new CpgNodeStarters(cpg).method.fullNameExact(fullName).foreach(bh.consume)
    }
  }

  @Benchmark
  def unindexedMethodFullName(bh: Blackhole): Unit = {
    for {
      str   <- fullnames
      found <- new CpgNodeStarters(cpg).method.filter { _ => true }.fullNameExact(str)
    } bh.consume(found)
  }

}
