package scalaspec.collection.immutable

sealed abstract class List[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: List[A]

  def ::[B >: A](b: B): List[B] = new ::(b, this)
}

final case class ::[A](head: A, tail: List[A]) extends List[A] {
  def isEmpty: Boolean = false
}

case object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = fail
  def tail: List[Nothing] = fail

  private[this] def fail = throw new UnsupportedOperationException("empty list")
}
