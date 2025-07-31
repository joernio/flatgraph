package testdomains.generic.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _anotherEdgeOut: Iterator[StoredNode] = iterator.flatMap(_._anotherEdgeOut)
  final def _anotherEdgeIn: Iterator[StoredNode]  = iterator.flatMap(_._anotherEdgeIn)

  final def _connectedToOut: Iterator[StoredNode] = iterator.flatMap(_._connectedToOut)
  final def _connectedToIn: Iterator[StoredNode]  = iterator.flatMap(_._connectedToIn)

}
