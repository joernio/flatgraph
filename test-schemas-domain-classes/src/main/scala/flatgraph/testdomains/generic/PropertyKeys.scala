package flatgraph.testdomains.generic

import flatgraph.PropertyKey

object PropertyKeys {

  val Intlist = flatgraph.MultiPropertyKey[Int](kind = 0, name = "intList")

  val Intmandatory = flatgraph.SinglePropertyKey[Int](kind = 1, name = "intMandatory", default = 42: Int)

  val Intoptional = flatgraph.OptionalPropertyKey[Int](kind = 2, name = "intOptional")

  val Stringlist = flatgraph.MultiPropertyKey[String](kind = 3, name = "stringList")

  val Stringmandatory = flatgraph.SinglePropertyKey[String](kind = 4, name = "stringMandatory", default = "<empty>")

  val Stringoptional = flatgraph.OptionalPropertyKey[String](kind = 5, name = "stringOptional")

}
