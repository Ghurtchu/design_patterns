package unification.functions_and_classes.functions_as_classes

object FunctionsWithoutSyntactigSugar extends scala.App {

  object Summator extends Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(Summator.apply(1, 2)) // 3

  /**
   * As you can see from the examples, unifying classes and functions leads to increased
   * expressivity and we can easily achieve various things such as callbacks, lazy parameter
   * evaluation, centralized exception handling, and others, and without writing extra code and
   * logic. Moreover, functions as classes mean that we can extend them to provide extra
   * functionality.
   * */

}
