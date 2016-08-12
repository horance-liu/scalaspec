package scalaspec.cakepattern.warmer

import scalaspec.cakepattern.api.Sensor

trait PotSensor extends Sensor {
  def isPresent = true
}
