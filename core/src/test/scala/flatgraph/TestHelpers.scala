package flatgraph

import java.nio.file.{Files, Path}
import scala.util.Try

object TestHelpers {
  def createTestNode(nodeKind: Int = 0, seqId: Int = 0): GNode =
    GNode(null, 0, 0)

  val DummyTestNode = createTestNode()

  def withTemporaryFile[A](prefix: String, suffix: String)(fun: Path => A): A = {
    val storagePath = Files.createTempFile(prefix, s".$suffix")
    val attempt     = Try(fun(storagePath))
    Files.deleteIfExists(storagePath)
    attempt.get
  }
}
