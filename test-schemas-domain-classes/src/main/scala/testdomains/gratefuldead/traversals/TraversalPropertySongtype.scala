package testdomains.gratefuldead.traversals

import testdomains.gratefuldead.nodes
import testdomains.gratefuldead.accessors.languagebootstrap.*

final class TraversalPropertySongtype[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]](
  val traversal: Iterator[NodeType]
) extends AnyVal {

  /** Traverse to songtype property */
  def songtype: Iterator[String] =
    traversal.flatMap(_.songtype)

  /** Traverse to nodes where the songtype matches the regular expression `value`
    */
  def songtype(pattern: String): Iterator[NodeType] = {
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      songtypeExact(pattern)
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filter { item =>
        val tmp = item.songtype; tmp.isDefined && matcher.reset(tmp.get).matches
      }
    }
  }

  /** Traverse to nodes where the songtype matches at least one of the regular expressions in `values`
    */
  def songtype(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filter { item =>
      val tmp = item.songtype; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
    }
  }

  /** Traverse to nodes where songtype matches `value` exactly.
    */
  def songtypeExact(value: String): Iterator[NodeType] = traversal match {
    case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
      val someNode = init.next
      flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 2, value).asInstanceOf[Iterator[NodeType]]
    case _ =>
      traversal.filter { node =>
        val tmp = node.songtype; tmp.isDefined && tmp.get == value
      }
  }

  /** Traverse to nodes where songtype matches one of the elements in `values` exactly.
    */
  def songtypeExact(values: String*): Iterator[NodeType] =
    if (values.length == 1) songtypeExact(values.head)
    else {
      val valueSet = values.toSet
      traversal.filter { item =>
        val tmp = item.songtype; tmp.isDefined && valueSet.contains(tmp.get)
      }
    }

  /** Traverse to nodes where songtype does not match the regular expression `value`.
    */
  def songtypeNot(pattern: String): Iterator[NodeType] = {
    if (!flatgraph.misc.Regex.isRegex(pattern)) {
      traversal.filter { node => node.songtype.isEmpty || node.songtype.get != pattern }
    } else {
      val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
      traversal.filterNot { item =>
        val tmp = item.songtype; tmp.isDefined && matcher.reset(tmp.get).matches
      }
    }
  }

  /** Traverse to nodes where songtype does not match any of the regular expressions in `values`.
    */
  def songtypeNot(patterns: String*): Iterator[NodeType] = {
    val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
    traversal.filterNot { item =>
      val tmp = item.songtype; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
    }
  }

}
