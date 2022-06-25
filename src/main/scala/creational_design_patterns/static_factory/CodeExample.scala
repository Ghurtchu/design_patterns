package creational_design_patterns.static_factory

object CodeExample extends scala.App {

  sealed trait Animal

  class Bird   extends Animal
  class Mammal extends Animal
  class Fish   extends Animal

  object Animal {
    // alternative would have been to return Option[Animal] with Some(animal) and None
    def apply(animal: String): Animal = animal.toLowerCase match {
      case "bird"   => new Bird
      case "mammal" => new Mammal
      case "fish"   => new Fish
      case _        => throw new RuntimeException(s"Unkown animal $animal")
    }
  }




}
