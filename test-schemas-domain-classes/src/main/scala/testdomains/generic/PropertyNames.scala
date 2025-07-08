package testdomains.generic

import java.util.{HashSet, Set}
import scala.jdk.CollectionConverters.SeqHasAsJava

object PropertyNames {
  val IntList: String         = "int_list"
  val IntMandatory: String    = "int_mandatory"
  val IntOptional: String     = "int_optional"
  val StringList: String      = "string_list"
  val StringMandatory: String = "string_mandatory"
  val StringOptional: String  = "string_optional"

  /** /** This is a contained node */ */
  val ContainedNodeB: String = "contained_node_b"

  val All: Set[String] =
    new HashSet[String](Seq(IntList, IntMandatory, IntOptional, StringList, StringMandatory, StringOptional, ContainedNodeB).asJava)
}
