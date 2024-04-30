package flatgraph

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
