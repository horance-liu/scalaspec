package scalaspec.dci.obj

import scalaspec.dci.obj.dest.SavingAccount
import scalaspec.dci.obj.src.PayingAccount
import scalaspec.dci.role.{AccountId, Currency, MoneyDestination, MoneySource}

object AccountRepository {
  private var srcAccounts: List[PayingAccount]  = Nil
  private var destAccounts: List[SavingAccount] = Nil

  def addPayingAccount(id: AccountId, currency: Currency) {
    srcAccounts ::= new PayingAccount(id, currency)
  }

  def addSavingAccount(id: AccountId, currency: Currency) {
    destAccounts ::= new SavingAccount(id, currency)
  }

  def getPayingAccount(accountId: AccountId): MoneySource =
    retrive(accountId, srcAccounts)

  def getSavingAccount(accountId: AccountId): MoneyDestination =
    retrive(accountId, destAccounts)

  private def retrive[T <: {val accountId: AccountId}]
    (accountId: AccountId, repo: List[T]): T = {
    repo.find(_.accountId == accountId).getOrElse(fail(accountId))
  }

  private def fail(accountId: AccountId) =
    throw new RuntimeException(s"not found ${accountId.id}")
}
