package testdomains.generic.traversals

import testdomains.generic.nodes
import testdomains.generic.accessors.languagebootstrap.*

final class TraversalPropertyStringMandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to stringMandatory property */
  def stringMandatory: Iterator[String] =
    traversal.map(_.stringMandatory)

  /** Traverse to nodes where the stringMandatory matches the regular expression `value`
    */
  def stringMandatory(pattern: String): Iterator[NodeType] =
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      stringMandatoryExact(pattern)
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filter { item => matcher.reset(item.stringMandatory).matches }
    }

  /** Traverse to nodes where the stringMandatory matches at least one of the regular expressions in `values`
    */
  def stringMandatory(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filter { item => matchers.exists { _.reset(item.stringMandatory).matches } }
  }

  /** Traverse to nodes where stringMandatory matches `value` exactly.
    */
  def stringMandatoryExact(value: String): Iterator[NodeType] = traversal match {
    case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
      val someNode = init.next
      flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value).asInstanceOf[Iterator[NodeType]]
    case _ => traversal.filter { _.stringMandatory == value }
  }

  /** Traverse to nodes where stringMandatory matches one of the elements in `values` exactly.
    */
  def stringMandatoryExact(values: String*): Iterator[NodeType] =
    if (values.length == 1) stringMandatoryExact(values.head)
    else {
      val valueSet = values.toSet
      traversal.filter { item => valueSet.contains(item.stringMandatory) }
    }

  /** Traverse to nodes where stringMandatory does not match the regular expression `value`.
    */
  def stringMandatoryNot(pattern: String): Iterator[NodeType] = {
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      traversal.filter { node => node.stringMandatory != pattern }
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filterNot { item => matcher.reset(item.stringMandatory).matches }
    }
  }

  /** Traverse to nodes where stringMandatory does not match any of the regular expressions in `values`.
    */
  def stringMandatoryNot(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filter { item => matchers.find { _.reset(item.stringMandatory).matches }.isEmpty }
  }

}
