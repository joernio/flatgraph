package flatgraph.traversal

// TODO bring back doc/help etc
//  import overflowdb.traversal.help.Doc
import flatgraph.GNode

trait GNodeTraversal {

  extension [A <: GNode](traversal: Iterator[A]) {

    /** `id` combines nodeKind and seq into a unique id Mostly for backwards compatibility with overflowdb v1 where nodes have a `id: Long`
      */
    def id: Iterator[Long] =
      traversal.map(_.id())

    /** the unique identifier for a node of _this kind_ */
    def seqId: Iterator[Int] =
      traversal.map(_.seq())

    /** traverse to the node label */
    // TODO bring back doc/help etc
    // @Doc(info = "Traverse to the node label")
    def label: Iterator[String] =
      traversal.map(_.label())

    /** filter by the node label */
    def label(value: String): Iterator[A] =
      traversal.filter(_.label() == value)

    /** filter by the node labels */
    def label(values: String*): Iterator[A] = {
      val wanted = values.toSet
      traversal.filter(node => wanted.contains(node.label()))
    }

    /** alias for {{{label}}} */
    def hasLabel(value: String): Iterator[A] = label(value)

    /** alias for {{{label}}} */
    def hasLabel(values: String*): Iterator[A] = label(values: _*)

    /** filter by the node label (inverse) */
    def labelNot(value: String): Iterator[A] =
      traversal.filterNot(_.label() == value)

    /** filter by the node labels (inverse) */
    def labelNot(value1: String, valueN: String*): Iterator[A] = {
      val unwanted = (valueN :+ value1).toSet
      traversal.filterNot(node => unwanted.contains(node.label()))
    }

    /** filter by the node kind */
    def kind(value: Int): Iterator[A] =
      traversal.filter(_.nodeKind == value)

    /** alias for {{{kind}}} */
    def hasKind(value: Int): Iterator[A] =
      kind(value)
  }

}
