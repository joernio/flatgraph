package flatgraph.misc

import flatgraph.*

import java.nio.file.Path

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

    def copy(storagePathMaybe: Option[Path] = None): Graph = {
      val schema = graph.schema
      val newGraph = new Graph(schema, storagePathMaybe)
      
      for (kind <- Range(0, schema.getNumberOfNodeKinds)) {
        newGraph.nodesArray(kind) = graph.nodesArray(kind).clone()
        newGraph.nodesArray(kind).mapInPlace { oldNode =>
          val newNode = schema.makeNode(newGraph, oldNode.nodeKind, oldNode.seq())
          if (AccessHelpers.isDeleted(oldNode)) AccessHelpers.markDeleted(newNode)
          newNode
        }
      }

      def cloneThing(item: AnyRef): AnyRef = item match {
        case null => null
        case a: Array[GNode] =>
          a.clone().mapInPlace { oldNode =>
            if (oldNode == null) null 
            else graph.nodesArray(oldNode.nodeKind)(oldNode.seq())
          }
        case other => other
      }
      // adjust that once we do diffgraph applications in-place
      for (idx <- Range(0, graph.properties.length))
        graph.properties(idx) = cloneThing(newGraph.properties(idx))
      for (idx <- Range(0, graph.neighbors.length))
        graph.neighbors(idx) = cloneThing(newGraph.neighbors(idx))
      java.lang.System.arraycopy(newGraph.livingNodeCountByKind, 0, graph.livingNodeCountByKind, 0, graph.livingNodeCountByKind.length)

      newGraph
    }

  }

}
