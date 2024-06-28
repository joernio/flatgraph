package flatgraph.codegen

object CodeSnippets {

  object NewNodeInserters {
    def forSingleItem(nameCamelCase: String, nodeType: String, propertyType: String, isNode: Boolean): String = {
      s"""object NewNodeInserter_${nodeType}_${nameCamelCase} extends flatgraph.NewNodePropertyInsertionHelper {
         |  override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
         |     if(newNodes.isEmpty) return
         |     val dstCast = dst.asInstanceOf[Array[${propertyType}]]
         |     val seq = newNodes.head.storedRef.get.seq()
         |     var offset = offsets(seq)
         |     var idx = 0
         |     while(idx < newNodes.length){
         |        val nn = newNodes(idx)
         |        nn match {
         |          case generated: New${nodeType} =>
         |            dstCast(offset) = ${
          if (isNode)
            s"generated.$nameCamelCase match {case newV:flatgraph.DNode => newV.storedRef.get; case oldV: flatgraph.GNode => oldV; case null => null}"
          else s"generated.${nameCamelCase}"
        }
         |            offset += 1
         |          case _ =>
         |        }
         |        assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
         |        idx += 1
         |        offsets(idx + seq) = offset
         |     }
         |  }
         |}""".stripMargin
    }
    def forOptionalItem(nameCamelCase: String, nodeType: String, propertyType: String, isNode: Boolean): String = {
      s"""object NewNodeInserter_${nodeType}_${nameCamelCase} extends flatgraph.NewNodePropertyInsertionHelper {
         |  override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
         |     if(newNodes.isEmpty) return
         |     val dstCast = dst.asInstanceOf[Array[${propertyType}]]
         |     val seq = newNodes.head.storedRef.get.seq()
         |     var offset = offsets(seq)
         |     var idx = 0
         |     while(idx < newNodes.length){
         |        val nn = newNodes(idx)
         |        nn match {
         |          case generated: New${nodeType} =>
         |            generated.${nameCamelCase} match {
         |              case Some(item) =>
         |                dstCast(offset) = ${
          if (isNode) s"item match {case newV:flatgraph.DNode => newV.storedRef.get; case oldV: flatgraph.GNode => oldV; case null => null}"
          else "item"
        }
         |                offset += 1
         |              case _ =>
         |            }
         |          case _ =>
         |        }
         |        assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
         |        idx += 1
         |        offsets(idx + seq) = offset
         |     }
         |  }
         |}""".stripMargin
    }

    def forMultiItem(nameCamelCase: String, nodeType: String, propertyType: String, isNode: Boolean): String = {
      s"""object NewNodeInserter_${nodeType}_${nameCamelCase} extends flatgraph.NewNodePropertyInsertionHelper {
         |  override def insertNewNodeProperties(newNodes: mutable.ArrayBuffer[flatgraph.DNode], dst: AnyRef, offsets: Array[Int]): Unit = {
         |     if(newNodes.isEmpty) return
         |     val dstCast = dst.asInstanceOf[Array[${propertyType}]]
         |     val seq = newNodes.head.storedRef.get.seq()
         |     var offset = offsets(seq)
         |     var idx = 0
         |     while(idx < newNodes.length){
         |        val nn = newNodes(idx)
         |        nn match {
         |          case generated: New${nodeType} =>
         |            for(item <- generated.${nameCamelCase}){
         |              dstCast(offset) = ${
          if (isNode) s"item match {case newV:flatgraph.DNode => newV.storedRef.get; case oldV: flatgraph.GNode => oldV; case null => null}"
          else "item"
        }
         |              offset += 1
         |            }
         |          case _ =>
         |        }
         |        assert(seq + idx == nn.storedRef.get.seq(), "internal consistency check")
         |        idx += 1
         |        offsets(idx + seq) = offset
         |     }
         |  }
         |}""".stripMargin
    }

  }

  object FilterSteps {

