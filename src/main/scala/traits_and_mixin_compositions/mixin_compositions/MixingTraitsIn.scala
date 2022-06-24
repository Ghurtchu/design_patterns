package traits_and_mixin_compositions.mixin_compositions

object MixingTraitsIn extends scala.App {

  trait Ear
  case object Ear extends Ear

  trait Eye
  case object Eye extends Eye

  trait HasEars {
    def ears: (Ear, Ear)
  }

  trait HasEyes {
    def eyes: (Eye, Eye)
  }

  case class Person(name: String) extends HasEars with HasEyes {
    override def eyes: (Eye, Eye) = (Eye, Eye)
    override def ears: (Ear, Ear) = (Ear, Ear)
  }

}
