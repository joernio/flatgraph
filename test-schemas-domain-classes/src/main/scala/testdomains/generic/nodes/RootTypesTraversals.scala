package testdomains.generic.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _connectedToOut: Iterator[StoredNode] = iterator.flatMap(_._connectedToOut)
  final def _connectedToIn: Iterator[StoredNode]  = iterator.flatMap(_._connectedToIn)

}
