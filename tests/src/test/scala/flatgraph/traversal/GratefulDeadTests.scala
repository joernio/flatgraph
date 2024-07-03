package flatgraph.traversal

import flatgraph.formats.graphml.GraphMLImporter
import flatgraph.misc.Regex.InvalidRegexException
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.gratefuldead.GratefulDead
import testdomains.gratefuldead.language.*
import testdomains.gratefuldead.edges.{Sungby, Writtenby}
import testdomains.gratefuldead.nodes.{Artist, NewArtist, NewSong, Song}

/** some tests to show the api of the generated domain classes */
class GratefulDeadTests extends AnyWordSpec {

  "usage with empty graph generated domain specific api" in {
    // create a simple graph with two nodes and two edges
    val garcia       = NewArtist().name("Garcia")
    val boDiddley    = NewArtist().name("Bo_Diddley")
    val heyBoDiddley = NewSong().name("HEY BO DIDDLEY").songtype("cover").performances(5)
    // n.b. if nodes are referenced in edges, they don't need to be added separately via `diffGraph.addNode`
    val gratefulDead = GratefulDead.from(
      _.addEdge(src = heyBoDiddley, dst = boDiddley, Writtenby.Label)
        .addEdge(src = heyBoDiddley, dst = garcia, Sungby.Label)
    )

    // now query it in the typesafe domain-specific query language
    gratefulDead.artist.name.sorted shouldBe List("Bo_Diddley", "Garcia")
    gratefulDead.artist.name("Garcia").sang.name.l shouldBe List("HEY BO DIDDLEY")
    gratefulDead.song.writtenBy.name.l shouldBe List("Bo_Diddley")
    gratefulDead.ids(0L, 1L << 32).l shouldBe List(boDiddley.storedRef.get, heyBoDiddley.storedRef.get)
    gratefulDead.id(2L).l shouldBe List.empty
  }

  lazy val gratefulDead = {
    val gratefulDead = GratefulDead.empty
    GraphMLImporter.runImport(gratefulDead.graph, "tests/src/test/resources/grateful-dead.xml")
    gratefulDead
  }

  "generic graph traversal".can {
    "perform generic graph steps" in {
      val graph = gratefulDead.graph
      graph.nodeCount shouldBe 808
      graph.nodes().label.toSet shouldBe Set(Artist.Label, Song.Label)

      graph.nodes(Artist.Label).size shouldBe 224
      graph.nodes(Song.Label).has(Song.PropertyNames.Name, "IM A MAN").size shouldBe 1
      graph.nodes().has(Song.PropertyNames.Songtype).size shouldBe 584
      graph.nodes().has(Song.PropertyNames.Performances, 2).size shouldBe 36
    }
  }

  "domain specific traversals" should {
    "offer basic starter steps" in {
      gratefulDead.artist.size shouldBe 224
      gratefulDead.song.size shouldBe 584

      gratefulDead.artist.nameExact("Bob_Dylan").size shouldBe 1

      val artistNames = gratefulDead.artist.name.l
      artistNames.size shouldBe 224
      artistNames.contains("Bob_Dylan") shouldBe true
    }

    "property filter" in {
      gratefulDead.artist.name(".*Bob.*").size shouldBe 3
      gratefulDead.artist.name(".*Bob.*", "^M.*").size shouldBe 16
      gratefulDead.artist.nameNot(".*Bob.*").size shouldBe 221
      gratefulDead.artist.nameNot(".*Bob.*", "^M.*").size shouldBe 208
      gratefulDead.artist.nameExact("Bob_Dylan").size shouldBe 1
      gratefulDead.artist.nameExact("Bob_Dylan", "All").size shouldBe 2
      gratefulDead.artist.name("Bob.*").size shouldBe 3
      gratefulDead.artist.name(".*Dylan").size shouldBe 1
      gratefulDead.artist.name(".*M.*").size shouldBe 30
      gratefulDead.artist.nameNot(".*M.*").size shouldBe 194

      gratefulDead.song.performances(1).size shouldBe 142
      gratefulDead.song.performancesGt(1).size shouldBe 341
      gratefulDead.song.performancesGte(1).size shouldBe 483
      gratefulDead.song.performancesLt(1).size shouldBe 101
      gratefulDead.song.performancesLte(1).size shouldBe 243

      // numeric filter steps
      gratefulDead.song.where(_.performances.equal(1)).size shouldBe 142
      gratefulDead.song.where(_.performances.greaterThan(1)).size shouldBe 341
      gratefulDead.song.where(_.performances.greaterThanEqual(1)).size shouldBe 483
      gratefulDead.song.where(_.performances.lessThan(1)).size shouldBe 101
      gratefulDead.song.where(_.performances.lessThanEqual(1)).size shouldBe 243
    }

    "throw useful exception when passing invalid regexp" in {
      intercept[InvalidRegexException] { gratefulDead.artist.name("this regexp is invalid [") }
    }

    "traverse domain-specific edges" in {
      gratefulDead.artist.nameExact("Bob_Dylan").sang.size shouldBe 22

      gratefulDead.song.nameExact("WALKIN THE DOG").followedBy.size shouldBe 5
      gratefulDead.song.nameExact("WALKIN THE DOG").followedBy.songtype.toSet shouldBe Set("original", "cover", "")
    }

    "be expressed in for comprehension" in {
      val traversal = for {
        artist <- gratefulDead.artist
        song   <- artist.sang
      } yield artist.name -> song.name

      val artistAndSongTuples = traversal.l
      artistAndSongTuples.size shouldBe 501
      artistAndSongTuples.sortBy(_._1).head shouldBe ("All" -> "AND WE BID YOU GOODNIGHT")
    }
  }

  "lifting elements into a Traversal" can {
    "lift a single element with `Traversal.fromSingle`" in {
      val dylan = gratefulDead.artist.nameExact("Bob_Dylan").next()
      Iterator.single(dylan).sang.size shouldBe 22
    }

    "lift a single element with `.start`" in {
      val dylan = gratefulDead.artist.nameExact("Bob_Dylan").next()
      dylan.start.sang.size shouldBe 22
    }

    "lift multiple elements with `Traversal.from`" in {
      val artist = gratefulDead.artist.nameExact("Bob_Dylan", "All").toList
      artist.iterator.sang.size shouldBe 31
    }
  }

  "repeat step".can {
    "across all playlists, how many distinct singers appear 3 places after a song sang by 'Hunter'?" in {
      gratefulDead.artist
        .name("Hunter")
        .sang
        .repeat(_.followedBy)(_.maxDepth(3))
        .sungBy
        .toSet
        .size shouldBe 43
    }
  }
}
