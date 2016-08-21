package scalaspec.matcher.oo.internal

import java.lang.reflect.Array
import java.util.Iterator

class ArrayIterator(array: Any) extends Iterator[Any] {
  private var currentIndex: Int = 0

  if (!array.getClass.isArray)
    throw new IllegalArgumentException("not an array")

  def hasNext: Boolean = currentIndex < Array.getLength(array)

  def next: Any = Array.get(array, {
    currentIndex += 1; currentIndex - 1
  })

  override def remove() {
    throw new UnsupportedOperationException("cannot remove items from an array")
  }
}

