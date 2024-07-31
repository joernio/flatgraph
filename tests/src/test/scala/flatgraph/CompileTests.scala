package flatgraph

import testdomains.codepropertygraphminified.*
import testdomains.codepropertygraphminified.nodes.*
import testdomains.codepropertygraphminified.language.*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/** Verifies that the generated API (accessors via implicits) works for the joern domain. Nothing really executes, we just want to verify
  * that this code compiles and produces no ambiguity warnings.
  *
  * Demonstrate that users can ad-hoc subtype nodes and write extension methods for the ad-hoc subtypes. In this example we define an ad-hoc
  * `IsStaticEMT` subtype of CALL which is "statically dispatched call", and an extension method staticCallee that safely goes to the
  * callee. This extension method is only defined on our ad-hoc subtype.
  */
class CompileTests extends AnyWordSpec with Matchers {
  import CompileTests.*

  "starter steps" in {
    lazy val compiles = {
      val cpg: CpgMinified = ???
      cpg.all
      cpg.method
    }
  }

  "concrete stored class" in {
    lazy val iter: Iterator[Call] = ???
    lazy val compiles = {
      iter.name("a")
      iter.order
      iter.next.order
      iter.isStatic.orderGt(3).staticCallee
      iter.next.isStatic.map(_.staticCallee)

      val isStaticIter = iter.isStatic
      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: Call & StaticType[IsStaticEMT] = isStaticIter.next()

      // edge accessors
      iter.next.method
      iter.method
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

      val isStaticIter = iter.isStatic
      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: CallBase & StaticType[IsStaticEMT] = isStaticIter.next()
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

      val isStaticIter = iter.isStatic
      // resolved type is both a Call and our ad-hoc defined `IsStatic` trait
      val _: NewCall & StaticType[IsStaticEMT] = isStaticIter.next()
    }
    assertDoesNotCompile("iter.isStatic.staticCallee")
    assertDoesNotCompile("iter.next.isStatic.map(_.staticCallee)")
  }

  "abstract stored class" in {
    lazy val iter: Iterator[Declaration] = ???
    lazy val compiles = {
      iter.name("a")
      iter.next.name
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
      lazy val iter: Iterator[Declaration & CallRepr] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }

    "using base class" in {
      lazy val iter: Iterator[Declaration & CallReprBase] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }

    "using New* class" in {
      lazy val iter: Iterator[Declaration & CallReprNew] = ???
      lazy val compiles = {
        iter.name("a")
        iter.order
        iter.next.name
      }
    }
  }

}

object CompileTests {

  /** Marker trait to indicate that a given `Call` node is static. Demonstrates the usage of ad-hoc defined erased marker traits (EMT) - the
    * original schema does not have `IsStatic` as a property. EMTs exists only at compile time in order to improve type safety. Hence, it's
    * safe to cast a given node instance to this marker type (see example below).
    */
  trait IsStaticEMT

  implicit class IsStaticExt[NodeType <: CallBase](val node: NodeType) extends AnyVal {
    // n.b. this should really be `def isStatic: Boolean` - the reason it's not is simply that we wanted to have compile-time test for
    // complex cases and didn't really think this through...
    def isStatic: Option[NodeType & StaticType[IsStaticEMT]] =
      if (node.dispatchType == "STATIC_DISPATCH") Some(node.asInstanceOf[NodeType & StaticType[IsStaticEMT]]) else None
  }

  implicit class IsStaticTravExt[NodeType <: CallBase](val trav: Iterator[NodeType]) extends AnyVal {
    def isStatic: Iterator[NodeType & StaticType[IsStaticEMT]] = trav.flatMap { _.isStatic }
  }

  implicit class StaticCallExt[NodeType <: Call & StaticType[IsStaticEMT]](val node: NodeType) extends AnyVal {
    def staticCallee: Method = node._callOut.head.asInstanceOf[Method]
  }

  implicit class StaticCallTravExt[NodeType <: Call & StaticType[IsStaticEMT]](val trav: Iterator[NodeType]) extends AnyVal {
    def staticCallee: Iterator[Method] = trav.map { _.staticCallee }
  }

}
