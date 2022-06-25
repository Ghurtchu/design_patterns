package creational_design_patterns.lazy_initialization

import java.util.Properties

object CodeExample extends scala.App {

  object CircleUtils {

    val basicPi = 3.14

    lazy val precisePi: Double = {
      println("Reading properties for the precise PI.")
//      val props = new Properties()
//      props.load(getClass.getResourceAsStream("pi.properties"))
//      props.getProperty("pi.high").toDouble
      3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253
    }

    def area(radius: Double, isPrecise: Boolean = false): Double = {
      val pi: Double = if (isPrecise) precisePi else basicPi

      pi * Math.pow(radius, 2)
    }

  }

  import CircleUtils._

  println(area(2, isPrecise = true))
  println(area(2, isPrecise = true))

}
