package scalaspec.matcher.fp

case class Human(name: String, age: Int)

object Human {
  def student(name: String, age: Int) = Human(name, age)
  def teacher(name: String, age: Int) = Human(name, age)
}
