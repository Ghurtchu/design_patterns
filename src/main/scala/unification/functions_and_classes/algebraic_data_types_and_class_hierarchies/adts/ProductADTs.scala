package unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.adts

object ProductADTs extends scala.App {

  sealed case class RGB private (
                       red: Int,
                       green: Int,
                       blue: Int
                       )

  object RGB {
    def apply(red: Int, green: Int, blue: Int): RGB =
      new RGB(red, green, blue)
  }

}
