package unification.functions_and_classes.modules_and_objects

object UsingModules extends scala.App {

  trait Tick {

    trait Ticker {
      def count: Int
      def tick(): Unit
    }

    def ticker: Ticker
  }

  trait TickLive extends Tick {
    class TickUserImpl extends Ticker {
      var curr = 0

      override def count: Int = curr
      override def tick(): Unit = curr = curr + 1
    }

    object ticker extends TickUserImpl
  }

  trait Alarm {

    trait Alarmer {
      def trigger(): Unit
    }

    def alarm: Alarmer
  }

  trait AlarmLive extends Alarm with Tick {

    class AlarmLiveImpl extends Alarmer {
      override def trigger(): Unit = {
        if (ticker.count % 10 == 0) {
          println("Alarm triggered")
        }
      }
    }

    object alarm extends AlarmLiveImpl
  }

}
