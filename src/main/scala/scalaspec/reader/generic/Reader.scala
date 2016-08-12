package scalaspec.reader.generic

trait Reader[+T] {
  val source: T
  def read: String
}
