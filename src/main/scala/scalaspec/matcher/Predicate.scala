package scalaspec.matcher

//trait Predicate[-E] {
//  def apply(e: E): Boolean
//}
//
//case class AgePredicate(age: Int) extends Predicate[Student] {
//  def apply(s: Student) = s.age == age
//}
//
//case class NamePredicate(name: String) extends Predicate[Student] {
//  def apply(s: Student) = s.name == name
//}

//object Predicate {
//  def age(expectAge: Int): Student => Boolean =
//    _.age == expectAge
//
//  def name(expectName: String): Student => Boolean =
//    _.name == expectName
//}

//object Predicate {
//  def age(matcher: Int => Boolean): Student => Boolean =
//    s => matcher(s.age)
//
//  def name(matcher: String => Boolean): Student => Boolean =
//    s => matcher(s.name)
//}

class Predicate[A](pred: A => Boolean) extends (A => Boolean) {
  override def apply(a: A) = pred(a)

  def &&(that: A => Boolean) = new Predicate[A](x => pred(x) && that(x))
  def ||(that: A => Boolean) = new Predicate[A](x => pred(x) || that(x))
  def unary_! = new Predicate[A](x => !pred(x))
}

object Predicate {
  def age(matcher: Int => Boolean): Predicate[Student] =
    new Predicate(s => matcher(s.age))

  def name(matcher: String => Boolean): Predicate[Student] =
    new Predicate(s => matcher(s.name))
}