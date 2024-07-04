package testdomains.generic.edges

object ConnectedTo {
  val Label                        = "connected_to"
  val propertyName: Option[String] = Some("string_mandatory")
}

class ConnectedTo(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
    extends flatgraph.Edge(src_4762, dst_4762, 0.toShort, subSeq_4862, property_4862) {
  override def propertyName: Option[String] = ConnectedTo.propertyName
}
