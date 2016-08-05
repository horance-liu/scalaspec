package scalaspec.util

object Swallow {
  def swallow(logger: (Object, Throwable) => Unit, action: => Unit) {
    try {
      action
    } catch {
      case e: Throwable => logger(e.getMessage, e)
    }
  }
}
