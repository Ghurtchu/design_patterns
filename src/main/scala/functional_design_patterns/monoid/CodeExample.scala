package functional_design_patterns.monoid

object CodeExample {

  // A monoid is a type with an associative binary operation over it, which also has an identity element

  trait Monoid[T] {
    def op(t1: T, t2: T): T
    def zero: T
  }

  implicit val intAdditionMonoid: Monoid[Int] = new Monoid[Int] {
    override def op(t1: Int, t2: Int): Int = t1 + t2
    override def zero: Int = 0
  }

  implicit val intMultiplicationMonoid: Monoid[Int] = new Monoid[Int] {
    override def op(t1: Int, t2: Int): Int = t1 * t2
    override def zero: Int = 1
  }

  implicit val stringConcatenationMonoid: Monoid[String] = new Monoid[String] {
    override def op(t1: String, t2: String): String = t1 concat t2
    override def zero: String = ""
  }

  implicit class MonoidSyntax[T](t1: T) {
    def ~>(t2: T)(implicit monoid: Monoid[T]): T = monoid.op(t1, t2)
  }


}
