package flatgraph.storage

import flatgraph.Edge

object Manifest {
  object GraphItem {
    def read(item: ujson.Value): GraphItem = {
      val version = item.obj(Keys.Version).num.toInt
      if (version != 0) throw new RuntimeException()
      val nodes            = item.obj(Keys.Nodes).arr.map(NodeItem.read).toArray
      val edges            = item.obj(Keys.Edges).arr.map(EdgeItem.read).toArray
      val properties       = item.obj(Keys.Properties).arr.map(PropertyItem.read).toArray
      val stringPoolLength = OutlineStorage.read(StorageType.Int, item.obj(Keys.StringPoolLength))
      val stringPoolBytes  = OutlineStorage.read(StorageType.Byte, item.obj(Keys.StringPoolBytes))
      val res              = new GraphItem(nodes, edges, properties, stringPoolLength, stringPoolBytes)
      res.version = version
      res
    }

    def write(item: GraphItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.Version) = 0
      res(Keys.Nodes) = ujson.Arr(item.nodes.map(NodeItem.write)*)
      res(Keys.Edges) = ujson.Arr(item.edges.map(EdgeItem.write)*)
      res(Keys.Properties) = ujson.Arr(item.properties.map(PropertyItem.write)*)
      res(Keys.StringPoolLength) = OutlineStorage.write(item.stringPoolLength)
      res(Keys.StringPoolBytes) = OutlineStorage.write(item.stringPoolBytes)
      res

    }
  }

  class GraphItem(
    var nodes: Array[NodeItem],
    var edges: Array[EdgeItem],
    var properties: Array[PropertyItem],
    val stringPoolLength: OutlineStorage,
    val stringPoolBytes: OutlineStorage
  ) {
    var version = 0
  }

  class NodeItem(val nodeLabel: String, val nnodes: Int, var deletions: Array[Int])

  object NodeItem {
    def write(item: NodeItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.NodeLabel) = item.nodeLabel
      res(Keys.NNodes) = item.nnodes
      res(Keys.Deletions) =
        if (item.deletions == null || item.deletions.isEmpty) ujson.Null else ujson.Arr(item.deletions.map { seq => ujson.Num(seq) }*)
      res
    }

    def read(item: ujson.Value): NodeItem = {
      val nodeLabel = item.obj(Keys.NodeLabel).str
      val nnodes    = item.obj(Keys.NNodes).num.toInt
      val deletions = item.obj
        .get(Keys.Deletions)
        .flatMap {
          case arr: ujson.Arr =>
            val a = arr.value.map(_.num.toInt)
            if (a.isEmpty) None else Some(a.toArray)
          case _ => None
        }
        .orNull

      new NodeItem(nodeLabel, nnodes, deletions)
    }
  }

  object EdgeItem {
    def read(item: ujson.Value): EdgeItem = {
      val nodeLabel = item.obj(Keys.NodeLabel).str
      val edgeLabel = item.obj(Keys.EdgeLabel).str
      val inout     = item.obj(Keys.InOut).num.toByte
      val qty       = OutlineStorage.read(StorageType.Int, item.obj(Keys.Quantity))
      val neighbors = OutlineStorage.read(StorageType.Ref, item.obj(Keys.Neighbors))
      val property  = OutlineStorage.read(item.obj(Keys.Property))
      new EdgeItem(nodeLabel, edgeLabel, inout, qty, neighbors, property)
    }

    def write(item: EdgeItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.NodeLabel) = item.nodeLabel
      res(Keys.EdgeLabel) = item.edgeLabel
      res(Keys.InOut) = item.inout
      res(Keys.Quantity) = OutlineStorage.write(item.qty)
      res(Keys.Neighbors) = OutlineStorage.write(item.neighbors)
      res(Keys.Property) = OutlineStorage.write(item.property)
      res
    }
  }

  class EdgeItem(
    val nodeLabel: String,
    val edgeLabel: String,
    val inout: Byte, // 0: Incoming, 1: Outgoing; see Edge.Direction enum
    var qty: OutlineStorage,
    var neighbors: OutlineStorage,
    var property: OutlineStorage
  ) {
    Edge.Direction.verifyEncodingRange(inout)
  }

  object PropertyItem {
    def write(item: PropertyItem): ujson.Value = {
      val res = ujson.Obj()
      res(Keys.NodeLabel) = item.nodeLabel
      res(Keys.PropertyLabel) = item.propertyLabel
      res(Keys.Quantity) = OutlineStorage.write(item.qty)
      res(Keys.Property) = OutlineStorage.write(item.property)
      res
    }

    def read(item: ujson.Value): PropertyItem = {
      val nodeLabel     = item.obj(Keys.NodeLabel).str
      val propertyLabel = item.obj(Keys.PropertyLabel).str
      val qty           = OutlineStorage.read(StorageType.Int, item.obj(Keys.Quantity))
      val property      = OutlineStorage.read(item.obj(Keys.Property))
      new PropertyItem(nodeLabel, propertyLabel, qty, property)
    }
  }

  class PropertyItem(val nodeLabel: String, val propertyLabel: String, var qty: OutlineStorage, var property: OutlineStorage)

  object OutlineStorage {
    def write(item: OutlineStorage): ujson.Value = {
      if (item == null) return ujson.Null
      val res = ujson.Obj()
      res(Keys.Type) = item.typ
      res(Keys.StartOffset) = ujson.Num(item.startOffset.toDouble)
      res(Keys.CompressedLength) = ujson.Num(item.compressedLength.toDouble)
      res(Keys.DecompressedLength) = ujson.Num(item.decompressedLength)
      res
    }

    def read(typ: String, item: ujson.Value): OutlineStorage = {
      val res = read(item)
      if (res != null && res.typ != typ) throw new RuntimeException()
      res
    }

    def read(item: ujson.Value): OutlineStorage = {
      if (item.isNull) return null
      val res = new OutlineStorage(item.obj(Keys.Type).str)
      res.startOffset = item.obj(Keys.StartOffset).num.toLong
      res.compressedLength = item.obj(Keys.CompressedLength).num.toInt
      res.decompressedLength = item.obj(Keys.DecompressedLength).num.toInt
      res
    }
  }

  class OutlineStorage(var typ: String) {
    var startOffset: Long       = -1L
    var compressedLength: Int   = -1
    var decompressedLength: Int = -1
  }
}
