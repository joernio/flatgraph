package io.joern.odb2.traversal.testdomains.simple

import io.joern.odb2.*

/* simple example graph:
 * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
 * */
trait ExampleGraphSetup {
  // val nonExistingLabel = "this label does not exist"
  // val nonExistingPropertyKey = new PropertyKey[String]("this property key does not exist")

  val schema = TestSchema.make(1, 1)
  val graph = new Graph(schema)
  val l3 = addNode()
  val l2 = addNode()
  val l1 = addNode()
  val center = addNode()
  val r1 = addNode()
  val r2 = addNode()
  val r3 = addNode()
  val r4 = addNode()
  val r5 = addNode()

  val diff = new DiffGraphBuilder
  // TODO reimplement arrow synax from odb
  // TODO bring back properties as well
  // center --- Connection.Label --> l1
  // l1 --- Connection.Label --> l2
  // l2 --- Connection.Label --> l3
  // center --- Connection.Label --> r1
  // r1 --- (Connection.Label, Connection.Properties.Distance.of(10)) --> r2
  // r2 --- (Connection.Label, Connection.Properties.Distance.of(10)) --> r3
  // r3 --- (Connection.Label, Connection.Properties.Distance.of(13)) --> r4
  // r4 --- (Connection.Label, Connection.Properties.Distance.of(14)) --> r5
  diff
    .addEdge(center, l1, 0)
    .addEdge(l1, l2, 0)
    .addEdge(l2, l3, 0)
    .addEdge(center, r1, 0)
    .addEdge(r1, r2, 0)
    .addEdge(r2, r3, 0)
    .addEdge(r3, r4, 0)
    .addEdge(r4, r5, 0)
  DiffGraphApplier.applyDiff(graph, diff)

  def addNode(): GNode = {
    val newNode = new GenericDNode(0)
    DiffGraphApplier.applyDiff(graph, DiffGraphBuilder().addNode(newNode))
    newNode.storedRef.get //that reference is set by DiffGraphApplier
  }
}