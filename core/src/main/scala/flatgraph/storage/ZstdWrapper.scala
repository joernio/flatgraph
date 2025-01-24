package flatgraph.storage

import com.github.luben.zstd
import com.github.luben.zstd.{ZstdCompressCtx, ZstdDecompressCtx}
import org.slf4j.LoggerFactory

import java.nio.{ByteBuffer, ByteOrder}
import java.nio.file.{Files, Paths}
import scala.jdk.CollectionConverters.*
import scala.util.{Properties, Try}
import scala.collection.mutable

object ZstdWrapper {
  private val logger = LoggerFactory.getLogger(getClass)

  class ZstdCtx extends AutoCloseable {
    var closed         = false
    val compressCtxs   = mutable.ArrayDeque[zstd.ZstdCompressCtx]()
    val decompressCtxs = mutable.ArrayDeque[zstd.ZstdDecompressCtx]()

    // cf library documentation: The resulting buffer is ready-to-go, i.e. comes pre-flipped / rewound.
    def compress(bytes: Array[Byte]): ByteBuffer = ZstdWrapper.apply {
      val ctx0 = this.synchronized {
        compressCtxs.removeLastOption()
      }
      val ctx = ctx0.getOrElse {
        val res = new ZstdCompressCtx
        res.setLevel(zstd.Zstd.defaultCompressionLevel())
        res
      }
      try {

        /** So, this allocateDirect thing may look somewhat awkward and is not the fastest. Sorry :(
          *
          * It is currently necessary, though, because the array-based zstdni methods have a very long JNI critical section, and this can
          * lead to OOM-crashes when using G1GC before JVM-22 (until 22, GC is effectively disabled during crit sections; afterwards, only
          * specific regions are pinned).
          *
          * The upstream code is
          * https://github.com/luben/zstd-jni/blob/9b39b598313f639c817469cb4de500f767cec453/src/main/native/jni_fast_zstd.c#L488
          *
          * We may consider submitting a patch upstream that allocates a temp array and only holds the critical section during a memcopy
          *
          * Same issue holds for decompress.
          *
          * The result comes ready-to-read, i.e. is flipped/rewound by the zstd compress function
          */
        val buf = ByteBuffer.allocateDirect(bytes.length)
        buf.put(bytes)
        buf.flip()
        ctx.compress(buf)
      } finally {
        this.synchronized {
          if (this.closed) ctx.close() else compressCtxs.append(ctx)
        }
      }
    }

    def decompress(bytes: ByteBuffer, len: Int): ByteBuffer =
      ZstdWrapper.apply {
        val ctx0 = this.synchronized {
          decompressCtxs.removeLastOption()
        }
        val ctx = ctx0.getOrElse { new ZstdDecompressCtx }
        try {
          ctx.decompress(bytes, len).order(ByteOrder.LITTLE_ENDIAN)
        } finally {
          this.synchronized {
            if (this.closed) ctx.close() else decompressCtxs.append(ctx)
          }
        }
      }

    override def close(): Unit = this.synchronized {
      compressCtxs.foreach { _.close() }; compressCtxs.clear; decompressCtxs.foreach { _.close() }; decompressCtxs.clear; this.closed = true
    }
  }

  /** zstd-jni ships system libraries that are being unpacked, loaded and executed from the system tmp directory. If that fails we get a
    * rather obscure error message - this wrapper adds a check if the tmp dir is executable, and enhances the error message if the zstd
    * invocation fails.
    *
    * This is where zstd-jni loads the system library:
    * https://github.com/luben/zstd-jni/blob/9b08f1d0cdcf3b12b7a307cbba3d9f195149250b/src/main/java/com/github/luben/zstd/util/Native.java#L71
    */
  def apply[A](fun: => A): A = {
    probeTmpMountOptions()

    try {
      fun
    } catch {
      case e =>
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
        if (mounts.asScala.exists { mountInfoLine => mountInfoLine.contains(s" $tmpDirPath ") && mountInfoLine.contains("noexec") })
          logger.warn(warnMessage)
      }
    }
    // we're just probing here to warn the user and give some hints about fixing the situation
    // it's fairly brittle as well, so if this fails we won't bother
  }

  class JniInvocationException(message: String, cause: Option[Throwable]) extends RuntimeException(message, cause.orNull)
}
