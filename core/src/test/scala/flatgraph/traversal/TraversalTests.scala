package flatgraph.traversal

import flatgraph.Implicits.start
import flatgraph.GNode
import flatgraph.help.DocSearchPackages
import flatgraph.traversal.Language.*
import flatgraph.traversal.testdomains.simple.SimpleDomain.Thing
import flatgraph.traversal.testdomains.simple.{ExampleGraphSetup, SimpleDomain}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable

class TraversalTests extends AnyWordSpec with ExampleGraphSetup {
  /* most tests work with this simple graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  def centerTrav = Iterator.single(center)

  "GNode traversals" in {
    centerTrav.label.l shouldBe Seq("V0")
    centerTrav.outE.size shouldBe 2
    centerTrav.inE.size shouldBe 0
    centerTrav.outE("0").size shouldBe 2
    centerTrav.inE("0").size shouldBe 0
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
    val sack = mutable.ListBuffer.empty[GNode]
    center.start.out.sideEffect(sack.addOne).out.toSetMutable shouldBe Set(l2, r2)
    sack.toSet shouldBe Set(l1, r1)
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

  ".help step" should {
    "generic help for `int`" in {
      val helpText = Iterator(1, 2, 3, 4).help
      helpText should include(".cast")
      helpText should include("casts all elements to given type")
      helpText should include(".whereNot")
      helpText should include(" only preserves elements if the provided traversal does _not_ have any results")

      val helpTextVerbose = Iterator(1, 2, 3, 4).helpVerbose
      helpTextVerbose should include(".cast")
      helpTextVerbose should include(".whereNot")
      helpTextVerbose should include("""flatgraph.traversal.GenericLanguage""") // should contain the location of the step definition...
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
      helpTextVerbose should include("""flatgraph.traversal.GenericLanguage""") // should contain the location of the step definition...
      helpTextVerbose should include("""flatgraph.traversal.NodeLanguage""")    // should contain the location of the step definition...
    }

    "give a domain overview" in {
      import flatgraph.traversal.testdomains.simple.SimpleDomain

      val helpText = SimpleDomain.help
      // should list starter steps etc.
      helpText should include(".things")
      helpText should include("all things")
    }

    "provide node-specific overview" when {
      "using simple domain" in {
        val thingTraversal     = SimpleDomain.traversal(SimpleDomain.newGraph).things
        val thingTraversalHelp = thingTraversal.help

        thingTraversalHelp should include(".name")       // step from `flatgraph.traversal.testdomains.simple.SimpleDomainTraversal`
        thingTraversalHelp should include(".sideEffect") // step from Traversal
        thingTraversalHelp should include(".label")      // step from ElementTraversal
        thingTraversalHelp should include(".out")        // step from NodeTraversal

        // scala generates additional `fooBar$extension` methods, but those don't matter in the context of .help/@Doc
        thingTraversalHelp shouldNot include("$extension")

        val thingTraversalHelpVerbose = thingTraversal.helpVerbose
        thingTraversalHelpVerbose should include("name of the Thing")
        thingTraversalHelpVerbose should include("testdomains.simple.SimpleDomainTraversal")
        thingTraversalHelpVerbose should include("node label")
        thingTraversalHelpVerbose should include("flatgraph.traversal.NodeLanguage")
        thingTraversalHelpVerbose should include("result to a list")
        thingTraversalHelpVerbose should include("flatgraph.traversal.GenericLanguage")
      }
    }

  }

}
