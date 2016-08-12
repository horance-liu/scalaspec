package scalaspec.dci.role

class InsufficientFunds (msg: String = null, cause: Throwable = null)
  extends Exception (msg, cause) {}

