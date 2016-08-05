package scalaspec.collection.immutable

import org.scalatest.Matchers._
import org.scalatest._

class ListWrapperSpec extends FunSpec {
  describe("ListWrapper") {
    it("sort by mapper") {
      val words = "The quick brown fox jumped over the lazy dog".split(' ')
      ListWrapper(words.toList).sortBy(x => (x.length, x.head)) should be(
        List("The", "dog", "fox", "the", "lazy", "over", "brown", "quick", "jumped"))

      List("1", "2").map(_.toInt)
    }
  }
}
