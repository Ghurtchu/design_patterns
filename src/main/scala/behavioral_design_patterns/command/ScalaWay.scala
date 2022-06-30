package behavioral_design_patterns.command

import behavioral_design_patterns.command.CodeExample.{CleanUp, MakeSandwich, PourJuice, Robot}

import scala.collection.mutable.ListBuffer

object ScalaWay extends scala.App {

  class RobotController {
    type Thunk = () => Unit
    val history: ListBuffer[Thunk] = ListBuffer.empty

    def issueCommand(command: => Unit): Unit = {
      command _ +=: history

      command
    }

    def showHistory(): Unit = history.foreach(println)
  }

  val robot = Robot()
  val robotController = new RobotController

  robotController.issueCommand(MakeSandwich(robot).execute())
  robotController.issueCommand(CleanUp(robot).execute())
  robotController.issueCommand(PourJuice(robot).execute())

  robotController.showHistory()

}
