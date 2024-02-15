package flatgraph.misc

import Regex.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RegexTests extends AnyWordSpec with Matchers {

  "multiline regex matcher" in {
    val matcher = multilineMatcher(".*DEF.*")
    matcher.reset("ABC").matches() shouldBe false
    matcher.reset("DEF").matches() shouldBe true
    matcher
      .reset("""ABC
        |DEF
        |GHI
        |""".stripMargin)
      .matches() shouldBe true

    assertThrows[InvalidRegexException](multilineMatcher("[invalid"))
  }

}
