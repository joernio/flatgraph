package flatgraph

import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.gratefuldead.GratefulDead
import testdomains.gratefuldead.language.*
import testdomains.gratefuldead.edges.{Sungby, Writtenby}
import testdomains.gratefuldead.nodes.{NewArtist, NewSong}

/** some tests to show the api of the generated domain classes - documentation driven development :) */
class GratefulDeadTests extends AnyWordSpec with MockFactory {

  "usage of generated domain specific api" in {
    val gratefulDead = GratefulDead.empty

    // create a simple graph with two nodes and two edges
    val diffGraph    = GratefulDead.newDiffGraphBuilder
    val garcia       = NewArtist().name("Garcia")
    val boDiddley    = NewArtist().name("Bo_Diddley")
    val heyBoDiddley = NewSong().name("HEY BO DIDDLEY").songtype("cover").performances(5)
    // n.b. if nodes are referenced in edges, they don't need to be added separately via `diffGraph.addNode`
    diffGraph.addEdge(src = heyBoDiddley, dst = boDiddley, Writtenby.Label)
    diffGraph.addEdge(src = heyBoDiddley, dst = garcia, Sungby.Label)
    DiffGraphApplier.applyDiff(gratefulDead.graph, diffGraph)

    // now query it in the typesafe domain-specific query language
    gratefulDead.artist.name.sorted shouldBe List("Bo_Diddley", "Garcia")
    gratefulDead.artist.name("Garcia").sang.name.l shouldBe List("HEY BO DIDDLEY")
    gratefulDead.song.writtenBy.name.l shouldBe List("Bo_Diddley")
  }

}
