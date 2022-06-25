package structural_design_patterns.flyweight

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object CodeExample extends scala.App {

  sealed abstract class Color

  case object Red     extends Color
  case object Green   extends Color
  case object Blue    extends Color
  case object Yellow  extends Color
  case object Magenta extends Color

  class Circle(color: Color) {
    println(s"Creating a circle with $color color")

    override def toString: String = s"Circle($color)"
  }

  object Circle {
    import scala.collection.mutable

    val cache = mutable.Map.empty[Color, Circle]

    def apply(color: Color): Circle = cache.getOrElseUpdate(color, new Circle(color))

    def circlesCreated(): Int = cache.size
  }

  class Graphic {
    val items = ListBuffer.empty[(Int, Int, Double, Circle)]

    def addCircle(x: Int, y: Int, radius: Double, circle: Circle): Unit = {
      items += ((x, y, radius , circle))
    }

    def draw(): Unit = {
      items.foreach {
        case (x, y, radius, circle) => println(s"Drawing a cirlce at ($x, $y) with radius $radius")
      }
    }
  }

  val graphic = new Graphic

  graphic.addCircle(1, 1, 1.0, Circle(Green))
  graphic.addCircle(1, 1, 2.0, Circle(Blue))
  graphic.addCircle(2, 1, 3.0, Circle(Yellow))
  graphic.addCircle(2, 2, 4.0, Circle(Red))
  graphic.addCircle(2, 3, 4.0, Circle(Magenta))
  graphic.addCircle(2, 3, 4.0, Circle(Magenta)) // won't be printed, will be reused
  graphic.addCircle(3, 1, 5.0, Circle(Blue)) // won't be printed, will be reused

}
