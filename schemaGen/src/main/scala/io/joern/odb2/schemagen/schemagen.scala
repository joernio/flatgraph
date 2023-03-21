package io.joern.odb2.schemagen

import overflowdb.codegen.Helpers
import overflowdb.schema.Property
import overflowdb.schema.Property.{Cardinality, Default, ValueType}

import scala.collection.mutable

object SchemaGen {
  def main(args: Array[String]): Unit = {
    val schema = args(1) match {
      case "cpg" => io.shiftleft.codepropertygraph.schema.CpgSchema.instance
      case "cs"  => io.shiftleft.codepropertygraph.schema.CpgExtSchema.instance
    }
    val outputDir   = better.files.File(args(0))
    val basePackage = schema.basePackage + ".v2"

    val nodeTypes  = schema.nodeTypes.sortBy(_.name).toArray
    val kindByNode = nodeTypes.zipWithIndex.toMap

    val actualPropertiesSet   = mutable.HashSet[overflowdb.schema.Property[_]]()
    val containingByName      = mutable.HashMap[String, mutable.HashSet[overflowdb.schema.NodeType]]()
    val containedIndexByName  = mutable.HashMap[String, Int]()
    val forbiddenSlotsByIndex = mutable.ArrayBuffer[mutable.HashSet[overflowdb.schema.NodeType]]()

    for (node <- nodeTypes) {
      actualPropertiesSet.addAll(node.properties)
      for (contained <- node.containedNodes) {
        containingByName.getOrElseUpdate(contained.localName, mutable.HashSet[overflowdb.schema.NodeType]()).add(node)
      }
    }
    // we need to assign non-conflicting indices to each containedNode. Knapsack!
    for ((name, containing) <- containingByName.toList.sortBy { case (n, c) => (-c.size, n) }) {
      forbiddenSlotsByIndex.iterator.zipWithIndex.find { case (forbidden, idx) =>
        forbidden.intersect(containing).isEmpty
      } match {
        case Some((oldforbidden, idx)) =>
          containedIndexByName(name) = idx
          oldforbidden.addAll(containing)
        case None =>
          containedIndexByName(name) = forbiddenSlotsByIndex.length
          forbiddenSlotsByIndex.append(containing.filter { _ => true })
      }
    }
    for (bt <- schema.nodeBaseTypes) {
      actualPropertiesSet.addAll(bt.properties)
    }

    if (
      actualPropertiesSet.size != actualPropertiesSet.map {
        _.name
      }.size
    ) {
      println(actualPropertiesSet.toList.sortBy {
        _.name
      })
      println(
        actualPropertiesSet
          .map {
            _.name
          }
          .toList
          .sorted
      )
      ???
    }
    val actualProperties = actualPropertiesSet.toArray.sortBy {
      _.name
    }
    val idByProperty                 = actualProperties.zipWithIndex.toMap
    val propertyOrContainedByNumbers = mutable.HashMap[(Int, Int), Any]()
    for (node <- schema.nodeTypes) {
      for (c <- node.containedNodes) {
        val containedId = containedIndexByName(c.localName)
        propertyOrContainedByNumbers((kindByNode(node), actualProperties.size + containedId)) = c
      }
      for (p <- node.properties) {
        propertyOrContainedByNumbers((kindByNode(node), idByProperty(p))) = p
      }
    }
    val edgeTypes    = schema.edgeTypes.sortBy(_.name).toArray
    val edgeIdByType = edgeTypes.zipWithIndex.toMap

    // base file
    val edgeAccess = edgeTypes
      .map { et =>
        s"""final def _${Helpers.camelCase(
            et.name
          )}Out: IndexedSeq[StoredNode] = odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, ${edgeIdByType(
            et
          )}).asInstanceOf[IndexedSeq[StoredNode]]
         |final def _${Helpers.camelCase(
            et.name
          )}In: IndexedSeq[StoredNode] = odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, ${edgeIdByType(
            et
          )}).asInstanceOf[IndexedSeq[StoredNode]]
         |""".stripMargin
      }
      .mkString("\n")
    val userMarkers = schema.allNodeTypes
      .flatMap {
        _.markerTraits
      }
      .distinct
      .map { case overflowdb.schema.MarkerTrait(name) => s"trait $name" }
      .sorted
      .mkString("\n")

    val basefile =
      s"""package ${basePackage}.nodes
         |import io.joern.odb2
         |
         |trait StaticType[+T]
         |
         |trait AbstractNode extends odb2.DNodeOrNode with StaticType[AnyRef]
         |
         |abstract class StoredNode(graph_4762: odb2.Graph, kind_4762: Short, seq_4762: Int) extends odb2.GNode(graph_4762, kind_4762, seq_4762) with AbstractNode {
         |${edgeAccess}
         |}
         |
         |abstract class NewNode extends AbstractNode with odb2.DNode
         |""".stripMargin
    outputDir.createChild("RootTypes.scala").write(basefile)

    val propertyMarkers = actualProperties.map { p => s"trait Has${p.className}T" }.mkString("\n")
    val basetypefile = schema.nodeBaseTypes
      .map { baseType =>
        val newExtendz = (baseType.extendz.toSet &~ baseType.extendz.flatMap { p => p.extendzRecursively }.toSet).toList.sortBy {
          _.name
        }
        val mixinsBase = List("AbstractNode") ++ newExtendz.map(_.className + "Base") ++ baseType.markerTraits.map(_.name)

        val mixinsStored =
          List("StoredNode", s"${baseType.className}Base") ++ newExtendz.map(_.className) ++ baseType.markerTraits.map(_.name)
        val mixinsNew =
          List("NewNode", s"${baseType.className}Base") ++ baseType.extendz.map(_.className + "New") ++ baseType.markerTraits.map(_.name)
        val newProperties = (baseType.properties.toSet &~ baseType.extendzRecursively.flatMap {
          _.properties
        }.toSet).toList.sortBy {
          _.name
        }
        val mixinsT =
          (List("AnyRef") ++ newExtendz.map { _.className + "T" } ++ newProperties.map { p => s"Has${p.className}T" }).mkString(" with ")
        val oldProperties = (baseType.properties.toSet &~ newProperties.toSet).toList.sortBy {
          _.name
        }
        val oldExtendz = (baseType.extendzRecursively.toSet &~ newExtendz.toSet).toList.sortBy {
          _.name
        }
        val accessors = newProperties
          .map { p =>
            val pre = s"def ${Helpers.camelCase(p.name)}: ${typeForProperty(p)}"
            /*
            val access = p.cardinality match {
              case Cardinality.ZeroOrOne =>
                s" = odb2.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}]((this: StoredNode).graph, (this: StoredNode).nodeKind, ${idByProperty(p)}, (this: StoredNode).seq)"
              case Cardinality.List =>
                s" = odb2.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}]((this: StoredNode).graph, (this: StoredNode).nodeKind, ${idByProperty(p)}, (this: StoredNode).seq)"
              case _: Cardinality.One[_] =>
                s" = odb2.Accessors.getNodePropertySingle[${unpackTypeUnboxed(p.valueType, true, false)}]((this: StoredNode).graph, (this: StoredNode).nodeKind, ${idByProperty(p)}, (this: StoredNode).seq)"
            } */
            pre // + access
          }
          .mkString("\n")

        s"""trait ${baseType.className}T extends ${mixinsT}
           |
           |trait ${baseType.className}Base extends ${mixinsBase.mkString(" with ")} with StaticType[${baseType.className}T]
           | // new properties: ${newProperties.map { _.name }.mkString(", ")}
           | // inherited properties: ${oldProperties.map { _.name }.mkString(", ")}
           | // inherited interfaces: ${oldExtendz
            .map {
              _.name
            }
            .mkString(", ")}
           | // implementing nodes: ${nodeTypes
            .filter { n => n.extendzRecursively.contains(baseType) }
            .map {
              _.name
            }
            .mkString(", ")}
           |trait ${baseType.className} extends ${mixinsStored
            .mkString(" with ")} with StaticType[${baseType.className}T] {
            |//{accessors}
            |}
           |
           |trait ${baseType.className}New extends ${mixinsNew.mkString(" with ")} with StaticType[${baseType.className}T]
           |""".stripMargin
      }
      .mkString(
        s"""package ${basePackage}.nodes
           |import io.joern.odb2
           |
           |
           |""".stripMargin,
        "\n\n",
        s"\n${userMarkers}\n${propertyMarkers}\n"
      )
    outputDir.createChild("BaseTypes.scala").write(basetypefile)

    val edgeTypes_ = edgeTypes.iterator.zipWithIndex
      .map { case (edgeType, idx) =>
        if (edgeType.properties.length > 1) throw new RuntimeException("we only support zero or one edge properties")

        val acceesor = if (edgeType.properties.length == 1) {
          val p = edgeType.properties.head
          p.cardinality match {
            case _: Cardinality.One[_] =>
              s"""{
                 |  def ${Helpers.camelCase(p.name)}: ${unpackTypeUnboxed(
                  p.valueType,
                  true
                )} = this.property.asInstanceOf[${unpackTypeUnboxed(p.valueType, true)}]
                 |}""".stripMargin
            case Cardinality.ZeroOrOne =>
              s"""{
                 |  def ${Helpers.camelCase(p.name)}: Option[${unpackTypeUnboxed(
                  p.valueType,
                  true
                )}] = Option(this.property.asInstanceOf[${unpackTypeBoxed(p.valueType, true)}])
                 |}""".stripMargin
            case Cardinality.List => throw new RuntimeException("edge properties are only supported with cardinality one or optional")
          }

        } else ""

        s"""class ${edgeType.className}(src_4762: odb2.GNode, dst_4762: odb2.GNode, subSeq_4862: Int, property_4862: Any)
           |    extends odb2.Edge(src_4762, dst_4762, ${idx}.toShort, subSeq_4862, property_4862) ${acceesor}""".stripMargin
      }
      .mkString(
        s"""package ${basePackage}.edges
           |import io.joern.odb2
           |
           |""".stripMargin,
        "\n",
        "\n"
      )
    outputDir.createChild("EdgeTypes.scala").write(edgeTypes_)

    val concreteNodes = nodeTypes.iterator.zipWithIndex
      .map { case (nodeType, kind) =>
        val newExtendz = (nodeType.extendz.toSet &~ nodeType.extendz.flatMap { p => p.extendzRecursively }.toSet).toList.sortBy {
          _.name
        }
        val newProperties = (nodeType.properties.toSet &~ nodeType.extendzRecursively.flatMap {
          _.properties
        }.toSet).toList.sortBy {
          _.name
        }
        val staticTyp =
          (s"""trait ${nodeType.className}T extends AnyRef""" +: newExtendz.map { b => s"${b.className}T" } ++: newProperties.map { p =>
            s"Has${p.className}T"
          }).mkString(" with ")
        val stored =
          (s"""class ${nodeType.className}(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, ${kind}.toShort , seq_4762)""" +: newExtendz
            .map { base => base.className } ++: List(s"StaticType[${nodeType.className}T]")).mkString(" with ")
        // val base = (s"""class ${nodeType.className}""")
        val propAccess = nodeType.properties
          .map { p =>
            val pre = s"def ${Helpers.camelCase(p.name)}: ${typeForProperty(p)}"
            val access = p.cardinality match {
              case Cardinality.ZeroOrOne =>
                s" = odb2.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}](graph, nodeKind, ${idByProperty(p)}, seq)"
              case Cardinality.List =>
                s" = odb2.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}](graph, nodeKind, ${idByProperty(p)}, seq)"
              case one: Cardinality.One[_] =>
                s" = odb2.Accessors.getNodePropertySingle(graph, nodeKind, ${idByProperty(p)}, seq, ${unpackDefault(p.valueType, one.default)})"
            }
            pre + access
          }
          .mkString("\n")
        val containedAccess = nodeType.containedNodes
          .map { contained =>
            s"""def ${contained.localName}: ${contained.cardinality match {
                case Cardinality.ZeroOrOne =>
                  s"Option[${contained.nodeType.className}] = odb2.Accessors.getNodePropertyOption[${contained.nodeType.className}](graph, nodeKind, ${actualProperties.size + containedIndexByName(contained.localName)}, seq)"
                case _: Cardinality.One[_] =>
                  s"${contained.nodeType.className} = odb2.Accessors.getNodePropertySingle(graph, nodeKind, ${actualProperties.size + containedIndexByName(
                      contained.localName
                    )}, seq, null: ${contained.nodeType.className})"
                case Cardinality.List =>
                  s"IndexedSeq[${contained.nodeType.className}] = odb2.Accessors.getNodePropertyMulti[${contained.nodeType.className}](graph, nodeKind, ${actualProperties.size + containedIndexByName(contained.localName)}, seq)"
              }}""".stripMargin
          }
          .mkString("\n")

        s"""${staticTyp}
           |${stored} {
           |//{propAccess}
           |${containedAccess}
           |}""".stripMargin
      }
      .mkString(
        s"""package ${basePackage}.nodes
           |import io.joern.odb2
           |
           |""".stripMargin,
        "\n\n",
        ""
      )
    outputDir.createChild("NodeTypes.scala").write(concreteNodes)

    val schemaFile =
      s"""package ${basePackage}
         |import io.joern.odb2
         |import ${basePackage}.nodes
         |import ${basePackage}.edges
         |
         |object GraphSchema extends odb2.Schema {
         |  val nodeLabels = Array(${kindByNode.iterator.toList
          .sortBy {
            _._2
          }
          .map { n => s"\"${n._1.name}\"" }
          .mkString(", ")})
         |  val nodeIdByLabel = nodeLabels.zipWithIndex.toMap
         |  val edgeLabels = Array(${edgeTypes.zipWithIndex.map { e => s"\"${e._1.name}\"" }.mkString(",  ")})
         |  val edgeIdByLabel = edgeLabels.zipWithIndex.toMap
         |  val edgePropertyAllocators: Array[Int => Array[_]] = Array(${edgeTypes.zipWithIndex
          .map { e =>
            e._1.properties.headOption match {
              case Some(p) if p.cardinality == Cardinality.ZeroOrOne => ???
              case Some(p) =>
                s"size => Array.fill(size)(${Helpers.defaultValueImpl(p.cardinality.asInstanceOf[Cardinality.One[_]].default)}) /*label = ${e._1.name}, id = ${e._2}*/"
              case None => "size => null"
            }
          }
          .mkString(", ")})
         |  val nodeFactories: Array[(odb2.Graph, Int) => nodes.StoredNode] = Array(${nodeTypes
          .map { node => s"(g, seq) => new nodes.${node.className}(g, seq)" }
          .mkString(", ")})
         |  val edgeFactories: Array[(odb2.GNode, odb2.GNode, Int, Any) => odb2.Edge] = Array(${edgeTypes
          .map { e => s"(s, d, subseq, p) => new edges.${e.className}(s, d, subseq, p)" }
          .mkString(", ")})
         |  val nodePropertyAllocators: Array[Int => Array[_]] = Array(${(actualProperties.map { p =>
          s"size => new Array[${unpackTypeUnboxed(p.valueType, true, raised = true)}](size)"
        }.iterator ++ forbiddenSlotsByIndex.map { _ => "size => new Array[odb2.GNode](size)" }).mkString(", ")})
         |  val normalNodePropertyNames = Array(${actualProperties.map { p => s"\"${p.name}\"" }.mkString(", ")})
         |  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap${containedIndexByName.toList
          .sortBy { kv => (kv._2, kv._1) }
          .map { kv => s".updated(\"${kv._1}\", ${actualProperties.size + kv._2})" }
          .mkString}
         |
         | override def getNumberOfNodeKinds: Int = ${nodeTypes.length}
         | override def getNumberOfEdgeKinds: Int = ${edgeTypes.length}
         | override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
         | override def getNodeIdByLabel(label: String): Int = nodeIdByLabel.getOrElse(label, -1)
         | override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
         | override def getEdgeIdByLabel(label: String): Int = edgeIdByLabel.getOrElse(label, -1)
         | override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String =
         |    if(propertyKind < ${actualProperties.length}) normalNodePropertyNames(propertyKind)
         |${nodeTypes
          .flatMap { nt =>
            nt.containedNodes.map {
              (nt, _)
            }
          }
          .map { case (node, contained) =>
            s"    else if(propertyKind == ${actualProperties.length + containedIndexByName(
                contained.localName
              )} && nodeKind == ${kindByNode(node)}) \"${contained.localName}\" /*on node ${node.name}*/"
          }
          .toList
          .sorted
          .mkString("\n")}
         |    else null
         | 
         | override def getPropertyIdByLabel(label: String): Int = nodePropertyByLabel.getOrElse(label, -1)
         | override def getNumberOfProperties: Int = ${actualProperties.size + forbiddenSlotsByIndex.size}
         | override def makeNode(graph: odb2.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
         | override def makeEdge(src: odb2.GNode, dst: odb2.GNode, edgeKind: Short, subSeq: Int, property: Any): odb2.Edge = edgeFactories(edgeKind)(src, dst, subSeq, property)
         | override def allocateEdgeProperty(nodeKind: Int, inout: Int, edgeKind: Int, size: Int): Array[_] = edgePropertyAllocators(edgeKind)(size)
         | override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_] = nodePropertyAllocators(propertyKind)(size)
         |}""".stripMargin
    outputDir.createChild("GraphSchema.scala").write(schemaFile)

    /*
    val containedAccessorClassesAndNode = mutable.ArrayBuffer[(String, String)]()
    val containedAccessors = nodeTypes
      .flatMap { nt =>
        nt.containedNodes.map {
          (nt, _)
        }
      }
      .map { case (node, contained) =>
        val cc = s"Access_contained_${contained.localName}_${node.name}"
        containedAccessorClassesAndNode.append((cc, node.name))
        s"""class ${cc}(val containingNode: nodes.StoredNode) extends AnyVal {
           |  def ${contained.localName}: ${contained.cardinality match {
            case Cardinality.ZeroOrOne =>
              s"Option[nodes.${contained.nodeType.className}] = odb2.Accessors.getNodePropertyOption[nodes.${contained.nodeType.className}](containingNode.graph, containingNode.nodeKind, ${actualProperties.size + containedIndexByName(contained.localName)}, containingNode.seq)"
            case _: Cardinality.One[_] =>
              s"nodes.${contained.nodeType.className} = odb2.Accessors.getNodePropertySingle[nodes.${contained.nodeType.className}](containingNode.graph, containingNode.nodeKind, ${actualProperties.size + containedIndexByName(contained.localName)}, containingNode.seq)"
            case Cardinality.List =>
              s"IndexedSeq[nodes.${contained.nodeType.className}] = odb2.Accessors.getNodePropertyMulti[nodes.${contained.nodeType.className}](containingNode.graph, containingNode.nodeKind, ${actualProperties.size + containedIndexByName(contained.localName)}, containingNode.seq)"
          }}
           |}""".stripMargin
      }
      .mkString("\n")
     */

    val propertyBaseConversions = actualProperties
      .map { p =>
        s"implicit def accessProperty${p.className}(node: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]): Access_property_${p.name} = new Access_property_${p.name}(node)"
      }
      .mkString("\n")

    val accessors =
      s"""package ${basePackage}.accessors
         |import io.joern.odb2
         |import ${basePackage}.nodes
         |import scala.collection.immutable.IndexedSeq
         |
         |object Accessors {
         |  ${actualProperties
          .map { p =>
            val pre =
              s"class Access_property_${p.name}(val node: nodes.StoredNode) extends AnyVal {\n  def ${Helpers.camelCase(p.name)}: ${typeForProperty(p)}  ="
            val access = p.cardinality match {
              case Cardinality.ZeroOrOne =>
                s"odb2.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
              case Cardinality.List =>
                s"odb2.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
              case one: Cardinality.One[_] =>
                s"odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, ${idByProperty(p)}, node.seq(), ${unpackDefault(p.valueType, one.default)})"
            }
            pre + "\n    " + access + "\n}"
          }
          .mkString("\n\n")}
         |}
         |
         |object Lang extends ImplicitAccessors
         |trait ImplicitAccessors{
         |import Accessors._
         |${propertyBaseConversions}
         |}""".stripMargin
     */

    // for now, let's skip accessors.
    outputDir.createChild("Accessors.scala").write(accessors)

    /*
if (containedNodes.size != containedNodes.map { _.localName }.size) {
  println(containedNodes.toList.sortBy {
    _.localName
  })
  println(
    containedNodes
      .map {
        _.localName
      }
      .toList
      .sorted
  )
  throw new RuntimeException()
}
     */

    // val properties = schema.properties.filter{schema.nodeTypes.exists{nt => nt.}}

  }

