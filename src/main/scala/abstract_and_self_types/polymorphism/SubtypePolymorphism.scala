package abstract_and_self_types.polymorphism

object SubtypePolymorphism extends scala.App {

  abstract class Item {
    def pack: String
  }

  class Fruit extends Item {
    override def pack: String = "I'm a fruit and I'm packed in a bag."
  }

  class Drink extends Item {
    override def pack: String = "I'm a drink and I'm packed in a bottle."
  }

  val items: List[Item] = List (
    new Fruit(),
    new Fruit(),
    new Drink(),
    new Drink(),
  )

  items.foreach(item => println(item.pack))

}
