package structural_design_patterns.facade

import java.util.Base64

object CodeExample extends scala.App {

  trait DataDownloader {
    def download(url: String): Array[Byte] = {
      println(s"Downloading from: $url")
      Thread.sleep(2000) // imitate downloading
      // {
      // "name": "Ivan",
      // "age": 26
      // }
      // the string below is the Base64 encoded Json above.
      "ew0KICAgICJuYW1lIjogIkl2YW4iLA0KICAgICJhZ2UiOiAyNg0KfQ==".getBytes
    }
  }

  trait DataDecoder {
    def decode(data: Array[Byte]): String = new String(Base64.getDecoder.decode(data), "UTF-8")
  }

  trait DataDeserializer {
    def parse[T](data: String): T = ??? // from json to class instance
  }

  case class Person(name: String, age: Int)

  // facade class
  class DataReader extends DataDownloader with DataDecoder with DataDeserializer {
    def readPerson(url: String): Person = {
      val data = download(url)
      val json = decode(data)

      parse[Person](json)
    }
  }

  val reader = new DataReader
  reader.readPerson("some url")
}
