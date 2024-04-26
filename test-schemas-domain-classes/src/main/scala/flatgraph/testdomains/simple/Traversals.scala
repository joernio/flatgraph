package flatgraph.testdomains.simple.traversals
import flatgraph.testdomains.simple.nodes

object Lang extends ConcreteStoredConversions

object Accessors {
  import flatgraph.testdomains.simple.accessors.Lang.*

  /* accessors for concrete stored nodes start */
  final class Traversal_Property_intList[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntlistEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to intlist property */
    def intlist: Iterator[Int] =
      traversal.flatMap(_.intlist)

  }
  final class Traversal_Property_intMandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntmandatoryEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to intmandatory property */
    def intmandatory: Iterator[Int] =
      traversal.map(_.intmandatory)

    /** Traverse to nodes where the intmandatory equals the given `value`
      */
    def intmandatory(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory == value }

    /** Traverse to nodes where the intmandatory equals at least one of the given `values`
      */
    def intmandatory(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.intmandatory) }
    }

    /** Traverse to nodes where the intmandatory is not equal to the given `value`
      */
    def intmandatoryNot(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory != value }

    /** Traverse to nodes where the intmandatory is not equal to any of the given `values`
      */
    def intmandatoryNot(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => !vset.contains(node.intmandatory) }
    }

    /** Traverse to nodes where the intmandatory is greater than the given `value`
      */
    def intmandatoryGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory > value }

    /** Traverse to nodes where the intmandatory is greater than or equal the given `value`
      */
    def intmandatoryGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory >= value }

    /** Traverse to nodes where the intmandatory is less than the given `value`
      */
    def intmandatoryLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory < value }

    /** Traverse to nodes where the intmandatory is less than or equal the given `value`
      */
    def intmandatoryLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory <= value }

  }
  final class Traversal_Property_intOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntoptionalEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to intoptional property */
    def intoptional: Iterator[Int] =
      traversal.flatMap(_.intoptional)

    /** Traverse to nodes where the intoptional equals the given `value`
      */
    def intoptional(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the intoptional equals at least one of the given `values`
      */
    def intoptional(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the intoptional is not equal to the given `value`
      */
    def intoptionalNot(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isEmpty || tmp.get != value
      }

    /** Traverse to nodes where the intoptional does not equal any one of the given `values`
      */
    def intoptionalNot(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isEmpty || !vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the intoptional is greater than the given `value`
      */
    def intoptionalGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the intoptional is greater than or equal the given `value`
      */
    def intoptionalGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the intoptional is less than the given `value`
      */
    def intoptionalLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the intoptional is less than or equal the given `value`
      */
    def intoptionalLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get <= value
      }

  }
  final class Traversal_Property_stringList[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringlistEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to stringlist property */
    def stringlist: Iterator[String] =
      traversal.flatMap(_.stringlist)

  }
  final class Traversal_Property_stringMandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringmandatoryEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to stringmandatory property */
    def stringmandatory: Iterator[String] =
      traversal.map(_.stringmandatory)

    /** Traverse to nodes where the stringmandatory matches the regular expression `value`
      */
    def stringmandatory(pattern: String): Iterator[NodeType] =
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        stringmandatoryExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item => matcher.reset(item.stringmandatory).matches }
      }

    /** Traverse to nodes where the stringmandatory matches at least one of the regular expressions in `values`
      */
    def stringmandatory(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.exists { _.reset(item.stringmandatory).matches } }
    }

    /** Traverse to nodes where stringmandatory matches `value` exactly.
      */
    def stringmandatoryExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors
          .getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value)
          .asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.stringmandatory == value }
    }

    /** Traverse to nodes where stringmandatory matches one of the elements in `values` exactly.
      */
    def stringmandatoryExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) stringmandatoryExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.stringmandatory) }
      }

    /** Traverse to nodes where stringmandatory does not match the regular expression `value`.
      */
    def stringmandatoryNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.stringmandatory != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item => matcher.reset(item.stringmandatory).matches }
      }
    }

    /** Traverse to nodes where stringmandatory does not match any of the regular expressions in `values`.
      */
    def stringmandatoryNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.find { _.reset(item.stringmandatory).matches }.isEmpty }
    }

  }
  final class Traversal_Property_stringOptional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringoptionalEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to stringoptional property */
    def stringoptional: Iterator[String] =
      traversal.flatMap(_.stringoptional)

    /** Traverse to nodes where the stringoptional matches the regular expression `value`
      */
    def stringoptional(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        stringoptionalExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item =>
          val tmp = item.stringoptional; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }
    }

    /** Traverse to nodes where the stringoptional matches at least one of the regular expressions in `values`
      */
    def stringoptional(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item =>
        val tmp = item.stringoptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where stringoptional matches `value` exactly.
      */
    def stringoptionalExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors
          .getWithInverseIndex(someNode.graph, someNode.nodeKind, 5, value)
          .asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.stringoptional; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where stringoptional matches one of the elements in `values` exactly.
      */
    def stringoptionalExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) stringoptionalExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.stringoptional; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to nodes where stringoptional does not match the regular expression `value`.
      */
    def stringoptionalNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.stringoptional.isEmpty || node.stringoptional.get != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item =>
          val tmp = item.stringoptional; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }
    }

    /** Traverse to nodes where stringoptional does not match any of the regular expressions in `values`.
      */
    def stringoptionalNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filterNot { item =>
        val tmp = item.stringoptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

  }
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Traversal_NodeABase[NodeType <: nodes.NodeABase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to intlist property */
    def intlist: Iterator[Int] =
      traversal.flatMap(_.intlist)

    /** Traverse to intmandatory property */
    def intmandatory: Iterator[Int] =
      traversal.map(_.intmandatory)

    /** Traverse to nodes where the intmandatory equals the given `value`
      */
    def intmandatory(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory == value }

    /** Traverse to nodes where the intmandatory equals at least one of the given `values`
      */
    def intmandatory(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.intmandatory) }
    }

    /** Traverse to nodes where the intmandatory is not equal to the given `value`
      */
    def intmandatoryNot(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory != value }

    /** Traverse to nodes where the intmandatory is not equal to any of the given `values`
      */
    def intmandatoryNot(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => !vset.contains(node.intmandatory) }
    }

    /** Traverse to nodes where the intmandatory is greater than the given `value`
      */
    def intmandatoryGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory > value }

    /** Traverse to nodes where the intmandatory is greater than or equal the given `value`
      */
    def intmandatoryGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory >= value }

    /** Traverse to nodes where the intmandatory is less than the given `value`
      */
    def intmandatoryLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory < value }

    /** Traverse to nodes where the intmandatory is less than or equal the given `value`
      */
    def intmandatoryLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.intmandatory <= value }

    /** Traverse to intoptional property */
    def intoptional: Iterator[Int] =
      traversal.flatMap(_.intoptional)

    /** Traverse to nodes where the intoptional equals the given `value`
      */
    def intoptional(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the intoptional equals at least one of the given `values`
      */
    def intoptional(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the intoptional is not equal to the given `value`
      */
    def intoptionalNot(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isEmpty || tmp.get != value
      }

    /** Traverse to nodes where the intoptional does not equal any one of the given `values`
      */
    def intoptionalNot(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isEmpty || !vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the intoptional is greater than the given `value`
      */
    def intoptionalGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the intoptional is greater than or equal the given `value`
      */
    def intoptionalGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the intoptional is less than the given `value`
      */
    def intoptionalLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the intoptional is less than or equal the given `value`
      */
    def intoptionalLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.intoptional; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to stringlist property */
    def stringlist: Iterator[String] =
      traversal.flatMap(_.stringlist)

    /** Traverse to stringmandatory property */
    def stringmandatory: Iterator[String] =
      traversal.map(_.stringmandatory)

    /** Traverse to nodes where the stringmandatory matches the regular expression `value`
      */
    def stringmandatory(pattern: String): Iterator[NodeType] =
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        stringmandatoryExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item => matcher.reset(item.stringmandatory).matches }
      }

    /** Traverse to nodes where the stringmandatory matches at least one of the regular expressions in `values`
      */
    def stringmandatory(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.exists { _.reset(item.stringmandatory).matches } }
    }

    /** Traverse to nodes where stringmandatory matches `value` exactly.
      */
    def stringmandatoryExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors
          .getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value)
          .asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.stringmandatory == value }
    }

    /** Traverse to nodes where stringmandatory matches one of the elements in `values` exactly.
      */
    def stringmandatoryExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) stringmandatoryExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.stringmandatory) }
      }

    /** Traverse to nodes where stringmandatory does not match the regular expression `value`.
      */
    def stringmandatoryNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.stringmandatory != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item => matcher.reset(item.stringmandatory).matches }
      }
    }

    /** Traverse to nodes where stringmandatory does not match any of the regular expressions in `values`.
      */
    def stringmandatoryNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item => matchers.find { _.reset(item.stringmandatory).matches }.isEmpty }
    }

    /** Traverse to stringoptional property */
    def stringoptional: Iterator[String] =
      traversal.flatMap(_.stringoptional)

    /** Traverse to nodes where the stringoptional matches the regular expression `value`
      */
    def stringoptional(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        stringoptionalExact(pattern)
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filter { item =>
          val tmp = item.stringoptional; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }
    }

    /** Traverse to nodes where the stringoptional matches at least one of the regular expressions in `values`
      */
    def stringoptional(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filter { item =>
        val tmp = item.stringoptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where stringoptional matches `value` exactly.
      */
    def stringoptionalExact(value: String): Iterator[NodeType] = traversal match {
      case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        flatgraph.Accessors
          .getWithInverseIndex(someNode.graph, someNode.nodeKind, 5, value)
          .asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.stringoptional; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where stringoptional matches one of the elements in `values` exactly.
      */
    def stringoptionalExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) stringoptionalExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.stringoptional; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to nodes where stringoptional does not match the regular expression `value`.
      */
    def stringoptionalNot(pattern: String): Iterator[NodeType] = {
      if (!flatgraph.misc.Regex.isRegex(pattern)) {
        traversal.filter { node => node.stringoptional.isEmpty || node.stringoptional.get != pattern }
      } else {
        val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
        traversal.filterNot { item =>
          val tmp = item.stringoptional; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }
    }

    /** Traverse to nodes where stringoptional does not match any of the regular expressions in `values`.
      */
    def stringoptionalNot(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
      traversal.filterNot { item =>
        val tmp = item.stringoptional; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

  }
  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyIntlistTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntlistEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_intList[NodeType] = new Traversal_Property_intList(traversal.iterator)
  implicit def accessPropertyIntmandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntmandatoryEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_intMandatory[NodeType] = new Traversal_Property_intMandatory(traversal.iterator)
  implicit def accessPropertyIntoptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntoptionalEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_intOptional[NodeType] = new Traversal_Property_intOptional(traversal.iterator)
  implicit def accessPropertyStringlistTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringlistEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_stringList[NodeType] = new Traversal_Property_stringList(traversal.iterator)
  implicit def accessPropertyStringmandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringmandatoryEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_stringMandatory[NodeType] =
    new Traversal_Property_stringMandatory(traversal.iterator)
  implicit def accessPropertyStringoptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringoptionalEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_stringOptional[NodeType] =
    new Traversal_Property_stringOptional(traversal.iterator)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def traversal_NodeABase[NodeType <: nodes.NodeABase](traversal: IterableOnce[NodeType]): Traversal_NodeABase[NodeType] =
    new Traversal_NodeABase(traversal.iterator)
}
