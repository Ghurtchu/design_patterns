package functional_design_patterns.monoid

object MonoidsAndFoldableCollections extends scala.App {

  import CodeExample._

  val words: List[String] = List(
    "I",
    "Love",
    "Scala"
  )

  val numbers: List[Int] = List(1, 2, 3, 4, 5)

  assert(words.foldLeft(stringConcatenationMonoid.zero)(stringConcatenationMonoid.op) == "ILoveScala")
  assert(numbers.foldLeft(intAdditionMonoid.zero)(intAdditionMonoid.op) == 15)
  assert(numbers.foldLeft(intMultiplicationMonoid.zero)(intMultiplicationMonoid.op) == 120)

  def fold[A](list: List[A])(implicit monoid: Monoid[A]): A = list.foldLeft(monoid.zero)(monoid.op)

  {
    import CodeExample.stringConcatenationMonoid
    println(fold(List("1", "2", "3")))
  }

  def foldMap[A, B](list: List[A], f: A => B)(implicit monoid: Monoid[B]): B = list.foldLeft(monoid.zero)((a, b) => monoid.op(a, f(b)))

  {
    import CodeExample.stringConcatenationMonoid
    val intToString: Int => String = _.toString
    val res = foldMap(List(11, 22, 33), intToString)
    println(res) // 112233 as a string
  }

}
