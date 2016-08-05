package scalaspec.serialization.ctxt

object RemoteConnection {
  import Serialization._
  def write[T: Writable](t: T) = t.serialized
}
