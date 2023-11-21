package flatgraph

object Implicits extends Implicits

trait Implicits {

  extension [NodeType <: GNode](node: NodeType) {

    /** start a new Traversal with this Node, i.e. lift it into a Traversal */
    def start: Iterator[NodeType] =
      Iterator.single(node)
  }

}
