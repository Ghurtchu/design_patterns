package traits_and_mixin_compositions.traits

object ExtendingTraits extends scala.App {

  trait Ping {
    def ping(): Unit = print("ping ~>")
  }

  trait Pong {
    def pong(): Unit = print("<~ pong\n")
  }

  trait PingPong extends Ping with Pong {
    def pingPong(): Unit = {
      ping()
      pong()
    }
  }

  val pingPong = new PingPong {}

  while (true) {
    Thread.sleep(scala.util.Random.nextInt(1000))
    pingPong.pingPong()
  }

}
