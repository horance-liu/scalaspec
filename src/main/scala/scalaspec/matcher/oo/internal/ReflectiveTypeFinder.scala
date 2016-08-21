package scalaspec.matcher.oo.internal

import java.lang.reflect.Method

class ReflectiveTypeFinder(methodName: String, numberOfParameters: Int, typedParameter: Int) {
  def findExpectedType(fromClass: Class[_]): Class[_] =
    ClassIterator(fromClass)
      .flatMap(_.getDeclaredMethods)
      .find(canObtainExpectedTypeFrom(_))
      .map(expectedTypeFrom(_))
      .getOrElse(fail)

  private def fail =
    throw new Error("Cannot determine correct type for " + methodName + "() method.")

  /**
    * @param method The method to examine.
    * @return true if this method references the relevant type
    */
  private def canObtainExpectedTypeFrom(method: Method): Boolean =
    method.getName == methodName &&
    method.getParameterTypes.length == numberOfParameters &&
    !method.isSynthetic

  /**
    * @param method The method from which to extract
    * @return The type we're looking for
    */
  private def expectedTypeFrom(method: Method): Class[_] =
    method.getParameterTypes()(typedParameter)
}

private[internal]
case class ClassIterator(fromClass: Class[_]) extends Iterator[Class[_]] {
  private var current = fromClass

  override def hasNext: Boolean =
    current ne classOf[Any]

  override def next(): Class[_] = {
    current = current.getSuperclass
    current
  }
}