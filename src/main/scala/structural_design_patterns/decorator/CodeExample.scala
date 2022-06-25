package structural_design_patterns.decorator

import java.io.{BufferedInputStream, BufferedReader, InputStreamReader}
import java.nio.charset.Charset
import java.util.Base64
import scala.jdk.CollectionConverters.IteratorHasAsScala

object CodeExample extends scala.App {

  trait InputReader {
    def readLines(): Stream[String]
  }

  class AdvancedInputReader(reader: BufferedReader) extends InputReader {
    override def readLines(): Stream[String] = reader.lines().iterator().asScala.toStream
  }

  // we have demonstrated the decorator design pattern using an intermediate abstract class
  // that all decorators extend. We could have achieved this design pattern without the
  // intermediate class and by just directly extending and wrapping InputReader.
  // This implementation however adds a bit more structure to our code

  abstract class InputReaderDecorator(inputReader: InputReader) extends InputReader {
    override def readLines(): Stream[String] = inputReader.readLines()
  }

  class CapitalizedInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader) {
    override def readLines(): Stream[String] = super.readLines().map(_.toUpperCase)
  }

  class Base64EncoderInputReader(inputReader: InputReader) extends InputReaderDecorator(inputReader) {
    override def readLines(): Stream[String] = super.readLines().map(line =>
      Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8"))))
  }
//
//  val reader = new CapitalizedInputReader(new AdvancedInputReader(new BufferedInputStream(null)))
//  reader.readLines().foreach(println)

}
