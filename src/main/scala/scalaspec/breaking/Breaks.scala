package scalaspec.breaking

import scala.util.control.{BreakControl, ControlThrowable}

private class BreakControl extends ControlThrowable

class Breaks {
  private val breakException = new BreakControl

  def breakable(op: => Unit) {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  }

  sealed trait TryBlock[T] {
    def catchBreak(onBreak: =>T): T
  }

  def tryBreakable[T](op: => T) = new TryBlock[T] {
    override def catchBreak(onBreak: => T): T = try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
        onBreak
    }
  }

  def break = throw breakException
}

object Breaks extends Breaks

