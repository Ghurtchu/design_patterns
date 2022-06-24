package traits_and_mixin_compositions.mixin_compositions.clashing_traits

object SameSignaturesAndDifferentReturnTypesMixins extends scala.App {

  trait C {
    def value(a: Int): Int = a
  }

  trait D {
    def value(a: Int): String = a.toString
  }

  val c = new C {}
  val d = new D {}

  println(c.value(5))
  println(d.value(5))

}
