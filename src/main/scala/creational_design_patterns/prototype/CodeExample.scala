package creational_design_patterns.prototype

object CodeExample extends scala.App {

  // case classes have copy methods for all scenarios
  case class Cell(dna: String, proteins: List[String])

  val initialCell = Cell("abcd", List("pr1", "pr2", "pr3"))

  val copy1 = initialCell.copy()

  // add "efg" to existing dna
  val copy2 = initialCell.copy(dna = initialCell.dna concat "efg")

  // turns proteins into an empty list
  val copy3 = initialCell.copy(proteins = List.empty)

  println(initialCell)
  println(copy1)
  println(copy2)
  println(copy3)

}
