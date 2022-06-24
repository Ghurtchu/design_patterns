package traits_and_mixin_compositions.mixin_compositions.clashing_traits

object SameSignaturesAndReturnTypesMixins extends scala.App {

  trait A {
    def hello(): String = "Hello, I am trait A"
  }

  trait B {
    def hello(): String = "Hello, I am trait B"
  }

  class Runner extends A with B {
    // you can choose the parent trait implementation compile time
    override def hello(): String = super[B].hello()
  }

  println((new Runner).hello())

}
