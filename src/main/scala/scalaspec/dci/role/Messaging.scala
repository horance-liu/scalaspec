package scalaspec.dci.role

trait Messaging {
  def sendMsg(to: AccountId, currency: Currency): Unit
}
