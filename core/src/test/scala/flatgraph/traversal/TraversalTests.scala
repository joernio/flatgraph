package flatgraph.traversal

import flatgraph.Implicits.start
import flatgraph.GNode
import flatgraph.traversal.Language.*
import flatgraph.traversal.testdomains.simple.ExampleGraphSetup
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
        var i = 0
        def hasNext = true
        def next(): Any = {
          val arr = Array.ofDim[Long](2048, 1024)
          // assign unique value to make the arrays unique
          arr(i)(i) = i
          i += 1
          arr
        }
      }

      /** using dedup by hash comparison, we can traverse over these elements - already consumed elements are garbage
        * collected
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
      helpTextVerbose should include("""flatgraph.traversal.NodeLanguage""") // should contain the location of the step definition...
    }

    "give a domain overview" in {
      //    import SimpleDomain._ // for domain specific `DocSearchPackages`
      //   list starter steps etc.

      ???
//      val helpText = simpleDomain.help
//      helpText should include(".things")
//      helpText should include("all things")
    }

    "provide node-specific overview" when {
      "using simple domain" in {
        ???
//        val thingTraversal = SimpleDomain.traversal(SimpleDomain.newGraph).things
//        val thingTraversalHelp = thingTraversal.help
//        thingTraversalHelp should include("Available steps for Thing")
//        thingTraversalHelp should include(".name")
//        thingTraversalHelp should include(".name2") // step from helptest.SimpleDomainTraversal
//
//        val thingTraversalHelpVerbose = thingTraversal.helpVerbose
//        thingTraversalHelpVerbose should include("ThingTraversal") // the Traversal classname
//        thingTraversalHelpVerbose should include(".sideEffect") // step from Traversal
//        thingTraversalHelpVerbose should include(".label") // step from ElementTraversal
//        thingTraversalHelpVerbose should include(".out") // step from NodeTraversal
//        thingTraversalHelpVerbose should include(
//          "just like name, but in a different package"
//        ) // step from helptest.SimpleDomainTraversal
      }

      "using hierarchical domain" in {
//        import overflowdb.traversal.testdomains.hierarchical._
        ???
//        Iterator.empty[Animal].help should include("species of the animal")
//        Iterator.empty[Mammal].help should include("can this mammal swim?")
//        Iterator.empty[Elephant].help should include("name of the elephant")
//        Iterator.empty[Car].help should include("name of the car")

        // elephant is a mammal (and therefor an animal)
//        Iterator.empty[Elephant].canSwim // only verify that it compiles
//        Iterator.empty[Elephant].species // only verify that it compiles
//        Iterator.empty[Elephant].help should include("species of the animal")
//        Iterator.empty[Elephant].help should include("can this mammal swim?")
      }
    }

    "provides generic help" when {
      "using verbose mode" when {
        "traversing nodes" in {
          ???
//          val thingTraversal: Iterator[Thing] = Iterator.empty
//          thingTraversal.helpVerbose should include(".sideEffect")
//          thingTraversal.helpVerbose should include(".label")
        }

        "traversing non-nodes" in {
          ???
//          val stringTraversal = Iterator.empty[String]
//          stringTraversal.helpVerbose should include(".sideEffect")
//          (stringTraversal.helpVerbose should not).include(".label")
        }
      }
    }
  }

}
