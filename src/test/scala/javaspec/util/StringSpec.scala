package javaspec.util

import org.scalatest.FunSpec
import org.scalatest.Matchers._

class StringSpec extends FunSpec {
  describe("StringUtil") {
    it("isDigit") {
      exists("123") { _.isDigit } should be(true)
      forall("123") { _.isDigit } should be(true)
    }

    it("isUpper") {
      exists("HORANCE") { _.isUpper } should be(true)
      forall("HORANCE") { _.isUpper } should be(true)
    }

    it("isLower") {
      exists("horance") { _.isLower } should be(true)
      forall("horance") { _.isLower } should be(true)
    }

    def exists(s: String)(p: Char => Boolean): Boolean =
      pred(StringUtil.exists)(s)(p)

    def forall(s: String)(p: Char => Boolean): Boolean =
      pred(StringUtil.forall)(s)(p)

    type StringFunctor = (String, CharacterSpec) => Boolean

    def pred(f: StringFunctor)(s: String)(p: Char => Boolean): Boolean =
      return f(s, new CharacterSpec {
        override def satisfy(c: Char): Boolean = p(c)
      })
  }

  describe("String") {
    it("isDigit") {
      "123".exists { _.isDigit } should be(true)
      "123".forall { _.isDigit } should be(true)
    }

    it("isUpper") {
      "HORANCE".exists { _.isUpper } should be(true)
      "HORANCE".forall { _.isUpper } should be(true)
    }

    it("isLower") {
      "horance".exists { _.isLower } should be(true)
      "horance".forall { _.isLower } should be(true)
    }
  }
}
