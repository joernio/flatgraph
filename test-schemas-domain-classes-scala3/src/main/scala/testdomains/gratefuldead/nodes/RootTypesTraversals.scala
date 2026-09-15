package testdomains.gratefuldead.nodes

extension (iterator: Iterator[StoredNode]) {

  final def _followedbyOut: Iterator[StoredNode] = iterator.flatMap(_._followedbyOut)
  final def _followedbyIn: Iterator[StoredNode]  = iterator.flatMap(_._followedbyIn)

  final def _sungbyOut: Iterator[StoredNode] = iterator.flatMap(_._sungbyOut)
  final def _sungbyIn: Iterator[StoredNode]  = iterator.flatMap(_._sungbyIn)

  final def _writtenbyOut: Iterator[StoredNode] = iterator.flatMap(_._writtenbyOut)
  final def _writtenbyIn: Iterator[StoredNode]  = iterator.flatMap(_._writtenbyIn)

}
