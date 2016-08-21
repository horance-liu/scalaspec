package scalaspec.matcher.oo.internal

import scalaspec.matcher.oo.SelfDescribing
import java.util.Iterator

class SelfDescribingValueIterator[T](values: Iterator[T]) extends Iterator[SelfDescribing] {
  def hasNext: Boolean = values.hasNext

  def next: SelfDescribing = new SelfDescribingValue[T](values.next)

  override def remove() {
    values.remove()
  }
}

