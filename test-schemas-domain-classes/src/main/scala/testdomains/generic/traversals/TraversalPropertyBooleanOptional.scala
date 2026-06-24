package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyBooleanOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasBooleanOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to booleanOptional property */
  def booleanOptional: Iterator[Boolean] =
    traversal.flatMap(_.booleanOptional)

  /** Traverse to nodes where the booleanOptional equals the given `value`
    */
  def booleanOptional(value: Boolean): Iterator[NodeType] =
    traversal.filter { node => node.booleanOptional.isDefined && node.booleanOptional.get == value }

}
