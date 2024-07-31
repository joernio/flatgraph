package flatgraph.testdomains

import flatgraph.schema.*

object CodePropertyGraphMinified {
  val schema: Schema = {
    val builder = new SchemaBuilder(domainShortName = "CpgMinified", basePackage = "testdomains.codepropertygraphminified")

    val name = builder
      .addProperty(name = "NAME", valueType = Property.ValueType.String)
      .mandatory(default = "<empty>")

    val order = builder
      .addProperty(name = "ORDER", valueType = Property.ValueType.Int)
      .mandatory(-1)

    val dispatchType = builder
      .addProperty(name = "DISPATCH_TYPE", valueType = Property.ValueType.String)
      .mandatory(default = "<empty>")

    val declaration = builder
      .addNodeBaseType(name = "DECLARATION")
      .addProperties(name)

    val method: NodeType = builder
      .addNodeType(name = "METHOD")
      .extendz(declaration)

    val callRepr = builder
      .addNodeBaseType(name = "CALL_REPR")
      .addProperties(name, order)

    val callNode: NodeType = builder
      .addNodeType(name = "CALL")
      .extendz(callRepr)
      .addProperties(dispatchType)

    val call = builder.addEdgeType(name = "CALL")

    callNode.addOutEdge(edge = call, inNode = method, stepNameOut = "method")

    builder.build
  }
}
