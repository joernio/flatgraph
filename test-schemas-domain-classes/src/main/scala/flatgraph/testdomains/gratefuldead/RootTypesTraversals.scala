package flatgraph.testdomains.gratefuldead.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _followedbyOut: Iterator[StoredNode] = iterator.flatMap(_._followedbyOut)
  final def _followedbyIn: Iterator[StoredNode]  = iterator.flatMap(_._followedbyIn)

}
