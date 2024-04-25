package flatgraph.testdomains.gratefuldead
import flatgraph.DiffGraphBuilder
import flatgraph.help.DocSearchPackages
import flatgraph.help.Table.AvailableWidthProvider
import Language.*

object GratefulDead {
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

  def empty: GratefulDead = new GratefulDead(new flatgraph.Graph(GraphSchema))

  /** Instantiate a new graph with storage. If the file already exists, this will deserialize the given file into
    * memory. `Graph.close` will serialise graph to that given file (and override whatever was there before), unless you
    * specify `persistOnClose = false`.
    */
  def withStorage(storagePath: java.nio.file.Path, persistOnClose: Boolean = true): GratefulDead = {
    val graph = flatgraph.Graph.withStorage(GraphSchema, storagePath, persistOnClose)
    new GratefulDead(graph)
  }

  def newDiffGraphBuilder: DiffGraphBuilder = new DiffGraphBuilder(GraphSchema)
}

class GratefulDead(private val _graph: flatgraph.Graph = new flatgraph.Graph(GraphSchema)) extends AutoCloseable {
  def graph: flatgraph.Graph = _graph

  def help(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    GratefulDead.help
  def helpVerbose(implicit searchPackageNames: DocSearchPackages, availableWidthProvider: AvailableWidthProvider) =
    GratefulDead.helpVerbose

  override def close(): Unit =
    _graph.close()

  override def toString(): String =
    String.format("GratefulDead[%s]", graph)
}

@flatgraph.help.TraversalSource
class GratefulDeadNodeStarters(val wrappedCpg: GratefulDead) {

  @flatgraph.help.Doc(info = "all nodes")
  def all: Iterator[nodes.StoredNode] = wrappedCpg.graph.allNodes.asInstanceOf[Iterator[nodes.StoredNode]]

  /** */
  @flatgraph.help.Doc(info = """""")
  def artist: Iterator[nodes.Artist] = wrappedCpg.graph._nodes(0).asInstanceOf[Iterator[nodes.Artist]]

  /** */
  @flatgraph.help.Doc(info = """""")
  def song: Iterator[nodes.Song] = wrappedCpg.graph._nodes(1).asInstanceOf[Iterator[nodes.Song]]
}
