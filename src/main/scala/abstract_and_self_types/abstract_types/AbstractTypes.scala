package abstract_and_self_types.abstract_types

object AbstractTypes extends scala.App {

  trait Container {
    type T
    val data: T

    def compare(other: Container): Boolean = data.equals(other.data)
  }

  class StringContainer(override val data: String) extends Container {
    type T = String
  }

  val s1 = new StringContainer("s1")
  val s2 = new StringContainer("s2")

  println(s1.compare(s2))


}
