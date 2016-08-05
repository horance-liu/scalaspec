package scalaspec.serialization.ctxt

object Serialization {
  case class Rem[A](value: A) {
    def serialized: String = s"$value"
  }

  type Writable[A] = A => Rem[A]

  implicit val fromInt: Writable[Int] = i => Rem(i)
  implicit val fromFloat:Writable[Float] = f => Rem(f)
  implicit val fromString: Writable[String] = s => Rem(s)
}