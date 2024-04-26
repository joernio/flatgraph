package flatgraph.testdomains.simple.edges

class Connectedto(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
    extends flatgraph.Edge(src_4762, dst_4762, 0.toShort, subSeq_4862, property_4862) {
  def stringmandatory: String = this.property.asInstanceOf[String]
}