  def typeForProperty(p: Property[_]): String = {
    val typ = unpackTypeUnboxed(p.valueType, true, false)
    p.cardinality match {
      case Cardinality.ZeroOrOne => s"Option[${typ}]"
      case Cardinality.List      => s"IndexedSeq[${typ}]"
      case _: Cardinality.One[_] => typ
    }
  }

  def unpackDefault(typ: ValueType[_], default: Default[_]): String = {
    import org.apache.commons.text.StringEscapeUtils.escapeJava
    typ match {
      case ValueType.Boolean                                            => s"${default.value}: Boolean"
      case ValueType.String if default.value == null                    => "null: String"
      case ValueType.String                                             => s"\"${escapeJava(default.value.asInstanceOf[String])}\": String"
      case ValueType.Byte                                               => s"${default.value}.toByte"
      case ValueType.Short                                              => s"${default.value}.toShort"
      case ValueType.Int                                                => s"${default.value}: Int"
      case ValueType.Long                                               => s"${default.value}L: Long"
      case ValueType.Float if default.value.asInstanceOf[Float].isNaN   => "Float.NaN"
      case ValueType.Float                                              => s"${default.value}f: Float"
      case ValueType.Double if default.value.asInstanceOf[Double].isNaN => "Double.NaN"
      case ValueType.Double                                             => s"${default.value}d: Double"
      case _                                                            => ???
    }
  }
  def unpackTypeUnboxed(tpe: ValueType[_], isStored: Boolean, raised: Boolean = false): String = {
    tpe match {
      case ValueType.Boolean             => "Boolean"
      case ValueType.String              => "String"
      case ValueType.Byte                => "Byte"
      case ValueType.Short               => "Short"
      case ValueType.Int                 => "Int"
      case ValueType.Long                => "Long"
      case ValueType.Float               => "Float"
      case ValueType.Double              => "Double"
      case ValueType.NodeRef if raised   => s"odb2.GNode"
      case ValueType.NodeRef if isStored => s"nodes.StoredNode"
      case ValueType.NodeRef             => s"nodes.AbstractNode"
      case _                             => ???
    }
  }

  def unpackTypeBoxed(tpe: ValueType[_], isStored: Boolean): String = {
    tpe match {
      case ValueType.Boolean             => "java.lang.Boolean"
      case ValueType.String              => "String"
      case ValueType.Byte                => "java.lang.Byte"
      case ValueType.Short               => "java.lang.Short"
      case ValueType.Int                 => "java.lang.Integer"
      case ValueType.Long                => "java.lang.Long"
      case ValueType.Float               => "java.lang.Float"
      case ValueType.Double              => "java.lang.Double"
      case ValueType.NodeRef if isStored => s"nodes.StoredNode"
      case ValueType.NodeRef             => s"nodes.AbstractNode"
      case _                             => ???
    }
  }
}
