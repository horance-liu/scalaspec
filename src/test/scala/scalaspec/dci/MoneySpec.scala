package scalaspec.dci

import org.scalatest._
import org.scalatest.Matchers._

import scalaspec.dci.ctxt.TransferMoneyContext
import scalaspec.dci.obj.AccountRepository
import scalaspec.dci.role.{AccountId, Currency}

class MoneySpec extends FunSpec {
  describe("MoneySpec") {
    AccountRepository.addPayingAccount(AccountId(1), Currency(1000))
    AccountRepository.addSavingAccount(AccountId(2), Currency(2000))

    it("can transfer money from source to destination") {
      TransferMoneyContext.transfer(AccountId(1), AccountId(2), Currency(1000))
    }
  }
}