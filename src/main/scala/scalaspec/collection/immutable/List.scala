package scalaspec.collection.immutable

sealed abstract class List[+A] {
  def isEmpty: Boolean = this match {
    case Nil => true
    case _   => false
  }

  def head: A = this match {
    case Nil => fail
    case h :: t => h
  }

  def tail: List[A] = this match {
    case Nil => fail
    case h :: t => t
  }

  def map[B](f: A => B): List[B] = this match {
    case Nil => Nil
    case h :: t => f(h) :: t.map(f)
  }

  def filter(f: A => Boolean): List[A] = this match {
    case Nil => Nil
    case h :: t => if(f(h)) h :: t.filter(f) else t.filter(f)
  }

  def foreach[U](f: A => U): Unit = this match {
    case Nil => ()
    case h :: t => { f(h); t.foreach(f) }
  }

  def ::[B >: A] (x: B): List[B] = new ::(x, this)

  private def fail = throw new UnsupportedOperationException("empty list")
}

final case class ::[A](override val head: A, override val tail: List[A]) extends List[A]
final case object Nil extends List[Nothing]

object List {
  def apply[A](xs: A*): List[A] =
    if (xs.isEmpty) Nil
    else ::(xs.head, apply(xs.tail: _*))
}
