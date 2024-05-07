package testdomains.generic.traversals
import testdomains.generic.nodes

object Lang extends ConcreteStoredConversions

object Accessors {
  import testdomains.generic.accessors.Lang.*

  /* accessors for concrete stored nodes start */
  final class Traversal_Property_int_list[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to intList property */
    def intList: Iterator[Int] =
      traversal.flatMap(_.intList)

  }
  final class Traversal_Property_int_mandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]](
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
  final class Traversal_Property_int_optional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]](
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
  final class Traversal_Property_string_list[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to stringList property */
    def stringList: Iterator[String] =
      traversal.flatMap(_.stringList)

  }
  final class Traversal_Property_string_mandatory[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]](
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
  final class Traversal_Property_string_optional[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]](
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
  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */
  final class Traversal_NodeABase[NodeType <: nodes.NodeABase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to intList property */
    def intList: Iterator[Int] =
      traversal.flatMap(_.intList)

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

    /** Traverse to stringList property */
    def stringList: Iterator[String] =
      traversal.flatMap(_.stringList)

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
  final class Traversal_NodeBBase[NodeType <: nodes.NodeBBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*
  implicit def accessPropertyIntListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntListEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_int_list[NodeType] = new Traversal_Property_int_list(traversal.iterator)
  implicit def accessPropertyIntMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntMandatoryEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_int_mandatory[NodeType] = new Traversal_Property_int_mandatory(traversal.iterator)
  implicit def accessPropertyIntOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasIntOptionalEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_int_optional[NodeType] = new Traversal_Property_int_optional(traversal.iterator)
  implicit def accessPropertyStringListTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringListEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_string_list[NodeType] = new Traversal_Property_string_list(traversal.iterator)
  implicit def accessPropertyStringMandatoryTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringMandatoryEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_string_mandatory[NodeType] = new Traversal_Property_string_mandatory(traversal.iterator)
  implicit def accessPropertyStringOptionalTraversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.HasStringOptionalEMT]](
    traversal: IterableOnce[NodeType]
  ): Traversal_Property_string_optional[NodeType] = new Traversal_Property_string_optional(traversal.iterator)
}

trait ConcreteBaseConversions {
  import Accessors.*
  implicit def traversal_NodeABase[NodeType <: nodes.NodeABase](traversal: IterableOnce[NodeType]): Traversal_NodeABase[NodeType] =
    new Traversal_NodeABase(traversal.iterator)
  implicit def traversal_NodeBBase[NodeType <: nodes.NodeBBase](traversal: IterableOnce[NodeType]): Traversal_NodeBBase[NodeType] =
    new Traversal_NodeBBase(traversal.iterator)
}
