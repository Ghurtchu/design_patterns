package structural_design_patterns.adapter

import structural_design_patterns.adapter.CodeExampleWithInheritance.{Log, LogType, Logger}

// sometimes the classes we want to build adapters for are `final`
// so they can not be extended, in that case we use composition.

object CodeExampleWithComposition extends scala.App {

  // composition
  class AppLogger extends Log {
    private final val logger = new Logger

    override def info(message: String): Unit = logger.log(message)(LogType.INFO)
    override def warning(message: String): Unit = logger.log(message)(LogType.WARNING)
    override def error(message: String): Unit = logger.log(message)(LogType.ERROR)
    override def debug(message: String): Unit = logger.log(message)(LogType.DEBUG)
  }

  val logger = new AppLogger

  logger.info("not boom")
  logger.warning("boom?!")
  logger.error("BOOOOOOOOOM")
  logger.debug("removing booms incrementally")
}
