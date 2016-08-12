package scalaspec.collection.mutable

class ArrayBuffer[A](initialSize: Int) {
  private var array = new Array[AnyRef](math.max(initialSize, 1))
  private var size = 0

  def this() = this(16)

  def map[B](f: A => B): ArrayBuffer[B] = {
    val buf = new ArrayBuffer[B]
    for (x <- this)
      buf += f(x)
    buf
  }

  def filter(f: A => Boolean): ArrayBuffer[A] = {
    val buf = new ArrayBuffer[A]
    for (x <- this)
      if (f(x)) buf += x
    buf
  }

  def foreach[U](f: A => U) {
    var i = 0
    while (i < size) {
      f(array(i).asInstanceOf[A])
      i += 1
    }
  }

  def apply(i: Int): A = array(i).asInstanceOf[A]

  private def prefixLength(p: A => Boolean, expectTrue: Boolean): Int = {
    var i = 0
    while (i < size && p(apply(i)) == expectTrue) i += 1
    i
  }

  def forall(p: A => Boolean): Boolean =
    prefixLength(p, expectTrue = true) == size

  def exists(p: A => Boolean): Boolean =
    prefixLength(p, expectTrue = false) != size

  def +=(elem: A): this.type = {
    if (atCapacity)
      grow()
    addElement(elem)
  }

  private def atCapacity: Boolean = size + 1 > array.length

  private def grow() {
    val newArray = new Array[AnyRef](newSize(size + 1))
    System.arraycopy(array, 0, newArray, 0, size)
    array = newArray
  }

  private def newSize(n: Int): Int = {
    var newSize: Long = array.length
    while (n > newSize)
      newSize *= 2
    math.min(newSize, Int.MaxValue).toInt
  }

  private def addElement(elem: A): this.type = {
    array(size) = elem.asInstanceOf[AnyRef]
    size += 1
    this
  }
}

object ArrayBuffer {
  def apply[A](elems: A*): ArrayBuffer[A] = {
    val buf = new ArrayBuffer[A]
    for (elem <- elems)
      buf += elem
    buf
  }
}
