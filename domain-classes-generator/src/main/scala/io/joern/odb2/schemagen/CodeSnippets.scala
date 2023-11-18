package io.joern.odb2.codegen

object CodeSnippets {

  object FilterSteps {

    def forSingleString(nameCamelCase: String, baseType: String, propertyId: Int) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): Iterator[NodeType] =
         |  if(!Misc.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filter{item => matcher.reset(item.$nameCamelCase).matches}
         |  }
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
         |  traversal.filter{item => matchers.exists{_.reset(item.$nameCamelCase).matches}}
         | }
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): Iterator[NodeType] = traversal match {
         |    case init: odb2.misc.InitNodeIterator[odb2.GNode @unchecked] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  $propertyId, value).asInstanceOf[Iterator[NodeType]]
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
         |  if(!Misc.isRegex(pattern)){
         |    traversal.filter{node => node.$nameCamelCase != pattern}
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filterNot{item => matcher.reset(item.$nameCamelCase).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match any of the regular expressions in `values`.
         |  * */
         |def ${nameCamelCase}Not(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
         |  traversal.filter{item => matchers.find{_.reset(item.$nameCamelCase).matches}.isEmpty}
         |}
         |""".stripMargin
    }

    def forOptionalString(nameCamelCase: String, baseType: String, propertyId: Int) = {
      s"""/**
         |  * Traverse to nodes where the $nameCamelCase matches the regular expression `value`
         |  * */
         |def $nameCamelCase(pattern: $baseType): Iterator[NodeType] = {
         |  if(!Misc.isRegex(pattern)){
         |    ${nameCamelCase}Exact(pattern)
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filter{ item =>  val tmp = item.${nameCamelCase}; tmp.isDefined && matcher.reset(tmp.get).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where the $nameCamelCase matches at least one of the regular expressions in `values`
         |  * */
         |def $nameCamelCase(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
         |  traversal.filter{item => val tmp = item.${nameCamelCase}; tmp.isDefined && matchers.exists{_.reset(tmp.get).matches}}
         | }
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase matches `value` exactly.
         |  * */
         |def ${nameCamelCase}Exact(value: $baseType): Iterator[NodeType] = traversal match {
         |    case init: odb2.misc.InitNodeIterator[odb2.GNode @unchecked] if init.isVirgin && init.hasNext =>
         |      val someNode = init.next
         |      odb2.Accessors.getWithInverseIndex(someNode.graph, someNode.nodeKind,  $propertyId, value).asInstanceOf[Iterator[NodeType]]
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
         |  if(!Misc.isRegex(pattern)){
         |    traversal.filter{node => node.$nameCamelCase.isEmpty || node.${nameCamelCase}.get != pattern}
         |  } else {
         |    val matcher = java.util.regex.Pattern.compile(pattern).matcher("")
         |    traversal.filterNot{ item =>  val tmp = item.${nameCamelCase}; tmp.isDefined && matcher.reset(tmp.get).matches}
         |  }
         |}
         |
         |/**
         |  * Traverse to nodes where $nameCamelCase does not match any of the regular expressions in `values`.
         |  * */
         |def ${nameCamelCase}Not(patterns: $baseType*): Iterator[NodeType] = {
         |  val matchers = patterns.map{java.util.regex.Pattern.compile(_).matcher("")}
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
         |  traversal.filter{node => !vset.contains(node.$nameCamelCase)}
         |}
         |
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
         |  traversal.filter{node => node.$nameCamelCase.isDefined && !vset.contains(node.$nameCamelCase.get)}
         |}
         |""".stripMargin
    }
  }

}
