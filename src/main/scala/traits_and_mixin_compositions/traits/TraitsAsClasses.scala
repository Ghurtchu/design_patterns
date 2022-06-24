package traits_and_mixin_compositions.traits

object TraitsAsClasses {

  trait Beeper {
    // it's like java default method impl
    def beep(times: Int): Unit = 1 to times foreach (_ => println("beep"))
  }

  def main(args: Array[String]): Unit = {
    val TIMES: Int = 10
    val beeper: Beeper = new Beeper {} // anonymous instance
    beeper beep TIMES
  }
}
