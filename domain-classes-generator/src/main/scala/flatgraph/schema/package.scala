package flatgraph

package object schema {

  object DefaultNodeTypes {

    /** root type for all nodes */
    val AbstractNodeName      = "ABSTRACT_NODE"
    val AbstractNodeClassname = "AbstractNode"

    val StoredNodeName      = "STORED_NODE"
    val StoredNodeClassname = "StoredNode"

    lazy val AllClassNames = Set(AbstractNodeClassname, StoredNodeClassname)
  }

}
