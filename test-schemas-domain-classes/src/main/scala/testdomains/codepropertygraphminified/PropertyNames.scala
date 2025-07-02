package testdomains.codepropertygraphminified

import java.util.{HashSet, Set}
import scala.jdk.CollectionConverters.SeqHasAsJava

object PropertyNames {
  val DispatchType: String = "DISPATCH_TYPE"

  val Name: String = "NAME"

  val Order: String = "ORDER"

  val All: Set[String] = new HashSet[String](Seq(DispatchType, Name, Order).asJava)
}
