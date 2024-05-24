package flatgraph

import testdomains.generic.GenericDomain
import testdomains.generic.edges.ConnectedTo
import testdomains.generic.nodes.NewNodeA
import testdomains.generic.language.*

import java.nio.file.Path

object TestGraphs {

  /** graph from genericDomain with two nodes, one edge and lots of properties:
    *
    * #Node numbers (kindId, nnodes) (0: 2), (1: 0), total 2 Node kind 0. (eid, nEdgesOut, nEdgesIn): (0, 1 [dense], 1 [dense]), node_a_0 :
    * int_mandatory: [42], string_list: [node 1 c1, node 1 c2], string_mandatory: [node 1 a], string_optional: [node 1 b] node_a_0
    * [connected_to] -> (edge property) node_a_1 node_a_1 : int_list: [10, 11, 12], int_mandatory: [1], int_optional: [2], string_mandatory:
    * [<empty>] node_a_1 [connected_to] <- (edge property) node_a_0 Node kind 1. (eid, nEdgesOut, nEdgesIn): (0, 0 [NA], 0 [NA]),
    */
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

  /** L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5 */
  def createFlatlineGraph(): GenericDomain = {
    val center = NewNodeA().stringMandatory("Center")
    val l1     = NewNodeA().stringMandatory("L1")
    val l2     = NewNodeA().stringMandatory("L2")
    val l3     = NewNodeA().stringMandatory("L3")
    val r1     = NewNodeA().stringMandatory("R1")
    val r2     = NewNodeA().stringMandatory("R2")
    val r3     = NewNodeA().stringMandatory("R3")
    val r4     = NewNodeA().stringMandatory("R4")
    val r5     = NewNodeA().stringMandatory("R5")

    // TODO reimplement arrow synax from odb
    // center --- Connection.Label --> l1
    // l1 --- Connection.Label --> l2
    // l2 --- Connection.Label --> l3
    // center --- Connection.Label --> r1
    // r1 --- (Connection.Label, Connection.Properties.Distance.of(10)) --> r2
    // r2 --- (Connection.Label, Connection.Properties.Distance.of(10)) --> r3
    // r3 --- (Connection.Label, Connection.Properties.Distance.of(13)) --> r4
    // r4 --- (Connection.Label, Connection.Properties.Distance.of(14)) --> r5

    GenericDomain.from(
      _.addEdge(center, l1, ConnectedTo.Label)
        .addEdge(l1, l2, ConnectedTo.Label)
        .addEdge(l2, l3, ConnectedTo.Label)
        .addEdge(center, r1, ConnectedTo.Label)
        .addEdge(r1, r2, ConnectedTo.Label)
        .addEdge(r2, r3, ConnectedTo.Label)
        .addEdge(r3, r4, ConnectedTo.Label)
        .addEdge(r4, r5, ConnectedTo.Label)
    )
  }

  /** L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5 */
  trait FlatlineGraphFixture {
    val genericDomain                               = TestGraphs.createFlatlineGraph()
    val Seq(center, l1, l2, l3, r1, r2, r3, r4, r5) = genericDomain.nodeA.sortBy(_.stringMandatory).l

    // verify graph setup
    assert(center.stringMandatory == "Center")
    assert(l1.stringMandatory == "L1")
    assert(l2.stringMandatory == "L2")
    assert(l3.stringMandatory == "L3")
    assert(r1.stringMandatory == "R1")
    assert(r2.stringMandatory == "R2")
    assert(r3.stringMandatory == "R3")
    assert(r4.stringMandatory == "R4")
    assert(r5.stringMandatory == "R5")
  }

}
