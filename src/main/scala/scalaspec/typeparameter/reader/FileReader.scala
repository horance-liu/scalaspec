package scalaspec.typeparameter.reader

import java.io.File

import scala.io.Source
import scala.util.Properties.lineSeparator
import scalaspec.loanpattern.using

class FileReader(val source: File) extends Reader[File] {
  def read: String = using(Source.fromFile(source)) { file =>
    file.getLines.mkString(lineSeparator)
  }

  List(1, 2, 3).map(_ * 2)
  Set(1, 2, 3).map(_ * 2)
  Map("1" -> 1, "2" -> 2, "3" -> 3).map(_._2 * 2)
}
