package flatgraph.misc

import flatgraph.*

/** Convenience functions for common use test use-cases. Context: applying a Diff */
object TestUtils {

  extension (diffGraphBuilder: DiffGraphBuilder) {
    def apply(graph: Graph): Graph = {
      DiffGraphApplier.applyDiff(graph, diffGraphBuilder)
      graph
    }
  }

  extension (graph: Graph) {
    def applyDiff(buildDiff: DiffGraphBuilder => Unit): Unit = {
      val diffGraphBuilder = DiffGraphBuilder(graph.schema)
      buildDiff(diffGraphBuilder)
      diffGraphBuilder.apply(graph)
    }

    def addNode(node: DNode): node.StoredNodeType = {
      applyDiff(_.addNode(node))
      node.storedRef.get
    }
  }

}
