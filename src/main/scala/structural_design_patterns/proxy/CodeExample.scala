package structural_design_patterns.proxy

import java.io.{BufferedReader, InputStreamReader}
import scala.jdk.CollectionConverters.IteratorHasAsScala

object CodeExample extends scala.App {

  trait FileReader {
    def readFileContents: String
  }

  class FileReaderLive(fileName: String) extends FileReader {
    val contents = {
      val stream = this.getClass.getResourceAsStream(fileName)
      val reader = new BufferedReader(new InputStreamReader(stream))
      try {
        reader.lines().iterator().asScala.mkString(System.getProperty("line.separator"))
      } finally {
        reader.close()
        stream.close()
      }

    }

    override def readFileContents: String = contents

  }

  class FileReaderProxy(filename: String) extends FileReader {
    private var fileReader: FileReaderLive = null
    override def readFileContents: String = {
      if (fileReader == null) {
        fileReader = new FileReaderLive(filename)
      }
      fileReader.readFileContents
    }
  }

  /**
   * The proxy design pattern is good when we want to delegate some expensive operations to
   * other classes, do operations lazily, and thus make our applications more efficient.
   * */

}
