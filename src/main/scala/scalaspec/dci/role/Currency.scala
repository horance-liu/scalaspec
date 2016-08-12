package scalaspec.dci.role

case class Currency(amount: Int) extends Ordered[Currency] {
  def +=(other: Currency): Currency =
    Currency(amount + other.amount)

  def -=(other: Currency): Currency =
    Currency(amount - other.amount)

  def compare(other: Currency): Int =
    amount - other.amount
}