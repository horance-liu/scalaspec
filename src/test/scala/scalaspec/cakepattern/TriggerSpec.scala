package scalaspec.cakepattern

import org.scalatest.FunSpec
import org.scalatest.Matchers._

import scalaspec.cakepattern.api.{Sensor, Switcher, Trigger}
import scalaspec.cakepattern.warmer.{Heater, PotSensor}

class TriggerSpec extends FunSpec {
  describe("Trigger") {
    it("can composite all trait into single object") {
      object Warmer extends Heater with PotSensor with Trigger {
        val switcher = this
        val sensor = this
      }

      Warmer.start
    }
  }
}