import java.io.File
import java.nio.file.Files
import java.security.{DigestInputStream, MessageDigest}

object FileUtils {

  def md5(roots: File*): String = {
    val md = MessageDigest.getInstance("MD5")
    roots.foreach { root =>
      Files.walk(root.toPath).filter(!_.toFile.isDirectory).forEach { path =>
        val dis = new DigestInputStream(Files.newInputStream(path), md)
        // fully consume the inputstream
        while (dis.available > 0) {
          dis.read
        }
        dis.close
      }
    }
    md.digest.map(b => String.format("%02x", Byte.box(b))).mkString
  }

}
