package flatgraph.traversal

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import flatgraph.*
import flatgraph.traversal.language.*
import flatgraph.TestGraphs.FlatlineGraphFixture
import testdomains.generic.nodes.NodeA
import testdomains.generic.edges.ConnectedTo

/** generic (i.e. domain independent) graph traversals, */
class GenericGraphTraversalTests extends AnyWordSpec with FlatlineGraphFixture {
  val graph        = genericDomain.graph
  val doesNotExist = "does not exist"

  "all nodes/edges lookup" in {
    graph.nodes().label.distinct.l shouldBe List(NodeA.Label)
    graph.allNodes.size shouldBe 9
    graph.nodes().size shouldBe 9
    graph.nodes(NodeA.Label).size shouldBe 9
    graph.nodes(doesNotExist).size shouldBe 0

    graph.edgeCount shouldBe 8
  }

  "base steps: out/in/both".can {
    "step out" in {
      center.out.toSet shouldBe Set(l1, r1)
      center.out.out.toSet shouldBe Set(l2, r2)
      center.out(ConnectedTo.Label).toSet shouldBe Set(l1, r1)
      center.out(doesNotExist).toSet shouldBe Set.empty

      Iterator(center).out.toSet shouldBe Set(l1, r1)
      Iterator(center).out.out.toSet shouldBe Set(l2, r2)
      Iterator(center).out(ConnectedTo.Label).toSet shouldBe Set(l1, r1)
      Iterator(center).out(doesNotExist).toSet shouldBe Set.empty
    }

    "step in" in {
      l2.in.size shouldBe 1
      l2.in.toSet shouldBe Set(l1)
      l2.in.in.toSet shouldBe Set(center)
      l2.in(ConnectedTo.Label).toSet shouldBe Set(l1)
      l2.in(doesNotExist).toSet shouldBe Set.empty

      Iterator(l2).in.size shouldBe 1
      Iterator(l2).in.toSet shouldBe Set(l1)
      Iterator(l2).in.in.toSet shouldBe Set(center)
      Iterator(l2).in(ConnectedTo.Label).toSet shouldBe Set(l1)
      Iterator(l2).in(doesNotExist).toSet shouldBe Set.empty
    }

    "step both" in {
      l2.both.size shouldBe 2
      l2.both.toSet shouldBe Set(l1, l3)
      r2.both.toSet shouldBe Set(r1, r3)
      l2.both.both.toSet shouldBe Set(l2, center)
      r2.both.both.toSet shouldBe Set(center, r2, r4)
      l2.both(ConnectedTo.Label).toSet shouldBe Set(l1, l3)
      l2.both(doesNotExist).toSet shouldBe Set.empty

      Iterator(l2).both.size shouldBe 2
      Iterator(l2).both.toSet shouldBe Set(l1, l3)
      Iterator(r2).both.toSet shouldBe Set(r1, r3)
      Iterator(l2).both.both.toSet shouldBe Set(l2, center)
      Iterator(r2).both.both.toSet shouldBe Set(center, r2, r4)
      Iterator(l2).both(ConnectedTo.Label).toSet shouldBe Set(l1, l3)
      Iterator(l2).both(doesNotExist).toSet shouldBe Set.empty
    }

    "step outE" in {
      center.outE.size shouldBe 2
      center.outE.src.toSet shouldBe Set(center)
      center.outE.dst.toSet shouldBe Set(l1, r1)
      center.outE.dst.outE.dst.toSet shouldBe Set(l2, r2)
      center.outE(ConnectedTo.Label).dst.toSet shouldBe Set(l1, r1)
      center.outE(doesNotExist).dst.toSet shouldBe Set.empty

      Iterator(center).outE.size shouldBe 2
      Iterator(center).outE.src.toSet shouldBe Set(center)
      Iterator(center).outE.dst.toSet shouldBe Set(l1, r1)
      Iterator(center).outE.dst.outE.dst.toSet shouldBe Set(l2, r2)
      Iterator(center).outE(ConnectedTo.Label).dst.toSet shouldBe Set(l1, r1)
      Iterator(center).outE(doesNotExist).dst.toSet shouldBe Set.empty
    }

    "step inE" in {
      l2.inE.size shouldBe 1
      l2.inE.dst.toSet shouldBe Set(l2)
      l2.inE.src.toSet shouldBe Set(l1)
      l2.inE.src.inE.src.toSet shouldBe Set(center)
      l2.inE(ConnectedTo.Label).src.toSet shouldBe Set(l1)
      l2.inE(doesNotExist).src.toSet shouldBe Set.empty

      Iterator(l2).inE.size shouldBe 1
      Iterator(l2).inE.dst.toSet shouldBe Set(l2)
      Iterator(l2).inE.src.toSet shouldBe Set(l1)
      Iterator(l2).inE.src.inE.src.toSet shouldBe Set(center)
      Iterator(l2).inE(ConnectedTo.Label).src.toSet shouldBe Set(l1)
      Iterator(l2).inE(doesNotExist).src.toSet shouldBe Set.empty
    }

    "step bothE" in {
      l2.bothE.size shouldBe 2
      l2.bothE(ConnectedTo.Label).size shouldBe 2
      l2.bothE(doesNotExist).size shouldBe 0

      Iterator(l2).bothE.size shouldBe 2
      Iterator(l2).bothE(ConnectedTo.Label).size shouldBe 2
      Iterator(l2).bothE(doesNotExist).size shouldBe 0
    }
  }

  "filter steps".can {
    import NodeA.PropertyNames.StringMandatory

    "filter by property" in {
      graph.nodes().has(StringMandatory).size shouldBe 9
      graph.nodes().has(StringMandatory, "R1").size shouldBe 1
      graph.nodes().has(doesNotExist).size shouldBe 0

      graph.nodes().hasNot(StringMandatory).size shouldBe 0
      graph.nodes().hasNot(StringMandatory, "R1").size shouldBe 8
      graph.nodes().hasNot(doesNotExist).size shouldBe 9
    }

    "`where` step taking a traversal" in {
      // find all nodes that _do_ have an OUT neighbor, i.e. find the inner nodes
      graph.nodes().where(_.out).property(StringMandatory).toSet shouldBe Set("L2", "L1", "Center", "R1", "R2", "R3", "R4")
    }

    "`not` step taking a traversal" in {
      // find all nodes that do _not_ have an OUT neighbor, i.e. find the outermost nodes
      graph.nodes().not(_.out).property(StringMandatory).toSet shouldBe Set("L3", "R5")
    }
  }
}
