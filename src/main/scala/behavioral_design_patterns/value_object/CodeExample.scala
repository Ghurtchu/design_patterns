package behavioral_design_patterns.value_object

object CodeExample extends scala.App {

  // equals, hashCode and toString are already implemented
  case class Date(day: Int, month: String, year: Int)

  val thirdOfMarch      = Date(3, "MARCH", 2022)
  val fourthOfJuly      = Date(4, "JULY", 2022)
  val myBirthDate       = Date(22, "MAY", 1999)
  val twentySecondOfMay = Date(22, "MAY", 1999)

  println(twentySecondOfMay == myBirthDate)
  println(twentySecondOfMay)

  println(thirdOfMarch)

  class BadDate(day: Int, month: String, year: Int) // without equals, hashCode and toString
  // extra `new` keyword for instantiating it

}
