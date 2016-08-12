package scalaspec.reader.abstraction

trait Reader {
  type T
  val source: T
  def read: String
}
