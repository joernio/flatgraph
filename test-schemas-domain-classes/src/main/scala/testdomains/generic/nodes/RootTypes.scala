package testdomains.generic.nodes

trait StaticType[+T]

trait AbstractNode extends flatgraph.DNodeOrNode with StaticType[AnyRef] with Product {
  def label: String

  def properties: Map[String, Any] = {
    scala.jdk.CollectionConverters.MapHasAsScala(propertiesMap).asScala.toMap
  }

  /** TODO deprecate and phase out */
  def propertiesMap: java.util.Map[String, Any]
}

abstract class StoredNode(graph_4762: flatgraph.Graph, kind_4762: Short, seq_4762: Int)
    extends flatgraph.GNode(graph_4762, kind_4762, seq_4762)
    with AbstractNode {

  final def _anotherEdgeOut: Iterator[StoredNode] = {
    flatgraph.Accessors
      .getNeighborsOut(this.graph, nodeKind = this.nodeKind, seq = this.seq, edgeKind = 0)
      .asInstanceOf[Iterator[StoredNode]]
  }
  final def _anotherEdgeIn: Iterator[StoredNode] = {
    flatgraph.Accessors
      .getNeighborsIn(this.graph, nodeKind = this.nodeKind, seq = this.seq, edgeKind = 0)
      .asInstanceOf[Iterator[StoredNode]]
  }

  final def _connectedToOut: Iterator[StoredNode] = {
    flatgraph.Accessors
      .getNeighborsOut(this.graph, nodeKind = this.nodeKind, seq = this.seq, edgeKind = 1)
      .asInstanceOf[Iterator[StoredNode]]
  }
  final def _connectedToIn: Iterator[StoredNode] = {
    flatgraph.Accessors
      .getNeighborsIn(this.graph, nodeKind = this.nodeKind, seq = this.seq, edgeKind = 1)
      .asInstanceOf[Iterator[StoredNode]]
  }

}

abstract class NewNode(val nodeKind: Short) extends AbstractNode with flatgraph.DNode {
  private /* volatile? */ var _storedRef: StoredNodeType          = null.asInstanceOf[StoredNodeType]
  override def storedRef: Option[StoredNodeType]                  = Option(this._storedRef)
  override def storedRef_=(stored: Option[flatgraph.GNode]): Unit = this._storedRef = stored.orNull.asInstanceOf[StoredNodeType]
  def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean
  def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean
  def copy: this.type
}
