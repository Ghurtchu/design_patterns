package traits_and_mixin_compositions.mixin_compositions.composing

import traits_and_mixin_compositions.traits.TraitsAsInterfaces.{Alarm, Notifier}

object ComposingSimpleTraits extends scala.App {

  class Watch(brand: String, initialTime: Long) {
    def getTime: Long = System.currentTimeMillis() - initialTime
  }

  val expensiveWatch = new Watch("Expensive brand", 1000L) with Alarm with Notifier {
    override val notificationMessage: String = "Expensive brand notification message"
    override def trigger(): String = "expensive boom"
    override def clear(): Unit = println("clearing")
  }

  val cheapWatch = new Watch("Cheap brand", 1000L) with Alarm {
    override def trigger(): String = "cheap boom"
  }

  println(expensiveWatch.trigger())
  println(cheapWatch.trigger())


}
