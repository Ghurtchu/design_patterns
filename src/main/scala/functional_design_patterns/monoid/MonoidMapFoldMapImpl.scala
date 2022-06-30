package functional_design_patterns.monoid

object MonoidMapFoldMapImpl extends scala.App {

  trait Monoid[A] {
    def apply(a1: A, a2: A): A
    def zero: A
  }

  trait Map[A, B] {
    def map: A => B
    def apply(a: A): B = map(a)
  }

  object Map {
    def apply[A, B](implicit map: Map[A, B]): Map[A, B] = map
  }

  trait FoldMap[A, B] {
    def list: List[A]
    def map: Map[A, B]
    def apply()(implicit monoid: Monoid[B]): B = list.foldLeft(monoid.zero)((a, b) => monoid(a, map(b)))
  }

  implicit val charToInt: Map[Char, Int] = new Map[Char, Int] {
    override def map: Char => Int = _.toInt
  }

  implicit val intAdder: Monoid[Int] = new Monoid[Int] {
    override def apply(a1: Int, a2: Int): Int = a1 + a2
    override def zero: Int = 0
  }

  implicit val data: List[Char] = List('a', 'b', 'c', 'd', 'e')

  val foldMap = new FoldMap[Char, Int] {
    override def list: List[Char] = implicitly[List[Char]]
    override def map: Map[Char, Int] = implicitly[Map[Char, Int]]
  }

  val res = foldMap()

  println(res)

  assert(res == 495)
}
