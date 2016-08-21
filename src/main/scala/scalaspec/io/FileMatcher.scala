package scalaspec.io

import java.io.File

object FileMatcher {
  private type Matcher = String => Boolean

  private def list(file: File)(matcher: Matcher) =
    file.listFiles.filter(f => matcher(f.getName))

  def ends(file: File, ext: String) =
    list(file) { _ endsWith ext }

  def contains(file: File, query: String) =
    list(file) { _ contains query }

  def matches(file: File, regex: String) =
    list(file) { _ matches regex }
}
