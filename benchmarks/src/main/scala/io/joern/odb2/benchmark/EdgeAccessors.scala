package io.joern.odb2.benchmark

import io.joern.odb2.Traversal.*
import io.shiftleft.codepropertygraph.generated.v2.nodes.*

// TODO generate these by codegen, then remove this file

object EdgeAccessors {
  object Language extends ForNodes with ForTraversals

  object ForNodes extends ForNodes
  trait ForNodes {
    extension (call: Call) {
      def argument: Iterator[Expression] = call._argumentOut.iterator.collectAll[Expression]
    }
  }

  trait ForTraversals {
    extension (iter: Iterator[Call]) {
      def argument: Iterator[Expression] = iter.flatMap(ForNodes.argument)
    }
  }

}
