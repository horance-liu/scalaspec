package scalaspec.dci.obj.src

import scalaspec.dci.role.{AccountId, Currency, Messaging}

trait Phone extends Messaging {
  def sendMsg(to: AccountId, currency: Currency) =
    println(s"transfer to ${to.id}: ${currency.amount}")
}
