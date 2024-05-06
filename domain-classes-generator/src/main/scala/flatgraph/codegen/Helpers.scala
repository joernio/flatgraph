package flatgraph.codegen

import java.lang.System.lineSeparator
import flatgraph.algorithm.LowestCommonAncestors
import flatgraph.schema._
import flatgraph.schema.Helpers._
import flatgraph.schema.Property.ValueType

object Helpers {

  /* surrounds input with `"` */
  def quoted(strings: Iterable[String]): Iterable[String] =
    strings.map(quote)

  def quote(string: String): String =
    s""""$string""""

  def scaladocMaybe(comment: Option[String]): String =
    comment.filter(_.nonEmpty).map(content => s"/** $content */").getOrElse("")

  def typeFor[A](property: Property[A]): String = {
    val isMandatory = property.isMandatory
    property.valueType match {
      case ValueType.Boolean => if (isMandatory) "Boolean" else "java.lang.Boolean"
      case ValueType.String  => "String"
      case ValueType.Byte    => if (isMandatory) "Byte" else "java.lang.Byte"
      case ValueType.Short   => if (isMandatory) "Short" else "java.lang.Short"
      case ValueType.Int     => if (isMandatory) "scala.Int" else "Integer"
      case ValueType.Long    => if (isMandatory) "Long" else "java.lang.Long"
      case ValueType.Float   => if (isMandatory) "Float" else "java.lang.Float"
      case ValueType.Double  => if (isMandatory) "Double" else "java.lang.Double"
      case ValueType.Char    => if (isMandatory) "scala.Char" else "Character"
      case ValueType.List    => "Seq[_]"
      case ValueType.NodeRef => "flatgraph.NodeRef[_]"
      case ValueType.Unknown => "java.lang.Object"
    }
  }

  def accessorName(neighborInfoForNode: NeighborInfoForNode): String = {
    neighborInfoForNode.customStepName.getOrElse {
      val neighborNodeName = neighborInfoForNode.neighborNode.name
      val edgeName         = neighborInfoForNode.edge.className
      val direction        = neighborInfoForNode.direction.toString
      s"_${camelCase(neighborNodeName)}Via$edgeName${camelCaseCaps(direction)}"
    }
  }

  def docAnnotationMaybe(customStepDoc: Option[String]): String = {
    customStepDoc.map(escapeJava) match {
      case Some(doc) =>
        s"""/** $doc */
           |@flatgraph.traversal.help.Doc(info = \"\"\"$doc\"\"\")""".stripMargin
      case None => ""
    }
  }

  /** escape things like quotes, backslashes, end of comment ('* /' without the space) etc. */
  def escapeJava(src: String): String = {
    src
      .replace("\"", "\\\"")
      .replace("/*", "\\/\\*")
      .replace("*/", "\\*\\/")
  }

  def isNodeBaseTrait(baseTraits: Seq[NodeBaseType], nodeName: String): Boolean =
    nodeName == DefaultNodeTypes.AbstractNodeName || baseTraits.map(_.name).contains(nodeName)

  def singularize(str: String): String =
    flatgraph.schema.Helpers.singularize(str)

  def snakeCase(camelCase: String): String =
    flatgraph.schema.Helpers.snakeCase(camelCase)

  def getCompleteType[A](property: Property[?]): String =
    getCompleteType(property.cardinality, typeFor(property))

  def typeFor(containedNode: ContainedNode): String = {
    containedNode.nodeType match {
      case anyNode: AnyNodeType => "AbstractNode"
      case nodeType =>
        val className = containedNode.nodeType.className
        if (DefaultNodeTypes.AllClassNames.contains(className)) className
        else className + "Base"
    }
  }

  def getCompleteType(containedNode: ContainedNode): String =
    getCompleteType(containedNode.cardinality, typeFor(containedNode))

  def getCompleteType(cardinality: Property.Cardinality, valueType: String): String = {
    import Property.Cardinality
    cardinality match {
      case Cardinality.One(_)    => valueType
      case Cardinality.ZeroOrOne => s"Option[$valueType]"
      case Cardinality.List      => s"IndexedSeq[$valueType]"
    }
  }

  def propertyKeyDef(name: String, baseType: String, cardinality: Property.Cardinality) = {
    val completeType = cardinality match {
      case Property.Cardinality.One(_)    => baseType
      case Property.Cardinality.ZeroOrOne => baseType
      case Property.Cardinality.List      => s"IndexedSeq[$baseType]"
    }
    s"""val ${camelCaseCaps(name)} = new flatgraph.PropertyKey[$completeType]("$name") """
  }

