package io.joern.odb2.benchmark

import io.shiftleft.codepropertygraph.generated.v2.nodes.*
import io.joern.odb2.Traversal.*

// TODO generate these by codegen, then remove this file
trait EdgeAccessors {
  extension (call: Call) {
    def argument: Iterator[Expression] = {
      call._argumentOut.iterator.collectAll[Expression]
    }
  }

}
