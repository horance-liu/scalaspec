package scalaspec.logger

import org.slf4j.{Logger, LoggerFactory}

trait Logging {
  val loggerName = this.getClass.getName
  lazy val logger: Logger = LoggerFactory.getLogger(loggerName)

  def trace(msg: => String) {
    if (logger.isTraceEnabled())
      logger.trace(msg)
  }

  def trace(msg: => String, e: => Throwable) {
    if (logger.isTraceEnabled())
      logger.trace(msg, e)
  }

  def swallowTrace(action: => Unit) {
    Logging.swallow(logger.trace, action)
  }

  def debug(msg: => String) {
    if (logger.isDebugEnabled())
      logger.debug(msg)
  }

  def debug(msg: => String, e: => Throwable) {
    if (logger.isDebugEnabled())
      logger.debug(msg,e)
  }

  def swallowDebug(action: => Unit) {
    Logging.swallow(logger.debug, action)
  }

  def info(msg: => String) {
    if (logger.isInfoEnabled())
      logger.info(msg)
  }

  def info(msg: => String,e: => Throwable) {
    if (logger.isInfoEnabled())
      logger.info(msg,e)
  }

  def swallowInfo(action: => Unit) {
    Logging.swallow(logger.info, action)
  }

  def warn(msg: => String) {
    logger.warn(msg)
  }

  def warn(msg: => String, e: => Throwable) {
    logger.warn(msg,e)
  }

  def swallowWarn(action: => Unit) {
    Logging.swallow(logger.warn, action)
  }

  def error(msg: => String) {
    logger.error(msg)
  }

  def error(msg: => String, e: => Throwable) {
    logger.error(msg, e)
  }

  def swallowError(action: => Unit) {
    Logging.swallow(logger.error, action)
  }
}

object Logging {
  def swallow(logger: (String, Throwable) => Unit, action: => Unit) {
    try {
      action
    } catch {
      case e: Throwable => logger(e.getMessage, e)
    }
  }
}
