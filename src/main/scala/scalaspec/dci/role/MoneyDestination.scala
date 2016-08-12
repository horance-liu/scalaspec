package scalaspec.dci.role

trait MoneyDestination {
  val balance: Balance
  val messaging: Messaging
  val accountId: AccountId

  def transferFrom(src: MoneySource, currency: Currency) {
    balance.increase(currency)
    messaging.sendMsg(src.accountId, currency)
  }
}
