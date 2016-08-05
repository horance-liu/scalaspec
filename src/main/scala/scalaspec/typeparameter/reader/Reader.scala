package scalaspec.typeparameter.reader

trait Reader[+T] {
  val source: T
  def read: String
}
