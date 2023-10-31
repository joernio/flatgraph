package io.shiftleft.codepropertygraph.generated.v2.neighboraccessors

import io.joern.odb2.traversal.Language.*
import io.shiftleft.codepropertygraph.generated.v2.nodes
import io.shiftleft.codepropertygraph.generated.v2.Language.*

final class AccessNeighborsForComment(val node: nodes.Comment) extends AnyVal {

  /** Traverse to COMMENT via SOURCE_FILE IN edge.
    */
  def _commentViaSourceFileIn: Iterator[nodes.Comment] = node._sourceFileIn.iterator.collectAll[nodes.Comment]

  /** Traverse to COMMENT via SOURCE_FILE OUT edge.
    */
  def file: Iterator[nodes.Comment] = node._sourceFileOut.iterator.collectAll[nodes.Comment]

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Iterator[nodes.File] = node._astIn.iterator.collectAll[nodes.File]

}

final class AccessNeighborsForCommentTraversal(val traversal: Iterator[nodes.Comment]) extends AnyVal {

  /** Traverse to COMMENT via SOURCE_FILE IN edge.
    */
  def _commentViaSourceFileIn: Iterator[nodes.Comment] = traversal.flatMap(_._commentViaSourceFileIn)

  /** Traverse to COMMENT via SOURCE_FILE OUT edge.
    */
  def file: Iterator[nodes.Comment] = traversal.flatMap(_.file)

  /** Traverse to FILE via AST IN edge.
    */
  def _fileViaAstIn: Iterator[nodes.File] = traversal.flatMap(_._fileViaAstIn)

}
