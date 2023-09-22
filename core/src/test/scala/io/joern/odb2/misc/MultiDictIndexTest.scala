package io.joern.odb2.misc

import io.joern.odb2.TestHelpers._
import io.joern.odb2.TestHelpers.DummyTestNode
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MultiDictIndexTest extends AnyWordSpec with Matchers {

  "insert and retrieve: single and multiple entries by key" in {
    val index = new MultiDictIndex
    index.initForSize(10)
    val testNode1 = createTestNode(seqId = 1)
    val testNode2 = createTestNode(seqId = 2)
    val testNode3 = createTestNode(seqId = 3)
    index.insert("key1", testNode1)
    index.insert("key2", testNode2)
    index.insert("key2", testNode3)
    index.shrinkFit()

    index.get("undefined").size shouldBe 0
    index.get("key1").toSeq shouldBe Seq(testNode1)
    index.get("key2").toSeq shouldBe Seq(testNode2, testNode3)
  }

  "recognises and throws exception if we try to insert beyond capacity" in {
    val index = new MultiDictIndex
    index.initForSize(1)
    index.insert("key1", DummyTestNode)
    assertThrows[AssertionError] {
      index.insert("key2", DummyTestNode)
    }
  }

}
