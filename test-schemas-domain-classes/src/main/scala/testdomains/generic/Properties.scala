package testdomains.generic

object Properties {
  val BooleanOptional = flatgraph.OptionalPropertyKey[Boolean](kind = 0, name = "boolean_optional")

  val DoubleOptional = flatgraph.OptionalPropertyKey[Double](kind = 1, name = "double_optional")

  val FloatOptional = flatgraph.OptionalPropertyKey[Float](kind = 2, name = "float_optional")

  val IntList = flatgraph.MultiPropertyKey[Int](kind = 3, name = "int_list")

  val IntMandatory = flatgraph.SinglePropertyKey[Int](kind = 4, name = "int_mandatory", default = 42: Int)

  val IntOptional = flatgraph.OptionalPropertyKey[Int](kind = 5, name = "int_optional")

  val LongOptional = flatgraph.OptionalPropertyKey[Long](kind = 6, name = "long_optional")

  val StringList = flatgraph.MultiPropertyKey[String](kind = 7, name = "string_list")

  val StringMandatory = flatgraph.SinglePropertyKey[String](kind = 8, name = "string_mandatory", default = "<empty>")

  val StringOptional = flatgraph.OptionalPropertyKey[String](kind = 9, name = "string_optional")
}
