package io.shiftleft.codepropertygraph.generated.v2.traversals
import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.nodes

object Lang extends ConcreteStoredConversions {}

object Accessors {
  import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang._
  import odb2.misc.Misc
  final class Traversal_Property_ALIAS_TYPE_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def aliasTypeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.aliasTypeFullName; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_ANNOTATION_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to annotationFullName property */
    def annotationFullName: Iterator[String] =
      traversal.map(_.annotationFullName)

    /** Traverse to nodes where the annotationFullName matches the regular expression `value`
      */
    def annotationFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        annotationFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.annotationFullName).matches }
      }

    /** Traverse to nodes where the annotationFullName matches at least one of the regular expressions in `values`
      */
    def annotationFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.annotationFullName).matches } }
    }

    /** Traverse to nodes where annotationFullName matches `value` exactly.
      */
    def annotationFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.annotationFullName == value }

    /** Traverse to nodes where annotationFullName matches one of the elements in `values` exactly.
      */
    def annotationFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) annotationFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.annotationFullName) }
      }

  }
  final class Traversal_Property_ANNOTATION_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to annotationName property */
    def annotationName: Iterator[String] =
      traversal.map(_.annotationName)

    /** Traverse to nodes where the annotationName matches the regular expression `value`
      */
    def annotationName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        annotationNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.annotationName).matches }
      }

    /** Traverse to nodes where the annotationName matches at least one of the regular expressions in `values`
      */
    def annotationName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.annotationName).matches } }
    }

    /** Traverse to nodes where annotationName matches `value` exactly.
      */
    def annotationNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.annotationName == value }

    /** Traverse to nodes where annotationName matches one of the elements in `values` exactly.
      */
    def annotationNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) annotationNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.annotationName) }
      }

  }
  final class Traversal_Property_ARGUMENT_INDEX[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_ARGUMENT_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def argumentNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.argumentName; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_AST_PARENT_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def astParentFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentFullName == value }

    /** Traverse to nodes where astParentFullName matches one of the elements in `values` exactly.
      */
    def astParentFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentFullName) }
      }

  }
  final class Traversal_Property_AST_PARENT_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def astParentTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentType == value }

    /** Traverse to nodes where astParentType matches one of the elements in `values` exactly.
      */
    def astParentTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentType) }
      }

  }
  final class Traversal_Property_BINARY_SIGNATURE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasBinarySignatureT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to binarySignature property */
    def binarySignature: Iterator[String] =
      traversal.flatMap(_.binarySignature)

    /** Traverse to nodes where the binarySignature matches the regular expression `value`
      */
    def binarySignature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        binarySignatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the binarySignature matches at least one of the regular expressions in `values`
      */
    def binarySignature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.binarySignature; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where binarySignature matches `value` exactly.
      */
    def binarySignatureExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.binarySignature; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where binarySignature matches one of the elements in `values` exactly.
      */
    def binarySignatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) binarySignatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  final class Traversal_Property_CANONICAL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def canonicalNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.canonicalName == value }

    /** Traverse to nodes where canonicalName matches one of the elements in `values` exactly.
      */
    def canonicalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) canonicalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.canonicalName) }
      }

  }
  final class Traversal_Property_CATEGORIES[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCategoriesT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to categories property */
    def categories: Iterator[String] =
      traversal.flatMap(_.categories)

  }
  final class Traversal_Property_CATEGORY[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCategoryT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to category property */
    def category: Iterator[String] =
      traversal.map(_.category)

    /** Traverse to nodes where the category matches the regular expression `value`
      */
    def category(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        categoryExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.category).matches }
      }

    /** Traverse to nodes where the category matches at least one of the regular expressions in `values`
      */
    def category(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.category).matches } }
    }

    /** Traverse to nodes where category matches `value` exactly.
      */
    def categoryExact(value: String): Iterator[NodeType] =
      traversal.filter { _.category == value }

    /** Traverse to nodes where category matches one of the elements in `values` exactly.
      */
    def categoryExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) categoryExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.category) }
      }

  }
  final class Traversal_Property_CLASS_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def classNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.className == value }

    /** Traverse to nodes where className matches one of the elements in `values` exactly.
      */
    def classNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.className) }
      }

  }
  final class Traversal_Property_CLASS_SHORT_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def classShortNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.classShortName == value }

    /** Traverse to nodes where classShortName matches one of the elements in `values` exactly.
      */
    def classShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) classShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.classShortName) }
      }

  }
  final class Traversal_Property_CLOSURE_BINDING_ID[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def closureBindingIdExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_CLOSURE_ORIGINAL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def closureOriginalNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.closureOriginalName; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_CODE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]](val traversal: Iterator[NodeType])
      extends AnyVal {

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
    def codeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.code == value }

    /** Traverse to nodes where code matches one of the elements in `values` exactly.
      */
    def codeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) codeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.code) }
      }

  }
  final class Traversal_Property_COLUMN_NUMBER[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_COLUMN_NUMBER_END[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_CONTAINED_REF[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def containedRefExact(value: String): Iterator[NodeType] =
      traversal.filter { _.containedRef == value }

    /** Traverse to nodes where containedRef matches one of the elements in `values` exactly.
      */
    def containedRefExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) containedRefExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.containedRef) }
      }

  }
  final class Traversal_Property_CONTENT[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def contentExact(value: String): Iterator[NodeType] =
      traversal.filter { _.content == value }

    /** Traverse to nodes where content matches one of the elements in `values` exactly.
      */
    def contentExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) contentExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.content) }
      }

  }
  final class Traversal_Property_CONTROL_STRUCTURE_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def controlStructureTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.controlStructureType == value }

    /** Traverse to nodes where controlStructureType matches one of the elements in `values` exactly.
      */
    def controlStructureTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) controlStructureTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.controlStructureType) }
      }

  }
  final class Traversal_Property_DEPENDENCY_GROUP_ID[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def dependencyGroupIdExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.dependencyGroupId; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_DEPENDENCY_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to dependencyType property */
    def dependencyType: Iterator[String] =
      traversal.map(_.dependencyType)

    /** Traverse to nodes where the dependencyType matches the regular expression `value`
      */
    def dependencyType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dependencyTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dependencyType).matches }
      }

    /** Traverse to nodes where the dependencyType matches at least one of the regular expressions in `values`
      */
    def dependencyType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dependencyType).matches } }
    }

    /** Traverse to nodes where dependencyType matches `value` exactly.
      */
    def dependencyTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dependencyType == value }

    /** Traverse to nodes where dependencyType matches one of the elements in `values` exactly.
      */
    def dependencyTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dependencyTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dependencyType) }
      }

  }
  final class Traversal_Property_DEPTH_FIRST_ORDER[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDepthFirstOrderT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to depthFirstOrder property */
    def depthFirstOrder: Iterator[Int] =
      traversal.map(_.depthFirstOrder)

    /** Traverse to nodes where the depthFirstOrder equals the given `value`
      */
    def depthFirstOrder(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder == value }

    /** Traverse to nodes where the depthFirstOrder equals at least one of the given `values`
      */
    def depthFirstOrder(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.depthFirstOrder) }
    }

    /** Traverse to nodes where the depthFirstOrder is greater than the given `value`
      */
    def depthFirstOrderGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder > value }

    /** Traverse to nodes where the depthFirstOrder is greater than or equal the given `value`
      */
    def depthFirstOrderGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder >= value }

    /** Traverse to nodes where the depthFirstOrder is less than the given `value`
      */
    def depthFirstOrderLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder < value }

    /** Traverse to nodes where the depthFirstOrder is less than or equal the given `value`
      */
    def depthFirstOrderLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder <= value }

  }
  final class Traversal_Property_DESCRIPTION[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDescriptionT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to description property */
    def description: Iterator[String] =
      traversal.map(_.description)

    /** Traverse to nodes where the description matches the regular expression `value`
      */
    def description(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        descriptionExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.description).matches }
      }

    /** Traverse to nodes where the description matches at least one of the regular expressions in `values`
      */
    def description(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.description).matches } }
    }

    /** Traverse to nodes where description matches `value` exactly.
      */
    def descriptionExact(value: String): Iterator[NodeType] =
      traversal.filter { _.description == value }

    /** Traverse to nodes where description matches one of the elements in `values` exactly.
      */
    def descriptionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) descriptionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.description) }
      }

  }
  final class Traversal_Property_DISPATCH_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to dispatchName property */
    def dispatchName: Iterator[String] =
      traversal.map(_.dispatchName)

    /** Traverse to nodes where the dispatchName matches the regular expression `value`
      */
    def dispatchName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dispatchNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dispatchName).matches }
      }

    /** Traverse to nodes where the dispatchName matches at least one of the regular expressions in `values`
      */
    def dispatchName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dispatchName).matches } }
    }

    /** Traverse to nodes where dispatchName matches `value` exactly.
      */
    def dispatchNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dispatchName == value }

    /** Traverse to nodes where dispatchName matches one of the elements in `values` exactly.
      */
    def dispatchNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dispatchNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dispatchName) }
      }

  }
  final class Traversal_Property_DISPATCH_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def dispatchTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dispatchType == value }

    /** Traverse to nodes where dispatchType matches one of the elements in `values` exactly.
      */
    def dispatchTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dispatchTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dispatchType) }
      }

  }
  final class Traversal_Property_DYNAMIC_TYPE_HINT_FULL_NAME[
    NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]
  ](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

  }
  final class Traversal_Property_EVALUATION_STRATEGY[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def evaluationStrategyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationStrategy == value }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

  }
  final class Traversal_Property_EVALUATION_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to evaluationType property */
    def evaluationType: Iterator[String] =
      traversal.map(_.evaluationType)

    /** Traverse to nodes where the evaluationType matches the regular expression `value`
      */
    def evaluationType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationType).matches }
      }

    /** Traverse to nodes where the evaluationType matches at least one of the regular expressions in `values`
      */
    def evaluationType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationType).matches } }
    }

    /** Traverse to nodes where evaluationType matches `value` exactly.
      */
    def evaluationTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationType == value }

    /** Traverse to nodes where evaluationType matches one of the elements in `values` exactly.
      */
    def evaluationTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationType) }
      }

  }
  final class Traversal_Property_EVAL_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvalTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to evalType property */
    def evalType: Iterator[String] =
      traversal.map(_.evalType)

    /** Traverse to nodes where the evalType matches the regular expression `value`
      */
    def evalType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evalTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evalType).matches }
      }

    /** Traverse to nodes where the evalType matches at least one of the regular expressions in `values`
      */
    def evalType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evalType).matches } }
    }

    /** Traverse to nodes where evalType matches `value` exactly.
      */
    def evalTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evalType == value }

    /** Traverse to nodes where evalType matches one of the elements in `values` exactly.
      */
    def evalTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evalTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evalType) }
      }

  }
  final class Traversal_Property_EXPLICIT_AS[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to explicitAs property */
    def explicitAs: Iterator[Boolean] =
      traversal.flatMap(_.explicitAs)

    /** Traverse to nodes where the explicitAs equals the given `value`
      */
    def explicitAs(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.explicitAs.isDefined && node.explicitAs.get == value }

  }
  final class Traversal_Property_FILENAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

  }
  final class Traversal_Property_FINGERPRINT[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFingerprintT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to fingerprint property */
    def fingerprint: Iterator[String] =
      traversal.map(_.fingerprint)

    /** Traverse to nodes where the fingerprint matches the regular expression `value`
      */
    def fingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fingerprint).matches }
      }

    /** Traverse to nodes where the fingerprint matches at least one of the regular expressions in `values`
      */
    def fingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fingerprint).matches } }
    }

    /** Traverse to nodes where fingerprint matches `value` exactly.
      */
    def fingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fingerprint == value }

    /** Traverse to nodes where fingerprint matches one of the elements in `values` exactly.
      */
    def fingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fingerprint) }
      }

  }
  final class Traversal_Property_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

  }
  final class Traversal_Property_HASH[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]](val traversal: Iterator[NodeType])
      extends AnyVal {

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
    def hashExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.hash; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_HAS_MAPPING[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasHasMappingT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to hasMapping property */
    def hasMapping: Iterator[Boolean] =
      traversal.flatMap(_.hasMapping)

    /** Traverse to nodes where the hasMapping equals the given `value`
      */
    def hasMapping(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.hasMapping.isDefined && node.hasMapping.get == value }

  }
  final class Traversal_Property_IMPORTED_AS[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def importedAsExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.importedAs; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_IMPORTED_ENTITY[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def importedEntityExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.importedEntity; tmp.isDefined && tmp.get == value
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
  final class Traversal_Property_INDEX[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_INHERITS_FROM_TYPE_FULL_NAME[
    NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]
  ](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to inheritsFromTypeFullName property */
    def inheritsFromTypeFullName: Iterator[String] =
      traversal.flatMap(_.inheritsFromTypeFullName)

  }
  final class Traversal_Property_INTERNAL_FLAGS[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasInternalFlagsT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to internalFlags property */
    def internalFlags: Iterator[Int] =
      traversal.map(_.internalFlags)

    /** Traverse to nodes where the internalFlags equals the given `value`
      */
    def internalFlags(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags == value }

    /** Traverse to nodes where the internalFlags equals at least one of the given `values`
      */
    def internalFlags(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.internalFlags) }
    }

    /** Traverse to nodes where the internalFlags is greater than the given `value`
      */
    def internalFlagsGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags > value }

    /** Traverse to nodes where the internalFlags is greater than or equal the given `value`
      */
    def internalFlagsGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags >= value }

    /** Traverse to nodes where the internalFlags is less than the given `value`
      */
    def internalFlagsLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags < value }

    /** Traverse to nodes where the internalFlags is less than or equal the given `value`
      */
    def internalFlagsLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags <= value }

  }
  final class Traversal_Property_IS_EXPLICIT[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to isExplicit property */
    def isExplicit: Iterator[Boolean] =
      traversal.flatMap(_.isExplicit)

    /** Traverse to nodes where the isExplicit equals the given `value`
      */
    def isExplicit(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isExplicit.isDefined && node.isExplicit.get == value }

  }
  final class Traversal_Property_IS_EXTERNAL[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to isExternal property */
    def isExternal: Iterator[Boolean] =
      traversal.map(_.isExternal)

    /** Traverse to nodes where the isExternal equals the given `value`
      */
    def isExternal(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isExternal == value }

  }
  final class Traversal_Property_IS_METHOD_NEVER_OVERRIDDEN[
    NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsMethodNeverOverriddenT]
  ](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to isMethodNeverOverridden property */
    def isMethodNeverOverridden: Iterator[Boolean] =
      traversal.flatMap(_.isMethodNeverOverridden)

    /** Traverse to nodes where the isMethodNeverOverridden equals the given `value`
      */
    def isMethodNeverOverridden(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isMethodNeverOverridden.isDefined && node.isMethodNeverOverridden.get == value }

  }
  final class Traversal_Property_IS_STATIC[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsStaticT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to isStatic property */
    def isStatic: Iterator[Boolean] =
      traversal.map(_.isStatic)

    /** Traverse to nodes where the isStatic equals the given `value`
      */
    def isStatic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isStatic == value }

  }
  final class Traversal_Property_IS_VARIADIC[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to isVariadic property */
    def isVariadic: Iterator[Boolean] =
      traversal.map(_.isVariadic)

    /** Traverse to nodes where the isVariadic equals the given `value`
      */
    def isVariadic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isVariadic == value }

  }
  final class Traversal_Property_IS_WILDCARD[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to isWildcard property */
    def isWildcard: Iterator[Boolean] =
      traversal.flatMap(_.isWildcard)

    /** Traverse to nodes where the isWildcard equals the given `value`
      */
    def isWildcard(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isWildcard.isDefined && node.isWildcard.get == value }

  }
  final class Traversal_Property_KEY[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]](val traversal: Iterator[NodeType])
      extends AnyVal {

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
    def keyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.key == value }

    /** Traverse to nodes where key matches one of the elements in `values` exactly.
      */
    def keyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) keyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.key) }
      }

  }
  final class Traversal_Property_LANGUAGE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def languageExact(value: String): Iterator[NodeType] =
      traversal.filter { _.language == value }

    /** Traverse to nodes where language matches one of the elements in `values` exactly.
      */
    def languageExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) languageExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.language) }
      }

  }
  final class Traversal_Property_LINE_NUMBER[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_LINE_NUMBER_END[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_LITERALS_TO_SINK[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLiteralsToSinkT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to literalsToSink property */
    def literalsToSink: Iterator[String] =
      traversal.flatMap(_.literalsToSink)

  }
  final class Traversal_Property_METHOD_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

  }
  final class Traversal_Property_METHOD_INST_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodInstFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to methodInstFullName property */
    def methodInstFullName: Iterator[String] =
      traversal.flatMap(_.methodInstFullName)

    /** Traverse to nodes where the methodInstFullName matches the regular expression `value`
      */
    def methodInstFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodInstFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the methodInstFullName matches at least one of the regular expressions in `values`
      */
    def methodInstFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.methodInstFullName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where methodInstFullName matches `value` exactly.
      */
    def methodInstFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.methodInstFullName; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where methodInstFullName matches one of the elements in `values` exactly.
      */
    def methodInstFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodInstFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  final class Traversal_Property_METHOD_SHORT_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def methodShortNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodShortName == value }

    /** Traverse to nodes where methodShortName matches one of the elements in `values` exactly.
      */
    def methodShortNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodShortNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodShortName) }
      }

  }
  final class Traversal_Property_ML_ASSISTED[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMlAssistedT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to mlAssisted property */
    def mlAssisted: Iterator[Boolean] =
      traversal.map(_.mlAssisted)

    /** Traverse to nodes where the mlAssisted equals the given `value`
      */
    def mlAssisted(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.mlAssisted == value }

  }
  final class Traversal_Property_MODIFIER_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def modifierTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.modifierType == value }

    /** Traverse to nodes where modifierType matches one of the elements in `values` exactly.
      */
    def modifierTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) modifierTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.modifierType) }
      }

  }
  final class Traversal_Property_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]](val traversal: Iterator[NodeType])
      extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_Property_NODE_LABEL[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def nodeLabelExact(value: String): Iterator[NodeType] =
      traversal.filter { _.nodeLabel == value }

    /** Traverse to nodes where nodeLabel matches one of the elements in `values` exactly.
      */
    def nodeLabelExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nodeLabelExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.nodeLabel) }
      }

  }
  final class Traversal_Property_ORDER[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
  final class Traversal_Property_OVERLAYS[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to overlays property */
    def overlays: Iterator[String] =
      traversal.flatMap(_.overlays)

  }
  final class Traversal_Property_PACKAGE_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def packageNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.packageName == value }

    /** Traverse to nodes where packageName matches one of the elements in `values` exactly.
      */
    def packageNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) packageNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.packageName) }
      }

  }
  final class Traversal_Property_PARAMETER_INDEX[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasParameterIndexT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to parameterIndex property */
    def parameterIndex: Iterator[Int] =
      traversal.flatMap(_.parameterIndex)

    /** Traverse to nodes where the parameterIndex equals the given `value`
      */
    def parameterIndex(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the parameterIndex equals at least one of the given `values`
      */
    def parameterIndex(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the parameterIndex is greater than the given `value`
      */
    def parameterIndexGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the parameterIndex is greater than or equal the given `value`
      */
    def parameterIndexGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the parameterIndex is less than the given `value`
      */
    def parameterIndexLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the parameterIndex is less than or equal the given `value`
      */
    def parameterIndexLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get <= value
      }

  }
  final class Traversal_Property_PARSER_TYPE_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def parserTypeNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.parserTypeName == value }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  final class Traversal_Property_PATH[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPathT]](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to path property */
    def path: Iterator[String] =
      traversal.map(_.path)

    /** Traverse to nodes where the path matches the regular expression `value`
      */
    def path(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        pathExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.path).matches }
      }

    /** Traverse to nodes where the path matches at least one of the regular expressions in `values`
      */
    def path(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.path).matches } }
    }

    /** Traverse to nodes where path matches `value` exactly.
      */
    def pathExact(value: String): Iterator[NodeType] =
      traversal.filter { _.path == value }

    /** Traverse to nodes where path matches one of the elements in `values` exactly.
      */
    def pathExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) pathExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.path) }
      }

  }
  final class Traversal_Property_PATTERN[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPatternT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to pattern property */
    def pattern: Iterator[String] =
      traversal.map(_.pattern)

    /** Traverse to nodes where the pattern matches the regular expression `value`
      */
    def pattern(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        patternExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.pattern).matches }
      }

    /** Traverse to nodes where the pattern matches at least one of the regular expressions in `values`
      */
    def pattern(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.pattern).matches } }
    }

    /** Traverse to nodes where pattern matches `value` exactly.
      */
    def patternExact(value: String): Iterator[NodeType] =
      traversal.filter { _.pattern == value }

    /** Traverse to nodes where pattern matches one of the elements in `values` exactly.
      */
    def patternExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) patternExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.pattern) }
      }

  }
  final class Traversal_Property_POLICY_DIRECTORIES[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPolicyDirectoriesT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to policyDirectories property */
    def policyDirectories: Iterator[String] =
      traversal.flatMap(_.policyDirectories)

  }
  final class Traversal_Property_RESOLVED[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasResolvedT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to resolved property */
    def resolved: Iterator[Boolean] =
      traversal.flatMap(_.resolved)

    /** Traverse to nodes where the resolved equals the given `value`
      */
    def resolved(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.resolved.isDefined && node.resolved.get == value }

  }
  final class Traversal_Property_ROOT[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]](val traversal: Iterator[NodeType])
      extends AnyVal {

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
    def rootExact(value: String): Iterator[NodeType] =
      traversal.filter { _.root == value }

    /** Traverse to nodes where root matches one of the elements in `values` exactly.
      */
    def rootExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) rootExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.root) }
      }

  }
  final class Traversal_Property_SCORE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasScoreT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to score property */
    def score: Iterator[String] =
      traversal.map(_.score)

    /** Traverse to nodes where the score matches the regular expression `value`
      */
    def score(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        scoreExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.score).matches }
      }

    /** Traverse to nodes where the score matches at least one of the regular expressions in `values`
      */
    def score(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.score).matches } }
    }

    /** Traverse to nodes where score matches `value` exactly.
      */
    def scoreExact(value: String): Iterator[NodeType] =
      traversal.filter { _.score == value }

    /** Traverse to nodes where score matches one of the elements in `values` exactly.
      */
    def scoreExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) scoreExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.score) }
      }

  }
  final class Traversal_Property_SIGNATURE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def signatureExact(value: String): Iterator[NodeType] =
      traversal.filter { _.signature == value }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  final class Traversal_Property_SINK_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSinkTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to sinkType property */
    def sinkType: Iterator[String] =
      traversal.map(_.sinkType)

    /** Traverse to nodes where the sinkType matches the regular expression `value`
      */
    def sinkType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        sinkTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.sinkType).matches }
      }

    /** Traverse to nodes where the sinkType matches at least one of the regular expressions in `values`
      */
    def sinkType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.sinkType).matches } }
    }

    /** Traverse to nodes where sinkType matches `value` exactly.
      */
    def sinkTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.sinkType == value }

    /** Traverse to nodes where sinkType matches one of the elements in `values` exactly.
      */
    def sinkTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) sinkTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.sinkType) }
      }

  }
  final class Traversal_Property_SOURCE_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSourceTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to sourceType property */
    def sourceType: Iterator[String] =
      traversal.map(_.sourceType)

    /** Traverse to nodes where the sourceType matches the regular expression `value`
      */
    def sourceType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        sourceTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.sourceType).matches }
      }

    /** Traverse to nodes where the sourceType matches at least one of the regular expressions in `values`
      */
    def sourceType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.sourceType).matches } }
    }

    /** Traverse to nodes where sourceType matches `value` exactly.
      */
    def sourceTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.sourceType == value }

    /** Traverse to nodes where sourceType matches one of the elements in `values` exactly.
      */
    def sourceTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) sourceTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.sourceType) }
      }

  }
  final class Traversal_Property_SPID[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSpidT]](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to spid property */
    def spid: Iterator[String] =
      traversal.flatMap(_.spid)

    /** Traverse to nodes where the spid matches the regular expression `value`
      */
    def spid(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        spidExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.spid; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the spid matches at least one of the regular expressions in `values`
      */
    def spid(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.spid; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where spid matches `value` exactly.
      */
    def spidExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.spid; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where spid matches one of the elements in `values` exactly.
      */
    def spidExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) spidExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.spid; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

  }
  final class Traversal_Property_STRUCTURED_FINGERPRINT[
    NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasStructuredFingerprintT]
  ](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to structuredFingerprint property */
    def structuredFingerprint: Iterator[String] =
      traversal.map(_.structuredFingerprint)

    /** Traverse to nodes where the structuredFingerprint matches the regular expression `value`
      */
    def structuredFingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        structuredFingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.structuredFingerprint).matches }
      }

    /** Traverse to nodes where the structuredFingerprint matches at least one of the regular expressions in `values`
      */
    def structuredFingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.structuredFingerprint).matches } }
    }

    /** Traverse to nodes where structuredFingerprint matches `value` exactly.
      */
    def structuredFingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.structuredFingerprint == value }

    /** Traverse to nodes where structuredFingerprint matches one of the elements in `values` exactly.
      */
    def structuredFingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) structuredFingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.structuredFingerprint) }
      }

  }
  final class Traversal_Property_SYMBOL[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def symbolExact(value: String): Iterator[NodeType] =
      traversal.filter { _.symbol == value }

    /** Traverse to nodes where symbol matches one of the elements in `values` exactly.
      */
    def symbolExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) symbolExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.symbol) }
      }

  }
  final class Traversal_Property_TYPE_DECL_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def typeDeclFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeDeclFullName == value }

    /** Traverse to nodes where typeDeclFullName matches one of the elements in `values` exactly.
      */
    def typeDeclFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeDeclFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeDeclFullName) }
      }

  }
  final class Traversal_Property_TYPE_FULL_NAME[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_Property_URL[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasUrlT]](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to url property */
    def url: Iterator[String] =
      traversal.map(_.url)

    /** Traverse to nodes where the url matches the regular expression `value`
      */
    def url(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        urlExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.url).matches }
      }

    /** Traverse to nodes where the url matches at least one of the regular expressions in `values`
      */
    def url(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.url).matches } }
    }

    /** Traverse to nodes where url matches `value` exactly.
      */
    def urlExact(value: String): Iterator[NodeType] =
      traversal.filter { _.url == value }

    /** Traverse to nodes where url matches one of the elements in `values` exactly.
      */
    def urlExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) urlExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.url) }
      }

  }
  final class Traversal_Property_VALUE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_Property_VARARG_PARAMETER[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVarargParameterT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to varargParameter property */
    def varargParameter: Iterator[Int] =
      traversal.map(_.varargParameter)

    /** Traverse to nodes where the varargParameter equals the given `value`
      */
    def varargParameter(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter == value }

    /** Traverse to nodes where the varargParameter equals at least one of the given `values`
      */
    def varargParameter(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.varargParameter) }
    }

    /** Traverse to nodes where the varargParameter is greater than the given `value`
      */
    def varargParameterGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter > value }

    /** Traverse to nodes where the varargParameter is greater than or equal the given `value`
      */
    def varargParameterGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter >= value }

    /** Traverse to nodes where the varargParameter is less than the given `value`
      */
    def varargParameterLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter < value }

    /** Traverse to nodes where the varargParameter is less than or equal the given `value`
      */
    def varargParameterLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter <= value }

  }
  final class Traversal_Property_VAR_TYPE[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVarTypeT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

    /** Traverse to varType property */
    def varType: Iterator[String] =
      traversal.map(_.varType)

    /** Traverse to nodes where the varType matches the regular expression `value`
      */
    def varType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        varTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.varType).matches }
      }

    /** Traverse to nodes where the varType matches at least one of the regular expressions in `values`
      */
    def varType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.varType).matches } }
    }

    /** Traverse to nodes where varType matches `value` exactly.
      */
    def varTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.varType == value }

    /** Traverse to nodes where varType matches one of the elements in `values` exactly.
      */
    def varTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) varTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.varType) }
      }

  }
  final class Traversal_Property_VERSION[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]](
    val traversal: Iterator[NodeType]
  ) extends AnyVal {

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
    def versionExact(value: String): Iterator[NodeType] =
      traversal.filter { _.version == value }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
  //
  final class Traversal_AnnotationBase[NodeType <: nodes.AnnotationBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_AnnotationLiteralBase[NodeType <: nodes.AnnotationLiteralBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_AnnotationParameterBase[NodeType <: nodes.AnnotationParameterBase](val traversal: Iterator[NodeType])
      extends AnyVal {}
  final class Traversal_AnnotationParameterAssignBase[NodeType <: nodes.AnnotationParameterAssignBase](val traversal: Iterator[NodeType])
      extends AnyVal {}
  final class Traversal_ArrayInitializerBase[NodeType <: nodes.ArrayInitializerBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_BindingBase[NodeType <: nodes.BindingBase](val traversal: Iterator[NodeType])                   extends AnyVal {

    /** Traverse to isMethodNeverOverridden property */
    def isMethodNeverOverridden: Iterator[Boolean] =
      traversal.flatMap(_.isMethodNeverOverridden)

    /** Traverse to nodes where the isMethodNeverOverridden equals the given `value`
      */
    def isMethodNeverOverridden(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.isMethodNeverOverridden.isDefined && node.isMethodNeverOverridden.get == value }

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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def signatureExact(value: String): Iterator[NodeType] =
      traversal.filter { _.signature == value }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  final class Traversal_BlockBase[NodeType <: nodes.BlockBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_CallBase[NodeType <: nodes.CallBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dispatchName property */
    def dispatchName: Iterator[String] =
      traversal.map(_.dispatchName)

    /** Traverse to nodes where the dispatchName matches the regular expression `value`
      */
    def dispatchName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dispatchNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dispatchName).matches }
      }

    /** Traverse to nodes where the dispatchName matches at least one of the regular expressions in `values`
      */
    def dispatchName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dispatchName).matches } }
    }

    /** Traverse to nodes where dispatchName matches `value` exactly.
      */
    def dispatchNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dispatchName == value }

    /** Traverse to nodes where dispatchName matches one of the elements in `values` exactly.
      */
    def dispatchNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dispatchNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dispatchName) }
      }

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
    def dispatchTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dispatchType == value }

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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to methodInstFullName property */
    def methodInstFullName: Iterator[String] =
      traversal.flatMap(_.methodInstFullName)

    /** Traverse to nodes where the methodInstFullName matches the regular expression `value`
      */
    def methodInstFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodInstFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the methodInstFullName matches at least one of the regular expressions in `values`
      */
    def methodInstFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.methodInstFullName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where methodInstFullName matches `value` exactly.
      */
    def methodInstFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.methodInstFullName; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where methodInstFullName matches one of the elements in `values` exactly.
      */
    def methodInstFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodInstFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to resolved property */
    def resolved: Iterator[Boolean] =
      traversal.flatMap(_.resolved)

    /** Traverse to nodes where the resolved equals the given `value`
      */
    def resolved(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.resolved.isDefined && node.resolved.get == value }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_CallChainBase[NodeType <: nodes.CallChainBase](val traversal: Iterator[NodeType])           extends AnyVal {}
  final class Traversal_CallSiteBase[NodeType <: nodes.CallSiteBase](val traversal: Iterator[NodeType])             extends AnyVal {}
  final class Traversal_ClosureBindingBase[NodeType <: nodes.ClosureBindingBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def closureBindingIdExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
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
    def closureOriginalNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.closureOriginalName; tmp.isDefined && tmp.get == value
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
    def evaluationStrategyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationStrategy == value }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

  }
  final class Traversal_CommentBase[NodeType <: nodes.CommentBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

    /** Traverse to nodes where filename matches one of the elements in `values` exactly.
      */
    def filenameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) filenameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.filename) }
      }

  }
  final class Traversal_ConfigFileBase[NodeType <: nodes.ConfigFileBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def contentExact(value: String): Iterator[NodeType] =
      traversal.filter { _.content == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_ControlStructureBase[NodeType <: nodes.ControlStructureBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def controlStructureTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.controlStructureType == value }

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
    def parserTypeNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.parserTypeName == value }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  final class Traversal_DependencyBase[NodeType <: nodes.DependencyBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def dependencyGroupIdExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.dependencyGroupId; tmp.isDefined && tmp.get == value
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

    /** Traverse to dependencyType property */
    def dependencyType: Iterator[String] =
      traversal.map(_.dependencyType)

    /** Traverse to nodes where the dependencyType matches the regular expression `value`
      */
    def dependencyType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        dependencyTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.dependencyType).matches }
      }

    /** Traverse to nodes where the dependencyType matches at least one of the regular expressions in `values`
      */
    def dependencyType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.dependencyType).matches } }
    }

    /** Traverse to nodes where dependencyType matches `value` exactly.
      */
    def dependencyTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.dependencyType == value }

    /** Traverse to nodes where dependencyType matches one of the elements in `values` exactly.
      */
    def dependencyTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) dependencyTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.dependencyType) }
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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def versionExact(value: String): Iterator[NodeType] =
      traversal.filter { _.version == value }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
  final class Traversal_DomAttributeBase[NodeType <: nodes.DomAttributeBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_DomNodeBase[NodeType <: nodes.DomNodeBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_FieldIdentifierBase[NodeType <: nodes.FieldIdentifierBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def canonicalNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.canonicalName == value }

    /** Traverse to nodes where canonicalName matches one of the elements in `values` exactly.
      */
    def canonicalNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) canonicalNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.canonicalName) }
      }

  }
  final class Traversal_FileBase[NodeType <: nodes.FileBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def hashExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.hash; tmp.isDefined && tmp.get == value
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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_FindingBase[NodeType <: nodes.FindingBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to structuredFingerprint property */
    def structuredFingerprint: Iterator[String] =
      traversal.map(_.structuredFingerprint)

    /** Traverse to nodes where the structuredFingerprint matches the regular expression `value`
      */
    def structuredFingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        structuredFingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.structuredFingerprint).matches }
      }

    /** Traverse to nodes where the structuredFingerprint matches at least one of the regular expressions in `values`
      */
    def structuredFingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.structuredFingerprint).matches } }
    }

    /** Traverse to nodes where structuredFingerprint matches `value` exactly.
      */
    def structuredFingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.structuredFingerprint == value }

    /** Traverse to nodes where structuredFingerprint matches one of the elements in `values` exactly.
      */
    def structuredFingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) structuredFingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.structuredFingerprint) }
      }

  }
  final class Traversal_FlowBase[NodeType <: nodes.FlowBase](val traversal: Iterator[NodeType])           extends AnyVal {}
  final class Traversal_FrameworkBase[NodeType <: nodes.FrameworkBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_FrameworkDataBase[NodeType <: nodes.FrameworkDataBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def contentExact(value: String): Iterator[NodeType] =
      traversal.filter { _.content == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_IdentifierBase[NodeType <: nodes.IdentifierBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_ImplicitCallBase[NodeType <: nodes.ImplicitCallBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_ImportBase[NodeType <: nodes.ImportBase](val traversal: Iterator[NodeType])             extends AnyVal {

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
    def importedAsExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.importedAs; tmp.isDefined && tmp.get == value
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
    def importedEntityExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.importedEntity; tmp.isDefined && tmp.get == value
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
  final class Traversal_IoflowBase[NodeType <: nodes.IoflowBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to fingerprint property */
    def fingerprint: Iterator[String] =
      traversal.map(_.fingerprint)

    /** Traverse to nodes where the fingerprint matches the regular expression `value`
      */
    def fingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        fingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.fingerprint).matches }
      }

    /** Traverse to nodes where the fingerprint matches at least one of the regular expressions in `values`
      */
    def fingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.fingerprint).matches } }
    }

    /** Traverse to nodes where fingerprint matches `value` exactly.
      */
    def fingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fingerprint == value }

    /** Traverse to nodes where fingerprint matches one of the elements in `values` exactly.
      */
    def fingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fingerprint) }
      }

    /** Traverse to literalsToSink property */
    def literalsToSink: Iterator[String] =
      traversal.flatMap(_.literalsToSink)

    /** Traverse to mlAssisted property */
    def mlAssisted: Iterator[Boolean] =
      traversal.map(_.mlAssisted)

    /** Traverse to nodes where the mlAssisted equals the given `value`
      */
    def mlAssisted(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.mlAssisted == value }

  }
  final class Traversal_JumpLabelBase[NodeType <: nodes.JumpLabelBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def parserTypeNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.parserTypeName == value }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  final class Traversal_JumpTargetBase[NodeType <: nodes.JumpTargetBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def parserTypeNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.parserTypeName == value }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

  }
  final class Traversal_KeyValuePairBase[NodeType <: nodes.KeyValuePairBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def keyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.key == value }

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_LiteralBase[NodeType <: nodes.LiteralBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_LocalBase[NodeType <: nodes.LocalBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def closureBindingIdExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.closureBindingId; tmp.isDefined && tmp.get == value
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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_LocationBase[NodeType <: nodes.LocationBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def classNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.className == value }

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
    def classShortNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.classShortName == value }

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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

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
    def methodShortNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodShortName == value }

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
    def nodeLabelExact(value: String): Iterator[NodeType] =
      traversal.filter { _.nodeLabel == value }

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
    def packageNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.packageName == value }

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
    def symbolExact(value: String): Iterator[NodeType] =
      traversal.filter { _.symbol == value }

    /** Traverse to nodes where symbol matches one of the elements in `values` exactly.
      */
    def symbolExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) symbolExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.symbol) }
      }

  }
  final class Traversal_MatchInfoBase[NodeType <: nodes.MatchInfoBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to category property */
    def category: Iterator[String] =
      traversal.map(_.category)

    /** Traverse to nodes where the category matches the regular expression `value`
      */
    def category(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        categoryExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.category).matches }
      }

    /** Traverse to nodes where the category matches at least one of the regular expressions in `values`
      */
    def category(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.category).matches } }
    }

    /** Traverse to nodes where category matches `value` exactly.
      */
    def categoryExact(value: String): Iterator[NodeType] =
      traversal.filter { _.category == value }

    /** Traverse to nodes where category matches one of the elements in `values` exactly.
      */
    def categoryExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) categoryExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.category) }
      }

    /** Traverse to pattern property */
    def pattern: Iterator[String] =
      traversal.map(_.pattern)

    /** Traverse to nodes where the pattern matches the regular expression `value`
      */
    def pattern(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        patternExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.pattern).matches }
      }

    /** Traverse to nodes where the pattern matches at least one of the regular expressions in `values`
      */
    def pattern(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.pattern).matches } }
    }

    /** Traverse to nodes where pattern matches `value` exactly.
      */
    def patternExact(value: String): Iterator[NodeType] =
      traversal.filter { _.pattern == value }

    /** Traverse to nodes where pattern matches one of the elements in `values` exactly.
      */
    def patternExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) patternExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.pattern) }
      }

  }
  final class Traversal_MemberBase[NodeType <: nodes.MemberBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_MetaDataBase[NodeType <: nodes.MetaDataBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def hashExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.hash; tmp.isDefined && tmp.get == value
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
    def languageExact(value: String): Iterator[NodeType] =
      traversal.filter { _.language == value }

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

    /** Traverse to policyDirectories property */
    def policyDirectories: Iterator[String] =
      traversal.flatMap(_.policyDirectories)

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
    def rootExact(value: String): Iterator[NodeType] =
      traversal.filter { _.root == value }

    /** Traverse to nodes where root matches one of the elements in `values` exactly.
      */
    def rootExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) rootExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.root) }
      }

    /** Traverse to spid property */
    def spid: Iterator[String] =
      traversal.flatMap(_.spid)

    /** Traverse to nodes where the spid matches the regular expression `value`
      */
    def spid(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        spidExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.spid; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the spid matches at least one of the regular expressions in `values`
      */
    def spid(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.spid; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where spid matches `value` exactly.
      */
    def spidExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.spid; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where spid matches one of the elements in `values` exactly.
      */
    def spidExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) spidExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.spid; tmp.isDefined && valueSet.contains(tmp.get)
        }
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
    def versionExact(value: String): Iterator[NodeType] =
      traversal.filter { _.version == value }

    /** Traverse to nodes where version matches one of the elements in `values` exactly.
      */
    def versionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) versionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.version) }
      }

  }
  final class Traversal_MethodBase[NodeType <: nodes.MethodBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def astParentFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentFullName == value }

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
    def astParentTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentType == value }

    /** Traverse to nodes where astParentType matches one of the elements in `values` exactly.
      */
    def astParentTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) astParentTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.astParentType) }
      }

    /** Traverse to binarySignature property */
    def binarySignature: Iterator[String] =
      traversal.flatMap(_.binarySignature)

    /** Traverse to nodes where the binarySignature matches the regular expression `value`
      */
    def binarySignature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        binarySignatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the binarySignature matches at least one of the regular expressions in `values`
      */
    def binarySignature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.binarySignature; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where binarySignature matches `value` exactly.
      */
    def binarySignatureExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.binarySignature; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where binarySignature matches one of the elements in `values` exactly.
      */
    def binarySignatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) binarySignatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && valueSet.contains(tmp.get)
        }
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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

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
    def hashExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.hash; tmp.isDefined && tmp.get == value
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

    /** Traverse to hasMapping property */
    def hasMapping: Iterator[Boolean] =
      traversal.flatMap(_.hasMapping)

    /** Traverse to nodes where the hasMapping equals the given `value`
      */
    def hasMapping(value: Boolean): Iterator[NodeType] =
      traversal.filter { node => node.hasMapping.isDefined && node.hasMapping.get == value }

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
    def signatureExact(value: String): Iterator[NodeType] =
      traversal.filter { _.signature == value }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

    /** Traverse to varargParameter property */
    def varargParameter: Iterator[Int] =
      traversal.map(_.varargParameter)

    /** Traverse to nodes where the varargParameter equals the given `value`
      */
    def varargParameter(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter == value }

    /** Traverse to nodes where the varargParameter equals at least one of the given `values`
      */
    def varargParameter(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.varargParameter) }
    }

    /** Traverse to nodes where the varargParameter is greater than the given `value`
      */
    def varargParameterGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter > value }

    /** Traverse to nodes where the varargParameter is greater than or equal the given `value`
      */
    def varargParameterGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter >= value }

    /** Traverse to nodes where the varargParameter is less than the given `value`
      */
    def varargParameterLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter < value }

    /** Traverse to nodes where the varargParameter is less than or equal the given `value`
      */
    def varargParameterLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.varargParameter <= value }

  }
  final class Traversal_MethodInstBase[NodeType <: nodes.MethodInstBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def signatureExact(value: String): Iterator[NodeType] =
      traversal.filter { _.signature == value }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  final class Traversal_MethodParameterInBase[NodeType <: nodes.MethodParameterInBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def evaluationStrategyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationStrategy == value }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_MethodParameterOutBase[NodeType <: nodes.MethodParameterOutBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def evaluationStrategyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationStrategy == value }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_MethodRefBase[NodeType <: nodes.MethodRefBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def methodFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.methodFullName == value }

    /** Traverse to nodes where methodFullName matches one of the elements in `values` exactly.
      */
    def methodFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.methodFullName) }
      }

    /** Traverse to methodInstFullName property */
    def methodInstFullName: Iterator[String] =
      traversal.flatMap(_.methodInstFullName)

    /** Traverse to nodes where the methodInstFullName matches the regular expression `value`
      */
    def methodInstFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        methodInstFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the methodInstFullName matches at least one of the regular expressions in `values`
      */
    def methodInstFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.methodInstFullName; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where methodInstFullName matches `value` exactly.
      */
    def methodInstFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.methodInstFullName; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where methodInstFullName matches one of the elements in `values` exactly.
      */
    def methodInstFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) methodInstFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.methodInstFullName; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_MethodReturnBase[NodeType <: nodes.MethodReturnBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def evaluationStrategyExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationStrategy == value }

    /** Traverse to nodes where evaluationStrategy matches one of the elements in `values` exactly.
      */
    def evaluationStrategyExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationStrategyExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationStrategy) }
      }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_MethodSummaryBase[NodeType <: nodes.MethodSummaryBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to binarySignature property */
    def binarySignature: Iterator[String] =
      traversal.flatMap(_.binarySignature)

    /** Traverse to nodes where the binarySignature matches the regular expression `value`
      */
    def binarySignature(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        binarySignatureExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && matcher.reset(tmp.get).matches
        }
      }

    /** Traverse to nodes where the binarySignature matches at least one of the regular expressions in `values`
      */
    def binarySignature(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item =>
        val tmp = item.binarySignature; tmp.isDefined && matchers.exists { _.reset(tmp.get).matches }
      }
    }

    /** Traverse to nodes where binarySignature matches `value` exactly.
      */
    def binarySignatureExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.binarySignature; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where binarySignature matches one of the elements in `values` exactly.
      */
    def binarySignatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) binarySignatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item =>
          val tmp = item.binarySignature; tmp.isDefined && valueSet.contains(tmp.get)
        }
      }

    /** Traverse to isExternal property */
    def isExternal: Iterator[Boolean] =
      traversal.map(_.isExternal)

    /** Traverse to nodes where the isExternal equals the given `value`
      */
    def isExternal(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isExternal == value }

    /** Traverse to isStatic property */
    def isStatic: Iterator[Boolean] =
      traversal.map(_.isStatic)

    /** Traverse to nodes where the isStatic equals the given `value`
      */
    def isStatic(value: Boolean): Iterator[NodeType] =
      traversal.filter { _.isStatic == value }

  }
  final class Traversal_ModifierBase[NodeType <: nodes.ModifierBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def modifierTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.modifierType == value }

    /** Traverse to nodes where modifierType matches one of the elements in `values` exactly.
      */
    def modifierTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) modifierTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.modifierType) }
      }

  }
  final class Traversal_NamespaceBase[NodeType <: nodes.NamespaceBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_NamespaceBlockBase[NodeType <: nodes.NamespaceBlockBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_PackagePrefixBase[NodeType <: nodes.PackagePrefixBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_PostExecutionCallBase[NodeType <: nodes.PostExecutionCallBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_ProgramPointBase[NodeType <: nodes.ProgramPointBase](val traversal: Iterator[NodeType])           extends AnyVal {}
  final class Traversal_ReadBase[NodeType <: nodes.ReadBase](val traversal: Iterator[NodeType])                           extends AnyVal {}
  final class Traversal_ReturnBase[NodeType <: nodes.ReturnBase](val traversal: Iterator[NodeType])                       extends AnyVal {}
  final class Traversal_RouteBase[NodeType <: nodes.RouteBase](val traversal: Iterator[NodeType])                         extends AnyVal {

    /** Traverse to path property */
    def path: Iterator[String] =
      traversal.map(_.path)

    /** Traverse to nodes where the path matches the regular expression `value`
      */
    def path(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        pathExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.path).matches }
      }

    /** Traverse to nodes where the path matches at least one of the regular expressions in `values`
      */
    def path(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.path).matches } }
    }

    /** Traverse to nodes where path matches `value` exactly.
      */
    def pathExact(value: String): Iterator[NodeType] =
      traversal.filter { _.path == value }

    /** Traverse to nodes where path matches one of the elements in `values` exactly.
      */
    def pathExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) pathExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.path) }
      }

  }
  final class Traversal_SensitiveDataTypeBase[NodeType <: nodes.SensitiveDataTypeBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

    /** Traverse to nodes where fullName matches one of the elements in `values` exactly.
      */
    def fullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) fullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.fullName) }
      }

  }
  final class Traversal_SensitiveMemberBase[NodeType <: nodes.SensitiveMemberBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_SensitiveReferenceBase[NodeType <: nodes.SensitiveReferenceBase](val traversal: Iterator[NodeType])
      extends AnyVal {}
  final class Traversal_SensitiveVariableBase[NodeType <: nodes.SensitiveVariableBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to categories property */
    def categories: Iterator[String] =
      traversal.flatMap(_.categories)

    /** Traverse to evalType property */
    def evalType: Iterator[String] =
      traversal.map(_.evalType)

    /** Traverse to nodes where the evalType matches the regular expression `value`
      */
    def evalType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evalTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evalType).matches }
      }

    /** Traverse to nodes where the evalType matches at least one of the regular expressions in `values`
      */
    def evalType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evalType).matches } }
    }

    /** Traverse to nodes where evalType matches `value` exactly.
      */
    def evalTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evalType == value }

    /** Traverse to nodes where evalType matches one of the elements in `values` exactly.
      */
    def evalTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evalTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evalType) }
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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_SinkBase[NodeType <: nodes.SinkBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to sinkType property */
    def sinkType: Iterator[String] =
      traversal.map(_.sinkType)

    /** Traverse to nodes where the sinkType matches the regular expression `value`
      */
    def sinkType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        sinkTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.sinkType).matches }
      }

    /** Traverse to nodes where the sinkType matches at least one of the regular expressions in `values`
      */
    def sinkType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.sinkType).matches } }
    }

    /** Traverse to nodes where sinkType matches `value` exactly.
      */
    def sinkTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.sinkType == value }

    /** Traverse to nodes where sinkType matches one of the elements in `values` exactly.
      */
    def sinkTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) sinkTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.sinkType) }
      }

    /** Traverse to structuredFingerprint property */
    def structuredFingerprint: Iterator[String] =
      traversal.map(_.structuredFingerprint)

    /** Traverse to nodes where the structuredFingerprint matches the regular expression `value`
      */
    def structuredFingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        structuredFingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.structuredFingerprint).matches }
      }

    /** Traverse to nodes where the structuredFingerprint matches at least one of the regular expressions in `values`
      */
    def structuredFingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.structuredFingerprint).matches } }
    }

    /** Traverse to nodes where structuredFingerprint matches `value` exactly.
      */
    def structuredFingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.structuredFingerprint == value }

    /** Traverse to nodes where structuredFingerprint matches one of the elements in `values` exactly.
      */
    def structuredFingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) structuredFingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.structuredFingerprint) }
      }

  }
  final class Traversal_SourceBase[NodeType <: nodes.SourceBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to sourceType property */
    def sourceType: Iterator[String] =
      traversal.map(_.sourceType)

    /** Traverse to nodes where the sourceType matches the regular expression `value`
      */
    def sourceType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        sourceTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.sourceType).matches }
      }

    /** Traverse to nodes where the sourceType matches at least one of the regular expressions in `values`
      */
    def sourceType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.sourceType).matches } }
    }

    /** Traverse to nodes where sourceType matches `value` exactly.
      */
    def sourceTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.sourceType == value }

    /** Traverse to nodes where sourceType matches one of the elements in `values` exactly.
      */
    def sourceTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) sourceTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.sourceType) }
      }

    /** Traverse to structuredFingerprint property */
    def structuredFingerprint: Iterator[String] =
      traversal.map(_.structuredFingerprint)

    /** Traverse to nodes where the structuredFingerprint matches the regular expression `value`
      */
    def structuredFingerprint(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        structuredFingerprintExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.structuredFingerprint).matches }
      }

    /** Traverse to nodes where the structuredFingerprint matches at least one of the regular expressions in `values`
      */
    def structuredFingerprint(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.structuredFingerprint).matches } }
    }

    /** Traverse to nodes where structuredFingerprint matches `value` exactly.
      */
    def structuredFingerprintExact(value: String): Iterator[NodeType] =
      traversal.filter { _.structuredFingerprint == value }

    /** Traverse to nodes where structuredFingerprint matches one of the elements in `values` exactly.
      */
    def structuredFingerprintExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) structuredFingerprintExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.structuredFingerprint) }
      }

  }
  final class Traversal_SpAnnotationParameterBase[NodeType <: nodes.SpAnnotationParameterBase](val traversal: Iterator[NodeType])
      extends AnyVal {

    /** Traverse to annotationFullName property */
    def annotationFullName: Iterator[String] =
      traversal.map(_.annotationFullName)

    /** Traverse to nodes where the annotationFullName matches the regular expression `value`
      */
    def annotationFullName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        annotationFullNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.annotationFullName).matches }
      }

    /** Traverse to nodes where the annotationFullName matches at least one of the regular expressions in `values`
      */
    def annotationFullName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.annotationFullName).matches } }
    }

    /** Traverse to nodes where annotationFullName matches `value` exactly.
      */
    def annotationFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.annotationFullName == value }

    /** Traverse to nodes where annotationFullName matches one of the elements in `values` exactly.
      */
    def annotationFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) annotationFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.annotationFullName) }
      }

    /** Traverse to annotationName property */
    def annotationName: Iterator[String] =
      traversal.map(_.annotationName)

    /** Traverse to nodes where the annotationName matches the regular expression `value`
      */
    def annotationName(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        annotationNameExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.annotationName).matches }
      }

    /** Traverse to nodes where the annotationName matches at least one of the regular expressions in `values`
      */
    def annotationName(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.annotationName).matches } }
    }

    /** Traverse to nodes where annotationName matches `value` exactly.
      */
    def annotationNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.annotationName == value }

    /** Traverse to nodes where annotationName matches one of the elements in `values` exactly.
      */
    def annotationNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) annotationNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.annotationName) }
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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_SpBlacklistBase[NodeType <: nodes.SpBlacklistBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_TagBase[NodeType <: nodes.TagBase](val traversal: Iterator[NodeType])                 extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def valueExact(value: String): Iterator[NodeType] =
      traversal.filter { _.value == value }

    /** Traverse to nodes where value matches one of the elements in `values` exactly.
      */
    def valueExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) valueExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.value) }
      }

  }
  final class Traversal_TagsBase[NodeType <: nodes.TagsBase](val traversal: Iterator[NodeType])               extends AnyVal {}
  final class Traversal_TagNodePairBase[NodeType <: nodes.TagNodePairBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_TemplateDomBase[NodeType <: nodes.TemplateDomBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_TransformBase[NodeType <: nodes.TransformBase](val traversal: Iterator[NodeType])           extends AnyVal {}
  final class Traversal_TransformationBase[NodeType <: nodes.TransformationBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_TypeBase[NodeType <: nodes.TypeBase](val traversal: Iterator[NodeType])                     extends AnyVal {

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def typeDeclFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeDeclFullName == value }

    /** Traverse to nodes where typeDeclFullName matches one of the elements in `values` exactly.
      */
    def typeDeclFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeDeclFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeDeclFullName) }
      }

  }
  final class Traversal_TypeArgumentBase[NodeType <: nodes.TypeArgumentBase](val traversal: Iterator[NodeType]) extends AnyVal {}
  final class Traversal_TypeDeclBase[NodeType <: nodes.TypeDeclBase](val traversal: Iterator[NodeType])         extends AnyVal {

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
    def aliasTypeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.aliasTypeFullName; tmp.isDefined && tmp.get == value
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
    def astParentFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentFullName == value }

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
    def astParentTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.astParentType == value }

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
    def filenameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.filename == value }

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
    def fullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.fullName == value }

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_TypeParameterBase[NodeType <: nodes.TypeParameterBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_TypeRefBase[NodeType <: nodes.TypeRefBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to dynamicTypeHintFullName property */
    def dynamicTypeHintFullName: Iterator[String] =
      traversal.flatMap(_.dynamicTypeHintFullName)

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_UnknownBase[NodeType <: nodes.UnknownBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def containedRefExact(value: String): Iterator[NodeType] =
      traversal.filter { _.containedRef == value }

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
    def parserTypeNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.parserTypeName == value }

    /** Traverse to nodes where parserTypeName matches one of the elements in `values` exactly.
      */
    def parserTypeNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) parserTypeNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.parserTypeName) }
      }

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
    def typeFullNameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.typeFullName == value }

    /** Traverse to nodes where typeFullName matches one of the elements in `values` exactly.
      */
    def typeFullNameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) typeFullNameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.typeFullName) }
      }

  }
  final class Traversal_VariableInfoBase[NodeType <: nodes.VariableInfoBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to evaluationType property */
    def evaluationType: Iterator[String] =
      traversal.map(_.evaluationType)

    /** Traverse to nodes where the evaluationType matches the regular expression `value`
      */
    def evaluationType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        evaluationTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.evaluationType).matches }
      }

    /** Traverse to nodes where the evaluationType matches at least one of the regular expressions in `values`
      */
    def evaluationType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.evaluationType).matches } }
    }

    /** Traverse to nodes where evaluationType matches `value` exactly.
      */
    def evaluationTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.evaluationType == value }

    /** Traverse to nodes where evaluationType matches one of the elements in `values` exactly.
      */
    def evaluationTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) evaluationTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.evaluationType) }
      }

    /** Traverse to parameterIndex property */
    def parameterIndex: Iterator[Int] =
      traversal.flatMap(_.parameterIndex)

    /** Traverse to nodes where the parameterIndex equals the given `value`
      */
    def parameterIndex(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get == value
      }

    /** Traverse to nodes where the parameterIndex equals at least one of the given `values`
      */
    def parameterIndex(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && vset.contains(tmp.get)
      }
    }

    /** Traverse to nodes where the parameterIndex is greater than the given `value`
      */
    def parameterIndexGt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get > value
      }

    /** Traverse to nodes where the parameterIndex is greater than or equal the given `value`
      */
    def parameterIndexGte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get >= value
      }

    /** Traverse to nodes where the parameterIndex is less than the given `value`
      */
    def parameterIndexLt(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get < value
      }

    /** Traverse to nodes where the parameterIndex is less than or equal the given `value`
      */
    def parameterIndexLte(value: Int): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.parameterIndex; tmp.isDefined && tmp.get <= value
      }

    /** Traverse to varType property */
    def varType: Iterator[String] =
      traversal.map(_.varType)

    /** Traverse to nodes where the varType matches the regular expression `value`
      */
    def varType(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        varTypeExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.varType).matches }
      }

    /** Traverse to nodes where the varType matches at least one of the regular expressions in `values`
      */
    def varType(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.varType).matches } }
    }

    /** Traverse to nodes where varType matches `value` exactly.
      */
    def varTypeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.varType == value }

    /** Traverse to nodes where varType matches one of the elements in `values` exactly.
      */
    def varTypeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) varTypeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.varType) }
      }

  }
  final class Traversal_VulnerabilityBase[NodeType <: nodes.VulnerabilityBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to description property */
    def description: Iterator[String] =
      traversal.map(_.description)

    /** Traverse to nodes where the description matches the regular expression `value`
      */
    def description(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        descriptionExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.description).matches }
      }

    /** Traverse to nodes where the description matches at least one of the regular expressions in `values`
      */
    def description(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.description).matches } }
    }

    /** Traverse to nodes where description matches `value` exactly.
      */
    def descriptionExact(value: String): Iterator[NodeType] =
      traversal.filter { _.description == value }

    /** Traverse to nodes where description matches one of the elements in `values` exactly.
      */
    def descriptionExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) descriptionExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.description) }
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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

    /** Traverse to score property */
    def score: Iterator[String] =
      traversal.map(_.score)

    /** Traverse to nodes where the score matches the regular expression `value`
      */
    def score(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        scoreExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.score).matches }
      }

    /** Traverse to nodes where the score matches at least one of the regular expressions in `values`
      */
    def score(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.score).matches } }
    }

    /** Traverse to nodes where score matches `value` exactly.
      */
    def scoreExact(value: String): Iterator[NodeType] =
      traversal.filter { _.score == value }

    /** Traverse to nodes where score matches one of the elements in `values` exactly.
      */
    def scoreExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) scoreExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.score) }
      }

    /** Traverse to url property */
    def url: Iterator[String] =
      traversal.map(_.url)

    /** Traverse to nodes where the url matches the regular expression `value`
      */
    def url(pattern: String): Iterator[NodeType] =
      if (!Misc.isRegex(pattern)) {
        urlExact(pattern)
      } else {
        val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
        traversal.filter { item => matcher.reset(item.url).matches }
      }

    /** Traverse to nodes where the url matches at least one of the regular expressions in `values`
      */
    def url(patterns: String*): Iterator[NodeType] = {
      val matchers = patterns.map { java.util.regex.Pattern.compile(_).matcher("") }
      traversal.filter { item => matchers.exists { _.reset(item.url).matches } }
    }

    /** Traverse to nodes where url matches `value` exactly.
      */
    def urlExact(value: String): Iterator[NodeType] =
      traversal.filter { _.url == value }

    /** Traverse to nodes where url matches one of the elements in `values` exactly.
      */
    def urlExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) urlExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.url) }
      }

  }
  final class Traversal_WriteBase[NodeType <: nodes.WriteBase](val traversal: Iterator[NodeType])     extends AnyVal {}
  final class Traversal_AstNodeBase[NodeType <: nodes.AstNodeBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def codeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.code == value }

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
  final class Traversal_CallReprBase[NodeType <: nodes.CallReprBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
    def signatureExact(value: String): Iterator[NodeType] =
      traversal.filter { _.signature == value }

    /** Traverse to nodes where signature matches one of the elements in `values` exactly.
      */
    def signatureExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) signatureExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.signature) }
      }

  }
  final class Traversal_CfgNodeBase[NodeType <: nodes.CfgNodeBase](val traversal: Iterator[NodeType]) extends AnyVal {

    /** Traverse to depthFirstOrder property */
    def depthFirstOrder: Iterator[Int] =
      traversal.map(_.depthFirstOrder)

    /** Traverse to nodes where the depthFirstOrder equals the given `value`
      */
    def depthFirstOrder(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder == value }

    /** Traverse to nodes where the depthFirstOrder equals at least one of the given `values`
      */
    def depthFirstOrder(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.depthFirstOrder) }
    }

    /** Traverse to nodes where the depthFirstOrder is greater than the given `value`
      */
    def depthFirstOrderGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder > value }

    /** Traverse to nodes where the depthFirstOrder is greater than or equal the given `value`
      */
    def depthFirstOrderGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder >= value }

    /** Traverse to nodes where the depthFirstOrder is less than the given `value`
      */
    def depthFirstOrderLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder < value }

    /** Traverse to nodes where the depthFirstOrder is less than or equal the given `value`
      */
    def depthFirstOrderLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.depthFirstOrder <= value }

    /** Traverse to internalFlags property */
    def internalFlags: Iterator[Int] =
      traversal.map(_.internalFlags)

    /** Traverse to nodes where the internalFlags equals the given `value`
      */
    def internalFlags(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags == value }

    /** Traverse to nodes where the internalFlags equals at least one of the given `values`
      */
    def internalFlags(values: Int*): Iterator[NodeType] = {
      val vset = values.toSet
      traversal.filter { node => vset.contains(node.internalFlags) }
    }

    /** Traverse to nodes where the internalFlags is greater than the given `value`
      */
    def internalFlagsGt(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags > value }

    /** Traverse to nodes where the internalFlags is greater than or equal the given `value`
      */
    def internalFlagsGte(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags >= value }

    /** Traverse to nodes where the internalFlags is less than the given `value`
      */
    def internalFlagsLt(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags < value }

    /** Traverse to nodes where the internalFlags is less than or equal the given `value`
      */
    def internalFlagsLte(value: Int): Iterator[NodeType] =
      traversal.filter { _.internalFlags <= value }

  }
  final class Traversal_ExpressionBase[NodeType <: nodes.ExpressionBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def argumentNameExact(value: String): Iterator[NodeType] =
      traversal.filter { node =>
        val tmp = node.argumentName; tmp.isDefined && tmp.get == value
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
  final class Traversal_DeclarationBase[NodeType <: nodes.DeclarationBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

    /** Traverse to nodes where name matches one of the elements in `values` exactly.
      */
    def nameExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) nameExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.name) }
      }

  }
  final class Traversal_TrackingPointBase[NodeType <: nodes.TrackingPointBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def codeExact(value: String): Iterator[NodeType] =
      traversal.filter { _.code == value }

    /** Traverse to nodes where code matches one of the elements in `values` exactly.
      */
    def codeExact(values: String*): Iterator[NodeType] =
      if (values.length == 1) codeExact(values.head)
      else {
        val valueSet = values.toSet
        traversal.filter { item => valueSet.contains(item.code) }
      }

  }
  final class Traversal_LocalLikeBase[NodeType <: nodes.LocalLikeBase](val traversal: Iterator[NodeType]) extends AnyVal {

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
    def nameExact(value: String): Iterator[NodeType] =
      traversal.filter { _.name == value }

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
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors._
  implicit def accessPropertyAliasTypeFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAliasTypeFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ALIAS_TYPE_FULL_NAME[NodeType] = new Traversal_Property_ALIAS_TYPE_FULL_NAME(traversal)
  implicit def accessPropertyAnnotationFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ANNOTATION_FULL_NAME[NodeType] = new Traversal_Property_ANNOTATION_FULL_NAME(traversal)
  implicit def accessPropertyAnnotationName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAnnotationNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ANNOTATION_NAME[NodeType] = new Traversal_Property_ANNOTATION_NAME(traversal)
  implicit def accessPropertyArgumentIndex[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentIndexT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ARGUMENT_INDEX[NodeType] = new Traversal_Property_ARGUMENT_INDEX(traversal)
  implicit def accessPropertyArgumentName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasArgumentNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ARGUMENT_NAME[NodeType] = new Traversal_Property_ARGUMENT_NAME(traversal)
  implicit def accessPropertyAstParentFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_AST_PARENT_FULL_NAME[NodeType] = new Traversal_Property_AST_PARENT_FULL_NAME(traversal)
  implicit def accessPropertyAstParentType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasAstParentTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_AST_PARENT_TYPE[NodeType] = new Traversal_Property_AST_PARENT_TYPE(traversal)
  implicit def accessPropertyBinarySignature[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasBinarySignatureT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_BINARY_SIGNATURE[NodeType] = new Traversal_Property_BINARY_SIGNATURE(traversal)
  implicit def accessPropertyCanonicalName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCanonicalNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CANONICAL_NAME[NodeType] = new Traversal_Property_CANONICAL_NAME(traversal)
  implicit def accessPropertyCategories[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCategoriesT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CATEGORIES[NodeType] = new Traversal_Property_CATEGORIES(traversal)
  implicit def accessPropertyCategory[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCategoryT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CATEGORY[NodeType] = new Traversal_Property_CATEGORY(traversal)
  implicit def accessPropertyClassName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CLASS_NAME[NodeType] = new Traversal_Property_CLASS_NAME(traversal)
  implicit def accessPropertyClassShortName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClassShortNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CLASS_SHORT_NAME[NodeType] = new Traversal_Property_CLASS_SHORT_NAME(traversal)
  implicit def accessPropertyClosureBindingId[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureBindingIdT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CLOSURE_BINDING_ID[NodeType] = new Traversal_Property_CLOSURE_BINDING_ID(traversal)
  implicit def accessPropertyClosureOriginalName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasClosureOriginalNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CLOSURE_ORIGINAL_NAME[NodeType] = new Traversal_Property_CLOSURE_ORIGINAL_NAME(traversal)
  implicit def accessPropertyCode[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasCodeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CODE[NodeType] = new Traversal_Property_CODE(traversal)
  implicit def accessPropertyColumnNumber[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_COLUMN_NUMBER[NodeType] = new Traversal_Property_COLUMN_NUMBER(traversal)
  implicit def accessPropertyColumnNumberEnd[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasColumnNumberEndT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_COLUMN_NUMBER_END[NodeType] = new Traversal_Property_COLUMN_NUMBER_END(traversal)
  implicit def accessPropertyContainedRef[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContainedRefT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CONTAINED_REF[NodeType] = new Traversal_Property_CONTAINED_REF(traversal)
  implicit def accessPropertyContent[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasContentT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CONTENT[NodeType] = new Traversal_Property_CONTENT(traversal)
  implicit def accessPropertyControlStructureType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasControlStructureTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_CONTROL_STRUCTURE_TYPE[NodeType] = new Traversal_Property_CONTROL_STRUCTURE_TYPE(traversal)
  implicit def accessPropertyDependencyGroupId[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyGroupIdT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DEPENDENCY_GROUP_ID[NodeType] = new Traversal_Property_DEPENDENCY_GROUP_ID(traversal)
  implicit def accessPropertyDependencyType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDependencyTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DEPENDENCY_TYPE[NodeType] = new Traversal_Property_DEPENDENCY_TYPE(traversal)
  implicit def accessPropertyDepthFirstOrder[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDepthFirstOrderT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DEPTH_FIRST_ORDER[NodeType] = new Traversal_Property_DEPTH_FIRST_ORDER(traversal)
  implicit def accessPropertyDescription[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDescriptionT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DESCRIPTION[NodeType] = new Traversal_Property_DESCRIPTION(traversal)
  implicit def accessPropertyDispatchName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DISPATCH_NAME[NodeType] = new Traversal_Property_DISPATCH_NAME(traversal)
  implicit def accessPropertyDispatchType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDispatchTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DISPATCH_TYPE[NodeType] = new Traversal_Property_DISPATCH_TYPE(traversal)
  implicit def accessPropertyDynamicTypeHintFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasDynamicTypeHintFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_DYNAMIC_TYPE_HINT_FULL_NAME[NodeType] = new Traversal_Property_DYNAMIC_TYPE_HINT_FULL_NAME(traversal)
  implicit def accessPropertyEvaluationStrategy[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationStrategyT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_EVALUATION_STRATEGY[NodeType] = new Traversal_Property_EVALUATION_STRATEGY(traversal)
  implicit def accessPropertyEvaluationType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvaluationTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_EVALUATION_TYPE[NodeType] = new Traversal_Property_EVALUATION_TYPE(traversal)
  implicit def accessPropertyEvalType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasEvalTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_EVAL_TYPE[NodeType] = new Traversal_Property_EVAL_TYPE(traversal)
  implicit def accessPropertyExplicitAs[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasExplicitAsT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_EXPLICIT_AS[NodeType] = new Traversal_Property_EXPLICIT_AS(traversal)
  implicit def accessPropertyFilename[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFilenameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_FILENAME[NodeType] = new Traversal_Property_FILENAME(traversal)
  implicit def accessPropertyFingerprint[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFingerprintT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_FINGERPRINT[NodeType] = new Traversal_Property_FINGERPRINT(traversal)
  implicit def accessPropertyFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_FULL_NAME[NodeType] = new Traversal_Property_FULL_NAME(traversal)
  implicit def accessPropertyHash[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasHashT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_HASH[NodeType] = new Traversal_Property_HASH(traversal)
  implicit def accessPropertyHasMapping[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasHasMappingT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_HAS_MAPPING[NodeType] = new Traversal_Property_HAS_MAPPING(traversal)
  implicit def accessPropertyImportedAs[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedAsT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IMPORTED_AS[NodeType] = new Traversal_Property_IMPORTED_AS(traversal)
  implicit def accessPropertyImportedEntity[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasImportedEntityT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IMPORTED_ENTITY[NodeType] = new Traversal_Property_IMPORTED_ENTITY(traversal)
  implicit def accessPropertyIndex[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIndexT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_INDEX[NodeType] = new Traversal_Property_INDEX(traversal)
  implicit def accessPropertyInheritsFromTypeFullName[
    NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasInheritsFromTypeFullNameT]
  ](traversal: Iterator[NodeType]): Traversal_Property_INHERITS_FROM_TYPE_FULL_NAME[NodeType] =
    new Traversal_Property_INHERITS_FROM_TYPE_FULL_NAME(traversal)
  implicit def accessPropertyInternalFlags[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasInternalFlagsT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_INTERNAL_FLAGS[NodeType] = new Traversal_Property_INTERNAL_FLAGS(traversal)
  implicit def accessPropertyIsExplicit[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExplicitT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_EXPLICIT[NodeType] = new Traversal_Property_IS_EXPLICIT(traversal)
  implicit def accessPropertyIsExternal[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsExternalT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_EXTERNAL[NodeType] = new Traversal_Property_IS_EXTERNAL(traversal)
  implicit def accessPropertyIsMethodNeverOverridden[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsMethodNeverOverriddenT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_METHOD_NEVER_OVERRIDDEN[NodeType] = new Traversal_Property_IS_METHOD_NEVER_OVERRIDDEN(traversal)
  implicit def accessPropertyIsStatic[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsStaticT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_STATIC[NodeType] = new Traversal_Property_IS_STATIC(traversal)
  implicit def accessPropertyIsVariadic[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsVariadicT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_VARIADIC[NodeType] = new Traversal_Property_IS_VARIADIC(traversal)
  implicit def accessPropertyIsWildcard[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasIsWildcardT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_IS_WILDCARD[NodeType] = new Traversal_Property_IS_WILDCARD(traversal)
  implicit def accessPropertyKey[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasKeyT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_KEY[NodeType] = new Traversal_Property_KEY(traversal)
  implicit def accessPropertyLanguage[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLanguageT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_LANGUAGE[NodeType] = new Traversal_Property_LANGUAGE(traversal)
  implicit def accessPropertyLineNumber[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_LINE_NUMBER[NodeType] = new Traversal_Property_LINE_NUMBER(traversal)
  implicit def accessPropertyLineNumberEnd[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLineNumberEndT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_LINE_NUMBER_END[NodeType] = new Traversal_Property_LINE_NUMBER_END(traversal)
  implicit def accessPropertyLiteralsToSink[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasLiteralsToSinkT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_LITERALS_TO_SINK[NodeType] = new Traversal_Property_LITERALS_TO_SINK(traversal)
  implicit def accessPropertyMethodFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_METHOD_FULL_NAME[NodeType] = new Traversal_Property_METHOD_FULL_NAME(traversal)
  implicit def accessPropertyMethodInstFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodInstFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_METHOD_INST_FULL_NAME[NodeType] = new Traversal_Property_METHOD_INST_FULL_NAME(traversal)
  implicit def accessPropertyMethodShortName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMethodShortNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_METHOD_SHORT_NAME[NodeType] = new Traversal_Property_METHOD_SHORT_NAME(traversal)
  implicit def accessPropertyMlAssisted[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasMlAssistedT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ML_ASSISTED[NodeType] = new Traversal_Property_ML_ASSISTED(traversal)
  implicit def accessPropertyModifierType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasModifierTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_MODIFIER_TYPE[NodeType] = new Traversal_Property_MODIFIER_TYPE(traversal)
  implicit def accessPropertyName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_NAME[NodeType] = new Traversal_Property_NAME(traversal)
  implicit def accessPropertyNodeLabel[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasNodeLabelT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_NODE_LABEL[NodeType] = new Traversal_Property_NODE_LABEL(traversal)
  implicit def accessPropertyOrder[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOrderT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ORDER[NodeType] = new Traversal_Property_ORDER(traversal)
  implicit def accessPropertyOverlays[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasOverlaysT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_OVERLAYS[NodeType] = new Traversal_Property_OVERLAYS(traversal)
  implicit def accessPropertyPackageName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPackageNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_PACKAGE_NAME[NodeType] = new Traversal_Property_PACKAGE_NAME(traversal)
  implicit def accessPropertyParameterIndex[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasParameterIndexT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_PARAMETER_INDEX[NodeType] = new Traversal_Property_PARAMETER_INDEX(traversal)
  implicit def accessPropertyParserTypeName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasParserTypeNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_PARSER_TYPE_NAME[NodeType] = new Traversal_Property_PARSER_TYPE_NAME(traversal)
  implicit def accessPropertyPath[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPathT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_PATH[NodeType] = new Traversal_Property_PATH(traversal)
  implicit def accessPropertyPattern[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPatternT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_PATTERN[NodeType] = new Traversal_Property_PATTERN(traversal)
  implicit def accessPropertyPolicyDirectories[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasPolicyDirectoriesT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_POLICY_DIRECTORIES[NodeType] = new Traversal_Property_POLICY_DIRECTORIES(traversal)
  implicit def accessPropertyResolved[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasResolvedT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_RESOLVED[NodeType] = new Traversal_Property_RESOLVED(traversal)
  implicit def accessPropertyRoot[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasRootT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_ROOT[NodeType] = new Traversal_Property_ROOT(traversal)
  implicit def accessPropertyScore[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasScoreT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SCORE[NodeType] = new Traversal_Property_SCORE(traversal)
  implicit def accessPropertySignature[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSignatureT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SIGNATURE[NodeType] = new Traversal_Property_SIGNATURE(traversal)
  implicit def accessPropertySinkType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSinkTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SINK_TYPE[NodeType] = new Traversal_Property_SINK_TYPE(traversal)
  implicit def accessPropertySourceType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSourceTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SOURCE_TYPE[NodeType] = new Traversal_Property_SOURCE_TYPE(traversal)
  implicit def accessPropertySpid[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSpidT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SPID[NodeType] = new Traversal_Property_SPID(traversal)
  implicit def accessPropertyStructuredFingerprint[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasStructuredFingerprintT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_STRUCTURED_FINGERPRINT[NodeType] = new Traversal_Property_STRUCTURED_FINGERPRINT(traversal)
  implicit def accessPropertySymbol[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasSymbolT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_SYMBOL[NodeType] = new Traversal_Property_SYMBOL(traversal)
  implicit def accessPropertyTypeDeclFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeDeclFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_TYPE_DECL_FULL_NAME[NodeType] = new Traversal_Property_TYPE_DECL_FULL_NAME(traversal)
  implicit def accessPropertyTypeFullName[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasTypeFullNameT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_TYPE_FULL_NAME[NodeType] = new Traversal_Property_TYPE_FULL_NAME(traversal)
  implicit def accessPropertyUrl[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasUrlT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_URL[NodeType] = new Traversal_Property_URL(traversal)
  implicit def accessPropertyValue[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasValueT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_VALUE[NodeType] = new Traversal_Property_VALUE(traversal)
  implicit def accessPropertyVarargParameter[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVarargParameterT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_VARARG_PARAMETER[NodeType] = new Traversal_Property_VARARG_PARAMETER(traversal)
  implicit def accessPropertyVarType[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVarTypeT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_VAR_TYPE[NodeType] = new Traversal_Property_VAR_TYPE(traversal)
  implicit def accessPropertyVersion[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.HasVersionT]](
    traversal: Iterator[NodeType]
  ): Traversal_Property_VERSION[NodeType] = new Traversal_Property_VERSION(traversal)
}

trait ConcreteBaseConversions extends AbstractBaseConversions0 {
  import Accessors._
  implicit def traversal_AnnotationBase[NodeType <: nodes.AnnotationBase](
    traversal: Iterator[NodeType]
  ): Traversal_AnnotationBase[NodeType] = new Traversal_AnnotationBase(traversal)
  implicit def traversal_AnnotationLiteralBase[NodeType <: nodes.AnnotationLiteralBase](
    traversal: Iterator[NodeType]
  ): Traversal_AnnotationLiteralBase[NodeType] = new Traversal_AnnotationLiteralBase(traversal)
  implicit def traversal_AnnotationParameterBase[NodeType <: nodes.AnnotationParameterBase](
    traversal: Iterator[NodeType]
  ): Traversal_AnnotationParameterBase[NodeType] = new Traversal_AnnotationParameterBase(traversal)
  implicit def traversal_AnnotationParameterAssignBase[NodeType <: nodes.AnnotationParameterAssignBase](
    traversal: Iterator[NodeType]
  ): Traversal_AnnotationParameterAssignBase[NodeType] = new Traversal_AnnotationParameterAssignBase(traversal)
  implicit def traversal_ArrayInitializerBase[NodeType <: nodes.ArrayInitializerBase](
    traversal: Iterator[NodeType]
  ): Traversal_ArrayInitializerBase[NodeType] = new Traversal_ArrayInitializerBase(traversal)
  implicit def traversal_BindingBase[NodeType <: nodes.BindingBase](traversal: Iterator[NodeType]): Traversal_BindingBase[NodeType] =
    new Traversal_BindingBase(traversal)
  implicit def traversal_BlockBase[NodeType <: nodes.BlockBase](traversal: Iterator[NodeType]): Traversal_BlockBase[NodeType] =
    new Traversal_BlockBase(traversal)
  implicit def traversal_CallBase[NodeType <: nodes.CallBase](traversal: Iterator[NodeType]): Traversal_CallBase[NodeType] =
    new Traversal_CallBase(traversal)
  implicit def traversal_CallChainBase[NodeType <: nodes.CallChainBase](traversal: Iterator[NodeType]): Traversal_CallChainBase[NodeType] =
    new Traversal_CallChainBase(traversal)
  implicit def traversal_CallSiteBase[NodeType <: nodes.CallSiteBase](traversal: Iterator[NodeType]): Traversal_CallSiteBase[NodeType] =
    new Traversal_CallSiteBase(traversal)
  implicit def traversal_ClosureBindingBase[NodeType <: nodes.ClosureBindingBase](
    traversal: Iterator[NodeType]
  ): Traversal_ClosureBindingBase[NodeType] = new Traversal_ClosureBindingBase(traversal)
  implicit def traversal_CommentBase[NodeType <: nodes.CommentBase](traversal: Iterator[NodeType]): Traversal_CommentBase[NodeType] =
    new Traversal_CommentBase(traversal)
  implicit def traversal_ConfigFileBase[NodeType <: nodes.ConfigFileBase](
    traversal: Iterator[NodeType]
  ): Traversal_ConfigFileBase[NodeType] = new Traversal_ConfigFileBase(traversal)
  implicit def traversal_ControlStructureBase[NodeType <: nodes.ControlStructureBase](
    traversal: Iterator[NodeType]
  ): Traversal_ControlStructureBase[NodeType] = new Traversal_ControlStructureBase(traversal)
  implicit def traversal_DependencyBase[NodeType <: nodes.DependencyBase](
    traversal: Iterator[NodeType]
  ): Traversal_DependencyBase[NodeType] = new Traversal_DependencyBase(traversal)
  implicit def traversal_DomAttributeBase[NodeType <: nodes.DomAttributeBase](
    traversal: Iterator[NodeType]
  ): Traversal_DomAttributeBase[NodeType] = new Traversal_DomAttributeBase(traversal)
  implicit def traversal_DomNodeBase[NodeType <: nodes.DomNodeBase](traversal: Iterator[NodeType]): Traversal_DomNodeBase[NodeType] =
    new Traversal_DomNodeBase(traversal)
  implicit def traversal_FieldIdentifierBase[NodeType <: nodes.FieldIdentifierBase](
    traversal: Iterator[NodeType]
  ): Traversal_FieldIdentifierBase[NodeType] = new Traversal_FieldIdentifierBase(traversal)
  implicit def traversal_FileBase[NodeType <: nodes.FileBase](traversal: Iterator[NodeType]): Traversal_FileBase[NodeType] =
    new Traversal_FileBase(traversal)
  implicit def traversal_FindingBase[NodeType <: nodes.FindingBase](traversal: Iterator[NodeType]): Traversal_FindingBase[NodeType] =
    new Traversal_FindingBase(traversal)
  implicit def traversal_FlowBase[NodeType <: nodes.FlowBase](traversal: Iterator[NodeType]): Traversal_FlowBase[NodeType] =
    new Traversal_FlowBase(traversal)
  implicit def traversal_FrameworkBase[NodeType <: nodes.FrameworkBase](traversal: Iterator[NodeType]): Traversal_FrameworkBase[NodeType] =
    new Traversal_FrameworkBase(traversal)
  implicit def traversal_FrameworkDataBase[NodeType <: nodes.FrameworkDataBase](
    traversal: Iterator[NodeType]
  ): Traversal_FrameworkDataBase[NodeType] = new Traversal_FrameworkDataBase(traversal)
  implicit def traversal_IdentifierBase[NodeType <: nodes.IdentifierBase](
    traversal: Iterator[NodeType]
  ): Traversal_IdentifierBase[NodeType] = new Traversal_IdentifierBase(traversal)
  implicit def traversal_ImplicitCallBase[NodeType <: nodes.ImplicitCallBase](
    traversal: Iterator[NodeType]
  ): Traversal_ImplicitCallBase[NodeType] = new Traversal_ImplicitCallBase(traversal)
  implicit def traversal_ImportBase[NodeType <: nodes.ImportBase](traversal: Iterator[NodeType]): Traversal_ImportBase[NodeType] =
    new Traversal_ImportBase(traversal)
  implicit def traversal_IoflowBase[NodeType <: nodes.IoflowBase](traversal: Iterator[NodeType]): Traversal_IoflowBase[NodeType] =
    new Traversal_IoflowBase(traversal)
  implicit def traversal_JumpLabelBase[NodeType <: nodes.JumpLabelBase](traversal: Iterator[NodeType]): Traversal_JumpLabelBase[NodeType] =
    new Traversal_JumpLabelBase(traversal)
  implicit def traversal_JumpTargetBase[NodeType <: nodes.JumpTargetBase](
    traversal: Iterator[NodeType]
  ): Traversal_JumpTargetBase[NodeType] = new Traversal_JumpTargetBase(traversal)
  implicit def traversal_KeyValuePairBase[NodeType <: nodes.KeyValuePairBase](
    traversal: Iterator[NodeType]
  ): Traversal_KeyValuePairBase[NodeType] = new Traversal_KeyValuePairBase(traversal)
  implicit def traversal_LiteralBase[NodeType <: nodes.LiteralBase](traversal: Iterator[NodeType]): Traversal_LiteralBase[NodeType] =
    new Traversal_LiteralBase(traversal)
  implicit def traversal_LocalBase[NodeType <: nodes.LocalBase](traversal: Iterator[NodeType]): Traversal_LocalBase[NodeType] =
    new Traversal_LocalBase(traversal)
  implicit def traversal_LocationBase[NodeType <: nodes.LocationBase](traversal: Iterator[NodeType]): Traversal_LocationBase[NodeType] =
    new Traversal_LocationBase(traversal)
  implicit def traversal_MatchInfoBase[NodeType <: nodes.MatchInfoBase](traversal: Iterator[NodeType]): Traversal_MatchInfoBase[NodeType] =
    new Traversal_MatchInfoBase(traversal)
  implicit def traversal_MemberBase[NodeType <: nodes.MemberBase](traversal: Iterator[NodeType]): Traversal_MemberBase[NodeType] =
    new Traversal_MemberBase(traversal)
  implicit def traversal_MetaDataBase[NodeType <: nodes.MetaDataBase](traversal: Iterator[NodeType]): Traversal_MetaDataBase[NodeType] =
    new Traversal_MetaDataBase(traversal)
  implicit def traversal_MethodBase[NodeType <: nodes.MethodBase](traversal: Iterator[NodeType]): Traversal_MethodBase[NodeType] =
    new Traversal_MethodBase(traversal)
  implicit def traversal_MethodInstBase[NodeType <: nodes.MethodInstBase](
    traversal: Iterator[NodeType]
  ): Traversal_MethodInstBase[NodeType] = new Traversal_MethodInstBase(traversal)
  implicit def traversal_MethodParameterInBase[NodeType <: nodes.MethodParameterInBase](
    traversal: Iterator[NodeType]
  ): Traversal_MethodParameterInBase[NodeType] = new Traversal_MethodParameterInBase(traversal)
  implicit def traversal_MethodParameterOutBase[NodeType <: nodes.MethodParameterOutBase](
    traversal: Iterator[NodeType]
  ): Traversal_MethodParameterOutBase[NodeType] = new Traversal_MethodParameterOutBase(traversal)
  implicit def traversal_MethodRefBase[NodeType <: nodes.MethodRefBase](traversal: Iterator[NodeType]): Traversal_MethodRefBase[NodeType] =
    new Traversal_MethodRefBase(traversal)
  implicit def traversal_MethodReturnBase[NodeType <: nodes.MethodReturnBase](
    traversal: Iterator[NodeType]
  ): Traversal_MethodReturnBase[NodeType] = new Traversal_MethodReturnBase(traversal)
  implicit def traversal_MethodSummaryBase[NodeType <: nodes.MethodSummaryBase](
    traversal: Iterator[NodeType]
  ): Traversal_MethodSummaryBase[NodeType] = new Traversal_MethodSummaryBase(traversal)
  implicit def traversal_ModifierBase[NodeType <: nodes.ModifierBase](traversal: Iterator[NodeType]): Traversal_ModifierBase[NodeType] =
    new Traversal_ModifierBase(traversal)
  implicit def traversal_NamespaceBase[NodeType <: nodes.NamespaceBase](traversal: Iterator[NodeType]): Traversal_NamespaceBase[NodeType] =
    new Traversal_NamespaceBase(traversal)
  implicit def traversal_NamespaceBlockBase[NodeType <: nodes.NamespaceBlockBase](
    traversal: Iterator[NodeType]
  ): Traversal_NamespaceBlockBase[NodeType] = new Traversal_NamespaceBlockBase(traversal)
  implicit def traversal_PackagePrefixBase[NodeType <: nodes.PackagePrefixBase](
    traversal: Iterator[NodeType]
  ): Traversal_PackagePrefixBase[NodeType] = new Traversal_PackagePrefixBase(traversal)
  implicit def traversal_PostExecutionCallBase[NodeType <: nodes.PostExecutionCallBase](
    traversal: Iterator[NodeType]
  ): Traversal_PostExecutionCallBase[NodeType] = new Traversal_PostExecutionCallBase(traversal)
  implicit def traversal_ProgramPointBase[NodeType <: nodes.ProgramPointBase](
    traversal: Iterator[NodeType]
  ): Traversal_ProgramPointBase[NodeType] = new Traversal_ProgramPointBase(traversal)
  implicit def traversal_ReadBase[NodeType <: nodes.ReadBase](traversal: Iterator[NodeType]): Traversal_ReadBase[NodeType] =
    new Traversal_ReadBase(traversal)
  implicit def traversal_ReturnBase[NodeType <: nodes.ReturnBase](traversal: Iterator[NodeType]): Traversal_ReturnBase[NodeType] =
    new Traversal_ReturnBase(traversal)
  implicit def traversal_RouteBase[NodeType <: nodes.RouteBase](traversal: Iterator[NodeType]): Traversal_RouteBase[NodeType] =
    new Traversal_RouteBase(traversal)
  implicit def traversal_SensitiveDataTypeBase[NodeType <: nodes.SensitiveDataTypeBase](
    traversal: Iterator[NodeType]
  ): Traversal_SensitiveDataTypeBase[NodeType] = new Traversal_SensitiveDataTypeBase(traversal)
  implicit def traversal_SensitiveMemberBase[NodeType <: nodes.SensitiveMemberBase](
    traversal: Iterator[NodeType]
  ): Traversal_SensitiveMemberBase[NodeType] = new Traversal_SensitiveMemberBase(traversal)
  implicit def traversal_SensitiveReferenceBase[NodeType <: nodes.SensitiveReferenceBase](
    traversal: Iterator[NodeType]
  ): Traversal_SensitiveReferenceBase[NodeType] = new Traversal_SensitiveReferenceBase(traversal)
  implicit def traversal_SensitiveVariableBase[NodeType <: nodes.SensitiveVariableBase](
    traversal: Iterator[NodeType]
  ): Traversal_SensitiveVariableBase[NodeType] = new Traversal_SensitiveVariableBase(traversal)
  implicit def traversal_SinkBase[NodeType <: nodes.SinkBase](traversal: Iterator[NodeType]): Traversal_SinkBase[NodeType] =
    new Traversal_SinkBase(traversal)
  implicit def traversal_SourceBase[NodeType <: nodes.SourceBase](traversal: Iterator[NodeType]): Traversal_SourceBase[NodeType] =
    new Traversal_SourceBase(traversal)
  implicit def traversal_SpAnnotationParameterBase[NodeType <: nodes.SpAnnotationParameterBase](
    traversal: Iterator[NodeType]
  ): Traversal_SpAnnotationParameterBase[NodeType] = new Traversal_SpAnnotationParameterBase(traversal)
  implicit def traversal_SpBlacklistBase[NodeType <: nodes.SpBlacklistBase](
    traversal: Iterator[NodeType]
  ): Traversal_SpBlacklistBase[NodeType] = new Traversal_SpBlacklistBase(traversal)
  implicit def traversal_TagBase[NodeType <: nodes.TagBase](traversal: Iterator[NodeType]): Traversal_TagBase[NodeType] =
    new Traversal_TagBase(traversal)
  implicit def traversal_TagsBase[NodeType <: nodes.TagsBase](traversal: Iterator[NodeType]): Traversal_TagsBase[NodeType] =
    new Traversal_TagsBase(traversal)
  implicit def traversal_TagNodePairBase[NodeType <: nodes.TagNodePairBase](
    traversal: Iterator[NodeType]
  ): Traversal_TagNodePairBase[NodeType] = new Traversal_TagNodePairBase(traversal)
  implicit def traversal_TemplateDomBase[NodeType <: nodes.TemplateDomBase](
    traversal: Iterator[NodeType]
  ): Traversal_TemplateDomBase[NodeType] = new Traversal_TemplateDomBase(traversal)
  implicit def traversal_TransformBase[NodeType <: nodes.TransformBase](traversal: Iterator[NodeType]): Traversal_TransformBase[NodeType] =
    new Traversal_TransformBase(traversal)
  implicit def traversal_TransformationBase[NodeType <: nodes.TransformationBase](
    traversal: Iterator[NodeType]
  ): Traversal_TransformationBase[NodeType] = new Traversal_TransformationBase(traversal)
  implicit def traversal_TypeBase[NodeType <: nodes.TypeBase](traversal: Iterator[NodeType]): Traversal_TypeBase[NodeType] =
    new Traversal_TypeBase(traversal)
  implicit def traversal_TypeArgumentBase[NodeType <: nodes.TypeArgumentBase](
    traversal: Iterator[NodeType]
  ): Traversal_TypeArgumentBase[NodeType] = new Traversal_TypeArgumentBase(traversal)
  implicit def traversal_TypeDeclBase[NodeType <: nodes.TypeDeclBase](traversal: Iterator[NodeType]): Traversal_TypeDeclBase[NodeType] =
    new Traversal_TypeDeclBase(traversal)
  implicit def traversal_TypeParameterBase[NodeType <: nodes.TypeParameterBase](
    traversal: Iterator[NodeType]
  ): Traversal_TypeParameterBase[NodeType] = new Traversal_TypeParameterBase(traversal)
  implicit def traversal_TypeRefBase[NodeType <: nodes.TypeRefBase](traversal: Iterator[NodeType]): Traversal_TypeRefBase[NodeType] =
    new Traversal_TypeRefBase(traversal)
  implicit def traversal_UnknownBase[NodeType <: nodes.UnknownBase](traversal: Iterator[NodeType]): Traversal_UnknownBase[NodeType] =
    new Traversal_UnknownBase(traversal)
  implicit def traversal_VariableInfoBase[NodeType <: nodes.VariableInfoBase](
    traversal: Iterator[NodeType]
  ): Traversal_VariableInfoBase[NodeType] = new Traversal_VariableInfoBase(traversal)
  implicit def traversal_VulnerabilityBase[NodeType <: nodes.VulnerabilityBase](
    traversal: Iterator[NodeType]
  ): Traversal_VulnerabilityBase[NodeType] = new Traversal_VulnerabilityBase(traversal)
  implicit def traversal_WriteBase[NodeType <: nodes.WriteBase](traversal: Iterator[NodeType]): Traversal_WriteBase[NodeType] =
    new Traversal_WriteBase(traversal)
}

trait AbstractBaseConversions0 extends AbstractBaseConversions1 {
  import Accessors._
  implicit def traversal_AstNodeBase[NodeType <: nodes.AstNodeBase](traversal: Iterator[NodeType]): Traversal_AstNodeBase[NodeType] =
    new Traversal_AstNodeBase(traversal)
  implicit def traversal_CallReprBase[NodeType <: nodes.CallReprBase](traversal: Iterator[NodeType]): Traversal_CallReprBase[NodeType] =
    new Traversal_CallReprBase(traversal)
  implicit def traversal_CfgNodeBase[NodeType <: nodes.CfgNodeBase](traversal: Iterator[NodeType]): Traversal_CfgNodeBase[NodeType] =
    new Traversal_CfgNodeBase(traversal)
  implicit def traversal_ExpressionBase[NodeType <: nodes.ExpressionBase](
    traversal: Iterator[NodeType]
  ): Traversal_ExpressionBase[NodeType] = new Traversal_ExpressionBase(traversal)
}

trait AbstractBaseConversions1 extends AbstractBaseConversions2 {
  import Accessors._
  implicit def traversal_DeclarationBase[NodeType <: nodes.DeclarationBase](
    traversal: Iterator[NodeType]
  ): Traversal_DeclarationBase[NodeType] = new Traversal_DeclarationBase(traversal)
  implicit def traversal_TrackingPointBase[NodeType <: nodes.TrackingPointBase](
    traversal: Iterator[NodeType]
  ): Traversal_TrackingPointBase[NodeType] = new Traversal_TrackingPointBase(traversal)
}

trait AbstractBaseConversions2 {
  import Accessors._
  implicit def traversal_LocalLikeBase[NodeType <: nodes.LocalLikeBase](traversal: Iterator[NodeType]): Traversal_LocalLikeBase[NodeType] =
    new Traversal_LocalLikeBase(traversal)
}
