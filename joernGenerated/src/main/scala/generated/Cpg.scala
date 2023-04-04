package io.shiftleft.codepropertygraph.generated.v2
import io.joern.odb2

object Cpg {
  def empty: Cpg = new Cpg(new odb2.Graph(GraphSchema))
}
class Cpg(val graph: odb2.Graph) {
  assert(graph.schema == GraphSchema)

}
