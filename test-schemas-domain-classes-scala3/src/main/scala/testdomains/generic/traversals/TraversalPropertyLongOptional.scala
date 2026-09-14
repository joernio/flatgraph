package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyLongOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasLongOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to longOptional property */
  def longOptional: Iterator[Long] =
    traversal.flatMap(_.longOptional)

  /** Traverse to nodes where the longOptional equals the given `value`
    */
  def longOptional(value: Long): Iterator[NodeType] =
    traversal.filter { node => node.longOptional.isDefined && node.longOptional.get == value }

  /** Traverse to nodes where the longOptional equals at least one of the given `values`
    */
  def longOptional(values: Long*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.longOptional.isDefined && vset.contains(node.longOptional.get) }
  }

  /** Traverse to nodes where the longOptional does not equal the given `value`
    */
  def longOptionalNot(value: Long): Iterator[NodeType] =
    traversal.filter { node => node.longOptional.isEmpty || node.longOptional.get != value }

  /** Traverse to nodes where the longOptional does not equal any one of the given `values`
    */
  def longOptionalNot(values: Long*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.longOptional.isEmpty || !vset.contains(node.longOptional.get) }
  }

}
