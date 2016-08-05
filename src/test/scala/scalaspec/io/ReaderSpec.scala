package scalaspec.io

import java.io.File

import org.scalatest.Matchers._
import org.scalatest._

class ReaderSpec extends FunSpec {
  describe("Reader") {
    it("can read from file") {
      print(new FileReader(new File("/Users/guangyun.lgc/.zshrc")).read)
    }

    it("") {
      def firstlast[A, C](c: C)(implicit ev: C <:< Iterable[A]) =
        (c.head, c.last)

      firstlast(List("a", "b", "c"))
    }
  }
}