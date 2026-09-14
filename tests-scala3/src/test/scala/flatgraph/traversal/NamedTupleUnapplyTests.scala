package flatgraph.traversal

import org.scalatest.matchers.should.Matchers.*
import org.scalatest.Inside.*
import org.scalatest.wordspec.AnyWordSpec
import testdomains.gratefuldead.GratefulDead
import testdomains.gratefuldead.language.*
import testdomains.gratefuldead.edges.{Sungby, Writtenby}
import testdomains.gratefuldead.nodes.{Artist, NewArtist, NewSong, Song}
import scala.collection.mutable

class NamedTupleUnapplyTests extends AnyWordSpec {

  "named tuple unapply" should {
    "destructure a Song node" in {
      val heyBoDiddley = NewSong().name("HEY BO DIDDLEY").songtype("cover").performances(5)
      val boDiddley    = NewArtist().name("Bo_Diddley")
      val gratefulDead = GratefulDead.from(_.addEdge(src = heyBoDiddley, dst = boDiddley, Writtenby.Label))

      inside(gratefulDead.song.toBuffer) { case mutable.Buffer(Song(name = name, songtype = Some("cover"), performances = Some(5))) =>
        name shouldBe "HEY BO DIDDLEY"
      }
      inside(gratefulDead.song.head) { case Song(name = name) =>
        name shouldBe "HEY BO DIDDLEY"
      }
    }

    "destructure an Artist node" in {
      val garcia       = NewArtist().name("Garcia")
      val gratefulDead = GratefulDead.from(_.addNode(garcia))

      val Artist(name = "Garcia") = gratefulDead.artist.head.runtimeChecked
    }
  }
}
