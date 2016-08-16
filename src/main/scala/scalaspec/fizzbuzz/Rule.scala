package scalaspec.fizzbuzz

object Rule {
  type Rule = Int => String

  import Matcher.Matcher
  import Action.Action

  def atom(matcher: => Matcher, action: => Action): Rule =
    m => if (matcher(m)) action(m) else ""

  def times(n: Int, word: String): Rule =
    m => if (m % n == 0) word else ""

  def contains(n: Int, word: String): Rule =
    m => if (m.toString.contains(n.toString)) word else ""

  def default: Rule =
    m => m.toString

  def allOf(rules: (Int => String)*): Rule =
    m => rules.foldLeft("") { _ + _(m) }

  def anyOf(rules: (Int => String)*): Rule =
    m => rules.map(_(m))
    .filterNot(_.isEmpty)
    .headOption
    .getOrElse("")
}
