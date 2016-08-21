package scalaspec.matcher.fp

object Matcher {
  // core
  def eql[T](expected: T): T => Boolean =
    _ == expected

  def is[T](matcher: T => Boolean): T => Boolean =
    matcher

  def is[T](expected: T): T => Boolean = is(eql(expected))

  def not[T](matcher: T => Boolean): T => Boolean =
    !matcher(_)

  def not[T](expected: T): T => Boolean = not(eql(expected))

  def always(bool: Boolean): Any => Boolean =
    any => bool

  def anything = always(true)

  def nil: AnyRef => Boolean =
    _ == null

  def same[T <: AnyRef](t: T): T => Boolean =
    actual => actual eq t

  def instanceOf[T]: T => Boolean =
    _.isInstanceOf[T]

  def allOf[T](matchers: (T => Boolean)*): T => Boolean =
    actual => matchers.forall(_(actual))

  def anyOf[T](matchers: (T => Boolean)*): T => Boolean =
    actual => matchers.exists(_(actual))

  // number
  type DoubleMatcher = Double => Boolean

  def nan: DoubleMatcher =
    _.isNaN

  def closeTo(value: Double, delta: Double): DoubleMatcher =
    n => (n - value).abs - delta <= 0

  // comparator
  def gt[T : Ordering](expected: T): T => Boolean =
    Ordering[T].gt(_, expected)

  def lt[T : Ordering](expected: T): T => Boolean =
    Ordering[T].lt(_, expected)

  def gteq[T : Ordering](expected: T): T => Boolean =
    Ordering[T].gteq(_, expected)

  def lteq[T : Ordering](expected: T): T => Boolean =
    Ordering[T].lteq(_, expected)

  def equiv[T : Ordering](expected: T): T => Boolean =
    Ordering[T].equiv(_, expected)

  // string
  type StringMatcher = String => Boolean

  def ignoring_case(matcher: String => StringMatcher, substr: String): StringMatcher =
    str => matcher(substr.toLowerCase)(str.toLowerCase)

  def starts(substr: String): StringMatcher =
    _.startsWith(substr)

  def ends(substr: String): StringMatcher =
    _.endsWith(substr)

  def contains(substr: String): StringMatcher =
    _.contains(substr)

  def empty = eql("")
  def empty_or_nil = anyOf(eql(""), nil)

  def blank: StringMatcher = """\s*""".r.pattern.matcher(_).matches
  def blank_or_nil = anyOf(blank, nil)
}
