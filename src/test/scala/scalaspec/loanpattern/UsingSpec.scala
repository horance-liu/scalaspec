package scalaspec.loanpattern

import org.scalatest.Matchers._
import org.scalatest._

import scala.io.Source
import scala.util.Properties

class UsingSpec extends FunSpec {
  describe("using") {
    it("should contains scalaspec for README.md") {
      def readme = s"${Properties.userDir}/README.md"

      using(Source.fromFile(readme)) { file =>
        file.getLines.exists(_.contains("ScalaSpec")) should be(true)
      }
    }
  }
}
