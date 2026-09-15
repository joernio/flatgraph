package testdomains.hierarchical

import java.util.{HashSet, Set}
import scala.jdk.CollectionConverters.SeqHasAsJava

object PropertyNames {
  val Name: String = "name"

  val All: Set[String] = new HashSet[String](Seq(Name).asJava)
}
