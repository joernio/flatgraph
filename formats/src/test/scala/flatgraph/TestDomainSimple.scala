package flatgraph

object TestDomainSimple {
  val TestNodeLabel = "testNode"
  val TestEdgeLabel = "testEdge"
  
  object PropertyNames {
    val StringProperty = "StringProperty"
    val StringListProperty = "StringListProperty"
    val IntProperty = "IntProperty"
    val IntListProperty = "IntListProperty"
  }
  
  val schema = new FreeSchema(
    nodeLabels = Array(TestNodeLabel),
    edgeLabels = Array(TestEdgeLabel),
    propertyLabels = Array(
      PropertyNames.StringProperty, 
      PropertyNames.StringListProperty, 
      PropertyNames.IntProperty, 
      PropertyNames.IntListProperty),
    nodePropertyPrototypes = Array(Array.empty[String], Array.empty[String], Array.emptyIntArray, Array.emptyIntArray),
    edgePropertyPrototypes = Array(Array.emptyLongArray),
  )
  
  def newGraphEmpty(): Graph = Graph(schema)
}
