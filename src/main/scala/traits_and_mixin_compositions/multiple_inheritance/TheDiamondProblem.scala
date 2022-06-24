package traits_and_mixin_compositions.multiple_inheritance

object TheDiamondProblem extends scala.App {

  trait A {
    def hello(): String = "Hello from A"
  }

  trait B extends A {
    override def hello(): String = "Hello from B"
  }

  trait C extends A {
    override def hello(): String = "Hello from C"
  }

  trait D extends B with C {

  }

  val d = new D {}
  println(d.hello()) // it chose C implementation due to the line 17
  // because it was the last mix in written
  // this is achieved with the help of linearization

}
