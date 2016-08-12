package scalaspec.dci.obj.dest

import scalaspec.dci.role.{AccountId, Balance, Currency, MoneyDestination}

class SavingAccount(val accountId: AccountId, var currency: Currency)
  extends MoneyDestination with Balance with Phone {
  val balance = this
  val messaging = this
}
