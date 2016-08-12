package scalaspec.dci.ctxt

import scalaspec.dci.obj.AccountRepository
import scalaspec.dci.role.{AccountId, Currency}

object TransferMoneyContext {
  def transfer(srcId: AccountId, destId: AccountId, currency: Currency) {
    val src  = AccountRepository.getPayingAccount(srcId)
    val dest = AccountRepository.getSavingAccount(destId)
    src.transferTo(dest, currency)
  }
}
