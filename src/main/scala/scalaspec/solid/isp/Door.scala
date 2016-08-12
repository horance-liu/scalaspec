package scalaspec.solid.isp

trait Door {
  def lock: Unit
  def unlock: Unit
  def isOpen: Boolean
}
