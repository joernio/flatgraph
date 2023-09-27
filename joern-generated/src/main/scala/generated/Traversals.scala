package io.shiftleft.codepropertygraph.generated.v2.traversals
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes
import odb2.misc.Misc
import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*

object Lang extends ConcreteStoredConversions

trait ConcreteStoredConversions extends ConcreteBaseConversions {
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to aliasTypeFullName property */
    def aliasTypeFullName: Iterator[String] =
      traversal.flatMap(_.aliasTypeFullName)

    /** Traverse to nodes where the aliasTypeFullName matches the regular expression `value`
      */
    def aliasTypeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        aliasTypeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.aliasTypeFullName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the aliasTypeFullName matches at least one of the regular expressions in `values`
      */
    def aliasTypeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.aliasTypeFullName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where aliasTypeFullName matches `value` exactly.
      */
    def aliasTypeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 0, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.aliasTypeFullName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where aliasTypeFullName matches one of the elements in `values` exactly.
      */
    def aliasTypeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) aliasTypeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.aliasTypeFullName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]](traversal: Iterator[NodeType]) {

    /** Traverse to argumentIndex property */
    def argumentIndex: Iterator[Int] =
      traversal.map(_.argumentIndex)

    /** Traverse to nodes where the argumentIndex equals the given `value`
      */
    def argumentIndex(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex == value }

    /** Traverse to nodes where the argumentIndex equals at least one of the given `values`
      */
    def argumentIndex(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.argumentIndex) }
    }

    /** Traverse to nodes where the argumentIndex is greater than the given `value`
      */
    def argumentIndexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex > value }

    /** Traverse to nodes where the argumentIndex is greater than or equal the given `value`
      */
    def argumentIndexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex >= value }

    /** Traverse to nodes where the argumentIndex is less than the given `value`
      */
    def argumentIndexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex < value }

    /** Traverse to nodes where the argumentIndex is less than or equal the given `value`
      */
    def argumentIndexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex <= value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to argumentName property */
    def argumentName: Iterator[String] =
      traversal.flatMap(_.argumentName)

    /** Traverse to nodes where the argumentName matches the regular expression `value`
      */
    def argumentName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        argumentNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.argumentName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the argumentName matches at least one of the regular expressions in `values`
      */
    def argumentName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.argumentName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where argumentName matches `value` exactly.
      */
    def argumentNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 2, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.argumentName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where argumentName matches one of the elements in `values` exactly.
      */
    def argumentNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) argumentNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.argumentName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to astParentFullName property */
    def astParentFullName: Iterator[String] =
      traversal.map(_.astParentFullName)

    /** Traverse to nodes where the astParentFullName matches the regular expression `value`
      */
    def astParentFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentFullName).matches }
      }

    /** Traverse to nodes where the astParentFullName matches at least one of the regular expressions in `values`
      */
    def astParentFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentFullName).matches } }
    }

    /** Traverse to nodes where astParentFullName matches `value` exactly.
      */
    def astParentFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 3, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentFullName == value }
    }

    /** Traverse to nodes where astParentFullName matches one of the elements in `values` exactly.
      */
    def astParentFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentFullName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]](traversal: Iterator[NodeType]) {

    /** Traverse to astParentType property */
    def astParentType: Iterator[String] =
      traversal.map(_.astParentType)

    /** Traverse to nodes where the astParentType matches the regular expression `value`
      */
    def astParentType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentType).matches }
      }

    /** Traverse to nodes where the astParentType matches at least one of the regular expressions in `values`
      */
    def astParentType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentType).matches } }
    }

    /** Traverse to nodes where astParentType matches `value` exactly.
      */
    def astParentTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentType == value }
    }

    /** Traverse to nodes where astParentType matches one of the elements in `values` exactly.
      */
    def astParentTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentType) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to canonicalName property */
    def canonicalName: Iterator[String] =
      traversal.map(_.canonicalName)

    /** Traverse to nodes where the canonicalName matches the regular expression `value`
      */
    def canonicalName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        canonicalNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.canonicalName).matches }
      }

    /** Traverse to nodes where the canonicalName matches at least one of the regular expressions in `values`
      */
    def canonicalName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.canonicalName).matches } }
    }

    /** Traverse to nodes where canonicalName matches `value` exactly.
      */
    def canonicalNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 5, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.canonicalName == value }
    }

    /** Traverse to nodes where canonicalName matches one of the elements in `values` exactly.
      */
    def canonicalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) canonicalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.canonicalName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to className property */
    def className: Iterator[String] =
      traversal.map(_.className)

    /** Traverse to nodes where the className matches the regular expression `value`
      */
    def className(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        classNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.className).matches }
      }

    /** Traverse to nodes where the className matches at least one of the regular expressions in `values`
      */
    def className(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.className).matches } }
    }

    /** Traverse to nodes where className matches `value` exactly.
      */
    def classNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 6, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.className == value }
    }

    /** Traverse to nodes where className matches one of the elements in `values` exactly.
      */
    def classNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.className) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to classShortName property */
    def classShortName: Iterator[String] =
      traversal.map(_.classShortName)

    /** Traverse to nodes where the classShortName matches the regular expression `value`
      */
    def classShortName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        classShortNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.classShortName).matches }
      }

    /** Traverse to nodes where the classShortName matches at least one of the regular expressions in `values`
      */
    def classShortName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.classShortName).matches } }
    }

    /** Traverse to nodes where classShortName matches `value` exactly.
      */
    def classShortNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 7, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.classShortName == value }
    }

    /** Traverse to nodes where classShortName matches one of the elements in `values` exactly.
      */
    def classShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.classShortName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]](traversal: Iterator[NodeType]) {

    /** Traverse to closureBindingId property */
    def closureBindingId: Iterator[String] =
      traversal.flatMap(_.closureBindingId)

    /** Traverse to nodes where the closureBindingId matches the regular expression `value`
      */
    def closureBindingId(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        closureBindingIdExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the closureBindingId matches at least one of the regular expressions in `values`
      */
    def closureBindingId(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.closureBindingId; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where closureBindingId matches `value` exactly.
      */
    def closureBindingIdExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 8, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where closureBindingId matches one of the elements in `values` exactly.
      */
    def closureBindingIdExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) closureBindingIdExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to closureOriginalName property */
    def closureOriginalName: Iterator[String] =
      traversal.flatMap(_.closureOriginalName)

    /** Traverse to nodes where the closureOriginalName matches the regular expression `value`
      */
    def closureOriginalName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        closureOriginalNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.closureOriginalName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the closureOriginalName matches at least one of the regular expressions in `values`
      */
    def closureOriginalName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.closureOriginalName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where closureOriginalName matches `value` exactly.
      */
    def closureOriginalNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 9, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.closureOriginalName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where closureOriginalName matches one of the elements in `values` exactly.
      */
    def closureOriginalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) closureOriginalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.closureOriginalName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]](traversal: Iterator[NodeType]) {

    /** Traverse to code property */
    def code: Iterator[String] =
      traversal.map(_.code)

    /** Traverse to nodes where the code matches the regular expression `value`
      */
    def code(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        codeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.code).matches }
      }

    /** Traverse to nodes where the code matches at least one of the regular expressions in `values`
      */
    def code(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.code).matches } }
    }

    /** Traverse to nodes where code matches `value` exactly.
      */
    def codeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 10, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.code == value }
    }

    /** Traverse to nodes where code matches one of the elements in `values` exactly.
      */
    def codeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) codeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.code) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]](traversal: Iterator[NodeType]) {

    /** Traverse to columnNumber property */
    def columnNumber: Iterator[Int] =
      traversal.flatMap(_.columnNumber)

    /** Traverse to nodes where the columnNumber equals the given `value`
      */
    def columnNumber(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the columnNumber equals at least one of the given `values`
      */
    def columnNumber(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the columnNumber is greater than the given `value`
      */
    def columnNumberGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the columnNumber is greater than or equal the given `value`
      */
    def columnNumberGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the columnNumber is less than the given `value`
      */
    def columnNumberLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the columnNumber is less than or equal the given `value`
      */
    def columnNumberLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get <= value
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]](traversal: Iterator[NodeType]) {

    /** Traverse to columnNumberEnd property */
    def columnNumberEnd: Iterator[Int] =
      traversal.flatMap(_.columnNumberEnd)

    /** Traverse to nodes where the columnNumberEnd equals the given `value`
      */
    def columnNumberEnd(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the columnNumberEnd equals at least one of the given `values`
      */
    def columnNumberEnd(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the columnNumberEnd is greater than the given `value`
      */
    def columnNumberEndGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the columnNumberEnd is greater than or equal the given `value`
      */
    def columnNumberEndGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the columnNumberEnd is less than the given `value`
      */
    def columnNumberEndLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the columnNumberEnd is less than or equal the given `value`
      */
    def columnNumberEndLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get <= value
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]](traversal: Iterator[NodeType]) {

    /** Traverse to containedRef property */
    def containedRef: Iterator[String] =
      traversal.map(_.containedRef)

    /** Traverse to nodes where the containedRef matches the regular expression `value`
      */
    def containedRef(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        containedRefExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.containedRef).matches }
      }

    /** Traverse to nodes where the containedRef matches at least one of the regular expressions in `values`
      */
    def containedRef(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.containedRef).matches } }
    }

    /** Traverse to nodes where containedRef matches `value` exactly.
      */
    def containedRefExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 13, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.containedRef == value }
    }

    /** Traverse to nodes where containedRef matches one of the elements in `values` exactly.
      */
    def containedRefExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) containedRefExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.containedRef) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]](traversal: Iterator[NodeType]) {

    /** Traverse to content property */
    def content: Iterator[String] =
      traversal.map(_.content)

    /** Traverse to nodes where the content matches the regular expression `value`
      */
    def content(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        contentExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.content).matches }
      }

    /** Traverse to nodes where the content matches at least one of the regular expressions in `values`
      */
    def content(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.content).matches } }
    }

    /** Traverse to nodes where content matches `value` exactly.
      */
    def contentExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 14, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.content == value }
    }

    /** Traverse to nodes where content matches one of the elements in `values` exactly.
      */
    def contentExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) contentExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.content) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]](traversal: Iterator[NodeType]) {

    /** Traverse to controlStructureType property */
    def controlStructureType: Iterator[String] =
      traversal.map(_.controlStructureType)

    /** Traverse to nodes where the controlStructureType matches the regular expression `value`
      */
    def controlStructureType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        controlStructureTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.controlStructureType).matches }
      }

    /** Traverse to nodes where the controlStructureType matches at least one of the regular expressions in `values`
      */
    def controlStructureType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.controlStructureType).matches } }
    }

    /** Traverse to nodes where controlStructureType matches `value` exactly.
      */
    def controlStructureTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 15, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.controlStructureType == value }
    }

    /** Traverse to nodes where controlStructureType matches one of the elements in `values` exactly.
      */
    def controlStructureTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) controlStructureTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.controlStructureType) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]](traversal: Iterator[NodeType]) {

    /** Traverse to dependencyGroupId property */
    def dependencyGroupId: Iterator[String] =
      traversal.flatMap(_.dependencyGroupId)

    /** Traverse to nodes where the dependencyGroupId matches the regular expression `value`
      */
    def dependencyGroupId(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dependencyGroupIdExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.dependencyGroupId; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the dependencyGroupId matches at least one of the regular expressions in `values`
      */
    def dependencyGroupId(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.dependencyGroupId; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where dependencyGroupId matches `value` exactly.
      */
    def dependencyGroupIdExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 16, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.dependencyGroupId; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where dependencyGroupId matches one of the elements in `values` exactly.
      */
    def dependencyGroupIdExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dependencyGroupIdExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.dependencyGroupId; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]](traversal: Iterator[NodeType]) {

    /** Traverse to dispatchType property */
    def dispatchType: Iterator[String] =
      traversal.map(_.dispatchType)

    /** Traverse to nodes where the dispatchType matches the regular expression `value`
      */
    def dispatchType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dispatchTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dispatchType).matches }
      }

    /** Traverse to nodes where the dispatchType matches at least one of the regular expressions in `values`
      */
    def dispatchType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dispatchType).matches } }
    }

    /** Traverse to nodes where dispatchType matches `value` exactly.
      */
    def dispatchTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 17, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.dispatchType == value }
    }

    /** Traverse to nodes where dispatchType matches one of the elements in `values` exactly.
      */
    def dispatchTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dispatchTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dispatchType) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]](traversal: Iterator[NodeType]) {

    /** Traverse to evaluationStrategy property */
    def evaluationStrategy: Iterator[String] =
      traversal.map(_.evaluationStrategy)

    /** Traverse to nodes where the evaluationStrategy matches the regular expression `value`
      */
    def evaluationStrategy(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationStrategyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationStrategy).matches }
      }

    /** Traverse to nodes where the evaluationStrategy matches at least one of the regular expressions in `values`
      */
    def evaluationStrategy(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationStrategy).matches } }
    }

    /** Traverse to nodes where evaluationStrategy matches `value` exactly.
      */
    def evaluationStrategyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 19, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.evaluationStrategy == value }
    }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]](traversal: Iterator[NodeType]) {

    /** Traverse to explicitAs property */
    def explicitAs: Iterator[Boolean] =
      traversal.flatMap(_.explicitAs)

    /** Traverse to nodes where the explicitAs equals the given `value`
      */
    def explicitAs(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.explicitAs.isDefined && node.explicitAs.get == value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]](traversal: Iterator[NodeType]) {

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]](traversal: Iterator[NodeType]) {

    /** Traverse to hash property */
    def hash: Iterator[String] =
      traversal.flatMap(_.hash)

    /** Traverse to nodes where the hash matches the regular expression `value`
      */
    def hash(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        hashExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the hash matches at least one of the regular expressions in `values`
      */
    def hash(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.hash; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where hash matches `value` exactly.
      */
    def hashExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 23, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.hash; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where hash matches one of the elements in `values` exactly.
      */
    def hashExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) hashExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]](traversal: Iterator[NodeType]) {

    /** Traverse to importedAs property */
    def importedAs: Iterator[String] =
      traversal.flatMap(_.importedAs)

    /** Traverse to nodes where the importedAs matches the regular expression `value`
      */
    def importedAs(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        importedAsExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.importedAs; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the importedAs matches at least one of the regular expressions in `values`
      */
    def importedAs(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.importedAs; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where importedAs matches `value` exactly.
      */
    def importedAsExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 24, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.importedAs; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where importedAs matches one of the elements in `values` exactly.
      */
    def importedAsExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) importedAsExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.importedAs; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]](traversal: Iterator[NodeType]) {

    /** Traverse to importedEntity property */
    def importedEntity: Iterator[String] =
      traversal.flatMap(_.importedEntity)

    /** Traverse to nodes where the importedEntity matches the regular expression `value`
      */
    def importedEntity(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        importedEntityExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.importedEntity; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the importedEntity matches at least one of the regular expressions in `values`
      */
    def importedEntity(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.importedEntity; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where importedEntity matches `value` exactly.
      */
    def importedEntityExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 25, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.importedEntity; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where importedEntity matches one of the elements in `values` exactly.
      */
    def importedEntityExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) importedEntityExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.importedEntity; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]](traversal: Iterator[NodeType]) {

    /** Traverse to index property */
    def index: Iterator[Int] =
      traversal.map(_.index)

    /** Traverse to nodes where the index equals the given `value`
      */
    def index(value: Int): Iterator[NodeType] =
      traversal.filter { _.index == value }

    /** Traverse to nodes where the index equals at least one of the given `values`
      */
    def index(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.index) }
    }

    /** Traverse to nodes where the index is greater than the given `value`
      */
    def indexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index > value }

    /** Traverse to nodes where the index is greater than or equal the given `value`
      */
    def indexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index >= value }

    /** Traverse to nodes where the index is less than the given `value`
      */
    def indexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index < value }

    /** Traverse to nodes where the index is less than or equal the given `value`
      */
    def indexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index <= value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to inheritsFromTypeFullName property */
    def inheritsFromTypeFullName: Iterator[String] =
      traversal.flatMap(_.inheritsFromTypeFullName)

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]](traversal: Iterator[NodeType]) {

    /** Traverse to isExplicit property */
    def isExplicit: Iterator[Boolean] =
      traversal.flatMap(_.isExplicit)

    /** Traverse to nodes where the isExplicit equals the given `value`
      */
    def isExplicit(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isExplicit.isDefined && node.isExplicit.get == value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]](traversal: Iterator[NodeType]) {

    /** Traverse to isExternal property */
    def isExternal: Iterator[Boolean] =
      traversal.map(_.isExternal)

    /** Traverse to nodes where the isExternal equals the given `value`
      */
    def isExternal(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isExternal == value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]](traversal: Iterator[NodeType]) {

    /** Traverse to isVariadic property */
    def isVariadic: Iterator[Boolean] =
      traversal.map(_.isVariadic)

    /** Traverse to nodes where the isVariadic equals the given `value`
      */
    def isVariadic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isVariadic == value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]](traversal: Iterator[NodeType]) {

    /** Traverse to isWildcard property */
    def isWildcard: Iterator[Boolean] =
      traversal.flatMap(_.isWildcard)

    /** Traverse to nodes where the isWildcard equals the given `value`
      */
    def isWildcard(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isWildcard.isDefined && node.isWildcard.get == value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]](traversal: Iterator[NodeType]) {

    /** Traverse to key property */
    def key: Iterator[String] =
      traversal.map(_.key)

    /** Traverse to nodes where the key matches the regular expression `value`
      */
    def key(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        keyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.key).matches }
      }

    /** Traverse to nodes where the key matches at least one of the regular expressions in `values`
      */
    def key(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.key).matches } }
    }

    /** Traverse to nodes where key matches `value` exactly.
      */
    def keyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 32, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.key == value }
    }

    /** Traverse to nodes where key matches one of the elements in `values` exactly.
      */
    def keyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) keyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.key) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]](traversal: Iterator[NodeType]) {

    /** Traverse to language property */
    def language: Iterator[String] =
      traversal.map(_.language)

    /** Traverse to nodes where the language matches the regular expression `value`
      */
    def language(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        languageExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.language).matches }
      }

    /** Traverse to nodes where the language matches at least one of the regular expressions in `values`
      */
    def language(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.language).matches } }
    }

    /** Traverse to nodes where language matches `value` exactly.
      */
    def languageExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 33, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.language == value }
    }

    /** Traverse to nodes where language matches one of the elements in `values` exactly.
      */
    def languageExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) languageExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.language) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]](traversal: Iterator[NodeType]) {

    /** Traverse to lineNumber property */
    def lineNumber: Iterator[Int] =
      traversal.flatMap(_.lineNumber)

    /** Traverse to nodes where the lineNumber equals the given `value`
      */
    def lineNumber(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the lineNumber equals at least one of the given `values`
      */
    def lineNumber(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the lineNumber is greater than the given `value`
      */
    def lineNumberGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the lineNumber is greater than or equal the given `value`
      */
    def lineNumberGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the lineNumber is less than the given `value`
      */
    def lineNumberLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the lineNumber is less than or equal the given `value`
      */
    def lineNumberLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get <= value
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]](traversal: Iterator[NodeType]) {

    /** Traverse to lineNumberEnd property */
    def lineNumberEnd: Iterator[Int] =
      traversal.flatMap(_.lineNumberEnd)

    /** Traverse to nodes where the lineNumberEnd equals the given `value`
      */
    def lineNumberEnd(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the lineNumberEnd equals at least one of the given `values`
      */
    def lineNumberEnd(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the lineNumberEnd is greater than the given `value`
      */
    def lineNumberEndGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the lineNumberEnd is greater than or equal the given `value`
      */
    def lineNumberEndGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the lineNumberEnd is less than the given `value`
      */
    def lineNumberEndLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the lineNumberEnd is less than or equal the given `value`
      */
    def lineNumberEndLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get <= value
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to methodFullName property */
    def methodFullName: Iterator[String] =
      traversal.map(_.methodFullName)

    /** Traverse to nodes where the methodFullName matches the regular expression `value`
      */
    def methodFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodFullName).matches }
      }

    /** Traverse to nodes where the methodFullName matches at least one of the regular expressions in `values`
      */
    def methodFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodFullName).matches } }
    }

    /** Traverse to nodes where methodFullName matches `value` exactly.
      */
    def methodFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 36, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodFullName == value }
    }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to methodShortName property */
    def methodShortName: Iterator[String] =
      traversal.map(_.methodShortName)

    /** Traverse to nodes where the methodShortName matches the regular expression `value`
      */
    def methodShortName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodShortNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodShortName).matches }
      }

    /** Traverse to nodes where the methodShortName matches at least one of the regular expressions in `values`
      */
    def methodShortName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodShortName).matches } }
    }

    /** Traverse to nodes where methodShortName matches `value` exactly.
      */
    def methodShortNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 37, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodShortName == value }
    }

    /** Traverse to nodes where methodShortName matches one of the elements in `values` exactly.
      */
    def methodShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodShortName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]](traversal: Iterator[NodeType]) {

    /** Traverse to modifierType property */
    def modifierType: Iterator[String] =
      traversal.map(_.modifierType)

    /** Traverse to nodes where the modifierType matches the regular expression `value`
      */
    def modifierType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        modifierTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.modifierType).matches }
      }

    /** Traverse to nodes where the modifierType matches at least one of the regular expressions in `values`
      */
    def modifierType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.modifierType).matches } }
    }

    /** Traverse to nodes where modifierType matches `value` exactly.
      */
    def modifierTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 38, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.modifierType == value }
    }

    /** Traverse to nodes where modifierType matches one of the elements in `values` exactly.
      */
    def modifierTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) modifierTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.modifierType) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]](traversal: Iterator[NodeType]) {

    /** Traverse to nodeLabel property */
    def nodeLabel: Iterator[String] =
      traversal.map(_.nodeLabel)

    /** Traverse to nodes where the nodeLabel matches the regular expression `value`
      */
    def nodeLabel(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nodeLabelExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.nodeLabel).matches }
      }

    /** Traverse to nodes where the nodeLabel matches at least one of the regular expressions in `values`
      */
    def nodeLabel(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.nodeLabel).matches } }
    }

    /** Traverse to nodes where nodeLabel matches `value` exactly.
      */
    def nodeLabelExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 40, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.nodeLabel == value }
    }

    /** Traverse to nodes where nodeLabel matches one of the elements in `values` exactly.
      */
    def nodeLabelExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nodeLabelExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.nodeLabel) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]](traversal: Iterator[NodeType]) {

    /** Traverse to order property */
    def order: Iterator[Int] =
      traversal.map(_.order)

    /** Traverse to nodes where the order equals the given `value`
      */
    def order(value: Int): Iterator[NodeType] =
      traversal.filter { _.order == value }

    /** Traverse to nodes where the order equals at least one of the given `values`
      */
    def order(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.order) }
    }

    /** Traverse to nodes where the order is greater than the given `value`
      */
    def orderGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.order > value }

    /** Traverse to nodes where the order is greater than or equal the given `value`
      */
    def orderGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.order >= value }

    /** Traverse to nodes where the order is less than the given `value`
      */
    def orderLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.order < value }

    /** Traverse to nodes where the order is less than or equal the given `value`
      */
    def orderLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.order <= value }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]](traversal: Iterator[NodeType]) {

    /** Traverse to overlays property */
    def overlays: Iterator[String] =
      traversal.flatMap(_.overlays)

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to packageName property */
    def packageName: Iterator[String] =
      traversal.map(_.packageName)

    /** Traverse to nodes where the packageName matches the regular expression `value`
      */
    def packageName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        packageNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.packageName).matches }
      }

    /** Traverse to nodes where the packageName matches at least one of the regular expressions in `values`
      */
    def packageName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.packageName).matches } }
    }

    /** Traverse to nodes where packageName matches `value` exactly.
      */
    def packageNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 43, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.packageName == value }
    }

    /** Traverse to nodes where packageName matches one of the elements in `values` exactly.
      */
    def packageNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) packageNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.packageName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to parserTypeName property */
    def parserTypeName: Iterator[String] =
      traversal.map(_.parserTypeName)

    /** Traverse to nodes where the parserTypeName matches the regular expression `value`
      */
    def parserTypeName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        parserTypeNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.parserTypeName).matches }
      }

    /** Traverse to nodes where the parserTypeName matches at least one of the regular expressions in `values`
      */
    def parserTypeName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.parserTypeName).matches } }
    }

    /** Traverse to nodes where parserTypeName matches `value` exactly.
      */
    def parserTypeNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 44, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.parserTypeName == value }
    }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPossibleTypesT]](traversal: Iterator[NodeType]) {

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]](traversal: Iterator[NodeType]) {

    /** Traverse to root property */
    def root: Iterator[String] =
      traversal.map(_.root)

    /** Traverse to nodes where the root matches the regular expression `value`
      */
    def root(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        rootExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.root).matches }
      }

    /** Traverse to nodes where the root matches at least one of the regular expressions in `values`
      */
    def root(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.root).matches } }
    }

    /** Traverse to nodes where root matches `value` exactly.
      */
    def rootExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 46, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.root == value }
    }

    /** Traverse to nodes where root matches one of the elements in `values` exactly.
      */
    def rootExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) rootExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.root) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]](traversal: Iterator[NodeType]) {

    /** Traverse to signature property */
    def signature: Iterator[String] =
      traversal.map(_.signature)

    /** Traverse to nodes where the signature matches the regular expression `value`
      */
    def signature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        signatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.signature).matches }
      }

    /** Traverse to nodes where the signature matches at least one of the regular expressions in `values`
      */
    def signature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.signature).matches } }
    }

    /** Traverse to nodes where signature matches `value` exactly.
      */
    def signatureExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 47, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.signature == value }
    }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]](traversal: Iterator[NodeType]) {

    /** Traverse to symbol property */
    def symbol: Iterator[String] =
      traversal.map(_.symbol)

    /** Traverse to nodes where the symbol matches the regular expression `value`
      */
    def symbol(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        symbolExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.symbol).matches }
      }

    /** Traverse to nodes where the symbol matches at least one of the regular expressions in `values`
      */
    def symbol(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.symbol).matches } }
    }

    /** Traverse to nodes where symbol matches `value` exactly.
      */
    def symbolExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 48, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.symbol == value }
    }

    /** Traverse to nodes where symbol matches one of the elements in `values` exactly.
      */
    def symbolExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) symbolExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.symbol) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to typeDeclFullName property */
    def typeDeclFullName: Iterator[String] =
      traversal.map(_.typeDeclFullName)

    /** Traverse to nodes where the typeDeclFullName matches the regular expression `value`
      */
    def typeDeclFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeDeclFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeDeclFullName).matches }
      }

    /** Traverse to nodes where the typeDeclFullName matches at least one of the regular expressions in `values`
      */
    def typeDeclFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeDeclFullName).matches } }
    }

    /** Traverse to nodes where typeDeclFullName matches `value` exactly.
      */
    def typeDeclFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 49, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeDeclFullName == value }
    }

    /** Traverse to nodes where typeDeclFullName matches one of the elements in `values` exactly.
      */
    def typeDeclFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeDeclFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeDeclFullName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]](traversal: Iterator[NodeType]) {

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]](traversal: Iterator[NodeType]) {

    /** Traverse to value property */
    def value: Iterator[String] =
      traversal.map(_.value)

    /** Traverse to nodes where the value matches the regular expression `value`
      */
    def value(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        valueExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.value).matches }
      }

    /** Traverse to nodes where the value matches at least one of the regular expressions in `values`
      */
    def value(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.value).matches } }
    }

    /** Traverse to nodes where value matches `value` exactly.
      */
    def valueExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 51, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.value == value }
    }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  extension [NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]](traversal: Iterator[NodeType]) {

    /** Traverse to version property */
    def version: Iterator[String] =
      traversal.map(_.version)

    /** Traverse to nodes where the version matches the regular expression `value`
      */
    def version(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        versionExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.version).matches }
      }

    /** Traverse to nodes where the version matches at least one of the regular expressions in `values`
      */
    def version(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.version).matches } }
    }

    /** Traverse to nodes where version matches `value` exactly.
      */
    def versionExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 52, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.version == value }
    }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  extension [NodeType <: nodes.AnnotationBase](traversal: Iterator[NodeType]) {

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.AnnotationLiteralBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.BindingBase](traversal: Iterator[NodeType]) {

    /** Traverse to methodFullName property */
    def methodFullName: Iterator[String] =
      traversal.map(_.methodFullName)

    /** Traverse to nodes where the methodFullName matches the regular expression `value`
      */
    def methodFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodFullName).matches }
      }

    /** Traverse to nodes where the methodFullName matches at least one of the regular expressions in `values`
      */
    def methodFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodFullName).matches } }
    }

    /** Traverse to nodes where methodFullName matches `value` exactly.
      */
    def methodFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 36, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodFullName == value }
    }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to signature property */
    def signature: Iterator[String] =
      traversal.map(_.signature)

    /** Traverse to nodes where the signature matches the regular expression `value`
      */
    def signature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        signatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.signature).matches }
      }

    /** Traverse to nodes where the signature matches at least one of the regular expressions in `values`
      */
    def signature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.signature).matches } }
    }

    /** Traverse to nodes where signature matches `value` exactly.
      */
    def signatureExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 47, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.signature == value }
    }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  extension [NodeType <: nodes.BlockBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.CallBase](traversal: Iterator[NodeType]) {

    /** Traverse to dispatchType property */
    def dispatchType: Iterator[String] =
      traversal.map(_.dispatchType)

    /** Traverse to nodes where the dispatchType matches the regular expression `value`
      */
    def dispatchType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dispatchTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dispatchType).matches }
      }

    /** Traverse to nodes where the dispatchType matches at least one of the regular expressions in `values`
      */
    def dispatchType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dispatchType).matches } }
    }

    /** Traverse to nodes where dispatchType matches `value` exactly.
      */
    def dispatchTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 17, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.dispatchType == value }
    }

    /** Traverse to nodes where dispatchType matches one of the elements in `values` exactly.
      */
    def dispatchTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dispatchTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dispatchType) }
      }

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to methodFullName property */
    def methodFullName: Iterator[String] =
      traversal.map(_.methodFullName)

    /** Traverse to nodes where the methodFullName matches the regular expression `value`
      */
    def methodFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodFullName).matches }
      }

    /** Traverse to nodes where the methodFullName matches at least one of the regular expressions in `values`
      */
    def methodFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodFullName).matches } }
    }

    /** Traverse to nodes where methodFullName matches `value` exactly.
      */
    def methodFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 36, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodFullName == value }
    }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.ClosureBindingBase](traversal: Iterator[NodeType]) {

    /** Traverse to closureBindingId property */
    def closureBindingId: Iterator[String] =
      traversal.flatMap(_.closureBindingId)

    /** Traverse to nodes where the closureBindingId matches the regular expression `value`
      */
    def closureBindingId(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        closureBindingIdExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the closureBindingId matches at least one of the regular expressions in `values`
      */
    def closureBindingId(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.closureBindingId; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where closureBindingId matches `value` exactly.
      */
    def closureBindingIdExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 8, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where closureBindingId matches one of the elements in `values` exactly.
      */
    def closureBindingIdExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) closureBindingIdExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to closureOriginalName property */
    def closureOriginalName: Iterator[String] =
      traversal.flatMap(_.closureOriginalName)

    /** Traverse to nodes where the closureOriginalName matches the regular expression `value`
      */
    def closureOriginalName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        closureOriginalNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.closureOriginalName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the closureOriginalName matches at least one of the regular expressions in `values`
      */
    def closureOriginalName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.closureOriginalName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where closureOriginalName matches `value` exactly.
      */
    def closureOriginalNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 9, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.closureOriginalName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where closureOriginalName matches one of the elements in `values` exactly.
      */
    def closureOriginalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) closureOriginalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.closureOriginalName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to evaluationStrategy property */
    def evaluationStrategy: Iterator[String] =
      traversal.map(_.evaluationStrategy)

    /** Traverse to nodes where the evaluationStrategy matches the regular expression `value`
      */
    def evaluationStrategy(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationStrategyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationStrategy).matches }
      }

    /** Traverse to nodes where the evaluationStrategy matches at least one of the regular expressions in `values`
      */
    def evaluationStrategy(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationStrategy).matches } }
    }

    /** Traverse to nodes where evaluationStrategy matches `value` exactly.
      */
    def evaluationStrategyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 19, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.evaluationStrategy == value }
    }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

  }
  extension [NodeType <: nodes.CommentBase](traversal: Iterator[NodeType]) {

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

  }
  extension [NodeType <: nodes.ConfigFileBase](traversal: Iterator[NodeType]) {

    /** Traverse to content property */
    def content: Iterator[String] =
      traversal.map(_.content)

    /** Traverse to nodes where the content matches the regular expression `value`
      */
    def content(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        contentExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.content).matches }
      }

    /** Traverse to nodes where the content matches at least one of the regular expressions in `values`
      */
    def content(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.content).matches } }
    }

    /** Traverse to nodes where content matches `value` exactly.
      */
    def contentExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 14, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.content == value }
    }

    /** Traverse to nodes where content matches one of the elements in `values` exactly.
      */
    def contentExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) contentExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.content) }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.ControlStructureBase](traversal: Iterator[NodeType]) {

    /** Traverse to controlStructureType property */
    def controlStructureType: Iterator[String] =
      traversal.map(_.controlStructureType)

    /** Traverse to nodes where the controlStructureType matches the regular expression `value`
      */
    def controlStructureType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        controlStructureTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.controlStructureType).matches }
      }

    /** Traverse to nodes where the controlStructureType matches at least one of the regular expressions in `values`
      */
    def controlStructureType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.controlStructureType).matches } }
    }

    /** Traverse to nodes where controlStructureType matches `value` exactly.
      */
    def controlStructureTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 15, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.controlStructureType == value }
    }

    /** Traverse to nodes where controlStructureType matches one of the elements in `values` exactly.
      */
    def controlStructureTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) controlStructureTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.controlStructureType) }
      }

    /** Traverse to parserTypeName property */
    def parserTypeName: Iterator[String] =
      traversal.map(_.parserTypeName)

    /** Traverse to nodes where the parserTypeName matches the regular expression `value`
      */
    def parserTypeName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        parserTypeNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.parserTypeName).matches }
      }

    /** Traverse to nodes where the parserTypeName matches at least one of the regular expressions in `values`
      */
    def parserTypeName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.parserTypeName).matches } }
    }

    /** Traverse to nodes where parserTypeName matches `value` exactly.
      */
    def parserTypeNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 44, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.parserTypeName == value }
    }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  extension [NodeType <: nodes.DependencyBase](traversal: Iterator[NodeType]) {

    /** Traverse to dependencyGroupId property */
    def dependencyGroupId: Iterator[String] =
      traversal.flatMap(_.dependencyGroupId)

    /** Traverse to nodes where the dependencyGroupId matches the regular expression `value`
      */
    def dependencyGroupId(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dependencyGroupIdExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.dependencyGroupId; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the dependencyGroupId matches at least one of the regular expressions in `values`
      */
    def dependencyGroupId(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.dependencyGroupId; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where dependencyGroupId matches `value` exactly.
      */
    def dependencyGroupIdExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 16, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.dependencyGroupId; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where dependencyGroupId matches one of the elements in `values` exactly.
      */
    def dependencyGroupIdExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dependencyGroupIdExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.dependencyGroupId; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to version property */
    def version: Iterator[String] =
      traversal.map(_.version)

    /** Traverse to nodes where the version matches the regular expression `value`
      */
    def version(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        versionExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.version).matches }
      }

    /** Traverse to nodes where the version matches at least one of the regular expressions in `values`
      */
    def version(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.version).matches } }
    }

    /** Traverse to nodes where version matches `value` exactly.
      */
    def versionExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 52, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.version == value }
    }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
  extension [NodeType <: nodes.FieldIdentifierBase](traversal: Iterator[NodeType]) {

    /** Traverse to canonicalName property */
    def canonicalName: Iterator[String] =
      traversal.map(_.canonicalName)

    /** Traverse to nodes where the canonicalName matches the regular expression `value`
      */
    def canonicalName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        canonicalNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.canonicalName).matches }
      }

    /** Traverse to nodes where the canonicalName matches at least one of the regular expressions in `values`
      */
    def canonicalName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.canonicalName).matches } }
    }

    /** Traverse to nodes where canonicalName matches `value` exactly.
      */
    def canonicalNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 5, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.canonicalName == value }
    }

    /** Traverse to nodes where canonicalName matches one of the elements in `values` exactly.
      */
    def canonicalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) canonicalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.canonicalName) }
      }

  }
  extension [NodeType <: nodes.FileBase](traversal: Iterator[NodeType]) {

    /** Traverse to hash property */
    def hash: Iterator[String] =
      traversal.flatMap(_.hash)

    /** Traverse to nodes where the hash matches the regular expression `value`
      */
    def hash(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        hashExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the hash matches at least one of the regular expressions in `values`
      */
    def hash(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.hash; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where hash matches `value` exactly.
      */
    def hashExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 23, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.hash; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where hash matches one of the elements in `values` exactly.
      */
    def hashExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) hashExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.IdentifierBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.ImportBase](traversal: Iterator[NodeType]) {

    /** Traverse to explicitAs property */
    def explicitAs: Iterator[Boolean] =
      traversal.flatMap(_.explicitAs)

    /** Traverse to nodes where the explicitAs equals the given `value`
      */
    def explicitAs(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.explicitAs.isDefined && node.explicitAs.get == value }

    /** Traverse to importedAs property */
    def importedAs: Iterator[String] =
      traversal.flatMap(_.importedAs)

    /** Traverse to nodes where the importedAs matches the regular expression `value`
      */
    def importedAs(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        importedAsExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.importedAs; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the importedAs matches at least one of the regular expressions in `values`
      */
    def importedAs(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.importedAs; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where importedAs matches `value` exactly.
      */
    def importedAsExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 24, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.importedAs; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where importedAs matches one of the elements in `values` exactly.
      */
    def importedAsExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) importedAsExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.importedAs; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to importedEntity property */
    def importedEntity: Iterator[String] =
      traversal.flatMap(_.importedEntity)

    /** Traverse to nodes where the importedEntity matches the regular expression `value`
      */
    def importedEntity(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        importedEntityExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.importedEntity; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the importedEntity matches at least one of the regular expressions in `values`
      */
    def importedEntity(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.importedEntity; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where importedEntity matches `value` exactly.
      */
    def importedEntityExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 25, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.importedEntity; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where importedEntity matches one of the elements in `values` exactly.
      */
    def importedEntityExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) importedEntityExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.importedEntity; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to isExplicit property */
    def isExplicit: Iterator[Boolean] =
      traversal.flatMap(_.isExplicit)

    /** Traverse to nodes where the isExplicit equals the given `value`
      */
    def isExplicit(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isExplicit.isDefined && node.isExplicit.get == value }

    /** Traverse to isWildcard property */
    def isWildcard: Iterator[Boolean] =
      traversal.flatMap(_.isWildcard)

    /** Traverse to nodes where the isWildcard equals the given `value`
      */
    def isWildcard(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isWildcard.isDefined && node.isWildcard.get == value }

  }
  extension [NodeType <: nodes.JumpLabelBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to parserTypeName property */
    def parserTypeName: Iterator[String] =
      traversal.map(_.parserTypeName)

    /** Traverse to nodes where the parserTypeName matches the regular expression `value`
      */
    def parserTypeName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        parserTypeNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.parserTypeName).matches }
      }

    /** Traverse to nodes where the parserTypeName matches at least one of the regular expressions in `values`
      */
    def parserTypeName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.parserTypeName).matches } }
    }

    /** Traverse to nodes where parserTypeName matches `value` exactly.
      */
    def parserTypeNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 44, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.parserTypeName == value }
    }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  extension [NodeType <: nodes.JumpTargetBase](traversal: Iterator[NodeType]) {

    /** Traverse to argumentIndex property */
    def argumentIndex: Iterator[Int] =
      traversal.map(_.argumentIndex)

    /** Traverse to nodes where the argumentIndex equals the given `value`
      */
    def argumentIndex(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex == value }

    /** Traverse to nodes where the argumentIndex equals at least one of the given `values`
      */
    def argumentIndex(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.argumentIndex) }
    }

    /** Traverse to nodes where the argumentIndex is greater than the given `value`
      */
    def argumentIndexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex > value }

    /** Traverse to nodes where the argumentIndex is greater than or equal the given `value`
      */
    def argumentIndexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex >= value }

    /** Traverse to nodes where the argumentIndex is less than the given `value`
      */
    def argumentIndexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex < value }

    /** Traverse to nodes where the argumentIndex is less than or equal the given `value`
      */
    def argumentIndexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex <= value }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to parserTypeName property */
    def parserTypeName: Iterator[String] =
      traversal.map(_.parserTypeName)

    /** Traverse to nodes where the parserTypeName matches the regular expression `value`
      */
    def parserTypeName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        parserTypeNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.parserTypeName).matches }
      }

    /** Traverse to nodes where the parserTypeName matches at least one of the regular expressions in `values`
      */
    def parserTypeName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.parserTypeName).matches } }
    }

    /** Traverse to nodes where parserTypeName matches `value` exactly.
      */
    def parserTypeNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 44, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.parserTypeName == value }
    }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  extension [NodeType <: nodes.KeyValuePairBase](traversal: Iterator[NodeType]) {

    /** Traverse to key property */
    def key: Iterator[String] =
      traversal.map(_.key)

    /** Traverse to nodes where the key matches the regular expression `value`
      */
    def key(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        keyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.key).matches }
      }

    /** Traverse to nodes where the key matches at least one of the regular expressions in `values`
      */
    def key(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.key).matches } }
    }

    /** Traverse to nodes where key matches `value` exactly.
      */
    def keyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 32, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.key == value }
    }

    /** Traverse to nodes where key matches one of the elements in `values` exactly.
      */
    def keyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) keyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.key) }
      }

    /** Traverse to value property */
    def value: Iterator[String] =
      traversal.map(_.value)

    /** Traverse to nodes where the value matches the regular expression `value`
      */
    def value(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        valueExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.value).matches }
      }

    /** Traverse to nodes where the value matches at least one of the regular expressions in `values`
      */
    def value(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.value).matches } }
    }

    /** Traverse to nodes where value matches `value` exactly.
      */
    def valueExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 51, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.value == value }
    }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  extension [NodeType <: nodes.LiteralBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.LocalBase](traversal: Iterator[NodeType]) {

    /** Traverse to closureBindingId property */
    def closureBindingId: Iterator[String] =
      traversal.flatMap(_.closureBindingId)

    /** Traverse to nodes where the closureBindingId matches the regular expression `value`
      */
    def closureBindingId(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        closureBindingIdExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the closureBindingId matches at least one of the regular expressions in `values`
      */
    def closureBindingId(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.closureBindingId; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where closureBindingId matches `value` exactly.
      */
    def closureBindingIdExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 8, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where closureBindingId matches one of the elements in `values` exactly.
      */
    def closureBindingIdExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) closureBindingIdExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.closureBindingId; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.LocationBase](traversal: Iterator[NodeType]) {

    /** Traverse to className property */
    def className: Iterator[String] =
      traversal.map(_.className)

    /** Traverse to nodes where the className matches the regular expression `value`
      */
    def className(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        classNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.className).matches }
      }

    /** Traverse to nodes where the className matches at least one of the regular expressions in `values`
      */
    def className(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.className).matches } }
    }

    /** Traverse to nodes where className matches `value` exactly.
      */
    def classNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 6, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.className == value }
    }

    /** Traverse to nodes where className matches one of the elements in `values` exactly.
      */
    def classNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.className) }
      }

    /** Traverse to classShortName property */
    def classShortName: Iterator[String] =
      traversal.map(_.classShortName)

    /** Traverse to nodes where the classShortName matches the regular expression `value`
      */
    def classShortName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        classShortNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.classShortName).matches }
      }

    /** Traverse to nodes where the classShortName matches at least one of the regular expressions in `values`
      */
    def classShortName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.classShortName).matches } }
    }

    /** Traverse to nodes where classShortName matches `value` exactly.
      */
    def classShortNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 7, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.classShortName == value }
    }

    /** Traverse to nodes where classShortName matches one of the elements in `values` exactly.
      */
    def classShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.classShortName) }
      }

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

    /** Traverse to lineNumber property */
    def lineNumber: Iterator[Int] =
      traversal.flatMap(_.lineNumber)

    /** Traverse to nodes where the lineNumber equals the given `value`
      */
    def lineNumber(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the lineNumber equals at least one of the given `values`
      */
    def lineNumber(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the lineNumber is greater than the given `value`
      */
    def lineNumberGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the lineNumber is greater than or equal the given `value`
      */
    def lineNumberGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the lineNumber is less than the given `value`
      */
    def lineNumberLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the lineNumber is less than or equal the given `value`
      */
    def lineNumberLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to methodFullName property */
    def methodFullName: Iterator[String] =
      traversal.map(_.methodFullName)

    /** Traverse to nodes where the methodFullName matches the regular expression `value`
      */
    def methodFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodFullName).matches }
      }

    /** Traverse to nodes where the methodFullName matches at least one of the regular expressions in `values`
      */
    def methodFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodFullName).matches } }
    }

    /** Traverse to nodes where methodFullName matches `value` exactly.
      */
    def methodFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 36, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodFullName == value }
    }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to methodShortName property */
    def methodShortName: Iterator[String] =
      traversal.map(_.methodShortName)

    /** Traverse to nodes where the methodShortName matches the regular expression `value`
      */
    def methodShortName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodShortNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodShortName).matches }
      }

    /** Traverse to nodes where the methodShortName matches at least one of the regular expressions in `values`
      */
    def methodShortName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodShortName).matches } }
    }

    /** Traverse to nodes where methodShortName matches `value` exactly.
      */
    def methodShortNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 37, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodShortName == value }
    }

    /** Traverse to nodes where methodShortName matches one of the elements in `values` exactly.
      */
    def methodShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodShortName) }
      }

    /** Traverse to nodeLabel property */
    def nodeLabel: Iterator[String] =
      traversal.map(_.nodeLabel)

    /** Traverse to nodes where the nodeLabel matches the regular expression `value`
      */
    def nodeLabel(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nodeLabelExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.nodeLabel).matches }
      }

    /** Traverse to nodes where the nodeLabel matches at least one of the regular expressions in `values`
      */
    def nodeLabel(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.nodeLabel).matches } }
    }

    /** Traverse to nodes where nodeLabel matches `value` exactly.
      */
    def nodeLabelExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 40, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.nodeLabel == value }
    }

    /** Traverse to nodes where nodeLabel matches one of the elements in `values` exactly.
      */
    def nodeLabelExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nodeLabelExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.nodeLabel) }
      }

    /** Traverse to packageName property */
    def packageName: Iterator[String] =
      traversal.map(_.packageName)

    /** Traverse to nodes where the packageName matches the regular expression `value`
      */
    def packageName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        packageNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.packageName).matches }
      }

    /** Traverse to nodes where the packageName matches at least one of the regular expressions in `values`
      */
    def packageName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.packageName).matches } }
    }

    /** Traverse to nodes where packageName matches `value` exactly.
      */
    def packageNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 43, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.packageName == value }
    }

    /** Traverse to nodes where packageName matches one of the elements in `values` exactly.
      */
    def packageNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) packageNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.packageName) }
      }

    /** Traverse to symbol property */
    def symbol: Iterator[String] =
      traversal.map(_.symbol)

    /** Traverse to nodes where the symbol matches the regular expression `value`
      */
    def symbol(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        symbolExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.symbol).matches }
      }

    /** Traverse to nodes where the symbol matches at least one of the regular expressions in `values`
      */
    def symbol(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.symbol).matches } }
    }

    /** Traverse to nodes where symbol matches `value` exactly.
      */
    def symbolExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 48, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.symbol == value }
    }

    /** Traverse to nodes where symbol matches one of the elements in `values` exactly.
      */
    def symbolExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) symbolExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.symbol) }
      }

  }
  extension [NodeType <: nodes.MemberBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.MetaDataBase](traversal: Iterator[NodeType]) {

    /** Traverse to hash property */
    def hash: Iterator[String] =
      traversal.flatMap(_.hash)

    /** Traverse to nodes where the hash matches the regular expression `value`
      */
    def hash(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        hashExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the hash matches at least one of the regular expressions in `values`
      */
    def hash(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.hash; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where hash matches `value` exactly.
      */
    def hashExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 23, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.hash; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where hash matches one of the elements in `values` exactly.
      */
    def hashExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) hashExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to language property */
    def language: Iterator[String] =
      traversal.map(_.language)

    /** Traverse to nodes where the language matches the regular expression `value`
      */
    def language(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        languageExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.language).matches }
      }

    /** Traverse to nodes where the language matches at least one of the regular expressions in `values`
      */
    def language(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.language).matches } }
    }

    /** Traverse to nodes where language matches `value` exactly.
      */
    def languageExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 33, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.language == value }
    }

    /** Traverse to nodes where language matches one of the elements in `values` exactly.
      */
    def languageExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) languageExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.language) }
      }

    /** Traverse to overlays property */
    def overlays: Iterator[String] =
      traversal.flatMap(_.overlays)

    /** Traverse to root property */
    def root: Iterator[String] =
      traversal.map(_.root)

    /** Traverse to nodes where the root matches the regular expression `value`
      */
    def root(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        rootExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.root).matches }
      }

    /** Traverse to nodes where the root matches at least one of the regular expressions in `values`
      */
    def root(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.root).matches } }
    }

    /** Traverse to nodes where root matches `value` exactly.
      */
    def rootExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 46, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.root == value }
    }

    /** Traverse to nodes where root matches one of the elements in `values` exactly.
      */
    def rootExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) rootExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.root) }
      }

    /** Traverse to version property */
    def version: Iterator[String] =
      traversal.map(_.version)

    /** Traverse to nodes where the version matches the regular expression `value`
      */
    def version(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        versionExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.version).matches }
      }

    /** Traverse to nodes where the version matches at least one of the regular expressions in `values`
      */
    def version(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.version).matches } }
    }

    /** Traverse to nodes where version matches `value` exactly.
      */
    def versionExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 52, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.version == value }
    }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
  extension [NodeType <: nodes.MethodBase](traversal: Iterator[NodeType]) {

    /** Traverse to astParentFullName property */
    def astParentFullName: Iterator[String] =
      traversal.map(_.astParentFullName)

    /** Traverse to nodes where the astParentFullName matches the regular expression `value`
      */
    def astParentFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentFullName).matches }
      }

    /** Traverse to nodes where the astParentFullName matches at least one of the regular expressions in `values`
      */
    def astParentFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentFullName).matches } }
    }

    /** Traverse to nodes where astParentFullName matches `value` exactly.
      */
    def astParentFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 3, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentFullName == value }
    }

    /** Traverse to nodes where astParentFullName matches one of the elements in `values` exactly.
      */
    def astParentFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentFullName) }
      }

    /** Traverse to astParentType property */
    def astParentType: Iterator[String] =
      traversal.map(_.astParentType)

    /** Traverse to nodes where the astParentType matches the regular expression `value`
      */
    def astParentType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentType).matches }
      }

    /** Traverse to nodes where the astParentType matches at least one of the regular expressions in `values`
      */
    def astParentType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentType).matches } }
    }

    /** Traverse to nodes where astParentType matches `value` exactly.
      */
    def astParentTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentType == value }
    }

    /** Traverse to nodes where astParentType matches one of the elements in `values` exactly.
      */
    def astParentTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentType) }
      }

    /** Traverse to columnNumberEnd property */
    def columnNumberEnd: Iterator[Int] =
      traversal.flatMap(_.columnNumberEnd)

    /** Traverse to nodes where the columnNumberEnd equals the given `value`
      */
    def columnNumberEnd(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the columnNumberEnd equals at least one of the given `values`
      */
    def columnNumberEnd(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the columnNumberEnd is greater than the given `value`
      */
    def columnNumberEndGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the columnNumberEnd is greater than or equal the given `value`
      */
    def columnNumberEndGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the columnNumberEnd is less than the given `value`
      */
    def columnNumberEndLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the columnNumberEnd is less than or equal the given `value`
      */
    def columnNumberEndLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumberEnd; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

    /** Traverse to hash property */
    def hash: Iterator[String] =
      traversal.flatMap(_.hash)

    /** Traverse to nodes where the hash matches the regular expression `value`
      */
    def hash(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        hashExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the hash matches at least one of the regular expressions in `values`
      */
    def hash(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.hash; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where hash matches `value` exactly.
      */
    def hashExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 23, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.hash; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where hash matches one of the elements in `values` exactly.
      */
    def hashExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) hashExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.hash; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to isExternal property */
    def isExternal: Iterator[Boolean] =
      traversal.map(_.isExternal)

    /** Traverse to nodes where the isExternal equals the given `value`
      */
    def isExternal(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isExternal == value }

    /** Traverse to lineNumberEnd property */
    def lineNumberEnd: Iterator[Int] =
      traversal.flatMap(_.lineNumberEnd)

    /** Traverse to nodes where the lineNumberEnd equals the given `value`
      */
    def lineNumberEnd(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the lineNumberEnd equals at least one of the given `values`
      */
    def lineNumberEnd(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the lineNumberEnd is greater than the given `value`
      */
    def lineNumberEndGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the lineNumberEnd is greater than or equal the given `value`
      */
    def lineNumberEndGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the lineNumberEnd is less than the given `value`
      */
    def lineNumberEndLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the lineNumberEnd is less than or equal the given `value`
      */
    def lineNumberEndLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumberEnd; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to signature property */
    def signature: Iterator[String] =
      traversal.map(_.signature)

    /** Traverse to nodes where the signature matches the regular expression `value`
      */
    def signature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        signatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.signature).matches }
      }

    /** Traverse to nodes where the signature matches at least one of the regular expressions in `values`
      */
    def signature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.signature).matches } }
    }

    /** Traverse to nodes where signature matches `value` exactly.
      */
    def signatureExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 47, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.signature == value }
    }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  extension [NodeType <: nodes.MethodParameterInBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to evaluationStrategy property */
    def evaluationStrategy: Iterator[String] =
      traversal.map(_.evaluationStrategy)

    /** Traverse to nodes where the evaluationStrategy matches the regular expression `value`
      */
    def evaluationStrategy(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationStrategyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationStrategy).matches }
      }

    /** Traverse to nodes where the evaluationStrategy matches at least one of the regular expressions in `values`
      */
    def evaluationStrategy(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationStrategy).matches } }
    }

    /** Traverse to nodes where evaluationStrategy matches `value` exactly.
      */
    def evaluationStrategyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 19, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.evaluationStrategy == value }
    }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

    /** Traverse to index property */
    def index: Iterator[Int] =
      traversal.map(_.index)

    /** Traverse to nodes where the index equals the given `value`
      */
    def index(value: Int): Iterator[NodeType] =
      traversal.filter { _.index == value }

    /** Traverse to nodes where the index equals at least one of the given `values`
      */
    def index(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.index) }
    }

    /** Traverse to nodes where the index is greater than the given `value`
      */
    def indexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index > value }

    /** Traverse to nodes where the index is greater than or equal the given `value`
      */
    def indexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index >= value }

    /** Traverse to nodes where the index is less than the given `value`
      */
    def indexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index < value }

    /** Traverse to nodes where the index is less than or equal the given `value`
      */
    def indexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index <= value }

    /** Traverse to isVariadic property */
    def isVariadic: Iterator[Boolean] =
      traversal.map(_.isVariadic)

    /** Traverse to nodes where the isVariadic equals the given `value`
      */
    def isVariadic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isVariadic == value }

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.MethodParameterOutBase](traversal: Iterator[NodeType]) {

    /** Traverse to evaluationStrategy property */
    def evaluationStrategy: Iterator[String] =
      traversal.map(_.evaluationStrategy)

    /** Traverse to nodes where the evaluationStrategy matches the regular expression `value`
      */
    def evaluationStrategy(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationStrategyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationStrategy).matches }
      }

    /** Traverse to nodes where the evaluationStrategy matches at least one of the regular expressions in `values`
      */
    def evaluationStrategy(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationStrategy).matches } }
    }

    /** Traverse to nodes where evaluationStrategy matches `value` exactly.
      */
    def evaluationStrategyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 19, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.evaluationStrategy == value }
    }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

    /** Traverse to index property */
    def index: Iterator[Int] =
      traversal.map(_.index)

    /** Traverse to nodes where the index equals the given `value`
      */
    def index(value: Int): Iterator[NodeType] =
      traversal.filter { _.index == value }

    /** Traverse to nodes where the index equals at least one of the given `values`
      */
    def index(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.index) }
    }

    /** Traverse to nodes where the index is greater than the given `value`
      */
    def indexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index > value }

    /** Traverse to nodes where the index is greater than or equal the given `value`
      */
    def indexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index >= value }

    /** Traverse to nodes where the index is less than the given `value`
      */
    def indexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.index < value }

    /** Traverse to nodes where the index is less than or equal the given `value`
      */
    def indexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.index <= value }

    /** Traverse to isVariadic property */
    def isVariadic: Iterator[Boolean] =
      traversal.map(_.isVariadic)

    /** Traverse to nodes where the isVariadic equals the given `value`
      */
    def isVariadic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isVariadic == value }

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.MethodRefBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to methodFullName property */
    def methodFullName: Iterator[String] =
      traversal.map(_.methodFullName)

    /** Traverse to nodes where the methodFullName matches the regular expression `value`
      */
    def methodFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.methodFullName).matches }
      }

    /** Traverse to nodes where the methodFullName matches at least one of the regular expressions in `values`
      */
    def methodFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.methodFullName).matches } }
    }

    /** Traverse to nodes where methodFullName matches `value` exactly.
      */
    def methodFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 36, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.methodFullName == value }
    }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.MethodReturnBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to evaluationStrategy property */
    def evaluationStrategy: Iterator[String] =
      traversal.map(_.evaluationStrategy)

    /** Traverse to nodes where the evaluationStrategy matches the regular expression `value`
      */
    def evaluationStrategy(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationStrategyExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationStrategy).matches }
      }

    /** Traverse to nodes where the evaluationStrategy matches at least one of the regular expressions in `values`
      */
    def evaluationStrategy(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationStrategy).matches } }
    }

    /** Traverse to nodes where evaluationStrategy matches `value` exactly.
      */
    def evaluationStrategyExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 19, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.evaluationStrategy == value }
    }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.ModifierBase](traversal: Iterator[NodeType]) {

    /** Traverse to modifierType property */
    def modifierType: Iterator[String] =
      traversal.map(_.modifierType)

    /** Traverse to nodes where the modifierType matches the regular expression `value`
      */
    def modifierType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        modifierTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.modifierType).matches }
      }

    /** Traverse to nodes where the modifierType matches at least one of the regular expressions in `values`
      */
    def modifierType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.modifierType).matches } }
    }

    /** Traverse to nodes where modifierType matches `value` exactly.
      */
    def modifierTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 38, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.modifierType == value }
    }

    /** Traverse to nodes where modifierType matches one of the elements in `values` exactly.
      */
    def modifierTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) modifierTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.modifierType) }
      }

  }
  extension [NodeType <: nodes.NamespaceBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.NamespaceBlockBase](traversal: Iterator[NodeType]) {

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.TagBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to value property */
    def value: Iterator[String] =
      traversal.map(_.value)

    /** Traverse to nodes where the value matches the regular expression `value`
      */
    def value(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        valueExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.value).matches }
      }

    /** Traverse to nodes where the value matches at least one of the regular expressions in `values`
      */
    def value(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.value).matches } }
    }

    /** Traverse to nodes where value matches `value` exactly.
      */
    def valueExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 51, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.value == value }
    }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  extension [NodeType <: nodes.TemplateDomBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.TypeBase](traversal: Iterator[NodeType]) {

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to typeDeclFullName property */
    def typeDeclFullName: Iterator[String] =
      traversal.map(_.typeDeclFullName)

    /** Traverse to nodes where the typeDeclFullName matches the regular expression `value`
      */
    def typeDeclFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeDeclFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeDeclFullName).matches }
      }

    /** Traverse to nodes where the typeDeclFullName matches at least one of the regular expressions in `values`
      */
    def typeDeclFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeDeclFullName).matches } }
    }

    /** Traverse to nodes where typeDeclFullName matches `value` exactly.
      */
    def typeDeclFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 49, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeDeclFullName == value }
    }

    /** Traverse to nodes where typeDeclFullName matches one of the elements in `values` exactly.
      */
    def typeDeclFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeDeclFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeDeclFullName) }
      }

  }
  extension [NodeType <: nodes.TypeDeclBase](traversal: Iterator[NodeType]) {

    /** Traverse to aliasTypeFullName property */
    def aliasTypeFullName: Iterator[String] =
      traversal.flatMap(_.aliasTypeFullName)

    /** Traverse to nodes where the aliasTypeFullName matches the regular expression `value`
      */
    def aliasTypeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        aliasTypeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.aliasTypeFullName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the aliasTypeFullName matches at least one of the regular expressions in `values`
      */
    def aliasTypeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.aliasTypeFullName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where aliasTypeFullName matches `value` exactly.
      */
    def aliasTypeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 0, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.aliasTypeFullName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where aliasTypeFullName matches one of the elements in `values` exactly.
      */
    def aliasTypeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) aliasTypeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.aliasTypeFullName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to astParentFullName property */
    def astParentFullName: Iterator[String] =
      traversal.map(_.astParentFullName)

    /** Traverse to nodes where the astParentFullName matches the regular expression `value`
      */
    def astParentFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentFullName).matches }
      }

    /** Traverse to nodes where the astParentFullName matches at least one of the regular expressions in `values`
      */
    def astParentFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentFullName).matches } }
    }

    /** Traverse to nodes where astParentFullName matches `value` exactly.
      */
    def astParentFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 3, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentFullName == value }
    }

    /** Traverse to nodes where astParentFullName matches one of the elements in `values` exactly.
      */
    def astParentFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentFullName) }
      }

    /** Traverse to astParentType property */
    def astParentType: Iterator[String] =
      traversal.map(_.astParentType)

    /** Traverse to nodes where the astParentType matches the regular expression `value`
      */
    def astParentType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        astParentTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.astParentType).matches }
      }

    /** Traverse to nodes where the astParentType matches at least one of the regular expressions in `values`
      */
    def astParentType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.astParentType).matches } }
    }

    /** Traverse to nodes where astParentType matches `value` exactly.
      */
    def astParentTypeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 4, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.astParentType == value }
    }

    /** Traverse to nodes where astParentType matches one of the elements in `values` exactly.
      */
    def astParentTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentType) }
      }

    /** Traverse to filename property */
    def filename: Iterator[String] =
      traversal.map(_.filename)

    /** Traverse to nodes where the filename matches the regular expression `value`
      */
    def filename(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        filenameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.filename).matches }
      }

    /** Traverse to nodes where the filename matches at least one of the regular expressions in `values`
      */
    def filename(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.filename).matches } }
    }

    /** Traverse to nodes where filename matches `value` exactly.
      */
    def filenameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 21, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.filename == value }
    }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

    /** Traverse to fullName property */
    def fullName: Iterator[String] =
      traversal.map(_.fullName)

    /** Traverse to nodes where the fullName matches the regular expression `value`
      */
    def fullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fullName).matches }
      }

    /** Traverse to nodes where the fullName matches at least one of the regular expressions in `values`
      */
    def fullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fullName).matches } }
    }

    /** Traverse to nodes where fullName matches `value` exactly.
      */
    def fullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 22, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.fullName == value }
    }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

    /** Traverse to inheritsFromTypeFullName property */
    def inheritsFromTypeFullName: Iterator[String] =
      traversal.flatMap(_.inheritsFromTypeFullName)

    /** Traverse to isExternal property */
    def isExternal: Iterator[Boolean] =
      traversal.map(_.isExternal)

    /** Traverse to nodes where the isExternal equals the given `value`
      */
    def isExternal(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isExternal == value }

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.TypeParameterBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
  extension [NodeType <: nodes.TypeRefBase](traversal: Iterator[NodeType]) {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  extension [NodeType <: nodes.UnknownBase](traversal: Iterator[NodeType]) {

    /** Traverse to containedRef property */
    def containedRef: Iterator[String] =
      traversal.map(_.containedRef)

    /** Traverse to nodes where the containedRef matches the regular expression `value`
      */
    def containedRef(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        containedRefExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.containedRef).matches }
      }

    /** Traverse to nodes where the containedRef matches at least one of the regular expressions in `values`
      */
    def containedRef(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.containedRef).matches } }
    }

    /** Traverse to nodes where containedRef matches `value` exactly.
      */
    def containedRefExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 13, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.containedRef == value }
    }

    /** Traverse to nodes where containedRef matches one of the elements in `values` exactly.
      */
    def containedRefExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) containedRefExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.containedRef) }
      }

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

    /** Traverse to parserTypeName property */
    def parserTypeName: Iterator[String] =
      traversal.map(_.parserTypeName)

    /** Traverse to nodes where the parserTypeName matches the regular expression `value`
      */
    def parserTypeName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        parserTypeNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.parserTypeName).matches }
      }

    /** Traverse to nodes where the parserTypeName matches at least one of the regular expressions in `values`
      */
    def parserTypeName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.parserTypeName).matches } }
    }

    /** Traverse to nodes where parserTypeName matches `value` exactly.
      */
    def parserTypeNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 44, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.parserTypeName == value }
    }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

    /** Traverse to possibleTypes property */
    def possibleTypes: Iterator[String] =
      traversal.flatMap(_.possibleTypes)

    /** Traverse to typeFullName property */
    def typeFullName: Iterator[String] =
      traversal.map(_.typeFullName)

    /** Traverse to nodes where the typeFullName matches the regular expression `value`
      */
    def typeFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        typeFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.typeFullName).matches }
      }

    /** Traverse to nodes where the typeFullName matches at least one of the regular expressions in `values`
      */
    def typeFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.typeFullName).matches } }
    }

    /** Traverse to nodes where typeFullName matches `value` exactly.
      */
    def typeFullNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 50, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.typeFullName == value }
    }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  extension [NodeType <: nodes.AstNodeBase](traversal: Iterator[NodeType]) {

    /** Traverse to code property */
    def code: Iterator[String] =
      traversal.map(_.code)

    /** Traverse to nodes where the code matches the regular expression `value`
      */
    def code(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        codeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.code).matches }
      }

    /** Traverse to nodes where the code matches at least one of the regular expressions in `values`
      */
    def code(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.code).matches } }
    }

    /** Traverse to nodes where code matches `value` exactly.
      */
    def codeExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 10, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.code == value }
    }

    /** Traverse to nodes where code matches one of the elements in `values` exactly.
      */
    def codeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) codeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.code) }
      }

    /** Traverse to columnNumber property */
    def columnNumber: Iterator[Int] =
      traversal.flatMap(_.columnNumber)

    /** Traverse to nodes where the columnNumber equals the given `value`
      */
    def columnNumber(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the columnNumber equals at least one of the given `values`
      */
    def columnNumber(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the columnNumber is greater than the given `value`
      */
    def columnNumberGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the columnNumber is greater than or equal the given `value`
      */
    def columnNumberGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the columnNumber is less than the given `value`
      */
    def columnNumberLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the columnNumber is less than or equal the given `value`
      */
    def columnNumberLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.columnNumber; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to lineNumber property */
    def lineNumber: Iterator[Int] =
      traversal.flatMap(_.lineNumber)

    /** Traverse to nodes where the lineNumber equals the given `value`
      */
    def lineNumber(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the lineNumber equals at least one of the given `values`
      */
    def lineNumber(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the lineNumber is greater than the given `value`
      */
    def lineNumberGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the lineNumber is greater than or equal the given `value`
      */
    def lineNumberGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the lineNumber is less than the given `value`
      */
    def lineNumberLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the lineNumber is less than or equal the given `value`
      */
    def lineNumberLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.lineNumber; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to order property */
    def order: Iterator[Int] =
      traversal.map(_.order)

    /** Traverse to nodes where the order equals the given `value`
      */
    def order(value: Int): Iterator[NodeType] =
      traversal.filter { _.order == value }

    /** Traverse to nodes where the order equals at least one of the given `values`
      */
    def order(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.order) }
    }

    /** Traverse to nodes where the order is greater than the given `value`
      */
    def orderGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.order > value }

    /** Traverse to nodes where the order is greater than or equal the given `value`
      */
    def orderGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.order >= value }

    /** Traverse to nodes where the order is less than the given `value`
      */
    def orderLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.order < value }

    /** Traverse to nodes where the order is less than or equal the given `value`
      */
    def orderLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.order <= value }

  }
  extension [NodeType <: nodes.CallReprBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

    /** Traverse to signature property */
    def signature: Iterator[String] =
      traversal.map(_.signature)

    /** Traverse to nodes where the signature matches the regular expression `value`
      */
    def signature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        signatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.signature).matches }
      }

    /** Traverse to nodes where the signature matches at least one of the regular expressions in `values`
      */
    def signature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.signature).matches } }
    }

    /** Traverse to nodes where signature matches `value` exactly.
      */
    def signatureExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 47, value).asInstanceOf[Iterator[NodeType]]
      case _ => traversal.filter { _.signature == value }
    }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  extension [NodeType <: nodes.ExpressionBase](traversal: Iterator[NodeType]) {

    /** Traverse to argumentIndex property */
    def argumentIndex: Iterator[Int] =
      traversal.map(_.argumentIndex)

    /** Traverse to nodes where the argumentIndex equals the given `value`
      */
    def argumentIndex(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex == value }

    /** Traverse to nodes where the argumentIndex equals at least one of the given `values`
      */
    def argumentIndex(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.argumentIndex) }
    }

    /** Traverse to nodes where the argumentIndex is greater than the given `value`
      */
    def argumentIndexGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex > value }

    /** Traverse to nodes where the argumentIndex is greater than or equal the given `value`
      */
    def argumentIndexGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex >= value }

    /** Traverse to nodes where the argumentIndex is less than the given `value`
      */
    def argumentIndexLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex < value }

    /** Traverse to nodes where the argumentIndex is less than or equal the given `value`
      */
    def argumentIndexLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.argumentIndex <= value }

    /** Traverse to argumentName property */
    def argumentName: Iterator[String] =
      traversal.flatMap(_.argumentName)

    /** Traverse to nodes where the argumentName matches the regular expression `value`
      */
    def argumentName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        argumentNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.argumentName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the argumentName matches at least one of the regular expressions in `values`
      */
    def argumentName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.argumentName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where argumentName matches `value` exactly.
      */
    def argumentNameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 2, value).asInstanceOf[Iterator[NodeType]]
      case _ =>
        traversal.filter { node =>
          val tmp = node.argumentName; tmp.isDefined && tmp.get == value
        }
    }

    /** Traverse to nodes where argumentName matches one of the elements in `values` exactly.
      */
    def argumentNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) argumentNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.argumentName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
}

trait AbstractBaseConversions1 {
  extension [NodeType <: nodes.DeclarationBase](traversal: Iterator[NodeType]) {

    /** Traverse to name property */
    def name: Iterator[String] =
      traversal.map(_.name)

    /** Traverse to nodes where the name matches the regular expression `value`
      */
    def name(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        nameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.name).matches }
      }

    /** Traverse to nodes where the name matches at least one of the regular expressions in `values`
      */
    def name(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.name).matches } }
    }

    /** Traverse to nodes where name matches `value` exactly.
      */
    def nameExact(value: String): Iterator[NodeType] = traversal match {
      case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
        val someNode = init.next
        odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind, 39, value).asInstanceOf[Iterator[NodeType]]
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

  }
}
