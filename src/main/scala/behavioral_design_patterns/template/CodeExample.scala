package behavioral_design_patterns.template

object CodeExample extends scala.App {

  // The purpose of the template method design pattern is to defer algorithm
  // steps to subclasses using template methods.

  case class Person(name: String, age: Int, address: String)

  abstract class DataFinder[A, B] {
    def find(f: A => Option[B]): Option[B] = {
      try {
        val data       = readData()
        val parsedData = parse(data)

        f(parsedData)
      } finally {
        cleanup()
      }
    }

    def readData(): Array[Byte]

    def parse(data: Array[Byte]): A

    def cleanup(): Unit

  }

  class JsonDataFinder extends DataFinder[List[Person], Person] {
    override def readData(): Array[Byte] = Array()

    override def parse(data: Array[Byte]): List[Person] = List()

    override def cleanup(): Unit = ()
  }

  class CSVDataFinder extends DataFinder[List[Person], Person] {
    override def readData(): Array[Byte] = Array()

    override def parse(data: Array[Byte]): List[Person] = List()

    override def cleanup(): Unit = ()
  }

}
