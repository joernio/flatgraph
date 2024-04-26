package flatgraph.testdomains.gratefuldead

import flatgraph.schema.EdgeType.Cardinality
import flatgraph.schema.Property.ValueType
import flatgraph.schema.SchemaBuilder

/** Tinkerpop GratefulDead schema:
  * https://github.com/apache/tinkerpop/blob/ac40c7442957e7e756fcaf9336c41c36fd95c467/docs/static/images/grateful-dead-schema.png
  */
object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(domainShortName = "GratefulDead", basePackage = "flatgraph.testdomains.gratefuldead")

    // properties
    val name         = builder.addProperty("name", ValueType.String).mandatory(default = "")
    val songType     = builder.addProperty("songType", ValueType.String)
    val performances = builder.addProperty("performances", ValueType.Int)
    val weight       = builder.addProperty("weight", ValueType.Long).mandatory(default = 0)

    // nodes
    val artist = builder
      .addNodeType("artist")
      .addProperty(name)

    val song = builder
      .addNodeType("song")
      .addProperty(name)
      .addProperty(songType)

    // edges
    val sungBy     = builder.addEdgeType("sungBy")
    val writtenBy  = builder.addEdgeType("writtenBy")
    val followedBy = builder.addEdgeType("followedBy").addProperty(weight)
    song.addOutEdge(sungBy, inNode = artist, cardinalityOut = Cardinality.One, stepNameOut = "sungBy", stepNameIn = "sang")
    song.addOutEdge(writtenBy, inNode = artist, cardinalityOut = Cardinality.One, stepNameOut = "writtenBy", stepNameIn = "wrote")
    song.addOutEdge(followedBy, inNode = song, cardinalityOut = Cardinality.One, stepNameOut = "followedBy")

    builder.build
  }
}
