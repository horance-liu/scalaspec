package scalaspec.io

import java.io.File

import scalaspec.reader.generic.FileReader
import org.scalatest.Matchers._
import org.scalatest._

import scala.collection.mutable.ArrayBuffer

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

    ArrayBuffer(1, 2).forall(_ > 0)
  }
}