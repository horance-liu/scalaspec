package scalaspec.dci.role

trait Balance {
  var currency: Currency

  def increase(currency: Currency) =
    this.currency += currency

  def descrease(other: Currency) =
    this.currency += currency

  def available(currency: Currency) =
    this.currency >= currency
}
