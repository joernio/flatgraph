package io.joern.odb2.benchmark

import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes

// TODO generate these by codegen, then remove this file

object EdgeAccessors {
  object Language {

    final implicit class Access_Edge_Argument(call: nodes.Call) extends AnyVal {
      def argument: Iterator[nodes.Expression] = call._argumentOut.iterator.collectAll[nodes.Expression]
    }

    final implicit class Access_Traversal_Edge_Argument(iter: Iterator[nodes.Call]) extends AnyVal {
      def argument: Iterator[nodes.Expression] = iter.flatMap(_.argument)
    }
  }

}
