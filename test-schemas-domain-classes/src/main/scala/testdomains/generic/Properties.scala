package testdomains.generic

object Properties {
  val IntList = flatgraph.MultiPropertyKey[Int](kind = 0, name = "int_list")

  val IntMandatory = flatgraph.SinglePropertyKey[Int](kind = 1, name = "int_mandatory", default = 42: Int)

  val IntOptional = flatgraph.OptionalPropertyKey[Int](kind = 2, name = "int_optional")

  val StringList = flatgraph.MultiPropertyKey[String](kind = 3, name = "string_list")

  val StringMandatory = flatgraph.SinglePropertyKey[String](kind = 4, name = "string_mandatory", default = "<empty>")

  val StringOptional = flatgraph.OptionalPropertyKey[String](kind = 5, name = "string_optional")
}
