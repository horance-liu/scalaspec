package scalaspec.matcher.fp

import org.scalatest.Matchers._
import org.scalatest._

class MatcherSpec extends FunSpec {
  describe("Students") {
    import scalaspec.matcher.fp.Human._
    import scalaspec.matcher.fp.Matcher._

    val students = Array(student("horance", 18), student("alice", 20))

//    it("find student by age") {
//      students.find { age(eql(18)) && name(eql("horance")) } should be(Some(student("horance", 18)))
//      students.find { age(eql(18)) } should be(Some(student("horance", 18)))
//    }
//
//    it("can't find student by age") {
//      students.find { age(eql(30))  } should be(None)
//    }
//
//    it("age(ne(18))") {
//      students.find { age(not(eql(20)))  } should be(Some(student("horance", 18)))
//    }
  }
}