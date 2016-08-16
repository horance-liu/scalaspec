package scalaspec.matcher

import scala.collection.GenTraversable

object Tools {
  def find[E](c: GenTraversable[E])(p: E => Boolean): Option[E] = {
    for (e <- c if p(e))
      return Some(e)
    None
  }
}
