package behavioral_design_patterns.value_object

object AlternativeImpl extends scala.App {

  // using tuples

  val mayFirst  = (1, "may", 2020)
  val janFirst  = (1, "jan", 1999)
  val mayFirst2 = (1, "may", 2020)

  println(mayFirst == mayFirst2)
  println(mayFirst)
}