    def forSingleString(nameCamelCase: String, baseType: String, propertyId: Int) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): Iterator[NodeType] =
         |  if(!flatgraph.misc.Regex.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
         |    traversal.filter{item => matcher.reset(item.$nameCamelCase).matches}
         |  }
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
         |  traversal.filter{item => matchers.exists{_.reset(item.$nameCamelCase).matches}}
         | }
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): Iterator[NodeType] = traversal match {
         |    case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  $propertyId, value).asInstanceOf[Iterator[NodeType]]
         |    case _ => traversal.filter{_.$nameCamelCase == value}
         |  }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches one of the elements in `values` exactly.
         |  * */
         |def ${nameCamelCase}Exact(values: $baseType*): Iterator[NodeType] =
         |  if(values.length == 1) ${nameCamelCase}Exact(values.head) else {
         |  val valueSet = values.toSet
         |  traversal.filter{item => valueSet.contains(item.$nameCamelCase)}
         |  }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match the regular expression `value`.
         |  * */
         |def ${nameCamelCase}Not(pattern: $baseType): Iterator[NodeType] = {
         |  if(!flatgraph.misc.Regex.isRegex(pattern)){
         |    traversal.filter{node => node.$nameCamelCase != pattern}
         |  } else {
         |    val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
         |    traversal.filterNot{item => matcher.reset(item.$nameCamelCase).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match any of the regular expressions in `values`.
         |  * */
         |def ${nameCamelCase}Not(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
         |  traversal.filter{item => matchers.find{_.reset(item.$nameCamelCase).matches}.isEmpty}
         |}
         |""".stripMargin
    }

    def forOptionalString(nameCamelCase: String, baseType: String, propertyId: Int) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): Iterator[NodeType] = {
         |  if(!flatgraph.misc.Regex.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
         |    traversal.filter{ item =>  val tmp = item.${nameCamelCase}; tmp.isDefined && matcher.reset(tmp.get).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
         |  traversal.filter{item => val tmp = item.${nameCamelCase}; tmp.isDefined && matchers.exists{_.reset(tmp.get).matches}}
         | }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): Iterator[NodeType] = traversal match {
         |    case init: flatgraph.misc.InitNodeIterator[flatgraph.GNode @unchecked] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      flatgraph.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  $propertyId, value).asInstanceOf[Iterator[NodeType]]
         |     case _ => traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get == value}
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches one of the elements in `values` exactly.
         |  * */
         |def ${nameCamelCase}Exact(values: $baseType*): Iterator[NodeType] =
         |  if(values.length == 1) ${nameCamelCase}Exact(values.head) else {
         |  val valueSet = values.toSet
         |  traversal.filter{item => val tmp = item.$nameCamelCase; tmp.isDefined && valueSet.contains(tmp.get)}
         |  }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match the regular expression `value`.
         |  * */
         |def ${nameCamelCase}Not(pattern: $baseType): Iterator[NodeType] = {
         |  if(!flatgraph.misc.Regex.isRegex(pattern)){
         |    traversal.filter{node => node.$nameCamelCase.isEmpty || node.${nameCamelCase}.get != pattern}
         |  } else {
         |    val matcher = flatgraph.misc.Regex.multilineMatcher(pattern)
         |    traversal.filterNot{ item =>  val tmp = item.${nameCamelCase}; tmp.isDefined && matcher.reset(tmp.get).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match any of the regular expressions in `values`.
         |  * */
         |def ${nameCamelCase}Not(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map(flatgraph.misc.Regex.multilineMatcher)
         |  traversal.filterNot{item => val tmp = item.${nameCamelCase}; tmp.isDefined && matchers.exists{_.reset(tmp.get).matches}}
         | }
         |""".stripMargin
    }

    def forSingleBoolean(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |""".stripMargin
    }

    def forOptionalBoolean(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => node.$nameCamelCase.isDefined && node.$nameCamelCase.get == value}
         |""".stripMargin
    }

    def forSingleInt(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => vset.contains(node.$nameCamelCase)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is not equal to the given `value`
         |  * */
         |def ${nameCamelCase}Not(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase != value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is not equal to any of the given `values`
         |  * */
         |def ${nameCamelCase}Not(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => !vset.contains(node.$nameCamelCase)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than the given `value`
         |  * */
         |def ${nameCamelCase}Gt(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase > value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Gte(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase >= value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than the given `value`
         |  * */
         |def ${nameCamelCase}Lt(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase < value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Lte(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase <= value}
         |
         |""".stripMargin
    }

    def forOptionalInt(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && vset.contains(tmp.get)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is not equal to the given `value`
         |  * */
         |def ${nameCamelCase}Not(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isEmpty || tmp.get != value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase does not equal any one of the given `values`
         |  * */
         |def ${nameCamelCase}Not(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isEmpty || !vset.contains(tmp.get)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than the given `value`
         |  * */
         |def ${nameCamelCase}Gt(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get > value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is greater than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Gte(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get >= value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than the given `value`
         |  * */
         |def ${nameCamelCase}Lt(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get < value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase is less than or equal the given `value`
         |  * */
         |def ${nameCamelCase}Lte(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => val tmp = node.$nameCamelCase; tmp.isDefined && tmp.get <= value}
         |
         |""".stripMargin
    }

    def genericSingle(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => vset.contains(node.$nameCamelCase)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase does not equal the given `value`
         |  * */
         |def ${nameCamelCase}Not(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{_.$nameCamelCase != value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase does not equal any one of the given `values`
         |  * */
         |def ${nameCamelCase}Not(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => !vset.contains(node.$nameCamelCase)}
         |}
         |""".stripMargin
    }

    def genericOption(nameCamelCase: String, baseType: String) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase equals the given `value`
         |  * */
         |def $nameCamelCase(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => node.$nameCamelCase.isDefined && node.$nameCamelCase.get == value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase equals at least one of the given `values`
         |  * */
         |def $nameCamelCase(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => node.$nameCamelCase.isDefined && vset.contains(node.$nameCamelCase.get)}
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase does not equal the given `value`
         |  * */
         |def ${nameCamelCase}Not(value: $baseType): Iterator[NodeType] =
         |  traversal.filter{node => node.$nameCamelCase.empty || node.$nameCamelCase.get != value}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase does not equal any one of the given `values`
         |  * */
         |def ${nameCamelCase}Not(values: $baseType*): Iterator[NodeType] = {
         |  val vset = values.toSet
         |  traversal.filter{node => node.$nameCamelCase.empty || !vset.contains(node.$nameCamelCase.get)}
         |}
         |""".stripMargin
    }
  }

}
