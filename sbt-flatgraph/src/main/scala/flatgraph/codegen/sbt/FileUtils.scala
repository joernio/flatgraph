package flatgraph.codegen.sbt

import java.io.File
import java.nio.file.Files
import java.security.{DigestInputStream, MessageDigest}
import scala.collection.JavaConverters._

object FileUtils {

  def listFilesRecursively(roots: File*): Seq[File] = {
    roots.flatMap { root =>
      Files.walk(root.toPath).iterator.asScala.map(_.toFile).filter(!_.isDirectory)
    }
  }

  def deleteRecursively(file: File): Unit = {
    if (file.isDirectory)
      file.listFiles.foreach(deleteRecursively)
    if (file.exists)
      file.delete()
  }

  def md5(root: File): String =
    md5(Seq(root))

  def md5(roots: Seq[File]): String = {
    val md = MessageDigest.getInstance("MD5")
    roots.filter(_.exists).foreach { root =>
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
