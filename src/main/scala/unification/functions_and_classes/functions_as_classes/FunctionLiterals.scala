package unification.functions_and_classes.functions_as_classes

object FunctionLiterals extends scala.App {

  val sum = (a: Int, b: Int) => a + b
  val sumSyntacticSugar: (Int, Int) => Int = _ + _

  def runOperation(f: (Int, Int) => Int, a: Int, b: Int): Int = f(a, b)

  runOperation(_ + _, 5, 1) // sum = 6
  runOperation(_ * _, 2, 2) // multiply = 4
  
}