  def defaultValueImpl[A](default: Property.Default[A]): String =
    default.value match {
      case str: String                    => s"$quotes$str$quotes"
      case char: Char                     => s"'$char'"
      case byte: Byte                     => s"$byte: Byte"
      case short: Short                   => s"$short: Short"
      case int: Int                       => s"$int: Int"
      case long: Long                     => s"$long: Long"
      case float: Float if float.isNaN    => "Float.NaN"
      case float: Float                   => s"${float}f"
      case double: Double if double.isNaN => "Double.NaN"
      case double: Double                 => s"${double}d"
      case other                          => s"$other"
    }

  def defaultValueCheckImpl[A](memberName: String, default: Property.Default[A]): String = {
    val defaultValueSrc = defaultValueImpl(default)
    default.value match {
      case float: Float if float.isNaN    => s"$memberName.isNaN"
      case double: Double if double.isNaN => s"$memberName.isNaN"
      case _                              => s"($defaultValueSrc) == $memberName"
    }
  }

  def propertyDefaultValueImpl(propertyDefaultsPath: String, properties: Seq[Property[?]]): String = {
    val propertyDefaultValueCases = properties
      .collect {
        case property if property.hasDefault =>
          s"""case "${property.name}" => $propertyDefaultsPath.${property.className}"""
      }
      .mkString(lineSeparator)

    s"""override def propertyDefaultValue(propertyKey: String) =
       |  propertyKey match {
       |    $propertyDefaultValueCases
       |    case _ => super.propertyDefaultValue(propertyKey)
       |}
       |""".stripMargin
  }

  def propertyDefaultCases(properties: Seq[Property[?]]): String = {
    properties
      .collect {
        case p if p.hasDefault =>
          s"""val ${p.className} = ${defaultValueImpl(p.default.get)}"""
      }
      .mkString(s"$lineSeparator|    ")
  }

  def propertyAccessors(properties: Seq[Property[?]]): String = {
    properties
      .map { property =>
        val camelCaseName = camelCase(property.name)
        val tpe           = getCompleteType(property)
        s"def $camelCaseName: $tpe"
      }
      .mkString(lineSeparator)
  }

  /** obtained from repl via
    * {{{
    * :power
    * nme.keywords
    * }}}
    */
  val scalaReservedKeywords = Set(
    "abstract",
    ">:",
    "if",
    ".",
    "catch",
    "protected",
    "final",
    "super",
    "while",
    "true",
    "val",
    "do",
    "throw",
    "<-",
    "package",
    "_",
    "macro",
    "@",
    "object",
    "false",
    "this",
    "then",
    "var",
    "trait",
    "with",
    "def",
    "else",
    "class",
    "type",
    "#",
    "lazy",
    "null",
    "=",
    "<:",
    "override",
    "=>",
    "private",
    "sealed",
    "finally",
    "new",
    "implicit",
    "extends",
    "for",
    "return",
    "case",
    "import",
    "forSome",
    ":",
    "yield",
    "try",
    "match",
    "<%"
  )

  def escapeIfKeyword(value: String) =
    if (scalaReservedKeywords.contains(value)) s"`$value`"
    else value

  def fullScalaType(neighborNode: AbstractNodeType, cardinality: EdgeType.Cardinality): String = {
    val neighborNodeClass = neighborNode.className
    cardinality match {
      case EdgeType.Cardinality.List      => s"flatgraph.traversal.Traversal[$neighborNodeClass]"
      case EdgeType.Cardinality.ZeroOrOne => s"Option[$neighborNodeClass]"
      case EdgeType.Cardinality.One       => s"$neighborNodeClass"
    }
  }

  def deriveCommonRootType(neighborNodeInfos: Set[AbstractNodeType]): Option[AbstractNodeType] = {
    lowestCommonAncestor(neighborNodeInfos)
      .orElse(findSharedRoot(neighborNodeInfos))
  }

  /** In theory there can be multiple candidates - we're just returning one of those for now. We want the results to be stable between
    * different codegen runs, so we simply return the first in alphabetical order...
    */
  def lowestCommonAncestor(nodes: Set[AbstractNodeType]): Option[AbstractNodeType] = {
    LowestCommonAncestors(nodes)(_.extendzRecursively.toSet).toSeq.sortBy(_.name).headOption
  }

  /** from the given node types, find one that is part of the complete type hierarchy of *all* other node types */
  def findSharedRoot(nodeTypes: Set[AbstractNodeType]): Option[AbstractNodeType] = {
    if (nodeTypes.size == 1) {
      Some(nodeTypes.head)
    } else if (nodeTypes.size > 1) {
      // trying to keep it deterministic...
      val sorted              = nodeTypes.toSeq.sortBy(_.className)
      val (first, otherNodes) = (sorted.head, sorted.tail)
      completeTypeHierarchy(first).find { candidate =>
        otherNodes.forall { otherNode =>
          completeTypeHierarchy(otherNode).contains(candidate)
        }
      }
    } else {
      None
    }
  }

  def completeTypeHierarchy(node: AbstractNodeType): Seq[AbstractNodeType] =
    node +: node.extendzRecursively

  val quotes = '"'
}
