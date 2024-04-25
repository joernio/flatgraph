package flatgraph.testdomains.gratefuldead

import flatgraph.schema.EdgeType.Cardinality
import flatgraph.schema.Property.ValueType
import flatgraph.schema.SchemaBuilder

/**
 * Tinkerpop GratefulDead schema:
 * https://github.com/apache/tinkerpop/blob/ac40c7442957e7e756fcaf9336c41c36fd95c467/docs/static/images/grateful-dead-schema.png
 */
object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(
      domainShortName = "GratefulDead",
      basePackage = "flatgraph.testdomains.gratefuldead"
    )

    val name = builder.addProperty("Name", ValueType.String).mandatory(default = "")
    val songType = builder.addProperty("SongType", ValueType.String)
    val performances = builder.addProperty("performances", ValueType.Int)
    val weight = builder.addProperty("weight", ValueType.Long).mandatory(default = 0)

    val artist = builder
      .addNodeType("Artist")
      .addProperty(name)

    val song = builder
      .addNodeType("Song")
      .addProperty(name)

    val followedBy = builder.addEdgeType("followedBy").addProperty(weight)
    song.addOutEdge(followedBy, inNode = song, cardinalityOut = Cardinality.One)

    builder.build
  }
}
