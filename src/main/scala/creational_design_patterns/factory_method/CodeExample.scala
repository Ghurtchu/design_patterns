package creational_design_patterns.factory_method

object CodeExample extends scala.App {

  trait SimpleConnection {
    def getName: String
    def executeQuery(query: String): Unit
  }

  class SimpleMySQLConnection extends SimpleConnection {
    override def getName: String = "connect to mysql server"
    override def executeQuery(query: String): Unit = println(s"executing query $query in MySQL")
  }

  class SimplePostgreSQLConnection extends SimpleConnection {
    override def getName: String = "connect to postgresql server"
    override def executeQuery(query: String): Unit = println(s"executing query $query in PostgreSQL")
  }

  abstract class DatabaseClient {
    def executeQuery(query: String): Unit = {
      val connection = connect()
      connection executeQuery query
    }

    // the return type is the base type which will be specific in runtime env
    protected def connect(): SimpleConnection
  }


  class MySQLClient extends DatabaseClient {
    override protected def connect(): SimpleConnection = new SimpleMySQLConnection
  }

  class PostgreSQLClient extends DatabaseClient {
    override protected def connect(): SimpleConnection = new SimplePostgreSQLConnection
  }

  val client = new MySQLClient

  client executeQuery "SELECT * FROM users"
  client executeQuery "SELECT * FROM employees"

}
