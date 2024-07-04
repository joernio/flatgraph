package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class Traversal_Property_string_list[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to stringList property */
  def stringList: Iterator[String] =
    traversal.flatMap(_.stringList)

}
