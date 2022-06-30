//package behavioral_design_patterns.mediator
//
//object CodeExample extends scala.App {
//
//  // The purpose of the mediator design pattern is to define an object that
//  // encapsulates how a set of other objects interact with each other in order to
//  // promote loose coupling and allow us to vary class interactions
//  // independently.
//
//  trait Notifiable {
//    def notify(message: String): Unit
//  }
//
//  case class Student(name: String, age: Int) extends Notifiable {
//    override def notify(message: String): Unit = println(s"Student with $name was notified with $message")
//  }
//
//  case class Group(name: String)
//
//  trait Mediator {
//    def addStudentToGroup(student: Student, group: Group): Unit
//
//    def isStudentInGroup(student: Student, group: Group): Boolean
//
//    def removeStudentFromGroup(student: Student, group: Group): Unit
//
//    def getStudentsInGroup(group: Group): List[Student]
//
//    def getGroupsForStudent(student: Student): List[Group]
//
//    def notifyStudentsInGroup(group: Group, message: String): Unit
//  }
//
//  class School extends Mediator {
//
//    import scala.collection.mutable
//
//    val studentsToGroups: mutable.Map[Student, Set[Group]] = mutable.Map.empty
//    val groupsToStudents: mutable.Map[Group, Set[Student]] = mutable.Map.empty
//
//    override def addStudentToGroup(student: Student, group: Group): Unit = {
//      studentsToGroups.getOrElseUpdate(student, Set()) += group
//      groupsToStudents.getOrElseUpdate(group, Set()) += student
//    }
//
//    override def isStudentInGroup(student: Student, group: Group): Boolean =
//      groupsToStudents.getOrElse(group, Set()).contains(student) &&
//        studentsToGroups.getOrElse(student, Set()).contains(group)
//
//    override def getStudentsInGroup(group: Group): List[Student] =
//      groupsToStudents.getOrElse(group, Set()).toList
//
//    override def getGroupsForStudent(student: Student): List[Group] =
//      studentsToGroups.getOrElse(student, Set()).toList
//
//    override def notifyStudentsInGroup(group: Group, message: String): Unit = {
//      groupsToStudents.getOrElse(group, Set()).foreach(_.notify(message))
//    }
//
//    override def removeStudentFromGroup(student: Student, group: Group): Unit
//    = {
//      studentsToGroups.getOrElse(student, Set()) -= group
//      groupsToStudents.getOrElse(group, Set()) -= student
//    }
//  }
//
//  val school = new School
//  // create students
//  val student1 = Student("Ivan", 26)
//  val student2 = Student("Maria", 26)
//  val student3 = Student("John", 25)
//  // create groups
//  val group1 = Group("Scala design patterns")
//  val group2 = Group("Databases")
//  val group3 = Group("Cloud computing")
//  school.addStudentToGroup(student1, group1)
//  school.addStudentToGroup(student1, group2)
//
//  school.notifyStudentsInGroup(group1, "Design patterns in Scala are amazing!")
//
//}
