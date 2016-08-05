package scalaspec

import org.scalatest._
import org.scalatest.Matchers._

class VersionSpec extends FunSpec {
  describe("cup") {
    it("should specify version") {
      Version.VERSION should be("1.0.0")
    }
  }
}