package scalaspec.io

import java.io.File

import org.scalatest.Matchers._
import org.scalatest._

import scalaspec.reader.generic.FileReader

class FileReaderSpec extends FunSpec {
  describe("FileReader") {
    it("can read from file") {
      new FileReader(new File("./README.md")).read.contains("ScalaSpec") should be(true)
    }
  }
}