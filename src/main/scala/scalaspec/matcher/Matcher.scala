package scalaspec.matcher

object Matcher {
  def equalTo[T](expected: T): T => Boolean =
    expected == _

  def notEqualTo[T](expected: T): T => Boolean =
    expected != _
}
