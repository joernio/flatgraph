package testdomains.gratefuldead

object Properties {

  /** This is a property comment */
  val Name = flatgraph.SinglePropertyKey[String](kind = 0, name = "name", default = "")

  val Performances = flatgraph.OptionalPropertyKey[Int](kind = 1, name = "performances")

  val Songtype = flatgraph.OptionalPropertyKey[String](kind = 2, name = "songType")
}
