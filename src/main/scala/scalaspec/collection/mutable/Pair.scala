package scalaspec.collection.mutable

import Pair._

class Pair[T <: SuperComparable[T]](var first: T, var second: T) {
  def smaller[T <: SuperComparable[T]] =
    if(first.compareTo(second) < 0) first else second

  def larger[T <: SuperComparable[T]] =
    if(first.compareTo(second) < 0) second else first
}

object Pair {
  type SuperComparable[T] = Comparable[_ >: T]

  def apply[T <: SuperComparable[T]](first: T, second: T) =
    new Pair[T](first, second)
}

//object Main extends App {
//  trait Employee
//  case class Manager(name: String) extends Employee
//
//  val ceo = new Manager("Bob")
//  val cfo = new Manager("Alice")
//
//  var managers = new Pair[Manager](ceo, cfo)
//  val employee: Pair[_ <: Employee] = managers
//  val m: Employee = employee.first
//
//  val employeeBuddies = new Pair[Employee](ceo, cfo)
//  val wildcardBuddies: Pair[_ >: Manager] = employeeBuddies
//  wildcardBuddies.first = ceo
//
//  def hasNull(p: Pair[_]): Boolean = {
//    p.first == null || p.second == null
//  }
//
//  def swap(p: Pair[_]) {
//    swapHelper(p);
//  }
//
//  private def swapHelper[T](p: Pair[T]) {
//    val t = p.first
//    p.first = p.second
//    p.second = t
//  }
//
//  type SuperComparable[T] = Comparable[_ >: T]
//
//  def min[T <: SuperComparable[T]](a: Array[T]): T = a.min
//
//  def min[T](a: Traversable[T])(implicit o: Ordering[T]): T = ???
//
//  trait Collection[+A] {
//    def max[B >: A](implicit cmp: Ordering[B]): B = ???
//    def foldLeft[B](z: B)(op: (B, A) => B): B = ???
//  }
//}
