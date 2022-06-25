package structural_design_patterns.decorator

import structural_design_patterns.decorator.CodeExample.{AdvancedInputReader, InputReader}

import java.nio.charset.Charset
import java.util.Base64

object ScalaWayOfDoingThings extends scala.App {

  // stackable traits baby!

  trait CapitalizedInputReaderTrait extends InputReader {
    abstract override def readLines(): Stream[String] =
      super.readLines().map(_.toUpperCase)
  }

  trait Base64EncoderInputReaderTrait extends InputReader {
    abstract override def readLines(): Stream[String] =
      super.readLines().map(line =>
        Base64.getEncoder.encodeToString(line.getBytes(Charset.forName("UTF-8"))))
  }

  val reader = new AdvancedInputReader(null) with CapitalizedInputReaderTrait with Base64EncoderInputReaderTrait

  reader.readLines().foreach(println)

}
