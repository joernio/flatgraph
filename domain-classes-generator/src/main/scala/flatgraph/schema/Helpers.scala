package flatgraph.schema

object Helpers {

  def stringToOption(s: String): Option[String] = s.trim match {
    case ""             => None
    case nonEmptyString => Some(nonEmptyString)
  }

  def camelCase(snakeCase: String): String = {
    val corrected = // correcting for internal keys, like "_KEY" -> drop leading underscore
      if (snakeCase.startsWith("_")) snakeCase.drop(1)
      else snakeCase

    val elements: Seq[String] = corrected.split("_").map(_.toLowerCase).toList match {
      case head :: tail => head :: tail.map(_.capitalize)
      case Nil          => Nil
    }
    elements.mkString
  }

  def camelCaseCaps(snakeCase: String): String = camelCase(snakeCase).capitalize

}
