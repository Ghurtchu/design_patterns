package creational_design_patterns.builder

object VersionWithCaseClass extends scala.App {

  case class Person(
                   firstName: String = "",
                   lastName: String  = "",
                   age: Int          = 0
                   )

  // do not specify last name, it will stay as empty string
  val me = Person(
    firstName = "Nika",
    age = 23
  )

  // without first and last names
  val someone = Person(
    age = 5
  )

  println(me)
  println(someone)

  println(me.lastName == "")
  println(someone.firstName == "")
  println(someone.lastName == "")

}
