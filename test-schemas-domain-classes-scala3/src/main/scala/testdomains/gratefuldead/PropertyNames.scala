package testdomains.gratefuldead

import java.util.{HashSet, Set}
import scala.jdk.CollectionConverters.SeqHasAsJava

object PropertyNames {

  /** This is a property comment */
  val Name: String         = "name"
  val Performances: String = "performances"
  val Songtype: String     = "songType"
  val Weight: String       = "weight"

  val All: Set[String] = new HashSet[String](Seq(Name, Performances, Songtype, Weight).asJava)
}
