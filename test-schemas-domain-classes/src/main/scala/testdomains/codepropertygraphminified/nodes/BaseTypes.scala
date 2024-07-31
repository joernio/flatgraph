package testdomains.codepropertygraphminified.nodes

trait CallReprEMT extends AnyRef with HasNameEMT with HasOrderEMT

trait CallReprBase extends AbstractNode with StaticType[CallReprEMT]
// new properties: NAME, ORDER
// inherited properties:
// inherited interfaces:
// implementing nodes: CALL
trait CallRepr extends StoredNode with CallReprBase with StaticType[CallReprEMT]

object CallRepr {
  object PropertyDefaults {
    val Name  = "<empty>"
    val Order = -1: Int
  }
}

trait CallReprNew extends NewNode with CallReprBase with StaticType[CallReprEMT] {
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
  def order: Int
  def order_=(value: Int): Unit
  def order(value: Int): this.type
}

trait DeclarationEMT extends AnyRef with HasNameEMT

trait DeclarationBase extends AbstractNode with StaticType[DeclarationEMT]
// new properties: NAME
// inherited properties:
// inherited interfaces:
// implementing nodes: METHOD
trait Declaration extends StoredNode with DeclarationBase with StaticType[DeclarationEMT]

object Declaration {
  object PropertyDefaults {
    val Name = "<empty>"
  }
}

trait DeclarationNew extends NewNode with DeclarationBase with StaticType[DeclarationEMT] {
  def name: String
  def name_=(value: String): Unit
  def name(value: String): this.type
}

/** Node types with this marker trait are guaranteed to have the DISPATCH_TYPE property. EMT stands for: "erased marker trait", it exists
  * only at compile time in order to improve type safety.
  */
trait HasDispatchTypeEMT

/** Node types with this marker trait are guaranteed to have the NAME property. EMT stands for: "erased marker trait", it exists only at
  * compile time in order to improve type safety.
  */
trait HasNameEMT

/** Node types with this marker trait are guaranteed to have the ORDER property. EMT stands for: "erased marker trait", it exists only at
  * compile time in order to improve type safety.
  */
trait HasOrderEMT
