package flatgraph.testdomains.generic
import flatgraph.DiffGraphBuilder
import flatgraph.help.DocSearchPackages
import flatgraph.help.Table.AvailableWidthProvider
import Language.*

object GenericDomain {
  val defaultDocSearchPackage = DocSearchPackages.default.withAdditionalPackage(getClass.getPackage.getName)

  @scala.annotation.implicitNotFound("""If you're using flatgraph purely without a schema and associated generated domain classes, you can
    |start with `given DocSearchPackages = DocSearchPackages.default`.
    |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
    |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
    |""".stripMargin)
  def help(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    flatgraph.help.TraversalHelp(searchPackageNames).forTraversalSources(verbose = false)

  @scala.annotation.implicitNotFound("""If you're using flatgraph purely without a schema and associated generated domain classes, you can
    |start with `given DocSearchPackages = DocSearchPackages.default`.
    |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
    |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
    |""".stripMargin)
  def helpVerbose(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    flatgraph.help.TraversalHelp(searchPackageNames).forTraversalSources(verbose = true)

  def empty: GenericDomain = new GenericDomain(new flatgraph.Graph(GraphSchema))

  /** Instantiate a new graph with storage. If the file already exists, this will deserialize the given file into memory. `Graph.close` will
    * serialise graph to that given file (and override whatever was there before), unless you specify `persistOnClose = false`.
    */
  def withStorage(storagePath: java.nio.file.Path, persistOnClose: Boolean = true): GenericDomain = {
    val graph = flatgraph.Graph.withStorage(GraphSchema, storagePath, persistOnClose)
    new GenericDomain(graph)
  }

  def newDiffGraphBuilder: DiffGraphBuilder = new DiffGraphBuilder(GraphSchema)
}

class GenericDomain(private val _graph: flatgraph.Graph = new flatgraph.Graph(GraphSchema)) extends AutoCloseable {
  def graph: flatgraph.Graph = _graph

  def help(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    GenericDomain.help
  def helpVerbose(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    GenericDomain.helpVerbose

  override def close(): Unit =
    _graph.close()

  override def toString(): String =
    String.format("GenericDomain[%s]", graph)
}

@flatgraph.help.TraversalSource
class GenericDomainNodeStarters(val wrappedGenericDomain: GenericDomain) {

  @flatgraph.help.Doc(info = "all nodes")
  def all: Iterator[nodes.StoredNode] = wrappedGenericDomain.graph.allNodes.asInstanceOf[Iterator[nodes.StoredNode]]

  /** */
  @flatgraph.help.Doc(info = """""")
  def nodeA: Iterator[nodes.NodeA] = wrappedGenericDomain.graph._nodes(0).asInstanceOf[Iterator[nodes.NodeA]]

  /** */
  @flatgraph.help.Doc(info = """""")
  def nodeB: Iterator[nodes.NodeB] = wrappedGenericDomain.graph._nodes(1).asInstanceOf[Iterator[nodes.NodeB]]
}
