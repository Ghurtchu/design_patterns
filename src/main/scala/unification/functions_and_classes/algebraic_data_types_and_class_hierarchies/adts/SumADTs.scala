package unification.functions_and_classes.algebraic_data_types_and_class_hierarchies.adts

object SumADTs extends scala.App {

  // one general definition of ADT
  sealed trait Month

  // 12 finite specific representations of general ADT
  case object January extends Month
  case object February extends Month
  case object March extends Month
  case object April extends Month
  case object May extends Month
  case object June extends Month
  case object July extends Month
  case object August extends Month
  case object September extends Month
  case object October extends Month
  case object November extends Month
  case object December extends Month

  object Month {
    def apply(num: Int): Option[Month] = num match {
      case 1  => Some(January)
      case 2  => Some(February)
      case 3  => Some(March)
      case 4  => Some(April)
      case 5  => Some(May)
      case 6  => Some(June)
      case 7  => Some(July)
      case 8  => Some(August)
      case 9  => Some(September)
      case 10 => Some(October)
      case 11 => Some(November)
      case 12 => Some(December)
    }
  }

  assert(Month(5).contains(May))

}
