package io.shiftleft.codepropertygraph.generated.v2
import io.joern.odb2
import io.joern.odb2.Edge.Direction
import io.shiftleft.codepropertygraph.generated.v2.{edges, nodes}

object GraphSchema extends odb2.Schema {
  val nodeLabels = Array(
    "ANNOTATION",
    "ANNOTATION_LITERAL",
    "ANNOTATION_PARAMETER",
    "ANNOTATION_PARAMETER_ASSIGN",
    "ARRAY_INITIALIZER",
    "BINDING",
    "BLOCK",
    "CALL",
    "CALL_CHAIN",
    "CALL_SITE",
    "CLOSURE_BINDING",
    "COMMENT",
    "CONFIG_FILE",
    "CONTROL_STRUCTURE",
    "DEPENDENCY",
    "DOM_ATTRIBUTE",
    "DOM_NODE",
    "FIELD_IDENTIFIER",
    "FILE",
    "FINDING",
    "FLOW",
    "FRAMEWORK",
    "FRAMEWORK_DATA",
    "IDENTIFIER",
    "IMPLICIT_CALL",
    "IMPORT",
    "IOFLOW",
    "JUMP_LABEL",
    "JUMP_TARGET",
    "KEY_VALUE_PAIR",
    "LITERAL",
    "LOCAL",
    "LOCATION",
    "MATCH_INFO",
    "MEMBER",
    "META_DATA",
    "METHOD",
    "METHOD_INST",
    "METHOD_PARAMETER_IN",
    "METHOD_PARAMETER_OUT",
    "METHOD_REF",
    "METHOD_RETURN",
    "METHOD_SUMMARY",
    "MODIFIER",
    "NAMESPACE",
    "NAMESPACE_BLOCK",
    "PACKAGE_PREFIX",
    "POST_EXECUTION_CALL",
    "PROGRAM_POINT",
    "READ",
    "RETURN",
    "ROUTE",
    "SENSITIVE_DATA_TYPE",
    "SENSITIVE_MEMBER",
    "SENSITIVE_REFERENCE",
    "SENSITIVE_VARIABLE",
    "SINK",
    "SOURCE",
    "SP_ANNOTATION_PARAMETER",
    "SP_BLACKLIST",
    "TAG",
    "TAGS",
    "TAG_NODE_PAIR",
    "TEMPLATE_DOM",
    "TRANSFORM",
    "TRANSFORMATION",
    "TYPE",
    "TYPE_ARGUMENT",
    "TYPE_DECL",
    "TYPE_PARAMETER",
    "TYPE_REF",
    "UNKNOWN",
    "VARIABLE_INFO",
    "VULNERABILITY",
    "WRITE"
  )
  val nodeIdByLabel = nodeLabels.zipWithIndex.toMap
  val edgeLabels = Array(
    "ALIAS_OF",
    "ARGUMENT",
    "AST",
    "ATTACHED_DATA",
    "BINDS",
    "BINDS_TO",
    "CALL",
    "CAPTURE",
    "CAPTURED_BY",
    "CDG",
    "CFG",
    "CONDITION",
    "CONTAINS",
    "DOMINATE",
    "DYNAMIC_TYPE",
    "EVAL_TYPE",
    "IMPORTS",
    "INHERITS_FROM",
    "IS_CALL_FOR_IMPORT",
    "IS_SENSITIVE_DATA_DESCR_OF",
    "IS_SENSITIVE_DATA_DESCR_OF_REF",
    "IS_SENSITIVE_DATA_OF_TYPE",
    "PARAMETER_LINK",
    "POINTS_TO",
    "POST_DOMINATE",
    "REACHING_DEF",
    "RECEIVER",
    "REF",
    "SOURCE_FILE",
    "TAGGED_BY",
    "TAINT_REMOVE",
    "TYPE_DECL_ALIAS",
    "VTABLE"
  )
  val edgeIdByLabel = edgeLabels.zipWithIndex.toMap
  val edgePropertyAllocators: Array[Int => Array[_]] = Array(
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => Array.fill(size)("<empty>") /*label = REACHING_DEF, id = 25*/,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null,
    size => null
  )
  val nodeFactories: Array[(odb2.Graph, Int) => nodes.StoredNode] = Array(
    (g, seq) => new nodes.Annotation(g, seq),
    (g, seq) => new nodes.AnnotationLiteral(g, seq),
    (g, seq) => new nodes.AnnotationParameter(g, seq),
    (g, seq) => new nodes.AnnotationParameterAssign(g, seq),
    (g, seq) => new nodes.ArrayInitializer(g, seq),
    (g, seq) => new nodes.Binding(g, seq),
    (g, seq) => new nodes.Block(g, seq),
    (g, seq) => new nodes.Call(g, seq),
    (g, seq) => new nodes.CallChain(g, seq),
    (g, seq) => new nodes.CallSite(g, seq),
    (g, seq) => new nodes.ClosureBinding(g, seq),
    (g, seq) => new nodes.Comment(g, seq),
    (g, seq) => new nodes.ConfigFile(g, seq),
    (g, seq) => new nodes.ControlStructure(g, seq),
    (g, seq) => new nodes.Dependency(g, seq),
    (g, seq) => new nodes.DomAttribute(g, seq),
    (g, seq) => new nodes.DomNode(g, seq),
    (g, seq) => new nodes.FieldIdentifier(g, seq),
    (g, seq) => new nodes.File(g, seq),
    (g, seq) => new nodes.Finding(g, seq),
    (g, seq) => new nodes.Flow(g, seq),
    (g, seq) => new nodes.Framework(g, seq),
    (g, seq) => new nodes.FrameworkData(g, seq),
    (g, seq) => new nodes.Identifier(g, seq),
    (g, seq) => new nodes.ImplicitCall(g, seq),
    (g, seq) => new nodes.Import(g, seq),
    (g, seq) => new nodes.Ioflow(g, seq),
    (g, seq) => new nodes.JumpLabel(g, seq),
    (g, seq) => new nodes.JumpTarget(g, seq),
    (g, seq) => new nodes.KeyValuePair(g, seq),
    (g, seq) => new nodes.Literal(g, seq),
    (g, seq) => new nodes.Local(g, seq),
    (g, seq) => new nodes.Location(g, seq),
    (g, seq) => new nodes.MatchInfo(g, seq),
    (g, seq) => new nodes.Member(g, seq),
    (g, seq) => new nodes.MetaData(g, seq),
    (g, seq) => new nodes.Method(g, seq),
    (g, seq) => new nodes.MethodInst(g, seq),
    (g, seq) => new nodes.MethodParameterIn(g, seq),
    (g, seq) => new nodes.MethodParameterOut(g, seq),
    (g, seq) => new nodes.MethodRef(g, seq),
    (g, seq) => new nodes.MethodReturn(g, seq),
    (g, seq) => new nodes.MethodSummary(g, seq),
    (g, seq) => new nodes.Modifier(g, seq),
    (g, seq) => new nodes.Namespace(g, seq),
    (g, seq) => new nodes.NamespaceBlock(g, seq),
    (g, seq) => new nodes.PackagePrefix(g, seq),
    (g, seq) => new nodes.PostExecutionCall(g, seq),
    (g, seq) => new nodes.ProgramPoint(g, seq),
    (g, seq) => new nodes.Read(g, seq),
    (g, seq) => new nodes.Return(g, seq),
    (g, seq) => new nodes.Route(g, seq),
    (g, seq) => new nodes.SensitiveDataType(g, seq),
    (g, seq) => new nodes.SensitiveMember(g, seq),
    (g, seq) => new nodes.SensitiveReference(g, seq),
    (g, seq) => new nodes.SensitiveVariable(g, seq),
    (g, seq) => new nodes.Sink(g, seq),
    (g, seq) => new nodes.Source(g, seq),
    (g, seq) => new nodes.SpAnnotationParameter(g, seq),
    (g, seq) => new nodes.SpBlacklist(g, seq),
    (g, seq) => new nodes.Tag(g, seq),
    (g, seq) => new nodes.Tags(g, seq),
    (g, seq) => new nodes.TagNodePair(g, seq),
    (g, seq) => new nodes.TemplateDom(g, seq),
    (g, seq) => new nodes.Transform(g, seq),
    (g, seq) => new nodes.Transformation(g, seq),
    (g, seq) => new nodes.Type(g, seq),
    (g, seq) => new nodes.TypeArgument(g, seq),
    (g, seq) => new nodes.TypeDecl(g, seq),
    (g, seq) => new nodes.TypeParameter(g, seq),
    (g, seq) => new nodes.TypeRef(g, seq),
    (g, seq) => new nodes.Unknown(g, seq),
    (g, seq) => new nodes.VariableInfo(g, seq),
    (g, seq) => new nodes.Vulnerability(g, seq),
    (g, seq) => new nodes.Write(g, seq)
  )
  val edgeFactories: Array[(odb2.GNode, odb2.GNode, Int, Any) => odb2.Edge] = Array(
    (s, d, subseq, p) => new edges.AliasOf(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Argument(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Ast(s, d, subseq, p),
    (s, d, subseq, p) => new edges.AttachedData(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Binds(s, d, subseq, p),
    (s, d, subseq, p) => new edges.BindsTo(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Call(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Capture(s, d, subseq, p),
    (s, d, subseq, p) => new edges.CapturedBy(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Cdg(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Cfg(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Condition(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Contains(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Dominate(s, d, subseq, p),
    (s, d, subseq, p) => new edges.DynamicType(s, d, subseq, p),
    (s, d, subseq, p) => new edges.EvalType(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Imports(s, d, subseq, p),
    (s, d, subseq, p) => new edges.InheritsFrom(s, d, subseq, p),
    (s, d, subseq, p) => new edges.IsCallForImport(s, d, subseq, p),
    (s, d, subseq, p) => new edges.IsSensitiveDataDescrOf(s, d, subseq, p),
    (s, d, subseq, p) => new edges.IsSensitiveDataDescrOfRef(s, d, subseq, p),
    (s, d, subseq, p) => new edges.IsSensitiveDataOfType(s, d, subseq, p),
    (s, d, subseq, p) => new edges.ParameterLink(s, d, subseq, p),
    (s, d, subseq, p) => new edges.PointsTo(s, d, subseq, p),
    (s, d, subseq, p) => new edges.PostDominate(s, d, subseq, p),
    (s, d, subseq, p) => new edges.ReachingDef(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Receiver(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Ref(s, d, subseq, p),
    (s, d, subseq, p) => new edges.SourceFile(s, d, subseq, p),
    (s, d, subseq, p) => new edges.TaggedBy(s, d, subseq, p),
    (s, d, subseq, p) => new edges.TaintRemove(s, d, subseq, p),
    (s, d, subseq, p) => new edges.TypeDeclAlias(s, d, subseq, p),
    (s, d, subseq, p) => new edges.Vtable(s, d, subseq, p)
  )
  val nodePropertyAllocators: Array[Int => Array[_]] = Array(
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Boolean](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Boolean](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[Boolean](size),
    size => new Array[Boolean](size),
    size => new Array[Boolean](size),
    size => new Array[Boolean](size),
    size => new Array[Boolean](size),
    size => new Array[Boolean](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Boolean](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Boolean](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[Int](size),
    size => new Array[String](size),
    size => new Array[String](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size),
    size => new Array[odb2.GNode](size)
  )
  val normalNodePropertyNames = Array(
    "ALIAS_TYPE_FULL_NAME",
    "ANNOTATION_FULL_NAME",
    "ANNOTATION_NAME",
    "ARGUMENT_INDEX",
    "ARGUMENT_NAME",
    "AST_PARENT_FULL_NAME",
    "AST_PARENT_TYPE",
    "BINARY_SIGNATURE",
    "CANONICAL_NAME",
    "CATEGORIES",
    "CATEGORY",
    "CLASS_NAME",
    "CLASS_SHORT_NAME",
    "CLOSURE_BINDING_ID",
    "CLOSURE_ORIGINAL_NAME",
    "CODE",
    "COLUMN_NUMBER",
    "COLUMN_NUMBER_END",
    "CONTAINED_REF",
    "CONTENT",
    "CONTROL_STRUCTURE_TYPE",
    "DEPENDENCY_GROUP_ID",
    "DEPENDENCY_TYPE",
    "DEPTH_FIRST_ORDER",
    "DESCRIPTION",
    "DISPATCH_NAME",
    "DISPATCH_TYPE",
    "DYNAMIC_TYPE_HINT_FULL_NAME",
    "EVALUATION_STRATEGY",
    "EVALUATION_TYPE",
    "EVAL_TYPE",
    "EXPLICIT_AS",
    "FILENAME",
    "FINGERPRINT",
    "FULL_NAME",
    "HASH",
    "HAS_MAPPING",
    "IMPORTED_AS",
    "IMPORTED_ENTITY",
    "INDEX",
    "INHERITS_FROM_TYPE_FULL_NAME",
    "INTERNAL_FLAGS",
    "IS_EXPLICIT",
    "IS_EXTERNAL",
    "IS_METHOD_NEVER_OVERRIDDEN",
    "IS_STATIC",
    "IS_VARIADIC",
    "IS_WILDCARD",
    "KEY",
    "LANGUAGE",
    "LINE_NUMBER",
    "LINE_NUMBER_END",
    "LITERALS_TO_SINK",
    "METHOD_FULL_NAME",
    "METHOD_INST_FULL_NAME",
    "METHOD_SHORT_NAME",
    "ML_ASSISTED",
    "MODIFIER_TYPE",
    "NAME",
    "NODE_LABEL",
    "ORDER",
    "OVERLAYS",
    "PACKAGE_NAME",
    "PARAMETER_INDEX",
    "PARSER_TYPE_NAME",
    "PATH",
    "PATTERN",
    "POLICY_DIRECTORIES",
    "RESOLVED",
    "ROOT",
    "SCORE",
    "SIGNATURE",
    "SINK_TYPE",
    "SOURCE_TYPE",
    "SPID",
    "STRUCTURED_FINGERPRINT",
    "SYMBOL",
    "TYPE_DECL_FULL_NAME",
    "TYPE_FULL_NAME",
    "URL",
    "VALUE",
    "VARARG_PARAMETER",
    "VAR_TYPE",
    "VERSION"
  )
  val nodePropertyByLabel = normalNodePropertyNames.zipWithIndex.toMap
    .updated("attributes", 84)
    .updated("callerMethod", 84)
    .updated("calls", 84)
    .updated("evidence", 84)
    .updated("ioflows", 84)
    .updated("names", 84)
    .updated("node", 84)
    .updated("paramTags", 84)
    .updated("sink", 84)
    .updated("branchPoints", 85)
    .updated("dataTags", 85)
    .updated("descriptorFlows", 85)
    .updated("keyValuePairs", 85)
    .updated("members", 85)
    .updated("method", 85)
    .updated("methods", 85)
    .updated("tag", 85)
    .updated("call", 86)
    .updated("elem", 86)
    .updated("flows", 86)
    .updated("parameterIn", 86)
    .updated("rootCauses", 86)
    .updated("source", 86)
    .updated("tags", 86)
    .updated("annotationParameters", 87)
    .updated("cfgNodes", 87)
    .updated("dstTags", 87)
    .updated("methodTags", 87)
    .updated("triggerCallChains", 87)
    .updated("callingMethod", 88)
    .updated("modifiers", 88)
    .updated("points", 88)
    .updated("primaryFlow", 88)
    .updated("callsite", 89)
    .updated("outParamTags", 89)
    .updated("sinkDescriptorFlows", 89)
    .updated("transformations", 89)
    .updated("nodeType", 90)
    .updated("outParameters", 90)
    .updated("sinkDescriptorTags", 90)
    .updated("paramTypes", 91)
    .updated("parameterInTags", 91)
    .updated("sourceDescriptorFlows", 91)
    .updated("parameters", 92)
    .updated("sourceDescriptorTags", 92)
    .updated("returnParamTags", 93)
    .updated("sourceTags", 93)
    .updated("returnParameter", 94)
    .updated("transforms", 94)
    .updated("returnParameterType", 95)
    .updated("triggerMethods", 95)
    .updated("routes", 96)

  override def getNumberOfNodeKinds: Int                          = 75
  override def getNumberOfEdgeKinds: Int                          = 33
  override def getNodeLabel(nodeKind: Int): String                = nodeLabels(nodeKind)
  override def getNodeIdByLabel(label: String): Int               = nodeIdByLabel.getOrElse(label, -1)
  override def getEdgeLabel(nodeKind: Int, edgeKind: Int): String = edgeLabels(edgeKind)
  override def getEdgeIdByLabel(label: String): Int               = edgeIdByLabel.getOrElse(label, -1)
  override def getPropertyLabel(nodeKind: Int, propertyKind: Int): String =
    if (propertyKind < 84) normalNodePropertyNames(propertyKind)
    else if (propertyKind == 84 && nodeKind == 16) "attributes"            /*on node DOM_NODE*/
    else if (propertyKind == 84 && nodeKind == 19) "evidence"              /*on node FINDING*/
    else if (propertyKind == 84 && nodeKind == 20) "sink"                  /*on node FLOW*/
    else if (propertyKind == 84 && nodeKind == 26) "sink"                  /*on node IOFLOW*/
    else if (propertyKind == 84 && nodeKind == 32) "node"                  /*on node LOCATION*/
    else if (propertyKind == 84 && nodeKind == 42) "paramTags"             /*on node METHOD_SUMMARY*/
    else if (propertyKind == 84 && nodeKind == 48) "paramTags"             /*on node PROGRAM_POINT*/
    else if (propertyKind == 84 && nodeKind == 52) "names"                 /*on node SENSITIVE_DATA_TYPE*/
    else if (propertyKind == 84 && nodeKind == 53) "names"                 /*on node SENSITIVE_MEMBER*/
    else if (propertyKind == 84 && nodeKind == 54) "ioflows"               /*on node SENSITIVE_REFERENCE*/
    else if (propertyKind == 84 && nodeKind == 55) "node"                  /*on node SENSITIVE_VARIABLE*/
    else if (propertyKind == 84 && nodeKind == 56) "node"                  /*on node SINK*/
    else if (propertyKind == 84 && nodeKind == 57) "node"                  /*on node SOURCE*/
    else if (propertyKind == 84 && nodeKind == 62) "node"                  /*on node TAG_NODE_PAIR*/
    else if (propertyKind == 84 && nodeKind == 64) "sink"                  /*on node TRANSFORM*/
    else if (propertyKind == 84 && nodeKind == 65) "node"                  /*on node TRANSFORMATION*/
    else if (propertyKind == 84 && nodeKind == 74) "sink"                  /*on node WRITE*/
    else if (propertyKind == 84 && nodeKind == 8) "calls"                  /*on node CALL_CHAIN*/
    else if (propertyKind == 84 && nodeKind == 9) "callerMethod"           /*on node CALL_SITE*/
    else if (propertyKind == 85 && nodeKind == 19) "keyValuePairs"         /*on node FINDING*/
    else if (propertyKind == 85 && nodeKind == 20) "branchPoints"          /*on node FLOW*/
    else if (propertyKind == 85 && nodeKind == 26) "dataTags"              /*on node IOFLOW*/
    else if (propertyKind == 85 && nodeKind == 42) "method"                /*on node METHOD_SUMMARY*/
    else if (propertyKind == 85 && nodeKind == 48) "method"                /*on node PROGRAM_POINT*/
    else if (propertyKind == 85 && nodeKind == 49) "descriptorFlows"       /*on node READ*/
    else if (propertyKind == 85 && nodeKind == 52) "members"               /*on node SENSITIVE_DATA_TYPE*/
    else if (propertyKind == 85 && nodeKind == 56) "method"                /*on node SINK*/
    else if (propertyKind == 85 && nodeKind == 57) "method"                /*on node SOURCE*/
    else if (propertyKind == 85 && nodeKind == 62) "tag"                   /*on node TAG_NODE_PAIR*/
    else if (propertyKind == 85 && nodeKind == 64) "descriptorFlows"       /*on node TRANSFORM*/
    else if (propertyKind == 85 && nodeKind == 74) "descriptorFlows"       /*on node WRITE*/
    else if (propertyKind == 85 && nodeKind == 8) "methods"                /*on node CALL_CHAIN*/
    else if (propertyKind == 85 && nodeKind == 9) "method"                 /*on node CALL_SITE*/
    else if (propertyKind == 86 && nodeKind == 19) "rootCauses"            /*on node FINDING*/
    else if (propertyKind == 86 && nodeKind == 20) "source"                /*on node FLOW*/
    else if (propertyKind == 86 && nodeKind == 26) "source"                /*on node IOFLOW*/
    else if (propertyKind == 86 && nodeKind == 42) "tags"                  /*on node METHOD_SUMMARY*/
    else if (propertyKind == 86 && nodeKind == 48) "elem"                  /*on node PROGRAM_POINT*/
    else if (propertyKind == 86 && nodeKind == 49) "source"                /*on node READ*/
    else if (propertyKind == 86 && nodeKind == 56) "parameterIn"           /*on node SINK*/
    else if (propertyKind == 86 && nodeKind == 57) "tags"                  /*on node SOURCE*/
    else if (propertyKind == 86 && nodeKind == 59) "tags"                  /*on node SP_BLACKLIST*/
    else if (propertyKind == 86 && nodeKind == 61) "tags"                  /*on node TAGS*/
    else if (propertyKind == 86 && nodeKind == 64) "call"                  /*on node TRANSFORM*/
    else if (propertyKind == 86 && nodeKind == 74) "flows"                 /*on node WRITE*/
    else if (propertyKind == 86 && nodeKind == 9) "call"                   /*on node CALL_SITE*/
    else if (propertyKind == 87 && nodeKind == 20) "cfgNodes"              /*on node FLOW*/
    else if (propertyKind == 87 && nodeKind == 26) "dstTags"               /*on node IOFLOW*/
    else if (propertyKind == 87 && nodeKind == 42) "annotationParameters"  /*on node METHOD_SUMMARY*/
    else if (propertyKind == 87 && nodeKind == 48) "methodTags"            /*on node PROGRAM_POINT*/
    else if (propertyKind == 87 && nodeKind == 49) "triggerCallChains"     /*on node READ*/
    else if (propertyKind == 87 && nodeKind == 56) "methodTags"            /*on node SINK*/
    else if (propertyKind == 87 && nodeKind == 57) "methodTags"            /*on node SOURCE*/
    else if (propertyKind == 87 && nodeKind == 64) "triggerCallChains"     /*on node TRANSFORM*/
    else if (propertyKind == 87 && nodeKind == 74) "triggerCallChains"     /*on node WRITE*/
    else if (propertyKind == 88 && nodeKind == 20) "points"                /*on node FLOW*/
    else if (propertyKind == 88 && nodeKind == 26) "primaryFlow"           /*on node IOFLOW*/
    else if (propertyKind == 88 && nodeKind == 42) "modifiers"             /*on node METHOD_SUMMARY*/
    else if (propertyKind == 88 && nodeKind == 56) "callingMethod"         /*on node SINK*/
    else if (propertyKind == 88 && nodeKind == 57) "callingMethod"         /*on node SOURCE*/
    else if (propertyKind == 89 && nodeKind == 20) "transformations"       /*on node FLOW*/
    else if (propertyKind == 89 && nodeKind == 26) "sinkDescriptorFlows"   /*on node IOFLOW*/
    else if (propertyKind == 89 && nodeKind == 42) "outParamTags"          /*on node METHOD_SUMMARY*/
    else if (propertyKind == 89 && nodeKind == 56) "callsite"              /*on node SINK*/
    else if (propertyKind == 89 && nodeKind == 57) "callsite"              /*on node SOURCE*/
    else if (propertyKind == 90 && nodeKind == 26) "sinkDescriptorTags"    /*on node IOFLOW*/
    else if (propertyKind == 90 && nodeKind == 42) "outParameters"         /*on node METHOD_SUMMARY*/
    else if (propertyKind == 90 && nodeKind == 56) "nodeType"              /*on node SINK*/
    else if (propertyKind == 90 && nodeKind == 57) "nodeType"              /*on node SOURCE*/
    else if (propertyKind == 91 && nodeKind == 26) "sourceDescriptorFlows" /*on node IOFLOW*/
    else if (propertyKind == 91 && nodeKind == 42) "paramTypes"            /*on node METHOD_SUMMARY*/
    else if (propertyKind == 91 && nodeKind == 56) "parameterInTags"       /*on node SINK*/
    else if (propertyKind == 92 && nodeKind == 26) "sourceDescriptorTags"  /*on node IOFLOW*/
    else if (propertyKind == 92 && nodeKind == 42) "parameters"            /*on node METHOD_SUMMARY*/
    else if (propertyKind == 93 && nodeKind == 26) "sourceTags"            /*on node IOFLOW*/
    else if (propertyKind == 93 && nodeKind == 42) "returnParamTags"       /*on node METHOD_SUMMARY*/
    else if (propertyKind == 94 && nodeKind == 26) "transforms"            /*on node IOFLOW*/
    else if (propertyKind == 94 && nodeKind == 42) "returnParameter"       /*on node METHOD_SUMMARY*/
    else if (propertyKind == 95 && nodeKind == 26) "triggerMethods"        /*on node IOFLOW*/
    else if (propertyKind == 95 && nodeKind == 42) "returnParameterType"   /*on node METHOD_SUMMARY*/
    else if (propertyKind == 96 && nodeKind == 42) "routes"                /*on node METHOD_SUMMARY*/
    else null

  override def getPropertyIdByLabel(label: String): Int                                 = nodePropertyByLabel.getOrElse(label, -1)
  override def getNumberOfProperties: Int                                               = 97
  override def makeNode(graph: odb2.Graph, nodeKind: Short, seq: Int): nodes.StoredNode = nodeFactories(nodeKind)(graph, seq)
  override def makeEdge(src: odb2.GNode, dst: odb2.GNode, edgeKind: Short, subSeq: Int, property: Any): odb2.Edge =
    edgeFactories(edgeKind)(src, dst, subSeq, property)
  override def allocateEdgeProperty(nodeKind: Int, direction: Direction, edgeKind: Int, size: Int): Array[_] = edgePropertyAllocators(edgeKind)(size)
  override def allocateNodeProperty(nodeKind: Int, propertyKind: Int, size: Int): Array[_] = nodePropertyAllocators(propertyKind)(size)
}
