package scalaspec.io

import java.io.File

import org.scalatest.Matchers._
import org.scalatest._

class FileWrapperSpec extends FunSpec {
  describe("FileWrapper") {
    it("FileWrapper to File") {
      val current: FileWrapper = new File(".")   // wrap: File => FileWrapper
      (current / "README.md").getCanonicalPath.contains("README.md") should be(true)   // unwrap: FileWrapper => File
    }
  }
}