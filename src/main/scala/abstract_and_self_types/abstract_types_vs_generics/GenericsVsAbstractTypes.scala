package abstract_and_self_types.abstract_types_vs_generics

object GenericsVsAbstractTypes extends scala.App {

  object abstracttypes {
    abstract class PrintData
    abstract class PrintMaterial
    abstract class PrintMedia

    trait Printer {
      type Data     <: PrintData
      type Material <: PrintMaterial
      type Media    <: PrintMedia

      def print(data: Data, material: Material, media: Media): String =
        s"Printing $data with $material on $media"
    }

    case class Paper() extends PrintMedia
    case class Air() extends PrintMedia

    case class Text() extends PrintData
    case class Model() extends PrintData

    case class Toner() extends PrintMaterial
    case class Plastic() extends PrintMaterial

    class LaserPrinter extends Printer {
      type Data     = Text
      type Media    = Paper
      type Material = Toner
    }

    class ThreeDPrinter extends Printer {
      type Data     = Model
      type Media    = Air
      type Material = Plastic
    }

    val laser =  new LaserPrinter
    val threeD = new ThreeDPrinter

    println(laser.print(Text(), Toner(), Paper()))
    println(threeD.print(Model(), Plastic(), Air()))
  }

}
