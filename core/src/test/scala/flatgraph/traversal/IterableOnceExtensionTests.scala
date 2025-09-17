package flatgraph.traversal

import flatgraph.traversal.language.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable.ArrayBuffer

class IterableOnceExtensionTests extends AnyWordSpec with Matchers {

  "loneElement returns the one and only element from an Iterable, and throws an exception otherwise" in {
    Seq(1).loneElement shouldBe 1
    Seq(1).loneElement("some context") shouldBe 1
    Seq(null).loneElement shouldBe null

    intercept[NoSuchElementException] {
      Seq.empty.loneElement
    }.getMessage should include("it is empty")

    intercept[NoSuchElementException] {
      Seq.empty.loneElement("some context")
    }.getMessage should include("it is empty. Hint: some context")

    intercept[AssertionError] {
      Seq(1, 2).loneElement
    }.getMessage should include("it has more than one")

    intercept[AssertionError] {
      ArrayBuffer(1, 2).loneElement
    }.getMessage should include("it has 2") // ArrayBuffer can 'cheaply' compute their size, so we can have it in the exception message

    intercept[AssertionError] {
      Iterator(1, 2).loneElement
    }.getMessage should include("it has 2") // should know that it's two elements, even if iterator consumes elements after iteration

    intercept[AssertionError] {
      Seq(1, 2).loneElement("some context")
    }.getMessage should include("it has more than one. Hint: some context")
  }

  "loneElementOption returns an Option of the one and only element from an Iterable, or else None" in {
    Seq(1).loneElementOption shouldBe Some(1)
    Seq(null).loneElementOption shouldBe Some(null)

    Seq.empty.loneElementOption shouldBe None

    Seq(1, 2).loneElementOption shouldBe None
  }

  "groupBy respects iteration order" in {
    Seq(5, 4, 3, 2, 1, 0).groupByOrdered(x => x % 3).valuesIterator.map { _.l }.l shouldBe List(List(5, 2), List(4, 1), List(3, 0))
    Seq(5, 4, 3, 2, 1, 0).groupByOrdered(x => (x + 1) % 3).valuesIterator.map { _.l }.l shouldBe List(List(5, 2), List(4, 1), List(3, 0))
    Seq(5, 4, 3, 2, 1, 0).groupByOrdered(x => (x + 2) % 3).valuesIterator.map { _.l }.l shouldBe List(List(5, 2), List(4, 1), List(3, 0))
  }

}
