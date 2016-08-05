package scalaspec.concurrent

import scalaspec.logger.Logging

object Threading extends Logging {
  def runnable(callback: => Unit) = new Runnable {
    override def run() = callback
  }

  def thread(callback: Unit) = new Thread(runnable(callback))

  def thread(name: String, daemon: Boolean)(callback: => Unit): Thread = {
    val thread = new Thread(runnable(callback), name)
    thread.setDaemon(daemon)
    thread.setUncaughtExceptionHandler(handler)
    thread
  }

  private def handler = onException { (thread, exception) =>
    error(s"Uncaught exception in thread ${thread.getName}:${exception.toString}", exception)
  }

  private def onException(h: (Thread, Throwable) => Unit) =
    new Thread.UncaughtExceptionHandler {
      override def uncaughtException(t: Thread, e: Throwable): Unit = h(t, e)
    }
}
