package io.joern.joernBench
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.{BenchmarkParams, Blackhole}
import org.openjdk.jmh.profile
import org.openjdk.jmh.runner.options.{OptionsBuilder, TimeValue}
import overflowdb.traversal.jIteratortoTraversal

import java.util.concurrent.TimeUnit
import scala.util.Random
object JmhMain {

  def jmhMain(): Unit = {
    val opt = new OptionsBuilder()
      .include(classOf[JoernGenerated].getSimpleName)
      .include(classOf[JoernLegacy].getSimpleName)
      .include(classOf[Odb2Generated].getSimpleName)
      // .addProfiler(classOf[profile.GCProfiler])
      // .addProfiler(classOf[profile.LinuxPerfNormProfiler])
      // .addProfiler(classOf[profile.LinuxPerfAsmProfiler], "tooBigThreshold=5000")
      .warmupIterations(2)
      .warmupTime(TimeValue.seconds(2))
      .measurementTime(TimeValue.seconds(2))
      .measurementIterations(5)
      .mode(Mode.AverageTime)
      .timeUnit(TimeUnit.NANOSECONDS)
      .forks(1)
      .output("./jmhResults.txt")
      .detectJvmArgs() // inherit stuff like max heap size
      .build()
    new Runner(opt).run()
  }

