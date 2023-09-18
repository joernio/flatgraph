package io.joern.odb2.benchmark

import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
import io.shiftleft.codepropertygraph.generated.v2.nodes.*
import io.shiftleft.codepropertygraph.generated.v2.traversals.Lang.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Verifies that the generated API (accessors via implicits) works for the joern domain.
 * Nothing really executes, we just want to verify that this code compiles and produces no ambiguity warnings.
 * */
class CompileTests extends AnyWordSpec with Matchers {
  import CompileTests.*

  def concreteStored(iter: Iterator[Call]): Unit = {
    iter.name("a")
    iter.order
    iter.next.order
    iter.isStatic.orderGt(3).staticCallee
    iter.next.isStatic.map { _.staticCallee }
  }

  def concreteBase(iter: Iterator[CallBase]): Unit = {
    iter.name("a")
    iter.order
    iter.next.order
    iter.isStatic
    // error: iter.isStatic.staticCallee
    iter.next.isStatic
    // error:  iter.next.isStatic.map{_.staticCallee}
  }

  def concreteNew(iter: Iterator[NewCall]): Unit = {
    iter.name("a")
    iter.order
    iter.next.order
    iter.isStatic
    // error: iter.isStatic.staticCallee
    iter.next.isStatic
    // error:  iter.next.isStatic.map{_.staticCallee}
  }

  def abstractStored(iter: Iterator[CallRepr]): Unit = {
    iter.name("a")
    iter.order
    iter.next.order
  }

  def abstractBase(iter: Iterator[CallReprBase]): Unit = {
    iter.name("a")
    iter.order
    iter.next.order
  }

  def abstractNew(iter: Iterator[CallReprNew]): Unit = {
    iter.name("a")
    iter.order
    iter.next.name
  }

  // here, both abstract types declare "name". So we test that the implicits are disambiguated.
  // there exist no nodes in the intersection, but the code should still compile.
  def conflictStored(iter: Iterator[Declaration with CallRepr]): Unit = {
    iter.name("a")
    iter.order
    iter.next.name
  }

  def conflictBase(iter: Iterator[DeclarationBase with CallReprBase]): Unit = {
    iter.name("a")
    iter.order
    iter.next.name
  }

  def conflictNew(iter: Iterator[DeclarationNew with CallReprNew]): Unit = {
    iter.name("a")
    iter.order
    iter.next.name
  }

}

object CompileTests {
  trait IsStaticT

  implicit class IsStaticExt[NodeType <: CallBase](val node: NodeType) extends AnyVal {
    // n.b. this should really be `def isStatic: Boolean` - the reason it's not is simply that we wanted to have compile-time test for
    // complex cases and didn't really think this through...
    def isStatic: Option[NodeType with StaticType[IsStaticT]] =
      if (node.dispatchType == "STATIC_DISPATCH") Some(node.asInstanceOf[NodeType with StaticType[IsStaticT]]) else None
  }

  implicit class IsStaticTravExt[NodeType <: CallBase](val trav: Iterator[NodeType]) extends AnyVal {
    def isStatic: Iterator[NodeType with StaticType[IsStaticT]] = trav.flatMap { _.isStatic }
  }

  implicit class StaticCallExt[NodeType <: Call with StaticType[IsStaticT]](val node: NodeType) extends AnyVal {
    def staticCallee: Method = node._callOut.head.asInstanceOf[Method]
  }

  implicit class StaticCallTravExt[NodeType <: Call with StaticType[IsStaticT]](val trav: Iterator[NodeType]) extends AnyVal {
    def staticCallee: Iterator[Method] = trav.map { _.staticCallee }
  }


}
