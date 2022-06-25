package abstract_and_self_types.self_types

object UsingSelfTypes extends scala.App {

  trait Persister[T] { self: Database[T] =>
    def persist(data: T): Unit = {
      println("Calling persist")
      self save data
    }
  }

  trait Database[T] {
    def save(data: T): Unit
  }

  import scala.collection.mutable

  trait MemoryDatabase[T] extends Database[T] {
    val db: mutable.ArrayBuffer[T] = mutable.ArrayBuffer.empty

    override def save(data: T): Unit =  {
      println("Saving to in memory db.")
      db :+ data
    }
  }

  trait FileDatabase[T] extends Database[T] {
    override def save(data: T): Unit = println("saving data to a file.")
  }

  class FilePersister[T] extends Persister[T] with FileDatabase[T]

  class MemoryPersister[T] extends Persister[T] with MemoryDatabase[T]

  class AnonymousPersister[T] extends Persister[T] with Database[T] {
    override def save(data: T): Unit = {
      println("saving somewhere else..")
    }
  }

  val persisters: List[Persister[String]] = List(
    new FilePersister[String],
    new MemoryPersister[String],
    new AnonymousPersister[String]
  )

  persisters.foreach(_.persist("data"))

}
