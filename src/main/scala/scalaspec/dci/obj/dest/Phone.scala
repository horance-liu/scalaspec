package scalaspec.dci.obj.dest

import scalaspec.dci.role.{AccountId, Currency, Messaging}

trait Phone extends Messaging {
  def sendMsg(from: AccountId, currency: Currency) {
    println(s"receive from ${from.id}: ${currency.amount}")
  }
}
