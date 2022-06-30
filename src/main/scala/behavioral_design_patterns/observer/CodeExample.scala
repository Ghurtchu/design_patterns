package behavioral_design_patterns.observer

import scala.collection.mutable.ListBuffer

object CodeExample extends scala.App {

  trait Observer[T] {
    def handleUpdate(subject: T): Unit
  }

  trait Observable[T] { this: T =>

    private val observers = ListBuffer[Observer[T]]()

    def addObserver(observer: Observer[T]): Unit = {
      observers.+=:(observer)
    }

    def notifyObservers(): Unit = {
      observers.foreach(_.handleUpdate(this))
    }
  }

  case class User(name: String) extends Observer[Post] {
    override def handleUpdate(subject: Post): Unit = {
      System.out.println(s"Hey, I'm ${name}. The post got some new comments ${subject.comments}")
    }
  }

  case class Comment(user: User, text: String)

  case class Post(user: User, text: String) extends Observable[Post] {
    val comments = ListBuffer[Comment]()

    def addComment(comment: Comment): Unit = {
      comments.+=:(comment)
      notifyObservers()
    }
  }

  val userIvan = User("Ivan")
  val userMaria = User("Maria")
  val userJohn = User("John")

  val post = Post(userIvan, "This is a post about the observerdesign pattern")
  post.addComment(Comment(userIvan, "I hope you like the post!"))
  post.addObserver(userJohn)
  post.addObserver(userMaria)

  
}
