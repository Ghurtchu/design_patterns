package creational_design_patterns.abstract_factory

import creational_design_patterns.factory_method.CodeExample.{DatabaseClient, SimpleConnection, SimpleMySQLConnection, SimplePostgreSQLConnection}

object CodeExample extends scala.App {

  trait DatabaseConnectorFactory {
    def connect(): SimpleConnection
  }

  class MySQLFactory extends DatabaseConnectorFactory {
    override def connect(): SimpleConnection = new SimpleMySQLConnection
  }

  class PostreSQLFactory extends DatabaseConnectorFactory {
    override def connect(): SimpleConnection = new SimplePostgreSQLConnection
  }

  class DatabaseClient(connectorFactory: DatabaseConnectorFactory) {
    def executeQuery(query: String): Unit = {
      val connection = connectorFactory.connect()
      connection executeQuery query
    }
  }

  val mysqlClient = new DatabaseClient(new MySQLFactory)
  mysqlClient.executeQuery("SELECT * FROM users")
}
