package io.joern.odb2.benchmark

//import io.joern.odb2.benchmark.EdgeAccessors.argument
import io.shiftleft.codepropertygraph.generated.v2.nodes.*

// TODO generate these by codegen, then remove this file
trait EdgeTraversals {
  extension (iter: Iterator[Call]) {
    def argument: Iterator[Expression] =
      ???
//      iter.flatMap(EdgeAccessors.argument)
  }
}
