package traits_and_mixin_compositions.traits

object TraitsAsInterfaces extends scala.App {

  // it's so called SAM interface with single abstract method
  trait Alarm {
    def trigger(): String
  }

  trait Notifier {
    val notificationMessage: String

    def printNotification(): Unit = println(notificationMessage)

    def clear(): Unit // abstract unimplemented method

  }

  // the val was overriden as well as clear() method
  class NotifierImpl(override val notificationMessage: String) extends Notifier {
    override def clear(): Unit = println("clearing the console...")
  }


}
