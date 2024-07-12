package flatgraph

import java.nio.charset.StandardCharsets

package object storage {

  /** file header in order to be able to detect the file type */
  val HeaderSize       = 16 // size for  than enough space for the MagicBytes
  val MagicBytesString = "FLT GRPH"
  val MagicBytes       = MagicBytesString.getBytes(StandardCharsets.UTF_8)

  object StorageType {
    val Bool   = "bool"
    val Byte   = "byte"
    val Short  = "short"
    val Int    = "int"
    val Long   = "long"
    val Ref    = "ref"
    val String = "string"
    val Double = "double"
    val Float  = "float"
  }

  object Keys {
    val Type               = "type"
    val StartOffset        = "startOffset"
    val CompressedLength   = "compressedLength"
    val DecompressedLength = "decompressedLength"
    val NodeLabel          = "nodeLabel"
    val PropertyLabel      = "propertyLabel"
    val Quantity           = "qty"
    val Property           = "property"
    val NNodes             = "nnodes"
    val Deletions          = "deletions"
    val EdgeLabel          = "edgeLabel"
    val InOut              = "inout"
    val Neighbors          = "neighbors"
    val Version            = "version"
    val Nodes              = "nodes"
    val Edges              = "edges"
    val Properties         = "properties"
    val StringPoolLength   = "stringPoolLength"
    val StringPoolBytes    = "stringPoolBytes"
    val Header             = MagicBytes
  }

}
