package testdomains.gratefuldead.traversals
import testdomains.gratefuldead.nodes

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  import testdomains.gratefuldead.accessors.languagebootstrap.*

  /* accessors for concrete stored nodes start */
  final class Traversal_Property_name[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 0, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.name == value }
    }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

    /** Traverse to nodes where name does not match the regular expression `value`.
      */
    def nameNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.name != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item => matcher.reset(item.name).matches }
      }
    }

    /** Traverse to nodes where name does not match any of the regular expressions in `values`.
      */
    def nameNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.find { _.reset(item.name).matches }.isEmpty }
    }

  }
  final class Traversal_Property_performances[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]](
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
  final class Traversal_Property_songType[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]](
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
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Traversal_ArtistBase[NodeType <: nodes.ArtistBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 0, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.name == value }
    }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

    /** Traverse to nodes where name does not match the regular expression `value`.
      */
    def nameNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.name != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item => matcher.reset(item.name).matches }
      }
    }

    /** Traverse to nodes where name does not match any of the regular expressions in `values`.
      */
    def nameNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.find { _.reset(item.name).matches }.isEmpty }
    }

  }
  final class Traversal_SongBase[NodeType <: nodes.SongBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 0, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.name == value }
    }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

    /** Traverse to nodes where name does not match the regular expression `value`.
      */
    def nameNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.name != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item => matcher.reset(item.name).matches }
      }
    }

    /** Traverse to nodes where name does not match any of the regular expressions in `values`.
      */
    def nameNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.find { _.reset(item.name).matches }.isEmpty }
    }

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
  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyNameTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasNameEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_name[NodeType] = new Traversal_Property_name(traversal.iterator)
  implicit def accessPropertyPerformancesTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasPerformancesEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_performances[NodeType] = new Traversal_Property_performances(traversal.iterator)
  implicit def accessPropertySongtypeTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasSongtypeEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_songType[NodeType] = new Traversal_Property_songType(traversal.iterator)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def traversal_ArtistBase[NodeType <: nodes.ArtistBase](traversal: IterableOnce[NodeType]): Traversal_ArtistBase[NodeType] =
    new Traversal_ArtistBase(traversal.iterator)
  implicit def traversal_SongBase[NodeType <: nodes.SongBase](traversal: IterableOnce[NodeType]): Traversal_SongBase[NodeType] =
    new Traversal_SongBase(traversal.iterator)
}
