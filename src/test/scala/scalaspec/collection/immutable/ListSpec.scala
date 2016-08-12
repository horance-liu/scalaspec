package scalaspec.collection.immutable

import org.scalatest._

class ListSpec extends FunSpec with ShouldMatchers {
  describe("List") {
    import scalaspec.collection.immutable.List

    it("should be cons elements") {
      List(1, 2, 3).map(_*2) shouldBe List(2, 4, 6)
    }

    it("should filter elements") {
      List(1, 2, 3).filter(_ > 0) shouldBe List(1, 2, 3)
    }

    it("should be enumerate elements") {
      List(1, 2, 3).foreach(println)
    }

    it("should be not empty") {
      List(1, 2, 3).isEmpty should be(false)
    }

    it("no empty can fetch head") {
      List(1, 2, 3).head should be(1)
    }

    it("no empty can fetch tail") {
      List(1).tail should be(Nil)
    }

    it("Nil should be empty") {
      Nil.isEmpty should be(true)
    }
  }
}