package scalaspec.typeparameter.reader

case class StringReader(source: String) extends Reader[String] {
  def read: String = source
}
