package testdomains.generic

/** combining all implicits into one trait that can be mixed in further downstream */
trait Language
    extends accessors.ConcreteStoredConversions
    with traversals.ConcreteStoredConversions
    with neighboraccessors.Conversions
    with flatgraph.traversal.Language
    with flatgraph.Implicits {
  implicit def toGeneratedNodeStarters(domain: GenericDomain): GenericDomainNodeStarters = GenericDomainNodeStarters(domain)
}

object Language extends Language
