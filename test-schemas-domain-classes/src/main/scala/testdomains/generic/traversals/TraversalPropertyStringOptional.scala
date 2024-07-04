package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyStringOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to stringOptional property */
  def stringOptional: Iterator[String] =
    traversal.flatMap(_.stringOptional)

  /** Traverse to nodes where the stringOptional matches the regular expression `value`
    */
  def stringOptional(pattern: String): Iterator[NodeType] = {
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      stringOptionalExact(pattern)
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filter { item =>
        val tmp = item.stringOptional; tmp.isDefined && matcher.reset(tmp.get).matches
      }
    }
  }

  /** Traverse to nodes where the stringOptional matches at least one of the regular expressions in `values`
    */
  def stringOptional(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filter { item =>
      val tmp = item.stringOptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
    }
  }

  /** Traverse to nodes where stringOptional matches `value` exactly.
    */
  def stringOptionalExact(value: String): Iterator[NodeType] = traversal match {
    case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
      val someNode = init.next
      flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 5, value).asInstanceOf[Iterator[NodeType]]
    case _ =>
      traversal.filter { node =>
        val tmp = node.stringOptional; tmp.isDefined && tmp.get == value
      }
  }

  /** Traverse to nodes where stringOptional matches one of the elements in `values` exactly.
    */
  def stringOptionalExact(values: String*): Iterator[NodeType] =
    if (values.length == 1) stringOptionalExact(values.head)
    else {
      val valueSet = values.toSet
      traversal.filter { item =>
        val tmp = item.stringOptional; tmp.isDefined && valueSet.contains(tmp.get)
      }
    }

  /** Traverse to nodes where stringOptional does not match the regular expression `value`.
    */
  def stringOptionalNot(pattern: String): Iterator[NodeType] = {
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      traversal.filter { node => node.stringOptional.isEmpty || node.stringOptional.get != pattern }
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filterNot { item =>
        val tmp = item.stringOptional; tmp.isDefined && matcher.reset(tmp.get).matches
      }
    }
  }

  /** Traverse to nodes where stringOptional does not match any of the regular expressions in `values`.
    */
  def stringOptionalNot(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filterNot { item =>
      val tmp = item.stringOptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
    }
  }

}
