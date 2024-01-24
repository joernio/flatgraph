package flatgraph.help

/** defines where we should search for @Traversal/@TraversalSource/@Doc annotations */
trait DocSearchPackages {
  def apply(): Seq[String]

  def withAdditionalPackage(packageName: String): DocSearchPackages = {
    val combinedPackages = this.apply() :+ packageName
    () => combinedPackages
  }
}

object DocSearchPackages {

  /** don't scan anywhere other than flatgraph */
  val default: DocSearchPackages = () => List("flatgraph")

  def apply(searchPackages: String*): DocSearchPackages =
    () => searchPackages
}
