package scalaspec.fizzbuzz

object Rule {
  type Rule = Int => String

  import Matcher.Matcher
  import Action.Action

  def atom(matcher: => Matcher, action: => Action): Rule =
    n => if (matcher(n)) action(n) else ""

  def allof(rules: Rule*): Rule =
    n => rules.foldLeft("") { _ + _(n) }

  def anyof(rules: Rule*): Rule =
    n => rules.map(_(n))
      .filterNot(_.isEmpty)
      .headOption
      .getOrElse("")

  def comb(rules: Rule*) = {
    def subsets: Seq[Rule] =
      rules.toSet.subsets.toList.reverse.map { subset =>
        allof(subset.toList: _*)
      }
    anyof(subsets: _*)
  }
}
