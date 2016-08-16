package scalaspec.fizzbuzz

import org.scalatest.Matchers._
import org.scalatest._

class RuleSpec extends FunSpec {
  describe("Rule") {
    import Rule._

    it("times(3) -> fizz") {
      times(3, "Fizz")(3 * 2) should be("Fizz")
    }

    it("contains(3) -> fizz") {
      contains(3, "Fizz")(13) should be("Fizz")
    }

    it("default rule") {
      default(2) should be("2")
    }

    it("times(3) && times(5) -> FizzBuzz") {
      allOf(times(3, "Fizz"), times(5, "Buzz"))(3 * 5) should be("FizzBuzz")
    }

    it("times(3) -> Fizz || times(5) -> Buzz") {
      anyOf(times(3, "Fizz"), times(5, "Buzz"))(3 * 5) should be("Fizz")
    }
  }

  describe("using atom rule") {
    import Rule.{allOf, anyOf, atom}
    import Matcher._
    import Action._

    val r1_3 = atom(times(3), to("Fizz"))
    val r1_5 = atom(times(5), to("Buzz"))

    it("times(3) -> fizz") {
      r1_3(3 * 2) should be("Fizz")
    }

    val r3 = atom(contains(3), to("Fizz"))

    it("contains(3) -> fizz") {
      r3(13) should be("Fizz")
    }

    val rd = atom(always(true), nop)

    it("default rule") {
      rd(2) should be("2")
    }

    it("times(3) && times(5) -> FizzBuzz") {
      allOf(r1_3, r1_5)(3 * 5) should be("FizzBuzz")
    }

    it("times(3) -> Fizz || times(5) -> Buzz") {
      anyOf(r1_3, r1_5)(3 * 5) should be("Fizz")
    }
  }
}
