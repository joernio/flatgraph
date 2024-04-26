package flatgraph.testdomains.gratefuldead.edges

object Followedby {
  val Label = "followedBy"
}

class Followedby(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
    extends flatgraph.Edge(src_4762, dst_4762, 0.toShort, subSeq_4862, property_4862) {
  def weight: Long = this.property.asInstanceOf[Long]
}

object Sungby {
  val Label = "sungBy"
}

class Sungby(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
    extends flatgraph.Edge(src_4762, dst_4762, 1.toShort, subSeq_4862, property_4862)

object Writtenby {
  val Label = "writtenBy"
}

class Writtenby(src_4762: flatgraph.GNode, dst_4762: flatgraph.GNode, subSeq_4862: Int, property_4862: Any)
    extends flatgraph.Edge(src_4762, dst_4762, 2.toShort, subSeq_4862, property_4862)
