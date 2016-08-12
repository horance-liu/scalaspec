package scalaspec.reader.generic

case class StringReader(source: String) extends Reader[String] {
  def read: String = source
}
