package flatgraph.misc

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ISeqTest extends AnyWordSpec with Matchers {

  "work with Reftypes" in {
    val a = Array("a", "b", null)
    ISeq.from(a, 0, 3).toList shouldBe List("a", "b", null)
    ISeq.from(a, 1, 3).toList shouldBe List("b", null)
    ISeq.from(a, 1, 2).toList shouldBe List("b")
    ISeq.from(a, 0, 3).getClass.getName shouldBe "flatgraph.misc.ISeq"
    ISeq.from(new Array[Integer](0), 0, 0).getClass.getName shouldBe "flatgraph.misc.ISeq"
  }

  "work and specialize with Int" in {
    val a = Array(0, 1, 2)
    ISeq.from(a, 0, 3).toList shouldBe List(0, 1, 2)
    ISeq.from(a, 1, 3).toList shouldBe List(1, 2)
    ISeq.from(a, 1, 2).toList shouldBe List(1)
    ISeq.from(a, 0, 3).getClass.getName shouldBe "flatgraph.misc.ISeq"
  }

}
