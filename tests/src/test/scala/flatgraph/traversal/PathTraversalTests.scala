package flatgraph.traversal

import flatgraph.*
import flatgraph.TestGraphs.FlatlineGraphFixture
import flatgraph.traversal.language.*
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.generic.language.*
import testdomains.generic.nodes.NodeA
import testdomains.generic.nodes.NodeA.PropertyNames

import scala.collection.mutable

class PathTraversalTests extends AnyWordSpec with FlatlineGraphFixture {

  /* sample graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  def centerTrav = genericDomain.nodeA.stringMandatory("Center")

  ".path step" should {
    "not be enabled by default" in {
      intercept[AssertionError] { centerTrav.out.path }
    }

    "work for single element traversal (boring)" in {
      centerTrav.enablePathTracking.path.toSet shouldBe Set(Seq(center))
    }

    "work for simple one-step expansion" in {
      centerTrav.enablePathTracking.out.path.toSet shouldBe Set(Seq(center, l1), Seq(center, r1))
    }

    "work for simple two-step expansion" in {
      centerTrav.enablePathTracking.out.out.path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "only track from where it's enabled" in {
      centerTrav.out.enablePathTracking.out.path.toSet shouldBe Set(Seq(l1, l2), Seq(r1, r2))
    }

    "support domain-specific steps" in {
      centerTrav.enablePathTracking.connectedTo.connectedTo.path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "work with repeat step" in {
      centerTrav.enablePathTracking.repeat(_.connectedTo)(_.maxDepth(2)).path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "work in combination with other steps" should {
      ".map: include intermediate results in path" in {
        centerTrav.enablePathTracking.connectedTo.map(_.stringMandatory).path.toSet shouldBe Set(
          Seq(center, l1, "L1"),
          Seq(center, r1, "R1")
        )
      }

      "collect: include intermediate results in path" in {
        centerTrav.enablePathTracking.connectedTo.collect { case x => x.stringMandatory }.path.toSet shouldBe Set(
          Seq(center, l1, "L1"),
          Seq(center, r1, "R1")
        )
      }

      "collectAll: does not include intermediate results" in {
        centerTrav.enablePathTracking.collectAll[NodeA].path.toList shouldBe List(Seq(center))
      }

      "filter" in {
        centerTrav.enablePathTracking.connectedTo.stringMandatory("R.*").connectedTo.path.toSet shouldBe Set(Seq(center, r1, r2))
      }

      "filterNot" in {
        centerTrav.enablePathTracking.connectedTo
          .filterNot(_.stringMandatory.startsWith("R"))
          .connectedTo
          .path
          .toSet shouldBe Set(Seq(center, l1, l2))
      }

      "dedup" in {
        verifyResults(center.start.enablePathTracking.both.both.dedup.path.toSet)
        verifyResults(center.start.enablePathTracking.both.both.dedupBy(_.hashCode).path.toSet)

        def verifyResults(paths: collection.Set[Vector[?]]) = {
          paths should contain(Vector(center, l1, l2))
          paths should contain(Vector(center, r1, r2))
          //        paths.should(contain(oneOf(Seq(center, l1, center), Seq(center, r1, center))))

          // should container *either* `center, l1, center` *or* `center, r1, center`
          var matchCount = 0
          if (paths.contains(Vector(center, l1, center))) matchCount += 1
          if (paths.contains(Vector(center, r1, center))) matchCount += 1
          matchCount shouldBe 1
        }
      }

      "cast" in {
        val traversal: Iterator[GNode] = center.start.enablePathTracking.out.out
        val results: Seq[NodeA]        = traversal.cast[NodeA].l
        results shouldBe Seq(l2, r2)
      }

      "where" in {
        centerTrav.enablePathTracking.connectedTo.where(_.stringMandatory("R.*")).connectedTo.path.toSet shouldBe Set(Seq(center, r1, r2))
      }

      "whereNot" in {
        centerTrav.enablePathTracking.connectedTo
          .whereNot(_.stringMandatory("R.*"))
          .connectedTo
          .path
          .toSet shouldBe Set(Seq(center, l1, l2))
      }

      "sideEffect" in {
        val sack = mutable.ListBuffer.empty[GNode]
        center.start.enablePathTracking.out.sideEffect(sack.addOne).out.path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
        sack.toSet shouldBe Set(l1, r1)
      }

      "sideEffectPF" in {
        val sack = mutable.ListBuffer.empty[GNode]

        center.start.enablePathTracking.out
          .sideEffectPF {
            case node if node.property(NodeA.Properties.StringMandatory).startsWith("L") =>
              sack.addOne(node)
          }
          .out
          .path
          .toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))

        sack.toSet shouldBe Set(l1)
      }

      "or" in {
        centerTrav.enablePathTracking.out
          .or(_.label("does not exist"), _.has(PropertyNames.StringMandatory, "R1"))
          .out
          .path
          .l shouldBe Seq(Seq(center, r1, r2))
      }

      "and" in {
        centerTrav.enablePathTracking.out
          .and(_.label(NodeA.Label), _.has(PropertyNames.StringMandatory, "R1"))
          .out
          .path
          .l shouldBe Seq(Seq(center, r1, r2))
      }

      "choose" in {
        genericDomain.nodeA.enablePathTracking
          .choose(_.stringMandatory) {
            case "L1" => _.out                          // -> L2
            case "R1" => _.repeat(_.out)(_.maxDepth(3)) // -> R4
          }
          .property(PropertyNames.StringMandatory)
          .path
          .toSet shouldBe Set(Seq(r1, r2, r3, r4, "R4"), Seq(l1, l2, "L2"))
      }

      "coalesce" in {
        var traversalInvoked = false
        centerTrav.enablePathTracking
          .coalesce(_.out("doesn't exist"), _.out, _.sideEffect(_ => traversalInvoked = true).out)
          .property(PropertyNames.StringMandatory)
          .path
          .toSet shouldBe Set(Seq(center, l1, "L1"), Seq(center, r1, "R1"))
        traversalInvoked shouldBe false
      }

      "union" in {
        centerTrav.enablePathTracking.union(_.out.out).path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
        // we can hide internal steps from path-tracking
        centerTrav.enablePathTracking.union(t => (t.out.out.l).iterator).path.toSet shouldBe Set(Seq(center, l2), Seq(center, r2))
      }
    }
  }

  ".simplePath step" should {
    "remove results where path has repeated objects on the path" in {
      center.start.enablePathTracking.both.both.simplePath.toSet shouldBe Set(l2, r2)

      center.start.enablePathTracking.both.both.simplePath.path.toSet shouldBe Set(Seq(center, l1, l2), Seq(center, r1, r2))
    }

    "throw error if path tracking not enabled" in {
      intercept[AssertionError] { center.start.both.both.simplePath.l }
    }
  }

}
