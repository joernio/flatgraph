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
      val schema   = graph.schema
      val newGraph = new Graph(schema, storagePathMaybe)

      for (kind <- schema.nodeKinds) {
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
            else newGraph.nodesArray(oldNode.nodeKind)(oldNode.seq())
          }
        case a: Array[_] =>
          a.clone()
        case other =>
          other
      }
      // adjust that once we do diffgraph applications in-place
      for (idx <- Range(0, graph.properties.length))
        newGraph.properties(idx) = cloneThing(graph.properties(idx))
      for (idx <- Range(0, graph.neighbors.length))
        newGraph.neighbors(idx) = cloneThing(graph.neighbors(idx))
      System.arraycopy(graph.livingNodeCountByKind, 0, newGraph.livingNodeCountByKind, 0, graph.livingNodeCountByKind.length)

      newGraph
    }

  }

}
