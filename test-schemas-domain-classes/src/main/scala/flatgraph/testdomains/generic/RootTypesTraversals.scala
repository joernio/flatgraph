package flatgraph.testdomains.generic.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _connectedtoOut: Iterator[StoredNode] = iterator.flatMap(_._connectedtoOut)
  final def _connectedtoIn: Iterator[StoredNode]  = iterator.flatMap(_._connectedtoIn)

}
