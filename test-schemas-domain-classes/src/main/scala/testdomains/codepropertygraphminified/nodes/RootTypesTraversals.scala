package testdomains.codepropertygraphminified.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _callOut: Iterator[StoredNode] = iterator.flatMap(_._callOut)
  final def _callIn: Iterator[StoredNode]  = iterator.flatMap(_._callIn)

}
