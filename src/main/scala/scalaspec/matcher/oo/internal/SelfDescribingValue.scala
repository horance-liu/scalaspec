package scalaspec.matcher.oo.internal

import scalaspec.matcher.oo.{Description, SelfDescribing}

class SelfDescribingValue[T](value: T) extends SelfDescribing {
  def describeTo(description: Description) {
    description.appendValue(value)
  }
}
