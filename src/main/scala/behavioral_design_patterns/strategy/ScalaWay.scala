package behavioral_design_patterns.strategy

import behavioral_design_patterns.strategy.CodeExample.{CSVParser, JsonParser, NullParser, Person}

object ScalaWay extends scala.App {

  class App[T](strategy: String => List[T]) {
    def write(file: String): Unit = {
      println(s"Got the following data ${strategy(file)}")
    }
  }

  object StrategyFactory {
    def apply[T](fileName: String): String => List[T] = fileName match {
      case f if f.endsWith(".json") => (new JsonParser).parse
      case f if f.endsWith(".csv")  => (new CSVParser).parse
      case _                        => (new NullParser).parse
    }
  }

  trait Parser[T] {
    def parse(file: String): List[T]
  }

  class CSVParser[T] extends Parser[T] {
    override def parse(file: String): List[T] = List()
  }

  class JsonParser[T] extends Parser[T] {
    override def parse(file: String): List[T] = List()
  }

  class NullParser[T] extends Parser[T] {
    override def parse(file: String): List[T] = List()
  }

  val app = new App[Person](StrategyFactory("file.json"))

  app.write("file.json")
  /**
   * The strategy design pattern helps us when we want to be able to change implementations at
   * runtime. Also, as we can see, the implementations live separately from the code that uses
   * them, so it's quite easy to add new ones without the risk of introducing bugs in other parts
   * of our system.
   * */
}
