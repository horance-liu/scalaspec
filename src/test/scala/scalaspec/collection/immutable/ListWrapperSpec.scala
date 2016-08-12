package scalaspec.collection.immutable

import org.scalatest.Matchers._
import org.scalatest._

import scala.collection.mutable.ArrayBuffer

class ListWrapperSpec extends FunSpec {
  describe("ListWrapper") {
    it("sort by mapper") {
      val words = "The quick brown fox jumped over the lazy dog".split(' ')
      ListWrapper(words.toList).sortBy(x => (x.length, x.head)) should be(
        scala.List("The", "dog", "fox", "the", "lazy", "over", "brown", "quick", "jumped"))
    }
  }
}
