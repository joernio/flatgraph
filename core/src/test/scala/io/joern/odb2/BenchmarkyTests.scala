package io.joern.odb2
import io.joern.odb2._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scala.collection.mutable

object BenchSchema extends io.joern.odb2.Schema {
  override def getNumberOfNodeKinds: Int = 10

  override def getNumberOfEdgeKinds: Int = 3

  override def getNumberOfProperties: Int = 3

  override def makeNode(graph: Graph, nodeKind: Short, seq: Int): GNode = new GNode(graph, nodeKind, seq)

  override def makeEdge(src: GNode, dst: GNode, edgeKind: Short, subSeq: Int, property: Any): Edge =
    new Edge(src, dst, edgeKind, subSeq, property)

  override def allocateEdgeProperty(nodeKind: Int, inout: Int, edgeKind: Int, size: Int): Array[_] = ???

  override def edgePropertyDefaultValue(nodeKind: Int, inout: Int, edgeKind: Int): DefaultValue = new DefaultValue(null)

  override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_] = new Array[String](size)
}

object TestStuff {

  def timeIt[R](fun: () => R): (Long, R) = {
    val tic = System.nanoTime()
    val res = fun()
    val toc = System.nanoTime()
    (toc - tic, res)
  }

  def mkGraph(rngSeed: Long, nKinds: Int, size: Int): Graph = {
    val g      = new Graph(BenchSchema)
    val rng    = new scala.util.Random(rngSeed)
    val diff   = new DiffGraphBuilder
    val buffer = mutable.ArrayBuffer[DNode]()
    // ensure that there is a node of kind 0
    val node = new GenericDNode(0.toShort)
    buffer.addOne(node)
    diff.addNode(node)

    for (_ <- Range(1, size)) {
      val node = new GenericDNode(rng.between(0, nKinds).toShort)
      buffer.addOne(node)
      diff.addNode(node)
    }
    rng.setSeed(rngSeed + 1)
    val permutation = rng.shuffle(Range(0, size).iterator).toArray
    for (idx <- Range(0, size - 1)) {
      diff.addEdge(buffer(permutation(idx)), buffer(permutation(idx + 1)), 0)
    }
    diff.addEdge(buffer(permutation(size - 1)), buffer(permutation(0)), 0)
    DiffGraphApplier.applyDiff(g, diff)
    g
  }

  def traverse(g: Graph): Int = {
    var count   = 0
    val initial = g._nodes(0)(0)
    var current = initial
    while (true) {
      current = Accessors.getNeighborsOut(current, 0).head
      count += 1
      if (current == initial) return count
    }
    ???
  }

  def mkPseudoGraph(rngSeed: Long, pad: Int, size: Int): Array[Int] = {
    val rng         = new scala.util.Random(rngSeed)
    val permutation = rng.shuffle(Range(0, size).iterator).toArray
    val res         = new Array[Int](size * pad)
    for (idx <- Range(0, size - 1)) {
      res(pad * permutation(idx)) = pad * permutation(idx + 1)
    }
    res(pad * permutation(size - 1)) = pad * permutation(0)
    res
  }

  def traverse(g: Array[Int]): Int = {
    var count   = 0
    val initial = g(0)
    var current = initial
    while (true) {
      current = g(current)
      count += 1
      if (current == initial) return count
    }
    ???
  }

}

class BenchmarkyTests extends AnyWordSpec with Matchers {
  import TestStuff._
  "Basic latency tests" should {
    val size = 100 * 1000
    val pad  = 16

    /*with size=10M we get stable ~200 ns/element. This makes sense: Each neighbor iter requires 3 memory fetches
     * At lower numbers we timing is significantly faster, presumably because eventually most relevant memory is in
     * at least L3.*/
    "work with a graph" in {
      //  val (tconstruct_gg, gg) = timeIt { () => mkGraph(42, 3, size) }
      // println(s"Build time graph gg (size = $size): ${tconstruct_gg / 1e6} ms = ${tconstruct_gg * 1.0 / size} ns/element")
      val (tconstruct_g, g) = timeIt { () => mkGraph(42, 3, size) }
      // println(s"Build time graph g: ${tconstruct_g / 1e6} ms = ${tconstruct_g * 1.0 / size} ns/element")
      traverse(g) shouldBe size
      // traverse(g) shouldBe size
      // val (tt_g, _) = TestStuff.timeIt { () => traverse(g) }
      // println(s"Traverse time graph g: ${tt_g / 1e6} ms = ${tt_g * 1.0 / size} ns/element")
      // val (tt_gg, _) = TestStuff.timeIt { () => traverse(gg) }
      // println(s"Traverse time graph gg: ${tt_gg / 1e6} ms = ${tt_gg / 1.0 / size} ns/element")
    }

    /*with pad=16 and size=10M we get stable ~70 ns memory latency on my system.*/
    "work with a pseudograph" in {

      //  val (tconstruct_gg, gg) = timeIt { () => mkPseudoGraph(42, pad, size) }
      //  println(s"Build time pseudograph gg (size = $size): ${tconstruct_gg / 1e6} ms = ${tconstruct_gg * 1.0 / size} ns/element")

      val (tconstruct_g, g) = timeIt { () => mkPseudoGraph(42, pad, size) }
      //  println(s"Build time pseudograph g: ${tconstruct_g / 1e6} ms = ${tconstruct_g * 1.0 / size} ns/element")
      traverse(g) shouldBe size

      //  traverse(g) shouldBe size
      //  val (tt_g, _) = TestStuff.timeIt { () => traverse(g) }
      //  println(s"Traverse time pseudograph g: ${tt_g / 1e6} ms = ${tt_g * 1.0 / size} ns/element")
      //  val (tt_gg, _) = TestStuff.timeIt { () => traverse(gg) }
      //  println(s"Traverse time pseudograph gg: ${tt_gg / 1e6} ms = ${tt_gg * 1.0 / size} ns/element")
    }
  }
}
