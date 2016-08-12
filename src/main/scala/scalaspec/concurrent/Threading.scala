package scalaspec.concurrent

import scalaspec.logger.Logging

object Threading extends Logging {

  def runnable(callback: => Unit) = new Runnable {
    override def run() = callback
  }

  def thread(callback: Unit) = new Thread(runnable(callback))

  def daemon(name: String)(callback: => Unit) =
    new Thread(runnable(callback), name) {
      setDaemon(true)
      setUncaughtExceptionHandler(handler)
    }

  private def handler = onException { (thread, exception) =>
    error(s"Uncaught exception in thread ${thread.getName}:${exception.toString}", exception)
  }

  private def onException(handler: (Thread, Throwable) => Unit) =
    new Thread.UncaughtExceptionHandler {
      override def uncaughtException(t: Thread, e: Throwable) = handler(t, e)
    }
}
