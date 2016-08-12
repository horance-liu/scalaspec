package scalaspec.cakepattern.warmer

import scalaspec.cakepattern.api.Switcher

trait Heater extends Switcher {
  def on  = println("on")
  def off = println("off")
}
