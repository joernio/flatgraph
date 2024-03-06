package flatgraph.schema

import scala.annotation.tailrec

object Helpers {

  def stringToOption(s: String): Option[String] = s.trim match {
    case ""             => None
    case nonEmptyString => Some(nonEmptyString)
  }

  def singularize(str: String): String = {
    if (str.endsWith("ies")) {
      // e.g. Strategies -> Strategy
      s"${str.dropRight(3)}y"
    } else {
      // e.g. Types -> Type
      str.dropRight(1)
    }
  }

  /** Converts from camelCase to snake_case e.g.: camelCase => camel_case
    *
    * copy pasted from https://gist.github.com/sidharthkuruvila/3154845#gistcomment-2622928
    */
  def snakeCase(camelCase: String): String = {
    @tailrec
    def go(accDone: List[Char], acc: List[Char]): List[Char] = acc match {
      case Nil                                                        => accDone
      case a :: b :: c :: tail if a.isUpper && b.isUpper && c.isLower => go(accDone ++ List(a, '_', b, c), tail)
      case a :: b :: tail if a.isLower && b.isUpper                   => go(accDone ++ List(a, '_', b), tail)
      case a :: tail                                                  => go(accDone :+ a, tail)
    }
    go(Nil, camelCase.toList).mkString.toLowerCase
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
