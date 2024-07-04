package testdomains.hierarchical.nodes

trait BaseNodeEMT extends AnyRef with HasNameEMT

trait BaseNodeBase extends AbstractNode with StaticType[BaseNodeEMT]
// new properties: name
// inherited properties:
// inherited interfaces:
// implementing nodes: node_x, node_y
trait BaseNode extends StoredNode with BaseNodeBase with StaticType[BaseNodeEMT]

object BaseNode {
  object PropertyDefaults {
    val Name = "<empty>"
  }
}

trait BaseNodeNew extends NewNode with BaseNodeBase with StaticType[BaseNodeEMT] {
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
}

/** Node types with this marker trait are guaranteed to have the name property. EMT stands for: "erased marker trait", it exists only at
  * compile time in order to improve type safety.
  */
trait HasNameEMT
