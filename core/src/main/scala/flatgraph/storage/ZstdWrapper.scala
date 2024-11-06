package flatgraph.storage

import org.slf4j.LoggerFactory

import java.nio.file.{Files, Paths}
import scala.jdk.CollectionConverters.*
import scala.util.{Properties, Try}

object ZstdWrapper {
  private val logger = LoggerFactory.getLogger(getClass)

  /**
   * zstd-jni ships system libraries that are being unpacked, loaded and executed from the system tmp directory.
   * If that fails we get a rather obscure error message - this wrapper adds a check if the tmp dir is executable,
   * and enhances the error message if the zstd invocation fails.
   *
   * This is where zstd-jni loads the system library:
   * https://github.com/luben/zstd-jni/blob/9b08f1d0cdcf3b12b7a307cbba3d9f195149250b/src/main/java/com/github/luben/zstd/util/Native.java#L71
   */
  def apply[A](fun: => A): A = {
    probeTmpMountOptions()

    try {
      fun
    } catch { case e =>
      throw new JniInvocationException(
        "Error while trying to invoke zstd, i.e. cannot compress or decompress, which is required for flatgraph's storage",
        Option(e)
      )
    }
  }

  private def probeTmpMountOptions(): Unit = {
    val tmpDirPath = System.getProperty("java.io.tmpdir")
    lazy val warnMessage = s"the configured temp directory ($tmpDirPath) is mounted with `noexec` flag - " +
      "this will likely lead to an error when trying to invoke zstd. Please either remount it without `noexec` or " +
      "configure a different tmp directory, e.g. via java system property `-Djava.io.tmpdir=/path/to/tmp`"
    Try {
      if (Properties.isLinux || Properties.isMac) {
        val mounts = Files.readAllLines(Paths.get("/proc/mounts"))
        if (mounts.asScala.exists { mountInfoLine => mountInfoLine.contains(s" $tmpDirPath ") && mountInfoLine.contains("noexec")})
          logger.warn(warnMessage)
        }
      }
    // we're just probing here to warn the user and give some hints about fixing the situation
    // it's fairly brittle as well, so if this fails we won't bother
  }

  class JniInvocationException(message: String, cause: Option[Throwable]) extends RuntimeException(message, cause.orNull)
}
