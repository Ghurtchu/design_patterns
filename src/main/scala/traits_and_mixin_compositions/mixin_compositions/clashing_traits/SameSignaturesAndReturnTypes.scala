package traits_and_mixin_compositions.mixin_compositions.clashing_traits

object SameSignaturesAndReturnTypes extends scala.App {

  trait FormalGreeting {
    def hello: String
  }

  trait InformalGreeting {
    def hello: String
  }

  class Greeter extends FormalGreeting with InformalGreeting {
    override def hello: String = "Good morning, sir/madam!"
  }

  // mixes both formal `hello` and informal `hello` into one

  val greeter = new Greeter
  println(greeter.hello)
}
