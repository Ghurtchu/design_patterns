package structural_design_patterns.adapter

object CodeExampleWithInheritance extends scala.App {

  // this is the new Logger we want to be using
  // we can not change since it's third party library and thereby is static
  // The problem: it takes logType param but we just want to represent only 4 states and avoid giving log type every time
  // these states are: 1) info, 2) debug, 3) warning and 4) error
  // so our adapter should define the cooperation and let us only provide string message for API
  // Logger is not declared as `final` so we can directly extend it, otherwise we'd compose baby!
  class Logger {
    def log(message: String)(logType: LogType): Unit = {
      println(s"${logType.get} $message")
    }
  }

  sealed trait LogType {
    def get: String
  }

  object LogType {
    case object INFO    extends LogType {
      override def get: String = "[info]"
    }
    case object WARNING extends LogType {
      override def get: String = "[warning]"
    }
    case object ERROR   extends LogType {
      override def get: String = "[error]"
    }
    case object DEBUG   extends LogType {
      override def get: String = "[debug]"
    }
  }

  // our interface
  trait Log {
    def info(message: String): Unit
    def debug(message: String): Unit
    def warning(message: String): Unit
    def error(message: String): Unit
  }

  // inheritance
  // our logger implementation just delegates to new Logger
  class AppLogger extends Logger with Log {
    override def info(message: String): Unit = log(message)(LogType.INFO)
    override def warning(message: String): Unit = log(message)(LogType.WARNING)
    override def error(message: String): Unit = log(message)(LogType.ERROR)
    override def debug(message: String): Unit = log(message)(LogType.DEBUG)
  }

  val logger = new AppLogger

  logger.info("This is an info message.")
  logger.debug("Debug something here.")
  logger.error("Show an error message.")
  logger.warning("I am warning you!!!")
  logger.info("Bye :)")

}
