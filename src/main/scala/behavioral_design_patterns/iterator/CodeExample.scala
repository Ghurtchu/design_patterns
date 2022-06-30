package behavioral_design_patterns.iterator

import scala.collection.mutable.ListBuffer

object CodeExample extends scala.App {

  // The iterator design pattern provides a way to access the elements of an
  // aggregate object (collection) in a sequential manner without exposing the
  // underlying representation of the items

  case class Student(name: String, age: Int)

  class StudentIterator(students: Array[Student]) extends Iterator[Student] {

    var currentPosition = 0

    override def hasNext: Boolean = currentPosition < students.length

    override def next(): Student = {
      val student = students(currentPosition)
      currentPosition = currentPosition + 1

      student
    }
  }

  class ClassRoom extends Iterable[Student] {
    val students: ListBuffer[Student] = ListBuffer.empty

    def add(s: Student): Unit = s +=: students

    override def iterator: Iterator[Student] = new StudentIterator(students.toArray);
  }

  val classRoom = new ClassRoom

  classRoom.add(Student("Nika", 23))
  classRoom.add(Student("Laliko", 19))

  classRoom.foreach(println)
}
