package abstract_and_self_types.self_types

import abstract_and_self_types.self_types.UsingSelfTypes.{Database, FileDatabase, MemoryDatabase}

object MultipleComponents extends scala.App {

  trait History {
    def add(): Unit = {
      println("Action added to history.")
    }
  }

  trait Persister[T] { self: Database[T] with History =>
    def persist(data: T): Unit = {
      println("Calling persist.")
      self save data
      self.add()
    }
  }

  class FilePersister[T]   extends Persister[T] with FileDatabase[T]   with History
  class MemoryPersister[T] extends Persister[T] with MemoryDatabase[T] with History




}
