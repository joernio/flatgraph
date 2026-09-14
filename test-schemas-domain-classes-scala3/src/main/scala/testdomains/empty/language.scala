package testdomains.empty

/** combining all implicits into one trait that can be mixed in further downstream */
trait language
    extends accessors.ConcreteStoredConversions
    with traversals.ConcreteStoredConversions
    with neighboraccessors.Conversions
    with flatgraph.traversal.language
    with flatgraph.help.language
    with flatgraph.Implicits {
  implicit def toGeneratedNodeStarters(domain: Empty): EmptyNodeStarters = EmptyNodeStarters(domain)
}

object language extends language
