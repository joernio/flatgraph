package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyDoubleOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasDoubleOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to doubleOptional property */
  def doubleOptional: Iterator[Double] =
    traversal.flatMap(_.doubleOptional)

  /** Traverse to nodes where the doubleOptional equals the given `value`
    */
  def doubleOptional(value: Double): Iterator[NodeType] =
    traversal.filter { node => node.doubleOptional.isDefined && node.doubleOptional.get == value }

  /** Traverse to nodes where the doubleOptional equals at least one of the given `values`
    */
  def doubleOptional(values: Double*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.doubleOptional.isDefined && vset.contains(node.doubleOptional.get) }
  }

  /** Traverse to nodes where the doubleOptional does not equal the given `value`
    */
  def doubleOptionalNot(value: Double): Iterator[NodeType] =
    traversal.filter { node => node.doubleOptional.isEmpty || node.doubleOptional.get != value }

  /** Traverse to nodes where the doubleOptional does not equal any one of the given `values`
    */
  def doubleOptionalNot(values: Double*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => node.doubleOptional.isEmpty || !vset.contains(node.doubleOptional.get) }
  }

}
