//package behavioral_design_patterns.visitor
//
//object CodeExample extends scala.App {
//
//  // The visitor design pattern helps us add new operations to existing object
//  // structures without modifying them.
//
//  abstract class Element(val text: String) {
//    def accept(visitor: Visitor): Unit
//  }
//
//  class Title(text: String) extends Element(text) {
//    override def accept(visitor: Any): Unit = visitor.visit(this)
//  }
//
//  class Text(text: String) extends Element(text) {
//    override def accept(visitor: Visitor): Unit = visitor.visit(this)
//  }
//
//  class Hyperlink(text: String, val url: String) extends Element(text) {
//    override def accept(visitor: Visitor): Unit = visitor.visit(this)
//  }
//
//  class Document(parts: List[Element]) {
//    def accept(visitor: Visitor): Unit = parts.foreach(p => p.accept(visitor))
//  }
//
//  trait Visitor {
//    def visit(title: Title): Unit
//    def visit(text: Text): Unit
//    def visit(hyperlink: Hyperlink): Unit
//  }
//
//  class HtmlExporterVisitor extends Visitor {
//    val line = System.getProperty("line.separator")
//    val builder = new StringBuilder
//
//    def getHtml(): String = builder.toString
//
//    override def visit(title: Title): Unit = {
//      builder.append(s"<h1>${title.text}</h1>").append(line)
//    }
//
//    override def visit(text: Text): Unit = {
//      builder.append(s"<p>${text.text}</p>").append(line)
//    }
//
//    override def visit(hyperlink: Hyperlink): Unit = {
//      builder.append(
//        s"""<ahref=\"${hyperlink.url}\">${hyperlink.text}</a>""").append(line)
//    }
//  }
//
//  class PlainTextExporterVisitor extends Visitor {
//    val line = System.getProperty("line.separator")
//    val builder = new StringBuilder
//    def getText(): String = builder.toString
//    override def visit(title: Title): Unit = {
//      builder.append(title.text).append(line)
//    }
//    override def visit(text: Text): Unit = {
//      builder.append(text.text).append(line)
//    }
//    override def visit(hyperlink: Hyperlink): Unit = {
//      builder.append(s"${hyperlink.text} (${hyperlink.url})").append(line)
//    }
//  }
//
//
//}
