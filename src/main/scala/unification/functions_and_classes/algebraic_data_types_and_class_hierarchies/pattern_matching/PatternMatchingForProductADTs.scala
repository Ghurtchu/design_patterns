package unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.pattern_matching

import unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.adts.HybridADTs.{Circle, Point, Rectangle, Shape}

object PatternMatchingForProductADTs extends scala.App {

  object AreaCalculator {
    def area(shape: Shape): Double = shape match {
      case Circle(Point(x, y), radius) => Math.PI * Math.pow(radius, 2)
      case Rectangle(_, h, w)          => h * w
    }
  }

  val circle = Circle(Point(1, 2), 2.5)
  val rect   = Rectangle(Point(1, 5), 1, 2)

  import AreaCalculator._

  println(area(circle))
  println(area(rect))

}
