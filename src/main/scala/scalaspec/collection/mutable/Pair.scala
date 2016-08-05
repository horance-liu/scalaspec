package scalaspec.collection.mutable

class Pair[T](var first: T, var second: T)

object Pair {
  type SuperComparable[T] = Comparable[_ >: T]

  def smaller[T <: Comparable[T]](p : Pair[T]) =
    if(p.first.compareTo(p.second) < 0) p.first else p.second

  def larger[T <: Comparable[T]](p : Pair[T]) =
    if(p.first.compareTo(p.second) < 0) p.second else p.first

  def apply[T](first: T, second: T) = new Pair[T](first, second)
}
