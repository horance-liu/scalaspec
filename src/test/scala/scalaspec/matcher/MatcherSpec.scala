package scalaspec.matcher

import org.scalatest.Matchers._
import org.scalatest._

class MatcherSpec extends FunSpec {
  describe("Students") {
    val students = Array(Student("horance", 18), Student("alice", 20))

    import Predicate._
    import Matcher._
    import Tools._

    it("find student by age") {
      find(students) { age(equalTo(18)) && name(equalTo("horance")) } should be(Some(Student("horance", 18)))
      find(students) { age(equalTo(18)) } should be(Some(Student("horance", 18)))
    }

    it("can't find student by age") {
      find(students) { age(equalTo(30))  } should be(None)
    }

    it("age(ne(18))") {
      find(students) { age(notEqualTo(20))  } should be(Some(Student("horance", 18)))
    }
  }
}