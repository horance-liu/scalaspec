package scalaspec.matcher.oo

trait Matcher[-A] extends (A => Boolean) {
  self =>

  def &&[B <: A](that: B => Boolean): B => Boolean =
    x => self(x) && that(x)

  def ||[B <: A](that: B => Boolean): B => Boolean =
    x => self(x) && that(x)

  def unary_![B <: A]: B => Boolean =
    x => !self(x)
}

case class EqualTo[A](expected: A) extends Matcher[A] {
  def apply(actual: A) =
    actual == expected
}

//case class NotEqualTo[-A](expected: A) extends Not(EqualTo(expected))

object IsNil extends EqualTo(null)

case class Always(bool: Boolean) extends Matcher[Any] {
  def apply(x: Any) = bool
}

class InstanceOf[-A] extends Matcher[A] {
  def apply(x: A) = x.isInstanceOf[A]
}

object InstanceOf {
  def apply[A] = new InstanceOf[A]
}

case class Same[A <: AnyRef](expected: A) extends Matcher[A] {
  def apply(actual: A) = actual eq expected
}

//case class NotSame[-A <: AnyRef](expected: A)
//  extends Not(Same(expected))

case class Not[-A](pred: Matcher[A]) extends Matcher[A] {
  def this(expected: A) = this(EqualTo(expected))
  def apply(actual: A) = !pred(actual)
}

case class Is[-A](pred: Matcher[A]) extends Matcher[A] {
  def this(expected: A) = this(EqualTo(expected))
  def apply(actual: A) = pred(actual)
}

case class AllOf[-A](matchers: Matcher[A]*) extends Matcher[A] {
  def apply(actual: A): Boolean = matchers.forall { _(actual) }
}

case class AnyOf[-A](matchers: Matcher[A]*) extends Matcher[A] {
  def apply(actual: A): Boolean = matchers.exists { _(actual) }
}

case class LessThan[A : Ordering](val expected: A) extends Matcher[A] {
  def apply(actual: A) = Ordering[A].lt(actual, expected)
}

case class GreaterThan[A : Ordering](expected: A) extends Matcher[A] {
  def apply(actual: A) = Ordering[A].gt(actual, expected)
}

case class GreaterThanOrEqualTo[A : Ordering](expected: A) extends Matcher[A] {
  def apply(actual: A) = Ordering[A].gteq(actual, expected)
}

case class LessThanOrEqualTo[A : Ordering](expected: A) extends Matcher[A] {
  def apply(actual: A) = Ordering[A].lteq(actual, expected)
}

case class ComparesEqualTo[A : Ordering](expected: A) extends Matcher[A] {
  def apply(actual: A) = Ordering[A].equiv(actual, expected)
}

trait StringMatcher extends Matcher[String]

case class Starts(prefix: String) extends StringMatcher {
  def apply(s: String) = s.startsWith(prefix)
}

case class Ends(suffix: String) extends StringMatcher {
  def apply(s: String) = s.endsWith(suffix)
}

case class Contains(substr: String) extends StringMatcher {
  def apply(s: String) = s.contains(substr)
}

case class IgnoringCase(matcher: StringMatcher) extends StringMatcher {
  def apply(s: String) = matcher(s.toLowerCase)
}

object Empty extends EqualTo("")

object EmptyOrNil extends AnyOf(Empty, IsNil)

object Blank extends StringMatcher {
  def apply(s: String) = """\s*""".r.pattern.matcher(s).matches
}

object BlankOrNil extends AnyOf(Blank, IsNil)
