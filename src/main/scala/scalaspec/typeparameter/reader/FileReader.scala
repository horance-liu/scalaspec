package scalaspec.typeparameter.reader

import java.io.File

import scala.io.Source
import scala.util.Properties.lineSeparator
import scalaspec.loanpattern.using

class FileReader(val source: File) extends Reader[File] {
  def read: String = using(Source.fromFile(source)) { file =>
    file.getLines.mkString(lineSeparator)
  }
}
