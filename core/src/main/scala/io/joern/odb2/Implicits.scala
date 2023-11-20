package io.joern.odb2

object Implicits extends Implicits

trait Implicits {

  extension [NodeType <: GNode](node: NodeType) {

    /** start a new Traversal with this Node, i.e. lift it into a Traversal */
    def start: Iterator[NodeType] =
      Iterator.single(node)
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
