package scalaspec.solid.isp

trait TimerListener {
  def timeout(timerId: TimerId)
}
