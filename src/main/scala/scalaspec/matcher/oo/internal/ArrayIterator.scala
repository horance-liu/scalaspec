package scalaspec.matcher.oo.internal

class ArrayIterator(array: Array[Any]) extends Iterator[Any] {
  private var currentIndex: Int = 0

  override def hasNext: Boolean = currentIndex < array.length

  override def next: Any = array({ currentIndex += 1; currentIndex - 1})
}