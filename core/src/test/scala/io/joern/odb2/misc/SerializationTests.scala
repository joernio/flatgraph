package io.joern.odb2.misc
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import com.fasterxml.jackson.core.{JsonParser, TreeNode}
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import io.joern.odb2.StorageManifest

class SerializationTests extends AnyWordSpec with Matchers {
  "foo" should {
    "bar" in {
      val testString = """{"foo":1, "bar": [1,2,3]}"""
      // com.fasterxml.jackson.core.json.
      val mapper = new ObjectMapper()
      val t      = mapper.readTree(testString)
      t.get("foo").isInt shouldBe true
      val x = mapper.treeToValue(t.get("bar"), new Array[Int](0).getClass)
      x shouldBe Array[Int](1, 2, 3)

      val xx = new StorageManifest.StorageWrap()
      xx.nodes.addOne(new StorageManifest.NodeItem("foo", 2))
      xx.nodes(0).deletions.contents = new StorageManifest.InlineIntArray(Array(1, 2, 3))
      mapper.registerModule(DefaultScalaModule)

      println(mapper.writeValueAsString(xx))

    }
  }

}
