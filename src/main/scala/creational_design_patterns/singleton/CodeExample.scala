package creational_design_patterns.singleton

import scala.collection.concurrent.TrieMap

object CodeExample extends scala.App {

  // done :D
  object StringUtils {
    def countNumberOfSpaces(text: String): Int =
      text.split("\\s+").length
  }

  val sentence = "Hello, I love Scala"
  println(s"The number of spaces in $sentence is ${StringUtils.countNumberOfSpaces(sentence)}")

  object AppRegistry {

    import scala.collection.mutable

    println("Registry initialization block called.")
    private val users: mutable.Map[String, String] = mutable.Map.empty

    def addUser(id: String, name: String): Unit = users.put(id, name)

    def isUserRegistered(id: String): Boolean = users contains id

    def getAllUserNames: List[String] = users.values.toList
  }

  println("Sleeping for 5 secs")
  Thread sleep 5000
  println("I woke up")

  AppRegistry.addUser("1", "Nika")
  AppRegistry.addUser("2", "John")
  AppRegistry.addUser("3", "Daniel")
  AppRegistry.addUser("4", "Shota")

  println(AppRegistry.getAllUserNames)

  println(AppRegistry.isUserRegistered("3"))


}
