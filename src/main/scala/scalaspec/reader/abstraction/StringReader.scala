package scalaspec.reader.abstraction

case class StringReader(source: String) extends Reader {
  type T = String
  def read: String = source
}
