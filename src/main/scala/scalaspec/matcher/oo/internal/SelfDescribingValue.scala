package scalaspec.matcher.oo.internal

import scalaspec.matcher.oo.{Description, SelfDescribing}

case class SelfDescribingValue[T](value: T) extends SelfDescribing {
  def describeTo(description: Description) {
    description.appendValue(value)
  }
}
