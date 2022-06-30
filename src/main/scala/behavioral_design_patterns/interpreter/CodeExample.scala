package behavioral_design_patterns.interpreter

import java.util.StringTokenizer
import scala.collection.mutable
import scala.jdk.CollectionConverters.EnumerationHasAsScala

object CodeExample extends scala.App {

  trait Expression {
    def interpret(): Int
  }

  class Number(n: Int) extends Expression {
    override def interpret(): Int = n
  }

  class Add(right: Expression, left: Expression) extends Expression {
    override def interpret(): Int = left.interpret() + right.interpret()
  }
  class Subtract(right: Expression, left: Expression) extends Expression {
    override def interpret(): Int = left.interpret() - right.interpret()
  }
  class Multiply(right: Expression, left: Expression) extends Expression {
    override def interpret(): Int = left.interpret() * right.interpret()
  }

  object Expression {
    def apply(operator: String, left: => Expression, right: => Expression):
    Option[Expression] =
      operator match {
        case "+" => Some(new Add(right, left))
        case "-" => Some(new Subtract(right, left))
        case "*" => Some(new Multiply(right, left))
        case i if i.matches("\\d+") => Some(new Number(i.toInt))
        case _ => None
      }
  }

  class RPNParser {
    def parse(expression: String): Expression = {
      val tokenizer = new StringTokenizer(expression)
      tokenizer.asScala.foldLeft(mutable.Stack[Expression]()) {
        case (result, token) =>
          val item = Expression(token.toString, result.pop(), result.pop())
          item.foreach(result.push)
          result
      }.pop()
    }
  }

  val expr1 = "1 2 + 3 * 9 10 + -" // (1 + 2) * 3 - (9 + 10) = -10
  val expr2 = "1 2 3 4 5 * * - +" // 1 + 2 - 3 * 4 * 5 = -57
  val expr3 = "12 -" // invalid
  val parser = new RPNParser

  println(parser.parse(expr1).interpret())
  println(parser.parse(expr2).interpret())
  println {
    try {
      parser.parse(expr3).interpret()
    } catch {
      case e: Exception => "unit"
    }
  }
}
