package flatgraph.testdomains.gratefuldead

import flatgraph.schema.EdgeType.Cardinality
import flatgraph.schema.Property.ValueType
import flatgraph.schema.SchemaBuilder

object Schema {
  val instance: flatgraph.schema.Schema = {
    val builder = new SchemaBuilder(
      domainShortName = "GratefulDead",
      basePackage = "flatgraph.testdomains.gratefuldead"
    )

    object Properties {
      val name = builder.addProperty("Name", ValueType.String).mandatory(default = "")
      val songType = builder.addProperty("SongType", ValueType.String)
      val performances = builder.addProperty("performances", ValueType.Int)
      val weight = builder.addProperty("weight", ValueType.Long)
    }

    val artist = builder
      .addNodeType("Artist")
      .addProperty(Properties.name)

    val song = builder
      .addNodeType("Song")
      .addProperty(Properties.name)

    val followedBy = builder.addEdgeType("followedBy")// TODO .addProperty(Properties.weight)
    song.addOutEdge(followedBy, inNode = song, cardinalityOut = Cardinality.One)


    builder.build
  }
}
