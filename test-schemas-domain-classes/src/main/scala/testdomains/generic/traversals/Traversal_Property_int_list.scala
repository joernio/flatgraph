package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class Traversal_Property_int_list[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to intList property */
  def intList: Iterator[Int] =
    traversal.flatMap(_.intList)

}
