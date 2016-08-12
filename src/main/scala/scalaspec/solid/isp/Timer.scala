package scalaspec.solid.isp

trait Timer {
  def register(timerId: TimerId, listener: TimerListener)
}
