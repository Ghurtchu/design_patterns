package functional_design_patterns.functor

object CodeExample extends scala.App {

  trait Functor[F[_]] {
    def map[A, B](con: F[A])(f: A => B): F[B]
  }

  val listFunctor: Functor[List] = new Functor[List] {
    override def map[A, B](con: List[A])(f: A => B): List[B] = con.map(f)
  }

  val data = List(1, 2, 3, 4, 5)

  listFunctor.map(data)(_ + 1) // increment

}
