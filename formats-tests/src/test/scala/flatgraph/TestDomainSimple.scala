package flatgraph

import flatgraph.misc.TestUtils.applyDiff
import flatgraph.TestDomainSimple.PropertyNames.*
import flatgraph.testdomains.generic.GenericDomain
import flatgraph.testdomains.generic.edges.ConnectedTo
import flatgraph.testdomains.generic.nodes.NewNodeA

import java.nio.file.Path

object TestGraphSimple {
  def create(storageMaybe: Option[Path] = None): GenericDomain = {
    val genericDomain = storageMaybe match {
      case None              => GenericDomain.empty
      case Some(storagePath) => GenericDomain.withStorage(storagePath)
    }
    val graph = genericDomain.graph
    val node1 = NewNodeA().stringMandatory("node 1 a").stringOptional("node 1 b").stringList(Seq("node 1 c1", "node 1 c2"))
    val node2 = NewNodeA().intMandatory(1).intOptional(2).intList(Seq(10, 11, 12))

    DiffGraphApplier.applyDiff(
      graph,
      GenericDomain.newDiffGraphBuilder
        .addEdge(node1, node2, ConnectedTo.Label, "edge property")
    )
    genericDomain
  }
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
