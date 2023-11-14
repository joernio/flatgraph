package io.shiftleft.codepropertygraph.generated.v2.nodes
import io.joern.odb2

trait StaticType[+T]

trait AbstractNode extends odb2.DNodeOrNode with StaticType[AnyRef] with Product {
  def label: String
  def propertiesMap: java.util.Map[String, Any]
}

abstract class StoredNode(graph_4762: odb2.Graph, kind_4762: Short, seq_4762: Int)
    extends odb2.GNode(graph_4762, kind_4762, seq_4762)
    with AbstractNode {

  final def _aliasOfOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 0).asInstanceOf[Iterator[StoredNode]]
  final def _aliasOfIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 0).asInstanceOf[Iterator[StoredNode]]

  final def _argumentOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 1).asInstanceOf[Iterator[StoredNode]]
  final def _argumentIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 1).asInstanceOf[Iterator[StoredNode]]

  final def _astOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 2).asInstanceOf[Iterator[StoredNode]]
  final def _astIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 2).asInstanceOf[Iterator[StoredNode]]

  final def _bindsOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 3).asInstanceOf[Iterator[StoredNode]]
  final def _bindsIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 3).asInstanceOf[Iterator[StoredNode]]

  final def _bindsToOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 4).asInstanceOf[Iterator[StoredNode]]
  final def _bindsToIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 4).asInstanceOf[Iterator[StoredNode]]

  final def _callOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 5).asInstanceOf[Iterator[StoredNode]]
  final def _callIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 5).asInstanceOf[Iterator[StoredNode]]

  final def _captureOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 6).asInstanceOf[Iterator[StoredNode]]
  final def _captureIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 6).asInstanceOf[Iterator[StoredNode]]

  final def _capturedByOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 7).asInstanceOf[Iterator[StoredNode]]
  final def _capturedByIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 7).asInstanceOf[Iterator[StoredNode]]

  final def _cdgOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 8).asInstanceOf[Iterator[StoredNode]]
  final def _cdgIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 8).asInstanceOf[Iterator[StoredNode]]

  final def _cfgOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 9).asInstanceOf[Iterator[StoredNode]]
  final def _cfgIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 9).asInstanceOf[Iterator[StoredNode]]

  final def _conditionOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 10).asInstanceOf[Iterator[StoredNode]]
  final def _conditionIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 10).asInstanceOf[Iterator[StoredNode]]

  final def _containsOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 11).asInstanceOf[Iterator[StoredNode]]
  final def _containsIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 11).asInstanceOf[Iterator[StoredNode]]

  final def _dominateOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 12).asInstanceOf[Iterator[StoredNode]]
  final def _dominateIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 12).asInstanceOf[Iterator[StoredNode]]

  final def _evalTypeOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 13).asInstanceOf[Iterator[StoredNode]]
  final def _evalTypeIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 13).asInstanceOf[Iterator[StoredNode]]

  final def _importsOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 14).asInstanceOf[Iterator[StoredNode]]
  final def _importsIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 14).asInstanceOf[Iterator[StoredNode]]

  final def _inheritsFromOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 15).asInstanceOf[Iterator[StoredNode]]
  final def _inheritsFromIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 15).asInstanceOf[Iterator[StoredNode]]

  final def _isCallForImportOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 16).asInstanceOf[Iterator[StoredNode]]
  final def _isCallForImportIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 16).asInstanceOf[Iterator[StoredNode]]

  final def _parameterLinkOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 17).asInstanceOf[Iterator[StoredNode]]
  final def _parameterLinkIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 17).asInstanceOf[Iterator[StoredNode]]

  final def _postDominateOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 18).asInstanceOf[Iterator[StoredNode]]
  final def _postDominateIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 18).asInstanceOf[Iterator[StoredNode]]

  final def _reachingDefOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 19).asInstanceOf[Iterator[StoredNode]]
  final def _reachingDefIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 19).asInstanceOf[Iterator[StoredNode]]

  final def _receiverOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 20).asInstanceOf[Iterator[StoredNode]]
  final def _receiverIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 20).asInstanceOf[Iterator[StoredNode]]

  final def _refOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 21).asInstanceOf[Iterator[StoredNode]]
  final def _refIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 21).asInstanceOf[Iterator[StoredNode]]

  final def _sourceFileOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 22).asInstanceOf[Iterator[StoredNode]]
  final def _sourceFileIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 22).asInstanceOf[Iterator[StoredNode]]

  final def _taggedByOut: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsOut(this.graph, this.nodeKind, this.seq, 23).asInstanceOf[Iterator[StoredNode]]
  final def _taggedByIn: Iterator[StoredNode] =
    odb2.Accessors.getNeighborsIn(this.graph, this.nodeKind, this.seq, 23).asInstanceOf[Iterator[StoredNode]]

}

abstract class NewNode(val nodeKind: Short) extends AbstractNode with odb2.DNode {
  type RelatedStored <: StoredNode
  private /* volatile? */ var _storedRef: RelatedStored      = null.asInstanceOf[RelatedStored]
  override def storedRef: Option[RelatedStored]              = Option(this._storedRef)
  override def storedRef_=(stored: Option[odb2.GNode]): Unit = this._storedRef = stored.orNull.asInstanceOf[RelatedStored]
  def isValidOutNeighbor(edgeLabel: String, n: NewNode): Boolean
  def isValidInNeighbor(edgeLabel: String, n: NewNode): Boolean
  def copy(): this.type
}
