package behavioral_design_patterns.null_object

import scala.language.implicitConversions

object CodeExample extends scala.App {

  // The purpose of the null object design pattern is to define an actual object
  // that represents the null value and has neutral behavior.

  object Printer {
    def print(message: Message): Unit = println(message.prettify)
  }

  sealed trait Message {
    def prettify: String
  }

  case class Text(value: String) extends Message {
    override def prettify: String = s"[$value]"
  }

  case object NullMessage extends Message {
    override def prettify: String = "[]"
  }

  val generateMessage: Int => Message = _ =>
    if (scala.util.Random.nextInt(10) > 5) Text(scala.util.Random.nextString(scala.util.Random.nextInt(10)))
    else NullMessage

  val messages: List[Message] = List.tabulate(25)(generateMessage)

  implicit class StringPrintSyntax(str: String) {
    def show(): Unit = println(str)
  }

  messages.foreach(_.prettify.show())



}
