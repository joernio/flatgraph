package flatgraph.codegen

import flatgraph.codegen.CodeSnippets.FilterSteps
import overflowdb.codegen.CodeGen.ConstantContext

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
    val basePackage = schema.basePackage + ".v2"

    val outputDir0 = {
      val outputDirRoot = os.Path(outputDir.toAbsolutePath)

      // start with a clean slate
      os.remove.all(outputDirRoot)

      val outputDirForBasePackage = outputDirRoot / os.RelPath(basePackage.replace('.', '/'))
      os.makeDir.all(outputDirForBasePackage)
      outputDirForBasePackage
    }

    val propertyContexts   = relevantPropertyContexts(schema)
    val relevantProperties = propertyContexts.properties

    val nodeTypes          = schema.nodeTypes.sortBy(_.name).toArray
    val nodeKindByNodeType = nodeTypes.zipWithIndex.toMap

    // We used to support multiplexing of different containedNode pseudo-properties into the same index.
    // We removed that feature, look at git blame on this line to find the supporting code.
    val containedNames       = propertyContexts.containedNodesByName.keys.toArray.sorted
    val containedIndexByName = containedNames.zipWithIndex.toMap

    val propertyKindByProperty = relevantProperties.zipWithIndex.toMap
    val edgeTypes              = schema.edgeTypes.sortBy(_.name).toArray
    val edgeIdByType           = edgeTypes.zipWithIndex.toMap

    val newPropertiesByNodeType: Map[AbstractNodeType, Set[Property[?]]] =
      schema.allNodeTypes.map { nodeType =>
        nodeType -> nodeType.properties.toSet.diff(nodeType.extendzRecursively.flatMap(_.properties).toSet)
      }.toMap
    val newPropsAtNodeList = newPropertiesByNodeType.view.mapValues(_.toList.sortBy(_.name))
    val newExtendzMap = schema.allNodeTypes.map { nodeType =>
      nodeType -> nodeType.extendz.toSet.diff(nodeType.extendzRecursively.flatMap(_.extendz).toSet).toList.sortBy(_.name)
    }.toMap

    val prioStages: Array[Array[NodeBaseType]] = {
      val prioStages = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[NodeBaseType]]
      for (baseType <- schema.nodeBaseTypes) {
        val props = newPropertiesByNodeType(baseType)
        prioStages.find { stage =>
          stage.forall(other => newPropertiesByNodeType(other).intersect(props).isEmpty)
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
       |final def _${Helpers.camelCase(et.name)}Out: Iterator[StoredNode] = flatgraph.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, ${edgeIdByType(et)}).asInstanceOf[Iterator[StoredNode]]
       |final def _${Helpers.camelCase(et.name)}In: Iterator[StoredNode] = flatgraph.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, ${edgeIdByType(et)}).asInstanceOf[Iterator[StoredNode]]
       |""".stripMargin
    }.mkString("\n")
    // format: on

    val schemaDefinedMarkerTraits = schema.allNodeTypes
      .flatMap(_.markerTraits)
      .distinct
      .map { case MarkerTrait(name) => s"trait $name" }
      .sorted
      .mkString("\n")

    val rootTypes =
      s"""package $basePackage.nodes
         |
         |trait StaticType[+T]
         |
         |trait AbstractNode extends flatgraph.DNodeOrNode with StaticType[AnyRef] with Product {
         |  def label: String
         |  def propertiesMap: java.util.Map[String, Any]
         |}
         |
         |abstract class StoredNode(graph_4762: flatgraph.Graph, kind_4762: Short, seq_4762: Int) extends flatgraph.GNode(graph_4762, kind_4762, seq_4762) with AbstractNode {
         |$edgeAccess
         |}
         |
         |abstract class NewNode(val nodeKind:Short) extends AbstractNode with flatgraph.DNode {
         |  private /* volatile? */ var _storedRef: StoredNodeType      = null.asInstanceOf[StoredNodeType]
         |  override def storedRef: Option[StoredNodeType]           = Option(this._storedRef)
         |  override def storedRef_=(stored: Option[flatgraph.GNode]): Unit = this._storedRef = stored.orNull.asInstanceOf[StoredNodeType]
         |  def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean
         |  def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean
         |  def copy(): this.type
         |}
         |""".stripMargin

    os.write(outputDir0 / "RootTypes.scala", rootTypes)

    os.write(outputDir0 / "RootTypesTraversals.scala", generateRootTypesTraversals(schema))

    val markerTraitsForProperties = relevantProperties
      .map { p =>
        s"""/** Node types with this marker trait are guaranteed to have the ${p.name} property.
         |   * EMT stands for: "erased marker trait", it exists only at compile time in order to improve type safety. */
         |trait Has${p.className}EMT""".stripMargin
      }
      .mkString("\n")
    val basetypefile = schema.nodeBaseTypes
      .map { baseType =>
        val newExtendz = newExtendzMap(baseType)
        val mixinsBase = List("AbstractNode") ++ newExtendz.map(_.className + "Base") ++ baseType.markerTraits.map(_.name)

        val mixinsStored =
          List("StoredNode", s"${baseType.className}Base") ++ newExtendz.map(_.className) ++ baseType.markerTraits.map(_.name)
        val mixinsNew =
          List("NewNode", s"${baseType.className}Base") ++ baseType.extendz.map(_.className + "New") ++ baseType.markerTraits.map(_.name)
        val newProperties = newPropsAtNodeList(baseType)
        val propertyDefaults = newProperties
          .collect {
            case p if p.hasDefault =>
              s"""val ${p.className} = ${Helpers.defaultValueImpl(p.default.get)}"""
          }
          .mkString("\n")
        val mixinsEMT =
          (List("AnyRef") ++ newExtendz.map { p => s"${p.className}EMT" } ++ newProperties.map { p => s"Has${p.className}EMT" })
            .mkString(" with ")
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

        s"""trait ${baseType.className}EMT extends $mixinsEMT
           |
           |trait ${baseType.className}Base extends ${mixinsBase.mkString(" with ")} with StaticType[${baseType.className}EMT]
           | // new properties: ${newProperties.map { _.name }.mkString(", ")}
           | // inherited properties: ${oldProperties.map { _.name }.mkString(", ")}
           | // inherited interfaces: ${oldExtendz.map(_.name).mkString(", ")}
           | // implementing nodes: ${nodeTypes
            .filter { n => n.extendzRecursively.contains(baseType) }
            .map(_.name)
            .mkString(", ")}
           |trait ${baseType.className} extends ${mixinsStored.mkString(" with ")} with StaticType[${baseType.className}EMT]
           |
           |object ${baseType.className} {
           |  object PropertyDefaults {
           |    $propertyDefaults
           |  }
           |}
           |
           |trait ${baseType.className}New extends ${mixinsNew.mkString(" with ")} with StaticType[${baseType.className}EMT]{
           |  ${newNodeDefs.mkString("\n")}
           |}
           |""".stripMargin
      }
      .mkString(
        s"""package $basePackage.nodes
           |
           |""".stripMargin,
        "\n\n",
        s"\n$schemaDefinedMarkerTraits\n$markerTraitsForProperties\n"
      )
    os.write(outputDir0 / "BaseTypes.scala", basetypefile)

    val edgeKindByEdgeType = edgeTypes.iterator.zipWithIndex.toMap
    val edgeTypesSource = edgeTypes.iterator
      .map { edgeType =>
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

        s"""class ${edgeType.className}(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
           |    extends flatgraph.Edge(src_4762, dst_4762, ${edgeKindByEdgeType(
            edgeType
          )}.toShort, subSeq_4862, property_4862) $accessor""".stripMargin
      }
      .mkString(
        s"""package $basePackage.edges
           |
           |""".stripMargin,
        "\n",
        "\n"
      )
    os.write(outputDir0 / "EdgeTypes.scala", edgeTypesSource)

    val nodesRootDir = outputDir0 / "nodes"
    os.makeDir(nodesRootDir)
    nodeTypes.iterator.zipWithIndex.foreach { case (nodeType, kind) =>
      val newExtendz    = newExtendzMap(nodeType)
      val newProperties = newPropsAtNodeList(nodeType)

      val erasedMarkerType = {
        val mixins = newExtendz.map(b => s"${b.className}EMT") ++ newProperties.map(p => s"Has${p.className}EMT")
        s"""trait ${nodeType.className}EMT extends AnyRef""" +: mixins
      }.mkString(" with ")

      val baseTrait = {
        val mixins = newExtendz.map(base => base.className + "Base") :+ s"StaticType[${nodeType.className}EMT]"
        s"""trait ${nodeType.className}Base extends AbstractNode""" +: mixins
      }.mkString(" with ")

      val storedNode = {
        val mixins = s"${nodeType.className}Base" +: newExtendz.map(_.className) :+ s"StaticType[${nodeType.className}EMT]"
        s"""class ${nodeType.className}(graph_4762: flatgraph.Graph, seq_4762: Int) extends StoredNode(graph_4762, $kind.toShort , seq_4762)""" +: mixins
      }.mkString(" with ")

      val newNodeProps    = mutable.ArrayBuffer.empty[String]
      val newNodeFluent   = mutable.ArrayBuffer.empty[String]
      val storedNodeProps = mutable.ArrayBuffer.empty[String]
      val baseNodeProps   = mutable.ArrayBuffer.empty[String]
      val propDictItems   = mutable.ArrayBuffer.empty[String]
      val flattenItems    = mutable.ArrayBuffer.empty[String]
      val productElements = mutable.ArrayBuffer.empty[String]

      for (p <- nodeType.properties) {
        val pname = Helpers.camelCase(p.name)
        productElements.addOne(pname)
        val ptyp = unpackTypeUnboxed(p.valueType, false, false)
        p.cardinality match {
          case Cardinality.List =>
            newNodeProps.append(s"var $pname: IndexedSeq[$ptyp] = ArraySeq.empty")
            newNodeFluent.append(s"def $pname(value: IterableOnce[$ptyp]): this.type = {this.$pname = value.iterator.to(ArraySeq); this }")
            propDictItems.append(
              s"""val tmp${p.className} = this.$pname; if(tmp${p.className}.nonEmpty) res.put("${p.name}", tmp${p.className})"""
            )
            flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, ${propertyKindByProperty(p)}, this.$pname)""")
          case Cardinality.ZeroOrOne =>
            newNodeProps.append(s"var $pname: Option[$ptyp] = None")
            newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
            newNodeFluent.append(
              s"def $pname(value: ${unpackTypeUnboxed(p.valueType, false, false)}): this.type = {this.$pname = Option(value); this }"
            )
            propDictItems.append(s"""this.$pname.foreach{p => res.put("${p.name}", p )}""")
            flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, ${propertyKindByProperty(p)}, this.$pname)""")

          case one: Cardinality.One[?] =>
            newNodeProps.append(s"var $pname: $ptyp = ${unpackDefault(p.valueType, one.default)}")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
            propDictItems.append(s"""res.put("${p.name}", this.$pname )""")
            flattenItems.append(s"""interface.insertProperty(this, ${propertyKindByProperty(p)}, Iterator(this.$pname))""")
        }
      }

      for (c <- nodeType.containedNodes) {
        val pname = c.localName
        productElements.addOne(pname)
        val ptyp  = classNameToBase(c.nodeType.className)
        val styp  = c.nodeType.className
        val index = relevantProperties.size + containedIndexByName(c.localName)
        val pid   = propertyKindByProperty.size + containedIndexByName(pname)
        c.cardinality match {
          case Cardinality.List =>
            newNodeProps.append(s"var $pname: IndexedSeq[$ptyp] = ArraySeq.empty")
            newNodeFluent.append(s"def $pname(value: IterableOnce[$ptyp]): this.type = {this.$pname = value.iterator.to(ArraySeq); this }")
            baseNodeProps.append(s"def $pname: IndexedSeq[$ptyp]")
            storedNodeProps.append(
              s"def $pname: IndexedSeq[${styp}] = flatgraph.Accessors.getNodePropertyMulti[$styp](graph, nodeKind, $index, seq)"
            )
            propDictItems.append(s"""val tmp$pname = this.$pname; if(tmp$pname.nonEmpty) res.put("$pname", tmp$pname)""")
            flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, $pid, this.$pname)""")

          case Cardinality.ZeroOrOne =>
            newNodeProps.append(s"var $pname: Option[$ptyp] = None")
            newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = Option(value); this }")
            baseNodeProps.append(s"def $pname: Option[$ptyp]")
            storedNodeProps.append(
              s"def $pname: Option[${styp}] = flatgraph.Accessors.getNodePropertyOption[$styp](graph, nodeKind, $index, seq)"
            )
            propDictItems.append(s"""this.$pname.foreach{p => res.put("$pname", p )}""")
            flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, $pid, this.$pname)""")

          case _: Cardinality.One[?] =>
            newNodeProps.append(s"var $pname: $ptyp = null")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
            baseNodeProps.append(s"def $pname: $ptyp")
            storedNodeProps.append(
              s"def $pname: ${styp} = flatgraph.Accessors.getNodePropertySingle(graph, nodeKind, $index, seq, null: ${styp})"
            )
            propDictItems.append(s"""res.put("$pname", this.$pname )""")
            flattenItems.append(s"""interface.insertProperty(this, $pid, Iterator(this.$pname))""")
        }
      }

      val productElementNames = productElements.zipWithIndex
        .map { case (name, index) =>
          s"""case $index => "$name""""
        }
        .mkString("\n")

      val productElementAccessors = productElements.zipWithIndex
        .map { case (name, index) =>
          s"case $index => this.$name"
        }
        .mkString("\n")

      val propertyNames = nodeType.properties
        .map(_.name)
        .map { name =>
          val camelCase = Helpers.camelCaseCaps(name)
          s"""val $camelCase = $basePackage.PropertyNames.$name"""
        }
        .mkString("\n")

      val propertyDefaults = nodeType.properties
        .collect {
          case p if p.hasDefault =>
            s"""val ${p.className} = ${Helpers.defaultValueImpl(p.default.get)}"""
        }
        .mkString("\n")

      def neighborEdgeStr(es: Map[String, Set[String]]): String =
        es.toSeq.sortBy(_._1).map { case (k, vs) => s"$k -> Set(${vs.toSeq.sorted.mkString(", ")})" }.mkString(", ")

      val inEdges: Map[String, Set[String]] = {
        val inEdges0 = nodeType.inEdges.map(x => (x.viaEdge.name.quote, x.neighbor.name.quote)).toSet
        val baseTypeInEdges = nodeType.extendzRecursively
          .flatMap(_.subtypes(allNodeTypes))
          .flatMap(_.inEdges)
          .flatMap(neighborMapping)
          .toSet
        edgeNeighborToMap(baseTypeInEdges ++ inEdges0)
      }
      val outEdges: Map[String, Set[String]] = {
        val outEdges0 = nodeType.outEdges.map(x => (x.viaEdge.name.quote, x.neighbor.name.quote)).toSet
        val baseTypeOutEdges = nodeType.extendzRecursively
          .flatMap(_.subtypes(allNodeTypes))
          .flatMap(_.outEdges)
          .flatMap(neighborMapping)
          .toSet
        edgeNeighborToMap(baseTypeOutEdges ++ outEdges0)
      }

      val copyFieldsImpl = productElements
        .map { memberName =>
          s"newInstance.$memberName = this.$memberName"
        }
        .mkString("\n")

      val newNode =
        s"""object New${nodeType.className} {
           |  def apply(): New${nodeType.className} = new New${nodeType.className}
           |  private val outNeighbors: Map[String, Set[String]] = Map(${neighborEdgeStr(outEdges)})
           |  private val inNeighbors: Map[String, Set[String]] = Map(${neighborEdgeStr(inEdges)})
           |}
           |class New${nodeType.className} extends NewNode(${nodeKindByNodeType(nodeType)}.toShort) with ${nodeType.className}Base {
           |  override type StoredNodeType = ${nodeType.className}
           |  override def label: String = "${nodeType.name}"
           |
           |  override def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean = {
           |    New${nodeType.className}.outNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
           |  }
           |  override def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean = {
           |    New${nodeType.className}.inNeighbors.getOrElse(edgeLabel, Set.empty).contains(n.label)
           |  }
           |
           |  ${newNodeProps.sorted.mkString("\n")}
           |  ${newNodeFluent.sorted.mkString("\n")}
           |  ${flattenItems.mkString(
            "override def flattenProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {\n",
            "\n",
            "\n}"
          )}
           |
           |  override def copy(): this.type = {
           |    val newInstance = new New${nodeType.className}
           |    $copyFieldsImpl
           |    newInstance.asInstanceOf[this.type]
           |  }
           |
           |  override def productElementName(n: Int): String =
           |    n match {
           |      $productElementNames
           |      case _ => ""
           |    }
           |
           |  override def productElement(n: Int): Any =
           |    n match {
           |      $productElementAccessors
           |      case _ => null
           |    }
           |
           |  override def productPrefix = "New${nodeType.className}"
           |  override def productArity = ${productElements.size}
           |  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[New${nodeType.className}]
           |}""".stripMargin

      val propDictItemsSource = propDictItems.mkString(
        s"""override def propertiesMap: java.util.Map[String, Any] = {
           | import $basePackage.accessors.Lang.*
           | val res = new java.util.HashMap[String, Any]()
           |""".stripMargin,
        "\n",
        "\n res\n}"
      )
      val nodeSource = {
        s"""package $basePackage.nodes
             |
             |import io.shiftleft.codepropertygraph.generated.v2.Language.*
             |import scala.collection.immutable.{IndexedSeq, ArraySeq}
             |
             |$erasedMarkerType
             |
             |$baseTrait {
             |  ${baseNodeProps.mkString("\n")}
             |  $propDictItemsSource
             |}
             |
             |object ${nodeType.className} {
             |  val Label = "${nodeType.name}"
             |  object PropertyNames {
             |    $propertyNames
             |  }
             |  object PropertyDefaults {
             |    $propertyDefaults
             |  }
             |}
             |
             |$storedNode {
             |  ${storedNodeProps.mkString("\n")}
             |
             |  override def productElementName(n: Int): String =
             |    n match {
             |      $productElementNames
             |      case _ => ""
             |    }
             |
             |  override def productElement(n: Int): Any =
             |    n match {
             |      $productElementAccessors
             |      case _ => null
             |    }
             |
             |  override def productPrefix = "${nodeType.className}"
             |  override def productArity = ${productElements.size}
             |
             |  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[${nodeType.className}]
             |}
             |
             |$newNode
             |""".stripMargin
      }
      os.write(nodesRootDir / s"${nodeType.className}.scala", nodeSource)
    }

    val schemaFile =
      s"""package $basePackage
         |import $basePackage.nodes
         |import $basePackage.edges
         |
         |object GraphSchema extends flatgraph.Schema {
         |  val nodeLabels = Array(${nodeKindByNodeType.iterator.toList
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
         |  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] = Array(${nodeTypes
          .map { node => s"(g, seq) => new nodes.${node.className}(g, seq)" }
          .mkString(", ")})
         |  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] = Array(${edgeTypes
          .map { e => s"(s, d, subseq, p) => new edges.${e.className}(s, d, subseq, p)" }
          .mkString(", ")})
         |  val nodePropertyAllocators: Array[Int => Array[?]] = Array(${(relevantProperties.map { p =>
          s"size => new Array[${unpackTypeUnboxed(p.valueType, true, raised = true)}](size)"
        }.iterator ++ containedNames.map { _ => "size => new Array[flatgraph.GNode](size)" }).mkString(", ")})
         |  val normalNodePropertyNames = Array(${relevantProperties.map { p => s"\"${p.name}\"" }.mkString(", ")})
         |  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap${containedIndexByName.toList
          .sortBy { case (name, idx) => (idx, name) }
          .map { case (name, idx) => s".updated(\"$name\", ${relevantProperties.size + idx})" }
          .mkString}
         |
         | override def getNumberOfNodeKinds: Int = ${nodeTypes.length}
         | override def getNumberOfEdgeKinds: Int = ${edgeTypes.length}
         | override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
         | override def getNodeKindByLabel(label: String): Int = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
         | override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
         | override def getEdgeKindByLabel(label: String): Int = edgeIdByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
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
              )} && nodeKind == ${nodeKindByNodeType(node)}) \"${contained.localName}\" /*on node ${node.name}*/"
          }
          .toList
          .sorted
          .mkString("\n")}
         |    else null
         |
         | override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
         | override def getNumberOfProperties: Int = ${relevantProperties.size + containedNames.size}
         | override def makeNode(graph: flatgraph.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
         | override def makeEdge(src: flatgraph.GNode, dst: flatgraph.GNode, edgeKind: Short, subSeq: Int, property: Any): flatgraph.Edge = edgeFactories(edgeKind)(src, dst, subSeq, property)
         | override def allocateEdgeProperty(nodeKind: Int, direction: flatgraph.Edge.Direction, edgeKind: Int, size: Int): Array[?] = edgePropertyAllocators(edgeKind)(size)
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
              s"flatgraph.Accessors.getNodePropertyOption[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${propertyKindByProperty(p)}, node.seq)"
            case Cardinality.List =>
              s"flatgraph.Accessors.getNodePropertyMulti[${unpackTypeUnboxed(p.valueType, true, false)}](node.graph, node.nodeKind, ${propertyKindByProperty(p)}, node.seq)"
            case one: Cardinality.One[?] =>
              s"flatgraph.Accessors.getNodePropertySingle(node.graph, node.nodeKind, ${propertyKindByProperty(p)}, node.seq(), ${unpackDefault(p.valueType, one.default)})"
          }}
           |}""".stripMargin
      )
      concreteStoredConv.addOne(
        s"""implicit def accessProperty${p.className}(node: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}EMT]): Access_Property_${p.name} = new Access_Property_${p.name}(node)""".stripMargin
      )
      accessorsForConcreteNodeTraversals.addOne(
        s"""final class Traversal_Property_${p.name}[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}EMT]](val traversal: Iterator[NodeType]) extends AnyVal {""".stripMargin +
          generatePropertyTraversals(p, propertyKindByProperty(p)) + "}"
      )
      concreteStoredConvTrav.addOne(
        s"""implicit def accessProperty${p.className}Traversal[NodeType <: nodes.StoredNode with nodes.StaticType[nodes.Has${p.className}EMT]](traversal: IterableOnce[NodeType]): Traversal_Property_${p.name}[NodeType] = new Traversal_Property_${p.name}(traversal.iterator)""".stripMargin
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
          s"implicit def traversal_${baseType.className}Base[NodeType <: nodes.${baseType.className}Base](traversal: IterableOnce[NodeType]): $extensionClass[NodeType] = new $extensionClass(traversal.iterator)"
        )
        val elems = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          elems.addOne(generatePropertyTraversals(p, propertyKindByProperty(p)))
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
         |import $basePackage.nodes
         |
         |object Lang extends ConcreteStoredConversions
         |
         |object Accessors {
         |  import $basePackage.accessors.Lang.*
         |  import flatgraph.misc.Misc
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

    writeNeighborAccessors(outputDir0, basePackage)
    // Accessors and traversals: end

    // domain object and starters: start
    // TODO: extract into separate method
    val sanitizeReservedNames = Map("return" -> "ret", "type" -> "typ", "import" -> "imports").withDefault(identity)
    val concreteStarters = nodeTypes.iterator.zipWithIndex.map { case (typ, idx) =>
      s"""def ${sanitizeReservedNames(
          Helpers.camelCase(typ.name)
        )}: Iterator[nodes.${typ.className}] = wrappedCpg.graph._nodes($idx).asInstanceOf[Iterator[nodes.${typ.className}]]"""
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
         |import flatgraph.DiffGraphBuilder
         |
         |object $domainShortName {
         |  def empty: $domainShortName = new $domainShortName(new flatgraph.Graph(GraphSchema))
         |
         |  /** Instantiate a new graph with storage. If the file already exists, this will deserialize the given file into memory.
         |   * `Graph.close` will serialise graph to that given file (and override whatever was there before), unless you
         |   * specify `deserializeOnClose = false`. */
         |  def withStorage(storagePath: java.nio.file.Path, deserializeOnClose: Boolean = true): $domainShortName = {
         |    val graph = flatgraph.Graph.withStorage(GraphSchema, storagePath, deserializeOnClose)
         |    new $domainShortName(graph)
         |  }
         |
         |  def newDiffGraphBuilder: DiffGraphBuilder = new DiffGraphBuilder(GraphSchema)
         |}
         |
         |class $domainShortName(private val _graph: flatgraph.Graph = new flatgraph.Graph(GraphSchema)) extends AutoCloseable {
         |  def graph: flatgraph.Graph = _graph
         |  assert(graph.schema == GraphSchema)
         |
         |  override def close(): Unit =
         |    _graph.close()
         |}
         |
         |class ${domainShortName}NodeStarters(val wrappedCpg: $domainShortName) {
         |  def all: Iterator[nodes.StoredNode] = wrappedCpg.graph.allNodes.asInstanceOf[Iterator[nodes.StoredNode]]
         |
         |${concreteStarters.mkString("\n")}
         |
         |${baseStarters.mkString("\n")}
         |}
         |""".stripMargin
    os.write(outputDir0 / s"$domainShortName.scala", domainMain)
    // domain object and starters: end

    os.write(
      outputDir0 / "Language.scala",
      s"""package $basePackage
         |
         |/** combining all implicits into one trait that can be mixed in further downstream */
         |trait Language
         |  extends accessors.ConcreteStoredConversions
         |  with traversals.ConcreteStoredConversions
         |  with neighboraccessors.Conversions
         |  with flatgraph.traversal.Language
         |  with flatgraph.Implicits {
         |    implicit def cpgToGeneratedNodeStarters(cpg: Cpg): CpgNodeStarters = CpgNodeStarters(cpg)
         |  }
         |
         |object Language extends Language
         |""".stripMargin
    )

    writeConstants(outputDir0, schema, KindContexts(nodeKindByNodeType, edgeKindByEdgeType, propertyKindByProperty))
    // end `run`
  }

  private def writeConstants(outputDir: os.Path, schema: Schema, kindContexts: KindContexts): Seq[os.Path] = {
    val results = Seq.newBuilder[os.Path]
    def writeConstants(className: String, constants: Seq[ConstantContext], generateCombinedConstantsSet: Boolean = true) = {
      val constantsSource = constants
        .map { constant =>
          val documentation = constant.documentation.filter(_.nonEmpty).map(comment => s"""/** $comment */""").getOrElse("")
          s"""$documentation
           |${constant.source}
           |""".stripMargin
        }
        .mkString("\n")
      val allConstantsSetType = if (constantsSource.contains("PropertyKey")) "PropertyKey<?>" else "String"
      val allConstantsBody = constants
        .map { constant =>
          s"add(${constant.name});"
        }
        .mkString("\n")
      val allConstantsSetMaybe = if (generateCombinedConstantsSet) {
        s"""public static Set<$allConstantsSetType> ALL = new HashSet<$allConstantsSetType>() {{
           |$allConstantsBody
           |}};
           |""".stripMargin
      } else ""
      val file = outputDir / s"$className.java"
      os.write(
        file,
        s"""package ${schema.basePackage}.v2;
           |
           |import java.util.HashSet;
           |import java.util.Set;
           |
           |public class $className {
           |
           |$constantsSource
           |$allConstantsSetMaybe
           |}""".stripMargin
      )
      results.addOne(file)
    }

    writeConstants(
      "PropertyNames",
      schema.properties.map { property =>
        ConstantContext(property.name, s"""public static final String ${property.name} = "${property.name}";""", property.comment)
      }
    )
    writeConstants(
      "PropertyKinds",
      schema.properties.filter(kindContexts.propertyKindByProperty.contains).map { property =>
        ConstantContext(
          property.name,
          s"""
             |/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
             | * projects have the ability to run with newly generated domain classes
             | * see https://stackoverflow.com/a/3524336/452762 */
             |public static final int ${property.name} = Integer.valueOf(${kindContexts.propertyKindByProperty(
              property
            )}).intValue();""".stripMargin,
          property.comment
        )
      },
      generateCombinedConstantsSet = false
    )
    writeConstants(
      "NodeKinds",
      schema.nodeTypes.map { nodeType =>
        ConstantContext(
          nodeType.name,
          s"""
             |/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
             | * projects have the ability to run with newly generated domain classes
             | * see https://stackoverflow.com/a/3524336/452762 */
             |public static final int ${nodeType.name} = ${kindContexts.nodeKindByNodeType(nodeType)};""".stripMargin,
          nodeType.comment
        )
      },
      generateCombinedConstantsSet = false
    )
    writeConstants(
      "EdgeKinds",
      schema.edgeTypes.map { edgeType =>
        ConstantContext(
          edgeType.name,
          s"""
             |/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
             | * projects have the ability to run with newly generated domain classes
             | * see https://stackoverflow.com/a/3524336/452762 */
             |public static final int ${edgeType.name} = ${kindContexts.edgeKindByEdgeType(edgeType)};""".stripMargin,
          edgeType.comment
        )
      },
      generateCombinedConstantsSet = false
    )
    writeConstants(
      "NodeTypes",
      schema.nodeTypes.map { nodeType =>
        ConstantContext(nodeType.name, s"""public static final String ${nodeType.name} = "${nodeType.name}";""", nodeType.comment)
      }
    )
    writeConstants(
      "EdgeTypes",
      schema.edgeTypes.map { edgeType =>
        ConstantContext(edgeType.name, s"""public static final String ${edgeType.name} = "${edgeType.name}";""", edgeType.comment)
      }
    )
    schema.constantsByCategory.foreach { case (category, constants) =>
      writeConstants(
        category,
        constants.map { constant =>
          ConstantContext(constant.name, s"""public static final String ${constant.name} = "${constant.value}";""", constant.comment)
        }
      )
    }

    results.result()
  }

  def writeNeighborAccessors(outputDir: os.Path, basePackage: String): Unit = {
    val conversions = Seq.newBuilder[String]

    val neighborAccessorsRootDir = outputDir / "neighboraccessors"
    os.makeDir(neighborAccessorsRootDir)

    case class StepContext(
      edge: EdgeType,
      neighbor: AbstractNodeType,
      direction: Direction.Value,
      cardinality: EdgeType.Cardinality,
      methodName: String,
      scaladoc: String
    )

    schema.allNodeTypes.map { nodeType =>
      val stepContexts = for {
        direction <- Direction.all
        inheritedNeighbors = nodeType.extendzRecursively
          .flatMap(_.edges(direction))
          .map(adjacentNode => (adjacentNode.viaEdge, adjacentNode.neighbor))
          .toSet
        AdjacentNode(edge, neighbor, cardinality, customStepName, customStepDoc) <- nodeType.edges(direction)
        // to ensure we generate each `_neighborViaEdgeDirection` step only once for each node type hierarchy tree, only generate it for the highest-up node type
        // this is to avoid any 'presumably' duplicate steps, which would cause to unambiguous implicits
        if !inheritedNeighbors.contains((edge, neighbor))
        scaladoc =
          s"""/** ${customStepDoc.getOrElse("")}
             |  * Traverse to ${neighbor.name} via ${edge.name} $direction edge. */""".stripMargin
        methodName = customStepName.getOrElse("_" + Helpers.camelCase(s"${neighbor.name}_Via_${edge.name}_$direction"))
      } yield StepContext(edge, neighbor, direction, cardinality, methodName, scaladoc)

      // e.g. `def _blockViaArgumentOut: Iterator[nodes.Block] = node._argumentOut.iterator.collectAll[nodes.Block]`
      val forSingleNode = {
        val stepImplementations = stepContexts.map { case StepContext(edge, neighbor, direction, cardinality, methodName, scaladoc) =>
          val edgeAccessorName = Helpers.camelCase(edge.name + "_" + direction)
          val accessorImpl0    = s"node._$edgeAccessorName.iterator.collectAll[nodes.${neighbor.className}]"
          val source = cardinality match {
            case EdgeType.Cardinality.List =>
              s"def $methodName: Iterator[nodes.${neighbor.className}] = $accessorImpl0"
            case EdgeType.Cardinality.ZeroOrOne =>
              s"def $methodName: Option[nodes.${neighbor.className}] = $accessorImpl0.nextOption()"
            case EdgeType.Cardinality.One =>
              s"""def $methodName: nodes.${neighbor.className} = {
                 |  try { $accessorImpl0.next() } catch {
                 |    case e: java.util.NoSuchElementException =>
                 |      throw new flatgraph.SchemaViolationException("$direction edge with label ${edge.name} to an adjacent ${neighbor.name} is mandatory, but not defined for this ${nodeType.name} node with seq=" + node.seq, e)
                 |  }
                 |}""".stripMargin
          }
          s"""$scaladoc
             |$source
             |""".stripMargin
        }

        if (stepImplementations.isEmpty) {
          ""
        } else {
          val className = Helpers.camelCaseCaps(s"Access_Neighbors_For_${nodeType.name}")
          conversions.addOne(s"""implicit def accessNeighborsFor${nodeType.className}(node: nodes.${nodeType.className}): $className =
               |  new $className(node)""".stripMargin)
          s"""final class $className(val node: nodes.${nodeType.className}) extends AnyVal {
             |  ${stepImplementations.sorted.distinct.mkString("\n\n")}
             |}
             |""".stripMargin
        }
      }

      // e.g. `def _blockViaArgumentOut: Iterator[nodes.Block] = traversal.flatMap(_._blockViaArgumentOut)`
      val forTraversal = {
        val stepImplementations = stepContexts.map { case StepContext(_, neighbor, _, cardinality, methodName, scaladoc) =>
          val mapOrFlatMap = if (cardinality == EdgeType.Cardinality.One) "map" else "flatMap"
          s"""$scaladoc
             |def $methodName: Iterator[nodes.${neighbor.className}] = traversal.$mapOrFlatMap(_.$methodName)
             |""".stripMargin
        }

        if (stepImplementations.isEmpty) {
          ""
        } else {
          val className = Helpers.camelCaseCaps(s"Access_Neighbors_For_${nodeType.name}_Traversal")
          conversions.addOne(
            s"""implicit def accessNeighborsFor${nodeType.className}Traversal(traversal: IterableOnce[nodes.${nodeType.className}]): $className =
               |  new $className(traversal.iterator)""".stripMargin
          )
          s"""final class $className(val traversal: Iterator[nodes.${nodeType.className}]) extends AnyVal {
             |  ${stepImplementations.sorted.distinct.mkString("\n\n")}
             |}
             |""".stripMargin
        }
      }

      if (forSingleNode.trim.size + forTraversal.trim.size > 0) {
        os.write(
          neighborAccessorsRootDir / s"${nodeType.className}.scala",
          s"""
             |package $basePackage.neighboraccessors
             |
             |import $basePackage.nodes
             |import $basePackage.Language.*
             |
             |$forSingleNode
             |$forTraversal
             |""".stripMargin
        )
      }
    }

    os.write(
      neighborAccessorsRootDir / "package.scala",
      s"""package $basePackage
         |
         |import flatgraph.traversal.Language.*
         |import $basePackage.nodes
         |
         |package object neighboraccessors {
         |  object Lang extends Conversions
         |
         |  trait Conversions {
         |    ${conversions.result().mkString("\n\n")}
         |  }
         |}
         |""".stripMargin
    )
  }

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

  /** Generate accessors for all edge types on all Traversals for each node type. Analogous to the steps directly on StoredNode
    */
  def generateRootTypesTraversals(schema: Schema): String = {
    val neighborSteps = schema.edgeTypes
      .map { edgeType =>
        val stepNameBase = s"_${Helpers.camelCase(edgeType.name)}"
        s"""
         |final def ${stepNameBase}Out: Iterator[StoredNode] = iterator.flatMap(_.${stepNameBase}Out)
         |final def ${stepNameBase}In:  Iterator[StoredNode] = iterator.flatMap(_.${stepNameBase}In)
         |""".stripMargin
      }
      .mkString("\n")

    s"""
       |package ${schema.basePackage}.v2.nodes
       |
       |extension (iterator: Iterator[StoredNode]) {
       |  $neighborSteps
       |}
       |""".stripMargin
  }

  def generatePropertyTraversals(property: Property[?], propertyId: Int): String = {
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
      case ValueType.NodeRef if raised   => s"flatgraph.GNode"
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

  private case class KindContexts(
    nodeKindByNodeType: Map[NodeType, Int],
    edgeKindByEdgeType: Map[EdgeType, Int],
    propertyKindByProperty: Map[Property[?], Int]
  )

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

  lazy val allNodeTypes = schema.allNodeTypes.toSet

  def flattenNeighbors(x: AbstractNodeType) =
    x.extendzRecursively.flatMap(_.subtypes(schema.allNodeTypes.toSet))

  def neighborMapping(x: AdjacentNode): Set[(String, String)] = {
    val edge = x.viaEdge.name.quote
    (x.neighbor +: flattenNeighbors(x.neighbor)).map(y => (edge, y.name.quote)).toSet
  }

  def edgeNeighborToMap(xs: Set[(String, String)]): Map[String, Set[String]] =
    xs.groupBy(_._1).map { case (edge, edgeNeighbors) => edge -> edgeNeighbors.map(_._2) }

  /** Useful string extensions to avoid Scala version incompatible interpolations.
    */
  extension (s: String) {
    def quote: String = s""""$s""""

  }

}
