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

  "concrete stored class" in {
    lazy val iter: Iterator[Call] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
      iter.isStatic.orderGt(3).staticCallee
      iter.next.isStatic.map(_.staticCallee)
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

  implicit class IsStaticExt[NodeType <: CallBase](val node: NodeType) extends AnyVal {
    // n.b. this should really be `def isStatic: Boolean` - the reason it's not is simply that we wanted to have compile-time test for
    // complex cases and didn't really think this through...
    def isStatic: Option[NodeType] =
      if (node.dispatchType == "STATIC_DISPATCH") Some(node) else None
  }

  implicit class IsStaticTravExt[NodeType <: CallBase](val trav: Iterator[NodeType]) extends AnyVal {
    def isStatic: Iterator[NodeType] = trav.flatMap { _.isStatic }
  }

  implicit class StaticCallExt[NodeType <: Call](val node: NodeType) extends AnyVal {
    def staticCallee: Method = node._callOut.head.asInstanceOf[Method]
  }

  implicit class StaticCallTravExt[NodeType <: Call](val trav: Iterator[NodeType]) extends AnyVal {
    def staticCallee: Iterator[Method] = trav.map { _.staticCallee }
  }


}
