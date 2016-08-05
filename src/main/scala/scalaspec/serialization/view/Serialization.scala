package scalaspec.serialization.view

object Serialization {
  case class Writable(value: Any) {
    def serialized: String = s"$value"
  }

  import scala.language.implicitConversions

  implicit def fromInt(i: Int) = Writable(i)
  implicit def fromFloat(f: Float) = Writable(f)
  implicit def fromString(s: String) = Writable(s)
}
