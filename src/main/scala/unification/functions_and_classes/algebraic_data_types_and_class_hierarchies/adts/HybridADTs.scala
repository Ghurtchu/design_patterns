package unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.adts

object HybridADTs extends scala.App {

  case class Point(x: Int, y: Int)

  // SUM     because we have finite representations of Shape
  // PRODUCT because constructors take extra parameters which might also be complex data structures like Point
  sealed trait Shape

  final case class Circle(point: Point, radius: Double) extends Shape
  final case class Rectangle(point: Point, height: Double, width: Double) extends Shape


}
