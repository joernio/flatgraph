package flatgraph.traversal.testdomains.simple

import flatgraph.{DiffGraphApplier, DiffGraphBuilder, GNode, GenericDNode, Graph, TestSchema}
import flatgraph.help.{Doc, DocSearchPackages, Traversal, TraversalHelp, TraversalSource}
import flatgraph.traversal.testdomains.simple.SimpleDomain.Thing
import flatgraph.traversal.Language.*

/* simple example graph:
 * L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4 -> R5
 * */
trait ExampleGraphSetup {
  // val nonExistingLabel = "this label does not exist"
  // val nonExistingPropertyKey = new PropertyKey[String]("this property key does not exist")

  val graph  = SimpleDomain.newGraph
  val l3     = addNode()
  val l2     = addNode()
  val l1     = addNode()
  val center = addNode()
  val r1     = addNode()
  val r2     = addNode()
  val r3     = addNode()
  val r4     = addNode()
  val r5     = addNode()

  val diff = new DiffGraphBuilder(graph.schema)
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
    ._addEdge(center, l1, 0)
    ._addEdge(l1, l2, 0)
    ._addEdge(l2, l3, 0)
    ._addEdge(center, r1, 0)
    ._addEdge(r1, r2, 0)
    ._addEdge(r2, r3, 0)
    ._addEdge(r3, r4, 0)
    ._addEdge(r4, r5, 0)
  DiffGraphApplier.applyDiff(graph, diff)

  def addNode(): GNode = {
    val newNode = new GenericDNode(0)
    DiffGraphApplier.applyDiff(graph, DiffGraphBuilder(graph.schema).addNode(newNode))
    newNode.storedRef.get // that reference is set by DiffGraphApplier
  }
}

object SimpleDomain {
  class Thing(graph: Graph, nodeKind: Short, seqId: Int) extends GNode(graph, nodeKind, seqId) {
    def name: String = ???
  }

  val defaultDocSearchPackage: DocSearchPackages = DocSearchPackages(getClass.getPackage.getName)
  lazy val help                                  = TraversalHelp(defaultDocSearchPackage).forTraversalSources(verbose = false)
  lazy val helpVerbose                           = TraversalHelp(defaultDocSearchPackage).forTraversalSources(verbose = true)

  def newGraph: Graph = {
    val schema = TestSchema.make(1, 1)
    Graph(schema)
  }

  def traversal(graph: Graph) = new SimpleDomainTraversalSource(graph)
}

@TraversalSource
class SimpleDomainTraversalSource(graph: Graph) {

  @Doc(info = "all things")
  def things: Iterator[Thing] =
    graph.nodes("V0").cast[Thing]
}

/** Example for domain specific extension steps that are defined in a different package. TraversalTests verifies that the .help step finds
  * the documentation as specified in @Doc
  *
  * @param traversal
  */
@Traversal(elementType = classOf[SimpleDomain.Thing])
class SimpleDomainTraversal(val traversal: Iterator[SimpleDomain.Thing]) extends AnyVal {

  @Doc(info = "name of the Thing")
  def name: Iterator[String] = traversal.map(_.name)
}
