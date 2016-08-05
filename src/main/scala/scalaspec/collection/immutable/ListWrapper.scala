package scalaspec.collection.immutable

import scala.math.Ordering

case class ListWrapper[A](seq: Seq[A]) {
  //  def sortBy[B](f: A => B)(implicit ord: Ordering[B]): Seq[A] =
  //    seq.sortBy(f)

  def sortBy[B : Ordering](f: A => B): Seq[A] =
    seq.sortBy(f)
}
