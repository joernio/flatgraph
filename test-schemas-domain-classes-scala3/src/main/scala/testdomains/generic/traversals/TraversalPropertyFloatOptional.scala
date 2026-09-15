package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyFloatOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasFloatOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to floatOptional property */
  def floatOptional: Iterator[Float] =
    traversal.flatMap(_.floatOptional)

  /** Traverse to nodes where the floatOptional equals the given `value`
    */
  def floatOptional(value: Float): Iterator[NodeType] =
    traversal.filter { node => node.floatOptional.isDefined && node.floatOptional.get == value }

  /** Traverse to nodes where the floatOptional equals at least one of the given `values`
    */
  def floatOptional(values: Float*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.floatOptional.isDefined && vset.contains(node.floatOptional.get) }
  }

  /** Traverse to nodes where the floatOptional does not equal the given `value`
    */
  def floatOptionalNot(value: Float): Iterator[NodeType] =
    traversal.filter { node => node.floatOptional.isEmpty || node.floatOptional.get != value }

  /** Traverse to nodes where the floatOptional does not equal any one of the given `values`
    */
  def floatOptionalNot(values: Float*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.floatOptional.isEmpty || !vset.contains(node.floatOptional.get) }
  }

}
