package flatgraph.traversal

import flatgraph.TestGraphs.FlatlineGraphFixture
import flatgraph.{GNode, TestGraphs}
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.generic.language.*
import testdomains.generic.nodes.NodeA
import testdomains.generic.nodes.NodeA.PropertyNames.StringMandatory

class LogicalStepsTests extends AnyWordSpec with FlatlineGraphFixture {

  /* sample graph:
   * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
   */
  def centerTrav = genericDomain.nodeA.stringMandatory("Center")

  "or step returns results if at least one condition is met" in {
    centerTrav.out.or(_.label(NodeA.Label)).size shouldBe 2
    centerTrav.out.or(_.label("does not exist")).size shouldBe 0

    centerTrav.out
      .or(_.label("does not exist"), _.has(StringMandatory, "R1"))
      .l shouldBe Seq(r1)
  }

  "and step returns results if ALL conditions are met" in {
    centerTrav.out.and(_.label(NodeA.Label)).size shouldBe 2
    centerTrav.out.and(_.label("does not exist")).size shouldBe 0

    centerTrav.out
      .and(_.label("does not exist"), _.has(StringMandatory, "R1"))
      .size shouldBe 0

    centerTrav.out
      .and(_.label(NodeA.Label), _.has(StringMandatory, "R1"))
      .l shouldBe Seq(r1)
  }

  "choose step" should {
    "provide if semantics" in {
      genericDomain.nodeA
        .choose(_.property[String](StringMandatory)) { case "L1" =>
          _.out // -> L2
        }
        .property(StringMandatory)
        .toSet shouldBe Set("L2")
    }

    "provide if/elseif semantics" in {
      genericDomain.nodeA
        .choose(_.property[String](StringMandatory)) {
          case "L1" => _.out                          // -> L2
          case "R1" => _.repeat(_.out)(_.maxDepth(3)) // -> R4
        }
        .property(StringMandatory)
        .toSet shouldBe Set("L2", "R4")
    }

    "provide if/else semantics" in {
      genericDomain.nodeA
        .choose(_.property[String](StringMandatory)) {
          case "L1" => _.out                          // -> L2
          case "R1" => _.repeat(_.out)(_.maxDepth(3)) // -> R4
          case _    => _.in
        }
        .property(StringMandatory)
        .toSet shouldBe Set("L2", "L1", "R1", "R2", "R3", "R4")
    }

    "handle empty `on` traversal: if semantics" in {
      genericDomain.nodeA
        .choose(_.property[String](StringMandatory).filter(_ => false)) { case "L1" =>
          _.out
        }
        .property(StringMandatory)
        .size shouldBe 0
    }

    "handle empty `on` traversal: if/else semantics" in {
      genericDomain.nodeA
        .choose(_.property[String](StringMandatory).filter(_ => false)) {
          case "L1" => _.in
          case _    => _.out
        }
        .property(StringMandatory)
        .toSet shouldBe Set("L3", "L2", "L1", "R1", "R2", "R3", "R4", "R5")
    }
  }

  "coalesce step takes arbitrary number of traversals and follows the first one that returns at least one element" in {
    centerTrav.coalesce(_.out).property(StringMandatory).toSet shouldBe Set("L1", "R1")

    centerTrav.coalesce().size shouldBe 0
    centerTrav.coalesce(_.out("doesn't exist")).size shouldBe 0

    // verify it doesn't invoke the third traversal
    var thirdTraversalInvoked = false
    centerTrav
      .coalesce(_.out("doesn't exist"), _.out, _.sideEffect(_ => thirdTraversalInvoked = true).out)
      .property(StringMandatory)
      .toSet shouldBe Set("L1", "R1")
    thirdTraversalInvoked shouldBe false

    centerTrav
      .coalesce(_.stringMandatory("doesn't exist"), _.connectedTo)
      .stringMandatory
      .toSet shouldBe Set("L1", "R1")

    // we can even mix generic graph steps (.out) and domain-specific steps (.followedBy), but need to help the type
    // inferencer by specifying `[GNode]` as the result type
    centerTrav.coalesce[GNode](_.out, _.connectedTo).property(StringMandatory).toSet shouldBe Set("L1", "R1")
  }

}
