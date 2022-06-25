package abstract_and_self_types.generics

object Generics extends scala.App {

  // ad hoc polymorphism
  trait Adder {
    def sum[T](a: T, b: T)(implicit numeric: Numeric[T]): T = numeric.plus(a, b)
  }

  class Container[T](data: T) {
    def compare(other: T): Boolean= data.equals(other)
  }

  val adder = new Adder {}

  println(adder.sum(1, 2)) // ints
  println(adder.sum(10L, 20L)) // longs
  println(adder.sum(1.0, 2.0)) // doubles
  println(adder.sum(2.0f, 3.0f)) // floats

  val intContainer    = new Container[Int](5)
  val stringContainer = new Container[String]("Scala rocks")




}
