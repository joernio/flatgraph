package flatgraph.codegen

import java.nio.file.Path
import flatgraph.codegen.CodeSnippets.{FilterSteps, NewNodeInserters}
import flatgraph.codegen.Helpers._
import flatgraph.schema.{AbstractNodeType, AdjacentNode, Direction, EdgeType, MarkerTrait, NodeBaseType, NodeType, Property, Schema}
import flatgraph.schema.Helpers._
import flatgraph.schema.Property.{Cardinality, Default, ValueType}

import scala.collection.mutable

class DomainClassesGenerator(schema: Schema) {
  import DomainClassesGenerator.ConstantContext
  private var enableScalafmt               = true
  private var scalafmtConfig: Option[Path] = None

  def disableScalafmt: this.type = {
    enableScalafmt = false
    this
  }

  /** replace entire default scalafmt config (from Formatter.defaultScalafmtConfig) with custom config */
  def withScalafmtConfig(path: Path): this.type = {
    this.scalafmtConfig = Option(path)
    this
  }

  def run(outputDir: Path): Seq[Path] = {
    val basePackage = schema.basePackage

    val outputDir0 = {
      val outputDirRoot           = os.Path(outputDir.toAbsolutePath)
      val outputDirForBasePackage = outputDirRoot / os.RelPath(basePackage.replace('.', '/'))

      // start clean
      os.remove.all(outputDirForBasePackage)
      os.makeDir.all(outputDirForBasePackage)
      outputDirForBasePackage
    }
    def makeSubdirectory(name: String): os.Path = {
      val subdir = outputDir0 / name
      os.makeDir(subdir)
      subdir
    }
    val accessorsOutputDir         = makeSubdirectory("accessors")
    val edgesOutputDir             = makeSubdirectory("edges")
    val neighborAccessorsOutputDir = makeSubdirectory("neighboraccessors")
    val nodesOutputDir             = makeSubdirectory("nodes")
    val traversalsOutputDir        = makeSubdirectory("traversals")

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
    val edgeKindByType         = edgeTypes.zipWithIndex.toMap

    val newPropertiesByNodeType: Map[AbstractNodeType, Set[Property[?]]] =
      schema.allNodeTypes.map { nodeType =>
        nodeType -> nodeType.properties.toSet.diff(nodeType.extendzRecursively.flatMap(_.properties).toSet)
      }.toMap
    val newPropsAtNodeList = newPropertiesByNodeType.view.map { case (key, values) =>
      key -> values.toList.sortBy(_.name)
    }.toMap
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
       |final def _${camelCase(et.name)}Out: Iterator[StoredNode] = flatgraph.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, ${edgeKindByType(et)}).asInstanceOf[Iterator[StoredNode]]
       |final def _${camelCase(et.name)}In: Iterator[StoredNode] = flatgraph.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, ${edgeKindByType(et)}).asInstanceOf[Iterator[StoredNode]]
       |""".stripMargin
    }.mkString("\n")
    // format: on

    val schemaDefinedMarkerTraits = schema.allNodeTypes
      .flatMap(_.markerTraits)
      .distinct
      .map { case MarkerTrait(name) => s"trait $name" }
      .sorted
      .mkString("\n")

    os.write(
      nodesOutputDir / "RootTypes.scala",
      s"""package $basePackage.nodes
         |
         |trait StaticType[+T]
         |
         |trait AbstractNode extends flatgraph.DNodeOrNode with StaticType[AnyRef] with Product {
         |  def label: String
         |
         |  def properties: Map[String, Any] = {
         |    scala.jdk.CollectionConverters.MapHasAsScala(propertiesMap).asScala.toMap
         |  }
         |
         |  /** TODO deprecate and phase out */
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
         |  def copy: this.type
         |}
         |""".stripMargin
    )

    generateRootTypesTraversals(schema).foreach { source =>
      os.write(nodesOutputDir / "RootTypesTraversals.scala", source)
    }

    val markerTraitsForProperties = relevantProperties
      .map { p =>
        s"""/** Node types with this marker trait are guaranteed to have the ${p.name} property.
         |   * EMT stands for: "erased marker trait", it exists only at compile time in order to improve type safety. */
         |trait Has${p.className}EMT""".stripMargin
      }
      .mkString("\n")
    // format: off
    val basetypefile = schema.nodeBaseTypes.map { baseType =>
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
          pname = camelCase(property.name)
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
      // format: on
      .mkString(
        s"""package $basePackage.nodes
           |
           |""".stripMargin,
        "\n\n",
        s"\n$schemaDefinedMarkerTraits\n$markerTraitsForProperties\n"
      )
    os.write(nodesOutputDir / "BaseTypes.scala", basetypefile)

    val edgeKindByEdgeType = edgeTypes.iterator.zipWithIndex.toMap
    // format: off
    val edgeTypesSource = edgeTypes.iterator.map { edgeType =>
      val propertyAccessorMaybe: Option[String] = edgeType.property.map { p =>
        p.cardinality match {
          case _: Cardinality.One[?] =>
            s"""def ${camelCase(p.name)}: ${unpackTypeUnboxed(p.valueType, true )} =
                |  this.property.asInstanceOf[${unpackTypeUnboxed(p.valueType, true)}]""".stripMargin
          case Cardinality.ZeroOrOne =>
            s"""def ${camelCase(p.name)}: Option[${unpackTypeUnboxed(p.valueType, true)}] =
                |  Option(this.property.asInstanceOf[${unpackTypeBoxed(p.valueType, true)}])""".stripMargin
          case Cardinality.List =>
            throw new RuntimeException("edge properties are only supported with cardinality one or optional")
        }
      }

      val propertyNameImplForObject = edgeType.property.map { property=>
        s"""val propertyName: Option[String] = Some("${property.name}")"""
      }
      val propertyNameImplForClass = propertyNameImplForObject.map { _ =>
        s"override def propertyName: Option[String] = ${edgeType.className}.propertyName"
      }

      s"""object ${edgeType.className} {
          |  val Label = "${edgeType.name}"
          |  ${propertyNameImplForObject.getOrElse("")}
          |}
          |
          |class ${edgeType.className}(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
          |  extends flatgraph.Edge(src_4762, dst_4762, ${edgeKindByEdgeType(edgeType)}.toShort, subSeq_4862, property_4862) {
          |  ${propertyNameImplForClass.getOrElse("")}
          |}
          |""".stripMargin
      // format: on
      }
      .mkString(
        s"""package $basePackage.edges
          |
          |""".stripMargin,
        "\n",
        "\n"
      )
    if (edgeTypes.nonEmpty) {
      os.write(edgesOutputDir / "EdgeTypes.scala", edgeTypesSource)
    }

    nodeTypes.iterator.zipWithIndex.foreach { case (nodeType, kind) =>
      val newExtendz    = newExtendzMap(nodeType)
      val newProperties = newPropsAtNodeList(nodeType)

      val erasedMarkerType = {
        val mixins = newExtendz.map(b => s"${b.className}EMT") ++ newProperties.map(p => s"Has${p.className}EMT")
        s"""/** Node base type for compiletime-only checks to improve type safety.
           | * EMT stands for: "erased marker trait", i.e. it is erased at runtime */
           |trait ${nodeType.className}EMT extends AnyRef""".stripMargin +: mixins
      }.mkString(" with ")

      val baseTrait = {
        val mixins = newExtendz.map(base => base.className + "Base") :+ s"StaticType[${nodeType.className}EMT]"
        s"""trait ${nodeType.className}Base extends AbstractNode""" +: mixins
      }.mkString(" with ")

      val storedNode = {
        val mixins = s"${nodeType.className}Base" +: newExtendz.map(_.className) :+ s"StaticType[${nodeType.className}EMT]"
        s"""class ${nodeType.className}(graph_4762: flatgraph.Graph, seq_4762: Int) extends StoredNode(graph_4762, $kind.toShort , seq_4762)""" +: mixins
      }.mkString(" with ")

      val newNodeProps       = mutable.ArrayBuffer.empty[String]
      val newNodeFluent      = mutable.ArrayBuffer.empty[String]
      val storedNodeProps    = mutable.ArrayBuffer.empty[String]
      val baseNodeProps      = mutable.ArrayBuffer.empty[String]
      val propDictItems      = mutable.ArrayBuffer.empty[String]
      val flattenItems       = mutable.ArrayBuffer.empty[String]
      val newNodeHelpersCode = mutable.ArrayBuffer.empty[String]
      val productElements    = mutable.ArrayBuffer.empty[String]

      for (p <- nodeType.properties) {
        val pname = camelCase(p.name)
        productElements.addOne(pname)
        val ptyp = unpackTypeUnboxed(p.valueType, false, false)
        p.cardinality match {
          case Cardinality.List =>
            newNodeProps.append(s"var $pname: IndexedSeq[$ptyp] = ArraySeq.empty")
            newNodeFluent.append(s"def $pname(value: IterableOnce[$ptyp]): this.type = {this.$pname = value.iterator.to(ArraySeq); this }")
            propDictItems.append(
              s"""val tmp${p.className} = this.$pname; if(tmp${p.className}.nonEmpty) res.put("${p.name}", tmp${p.className})"""
            )
            flattenItems.append(s"interface.countProperty(this, ${propertyKindByProperty(p)}, ${pname}.size)")
            newNodeHelpersCode.append(NewNodeInserters.forMultiItem(pname, nodeType.className, ptyp, false))
          case Cardinality.ZeroOrOne =>
            newNodeProps.append(s"var $pname: Option[$ptyp] = None")
            newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
            newNodeFluent.append(
              s"def $pname(value: ${unpackTypeUnboxed(p.valueType, false, false)}): this.type = {this.$pname = Option(value); this }"
            )
            propDictItems.append(s"""this.$pname.foreach{p => res.put("${p.name}", p )}""")
            flattenItems.append(s"interface.countProperty(this, ${propertyKindByProperty(p)}, ${pname}.size)")
            newNodeHelpersCode.append(NewNodeInserters.forOptionalItem(pname, nodeType.className, ptyp, false))

          case one: Cardinality.One[?] =>
            newNodeProps.append(s"var $pname: $ptyp = ${unpackDefault(p.valueType, one.default)}")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
            propDictItems.append(s"""if ((${unpackDefault(p.valueType, one.default)}) != this.$pname) res.put("${p.name}", this.$pname )""")
            flattenItems.append(s"interface.countProperty(this, ${propertyKindByProperty(p)}, 1)")
            newNodeHelpersCode.append(NewNodeInserters.forSingleItem(pname, nodeType.className, ptyp, false))
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
            // flattenItems.append(s"""if($pname.nonEmpty) interface.insertProperty(this, $pid, this.$pname)""")
            flattenItems.append(s"interface.countProperty(this, $pid, ${pname}.size)")
            flattenItems.append(s"${pname}.foreach(interface.visitContainedNode)")
            newNodeHelpersCode.append(NewNodeInserters.forMultiItem(pname, nodeType.className, "flatgraph.GNode", true))

          case Cardinality.ZeroOrOne =>
            newNodeProps.append(s"var $pname: Option[$ptyp] = None")
            newNodeFluent.append(s"def $pname(value: Option[$ptyp]): this.type = {this.$pname = value; this }")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = Option(value); this }")
            baseNodeProps.append(s"def $pname: Option[$ptyp]")
            storedNodeProps.append(
              s"def $pname: Option[${styp}] = flatgraph.Accessors.getNodePropertyOption[$styp](graph, nodeKind, $index, seq)"
            )
            propDictItems.append(s"""this.$pname.foreach{p => res.put("$pname", p )}""")
            flattenItems.append(s"interface.countProperty(this, $pid, ${pname}.size)")
            flattenItems.append(s"${pname}.foreach(interface.visitContainedNode)")
            newNodeHelpersCode.append(NewNodeInserters.forOptionalItem(pname, nodeType.className, "flatgraph.GNode", true))
          case _: Cardinality.One[?] =>
            newNodeProps.append(s"var $pname: $ptyp = null")
            newNodeFluent.append(s"def $pname(value: $ptyp): this.type = {this.$pname = value; this }")
            baseNodeProps.append(s"def $pname: $ptyp")
            storedNodeProps.append(
              s"def $pname: ${styp} = flatgraph.Accessors.getNodePropertySingle(graph, nodeKind, $index, seq, null: ${styp})"
            )
            propDictItems.append(s"""res.put("$pname", this.$pname )""")
            flattenItems.append(s"interface.countProperty(this, $pid, 1)")
            flattenItems.append(s"interface.visitContainedNode($pname)")
            newNodeHelpersCode.append(NewNodeInserters.forSingleItem(pname, nodeType.className, "flatgraph.GNode", true))

        }
      }

      // format: off
      val productElementNames = productElements.zipWithIndex.map { case (name, index) =>
        s"""case $index => "$name""""
      }.mkString("\n")

      val productElementAccessors = productElements.zipWithIndex.map { case (name, index) =>
        s"case $index => this.$name"
      }.mkString("\n")

      val propertyNames = {
        val sourceLines = Seq.newBuilder[String]
        nodeType.properties.map { property =>
          s"""${scaladocMaybe(property.comment)}
             |val ${camelCaseCaps(property.name)} = "${property.name}" """.stripMargin
        }.map(sourceLines.addOne)
        nodeType.containedNodes.map { containedNode =>
          s"""${scaladocMaybe(containedNode.comment)}
             |val ${camelCaseCaps(containedNode.localName)} = "${containedNode.localName}" """.stripMargin.trim
        }.map(sourceLines.addOne)
        sourceLines.result().mkString("\n")
      }

      val properties = {
        val sourceLines = Seq.newBuilder[String]
        nodeType.properties.map { property =>
          propertyKeySource(property, propertyKindByProperty(property))
        }.map(sourceLines.addOne)
        sourceLines.result().mkString("\n")
      }

      val propertyDefaults = nodeType.properties.collect {
        case p if p.hasDefault =>
          s"""val ${p.className} = ${Helpers.defaultValueImpl(p.default.get)}"""
      }.mkString("\n")
      // format: on

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

      val newNodeMixins =
        Seq
          .newBuilder[String]
          .addOne(s"${nodeType.className}Base")
          .addAll(nodeType.extendz.map(nodeType => s"${nodeType.className}New"))
          // TODO this should really be `New${nodeType.className}`, but it was like this in ODB, so not sure if now is the best time to change it...
          .result()
          .mkString("with ", " with ", "")

      val newNode =
        s"""object New${nodeType.className} {
           |  def apply(): New${nodeType.className} = new New${nodeType.className}
           |  private val outNeighbors: Map[String, Set[String]] = Map(${neighborEdgeStr(outEdges)})
           |  private val inNeighbors: Map[String, Set[String]] = Map(${neighborEdgeStr(inEdges)})
           |
           |  object InsertionHelpers {
           |      ${newNodeHelpersCode.mkString("\n")}
           |  }
           |}
           |
           |class New${nodeType.className} extends NewNode(${nodeKindByNodeType(nodeType)}.toShort) $newNodeMixins {
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
            "override def countAndVisitProperties(interface: flatgraph.BatchedUpdateInterface): Unit = {\n",
            "\n",
            "\n}"
          )}
           |
           |  override def copy: this.type = {
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
           | import $basePackage.accessors.languagebootstrap.*
           | val res = new java.util.HashMap[String, Any]()
           |""".stripMargin,
        "\n",
        "\n res\n}"
      )
      val nodeSource = {
        s"""package $basePackage.nodes
           |
           |import $basePackage.language.*
           |import scala.collection.immutable.{IndexedSeq, ArraySeq}
           |import scala.collection.mutable
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
           |  object Properties {
           |    $properties
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
      os.write(nodesOutputDir / s"${nodeType.className}.scala", nodeSource)
    }

    val schemaFile = {
      val nodeLabelsSrc = nodeKindByNodeType.toList
        .sortBy { case (_, kind) => kind }
        .map { case (nodeType, _) => s""""${nodeType.name}"""" }
        .mkString(", ")
      val edgePropertyAllocatorsSrc = edgeTypes.zipWithIndex
        .map { case (edge, idx) =>
          edge.property match {
            case Some(p) if p.cardinality == Cardinality.ZeroOrOne => ???
            case Some(p) =>
              s"size => Array.fill(size)(${Helpers.defaultValueImpl(p.cardinality.asInstanceOf[Cardinality.One[?]].default)}) /* label = ${edge.name}, id = $idx */"
            case None => "size => null"
          }
        }
        .mkString(", ")
      val edgeFactoriesSrc = edgeTypes.map { e => s"(s, d, subseq, p) => new edges.${e.className}(s, d, subseq, p)" }.mkString(", ")
      val nodeFactoriesSrc = nodeTypes.map { node => s"(g, seq) => new nodes.${node.className}(g, seq)" }.mkString(", ")
      val nodePropertyAllocatorsSrc = (relevantProperties.map { p =>
        s"size => new Array[${unpackTypeUnboxed(p.valueType, true, raised = true)}](size)"
      }.iterator ++ containedNames.map { _ => "size => new Array[flatgraph.GNode](size)" }).mkString(", ")
      val nodePropertyByLabelSrc = containedIndexByName.toList
        .sortBy { case (name, idx) => (idx, name) }
        .map { case (name, idx) => s""".updated("$name", ${relevantProperties.size + idx})""" }
        .mkString
      val containedNodesAsPropertyCases = nodeTypes
        .flatMap(nt => nt.containedNodes.map((nt, _)))
        .map { case (node, contained) =>
          val propertyKind = relevantProperties.length + containedIndexByName(contained.localName)
          s"""    else if(propertyKind == $propertyKind && nodeKind == ${nodeKindByNodeType(
              node
            )}) "${contained.localName}" /*on node ${node.name}*/"""
        }
        .toList
        .sorted
        .mkString("\n")

      val nodePropertyDescriptorsSource = {
        val sourceLines = Seq.newBuilder[String]
        val length      = (relevantProperties.length + containedNames.length) * nodeTypes.length * 2
        sourceLines.addOne(s"""{
             |  val nodePropertyDescriptors = new Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType]($length)
             |  for (idx <- Range(0, $length)) {
             |    nodePropertyDescriptors(idx) =
             |      if ((idx & 1) == 0) FormalQtyType.NothingType
             |      else                FormalQtyType.QtyNone
             |  }
             |""".stripMargin)
        for ((node, nodeKind) <- nodeTypes.zipWithIndex) {
          for (property <- node.properties) {
            val propertyKind = propertyKindByProperty(property)
            val typ =
              property.valueType match {
                case ValueType.Boolean => "FormalQtyType.BoolType"
                case ValueType.Byte    => "FormalQtyType.ByteType"
                case ValueType.Short   => "FormalQtyType.ShortType"
                case ValueType.Int     => "FormalQtyType.IntType"
                case ValueType.Long    => "FormalQtyType.LongType"
                case ValueType.Float   => "FormalQtyType.FloatType"
                case ValueType.Double  => "FormalQtyType.DoubleType"
                case ValueType.String  => "FormalQtyType.StringType"
                case _                 => ???
              }
            val qty = property.cardinality match {
              case Cardinality.ZeroOrOne => "FormalQtyType.QtyOption"
              case Cardinality.List      => "FormalQtyType.QtyMulti"
              case _: Cardinality.One[?] => "FormalQtyType.QtyOne"
            }
            val pos = 2 * (nodeKind + nodeTypes.length * propertyKind)
            sourceLines.addOne(s"""  nodePropertyDescriptors($pos) = $typ // ${node.name}.${property.name}""")
            sourceLines.addOne(s"""  nodePropertyDescriptors(${pos + 1}) = $qty""")
          }
          for (containedNode <- node.containedNodes) {
            val propertyKind = relevantProperties.length + containedIndexByName(containedNode.localName)
            val typ          = "FormalQtyType.RefType"
            val qty = containedNode.cardinality match {
              case Cardinality.ZeroOrOne => "FormalQtyType.QtyOption"
              case Cardinality.List      => "FormalQtyType.QtyMulti"
              case _: Cardinality.One[?] => "FormalQtyType.QtyOne"
            }
            val pos = 2 * (nodeKind + nodeTypes.length * propertyKind)
            sourceLines.addOne(s"""  nodePropertyDescriptors($pos) = $typ // ${node.name}.${containedNode.localName}""")
            sourceLines.addOne(s"""  nodePropertyDescriptors(${pos + 1}) = $qty""")
          }
        }
        sourceLines.addOne("  nodePropertyDescriptors") // return statement
        sourceLines.addOne("}")
        sourceLines.result()
      }
      val newNodePropertyHelpers = {
        val inserters = mutable.ArrayBuffer.empty[String]
        for ((node, nodeKind) <- nodeTypes.zipWithIndex) {
          for (property <- node.properties) {
            val propertyKind = propertyKindByProperty(property)
            val pos          = 2 * (nodeKind + nodeTypes.length * propertyKind)
            val name         = s"nodes.New${node.className}.InsertionHelpers.NewNodeInserter_${node.className}_${camelCase(property.name)}"
            inserters.append(s"_newNodeInserters(${pos}) = $name")
          }
          for (cn <- node.containedNodes) {
            val localName = cn.localName
            val index     = relevantProperties.size + containedIndexByName(localName)
            val pos       = 2 * (nodeKind + nodeTypes.length * index)
            val name      = s"nodes.New${node.className}.InsertionHelpers.NewNodeInserter_${node.className}_${localName}"
            inserters.append(s"_newNodeInserters(${pos}) = $name")
          }
        }
        s"""private val newNodeInsertionHelpers: Array[flatgraph.NewNodePropertyInsertionHelper] = {
           |  val _newNodeInserters = new Array[flatgraph.NewNodePropertyInsertionHelper](${2 * nodeTypes.length * (relevantProperties.length + containedIndexByName.size)})
           |  ${inserters.mkString("\n")}
           |  _newNodeInserters
           |}""".stripMargin
      }

      val nodePropertyNameCases = for {
        nodeType <- nodeTypes
        propertyNames = nodeType.properties.map(p => s""""${p.name}"""").mkString(", ")
      } yield s"""case "${nodeType.name}" => Set($propertyNames)"""

      val edgePropertyNameCases = for {
        edgeType <- edgeTypes
        property <- edgeType.property
      } yield s"""case "${edgeType.name}" => Some("${property.name}")"""

      // format: off
      s"""package $basePackage
         |
         |import flatgraph.FormalQtyType
         |
         |object GraphSchema extends flatgraph.Schema {
         |  private val nodeLabels = IndexedSeq($nodeLabelsSrc)
         |  val nodeKindByLabel = nodeLabels.zipWithIndex.toMap
         |  val edgeLabels: Array[String] = Array(${edgeTypes.map { e => s""""${e.name}"""" }.mkString(", ")})
         |  val edgeKindByLabel = edgeLabels.zipWithIndex.toMap
         |  val edgePropertyAllocators: Array[Int => Array[?]] = Array($edgePropertyAllocatorsSrc)
         |  val nodeFactories: Array[(flatgraph.Graph, Int) => nodes.StoredNode] = Array($nodeFactoriesSrc)
         |  val edgeFactories: Array[(flatgraph.GNode, flatgraph.GNode, Int, Any) => flatgraph.Edge] = Array($edgeFactoriesSrc)
         |  val nodePropertyAllocators: Array[Int => Array[?]] = Array($nodePropertyAllocatorsSrc)
         |  val normalNodePropertyNames: Array[String] = Array(${relevantProperties.map { p => s""""${p.name}"""" }.mkString(", ")})
         |  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap$nodePropertyByLabelSrc
         |  val nodePropertyDescriptors: Array[FormalQtyType.FormalQuantity | FormalQtyType.FormalType] = ${nodePropertyDescriptorsSource.mkString("\n")}
         |  ${newNodePropertyHelpers}
         |  override def getNumberOfNodeKinds: Int = ${nodeTypes.length}
         |  override def getNumberOfEdgeKinds: Int = ${edgeTypes.length}
         |  override def getNodeLabel(nodeKind: Int): String = nodeLabels(nodeKind)
         |  override def getNodeKindByLabel(label: String): Int = nodeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
         |  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
         |  override def getEdgeKindByLabel(label: String): Int = edgeKindByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
         |  override def getNodePropertyNames(nodeLabel: String): Set[String] = {
         |    nodeLabel match {
         |      ${nodePropertyNameCases.mkString("\n")}
         |      case _ => Set.empty
         |    }
         |  }
         |  override def getEdgePropertyName(label: String): Option[String] = {
         |    label match {
         |      ${edgePropertyNameCases.mkString("\n")}
         |      case _ => None
         |    }
         |  }
         |
         |  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String = {
         |    if(propertyKind < ${relevantProperties.length}) normalNodePropertyNames(propertyKind)
         |    $containedNodesAsPropertyCases
         |    else null
         |  }
         |
         |  override def getPropertyKindByName(label: String): Int = nodePropertyByLabel.getOrElse(label, flatgraph.Schema.UndefinedKind)
         |  override def getNumberOfPropertyKinds: Int = ${relevantProperties.size + containedNames.size}
         |  override def makeNode(graph: flatgraph.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
         |  override def makeEdge(src: flatgraph.GNode, dst: flatgraph.GNode, edgeKind: Short, subSeq: Int, property: Any): flatgraph.Edge = edgeFactories(edgeKind)(src, dst, subSeq, property)
         |  override def allocateEdgeProperty(nodeKind: Int, direction: flatgraph.Edge.Direction, edgeKind: Int, size: Int): Array[?] = edgePropertyAllocators(edgeKind)(size)
         |  override def getNodePropertyFormalType(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalType = nodePropertyDescriptors(propertyOffsetArrayIndex(nodeKind, propertyKind)).asInstanceOf[FormalQtyType.FormalType]
         |  override def getNodePropertyFormalQuantity(nodeKind: Int, propertyKind: Int): FormalQtyType.FormalQuantity = nodePropertyDescriptors(1 + propertyOffsetArrayIndex(nodeKind, propertyKind)).asInstanceOf[FormalQtyType.FormalQuantity]
         |
         |  override def getNewNodePropertyInserter (nodeKind: Int, propertyKind: Int): flatgraph.NewNodePropertyInsertionHelper = newNodeInsertionHelpers(propertyOffsetArrayIndex(nodeKind, propertyKind))
         |}""".stripMargin
      // format: on
    }
    os.write(outputDir0 / "GraphSchema.scala", schemaFile)

    os.write(
      outputDir0 / "PropertyErrorRegister.scala",
      s"""package $basePackage
         |
         |object PropertyErrorRegister {
         |  private var errorMap = Set.empty[(Class[?], String)]
         |  private val logger = org.slf4j.LoggerFactory.getLogger(getClass)
         |
         |  def logPropertyErrorIfFirst(clazz: Class[?], propertyName: String): Unit = {
         |    if (!errorMap.contains((clazz, propertyName))) {
         |      logger.warn("Property " + propertyName + " is deprecated for " + clazz.getName + ".")
         |      errorMap += ((clazz, propertyName))
         |    }
         |  }
         |}
         |""".stripMargin
    )

    // Accessors and traversals: start
    // TODO extract into separate method
    val accessorsForConcreteStoredNodes = mutable.ArrayBuffer.empty[String]
    val concreteStoredConv              = mutable.ArrayBuffer.empty[String]
    val accessorsForBaseNodes           = mutable.ArrayBuffer.empty[String]
    val baseConvert                     = Seq.fill(prioStages.length + 1)(mutable.ArrayBuffer.empty[String])

    val accessorsForConcreteNodeTraversals = mutable.ArrayBuffer.empty[ClassnameAndSource]
    val concreteStoredConvTrav             = mutable.ArrayBuffer.empty[String]
    val accessorsForBaseNodeTraversals     = mutable.ArrayBuffer.empty[ClassnameAndSource]
    val baseConvertTrav                    = Seq.fill(prioStages.length + 1)(mutable.ArrayBuffer.empty[String])

    for (p <- relevantProperties) {
      val funName = camelCase(p.name)
      accessorsForConcreteStoredNodes.addOne(
        s"""final class ${propertyAccessorClassname(p.name)}(val node: nodes.StoredNode) extends AnyVal {
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
        s"""implicit def accessProperty${p.className}(node: nodes.StoredNode & nodes.StaticType[nodes.Has${p.className}EMT]): ${propertyAccessorClassname(
            p.name
          )} = new ${propertyAccessorClassname(p.name)}(node)""".stripMargin
      )

      val concreteNodeTravClassname = traversalPropertyClassname(p.name)
      accessorsForConcreteNodeTraversals.addOne(
        ClassnameAndSource(
          concreteNodeTravClassname,
          s"""final class $concreteNodeTravClassname[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.Has${p.className}EMT]](val traversal: Iterator[NodeType]) extends AnyVal {""".stripMargin +
            generatePropertyTraversals(p, propertyKindByProperty(p)) + "}"
        )
      )
      concreteStoredConvTrav.addOne(
        s"""implicit def accessProperty${p.className}Traversal[NodeType <: nodes.StoredNode & nodes.StaticType[nodes.Has${p.className}EMT]](traversal: IterableOnce[NodeType]): ${traversalPropertyClassname(
            p.name
          )}[NodeType] = new ${traversalPropertyClassname(p.name)}(traversal.iterator)""".stripMargin
      )
    }

    for ((convertForStage, stage) <- baseConvert.iterator.zip(Iterator(nodeTypes) ++ prioStages.iterator)) {
      stage.foreach { baseType =>
        val extensionClass     = s"${accessorClassname(baseType.className)}Base"
        val implicitMethodName = camelCase(s"access_${baseType.className}Base")
        convertForStage.addOne(
          s"implicit def $implicitMethodName(node: nodes.${baseType.className}Base): $extensionClass = new $extensionClass(node)"
        )
        val newName = if (baseType.isInstanceOf[NodeBaseType]) { baseType.className + "New" }
        else { "New" + baseType.className }
        val accessors = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          val funName = camelCase(p.name)
          accessors.addOne(s"""def ${funName}: ${typeForProperty(p)}  = node match {
          | case stored: nodes.StoredNode => new ${propertyAccessorClassname(p.name)}(stored).${funName}
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
        val extensionClass     = camelCaseCaps(s"Traversal_${baseType.className}_Base")
        val implicitMethodName = camelCase(s"traversal_${baseType.className}_Base")
        convertForStage.addOne(
          s"implicit def $implicitMethodName[NodeType <: nodes.${baseType.className}Base](traversal: IterableOnce[NodeType]): $extensionClass[NodeType] = new $extensionClass(traversal.iterator)"
        )
        val elems = mutable.ArrayBuffer.empty[String]
        for (p <- newPropsAtNodeList(baseType)) {
          elems.addOne(generatePropertyTraversals(p, propertyKindByProperty(p)))
        }
        accessorsForBaseNodeTraversals.addOne(
          ClassnameAndSource(
            extensionClass,
            elems.mkString(
              s"final class $extensionClass[NodeType <: nodes.${baseType.className}Base](val traversal: Iterator[NodeType]) extends AnyVal { ",
              "\n",
              "}"
            )
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
           |${convBuffer(idx).mkString("\n")}
           |}""".stripMargin)
      conversionsForTraversals.addOne(s"""trait $tname ${tparent.map { p => s" extends $p" }.getOrElse("")} {
           |${convBufferTrav(idx).mkString("\n")}
           |}""".stripMargin)
    }

    os.write(
      accessorsOutputDir / "Accessors.scala",
      s"""package $basePackage.accessors
         |import $basePackage.nodes
         |import scala.collection.immutable.IndexedSeq
         |
         |/** not supposed to be used directly by users, hence the `bootstrap` in the name */
         |object languagebootstrap extends ConcreteStoredConversions
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
         |import Accessors.*
         |${conversionsForProperties.mkString("\n\n")}
         |""".stripMargin
    )

    os.write(
      traversalsOutputDir / "package.scala",
      s"""package $basePackage
         |
         |import $basePackage.nodes
         |
         |package object traversals {
         |  
         |  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
         |  object languagebootstrap extends ConcreteStoredConversions
         |  
         |  ${conversionsForTraversals.mkString("\n\n")}
         |}
         |""".stripMargin
    )

    (accessorsForConcreteNodeTraversals ++ accessorsForBaseNodeTraversals).foreach { case ClassnameAndSource(classname, source) =>
      os.write(
        traversalsOutputDir / s"$classname.scala",
        s"""package $basePackage.traversals
           |
           |import $basePackage.nodes
           |import $basePackage.accessors.languagebootstrap.*
           |
           |$source
           |""".stripMargin
      )
    }

    writeNeighborAccessors(neighborAccessorsOutputDir, basePackage)
    // Accessors and traversals: end

    // domain object and starters: start
    // TODO: extract into separate method
    val domainShortName       = schema.domainShortName
    val sanitizeReservedNames = Map("return" -> "ret", "type" -> "typ", "import" -> "imports").withDefault(identity)
    val starters              = mutable.ArrayBuffer[String]()
    nodeTypes.zipWithIndex.collect { case (typ, idx) =>
      typ.starterName.foreach { starterName =>
        // starter for this concrete node type
        val comment = typ.comment.getOrElse("").trim
        starters.append(
          s"""/** $comment */
             |@flatgraph.help.Doc(info = \"\"\"$comment\"\"\")
             |def $starterName: Iterator[nodes.${typ.className}] = wrapped$domainShortName.graph._nodes($idx).asInstanceOf[Iterator[nodes.${typ.className}]]""".stripMargin
        )

        // starter for primary key property (if defined) of this concrete node type
        typ.primaryKey.foreach { property =>
          // note: we cannot use our reverse index for property lookup here because the given key might be a regex
          val propertyNameCamelCase = camelCase(property.name)
          val docText               = s"Shorthand for $starterName.$propertyNameCamelCase"
          starters.append(
            s"""/** $docText */
               |def $starterName($propertyNameCamelCase: ${typeFor(
                property
              )}): Iterator[nodes.${typ.className}] = $starterName.$propertyNameCamelCase($propertyNameCamelCase)""".stripMargin
          )
        }
      }
    }

    schema.nodeBaseTypes.foreach { baseType =>
      baseType.starterName.foreach { starterName =>
        val docTextInfo    = baseType.comment.getOrElse("").trim
        val subTypes       = schema.nodeTypes.filter(_.extendzRecursively.contains(baseType)).map(_.name).sorted.mkString(", ")
        val docTextVerbose = s"""subtypes: $subTypes"""
        val concreteSubTypeStarters = nodeTypes.collect {
          case typ if typ.extendzRecursively.contains(baseType) =>
            "this." + sanitizeReservedNames(camelCase(typ.name))
        }
        starters.append(s"""
             |/** $docTextInfo
             | *  $docTextVerbose
             | */
             |@flatgraph.help.Doc(info = \"\"\"$docTextInfo\"\"\", longInfo = \"\"\"$docTextVerbose\"\"\")
             |def $starterName: Iterator[nodes.${baseType.className}] = Iterator(${concreteSubTypeStarters.mkString(", ")}).flatten
             |""".stripMargin)
      }
    }

    val domainMain =
      s"""package $basePackage
         |import flatgraph.{DiffGraphApplier, DiffGraphBuilder}
         |import flatgraph.help.DocSearchPackages
         |import flatgraph.help.Table.AvailableWidthProvider
         |import $basePackage.language.*
         |
         |object $domainShortName {
         |  val defaultDocSearchPackage = DocSearchPackages.default.withAdditionalPackage(getClass.getPackage.getName)
         |
         |@scala.annotation.implicitNotFound(
         |  \"\"\"If you're using flatgraph purely without a schema and associated generated domain classes, you can
         |    |start with `given DocSearchPackages = DocSearchPackages.default`.
         |    |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
         |    |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
         |    |\"\"\".stripMargin)
         |  def help(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
         |    flatgraph.help.TraversalHelp(searchPackageNames).forTraversalSources(verbose = false)
         |
         |@scala.annotation.implicitNotFound(
         |  \"\"\"If you're using flatgraph purely without a schema and associated generated domain classes, you can
         |    |start with `given DocSearchPackages = DocSearchPackages.default`.
         |    |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
         |    |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
         |    |\"\"\".stripMargin)
         |  def helpVerbose(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
         |    flatgraph.help.TraversalHelp(searchPackageNames).forTraversalSources(verbose = true)
         |
         |  def empty: $domainShortName = new $domainShortName(new flatgraph.Graph(GraphSchema))
         |
         |  def from(initialElements: DiffGraphBuilder => DiffGraphBuilder): $domainShortName = {
         |    val graph = new flatgraph.Graph(GraphSchema)
         |    DiffGraphApplier.applyDiff(graph, initialElements(new DiffGraphBuilder(GraphSchema)))
         |    new $domainShortName(graph)
         |  }
         |
         |  /** Instantiate a new graph with storage. If the file already exists, this will deserialize the given file into memory.
         |   * `Graph.close` will serialise graph to that given file (and override whatever was there before), unless you
         |   * specify `persistOnClose = false`. */
         |  def withStorage(storagePath: java.nio.file.Path, persistOnClose: Boolean = true): $domainShortName = {
         |    val graph = flatgraph.Graph.withStorage(GraphSchema, storagePath, persistOnClose)
         |    new $domainShortName(graph)
         |  }
         |
         |  def newDiffGraphBuilder: DiffGraphBuilder = new DiffGraphBuilder(GraphSchema)
         |}
         |
         |class $domainShortName(private val _graph: flatgraph.Graph = new flatgraph.Graph(GraphSchema)) extends AutoCloseable {
         |  def graph: flatgraph.Graph = _graph
         |
         |  def help(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
         |    $domainShortName.help
         |  def helpVerbose(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
         |    $domainShortName.helpVerbose
         |
         |  override def close(): Unit =
         |    _graph.close()
         |
         |  override def toString(): String =
         |    String.format("$domainShortName[%s]", graph)
         |}
         |
         |@flatgraph.help.TraversalSource
         |class ${domainShortName}NodeStarters(val wrapped$domainShortName: $domainShortName) {
         |
         |  @flatgraph.help.Doc(info = "all nodes")
         |  def all: Iterator[nodes.StoredNode] = wrapped$domainShortName.graph.allNodes.asInstanceOf[Iterator[nodes.StoredNode]]
         |  
         |  def id(nodeId: Long):Iterator[nodes.StoredNode] = Option(wrapped$domainShortName.graph.node(nodeId)).iterator.asInstanceOf[Iterator[nodes.StoredNode]]
         |
         |  def ids(nodeIds: Long*):Iterator[nodes.StoredNode] = nodeIds.iterator.flatMap(id)
         |
         |${starters.mkString("\n\n")}
         |}
         |""".stripMargin
    os.write(outputDir0 / s"$domainShortName.scala", domainMain)
    // domain object and starters: end

    os.write(
      outputDir0 / "language.scala",
      s"""package $basePackage
         |
         |/** combining all implicits into one trait that can be mixed in further downstream */
         |trait language
         |  extends accessors.ConcreteStoredConversions
         |  with traversals.ConcreteStoredConversions
         |  with neighboraccessors.Conversions
         |  with flatgraph.traversal.language
         |  with flatgraph.help.language
         |  with flatgraph.Implicits {
         |    implicit def toGeneratedNodeStarters(domain: $domainShortName): ${domainShortName}NodeStarters = ${domainShortName}NodeStarters(domain)
         |  }
         |
         |object language extends language
         |""".stripMargin
    )

    val lastSeparatorIdx  = basePackage.lastIndexOf('.')
    val packageParent     = basePackage.take(lastSeparatorIdx)
    val packageSimpleName = basePackage.drop(lastSeparatorIdx + 1)
    os.write(
      outputDir0 / "package.scala",
      s"""package $packageParent
         |
         |package object $packageSimpleName {
         |  // some type aliases so that the domain-specific code can avoid referencing the `flatgraph` namespace
         |  type DiffGraphBuilder = _root_.flatgraph.DiffGraphBuilder
         |  
         |  object help {
         |    type Doc = _root_.flatgraph.help.Doc
         |    type Traversal = _root_.flatgraph.help.Traversal
         |    type TraversalSource = _root_.flatgraph.help.TraversalSource
         |  }
         |}
         |""".stripMargin
    )

    writeConstants(outputDir0, schema, KindContexts(nodeKindByNodeType, edgeKindByEdgeType, propertyKindByProperty))
    // end `run`

    val results = os.walk(outputDir0)
    if (enableScalafmt) {
      val scalaSources = results.filter(_.ext == "scala").map(_.toNIO)
      Formatter.run(scalaSources, scalafmtConfig)
    }
    results.map(_.toNIO)
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
      val allConstantsBody    = constants.map(constant => s"add(${constant.name});").mkString("\n")
      val allConstantsSetMaybe = if (generateCombinedConstantsSet) {
        s"""public static Set<$allConstantsSetType> ALL = new HashSet<$allConstantsSetType>() {{
           |$allConstantsBody
           |}};
           |""".stripMargin
      } else ""
      val file = outputDir / s"$className.java"
      os.write(
        file,
        s"""package ${schema.basePackage};
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
        ConstantContext(
          property.name.toUpperCase,
          s"""public static final String ${property.name.toUpperCase} = "${property.name}";""",
          property.comment
        )
      }
    )
    writeConstants(
      "NodeTypes",
      schema.nodeTypes.map { nodeType =>
        ConstantContext(
          nodeType.name.toUpperCase,
          s"""public static final String ${nodeType.name.toUpperCase} = "${nodeType.name}";""",
          nodeType.comment
        )
      }
    )
    writeConstants(
      "EdgeTypes",
      schema.edgeTypes.map { edgeType =>
        ConstantContext(
          edgeType.name.toUpperCase,
          s"""public static final String ${edgeType.name.toUpperCase} = "${edgeType.name}";""",
          edgeType.comment
        )
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

    val propertyKeysConstantsSource = {
      schema.properties.filter(kindContexts.propertyKindByProperty.contains).map { property =>
        propertyKeySource(property, propertyKind = kindContexts.propertyKindByProperty(property))
      }
    }.mkString("\n\n")
    val file = outputDir / "Properties.scala"
    os.write(
      file,
      s"""package ${schema.basePackage}
         |
         |object Properties {
         |$propertyKeysConstantsSource
         |}""".stripMargin
    )
    results.addOne(file)

    results.result()
  }

  def writeNeighborAccessors(outputDir: os.Path, basePackage: String): Unit = {
    val conversions = Seq.newBuilder[String]

    case class NeighborContext(adjacentNode: AdjacentNode, scaladoc: String, defaultMethodName: String, customStepName: Option[String])
    case class NeighborContextsByEdge(direction: Direction.Value, edge: EdgeType, neighborContexts: Seq[NeighborContext]) {
      lazy val edgeAccessorName = camelCase(edge.name + "_" + direction)

      /** common root type across neighbors via this edge */
      lazy val commonNeighborClassName =
        Helpers.deriveCommonRootType(neighborContexts.map(_.adjacentNode.neighbor).toSet).getOrElse(schema.anyNode).className
    }

    schema.allNodeTypes.map { nodeType =>

      val neighborContextsByEdge: Seq[NeighborContextsByEdge] =
        Direction.all.flatMap { direction =>
          nodeType
            .edges(direction)
            .groupBy(_.viaEdge)
            .map { case (edge, adjacentNodes) =>
              val neighborContexts = adjacentNodes.map { adjacentNode =>
                val scaladoc = s"""/** ${adjacentNode.customStepDoc.getOrElse("")}
                                | * Traverse to ${adjacentNode.neighbor.name} via ${edge.name} $direction edge. */""".stripMargin
                val defaultMethodName = "_" + camelCase(s"${adjacentNode.neighbor.name}_Via_${edge.name}_$direction")
                NeighborContext(adjacentNode, scaladoc, defaultMethodName, adjacentNode.customStepName)
              }
              NeighborContextsByEdge(direction, edge, neighborContexts)
            }
        }

      val forSingleNode = {
        val stepImplementations = Seq.newBuilder[String]
        neighborContextsByEdge.foreach { case context @ NeighborContextsByEdge(direction, edge, neighborContexts) =>
          stepImplementations.addOne(
            s"def ${context.edgeAccessorName}: Iterator[nodes.${context.commonNeighborClassName}] = node._${context.edgeAccessorName}.cast[nodes.${context.commonNeighborClassName}]"
          )

          neighborContexts.foreach { case NeighborContext(adjacentNode, scaladoc, defaultMethodName, customStepName) =>
            val accessorImpl0 = s"${context.edgeAccessorName}.collectAll[nodes.${adjacentNode.neighbor.className}]"
            val (primaryMethodName, secondaryMethodNameMaybe) = customStepName match {
              case Some(name) => (name, Some(defaultMethodName))
              case None       => (defaultMethodName, None)
            }
            val source = adjacentNode.cardinality match {
              case EdgeType.Cardinality.List =>
                s"def $primaryMethodName: Iterator[nodes.${adjacentNode.neighbor.className}] = $accessorImpl0"
              case EdgeType.Cardinality.ZeroOrOne =>
                s"def $primaryMethodName: Option[nodes.${adjacentNode.neighbor.className}] =   $accessorImpl0.nextOption()"
              case EdgeType.Cardinality.One =>
                s"""def $primaryMethodName: nodes.${adjacentNode.neighbor.className} = {
                   |  try { $accessorImpl0.next() } catch {
                   |    case e: java.util.NoSuchElementException =>
                   |      throw new flatgraph.SchemaViolationException("$direction edge with label ${edge.name} to an adjacent ${adjacentNode.neighbor.name} is mandatory, but not defined for this ${nodeType.name} node with seq=" + node.seq, e)
                   |  }
                   |}""".stripMargin
            }
            stepImplementations.addOne(s"""$scaladoc
                 |$source
                 |""".stripMargin)

            secondaryMethodNameMaybe.foreach { methodName =>
              val source = adjacentNode.cardinality match {
                case EdgeType.Cardinality.List =>
                  s"def $methodName: Iterator[nodes.${adjacentNode.neighbor.className}] = $primaryMethodName"
                case EdgeType.Cardinality.ZeroOrOne =>
                  s"def $methodName: Option[nodes.${adjacentNode.neighbor.className}]   = $primaryMethodName"
                case EdgeType.Cardinality.One =>
                  s"def $methodName: nodes.${adjacentNode.neighbor.className}           = $primaryMethodName"
              }
              stepImplementations.addOne(s"""$scaladoc
                   |@deprecated("please use $primaryMethodName instead")
                   |$source
                   |""".stripMargin)
            }
          }
        }

        if (stepImplementations.result().isEmpty) {
          ""
        } else {
          val className = camelCaseCaps(s"Access_Neighbors_For_${nodeType.name}")
          conversions.addOne(s"""implicit def accessNeighborsFor${nodeType.className}(node: nodes.${nodeType.className}): $className =
               |  new $className(node)""".stripMargin)
          s"""final class $className(val node: nodes.${nodeType.className}) extends AnyVal {
             |  ${stepImplementations.result().sorted.distinct.mkString("\n\n")}
             |}
             |""".stripMargin
        }
      }

      val forTraversal = {
        val stepImplementations = Seq.newBuilder[String]
        neighborContextsByEdge.foreach { case context =>
          stepImplementations.addOne(
            s"def ${context.edgeAccessorName}: Iterator[nodes.${context.commonNeighborClassName}] = traversal.flatMap(_.${context.edgeAccessorName})"
          )

          context.neighborContexts
            .map { case NeighborContext(adjacentNode, scaladoc, defaultMethodName, customStepName) =>
              val mapOrFlatMap = if (adjacentNode.cardinality == EdgeType.Cardinality.One) "map" else "flatMap"
              def methodImpl(name: String) =
                s"def $name: Iterator[nodes.${adjacentNode.neighbor.className}] = traversal.$mapOrFlatMap(_.$name)"
              customStepName match {
                case None =>
                  s"""$scaladoc
                   |${methodImpl(defaultMethodName)}
                   |""".stripMargin
                case Some(customStepName) =>
                  s"""$scaladoc
                   |${methodImpl(customStepName)}
                   |
                   |$scaladoc
                   |@deprecated("please use $customStepName instead")
                   |${methodImpl(defaultMethodName)}
                   |""".stripMargin
              }
            }
            .foreach(stepImplementations.addOne)
        }

        if (stepImplementations.result().isEmpty) {
          ""
        } else {
          val className = camelCaseCaps(s"Access_Neighbors_For_${nodeType.name}_Traversal")
          conversions.addOne(
            s"""implicit def accessNeighborsFor${nodeType.className}Traversal(traversal: IterableOnce[nodes.${nodeType.className}]): $className =
               |  new $className(traversal.iterator)""".stripMargin
          )
          s"""final class $className(val traversal: Iterator[nodes.${nodeType.className}]) extends AnyVal {
             |  ${stepImplementations.result().sorted.distinct.mkString("\n\n")}
             |}
             |""".stripMargin
        }
      }

      if (forSingleNode.trim.size + forTraversal.trim.size > 0) {
        os.write(
          outputDir / s"${nodeType.className}.scala",
          s"""
             |package $basePackage.neighboraccessors
             |
             |import $basePackage.nodes
             |import $basePackage.language.*
             |
             |$forSingleNode
             |$forTraversal
             |""".stripMargin
        )
      }
    }

    os.write(
      outputDir / "package.scala",
      s"""package $basePackage
         |
         |import flatgraph.traversal.language.*
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
  def generateRootTypesTraversals(schema: Schema): Option[String] = {
    val neighborSteps = schema.edgeTypes.map { edgeType =>
      val stepNameBase = s"_${camelCase(edgeType.name)}"
      s"""
      |final def ${stepNameBase}Out: Iterator[StoredNode] = iterator.flatMap(_.${stepNameBase}Out)
      |final def ${stepNameBase}In:  Iterator[StoredNode] = iterator.flatMap(_.${stepNameBase}In)
      |""".stripMargin
    }

    if (neighborSteps.isEmpty) {
      None
    } else {
      Some(s"""
          |package ${schema.basePackage}.nodes
          |
          |extension (iterator: Iterator[StoredNode]) {
          |  ${neighborSteps.mkString("\n")}
          |}
          |""".stripMargin)
    }
  }

  def generatePropertyTraversals(property: Property[?], propertyId: Int): String = {
    val nameCamelCase = camelCase(property.name)
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
      case ValueType.Boolean                                          => s"${default.value}: Boolean"
      case ValueType.String if default.value == null                  => "null: String"
      case ValueType.String                                           => s""""${escapeJava(default.value.asInstanceOf[String])}": String"""
      case ValueType.Byte                                             => s"${default.value}.toByte"
      case ValueType.Short                                            => s"${default.value}.toShort"
      case ValueType.Int                                              => s"${default.value}: Int"
      case ValueType.Long                                             => s"${default.value}L: Long"
      case ValueType.Float if default.value.asInstanceOf[Float].isNaN => "Float.NaN"
      case ValueType.Float                                            => s"${default.value}f: Float"
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

  def propertyKeySource(property: Property[?], propertyKind: Int): String = {
    val valueTypeUnpacked = unpackTypeUnboxed(property.valueType, isStored = false)
    val propertyKeyImpl = property.cardinality match {
      case Cardinality.One(default) =>
        val defaultValueImpl = Helpers.defaultValueImpl(default)
        s"""flatgraph.SinglePropertyKey[$valueTypeUnpacked](kind = $propertyKind, name = "${property.name}", default = $defaultValueImpl)"""
      case Cardinality.ZeroOrOne =>
        s"""flatgraph.OptionalPropertyKey[$valueTypeUnpacked](kind = $propertyKind, name = "${property.name}")"""
      case Cardinality.List =>
        s"""flatgraph.MultiPropertyKey[$valueTypeUnpacked](kind = $propertyKind, name = "${property.name}")"""
    }
    s"""${scaladocMaybe(property.comment)}
       |val ${camelCaseCaps(property.name)} = $propertyKeyImpl""".stripMargin.trim
  }

  private case class ClassnameAndSource(classname: String, source: String)

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

  def accessorClassname(nodeType: String): String =
    camelCaseCaps(s"Access_$nodeType")

  def propertyAccessorClassname(propertyName: String): String =
    camelCaseCaps(s"Access_Property_$propertyName")

  def traversalPropertyClassname(propertyName: String): String =
    camelCaseCaps(s"Traversal_Property_$propertyName")

  /** Useful string extensions to avoid Scala version incompatible interpolations.
    */
  implicit class StringHelper(s: String) {
    def quote: String = s""""$s""""
  }

  /** for scala3 api compat */
  implicit class ArrayBufferCompat[A](buffer: mutable.ArrayBuffer[A]) {
    def addOne(element: A): mutable.ArrayBuffer[A] =
      buffer += element
  }

  /** for scala3 api compat */
  implicit class BuilderCompat[A, To](buffer: mutable.Builder[A, To]) {
    def addOne(element: A): mutable.Builder[A, To] =
      buffer += element

    def addAll(elements: Iterable[A]): mutable.Builder[A, To] = {
      elements.foreach(buffer.+=)
      buffer
    }
  }

}

object DomainClassesGenerator {
  case class ConstantContext(name: String, source: String, documentation: Option[String])
}
