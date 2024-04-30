package flatgraph

import flatgraph.testdomains.generic.GenericDomain
import flatgraph.testdomains.generic.edges.ConnectedTo
import flatgraph.testdomains.generic.nodes.NewNodeA

import java.nio.file.Path

object TestGraphs {

  /** graph from genericDomain with two nodes, one edge and lots of properties:
   *
   * #Node numbers (kindId, nnodes) (0: 2), (1: 0), total 2
   * Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 1 [dense], 1 [dense]),
   * node_a_0       : int_mandatory: [42], string_list: [node 1 c1, node 1 c2], string_mandatory: [node 1 a], string_optional: [node 1 b]
   * node_a_0   [connected_to] -> (edge property) node_a_1
   * node_a_1       : int_list: [10, 11, 12], int_mandatory: [1], int_optional: [2], string_mandatory: [<empty>]
   * node_a_1   [connected_to] <- (edge property) node_a_0
   * Node kind 1. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]),
   *
   *  */
  def createSimpleGraph(storageMaybe: Option[Path] = None): GenericDomain = {
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
