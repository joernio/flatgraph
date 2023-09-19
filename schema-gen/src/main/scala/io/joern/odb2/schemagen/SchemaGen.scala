package io.joern.odb2.schemagen

import overflowdb.codegen.Helpers
import overflowdb.schema.{MarkerTrait, NodeBaseType, NodeType, Property, Schema}
import overflowdb.schema.Property.{Cardinality, Default, ValueType}

import scala.collection.mutable

object SchemaGen {

  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println("usage: CodeGen <outputDir> <schema: cpg|cs>")
      System.exit(1)
    }

    val schema = args(1) match {
      case "cpg" => io.shiftleft.codepropertygraph.schema.CpgSchema.instance
      case "cs"  => io.shiftleft.codepropertygraph.schema.CpgExtSchema.instance
    }
    val outputDir   = better.files.File(args(0))
    val basePackage = schema.basePackage + ".v2"

    val propertyContexts = relevantPropertyContexts(schema)
    val relevantProperties = propertyContexts.properties

    val nodeTypes  = schema.nodeTypes.sortBy(_.name).toArray
    val kindByNode = nodeTypes.zipWithIndex.toMap

    val containedIndexByName  = mutable.HashMap.empty[String, Int]
    val forbiddenSlotsByIndex = mutable.ArrayBuffer.empty[mutable.HashSet[NodeType]]

    // TODO: remove knapsack - as discussed with Bernhard and Markus, we don't need this complicated mechanism for a relatively small benefit
    // context: the original idea was to have a high L1 usage, but that's not realistic, and adds lots of complexity
    // we need to assign non-conflicting indices to each containedNode. Knapsack!
    for ((name, containing) <- propertyContexts.containedNodesByName.toList.sortBy { case (n, c) => (-c.size, n) }) {
      forbiddenSlotsByIndex.iterator.zipWithIndex.find { case (forbidden, _) =>
        forbidden.intersect(containing).isEmpty
      } match {
        case Some((oldForbidden, idx)) =>
          containedIndexByName(name) = idx
          oldForbidden.addAll(containing)
        case None =>
          containedIndexByName(name) = forbiddenSlotsByIndex.length
          forbiddenSlotsByIndex.append(containing.filter { _ => true }) // this looks silly (because it is!) - apparently .filter copies the map, and since it's mutable...
      }
    }

    val idByProperty                 = relevantProperties.zipWithIndex.toMap
    val edgeTypes    = schema.edgeTypes.sortBy(_.name).toArray
    val edgeIdByType = edgeTypes.zipWithIndex.toMap

    val newPropsAtNodeSet = schema.allNodeTypes.map { n =>
      n -> (n.properties.toSet &~ n.extendzRecursively.flatMap { _.properties }.toSet)
    }.toMap
    val newPropsAtNodeList = newPropsAtNodeSet.map { case k -> v => k -> v.toList.sortBy(_.name) }
    val newExtendzMap = schema.allNodeTypes.map { n =>
      n -> (n.extendz.toSet &~ n.extendzRecursively.flatMap {
        _.extendz
      }.toSet).toList.sortBy(_.name)
    }.toMap

    val prioStages = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[NodeBaseType]]
    for (baseType <- schema.nodeBaseTypes) {
      val props = newPropsAtNodeSet(baseType)
      val dst   = prioStages.find { stage => stage.forall(other => (newPropsAtNodeSet(other) & props).isEmpty) }
      if (dst.isDefined) { dst.get.addOne(baseType) }
      else prioStages.addOne(mutable.ArrayBuffer(baseType))
    }

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
      .map { case MarkerTrait(name) => s"trait $name" }
      .sorted
      .mkString("\n")

    val rootTypes =
      s"""package ${basePackage}.nodes
         |import io.joern.odb2
         |
         |trait StaticType[+T]
         |
         |trait AbstractNode extends odb2.DNodeOrNode with StaticType[AnyRef] {
         |  def label: String
         |  def propertiesMap: java.util.Map[String, Any]
         |}
         |
         |abstract class StoredNode(graph_4762: odb2.Graph, kind_4762: Short, seq_4762: Int) extends odb2.GNode(graph_4762, kind_4762, seq_4762) with AbstractNode {
         |${edgeAccess}
         |}
         |
         |abstract class NewNode(val nodeKind:Short) extends AbstractNode with odb2.DNode {
         |type RelatedStored <: StoredNode
         |private /* volatile? */ var _storedRef: RelatedStored = null.asInstanceOf[RelatedStored]
         |override def storedRef:Option[RelatedStored] = Option(this._storedRef)
         |override def storedRef_=(stored: Option[odb2.GNode]):Unit = this._storedRef = stored.orNull.asInstanceOf[RelatedStored]
         |}
         |""".stripMargin
    outputDir.createChild("RootTypes.scala").write(rootTypes)

    val propertyMarkers = relevantProperties.map { p => s"trait Has${p.className}T" }.mkString("\n")
    val basetypefile = schema.nodeBaseTypes
      .map { baseType =>
        val newExtendz = newExtendzMap(baseType)
        val mixinsBase = List("AbstractNode") ++ newExtendz.map(_.className + "Base") ++ baseType.markerTraits.map(_.name)

        val mixinsStored =
          List("StoredNode", s"${baseType.className}Base") ++ newExtendz.map(_.className) ++ baseType.markerTraits.map(_.name)
        val mixinsNew =
          List("NewNode", s"${baseType.className}Base") ++ baseType.extendz.map(_.className + "New") ++ baseType.markerTraits.map(_.name)
        val newProperties = newPropsAtNodeList(baseType)
        val mixinsT =
          (List("AnyRef") ++ newExtendz.map { _.className + "T" } ++ newProperties.map { p => s"Has${p.className}T" }).mkString(" with ")
        val oldProperties = (baseType.properties.toSet &~ newProperties.toSet).toList.sortBy {
          _.name
        }
        val oldExtendz = (baseType.extendzRecursively.toSet &~ newExtendz.toSet).toList.sortBy {
          _.name
        }

        val newNodeDefs = mutable.ArrayBuffer.empty[String]

        for (p <- newProperties) {
          val pname = Helpers.camelCase(p.name)
          val ptyp  = unpackTypeUnboxed(p.valueType, false, false)
          p.cardinality match {
            case Cardinality.List =>
              newNodeDefs.append(s"def ${pname}: IndexedSeq[${ptyp}]")
              newNodeDefs.append(s"def ${pname}_=(value: IndexedSeq[${ptyp}]): Unit")
              newNodeDefs.append(s"def ${pname}(value: IterableOnce[${ptyp}]): this.type")
            case Cardinality.ZeroOrOne =>
              newNodeDefs.append(s"def ${pname}: Option[${ptyp}]")
              newNodeDefs.append(s"def ${pname}_=(value: Option[${ptyp}]): Unit")
              newNodeDefs.append(s"def ${pname}(value: Option[${ptyp}]): this.type")
              newNodeDefs.append(s"def ${pname}(value: ${ptyp}): this.type")
            case one: Cardinality.One[_] =>
              newNodeDefs.append(s"def ${pname}: ${ptyp}")
              newNodeDefs.append(s"def ${pname}_=(value: ${ptyp}): Unit")
              newNodeDefs.append(s"def ${pname}(value: ${ptyp}): this.type")
          }
        }

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
            .mkString(" with ")} with StaticType[${baseType.className}T]
           |
           |trait ${baseType.className}New extends ${mixinsNew.mkString(" with ")} with StaticType[${baseType.className}T]{
           |  type RelatedStored <:  ${baseType.className}
           |  ${newNodeDefs.mkString("\n")}
           |}
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
        val newExtendz    = newExtendzMap(nodeType)
        val newProperties = newPropsAtNodeList(nodeType)
        val staticTyp =
          (s"""trait ${nodeType.className}T extends AnyRef""" +: newExtendz.map { b => s"${b.className}T" } ++: newProperties.map { p =>
            s"Has${p.className}T"
          }).mkString(" with ")

        val base = (s"""trait ${nodeType.className}Base extends AbstractNode""" +: newExtendz
          .map { base => base.className + "Base" } ++: List(s"StaticType[${nodeType.className}T]")).mkString(" with ")

        val stored =
          (s"""class ${nodeType.className}(graph_4762: odb2.Graph, seq_4762: Int) extends StoredNode(graph_4762, ${kind}.toShort , seq_4762)""" :: s"${nodeType.className}Base" +: newExtendz
            .map { base => base.className } ++: List(s"StaticType[${nodeType.className}T]")).mkString(" with ")
        // val base = (s"""class ${nodeType.className}""")
        val newNodeProps    = mutable.ArrayBuffer.empty[String]
        val newNodeFluent   = mutable.ArrayBuffer.empty[String]
        val storedNodeProps = mutable.ArrayBuffer.empty[String]
        val baseNodeProps   = mutable.ArrayBuffer.empty[String]
        val propDictItems   = mutable.ArrayBuffer.empty[String]
        val flattenItems    = mutable.ArrayBuffer.empty[String]

        for (p <- nodeType.properties) {
          val pname = Helpers.camelCase(p.name)
          val ptyp  = unpackTypeUnboxed(p.valueType, false, false)
          p.cardinality match {
            case Cardinality.List =>
              newNodeProps.append(s"var ${pname}: IndexedSeq[${ptyp}] = ArraySeq.empty")
              newNodeFluent.append(
                s"def ${pname}(value: IterableOnce[${ptyp}]): this.type = {this.${pname} = value.iterator.to(ArraySeq); this }"
              )
              propDictItems.append(
                s"""val tmp${p.className} = this.${pname}; if(tmp${p.className}.nonEmpty) res.put("${p.name}", tmp${p.className})"""
              )
              flattenItems.append(s"""if(${pname}.nonEmpty) interface.emplaceProperty(this, ${idByProperty(p)}, this.${pname})""")
            case Cardinality.ZeroOrOne =>
              newNodeProps.append(s"var ${pname}: Option[${ptyp}] = None")
              newNodeFluent.append(s"def ${pname}(value: Option[${ptyp}]): this.type = {this.${pname} = value; this }")
              newNodeFluent.append(
                s"def ${pname}(value: ${unpackTypeUnboxed(p.valueType, false, false)}): this.type = {this.${pname} = Option(value); this }"
              )
              propDictItems.append(s"""this.${pname}.foreach{p => res.put("${p.name}", p )}""")
              flattenItems.append(s"""if(${pname}.nonEmpty) interface.emplaceProperty(this, ${idByProperty(p)}, this.${pname})""")

            case one: Cardinality.One[_] =>
              newNodeProps.append(s"var ${pname}: ${ptyp} = ${unpackDefault(p.valueType, one.default)}")
              newNodeFluent.append(s"def ${pname}(value: ${ptyp}): this.type = {this.${pname} = value; this }")
              propDictItems.append(s"""res.put("${p.name}", this.$pname )""")
              flattenItems.append(s"""interface.emplaceProperty(this, ${idByProperty(p)}, Iterator(this.${pname}))""")
          }
        }
        for (c <- nodeType.containedNodes) {
          val pname = c.localName
          val ptyp  = classNameToBase(c.nodeType.className)
          val styp  = c.nodeType.className
          val index = relevantProperties.size + containedIndexByName(c.localName)
          val pid   = idByProperty.size + containedIndexByName(pname)
          c.cardinality match {
            case Cardinality.List =>
              newNodeProps.append(s"var ${pname}: IndexedSeq[${ptyp}] = ArraySeq.empty")
              newNodeFluent.append(
                s"def ${pname}(value: IterableOnce[${ptyp}]): this.type = {this.${pname} = value.iterator.to(ArraySeq); this }"
              )
              baseNodeProps.append(s"def ${pname}: IndexedSeq[${ptyp}]")
              storedNodeProps.append(
                s"def ${pname}: IndexedSeq[${styp}] = odb2.Accessors.getNodePropertyMulti[$styp](graph, nodeKind, $index, seq)"
              )
              propDictItems.append(s"""val tmp${pname} = this.${pname}; if(tmp${pname}.nonEmpty) res.put("${pname}", tmp${pname})""")
              flattenItems.append(s"""if(${pname}.nonEmpty) interface.emplaceProperty(this, ${pid}, this.${pname})""")

            case Cardinality.ZeroOrOne =>
              newNodeProps.append(s"var ${pname}: Option[${ptyp}] = None")
              newNodeFluent.append(s"def ${pname}(value: Option[${ptyp}]): this.type = {this.${pname} = value; this }")
              newNodeFluent.append(s"def ${pname}(value: ${ptyp}): this.type = {this.${pname} = Option(value); this }")
              baseNodeProps.append(s"def ${pname}: Option[${ptyp}]")
              storedNodeProps.append(
                s"def ${pname}: Option[${styp}] = odb2.Accessors.getNodePropertyOption[$styp](graph, nodeKind, $index, seq)"
              )
              propDictItems.append(s"""this.${pname}.foreach{p => res.put("${pname}", p )}""")
              flattenItems.append(s"""if(${pname}.nonEmpty) interface.emplaceProperty(this, ${pid}, this.${pname})""")

            case one: Cardinality.One[_] =>
              newNodeProps.append(s"var ${pname}: ${ptyp} = null")
              newNodeFluent.append(s"def ${pname}(value: ${ptyp}): this.type = {this.${pname} = value; this }")
              baseNodeProps.append(s"def ${pname}: ${ptyp}")
              storedNodeProps.append(
                s"def ${pname}: ${styp} = odb2.Accessors.getNodePropertySingle(graph, nodeKind, $index, seq, null: ${styp})"
              )
              propDictItems.append(s"""res.put("${pname}", this.$pname )""")
              flattenItems.append(s"""interface.emplaceProperty(this, ${pid}, Iterator(this.${pname}))""")
          }
        }

        val newNode =
          s"""object New${nodeType.className}{def apply():  New${nodeType.className} = new  New${nodeType.className}}
             |class New${nodeType.className} extends NewNode(${kindByNode(nodeType)}.toShort) with ${nodeType.className}Base {
             |type RelatedStored = ${nodeType.className}
             |override def label: String = "${nodeType.name}"
             |${newNodeProps.sorted.mkString("\n")}
             |${newNodeFluent.sorted.mkString("\n")}
             |${flattenItems.mkString("override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {\n", "\n", "\n}")}
             |}""".stripMargin

        s"""${staticTyp}
           |${base}{
           |${baseNodeProps.mkString("\n")}
           |${propDictItems.mkString(
            s"override def propertiesMap: java.util.Map[String, Any] = {\n import ${basePackage}.accessors.Lang._\n val res = new java.util.HashMap[String, Any]()\n",
            "\n",
            "\n res\n}"
          )}
           |}
           |${stored} {
           |${storedNodeProps.mkString("\n")}
           |}
           |${newNode}
           |""".stripMargin
      }
      .mkString(
        s"""package ${basePackage}.nodes
           |import io.joern.odb2
           |import scala.collection.immutable.{IndexedSeq, ArraySeq}
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
         |  val nodePropertyAllocators: Array[Int => Array[_]] = Array(${(relevantProperties.map { p =>
          s"size => new Array[${unpackTypeUnboxed(p.valueType, true, raised = true)}](size)"
        }.iterator ++ forbiddenSlotsByIndex.map { _ => "size => new Array[odb2.GNode](size)" }).mkString(", ")})
         |  val normalNodePropertyNames = Array(${relevantProperties.map { p => s"\"${p.name}\"" }.mkString(", ")})
         |  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap${containedIndexByName.toList
          .sortBy { kv => (kv._2, kv._1) }
          .map { kv => s".updated(\"${kv._1}\", ${relevantProperties.size + kv._2})" }
          .mkString}
         |
         | override def getNumberOfNodeKinds: Int = ${nodeTypes.length}
         | override def getNumberOfEdgeKinds: Int = ${edgeTypes.length}
         | override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
         | override def getNodeIdByLabel(label: String): Int = nodeIdByLabel.getOrElse(label, -1)
         | override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
         | override def getEdgeIdByLabel(label: String): Int = edgeIdByLabel.getOrElse(label, -1)
         | override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String =
         |    if(propertyKind < ${relevantProperties.length}) normalNodePropertyNames(propertyKind)
         |${nodeTypes
          .flatMap { nt =>
            nt.containedNodes.map {
              (nt, _)
            }
          }
          .map { case (node, contained) =>
            s"    else if(propertyKind == ${relevantProperties.length + containedIndexByName(
                contained.localName
              )} && nodeKind == ${kindByNode(node)}) \"${contained.localName}\" /*on node ${node.name}*/"
          }
          .toList
          .sorted
          .mkString("\n")}
         |    else null
         | 
         | override def getPropertyIdByLabel(label: String): Int = nodePropertyByLabel.getOrElse(label, -1)
         | override def getNumberOfProperties: Int = ${relevantProperties.size + forbiddenSlotsByIndex.size}
         | override def makeNode(graph: odb2.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
         | override def makeEdge(src: odb2.GNode, dst: odb2.GNode, edgeKind: Short, subSeq: Int, property: Any): odb2.Edge = edgeFactories(edgeKind)(src, dst, subSeq, property)
         | override def allocateEdgeProperty(nodeKind: Int, direction: odb2.Edge.Direction, edgeKind: Int, size: Int): Array[_] = edgePropertyAllocators(edgeKind)(size)
         | override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_] = nodePropertyAllocators(propertyKind)(size)
         |}""".stripMargin
    outputDir.createChild("GraphSchema.scala").write(schemaFile)

    // Accessors and traversals

    val concreteStoredAccess = mutable.ArrayBuffer.empty[String]
    val concreteStoredConv   = mutable.ArrayBuffer.empty[String]
    val baseAccess           = mutable.ArrayBuffer.empty[String]
    val baseConvert          = Range(0, prioStages.length + 1).map { _ => mutable.ArrayBuffer.empty[String] }

    val concreteStoredAccessTrav = mutable.ArrayBuffer.empty[String]
    val concreteStoredConvTrav   = mutable.ArrayBuffer.empty[String]
    val baseAccessTrav           = mutable.ArrayBuffer.empty[String]
    val baseConvertTrav          = Range(0, prioStages.length + 1).map { _ => mutable.ArrayBuffer.empty[String] }

    for (p <- relevantProperties) {
      val funName = Helpers.camelCase(p.name)
      concreteStoredAccess.addOne(
        s"""final class Access_Property_${p.name}(val node: nodes.StoredNode) extends AnyVal {
           |  def ${funName}: ${typeForProperty(p)}  = ${p.cardinality match {
            case Cardinality.ZeroOrOne =>
              s"odb2.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
            case Cardinality.List =>
              s"odb2.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
            case one: Cardinality.One[_] =>
              s"odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, ${idByProperty(p)}, node.seq(), ${unpackDefault(p.valueType, one.default)})"
          }}
           |}""".stripMargin
      )
      concreteStoredConv.addOne(
        s"""implicit def accessProperty${p.className}(node: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]): Access_Property_${p.name} = new Access_Property_${p.name}(node)""".stripMargin
      )
      concreteStoredAccessTrav.addOne(
        s"""final class Traversal_Property_${p.name}[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]](val traversal: Iterator[NodeType]) extends AnyVal {""".stripMargin +
          generatePropertyTraversals(p, idByProperty(p)) + "}"
      )
      concreteStoredConvTrav.addOne(
        s"""implicit def accessProperty${p.className}[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]](traversal: Iterator[NodeType]): Traversal_Property_${p.name}[NodeType] = new Traversal_Property_${p.name}(traversal)""".stripMargin
      )

    }

    for ((convertForStage, stage) <- baseConvert.iterator.zip(Iterator(nodeTypes.iterator) ++ prioStages.iterator)) {
      stage.iterator.foreach { baseType =>
        val extensionClass = s"Access_${baseType.className}Base"
        convertForStage.addOne(
          s"implicit def access_${baseType.className}Base(node: nodes.${baseType.className}Base): $extensionClass = new $extensionClass(node)"
        )
        val newName = if (baseType.isInstanceOf[NodeBaseType]) { baseType.className + "New" }
        else { "New" + baseType.className }
        val accessors = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          val funName = Helpers.camelCase(p.name)
          accessors.addOne(s"""def ${funName}: ${typeForProperty(p)}  = node match {
          | case stored: nodes.StoredNode => new Access_Property_${p.name}(stored).${funName}
          | case newNode: nodes.${newName} => newNode.${funName}
          |}""".stripMargin)
        }
        baseAccess.addOne(
          accessors.mkString(s"final class ${extensionClass}(val node: nodes.${baseType.className}Base) extends AnyVal {\n", "\n", "\n}")
        )
      }
    }
    for ((convertForStage, stage) <- baseConvertTrav.iterator.zip(Iterator(nodeTypes.iterator) ++ prioStages.iterator)) {
      stage.iterator.foreach { baseType =>
        val extensionClass = s"Traversal_${baseType.className}Base"
        convertForStage.addOne(
          s"implicit def traversal_${baseType.className}Base[NodeType <: nodes.${baseType.className}Base](traversal: Iterator[NodeType]): $extensionClass[NodeType] = new $extensionClass(traversal)"
        )
        val elems = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          elems.addOne(generatePropertyTraversals(p, idByProperty(p)))
        }
        baseAccessTrav.addOne(
          elems.mkString(
            s"final class $extensionClass[NodeType <: nodes.${baseType.className}Base](val traversal: Iterator[NodeType]) extends AnyVal { ",
            "\n",
            "}"
          )
        )
      }
    }

    val convtraits     = mutable.ArrayBuffer.empty[String]
    val convtraitsTrav = mutable.ArrayBuffer.empty[String]

    val convBuffer     = concreteStoredConv +: baseConvert
    val convBufferTrav = concreteStoredConvTrav +: baseConvertTrav
    for (idx <- Range(0, baseConvert.length + 1)) {
      val (tname, tparent) = idx match {
        case 0 => ("ConcreteStoredConversions", Some("ConcreteBaseConversions"))
        case 1 => ("ConcreteBaseConversions", if (baseConvert.length > 1) Some("AbstractBaseConversions0") else None)
        case _ =>
          (s"AbstractBaseConversions${idx - 2}", if (idx < baseConvert.length) Some(s"AbstractBaseConversions${idx - 1}") else None)
      }
      convtraits.addOne(s"""trait ${tname} ${tparent.map { p => s" extends ${p}" }.getOrElse("")} {
           |import Accessors._
           |${convBuffer(idx).mkString("\n")}
           |}""".stripMargin)
      convtraitsTrav.addOne(s"""trait ${tname} ${tparent.map { p => s" extends ${p}" }.getOrElse("")} {
           |import Accessors._
           |${convBufferTrav(idx).mkString("\n")}
           |}""".stripMargin)
    }

    val accessors =
      s"""package ${basePackage}.accessors
         |import io.joern.odb2
         |import ${basePackage}.nodes
         |import scala.collection.immutable.IndexedSeq
         |
         |object Lang extends ConcreteStoredConversions {}
         |
         |object Accessors {
         |  ${concreteStoredAccess.mkString("\n")}
         |  //
         |  ${baseAccess.mkString("\n")}
         |}
         |
         |${convtraits.mkString("\n\n")}
         |""".stripMargin

    outputDir.createChild("Accessors.scala").write(accessors)

    // fixme: Also generate edge accessors
    val traversals =
      s"""package $basePackage.traversals
         |import io.joern.odb2
         |import ${basePackage}.nodes
         |
         |object Lang extends ConcreteStoredConversions {}
         |
         |object Accessors {
         |  import $basePackage.accessors.Lang._
         |  import odb2.misc.Misc
         |  ${concreteStoredAccessTrav.mkString("\n")}
         |  //
         |  ${baseAccessTrav.mkString("\n")}
         |}
         |${convtraitsTrav.mkString("\n\n")}
         |""".stripMargin
    outputDir.createChild("Traversals.scala").write(traversals)

    val strmapping = Map("return" -> "ret", "type" -> "typ", "import" -> "imports").withDefault(s => s)
    val concreteStarters = nodeTypes.iterator.zipWithIndex.map { case (typ, idx) =>
      s"""def ${strmapping(
          Helpers.camelCase(typ.name)
        )}: Iterator[nodes.${typ.className}] = wrappedGraph.graph.nodes(${idx}).asInstanceOf[Iterator[nodes.${typ.className}]]"""
    }.toList
    val baseStarters = schema.nodeBaseTypes.iterator.map { basetyp =>
      s"""def ${strmapping(Helpers.camelCase(basetyp.name))}: Iterator[nodes.${basetyp.className}] = Iterator(${nodeTypes
          .filter { _.extendzRecursively.contains(basetyp) }
          .map { t => "this." + strmapping(Helpers.camelCase(t.name)) }
          .mkString(", ")}).flatten"""
    }.toList
    val domainMain =
      s"""package ${basePackage}
         |import io.joern.odb2
         |
         |object ${schema.domainShortName}{
         |  def empty: ${schema.domainShortName} = new ${schema.domainShortName}(new odb2.Graph(GraphSchema))
         |}
         |class ${schema.domainShortName}(val graph: odb2.Graph){
         |assert(graph.schema == GraphSchema)
         |}
         |
         |class ${schema.domainShortName}GeneratedNodeStarters(val wrappedGraph: ${schema.domainShortName}) extends AnyVal {
         |${concreteStarters.mkString("\n")}
         |
         |${baseStarters.mkString("\n")}
         |}
         |""".stripMargin
    outputDir.createChild(s"${schema.domainShortName}.scala").write(domainMain)

  } // end generate

  def typeForProperty(p: Property[_]): String = {
    val typ = unpackTypeUnboxed(p.valueType, true, false)
    p.cardinality match {
      case Cardinality.ZeroOrOne => s"Option[${typ}]"
      case Cardinality.List      => s"IndexedSeq[${typ}]"
      case _: Cardinality.One[_] => typ
    }
  }

  def classNameToBase(classname: String): String = {
    classname match {
      case "StoredNode" => "AbstractNode"
      case other        => other + "Base"
    }
  }

  def generatePropertyTraversals(property: Property[_], propertyId: Int): String = {
    // fixme: also generate negated filters
    val nameCamelCase = Helpers.camelCase(property.name)
    val baseType      = unpackTypeUnboxed(property.valueType, false, false)
    val cardinality   = property.cardinality
    val Traversal     = "Iterator"

    val mapOrFlatMap = cardinality match {
      case Cardinality.One(_)                       => "map"
      case Cardinality.ZeroOrOne | Cardinality.List => "flatMap"
    }

    val filterStepsForSingleString =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): $Traversal[NodeType] =
         |  if(!Misc.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filter{item => matcher.reset(item.${nameCamelCase}).matches}
         |  }
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): $Traversal[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
         |   traversal.filter{item => matchers.exists{_.reset(item.$nameCamelCase).matches}}
         | }
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): $Traversal[NodeType] = traversal match {
         |    case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  ${propertyId}, value).asInstanceOf[Iterator[NodeType]]
         |    case _ => traversal.filter{_.${nameCamelCase} == value}
         |  }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches one of the elements in `values` exactly.
         |  * */
         |def ${nameCamelCase}Exact(values: $baseType*): $Traversal[NodeType] =
         |  if(values.length == 1) ${nameCamelCase}Exact(values.head) else {
         |  val valueSet = values.toSet
         |  traversal.filter{item => valueSet.contains(item.${nameCamelCase})}
         |  }
         |
         |
         |""".stripMargin

    val filterStepsForOptionalString =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): $Traversal[NodeType] =
         |  if(!Misc.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filter{ item =>  val tmp = item.${nameCamelCase}; tmp.isDefined && matcher.reset(tmp.get).matches}
         |  }
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): $Traversal[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
         |   traversal.filter{item => val tmp = item.${nameCamelCase}; tmp.isDefined && matchers.exists{_.reset(tmp.get).matches}}
         | }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): $Traversal[NodeType] = traversal match {
         |    case init: odb2.misc.InitNodeIterator[odb2.GNode] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  ${propertyId}, value).asInstanceOf[Iterator[NodeType]]
         |     case _ => traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get == value}
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches one of the elements in `values` exactly.
         |  * */
         |def ${nameCamelCase}Exact(values: $baseType*): $Traversal[NodeType] = 
         |  if(values.length == 1) ${nameCamelCase}Exact(values.head) else {
         |  val valueSet = values.toSet
         |  traversal.filter{item => val tmp = item.$nameCamelCase; tmp.isDefined && valueSet.contains(tmp.get)}
         |  }
         |""".stripMargin

    val filterStepsForSingleBoolean =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |""".stripMargin

    val filterStepsForOptionalBoolean =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => node.${nameCamelCase}.isDefined && node.$nameCamelCase.get == value}
         |""".stripMargin

    val filterStepsForSingleInt =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): $Traversal[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => vset.contains(node.$nameCamelCase)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than the given `value`
         |  * */
         |def ${nameCamelCase}Gt(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase > value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Gte(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase >= value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than the given `value`
         |  * */
         |def ${nameCamelCase}Lt(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase < value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Lte(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase <= value}
         |
         |""".stripMargin

    val filterStepsForOptionalInt =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): $Traversal[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && vset.contains(tmp.get)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than the given `value`
         |  * */
         |def ${nameCamelCase}Gt(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get > value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Gte(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get >= value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than the given `value`
         |  * */
         |def ${nameCamelCase}Lt(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get < value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Lte(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get <= value}
         |
         |""".stripMargin

    val filterStepsGenericSingle =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): $Traversal[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => !vset.contains(node.$nameCamelCase)}
         |}
         |
         |""".stripMargin

    val filterStepsGenericOption =
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): $Traversal[NodeType] =
         |  traversal.filter{node => node.$nameCamelCase.isDefined && node.$nameCamelCase.get == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): $Traversal[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => node.$nameCamelCase.isDefined && !vset.contains(node.$nameCamelCase.get)}
         |}
         |""".stripMargin

    val filterSteps = (cardinality, property.valueType) match {
      case (Cardinality.List, _)                      => ""
      case (Cardinality.One(_), ValueType.String)     => filterStepsForSingleString
      case (Cardinality.ZeroOrOne, ValueType.String)  => filterStepsForOptionalString
      case (Cardinality.One(_), ValueType.Boolean)    => filterStepsForSingleBoolean
      case (Cardinality.ZeroOrOne, ValueType.Boolean) => filterStepsForOptionalBoolean
      case (Cardinality.One(_), ValueType.Int)        => filterStepsForSingleInt
      case (Cardinality.ZeroOrOne, ValueType.Int)     => filterStepsForOptionalInt
      case (Cardinality.One(_), _)                    => filterStepsGenericSingle
      case (Cardinality.ZeroOrOne, _)                 => filterStepsGenericOption
      case _                                          => ""
    }

    s"""/** Traverse to $nameCamelCase property */
       |def $nameCamelCase: $Traversal[$baseType] =
       |  traversal.$mapOrFlatMap(_.$nameCamelCase)
       |
       |$filterSteps
       |""".stripMargin

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

  private case class PropertyContexts(properties: Array[Property[?]], containedNodesByName: Map[String, mutable.HashSet[NodeType]])

  private def relevantPropertyContexts(schema: Schema): PropertyContexts = {
    val relevantPropertiesSet = mutable.HashSet.empty[Property[?]]
    val containingByName      = mutable.HashMap.empty[String, mutable.HashSet[NodeType]]

    for (node <- schema.nodeTypes) {
      relevantPropertiesSet.addAll(node.properties)
      for (contained <- node.containedNodes) {
        containingByName
          .getOrElseUpdate(contained.localName, mutable.HashSet.empty[NodeType])
          .add(node)
      }
    }

    for (baseType <- schema.nodeBaseTypes) {
      relevantPropertiesSet.addAll(baseType.properties)
    }

    assert(relevantPropertiesSet.size == relevantPropertiesSet.map(_.name).size,
      s"""relevantPropertiesSet should have exactly one entry per entry name, but that's not the case...
         |relevantPropertiesSet entries: ${relevantPropertiesSet.toSeq.sortBy(_.name)}
         |relevantPropertiesSet names:   ${relevantPropertiesSet.map(_.name).toSeq}
         |""".stripMargin)

    PropertyContexts(
      relevantPropertiesSet.toArray.sortBy(_.name),
      containingByName.view.toMap
    )
  }
}
