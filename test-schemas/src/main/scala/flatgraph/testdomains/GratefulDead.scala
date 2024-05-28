package flatgraph.testdomains

import flatgraph.schema.*
import flatgraph.schema.EdgeType.Cardinality
import flatgraph.schema.Property.ValueType

/** Tinkerpop GratefulDead schema:
  * https://github.com/apache/tinkerpop/blob/ac40c7442957e7e756fcaf9336c41c36fd95c467/docs/static/images/grateful-dead-schema.png
  */
object GratefulDead {
  val schema: Schema = {
    val builder = new SchemaBuilder(domainShortName = "GratefulDead", basePackage = "testdomains.gratefuldead")

    // properties
    val name         = builder.addProperty("name", ValueType.String).mandatory(default = "")
    val songType     = builder.addProperty("songType", ValueType.String)
    val performances = builder.addProperty("performances", ValueType.Int)
    val weight       = builder.addProperty("weight", ValueType.Int).mandatory(default = 0)

    // nodes
    val artist = builder.addNodeType("artist").addProperty(name)
    val song   = builder.addNodeType("song").addProperty(name).addProperty(songType).addProperty(performances)

    // edges
    val sungBy     = builder.addEdgeType("sungBy")
    val writtenBy  = builder.addEdgeType("writtenBy")
    val followedBy = builder.addEdgeType("followedBy").withProperty(weight)
    song.addOutEdge(sungBy, inNode = artist, stepNameOut = "sungBy", stepNameIn = "sang")
    song.addOutEdge(writtenBy, inNode = artist, stepNameOut = "writtenBy", stepNameIn = "wrote")
    song.addOutEdge(followedBy, inNode = song, stepNameOut = "followedBy")

    builder.build
  }
}
