package testdomains.gratefuldead.traversals

import testdomains.gratefuldead.nodes
import testdomains.gratefuldead.accessors.languagebootstrap.*

final class TraversalPropertyPerformances[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to performances property */
  def performances: Iterator[Int] =
    traversal.flatMap(_.performances)

  /** Traverse to nodes where the performances equals the given `value`
    */
  def performances(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && tmp.get == value
    }

  /** Traverse to nodes where the performances equals at least one of the given `values`
    */
  def performances(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && vset.contains(tmp.get)
    }
  }

  /** Traverse to nodes where the performances is not equal to the given `value`
    */
  def performancesNot(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isEmpty || tmp.get != value
    }

  /** Traverse to nodes where the performances does not equal any one of the given `values`
    */
  def performancesNot(values: Int*): Iterator[NodeType] = {
    val vset = values.toSet
    traversal.filter { node =>
      val tmp = node.performances; tmp.isEmpty || !vset.contains(tmp.get)
    }
  }

  /** Traverse to nodes where the performances is greater than the given `value`
    */
  def performancesGt(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && tmp.get > value
    }

  /** Traverse to nodes where the performances is greater than or equal the given `value`
    */
  def performancesGte(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && tmp.get >= value
    }

  /** Traverse to nodes where the performances is less than the given `value`
    */
  def performancesLt(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && tmp.get < value
    }

  /** Traverse to nodes where the performances is less than or equal the given `value`
    */
  def performancesLte(value: Int): Iterator[NodeType] =
    traversal.filter { node =>
      val tmp = node.performances; tmp.isDefined && tmp.get <= value
    }

}
