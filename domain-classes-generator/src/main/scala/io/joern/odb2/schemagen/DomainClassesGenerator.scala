package io.joern.odb2.codegen

import io.joern.odb2.codegen.CodeSnippets.FilterSteps

import java.nio.file.{Path, Paths}
import overflowdb.codegen.Helpers
import overflowdb.schema.{AbstractNodeType, AdjacentNode, Direction, EdgeType, MarkerTrait, NodeBaseType, NodeType, Property, Schema}
import overflowdb.schema.Property.{Cardinality, Default, ValueType}

import scala.collection.mutable

object DomainClassesGeneratorCpg {
  def main(args: Array[String]): Unit = {
    new DomainClassesGenerator(io.shiftleft.codepropertygraph.schema.CpgSchema.instance).main(args)
  }
}

class DomainClassesGenerator(schema: Schema) {
  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      System.err.println("usage: CodeGen <outputDir>")
      System.exit(1)
    }
    val outputDir = Paths.get(args(0))
    run(outputDir)
  }

  def run(outputDir: Path): Unit = {
    val outputDir0 = os.Path(outputDir.toAbsolutePath)
    // start with a clean slate
    os.remove.all(outputDir0)
    os.makeDir.all(outputDir0)

    val basePackage = schema.basePackage + ".v2"

    val propertyContexts   = relevantPropertyContexts(schema)
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
          forbiddenSlotsByIndex.append(
            containing.filter(_ => true)
          ) // this looks silly (because it is!) - apparently .filter copies the map, and since it's mutable...
      }
    }

    val idByProperty = relevantProperties.zipWithIndex.toMap
    val edgeTypes    = schema.edgeTypes.sortBy(_.name).toArray
    val edgeIdByType = edgeTypes.zipWithIndex.toMap

    val newPropsAtNodeSet: Map[AbstractNodeType, Set[Property[?]]] =
      schema.allNodeTypes.map { nodeType =>
        nodeType -> nodeType.properties.toSet.diff(nodeType.extendzRecursively.flatMap(_.properties).toSet)
      }.toMap
    val newPropsAtNodeList = newPropsAtNodeSet.view.mapValues(_.toList.sortBy(_.name))
    val newExtendzMap = schema.allNodeTypes.map { nodeType =>
      nodeType -> nodeType.extendz.toSet.diff(nodeType.extendzRecursively.flatMap(_.extendz).toSet).toList.sortBy(_.name)
    }.toMap

    val prioStages: Array[Array[NodeBaseType]] = {
      val prioStages = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[NodeBaseType]]
      for (baseType <- schema.nodeBaseTypes) {
        val props = newPropsAtNodeSet(baseType)
        prioStages.find { stage =>
          stage.forall(other => newPropsAtNodeSet(other).intersect(props).isEmpty)
        } match {
          case Some(value) => value.addOne(baseType)
          case None        => prioStages.addOne(mutable.ArrayBuffer(baseType))
        }
      }
      prioStages.map(_.toArray).toArray
    }

    // base file
    // format: off
    val edgeAccess = edgeTypes.map { et =>
      s"""
       |final def _${Helpers.camelCase(et.name)}Out: IndexedSeq[StoredNode] = odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, ${edgeIdByType(et)}).asInstanceOf[IndexedSeq[StoredNode]]
       |final def _${Helpers.camelCase(et.name)}In: IndexedSeq[StoredNode] = odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, ${edgeIdByType(et)}).asInstanceOf[IndexedSeq[StoredNode]]
       |""".stripMargin
    }.mkString("\n")
    // format: on

    val userMarkers = schema.allNodeTypes
      .flatMap(_.markerTraits)
      .distinct
      .map { case MarkerTrait(name) => s"trait $name" }
      .sorted
      .mkString("\n")

    val rootTypes =
      s"""package $basePackage.nodes
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
         |$edgeAccess
         |}
         |
         |abstract class NewNode(val nodeKind:Short) extends AbstractNode with odb2.DNode {
         |type RelatedStored <: StoredNode
         |private /* volatile? */ var _storedRef: RelatedStored = null.asInstanceOf[RelatedStored]
         |override def storedRef:Option[RelatedStored] = Option(this._storedRef)
         |override def storedRef_=(stored: Option[odb2.GNode]):Unit = this._storedRef = stored.orNull.asInstanceOf[RelatedStored]
         |}
         |""".stripMargin

    os.write(outputDir0 / "RootTypes.scala", rootTypes)

    val propertyMarkers = relevantProperties.map(p => s"trait Has${p.className}T").mkString("\n")
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
        val oldProperties = baseType.properties.toSet.diff(newProperties.toSet).toList.sortBy(_.name)
        val oldExtendz    = baseType.extendzRecursively.toSet.diff(newExtendz.toSet).toList.sortBy(_.name)

        val newNodeDefs: Seq[String] = {
          for {
            property <- newProperties
            pname = Helpers.camelCase(property.name)
            ptyp  = unpackTypeUnboxed(property.valueType, isStored = false, raised = false)
          } yield property.cardinality match {
            case Cardinality.List =>
              Seq(
                s"def ${pname}: IndexedSeq[$ptyp]",
                s"def ${pname}_=(value: IndexedSeq[$ptyp]): Unit",
                s"def ${pname}(value: IterableOnce[$ptyp]): this.type"
              )
            case Cardinality.ZeroOrOne =>
              Seq(
                s"def ${pname}: Option[$ptyp]",
                s"def ${pname}_=(value: Option[$ptyp]): Unit",
                s"def ${pname}(value: Option[$ptyp]): this.type",
                s"def ${pname}(value: $ptyp): this.type"
              )
            case one: Cardinality.One[?] =>
              Seq(s"def ${pname}: $ptyp", s"def ${pname}_=(value: $ptyp): Unit", s"def ${pname}(value: $ptyp): this.type")
          }
        }.flatten

        s"""trait ${baseType.className}T extends $mixinsT
           |
           |trait ${baseType.className}Base extends ${mixinsBase.mkString(" with ")} with StaticType[${baseType.className}T]
           | // new properties: ${newProperties.map { _.name }.mkString(", ")}
           | // inherited properties: ${oldProperties.map { _.name }.mkString(", ")}
           | // inherited interfaces: ${oldExtendz.map(_.name).mkString(", ")}
           | // implementing nodes: ${nodeTypes
            .filter { n => n.extendzRecursively.contains(baseType) }
            .map(_.name)
            .mkString(", ")}
           |trait ${baseType.className} extends ${mixinsStored.mkString(" with ")} with StaticType[${baseType.className}T]
           |
           |trait ${baseType.className}New extends ${mixinsNew.mkString(" with ")} with StaticType[${baseType.className}T]{
           |  type RelatedStored <:  ${baseType.className}
           |  ${newNodeDefs.mkString("\n")}
           |}
           |""".stripMargin
      }
      .mkString(
        s"""package $basePackage.nodes
           |import io.joern.odb2
           |
           |""".stripMargin,
        "\n\n",
        s"\n$userMarkers\n$propertyMarkers\n"
      )
    os.write(outputDir0 / "BaseTypes.scala", basetypefile)

    val edgeTypesSource = edgeTypes.iterator.zipWithIndex
      .map { case (edgeType, idx) =>
        if (edgeType.properties.length > 1) throw new RuntimeException("we only support zero or one edge properties")

        // format: off
        val accessor = if (edgeType.properties.length == 1) {
          val p = edgeType.properties.head
          p.cardinality match {
            case _: Cardinality.One[?] =>
              s"""{
                 |  def ${Helpers.camelCase(p.name)}: ${unpackTypeUnboxed(p.valueType, true )} = this.property.asInstanceOf[${unpackTypeUnboxed(p.valueType, true)}]
                 |}""".stripMargin
            case Cardinality.ZeroOrOne =>
              s"""{
                 |  def ${Helpers.camelCase(p.name)}: Option[${unpackTypeUnboxed(p.valueType, true)}] = Option(this.property.asInstanceOf[${unpackTypeBoxed(p.valueType, true)}])
                 |}""".stripMargin
            case Cardinality.List => throw new RuntimeException("edge properties are only supported with cardinality one or optional")
          }
        } else ""
        // format: on

        s"""class ${edgeType.className}(src_4762: odb2.GNode, dst_4762: odb2.GNode, subSeq_4862: Int, property_4862: Any)
           |    extends odb2.Edge(src_4762, dst_4762, $idx.toShort, subSeq_4862, property_4862) $accessor""".stripMargin
      }
      .mkString(
        s"""package $basePackage.edges
           |import io.joern.odb2
           |
           |""".stripMargin,
        "\n",
        "\n"
      )
    os.write(outputDir0 / "EdgeTypes.scala", edgeTypesSource)

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
              newNodeProps.append(s"var $pname: IndexedSeq[$ptyp] = ArraySeq.empty")
              newNodeFluent.append(
                s"def $pname(value: IterableOnce[$ptyp]): this.type = {this.$pname = value.iterator.to(ArraySeq); this }"
              )
              propDictItems.append(
                s"""val tmp${p.className} = this.$pname; if(tmp${p.className}.nonEmpty) res.put("${p.name}", tmp${p.className})"""
              )
              flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, ${idByProperty(p)}, this.$pname)""")
            case Cardinality.ZeroOrOne =>
              newNodeProps.append(s"var $pname: Option[$ptyp] = None")
              newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
              newNodeFluent.append(
                s"def $pname(value: ${unpackTypeUnboxed(p.valueType, false, false)}): this.type = {this.$pname = Option(value); this }"
              )
              propDictItems.append(s"""this.$pname.foreach{p => res.put("${p.name}", p )}""")
              flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, ${idByProperty(p)}, this.$pname)""")

            case one: Cardinality.One[?] =>
              newNodeProps.append(s"var $pname: $ptyp = ${unpackDefault(p.valueType, one.default)}")
              newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
              propDictItems.append(s"""res.put("${p.name}", this.$pname )""")
              flattenItems.append(s"""interface.insertProperty(this, ${idByProperty(p)}, Iterator(this.$pname))""")
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
              newNodeProps.append(s"var $pname: IndexedSeq[$ptyp] = ArraySeq.empty")
              newNodeFluent.append(
                s"def $pname(value: IterableOnce[$ptyp]): this.type = {this.$pname = value.iterator.to(ArraySeq); this }"
              )
              baseNodeProps.append(s"def $pname: IndexedSeq[$ptyp]")
              storedNodeProps.append(
                s"def $pname: IndexedSeq[${styp}] = odb2.Accessors.getNodePropertyMulti[$styp](graph, nodeKind, $index, seq)"
              )
              propDictItems.append(s"""val tmp$pname = this.$pname; if(tmp$pname.nonEmpty) res.put("$pname", tmp$pname)""")
              flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, $pid, this.$pname)""")

            case Cardinality.ZeroOrOne =>
              newNodeProps.append(s"var $pname: Option[$ptyp] = None")
              newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
              newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = Option(value); this }")
              baseNodeProps.append(s"def $pname: Option[$ptyp]")
              storedNodeProps.append(
                s"def $pname: Option[${styp}] = odb2.Accessors.getNodePropertyOption[$styp](graph, nodeKind, $index, seq)"
              )
              propDictItems.append(s"""this.$pname.foreach{p => res.put("$pname", p )}""")
              flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, $pid, this.$pname)""")

            case _: Cardinality.One[?] =>
              newNodeProps.append(s"var $pname: $ptyp = null")
              newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
              baseNodeProps.append(s"def $pname: $ptyp")
              storedNodeProps.append(
                s"def $pname: ${styp} = odb2.Accessors.getNodePropertySingle(graph, nodeKind, $index, seq, null: ${styp})"
              )
              propDictItems.append(s"""res.put("$pname", this.$pname )""")
              flattenItems.append(s"""interface.insertProperty(this, $pid, Iterator(this.$pname))""")
          }
        }

        val newNode =
          s"""object New${nodeType.className}{def apply(): New${nodeType.className} = new New${nodeType.className}}
             |class New${nodeType.className} extends NewNode(${kindByNode(nodeType)}.toShort) with ${nodeType.className}Base {
             |type RelatedStored = ${nodeType.className}
             |override def label: String = "${nodeType.name}"
             |${newNodeProps.sorted.mkString("\n")}
             |${newNodeFluent.sorted.mkString("\n")}
             |${flattenItems.mkString("override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {\n", "\n", "\n}")}
             |}""".stripMargin

        s"""$staticTyp
           |$base {
           |${baseNodeProps.mkString("\n")}
           |${propDictItems.mkString(
            s"""override def propertiesMap: java.util.Map[String, Any] = {
               | import $basePackage.accessors.Lang.*
               | val res = new java.util.HashMap[String, Any]()
               |""".stripMargin,
            "\n",
            "\n res\n}"
          )}
           |}
           |$stored {
           |${storedNodeProps.mkString("\n")}
           |}
           |$newNode
           |""".stripMargin
      }
      .mkString(
        s"""package $basePackage.nodes
           |import io.joern.odb2
           |import scala.collection.immutable.{IndexedSeq, ArraySeq}
           |
           |""".stripMargin,
        "\n\n",
        ""
      )
    os.write(outputDir0 / "NodeTypes.scala", concreteNodes)

    val schemaFile =
      s"""package $basePackage
         |import io.joern.odb2
         |import $basePackage.nodes
         |import $basePackage.edges
         |
         |object GraphSchema extends odb2.Schema {
         |  val nodeLabels = Array(${kindByNode.iterator.toList
          .sortBy { case (_, kind) => kind }
          .map { case (nodeType, _) => s"\"${nodeType.name}\"" }
          .mkString(", ")})
         |  val nodeKindByLabel = nodeLabels.zipWithIndex.toMap
         |  val edgeLabels = Array(${edgeTypes.map { e => s"\"${e.name}\"" }.mkString(",  ")})
         |  val edgeIdByLabel = edgeLabels.zipWithIndex.toMap
         |  val edgePropertyAllocators: Array[Int => Array[?]] = Array(${edgeTypes.zipWithIndex
          .map { case (edge, idx) =>
            edge.properties.headOption match {
              case Some(p) if p.cardinality == Cardinality.ZeroOrOne => ???
              case Some(p) =>
                s"size => Array.fill(size)(${Helpers.defaultValueImpl(p.cardinality.asInstanceOf[Cardinality.One[?]].default)}) /* label = ${edge.name}, id = $idx */"
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
         |  val nodePropertyAllocators: Array[Int => Array[?]] = Array(${(relevantProperties.map { p =>
          s"size => new Array[${unpackTypeUnboxed(p.valueType, true, raised = true)}](size)"
        }.iterator ++ forbiddenSlotsByIndex.map { _ => "size => new Array[odb2.GNode](size)" }).mkString(", ")})
         |  val normalNodePropertyNames = Array(${relevantProperties.map { p => s"\"${p.name}\"" }.mkString(", ")})
         |  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap${containedIndexByName.toList
          .sortBy { case (name, idx) => (idx, name) }
          .map { case (name, idx) => s".updated(\"$name\", ${relevantProperties.size + idx})" }
          .mkString}
         |
         | override def getNumberOfNodeKinds: Int = ${nodeTypes.length}
         | override def getNumberOfEdgeKinds: Int = ${edgeTypes.length}
         | override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
         | override def getNodeIdByLabel(label: String): Int = nodeKindByLabel.getOrElse(label, -1)
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
         | override def allocateEdgeProperty(nodeKind: Int, direction: odb2.Edge.Direction, edgeKind: Int, size: Int): Array[?] = edgePropertyAllocators(edgeKind)(size)
         | override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[?] = nodePropertyAllocators(propertyKind)(size)
         |}""".stripMargin
    os.write(outputDir0 / "GraphSchema.scala", schemaFile)

    // Accessors and traversals: start
    // TODO extract into separate method
    val accessorsForConcreteStoredNodes = mutable.ArrayBuffer.empty[String]
    val concreteStoredConv              = mutable.ArrayBuffer.empty[String]
    val accessorsForBaseNodes           = mutable.ArrayBuffer.empty[String]
    val baseConvert                     = Seq.fill(prioStages.length + 1)(mutable.ArrayBuffer.empty[String])

    val accessorsForConcreteNodeTraversals = mutable.ArrayBuffer.empty[String]
    val concreteStoredConvTrav             = mutable.ArrayBuffer.empty[String]
    val accessorsForBaseNodeTraversals     = mutable.ArrayBuffer.empty[String]
    val baseConvertTrav                    = Seq.fill(prioStages.length + 1)(mutable.ArrayBuffer.empty[String])

    for (p <- relevantProperties) {
      val funName = Helpers.camelCase(p.name)
      accessorsForConcreteStoredNodes.addOne(
        s"""final class Access_Property_${p.name}(val node: nodes.StoredNode) extends AnyVal {
           |  def $funName: ${typeForProperty(p)}  = ${p.cardinality match {
            case Cardinality.ZeroOrOne =>
              s"odb2.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
            case Cardinality.List =>
              s"odb2.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${idByProperty(p)}, node.seq)"
            case one: Cardinality.One[?] =>
              s"odb2.Accessors.getNodePropertySingle(node.graph, node.nodeKind, ${idByProperty(p)}, node.seq(), ${unpackDefault(p.valueType, one.default)})"
          }}
           |}""".stripMargin
      )
      concreteStoredConv.addOne(
        s"""implicit def accessProperty${p.className}(node: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]): Access_Property_${p.name} = new Access_Property_${p.name}(node)""".stripMargin
      )
      accessorsForConcreteNodeTraversals.addOne(
        s"""final class Traversal_Property_${p.name}[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]](val traversal: Iterator[NodeType]) extends AnyVal {""".stripMargin +
          generatePropertyTraversals(p, idByProperty(p)) + "}"
      )
      concreteStoredConvTrav.addOne(
        s"""implicit def accessProperty${p.className}[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]](traversal: Iterator[NodeType]): Traversal_Property_${p.name}[NodeType] = new Traversal_Property_${p.name}(traversal)""".stripMargin
      )
    }

    for ((convertForStage, stage) <- baseConvert.iterator.zip(Iterator(nodeTypes) ++ prioStages.iterator)) {
      stage.foreach { baseType =>
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
        accessorsForBaseNodes.addOne(
          accessors.mkString(s"final class ${extensionClass}(val node: nodes.${baseType.className}Base) extends AnyVal {\n", "\n", "\n}")
        )
      }
    }

    for ((convertForStage, stage) <- baseConvertTrav.iterator.zip(Iterator(nodeTypes) ++ prioStages.iterator)) {
      stage.foreach { baseType =>
        val extensionClass = s"Traversal_${baseType.className}Base"
        convertForStage.addOne(
          s"implicit def traversal_${baseType.className}Base[NodeType <: nodes.${baseType.className}Base](traversal: Iterator[NodeType]): $extensionClass[NodeType] = new $extensionClass(traversal)"
        )
        val elems = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          elems.addOne(generatePropertyTraversals(p, idByProperty(p)))
        }
        accessorsForBaseNodeTraversals.addOne(
          elems.mkString(
            s"final class $extensionClass[NodeType <: nodes.${baseType.className}Base](val traversal: Iterator[NodeType]) extends AnyVal { ",
            "\n",
            "}"
          )
        )
      }
    }

    val conversionsForProperties = mutable.ArrayBuffer.empty[String]
    val conversionsForTraversals = mutable.ArrayBuffer.empty[String]

    val convBuffer     = concreteStoredConv +: baseConvert
    val convBufferTrav = concreteStoredConvTrav +: baseConvertTrav
    for (idx <- Range(0, baseConvert.length + 1)) {
      val (tname, tparent) = idx match {
        case 0 => ("ConcreteStoredConversions", Some("ConcreteBaseConversions"))
        case 1 => ("ConcreteBaseConversions", if (baseConvert.length > 1) Some("AbstractBaseConversions0") else None)
        case _ =>
          (s"AbstractBaseConversions${idx - 2}", if (idx < baseConvert.length) Some(s"AbstractBaseConversions${idx - 1}") else None)
      }
      conversionsForProperties.addOne(s"""trait $tname ${tparent.map { p => s" extends $p" }.getOrElse("")} {
           |import Accessors.*
           |${convBuffer(idx).mkString("\n")}
           |}""".stripMargin)
      conversionsForTraversals.addOne(s"""trait $tname ${tparent.map { p => s" extends $p" }.getOrElse("")} {
           |import Accessors.*
           |${convBufferTrav(idx).mkString("\n")}
           |}""".stripMargin)
    }

    val accessors =
      s"""package $basePackage.accessors
         |import io.joern.odb2
         |import $basePackage.nodes
         |import scala.collection.immutable.IndexedSeq
         |
         |object Lang extends ConcreteStoredConversions
         |
         |object Accessors {
         |  /* accessors for concrete stored nodes start */
         |  ${accessorsForConcreteStoredNodes.mkString("\n")}
         |  /* accessors for concrete stored nodes end */
         |
         |  /* accessors for base nodes start */
         |  ${accessorsForBaseNodes.mkString("\n")}
         |  /* accessors for base nodes end */
         |}
         |
         |${conversionsForProperties.mkString("\n\n")}
         |""".stripMargin

    os.write(outputDir0 / "Accessors.scala", accessors)

    val traversals =
      s"""package $basePackage.traversals
         |import io.joern.odb2
         |import $basePackage.nodes
         |
         |object Lang extends ConcreteStoredConversions
         |
         |object Accessors {
         |  import $basePackage.accessors.Lang.*
         |  import odb2.misc.Misc
         |
         |  /* accessors for concrete stored nodes start */
         |  ${accessorsForConcreteNodeTraversals.mkString("\n")}
         |  /* accessors for concrete stored nodes end */
         |
         |  /* accessors for base nodes start */
         |  ${accessorsForBaseNodeTraversals.mkString("\n")}
         |  /* accessors for base nodes end */
         |}
         |${conversionsForTraversals.mkString("\n\n")}
         |""".stripMargin
    os.write(outputDir0 / "Traversals.scala", traversals)

    // TODO extract to separate method
    val neighborAccessors = {
      val neighborAccessorsForConcreteNodes = {
        val neighborAccessorsForConcreteNodes = Seq.newBuilder[String]
        schema.allNodeTypes.foreach { nodeType =>
          val stepImplementations = Seq.newBuilder[String]
          for {
            direction <- Direction.all
            AdjacentNode(edge, neighbor, cardinality, customStepName, customStepDoc) <- nodeType.edges(direction)
          } {
            def addStepImplementation(methodName: String): Unit = {
              val edgeAccessorName = Helpers.camelCase(edge.name + "_" + direction)
              val accessorImpl0 = s"node._$edgeAccessorName.iterator.collectAll[nodes.${neighbor.className}]"
              val source = cardinality match {
                case EdgeType.Cardinality.List =>
                  s"def $methodName: Iterator[nodes.${neighbor.className}] = $accessorImpl0"
                case EdgeType.Cardinality.ZeroOrOne =>
                  s"def $methodName: Option[nodes.${neighbor.className}] = $accessorImpl0.nextOption()"
                case EdgeType.Cardinality.One =>
                  s"""def $methodName: nodes.${neighbor.className} = {
                     |  try { $accessorImpl0.next() } catch {
                     |    case e: java.util.NoSuchElementException =>
                     |      throw new io.joern.odb2.SchemaViolationException("$direction edge with label ${edge.name} to an adjacent ${neighbor.name} is mandatory, but not defined for this ${nodeType.name} node with seq=" + node.seq, e)
                     |  }
                     |}""".stripMargin
              }
              val scaladoc = s"""/** ${customStepDoc.getOrElse("")}
                                |  * Traverse to ${neighbor.name} via ${edge.name} $direction edge. */""".stripMargin
              stepImplementations.addOne(
                s"""$scaladoc
                   |$source
                   |""".stripMargin)
            }
            addStepImplementation(methodName = "_" + Helpers.camelCase(s"${neighbor.name}_Via_${edge.name}_$direction"))
            customStepName.foreach(addStepImplementation)
          }
          val className = Helpers.camelCaseCaps(s"Access_Neighbors_For_${nodeType.name}")
          neighborAccessorsForConcreteNodes.addOne(
            s"""final class $className(val node: nodes.${nodeType.className}) extends AnyVal {
               |  ${stepImplementations.result().sorted.distinct.mkString("\n\n")}
               |}
               |""".stripMargin
          )
        }
        neighborAccessorsForConcreteNodes.result()
      }

      val neighborAccessorsForBaseNodes = mutable.ArrayBuffer.empty[String]
      val concreteStoredConv2 = mutable.ArrayBuffer.empty[String]


      // TODO cleanup
      /*
        for (p <- relevantProperties) {
        concreteStoredConv.addOne(
          s"""implicit def accessProperty${p.className}(node: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}T]): Access_Property_${p.name} = new Access_Property_${p.name}(node)""".stripMargin
        )
       */

      val newInEdgesByNodeType: Map[AbstractNodeType, Set[AdjacentNode]] =
        schema.allNodeTypes.map { nodeType =>
          nodeType -> nodeType.inEdges.toSet.diff(nodeType.extendzRecursively.flatMap(_.inEdges).toSet)
        }.toMap
      val newOutEdgesByNodeType: Map[AbstractNodeType, Set[AdjacentNode]] =
        schema.allNodeTypes.map { nodeType =>
          nodeType -> nodeType.outEdges.toSet.diff(nodeType.extendzRecursively.flatMap(_.outEdges).toSet)
        }.toMap

      val prioStages: Array[Array[NodeBaseType]] = {
        val prioStages = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[NodeBaseType]]
        for (baseType <- schema.nodeBaseTypes) {
          val inEdges = newInEdgesByNodeType(baseType)
          val outEdges = newOutEdgesByNodeType(baseType)
          prioStages.find { stage =>
            stage.forall(other => newInEdgesByNodeType(other).intersect(inEdges).isEmpty &&
                                 newOutEdgesByNodeType(other).intersect(outEdges).isEmpty)
          } match {
            case Some(value) => value.addOne(baseType)
            case None => prioStages.addOne(mutable.ArrayBuffer(baseType))
          }
        }
        prioStages.map(_.toArray).toArray
      }

      val baseConvert = Seq.fill(prioStages.length + 1)(mutable.ArrayBuffer.empty[String])

      for ((convertForStage, stage) <- baseConvert.iterator.zip(Iterator(nodeTypes) ++ prioStages.iterator)) {
        stage.foreach { baseType =>
          val extensionClass = s"Access_${baseType.className}Base"
          convertForStage.addOne(
            s"//XX2 implicit def access_${baseType.className}Base(node: nodes.${baseType.className}Base): $extensionClass = new $extensionClass(node)"
          )
          val accessors = mutable.ArrayBuffer.empty[String]
          for (p <- newPropsAtNodeList(baseType)) {
            val funName = Helpers.camelCase(p.name)
            accessors.addOne(s"""def ${funName}: ${typeForProperty(p)}  = node match {
            | case stored: nodes.StoredNode => new Access_Property_${p.name}(stored).${funName}
            | // XX1 case newNode: nodes.newName /XX1b => newNode.${funName}
            |}""".stripMargin)
          }
          accessorsForBaseNodes.addOne(
            accessors.mkString(s"final class ${extensionClass}(val node: nodes.${baseType.className}Base) extends AnyVal {\n", "\n", "\n}")
          )
        }
      }

      // TODO: abstract and reuse: prioritized traits names
      val conversionsForNeighborAccessors = mutable.ArrayBuffer.empty[String]
      val convBuffer = concreteStoredConv2 +: baseConvert
      for (idx <- Range(0, baseConvert.length + 1)) {
        val (tname, tparent) = idx match {
          case 0 => ("ConcreteStoredConversions", Some("ConcreteBaseConversions"))
          case 1 => ("ConcreteBaseConversions", if (baseConvert.length > 1) Some("AbstractBaseConversions0") else None)
          case _ =>
            (s"AbstractBaseConversions${idx - 2}", if (idx < baseConvert.length) Some(s"AbstractBaseConversions${idx - 1}") else None)
        }
        conversionsForNeighborAccessors.addOne(
          s"""trait $tname ${tparent.map { p => s" extends $p" }.getOrElse("")} {
             |import Accessors.*
             |${convBuffer(idx).mkString("\n")}
             |}""".stripMargin
        )
      }

      s"""package $basePackage.neighboraccessors
         |import io.joern.odb2
         |import io.joern.odb2.Traversal.*
         |import $basePackage.nodes
         |
         |// object Lang extends ConcreteStoredConversions
         |
         |object Accessors {
         |  // import $basePackage.accessors.Lang.*
         |
         |  /* accessors for concrete stored nodes start */
         |  ${neighborAccessorsForConcreteNodes.mkString("\n\n")}
         |  /* accessors for concrete stored nodes end */
         |
         |  /* accessors for base nodes start */
         |  ${neighborAccessorsForBaseNodes.mkString("\n\n")}
         |  /* accessors for base nodes end */
         |}
         |${conversionsForNeighborAccessors.mkString("\n\n")}
         |""".stripMargin
    }
    os.write(outputDir0 / "NeighborAccessors.scala", neighborAccessors)
    // Accessors and traversals: end

    // domain object and starters: start
    // TODO: extract into separate method
    val sanitizeReservedNames = Map("return" -> "ret", "type" -> "typ", "import" -> "imports").withDefault(identity)
    val concreteStarters = nodeTypes.iterator.zipWithIndex.map { case (typ, idx) =>
      s"""def ${sanitizeReservedNames(
          Helpers.camelCase(typ.name)
        )}: Iterator[nodes.${typ.className}] = wrappedCpg.graph.nodes($idx).asInstanceOf[Iterator[nodes.${typ.className}]]"""
    }.toList
    val baseStarters = schema.nodeBaseTypes.iterator.map { baseType =>
      s"""def ${sanitizeReservedNames(Helpers.camelCase(baseType.name))}: Iterator[nodes.${baseType.className}] = Iterator(${nodeTypes
          .filter { _.extendzRecursively.contains(baseType) }
          .map { t => "this." + sanitizeReservedNames(Helpers.camelCase(t.name)) }
          .mkString(", ")}).flatten"""
    }.toList
    val domainShortName = schema.domainShortName
    val domainMain =
      s"""package $basePackage
         |import io.joern.odb2
         |
         |object $domainShortName {
         |  def empty: $domainShortName = new $domainShortName(new odb2.Graph(GraphSchema))
         |}
         |class $domainShortName(val graph: odb2.Graph) {
         |assert(graph.schema == GraphSchema)
         |}
         |
         |class ${domainShortName}NodeStarters(val wrappedCpg: $domainShortName) extends AnyVal {
         |  def all: Iterator[nodes.AbstractNode] = wrappedCpg.graph.allNodes.asInstanceOf[Iterator[nodes.AbstractNode]]
         |
         |${concreteStarters.mkString("\n")}
         |
         |${baseStarters.mkString("\n")}
         |}
         |""".stripMargin
    os.write(outputDir0 / s"$domainShortName.scala", domainMain)
  }
  // domain object and starters: end
  // end generate

  def typeForProperty(p: Property[?]): String = {
    val typ = unpackTypeUnboxed(p.valueType, isStored = true, raised = false)
    p.cardinality match {
      case Cardinality.ZeroOrOne => s"Option[$typ]"
      case Cardinality.List      => s"IndexedSeq[$typ]"
      case _: Cardinality.One[?] => typ
    }
  }

  def classNameToBase(className: String): String = {
    className match {
      case "StoredNode" => "AbstractNode"
      case other        => s"${other}Base"
    }
  }

  def generatePropertyTraversals(property: Property[?], propertyId: Int): String = {
    // fixme: also generate negated filters
    val nameCamelCase = Helpers.camelCase(property.name)
    val baseType      = unpackTypeUnboxed(property.valueType, isStored = false, raised = false)
    val cardinality   = property.cardinality

    val mapOrFlatMap = cardinality match {
      case Cardinality.One(_)                       => "map"
      case Cardinality.ZeroOrOne | Cardinality.List => "flatMap"
    }

    val filterSteps = (cardinality, property.valueType) match {
      case (Cardinality.List, _)                      => ""
      case (Cardinality.One(_), ValueType.String)     => FilterSteps.forSingleString(nameCamelCase, baseType, propertyId)
      case (Cardinality.ZeroOrOne, ValueType.String)  => FilterSteps.forOptionalString(nameCamelCase, baseType, propertyId)
      case (Cardinality.One(_), ValueType.Boolean)    => FilterSteps.forSingleBoolean(nameCamelCase, baseType)
      case (Cardinality.ZeroOrOne, ValueType.Boolean) => FilterSteps.forOptionalBoolean(nameCamelCase, baseType)
      case (Cardinality.One(_), ValueType.Int)        => FilterSteps.forSingleInt(nameCamelCase, baseType)
      case (Cardinality.ZeroOrOne, ValueType.Int)     => FilterSteps.forOptionalInt(nameCamelCase, baseType)
      case (Cardinality.One(_), _)                    => FilterSteps.genericSingle(nameCamelCase, baseType)
      case (Cardinality.ZeroOrOne, _)                 => FilterSteps.genericOption(nameCamelCase, baseType)
      case _                                          => ""
    }

    s"""/** Traverse to $nameCamelCase property */
       |def $nameCamelCase: Iterator[$baseType] =
       |  traversal.$mapOrFlatMap(_.$nameCamelCase)
       |
       |$filterSteps
       |""".stripMargin

  }
  def unpackDefault(typ: ValueType[?], default: Default[?]): String = {
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
  def unpackTypeUnboxed(tpe: ValueType[?], isStored: Boolean, raised: Boolean = false): String = {
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

  def unpackTypeBoxed(tpe: ValueType[?], isStored: Boolean): String = {
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

    assert(
      relevantPropertiesSet.size == relevantPropertiesSet.map(_.name).size,
      s"""relevantPropertiesSet should have exactly one entry per entry name, but that's not the case...
         |relevantPropertiesSet entries: ${relevantPropertiesSet.toSeq.sortBy(_.name)}
         |relevantPropertiesSet names:   ${relevantPropertiesSet.map(_.name).toSeq}
         |""".stripMargin
    )

    PropertyContexts(relevantPropertiesSet.toArray.sortBy(_.name), containingByName.view.toMap)
  }

}