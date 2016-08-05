package scalaspec.collection.immutable

import scala.math.Ordering

case class Pair[+T : Ordering](first: T, second: T) {
  //def smaller = Ordering[T].min(first, second)
  def smaller = implicitly[Ordering[T]].min(first, second)
}
