package behavioral_design_patterns.command

import scala.collection.mutable.ListBuffer

object CodeExample extends scala.App {

  // The purpose of the command design pattern is to encapsulate the
  // information needed to perform an action at a later stage and pass this
  // information to the object that will be running the actual code.

  case class Robot() {
    def cleanUp(): Unit = println("Cleaning up")
    def pourJuice(): Unit = println("Pouring juice")
    def makeSandwich(): Unit = println("Making a sandwich")
  }

  trait RobotCommand {
    def execute(): Unit
  }

  case class MakeSandwich(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.makeSandwich()
  }

  case class PourJuice(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.pourJuice()
  }

  case class CleanUp(robot: Robot) extends RobotCommand {
    override def execute(): Unit = robot.cleanUp()
  }

  class RobotController {
    val history = ListBuffer[RobotCommand]()

    def issueCommand(command: RobotCommand): Unit = {
      command +=: history
      command.execute()
    }

    def showHistory(): Unit = history.foreach(println)
  }

  val robot = Robot()
  val robotController = new RobotController

  robotController.issueCommand(MakeSandwich(robot))
  robotController.issueCommand(CleanUp(robot))

  robotController.showHistory()
}
