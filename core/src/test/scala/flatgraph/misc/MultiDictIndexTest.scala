package flatgraph.misc

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MultiDictIndexTest extends AnyWordSpec with Matchers {

  "insert and retrieve: single and multiple entries by key" in {
    val index = new MultiDictIndex[String](sizeHint = 10)
    index.insert("key1", "value1")
    index.insert("key2", "value2")
    index.insert("key2", "value3")
    index.shrinkFit()

    index.get("undefined").size shouldBe 0
    index.get("key1").toSeq shouldBe Seq("value1")
    index.get("key2").toSeq shouldBe Seq("value2", "value3")
  }

  "recognises and throws exception if we try to insert beyond capacity" in {
    val index = new MultiDictIndex[String](sizeHint = 1)
    index.insert("key1", "one")
    assertThrows[AssertionError] {
      index.insert("key2", "oneTooMany")
    }
  }

  "should return empty Iterator for non-existing key" in {
    val index = new MultiDictIndex[String](sizeHint = 1)
    index.insert("key1", "one")
    index.shrinkFit()

    // note: this should not run into an endless loop, as it happened with a previous version
    index.get("undefined") shouldBe Iterator.empty
  }

}
