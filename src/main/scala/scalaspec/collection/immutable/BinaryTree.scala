package scalaspec.collection.immutable

import scala.math.Ordering

sealed abstract class BinaryTree[+A] {
  def map[B](f: A => B): BinaryTree[B] = this match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(l.map(f), r.map(f))
  }

  def size: Int = this match {
    case Leaf(_) => 1
    case Branch(l, r) => l.size + r.size
  }

  def depth: Int = this match {
    case Leaf(_) => 0
    case Branch(l, r) => 1 + l.depth.max(r.depth)
  }
}

final case class Branch[A](left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]
final case class Leaf[A](value: A) extends BinaryTree[A]
