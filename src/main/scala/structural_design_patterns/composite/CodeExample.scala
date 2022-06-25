package structural_design_patterns.composite

import scala.collection.mutable.ListBuffer

object CodeExample extends scala.App {

  trait Node {
    def print(prefix: String): Unit
  }

  class Leaf(data: String) extends Node {
    override def print(prefix: String): Unit = println(s"$prefix $data")
  }

  class Tree extends Node {
    private val children = ListBuffer.empty[Node]

    override def print(prefix: String): Unit = {
      println(s"$prefix")
      children.foreach(_.print(s"$prefix $prefix"))
      println(s"$prefix")
    }

    def add(child: Node): Unit = {
      children += child
    }

    def remove(): Unit = {
      if (children.nonEmpty) {
        children.remove(0)
      }
    }

  }

  val tree = new Tree
  tree.add(new Leaf("1"))

  val subtree = new Tree
  subtree.add(new Leaf("2"))

  tree.add(subtree)

  tree.print("-")
}
