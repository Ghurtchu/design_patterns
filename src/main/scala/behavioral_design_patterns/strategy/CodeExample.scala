package behavioral_design_patterns.strategy

object CodeExample extends scala.App {

  case class Person(name: String, age: Int, address: String)

  trait Parser[T] {
    def parse(file: String): List[T]
  }

  object Parser {
    def apply(fileName: String): Parser[Person] = fileName match {
      case f if f.endsWith(".json") => new JsonParser
      case f if f.endsWith(".csv")  => new CSVParser
      case _                        => NullParser
    }
  }

  class CSVParser extends Parser[Person] {
    override def parse(file: String): List[Person] = {
      // implementation does not matter
      List(Person("nika", 12, "address"))
    }
  }

  class JsonParser extends Parser[Person] {
    override def parse(file: String): List[Person] = {
      // impl does not matter
      List(Person("nika", 44, "ad"))
    }
  }

  object NullParser extends Parser[Person] {
    override def parse(file: String): List[Person] = List()
  }

  class PersonApp[T](parser: Parser[T]) {
    def write(file: String): Unit = {
      println(s"Got the following data ${parser.parse(file)}")
    }
  }

  val app = new PersonApp[Person](Parser("file.json"))
  app.write("file.json")

}