  def setOps(params: BenchmarkParams, ops: Int): Unit = {
    var field: java.lang.reflect.Field = null
    var clazz: Class[_]                = params.getClass
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
class JoernGenerated {
  import io.shiftleft.codepropertygraph.generated.Cpg
  import io.shiftleft.codepropertygraph.generated.nodes.{StoredNode, AstNode}

  @Param(Array("true", "false"))
  var shuffled: Boolean = _

  private var cpg: Cpg                     = _
  private var nodeStart: Array[StoredNode] = null

  @Setup
  def setupFun(params: BenchmarkParams): Unit = {
    cpg = Bench.loadCopyFile("./cpg.bin")
    params.getBenchmark match {
      case name if name.endsWith("astDFS") =>
        nodeStart =
          cpg.graph.nodes().collect { case astNode: StoredNode if !astNode._astIn.hasNext && astNode._astOut.hasNext => astNode }.toArray
        JmhMain.setOps(params, astDFS(null))
      case name if name.endsWith("astUp") =>
        nodeStart = cpg.graph.nodes().collect { case astNode: StoredNode => astNode }.toArray
        JmhMain.setOps(params, astUp(null))
      case name if name.endsWith("orderSum") =>
        nodeStart = cpg.graph.nodes().collect { case astNode: AstNode => astNode.asInstanceOf[StoredNode] }.toArray
        JmhMain.setOps(params, nodeStart.length)
    }
    if (shuffled) {
      nodeStart = new Random(1234).shuffle(nodeStart.iterator).toArray
    }
  }

  @Benchmark
  def astDFS(blackhole: Blackhole): Int = {
    val stack = scala.collection.mutable.ArrayDeque[StoredNode]()
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
  def orderSum(blackhole: Blackhole): Int = {
    var sumOrder = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[AstNode]]) {
      sumOrder += node.order
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }
}

@State(Scope.Benchmark)
class JoernLegacy {
  import io.shiftleft.codepropertygraph.generated.Cpg
  import io.shiftleft.codepropertygraph.generated.nodes.StoredNode
  import io.shiftleft.codepropertygraph.generated.nodes

  @Param(Array("true", "false"))
  var shuffled: Boolean = _

  private var cpg: overflowdb.Graph             = _
  private var nodeStart: Array[overflowdb.Node] = null

  @Setup
  def setupFun(params: BenchmarkParams): Unit = {
    cpg = Bench.loadCopyFile("./cpg.bin").graph
    params.getBenchmark match {
      case name if name.endsWith("astDFS") =>
        nodeStart =
          cpg.nodes().collect { case astNode: StoredNode if !astNode._astIn.hasNext && astNode._astOut.hasNext => astNode }.toArray
        JmhMain.setOps(params, astDFS(null))
      case name if name.endsWith("astUp") =>
        nodeStart = cpg.nodes().toArray
        JmhMain.setOps(params, astUp(null))
      case name if name.endsWith("orderSum") =>
        nodeStart = cpg.nodes().collect { case astNode: nodes.AstNode => astNode.asInstanceOf[StoredNode] }.toArray
        JmhMain.setOps(params, nodeStart.length)
    }
    if (shuffled) {
      nodeStart = new Random(1234).shuffle(nodeStart.iterator).toArray
    }
  }

  @Benchmark
  def astDFS(blackhole: Blackhole): Int = {
    val stack = scala.collection.mutable.ArrayDeque[overflowdb.Node]()
    stack.addAll(nodeStart)
    var nnodes = nodeStart.size
    while (stack.nonEmpty) {
      val nx = stack.removeLast()
      stack.appendAll(nx.out("AST"))
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
        p = p.in("AST").nextOption.orNull
      }
    }
    if (blackhole != null) blackhole.consume(sumDepth)
    sumDepth
  }

  @Benchmark
  def orderSum(blackhole: Blackhole): Int = {
    var sumOrder = 0
    for (node <- nodeStart) {
      sumOrder += node.property("ORDER").asInstanceOf[Int]
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }
}

@State(Scope.Benchmark)
class Odb2Generated {
  import io.shiftleft.codepropertygraph.generated.v2
  import io.joern.odb2

  @Param(Array("true", "false"))
  var shuffled: Boolean = _

  private var cpg: odb2.Graph                       = _
  private var nodeStart: Array[v2.nodes.StoredNode] = null

  @Setup
  def setupFun(params: BenchmarkParams): Unit = {
    cpg = odb2.storage.Deserialization.readGraph("./cpg.fg", v2.GraphSchema)
    params.getBenchmark match {
      case name if name.endsWith("astDFS") =>
        nodeStart = cpg._nodes.iterator.flatMap { nodesOfKind =>
          nodesOfKind.iterator.collect {
            case astNode: v2.nodes.StoredNode if astNode._astIn.isEmpty && astNode._astOut.nonEmpty => astNode
          }
        }.toArray
        JmhMain.setOps(params, astDFS(null))
      case name if name.endsWith("astUp") =>
        nodeStart = cpg._nodes.flatMap {
          _.iterator.asInstanceOf[Iterator[v2.nodes.StoredNode]]
        }
        JmhMain.setOps(params, astUp(null))
      case name if name.contains("orderSum") =>
        nodeStart = cpg._nodes.iterator.flatMap { nodesOfKind =>
          nodesOfKind.iterator.collect { case astNode: v2.nodes.AstNode =>
            astNode.asInstanceOf[v2.nodes.StoredNode]
          }
        }.toArray
        JmhMain.setOps(params, nodeStart.length)
    }

    if (shuffled) {
      nodeStart = new Random(1234).shuffle(nodeStart.iterator).toArray
    }
  }

  @Benchmark
  def astDFS(blackhole: Blackhole): Int = {
    val stack = scala.collection.mutable.ArrayDeque[v2.nodes.StoredNode]()
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
        p = p._astIn.headOption.orNull
      }
    }
    if (blackhole != null) blackhole.consume(sumDepth)
    sumDepth
  }

  @Benchmark
  def orderSumChecked(blackhole: Blackhole): Int = {
    import v2.accessors.Lang._
    var sumOrder = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[v2.nodes.AstNode]]) {
      // we use a checked cast to ensure that our node is an AST-node (i.e. implements the AstNode interface)
      sumOrder += node.order
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }

  @Benchmark
  def orderSumUnchecked(blackhole: Blackhole): Int = {
    import v2.accessors.Lang._
    var sumOrder = 0
    for (node <- nodeStart.iterator.asInstanceOf[Iterator[v2.nodes.StoredNode with v2.nodes.StaticType[v2.nodes.AstNodeT]]]) {
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
    val prop     = nodeStart.head.graph.schema.getPropertyIdByLabel("ORDER")
    for (node <- nodeStart) {
      sumOrder += odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, prop, node.seq(), -1)
    }
    if (blackhole != null) blackhole.consume(sumOrder)
    sumOrder
  }
}
