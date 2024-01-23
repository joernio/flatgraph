package flatgraph.help

/** defines where we should search for @Traversal/@TraversalSource/@Doc annotations */
trait DocSearchPackages {
  def apply(): Seq[String]
}

object DocSearchPackages {

  /** don't scan anywhere other than flatgraph.traversal */
  val noAdditionalPackages: DocSearchPackages = () => Nil

  def apply(searchPackages: String*): DocSearchPackages =
    () => searchPackages
}
