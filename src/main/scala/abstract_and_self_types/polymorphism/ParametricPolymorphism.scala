package abstract_and_self_types.polymorphism

import abstract_and_self_types.polymorphism.ParametricPolymorphism.adhocpolymorphism.Adder.sum
import abstract_and_self_types.polymorphism.ParametricPolymorphism.adhocpolymorphism.AdderSyntax

object ParametricPolymorphism extends scala.App {

  object adhocpolymorphism {

    trait Adder[T] {
      def sum(a: T, b: T): T
    }

    object Adder {
      // [T: Adder] implicit conversion from T to Adder[T]
      def sum[T: Adder](a: T, b: T): T = implicitly[Adder[T]].sum(a, b)

      def sumAlternative[T](a: T, b: T)(implicit adder: Adder[T]): T = adder.sum(a, b)
    }

    implicit class AdderSyntax[T: Adder](t: T) {
      def ~>(other: T): T = implicitly[Adder[T]].sum(t, other)
    }

    implicit object StringAdder extends Adder[String] {
      override def sum(a: String, b: String): String = a concat b
    }

    implicit object IntAdder extends Adder[Int] {
      override def sum(a: Int, b: Int): Int = a + b
    }

  }

  import adhocpolymorphism._

  println(sum("abc", "dfe"))
  println("abc" ~> "dfe")
  println {
    1 ~> 2
  }
  
}
