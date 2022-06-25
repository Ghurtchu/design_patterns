package creational_design_patterns.builder

// java-like version
object VersionWithMutableState extends scala.App {

  class Person private (builder: Person.PersonBuilder) {
    val firstName: String = builder.firstName
    val lastName: String  = builder.lastName
    val age: Int          = builder.age

    override def toString: String =
      s"""
         |Person(firstName=$firstName, lastName=$lastName, age=$age)
         |""".stripMargin
  }

  object Person {

    class PersonBuilder {
      var firstName: String = ""
      var lastName: String  = ""
      var age: Int          = 0

      def withFirstName(firstName: String): PersonBuilder = {
        this.firstName = firstName
        this
      }

      def withLastName(lastName: String): PersonBuilder = {
        this.lastName = lastName
        this
      }

      def withAge(age: Int): PersonBuilder = {
        this.age = age
        this
      }

      def build: Person = new Person(this)

    }

  }

  val albus: Person = new Person.PersonBuilder()
    .withAge(100)
    .withFirstName("Albus")
    .withLastName("Dumbledore")
    .build

  val me: Person = new Person.PersonBuilder()
    .withFirstName("Unknown")
    .build

  println(albus)

  println(me)


}
