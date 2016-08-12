package scalaspec.collection.mutable

import org.scalatest.{FunSpec, ShouldMatchers}

class ArrayBufferSpec extends FunSpec with ShouldMatchers {
  describe("ArrayBuffer") {
    it ("filter elements") {
      ArrayBuffer(1, 2, 3).filter(_ % 2 == 0) == ArrayBuffer(2)
    }
  }
}
