package scalaspec.solid.isp

class TimedDoor extends Door with TimerListener {
  override def lock: Unit = ???
  override def unlock: Unit = ???
  override def isOpen: Boolean = ???
  override def timeout(timerId: TimerId): Unit = ???
}
