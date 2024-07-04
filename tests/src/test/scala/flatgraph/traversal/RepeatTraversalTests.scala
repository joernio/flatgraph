package flatgraph.traversal

import flatgraph.GNode
import flatgraph.TestGraphs.FlatlineGraphFixture
import testdomains.generic.GenericDomain
import testdomains.generic.language.*
import testdomains.generic.Properties.StringMandatory
import testdomains.generic.edges.ConnectedTo
import testdomains.generic.nodes.{NewNodeA, NodeA}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable

/* uses 'flat line' sample graph:
 * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
 */
class RepeatTraversalTests extends AnyWordSpec with FlatlineGraphFixture {
  /* most tests work with this simple graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  def centerTrav = Iterator.single(center)

  "typical case for both generic graph steps" in {
    centerTrav.repeat(_.out)(_.maxDepth(2)).toSet shouldBe Set(l2, r2)
  }

  "repeat given traversal up to depth 2" should {
    "return only the final elements" in {
      val expectedResults = Set(l2, r2)
      centerTrav.repeat(_.out)(_.maxDepth(2)).toSet shouldBe expectedResults
      centerTrav.repeat(_.out)(_.maxDepth(2).breadthFirstSearch).toSet shouldBe expectedResults
    }

    "return only the final elements - if any" in {
      val expectedResults = Set(r4) // there is no L4
      centerTrav.repeat(_.out)(_.maxDepth(4)).toSet shouldBe expectedResults
      centerTrav.repeat(_.out)(_.maxDepth(4).breadthFirstSearch).toSet shouldBe expectedResults
    }

    "return everything along the way also, if used in combination with emit" in {
      val expectedResults = Set(center, l1, l2, r1, r2)
      centerTrav.repeat(_.out)(_.maxDepth(2).emit).toSet shouldBe expectedResults
      centerTrav.repeat(_.out)(_.maxDepth(2).emit.breadthFirstSearch).toSet shouldBe expectedResults
    }
  }

  "emit everything along the way if so configured" in {
    val expectedResults = Set(l3, l2, l1, center, r1, r2, r3, r4, r5)
    centerTrav.repeat(_.out)(_.emit).toSet shouldBe expectedResults
    centerTrav.repeat(_.out)(_.emit.breadthFirstSearch).toSet shouldBe expectedResults
  }

  "emit everything along the way but the first element (starting point)" in {
    val expectedResults = Set(l3, l2, l1, r1, r2, r3, r4, r5)
    centerTrav.repeat(_.out)(_.emitAllButFirst).toSet shouldBe expectedResults
    centerTrav.repeat(_.out)(_.emitAllButFirst.breadthFirstSearch).toSet shouldBe expectedResults
  }

  "emit nodes along the way that meet given condition" in {
    centerTrav
      .repeat(_.out)(_.emit(_.where(_.property(StringMandatory).filter(_.startsWith("L")))))
      .property(StringMandatory)
      .toSet shouldBe Set("L1", "L2", "L3")

    // with domain specific language
    centerTrav
      .repeat(_.connectedTo)(_.emit(_.stringMandatory("L.*")))
      .stringMandatory
      .toSet shouldBe Set("L1", "L2", "L3")

    // note: the emit condition only applies as a filter to what's emitted _along the way_, i.e. if the repeat
    // traversal ends somewhere with results (e.g. because of `maxDepth` or `until`), you'll get those results also
    // example: this traversal ends at `L2/R2` due to `maxDepth=2` and it emitted `L1` along the way
    centerTrav
      .repeat(_.connectedTo)(_.maxDepth(2).emit(_.stringMandatory("L.*")))
      .stringMandatory
      .toSet shouldBe Set("L1", "L2", "R2")
  }

  "going through multiple steps in repeat traversal" in {
    r1.start.repeat(_.out.out)(_.emit).l shouldBe Seq(r1, r3, r5)
    r1.start.enablePathTracking.repeat(_.out.out)(_.emit).path.l shouldBe Seq(Seq(r1), Seq(r1, r2, r3), Seq(r1, r2, r3, r4, r5))
  }

  "support arbitrary `until` condition" should {
    "work without emit" in {
      val expectedResults = Set("L2", "R2")

      centerTrav
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_.matches(".*2"))))
        .property(StringMandatory)
        .toSet shouldBe expectedResults

      centerTrav
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_.matches(".*2"))).breadthFirstSearch)
        .property(StringMandatory)
        .toSet shouldBe expectedResults
    }

    "work in combination with emit" in {
      val expectedResults = Set("Center", "L1", "L2", "R1", "R2")
      centerTrav
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_.matches(".*2"))).emit)
        .property(StringMandatory)
        .toSet shouldBe expectedResults
      centerTrav
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_.matches(".*2"))).emit.breadthFirstSearch)
        .property(StringMandatory)
        .toSet shouldBe expectedResults
    }

    "result in 'repeat/until' behaviour, i.e. `until` condition is only evaluated after one iteration" in {
      val expectedResults = Set("L1", "R1")
      centerTrav.repeat(_.out)(_.until(_.hasLabel(NodeA.Label))).property(StringMandatory).toSet shouldBe expectedResults
      centerTrav
        .repeat(_.out)(_.until(_.hasLabel(NodeA.Label)).breadthFirstSearch)
        .property(StringMandatory)
        .toSet shouldBe expectedResults
    }

    "be combinable with `.maxDepth`" in {
      centerTrav
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_ == "R2")).maxDepth(3))
        .property(StringMandatory)
        .toSet shouldBe Set("L3", "R2")
    }
  }

  "until and maxDepth" should {
    "work in combination" in {
      centerTrav.repeat(_.out)(_.until(_.property(StringMandatory).filter(_ == "R2")).maxDepth(2)).toSet shouldBe Set(l2, r2)
      centerTrav
        .repeat(_.out)(_.breadthFirstSearch.until(_.property(StringMandatory).filter(_ == "R2")).maxDepth(2))
        .toSet shouldBe Set(l2, r2)
    }

    "work in combination with path" in {
      centerTrav.enablePathTracking
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_ == "R2")).maxDepth(2))
        .path
        .filter(_.last == r2)
        .l shouldBe Seq(Vector(center, r1, r2))
    }
  }

  "support repeat/while behaviour" should {
    "base case: given `whilst` condition is also evaluated for first iteration" in {
      centerTrav.repeat(_.out)(_.whilst(_.property(StringMandatory).filter(_ == "does not exist"))).toSet shouldBe Set(center)
    }

    "walk one iteration" in {
      centerTrav.repeat(_.out)(_.whilst(_.property(StringMandatory).filter(_ == "Center"))).toSet shouldBe Set(l1, r1)
    }

    "walk two iterations" in {
      centerTrav
        .repeat(_.out)(
          _.whilst(_.or(_.property(StringMandatory).filter(_.endsWith("1")), _.property(StringMandatory).filter(_ == "Center")))
        )
        .toSet shouldBe Set(l2, r2)
    }

    "emitting nodes along the way" in {
      centerTrav.repeat(_.out)(_.emit.whilst(_.property(StringMandatory).filter(_ == "Center"))).toSet shouldBe Set(center, l1, r1)
      centerTrav.repeat(_.out)(_.emitAllButFirst.whilst(_.property(StringMandatory).filter(_ == "Center"))).toSet shouldBe Set(l1, r1)
    }

    "with path tracking enabled" in {
      centerTrav.enablePathTracking
        .repeat(_.out)(_.whilst(_.property(StringMandatory).filter(_ == "Center")))
        .path
        .toSet shouldBe Set(Seq(center, r1), Seq(center, l1))
    }

    "be combinable with `.maxDepth`" in {
      centerTrav
        .repeat(_.out)(_.whilst(_.property(StringMandatory).filter(_ != "R2")).maxDepth(3))
        .property(StringMandatory)
        .toSet shouldBe Set("L3", "R2")
    }
  }

  ".dedup should apply to all repeat iterations - e.g. to avoid cycles" when {

    "path tracking is not enabled" in {
      centerTrav.repeat(_.both)(_.maxDepth(2).dedup).toSet shouldBe Set(l2, r2)
      centerTrav.repeat(_.both)(_.maxDepth(3).dedup).toSet shouldBe Set(l3, r3)
      centerTrav.repeat(_.both)(_.maxDepth(4).dedup).toSet shouldBe Set(r4)

      // for reference, without dedup (order is irrelevant, only using .l to show duplicate `center`)
      centerTrav.repeat(_.both)(_.maxDepth(2)).l shouldBe Seq(l2, center, r2, center)
    }

    "path tracking is enabled" in {
      centerTrav.enablePathTracking.repeat(_.both)(_.maxDepth(2).dedup).path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))

      // for reference, without dedup:
      centerTrav.enablePathTracking.repeat(_.both)(_.maxDepth(2)).path.toSet shouldBe Set(
        Seq(center, l1, l2),
        Seq(center, l1, center),
        Seq(center, r1, r2),
        Seq(center, r1, center)
      )
    }

    "used with emit" in {
      // order is irrelevant, only using .l to show that there's no duplicates
      centerTrav.repeat(_.both)(_.maxDepth(2).emit.dedup).l shouldBe Seq(center, l1, l2, r1, r2)
    }

    "used with emit and path" in {
      centerTrav.enablePathTracking.repeat(_.both)(_.maxDepth(2).emit.dedup).path.toSet shouldBe Set(
        Seq(center),
        Seq(center, l1),
        Seq(center, l1, l2),
        Seq(center, r1),
        Seq(center, r1, r2)
      )
    }
  }

  "is lazy" in {
    val traversedNodes = mutable.ListBuffer.empty[GNode]
    val traversalNotYetExecuted = {
      centerTrav.repeat(_.out.sideEffect(traversedNodes.addOne))
      centerTrav.repeat(_.out.sideEffect(traversedNodes.addOne))(_.breadthFirstSearch)
    }
    withClue("traversal should not do anything when it's only created") {
      traversedNodes.size shouldBe 0
    }
  }

  "hasNext check doesn't change contents of traversal" when {
    "path tracking is not enabled" in {
      val trav = centerTrav.repeat(_.out)(_.maxDepth(2))
      trav.hasNext shouldBe true
      trav.toSet shouldBe Set(l2, r2)
    }

    "path tracking is enabled" in {
      val trav1 = centerTrav.enablePathTracking.repeat(_.out)(_.maxDepth(2))
      val trav2 = centerTrav.enablePathTracking.repeat(_.out)(_.maxDepth(2)).path
      trav1.hasNext shouldBe true
      trav2.hasNext shouldBe true
      trav1.toSet shouldBe Set(l2, r2)
      trav2.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }
  }

  "traverses all nodes to outer limits exactly once, emitting and returning nothing, by default" in {
    val traversedNodes = mutable.ListBuffer.empty[Any]

    def test(traverse: => Iterable[?]) = {
      traversedNodes.clear()
      val results = traverse
      traversedNodes.size shouldBe 9
      results.size shouldBe 0
    }

    test(centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out).l)
    test(centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out)(_.breadthFirstSearch).l)

    // for reference: this is the equivalent in tinkerpop - this doesn't compile any more because we dropped that dependency
    //    withClue("for reference: this behaviour is adapted from tinkerpop") {
    //      import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.__
    //      import org.apache.tinkerpop.gremlin.process.traversal.{Traverser, Traversal => TPTraversal}
    //      import org.apache.tinkerpop.gremlin.structure.Vertex
    //      test {
    //        val centerTp3: Vertex = NodeTp3.wrap(center)
    //        __(centerTp3).repeat(
    //          __().sideEffect { x: Traverser[Vertex] => traversedNodes += x.get }
    //            .out().asInstanceOf[TPTraversal[_, Vertex]]
    //        ).toList.asScala
    //      }
    //    }
  }

  "uses DFS (depth first search) by default" in {
    val traversedNodes = mutable.ListBuffer.empty[GNode]
    centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out).iterate()

    traversedNodes.property(StringMandatory).l shouldBe List("Center", "L1", "L2", "L3", "R1", "R2", "R3", "R4", "R5")
  }

  "uses BFS (breadth first search) if configured" in {
    val traversedNodes = mutable.ListBuffer.empty[GNode]
    centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out)(_.breadthFirstSearch).iterate()

    traversedNodes.property(StringMandatory).l shouldBe List("Center", "L1", "R1", "L2", "R2", "L3", "R3", "R4", "R5")
  }

  "hasNext is idempotent: DFS" in {
    val traversedNodes = mutable.ListBuffer.empty[GNode]
    val traversal      = centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out)(_.maxDepth(3))

    // hasNext will run the provided repeat traversal exactly 3 times (as configured)
    traversal.hasNext shouldBe true
    traversedNodes.size shouldBe 3
    traversedNodes.property(StringMandatory).l shouldBe List("Center", "L1", "L2")
    // hasNext is idempotent - calling it again doesn't result in any further traversing
    traversal.hasNext shouldBe true
    traversedNodes.size shouldBe 3
  }

  "hasNext is idempotent: BFS" in {
    val traversedNodes = mutable.ListBuffer.empty[GNode]
    val traversal      = centerTrav.repeat(_.sideEffect(traversedNodes.addOne).out)(_.maxDepth(2).breadthFirstSearch)

    // hasNext will run the provided repeat traversal exactly 3 times (as configured)
    traversal.hasNext shouldBe true
    traversedNodes.size shouldBe 2
    traversedNodes.property(StringMandatory).l shouldBe List("Center", "L1")
    // hasNext is idempotent - calling it again doesn't result in any further traversing
    traversal.hasNext shouldBe true
    traversedNodes.size shouldBe 2
  }

  "supports large amount of iterations" in {
    // create circular graph so that we can repeat any number of times
    val newA = NewNodeA().stringMandatory("a")
    val newB = NewNodeA().stringMandatory("b")
    val newC = NewNodeA().stringMandatory("c")

    val genericDomain = GenericDomain.from(
      _.addEdge(newA, newB, ConnectedTo.Label)
        .addEdge(newB, newC, ConnectedTo.Label)
        .addEdge(newC, newA, ConnectedTo.Label)
    )

    val repeatCount = 100000

    genericDomain.nodeA.stringMandatory("a").repeat(_.out)(_.maxDepth(repeatCount)).property(StringMandatory).l shouldBe List("b")
    genericDomain.nodeA
      .stringMandatory("a")
      .repeat(_.out)(_.maxDepth(repeatCount).breadthFirstSearch)
      .property(StringMandatory)
      .l shouldBe List("b")

    // for reference: tinkerpop becomes very slow with large iteration counts:
    // on my machine this didn't terminate within 5mins, hence commenting out
    //    import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.__
    //    __(a).repeat(
    //      __().out().asInstanceOf[org.apache.tinkerpop.gremlin.process.traversal.Traversal[_, Node]]
    //    ).times(repeatCount).values[String](StringMandatory.name).next() shouldBe "b"
  }

  "support .path step" when {
    "using `maxDepth` modulator" in {
      centerTrav.enablePathTracking.repeat(_.out)(_.maxDepth(2)).path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "using `emit` modulator" in {
      centerTrav.enablePathTracking.repeat(_.out)(_.emit).path.toSet shouldBe Set(
        Seq(center),
        Seq(center, l1),
        Seq(center, l1, l2),
        Seq(center, l1, l2, l3),
        Seq(center, r1),
        Seq(center, r1, r2),
        Seq(center, r1, r2, r3),
        Seq(center, r1, r2, r3, r4),
        Seq(center, r1, r2, r3, r4, r5)
      )
    }

    "using `until` modulator" in {
      centerTrav.enablePathTracking
        .repeat(_.out)(_.until(_.property(StringMandatory).filter(_.endsWith("2"))))
        .path
        .toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "using breadth first search" in {
      centerTrav.enablePathTracking
        .repeat(_.out)(_.breadthFirstSearch.maxDepth(2))
        .path
        .toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "doing multiple steps: should track every single step along the way" in {
      centerTrav.enablePathTracking.repeat(_.out.out)(_.maxDepth(1)).path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))

      r1.start.enablePathTracking
        .repeat(_.out.out.out)(_.maxDepth(1))
        .path
        .toSet shouldBe Set(Seq(r1, r2, r3, r4))

      r1.start.enablePathTracking.repeat(_.out.out)(_.maxDepth(2)).l shouldBe Seq(r5)
      r1.start.enablePathTracking.repeat(_.out.out)(_.maxDepth(2)).path.next() shouldBe List(r1, r2, r3, r4, r5)
    }

    "should not forget steps preceding the repeat" in {
      centerTrav.enablePathTracking.out
        .repeat(_.out.out)(_.maxDepth(1))
        .path
        .toSet shouldBe Set(Seq(center, l1, l2, l3), Seq(center, r1, r2, r3))
    }

  }

  "type resolution in hierarchical domain schema" in {
    import testdomains.hierarchical.Hierarchical
    import testdomains.hierarchical.language.*
    import testdomains.hierarchical.nodes.*

    /** Using hierarchical domain to verify that repeat derives the correct types. Graph setup: NodeX <: BaseType NodeY <: BaseType X1 -->
      * Y2 --> X3 --> X4
      */
    val newNodeX1 = NewNodeX().name("X1")
    val newNodeY2 = NewNodeY().name("Y2")
    val newNodeX3 = NewNodeX().name("X3")
    val newNodeY4 = NewNodeY().name("Y4")

    val hierarchical = Hierarchical.from(
      _.addEdge(newNodeX1, newNodeY2, testdomains.hierarchical.edges.ConnectedTo.Label)
        .addEdge(newNodeY2, newNodeX3, testdomains.hierarchical.edges.ConnectedTo.Label)
        .addEdge(newNodeX3, newNodeY4, testdomains.hierarchical.edges.ConnectedTo.Label)
    )

    val nodeX = hierarchical.nodeX.name("X1")
    nodeX.repeat(_.connectedTo)(_.emit).name.l shouldBe List("X1", "Y2", "X3", "Y4")
  }

}
