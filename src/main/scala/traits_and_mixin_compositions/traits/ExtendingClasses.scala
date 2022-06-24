package traits_and_mixin_compositions.traits

object ExtendingClasses extends scala.App {

  abstract class Connector {
    def connect(): Unit

    def close(): Unit
  }

  trait ConnectorWithHelper extends Connector {
    def findDriver(): Unit = println("Find driver called.")
  }

  class PgSqlConnector extends ConnectorWithHelper {
    override def connect(): Unit = println("Connected")

    override def close(): Unit = println("Closed")
  }


}
