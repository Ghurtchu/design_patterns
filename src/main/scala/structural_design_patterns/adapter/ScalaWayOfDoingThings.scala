package structural_design_patterns.adapter

import structural_design_patterns.adapter.CodeExampleWithInheritance.{Log, LogType, Logger}

object ScalaWayOfDoingThings extends scala.App {

  // since scala is a VERY RICH language we can use one of its features and
  // do implicit conversions from Logger to any type
  implicit class LoggerConverter(logger: Logger) extends Log {
    override def info(message: String): Unit = logger.log(message)(LogType.INFO)
    override def debug(message: String): Unit = logger.log(message)(LogType.DEBUG)
    override def warning(message: String): Unit = logger.log(message)(LogType.WARNING)
    override def error(message: String): Unit = logger.log(message)(LogType.ERROR)
  }

  // without extending Log interface
  //  implicit class LoggerImplicit(logger: Logger) {
  //    def info(message: String): Unit = logger.log(message)(LogType.INFO)
  //    def debug(message: String): Unit = logger.log(message)(LogType.DEBUG)
  //    def warning(message: String): Unit = logger.log(message)(LogType.WARNING)
  //    def error(message: String): Unit = logger.log(message)(LogType.ERROR)
  //  }

  // in scala 3 we can use extension methods baby

  val logger = new Logger

  logger.info("info")
  logger.debug("debug")
  logger.warning("warning")
  logger.error("error")

}
