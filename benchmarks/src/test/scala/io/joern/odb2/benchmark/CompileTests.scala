package io.joern.odb2.benchmark

import io.shiftleft.codepropertygraph.generated.v2
import v2.accessors.Lang.*
import v2.nodes
import v2.traversals.Lang.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Verifies that the generated API (accessors via implicits) works for the joern domain.
 * Nothing really executes, we just want to verify that this code compiles and produces no ambiguity warnings.
 * */
class CompileTests extends AnyWordSpec with Matchers {
  import CompileTests.*

  def concreteStored(it: Iterator[nodes.Call]): Unit = {
    it.name("a")
    it.order
    it.next.order
    it.isStatic.orderGt(3).staticCallee
    it.next.isStatic.map { _.staticCallee }
  }

  def concreteBase(it: Iterator[nodes.CallBase]): Unit = {
    it.name("a")
    it.order
    it.next.order
    it.isStatic
    // error: it.isStatic.staticCallee
    it.next.isStatic
    // error:  it.next.isStatic.map{_.staticCallee}
  }

  def concreteNew(it: Iterator[nodes.NewCall]): Unit = {
    it.name("a")
    it.order
    it.next.order
    it.isStatic
    // error: it.isStatic.staticCallee
    it.next.isStatic
    // error:  it.next.isStatic.map{_.staticCallee}
  }

  def abstractStored(it: Iterator[nodes.CallRepr]): Unit = {
    it.name("a")
    it.order
    it.next.order
  }

  def abstractBase(it: Iterator[nodes.CallReprBase]): Unit = {
    it.name("a")
    it.order
    it.next.order
  }

  def abstractNew(it: Iterator[nodes.CallReprNew]): Unit = {
    it.name("a")
    it.order
    it.next.name
  }

  // here, both abstract types declare "name". So we test that the implicits are disambiguated.
  // there exist no nodes in the intersection, but the code should still compile.
  def conflictStored(it: Iterator[nodes.Declaration with nodes.CallRepr]): Unit = {
    it.name("a")
    it.order
    it.next.name
  }

  def conflictBase(it: Iterator[nodes.DeclarationBase with nodes.CallReprBase]): Unit = {
    it.name("a")
    it.order
    it.next.name
  }

  def conflictNew(it: Iterator[nodes.DeclarationNew with nodes.CallReprNew]): Unit = {
    it.name("a")
    it.order
    it.next.name
  }

}

object CompileTests {
  trait IsStaticT

  implicit class IsStaticExt[NodeType <: nodes.CallBase](val node: NodeType) extends AnyVal {
    // n.b. this should really be `def isStatic: Boolean` - the reason it's not is simply that we wanted to have compile-time test for
    // complex cases and didn't really think this through...
    def isStatic: Option[NodeType with nodes.StaticType[IsStaticT]] =
      if (node.dispatchType == "STATIC_DISPATCH") Some(node.asInstanceOf[NodeType with nodes.StaticType[IsStaticT]]) else None
  }

  implicit class IsStaticTravExt[NodeType <: nodes.CallBase](val trav: Iterator[NodeType]) extends AnyVal {
    def isStatic: Iterator[NodeType with nodes.StaticType[IsStaticT]] = trav.flatMap { _.isStatic }
  }

  implicit class StaticCallExt[NodeType <: nodes.Call with nodes.StaticType[IsStaticT]](val node: NodeType) extends AnyVal {
    def staticCallee: nodes.Method = node._callOut.head.asInstanceOf[nodes.Method]
  }

  implicit class StaticCallTravExt[NodeType <: nodes.Call with nodes.StaticType[IsStaticT]](val trav: Iterator[NodeType]) extends AnyVal {
    def staticCallee: Iterator[nodes.Method] = trav.map { _.staticCallee }
  }


}
