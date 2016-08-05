package scalaspec.loanpattern

import scala.language.reflectiveCalls



object using {
  def apply[R <: { def close(): Unit }, T](resource: => R)(f: R => T): T = {
    var source: Option[R] = None
    try {
      source = Some(resource)
      f(source.get)
    } finally {
      for (s <- source)
        s.close
    }
  }
}
