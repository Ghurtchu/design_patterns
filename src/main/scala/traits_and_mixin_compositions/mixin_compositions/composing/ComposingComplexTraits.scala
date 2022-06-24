//package traits_and_mixin_compositions.mixin_compositions.composing
//
//import traits_and_mixin_compositions.mixin_compositions.composing.ComposingSimpleTraits.Watch
//import traits_and_mixin_compositions.traits.ExtendingClasses.ConnectorWithHelper
//
//object ComposingComplexTraits extends scala.App {
//
//  val reallyExpensiveWatch = new Watch("really expensive brand", 1000L) with ConnectorWithHelper {
//    override def connect(): Unit = println("Connected with another connector")
//
//    override def close(): Unit = println("Closed with another connector")
//  }
//
//  println("Using the really expensive watch.")
//
//  reallyExpensiveWatch.findDriver()
//  reallyExpensiveWatch.connect()
//  reallyExpensiveWatch.close()
//
//  // does not compile because watch does not extend Connector
//
//}
