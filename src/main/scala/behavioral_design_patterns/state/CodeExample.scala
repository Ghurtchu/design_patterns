package behavioral_design_patterns.state

import javax.print.attribute.standard.MediaPrintableArea

object CodeExample extends scala.App {

  // The purpose of the state design pattern is to allow us to choose a different
  // behavior of an object based on the object's internal state.

  trait State[T] {
    def press(context: T): Unit
  }

  class Playing extends State[MediaPlayer] {
    override def press(context: MediaPlayer): Unit = {
      println("pressing Resume button")
      context setState new Paused
    }
  }

  class Paused extends State[MediaPlayer] {
    override def press(context: MediaPlayer): Unit = {
      println("pressing Stop button")
      context setState new Playing
    }
  }

  case class MediaPlayer() {
    private var state: State[MediaPlayer] = new Paused
    def setState(st: State[MediaPlayer]): Unit = this.state = st
    def press(): Unit = state.press(this)
  }

  val mp = MediaPlayer()
  mp.press()
  mp.press()
  mp.press()
  mp.press()





}
