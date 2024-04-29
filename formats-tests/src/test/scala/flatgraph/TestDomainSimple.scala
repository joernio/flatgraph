package flatgraph

import flatgraph.misc.TestUtils.applyDiff
import flatgraph.TestDomainSimple.PropertyNames.*

object TestGraphSimple {
  
}

object TestDomainSimple {
  val TestNodeLabel = "testNode"
  val TestEdgeLabel = "testEdge"

  object PropertyNames {
    val StringProperty            = "StringProperty"
    val StringListProperty        = "StringListProperty"
    val IntProperty               = "IntProperty"
    val IntListProperty           = "IntListProperty"
    val ContainedTestNodeProperty = "ContainedTestNodeProperty"
  }

  val schema = new FreeSchema(
    nodeLabels = Array(TestNodeLabel),
    edgeLabels = Array(TestEdgeLabel),
    propertyLabels = Array(
      PropertyNames.StringProperty,
      PropertyNames.StringListProperty,
      PropertyNames.IntProperty,
      PropertyNames.IntListProperty,
      PropertyNames.ContainedTestNodeProperty
    ),
    nodePropertyPrototypes = Array(Array.empty[String], Array.empty[String], Array.emptyIntArray, Array.emptyIntArray, Array.empty[GNode]),
    propertyNamesByNodeLabel = Map.empty,
    edgePropertyPrototypes = Array(Array.emptyLongArray)
  )

  def newGraphEmpty(): Graph = Graph(schema)

  def newGraphSimple(): Graph = {
    val graph = newGraphEmpty()
    val v0    = new GenericDNode(0)
    val v1    = new GenericDNode(0)
    val v2    = new GenericDNode(0)

    graph.applyDiff(
      _._addEdge(v0, v1, 0, Long.MaxValue)
        ._addEdge(v1, v2, 0)
    )

    graph.applyDiff(
      _.setNodeProperty(v0.storedRef.get, IntProperty, 11)
        .setNodeProperty(v0.storedRef.get, StringProperty, "<stringProp1>")
        .setNodeProperty(v0.storedRef.get, StringListProperty, List("stringListProp1a", "stringList\\Prop1b"))
        .setNodeProperty(v0.storedRef.get, IntListProperty, List(21, 31, 41))
        .setNodeProperty(v1.storedRef.get, StringProperty, """string"Prop2\""")
        .setNodeProperty(v2.storedRef.get, IntProperty, 13)
    )

    graph
  }
}
