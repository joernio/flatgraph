package testdomains.codepropertygraphminified

object Properties {
  val DispatchType = flatgraph.SinglePropertyKey[String](kind = 0, name = "DISPATCH_TYPE", default = "<empty>")

  val Name = flatgraph.SinglePropertyKey[String](kind = 1, name = "NAME", default = "<empty>")

  val Order = flatgraph.SinglePropertyKey[Int](kind = 2, name = "ORDER", default = -1: Int)
}
