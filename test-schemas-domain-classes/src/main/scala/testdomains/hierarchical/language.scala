package testdomains.hierarchical

/** combining all implicits into one trait that can be mixed in further downstream */
trait language
    extends accessors.ConcreteStoredConversions
    with traversals.ConcreteStoredConversions
    with neighboraccessors.Conversions
    with flatgraph.traversal.language
    with flatgraph.help.language
    with flatgraph.Implicits {
  implicit def toGeneratedNodeStarters(domain: Hierarchical): HierarchicalNodeStarters = HierarchicalNodeStarters(domain)
}

object language extends language
