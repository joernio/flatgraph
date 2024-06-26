package flatgraph.traversal

import flatgraph.help.Table.AvailableWidthProvider
import flatgraph.help.{DocSearchPackages, Table}
import flatgraph.{GNode, TestGraphs}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.generic.GenericDomain
import testdomains.generic.language.*
import testdomains.generic.edges.ConnectedTo
import testdomains.generic.nodes.{NewNodeA, NewNodeB, NodeA, NodeB}

import scala.collection.mutable

class TraversalTests extends AnyWordSpec {

  /* sample graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  val flatlineGraph = TestGraphs.createFlatlineGraph()
  def centerTrav    = flatlineGraph.nodeA.stringMandatory("Center")

  "domain specific traversals" in {
    centerTrav.connectedTo.size shouldBe 2
    centerTrav.connectedToIn.size shouldBe 0
  }

  "generic GNode traversals" in {
    centerTrav.label.l shouldBe Seq(NodeA.Label)
    centerTrav.outE.size shouldBe 2
    centerTrav.inE.size shouldBe 0
    centerTrav.outE(ConnectedTo.Label).size shouldBe 2
    centerTrav.inE(ConnectedTo.Label).size shouldBe 0
  }

  "can only be iterated once" in {
    val one = Iterator.single("one")
    one.size shouldBe 1
    one.size shouldBe 0

    val empty = Iterator.empty[String]
    empty.size shouldBe 0
    empty.size shouldBe 0
  }

  ".sideEffect step should apply provided function and do nothing else" in {
    val sack = mutable.ListBuffer.empty[NodeA]
    centerTrav.connectedTo.sideEffect(sack.addOne).connectedTo.stringMandatory.toSet shouldBe Set("L2", "R2")
    sack.map(_.stringMandatory).toSet shouldBe Set("L1", "R1")
  }

  ".dedup step" should {
    "remove duplicates" in {
      Iterator(1, 2, 1, 3).dedup.l shouldBe List(1, 2, 3)
      Iterator(1, 2, 1, 3).dedupBy(_.hashCode).l shouldBe List(1, 2, 3)
    }

    "allow method only based on hashCode - to ensure the traversal doesn't hold onto elements after they've been consumed" in {
      // when run with -Xmx128m we can hold ~7 of these at a time
      def infiniteTraversalWithLargeElements = new Iterator[Any] {
        var i       = 0
        def hasNext = true
        def next(): Any = {
          val arr = Array.ofDim[Long](2048, 1024)
          // assign unique value to make the arrays unique
          arr(i)(i) = i
          i += 1
          arr
        }
      }

      /** using dedup by hash comparison, we can traverse over these elements - already consumed elements are garbage collected
        */
      val traversal = infiniteTraversalWithLargeElements.dedupBy(_.hashCode)
      0.to(128).foreach { i =>
        traversal.next()
      }
    }
  }

  ".sort steps should order" in {
    Iterator(1, 3, 2).sorted shouldBe Seq(1, 2, 3)
    Iterator("aa", "aaa", "a").sortBy(_.length) shouldBe Seq("a", "aa", "aaa")
  }

  "`is` filter step" in {
    def oneToFour = Iterator(1, 2, 3, 4)
    oneToFour.is(2).l shouldBe Seq(2)
  }

  "within/without filter steps" in {
    def oneToFour = Iterator(1, 2, 3, 4)
    oneToFour.within(Set(2, 4)).l shouldBe Seq(2, 4)
    oneToFour.without(Set(2, 4)).l shouldBe Seq(1, 3)
  }

  "collectAll step should collect (and cast) all elements of the given type" in {
    val anyIter: Iterator[Any] = Iterator("a", "b", 1, 2, 3)
    val stringIter             = anyIter.collectAll[String]

    // just verifying that we can assign it
    val stringIter2: Iterator[String] = stringIter
    stringIter2.size shouldBe 2
  }

  "help step" should {
    // a specific domain would provide it's own DocSearchPackage implementation, to specify where we're supposed to scan for @Doc annotations
    given DocSearchPackages      = DocSearchPackages.default
    given AvailableWidthProvider = new Table.ConstantWidth(120)

    "generic help for `int`" in {
      val helpText = Iterator(1, 2, 3, 4).help
      helpText should include(".cast")
      helpText should include("casts all elements to given type")
      helpText should include(".whereNot")
      helpText should include("only preserves elements if the provided traversal does")

      val helpTextVerbose = Iterator(1, 2, 3, 4).helpVerbose
      helpTextVerbose should include(".cast")
      helpTextVerbose should include(".whereNot")
      helpTextVerbose should include("""flatgraph.traversal.GenericSt""") // should contain the location of the step definition...
    }

    "help for nodes" in {
      val helpText = Iterator.empty[GNode].help
      helpText should include(".label")
      helpText should include(".property")
      helpText should include(".out")
      helpText should include(".in")
      helpText should include(".cast")

      val helpTextVerbose = Iterator.empty[GNode].helpVerbose
      helpTextVerbose should include(".label")
      helpTextVerbose should include(".property")
      helpTextVerbose should include(".cast")
      helpTextVerbose should include("""flatgraph.traversal.GenericSt""") // should contain the location of the step definition...
      helpTextVerbose should include("""flatgraph.traversal.NodeSteps""") // should contain the location of the step definition...
    }

    "give a domain overview" in {
      given DocSearchPackages = GenericDomain.defaultDocSearchPackage
      val helpText            = GenericDomain.help
      // should list starter steps etc.
      helpText should include(".nodeA")
      helpText should include(".nodeB")
      helpText should include("all nodes")
    }

    "provide node-specific overview" in {
      val nodeATraversal     = flatlineGraph.nodeA
      val nodeATraversalHelp = nodeATraversal.help

      // TODO bring these back, by generating the @Doc annotations
//      nodeATraversalHelp should include(".connectedTo") // step from `flatgraph.traversal.testdomains.simple.SimpleDomainTraversal`
      nodeATraversalHelp should include(".sideEffect") // step from Traversal
      nodeATraversalHelp should include(".label")      // step from ElementTraversal
      nodeATraversalHelp should include(".out")        // step from NodeTraversal

      // scala generates additional `fooBar$extension` methods, but those don't matter in the context of .help/@Doc
      nodeATraversalHelp shouldNot include("$extension")

      val thingTraversalHelpVerbose = nodeATraversal.helpVerbose
      // TODO bring these back, by generating the @Doc annotations
//      thingTraversalHelpVerbose should include("name of the Thing")
//      thingTraversalHelpVerbose should include("simple.SimpleDomainTravers")
      thingTraversalHelpVerbose should include("node label")
      thingTraversalHelpVerbose should include("flatgraph.traversal.NodeSteps")
      thingTraversalHelpVerbose should include("result to a list")
      thingTraversalHelpVerbose should include("flatgraph.traversal.GenericSt")
    }
  }

  "generic graph steps" in {
    centerTrav.out.size shouldBe 2
    centerTrav.out(ConnectedTo.Label).size shouldBe 2
    centerTrav.out("does not exist").size shouldBe 0
  }

}
