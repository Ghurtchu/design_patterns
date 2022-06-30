package behavioral_design_patterns.chain_of_responsibility

object CodeExample extends scala.App {

  // The purpose of the chain of responsibility design pattern is to decouple the
  // sender of a request from its receiver by giving multiple objects the chance
  // to handle the request.

  case class Money(amount: Int)

  trait Dispenser {
    val amount: Int
    val next: Option[Dispenser]
    def dispense(money: Money): Unit = {
      if (money.amount >= amount) {
        val notes = money.amount / amount
        val left = money.amount % amount
        System.out.println(s"Dispensing $notes note/s of $amount.")
        if (left > 0) next.map(_.dispense(Money(left)))
      } else {
        next.foreach(_.dispense(money))
      }
    }
  }

  class Dispenser50(val next: Option[Dispenser]) extends Dispenser {
    override val amount = 50
  }
  class Dispenser20(val next: Option[Dispenser]) extends Dispenser {
    override val amount: Int = 20
  }
  class Dispenser10(val next: Option[Dispenser]) extends Dispenser {
    override val amount: Int = 10
  }
  class Dispenser5(val next: Option[Dispenser]) extends Dispenser {
    override val amount: Int = 5
  }

  class ATM {
    val dispenser: Dispenser = {
      val d1 = new Dispenser5(None)
      val d2 = new Dispenser10(Some(d1))
      val d3 = new Dispenser20(Some(d2))
      new Dispenser50(Some(d3))
    }
    def requestMoney(money: Money): Unit = {
      if (money.amount % 5 != 0) {
        System.err.println("The smallest nominal is 5 and we cannot satisfy your request.")
      } else {
        dispenser.dispense(money)
      }
    }
  }

  val atm = new ATM
  atm.requestMoney(Money(25))
  
}
