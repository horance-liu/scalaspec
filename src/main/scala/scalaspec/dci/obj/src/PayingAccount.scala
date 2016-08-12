package scalaspec.dci.obj.src

import scalaspec.dci.role.{AccountId, Balance, Currency, MoneySource}

class PayingAccount(val accountId: AccountId, var currency: Currency)
  extends MoneySource with Balance with Phone {
  val balance = this
  val messaging = this
}
