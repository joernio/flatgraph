package io.joern.odb2.misc

object Misc {
  val reChars = Array('[', ']', '(', ')', '{', '}', '*', '+', '&', '|', '?', '.', ',', '\\', '$')

  def isRegex(pattern: String): Boolean = reChars.exists(pattern.indexOf(_) >= 0)
}
