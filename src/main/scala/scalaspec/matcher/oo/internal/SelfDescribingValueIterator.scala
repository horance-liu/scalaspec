package scalaspec.matcher.oo.internal

import scalaspec.matcher.oo.SelfDescribing

case class SelfDescribingValueIterator[T](values: Iterator[T]) extends Iterator[SelfDescribing] {
  override def hasNext: Boolean = values.hasNext
  override def next(): SelfDescribing = SelfDescribingValue(values.next())
}

