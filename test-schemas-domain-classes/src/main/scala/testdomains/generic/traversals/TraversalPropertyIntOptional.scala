package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyIntOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to intOptional property */
  def intOptional: Iterator[Int] =
    traversal.flatMap(_.intOptional)

  /** Traverse to nodes where the intOptional equals the given `value`
    */
  def intOptional(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && tmp.get == value
    }

  /** Traverse to nodes where the intOptional equals at least one of the given `values`
    */
  def intOptional(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && vset.contains(tmp.get)
    }
  }

  /** Traverse to nodes where the intOptional is not equal to the given `value`
    */
  def intOptionalNot(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isEmpty || tmp.get != value
    }

  /** Traverse to nodes where the intOptional does not equal any one of the given `values`
    */
  def intOptionalNot(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isEmpty || !vset.contains(tmp.get)
    }
  }

  /** Traverse to nodes where the intOptional is greater than the given `value`
    */
  def intOptionalGt(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && tmp.get > value
    }

  /** Traverse to nodes where the intOptional is greater than or equal the given `value`
    */
  def intOptionalGte(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && tmp.get >= value
    }

  /** Traverse to nodes where the intOptional is less than the given `value`
    */
  def intOptionalLt(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && tmp.get < value
    }

  /** Traverse to nodes where the intOptional is less than or equal the given `value`
    */
  def intOptionalLte(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.intOptional; tmp.isDefined && tmp.get <= value
    }

}
