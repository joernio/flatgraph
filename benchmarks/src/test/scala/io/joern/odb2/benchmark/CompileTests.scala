package io.joern.odb2.benchmark

import io.joern.odb2.benchmark.EdgeAccessors.Language.*
import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
import io.shiftleft.codepropertygraph.generated.v2.nodes.*
import io.shiftleft.codepropertygraph.generated.v2.traversals.Lang.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * Verifies that the generated API (accessors via implicits) works for the joern domain.
 * Nothing really executes, we just want to verify that this code compiles and produces no ambiguity warnings.
 *
 * Demonstrate that users can ad-hoc subtype nodes and write extension methods for the ad-hoc  subtypes.
 * In this example we define an ad-hoc  `IsStaticT` subtype of CALL which is "statically dispatched call", and an
 * extension method staticCallee that safely goes to the callee.
 * This extension method is only defined on our ad-hoc subtype.
 * */
class CompileTests extends AnyWordSpec with Matchers {
  import CompileTests.*

  "concrete stored class" in {
    lazy val iter: Iterator[Call] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
      iter.isStatic.orderGt(3).staticCallee
      iter.next.isStatic.map(_.staticCallee)

      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: Iterator[Call & StaticType[IsStaticT]] = iter.isStatic

      // edge accessors
      iter.next.argument
      iter.argument
    }
  }

  "concrete base trait" in {
    lazy val iter: Iterator[CallBase] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
      iter.isStatic
      iter.next.isStatic

      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: Iterator[CallBase & StaticType[IsStaticT]] = iter.isStatic
    }
    assertDoesNotCompile("iter.isStatic.staticCallee")
    assertDoesNotCompile("iter.next.isStatic.map(_.staticCallee)")
  }

  "concrete New* class" in {
    lazy val iter: Iterator[NewCall] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
      iter.isStatic
      iter.next.isStatic

      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: Iterator[NewCall & StaticType[IsStaticT]] = iter.isStatic
    }
    assertDoesNotCompile("iter.isStatic.staticCallee")
    assertDoesNotCompile("iter.next.isStatic.map(_.staticCallee)")
  }

  "abstract stored class" in {
    lazy val iter: Iterator[CallRepr] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
    }

  }

  "abstract base class" in {
    lazy val iter: Iterator[CallReprBase] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
    }
  }

  "abstract New* class" in {
    lazy val iter: Iterator[CallReprNew] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
    }
  }

  "resolves name ambiguity" when {
    // here, both abstract types declare "name". So we test that the implicits are disambiguated.
    // there exist no nodes in the intersection, but the code should still compile.

    "using stored class" in {
      lazy val iter: Iterator[Declaration with CallRepr] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }

    "using base class" in {
      lazy val iter: Iterator[Declaration with CallReprBase] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }

    "using New* class" in {
      lazy val iter: Iterator[Declaration with CallReprNew] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }
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
