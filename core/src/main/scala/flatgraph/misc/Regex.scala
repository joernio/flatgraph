package flatgraph.misc

import java.util.regex.{Matcher, Pattern, PatternSyntaxException}

object Regex {

  private val reChars = Array('[', ']', '(', ')', '{', '}', '*', '+', '&', '|', '?', '.', ',', '\\', '$')

  def isRegex(pattern: String): Boolean =
    reChars.exists(pattern.indexOf(_) >= 0)

  /** compiles given string into a regex matcher, prefixes the pattern with `(?s)` to enable multi line matching */
  def multilineMatcher(pattern: String): Matcher = {
    try {
      Pattern.compile(s"(?s)$pattern").matcher("")
    } catch {
      case e: PatternSyntaxException =>
        throw new InvalidRegexException(pattern, e)
    }
  }

  class InvalidRegexException(regexp: String, cause: PatternSyntaxException)
      extends RuntimeException(s"invalid regular expression: `$regexp`", cause)

}
