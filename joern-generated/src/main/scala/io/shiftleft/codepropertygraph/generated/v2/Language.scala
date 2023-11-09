package io.shiftleft.codepropertygraph.generated.v2

/** combining all implicits into one trait that can be mixed in further downstream */
trait Language
    extends accessors.ConcreteStoredConversions
    with traversals.ConcreteStoredConversions
    with neighboraccessors.Conversions
    with io.joern.odb2.traversal.Language
    with io.joern.odb2.Implicits {
  implicit def cpgToGeneratedNodeStarters(cpg: Cpg): CpgNodeStarters = CpgNodeStarters(cpg)
}

object Language extends Language
