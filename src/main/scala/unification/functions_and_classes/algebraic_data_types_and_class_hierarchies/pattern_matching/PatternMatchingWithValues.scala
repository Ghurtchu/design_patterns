package unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.pattern_matching

import unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.adts.SumADTs.{April, August, December, February, January, July, June, March, May, Month, November, October, September}

object PatternMatchingWithValues extends scala.App {

  object MonthToIntConverter {
    def toInt(month: Month): Int = month match {
      case January   => 1
      case February  => 2
      case March     => 3
      case April     => 4
      case May       => 5
      case June      => 6
      case July      => 7
      case August    => 8
      case September => 9
      case October   => 10
      case November  => 11
      case December  => 12
    }
  }

}
