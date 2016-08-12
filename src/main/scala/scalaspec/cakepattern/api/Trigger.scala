package scalaspec.cakepattern.api

trait Trigger {
  val sensor: Sensor
  val switcher: Switcher

  def start {
    if (sensor.isPresent) switcher.on
    else switcher.off
  }
}
