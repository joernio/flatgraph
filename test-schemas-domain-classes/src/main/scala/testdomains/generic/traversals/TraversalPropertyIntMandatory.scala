package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyIntMandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to intMandatory property */
  def intMandatory: Iterator[Int] =
    traversal.map(_.intMandatory)

  /** Traverse to nodes where the intMandatory equals the given `value`
    */
  def intMandatory(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory == value }

  /** Traverse to nodes where the intMandatory equals at least one of the given `values`
    */
  def intMandatory(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => vset.contains(node.intMandatory) }
  }

  /** Traverse to nodes where the intMandatory is not equal to the given `value`
    */
  def intMandatoryNot(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory != value }

  /** Traverse to nodes where the intMandatory is not equal to any of the given `values`
    */
  def intMandatoryNot(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node => !vset.contains(node.intMandatory) }
  }

  /** Traverse to nodes where the intMandatory is greater than the given `value`
    */
  def intMandatoryGt(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory > value }

  /** Traverse to nodes where the intMandatory is greater than or equal the given `value`
    */
  def intMandatoryGte(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory >= value }

  /** Traverse to nodes where the intMandatory is less than the given `value`
    */
  def intMandatoryLt(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory < value }

  /** Traverse to nodes where the intMandatory is less than or equal the given `value`
    */
  def intMandatoryLte(value: Int): Iterator[NodeType] =
    traversal.filter { _.intMandatory <= value }

}
