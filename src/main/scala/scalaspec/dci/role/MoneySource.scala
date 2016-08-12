package scalaspec.dci.role

trait MoneySource {
  val balance: Balance
  val messaging: Messaging
  val accountId: AccountId

  def transferTo(dest: MoneyDestination, currency: Currency) {
    if (!balance.available(currency))
      throw new InsufficientFunds(s"remainded: ${currency.amount}")

    balance.descrease(currency)
    messaging.sendMsg(dest.accountId, currency)
  }
}
