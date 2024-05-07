package testdomains.gratefuldead

object PropertyKeys {
  val Name = flatgraph.SinglePropertyKey[String](kind = 0, name = "name", default = "")

  val Songtype = flatgraph.OptionalPropertyKey[String](kind = 1, name = "songType")
}
