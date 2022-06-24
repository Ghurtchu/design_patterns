package traits_and_mixin_compositions.mixin_compositions.composing

import traits_and_mixin_compositions.mixin_compositions.composing.ComposingSimpleTraits.Watch
import traits_and_mixin_compositions.traits.TraitsAsInterfaces.Notifier

object ComposingWithSelfTypes extends scala.App {

  // AlarmNotifier must be mixed in with Notifier
  // self type
  // any class that mixes with AlarmNotifier must also mix with Notifier, it's a contract for the compiler
  trait AlarmNotifier { self: Notifier =>
    def trigger(): String
  }

  val watch = new Watch("Alarm with notification", 1000L) with AlarmNotifier with Notifier {
    override val notificationMessage: String = "The notification."

    override def trigger(): String = "Alarm triggered."

    override def printNotification(): Unit = println(notificationMessage)

    override def clear(): Unit = println("Alarm cleared.")
  }


}
