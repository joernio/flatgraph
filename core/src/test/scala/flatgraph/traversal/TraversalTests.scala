package flatgraph.traversal

import flatgraph.traversal.Language.*
import flatgraph.traversal.testdomains.simple.ExampleGraphSetup
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

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

}
