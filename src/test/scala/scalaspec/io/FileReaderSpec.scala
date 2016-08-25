package scalaspec.io

import java.io.File

import org.scalatest.Matchers._
import org.scalatest._

import scalaspec.reader.generic.FileReader

class FileReaderSpec extends FunSpec {
  describe("FileReader") {
    it("can read from file") {
      new FileReader(new File("/Users/guangyun.lgc/.zshrc")).read.contains("JAVA_HOME") should be(true)
    }
  }
}